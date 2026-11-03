#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
央视频直播 - 单源多模式版 (JCE 25312 / bkliveinfo)，TVBox / FongMi / VodPlus 爬虫版

用法一：当直播源（live 里填）
{
"api": "./yangshipin.py",
"ext": {},
"name": "央视频"
}

用法二：当点播站（site 里填）
{
"key": "yangshipin_vod", "name": "央视频",
"type": 3,
"api": "./yangshipin.py", "ext": {}
}

ext 可选：
  epg_xml         直播源 M3U 的节目单地址，默认 https://epg.112114.xyz/pp.xml，留空则不写
  epg_ids         覆盖 tvg-id 映射，如 {"CCTV-1 综合": "CCTV1"}
  logo_mode       direct(默认) 台标走 CDN 直连；proxy 则全部走本地代理
  direct          true = 全部请求走 urllib，不借容器的 self.fetch()，排错时用
  wait            打开频道时等待首帧就绪的秒数，默认 12
  cast_wait       打开投屏线路时等待握手的秒数，默认 20（比源1慢，要给足时间）
  holdback        播放列表尾部保留几片不播，默认 1（防刚抓到的切片没落地）
  ts_cache_mb     切片缓存上限(MB)，默认 200（对齐 ysp-live v9.0 的 TsSegmentCache(max_mb=200)，
                  4K/8K 高码段下可覆盖 2-3 分钟窗口，开启预取抗网络抖动），0=关闭
  cast_entries    true 时直播源 M3U 也导出投屏条目（默认 false，只出源1）
  live_mode       proxy(默认) 走代理滚动缓冲；redirect 直接 302 到官方 m3u8，
                  省掉握手等待（投屏源必须带签名头，会自动退回 proxy）
  cast_timeout / cast_insecure / cast_cache_ttl / cast_interval / cast_jitter
  cast_session_ttl / cast_heartbeat / cast_links / cast_persist / cast_device_json

排错：浏览器打开 代理地址?type=diag
      加 &slug=cctv1 会当场拉一次流（&mode=redirect 则测直连取址）
代理附加类型（点播/外部流可复用）：
      ?type=m3u8&url=<上游m3u8>[&referer=...]  拉上游 m3u8（主表自动展开子流），
        把段/密钥 URI 全部改写为本代理地址，避免播放器以本地代理为基准解析相对路径 404
      ?type=ts&url=<段/key绝对地址>[&referer=...]  二进制回传 .ts/.key（0x47 识别 video/mp2t）

多模式兼容说明：
- 出网：普通请求统一走 _http()，GET 优先借容器 self.fetch()，失败或 POST 回落 urllib，
  SSL 校验失败自动降级重试一次；投屏请求走自带客户端（保签名头 + cookie）
- 源1（默认）：JCE 25312 / bkliveinfo 双通道互备，bk 取不到回落 JCE，
  JCE 撞到死链 CDN(liverecord.video.cloud.cctv.com) 自动切 bk
- 源2（投屏）：模拟电视接收端做设备注册 + 云设备注册 + 单设备并发池(v9.4)，
  换高码流；启动不建会话，进「央视高码」分类或点开投屏线路时才触发
- 播放：localProxy 取代 ThreadingHTTPServer，不占端口；live_mode 可在
  代理滚动缓冲(proxy) 与 官方直连 302(redirect) 之间切换
- 入口：live(直播 M3U) / site(点播分类+详情) / diag 三种模式共用同一份频道表
- 依赖：纯标准库，内置纯 Python AES-256-GCM 与 RSA-OAEP，不需要装加解密包
"""

import base64, gzip, hashlib, hmac as _hmac, http.cookiejar, json, os, random, re, socket, struct, threading, time
import ssl
import urllib.error, urllib.parse, urllib.request, uuid
from collections import deque

try:
 from base.spider import Spider as SpiderBase
except ImportError:
 class SpiderBase(object):
  def getCache(self, key): return None
  def setCache(self, key, value): return "fail"
  def delCache(self, key): return "fail"


# ================================================================ 日志 (已禁用文件写入)
# 只 print 到 stdout, 不写文件. TVBox 一般看不到 stdout, 等于静默.

def _log(msg):
 # 注意：这里不能直接用 print(flush=True)——daemon 刷新线程在解释器 shutdown
 # 阶段持有 stdout 缓冲锁时，主线程退出会触发 native crash
 # (_enter_buffered_busy / segfault，本地 python3 实测复现)。
 # 改用 os.write(2, ...) 直写 stderr：原子写、不经过 BufferedWriter 缓冲锁。
 try:
  os.write(2, ('[ysp] %s\n' % msg).encode('utf-8', 'replace'))
 except Exception:
  pass


def format_remarks(brand="央视频", meta=""):
 clean_meta = str(meta or "").strip()
 clean_meta = re.sub(r"[\r\n\t]+", " ", clean_meta).strip()
 return ("%s | %s" % (brand, clean_meta)) if clean_meta else brand


UA = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0 Safari/537.36'
WINDOW = 300
REFRESH_INTERVAL = 2
IDLE_TIMEOUT = 300
MAX_SEGS = 400
# 播放窗口对标 ysp-live v9.0 stale-while-refresh 思路：窗口≈80s(16段×5s)，
# 覆盖一次完整刷新停摆(jce死→切bk→bk 403 实测 12s+，含失败退避)，停摆期间播放器吃已有窗口不卡
PLAYLIST_WINDOW = 16
HTTP_TIMEOUT = 12
LINK_IDLE_TIMEOUT = 15.0
BK_URL_TTL = 300
ZAP_DEBOUNCE = 10.0

# 壳端(FongMi 5.1.6 / VodPlus 1.2.1)的 Proxy.createResponse 直接拿 status 做
# NanoHTTPD Status.lookup()，lookup 不认识的码(如 502/599)返回 null，
# Response.send 抛 "Status can't be null" 导致整个 app 闪退。
# 这里维护设备端 Status 枚举的合法码表，出站回包统一收敛。
_SAFE_STATUS = {101, 200, 201, 202, 204, 206, 207,
 301, 302, 303, 304, 307,
 400, 401, 403, 404, 405, 406, 408, 409, 410, 411, 412, 413,
 415, 416, 417, 429, 500, 501, 503, 505}


def _proxy_safe(resp):
 """把 localProxy 回包收敛成壳端一定认识的 [status, mime, body, headers?]。"""
 if not isinstance(resp, (list, tuple)) or not resp:
  return [500, "text/plain; charset=utf-8", "央视频: 非法代理返回"]
 try:
  status = int(resp[0])
 except (TypeError, ValueError):
  status = 500
 if status not in _SAFE_STATUS:
  status = 500
 mime = resp[1] if len(resp) > 1 and resp[1] else "text/plain; charset=utf-8"
 body = resp[2] if len(resp) > 2 and resp[2] is not None else ""
 out = [status, mime, body]
 if len(resp) > 3 and resp[3]:
  out.append(resp[3])
 return out


# ================================================================ JCE 协议

class W:
 def __init__(self): self.b = bytearray()
 def head(self, typ, tag):
  if tag < 15: self.b.append(((tag & 0xf) << 4) | (typ & 0xf))
  else: self.b.append(0xf0 | (typ & 0xf)); self.b.append(tag)
 def byte(self, v, tag):
  v = int(v)
  if v == 0: self.head(12, tag)
  else: self.head(0, tag); self.b += struct.pack('>b', v)
 def short(self, v, tag):
  v = int(v)
  if -128 <= v <= 127: self.byte(v, tag)
  else: self.head(1, tag); self.b += struct.pack('>h', v)
 def int(self, v, tag):
  v = int(v)
  if -32768 <= v <= 32767: self.short(v, tag)
  else: self.head(2, tag); self.b += struct.pack('>i', v)
 def long(self, v, tag):
  v = int(v)
  if -2147483648 <= v <= 2147483647: self.int(v, tag)
  else: self.head(3, tag); self.b += struct.pack('>q', v)
 def float(self, v, tag):
  self.head(4, tag); self.b += struct.pack('>f', float(v))
 def double(self, v, tag):
  self.head(5, tag); self.b += struct.pack('>d', float(v))
 def string(self, s, tag):
  if s is None: return
  data = str(s).encode('utf-8')
  if len(data) > 255: self.head(7, tag); self.b += struct.pack('>i', len(data)); self.b += data
  else: self.head(6, tag); self.b.append(len(data)); self.b += data
 def bytes(self, data, tag):
  data = bytes(data); self.head(13, tag); self.head(0, 0); self.int(len(data), 0); self.b += data
 def struct(self, fn, tag): self.head(10, tag); fn(self); self.head(11, 0)
 def list(self, items, tag, wf=None): self.head(9, tag); self.int(len(items), 0)
 def out(self): return bytes(self.b)


class R:
 def __init__(self, data): self.d = memoryview(data); self.p = 0
 def rem(self): return len(self.d) - self.p
 def get(self, n):
  if self.p + n > len(self.d): raise EOFError
  b = self.d[self.p:self.p + n].tobytes(); self.p += n; return b
 def u8(self): return self.get(1)[0]
 def head(self):
  b = self.u8(); typ = b & 0xf; tag = (b & 0xf0) >> 4
  if tag == 15: tag = self.u8()
  return typ, tag
 def value(self, typ):
  if typ == 0: return struct.unpack('>b', self.get(1))[0]
  if typ == 1: return struct.unpack('>h', self.get(2))[0]
  if typ == 2: return struct.unpack('>i', self.get(4))[0]
  if typ == 3: return struct.unpack('>q', self.get(8))[0]
  if typ == 4: return struct.unpack('>f', self.get(4))[0]
  if typ == 5: return struct.unpack('>d', self.get(8))[0]
  if typ == 6: n = self.u8(); return self.get(n).decode('utf-8', 'replace')
  if typ == 7: n = struct.unpack('>i', self.get(4))[0]; return self.get(n).decode('utf-8', 'replace')
  if typ == 8: n = self._int(); return {self._fv(): self._fv() for _ in range(n)}
  if typ == 9: n = self._int(); return [self._fv() for _ in range(n)]
  if typ == 10: return self.struct()
  if typ == 11: return None
  if typ == 12: return 0
  if typ == 13: t, _ = self.head(); n = self._int(); return self.get(n)
  raise ValueError('type %d' % typ)
 def _fv(self): t, _ = self.head(); return self.value(t)
 def _int(self): t, _ = self.head(); return int(self.value(t))
 def struct(self):
  m = {}
  while self.rem() > 0:
   t, tag = self.head()
   if t == 11: break
   m[tag] = self.value(t)
  return m


VER_NAME, VER_CODE = '3.2.7.26212', '302070'
APP_ID, QMF_APP_ID, QMF_PLATFORM, BIZ_ID = '1200013', 10012, 1, 0
CHAN_ID = '10070'
GUID = ''.join(random.choice('0123456789abcdef') for _ in range(32))


def _qua(w):
 w.string(VER_NAME, 0); w.string(VER_CODE, 1)
 w.int(1080, 2); w.int(2400, 3); w.int(3, 4); w.string('12', 5)
 w.int(1, 6); w.int(1, 7); w.int(420, 8); w.string(CHAN_ID, 9)
 for i in range(10, 15): w.string('', i)
 w.struct(lambda ww: (ww.int(0, 0), ww.byte(0, 1), ww.string('', 2)), 15)
 w.string('', 16); w.string('', 17); w.string('', 18)
 w.struct(lambda ww: (ww.int(0, 0), ww.float(0, 1), ww.float(0, 2), ww.double(0, 3)), 19)
 w.string(GUID[:16], 20); w.string('Pixel 6', 21)
 w.int(1, 22)
 for i in range(23, 27): w.int(0, i)
 w.string('', 27); w.string('', 28); w.string(GUID, 29)


def _head(w, cmd, reqid):
 w.int(reqid, 0); w.int(cmd, 1)
 w.struct(lambda ww: _qua(ww), 2)
 w.string(APP_ID, 3); w.string(GUID, 4)
 w.list([], 5); w.struct(lambda ww: None, 6)
 w.list([], 7)
 w.int(0, 8); w.int(0, 9); w.int(0, 10)


def _wrap(cmd, body, reqid):
 w = W()
 w.struct(lambda ww: _head(ww, cmd, reqid), 0)
 w.bytes(body, 1)
 reqcmd = w.out()
 inner = bytearray([38]) + struct.pack('>i', len(reqcmd) + 17) + bytes([1]) + b'\x00' * 10 + reqcmd + bytes([40])
 comp = gzip.compress(bytes(inner))
 out = bytearray([19]) + struct.pack('>i', 0) + struct.pack('>H', 2) + struct.pack('>H', 65281)
 out += struct.pack('>H', cmd) + struct.pack('>H', 0) + struct.pack('>q', reqid)
 out += struct.pack('>i', 531) + struct.pack('>i', QMF_APP_ID) + struct.pack('>q', BIZ_ID)
 g = GUID.encode()[:32]; out += g + b'\x00' * (32 - len(g))
 out += struct.pack('>b', QMF_PLATFORM) + struct.pack('>i', int(VER_CODE)) + b'\x00' * 6
 out += bytes([0]) + struct.pack('>H', 0) + struct.pack('>H', 0)
 out += struct.pack('>i', len(inner)) + comp + bytes([3])
 struct.pack_into('>i', out, 1, len(out))
 return bytes(out)


def _unwrap(data):
 if data[:1] != b'\x13' or len(data) < 90: return None
 flags = struct.unpack('>i', data[21:25])[0]
 payload = data[89:-1]
 if flags & 2: payload = gzip.decompress(payload)
 if payload[:1] != b'&' or payload[-1:] != b'(': return None
 rc = R(payload[16:-1]).struct()
 return rc.get(1) or b''


class DeadHostError(RuntimeError):
 pass


def jce_timeshift_url(pid, sid, start, end, stream='fhd'):
 w = W()
 w.string(pid, 0); w.string(sid, 1); w.long(start, 2); w.long(end, 3); w.string(stream, 4)
 body = w.out()
 CMD = 25312
 reqid = int(time.time() * 1000) & 0x7fffffff
 packet = _wrap(CMD, body, reqid)
 st, raw, _ = _http('POST', 'https://jacc.ysp.cctv.cn',
  {'Content-Type': 'application/octet-stream'}, packet, HTTP_TIMEOUT)
 if st < 200 or st >= 300:
  raise RuntimeError('jce HTTP %d' % st)
 resp_body = _unwrap(raw)
 if not resp_body: raise RuntimeError('bad response')
 m = R(resp_body).struct()
 err = m.get(0, 0)
 if err != 0: raise RuntimeError(m.get(1, 'errCode=%s' % err))
 url = m.get(2, '')
 if not url: raise RuntimeError('empty m3u8')
 if 'liverecord.video.cloud.cctv.com' in url:
  raise DeadHostError('dead cdn host')
 return url


# ================================================================ cKey + bkliveinfo

_CK_PLATFORM = 4330403
_CK_APPVER = 'V8.22.1035.3031'
_CK_TEA = bytes.fromhex('59b2f7cf725ef43c34fdd7c123411ed3')
_CK_GTEA = bytes.fromhex('110DBEC10C23E7D2E56A1CAD6914EF1B')
_CK_XOR = bytes([0x84, 0x2e, 0xed, 0x08, 0xf0, 0x66, 0xe6, 0xea, 0x48, 0xb4, 0xca, 0xa9, 0x91, 0xed, 0x6f, 0xf3])
_CK_GXOR = bytes([0xb3, 0xc9, 0x53, 0xa0, 0x69, 0x13, 0xad, 0x4d])


def _u32(v): return v & 0xFFFFFFFF


def _tea_blk(blk, key):
 y, z = struct.unpack('>2I', blk)
 k = struct.unpack('>4I', key)
 s = 0
 for _ in range(16):
  s = _u32(s + 0x9e3779b9)
  y = _u32(y + _u32(_u32(_u32(z << 4) + k[0]) ^ _u32(z + s) ^ _u32((z >> 5) + k[1])))
  z = _u32(z + _u32(_u32(_u32(y << 4) + k[2]) ^ _u32(y + s) ^ _u32((y >> 5) + k[3])))
 return struct.pack('>2I', y, z)


def _cksum(buf):
 v = 0
 for b in buf: v = (0x83 * v + b) & 0x7fffffff
 return v


def _tea_pkt(data, key):
 pad = (8 - ((len(data) + 10) % 8)) % 8
 plain = bytes([(os.urandom(1)[0] & 0xf8) | pad]) + os.urandom(pad) + os.urandom(2) + data + bytes(7)
 out, pp, pc = b'', bytes(8), bytes(8)
 for off in range(0, len(plain), 8):
  mixed = bytes(a ^ b for a, b in zip(plain[off:off + 8], pc))
  enc = _tea_blk(mixed, key)
  cipher = bytes(a ^ b for a, b in zip(enc, pp))
  out += cipher
  pp, pc = mixed, cipher
 return out


def _lp(s):
 d = s.encode() if isinstance(s, str) else s
 return struct.pack('>H', len(d)) + d


def _ck_guard(ts, guid):
 def tail(v):
  t = str(v); return t[-5:] if len(t) >= 5 else ''
 body = struct.pack('>I', ts) + _lp(tail(guid)) + _lp(tail('null')) + _lp(tail('null')) + _lp('-1')
 plain = _lp(body)
 enc = _tea_pkt(plain, _CK_GTEA) + struct.pack('>I', _cksum(plain))
 enc = bytes(a ^ _CK_GXOR[i & 7] for i, a in enumerate(enc))
 return enc.hex().upper()


def _ckey(channel_id):
 ts = int(time.time())
 guid = os.urandom(16).hex()
 guard = _ck_guard(ts, guid)
 uid = os.urandom(4).hex().upper()
 body = (bytes.fromhex('0000004200000004000004d2') + struct.pack('>I', _CK_PLATFORM)
  + struct.pack('>I', 0) + struct.pack('>I', ts) + _lp('dcgh')
  + _lp('_zj1A5Gh6QYcxWjIUGos2w==') + _lp(_CK_APPVER) + _lp(str(channel_id))
  + _lp(guid) + struct.pack('>I', 1) + struct.pack('>I', 1) + _lp(uid) + _lp('nil')
  + _lp('57eab0c4-2c58-44c6-8ae9-dd2757525dc5') + _lp('nil') + _lp('v0.1.000')
  + _lp('com.cctv.yangshipin.app.iphone') + _lp(str(_CK_PLATFORM))
  + _lp('ex_json_bus') + _lp('ex_json_vs') + _lp(guard))
 pkt = bytearray(struct.pack('>H', len(body)) + body)
 pkt[18:22] = struct.pack('>I', _cksum(bytes(pkt)))
 pkt = bytes(pkt)
 enc = _tea_pkt(pkt, _CK_TEA) + struct.pack('>I', _cksum(pkt))
 enc = bytes(a ^ _CK_XOR[i & 15] for i, a in enumerate(enc))
 b64 = base64.b64encode(enc).decode().replace('+', '_').replace('/', '-').rstrip('=')
 return {'cKey': '--01' + b64, 'guid': guid, 'ts': ts,
  'flowId': '%s_%d' % (uuid.uuid4().hex.upper(), _CK_PLATFORM)}


_BK_H264 = base64.b64encode(b'H(30:1080,60:1080|30:1080,60:1080)').decode()
_BK_URL_CACHE = {}  # (sid,pid,defn) -> (urls, ts), TTL=BK_URL_TTL(v9.4 300s)


def bk_playurls(channel_id, live_pid, defn='fhd'):
 t = _ckey(channel_id)
 q = urllib.parse.urlencode({
  'atime': '120', 'livepid': live_pid, 'cnlid': channel_id,
  'appVer': _CK_APPVER, 'app_version': '300090', 'caplv': '1', 'cmd': '2',
  'defn': defn, 'device': 'iPhone', 'encryptVer': '4.2', 'getpreviewinfo': '0',
  'hevclv': '0', 'lang': 'zh-Hans_CN', 'livequeue': '0', 'logintype': '1',
  'nettype': '1', 'newnettype': '1', 'newplatform': str(_CK_PLATFORM),
  'platform': str(_CK_PLATFORM), 'sdtfrom': 'v3021', 'spacode': '23',
  'spaudio': '1', 'spdemuxer': '6', 'spdrm': '2', 'spdynamicrange': '1',
  'spflv': '1', 'spflvaudio': '1', 'sphdrfps': '60', 'sphttps': '1',
  'spvcode': _BK_H264, 'spvideo': '4', 'stream': '1', 'system': '1',
  'sysver': 'ios18.2.1', 'uhd_flag': '0', 'cKey': t['cKey'], 'guid': t['guid'],
  'fntick': str(t['ts']), 'flowid': t['flowId'], 'playbacktime': '0',
 })
 st, body, _ = _http('GET', 'https://bkliveinfo.ysp.cctv.cn/?' + q,
  {'User-Agent': 'qqlive', 'Accept': 'application/json'}, None, 6)
 if st < 200 or st >= 300:
  raise RuntimeError('bk HTTP %d' % st)
 p = json.loads(body.decode('utf-8', 'replace'))
 if int(p.get('iretcode', -1)) != 0:
  raise RuntimeError('iretcode=%s %s' % (p.get('iretcode'), p.get('errinfo', '')))
 urls = []
 if p.get('playurl'): urls.append(p['playurl'])
 bu = p.get('backurl_list') or p.get('backurlList') or p.get('backurl')
 if isinstance(bu, list):
  for it in bu: urls.append(it if isinstance(it, str) else (it.get('url') or it.get('playurl') or ''))
 elif isinstance(bu, str):
  urls += [x for x in re.split(r'[;,]', bu) if x.strip()]
 urls = [u for u in dict.fromkeys(urls) if u and '.cctv.' in u]
 if not urls: raise RuntimeError('no playurl')
 urls.sort(key=lambda u: (0 if 'bklive-' in u else 1, u))
 return urls


# ================================================================ 央视高码内核 (协议源自 ysp-live v9.0)

CAST_AK = '9f5c54c4ed0e50109b800f7e28fec205'
CAST_RSA_PUBKEY_B64 = ('MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkKeLy4ywWLSnBkwRyqYgF3HMIj05V5uu'
 'h5HjyEsZOWnu1NHu3jPQv3sr32wwQNYv5qapsNXmNgLUDHtgHZxqPQAYXltjSRc0qhcD286t62wOIH'
 'Id8zXS3s1Jy4rgU4qjQWzI9rp/1sE0pMsmwTaJa4zuJ5iz8VwF8Av5oJ1k+HxY+/HLnjNlW1hmWLpu'
 'DYmkZYuAoTHa1VGeHQh9FEKI8ZcL3GTQphShUoC+Kg3P1hGUVTtCYapmzPS5lkAdwebuzwvTCfGiT'
 'ErYZCnPBUSeV7BVlgjtLYIi29KvF0a8FHsJMfe/UdHcyW/RihsIYOtDQcRRpFGXyPXbVrzFJse24'
 'QIDAQAB')
CAST_CLOUD_GET = 'https://ytpcloudws.cctv.cn/cloudps/wssapi/device/v2/get'
CAST_CLOUD_REGISTER = 'https://ytpcloudws.cctv.cn/cloudps/wssapi/device/v2/register'
CAST_APP_START = 'https://ytpaddr.cctv.cn/gsnw/api/app/start/v1/01'
CAST_DRM_CONFIG = 'https://ytpaddr.cctv.cn/gsnw/drm/config/obtain/v1'
CAST_VERSION_CONFIG = 'https://ytpaddr.cctv.cn/gsnw/version/config/obtain/v1'
CAST_DICTIONARY = 'https://ytpaddr.cctv.cn/gsnw/player/dictionary/obtain/v1'
CAST_INDEX = 'https://ytpaddr.cctv.cn/gsnw/api/index/v1/01'
CAST_REPORT_SINGLE = 'https://ytpdata.cctv.cn/das/app/data/message/single'
CAST_COLLECT_REPORT = 'https://collect.cctv.cn/cctvmobileinf/rest/cctv/receive/new/app'
CAST_LIVE_01 = 'https://ytpaddr.cctv.cn/gsnw/api/live/v1/01'
CAST_LIVE_02 = 'https://ytpaddr.cctv.cn/gsnw/api/live/v1/02'
CAST_VDN = 'https://ytpvdn.cctv.cn/cctvmobileinf/rest/cctv/videoliveUrl/getstream'
CAST_LIVE_USER_ID = 'BAEBFF2B-C516-4F34-ABC0-A824A6461CBD'
CAST_DEVICE_NAME = '央视频电视投屏助手'
CAST_VDN_APP_NAME = '央视频电视投屏助手'
CAST_REPORT_APP_KEY = '1178c84d-4818-44ff-b415-02106e87e144'
CAST_SDK_VERSION = '1.0.0'
CAST_PAGE_NAME = 'com.cctv.tv.mvp.ui.activity.MainActivity'
CAST_ACCEPT_LANGUAGE = 'zh-CN,zh;q=0.8'
CAST_UA = 'cctv_app_tv'
CAST_APP_CHANNEL = 'dangbei'
CAST_VERSION = '1.4.1'
CAST_RESULT_OK = 0
CAST_RESULT_NEEDS_REGISTER = 601
CAST_RESULT_GET_INVALID = 2
CAST_RESULT_REGISTERED_ELSEWHERE = 694
CAST_RESULT_RETRY_LATER = 695

# ==== 纯 Python AES-256 / GCM / RSA-OAEP-SHA256（不依赖 pycryptodome、cryptography）====

_SBOX = (
 99,
 124,
 119,
 123,
 242,
 107,
 111,
 197,
 48,
 1,
 103,
 43,
 254,
 215,
 171,
 118,
 202,
 130,
 201,
 125,
 250,
 89,
 71,
 240,
 173,
 212,
 162,
 175,
 156,
 164,
 114,
 192,
 183,
 253,
 147,
 38,
 54,
 63,
 247,
 204,
 52,
 165,
 229,
 241,
 113,
 216,
 49,
 21,
 4,
 199,
 35,
 195,
 24,
 150,
 5,
 154,
 7,
 18,
 128,
 226,
 235,
 39,
 178,
 117,
 9,
 131,
 44,
 26,
 27,
 110,
 90,
 160,
 82,
 59,
 214,
 179,
 41,
 227,
 47,
 132,
 83,
 209,
 0,
 237,
 32,
 252,
 177,
 91,
 106,
 203,
 190,
 57,
 74,
 76,
 88,
 207,
 208,
 239,
 170,
 251,
 67,
 77,
 51,
 133,
 69,
 249,
 2,
 127,
 80,
 60,
 159,
 168,
 81,
 163,
 64,
 143,
 146,
 157,
 56,
 245,
 188,
 182,
 218,
 33,
 16,
 255,
 243,
 210,
 205,
 12,
 19,
 236,
 95,
 151,
 68,
 23,
 196,
 167,
 126,
 61,
 100,
 93,
 25,
 115,
 96,
 129,
 79,
 220,
 34,
 42,
 144,
 136,
 70,
 238,
 184,
 20,
 222,
 94,
 11,
 219,
 224,
 50,
 58,
 10,
 73,
 6,
 36,
 92,
 194,
 211,
 172,
 98,
 145,
 149,
 228,
 121,
 231,
 200,
 55,
 109,
 141,
 213,
 78,
 169,
 108,
 86,
 244,
 234,
 101,
 122,
 174,
 8,
 186,
 120,
 37,
 46,
 28,
 166,
 180,
 198,
 232,
 221,
 116,
 31,
 75,
 189,
 139,
 138,
 112,
 62,
 181,
 102,
 72,
 3,
 246,
 14,
 97,
 53,
 87,
 185,
 134,
 193,
 29,
 158,
 225,
 248,
 152,
 17,
 105,
 217,
 142,
 148,
 155,
 30,
 135,
 233,
 206,
 85,
 40,
 223,
 140,
 161,
 137,
 13,
 191,
 230,
 66,
 104,
 65,
 153,
 45,
 15,
 176,
 84,
 187,
 22
)
_INV_SBOX = [0] * 256 
for _i, _v in enumerate(_SBOX):
 _INV_SBOX[_v] = _i 
_INV_SBOX = tuple(_INV_SBOX)
_RCON = (1, 2, 4, 8, 16, 32, 64, 128, 27, 54)
def _xtime(a: int) -> int:
 return (a << 1 ^ 283) & 255 if a & 128 else a << 1 & 255 
def _aes256_key_schedule(key: bytes):
 assert len(key) == 32 
 w = [int.from_bytes(key[i:i + 4], 'big') for i in range(0, 32, 4)]
 for i in range(8, 60):
  temp = w[i - 1]
  if i % 8 == 0:
   temp = _SBOX[temp >> 16 & 255] << 24 | _SBOX[temp >> 8 & 255] << 16 | _SBOX[temp & 255] << 8 | _SBOX[
    temp >> 24 & 255
   ]
   temp ^= _RCON[i // 8 - 1] << 24 
  elif i % 8 == 4:
   temp = _SBOX[temp >> 24 & 255] << 24 | _SBOX[temp >> 16 & 255] << 16 | _SBOX[temp >> 8 & 255] << 8 | _SBOX[
    temp & 255
   ]
  w.append(w[i - 8] ^ temp)
 return [b''.join((word.to_bytes(4, 'big') for word in w[i:i + 4])) for i in range(0, 60, 4)]
def _add_round_key(state, rk: bytes):
 for i in range(16):
  state[i] ^= rk[i]
def _sub_bytes(state):
 for i in range(16):
  state[i] = _SBOX[state[i]]
def _inv_sub_bytes(state):
 for i in range(16):
  state[i] = _INV_SBOX[state[i]]
def _shift_rows(s):
 s[1], s[5], s[9], s[13] = (s[5], s[9], s[13], s[1])
 s[2], s[6], s[10], s[14] = (s[10], s[14], s[2], s[6])
 s[3], s[7], s[11], s[15] = (s[15], s[3], s[7], s[11])
def _inv_shift_rows(s):
 s[1], s[5], s[9], s[13] = (s[13], s[1], s[5], s[9])
 s[2], s[6], s[10], s[14] = (s[10], s[14], s[2], s[6])
 s[3], s[7], s[11], s[15] = (s[7], s[11], s[15], s[3])
def _mix_columns(s):
 for c in range(4):
  a0, a1, a2, a3 = (s[4 * c], s[4 * c + 1], s[4 * c + 2], s[4 * c + 3])
  s[4 * c] = _xtime(a0) ^ (_xtime(a1) ^ a1) ^ a2 ^ a3 
  s[4 * c + 1] = a0 ^ _xtime(a1) ^ (_xtime(a2) ^ a2) ^ a3 
  s[4 * c + 2] = a0 ^ a1 ^ _xtime(a2) ^ (_xtime(a3) ^ a3)
  s[4 * c + 3] = _xtime(a0) ^ a0 ^ a1 ^ a2 ^ _xtime(a3)
def _mul(a: int, b: int) -> int:
 p = 0 
 for _ in range(8):
  if b & 1:
   p ^= a 
  hi = a & 128 
  a = a << 1 & 255 
  if hi:
   a ^= 27 
  b >>= 1 
 return p 
def _inv_mix_columns(s):
 for c in range(4):
  a0, a1, a2, a3 = (s[4 * c], s[4 * c + 1], s[4 * c + 2], s[4 * c + 3])
  s[4 * c] = _mul(a0, 14) ^ _mul(a1, 11) ^ _mul(a2, 13) ^ _mul(a3, 9)
  s[4 * c + 1] = _mul(a0, 9) ^ _mul(a1, 14) ^ _mul(a2, 11) ^ _mul(a3, 13)
  s[4 * c + 2] = _mul(a0, 13) ^ _mul(a1, 9) ^ _mul(a2, 14) ^ _mul(a3, 11)
  s[4 * c + 3] = _mul(a0, 11) ^ _mul(a1, 13) ^ _mul(a2, 9) ^ _mul(a3, 14)
def _aes256_encrypt_block_rk(rk, block: bytes) -> bytes:
 # rk 为已展开的轮密钥；对同一 key 多次调用时省去重复 key schedule
 s = bytearray(block)
 _add_round_key(s, rk[0])
 for rnd in range(1, 14):
  _sub_bytes(s)
  _shift_rows(s)
  _mix_columns(s)
  _add_round_key(s, rk[rnd])
 _sub_bytes(s)
 _shift_rows(s)
 _add_round_key(s, rk[14])
 return bytes(s)
def aes256_encrypt_block(key: bytes, block: bytes) -> bytes:
 return _aes256_encrypt_block_rk(_aes256_key_schedule(key), block)
def aes256_decrypt_block(key: bytes, block: bytes) -> bytes:
 rk = _aes256_key_schedule(key)
 s = bytearray(block)
 _add_round_key(s, rk[14])
 for rnd in range(13, 0, -1):
  _inv_shift_rows(s)
  _inv_sub_bytes(s)
  _add_round_key(s, rk[rnd])
  _inv_mix_columns(s)
 _inv_shift_rows(s)
 _inv_sub_bytes(s)
 _add_round_key(s, rk[0])
 return bytes(s)
def _gf_mult(x: int, y: int) -> int:
 r = 299076299051606071403356588563077529600 
 z = 0 
 v = y 
 for _ in range(128):
  if x & 170141183460469231731687303715884105728:
   z ^= v 
  if v & 1:
   v = v >> 1 ^ r 
  else:
   v >>= 1 
  x = x << 1 & 340282366920938463463374607431768211455 
 return z 
def _ghash(h: int, aad: bytes, ct: bytes) -> int:
 x = 0 
 def _blocks(data: bytes):
  for i in range(0, len(data), 16):
   blk = data[i:i + 16]
   if len(blk) < 16:
    blk = blk + b'\x00' * (16 - len(blk))
   yield int.from_bytes(blk, 'big')
 for b in _blocks(aad):
  x = _gf_mult(x ^ b, h)
 for b in _blocks(ct):
  x = _gf_mult(x ^ b, h)
 lens = len(aad) * 8 << 64 | len(ct) * 8 
 x = _gf_mult(x ^ lens, h)
 return x 
def _inc32(block: bytes) -> bytes:
 ctr = int.from_bytes(block[12:], 'big')
 return block[:12] + (ctr + 1 & 4294967295).to_bytes(4, 'big')
def _gctr_rk(rk, icb: bytes, data: bytes) -> bytes:
 out = bytearray()
 cb = icb 
 for i in range(0, len(data), 16):
  ks = _aes256_encrypt_block_rk(rk, cb)
  chunk = data[i:i + 16]
  out += bytes((a ^ b for a, b in zip(chunk, ks)))
  cb = _inc32(cb)
 return bytes(out)
def _gctr(key: bytes, icb: bytes, data: bytes) -> bytes:
 return _gctr_rk(_aes256_key_schedule(key), icb, data)
def aes_gcm_encrypt(key: bytes, nonce: bytes, plaintext: bytes, aad: bytes = b'') -> bytes:
 assert len(key) == 32 and len(nonce) == 12 
 rk = _aes256_key_schedule(key)
 h = int.from_bytes(_aes256_encrypt_block_rk(rk, b'\x00' * 16), 'big')
 j0 = nonce + b'\x00\x00\x00\x01'
 ct = _gctr_rk(rk, _inc32(j0), plaintext)
 s = _ghash(h, aad, ct).to_bytes(16, 'big')
 tag = bytes((a ^ b for a, b in zip(_aes256_encrypt_block_rk(rk, j0), s)))
 return ct + tag 
def aes_gcm_decrypt(key: bytes, nonce: bytes, ct_and_tag: bytes, aad: bytes = b'') -> bytes:
 if len(ct_and_tag) < 16:
  raise ValueError('AES-GCM payload too short')
 ct, tag = (ct_and_tag[:-16], ct_and_tag[-16:])
 rk = _aes256_key_schedule(key)
 h = int.from_bytes(_aes256_encrypt_block_rk(rk, b'\x00' * 16), 'big')
 j0 = nonce + b'\x00\x00\x00\x01'
 s = _ghash(h, aad, ct).to_bytes(16, 'big')
 expect = bytes((a ^ b for a, b in zip(_aes256_encrypt_block_rk(rk, j0), s)))
 if not _hmac.compare_digest(tag, expect):
  raise ValueError('AES-GCM decrypt failed')
 return _gctr_rk(rk, _inc32(j0), ct)
def _mgf1_sha256(seed: bytes, length: int) -> bytes:
 out = bytearray()
 counter = 0 
 while len(out) < length:
  out += hashlib.sha256(seed + counter.to_bytes(4, 'big')).digest()
  counter += 1 
 return bytes(out[:length])
def _oaep_encode_sha256(message: bytes, k: int, seed: bytes) -> bytes:
 hlen = 32 
 if len(message) > k - 2 * hlen - 2:
  raise ValueError('OAEP message too long')
 lhash = hashlib.sha256(b'').digest()
 ps = b'\x00' * (k - len(message) - 2 * hlen - 2)
 db = lhash + ps + b'\x01' + message 
 db_mask = _mgf1_sha256(seed, k - hlen - 1)
 masked_db = bytes((a ^ b for a, b in zip(db, db_mask)))
 seed_mask = _mgf1_sha256(masked_db, hlen)
 masked_seed = bytes((a ^ b for a, b in zip(seed, seed_mask)))
 return b'\x00' + masked_seed + masked_db 
def _der_read_tlv(der: bytes, pos: int):
 assert der[pos] == 48, 'expected SEQUENCE'
 pos += 1 
 ln, pos = _der_read_len(der, pos)
 end = pos + ln 
 items = []
 while pos < end:
  tag = der[pos]
  pos += 1 
  ln2, pos = _der_read_len(der, pos)
  items.append((tag, der[pos:pos + ln2]))
  pos += ln2 
 return items 
def _der_read_len(der: bytes, pos: int):
 first = der[pos]
 pos += 1 
 if first & 128 == 0:
  return (first, pos)
 n = first & 127 
 return (int.from_bytes(der[pos:pos + n], 'big'), pos + n)
def _der_read_int(raw: bytes) -> int:
 return int.from_bytes(raw, 'big')
def parse_spki_rsa_pubkey(der: bytes):
 outer = _der_read_tlv(der, 0)
 bitstring = outer[1][1]
 assert bitstring[0] == 0 
 inner = _der_read_tlv(bitstring[1:], 0)
 n = _der_read_int(inner[0][1])
 e = _der_read_int(inner[1][1])
 return (n, e)
def rsa_oaep_sha256_encrypt(der: bytes, message: bytes, seed: bytes) -> bytes:
 n, e = parse_spki_rsa_pubkey(der)
 k = (n.bit_length() + 7) // 8 
 em = _oaep_encode_sha256(message, k, seed)
 m = int.from_bytes(em, 'big')
 c = pow(m, e, n)
 return c.to_bytes(k, 'big')


class CastError(Exception):
 pass


def _cast_log(msg):
 _log('[cast] ' + str(msg))


def _java_hashcode(s):
 h = 0
 for ch in s:
  h = ((h * 31) + ord(ch)) & 0xFFFFFFFF
  if h >= 0x80000000:
   h -= 0x100000000
 return h


def _java_uuid_from_hashes(msb, lsb):
 def to_u64(v):
  return v + (1 << 64) if v < 0 else v
 return '%016x%016x' % (to_u64(msb), to_u64(lsb))


def _sha1_upper(s):
 return hashlib.sha1(s.encode('utf-8')).hexdigest().upper()


def _sha256_hex(s):
 return hashlib.sha256(s.encode('utf-8')).hexdigest()


def _md5_hex(s):
 return hashlib.md5(s.encode('utf-8')).hexdigest()


def _native_day0_ms(now_s):
 return 86400000 * ((int(now_s) + 28800) // 86400) - 28800000


def _compute_fingerprint(x_uid, now_ms):
 day0 = _native_day0_ms(now_ms // 1000)
 return _sha256_hex(_sha256_hex(CAST_AK + x_uid + str(now_ms) + str(day0))), now_ms, day0


def _random_hex(n):
 return ''.join(random.choice('0123456789abcdef') for _ in range(n))


def _random_mac():
 parts = [0xAA, 0xBB, 0xCC, random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)]
 return ':'.join('%02x' % b for b in parts)


def _sanitize_profile_id(v):
 return re.sub(r'[^A-Za-z0-9]+', '_', str(v or '')).strip('_')


def _resolution_from_screen_param(sp):
 m = re.match(r'^(\d+)\*(\d+)$', str(sp or ''))
 if not m:
  return '7680*4320'
 return '%s*%s' % (m.group(1), m.group(2))


def _compact_json_bytes(value, escape_slashes):
 text = json.dumps(value, separators=(',', ':'), ensure_ascii=False, sort_keys=True)
 if escape_slashes:
  text = text.replace('/', '\\/')
 return text.encode('utf-8')


def _normalize_aes_key(value):
 raw = value.encode('utf-8')
 return (raw + b'\x00' * 32)[:32]


def _aes_gcm_decrypt_b64(value, key):
 try:
  raw = base64.b64decode(value, validate=True)
 except Exception as e:
  raise CastError('base64 decode failed: %s' % e)
 if len(raw) <= 12:
  raise CastError('AES-GCM payload too short')
 try:
  plain = aes_gcm_decrypt(_normalize_aes_key(key), raw[:12], raw[12:])
 except ValueError:
  raise CastError('AES-GCM decrypt failed')
 return plain.decode('utf-8', 'replace')


def _aes_gcm_encrypt_b64(value, key):
 nonce = os.urandom(12)
 try:
  enc = aes_gcm_encrypt(_normalize_aes_key(key), nonce, value.encode('utf-8'))
 except ValueError:
  raise CastError('AES-GCM encrypt failed')
 return base64.b64encode(nonce + enc).decode('ascii')


def _rsa_encrypt_device_id(device_id):
 der = base64.b64decode(CAST_RSA_PUBKEY_B64)
 n, e = parse_spki_rsa_pubkey(der)
 k = (n.bit_length() + 7) // 8
 hlen = 32
 chunk = k - 2 * hlen - 2
 data = device_id.encode('utf-8')
 out = bytearray()
 for i in range(0, len(data), chunk):
  out += rsa_oaep_sha256_encrypt(der, data[i:i + chunk], os.urandom(hlen))
 return base64.b64encode(bytes(out)).decode('ascii')


def _form_urlencode_value(s):
 out = []
 for byte in s.encode('utf-8'):
  ch = chr(byte)
  if ch.isascii() and (ch.isalnum() or ch in '*-._'):
   out.append(ch)
  elif byte == 32:
   out.append('+')
  else:
   out.append('%%%02X' % byte)
 return ''.join(out)


def _form_encode(pairs):
 return '&'.join('%s=%s' % (_form_urlencode_value(k), _form_urlencode_value(v)) for k, v in pairs).encode('utf-8')


def _url_host(url):
 try:
  return urllib.parse.urlsplit(url).hostname or ''
 except ValueError:
  return ''


_CAST_CLIENT = None
_CAST_CLIENT_LOCK = threading.Lock()


def _cast_client():
 """投屏拉切片复用同一个客户端：带 cookie jar，超时/insecure 跟着 CAST 配置走。"""
 global _CAST_CLIENT
 with _CAST_CLIENT_LOCK:
  if _CAST_CLIENT is None:
   _CAST_CLIENT = CastHttp(CAST.timeout, CAST.insecure)
  else:
   _CAST_CLIENT.timeout = max(float(CAST.timeout), 0.1)
  return _CAST_CLIENT


def _needs_signed_headers(host):
 lower = (host or '').lower()
 return 'liveali' in lower or 'liveten' in lower


def _default_playback_headers(uid):
 return {'UID': uid, 'APPID': CAST_AK, 'Referer': 'api.cctv.cn', 'User-Agent': CAST_UA}


def _generate_app_random_str():
 return '%08x-0000-%04x-0000-00000000%04x' % (
  random.getrandbits(32), random.getrandbits(16), random.getrandbits(16))


def _compute_vdn_code(app_secret, random_str=None):
 r = random_str if random_str is not None else _generate_app_random_str()
 return _md5_hex('%s%s%s' % (CAST_AK, app_secret, r)), r


def _build_vdn_appcommon(version):
 return json.dumps({'adid': '', 'av': version, 'an': CAST_VDN_APP_NAME, 'ap': CAST_UA},
  separators=(',', ':'), ensure_ascii=False, sort_keys=True)


def _parse_result_code(value):
 if isinstance(value, dict):
  for key in ('result', 'code', 'errCode', 'errcode', 'ret'):
   if key in value:
    raw = value[key]
    if isinstance(raw, bool):
     continue
    if isinstance(raw, int):
     return raw
    if isinstance(raw, str):
     try:
      return int(raw)
     except ValueError:
      pass
  for key in ('data', 'error', 'response'):
   if key in value:
    found = _parse_result_code(value[key])
    if found is not None:
     return found
 return None


def _extract_guid(value):
 if isinstance(value, dict):
  data = value.get('data')
  if isinstance(data, dict):
   guid = data.get('guid')
   if isinstance(guid, str):
    return guid
 return ''


def _root_headers(version):
 return {'X-Uid': 'ROOT', 'X-Fingerprint': 'ROOT', 'X-Nonce': str(uuid.uuid4()),
  'X-Timestamp': str(int(time.time() * 1000)), 'X-Version': version, 'UID': 'ROOT',
  'Referer': 'api.cctv.cn', 'User-Agent': CAST_UA, 'appChannel': 'ROOT',
  'Connection': 'Keep-Alive', 'Accept-Encoding': 'gzip'}


# ---- 错误分类（v9.5 移植）：区分「会话核心 400」「控制面 400」「会话失效」「身份可恢复」 ----
# 会话核心端点真正返回 400 才意味着当前会话不可用；控制面端点（dictionary/cloud_get 等）
# 的 400 只影响该次旁路上报。另外 CastError 文本会拼接上游响应体前若干字节，
# 裸子串 ' 400' 可能被响应体内容误命中，故必须带端点上下文限定。

# 出现 400 即视为投屏会话链路本身出问题的端点
_CAST_SESSION_CORE_ENDPOINTS = ('app/start', 'live/v1/01', 'live/v1/02', 'vdn', 'heartbeat')
# 控制面端点：400 不必然意味着会话失效
_CAST_CONTROL_PLANE_ENDPOINTS = (
 'app/start', 'dictionary', 'app event', 'page event', 'cloud_get', 'cloud get', 'cloud_register')


def _has_http_400(lower):
 return 'http 400' in lower or 'status=400' in lower


def _is_session_core_http_400(lower):
 return _has_http_400(lower) and any(n in lower for n in _CAST_SESSION_CORE_ENDPOINTS)


def _is_control_plane_http_400(lower):
 return _has_http_400(lower) and any(n in lower for n in _CAST_CONTROL_PLANE_ENDPOINTS)


def _is_session_invalidating_error(message):
 """当前会话已不可用，必须重建会话（rotate）后重试。"""
 lower = str(message).lower()
 return ('app/start' in lower or 'decrypt' in lower or 'session_key' in lower
  or 'missing encrypted session key' in lower or _is_session_core_http_400(lower))


def _is_identity_recoverable_error(message):
 """该错误可通过重建身份/会话恢复（比 session_invalidating 更宽）。"""
 lower = str(message).lower()
 return (_is_session_invalidating_error(message) or _is_control_plane_http_400(lower)
  or 'upstream m3u8 http 400' in lower or 'upstream m3u8 http 401' in lower)


# ==== 数据结构 ====

class CastProfile(object):
 __slots__ = ('android_id', 'mac', 'hardware', 'board', 'brand', 'device', 'manufacturer',
  'model', 'product', 'tags', 'build_type', 'user', 'resolution', 'display',
  'version_id', 'host', 'fingerprint', 'report_model')


class CastIdentity(object):
 __slots__ = ('x_uid', 'x_fingerprint', 'ts', 'headers')

 def __init__(self, x_uid, x_fingerprint, ts, headers):
  self.x_uid = x_uid
  self.x_fingerprint = x_fingerprint
  self.ts = ts
  self.headers = headers


class CastSession(object):
 __slots__ = ('profile', 'identity', 'client', 'session_key', 'cloud_guid', 'version',
  'screen_param', 'cast_model', 'created_at', 'generation', 'linked_channels',
  'last_heartbeat_at', 'heartbeat_count', 'last_heartbeat_error')


class CastEntry(object):
 __slots__ = ('channel', 'live_id', 'final_url', 'playback_headers', 'android_id', 'x_uid',
  'rate', 'rate_name', 'final_host', 'refreshed_at', 'expires_at',
  'session_generation', 'last_error')

 def fresh(self, now):
  return bool(self.final_url) and now < self.expires_at

 def stale_usable(self, now):
  return bool(self.final_url) and now < self.expires_at + CAST_STALE_GRACE


CAST_STALE_GRACE = 900.0

# ==== 设备档案池（50+ 款 8K / 4K 电视，随机抽一台冒充投屏接收端）====

CAST_DEVICE_POOL = [
 {
  'source': "sony_8k_pool.XR-85Z9K",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-85Z9K",
  'report_model': "XR85Z9K",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2022.XR_85Z9K",
  'screen_param': "7680-4320-280",
  'cast_model': "XR-85Z9K"
 },
 {
  'source': "sony_8k_pool.XR-75Z9K",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-75Z9K",
  'report_model': "XR75Z9K",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2022.XR_75Z9K",
  'screen_param': "7680-4320-260",
  'cast_model': "XR-75Z9K"
 },
 {
  'source': "sony_8k_pool.XR-85Z9J",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-85Z9J",
  'report_model': "XR85Z9J",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2021.XR_85Z9J",
  'screen_param': "7680-4320-280",
  'cast_model': "XR-85Z9J"
 },
 {
  'source': "sony_8k_pool.XR-75Z9J",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-75Z9J",
  'report_model': "XR75Z9J",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2021.XR_75Z9J",
  'screen_param': "7680-4320-260",
  'cast_model': "XR-75Z9J"
 },
 {
  'source': "sony_8k_pool.KD-98ZG9",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "KD-98ZG9",
  'report_model': "KD98ZG9",
  'hardware': "mt5893",
  'board': "mt5893",
  'version_id': "SONYTV.2019.KD_98ZG9",
  'screen_param': "7680-4320-320",
  'cast_model': "KD-98ZG9"
 },
 {
  'source': "sony_8k_pool.KD-85ZG9",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "KD-85ZG9",
  'report_model': "KD85ZG9",
  'hardware': "mt5893",
  'board': "mt5893",
  'version_id': "SONYTV.2019.KD_85ZG9",
  'screen_param': "7680-4320-280",
  'cast_model': "KD-85ZG9"
 },
 {
  'source': "sony_8k_pool.KD-85ZH8",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "KD-85ZH8",
  'report_model': "KD85ZH8",
  'hardware': "mt5893",
  'board': "mt5893",
  'version_id': "SONYTV.2020.KD_85ZH8",
  'screen_param': "7680-4320-280",
  'cast_model': "KD-85ZH8"
 },
 {
  'source': "sony_8k_pool.KD-75ZH8",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "KD-75ZH8",
  'report_model': "KD75ZH8",
  'hardware': "mt5893",
  'board': "mt5893",
  'version_id': "SONYTV.2020.KD_75ZH8",
  'screen_param': "7680-4320-260",
  'cast_model': "KD-75ZH8"
 },
 {
  'source': "samsung_8k_pool.QA85QN900A",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA85QN900A",
  'report_model': "QA85QN900A",
  'hardware': "s5e9925",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2021.QN900A",
  'screen_param': "7680-4320-280",
  'cast_model': "QA85QN900A"
 },
 {
  'source': "samsung_8k_pool.QA75QN900A",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA75QN900A",
  'report_model': "QA75QN900A",
  'hardware': "s5e9925",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2021.QN900A",
  'screen_param': "7680-4320-260",
  'cast_model': "QA75QN900A"
 },
 {
  'source': "samsung_8k_pool.QA85QN900B",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA85QN900B",
  'report_model': "QA85QN900B",
  'hardware': "s5e9925",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2022.QN900B",
  'screen_param': "7680-4320-280",
  'cast_model': "QA85QN900B"
 },
 {
  'source': "samsung_8k_pool.QA75QN900B",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA75QN900B",
  'report_model': "QA75QN900B",
  'hardware': "s5e9925",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2022.QN900B",
  'screen_param': "7680-4320-260",
  'cast_model': "QA75QN900B"
 },
 {
  'source': "samsung_8k_pool.QA85QN900C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA85QN900C",
  'report_model': "QA85QN900C",
  'hardware': "s5e9935",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2023.QN900C",
  'screen_param': "7680-4320-280",
  'cast_model': "QA85QN900C"
 },
 {
  'source': "samsung_8k_pool.QA75QN900C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA75QN900C",
  'report_model': "QA75QN900C",
  'hardware': "s5e9935",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2023.QN900C",
  'screen_param': "7680-4320-260",
  'cast_model': "QA75QN900C"
 },
 {
  'source': "samsung_8k_pool.QA85QN900D",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA85QN900D",
  'report_model': "QA85QN900D",
  'hardware': "s5e9945",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2024.QN900D",
  'screen_param': "7680-4320-280",
  'cast_model': "QA85QN900D"
 },
 {
  'source': "samsung_8k_pool.QA98QN990C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA98QN990C",
  'report_model': "QA98QN990C",
  'hardware': "s5e9935",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2023.QN990C",
  'screen_param': "7680-4320-320",
  'cast_model': "QA98QN990C"
 },
 {
  'source': "samsung_8k_pool.QA85QN800C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA85QN800C",
  'report_model': "QA85QN800C",
  'hardware': "s5e9935",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2023.QN800C",
  'screen_param': "7680-4320-280",
  'cast_model': "QA85QN800C"
 },
 {
  'source': "samsung_8k_pool.QA75QN800D",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA75QN800D",
  'report_model': "QA75QN800D",
  'hardware': "s5e9945",
  'board': "neo8k",
  'version_id': "SAMSUNGTV.2024.QN800D",
  'screen_param': "7680-4320-260",
  'cast_model': "QA75QN800D"
 },
 {
  'source': "lg_8k_pool.OLED88Z1PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED88Z1PCA",
  'report_model': "OLED88Z1PCA",
  'hardware': "alpha9gen4",
  'board': "lg8k",
  'version_id': "LGTV.2021.OLED88Z1",
  'screen_param': "7680-4320-320",
  'cast_model': "OLED88Z1PCA"
 },
 {
  'source': "lg_8k_pool.OLED77Z1PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED77Z1PCA",
  'report_model': "OLED77Z1PCA",
  'hardware': "alpha9gen4",
  'board': "lg8k",
  'version_id': "LGTV.2021.OLED77Z1",
  'screen_param': "7680-4320-260",
  'cast_model': "OLED77Z1PCA"
 },
 {
  'source': "lg_8k_pool.OLED88Z2PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED88Z2PCA",
  'report_model': "OLED88Z2PCA",
  'hardware': "alpha9gen5",
  'board': "lg8k",
  'version_id': "LGTV.2022.OLED88Z2",
  'screen_param': "7680-4320-320",
  'cast_model': "OLED88Z2PCA"
 },
 {
  'source': "lg_8k_pool.OLED77Z2PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED77Z2PCA",
  'report_model': "OLED77Z2PCA",
  'hardware': "alpha9gen5",
  'board': "lg8k",
  'version_id': "LGTV.2022.OLED77Z2",
  'screen_param': "7680-4320-260",
  'cast_model': "OLED77Z2PCA"
 },
 {
  'source': "lg_8k_pool.OLED88Z3PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED88Z3PCA",
  'report_model': "OLED88Z3PCA",
  'hardware': "alpha9gen6",
  'board': "lg8k",
  'version_id': "LGTV.2023.OLED88Z3",
  'screen_param': "7680-4320-320",
  'cast_model': "OLED88Z3PCA"
 },
 {
  'source': "lg_8k_pool.OLED77Z3PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED77Z3PCA",
  'report_model': "OLED77Z3PCA",
  'hardware': "alpha9gen6",
  'board': "lg8k",
  'version_id': "LGTV.2023.OLED77Z3",
  'screen_param': "7680-4320-260",
  'cast_model': "OLED77Z3PCA"
 },
 {
  'source': "lg_8k_pool.OLED88Z4PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED88Z4PCA",
  'report_model': "OLED88Z4PCA",
  'hardware': "alpha9gen7",
  'board': "lg8k",
  'version_id': "LGTV.2024.OLED88Z4",
  'screen_param': "7680-4320-320",
  'cast_model': "OLED88Z4PCA"
 },
 {
  'source': "lg_8k_pool.86QNED99",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "86QNED99",
  'report_model': "86QNED99",
  'hardware': "alpha9gen4",
  'board': "lg8k",
  'version_id': "LGTV.2021.86QNED99",
  'screen_param': "7680-4320-300",
  'cast_model': "86QNED99"
 },
 {
  'source': "sony_4k_pool.XR-85X95K",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-85X95K",
  'report_model': "XR85X95K",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2022.XR_85X95K",
  'screen_param': "3840-2160-300",
  'cast_model': "XR-85X95K"
 },
 {
  'source': "sony_4k_pool.XR-75X95K",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-75X95K",
  'report_model': "XR75X95K",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2022.XR_75X95K",
  'screen_param': "3840-2160-280",
  'cast_model': "XR-75X95K"
 },
 {
  'source': "sony_4k_pool.XR-65X90K",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-65X90K",
  'report_model': "XR65X90K",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2022.XR_65X90K",
  'screen_param': "3840-2160-260",
  'cast_model': "XR-65X90K"
 },
 {
  'source': "sony_4k_pool.XR-55X90K",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-55X90K",
  'report_model': "XR55X90K",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2022.XR_55X90K",
  'screen_param': "3840-2160-240",
  'cast_model': "XR-55X90K"
 },
 {
  'source': "sony_4k_pool.XR-65A95K",
  'brand': "Sony",
  'manufacturer': "Sony",
  'model': "XR-65A95K",
  'report_model': "XR65A95K",
  'hardware': "mt5895",
  'board': "mt5895",
  'version_id': "SONYTV.2022.XR_65A95K",
  'screen_param': "3840-2160-260",
  'cast_model': "XR-65A95K"
 },
 {
  'source': "samsung_4k_pool.QA85QN90C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA85QN90C",
  'report_model': "QA85QN90C",
  'hardware': "s5e9935",
  'board': "neo4k",
  'version_id': "SAMSUNGTV.2023.QN90C",
  'screen_param': "3840-2160-300",
  'cast_model': "QA85QN90C"
 },
 {
  'source': "samsung_4k_pool.QA75QN90C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA75QN90C",
  'report_model': "QA75QN90C",
  'hardware': "s5e9935",
  'board': "neo4k",
  'version_id': "SAMSUNGTV.2023.QN90C",
  'screen_param': "3840-2160-280",
  'cast_model': "QA75QN90C"
 },
 {
  'source': "samsung_4k_pool.QA65QN90C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA65QN90C",
  'report_model': "QA65QN90C",
  'hardware': "s5e9935",
  'board': "neo4k",
  'version_id': "SAMSUNGTV.2023.QN90C",
  'screen_param': "3840-2160-260",
  'cast_model': "QA65QN90C"
 },
 {
  'source': "samsung_4k_pool.QA55QN90C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA55QN90C",
  'report_model': "QA55QN90C",
  'hardware': "s5e9935",
  'board': "neo4k",
  'version_id': "SAMSUNGTV.2023.QN90C",
  'screen_param': "3840-2160-240",
  'cast_model': "QA55QN90C"
 },
 {
  'source': "samsung_4k_pool.QA65S95C",
  'brand': "Samsung",
  'manufacturer': "Samsung",
  'model': "QA65S95C",
  'report_model': "QA65S95C",
  'hardware': "s5e9935",
  'board': "oled4k",
  'version_id': "SAMSUNGTV.2023.S95C",
  'screen_param': "3840-2160-260",
  'cast_model': "QA65S95C"
 },
 {
  'source': "lg_4k_pool.OLED83C3PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED83C3PCA",
  'report_model': "OLED83C3PCA",
  'hardware': "alpha9gen6",
  'board': "lg4k",
  'version_id': "LGTV.2023.OLED83C3",
  'screen_param': "3840-2160-300",
  'cast_model': "OLED83C3PCA"
 },
 {
  'source': "lg_4k_pool.OLED77C3PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED77C3PCA",
  'report_model': "OLED77C3PCA",
  'hardware': "alpha9gen6",
  'board': "lg4k",
  'version_id': "LGTV.2023.OLED77C3",
  'screen_param': "3840-2160-280",
  'cast_model': "OLED77C3PCA"
 },
 {
  'source': "lg_4k_pool.OLED65C3PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED65C3PCA",
  'report_model': "OLED65C3PCA",
  'hardware': "alpha9gen6",
  'board': "lg4k",
  'version_id': "LGTV.2023.OLED65C3",
  'screen_param': "3840-2160-260",
  'cast_model': "OLED65C3PCA"
 },
 {
  'source': "lg_4k_pool.OLED55C3PCA",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "OLED55C3PCA",
  'report_model': "OLED55C3PCA",
  'hardware': "alpha9gen6",
  'board': "lg4k",
  'version_id': "LGTV.2023.OLED55C3",
  'screen_param': "3840-2160-240",
  'cast_model': "OLED55C3PCA"
 },
 {
  'source': "lg_4k_pool.86QNED90",
  'brand': "LG",
  'manufacturer': "LGE",
  'model': "86QNED90",
  'report_model': "86QNED90",
  'hardware': "alpha7gen5",
  'board': "lg4k",
  'version_id': "LGTV.2022.86QNED90",
  'screen_param': "3840-2160-300",
  'cast_model': "86QNED90"
 },
 {
  'source': "tcl_8k_pool.85X925PRO",
  'brand': "TCL",
  'manufacturer': "TCL",
  'model': "85X925 PRO",
  'report_model': "85X925PRO",
  'hardware': "mt9615",
  'board': "tcl8k",
  'version_id': "TCLTV.2021.X925PRO",
  'screen_param': "7680-4320-280",
  'cast_model': "85X925 PRO"
 },
 {
  'source': "tcl_8k_pool.75X925PRO",
  'brand': "TCL",
  'manufacturer': "TCL",
  'model': "75X925 PRO",
  'report_model': "75X925PRO",
  'hardware': "mt9615",
  'board': "tcl8k",
  'version_id': "TCLTV.2021.X925PRO",
  'screen_param': "7680-4320-260",
  'cast_model': "75X925 PRO"
 },
 {
  'source': "tcl_4k_pool.85C845",
  'brand': "TCL",
  'manufacturer': "TCL",
  'model': "85C845",
  'report_model': "85C845",
  'hardware': "mt9615",
  'board': "tcl4k",
  'version_id': "TCLTV.2023.C845",
  'screen_param': "3840-2160-300",
  'cast_model': "85C845"
 },
 {
  'source': "tcl_4k_pool.75C845",
  'brand': "TCL",
  'manufacturer': "TCL",
  'model': "75C845",
  'report_model': "75C845",
  'hardware': "mt9615",
  'board': "tcl4k",
  'version_id': "TCLTV.2023.C845",
  'screen_param': "3840-2160-280",
  'cast_model': "75C845"
 },
 {
  'source': "tcl_4k_pool.65C845",
  'brand': "TCL",
  'manufacturer': "TCL",
  'model': "65C845",
  'report_model': "65C845",
  'hardware': "mt9615",
  'board': "tcl4k",
  'version_id': "TCLTV.2023.C845",
  'screen_param': "3840-2160-260",
  'cast_model': "65C845"
 },
 {
  'source': "tcl_4k_pool.75C745",
  'brand': "TCL",
  'manufacturer': "TCL",
  'model': "75C745",
  'report_model': "75C745",
  'hardware': "mt9615",
  'board': "tcl4k",
  'version_id': "TCLTV.2023.C745",
  'screen_param': "3840-2160-280",
  'cast_model': "75C745"
 },
 {
  'source': "tcl_4k_pool.65C745",
  'brand': "TCL",
  'manufacturer': "TCL",
  'model': "65C745",
  'report_model': "65C745",
  'hardware': "mt9615",
  'board': "tcl4k",
  'version_id': "TCLTV.2023.C745",
  'screen_param': "3840-2160-260",
  'cast_model': "65C745"
 },
 {
  'source': "changhong_4k_pool.U65G7",
  'brand': "CHANGHONG",
  'manufacturer': "CHANGHONG",
  'model': "U65G7",
  'report_model': "U65G7",
  'hardware': "mt9632",
  'board': "changhong4k",
  'version_id': "CHANGHONGTV.2022.U65G7",
  'screen_param': "3840-2160-260",
  'cast_model': "U65G7"
 },
 {
  'source': "changhong_4k_pool.U55G7",
  'brand': "CHANGHONG",
  'manufacturer': "CHANGHONG",
  'model': "U55G7",
  'report_model': "U55G7",
  'hardware': "mt9632",
  'board': "changhong4k",
  'version_id': "CHANGHONGTV.2022.U55G7",
  'screen_param': "3840-2160-240",
  'cast_model': "U55G7"
 },
 {
  'source': "changhong_4k_pool.L55QCN1",
  'brand': "CHANGHONG",
  'manufacturer': "CHANGHONG",
  'model': "L55QCN1",
  'report_model': "L55QCN1",
  'hardware': "mt9632",
  'board': "changhong4k",
  'version_id': "CHANGHONGTV.2021.L55QCN1",
  'screen_param': "3840-2160-240",
  'cast_model': "L55QCN1"
 },
 {
  'source': "changhong_4k_pool.U43QCN1",
  'brand': "CHANGHONG",
  'manufacturer': "CHANGHONG",
  'model': "U43QCN1",
  'report_model': "U43QCN1",
  'hardware': "mt9632",
  'board': "changhong4k",
  'version_id': "CHANGHONGTV.2021.U43QCN1",
  'screen_param': "3840-2160-220",
  'cast_model': "U43QCN1"
 },
 {
  'source': "changhong_4k_pool.UD65YC5500UA",
  'brand': "CHANGHONG",
  'manufacturer': "CHANGHONG",
  'model': "UD65YC5500UA",
  'report_model': "UD65YC5500UA",
  'hardware': "mt9632",
  'board': "changhong4k",
  'version_id': "CHANGHONGTV.2020.UD65YC5500UA",
  'screen_param': "3840-2160-260",
  'cast_model': "UD65YC5500UA"
 },
]


def _random_device_template(prefer_4k=False):
 if prefer_4k:
  pool_4k = [t for t in CAST_DEVICE_POOL if '8k' not in str(t.get('source', ''))]
  if pool_4k:
   return random.choice(pool_4k)
 pool = [t for t in CAST_DEVICE_POOL if '8k' in str(t.get('source', ''))]
 return random.choice(pool or CAST_DEVICE_POOL)


def _device_profile_from_template(tpl, android_id, mac):
 p = CastProfile()
 brand_id = _sanitize_profile_id(tpl['brand'])
 model_id = _sanitize_profile_id(tpl['model'])
 p.android_id = android_id
 p.mac = mac
 p.hardware = tpl['hardware']
 p.board = tpl['board']
 p.brand = tpl['brand']
 p.manufacturer = tpl['manufacturer']
 p.model = tpl['model']
 p.report_model = tpl.get('report_model') or tpl['model']
 p.device = '%s_%s' % (brand_id, model_id)
 p.product = '%s_%s' % (brand_id, model_id)
 p.tags = 'release-keys'
 p.build_type = 'user'
 p.user = 'build'
 p.resolution = _resolution_from_screen_param(tpl['screen_param'])
 p.display = '%s-user 13 %s 2024 release-keys' % (tpl['model'], tpl['version_id'])
 p.version_id = tpl['version_id']
 p.host = '%s-tv-build' % brand_id
 p.fingerprint = '%s/%s/%s:13/%s/2024:user/release-keys' % (
  tpl['manufacturer'], p.product, p.device, tpl['version_id'])
 return p


def _infer_os_version(p):
 if ':' in p.fingerprint:
  tail = p.fingerprint.split(':', 1)[1]
  if '/' in tail:
   return tail.split('/', 1)[0]
 return ''


def _infer_sdk_int(p):
 major = _infer_os_version(p).split('.')[0] if _infer_os_version(p) else ''
 return {'13': '33', '12': '31', '11': '30', '10': '29', '9': '28', '8': '26',
  '7': '24', '6': '23'}.get(major, '')


def _compute_x_uid(p):
 build = ('1698' + p.hardware + p.board + p.brand + p.device + p.manufacturer + p.model
  + p.product + p.tags + p.build_type + p.user + p.resolution + p.mac)
 uuid_part = _java_uuid_from_hashes(_java_hashcode(build), _java_hashcode(p.model))
 return _sha1_upper('%s|%s' % (p.android_id, uuid_part))


def _build_identity(p, app_channel, version):
 x_uid = _compute_x_uid(p)
 fp, ts, _day0 = _compute_fingerprint(x_uid, int(time.time() * 1000))
 headers = {
  'Accept': 'application/json', 'Accept-Language': CAST_ACCEPT_LANGUAGE,
  'Referer': 'api.cctv.cn', 'User-Agent': CAST_UA, 'UID': p.android_id,
  'appChannel': app_channel, 'X-Uid': x_uid, 'X-Fingerprint': fp,
  'X-Version': version, 'Content-Type': 'application/json; charset=utf-8',
  'Connection': 'Keep-Alive', 'Accept-Encoding': 'gzip', 'Cache-Control': 'no-cache',
 }
 return CastIdentity(x_uid, fp, ts, headers)


def _fresh_headers(template, content_type, accept=None, force_ts=None):
 headers = {}
 if accept is not None:
  headers['Accept'] = accept
 headers['X-Timestamp'] = str(force_ts if force_ts is not None else int(time.time() * 1000))
 headers['X-Nonce'] = str(uuid.uuid4())
 for key in ('Accept-Language', 'Referer', 'User-Agent', 'UID', 'appChannel',
  'X-Uid', 'X-Fingerprint', 'X-Version'):
  if key in template:
   headers[key] = template[key]
 if content_type:
  headers['Content-Type'] = content_type
 for key in ('Connection', 'Accept-Encoding', 'Cache-Control'):
  if key in template:
   headers[key] = template[key]
 return headers


def _report_common_value(p, x_uid, app_channel, version, sdk_version, ts_ms):
 def f(v, limit):
  return str(v)[:limit] if limit >= 0 else str(v)
 model = p.report_model or p.model.replace(p.manufacturer, '').replace(' ', '')
 return {
  'cctv_id': f(x_uid, 64), 'device_id': f(p.android_id, 64), 'idfa': '', 'idfv': '',
  'user_id': '', 'app_key': f(CAST_REPORT_APP_KEY, 64), 'imei': '',
  'android_id': f(p.android_id, 64), 'mac': f(p.mac, 64),
  'device_builder_type': f(p.build_type, 64), 'device_hardware': f(p.hardware, 64),
  'device_board': f(p.board, 64), 'device_brand': f(p.brand, 64),
  'device_params': f(p.device, 64), 'device_display': f(p.display, 64),
  'device_version_id': f(p.version_id, 64), 'device_host': f(p.host, 128),
  'device_product': f(p.product, 64), 'device_tags': f(p.tags, 64),
  'device_user': f(p.user, 30), 'device_fingerprint': f(p.fingerprint, 128),
  'device_manufacturer': f(p.manufacturer, 64), 'device_model': f(model, 50),
  'device_resolution': f(p.resolution, 20), 'system_type': 'Android', 'device_type': 'TV',
  'app_language': 'CHINESE', 'app_version': f(version, 30),
  'sdk_version': f(sdk_version, 30), 'os_version': f(_infer_os_version(p), 20),
  'app_channel': f(app_channel, 50), 'data_time': f(ts_ms, 13),
 }


def _collect_headers(p):
 release = _infer_os_version(p)
 return {'Content-type': 'application/x-www-form-urlencoded', 'Charset': 'UTF-8',
  'User-Agent': 'Dalvik/2.1.0 (Linux; U; Android %s; %s Build/%s)'
  % (release or 'Android', p.model, p.version_id),
  'Connection': 'Keep-Alive', 'Accept-Encoding': 'gzip'}


# ==== 投屏专用 HTTP 客户端（不借容器 fetch，避免头部被改写）====

class CastHttp(object):
 def __init__(self, timeout, insecure):
  self.timeout = max(float(timeout), 0.1)
  ctx = ssl._create_unverified_context() if insecure else ssl.create_default_context()
  jar = http.cookiejar.CookieJar()
  self.opener = urllib.request.build_opener(
   urllib.request.HTTPCookieProcessor(jar), urllib.request.HTTPSHandler(context=ctx))

 def _send(self, method, url, headers, data):
  req = urllib.request.Request(url, data=data, method=method)
  for k, v in (headers or {}).items():
   try:
    req.add_header(k, str(v))
   except Exception:
    pass
  try:
   try:
    with self.opener.open(req, timeout=self.timeout) as resp:
     status, hdrs, body = resp.status, dict(resp.headers.items()), resp.read()
   except urllib.error.HTTPError as e:
    status = e.code
    hdrs = dict(e.headers.items()) if getattr(e, 'headers', None) else {}
    try:
     body = e.read()
    except Exception:
     body = b''
  except Exception as e:
   raise CastError('network error: %s: %s' % (type(e).__name__, e))
  low = {str(k).lower(): v for k, v in hdrs.items()}
  if 'gzip' in str(low.get('content-encoding', '')).lower():
   try:
    body = gzip.decompress(body)
   except Exception:
    pass
  return status, body, low

 def get(self, url, headers):
  return self._send('GET', url, headers, None)

 def post_bytes(self, url, headers, data):
  return self._send('POST', url, headers, data)

 def post_json(self, url, headers, body):
  return self._send('POST', url, headers,
   json.dumps(body, separators=(',', ':'), ensure_ascii=False,
    sort_keys=True).encode('utf-8'))

 def post_form(self, url, headers, pairs):
  return self._send('POST', url, headers, _form_encode(pairs))


def _cast_json(status, body):
 try:
  return json.loads(body.decode('utf-8', 'replace'))
 except Exception:
  return None


# ==== 全局请求流控（避免打太快被风控）====

class CastLimiter(object):
 def __init__(self, interval, jitter):
  self.interval = float(interval)
  self.jitter = float(jitter)
  self.lock = threading.Lock()
  self.last_end = 0.0

 def __call__(self, name=''):
  with self.lock:
   wait = self.interval - (time.time() - self.last_end)
   if wait > 0:
    time.sleep(wait + random.uniform(0, self.jitter))
   self.last_end = time.time()


# ==== 投屏解析器 ====

class CastResolver(object):
 """设备投屏源内核：角色扮演电视 → 云注册 → app/start → live01/02 → VDN 换取高码流。"""

 def __init__(self):
  self.timeout = 12.0
  self.insecure = False
  self.cache_ttl = 1500.0
  self.refresh_interval = 0.7
  self.jitter = 0.25
  self.session_ttl = 3600.0
  self.heartbeat_interval = 300.0
  self.links_per_device = 6
  self.max_slots = 1
  self.state_lock = threading.RLock()
  self.control_lock = threading.RLock()
  self.limiter = CastLimiter(self.refresh_interval, self.jitter)
  self.sessions = {}
  self.standby = None
  self.cache = {}
  self.failures = {}
  self.device_file = ''
  self.persist = False
  self.last_error = ''
  self.last_error_at = 0.0
  self.generation = 0
  self.prepared = False
  self.prepared_at = 0.0
  self.hb_thread = None
  self.zap_channel = ''
  self.zap_time = 0.0
  self.zap_pending = ''
  self.zap_generation = 0
  self.last_device_wipe_at = 0.0
  self.device_wipe_day = ''
  self.device_wipe_count = 0
  self.channel_last_access = {}
  self.zap_debounce = 10.0

 # ---- 配置 ----
 def configure(self, opts):
  self.timeout = float(opts.get('cast_timeout') or 12)
  self.insecure = bool(opts.get('cast_insecure', False))
  self.cache_ttl = float(opts.get('cast_cache_ttl') or 1500)
  self.refresh_interval = float(opts.get('cast_interval') or 0.7)
  self.jitter = float(opts.get('cast_jitter') or 0.25)
  self.session_ttl = float(opts.get('cast_session_ttl') or 3600)
  self.heartbeat_interval = float(opts.get('cast_heartbeat') or 300)
  self.links_per_device = int(opts.get('cast_links') or 6)
  try:
   self.zap_debounce = float(opts.get('zap_debounce', opts.get('cast_zap_debounce', 10.0)))
  except (TypeError, ValueError):
   self.zap_debounce = 10.0
  self.device_file = str(opts.get('cast_device_json') or '')
  self.persist = bool(opts.get('cast_persist', False)) and bool(self.device_file)
  self.limiter = CastLimiter(self.refresh_interval, self.jitter)

 # ---- 小工具 ----
 def new_client(self):
  return CastHttp(self.timeout, self.insecure)

 def get_slot_for_channel(self, channel):
  return 0

 def _slot_for(self, channel):
  return self.get_slot_for_channel(channel)

 def evict_idle_links(self, sess, idle_sec=15.0):
  now = time.time()
  with self.state_lock:
   last = dict(self.channel_last_access)
  for ch in list(sess.linked_channels):
   if now - last.get(ch, 0.0) > idle_sec:
    sess.linked_channels.discard(ch)

 def zap_debounced(self, channel):
  if channel in TRUE_4K_CHANNELS:
   return False
  try:
   debounce = float(getattr(self, 'zap_debounce', 10.0))
  except (TypeError, ValueError):
   debounce = 10.0
  if debounce <= 0.0:
   return False
  now = time.time()
  with self.state_lock:
   entry = self.cache.get(channel)
   if entry is not None and entry.fresh(now):
    return False
   if self.zap_channel != channel:
    self.zap_channel = channel
    self.zap_time = now
    self.zap_pending = ''
   if self.zap_pending == channel:
    return True
   if now - self.zap_time < debounce:
    self.zap_pending = channel
    self.zap_generation += 1
    gen = self.zap_generation
    delay = max(0.1, debounce - (now - self.zap_time))
    threading.Thread(target=self._zap_resolve_worker, args=(channel, gen, delay), daemon=True).start()
    return True
  return False

 def _zap_resolve_worker(self, channel, gen, delay):
  time.sleep(delay)
  with self.state_lock:
   if gen != self.zap_generation or self.zap_channel != channel:
    return
  try:
   self.resolve(channel, force=True)
   _cast_log('[%s] high-bitrate background prefetch done' % channel)
  except Exception as e:
   _cast_log('[%s] background prefetch failed: %s, keep 1080p' % (channel, e))
  finally:
   with self.state_lock:
    if self.zap_pending == channel:
     self.zap_pending = ''

 def rotate_device_on_400(self, reason):
  now = time.time()
  with self.state_lock:
   if now - self.last_device_wipe_at < 300.0:
    return False
   day = time.strftime('%Y-%m-%d', time.localtime(now))
   if self.device_wipe_day != day:
    self.device_wipe_day = day
    self.device_wipe_count = 0
   if self.device_wipe_count >= 5:
    _cast_log('device auto-rotate capped 5/day, check network')
    return False
   self.last_device_wipe_at = now
   self.device_wipe_day = day
   self.device_wipe_count += 1
   wipe_no = self.device_wipe_count
   self.sessions.pop(0, None)
   self.cache.clear()
   self.failures.clear()
   self.channel_last_access.clear()
  try:
   self.ensure_slot_session(0)
  except Exception as e:
   _cast_log('rotate on 400 failed: %s' % e)
   return False
  _cast_log('[device] 400 (%s) rotated identity (once per 5min, #%s today)' % (reason, wipe_no))
  return True

 def _request(self, client, method, url, headers, body=None, form=None, raw=None):
  self.limiter()
  if method == 'GET':
   return client.get(url, headers)
  if form is not None:
   return client.post_form(url, headers, form)
  if raw is not None:
   return client.post_bytes(url, headers, raw)
  return client.post_json(url, headers, body)

 def _cooldown(self, channel):
  item = self.failures.get(channel)
  if not item:
   return 0.0
  at, _err, cnt = item
  wait = 15.0 if cnt <= 1 else (60.0 if cnt == 2 else 120.0)
  left = wait - (time.time() - at)
  return left if left > 0 else 0.0

 def _record_failure(self, channel, err):
  prev = self.failures.get(channel)
  cnt = (prev[2] + 1) if prev else 1
  self.failures[channel] = (time.time(), str(err)[:120], cnt)
  self.last_error = str(err)[:200]
  self.last_error_at = time.time()

 # ---- 会话 ----
 def app_start_flow(self, client, p, ident):
  last = 'app/start failed'
  for attempt in range(1, 3):
   if attempt > 1:
    time.sleep(float(attempt - 1))
   ts = int(time.time() * 1000)
   fp, _t, _d = _compute_fingerprint(ident.x_uid, ts)
   ident.x_fingerprint = fp
   ident.headers['X-Fingerprint'] = fp
   body = {'key': 'app_start_d1',
    'value': _report_common_value(p, ident.x_uid, CAST_APP_CHANNEL,
     CAST_VERSION, '', ts)}
   headers = _fresh_headers(ident.headers, 'application/json', 'application/json', ts)
   headers['UID'] = ''
   status, resp, _h = self._request(client, 'POST', CAST_APP_START, headers,
    raw=_compact_json_bytes(body, True))
   value = _cast_json(status, resp)
   if 200 <= status < 300 and isinstance(value, dict):
    data = value.get('data')
    enc = ''
    if isinstance(data, dict):
     kv = data.get('key', data)
     enc = kv if isinstance(kv, str) else ''
    elif isinstance(data, str):
     enc = data
    if enc:
     return _aes_gcm_decrypt_b64(enc, fp[:32])
   last = 'app/start HTTP %s: %s' % (status, resp[:160].decode('utf-8', 'replace'))
  raise CastError(last)

 def cloud_registration_flow(self, ident, device_id):
  body = {'device_name': CAST_DEVICE_NAME, 'device_id': _rsa_encrypt_device_id(device_id)}
  client = self.new_client()
  status, resp, _h = self._request(client, 'POST', CAST_CLOUD_GET,
   _fresh_headers(ident.headers, 'application/json',
    'application/json'), body)
  value = _cast_json(status, resp)
  code = _parse_result_code(value)
  if code == CAST_RESULT_OK:
   return _extract_guid(value)
  if code not in (CAST_RESULT_NEEDS_REGISTER, CAST_RESULT_GET_INVALID):
   return ''
  last = None
  guid = ''
  for _ in range(2):
   status, resp, _h = self._request(client, 'POST', CAST_CLOUD_REGISTER,
    _fresh_headers(ident.headers, 'application/json',
     'application/json'), body)
   value = _cast_json(status, resp)
   last = _parse_result_code(value)
   guid = _extract_guid(value)
   if guid or last != CAST_RESULT_RETRY_LATER:
    break
  if guid:
   return guid
  if last in (CAST_RESULT_OK, CAST_RESULT_REGISTERED_ELSEWHERE, CAST_RESULT_GET_INVALID):
   status, resp, _h = self._request(client, 'POST', CAST_CLOUD_GET,
    _fresh_headers(ident.headers, 'application/json',
     'application/json'), body)
   return _extract_guid(_cast_json(status, resp))
  return ''

 def heartbeat_flow(self, client, p, ident, cloud_guid):
  ts = int(time.time() * 1000)
  value = _report_common_value(p, ident.x_uid, CAST_APP_CHANNEL, CAST_VERSION, '', ts)
  value['network_type'] = 'WiFi'
  value['guid'] = cloud_guid
  value['other'] = ''
  status, resp, _h = self._request(client, 'POST', CAST_REPORT_SINGLE,
   _fresh_headers(ident.headers, 'application/json',
    'application/json'),
   {'key': 'app_heartbeat', 'value': value})
  if not 200 <= status < 300:
   raise CastError('heartbeat HTTP %s' % status)
  code = _parse_result_code(_cast_json(status, resp))
  return '' if code is None else str(code)

 def bootstrap_session(self, prefer_4k=False, profile_seed=None):
  tpl = _random_device_template(prefer_4k)
  if profile_seed:
   p = _device_profile_from_template(profile_seed, profile_seed.get('android_id')
    or _random_hex(16), profile_seed.get('mac')
    or _random_mac())
  else:
   p = _device_profile_from_template(tpl, _random_hex(16), _random_mac())
  ident = _build_identity(p, CAST_APP_CHANNEL, CAST_VERSION)
  client = self.new_client()
  session_key = self.app_start_flow(client, p, ident)
  cloud_guid = ''
  try:
   cloud_guid = self.cloud_registration_flow(ident, ident.x_uid)
  except Exception as e:
   _cast_log('cloud register skip: %s' % e)
  try:
   self.heartbeat_flow(client, p, ident, cloud_guid)
  except Exception as e:
   _cast_log('heartbeat skip: %s' % e)
  sess = CastSession()
  sess.profile = p
  sess.identity = ident
  sess.client = client
  sess.session_key = session_key
  sess.cloud_guid = cloud_guid
  sess.version = CAST_VERSION
  sess.screen_param = tpl.get('screen_param', '7680-4320-280')
  sess.cast_model = tpl.get('cast_model') or p.model
  sess.created_at = time.time()
  sess.generation = 0
  sess.linked_channels = set()
  sess.last_heartbeat_at = time.time()
  sess.heartbeat_count = 1
  sess.last_heartbeat_error = ''
  self._telemetry(client, p, ident, cloud_guid)
  _cast_log('session ready model=%s uid=%s cloud=%s'
   % (p.model, ident.x_uid[:12], 'yes' if cloud_guid else 'no'))
  return sess

 def _telemetry(self, client, p, ident, cloud_guid):
  def run():
   try:
    body = {'key': 'app_start_d1',
     'value': _report_common_value(p, ident.x_uid, CAST_APP_CHANNEL,
      CAST_VERSION, CAST_SDK_VERSION,
      int(time.time() * 1000))}
    client.post_form(CAST_COLLECT_REPORT, _collect_headers(p),
     [('info', json.dumps(body, separators=(',', ':'),
      ensure_ascii=False, sort_keys=True))])
   except Exception:
    pass
   try:
    client.post_bytes(CAST_DICTIONARY, _root_headers(CAST_VERSION), b'')
   except Exception:
    pass
   if cloud_guid:
    try:
     ts = int(time.time() * 1000)
     value = _report_common_value(p, ident.x_uid, CAST_APP_CHANNEL,
      CAST_VERSION, '', ts)
     sdk = _infer_sdk_int(p)
     system_info = _infer_os_version(p)
     if sdk:
      system_info = sdk if not system_info else '%s/%s' % (system_info, sdk)
     value.update({'version': CAST_VERSION, 'network_status': 'WiFi',
      'device_info': '%s-%s' % (p.brand, p.model),
      'manufacturer': p.manufacturer, 'cpu_info': '',
      'chip_info': p.hardware, 'ram_info': '', 'memory_info': '',
      'system_info': system_info, 'guid': cloud_guid})
     client.post_json(CAST_REPORT_SINGLE,
      _fresh_headers(ident.headers, 'application/json',
       'application/json'),
      {'key': 'app_device_info', 'value': value})
    except Exception:
     pass
   try:
    client.post_json(CAST_INDEX,
     _fresh_headers(ident.headers, 'application/json',
      'application/json'),
     {'channel': CAST_APP_CHANNEL, 'source': 'application'})
   except Exception:
    pass
   try:
    appcommon = _build_vdn_appcommon(CAST_VERSION)
    client.post_form(CAST_DRM_CONFIG,
     _fresh_headers(ident.headers,
      'application/x-www-form-urlencoded'),
     [('appcommon', appcommon)])
    client.get('%s?appcommon=%s' % (CAST_VERSION_CONFIG,
     _form_urlencode_value(appcommon)),
     _fresh_headers(ident.headers, ''))
   except Exception:
    pass
  threading.Thread(target=run, daemon=True).start()

 def ensure_slot_session(self, slot, force=False):
  with self.control_lock:
   with self.state_lock:
    sess = self.sessions.get(slot)
   if sess is not None and not force and time.time() - sess.created_at < self.session_ttl \
                    and sess.session_key:
    return sess
   if sess is not None and force:
    self._rotate_now(slot, 'forced')
   with self.state_lock:
    sess = self.sessions.get(slot)
    if sess is not None and sess.session_key and not force:
     return sess
   new_sess = self.bootstrap_session(prefer_4k=(slot == 0))
   with self.state_lock:
    self.generation += 1
    new_sess.generation = self.generation
    self.sessions[slot] = new_sess
   self._start_heartbeat()
   return new_sess

 def _rotate_now(self, slot, reason):
  with self.state_lock:
   old = self.sessions.pop(slot, None)
   self.generation += 1
  _cast_log('rotate slot %s (%s)' % (slot, reason))
  try:
   new_sess = self.bootstrap_session(prefer_4k=(slot == 0))
  except Exception as e:
   with self.state_lock:
    if old is not None:
     self.sessions[slot] = old
   raise CastError('rotate failed: %s' % e)
  with self.state_lock:
   self.generation += 1
   new_sess.generation = self.generation
   self.sessions[slot] = new_sess
  return new_sess

 def _start_heartbeat(self):
  if self.hb_thread is not None and self.hb_thread.is_alive():
   return
  self.hb_thread = threading.Thread(target=self._heartbeat_loop, daemon=True)
  self.hb_thread.start()

 def _heartbeat_loop(self):
  while True:
   time.sleep(max(60.0, self.heartbeat_interval))
   try:
    with self.state_lock:
     slots = list(self.sessions.keys())
    for slot in slots:
     with self.state_lock:
      sess = self.sessions.get(slot)
     if sess is None:
      continue
     if time.time() - sess.created_at > self.session_ttl - 300:
      try:
       sess = self.ensure_slot_session(slot, force=True)
      except Exception as e:
       _cast_log('heartbeat rotate fail: %s' % e)
       continue
     try:
      self.heartbeat_flow(sess.client, sess.profile, sess.identity,
       sess.cloud_guid)
      sess.last_heartbeat_at = time.time()
      sess.heartbeat_count += 1
      sess.last_heartbeat_error = ''
     except Exception as e:
      sess.last_heartbeat_error = str(e)[:120]
      _cast_log('heartbeat fail slot %s: %s' % (slot, e))
   except Exception:
    pass

 # ---- 频道解析 ----
 def live_v1_01_flow(self, sess, live_id):
  body = {'screenParam': sess.screen_param, 'rate': '', 'systemType': 'ios',
   'model': sess.cast_model, 'id': live_id, 'userId': CAST_LIVE_USER_ID,
   'clientSign': 'cctvVideo',
   'deviceId': {'serial': '', 'imei': '', 'android_id': ''}}
  status, resp, _h = self._request(sess.client, 'POST', CAST_LIVE_01,
   _fresh_headers(sess.identity.headers,
    'application/json', 'application/json'),
   body)
  value = _cast_json(status, resp)
  if not 200 <= status < 300:
   raise CastError('live/v1/01 HTTP %s: %s'
    % (status, resp[:160].decode('utf-8', 'replace')))
  videos = None
  if isinstance(value, dict) and isinstance(value.get('data'), dict):
   videos = value['data'].get('videoList') or value['data'].get('videos')
  if not isinstance(videos, list):
   raise CastError('live/v1/01 missing videos')
  selected, fallback = None, None
  for item in videos:
   if not isinstance(item, dict):
    continue
   url = item.get('url')
   if not isinstance(url, str) or not url:
    continue
   if fallback is None:
    fallback = item
   if item.get('rate') == '36p':
    selected = item
    break
  video = selected if selected is not None else fallback
  if video is None:
   raise CastError('live/v1/01 no usable URL')
  raw_url = video.get('url', '')
  if raw_url.startswith('http://') or raw_url.startswith('https://'):
   live_url = raw_url
  else:
   live_url = _aes_gcm_decrypt_b64(raw_url, sess.session_key)
  rate = video.get('rate')
  rate_name = video.get('rateName')
  return live_url, (rate if isinstance(rate, str) else ''), \
            (rate_name if isinstance(rate_name, str) else '')

 def live_v1_02_flow(self, sess):
  enc_guid = _aes_gcm_encrypt_b64('', sess.session_key)
  status, resp, _h = self._request(sess.client, 'POST', CAST_LIVE_02,
   _fresh_headers(sess.identity.headers,
    'application/json', 'application/json'),
   {'guid': enc_guid})
  value = _cast_json(status, resp)
  if not 200 <= status < 300:
   raise CastError('live/v1/02 HTTP %s: %s'
    % (status, resp[:160].decode('utf-8', 'replace')))
  enc = None
  if isinstance(value, dict):
   data = value.get('data')
   if isinstance(data, dict):
    for key in ('appSecret', 'app_secret'):
     v = data.get(key)
     if isinstance(v, str):
      enc = v
      break
   if enc is None and isinstance(data, str):
    enc = data
  if enc is None:
   raise CastError('live/v1/02 missing appSecret')
  return _aes_gcm_decrypt_b64(enc, sess.session_key)

 def vdn_getstream_flow(self, sess, live_url, app_secret):
  app_sign, random_str = _compute_vdn_code(app_secret)
  headers = _fresh_headers(sess.identity.headers, 'application/x-www-form-urlencoded')
  headers['APPID'] = CAST_AK
  headers['APPSIGN'] = app_sign
  headers['APPRANDOMSTR'] = random_str
  status, resp, _h = self._request(sess.client, 'POST', CAST_VDN, headers,
   form=[('appcommon', _build_vdn_appcommon(CAST_VERSION)),
    ('url', live_url)])
  value = _cast_json(status, resp)
  if not 200 <= status < 300:
   raise CastError('VDN HTTP %s: %s' % (status, resp[:160].decode('utf-8', 'replace')))
  if isinstance(value, dict):
   succeed = value.get('succeed')
   ok = str(succeed).strip('"') == '1' if succeed is not None else False
   if ok:
    url = value.get('url')
    if isinstance(url, str) and url:
     return url, app_sign, random_str
  raise CastError('VDN did not return final URL')

 def _resolve_once(self, sess, channel, live_id):
  live_url, rate, rate_name = self.live_v1_01_flow(sess, live_id)
  app_secret = self.live_v1_02_flow(sess)
  final_url, app_sign, random_str = self.vdn_getstream_flow(sess, live_url, app_secret)
  headers = _default_playback_headers(sess.profile.android_id)
  headers['APPRANDOMSTR'] = random_str
  headers['APPSIGN'] = app_sign
  entry = CastEntry()
  entry.channel = channel
  entry.live_id = live_id
  entry.final_url = final_url
  entry.playback_headers = headers
  entry.android_id = sess.profile.android_id
  entry.x_uid = sess.identity.x_uid
  entry.rate = rate
  entry.rate_name = rate_name
  entry.final_host = _url_host(final_url)
  entry.refreshed_at = time.time()
  entry.expires_at = entry.refreshed_at + self.cache_ttl
  entry.session_generation = sess.generation
  entry.last_error = ''
  sess.linked_channels.add(channel)
  return entry

 def resolve(self, channel, force=False):
  """取一个频道的投屏高码流地址；带冷却、SWR 旧值兜底、热备设备重试。"""
  live_id = CAST_LIVE_IDS.get(channel)
  if not live_id:
   raise CastError('channel has no cast id: %s' % channel)
  now = time.time()
  with self.state_lock:
   entry = self.cache.get(channel)
  if entry is not None and entry.fresh(now) and not force:
   return entry
  wait = self._cooldown(channel)
  if wait > 0 and entry is None:
   raise CastError('channel cooling down %.0fs (%s)' % (wait, self.last_error))
  slot = self.get_slot_for_channel(channel)
  try:
   with self.state_lock:
    self.channel_last_access[channel] = time.time()
   sess = self.ensure_slot_session(slot)
   limit = self.links_per_device
   if limit > 0 and channel not in sess.linked_channels \
                    and len(sess.linked_channels) >= limit:
    self.evict_idle_links(sess, LINK_IDLE_TIMEOUT)
    if len(sess.linked_channels) >= limit:
     raise CastError('device link quota reached (%s), fallback to 1080p' % limit)
   try:
    entry = self._resolve_once(sess, channel, live_id)
   except CastError as err:
    txt = str(err)
    # 仅当「会话核心端点」确实返回 400 时才轮换设备身份；
    # 旧实现用裸子串 ' 400'，会被上游响应体里出现的 " 400" 误命中。
    if _is_session_core_http_400(txt.lower()) or _is_control_plane_http_400(txt.lower()):
     try:
      self.rotate_device_on_400(txt[:120])
     except Exception:
      pass
    if self._session_invalid(err):
     _cast_log('slot %s hit risk control (%s), rotate & retry' % (slot, err))
     sess = self._rotate_now(slot, str(err))
     entry = self._resolve_once(sess, channel, live_id)
    else:
     raise
  except Exception as err:
   self._record_failure(channel, err)
   with self.state_lock:
    stale = self.cache.get(channel)
   if stale is not None and stale.stale_usable(now):
    _cast_log('%s serve stale: %s' % (channel, err))
    return stale
   if isinstance(err, CastError):
    raise
   raise CastError(str(err))
  with self.state_lock:
   self.cache[channel] = entry
   self.failures.pop(channel, None)
   self.channel_last_access[channel] = time.time()
   if self.zap_pending == channel:
    self.zap_pending = ''
  self.prepared = True
  self.prepared_at = time.time()
  return entry

 def resolve_background(self, channel):
  """后台预热：不抛错，结果进缓存。"""
  try:
   self.resolve(channel)
  except Exception as e:
   _cast_log('background %s failed: %s' % (channel, e))

 @staticmethod
 def _session_invalid(err):
  text = str(err)
  marks = ('app/start', 'AES-GCM decrypt', 'session_key', 'HTTP 401',
   'HTTP 403', 'missing videos', 'no usable URL', 'missing appSecret')
  if any(m in text for m in marks):
   return True
  # HTTP 400 走带端点上下文的分类判断（v9.5 移植），
  # 不再把任意含 '400' 的报文当成会话失效。
  return _is_session_invalidating_error(text)

 def prepare(self, channels=None):
  """取消启动预热(v9.4)：只建单设备池会话，不拉频道。"""
  def run():
   try:
    self.ensure_slot_session(0)
    self.prepared = True
    self.prepared_at = time.time()
    _cast_log('prepared')
   except Exception as e:
    _cast_log('prepare failed: %s' % e)
  threading.Thread(target=run, daemon=True).start()

 def status(self):
  with self.state_lock:
   lines = ['prepared=%s sessions=%s cache=%s'
    % (self.prepared, sorted(self.sessions.keys()), len(self.cache))]
   for slot in sorted(self.sessions):
    s = self.sessions[slot]
    lines.append('slot %s: model=%s uid=%s cloud=%s links=%d age=%.0fs hb=%s'
     % (slot, s.profile.model, s.identity.x_uid[:12],
      bool(s.cloud_guid), len(s.linked_channels),
      time.time() - s.created_at, s.last_heartbeat_error or 'ok'))
   for ch in sorted(self.cache):
    e = self.cache[ch]
    lines.append('%s: rate=%s (%s) fresh=%s host=%s'
     % (ch, e.rate, e.rate_name, e.fresh(time.time()), e.final_host))
   if self.last_error:
    lines.append('last_error=%s' % self.last_error)
  return '\n'.join(lines) + '\n'


CAST = CastResolver()


# ================================================================ 频道表

CHANNELS = [
 ('cctv1', 'CCTV-1 综合', '2024078201', '600001859', 'fhd', 'Live1717729995180256'),
 ('cctv2', 'CCTV-2 财经', '2024075401', '600001800', 'fhd', 'Live1718261577870260'),
 ('cctv3', 'CCTV-3 综艺', '2024068501', '600001801', 'fhd', 'Live1718261955077261'),
 ('cctv4', 'CCTV-4 中文国际', '2029797101', '600001814', 'fhd', 'Live1718276148119264'),
 ('cctv5', 'CCTV-5 体育', '2024078401', '600001818', 'fhd', 'Live1719474204987287'),
 ('cctv5p', 'CCTV-5+ 体育赛事', '2024078001', '600001817', 'fhd', 'Live1719473996025286'),
 ('cctv6', 'CCTV-6 电影', '2013693901', '600108442', 'fhd', None),
 ('cctv7', 'CCTV-7 国防军事', '2024072001', '600004092', 'fhd', 'Live1718276412224269'),
 ('cctv8', 'CCTV-8 电视剧', '2029793001', '600001803', 'fhd', 'Live1718276458899270'),
 ('cctv9', 'CCTV-9 纪录', '2024078601', '600004078', 'fhd', 'Live1718276503187272'),
 ('cctv10', 'CCTV-10 科教', '2024078701', '600001805', 'fhd', 'Live1718276550002273'),
 ('cctv11', 'CCTV-11 戏曲', '2027248701', '600001806', 'fhd', 'Live1718276603690275'),
 ('cctv12', 'CCTV-12 社会与法', '2027248801', '600001807', 'fhd', 'Live1718276623932276'),
 ('cctv13', 'CCTV-13 新闻', '2029797201', '600001811', 'fhd', 'Live1718276575708274'),
 ('cctv14', 'CCTV-14 少儿', '2027248901', '600001809', 'fhd', 'Live1718276498748271'),
 ('cctv15', 'CCTV-15 音乐', '2027249001', '600001815', 'fhd', 'Live1718276319614267'),
 ('cctv16', 'CCTV-16 奥林匹克', '2027249101', '600098637', 'fhd', 'Live1718276256572265'),
 ('cctv17', 'CCTV-17 农业农村', '2027249401', '600001810', 'fhd', 'Live1718276138318263'),
 ('cctv4k', 'CCTV-4K 超高清', '2029810301', '600002264', 'fhd', 'Live1767871224782105'),
 ('cctv8k', 'CCTV-8K 超高清', '2026774101', '600156816', 'fhd', 'Live1688400593818102'),
 ('cctv164k', 'CCTV-16 4K', '2027249301', '600099502', 'fhd', 'Live1704966749996185'),
 ('cgtn', 'CGTN 英语', '2024181701', '600014550', 'fhd', 'Live1719392219423280'),
 ('cgtnfr', 'CGTN 法语', '2024181801', '600084704', 'fhd', 'Live1719392670442283'),
 ('cgtnru', 'CGTN 俄语', '2024181901', '600084758', 'fhd', 'Live1719392779653284'),
 ('cgtnar', 'CGTN 阿拉伯语', '2024182001', '600084782', 'fhd', 'Live1719392885692285'),
 ('cgtnes', 'CGTN 西班牙语', '2024182101', '600084744', 'fhd', 'Live1719392560433282'),
 ('cgtndoc', 'CGTN 纪录', '2024182301', '600084781', 'fhd', 'Live1719392360336281'),
 ('cctvfyjc', 'CCTV 风云剧场', '2025637102', '600099658', 'shd', None),
 ('cctvdyjc', 'CCTV 第一剧场', '2026874202', '600099655', 'shd', None),
 ('cctvhjjc', 'CCTV 怀旧剧场', '2026874302', '600099620', 'shd', None),
 ('bjws', '北京卫视', '2024052703', '600002309', 'fhd', None),
 ('jsws', '江苏卫视', '2024171103', '600002521', 'fhd', None),
 ('dfws', '东方卫视', '2024054503', '600002483', 'fhd', None),
 ('zjws', '浙江卫视', '2024054703', '600002520', 'fhd', None),
 ('hnws', '湖南卫视', '2024054803', '600002475', 'fhd', None),
 ('hbws', '湖北卫视', '2024171203', '600002508', 'fhd', None),
 ('gdws', '广东卫视', '2024060903', '600002485', 'fhd', None),
 ('gxws', '广西卫视', '2024060703', '600002509', 'fhd', None),
 ('hljws', '黑龙江卫视', '2029797003', '600002498', 'fhd', None),
 ('hainanws', '海南卫视', '2024055603', '600002506', 'fhd', None),
 ('cqws', '重庆卫视', '2024061103', '600002531', 'fhd', None),
 ('szws', '深圳卫视', '2024061303', '600002481', 'fhd', None),
 ('scws', '四川卫视', '2024061403', '600002516', 'fhd', None),
 ('henanws', '河南卫视', '2029797303', '600002525', 'fhd', None),
 ('dnws', '东南卫视', '2024061503', '600002484', 'fhd', None),
 ('gzws', '贵州卫视', '2024061603', '600002490', 'fhd', None),
 ('jxws', '江西卫视', '2024061703', '600002503', 'fhd', None),
 ('lnws', '辽宁卫视', '2024171303', '600002505', 'fhd', None),
 ('ahws', '安徽卫视', '2024171403', '600002532', 'fhd', None),
 ('hebws', '河北卫视', '2024171503', '600002493', 'fhd', None),
 ('sdws', '山东卫视', '2029787903', '600002513', 'fhd', None),
 ('tjws', '天津卫视', '2019927003', '600152137', 'fhd', None),
 ('jlws', '吉林卫视', '2025561503', '600190405', 'fhd', None),
 ('saxws', '陕西卫视', '2029795103', '600190400', 'fhd', None),
 ('nxws', '宁夏卫视', '2025608503', '600190737', 'fhd', None),
 ('nmgws', '内蒙古卫视', '2025561203', '600190401', 'fhd', None),
 ('ynws', '云南卫视', '2025561303', '600190402', 'fhd', None),
 ('shanxiws', '山西卫视', '2025560803', '600190407', 'fhd', None),
 ('qhws', '青海卫视', '2025559103', '600190406', 'fhd', None),
 ('xizangws', '西藏卫视', '2025558003', '600190403', 'fhd', None),
 ('xjws', '新疆卫视', '2019927403', '600152138', 'fhd', None),
 ('cetv1', 'CETV-1', '2022823801', '600171827', 'fhd', None),
 ('guoxue', '国学频道', '2029360403', '600213139', 'fhd', None),
]

CHANNEL_MAP = {c[0]: {'slug': c[0], 'name': c[1], 'sid': c[2], 'pid': c[3], 'defn': c[4], 'cast': c[5]} for c in CHANNELS}

# 投屏（设备模拟）频道 -> 央视频 live_id
CAST_LIVE_IDS = {c[0]: c[5] for c in CHANNELS if c[5]}

CAST_SLUG_SUFFIX = '_cast'


def _base_slug(slug):
 return slug[:-len(CAST_SLUG_SUFFIX)] if slug.endswith(CAST_SLUG_SUFFIX) else slug


def _cast_slug(slug):
 return slug + CAST_SLUG_SUFFIX


def _has_cast(slug):
 return bool(CHANNEL_MAP.get(_base_slug(slug), {}).get('cast'))

FORCE_BK = {'cctv11', 'cctv12', 'cctv14', 'cctv15', 'cctv16', 'cctv164k',
 'cctv17', 'cctv4k', 'cctvfyjc', 'cctvdyjc', 'cctvhjjc'}

BACKEND_CHANNELS = {
 'cctv1', 'cctv2', 'cctv3', 'cctv4', 'cctv5', 'cctv5p',
 'cctv7', 'cctv8', 'cctv9', 'cctv10', 'cctv11', 'cctv12',
 'cctv13', 'cctv14', 'cctv15', 'cctv16', 'cctv17',
 'cctv4k', 'cctv8k', 'cctv164k',
 'cgtn', 'cgtnfr', 'cgtnru', 'cgtnar', 'cgtnes', 'cgtndoc',
}

TRUE_4K_CHANNELS = {'cctv4k', 'cctv8k', 'cctv164k'}


def _has_native(slug):
 info = CHANNEL_MAP.get(slug, {})
 return bool(info.get('sid')) and bool(info.get('pid'))


# ================================================================ 台标

LOGO_MIRRORS = [
 'https://cdn.jsdmirror.com/gh/fanmingming/live@main/tv/',
 'https://jsd.onmicrosoft.cn/gh/fanmingming/live@main/tv/',
 'https://gcore.jsdelivr.net/gh/fanmingming/live@main/tv/',
 'https://cdn.jsdelivr.net/gh/fanmingming/live@main/tv/',
 'https://ghproxy.net/https://raw.githubusercontent.com/fanmingming/live/main/tv/',
 'https://live.fanmingming.com/tv/',
]
LOGO_PROBE_FILE = 'CCTV1.png'
LOGO_TIMEOUT = 8
LOGO_MODE = 'auto'

_LOGO_BASE = LOGO_MIRRORS[0]
_LOGO_DONE = threading.Event()
_LOGO_START_LOCK = threading.Lock()
_LOGO_STARTED = False
_LOGO_CACHE = {}
_LOGO_CACHE_LOCK = threading.Lock()

_LOGO_PLACEHOLDER = base64.b64decode(
 'iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII='
)

_LOGO_OVERRIDE = {
 'cctv5p': 'CCTV5+.png', 'cctv4k': 'CCTV4K.png', 'cctv8k': 'CCTV8K.png',
 'cctv164k': 'CCTV16.png',
 'cgtn': 'CGTN.png',
 'cgtnfr': 'CGTN法语.png', 'cgtnru': 'CGTN俄语.png',
 'cgtnar': 'CGTN阿语.png', 'cgtnes': 'CGTN西语.png', 'cgtndoc': 'CGTN纪录.png',
 'cctvfyjc': '风云剧场.png', 'cctvdyjc': '第一剧场.png', 'cctvhjjc': '怀旧剧场.png',
 'cetv1': 'CETV1.png', 'guoxue': '国学.png',
}


def _logo_file(slug, name=''):
 if slug in _LOGO_OVERRIDE: return _LOGO_OVERRIDE[slug]
 m = re.match(r'^cctv(\d+)$', slug)
 if m: return 'CCTV%s.png' % m.group(1)
 if name and slug.endswith('ws'): return name + '.png'
 return ''


def _probe_logo_source():
 global _LOGO_BASE
 try:
  for base in LOGO_MIRRORS:
   try:
    st, head, _ = _http('GET', base + LOGO_PROBE_FILE,
     {'User-Agent': UA, 'Referer': 'https://live.cctv.cn/'}, None, LOGO_TIMEOUT)
    if st >= 200 and st < 300 and head[:4] == b'\x89PNG':
     _LOGO_BASE = base; return
   except Exception: continue
  _LOGO_BASE = ''
 finally: _LOGO_DONE.set()


def _ensure_logo_source(wait=3.0):
 global _LOGO_STARTED
 with _LOGO_START_LOCK:
  if not _LOGO_STARTED:
   _LOGO_STARTED = True
   threading.Thread(target=_probe_logo_source, daemon=True).start()
 _LOGO_DONE.wait(wait)
 return _LOGO_BASE


def _logo_url(slug, name=''):
 # 台标只给 CDN 直连地址；拿不到就返回空，由 Spider._logo 决定要不要走代理兜底
 _ensure_logo_source(wait=0)
 fname = _logo_file(slug, name)
 base = _LOGO_BASE
 if not (base and fname):
  return ''
 return base + urllib.parse.quote(fname)


def _fetch_logo_bytes(slug, name):
 fname = _logo_file(slug, name)
 if fname:
  bases = ([_LOGO_BASE] if _LOGO_BASE else []) + [b for b in LOGO_MIRRORS if b != _LOGO_BASE]
  q = urllib.parse.quote(fname)
  for base in bases:
   try:
    st, data, _ = _http('GET', base + q,
     {'User-Agent': UA, 'Referer': 'https://live.cctv.cn/'}, None, LOGO_TIMEOUT)
    if st >= 200 and st < 300 and data[:4] == b'\x89PNG': return data
   except Exception: continue
 return _LOGO_PLACEHOLDER


# ================================================================ 活流状态

class _ChannelState:
 def __init__(self, slug, name, sid, pid, defn, mode):
  self.slug = slug; self.name = name
  self.sid = sid; self.pid = pid; self.defn = defn
  self.lock = threading.Lock()
  self.segments = {}; self.order = deque(); self.seq = 0
  self.headers = {'User-Agent': UA}
  self.last_access = 0.0; self.thread = None
  self.last_error = ''
  self.mode = mode
  self._starting = False
  self._prefetching = set()  # 正在/已经后台预取的段 key，防止重复回源


CHANNEL_STATE = {}

for c in CHANNELS:
 slug, name, sid, pid, defn, live_id = c[0], c[1], c[2], c[3], c[4], c[5]
 if sid and pid:
  native_mode = 'bk' if slug in FORCE_BK else 'jce'
  CHANNEL_STATE[slug] = _ChannelState(slug, name, sid, pid, defn, native_mode)
 if live_id:
  CHANNEL_STATE[slug + CAST_SLUG_SUFFIX] = _ChannelState(
   slug + CAST_SLUG_SUFFIX, name, '', '', defn, 'cast')


def _seg_key(url, pdt):
 if pdt: return 'pdt:' + pdt
 p = urllib.parse.urlsplit(url)
 return p.scheme + '://' + p.netloc + p.path


def _append_segments(ch, segs):
 with ch.lock:
  for dur, pdt, url in segs:
   key = _seg_key(url, pdt)
   if key in ch.segments:
    ch.segments[key][3] = url
    continue
   ch.seq += 1
   ch.segments[key] = [ch.seq, dur, pdt, url]
   ch.order.append(key)
  while len(ch.order) > MAX_SEGS:
   ch.segments.pop(ch.order.popleft(), None)
  ch.last_error = ''


def _parse_m3u8(text, base_url):
 segs, dur, pdt = [], 6.0, ''
 for line in text.splitlines():
  line = line.strip()
  if line.startswith('#EXTINF:'):
   try: dur = float(line[len('#EXTINF:'):].split(',')[0])
   except ValueError: dur = 6.0
  elif line.startswith('#EXT-X-PROGRAM-DATE-TIME:'):
   pdt = line[len('#EXT-X-PROGRAM-DATE-TIME:'):]
  elif line and not line.startswith('#'):
   segs.append((dur, pdt, urllib.parse.urljoin(base_url, line)))
   pdt = ''
 return segs


def _jce_refresh(ch):
 ch.headers = {'User-Agent': UA}
 now = int(time.time())
 m3u8_url = jce_timeshift_url(ch.pid, ch.sid, now - WINDOW, now, ch.defn)
 st, body, _ = _http('GET', m3u8_url, {'User-Agent': UA}, None, HTTP_TIMEOUT)
 if st < 200 or st >= 300:
  raise RuntimeError('jce playlist HTTP %d' % st)
 text = body.decode('utf-8', 'replace')
 segs = _parse_m3u8(text, m3u8_url)
 if not segs: raise RuntimeError('empty playlist')
 _append_segments(ch, segs)
 return True


def _bk_refresh(ch):
 ch.headers = {'User-Agent': UA, 'Referer': 'https://live.cctv.cn/'}
 last_err = ''
 bk_key = (ch.sid, ch.pid, ch.defn)
 now0 = time.time()
 hit = _BK_URL_CACHE.get(bk_key)
 if hit and now0 - hit[1] < BK_URL_TTL and hit[0]:
  urls0 = list(hit[0])
 else:
  urls0 = None
 # 签名 URL 短时效，过期/风控会回 403；两轮之间重取 bk_playurls 换新签名再试。
 # 总预算 ~15s：播放列表是小文件用 5s 超时；阻塞过久会让刷新线程卡死、
 # 播放列表停止推进，窗口内签名 URL 成批过期(实测阻塞 30s 时下游切片成批 403)
 deadline = time.time() + 15.0
 for round_no in range(2):
  if time.time() >= deadline: break
  try:
   if round_no == 0 and urls0 is not None:
    urls = urls0
   else:
    urls = bk_playurls(ch.sid, ch.pid, ch.defn)
    try:
     _BK_URL_CACHE[bk_key] = (list(urls), time.time())
    except Exception:
     pass
  except Exception as e:
   last_err = '%s: %s' % (type(e).__name__, e)
   try:
    _BK_URL_CACHE.pop(bk_key, None)
   except Exception:
    pass
   continue
  for u in urls:
   if time.time() >= deadline: break
   try:
    hb = {'User-Agent': UA, 'Referer': 'https://live.cctv.cn/',
     'Accept': 'application/vnd.apple.mpegurl,application/json,*/*'}
    st, body, _ = _http('GET', u, hb, None, 5)
    if st < 200 or st >= 300:
     raise RuntimeError('bk playlist HTTP %d' % st)
    text = body.decode('utf-8', 'replace'); final = u
    lines = text.splitlines()
    for i, ln in enumerate(lines):
     if ln.strip().startswith('#EXT-X-STREAM-INF'):
      for j in range(i + 1, len(lines)):
       s = lines[j].strip()
       if s and not s.startswith('#'):
        sub = urllib.parse.urljoin(final, s)
        st2, body2, _ = _http('GET', sub, {'User-Agent': UA}, None, 5)
        if st2 < 200 or st2 >= 300:
         raise RuntimeError('bk variant HTTP %d' % st2)
        text = body2.decode('utf-8', 'replace'); final = sub
        break
      break
    segs = _parse_m3u8(text, final)
    if segs:
     _append_segments(ch, segs)
     return True
   except Exception as e:
    last_err = '%s: %s' % (type(e).__name__, e); continue
 raise RuntimeError(last_err or 'bk playlist failed')


def _refresh_native(ch):
 if ch.mode == 'bk':
  try: return _bk_refresh(ch)
  except Exception as e:
   # FORCE_BK 频道的 jce CDN 已确认是死链（DeadHostError），
   # 再 fallback 只会白等 jce 超时后抛错，把单次 refresh 拖到 15s+
   if ch.slug in FORCE_BK: raise
   _log('%s bk failed (%s), fallback jce' % (ch.slug, e))
   ch.mode = 'jce'
   return _jce_refresh(ch)
 try:
  return _jce_refresh(ch)
 except DeadHostError:
  ch.mode = 'bk'
  return _bk_refresh(ch)


def _cast_fetch(url, headers):
 """投屏流走自带 urllib 客户端：签名头必须原样带出去，容器 fetch 会丢。"""
 status, body, _ = _cast_client().get(url, headers)
 if status < 200 or status >= 300:
  raise RuntimeError('cast HTTP %d' % status)
 return body.decode('utf-8', 'replace')


def _pick_variant(text, final, headers):
 """m3u8 是主列表时，挑第一条子流再拉一次。"""
 lines = text.splitlines()
 for i, ln in enumerate(lines):
  if ln.strip().startswith('#EXT-X-STREAM-INF'):
   for j in range(i + 1, len(lines)):
    s = lines[j].strip()
    if s and not s.startswith('#'):
     sub = urllib.parse.urljoin(final, s)
     return _cast_fetch(sub, headers), sub
   break
 return text, final


def _cast_refresh(ch):
 """源2：设备投屏（模拟电视接收端，签名换高码流）。"""
 base = _base_slug(ch.slug)
 try:
  if CAST.zap_debounced(base):
   _log('[%s] 换台防抖: 先出1080p, 停留后自动升码率' % base)
 except Exception:
  pass
 entry = CAST.resolve(base)
 headers = dict(entry.playback_headers or {})
 if not headers:
  headers = _default_playback_headers(entry.android_id)
 ch.headers = headers
 text = _cast_fetch(entry.final_url, headers)
 text, final = _pick_variant(text, entry.final_url, headers)
 segs = _parse_m3u8(text, final)
 if not segs:
  raise RuntimeError('cast empty playlist')
 _append_segments(ch, segs)
 return True


_PREFETCH_COUNT = 28  # 预取上限：覆盖整个播放窗口(16) + 余量
_PREFETCH_DELAY = 0.12  # 预取间隔，避免瞬间打爆 CDN 触发风控


def _prefetch_segments(ch):
 """后台预下载切片：按播放器消费顺序(最旧在前)补齐缓存，网络抖动不再传导成 503 断流。"""
 holdback = 1
 with ch.lock:
  keys = [k for k in ch.order if k in ch.segments]
  # 播放列表尾部 holdback 片未落地不预取，从最旧的开始补（播放器先请求最旧端）
  keys = keys[:-holdback] if holdback and len(keys) > holdback + 1 else keys
  todo = []
  for k in keys:
   if len(todo) >= _PREFETCH_COUNT:
    break
   url = ch.segments[k][3]
   if TS_CACHE.get(url) is not None or k in ch._prefetching:
    continue
   ch._prefetching.add(k)
   todo.append((k, url, dict(ch.headers or {'User-Agent': UA})))
 if not todo:
  return

 def pull(k, url, headers):
  try:
   if ch.mode == 'cast':
    status, body, _ = _cast_client().get(url, headers)
   else:
    status, body, _ = _http('GET', url, headers, None, 12)
   if 200 <= status < 300 and body:
    TS_CACHE.put(url, body)
  except Exception:
   pass
  finally:
   with ch.lock:
    ch._prefetching.discard(k)

 def dispatch():
  # 3 线程并行：串行 12 片 ≈ 7s，慢于 2s 刷新间隔会漏预取最新段
  for i in range(0, len(todo), 3):
   batch = todo[i:i + 3]
   threads = [threading.Thread(target=pull, args=item, daemon=True) for item in batch]
   for t in threads:
    t.start()
   for t in threads:
    t.join(timeout=13)
   time.sleep(_PREFETCH_DELAY)
 threading.Thread(target=dispatch, daemon=True).start()


def _refresh_once(ch):
 t0 = time.time()
 try:
  ok = _cast_refresh(ch) if ch.mode == 'cast' else _refresh_native(ch)
  _log('refresh %s: ok=%s %.2fs segs=%d'
   % (ch.slug, ok, time.time() - t0, len(ch.order)))
  return ok
 except Exception as e:
  ch.last_error = ('%s: %s' % (type(e).__name__, e))[:120]
  _log('refresh %s: FAIL %.2fs %s'
   % (ch.slug, time.time() - t0, ch.last_error))
  return False
 finally:
  # v9.0 stale-while-refresh：无论刷新成败都预取已在窗口中的段。
  # 刷新停摆(上游403/DNS 408)期间，播放器请求直接命中本地缓存，不回源、不 403，
  # 停摆只影响"窗口不再推进"，不影响"已有段可播"——这是卡顿转不卡的关键
  if TS_CACHE.enabled():
   _prefetch_segments(ch)


def _refresh_loop(ch):
 fails = 0
 while time.time() - ch.last_access < IDLE_TIMEOUT:
  ok = _refresh_once(ch)
  fails = 0 if ok else fails + 1
  time.sleep(REFRESH_INTERVAL if fails < 3 else 5)  # v9.0 失败冷却 5s，快速重试换线路/签名


def _ensure_channel(ch):
 ch.last_access = time.time()
 with ch.lock:
  if ch._starting: return
  need_fetch = not ch.segments
  need_thread = ch.thread is None or not ch.thread.is_alive()
  if need_fetch or need_thread: ch._starting = True
  else: return
 try:
  if need_fetch: _refresh_once(ch)
  if need_thread:
   ch.thread = threading.Thread(target=_refresh_loop, args=(ch,), daemon=True)
   ch.thread.start()
 finally:
  with ch.lock: ch._starting = False


class _Resp(object):

 __slots__ = ("status", "content", "headers")

 def __init__(self, status, content, headers):
  self.status = status
  self.content = content
  self.headers = headers


def _gunzip(content, headers):
 if not content:
  return content
 encoding = ""
 for key, value in (headers or {}).items():
  if str(key).lower() == "content-encoding":
   encoding = str(value).lower()
 if content[:2] == b"\x1f\x8b" or "gzip" in encoding:
  try:
   return gzip.decompress(content)
  except (OSError, ValueError, EOFError):
   return content
 return content


class _Net(object):
 """容器无关的网络层。

    GET 优先借容器的 self.fetch()，POST 和一切失败情形回落到 urllib；
    内置 Python 常缺 CA 证书，SSL 校验失败时自动降级重试一次。
    """

 def __init__(self):
  self.spider = None
  self.fetch_broken = False

 def bind(self, spider):
  self.spider = spider

 # ---- 容器 fetch ----
 def _via_fetch(self, url, headers, timeout):
  if self.spider is None or self.fetch_broken or DIRECT:
   return None
  fn = getattr(self.spider, "fetch", None)
  if not callable(fn):
   return None
  try:
   response = fn(url, headers=headers, timeout=timeout)
  except TypeError:
   try:
    response = fn(url, headers=headers)
   except Exception:
    return None
  except Exception:
   return None
  if response is None:
   return None
  if isinstance(response, str):
   return _Resp(200, response.encode("utf-8"), {})
  if isinstance(response, dict):
   body = response.get("content")
   if body is None:
    body = response.get("body")
   if body is None:
    body = response.get("text") or ""
   if isinstance(body, str):
    body = body.encode("utf-8")
   return _Resp(int(response.get("code") or response.get("status") or 200),
    bytes(body), response.get("headers") or {})
  status = getattr(response, "status_code", None)
  if status is None:
   status = getattr(response, "status", None)
  if status is None:
   self.fetch_broken = True
   return None
  content = getattr(response, "content", None)
  if content is None:
   content = (getattr(response, "text", "") or "").encode("utf-8")
  raw = getattr(response, "headers", None) or {}
  try:
   raw = dict(raw)
  except (TypeError, ValueError):
   raw = {}
  return _Resp(int(status), bytes(content), raw)

 # ---- urllib ----
 def _via_urllib(self, method, url, headers, body, timeout, unverified):
  request = urllib.request.Request(url, data=body, headers=headers or {}, method=method)
  context = ssl.create_default_context()
  if unverified:
   context.check_hostname = False
   context.verify_mode = ssl.CERT_NONE
  with urllib.request.urlopen(request, timeout=timeout, context=context) as stream:
   return _Resp(stream.status, stream.read(), dict(stream.headers))

 @staticmethod
 def _http_error(error):
  body = b""
  try:
   body = error.read()
  except Exception:
   pass
  headers = {}
  try:
   headers = dict(error.headers or {})
  except (TypeError, ValueError):
   headers = {}
  return error.code, _gunzip(body, headers), headers

 def request(self, method, url, headers=None, body=None, timeout=15):
  headers = dict(headers or {})
  headers.setdefault("User-Agent", UA)
  if "Accept-Encoding" not in headers:
   headers["Accept-Encoding"] = "identity"
  if method == "GET" and body is None:
   try:
    response = self._via_fetch(url, headers, timeout)
   except Exception:
    response = None
   if response is not None:
    return response.status, _gunzip(response.content, response.headers), response.headers
  try:
   response = self._via_urllib(method, url, headers, body, timeout, False)
   return response.status, _gunzip(response.content, response.headers), response.headers
  except urllib.error.HTTPError as error:
   return self._http_error(error)
  except ssl.SSLError:
   try:
    response = self._via_urllib(method, url, headers, body, timeout, True)
    return response.status, _gunzip(response.content, response.headers), response.headers
   except urllib.error.HTTPError as error:
    return self._http_error(error)
   except Exception as error:
    return 599, ("%s(SSL降级): %s" % (type(error).__name__, error)).encode("utf-8"), {}
  except Exception as error:
   return 599, ("%s: %s" % (type(error).__name__, error)).encode("utf-8"), {}


DIRECT = False
_NET = _Net()


def _http(method, url, headers=None, body=None, timeout=15):
 """统一 HTTP 出口，返回 (status, bytes, headers)。"""
 return _NET.request(method, url, headers, body, timeout)


def _one(value):
 """localProxy 的参数值可能是 str 或 list，统一取第一个。"""
 if isinstance(value, (list, tuple)):
  value = value[0] if value else ""
 return "" if value is None else str(value)


def _safe(value):
 """M3U 属性里不能出现双引号。"""
 return str(value).replace('"', "'")


# ================================================================ 分类 / EPG

GROUP_NAMES = {
 "cctv": "央视频道", "satellite": "卫视频道", "cgtn": "CGTN",
 "4k": "4K超清", "premium": "付费剧场", "other": "其他",
}

EPG_XML_URL = "https://epg.112114.xyz/pp.xml"

# tvg-id 默认按主流 XMLTV 源（fanmingming / 112114）的习惯命名
EPG_IDS = {
 "cctv5p": "CCTV5+", "cctv4k": "CCTV4K", "cctv8k": "CCTV8K",
 "cctv164k": "CCTV16",
 "cgtn": "CGTN",
 "cgtnfr": "CGTN法语", "cgtnru": "CGTN俄语",
 "cgtnar": "CGTN阿语", "cgtnes": "CGTN西语", "cgtndoc": "CGTN纪录",
 "cctvfyjc": "风云剧场", "cctvdyjc": "第一剧场", "cctvhjjc": "怀旧剧场",
 "cetv1": "CETV1", "guoxue": "国学",
}


def _epg_id(slug, name=""):
 if slug in EPG_IDS:
  return EPG_IDS[slug]
 matched = re.match(r"^cctv(\d+)$", slug)
 if matched:
  return "CCTV%s" % matched.group(1)
 return name or slug


def _classify(slug):
 cats = []
 if (re.match(r"^cctv\d+$", slug) or slug == "cctv5p") and slug not in TRUE_4K_CHANNELS:
  cats.append("cctv")
 if slug in TRUE_4K_CHANNELS:
  cats.append("4k")
 if slug in ("cctvfyjc", "cctvdyjc", "cctvhjjc"):
  cats.append("premium")
 if slug.endswith("ws") or slug == "cetv1":
  cats.append("satellite")
 if slug.startswith("cgtn"):
  cats.append("cgtn")
 if slug == "guoxue":
  cats.append("other")
 return cats


def _group_name(slug):
 cats = _classify(slug)
 return GROUP_NAMES.get(cats[0], "其他") if cats else "其他"


CAST_GROUP_NAME = '央视高码'


def _entries(tid='all'):
 """点播列表与直播 M3U 的唯一频道来源，两边都从这里取，保证一致。

    返回 [{slug, name, group, epg, cast}]；cast 条目的 epg 指向原生 slug，
    这样投屏线路和原线路在节目单里是同一个台。
    """
 out = []
 for row in CHANNELS:
  slug, name, live_id = row[0], row[1], row[5]
  if tid == 'cast':
   if live_id:
    out.append({'slug': _cast_slug(slug), 'name': name,
     'group': CAST_GROUP_NAME, 'epg': slug, 'cast': True})
   continue
  if tid in ('', 'all') or tid in _classify(slug):
   out.append({'slug': slug, 'name': name,
    'group': _group_name(slug), 'epg': '', 'cast': False})
 return out


def _live_entries(include_cast=True):
 """直播 M3U 用的总表 = 点播「全部频道」+ 点播「央视高码」分类。"""
 out = list(_entries('all'))
 if include_cast:
  out += _entries('cast')
 return out


def _upstream_url(ch):
 """拿到官方可直接播放的 m3u8 地址（不改切片、不经过代理）。

    bk 优先取回源列表第一条，取不到再试 JCE；两个都失败返回空，由调用方退回代理滚动缓冲。
    投屏源只有不需要签名头的节点才能 302，否则播放器直连会丢头，退回代理。
    """
 if ch.mode == 'cast':
  try:
   entry = CAST.resolve(_base_slug(ch.slug))
  except Exception as error:
   _log('%s cast upstream failed: %s' % (ch.slug, error))
   return ''
  if not entry.final_url:
   return ''
  if _needs_signed_headers(entry.final_host or _url_host(entry.final_url)):
   return ''
  return entry.final_url
 if not (ch.sid and ch.pid):
  return ''
 now = int(time.time())
 for mode in (('bk', 'jce') if ch.mode == 'bk' else ('jce', 'bk')):
  try:
   if mode == 'bk':
    urls = bk_playurls(ch.sid, ch.pid, ch.defn)
    for u in urls:
     if u:
      return u
   else:
    return jce_timeshift_url(ch.pid, ch.sid, now - WINDOW, now, ch.defn)
  except Exception as error:
   _log('%s upstream %s failed: %s' % (ch.slug, mode, error))
 return ''


class _TsCache(object):
 """切片 LRU 缓存：代理被反复拖同一个 ts 时省一次回源。"""

 def __init__(self, max_mb=0):
  self.max_bytes = int(max(0.0, float(max_mb)) * 1024 * 1024)
  self.data = {}
  self.order = deque()
  self.size = 0
  self.lock = threading.Lock()

 def configure(self, max_mb):
  with self.lock:
   self.max_bytes = int(max(0.0, float(max_mb)) * 1024 * 1024)
   while self.size > self.max_bytes and self.order:
    k = self.order.popleft()
    b = self.data.pop(k, None)
    if b is not None:
     self.size -= len(b)

 def enabled(self):
  return self.max_bytes > 0

 def get(self, key):
  if not self.max_bytes:
   return None
  with self.lock:
   return self.data.get(key)

 def put(self, key, body):
  if not self.max_bytes or not body:
   return
  with self.lock:
   if key in self.data or len(body) > self.max_bytes:
    return
   self.data[key] = body
   self.order.append(key)
   self.size += len(body)
   while self.size > self.max_bytes and self.order:
    k = self.order.popleft()
    b = self.data.pop(k, None)
    if b is not None:
     self.size -= len(b)


TS_CACHE = _TsCache(200)  # v9.4对齐：默认200MB，覆盖4K/8K窗口，0=关闭


def _start_channel(ch):
 """后台起刷新线程，立刻返回，不阻塞当前请求。"""
 ch.last_access = time.time()
 thread = threading.Thread(target=_ensure_channel, args=(ch,), daemon=True)
 thread.start()
 return thread


# ================================================================ Spider

class Spider(SpiderBase):

 def __init__(self):
  try:
   super(Spider, self).__init__()
  except Exception:
   pass
  self.brandActor = "📺 央视频直播"
  self.brandDirector = "ysp-live-multi"
  self.epg_xml = EPG_XML_URL
  self.epg_ids = {}
  self.logo_mode = "direct"
  self.wait = 12.0
  self.cast_wait = 20.0
  self.holdback = 1
  self.cast_entries = False
  self.live_mode = "proxy"

 # ---------------- 生命周期 ----------------
 def getName(self):
  return "央视频"

 def getDependence(self):
  # 单源版只用标准库（urllib / struct / gzip），不依赖 pycryptodome、cryptography
  return []

 def init(self, extend=""):
  global DIRECT
  opts = {}
  if isinstance(extend, dict):
   opts = extend
  elif isinstance(extend, str) and extend.strip().startswith("{"):
   try:
    opts = json.loads(extend)
   except ValueError:
    opts = {}
  self.epg_xml = str(opts.get("epg_xml", EPG_XML_URL) or "")
  if isinstance(opts.get("epg_ids"), dict):
   self.epg_ids = {str(k): str(v) for k, v in opts["epg_ids"].items()}
  self.logo_mode = str(opts.get("logo_mode") or "direct").lower()
  self.live_mode = str(opts.get("live_mode") or "proxy").lower()
  # 直播列表由点播列表生成，投屏分类在点播里默认就在，这里默认同样带上，保持一致
  self.cast_entries = bool(opts.get("cast_entries", True))
  DIRECT = bool(opts.get("direct", False))
  try:
   self.wait = max(3.0, float(opts.get("wait") or 12))
  except (TypeError, ValueError):
   self.wait = 12.0
  try:
   self.cast_wait = max(3.0, float(opts.get("cast_wait") or 20))
  except (TypeError, ValueError):
   self.cast_wait = 20.0
  try:
   self.holdback = max(0, int(opts.get("holdback") or 1))
  except (TypeError, ValueError):
   self.holdback = 1
  # v9.0 原理：TsSegmentCache(max_mb=200)，4K/8K 高码段(8-12Mbps)默认 64MB 只够约 45 秒，
  # 200MB 可覆盖约 2-3 分钟时移窗口，配合预取把网络抖动消化在代理侧
  try:
   TS_CACHE.configure(float(opts.get("ts_cache_mb", 200)))
  except (TypeError, ValueError):
   TS_CACHE.configure(200)
  # 投屏只在这里读配置、建客户端，不联网；会话等真正点开投屏频道再建
  try:
   CAST.configure(opts)
  except Exception as error:
   _log('cast configure failed: %s' % error)
  _NET.bind(self)
  try:
   _ensure_logo_source(wait=0)
  except Exception:
   pass
  return True

 def destroy(self):
  for ch in CHANNEL_STATE.values():
   ch.last_access = 0.0

 def isVideoFormat(self, url):
  return True

 def manualVideoCheck(self):
  return False

 def action(self, action):
  # 部分壳（TVBox/fongmi/OK影视）初始化时会调用 action，返回 dict 即可
  return {}

 # ---------------- 入口 ----------------
 def homeContent(self, filter=None):
  classes = [{"type_id": "all", "type_name": "全部频道"}]
  for key, name in (("cctv", "央视频道"), ("satellite", "卫视频道"),
   ("cgtn", "CGTN"), ("4k", "4K超清"),
   ("premium", "付费剧场"), ("other", "其他"),
   ("cast", "央视高码")):
   classes.append({"type_id": key, "type_name": name})
  return {"class": classes, "filters": {}, "list": self._cards("all")}

 def homeVideoContent(self):
  return {"list": self._cards("all")}

 def categoryContent(self, tid, pg, filter, extend):
  if tid == "cast":
   self._ensure_cast_ready()
  cards = self._cards(tid or "all")
  return {"page": 1, "pagecount": 1, "limit": len(cards), "total": len(cards), "list": cards}

 def detailContent(self, ids):
  raw = ids[0] if isinstance(ids, (list, tuple)) else ids
  slug = _one(raw).strip()
  base = _base_slug(slug)
  info = CHANNEL_MAP.get(base)
  if not info:
   return {"list": []}
  # 投屏是独立分类、独立一路，不再挂成央视频的备选线路2：
  # 一个 slug 只出一条线路，slug 带 _cast 就只出投屏，否则只出原生源。
  is_cast = slug != base
  if is_cast and not info.get("cast"):
   return {"list": []}
  if is_cast:
   self._ensure_cast_ready()
   play_from = CAST_GROUP_NAME
   play_url = "高码率(投屏)$%s" % slug
   desc = "【📺 央视高码】\n频道: %s\n线路: 设备投屏(高码率)\n" \
                   "独立分类，不与央视频源混用" % info["name"]
  else:
   play_from = "央视频源1"
   play_url = "超清$%s" % base
   desc = "【📺 央视频直播】\n频道: %s\n线路: JCE/bk 原生源" % info["name"]
  self._warm(slug)
  desc = desc.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
  return {"list": [{
   "vod_id": slug, "vod_name": info["name"],
   "vod_pic": self._logo(base, info["name"]),
   "vod_actor": self.brandActor, "vod_director": self.brandDirector,
   "vod_remarks": format_remarks("央视高码" if is_cast else "央视频", "直播"),
   "vod_content": desc,
   "vod_play_from": play_from,
   "vod_play_url": play_url,
  }]}

 def searchContent(self, key, quick, pg="1"):
  keyword = (key or "").strip().lower()
  cards = []
  if keyword:
   for slug, name, _s, _p, _d, _c in CHANNELS:
    if keyword in name.lower() or keyword in slug.lower():
     cards.append(self._card(slug, name))
  return {"page": 1, "pagecount": 1, "limit": len(cards), "total": len(cards), "list": cards}

 def playerContent(self, flag, id, vipFlags):
  slug = _one(id).strip()
  if slug.startswith("http://") or slug.startswith("https://"):
   # 外部 m3u8 直链：挂到本代理 type=m3u8 分支，由 _ext_media 展开主表、
   # 把段/密钥 URI 改写为绝对代理地址——否则相对路径(如 ../key、/hls_key/)
   # 会以 127.0.0.1 本地代理为基准解析请求不存在的路由，ExoPlayer 404 断流
   # position 字段已按需求移除：不再由 spider 覆盖历史进度，恢复行为交回壳端
   return {"parse": 0, "playUrl": "",
    "url": self._purl(type="m3u8", url=slug),
    "header": {"User-Agent": UA, "Referer": "https://live.cctv.cn/"},
    "format": "application/x-mpegURL"}
  ch = CHANNEL_STATE.get(slug)
  if ch is None:
   return {"parse": 0, "playUrl": "", "url": "", "header": {}}
  self._warm(slug)
  header = {"User-Agent": UA, "Referer": "https://live.cctv.cn/"}
  if ch.mode == "cast":
   header = dict(ch.headers or header)
   if self.live_mode == "redirect" and _upstream_url(ch):
    # 直连会丢签名头，只有无需签名的 CDN 才走 302
    pass
  return {
   "parse": 0, "playUrl": "",
   # 自有频道入口也带 type=m3u8 标记：壳/日志可识别该流走本代理 m3u8 链路；
   # _localProxyRaw 中 type=m3u8+slug 组合继续走滚动直播播放列表分支
   "url": self._purl(type="m3u8", slug=slug),
   "header": header,
  }

 # ---------------- 直播源 M3U ----------------
 def liveContent(self, url=""):
  if self.epg_xml:
   lines = ['#EXTM3U tvg-url="%s" x-tvg-url="%s"' % (self.epg_xml, self.epg_xml)]
  else:
   lines = ["#EXTM3U"]
  # 直播列表直接由点播列表生成：点播「全部频道」+ 点播「央视高码」分类，
  # 两边共用 _entries()，频道集合、顺序、分组永远一致。
  for item in _live_entries(self.cast_entries):
   slug, name = item['slug'], item['name']
   if item['cast']:
    name = name + " (投屏)"
   lines.append(self._m3u_entry(slug, name, item['epg'], item['group']))
   lines.append(self._play_url(slug))
  return "\n".join(lines) + "\n"

 def _play_url(self, slug):
  if self.live_mode == "redirect":
   return self._purl(slug=slug, mode="redirect")
  return self._purl(slug=slug)

 def _m3u_entry(self, slug, name, epg_slug="", group=""):
  base = _base_slug(slug)
  source = epg_slug or base
  tvg = _safe(self.epg_ids.get(source) or _epg_id(source, name))
  return '#EXTINF:-1 tvg-id="%s" tvg-name="%s" tvg-logo="%s" group-title="%s",%s' % (
   tvg, tvg, self._logo(base, name),
   _safe(group or _group_name(base)), _safe(name))

 # ---------------- 本地代理（取代本地 HTTP 服务） ----------------
 def localProxy(self, param):
  # 统一走 raw 实现，再收敛成壳端认识的状态码，避免 Status null 闪退
  return _proxy_safe(self._localProxyRaw(param))

 def _localProxyRaw(self, param):
  try:
   # 部分壳传 JSON 字符串而非 dict，先归一化
   if isinstance(param, str):
    try:
     param = json.loads(param)
    except ValueError:
     param = {}
   if not isinstance(param, dict):
    param = {}
   query = {}
   for key, value in param.items():
    query[str(key)] = _one(value)
   kind = query.get("type", "")
   if kind == "diag":
    return [200, "text/plain; charset=utf-8",
     self._diag(query.get("slug"), query.get("mode"))]
   if kind == "logo":
    return self._logo_bytes(query.get("slug", ""))
   if kind in ("m3u8", "ts") and (kind == "ts" or not (query.get("slug") or query.get("id"))):
    # 外部/点播 m3u8 代理：m3u8 拉回上游并把段/密钥地址改写成代理地址，
    # 段用 type=ts 二进制回传——否则播放器会把 m3u8 内的相对路径
    # 以 127.0.0.1 本地代理为基准解析，请求不存在的路由直接 404 断流。
    # type=m3u8 且带 slug 时不进此分支：那是自有频道入口（type=m3u8&slug=...），
    # 继续往下走滚动直播播放列表，段 URL 已是绝对代理地址无需改写
    return self._ext_media(kind, query)
   slug = query.get("slug") or query.get("id") or ""
   ch = CHANNEL_STATE.get(slug)
   if ch is None:
    return [404, "text/plain; charset=utf-8", "央视频: 未知频道 " + slug]
   if query.get("seq"):
    return self._chunk(ch, query["seq"])
   want_redirect = self.live_mode == "redirect"
   if query.get("mode") == "redirect":
    want_redirect = True
   elif query.get("mode") == "proxy":
    want_redirect = False
   if want_redirect:
    direct = _upstream_url(ch)
    if direct:
     return [302, "text/plain", "",
      {"Location": direct, "Cache-Control": "no-store"}]
   return self._playlist(ch)
  except Exception as error:
   return [500, "text/plain; charset=utf-8",
    "央视频: %s: %s" % (type(error).__name__, error)]

 def _ext_media(self, kind, query):
  """type=m3u8/ts：代理外部 m3u8 与其 .ts/.key 段。

     m3u8 分支把相对段地址、#EXT-X-KEY 等 URI= 改写为本代理地址（type=ts），
     否则播放器会以 127.0.0.1 本地代理为基准解析相对路径请求不存在的路由；
     ts 分支原样二进制回传段数据（识别 0x47 同步字节给 video/mp2t）。
    """
  url = urllib.parse.unquote(query.get("url") or "").replace("\\/", "/").strip()
  if url.startswith("//"):
   url = "https:" + url
  if not url.startswith("http"):
   return [400, "text/plain; charset=utf-8", "央视频: 缺少 url 参数"]
  referer = urllib.parse.unquote(query.get("referer") or query.get("ref") or "").strip()
  if not referer.startswith("http"):
   referer = ""
  headers = {"User-Agent": UA, "Accept": "*/*"}
  if referer:
   headers["Referer"] = referer
  if kind == "ts":
   try:
    status, body, _ = _http("GET", url, headers, None, 20)
   except Exception as error:
    return [503, "text/plain; charset=utf-8",
     "央视频: 段暂时错误 %s" % type(error).__name__]
   if status == 599 or status >= 500 or status in (408, 425, 429):
   # 网络类失败可恢复：回 503 让播放器退避重试，不断流
    return [503, "text/plain; charset=utf-8",
     "央视频: 段暂时不可用 HTTP %d" % status]
   if status < 200 or status >= 300 or not body:
    return [503, "text/plain; charset=utf-8", "央视频: 段 HTTP %d" % status]
   mime = "video/mp2t" if body[:1] == b"\x47" else "application/octet-stream"
   return [200, mime, body, {"Cache-Control": "no-cache, no-store"}]
  # kind == "m3u8"：拉上游 m3u8（主表先展开到媒体表）再改写
  try:
   status, raw, _ = _http("GET", url, headers, None, 12)
  except Exception as error:
   return [503, "text/plain; charset=utf-8",
    "央视频: m3u8 暂时错误 %s" % type(error).__name__]
  if status != 200 or not raw:
   return [503, "text/plain; charset=utf-8", "央视频: m3u8 HTTP %d" % status]
  text = raw.decode("utf-8", "replace")
  if "#EXT-X-STREAM-INF" in text:
   # 主表：取第一条子流再拉一次（子流地址同样以本 m3u8 为基准）
   sub = ""
   lines = text.splitlines()
   for i, line in enumerate(lines):
    if line.strip().startswith("#EXT-X-STREAM-INF"):
     for nxt in lines[i + 1:]:
      s = nxt.strip()
      if s and not s.startswith("#"):
       sub = s
       break
     break
   if sub:
    sub_url = sub if sub.startswith("http") else urllib.parse.urljoin(url, sub)
    try:
     st2, raw2, _ = _http("GET", sub_url, headers, None, 12)
     if st2 == 200 and raw2:
     # 子流的相对段要以子流地址为基准，后续改写统一用 sub_url
      url, text = sub_url, raw2.decode("utf-8", "replace")
    except Exception:
     pass
  return [200, "application/vnd.apple.mpegurl",
   self._rewrite_ext_m3u8(text, url, referer),
   {"Cache-Control": "no-cache, no-store"}]

 def _rewrite_ext_m3u8(self, text, base, referer=""):
  """把 m3u8 内的段/子表/密钥 URI 改写成本代理地址（type=ts）。

     根路径开头的拼站点域名、非 http 开头的以 base 相对解析、http 开头原样。
    """
  root = self.getProxyUrl() or ""
  if not root:
   # 拿不到代理根地址时保持原样（本地直跑/老版本壳），交由直连兜底
   return text if text.endswith("\n") else text + "\n"
  sep = "&" if "?" in root else "?"

  def _to_abs(value):
   if value.startswith("http"):
    return value
   if value.startswith("//"):
    return "https:" + value
   if value.startswith("/"):
    parts = urllib.parse.urlsplit(base)
    return "%s://%s%s" % (parts.scheme, parts.netloc, value)
   return urllib.parse.urljoin(base, value)

  def _proxy(value, kind):
   out = "%s%stype=%s&url=%s" % (root, sep, kind,
    urllib.parse.quote(_to_abs(value), safe=""))
   if referer:
    out += "&referer=" + urllib.parse.quote(referer, safe="")
   return out

  out = []
  for raw in text.replace("\r\n", "\n").replace("\r", "\n").split("\n"):
   line = raw.strip()
   if not line:
    out.append("")
   elif line.startswith("#"):
    # URI="..."：EXT-X-KEY/EXT-X-MAP/子表等，走 media 级改写（.ts/.key 二进制）
    if "URI=" in line:
     line = re.sub(r'(URI=")([^"]+)(")',
      lambda m: m.group(1) + _proxy(m.group(2), "ts") + m.group(3), line)
    out.append(line)
   elif line.startswith("#EXT-X-ENDLIST") or line.startswith("#EXTM3U"):
    out.append(line)
   else:
    out.append(_proxy(line, "ts"))
  body = "\n".join(out)
  return body if body.endswith("\n") else body + "\n"

 def _playlist(self, ch):
  """返回滚动播放列表。

        直播没有详情页可以预热，所以这里不再同步等握手：后台起刷新线程，
        最多等 self.wait 秒拿到首帧后就吐出滚动窗口（取不到就等代理线程补上）。
        """
  ch.last_access = time.time()
  candidates = [ch]
  with ch.lock:
   ready = bool(ch.order)
  if not ready:
   _start_channel(ch)
  timeout = self.cast_wait if ch.mode == "cast" else self.wait
  owner = self._first_ready(candidates, timeout)
  if owner is None:
   detail = " | ".join("%s:%s" % (c.slug, c.last_error or "超时")
    for c in candidates)
   return [503, "text/plain; charset=utf-8", "央视频: 暂无数据 " + detail]
  return self._render(owner)

 def _first_ready(self, channels, timeout):
  deadline = time.time() + timeout
  while time.time() < deadline:
   for ch in channels:
    with ch.lock:
     if ch.order:
      return ch
   time.sleep(0.15)
  for ch in channels:
   with ch.lock:
    if ch.order:
     return ch
  return None

 def _render(self, ch):
  holdback = max(0, int(getattr(self, "holdback", 1)))
  with ch.lock:
   keys = list(ch.order)
   segs = [ch.segments[k] for k in keys if k in ch.segments]
   # 尾部保留 holdback 个切片：刚抓到的那片可能还没落地，播到会卡一下
   if holdback and len(segs) > holdback + 1:
    window = segs[-(PLAYLIST_WINDOW + holdback):-holdback]
   else:
    window = segs[-PLAYLIST_WINDOW:] if segs else []
  if not window:
   return [503, "text/plain; charset=utf-8",
    "央视频: 暂无数据 %s" % (ch.last_error or "抓取中")]
  ch.last_access = time.time()
  target = max(6, int(max(seg[1] for seg in window) + 0.5))
  out = ["#EXTM3U", "#EXT-X-VERSION:3",
   "#EXT-X-TARGETDURATION:%d" % target,
   "#EXT-X-MEDIA-SEQUENCE:%d" % window[0][0],
   "#EXT-X-DISCONTINUITY-SEQUENCE:0",
   "#EXT-X-START:TIME-OFFSET=-15.0"]
  for seq, dur, pdt, _url in window:
   if pdt:
    out.append("#EXT-X-PROGRAM-DATE-TIME:" + pdt)
   out.append("#EXTINF:%.3f," % dur)
   out.append(self._purl(slug=ch.slug, seq=seq))
  return [200, "application/vnd.apple.mpegurl", "\n".join(out) + "\n",
   {"Cache-Control": "no-cache, no-store"}]

 def _chunk(self, ch, raw_seq):
  try:
   seq = int(raw_seq)
  except (TypeError, ValueError):
   return [400, "text/plain; charset=utf-8", "央视频: bad seq"]
  ch.last_access = time.time()
  key = None
  with ch.lock:
   url = None
   for k in ch.order:
    seg = ch.segments.get(k)
    if seg and seg[0] == seq:
     key, url = k, seg[3]
     break
  if not url:
   # 段已被踢出或超出窗口(含 403 签名失效踢段)：回 503 让播放器重读播放列表
   _log('chunk miss slug=%s seq=%s' % (ch.slug, seq))
   return [503, "text/plain; charset=utf-8", "央视频: 切片已过期"]

  def _drop_dead_segment():
   # 仅确认死链(403/404/410)才踢出窗口；网络抖动不踢，否则重试时 seq 已消失、
   # 永远取不到数据，退避耗尽后播放器直接 Source error 断流
   with ch.lock:
    if key in ch.segments and key in ch.order:
     ch.order.remove(key)
     ch.segments.pop(key, None)

  cached = TS_CACHE.get(url)
  if cached is not None:
   return [200, "video/mp2t", cached, {"Cache-Control": "no-cache, no-store"}]
  headers = ch.headers or {"User-Agent": UA}
  # 缓存未命中（预取没赶上）时，代理侧先做指数退避重试：真机 DNS 抖动可达 10s+，
  # 403(CDN 风控/签名过期)实测需数秒才恢复。直接 503 会耗光播放器重试预算导致
  # Source error 断流；重试总预算 ~6s(4 次 × 8s 超时上限)，仍留给播放器退避空间
  status, body = 599, b""
  for attempt in range(4):
   if attempt:
    time.sleep(min(0.5 * (2 ** (attempt - 1)), 2.5))  # 0.5 / 1 / 2s
    # 重读段 URL：刷新线程 _append_segments 对已存在 key 只原地换新签名 URL、
    # 不改 seq，403 后下一拍重试即可能拿到新 URL 回源成功（自愈关键）
    with ch.lock:
     fresh = ch.segments.get(key)
     if fresh:
      url = fresh[3]
   try:
    if ch.mode == "cast":
     status, body, _ = _cast_client().get(url, headers)
    else:
     status, body, _ = _http("GET", url, headers, None, 8)
   except Exception as error:
    status, body = 599, ("%s: %s" % (type(error).__name__, error)).encode("utf-8", "ignore")
   if 200 <= status < 300 and body:
    break
   if status in (404, 410):  # 确认死链，重试无意义
    break
  if status == 599 or status >= 500 or status in (408, 425, 429):
   # 599=_http 网络层失败(真机 DNS 408 超时即此路径)，5xx/408/429 可恢复，不踢段
   _log('chunk temp slug=%s seq=%s HTTP %d' % (ch.slug, seq, status))
   return [503, "text/plain; charset=utf-8",
    "央视频: 切片暂时不可用 HTTP %d" % status]
  if status == 403:
   # 403=签名过期/CDN 风控：不踢段。ch.seq 单调递增，段被踢后该 seq 永不复现，
   # 播放器持旧播放列表反复请求只会 chunk miss → 503 耗尽 → Source error 断流
   # （真机日志实证：403-drop seq=15 → 4×chunk miss seq=15 → Source error 503）。
   # 保留段：刷新线程 _append_segments 每拍对同 key 原地换新签名 URL，上方重试
   # 循环重读 URL 自愈；仍 403 则回 503 交给播放器退避，窗口推进后自然淘汰
   _log('chunk 403 slug=%s seq=%s' % (ch.slug, seq))
   return [503, "text/plain; charset=utf-8", "央视频: 切片签名失效 HTTP 403"]
  if status < 200 or status >= 300:
   _drop_dead_segment()
   # 仅确认死链(404/410 等)才踢段；统一 503 等待播放列表推进
   return [503, "text/plain; charset=utf-8", "央视频: 切片 HTTP %d" % status]
  if not body:
   return [503, "text/plain; charset=utf-8", "央视频: 切片空响应 HTTP %d" % status]
  TS_CACHE.put(url, body)
  return [200, "video/mp2t", body, {"Cache-Control": "no-cache, no-store"}]

 def _logo_bytes(self, slug):
  info = CHANNEL_MAP.get(slug) or {}
  with _LOGO_CACHE_LOCK:
   data = _LOGO_CACHE.get(slug)
  if data is None:
   data = _fetch_logo_bytes(slug, info.get("name", ""))
   with _LOGO_CACHE_LOCK:
    _LOGO_CACHE[slug] = data
  return [200, "image/png", data, {"Cache-Control": "public, max-age=86400"}]

 def _probe(self, slug, mode=""):
  """?type=diag&slug=cctv1 —— 当场拉一次，看看卡在哪个源。"""
  ch = CHANNEL_STATE.get(slug)
  if ch is None:
   return "未知频道: %s\n" % slug
  out = ["频道: %s  模式: %s" % (ch.slug, ch.mode)]
  if mode == "redirect" or (self.live_mode == "redirect" and mode != "proxy"):
   started = time.time()
   url = _upstream_url(ch)
   out.append("直连取址: %.2fs -> %s" % (time.time() - started, url or "(失败)"))
   if url:
    st, body, _ = _http("GET", url, {"User-Agent": UA}, None, HTTP_TIMEOUT)
    out.append("直连拉取: HTTP %d, %d 字节" % (st, len(body or b"")))
    out.append((body or b"").decode("utf-8", "replace")[:200].replace("\n", " | "))
  started = time.time()
  ok = _refresh_once(ch)
  with ch.lock:
   count = len(ch.order)
  out.append("代理取流: ok=%s %.2fs segs=%d err=%s"
   % (ok, time.time() - started, count, ch.last_error))
  return "\n".join(out) + "\n"

 def _diag(self, slug="", mode=""):
  if slug:
   return self._probe(slug, mode)
  lines = ["net: %s" % ("urllib(直连)" if DIRECT else "容器fetch优先/urllib兜底"),
   "logo源: %s" % (_LOGO_BASE or "(未探测到)"),
   "频道总数: %d" % len(CHANNEL_STATE), ""]
  try:
   for line in CAST.status().splitlines():
    lines.append(line)
  except Exception as error:
   lines.append("投屏状态: 不可用 (%s)" % type(error).__name__)
  lines.append("")
  for slug in sorted(CHANNEL_STATE):
   ch = CHANNEL_STATE[slug]
   with ch.lock:
    count = len(ch.order)
   lines.append("%-14s mode=%-6s segs=%-4d err=%s" % (slug, ch.mode, count, ch.last_error))
  return "\n".join(lines) + "\n"

 # ---------------- 小工具 ----------------
 def _purl(self, **kw):
  # 容器不一定提供 getProxyUrl（本地直跑 / 老版本壳子），拿不到就退化成空串，
  # 由调用方走直连兜底，避免整站直接抛异常。
  try:
   base = (self.getProxyUrl() or "").strip()
  except Exception:
   base = ""
  if not base:
   return ""
  sep = "&" if "?" in base else "?"
  return base + sep + "&".join(
   "%s=%s" % (k, urllib.parse.quote(str(v), safe="")) for k, v in kw.items())

 def _warm(self, slug):
  """后台预热，真正等数据在代理返回播放列表时才做。"""
  base = _base_slug(slug)
  if slug != base:
   self._ensure_cast_ready()
  for target in (slug, base):
   ch = CHANNEL_STATE.get(target)
   if ch is None:
    continue
   ch.last_access = time.time()
  ch = CHANNEL_STATE.get(slug)
  if ch is None:
   return
  threading.Thread(target=_ensure_channel, args=(ch,), daemon=True).start()

 def _logo(self, slug, name=""):
  direct = _logo_url(slug, name)
  if self.logo_mode != "proxy":
   if direct:
    return direct
  proxied = self._purl(type="logo", slug=slug)
  return proxied or direct or ""

 def _card(self, slug, name=""):
  base = _base_slug(slug)
  tag = ""
  if base in TRUE_4K_CHANNELS:
   tag = "真4K"
  elif base in BACKEND_CHANNELS:
   tag = "高码率"
  if slug != base:
   tag = ("%s | " % tag if tag else "") + "投屏"
  return {"vod_id": slug, "vod_name": name,
   "vod_pic": self._logo(base, name),
   "vod_remarks": ("央视频 | %s" % tag) if tag else "央视频",
   "style": {"type": "rect", "ratio": 1.78}}

 def _cards(self, tid):
  return [self._card(item['slug'], item['name']) for item in _entries(tid or 'all')]

 # ---------------- 投屏（第二线路） ----------------
 def _ensure_cast_ready(self):
  """只有进投屏分类 / 打开投屏线路时才建会话，启动阶段不碰。"""
  try:
   CAST.prepare()
  except Exception as error:
   _log('cast prepare failed: %s' % error)
