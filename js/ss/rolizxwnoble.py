import base64
import html as htmlmod
import json
import re
from urllib.parse import quote, unquote, urljoin, urlparse

import requests
from lxml import etree


class Spider:
    def __init__(self):
        self.host = "https://pnd27y1jh1.rolizxwnoble.buzz"
        self.headers = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "Accept-Language": "zh-CN,zh;q=0.9",
            "Referer": "https://pnd27y1jh1.rolizxwnoble.buzz/vod/",
        }
        self.session = requests.Session()
        self.session.headers.update(self.headers)
        self.categories = []

    def getDependence(self):
        return []

    def action(self, action):
        return {}

    def getName(self):
        return "rolizxwnoble"

    def isVideoFormat(self, url):
        if not url:
            return False
        return ".m3u8" in url or ".mp4" in url or ".ts" in url or ".flv" in url

    def manualVideoCheck(self):
        return False

    def destroy(self):
        try:
            self.session.close()
        except Exception:
            pass

    def localProxy(self, param):
        if isinstance(param, str):
            try:
                param = json.loads(param)
            except Exception:
                param = {}
        if not isinstance(param, dict):
            param = {}
        return [404, "text/plain", b"Not Found", {}]

    def init(self, extend=""):
        if isinstance(extend, str) and extend.strip().startswith("http"):
            self.host = extend.strip().rstrip("/")
            self.headers["Referer"] = self.host + "/vod/"
            self.session.headers.update(self.headers)
        text = self._fetch(self.host + "/vod/")
        if text:
            self._load_categories(text)

    def _clean(self, text):
        if not text:
            return ""
        return htmlmod.unescape(re.sub(r"<[^>]+>", "", str(text))).strip()

    def _fix(self, url):
        if not url:
            return ""
        if url.startswith("//"):
            return "https:" + url
        if url.startswith("/"):
            return urljoin(self.host, url)
        return url

    def _fetch(self, url, timeout=30):
        try:
            r = self.session.get(url, headers=self.headers, timeout=timeout, verify=False)
        except Exception as e:
            raise ValueError("网络请求失败: %s" % e)
        r.encoding = "utf-8"
        if r.status_code != 200:
            raise ValueError("HTTP %s: %s" % (r.status_code, url))
        text = r.text
        if self._is_parked(text):
            raise ValueError("站点返回停泊/跳转页，域名疑似已失效: %s" % url)
        return text

    @staticmethod
    def _is_parked(text):
        # 此类镜像站域名过期后由 Cloudflare 停泊页接管：JS 倒计时跳转到无关站点，
        # 页面不含任何 /vodtype/、/voddetail/ 内容，不能当作成功空列表处理
        for kw in ("aissdxi.buzz", "aissdj.buzz", "aissdj.com", "spTime"):
            if kw in (text or ""):
                return True
        return False

    def _load_categories(self, page_text):
        cats = []
        seen = set()
        for tid, name in re.findall(r'<a[^>]+href="/vodtype/(\d+)/"[^>]*>([^<]+)</a>', page_text or ""):
            name = name.strip()
            if not name or tid in seen:
                continue
            seen.add(tid)
            cats.append({"type_id": tid, "type_name": name})
        self.categories = cats
        return cats

    def _parse_list(self, page_text):
        items = []
        if not page_text:
            return items
        doc = etree.HTML(page_text)
        if doc is None:
            return items
        seen = set()
        for dl in doc.xpath("//dl"):
            try:
                alist = dl.xpath('.//a[contains(@href,"/voddetail/")]')
                if not alist:
                    continue
                href = alist[0].get("href") or ""
                m = re.search(r"/voddetail/([^/]+)/?", href)
                if not m:
                    continue
                vid = m.group(1).strip("/")
                if not vid or vid in seen:
                    continue
                seen.add(vid)
                title = ""
                h3 = dl.xpath(".//h3//text()")
                if h3:
                    title = "".join(h3).strip()
                if not title:
                    title = vid
                pic = ""
                for img in dl.xpath(".//img"):
                    cand = img.get("data-original") or img.get("data-src") or img.get("src") or ""
                    if cand and "loading" not in cand:
                        pic = self._fix(cand)
                        break
                items.append({"vod_id": vid, "vod_name": title, "vod_pic": pic, "vod_remarks": ""})
            except Exception:
                continue
        return items

    def homeContent(self, filter=None):
        text = self._fetch(self.host + "/vod/")
        if text:
            self._load_categories(text)
        return {"class": self.categories, "filters": {}}

    def homeVideoContent(self):
        text = self._fetch(self.host + "/vod/")
        return {"list": self._parse_list(text)[:30]}

    def categoryContent(self, tid, pg=1, filter=None, extend=None):
        try:
            pg = int(pg) if pg else 1
        except Exception:
            pg = 1
        tid = str(tid or "").strip().strip("/")
        if pg == 1:
            url = self.host + "/vodtype/" + tid + "/"
        else:
            url = self.host + "/vodtype/" + tid + "/page/" + str(pg) + "/"
        items = self._parse_list(self._fetch(url))
        return {"list": items, "page": pg, "pagecount": pg + 1 if items else pg, "limit": len(items), "total": 0}

    def _parse_detail(self, page_text, vid, base_url):
        title = vid
        m = re.search(r"<h1[^>]*>(.*?)</h1>", page_text or "", re.S)
        if m:
            title = self._clean(m.group(1)) or vid
        cover = ""
        m = re.search(r'data-original="([^"]+)"', page_text or "")
        if m:
            cover = self._fix(m.group(1))
        if not cover:
            m = re.search(r'<meta[^>]*property="og:image"[^>]*content="([^"]+)"', page_text or "")
            if m:
                cover = self._fix(m.group(1))
        content = ""
        m = re.search(r'<meta[^>]*name="description"[^>]*content="([^"]+)"', page_text or "")
        if m:
            content = self._clean(m.group(1))
        links = []
        for phref, pname in re.findall(r'<a[^>]+href="(/vodplay/[^"]+)"[^>]*>(.*?)</a>', page_text or "", re.S):
            pname = self._clean(pname) or "立即播放"
            links.append(pname + "$" + urljoin(base_url, phref))
        for media in set(re.findall(r"https?://[^\s\"'<>]+\.(?:m3u8|mp4|flv)(?:\?[^\s\"'<>]*)?", page_text or "")):
            links.append("直链$" + media)
        if not links:
            raise ValueError("详情页未找到播放链接: %s" % base_url)
        froms = []
        urls = []
        for entry in links:
            name = entry.split("$", 1)[0] or "播放"
            froms.append(name)
            urls.append(entry)
        return {
            "vod_id": vid,
            "vod_name": title,
            "vod_pic": cover,
            "vod_content": content,
            "vod_play_from": "$$$".join(froms),
            "vod_play_url": "$$$".join(urls),
        }

    def detailContent(self, ids):
        if isinstance(ids, (list, tuple)):
            vid = str(ids[0]) if ids else ""
        else:
            vid = str(ids or "")
        vid = vid.strip().strip("/")
        url = self.host + "/voddetail/" + vid + "/"
        page_text = self._fetch(url)
        if not page_text:
            return {"list": []}
        return {"list": [self._parse_detail(page_text, vid, url)]}

    def _extract_play_url(self, page_text):
        if not page_text:
            return ""
        for pat in [
            r"var\s+player_data\s*=\s*(\{.+?\})\s*(?:;|\s*</script>)",
            r"player_data\s*=\s*(\{.+?\})\s*(?:;|\s*</script>)",
        ]:
            m = re.search(pat, page_text, re.S)
            if m:
                try:
                    data = json.loads(m.group(1))
                    url = str(data.get("url", "") or "").strip()
                    enc = str(data.get("encrypt", "0"))
                    if enc == "1":
                        url = unquote(url)
                    elif enc == "2":
                        url = unquote(base64.b64decode(url).decode("utf-8", errors="ignore"))
                    if url:
                        return url
                except Exception:
                    pass
        m = re.search(r"(https?://[^\s\"']+\.m3u8[^\s\"']*)", page_text)
        if m:
            return m.group(1)
        m = re.search(r"(https?://[^\s\"']+\.mp4[^\s\"']*)", page_text)
        if m:
            return m.group(1)
        m = re.search(r'<iframe[^>]+src="([^"]+)"', page_text)
        if m:
            return self._fix(m.group(1))
        return ""

    def playerContent(self, flag, id, vipFlags=None):
        if isinstance(id, (list, tuple)):
            id = str(id[0]) if id else ""
        else:
            id = str(id or "")
        if id and self.isVideoFormat(id):
            parsed = urlparse(id)
            referer = parsed.scheme + "://" + parsed.netloc + "/" if parsed.netloc else self.host + "/"
            return {"parse": 0, "jx": 0, "playUrl": "", "url": id, "header": {"Referer": referer, "User-Agent": self.headers["User-Agent"]}}
        if "/vodplay/" in id:
            page_text = self._fetch(id if id.startswith("http") else urljoin(self.host, id))
            real = self._extract_play_url(page_text)
            if real and self.isVideoFormat(real):
                parsed = urlparse(real)
                referer = parsed.scheme + "://" + parsed.netloc + "/" if parsed.netloc else self.host + "/"
                return {"parse": 0, "jx": 0, "playUrl": "", "url": real, "header": {"Referer": referer, "User-Agent": self.headers["User-Agent"]}}
            return {"parse": 1, "jx": 0, "playUrl": "", "url": id, "header": dict(self.headers)}
        if id.startswith("http"):
            page_text = self._fetch(id)
            real = self._extract_play_url(page_text)
            if real:
                return {"parse": 0, "jx": 0, "playUrl": "", "url": real, "header": dict(self.headers)}
            return {"parse": 1, "jx": 0, "playUrl": "", "url": id, "header": dict(self.headers)}
        return {"parse": 0, "jx": 0, "playUrl": "", "url": id, "header": dict(self.headers)}

    def searchContent(self, key, quick=False, pg="1"):
        try:
            pg = int(pg) if pg else 1
        except Exception:
            pg = 1
        url = self.host + "/vodsearch/-------------/?wd=" + quote(str(key))
        if pg > 1:
            url += "&page=" + str(pg)
        items = self._parse_list(self._fetch(url))
        return {"list": items, "page": pg, "pagecount": pg + 1 if items else pg, "limit": len(items), "total": 0}