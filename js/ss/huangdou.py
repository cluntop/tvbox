# -*- coding: utf-8 -*-
import gzip
import hashlib
import hmac
import json
import os
import time
import uuid
import requests

try:
    from base.spider import Spider as BaseSpider
except Exception:
    class BaseSpider:
        pass

class _AESCBC:
    @staticmethod
    def encrypt(data, key, iv):
        try:
            from Crypto.Cipher import AES
            return AES.new(key, AES.MODE_CBC, iv).encrypt(_AESCBC.pad(data))
        except Exception:
            from cryptography.hazmat.backends import default_backend
            from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
            enc = Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend()).encryptor()
            return enc.update(_AESCBC.pad(data)) + enc.finalize()

    @staticmethod
    def decrypt(data, key, iv):
        try:
            from Crypto.Cipher import AES
            plain = AES.new(key, AES.MODE_CBC, iv).decrypt(data)
        except Exception:
            from cryptography.hazmat.backends import default_backend
            from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
            dec = Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend()).decryptor()
            plain = dec.update(data) + dec.finalize()
        return _AESCBC.unpad(plain)

    @staticmethod
    def pad(data):
        n = 16 - len(data) % 16
        return data + bytes([n]) * n

    @staticmethod
    def unpad(data):
        n = data[-1] if data else 0
        return data[:-n] if 1 <= n <= 16 else data

class Spider(BaseSpider):
    def __init__(self):
        self.host = "https://lzlukvca.cc"
        self.backups = ["https://roufquunbu.cc", "https://xqjurgek.top"]
        self.api = self.host + "/api"
        self.name = "黄豆短剧"
        self.platform_key = "7961beb44246e3012ce228d6b5ced05a"
        self.version = "2.0.0"
        self.device_type = "web"
        self.session_id = uuid.uuid4().hex
        self.device_id = self.session_id
        self.token = ""
        self.headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36", "Accept": "*/*", "Origin": self.host, "Referer": self.host + "/", "Content-Type": "application/octet-stream"}
        self.session = requests.Session()
        self.session.headers.update(self.headers)
        self.class_cache = None
        self.filter_cache = {}

    def init(self, extend=""):
        if extend:
            try:
                cfg = json.loads(extend)
                self.host = (cfg.get("site") or cfg.get("base_url") or self.host).rstrip("/")
                self.token = cfg.get("token", self.token)
            except Exception:
                None
        self._apply_host()

    def _apply_host(self):
        self.api = self.host + "/api"
        self.headers["Origin"] = self.host
        self.headers["Referer"] = self.host + "/"
        self.session.headers.update(self.headers)

    def getName(self):
        return self.name

    def _page(self, items, pg, tid=""):
        """站点返回定长 page_size 且无精确总数: 满页视为有下一页, 空页回退当前页。
        不臆造 total（接口未提供）。"""
        page = max(1, self._int(pg, 1))
        n = len(items)
        if n == 0:
            return page, page
        return page, page + 1 if n >= 18 else page

    def homeContent(self, filter):
        data = self._api("/drama/list", {"page": "1", "page_size": "18"})
        classes = self._classes()
        return {"class": classes, "filters": self._filters(classes), "list": [self._vod(x) for x in self._list(data)], "parse": 0, "jx": 0}

    def categoryContent(self, tid, pg, filter, extend):
        extend = extend or {}
        if tid == "yuandou":
            # navBlock 一次返回全部分区块（实测 p1=137 条、p2 起为空），按单页交付
            data = self._api("/drama/navBlock", {"code": "yuandou", "tab": "recommend", "page": "1"})
            items = self._nav_items(data)
            return {"page": 1, "pagecount": 1, "limit": len(items) or 18, "list": [self._vod(x) for x in items], "parse": 0, "jx": 0}
        else:
            req = {"page": str(pg), "page_size": "18"}
            if tid and tid not in ("all", "recommend"):
                tabs = self._nav_filter(tid)
                idx = self._int(extend.get("sub"), 0)
                sub = tabs[idx] if tabs and 0 <= idx < len(tabs) else {}
                flt = sub.get("filter", {}) if isinstance(sub, dict) else {}
                req["cat_id"] = flt.get("cat_id", "")
                if flt.get("tag_id"):
                    req["tag_id"] = flt.get("tag_id", "")
                req["order"] = flt.get("order", "") or extend.get("order", "")
            elif extend.get("order"):
                req["order"] = extend.get("order")
            if extend.get("update_status"):
                req["update_status"] = extend.get("update_status")
            data = self._api("/drama/list", req)
            items = self._list(data)
        page, pagecount = self._page(items, pg, tid)
        return {"page": page, "pagecount": pagecount, "limit": 18, "list": [self._vod(x) for x in items], "parse": 0, "jx": 0}

    def detailContent(self, ids):
        vid = self._sid(ids[0] if ids else "")
        obj = self._api("/drama/detail", {"id": vid})
        data = obj.get("data", obj) if isinstance(obj, dict) else {}
        if not isinstance(data, dict) or not data:
            return {"list": []}
        vod_id = self._sid(data.get("id") or data.get("drama_id") or vid)
        name = data.get("name") or data.get("title") or data.get("t") or vod_id
        eps = data.get("episodes") if isinstance(data.get("episodes"), list) else []
        count = self._int(data.get("episode_count") or data.get("free_episodes"), len(eps) or 1)
        free = self._int(data.get("free_episodes"), 0)
        vip_seqs = set(self._int(x, -1) for x in (data.get("vip_episodes") or []))
        play = []
        if eps:
            for i, ep in enumerate(eps, 1):
                if not isinstance(ep, dict):
                    continue
                seq = ep.get("seq") or ep.get("episode") or ep.get("ep") or i
                ep_name = ep.get("name") or ep.get("title") or "第%s集" % seq
                # 站点按集下发放映权限: type=vip / is_buy=false 的集只给 10 秒预览。
                # 保留真实标记，避免用户在播放器里遇到无提示的截断。
                if self._int(seq, -1) in vip_seqs or str(ep.get("type") or "") == "vip":
                    ep_name = "%s·会员" % ep_name
                elif free and self._int(seq, 0) > free:
                    ep_name = "%s·会员" % ep_name
                play.append("%s$%s|%s" % (ep_name, vod_id, seq))
        if not play:
            play = ["第%s集$%s|%s" % (i, vod_id, i) for i in range(1, count + 1)]
        remarks = data.get("update_label") or ("全%s集" % count)
        if free and count and free < count:
            remarks = "%s（免费%s集）" % (remarks, free)
        vod = {"vod_id": vod_id, "vod_name": name, "vod_pic": self._pic(data), "type_name": data.get("category") or data.get("type") or "", "vod_year": "", "vod_area": "", "vod_remarks": remarks, "vod_actor": "", "vod_director": "", "vod_content": data.get("description") or data.get("summary") or name, "vod_play_from": self.name, "vod_play_url": "#".join(play)}
        return {"list": [vod], "parse": 0, "jx": 0}

    def searchContent(self, key, quick, pg="1"):
        data = self._api("/drama/list", {"page": str(pg), "page_size": "18", "keywords": str(key)})
        items = self._list(data)
        page, pagecount = self._page(items, pg)
        return {"page": page, "pagecount": pagecount, "limit": 18, "list": [self._vod(x) for x in items], "parse": 0, "jx": 0}

    def playerContent(self, flag, id, vipFlags):
        vid, seq = self._split(id)
        obj = self._api("/drama/play", {"id": vid, "seq": str(seq)})
        data = obj.get("data", {}) if isinstance(obj, dict) else {}
        if not isinstance(data, dict):
            data = {}
        # 站点每次请求实时签发带 exp/sig 的 m3u8；lines 为同一集的多条 CDN 线路
        urls = []
        lines = data.get("lines")
        if isinstance(lines, list):
            for ln in lines:
                u = ln.get("url") if isinstance(ln, dict) else None
                if u and u not in urls:
                    urls.append(u)
        for k in ("m3u8", "preview_m3u8"):
            u = data.get(k)
            if u and u not in urls:
                urls.append(u)
        if not urls:
            return {"parse": 1, "playUrl": "", "url": "", "jx": 0,
                    "header": self._play_headers()}
        # 付费集只下发 10 秒预览（is_preview=true）；无完整片源时仍返回可播地址，
        # 不伪造完整直链，避免播放器表现为黑屏。
        return {"parse": 0, "playUrl": "", "url": urls[0], "jx": 0,
                "header": self._play_headers()}

    def _play_headers(self):
        return {"User-Agent": self.headers["User-Agent"], "Referer": self.host + "/", "Origin": self.host}

    def homeVideoContent(self):
        return {"list": []}

    def localProxy(self, param):
        return None

    def proxy(self, param):
        return self.localProxy(param)

    def isVideoFormat(self, url):
        u = str(url or "").lower()
        return ("m3u8" in u) or (".mp4" in u) or (".ts" in u)

    def manualVideoCheck(self):
        return False

    def action(self, action):
        return ""

    def destroy(self):
        try:
            self.session.close()
        except Exception:
            None

    def getDependence(self):
        return []

    def _hosts(self):
        """可尝试的站点域名: 当前 host 优先, 其后为备份域名。"""
        out = []
        for h in [self.host] + list(self.backups):
            h = str(h or "").rstrip("/")
            if h and h not in out:
                out.append(h)
        return out

    def _api(self, path, data=None, silent=False):
        path = "/" + path.lstrip("/")
        rid = str(uuid.uuid4())
        key = self._key(rid)
        iv = os.urandom(16)
        raw = json.dumps({"token": self.token or "", "deviceId": self.device_id, "data": data or {}}, ensure_ascii=False, separators=(",", ":")).encode("utf-8")
        body = iv + _AESCBC.encrypt(gzip.compress(raw), key, iv)
        ts = int(time.time())
        sign = hashlib.sha256(("Dart|%s|%s|%s|%s" % (self.session_id, rid, ts, path)).encode("utf-8")).hexdigest() + "-" + str(ts)
        base = dict(self.headers)
        base.update({"version": self.version, "deviceType": self.device_type, "time": str(ts), "sign": sign, "requestId": rid, "sessionId": self.session_id, "deviceBrand": "", "deviceModel": "", "systemName": "", "systemVersion": ""})
        for host in self._hosts():
            h = dict(base)
            h["Origin"] = host
            h["Referer"] = host + "/"
            try:
                r = self.session.post(host + "/api" + path, data=body, headers=h, timeout=20, verify=False)
                r.raise_for_status()
                obj = self._decode(r.content, rid)
            except Exception:
                continue
            if isinstance(obj, dict) and obj.get("status") in ("y", "n"):
                if host != self.host:
                    self.host = host
                    self._apply_host()
                return obj
        return {}

    def _key(self, rid):
        return hmac.new(self.platform_key.encode("utf-8"), bytes.fromhex(str(rid).replace("-", "")), hashlib.sha256).digest()

    def _decode(self, blob, rid):
        if not blob or len(blob) < 32 or (len(blob) - 16) % 16 != 0:
            try:
                return json.loads(blob.decode("utf-8"))
            except Exception:
                return {}
        plain = _AESCBC.decrypt(blob[16:], self._key(rid), blob[:16])
        if plain[:2] == b"\x1f\x8b":
            plain = gzip.decompress(plain)
        return json.loads(plain.decode("utf-8"))

    def _classes(self):
        if self.class_cache:
            return self.class_cache
        arr = [{"type_id": "all", "type_name": "全部短剧"}]
        data = self._api("/drama/navList", {})
        for item in self._list(data.get("data", data) if isinstance(data, dict) else data):
            tid = str(item.get("code") or item.get("id") or item.get("cat_id") or "")
            name = item.get("name") or item.get("title") or tid
            if tid and name:
                arr.append({"type_id": tid, "type_name": name})
        self.class_cache = arr
        return arr

    def _filters(self, classes):
        common = [{"key": "order", "name": "排序", "value": [{"n": "默认", "v": ""}, {"n": "最新", "v": "new"}, {"n": "最热", "v": "hot"}]}, {"key": "update_status", "name": "状态", "value": [{"n": "全部", "v": ""}, {"n": "连载", "v": "0"}, {"n": "完结", "v": "1"}]}]
        fs = {}
        for c in classes:
            tid = c["type_id"]
            tabs = self._nav_filter(tid) if tid not in ("all", "yuandou") else []
            fs[tid] = ([{"key": "sub", "name": "子分类", "value": [{"n": t.get("name", "默认"), "v": str(i)} for i, t in enumerate(tabs)]}] if tabs else []) + common
        return fs

    def _nav_filter(self, code):
        if code not in self.filter_cache:
            data = self._api("/drama/navFilter", {"code": str(code)})
            self.filter_cache[code] = self._list(data.get("data", data) if isinstance(data, dict) else data)
        return self.filter_cache.get(code, [])

    def _list(self, data):
        if isinstance(data, list):
            return data
        if not isinstance(data, dict):
            return []
        if isinstance(data.get("list"), list):
            return data["list"]
        if isinstance(data.get("items"), list):
            return data["items"]
        if isinstance(data.get("data"), list):
            return data["data"]
        if isinstance(data.get("data"), dict):
            return self._list(data["data"])
        return []

    def _nav_items(self, data):
        blocks = self._list(data.get("data", data) if isinstance(data, dict) else data)
        items = []
        for b in blocks:
            if isinstance(b, dict) and isinstance(b.get("items"), list):
                items += b.get("items")
            elif isinstance(b, dict) and (b.get("id") or b.get("drama_id")):
                items.append(b)
        return items

    def _vod(self, item):
        item = item or {}
        vid = self._sid(item.get("id") or item.get("drama_id") or "")
        remarks = item.get("update_label") or item.get("corner") or ("全%s集" % item.get("episode_count") if item.get("episode_count") else "")
        return {"vod_id": vid, "vod_name": item.get("name") or item.get("title") or item.get("t") or vid, "vod_pic": self._pic(item), "vod_remarks": remarks}

    def _pic(self, item):
        return item.get("img_y") or item.get("img_x") or item.get("img") or item.get("cover") or item.get("pic") or ""

    def _sid(self, x):
        return str(x or "").replace("rp_", "")

    def _split(self, x):
        p = str(x).split("|", 1)
        return self._sid(p[0]), p[1] if len(p) > 1 and p[1] else "1"

    def _int(self, x, d=0):
        try:
            return int(x)
        except Exception:
            return d
