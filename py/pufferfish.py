# coding: utf-8
# 河豚4K（lee_hetun4k）TVBox / FongMi Python 站源
# 协议：自定义 protobuf + RSA(PKCS#1 v1.5) 设备签名 + AES(ECB/CBC) 参数加密
# 纯标准库实现（自带 AES 加密与 RSA 公钥加密），不依赖 pycryptodome / requests
import base64
import json
import os
import re
import time
import uuid

from base.spider import Spider as BaseSpider

CFG = {
    "app_name": "河豚",
    "public_key": "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCr8SzZhjYy+rsya1K09t8d2K50pWFoBkgUqMpKOiW+3IEVKd4eTdvg9RSOjQ82kypL6R9BnsmrS1V8s4PVDwjQbUtYhTPPC9Hz16qY7rpD6m0d2vr09/UpWQ5uOy9PR0QTrsioveZ+DIe9jc3C+zBCu/kZSY/R8stwJoiitki3gwIDAQAB",
    "safe_code": "V04XQZNYRWN6T0JODZFIAG5CTZB3PT0=",
    "data_iv": "OC1A06E197EF10CF3F6058CA7A803B5E",
    "pkg": "com.djlxxl.xcydzkj",
    "boot": "https://az1-1456692500.cos.ap-guangzhou.myqcloud.com/az1.txt",
    "v_name": "7.0.0.2",
    "device_key": "ed5fdsgucxumegqa",
}

UA = "okhttp/3.12.1"
MEDIA_RE = re.compile(r"\.(?:mp4|m3u8|flv|mkv|avi|ts|mov|mpd|m4a|wmv)(?:\?.*)?$", re.I)


# --------------------------------------------------------------------------
# protobuf（只用到 varint 与 length-delimited）
# --------------------------------------------------------------------------
def _varint(n):
    out = bytearray()
    n = int(n)
    while True:
        b = n & 0x7F
        n >>= 7
        out.append(b | 0x80 if n else b)
        if not n:
            return bytes(out)


def _p_int(field, value):
    return _varint(field << 3) + _varint(value)


def _p_bytes(field, value):
    if isinstance(value, str):
        value = value.encode("utf-8")
    return _varint((field << 3) | 2) + _varint(len(value)) + value


def _parse(buf):
    """返回 {field: [value, ...]}，varint 为 int，其余为 bytes。"""
    out = {}
    pos = 0
    n = len(buf)
    while pos < n:
        tag, pos = _read_varint(buf, pos)
        field, wire = tag >> 3, tag & 7
        if wire == 0:
            val, pos = _read_varint(buf, pos)
        elif wire == 2:
            ln, pos = _read_varint(buf, pos)
            val = buf[pos:pos + ln]
            pos += ln
        elif wire == 1:
            val = buf[pos:pos + 8]
            pos += 8
        elif wire == 5:
            val = buf[pos:pos + 4]
            pos += 4
        else:
            break
        out.setdefault(field, []).append(val)
    return out


def _read_varint(buf, pos):
    n = 0
    shift = 0
    while pos < len(buf):
        b = buf[pos]
        pos += 1
        n |= (b & 0x7F) << shift
        if not b & 0x80:
            return n, pos
        shift += 7
    raise ValueError("bad varint")


def _one(fields, num, default=None):
    v = fields.get(num)
    if not v:
        return default
    return v[0]


def _s(value, default=""):
    if value is None:
        return default
    if isinstance(value, bytes):
        return value.decode("utf-8", "ignore")
    if isinstance(value, int):
        return str(value)
    return str(value)


# --------------------------------------------------------------------------
# AES（只做加密：ECB / CBC + PKCS7），S 盒按 GF(2^8) 定义现算
# --------------------------------------------------------------------------
def _gmul(a, b):
    p = 0
    for _ in range(8):
        if b & 1:
            p ^= a
        hi = a & 0x80
        a = (a << 1) & 0xFF
        if hi:
            a ^= 0x1B
        b >>= 1
    return p


def _build_sbox():
    inv = [0] * 256
    for i in range(1, 256):
        # 乘法逆元：i^254
        r = 1
        base = i
        e = 254
        while e:
            if e & 1:
                r = _gmul(r, base)
            base = _gmul(base, base)
            e >>= 1
        inv[i] = r

    def rotl(x, n):
        return ((x << n) | (x >> (8 - n))) & 0xFF

    box = [0] * 256
    for i in range(256):
        x = inv[i]
        box[i] = x ^ rotl(x, 1) ^ rotl(x, 2) ^ rotl(x, 3) ^ rotl(x, 4) ^ 0x63
    return box


SBOX = _build_sbox()
RCON = [0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1B, 0x36, 0x6C, 0xD8, 0xAB, 0x4D]


class _AES(object):
    def __init__(self, key):
        if len(key) not in (16, 24, 32):
            raise ValueError("bad aes key length %d" % len(key))
        self.nk = len(key) // 4
        self.nr = self.nk + 6
        self.rk = self._expand(key)

    def _expand(self, key):
        w = [list(key[i:i + 4]) for i in range(0, len(key), 4)]
        total = 4 * (self.nr + 1)
        for i in range(self.nk, total):
            t = list(w[i - 1])
            if i % self.nk == 0:
                t = t[1:] + t[:1]
                t = [SBOX[b] for b in t]
                t[0] ^= RCON[i // self.nk - 1]
            elif self.nk > 6 and i % self.nk == 4:
                t = [SBOX[b] for b in t]
            w.append([w[i - self.nk][j] ^ t[j] for j in range(4)])
        return w

    def _add(self, s, rnd):
        for c in range(4):
            for r in range(4):
                s[r][c] ^= self.rk[rnd * 4 + c][r]

    def encrypt_block(self, block):
        s = [[block[r + 4 * c] for c in range(4)] for r in range(4)]
        self._add(s, 0)
        for rnd in range(1, self.nr + 1):
            for r in range(4):
                for c in range(4):
                    s[r][c] = SBOX[s[r][c]]
            for r in range(1, 4):
                s[r] = s[r][r:] + s[r][:r]
            if rnd != self.nr:
                for c in range(4):
                    a0, a1, a2, a3 = s[0][c], s[1][c], s[2][c], s[3][c]
                    s[0][c] = _gmul(a0, 2) ^ _gmul(a1, 3) ^ a2 ^ a3
                    s[1][c] = a0 ^ _gmul(a1, 2) ^ _gmul(a2, 3) ^ a3
                    s[2][c] = a0 ^ a1 ^ _gmul(a2, 2) ^ _gmul(a3, 3)
                    s[3][c] = _gmul(a0, 3) ^ a1 ^ a2 ^ _gmul(a3, 2)
            self._add(s, rnd)
        return bytes(s[r][c] for c in range(4) for r in range(4))


def _pad(data):
    n = 16 - len(data) % 16
    return data + bytes([n]) * n


_AES_CACHE = {}


def _aes(key):
    inst = _AES_CACHE.get(key)
    if inst is None:
        inst = _AES(key)
        _AES_CACHE[key] = inst
    return inst


def _aes_ecb(data, key):
    aes = _aes(key)
    data = _pad(data)
    return b"".join(aes.encrypt_block(data[i:i + 16]) for i in range(0, len(data), 16))


def _aes_cbc(data, key):
    aes = _aes(key)
    data = _pad(data)
    iv = list(key)
    out = bytearray()
    for i in range(0, len(data), 16):
        block = [data[i + j] ^ iv[j] for j in range(16)]
        enc = aes.encrypt_block(bytes(block))
        out += enc
        iv = list(enc)
    return bytes(out)


# --------------------------------------------------------------------------
# RSA 公钥加密（PKCS#1 v1.5），DER/SPKI 手工解析
# --------------------------------------------------------------------------
def _der_tlv(buf, pos):
    tag = buf[pos]
    pos += 1
    ln = buf[pos]
    pos += 1
    if ln & 0x80:
        cnt = ln & 0x7F
        ln = int.from_bytes(buf[pos:pos + cnt], "big")
        pos += cnt
    return tag, buf[pos:pos + ln], pos + ln


def _rsa_public(der):
    _, body, _ = _der_tlv(der, 0)          # SEQUENCE
    _, _, p = _der_tlv(body, 0)            # AlgorithmIdentifier
    _, bitstr, _ = _der_tlv(body, p)       # BIT STRING
    inner = bitstr[1:]                     # 跳过 unused-bits
    _, rsa_seq, _ = _der_tlv(inner, 0)
    _, n_raw, p = _der_tlv(rsa_seq, 0)
    _, e_raw, _ = _der_tlv(rsa_seq, p)
    return int.from_bytes(n_raw, "big"), int.from_bytes(e_raw, "big")


_RSA_CACHE = {}


def _rsa_encrypt(text, public_key_b64):
    if public_key_b64 not in _RSA_CACHE:
        _RSA_CACHE[public_key_b64] = _rsa_public(base64.b64decode(public_key_b64))
    n, e = _RSA_CACHE[public_key_b64]
    k = (n.bit_length() + 7) // 8
    msg = text.encode("utf-8")
    if len(msg) > k - 11:
        raise ValueError("rsa message too long")
    ps = bytearray()
    while len(ps) < k - 3 - len(msg):
        chunk = os.urandom(k - 3 - len(msg) - len(ps))
        ps += bytes(b for b in chunk if b)
    block = b"\x00\x02" + bytes(ps) + b"\x00" + msg
    return base64.b64encode(pow(int.from_bytes(block, "big"), e, n).to_bytes(k, "big")).decode()


# --------------------------------------------------------------------------
def _rand(n):
    raw = base64.b64encode(os.urandom(n)).decode()
    raw = re.sub(r"[^A-Za-z0-9]", "", raw)
    return (raw + "A" * n)[:n - 1] + "="


def _clean_html(text):
    text = _s(text)
    if not text:
        return ""
    text = re.sub(r"(?is)<(script|style)[^>]*>.*?</\1>", "", text)
    text = re.sub(r"(?i)<br\s*/?>|</p>|</div>", "\n", text)
    text = re.sub(r"<[^>]+>", "", text)
    text = (text.replace("&nbsp;", " ").replace("&amp;", "&")
                .replace("&lt;", "<").replace("&gt;", ">")
                .replace("&quot;", '"').replace("&#39;", "'"))
    return re.sub(r"[ \t]+", " ", text).strip()


class Spider(BaseSpider):
    # 跨实例共享：域名 + 动态公钥（壳子可能每次调用重建 Spider）
    _shared = {"host": "", "key": "", "ts": 0}

    # ---- 基础信息 -------------------------------------------------------
    def getName(self):
        return "河豚4K"

    def getDependence(self):
        return []

    def setExtendInfo(self, extend):
        return None

    def init(self, extend=""):
        # 保持轻量：域名与握手都延迟到首次请求
        self._host = ""
        self._dyn_key = ""
        self._primed = False

    # ---- 网络 ----------------------------------------------------------
    def _http(self, url, method="GET", body=None, headers=None, timeout=18):
        hdrs = {"User-Agent": UA}
        if headers:
            hdrs.update(headers)
        try:
            sess = getattr(self, "session", None)
            if sess is not None:
                r = sess.request(method, url, data=body, headers=hdrs, timeout=timeout)
                return r.content or b""
        except Exception:
            pass
        try:
            if method == "GET":
                r = self.fetch(url, headers=hdrs, timeout=timeout)
                data = getattr(r, "content", None)
                if data is None:
                    data = _s(getattr(r, "text", "")).encode("utf-8")
                return data or b""
            r = self.post(url, data=body, headers=hdrs, timeout=timeout)
            return getattr(r, "content", b"") or b""
        except Exception:
            return b""

    def _ensure(self):
        if self._host:
            return True
        cache = Spider._shared
        if cache["host"] and time.time() - cache["ts"] < 600:
            self._host = cache["host"]
            self._dyn_key = cache["key"]
            return True
        raw = self._http(CFG["boot"], timeout=10)
        try:
            host = _s(json.loads(raw.decode("utf-8")).get("domain")).rstrip("/")
        except Exception:
            host = ""
        if not host:
            return False
        self._host = host
        # 握手取动态签名公钥（失败则回退内置公钥）
        try:
            ts = int(time.time() * 1000)
            r = _rand(16)
            body = (_p_int(1, ts) + _p_bytes(2, _rsa_encrypt(str(ts) + r, CFG["public_key"]))
                    + _p_bytes(3, _rand(16)) + _p_bytes(4, r) + _p_bytes(5, _rand(16)))
            resp = self._http(self._host + "/api/v5/find/app/zone", "POST", body, self._headers(True, True))
            zone = _parse(_one(_parse(resp), 3, b"") or b"")
            self._dyn_key = "".join(_s(_one(zone, i)) for i in (2, 3, 4, 5))
        except Exception:
            self._dyn_key = ""
        cache["host"] = self._host
        cache["key"] = self._dyn_key
        cache["ts"] = time.time()
        return True

    def _headers(self, protobuf=True, no_sig=False):
        ts = int(time.time() * 1000)
        r = _rand(16)
        uid = uuid.uuid4().hex.upper()
        vapp = CFG["v_name"].replace(".", "")
        device = {
            "country": "CN", "vName": CFG["v_name"], "cpuId": "MT6893Z%2FCZA", "young": 0,
            "facturer": "Xiaomi", "pkg": CFG["pkg"], "uuid": uid, "resolution": "1080x2272",
            "mac": "02%3A00%3A00%3A00%3A00%3A00", "abid": "397", "model": "M2012K11AC",
            "plat": "android", "udid": uid, "dpi": "440", "net": "1", "lang": "zh",
            "brand": "Xiaomi", "density": "2.75", "appName": CFG["app_name"],
            "cpu": "arm64-v8a", "chid": "10000", "carrier": "%E8%81%94%E9%80%9A",
            "_vOsCode": 30, "vOs": "11", "v": 1, "tenantId": "", "vApp": vapp,
            "device": 0, "androidID": uid.lower()[:16],
        }
        if no_sig:
            device["sig"] = _rsa_encrypt(str(ts) + r + vapp, CFG["public_key"])
        else:
            device["sig"] = _rsa_encrypt(str(ts) + r + vapp, self._dyn_key or CFG["public_key"])
        device["random_str"] = r
        device["timestamp"] = ts
        sig = base64.b64encode(_aes_ecb((str(ts) + r).encode("utf-8"), CFG["data_iv"].encode("ascii"))).decode()
        device["sig2"] = sig[:8]
        device["sig3"] = sig[8:]
        params = _aes_cbc(json.dumps(device, separators=(",", ":")).encode("utf-8"),
                          CFG["device_key"].encode("ascii")).hex()
        return {
            "User-Agent": UA,
            "Accept": "application/x-protobuf" if protobuf else "application/json",
            "Content-Type": "application/x-protobuf" if protobuf else "application/json; charset=utf-8",
            "publicParams": '{"paramsData":"%s"}' % params,
        }

    def _secure(self, params):
        ts = int(time.time() * 1000)
        r = _rand(8)
        fake = _rand(20)
        query = "&".join("%s=%s" % (k, v) for k, v in params.items()
                         if v is not None and str(v) != "")
        enc = r + base64.b64encode(_aes_ecb((query + str(ts)).encode("utf-8"),
                                            CFG["safe_code"].encode("ascii"))).decode()
        return (_p_bytes(1, enc[:20]) + _p_bytes(2, enc[20:]) + _p_bytes(3, fake)
                + _p_int(4, ts) + _p_bytes(5, r))

    def _post(self, path, body):
        return self._http(self._host + path, "POST", body, self._headers(True))

    def _api(self, path, params, retry=True):
        if not self._ensure():
            return {}
        try:
            outer = _parse(self._post(path, self._secure(params)))
            msg = _s(_one(outer, 2))
            data = _parse(_one(outer, 3, b"") or b"")
            if data:
                return data
            # 域名或动态公钥失效（RSA/签名类错误）时清缓存重来一次
            if retry and ("RSA" in msg or "签名" in msg or "过期" in msg):
                Spider._shared.update({"host": "", "key": "", "ts": 0})
                self._host = ""
                self._dyn_key = ""
                return self._api(path, params, False)
            return data
        except Exception:
            return {}

    def _json(self, path):
        if not self._ensure():
            return {}
        try:
            return json.loads(self._http(self._host + path, "GET", None, self._headers(False)).decode("utf-8"))
        except Exception:
            return {}

    # ---- 解析 ----------------------------------------------------------
    def _cover(self, raw):
        if not isinstance(raw, bytes) or not raw:
            return ""
        try:
            f = _parse(raw)
        except Exception:
            return ""
        for num in (2, 1):
            url = _s(_one(f, num))
            if url.startswith("http") and "$" not in url and len(url) < 300:
                if re.search(r"\.(?:jpe?g|png|webp|gif|bmp|avif)(?:\?|$)", url, re.I) or "img" in url:
                    return url
        return ""

    def _vod(self, raw):
        f = _parse(raw)
        name = _s(_one(f, 5))
        if not name:
            return None
        return {
            "vod_id": _s(_one(f, 3)),
            "vod_name": name,
            "vod_pic": self._cover(_one(f, 2)),
            "vod_remarks": _s(_one(f, 13)),
            "vod_year": _s(_one(f, 14)),
            "vod_area": _s(_one(f, 1)),
            "type_name": _s(_one(f, 15)).split(",")[-1],
        }

    def _list(self, fields):
        out = []
        seen = set()
        for raw in fields.get(1, []) or []:
            try:
                item = self._vod(raw)
            except Exception:
                continue
            if not item or not item["vod_id"] or item["vod_id"] in seen:
                continue
            seen.add(item["vod_id"])
            out.append(item)
        return out

    # ---- 接口 ----------------------------------------------------------
    def homeContent(self, filter):
        try:
            cats = []
            data = self._json("/api/v3/drama/getCategory?orderBy=type_id")
            for item in data.get("data") or []:
                if not item.get("id") or item.get("name") == "公告":
                    continue
                cats.append({"type_id": _s(item.get("id")), "type_name": _s(item.get("name"))})
            if not cats:
                cats = [
                    {"type_id": "21", "type_name": "电影"}, {"type_id": "22", "type_name": "剧集"},
                    {"type_id": "25", "type_name": "动漫"}, {"type_id": "26", "type_name": "综艺"},
                    {"type_id": "27", "type_name": "短剧"}, {"type_id": "28", "type_name": "漫剧"},
                    {"type_id": "29", "type_name": "直播"}, {"type_id": "30", "type_name": "纪录片"},
                ]
            return {"class": cats, "filters": self._filters(cats)}
        except Exception:
            return {"class": [], "filters": {}}

    def _filters(self, cats):
        order = _opt("排序", ["最新", "最热", "评分"])
        cls = _opt("类型", ["动作", "喜剧", "爱情", "科幻", "恐怖", "剧情", "战争", "犯罪",
                            "悬疑", "动画", "纪录片", "伦理", "冒险", "奇幻"])
        area = _opt("地区", ["内地", "香港", "台湾", "美国", "韩国", "日本", "泰国",
                             "印度", "法国", "英国", "德国", "其他"])
        year = _opt("年份", [str(y) for y in range(2026, 2014, -1)])
        lang = _opt("语言", ["国语", "英语", "日语", "韩语", "粤语", "法语"])
        out = {}
        for c in cats:
            tid = c["type_id"]
            if tid == "29":                      # 直播没有筛选
                out[tid] = []
            elif tid in ("27", "28"):            # 短剧/漫剧：语言维度无数据
                out[tid] = [cls, area, year, order]
            else:
                out[tid] = [cls, area, year, lang, order]
        return out

    def homeVideoContent(self):
        try:
            f = self._api("/api/proto/v5/drama/category", {
                "pagesize": "21", "typeId1": "21", "page": "1",
                "vodOrderBy": "最热", "vodArea": "", "vodLang": "", "vodClass": "", "vodYear": "",
            })
            return {"list": self._list(f)}
        except Exception:
            return {"list": []}

    def categoryContent(self, tid, pg, filter, extend):
        try:
            ext = extend or {}
            page = max(1, int(str(pg).isdigit() and pg or 1))
            params = {
                "pagesize": "21",
                "typeId1": _s(tid),
                "page": str(page),
                "vodOrderBy": _s(ext.get("排序")) or "最新",
                "vodArea": _s(ext.get("地区")),
                "vodLang": _s(ext.get("语言")),
                "vodClass": _s(ext.get("类型")),
                "vodYear": _s(ext.get("年份")),
            }
            items = self._list(self._api("/api/proto/v5/drama/category", params))
            pagecount = page + 1 if len(items) >= 21 else page
            return {"list": items, "page": page, "pagecount": pagecount,
                    "limit": 21, "total": pagecount * 21 if items else 0}
        except Exception:
            return {"list": [], "page": 1, "pagecount": 1, "limit": 21, "total": 0}

    def detailContent(self, ids):
        try:
            vid = _s(ids[0] if isinstance(ids, (list, tuple)) else ids).strip()
            f = self._api("/api/proto/v5/drama/getDetail", {"id": vid})
            if not f:
                return {"list": []}
            groups = {}
            order = []
            for raw in f.get(29, []) or []:
                try:
                    ep = _parse(raw)
                except Exception:
                    continue
                path = _s(_one(ep, 4))
                if not path:
                    continue
                title = _s(_one(ep, 3)) or _s(_one(ep, 2)) or "第1集"
                source = _s(_one(ep, 9))
                quality = _s(_one(ep, 10)) or source or "未知"
                name = "%s (%s)" % (quality, source) if source and quality != source else quality
                name = name.replace("$", "").replace("#", "")
                title = title.replace("$", "").replace("#", "")
                if MEDIA_RE.search(path):
                    token = path
                else:
                    payload = "%s\n%s" % (source, path)          # 线路源 + 播放标识
                    token = base64.urlsafe_b64encode(payload.encode("utf-8")).decode().rstrip("=")
                if name not in groups:
                    groups[name] = []
                    order.append(name)
                groups[name].append("%s$%s" % (title, token))
            if not groups:
                return {"list": [{
                    "vod_id": vid, "vod_name": _s(_one(f, 9)), "vod_pic": self._cover(_one(f, 2)),
                    "vod_actor": _s(_one(f, 25)), "vod_director": _s(_one(f, 12)),
                    "vod_area": _s(_one(f, 1)), "vod_year": _s(_one(f, 18)),
                    "vod_remarks": _s(_one(f, 26)), "vod_content": _clean_html(_one(f, 6)),
                    "vod_play_from": "", "vod_play_url": "",
                }]}

            def rank(name):
                low = name.lower()
                if "4k" in low:
                    return 0
                if "蓝光" in low:
                    return 1
                if "超清" in low or "高清" in low:
                    return 2
                return 3

            names = sorted(order, key=lambda x: (rank(x), order.index(x)))
            vod = {
                "vod_id": vid,
                "vod_name": _s(_one(f, 9)),
                "vod_pic": self._cover(_one(f, 2)),
                "vod_actor": _s(_one(f, 25)),
                "vod_director": _s(_one(f, 12)),
                "vod_area": _s(_one(f, 1)),
                "vod_year": _s(_one(f, 18)),
                "vod_remarks": _s(_one(f, 26)),
                "vod_content": _clean_html(_one(f, 6)),
                "vod_play_from": "$$$".join(names),
                "vod_play_url": "$$$".join("#".join(groups[n]) for n in names),
            }
            return {"list": [vod]}
        except Exception:
            return {"list": []}

    def searchContent(self, key, quick, pg="1"):
        try:
            page = max(1, int(str(pg).isdigit() and pg or 1))
            f = self._api("/api/proto/v5/drama/search", {
                "searchKeys": _s(key), "page": str(page), "pagesize": "21",
            })
            items = self._list(f)
            return {"list": items, "page": page,
                    "pagecount": page + 1 if len(items) >= 21 else page}
        except Exception:
            return {"list": [], "page": 1, "pagecount": 1}

    def playerContent(self, flag, pid, vipFlags):
        try:
            vid = _s(pid).strip()
            if MEDIA_RE.search(vid):
                return {"parse": 0, "url": vid, "header": {"User-Agent": UA}}
            raw = vid
            pad = "=" * (-len(raw) % 4)
            try:
                plain = base64.urlsafe_b64decode(raw + pad).decode("utf-8", "ignore")
            except Exception:
                try:
                    plain = base64.b64decode(raw + pad).decode("utf-8", "ignore")
                except Exception:
                    return {"parse": 1, "url": vid, "header": {"User-Agent": UA}}
            if "\n" not in plain:
                return {"parse": 1, "url": vid, "header": {"User-Agent": UA}}
            source, path = plain.split("\n", 1)
            f = self._api("/api/proto/v5/videoUsableUrl", {
                "vodPlayFrom": source, "playUrl": path,
            })
            url = _s(_one(f, 1))
            if not url:
                return {"parse": 1, "url": vid, "header": {"User-Agent": UA}}
            header = {"User-Agent": UA}
            for raw_h in f.get(6, []) or []:
                try:
                    h = _parse(raw_h)
                except Exception:
                    continue
                k = _s(_one(h, 1))
                v = _s(_one(h, 2))
                if k and k.lower() not in ("user-agent", "host", "content-length", "accept-encoding"):
                    header[k] = v
            return {"parse": 0, "url": url, "header": header}
        except Exception:
            return {"parse": 1, "url": _s(pid), "header": {"User-Agent": UA}}


def _opt(name, values):
    return {"key": name, "name": name, "value": [{"n": "全部", "v": ""}] +
            [{"n": v, "v": v} for v in values]}
