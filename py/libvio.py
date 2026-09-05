# -*- coding: utf-8 -*-
import re
import json
import time
import base64
import hashlib
from urllib.parse import quote, unquote
from lxml import etree
try:
    import urllib3
    urllib3.disable_warnings()
except Exception:
    pass
try:
    from base.spider import Spider as BaseSpider
except ImportError:
    class BaseSpider(object):
        def getName(self): return ''
        def init(self, extend=''): pass
        def homeContent(self, filter=False): return {"class": [], "list": [], "filters": {}}
        def homeVideoContent(self): return {"list": []}
        def categoryContent(self, tid, pg, filter=False, extend=''): return {"list": []}
        def detailContent(self, ids): return {"list": []}
        def searchContent(self, key, quick, pg='1'): return {"list": []}
        def playerContent(self, flag, id, vipFlags=None): return {"parse": 0, "url": ""}
        def localProxy(self, param=''): return {}
        def isVideoFormat(self, url): return False
        def manualVideoCheck(self): return False
        def destroy(self): pass


class Spider(BaseSpider):
    def getName(self):
        return "LIBVIO"

    def init(self, extend=""):
        self.host = "https://www.libvio.to"
        self.hosts = ["https://www.libvio.to", "https://libviobd.com", "https://libvio.host"]
        self.headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36", "Referer": self.host + "/", "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8", "Accept-Language": "zh-CN,zh;q=0.9"}
        self.timeout = 15
        self._pow = {}
        try:
            ext = self._parse_extend(extend)
            if ext.get("host"):
                self.host = str(ext["host"]).rstrip("/")
            elif isinstance(ext.get("sites"), list) and ext["sites"]:
                hs = [str(x).rstrip("/") for x in ext["sites"] if str(x).strip()]
                if hs:
                    try:
                        idx = int(ext.get("sitesIndex", 0) or 0)
                    except Exception:
                        idx = 0
                    if 0 <= idx < len(hs):
                        hs = hs[idx:] + hs[:idx]
                    self.hosts = hs
                    self.host = hs[0]
        except Exception:
            pass
        try:
            self.headers["Referer"] = self.host + "/"
        except Exception:
            pass

    @staticmethod
    def _parse_extend(extend):
        if not extend:
            return {}
        if isinstance(extend, dict):
            return extend
        s = str(extend).strip()
        try:
            return json.loads(s)
        except Exception:
            pass
        if "=" in s:
            d = {}
            sep = "&" if "&" in s else (";" if ";" in s else None)
            for p in (s.split(sep) if sep else [s]):
                if "=" in p:
                    k, v = p.split("=", 1)
                    d[k.strip()] = v.strip()
            if d:
                return d
        return {}

    def _solve_pow(self, body):
        try:
            ts = re.search(r'TS\s*=\s*"([^"]+)"', body).group(1)
            sig = re.search(r'SIG\s*=\s*"([^"]+)"', body).group(1)
            diff = re.search(r'DIFF\s*=\s*"([^"]+)"', body).group(1)
            powname = re.search(r'POW\s*=\s*"([^"]+)"', body).group(1)
            m = re.search(r'MODE\s*=\s*"([^"]+)"', body)
            mode = m.group(1) if m else "auto"
            if not (2 <= len(diff) <= 6):
                return None, None
            for i in range(4000000):
                if hashlib.sha256((sig + str(i)).encode()).hexdigest().startswith(diff):
                    return powname, ts + "_" + mode + "_" + str(i) + "_" + sig
        except Exception:
            pass
        return None, None

    def _is_challenge(self, txt):
        try:
            return bool(txt) and len(txt) > 1000 and "SIG" in txt and "DIFF" in txt and "POW" in txt
        except Exception:
            return False

    def _decode_purl(self, u, encrypt=0):
        try:
            if u is None:
                return ""
            s = str(u).strip().replace("\\/", "/").replace("\\", "")
            if not s:
                return ""
            try:
                s = unquote(s)
            except Exception:
                pass
            if s.startswith("http") or s.startswith("//"):
                return ("https:" + s) if s.startswith("//") else s
            try:
                import urllib.parse as _up2
                if "%u" in s or "%" in s:
                    s2 = _up2.unquote(s)
                    if s2.startswith("http"):
                        return s2
            except Exception:
                pass
            b = s.strip()
            if len(b) >= 8 and re.fullmatch(r'[A-Za-z0-9+/=_-]+', b):
                try:
                    c = b.replace("-", "+").replace("_", "/")
                    c += "=" * (-len(c) % 4)
                    d = base64.b64decode(c).decode("utf-8", "ignore").strip()
                    if d.startswith("http") or ".m3u8" in d or ".mp4" in d:
                        return d
                    try:
                        d2 = unquote(d)
                        if d2.startswith("http"):
                            return d2
                    except Exception:
                        pass
                    if d:
                        return d
                except Exception:
                    pass
            return s
        except Exception:
            return str(u or "").strip()

    def _extract_purl(self, html):
        try:
            if not html:
                return "", 0
            enc = 0
            try:
                m0 = re.search(r'"encrypt"\s*:\s*(\d+)', html)
                if m0:
                    enc = int(m0.group(1) or 0)
            except Exception:
                enc = 0
            m = re.search(r'player_aaaa\s*=\s*(\{.*?\})\s*</script>', html, re.S)
            if m:
                try:
                    pd = json.loads(m.group(1))
                    u = str(pd.get("url", "") or "").strip()
                    try:
                        e2 = int(pd.get("encrypt", enc) or enc or 0)
                    except Exception:
                        e2 = enc
                    du = self._decode_purl(u, e2)
                    if du:
                        return du, e2
                except Exception:
                    pass
            for mm in re.finditer(r'"url"\s*:\s*"([^"]+)"', html):
                try:
                    cand = self._decode_purl(mm.group(1), enc)
                    if cand.startswith("http"):
                        if "url_next" in html[max(0, mm.start() - 30):mm.start()]:
                            continue
                        return cand, enc
                    if cand and (".m3u8" in cand or ".mp4" in cand):
                        return cand, enc
                except Exception:
                    continue
            m3 = re.search(r'(https?://[^\s"\'<>\\]+\.(?:m3u8|mp4|mkv|flv)[^\s"\'<>\\]*)', html)
            if m3:
                return m3.group(1).replace("\\/", "/"), enc
            m4 = re.search(r'<iframe[^>]+src=["\']([^"\']+)["\']', html, re.I)
            if m4:
                src = m4.group(1).strip()
                if src.startswith("//"):
                    src = "https:" + src
                if src.startswith("http"):
                    return src, enc
            return "", enc
        except Exception:
            return "", 0

    def _fetch_one(self, url, referer=None):
        h = dict(self.headers)
        hosts = [self.host] + [x for x in (self.hosts or []) if x != self.host]
        if url.startswith("http"):
            try:
                m0 = re.match(r'https?://[^/]+(/.*)', url)
                path = m0.group(1) if m0 else "/"
            except Exception:
                path = "/"
        else:
            path = url if url.startswith("/") else "/" + url
        last_txt = ""
        for host in hosts:
            try:
                base = host.rstrip("/")
                full = base + path
                h["Referer"] = base + "/"
                if referer and isinstance(referer, str) and referer.startswith("http") and "/w/" not in referer and "/detail/" not in referer:
                    h["Referer"] = referer
                ck = self._pow.get(base)
                cj = {ck[0]: ck[1]} if ck else None
                r = self.fetch(full, headers=h, timeout=self.timeout, cookies=cj, verify=False)
                if r is None:
                    continue
                txt = r.text or ""
                if self._is_challenge(txt):
                    pn, val = self._solve_pow(txt)
                    if val:
                        self._pow[base] = (pn, val)
                        try:
                            r2 = self.fetch(full, headers=h, timeout=self.timeout, cookies={pn: val}, verify=False)
                        except Exception:
                            r2 = None
                        if r2 is not None:
                            t2 = r2.text or ""
                            if self._is_challenge(t2):
                                continue
                            if t2 and len(t2) > 500:
                                try:
                                    self.host = base
                                except Exception:
                                    pass
                                return t2
                    continue
                code = getattr(r, "status_code", 200)
                if code == 200 and txt and len(txt) > 500:
                    try:
                        self.host = base
                    except Exception:
                        pass
                    return txt
                if txt and len(txt) > len(last_txt):
                    last_txt = txt
            except Exception:
                continue
        if self._is_challenge(last_txt):
            return ""
        return last_txt if last_txt and len(last_txt) > 500 else ""

    def _get(self, url, referer=None):
        try:
            return self._fetch_one(url, referer) or ""
        except Exception:
            return ""

    def _fix(self, u):
        if not u:
            return ""
        u = str(u).strip()
        if u.startswith("//"):
            return "https:" + u
        if u.startswith("/"):
            return self.host + u
        return u

    def _cards(self, html):
        if not html:
            return []
        try:
            tree = etree.HTML(html)
        except Exception:
            return []
        if tree is None:
            return []
        out, seen = [], set()
        for box in tree.xpath('//div[contains(@class,"stui-vodlist__box")]'):
            try:
                a = box.xpath('.//a[contains(@class,"stui-vodlist__thumb")]')
                if not a:
                    continue
                a = a[0]
                href = a.get("href", "") or ""
                m = re.search(r'/detail/(\d+)\.html', href)
                if not m or m.group(1) in seen:
                    continue
                seen.add(m.group(1))
                title = (a.get("title", "") or "").strip()
                if not title:
                    title = "".join(box.xpath('.//h4[contains(@class,"title")]//text()')).strip()
                if not title:
                    continue
                pic = a.get("data-original", "") or a.get("data-src", "") or ""
                if not pic:
                    pic = "".join(box.xpath('.//img/@data-original | .//img/@data-src | .//img/@src')[:1])
                rem = "".join(box.xpath('.//span[contains(@class,"pic-text")]//text()')).strip()
                sco = "".join(box.xpath('.//span[contains(@class,"pic-tag-top")]//text()')).strip()
                remark = (rem + " " + sco).strip()
                out.append({"vod_id": m.group(1), "vod_name": title, "vod_pic": self._fix(pic), "vod_remarks": remark})
            except Exception:
                continue
        return out

    def _show_url(self, tid, page=1, area="", byv="", lang="", year=""):
        parts = [area or "", byv or "", "", lang or "", "", "", "", str(page or 1), "", "", year or ""]
        return "/show/%s-%s.html" % (str(tid), "-".join(parts))

    def _filters(self):
        years = ["全部", "2026", "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "1999", "1998"]
        yv = lambda arr: [{"n": x, "v": ("" if x == "全部" else x)} for x in arr]
        lang8 = ["全部", "国语", "英语", "粤语", "闽南语", "韩语", "日语", "其它"]
        lang10 = ["全部", "国语", "英语", "粤语", "闽南语", "韩语", "日语", "法语", "德语", "其它"]
        sorts = [{"n": "时间", "v": "time"}, {"n": "人气", "v": "hits"}, {"n": "评分", "v": "score"}]
        a1 = ["全部", "中国大陆", "中国香港", "中国台湾", "美国", "法国", "英国", "日本", "韩国", "德国", "泰国", "印度", "意大利", "西班牙", "加拿大", "其他"]
        a2 = ["全部", "中国大陆", "中国台湾", "中国香港", "韩国", "日本", "美国", "泰国", "英国", "新加坡", "其他"]
        a4 = ["全部", "中国", "日本", "欧美", "其他"]
        a15 = ["全部", "日本", "韩国"]
        a16 = ["全部", "美国", "英国", "德国", "加拿大", "其他"]
        def blk(area, lang):
            return [{"key": "area", "name": "地区", "value": yv(area)}, {"key": "year", "name": "年份", "value": yv(years)}, {"key": "lang", "name": "语言", "value": yv(lang)}, {"key": "by", "name": "排序", "value": sorts}]
        return {"1": blk(a1, lang10), "2": blk(a2, lang8), "4": blk(a4, lang8), "15": blk(a15, lang8), "16": blk(a16, lang8)}

    def homeContent(self, filter):
        classes = [{"type_id": "1", "type_name": "电影"}, {"type_id": "2", "type_name": "剧集"}, {"type_id": "4", "type_name": "番剧"}, {"type_id": "15", "type_name": "日韩"}, {"type_id": "16", "type_name": "欧美"}]
        return {"class": classes, "list": self._cards(self._get("/")), "filters": self._filters()}

    def homeVideoContent(self):
        return {"list": self._cards(self._get("/"))}

    def categoryContent(self, tid, pg, filter, extend):
        try:
            page = int(str(pg or 1))
        except Exception:
            page = 1
        if page < 1:
            page = 1
        tid = str(tid or "2")
        ext = extend if isinstance(extend, dict) else self._parse_extend(extend)
        args = {}
        if isinstance(filter, dict):
            args.update({k: v for k, v in filter.items() if v})
        if isinstance(ext, dict):
            args.update({k: v for k, v in ext.items() if v and k not in args})
        area = str(args.get("area", "") or "")
        byv = str(args.get("by", "") or args.get("sort", "") or "")
        if byv in ("最新", "时间", "d_id"):
            byv = "time"
        if byv in ("最热", "人气", "d_hits"):
            byv = "hits"
        if byv in ("推荐", "评分", "d_score"):
            byv = "score"
        lang = str(args.get("lang", "") or "")
        year = str(args.get("year", "") or "")
        if byv not in ("", "time", "hits", "score"):
            byv = ""
        if area in ("0", "全部"):
            area = ""
        if lang in ("0", "全部"):
            lang = ""
        if year in ("0", "全部"):
            year = ""
        import urllib.parse as _up
        def _q(u):
            return _up.quote(u, safe="/:.-_%")
        html = ""
        items = []
        if area or byv or lang or year:
            html = self._get(_q(self._show_url(tid, page, area, byv, lang, year)))
            items = self._cards(html)
        if not items:
            html = self._get("/type/%s-%s.html" % (tid, page))
            items = self._cards(html)
        if not items and page == 1:
            html = self._get("/type/%s.html" % tid)
            items = self._cards(html)
        pc = page
        try:
            m = re.search(r'(\d+)\s*/\s*(\d+)', html or "")
            if m:
                pc = max(page, int(m.group(2)))
        except Exception:
            pass
        return {"page": page, "pagecount": pc, "limit": len(items), "total": (pc * len(items) if items else 0), "list": items}

    def detailContent(self, ids):
        try:
            vid = str(ids[0] if isinstance(ids, (list, tuple)) else ids).strip()
        except Exception:
            return {"list": []}
        if not vid:
            return {"list": []}
        html = self._get("/detail/%s.html" % vid)
        if not html:
            return {"list": []}
        try:
            tree = etree.HTML(html)
        except Exception:
            return {"list": []}
        if tree is None:
            return {"list": []}
        name = "".join(tree.xpath('//h1[contains(@class,"title")]//text()')).strip()
        if not name:
            t = "".join(tree.xpath('//title//text()')).strip()
            name = re.sub(r'\s*[-\u2013\u2014]\s*LIBVIO.*$', '', t).strip() or vid
        metas = [x.strip() for x in tree.xpath('//span[contains(@class,"meta-item")]//text()') if x.strip()]
        cate, area, year, release, total, update, actors, director = "", "", "", "", "", "", "", ""
        for txt in metas:
            if txt.startswith("主演：") or txt.startswith("主演:"):
                actors = re.sub(r'^主演[:：]?', '', txt).strip()
            elif txt.startswith("导演：") or txt.startswith("导演:"):
                director = re.sub(r'^导演[:：]?', '', txt).strip()
            elif txt.startswith("上映"):
                release = txt[2:].strip()
            elif txt.startswith("共") and "集" in txt:
                total = txt
            elif txt.startswith("更新"):
                update = txt[2:].strip()
            elif re.fullmatch(r'(19|20)\d{2}', txt):
                year = txt
            elif not cate and re.search(r'剧情|喜剧|动作|爱情|科幻|悬疑|恐怖|犯罪|动画|冒险|奇幻|纪录|家庭|历史|战争', txt):
                cate = txt
            elif not area and len(txt) <= 12:
                area = txt
        if not cate and metas:
            cate = metas[0]
        intro = "".join(tree.xpath('//span[contains(@class,"detail-content")]//text()')).strip()
        if not intro:
            intro = "".join(tree.xpath('//span[contains(@class,"detail-sketch")]//text()')).strip()
        score = "".join(tree.xpath('//*[contains(@class,"vod-rating")]//span[contains(@class,"score")]//text()')).strip().replace("分", "")
        douban = "".join(tree.xpath('//a[contains(@href,"douban.com")]/@href')[:1])
        pic = "".join(tree.xpath('//*[contains(@class,"vod-poster__wrap")]//img/@data-original | //*[contains(@class,"vod-poster__wrap")]//img/@src | //*[contains(@class,"vod-poster")]//img/@data-original | //*[contains(@class,"vod-poster")]//img/@src')[:1])
        froms, urls = [], []
        for panel in tree.xpath('//div[contains(@class,"playlist-panel")]'):
            try:
                eps = panel.xpath('.//a[contains(@href,"/w/")]')
                nds = panel.xpath('.//a[contains(@class,"netdisk-item")]')
                if eps:
                    head = "".join(panel.xpath('.//h3//text()')).strip() or ("线路%s" % (len(froms) + 1))
                    arr = []
                    for a in eps:
                        nm = "".join(a.xpath(".//text()")).strip() or "播放"
                        arr.append("%s$%s" % (nm, self._fix(a.get("href", ""))))
                    if arr:
                        froms.append(head)
                        urls.append("#".join(arr))
                elif nds:
                    head = "".join(panel.xpath('.//h3//text()')).strip() or "网盘下载"
                    arr = []
                    for a in nds:
                        href = a.get("href", "") or ""
                        nm = "".join(a.xpath('.//span[contains(@class,"netdisk-name")]//text()')).strip()
                        if not nm:
                            nm = "".join(a.xpath('.//span[contains(@class,"netdisk-url")]//text()')).strip()[:40] or "网盘"
                        if href:
                            arr.append("%s$%s" % (nm, href))
                    if arr:
                        froms.append(head)
                        urls.append("#".join(arr))
            except Exception:
                continue
        vod = {"vod_id": vid, "vod_name": name, "vod_pic": self._fix(pic), "vod_year": year, "vod_area": area, "vod_director": director, "vod_actor": actors, "vod_remarks": (total or update or score), "vod_content": intro, "type_name": cate}
        if release:
            try:
                m = re.search(r'(19|20)\d{2}', release)
                if m and not vod.get("vod_year"):
                    vod["vod_year"] = m.group(0)
            except Exception:
                pass
        if douban:
            vod["vod_douban"] = douban
        if score:
            vod["vod_score"] = score
        vod["vod_play_from"] = "$$$".join(froms)
        vod["vod_play_url"] = "$$$".join(urls)
        return {"list": [vod]}

    def searchContent(self, key, quick, pg="1"):
        try:
            page = int(str(pg or 1))
        except Exception:
            page = 1
        kw = quote(str(key or "").strip())
        if not kw:
            return {"list": [], "page": page}
        items = self._cards(self._get("/search/%s----------%s---.html" % (kw, page)))
        return {"list": items, "page": page}

    def playerContent(self, flag, id, vipFlags):
        try:
            token = str(id or "").strip()
        except Exception:
            return {"parse": 0, "url": ""}
        if not token:
            return {"parse": 0, "url": ""}
        if token.startswith("//"):
            token = "https:" + token
        if any(x in token for x in ("pan.", "magnet:", "thunder:", "ed2k:")):
            return {"parse": 1, "url": token}
        if "$" in token:
            token = token.split("$")[-1].strip()
        url = self._fix(token)
        if url.startswith("http") and "/w/" not in url and (".m3u8" in url or ".mp4" in url or ".mkv" in url or ".flv" in url):
            h = dict(self.headers)
            h["Referer"] = self.host + "/"
            return {"parse": 0, "url": url, "header": h}
        if url.startswith("http") and "/w/" not in url:
            return {"parse": 1, "url": url}
        last_url = url
        for att in range(3):
            try:
                html = self._get(url, referer=url)
            except Exception:
                html = ""
            if not html or len(html) < 500 or self._is_challenge(html):
                try:
                    time.sleep(0.5 * (att + 1))
                except Exception:
                    pass
                continue
            try:
                purl, _enc = self._extract_purl(html)
            except Exception:
                purl = ""
            try:
                if purl.startswith("//"):
                    purl = "https:" + purl
            except Exception:
                pass
            if purl and purl.startswith("http"):
                if any(x in purl for x in ("pan.", "magnet:", "thunder:", "ed2k:")):
                    return {"parse": 1, "url": purl}
                try:
                    ref = re.match(r'(https?://[^/]+)', url).group(1)
                except Exception:
                    ref = self.host
                h = {"User-Agent": self.headers.get("User-Agent", "Mozilla/5.0"), "Referer": ref + "/"}
                if ".m3u8" in purl or ".mp4" in purl or ".mkv" in purl or ".flv" in purl:
                    return {"parse": 0, "url": purl, "header": h}
                if purl.endswith(".html") or "/w/" in purl or "<iframe" in html and "iframe" in purl:
                    return {"parse": 1, "url": purl}
                return {"parse": 0, "url": purl, "header": h}
            try:
                time.sleep(0.5 * (att + 1))
            except Exception:
                pass
        return {"parse": 1, "url": last_url}

    def isVideoFormat(self, url):
        try:
            return any(x in str(url or "") for x in (".m3u8", ".mp4", ".mkv", ".flv"))
        except Exception:
            return False

    def manualVideoCheck(self):
        return False

    def localProxy(self, param):
        return None

    def destroy(self):
        return None
