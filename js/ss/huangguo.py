# -*- coding: utf-8 -*-
import re
import sys
import json
import time
from base64 import b64encode, b64decode
from urllib.parse import quote, unquote

try:
    import requests
except Exception:
    requests = None
import urllib.request

try:
    import urllib3
    urllib3.disable_warnings()
except Exception:
    pass
try:
    from Crypto.Cipher import AES as _AES
except Exception:
    try:
        from Cryptodome.Cipher import AES as _AES
    except Exception:
        _AES = None
try:
    from lxml import etree
except Exception:
    etree = None


class Spider:
    """黄果短剧五壳通用独立 Spider"""

    _IMG_KEY = bytes([102, 53, 100, 57, 54, 53, 100, 102, 55, 53, 51, 51, 54, 50, 55, 48])
    _IMG_IV = bytes([57, 55, 98, 54, 48, 51, 57, 52, 97, 98, 99, 50, 102, 98, 101, 49])
    _TIMEOUT = 20

    def __init__(self):
        self.host = "https://huangguoai.com"
        self.ua = ("Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                   "AppleWebKit/537.36 (KHTML, like Gecko) "
                   "Chrome/120.0.0.0 Safari/537.36")
        self.pics_direct = False
        self._proxy_url = ""
        self._session = None
        self.img_key = b'f5d965df75336270'
        self.img_iv = b'97b60394abc2fbe1'
        self.img_hosts = {'pic.drleao.cn', 'pic.eanfog.cn', 'pic.zdmhyg.cn', 'pic.tuafjz.cn'}
        self.base_cates = [
            {"type_id": "ai-duanju", "type_name": "AI成人短剧"},
            {"type_id": "ai-manju", "type_name": "AI成人漫剧"},
            {"type_id": "ai-huanlian", "type_name": "AI换脸"},
            {"type_id": "ai-mogai", "type_name": "AI魔改"},
        ]
        self._recommend_cache = None

    def getName(self):
        return "黄果短剧"

    def getDependence(self):
        return []

    def init(self, extend=""):
        if isinstance(extend, str) and extend.strip()[:1] == "{":
            try:
                extend = json.loads(extend)
            except Exception:
                extend = dict()
        if not isinstance(extend, dict):
            extend = dict()
        if extend.get("host"):
            self.host = str(extend["host"]).rstrip("/")
        ext = json.dumps(extend, ensure_ascii=False) if extend else str(extend)
        self.pics_direct = "direct=1" in ext
        self.categories = [
            {"type_id": "recommend", "type_name": "精选推荐"},
            {"type_id": "ai-duanju", "type_name": "AI成人短剧"},
            {"type_id": "ai-manju", "type_name": "AI成人漫剧"},
            {"type_id": "ai-huanlian", "type_name": "AI换脸"},
            {"type_id": "ai-mogai", "type_name": "AI魔改"},
            {"type_id": "ranks", "type_name": "排行榜"},
            {"type_id": "chigua", "type_name": "黄果吃瓜"},
            {"type_id": "topics", "type_name": "话题精选"},
        ]
        self.filters = {
            "ai-duanju": [{"key": "sort", "name": "排序", "value": [
                {"n": "最新更新", "v": "latest"}, {"n": "当前热播", "v": "hot"},
                {"n": "独家原创", "v": "original"}, {"n": "随机推荐", "v": "random"}]}],
            "ai-manju": [{"key": "sort", "name": "排序", "value": [
                {"n": "最新更新", "v": "latest"}, {"n": "当前热播", "v": "hot"},
                {"n": "独家原创", "v": "original"}, {"n": "随机推荐", "v": "random"}]}],
            "ai-huanlian": [{"key": "sort", "name": "排序", "value": [
                {"n": "最新更新", "v": "latest"}, {"n": "当前热播", "v": "hot"},
                {"n": "独家原创", "v": "original"}, {"n": "随机推荐", "v": "random"}]}],
            "ai-mogai": [{"key": "sort", "name": "排序", "value": [
                {"n": "最新更新", "v": "latest"}, {"n": "当前热播", "v": "hot"},
                {"n": "独家原创", "v": "original"}, {"n": "随机推荐", "v": "random"}]}],
            "ranks": [{"key": "rank_type", "name": "榜单", "value": [
                {"n": "热播榜", "v": "hot"}, {"n": "推荐榜", "v": "recommend"},
                {"n": "潜力榜", "v": "potential"}]}],
            "chigua": [{"key": "cate", "name": "分类", "value": [
                {"n": "全部", "v": "all"}, {"n": "热门吃瓜", "v": "remen"},
                {"n": "AI原创", "v": "yuanchuang"}]}],
            "topics": [{"key": "tid", "name": "话题", "value": [
                {"n": "热门AI短剧", "v": "hot-aiduanju"}, {"n": "欧美短剧", "v": "oumei-duanju"},
                {"n": "天才男友", "v": "tiancai-nantong"}, {"n": "明星换脸", "v": "mingxing-huanlian"}]}],
        }

    def _headers(self, referer=None):
        return {
            "User-Agent": self.ua,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
            "Accept-Language": "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7",
            "Cache-Control": "no-cache",
            "Pragma": "no-cache",
            "Sec-Fetch-Dest": "document",
            "Sec-Fetch-Mode": "navigate",
            "Sec-Fetch-Site": "same-origin",
            "Sec-Fetch-User": "?1",
            "Upgrade-Insecure-Requests": "1",
            "Referer": (referer or self.host) + "/",
        }

    def _session_obj(self):
        """复用 Session，行为接近真实浏览器持续访问"""
        if self._session is not None:
            return self._session
        if requests is None:
            return None
        try:
            s = requests.Session()
            s.verify = False
            s.headers.update(self._headers())
            self._session = s
            return s
        except Exception:
            return None

    def _ensure_str(self, data, asjson=False):
        """把响应统一为干净字符串；处理 gzip 与宽字符编码，避免 lxml 编码探测报错"""
        if isinstance(data, str):
            return data
        if data is None:
            return ""
        if isinstance(data, bytes):
            if len(data) >= 2 and data[:2] == b"\x1f\x8b":
                import gzip
                try:
                    data = gzip.decompress(data)
                except Exception:
                    pass
            # 去掉 UTF-32/UTF-16 BOM，避免 lxml "encoding not supported" 报错
            for bom, enc in ((b"\xff\xfe\x00\x00", "utf-32"), (b"\x00\x00\xfe\xff", "utf-32"),
                             (b"\xff\xfe", "utf-16"), (b"\xfe\xff", "utf-16")):
                if data[:len(bom)] == bom:
                    try:
                        return data.decode(enc)
                    except Exception:
                        break
            try:
                return data.decode("utf-8")
            except UnicodeDecodeError:
                return data.decode("gbk", errors="ignore")
        return str(data)

    def _get(self, url, referer=None, asjson=False, raw=False):
        fail = dict() if asjson else (b"" if raw else "")
        if not url:
            return fail
        headers = self._headers(referer)
        sess = self._session_obj()
        if sess is not None:
            for _ in range(3):
                try:
                    r = sess.get(url, headers=headers, timeout=self._TIMEOUT)
                    if asjson:
                        try:
                            return r.json()
                        except Exception:
                            return dict()
                    if raw:
                        return r.content
                    return self._ensure_str(r.content)
                except Exception:
                    time.sleep(1)
            return fail
        if requests is not None:
            for _ in range(3):
                try:
                    r = requests.get(url, headers=headers, timeout=self._TIMEOUT, verify=False)
                    if asjson:
                        try:
                            return r.json()
                        except Exception:
                            return dict()
                    if raw:
                        return r.content
                    return self._ensure_str(r.content)
                except Exception:
                    time.sleep(1)
            return fail
        import gzip
        for _ in range(3):
            try:
                req = urllib.request.Request(url, headers=headers)
                resp = urllib.request.urlopen(req, timeout=self._TIMEOUT)
                data = resp.read()
                if asjson:
                    try:
                        return json.loads(self._ensure_str(data))
                    except Exception:
                        return dict()
                if raw:
                    return data
                return self._ensure_str(data)
            except Exception:
                time.sleep(1)
        return fail

    def _get_bin(self, url):
        return self._get(url, raw=True)

    def _fix(self, u):
        if not u:
            return ""
        if u.startswith("//"):
            return "https:" + u
        if u.startswith("/"):
            return self.host + u
        return u

    def _img_src(self, u):
        """剔除 CDN 防盗链的 auth_key 等查询参数，得到不过期的稳定直链"""
        u = self._fix(u or "")
        if u.startswith("http") and "?" in u:
            u = re.sub(r"\?.*", "", u)
        return u

    def getProxyUrl(self, local=True):
        if self._proxy_url:
            return self._proxy_url
        try:
            from com.github.catvod import Proxy as _CatProxy
            return str(_CatProxy.getUrl(local)) + "?do=py"
        except Exception:
            pass
        return "http://127.0.0.1:9978/proxy?do=py"

    def _proxy_pic(self, u):
        """图片走壳本地代理，由 localProxy 解密后返回真实图片"""
        u = self._img_src(u)
        if not u:
            return ""
        if self.pics_direct:
            return u
        enc = quote(b64encode(u.encode("utf-8")).decode("utf-8"), safe="")
        return self.getProxyUrl() + "&url=" + enc + "&type=img"

    def _decrypt_img(self, raw):
        """AES-128-CBC 解密站点封面字节；无加密或解密失败时原样返回"""
        if not raw or len(raw) % 16 != 0 or _AES is None:
            return raw
        try:
            pt = _AES.new(self._IMG_KEY, _AES.MODE_CBC, self._IMG_IV).decrypt(raw)
        except Exception:
            return raw
        if not (pt[:2] == b"\xff\xd8" or pt[:8] == b"\x89PNG\r\n\x1a\n"
                or pt[:4] == b"RIFF" or pt[:6] in (b"GIF87a", b"GIF89a")):
            return raw
        pad = pt[-1]
        if 0 < pad <= 16 and pt[-pad:] == bytes([pad]) * pad:
            pt = pt[:-pad]
        if pt[:2] == b"\xff\xd8":
            i = pt.rfind(b"\xff\xd9")
            if i >= 0:
                pt = pt[:i + 2]
        elif pt[:8] == b"\x89PNG\r\n\x1a\n":
            i = pt.rfind(b"IEND")
            if i >= 0:
                pt = pt[:i + 8]
        return pt

    def _img_ct(self, data):
        if data[:8] == b"\x89PNG\r\n\x1a\n":
            return "image/png"
        if data[:4] == b"RIFF" and data[8:12] == b"WEBP":
            return "image/webp"
        if data[:6] in (b"GIF87a", b"GIF89a"):
            return "image/gif"
        return "image/jpeg"

    def _card(self, card):
        a = card.xpath('.//a[contains(@href,"/detail/")]')
        if not a:
            return None
        a = a[0]
        m = re.search(r"/detail/(\d+)/", a.get("href", ""))
        if not m:
            return None
        img = (card.xpath('.//img/@data-src') or card.xpath('.//img/@src') or ["", ""])[0]
        title = "".join(card.xpath('.//*[contains(@class,"hg-drama-card__title")]//text()')).strip()
        if not title:
            title = a.get("title", "").strip()
        if not title:
            return None
        rem = "".join(card.xpath('.//*[contains(@class,"hg-drama-card__episode")]//text()')).strip()
        score = "".join(card.xpath('.//*[contains(@class,"hg-drama-card__score")]//text()')).strip()
        if rem and score:
            rem = rem + " · " + score
        elif not rem:
            rem = score
        return {
            "vod_id": m.group(1),
            "vod_name": title,
            "vod_pic": self._proxy_pic(img),
            "vod_remarks": rem,
        }

    def _cards(self, html, all_grids=False):
        if not html or etree is None:
            return []
        if not isinstance(html, str):
            html = self._ensure_str(html)
        try:
            tree = etree.HTML(html)
        except Exception:
            return []
        if all_grids:
            nodes = []
            for g in tree.xpath('//*[contains(@class,"hg-card-grid")]'):
                nodes.extend(g.xpath('.//*[contains(@class,"hg-drama-card")]'))
        else:
            grids = tree.xpath('//*[contains(@class,"hg-card-grid")]')
            nodes = grids[0].xpath('.//*[contains(@class,"hg-drama-card")]') if grids else []
        out, seen = [], set()
        for card in nodes:
            try:
                item = self._card(card)
                if not item or item["vod_id"] in seen:
                    continue
                seen.add(item["vod_id"])
                out.append(item)
            except Exception:
                continue
        return out

    def _rank_items(self, html):
        if not html or etree is None:
            return []
        if not isinstance(html, str):
            html = self._ensure_str(html)
        try:
            tree = etree.HTML(html)
        except Exception:
            return []
        lists = tree.xpath('//*[contains(@class,"hg-rank-list")]')
        nodes = lists[0].xpath('.//*[contains(@class,"hg-rank-item")]') if lists else tree.xpath('//*[contains(@class,"hg-rank-item")]')
        out, seen = [], set()
        for item in nodes:
            try:
                a = item.xpath('.//a[contains(@href,"/detail/")]')
                if not a:
                    continue
                m = re.search(r"/detail/(\d+)/", a[0].get("href", ""))
                if not m or m.group(1) in seen:
                    continue
                seen.add(m.group(1))
                img = (item.xpath('.//img/@data-src') or item.xpath('.//img/@src') or ["", ""])[0]
                title = "".join(item.xpath('.//*[contains(@class,"hg-rank-item__title")]//text()')).strip()
                if not title:
                    title = a[0].get("title", "").strip()
                if not title:
                    continue
                out.append({
                    "vod_id": m.group(1),
                    "vod_name": title,
                    "vod_pic": self._proxy_pic(img),
                    "vod_remarks": "".join(item.xpath('.//*[contains(@class,"hg-rank-item__tags")]//text()')).strip(),
                })
            except Exception:
                continue
        return out

    def _panel_total(self, html):
        m = re.search(r'data-panel-total="(\d+)"', html or "")
        return int(m.group(1)) if m else 0

    def _api_items(self, path):
        """站点 JSON 接口优先，行为接近真实浏览器持续访问"""
        try:
            data = self._get(self.host + path, asjson=True)
        except Exception:
            return None, None
        if not isinstance(data, dict):
            return None, None
        body = data.get("data")
        if not isinstance(body, dict):
            return None, None
        items = body.get("items")
        if not isinstance(items, list):
            return None, None
        return items, body.get("pagination") if isinstance(body.get("pagination"), dict) else None

    def _api_get(self, path):
        """返回完整 data 字典（含无 items 的嵌套结构）"""
        try:
            data = self._get(self.host + path, asjson=True)
        except Exception:
            return None
        if isinstance(data, dict) and isinstance(data.get("data"), dict):
            return data["data"]
        return None

    def _api_post(self, path, payload=None):
        """POST JSON 接口（播放直链等签名接口需要 POST）"""
        body = json.dumps(payload or {})
        headers = self._headers()
        headers["Content-Type"] = "application/json"
        headers["Accept"] = "application/json, text/plain, */*"
        for _ in range(3):
            raw = None
            sess = self._session_obj()
            try:
                if sess is not None:
                    r = sess.post(self.host + path, data=body, headers=headers, timeout=self._TIMEOUT)
                    raw = r.content
                elif requests is not None:
                    r = requests.post(self.host + path, data=body, headers=headers,
                                      timeout=self._TIMEOUT, verify=False)
                    raw = r.content
                else:
                    import urllib.request as _uq
                    req = _uq.Request(self.host + path, data=body.encode("utf-8"), headers=headers)
                    raw = _uq.urlopen(req, timeout=self._TIMEOUT).read()
                try:
                    return json.loads(self._ensure_str(raw))
                except Exception:
                    return dict()
            except Exception:
                time.sleep(1)
        return dict()

    @staticmethod
    def _api_remarks(item):
        if not isinstance(item, dict):
            return ""
        if item.get("is_finished"):
            try:
                total = int(item.get("episode_count") or item.get("total_episodes") or 0)
            except Exception:
                total = 0
            return ("全%d集" % total) if total else "已完结"
        try:
            ep = int(item.get("episode_count") or 0)
        except Exception:
            ep = 0
        if ep:
            return "更新至%d集" % ep
        score = item.get("score")
        try:
            if score not in (None, ""):
                return str(score) + "分"
        except Exception:
            pass
        return ""

    def _api_video_item(self, item):
        vid = str(item.get("id") or item.get("video_id") or "")
        if not vid:
            return None
        tags = item.get("tags")
        remarks = self._api_remarks(item)
        if isinstance(tags, list) and tags:
            tag_str = "·".join([str(t) for t in tags[:3] if t])
            if tag_str:
                remarks = (remarks + " " + tag_str).strip() if remarks else tag_str
        return {
            "vod_id": vid,
            "vod_name": item.get("title") or "",
            "vod_pic": self._proxy_pic(item.get("cover") or ""),
            "vod_remarks": remarks,
        }

    def _api_rank_item(self, item):
        vid = str(item.get("video_id") or item.get("id") or "")
        if not vid:
            return None
        try:
            rank = item.get("rank")
            label = item.get("metric_label") or ""
            value = item.get("metric_value")
            remarks = ("#%s %s%s" % (rank, label, value)).strip() if rank else ""
        except Exception:
            remarks = ""
        tags = item.get("tags")
        if isinstance(tags, list) and tags:
            tag_str = "·".join([str(t) for t in tags[:3] if t])
            if tag_str:
                remarks = (remarks + " " + tag_str).strip() if remarks else tag_str
        if not remarks:
            remarks = self._api_remarks(item)
        return {
            "vod_id": vid,
            "vod_name": item.get("title") or "",
            "vod_pic": self._proxy_pic(item.get("cover") or ""),
            "vod_remarks": remarks,
        }

    def _page_from(self, pagination, page, limit, fallback_pages=9999):
        """从接口 pagination 读取真实分页，缺失时用列表长度推断"""
        if isinstance(pagination, dict):
            try:
                pages = int(pagination.get("pages") or 0)
            except Exception:
                pages = 0
            try:
                total = int(pagination.get("total") or 0)
            except Exception:
                total = 0
            if pages > 0:
                return pages, (total or pages * max(int(limit or 1), 1))
            if total > 0:
                return max(1, (total + max(int(limit or 1), 1) - 1) // max(int(limit or 1), 1)), total
        return fallback_pages, fallback_pages * max(int(limit or 1), 1)

    def _category_api(self, base_id, sort, page, per=20):
        result = {"list": [], "page": page, "pagecount": 1, "limit": per, "total": 0}
        items, pagination = self._api_items(
            "/api/videos/category/%s?page=%d&size=%d&sort=%s" % (base_id, page, per, sort or "latest"))
        if not items:
            return result
        for it in items:
            v = self._api_video_item(it)
            if v:
                result["list"].append(v)
        pages, total = self._page_from(pagination, page, per)
        result["pagecount"] = max(page, pages) if result["list"] else max(1, page - 1)
        result["total"] = total
        return result

    def _category_ranks(self, rank_type, page, per=20):
        result = {"list": [], "page": page, "pagecount": 1, "limit": per, "total": 0}
        items, pagination = self._api_items(
            "/api/ranks/%s?page=%d&size=%d" % (rank_type or "hot", page, per))
        if not items:
            return result
        for it in items:
            v = self._api_rank_item(it)
            if v:
                result["list"].append(v)
        pages, total = self._page_from(pagination, page, per)
        result["pagecount"] = max(page, pages) if result["list"] else max(1, page - 1)
        result["total"] = total
        return result

    def _category_sort(self, route, page, per=20):
        """站点全局排序路由：/api/videos/sort/:route"""
        result = {"list": [], "page": page, "pagecount": 1, "limit": per, "total": 0}
        items, pagination = self._api_items(
            "/api/videos/sort/%s?page=%d&size=%d" % (route, page, per))
        if not items:
            return result
        for it in items:
            v = self._api_video_item(it)
            if v:
                result["list"].append(v)
        pages, total = self._page_from(pagination, page, per)
        result["pagecount"] = max(page, pages) if result["list"] else max(1, page - 1)
        result["total"] = total
        return result

    def _category_feed(self, page, per=20, path="/api/feed/recommend"):
        """全站推荐流，作精选推荐的分页数据源"""
        result = {"list": [], "page": page, "pagecount": 1, "limit": per, "total": 0}
        items, pagination = self._api_items("%s?page=%d&size=%d" % (path, page, per))
        if not items:
            return result
        for it in items:
            v = self._api_video_item(it)
            if v:
                result["list"].append(v)
        pages, total = self._page_from(pagination, page, per)
        result["pagecount"] = max(page, pages) if result["list"] else max(1, page - 1)
        result["total"] = total
        return result

    def _ensure_cates(self):
        if getattr(self, "categories", None):
            if not getattr(self, "filters", None):
                self.filters = dict()
            return
        self.categories = [
            {"type_id": "recommend", "type_name": "精选推荐"},
            {"type_id": "ai-duanju", "type_name": "AI成人短剧"},
            {"type_id": "ai-manju", "type_name": "AI成人漫剧"},
            {"type_id": "ai-huanlian", "type_name": "AI换脸"},
            {"type_id": "ai-mogai", "type_name": "AI魔改"},
            {"type_id": "ranks", "type_name": "排行榜"},
            {"type_id": "chigua", "type_name": "黄果吃瓜"},
            {"type_id": "topics", "type_name": "话题精选"},
        ]
        self.filters = dict()

    def _is_encrypted(self, url):
        if not url:
            return False
        try:
            from urllib.parse import urlparse as _up
            return _up(url).hostname in self.img_hosts
        except Exception:
            return False

    def _wrap_pic(self, pic):
        return self._proxy_pic(pic)

    @staticmethod
    def _remarks(item):
        if not isinstance(item, dict):
            return ""
        if item.get("is_finished"):
            try:
                total = int(item.get("episode_count") or item.get("total_episodes") or 0)
            except Exception:
                total = 0
            return ("全%d集" % total) if total else "已完结"
        try:
            ep = int(item.get("episode_count") or 0)
        except Exception:
            ep = 0
        return ("更新至%d集" % ep) if ep else ""

    def _category_random(self, base_id):
        return self._category_api(base_id, "random", 1)

    def _category_chigua(self, cate, page):
        """吃瓜文章（/api/posts/category/:route）"""
        per = 20
        result = {"list": [], "page": page, "pagecount": 1, "limit": per, "total": 0}
        route = {"all": "", "remen": "remen-chigua", "yuanchuang": "ai-yuanchuang"}.get(cate, "")
        path = "/api/posts"
        if route:
            path += "/category/" + route
        items, pagination = self._api_items("%s?page=%d&size=%d" % (path, page, per))
        if not items:
            return result
        for it in items:
            pid = str(it.get("id") or "")
            if not pid:
                continue
            tags = it.get("tags")
            tag_str = "·".join([str(t) for t in tags[:3] if t]) if isinstance(tags, list) else ""
            result["list"].append({
                "vod_id": "post_%s" % pid,
                "vod_name": it.get("title") or "",
                "vod_pic": self._proxy_pic(it.get("cover") or ""),
                "vod_remarks": tag_str or "吃瓜",
            })
        pages, total = self._page_from(pagination, page, per)
        result["pagecount"] = max(page, pages) if result["list"] else max(1, page - 1)
        result["total"] = total
        return result

    def _category_topics(self, topic, page):
        """话题专辑视频（/api/topics/:slug），无 slug 时列专辑"""
        per = 20
        result = {"list": [], "page": page, "pagecount": 1, "limit": per, "total": 0}
        if not topic:
            items, pagination = self._api_items("/api/topics?page=%d&size=%d" % (page, per))
            if not items:
                return result
            for it in items:
                slug = str(it.get("slug") or "")
                if not slug:
                    continue
                result["list"].append({
                    "vod_id": "topic_%s" % slug,
                    "vod_name": it.get("title") or "",
                    "vod_pic": self._proxy_pic(it.get("cover") or ""),
                    "vod_remarks": "%s部" % (it.get("video_count") or 0),
                })
            pages, total = self._page_from(pagination, page, per)
            result["pagecount"] = max(page, pages) if result["list"] else max(1, page - 1)
            result["total"] = total
            return result
        body = self._api_get("/api/topics/%s?page=%d&size=%d" % (topic, page, per))
        if not isinstance(body, dict):
            return result
        block = body.get("videos")
        items = block.get("items") if isinstance(block, dict) else None
        pagination = block.get("pagination") if isinstance(block, dict) else None
        if not isinstance(items, list):
            return result
        for it in items:
            v = self._api_video_item(it)
            if v:
                result["list"].append(v)
        pages, total = self._page_from(pagination, page, per)
        result["pagecount"] = max(page, pages) if result["list"] else max(1, page - 1)
        result["total"] = total
        return result

    def homeContent(self, filter=None):
        self._ensure_cates()
        result = {"class": self.categories, "filters": getattr(self, "filters", dict())}
        return result

    def homeVideoContent(self):
        if self._recommend_cache:
            return {"list": self._recommend_cache}
        try:
            items, _ = self._api_items("/api/videos/category/ai-duanju?page=1&size=20&sort=latest")
            vids, seen = [], set()
            for it in items or []:
                v = self._api_video_item(it)
                if not v or v["vod_id"] in seen:
                    continue
                seen.add(v["vod_id"])
                vids.append(v)
            if vids:
                self._recommend_cache = vids
                return {"list": vids}
        except Exception:
            pass
        return {"list": self._cards(self._get(self.host), all_grids=True)}

    def categoryContent(self, tid, pg=1, filter=None, extend=None):
        pg = max(int(pg or 1), 1)
        tid = str(tid or "").strip("/")
        ext = extend if isinstance(extend, dict) else dict()
        if tid == "recommend":
            return self._category_feed(pg)
        if tid in ("ranks", "ranks/hot", "rank"):
            return self._category_ranks(ext.get("rank_type", "hot"), pg)
        if tid == "chigua":
            return self._category_chigua(ext.get("cate", "all"), pg)
        if tid == "topics":
            return self._category_topics(ext.get("tid", ""), pg)
        sort = ext.get("sort", "latest")
        if sort == "random":
            return self._category_api(tid, "random", 1)
        ret = self._category_api(tid, sort, pg)
        if ret.get("list"):
            return ret
        html = self._get(self.host + "/" + tid + ("/" if pg == 1 else "/%d/" % pg))
        cards = self._cards(html) or self._cards(html, all_grids=True) or self._rank_items(html)
        total = self._panel_total(html)
        pagecount = max(1, (total + 23) // 24) if total else 9999
        return {"page": pg, "pagecount": pagecount, "limit": 24, "total": total or 99999, "list": cards}

    def detailContent(self, ids, second="1"):
        if isinstance(ids, (list, tuple)):
            vid = str(ids[0]) if ids else ""
        else:
            vid = str(ids or "")
        vid = vid.strip()
        if not vid:
            return {"list": []}
        ep_no = None
        sid = str(second or "1").strip()
        if "|" in vid:
            vid, sid = vid.split("|", 1)
            vid = vid.strip()
        try:
            ep_no = int(sid)
        except Exception:
            ep_no = None
        if vid.startswith("archives_"):
            return self._detail_archives(vid.replace("archives_", ""))
        if vid.startswith("post_"):
            return self._detail_post(vid.replace("post_", ""))
        if vid.startswith("topic_"):
            return self._detail_topic(vid.replace("topic_", ""), ep_no)
        return self._detail_video(vid, ep_no)

    def _detail_video(self, vid, ep_no=None):
        """视频详情：GET /api/videos/{id}（含 episodes[].ep_num）"""
        result = {"list": []}
        title, cover, desc = "", "", ""
        data = self._api_get("/api/videos/" + str(vid))
        if isinstance(data, dict):
            title = data.get("title", "") or ""
            cover = self._proxy_pic(data.get("cover", "") or "")
            desc = data.get("description", "") or ""
            if not isinstance(desc, str):
                desc = ""
        eps = []
        if isinstance(data, dict):
            raw_eps = data.get("episodes")
            if isinstance(raw_eps, list):
                for e in raw_eps:
                    if not isinstance(e, dict):
                        continue
                    no = e.get("ep_num")
                    try:
                        no = int(no)
                    except Exception:
                        no = 0
                    if no <= 0:
                        continue
                    eps.append(no)
        if not eps:
            eps = [1]
        segs = ["第%d集$%s@%d" % (no, vid, no) for no in sorted(set(eps))]
        if not title:
            title = str(vid)
        remarks = self._api_remarks(data if isinstance(data, dict) else {})
        info = {"vod_id": str(vid), "vod_name": title, "vod_pic": cover,
                "vod_content": desc, "vod_remarks": remarks,
                "vod_play_from": "黄果直链", "vod_play_url": "#".join(segs)}
        if isinstance(data, dict):
            tags = data.get("tags")
            if isinstance(tags, list) and tags:
                tag_str = ",".join([str(t) for t in tags if t])
                if tag_str:
                    info["vod_class"] = tag_str
            sc = data.get("score")
            if sc not in (None, ""):
                info["vod_remarks"] = (str(remarks) + " ").strip() + ("%s分" % sc)
        result["list"].append(info)
        return result

    def _playback_headers(self):
        """播放接口附加解析用请求头（Referer/Origin 需与站点一致）"""
        h = self._headers()
        h["Content-Type"] = "application/json"
        h["Accept"] = "application/json, text/plain, */*"
        h["Sec-Fetch-Dest"] = "empty"
        h["Sec-Fetch-Mode"] = "cors"
        h["Sec-Fetch-Site"] = "same-origin"
        h["Origin"] = self.host
        return h

    def _cdn_header(self, cdn):
        """从 playback 响应的 cdn 节点取出鉴权头"""
        out = {}
        if not isinstance(cdn, dict):
            return out
        k = cdn.get("authKey") or ""
        v = cdn.get("authValue") or ""
        if k and v:
            out[str(k)] = str(v)
        return out

    def _play_stream(self, body, prefer="main"):
        """从 playback 响应 streams 中挑出可播放直链"""
        if not isinstance(body, dict):
            return "", {}
        data = body.get("data") if isinstance(body.get("data"), dict) else body
        streams = data.get("streams") if isinstance(data, dict) else None
        url = ""
        if isinstance(streams, dict):
            if prefer and isinstance(streams.get(prefer), str):
                url = streams[prefer]
            if not url:
                for k in ("main", "hevc", "preview"):
                    v = streams.get(k)
                    if isinstance(v, str) and v:
                        url = v
                        break
        return url, self._cdn_header(data.get("cdn") if isinstance(data, dict) else None)

    def _play_post(self, body):
        """吃瓜文章 playback：data.videos[].url"""
        if not isinstance(body, dict):
            return "", {}
        data = body.get("data") if isinstance(body.get("data"), dict) else body
        vids = data.get("videos") if isinstance(data, dict) else None
        url = ""
        if isinstance(vids, list):
            for v in vids:
                if isinstance(v, dict) and v.get("url"):
                    url = str(v["url"])
                    break
                if isinstance(v, str) and v:
                    url = v
                    break
        return url, self._cdn_header(data.get("cdn") if isinstance(data, dict) else None)

    def _detail_post(self, pid):
        """吃瓜文章详情：GET /api/posts/{id} + POST /api/posts/{id}/playback"""
        result = {"list": []}
        data = self._api_get("/api/posts/" + str(pid))
        if not isinstance(data, dict):
            return result
        title = data.get("title") or ("吃瓜%s" % pid)
        cover = self._proxy_pic(data.get("cover") or "")
        desc = data.get("desc") or ""
        if not desc:
            c = data.get("content")
            if isinstance(c, str):
                desc = re.sub(r"<[^>]+>", " ", c)
                desc = re.sub(r"\s+", " ", desc).strip()
        body = self._api_post("/api/posts/%s/playback" % pid, {})
        segs = []
        block = body.get("data") if isinstance(body.get("data"), dict) else {}
        vids = block.get("videos") if isinstance(block.get("videos"), list) else []
        if vids:
            idx = 0
            for v in vids:
                if isinstance(v, dict) and v.get("url"):
                    try:
                        n = int(v.get("index", idx)) + 1
                    except Exception:
                        n = idx + 1
                    segs.append("第%d集$%s" % (n, v["url"]))
                idx += 1
        if not segs:
            url, _cdn = self._play_post(body)
            if url:
                segs = ["第1集$%s" % url]
        play_url = "#".join(segs) if segs else ("第1集$post_%s" % pid)
        info = {"vod_id": "post_%s" % pid, "vod_name": title, "vod_pic": cover,
                "vod_content": desc, "vod_play_from": "黄果直链",
                "vod_play_url": play_url}
        tags = data.get("tags")
        if isinstance(tags, list) and tags:
            tag_str = ",".join([str(t) for t in tags if t])
            if tag_str:
                info["vod_class"] = tag_str
        result["list"].append(info)
        return result

    def _detail_topic(self, slug, ep_no=None):
        """话题专辑详情：GET /api/topics/{slug}，videos.items 为剧集列表"""
        result = {"list": []}
        data = self._api_get("/api/topics/%s?page=1&size=200" % str(slug))
        if not isinstance(data, dict):
            return result
        topic = data.get("topic") if isinstance(data.get("topic"), dict) else {}
        title = topic.get("title") or ("话题%s" % slug)
        cover = self._proxy_pic(topic.get("cover") or "")
        block = data.get("videos")
        items = block.get("items") if isinstance(block, dict) else None
        if not isinstance(items, list):
            items = []
        segs = []
        i = 1
        for it in items:
            if not isinstance(it, dict):
                continue
            vid = str(it.get("id") or it.get("video_id") or "")
            if not vid:
                continue
            nm = it.get("title") or ("第%d集" % i)
            segs.append("%s$%s@%d" % (nm, vid, i))
            i += 1
        if not segs:
            return result
        pick = 1
        if isinstance(ep_no, int) and ep_no > 0:
            pick = ep_no
        result["play_url"] = "#".join(segs) if segs else ("第1集$topic_%s" % slug)
        info = {"vod_id": "topic_%s" % slug, "vod_name": title, "vod_pic": cover,
                "vod_content": topic.get("intro") or "", "vod_play_from": "黄果直链",
                "vod_play_url": result["play_url"]}
        if i - 1:
            info["vod_remarks"] = "共%d集" % (i - 1)
        result["list"].append(info)
        return result

    def _detail_archives(self, post_id):
        result = {"list": []}
        try:
            html = self._get(self.host + "/archives/%s/" % post_id)
            if not html:
                return result
            tm = re.search(r'<title>(.*?)</title>', html)
            title = (tm.group(1).replace(" - 黄果短剧", "").strip()) if tm else ("吃瓜%s" % post_id)
            pm = re.search(r'data-src="(https?://[^"]+)"', html) or re.search(r'src="(https?://[^"]+)"', html)
            pic = self._proxy_pic(pm.group(1)) if pm else ""
            video_url = ""
            m = re.search(r'<video[^>]+src="(https?://[^"]+)"', html)
            if m:
                video_url = m.group(1)
            if not video_url:
                m = re.search(r'<iframe[^>]+src="(https?://[^"]+)"', html)
                if m:
                    video_url = m.group(1)
            if not video_url:
                m = re.search(r'(https?://[^\s"\'<>]+\.(?:m3u8|mp4)[^\s"\'<>]*)', html)
                if m:
                    video_url = m.group(1)
            play_url = "第1集$%s" % video_url if video_url else "第1集$%s" % post_id
            result["list"].append({"vod_id": "archives_%s" % post_id, "vod_name": title, "vod_pic": pic, "vod_content": "吃瓜内容", "vod_play_from": "黄果短剧", "vod_play_url": play_url})
        except Exception:
            pass
        return result

    def searchContent(self, key, quick=False, pg="1"):
        """搜索：GET /api/search?q=&page&size，按 item 的预览/详情字段归一化"""
        result = {"list": [], "page": 1, "pagecount": 1, "limit": 20, "total": 0}
        try:
            page = max(int(pg or 1), 1)
            kw = str(key or "").strip()
            if not kw:
                return result
            path = "/api/search?q=%s&page=%d&size=20" % (quote(kw), page)
            data = self._api_get(path)
            items = data.get("items") if isinstance(data, dict) else None
            if not isinstance(items, list):
                return result
            videos, seen = [], set()
            for it in items:
                v = self._api_video_item(it)
                if not v or v["vod_id"] in seen:
                    continue
                seen.add(v["vod_id"])
                videos.append(v)
            result["list"] = videos
            pages, total = self._page_from(data.get("pagination") if isinstance(data, dict) else None, page, 20)
            result["page"] = page
            result["pagecount"] = max(page, pages) if videos else 1
            result["total"] = total
        except Exception:
            pass
        return result

    def searchContentPage(self, key, quick=False, pg="1", size="20"):
        return self.searchContent(key, quick, pg)

    def playerContent(self, flag, id, vipFlags=None):
        """播放：POST /api/videos/{id}/episodes/{ep}/playback 或 POST /api/posts/{id}/playback"""
        header = self._playback_headers()
        result = {"parse": 0, "jx": 0, "playUrl": "", "url": "", "header": header,
                  "format": "application/x-mpegURL"}
        if not id:
            return result
        raw = str(id).strip()
        seg_target = ""
        if "$" in raw:
            _, _, tgt = raw.partition("$")
            seg_target = tgt.strip()
            if seg_target.startswith("http") and (".m3u8" in seg_target or ".mp4" in seg_target):
                if ".mp4" in seg_target.lower():
                    result["format"] = "video/mp4"
                result["url"] = seg_target
                return result
        if raw.startswith("http") and (".m3u8" in raw or ".mp4" in raw):
            if ".mp4" in raw.lower():
                result["format"] = "video/mp4"
            result["url"] = raw
            return result
        # detailContent 输出格式："第N集$vid@ep"（vid 可能带 post_/topic_/archives_ 前缀）
        if "$" in raw:
            _, _, target = raw.partition("$")
        else:
            target = raw
        target = target.strip()
        ep = 1
        if "@" in target:
            target, _, eps = target.partition("@")
            target = target.strip()
            try:
                ep = max(int(eps), 1)
            except Exception:
                ep = 1
        if target.startswith("post_"):
            pid = target[len("post_"):]
            body = self._api_post("/api/posts/%s/playback" % pid, {})
            url, cdn = self._play_post(body)
            if url:
                header.update(cdn)
                result["url"] = url
                result["header"] = header
                return result
            result["parse"] = 1
            result["url"] = "%s/archives/%s/" % (self.host, pid)
            return result
        if target.startswith("topic_"):
            slug = target[len("topic_"):]
            data = self._api_get("/api/topics/%s?page=1&size=200" % slug)
            if isinstance(data, dict):
                block = data.get("videos")
                items = block.get("items") if isinstance(block, dict) else None
                if isinstance(items, list):
                    try:
                        idx = items[ep - 1]
                    except Exception:
                        idx = None
                    if isinstance(idx, dict):
                        vid = str(idx.get("id") or idx.get("video_id") or "")
                        if vid:
                            body = self._api_post("/api/videos/%s/episodes/%d/playback" % (vid, ep), {})
                            url, cdn = self._play_stream(body, "main")
                            if url:
                                header.update(cdn)
                                result["url"] = url
                                result["header"] = header
                                return result
            result["parse"] = 1
            result["url"] = "%s/topic/%s/" % (self.host, slug)
            return result
        if target.startswith("archives_"):
            d = self._detail_archives(target[len("archives_"):])
            pu = (d.get("list") or [{}])[0].get("vod_play_url", "")
            parts = pu.split("$", 1)
            if len(parts) == 2 and parts[1].startswith("http"):
                if ".mp4" in parts[1].lower():
                    result["format"] = "video/mp4"
                result["url"] = parts[1]
                return result
            result["parse"] = 1
            result["url"] = "%s/archives/%s/" % (self.host, target[len("archives_"):])
            return result
        # 普通视频 id
        if not target:
            return result
        body = self._api_post("/api/videos/%s/episodes/%d/playback" % (target, ep), {})
        url, cdn = self._play_stream(body, "main")
        if not url:
            body = self._api_post("/api/videos/%s/playback" % target, {})
            url, cdn = self._play_stream(body, "main")
        if url:
            header.update(cdn)
            result["url"] = url
            result["header"] = header
            return result
        result["parse"] = 1
        result["url"] = "%s/video/%s/" % (self.host, target)
        return result

    def proxy(self, param=None):
        result = self.localProxy(param)
        if isinstance(result, (list, tuple)) and len(result) >= 4:
            return [result[0], result[1], result[2]]
        return result

    def localProxy(self, param):
        if isinstance(param, str):
            try:
                param = json.loads(param)
            except Exception:
                param = dict()
        if not isinstance(param, dict):
            param = dict()
        else:
            param = dict(param)
        def _one(v):
            if isinstance(v, (list, tuple)):
                return v[0] if v else ""
            return v
        try:
            kind = _one(param.get("type") or param.get("action") or "")
            kind = str(kind or "").strip().lower()
            if kind not in ("img",):
                kind = "img"
            if kind == "img":
                raw = _one(param.get("url", "")) or ""
                if raw:
                    url = b64decode(unquote(str(raw)).encode("utf-8")).decode("utf-8")
                    url = self._img_src(url)
                    if url:
                        raw2 = self._get_bin(url)
                        if raw2:
                            data = self._decrypt_img(raw2)
                            return [200, self._img_ct(data), data, {"Access-Control-Allow-Origin": "*"}]
        except Exception:
            pass
        return [404, "text/plain", "Not Found", dict()]

    def isVideoFormat(self, url):
        u = (url or "").lower()
        return ".m3u8" in u or ".mp4" in u or ".flv" in u or ".ts" in u or ".m4v" in u

    def manualVideoCheck(self):
        return False

    def action(self, action):
        return dict()

    def destroy(self):
        return None