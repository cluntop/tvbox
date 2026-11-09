import base64
import html as htmlmod
import json
import re
import struct
import zlib
from urllib.parse import quote, unquote
try:
    import requests
except ImportError:
    requests = None
try:
    from lxml import etree
except ImportError:
    etree = None
# 六壳契约：TVBox / fongmi / 默影视 / 影视仓 / OK影视 / PickTV 均要求可静态识别的基类导入
try:
    from base.spider import Spider as _BaseSpider
except Exception:
    try:
        import sys as _sys
        _sys.path.append("..")
        from base.spider import Spider as _BaseSpider
    except Exception:
        try:
            import importlib as _importlib
            _BaseSpider = _importlib.import_module("base.spider").Spider
        except Exception:
            class _BaseSpider:
                def __init__(self):
                    self.extend = ""
                def fetch(self, url, params=None, cookies=None, headers=None, timeout=5, verify=True, stream=False, allow_redirects=True):
                    if requests is None:
                        raise RuntimeError("requests unavailable")
                    return requests.get(url, params=params, cookies=cookies, headers=headers, timeout=timeout, verify=verify, stream=stream, allow_redirects=allow_redirects)
                def post(self, url, params=None, data=None, json=None, cookies=None, headers=None, timeout=5, verify=True, stream=False, allow_redirects=True):
                    if requests is None:
                        raise RuntimeError("requests unavailable")
                    return requests.post(url, params=params, data=data, json=json, cookies=cookies, headers=headers, timeout=timeout, verify=verify, stream=stream, allow_redirects=allow_redirects)
                def getProxyUrl(self, local=True):
                    return "http://127.0.0.1:9978/proxy?do=py"
class Spider(_BaseSpider):
    HOSTS = [
        "https://rou.video",
        "https://rouvb1.xyz",
        "https://rouva8.xyz",
        "https://rou-video.zproxy.org",
    ]
    PUB_PAGE_URL = "https://rdz3.xyz/dizhi"

    def __init__(self):
        try:
            _BaseSpider.__init__(self)
        except Exception:
            self.extend = ""
        self._current_host_idx = 0
        self._fetched_pub_hosts = False
        self._destroyed = False
        self._timeout = 20
        self.host = self.HOSTS[0]
        self.headers = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
            "Referer": self.HOSTS[0] + "/",
            "Accept-Language": "zh-CN,zh;q=0.9",
        }
        self.s = None
        self.session = None
        self.sess = None
        try:
            if requests is not None:
                self.s = requests.Session()
                self.s.headers.update(self.headers)
                self.s.verify = False
                self.session = self.s
                self.sess = self.s
        except Exception:
            pass

    def getDependence(self):
        return []

    def getName(self):
        return "肉视频"

    def _ext_cfg(self, extend):
        cfg = {}
        if isinstance(extend, dict):
            cfg = dict(extend)
        elif isinstance(extend, str):
            text = extend.strip()
            if text.startswith("{"):
                try:
                    parsed = json.loads(text)
                    if isinstance(parsed, dict):
                        cfg = parsed
                except Exception:
                    cfg = {}
            elif text.startswith("http"):
                cfg = {"site": text}
            elif text:
                cfg = {"site": text}
        return cfg

    def init(self, extend=""):
        self.extend = extend
        self._destroyed = False
        cfg = self._ext_cfg(extend)
        site = str(cfg.get("site", "") or "").strip().rstrip("/")
        if site.startswith("http"):
            self._set_host(site)
        hosts = cfg.get("hosts", "")
        if isinstance(hosts, str) and hosts.strip():
            for h in re.split(r"[,\s;|]+", hosts.strip()):
                h = h.strip().rstrip("/")
                if h.startswith("http") and h not in self.HOSTS:
                    self.HOSTS.append(h)
        elif isinstance(hosts, list):
            for h in hosts:
                h = str(h or "").strip().rstrip("/")
                if h.startswith("http") and h not in self.HOSTS:
                    self.HOSTS.append(h)
        ua = str(cfg.get("ua", "") or "").strip()
        if ua:
            self.headers["User-Agent"] = ua
            try:
                if self.s is not None:
                    self.s.headers.update(self.headers)
            except Exception:
                pass
        timeout = cfg.get("timeout", "")
        try:
            timeout = int(timeout) if str(timeout).strip() else 20
        except Exception:
            timeout = 20
        if timeout < 5:
            timeout = 5
        if timeout > 60:
            timeout = 60
        self._timeout = timeout
        pub = str(cfg.get("pub", "") or "").strip().rstrip("/")
        if pub.startswith("http"):
            self.PUB_PAGE_URL = pub

    def _set_host(self, host):
        host = (host or "").rstrip("/")
        if not host:
            return
        if host not in self.HOSTS:
            self.HOSTS.append(host)
            self._current_host_idx = len(self.HOSTS) - 1
        else:
            self._current_host_idx = self.HOSTS.index(host)
        self.host = self.HOSTS[self._current_host_idx]
        self.headers["Referer"] = self.host + "/"
        try:
            if self.s is not None:
                self.s.headers.update(self.headers)
        except Exception:
            pass

    @property
    def HOST(self):
        return self.HOSTS[self._current_host_idx]

    def _timeout_value(self):
        return getattr(self, "_timeout", 20)

    def _clean(self, text):
        if not text:
            return ""
        return htmlmod.unescape(re.sub(r"<[^>]+>", "", str(text))).strip()

    def _fix(self, u):
        if not u:
            return ""
        u = u.strip()
        if u.startswith("//"):
            return "https:" + u
        if u.startswith("/"):
            return self.HOST + u
        return u

    def _get(self, url, headers=None):
        if getattr(self, "_destroyed", False):
            return ""
        headers = headers or dict(self.headers)
        timeout = self._timeout_value()
        try:
            if self.s is not None:
                r = self.s.get(url, headers=headers, timeout=timeout)
                r.encoding = "utf-8"
                if r.status_code == 200 and r.text:
                    return r.text
        except Exception:
            pass
        try:
            r = self.fetch(url, headers=headers, timeout=timeout, verify=False)
            if r is not None and getattr(r, "status_code", 0) == 200:
                try:
                    r.encoding = "utf-8"
                except Exception:
                    pass
                text = r.text
                if text:
                    return text
        except Exception:
            pass
        try:
            import urllib.request
            req = urllib.request.Request(url, headers=headers)
            with urllib.request.urlopen(req, timeout=timeout) as resp:
                raw = resp.read()
                for enc in ("utf-8", "gbk", "big5"):
                    try:
                        return raw.decode(enc)
                    except Exception:
                        continue
                return raw.decode("utf-8", "ignore")
        except Exception:
            return ""

    def _get_bytes(self, url, headers=None):
        if getattr(self, "_destroyed", False):
            return b""
        headers = headers or dict(self.headers)
        timeout = self._timeout_value()
        try:
            if self.s is not None:
                r = self.s.get(url, headers=headers, timeout=timeout)
                if r.status_code == 200 and r.content:
                    return r.content
        except Exception:
            pass
        try:
            r = self.fetch(url, headers=headers, timeout=timeout, verify=False)
            if r is not None and getattr(r, "status_code", 0) == 200:
                content = getattr(r, "content", b"")
                if content:
                    return content
        except Exception:
            pass
        return b""

    def _refresh_hosts_from_pub(self):
        if self._fetched_pub_hosts:
            return
        self._fetched_pub_hosts = True
        try:
            html = self._get(self.PUB_PAGE_URL, headers={
                "User-Agent": self.headers["User-Agent"],
                "Referer": "https://rdz3.xyz/",
            })
            if not html:
                return
            found = []
            for sec in re.split(r"<section", html):
                if ("肉視頻" in sec or "肉视频" in sec) and ("科学地址" in sec or "永久地址" in sec):
                    for m in re.finditer(r'href="(https?://[^"]+)"', sec):
                        href = m.group(1).strip().rstrip("/")
                        if href and href not in found:
                            found.append(href)
                    for m in re.finditer(r'<span class="url">(https?://[^<]+)</span>', sec):
                        href = m.group(1).strip().rstrip("/")
                        if href and href not in found:
                            found.append(href)
            for href in found:
                if href not in self.HOSTS:
                    self.HOSTS.append(href)
        except Exception:
            pass

    def _req(self, path):
        for i in range(len(self.HOSTS)):
            idx = (self._current_host_idx + i) % len(self.HOSTS)
            host = self.HOSTS[idx]
            url = "%s%s" % (host, path)
            headers = dict(self.headers)
            headers["Referer"] = host + "/"
            html = self._get(url, headers=headers)
            if html:
                self._current_host_idx = idx
                self.host = self.HOSTS[idx]
                return html
        self._refresh_hosts_from_pub()
        for i in range(len(self.HOSTS)):
            host = self.HOSTS[i]
            url = "%s%s" % (host, path)
            headers = dict(self.headers)
            headers["Referer"] = host + "/"
            html = self._get(url, headers=headers)
            if html:
                self._current_host_idx = i
                self.host = self.HOSTS[i]
                return html
        return ""

    def _decrypt_ev(self, ev_d, ev_k=35):
        try:
            b = base64.b64decode(ev_d)
            k = int(ev_k)
            raw = bytes([(x - k) % 256 for x in b])
            return json.loads(raw.decode("utf-8", "replace"))
        except Exception:
            return {}

    def _extract_ev(self, html):
        if not html:
            return {}
        m = re.search(r'ev:\$R\[\d+\]=\{d:"([^"]+)",k:(\d+)\}', html)
        if m:
            return self._decrypt_ev(m.group(1), int(m.group(2)))
        m = re.search(r'"ev"\s*:\s*\{"d"\s*:\s*"([^"]+)"\s*,\s*"k"\s*:\s*(\d+)', html)
        if m:
            return self._decrypt_ev(m.group(1), int(m.group(2)))
        return {}

    def _extract_tsr_videos(self, html):
        if not html or "self.$R" not in html:
            return []
        try:
            blob = html[html.find("self.$R"):html.find("self.$R") + 400000]
            vids = []
            for m in re.finditer(r'\{id:"([A-Za-z0-9]+)",vid:(?:"([^"]*)"|null),name:"((?:[^"\\]|\\.)*)"', blob):
                vid = m.group(1)
                name = m.group(3).encode().decode("unicode_escape", "ignore") if "\\u" in m.group(3) else m.group(3)
                name = name.replace('\\"', '"').strip()
                if not vid or not name or len(vid) > 60:
                    continue
                vids.append((vid, name))
            if not vids:
                return []
            covers = {}
            for m in re.finditer(r'id:"([A-Za-z0-9]+)".{0,2500}?coverImageUrl:"([^"]+)"', blob):
                covers[m.group(1)] = m.group(2)
            tags_map = {}
            for m in re.finditer(r'id:"([A-Za-z0-9]+)".{0,1200}?tags:\$R\[\d+\]=\["([^"\]]+)"', blob):
                try:
                    tags_map[m.group(1)] = m.group(2)
                except Exception:
                    pass
            out, seen = [], set()
            for vid, name in vids:
                if vid in seen:
                    continue
                seen.add(vid)
                pic = covers.get(vid, "")
                item = {"vod_id": vid, "vod_name": self._clean(name), "vod_pic": pic}
                if tags_map.get(vid):
                    item["vod_remarks"] = self._clean(tags_map[vid])
                out.append(item)
            return out
        except Exception:
            return []

    def _parse_dom_list(self, html):
        out, seen = [], set()
        if not html:
            return out
        try:
            if etree is not None:
                doc = etree.HTML(html)
                if doc is not None:
                    for a in doc.xpath('//a[starts-with(@href,"/v/")]'):
                        try:
                            href = (a.get("href") or "").strip()
                            vid = href.replace("/v/", "").strip().strip("/")
                            if not vid or "/" in vid or vid in seen:
                                continue
                            name = "".join(a.xpath('.//h3//text()')).strip()
                            if not name:
                                name = "".join(a.xpath('.//img/@alt')).strip()
                            if not name:
                                continue
                            imgs = a.xpath('.//img/@src')
                            pic = ""
                            for cand in imgs:
                                cand = (cand or "").strip()
                                if cand and "data:image" not in cand:
                                    if not pic:
                                        pic = cand
                                    if "blur-sm" not in (a.xpath('.//img')[0].get("class", "") if a.xpath('.//img') else ""):
                                        pic = cand
                                        break
                            if len(imgs) >= 2 and not pic:
                                pic = imgs[1]
                            remarks = ""
                            for t in a.xpath('.//span[contains(@class,"absolute") or contains(@class,"bg-feature") or contains(@class,"bg-[#071015")]//text()'):
                                t = t.strip()
                                if t and t != name and len(t) < 20:
                                    remarks = t
                                    break
                            seen.add(vid)
                            item = {"vod_id": vid, "vod_name": self._clean(name), "vod_pic": pic}
                            if remarks:
                                item["vod_remarks"] = remarks
                            out.append(item)
                        except Exception:
                            continue
                    if out:
                        return out
            for m in re.finditer(r'<a[^>]+href="(/v/[^"]+)"[^>]*>(.*?)</a>', html, re.S):
                try:
                    href = m.group(1)
                    inner = m.group(2)
                    vid = href.replace("/v/", "").strip().strip("/")
                    if not vid or "/" in vid or vid in seen:
                        continue
                    h = re.search(r"<h3[^>]*>(.*?)</h3>", inner, re.S)
                    name = self._clean(h.group(1)) if h else ""
                    if not name:
                        am = re.search(r'alt="([^"]+)"', inner)
                        name = self._clean(am.group(1)) if am else ""
                    if not name:
                        continue
                    pics = re.findall(r'src="([^"]+)"', inner)
                    pic = ""
                    for cand in pics:
                        if cand and "data:image" not in cand:
                            pic = cand
                    rm = re.search(r'<span[^>]*>(720P|1080P|\d+分\d+秒|\d+:\d+)</span>', inner)
                    seen.add(vid)
                    item = {"vod_id": vid, "vod_name": name, "vod_pic": pic}
                    if rm:
                        item["vod_remarks"] = rm.group(1)
                    out.append(item)
                except Exception:
                    continue
        except Exception:
            pass
        return out

    def _parse_pagecount(self, html, page="1"):
        try:
            p_num = int(str(page)) if str(page).isdigit() else 1
        except Exception:
            p_num = 1
        max_page = p_num
        if html:
            for m in re.finditer(r'[?&](?:amp;)?page=(\d+)', html):
                try:
                    n = int(m.group(1))
                    if n > max_page:
                        max_page = n
                except Exception:
                    continue
        return p_num, (max_page if max_page > p_num else p_num)

    def _parse_video_list(self, html, page="1"):
        videos = self._extract_tsr_videos(html)
        if not videos:
            videos = self._parse_dom_list(html)
        p_num, pagecount = self._parse_pagecount(html, page)
        return {"page": p_num, "pagecount": pagecount, "limit": len(videos) or 20, "list": videos}

    def _norm_extend(self, extend):
        if isinstance(extend, str):
            try:
                extend = json.loads(extend) if extend.strip().startswith("{") else {}
            except Exception:
                extend = {}
        if not isinstance(extend, dict):
            extend = {}
        return extend

    def _first(self, value, default=""):
        if isinstance(value, list):
            return str(value[0]) if value else default
        return str(value) if value not in (None, "") else default

    def _order_value(self, extend):
        extend = self._norm_extend(extend)
        return self._first(extend.get("order", "createdAt"), "createdAt") or "createdAt"

    def _sub_cate_value(self, extend):
        extend = self._norm_extend(extend)
        return self._first(extend.get("sub_cate", ""), "")

    def homeContent(self, filter=None):
        classes = [
            {"type_id": "國產AV", "type_name": "國產AV"},
            {"type_id": "麻豆傳媒", "type_name": "麻豆傳媒"},
            {"type_id": "探花", "type_name": "探花"},
            {"type_id": "自拍流出", "type_name": "自拍流出"},
            {"type_id": "OnlyFans", "type_name": "OnlyFans"},
            {"type_id": "日本", "type_name": "日本"},
            {"type_id": "全部视频", "type_name": "全部视频"},
            {"type_id": "视频分类", "type_name": "视频分类"},
        ]
        order_filter = {"key": "order", "name": "排序", "value": [
            {"n": "最新发布", "v": "createdAt"},
            {"n": "最多观看", "v": "viewCount"},
            {"n": "最多点赞", "v": "likeCount"},
        ]}
        sub_all = lambda rows: [{"n": "全部", "v": ""}] + [{"n": r, "v": r} for r in rows]
        filters = {
            "國產AV": [order_filter, {"key": "sub_cate", "name": "厂牌/频道", "value": sub_all(["糖心Vlog", "蜜桃影像傳媒", "香蕉視頻傳媒", "星空無限傳媒", "天美傳媒", "精東影業", "杏吧傳媒", "91製片廠", "皇家華人", "起點傳媒", "大象傳媒", "果凍傳媒", "蘿莉社", "ED Mosaic", "兔子先生", "扣扣傳媒", "SA國際傳媒", "愛神傳媒", "性視界傳媒", "PsychopornTW", "拍攝花絮", "抖陰", "91茄子", "絕對領域傳媒", "烏托邦傳媒", "紅斯燈影像", "草莓視頻", "渡邊傳媒", "葫蘆影業", "樂播傳媒", "Pussy Hunter", "麻麻傳媒", "三只狼傳媒", "萝莉原创", "辣椒原創", "MisAV", "SWAG@daisybaby", "冠希傳媒", "微密圈傳媒", "愛妃傳媒", "天美影院", "西瓜影視", "肉肉傳媒", "烏鴉傳媒", "日出文化", "鯨魚傳媒", "國產AV劇情", "SWAG@cartiernn", "TWAV", "Mini傳媒", "桃花源", "叮叮映畫", "蜜桃視頻", "O-STAR", "開心鬼傳媒", "葵心娛樂", "愛污傳媒"])}],
            "麻豆傳媒": [order_filter, {"key": "sub_cate", "name": "厂牌/系列", "value": sub_all(["愛豆傳媒", "MD", "MDX", "麻豆US", "MSD", "MCY", "MKY", "MPG", "FLIXKO", "貓爪影像", "國產麻豆AV節目", "麻豆女神微愛視頻", "麻豆番外", "麻豆三十天特別企劃", "麻豆導演系列", "情趣K歌房", "MDWP", "突襲女優家", "麻豆女優", "麻豆達人秀", "澀會", "MDS", "MDSR", "麻豆女神微愛影片", "MDL", "MAN", "MSM", "MDHT", "MDAG", "MS", "MSG", "MDJ", "MDM", "MXJ", "MDD", "MLT"])}],
            "探花": [order_filter, {"key": "sub_cate", "name": "主播/探花", "value": sub_all(["91沈先生", "探花精選400", "小寶尋花", "91lisa", "調教小景甜", "午夜尋花", "91鳳鳴鳥唱", "大神精選", "AVOVE直播", "91貓先生", "千人斬探花", "全國探花", "91Fans", "七天探花", "9總全國探花", "91大神@LovELolita7", "18歲母狗無限高潮", "鴨哥探花", "锤子探花", "探花合集", "91不見星空", "早期東莞ISO桑拿系列", "91康先生", "肉オナホ", "91大神唐伯虎", "韋小寶", "91風流哥全集", "91蜜桃的合集", "換妻探花", "小陳頭星選", "91大神括約肌大叔", "情侶自拍", "探花精選", "91呆哥", "mmmn753", "楊導撩妹", "歌廳探花陳先生", "91美女涵菱", "太子探花", "小馬尋花", "91唐哥", "jimmybiiig", "91天堂原創", "小飛探花", "文軒探花", "王子哥專啪學生妹", "偉哥尋歡", "大草莓寶貝", "探花女下海直播", "91天堂系列", "91大神胖Kyo", "攝影師果哥出品", "莞式選妃", "catman", "90w粉", "探花大神", "91原創達人@多乙丶", "91大黃鴨", "小東全國尋妹", "91Dr哥", "大熊探花", "91約妹達人", "91大神揚風", "91愛絲小仙女思妍", "探花郎李尋歡", "91新晉大神sweattt", "91新人GD超模（現改名69DD）", "91大神jinx", "91sex哥", "175車模", "東莞探花", "嫖嫖sex探花", "秀人網模特"])}],
            "OnlyFans": [order_filter, {"key": "sub_cate", "name": "创作者", "value": sub_all(["fansly", "tangbo_hu", "HongKongDoll", "BunnyMiffy", "Nana_Taipei", "qiobnxingcai", "suchanghub", "ssrpeach", "nicolove.cc", "Miuzxc", "yui_xin_tw", "kitty2002102", "kittyxkum", "juneliu", "YuZuKitty", "jeenzen", "monmon_tw", "applecptv", "Loliiiiipop99", "andmlove", "daintywilder", "ZZZ666", "aixiaixi", "ChiChibae", "blazeconjure3", "moremore618", "bdollairi", "olive_emmm", "chocoletmilkk", "SLRabbit", "Xreindeers", "Carla Grace"])}],
            "自拍流出": [order_filter],
            "日本": [order_filter],
            "全部视频": [order_filter],
        }
        return {"class": classes, "filters": filters, "list": []}

    def homeVideoContent(self):
        try:
            return self.categoryContent("全部视频", "1", False, {})
        except Exception:
            return {"list": []}

    def categoryContent(self, tid, pg=1, filter=None, extend=None):
        extend = self._norm_extend(extend)
        page = str(pg or "1").strip()
        if not page.isdigit():
            page = "1"
        order = self._order_value(extend)
        tid = str(tid or "").strip()
        if tid.startswith("cat_tag:"):
            real_tag = tid.replace("cat_tag:", "").strip()
            return self._parse_video_list(self._req("/t/%s?order=%s&page=%s" % (quote(real_tag), order, page)), page)
        if tid == "视频分类":
            return self._parse_three_level_categories()
        if tid == "全部视频":
            return self._parse_video_list(self._req("/v?order=%s&page=%s" % (order, page)), page)
        cate_id = self._sub_cate_value(extend) or tid
        return self._parse_video_list(self._req("/t/%s?order=%s&page=%s" % (quote(cate_id), order, page)), page)

    def _parse_three_level_categories(self):
        tag_items, seen = [], set()
        try:
            html = self._req("/cat")
            if html:
                for m in re.finditer(r'href="(/t/[^"]+)"[^>]*>(.*?)</a>', html, re.S):
                    try:
                        href = m.group(1)
                        tag_name = unquote(href.replace("/t/", "").strip())
                        if not tag_name or tag_name in seen or len(tag_name) > 40:
                            continue
                        seen.add(tag_name)
                        tag_items.append({"vod_id": "cat_tag:%s" % tag_name, "vod_name": tag_name, "vod_pic": self.HOST + "/favicon.ico", "vod_remarks": "分类目录", "vod_tag": "folder"})
                    except Exception:
                        continue
        except Exception:
            pass
        return {"page": 1, "pagecount": 1, "limit": len(tag_items), "total": len(tag_items), "list": tag_items}

    def searchContent(self, key, quick=False, pg="1"):
        page = str(pg or "1").strip()
        if not page.isdigit():
            page = "1"
        html = self._req("/search?q=%s&t=&sort=&page=%s" % (quote(str(key or "")), page))
        if not html:
            return {"page": int(page), "pagecount": int(page), "limit": 0, "list": []}
        return self._parse_video_list(html, page)

    def detailContent(self, ids):
        if isinstance(ids, (list, tuple)):
            vid = str(ids[0]) if ids else ""
        else:
            vid = str(ids or "")
        clean_id = re.sub(r"^https?://[^/]+/v/", "", vid).replace("/v/", "").strip().strip("/")
        html = self._req("/v/%s" % clean_id)
        if not html:
            return {"list": [], "msg": "详情页获取失败：%s" % clean_id}
        vod_name = clean_id
        m = re.search(r"<h1[^>]*>(.*?)</h1>", html, re.S)
        if m:
            vod_name = self._clean(m.group(1)) or vod_name
        vod_pic = ""
        m = re.search(r'<video[^>]+poster="([^"]+)"', html)
        if m:
            vod_pic = m.group(1)
        if not vod_pic:
            m = re.search(r'coverImageUrl:"([^"]+)"', html)
            if m:
                vod_pic = m.group(1)
        tags = []
        for m in re.finditer(r'href="(/t/[^"]+)"[^>]*>([^<]{1,30})<', html):
            try:
                name = self._clean(m.group(2))
                if name and name not in tags and len(tags) < 10:
                    tags.append(name)
            except Exception:
                continue
        type_name = " • ".join(tags) if tags else "肉视频"
        desc = ""
        m = re.search(r'<meta[^>]+name="description"[^>]+content="([^"]+)"', html)
        if m:
            desc = self._clean(m.group(1))
        main_name = ""
        main_vid = ""
        main_tags = []
        try:
            j = html.find('id:"%s"' % clean_id)
            if j >= 0:
                seg = html[j:j + 6000]
                m2 = re.search(r'name:"((?:[^"\\]|\\.)*)"', seg)
                if m2:
                    raw_name = m2.group(1)
                    try:
                        main_name = raw_name.encode().decode("unicode_escape", "ignore") if "\\u" in raw_name else raw_name
                    except Exception:
                        main_name = raw_name
                    main_name = self._clean(main_name.replace('\\"', '"'))
                m2 = re.search(r'vid:(?:"([^"]*)"|null)', seg)
                if m2 and m2.group(1) and m2.group(1) != "null":
                    main_vid = m2.group(1)
                m2 = re.search(r'tags:\$R\[\d+\]=\["([^"\]]+)"', seg)
                if m2:
                    main_tags = [self._clean(m2.group(1))]
        except Exception:
            pass
        if main_name:
            vod_name = main_name
        if main_tags:
            type_name = " • ".join(main_tags)
        vid_label = main_vid
        vod_content = desc
        if vid_label:
            vod_content = ("【番号】：%s\n%s" % (vid_label, desc)) if desc else ("【番号】：%s" % vid_label)
        vod = {"vod_id": clean_id, "vod_name": vod_name, "vod_remarks": vid_label, "vod_pic": vod_pic, "type_name": type_name, "vod_content": vod_content, "vod_play_from": self.getName(), "vod_play_url": "正片播放$%s" % clean_id}
        return {"list": [vod]}

    def _png_extract_m3u8(self, data):
        if not data or len(data) < 8:
            return ""
        if list(data[:8]) != [137, 80, 78, 71, 13, 10, 26, 10]:
            try:
                text = data.decode("utf-8", "ignore")
                if "#EXTM3U" in text:
                    return text
            except Exception:
                pass
            return ""
        off = 8
        while off + 8 <= len(data):
            try:
                ln = struct.unpack(">I", data[off:off + 4])[0]
                typ = data[off + 4:off + 8]
                payload = data[off + 8:off + 8 + ln]
            except Exception:
                break
            if typ == b"roUd" and len(payload) > 1:
                try:
                    return zlib.decompress(payload[1:]).decode("utf-8", "ignore")
                except Exception:
                    pass
            off += 8 + ln + 4
            if off > 800000:
                break
        return ""

    def _png_extract_mp4(self, data):
        if not data or len(data) < 8:
            return b""
        if list(data[:8]) != [137, 80, 78, 71, 13, 10, 26, 10]:
            return data if data[:4] == b"\x00\x00\x00 " or b"ftyp" in data[:32] else b""
        off = 8
        while off + 8 <= len(data):
            try:
                ln = struct.unpack(">I", data[off:off + 4])[0]
                typ = data[off + 4:off + 8]
                payload = data[off + 8:off + 8 + ln]
            except Exception:
                break
            if typ == b"roUd" and len(payload) > 1:
                return payload[1:]
            off += 8 + ln + 4
            if off > 2000000:
                break
        return b""

    def _proxy_url(self, vid, target):
        try:
            base = self.getProxyUrl(True)
        except Exception:
            base = ""
        if not base:
            try:
                from com.github.catvod import Proxy
                base = Proxy.getUrl(True)
            except Exception:
                base = "http://127.0.0.1:9978/proxy"
        try:
            import urllib.parse as _up
            parts = _up.urlsplit(str(base))
            query = dict(_up.parse_qsl(parts.query, keep_blank_values=True))
            query["do"] = "py"
            base = _up.urlunsplit((parts.scheme, parts.netloc, parts.path, _up.urlencode(query), parts.fragment))
        except Exception:
            sep = "&" if "?" in base else "?"
            if "do=" not in base:
                base = base + sep + "do=py"
        sep = "&" if "?" in base else "?"
        return "%s%stype=rou_hls&vid=%s&url=%s" % (base, sep, quote(str(vid or ""), safe=""), quote(str(target or ""), safe=""))

    def playerContent(self, flag, id, vipFlags=None):
        if isinstance(id, (list, tuple)):
            id = str(id[0]) if id else ""
        else:
            id = str(id or "")
        if isinstance(flag, (list, tuple)):
            flag = str(flag[0]) if flag else ""
        else:
            flag = str(flag or "")
        if isinstance(vipFlags, str):
            try:
                vipFlags = json.loads(vipFlags) if vipFlags.strip().startswith(("[", "{")) else [vipFlags]
            except Exception:
                vipFlags = [vipFlags]
        clean_id = re.sub(r"^https?://[^/]+/v/", "", id).replace("/v/", "").strip().strip("/")
        if clean_id.startswith("http"):
            return {"parse": 0, "jx": 0, "playUrl": "", "url": clean_id, "header": {"User-Agent": self.headers["User-Agent"], "Referer": self.HOST + "/"}, "format": "application/x-mpegURL"}
        html = self._req("/v/%s" % clean_id)
        if not html:
            return {"parse": 1, "jx": 0, "playUrl": "", "url": "%s/v/%s" % (self.HOST, clean_id), "header": {}}
        ev = self._extract_ev(html)
        video_path = ev.get("videoUrl", "")
        if not video_path:
            return {"parse": 1, "jx": 0, "playUrl": "", "url": "%s/v/%s" % (self.HOST, clean_id), "header": {}}
        if video_path.startswith("http"):
            full = video_path
        else:
            full = self.HOST + video_path
        raw = self._get_bytes(full, headers={"User-Agent": self.headers["User-Agent"], "Referer": "%s/v/%s" % (self.HOST, clean_id)})
        m3u8 = self._png_extract_m3u8(raw)
        if "#EXTM3U" not in m3u8:
            return {"parse": 1, "jx": 0, "playUrl": "", "url": "%s/v/%s" % (self.HOST, clean_id), "header": {}}
        proxy_m3u8 = self._proxy_url(clean_id, full)
        return {"parse": 0, "jx": 0, "playUrl": "", "url": proxy_m3u8, "header": {"User-Agent": self.headers["User-Agent"], "Referer": self.HOST + "/"}, "format": "application/x-mpegURL"}

    def localProxy(self, param):
        if isinstance(param, str):
            try:
                import urllib.parse as _up
                text = param.strip()
                if text.startswith("http"):
                    param = dict(_up.parse_qsl(_up.urlsplit(text).query))
                elif text.startswith("{"):
                    param = json.loads(text)
                else:
                    param = dict(_up.parse_qsl(text))
            except Exception:
                param = {}
        if not isinstance(param, dict):
            param = {}
        try:
            ptype = str(param.get("type", ""))
            target = str(param.get("url", "") or "")
            if ptype in ("rou_hls", "m3u8", "ts", "mp4", "py", "proxy") and target:
                import urllib.parse as _up
                vid = str(param.get("vid", "") or "")
                try:
                    raw_parts = _up.urlsplit(target)
                    inner = dict(_up.parse_qsl(raw_parts.query, keep_blank_values=True))
                    if inner.get("url") and ("/proxy" in raw_parts.path or "127.0.0.1" in raw_parts.netloc):
                        target = inner["url"]
                        if not vid:
                            vid = str(inner.get("vid", "") or "")
                except Exception:
                    target = _up.unquote(target)
                vid = str(param.get("vid", "") or vid or "")
                if not vid:
                    m = re.search(r"/(?:api/)?hls/([A-Za-z0-9_-]+)", target)
                    if m:
                        vid = m.group(1)
                if target.startswith("//"): 
                    target = "https:" + target
                if target.startswith("/"):
                    target = self.HOST + target
                if not target.lower().startswith("http"):
                    return [404, "text/plain", b"Not Found", {}]
                if "/api/hls/" in target and "?" not in target and ".png" not in target:
                    raw = self._get_bytes(target, headers={"User-Agent": self.headers["User-Agent"], "Referer": self.HOST + "/"})
                    m3u8 = self._png_extract_m3u8(raw)
                    if "#EXTM3U" not in m3u8:
                        return [404, "text/plain", b"Not Found", {}]
                    lines = []
                    for line in m3u8.splitlines():
                        s = line.strip()
                        if s.startswith("http"):
                            lines.append(self._proxy_url(vid, s))
                        elif s and not s.startswith("#"):
                            lines.append(self._proxy_url(vid, s))
                        else:
                            lines.append(line)
                    body = "\n".join(lines).encode("utf-8")
                    return [200, "application/vnd.apple.mpegurl", body, {"Access-Control-Allow-Origin": "*"}]
                raw = self._get_bytes(target, headers={"User-Agent": self.headers["User-Agent"], "Referer": self.HOST + "/"})
                if not raw:
                    return [404, "text/plain", b"Not Found", {}]
                mp4 = self._png_extract_mp4(raw)
                if not mp4:
                    if b"#EXTM3U" in raw:
                        return [200, "application/vnd.apple.mpegurl", raw, {"Access-Control-Allow-Origin": "*"}]
                    return [404, "text/plain", b"Not Found", {}]
                return [200, "video/mp2t", mp4, {"Access-Control-Allow-Origin": "*"}]
        except Exception:
            pass
        return [404, "text/plain", b"Not Found", {}]

    def isVideoFormat(self, url):
        if not url:
            return False
        u = str(url).lower()
        return ".m3u8" in u or ".mp4" in u or ".flv" in u or ".ts" in u or ".mkv" in u or ".webm" in u or "type=rou_hls" in u

    def manualVideoCheck(self):
        return False

    def liveContent(self, url=""):
        return {"list": []}

    def action(self, action=""):
        return {}

    def proxy(self, param=None):
        return self.localProxy(param)

    def destroy(self):
        self._destroyed = True
        try:
            if self.s is not None:
                self.s.close()
        except Exception:
            pass
        self.s = None
        self.session = None
        self.sess = None
        return None