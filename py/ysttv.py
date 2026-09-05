#!/usr/bin/python
# -*- coding: utf-8 -*-
import re
import json
import html as _html
import requests
from urllib.parse import quote
try:
    from lxml import etree
except Exception:
    etree = None
from base.spider import Spider


BADIMG = ("poster_loading", "logo", "thumb.png", "playing.gif", "favicon", "doubanio", "discord", "bytegoofy", "yximgs", "douyinstatic", "weibo.com", "toutiao", "baidu.com", "icons.svg", "avatar", "empty-box")


class Spider(Spider):
    def getName(self):
        return "影视天堂"

    def init(self, extend=""):
        self.host = "http://ysttv.com"
        try:
            ext = json.loads(extend) if str(extend).strip().startswith("{") else {}
        except Exception:
            ext = {}
        if ext.get("host"):
            self.host = str(ext["host"]).rstrip("/")
        self.headers = {"User-Agent": ext.get("ua", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"), "Referer": self.host + "/", "Accept-Language": "zh-CN,zh;q=0.9"}
        self.categories = [{"type_id": "movie", "type_name": "电影"}, {"type_id": "teleplay", "type_name": "剧集"}, {"type_id": "variety", "type_name": "综艺"}, {"type_id": "anime", "type_name": "动漫"}, {"type_id": "playlet", "type_name": "短剧"}]
        self._filters = self._build_filters()

    def _build_filters(self):
        genres = {
            "movie": [["武侠", "wuxia"], ["西部", "western"], ["喜剧片", "comedy-movie"], ["恐怖片", "horror-movie"], ["剧情片", "drama-movie"], ["爱情片", "romance-movie"], ["动作片", "action-movie"], ["科幻片", "sci-fi-movie"], ["欧美剧", "western-drama"], ["音乐", "music"], ["惊悚", "thriller"], ["悬疑", "mystery"], ["动作", "action"], ["科幻", "sci-fi"], ["奇幻", "fantasy"], ["爱情", "romance"], ["喜剧", "comedy"], ["冒险", "adventure"], ["犯罪", "crime"], ["恐怖", "horror"], ["纪录片", "documentary"], ["剧情", "drama"], ["歌舞", "musical"], ["运动", "sports"], ["灾难", "disaster"], ["同性", "lgbt"], ["历史", "history"], ["传记", "biography"], ["情色", "erotic"], ["儿童", "kids"], ["古装", "costume"]],
            "teleplay": [["伦理", "ethics"], ["战争", "war"], ["情色", "erotic"], ["短片", "short-series"], ["动画", "animation"], ["古装", "costume"], ["家庭", "family"], ["纪录片", "documentary"], ["西部", "western"], ["冒险", "adventure"], ["音乐", "music"], ["运动", "sports"], ["传记", "biography"], ["爱情", "romance"], ["同性", "lgbt"], ["动作", "action"], ["历史", "history"], ["惊悚", "thriller"], ["恐怖", "horror"], ["科幻", "sci-fi"], ["剧情", "drama"], ["悬疑", "mystery"], ["奇幻", "fantasy"], ["犯罪", "crime"], ["喜剧", "comedy"]],
            "variety": [["选秀", "talent-show"], ["综艺", "variety"], ["情感", "emotion"], ["美食", "food"], ["音乐", "music"], ["真人秀", "reality-show"], ["喜剧", "comedy"], ["脱口秀", "talk-show"], ["爱情", "romance"], ["歌舞", "musical"]],
            "anime": [["国漫", "anime-cn"], ["惊悚", "thriller"], ["日漫", "anime-jp"], ["美漫", "anime-us"], ["动画", "animation"], ["奇幻", "fantasy"], ["冒险", "adventure"], ["喜剧", "comedy"], ["动作", "action"], ["剧情", "drama"], ["古装", "costume"], ["武侠", "wuxia"], ["爱情", "romance"]],
            "playlet": [["重生", "rebirth"], ["穿越", "time-travel"], ["复仇", "revenge"], ["战神", "war-god"], ["爱情", "love"], ["神医", "divine-doctor"], ["萌娃", "cute-kids"], ["玄幻", "xuanhuan"], ["言情", "romance"], ["都市", "urban"], ["悬疑", "mystery"], ["都市情感剧", "urban-romance"], ["擦边剧", "edge-drama"]],
        }
        years = [["全部", ""]] + [[str(y), "year%d" % y] for y in range(2025, 1995, -1)]
        areas = [["全部", ""], ["大陆", "area-china"], ["台湾", "area-taiwan"], ["香港", "area-hong-kong"], ["美国", "area-usa"], ["韩国", "area-korea"], ["日本", "area-japan"], ["印度", "area-india"], ["英国", "area-uk"], ["法国", "area-france"], ["黎巴嫩", "area-lebanon"], ["波兰", "area-poland"], ["俄罗斯", "area-russia"], ["乌克兰", "area-ukraine"], ["西班牙", "area-spain"], ["意大利", "area-italy"], ["巴西", "area-brazil"], ["荷兰", "area-netherlands"], ["丹麦", "area-denmark"], ["澳大利亚", "area-australia"], ["德国", "area-germany"], ["泰国", "area-thailand"], ["芬兰", "area-finland"], ["瑞典", "area-sweden"], ["挪威", "area-norway"], ["墨西哥", "area-mexico"], ["阿根廷", "area-argentina"], ["南非", "area-south-africa"], ["加拿大", "area-canada"], ["比利时", "area-belgium"]]
        sorts = [["最新", ""], ["人气", "hot"], ["评分", "rating"]]
        fl = {}
        for c in self.categories:
            tid = c["type_id"]
            fl[tid] = [{"key": "genre", "name": "类型", "value": [{"n": g[0], "v": g[1]} for g in genres.get(tid, [])]}, {"key": "year", "name": "年份", "value": [{"n": y[0], "v": y[1]} for y in years]}, {"key": "area", "name": "地区", "value": [{"n": a[0], "v": a[1]} for a in areas]}, {"key": "sort", "name": "排序", "value": [{"n": s[0], "v": s[1]} for s in sorts]}]
        return fl

    def _fix(self, u):
        if not u:
            return ""
        u = str(u).strip()
        if u.startswith("//"):
            return "https:" + u
        if u.startswith("/"):
            return self.host + u
        return u

    def _get(self, path):
        url = path if str(path).startswith("http") else self.host + str(path)
        try:
            r = requests.get(url, headers=self.headers, timeout=15, allow_redirects=True)
            r.encoding = "utf-8"
            if r.status_code >= 400:
                return None
            return r.text
        except Exception:
            pass
        try:
            alt = url.replace("http://", "https://", 1) if url.startswith("http://") else url.replace("https://", "http://", 1)
            if alt != url:
                r = requests.get(alt, headers=self.headers, timeout=15, allow_redirects=True, verify=False)
                r.encoding = "utf-8"
                if r.status_code >= 400:
                    return None
                return r.text
        except Exception:
            pass
        return None

    def _good_img(self, v):
        if not v:
            return False
        s = str(v).strip()
        if not s or s.startswith("data:"):
            return False
        low = s.lower()
        for b in BADIMG:
            if b.lower() in low:
                return False
        return True

    def _pick_img(self, node):
        try:
            for at in ("data-src", "data-original", "src"):
                for v in node.xpath(".//img/@%s" % at):
                    if self._good_img(v):
                        return str(v).strip()
        except Exception:
            pass
        return ""

    def _parse_cards(self, html):
        if not html or etree is None:
            return []
        try:
            tree = etree.HTML(html)
        except Exception:
            return []
        if tree is None:
            return []
        out, seen = [], set()
        for a in tree.xpath('//a[contains(@class,"video-card") and contains(@href,"/detail/")]'):
            try:
                m = re.search(r"/detail/(\d+)", a.get("href", "") or "")
                if not m or m.group(1) in seen:
                    continue
                name = (a.get("title") or "").strip()
                if not name:
                    name = "".join(a.xpath('.//h3//text()')).strip()
                if not name:
                    name = "".join(a.xpath('.//img/@alt')).strip()
                if not name:
                    continue
                seen.add(m.group(1))
                pic = self._pick_img(a)
                # lxml 已自动解码 &amp;，pic 无需处理
                sub = "".join(a.xpath('.//div[contains(@class,"subtitle")]//text()')).strip()
                if sub == "My post subtitle":
                    sub = ""
                tags = [x.strip() for x in a.xpath('.//span[contains(@class,"tag")]//text()') if x.strip()]
                # 区分评分与类型：过滤 0.00 这类无意义评分
                scores, types = [], []
                for t in tags:
                    if re.fullmatch(r"\d+(\.\d+)?", t):
                        try:
                            if float(t) != 0:
                                scores.append(t)
                        except Exception:
                            pass
                    else:
                        if t and t not in types:
                            types.append(t)
                # 清晰度：<span class=\"text-white\">超清</span>
                clarity = ""
                try:
                    cl = ["".join([y.strip() for y in [x] if y.strip()]) for x in a.xpath('.//span[@class="text-white"]//text()')]
                    cl = [x for x in cl if x]
                    if cl:
                        clarity = cl[0].strip()
                    if not clarity:
                        cl2 = "".join(a.xpath('.//div[contains(@class,"dx-video-linear")]//text()')).strip()
                        if cl2 and len(cl2) <= 10:
                            clarity = cl2
                except Exception:
                    clarity = ""
                # 更新标记：new-updated 非空时优先（如 更新至X集）
                upd = ""
                try:
                    upd = "".join(a.xpath('.//div[contains(@class,"new-updated")]//text()')).strip()
                    upd = re.sub(r"\s+", " ", upd).strip()[:20]
                except Exception:
                    upd = ""
                parts = []
                for p in types + scores + ([sub] if sub else []) + ([clarity] if clarity else []) + ([upd] if upd else []):
                    p = str(p).strip()
                    if p and p not in parts and p != "My post subtitle":
                        parts.append(p)
                rem = " ".join(parts).strip()[:40]
                out.append({"vod_id": m.group(1), "vod_name": name, "vod_pic": self._fix(pic), "vod_remarks": rem})
            except Exception:
                continue
        return out

    def _parse_search(self, html):
        if not html or etree is None:
            return []
        try:
            tree = etree.HTML(html)
        except Exception:
            return []
        if tree is None:
            return []
        out, seen = [], set()
        nodes = tree.xpath('//ul[contains(@class,"grid-cols-1")]//a[contains(@href,"/detail/")]')
        if not nodes:
            return self._parse_cards(html)
        for a in nodes:
            try:
                m = re.search(r"/detail/(\d+)", a.get("href", "") or "")
                if not m or m.group(1) in seen:
                    continue
                name = (a.get("title") or "").strip()
                if not name:
                    name = "".join(a.xpath('.//h2//text()')).strip()
                if not name:
                    continue
                seen.add(m.group(1))
                pic = self._pick_img(a)
                # 副标题：类型 年份 地区（如 电影 2026 大陆），过滤“立即播放”按钮杂文本
                spans = [x.strip() for x in a.xpath('.//span//text()') if x.strip()]
                spans = [x for x in spans if x not in ("立即播放",) and "icon" not in x.lower()]
                # 前3个多为 类型/年份/地区，拼成副标题
                meta = " ".join(spans[:4]).strip()[:40]
                if not meta or meta == "立即播放":
                    meta = " ".join(spans).replace("立即播放", "").strip()[:40]
                out.append({"vod_id": m.group(1), "vod_name": name, "vod_pic": self._fix(pic), "vod_remarks": meta})
            except Exception:
                continue
        return out

    def _pager(self, html, pg):
        try:
            m = re.search(r'<ul[^>]+class="pager"[^>]*>', html or "")
            if not m:
                return pg, pg, 0, 32
            tag = m.group(0)
            total = int(re.search(r'data-rec-total="(\d+)"', tag).group(1)) if re.search(r'data-rec-total="(\d+)"', tag) else 0
            per = int(re.search(r'data-rec-per-page="(\d+)"', tag).group(1)) if re.search(r'data-rec-per-page="(\d+)"', tag) else 32
            cur = int(re.search(r'data-page="(\d+)"', tag).group(1)) if re.search(r'data-page="(\d+)"', tag) else pg
            if not per:
                per = 32
            pc = (total + per - 1) // per if total and per else cur
            if pc < cur:
                pc = cur
            return cur, pc, total, per
        except Exception:
            return pg, pg, 0, 32

    def _norm_year(self, v):
        s = str(v or "").strip()
        if not s:
            return ""
        if re.fullmatch(r"(19|20)\d{2}", s):
            return "year" + s
        if s.startswith("year"):
            return s
        return s

    def _norm_area(self, v):
        s = str(v or "").strip()
        if not s:
            return ""
        if s.startswith("area-"):
            return s
        if re.fullmatch(r"[a-z\-]+", s):
            return "area-" + s
        return s

    def _cat_url(self, tid, genre, year, area, sort, pg):
        parts = []
        if genre:
            parts.append(str(genre).strip().strip("/"))
        if year:
            parts.append(str(year).strip().strip("/"))
        if area:
            parts.append(str(area).strip().strip("/"))
        if sort and str(sort).strip() not in ("", "latest"):
            parts.append(str(sort).strip().strip("/"))
        base = "/vod/%s" % str(tid).strip().strip("/")
        if parts:
            base += "/" + "/".join([quote(p, safe="-") for p in parts])
        if str(pg or "1") == "1":
            return base + "/"
        return base + "/%s/" % str(pg)

    def homeContent(self, filter):
        return {"class": self.categories, "list": self._parse_cards(self._get("/")), "filters": self._filters}

    def homeVideoContent(self):
        return {"list": self._parse_cards(self._get("/"))}

    def categoryContent(self, tid, pg, filter, extend):
        try:
            pg = int(str(pg or 1))
        except Exception:
            pg = 1
        if pg < 1:
            pg = 1
        tid = str(tid or "movie").strip() or "movie"
        ex = {}
        try:
            if isinstance(filter, dict):
                ex.update(filter)
        except Exception:
            pass
        try:
            if isinstance(extend, dict):
                for k, v in extend.items():
                    if v not in (None, "") and k not in ex:
                        ex[k] = v
        except Exception:
            pass
        genre = str(ex.get("genre", "") or "").strip()
        year = self._norm_year(ex.get("year", ""))
        area = self._norm_area(ex.get("area", ""))
        sort = str(ex.get("sort", "") or "").strip()
        if sort not in ("", "hot", "rating", "latest"):
            sort = ""
        url = self._cat_url(tid, genre, year, area, sort, pg)
        html = self._get(url)
        lst = self._parse_cards(html)
        cur, pc, total, per = self._pager(html, pg)
        return {"page": cur, "pagecount": pc, "limit": per, "total": total, "list": lst}

    def searchContent(self, key, quick, pg="1"):
        try:
            pg = int(str(pg or 1))
        except Exception:
            pg = 1
        if pg < 1:
            pg = 1
        kw = str(key or "").strip()
        if not kw:
            return {"list": [], "page": pg}
        q = quote(kw, safe="")
        if pg == 1:
            url = "/search/video/%s/" % q
        else:
            url = "/search/video/%s/%d/" % (q, pg)
        html = self._get(url)
        lst = self._parse_search(html)
        cur, pc, total, per = self._pager(html, pg)
        try:
            m = re.search(r'data-search-result-count="(\d+)"', html or "")
            if m:
                total = int(m.group(1))
                per = 30
                pc = (total + per - 1) // per if total else pg
        except Exception:
            pass
        return {"list": lst, "page": cur, "pagecount": pc, "limit": per if per else 30, "total": total}

    def _field(self, html, key):
        try:
            m = re.search(r"%s\s*[:：]\s*([^<\n]{1,200})" % re.escape(key), html or "")
            if not m:
                return ""
            return m.group(1).strip(" \u3000|/").split("<")[0].strip()
        except Exception:
            return ""

    def detailContent(self, ids):
        try:
            vid = re.sub(r"\D", "", str(ids[0] if isinstance(ids, (list, tuple)) else ids))
        except Exception:
            return {"list": []}
        if not vid:
            return {"list": []}
        html = self._get("/detail/%s/" % vid)
        if not html or etree is None:
            return {"list": []}
        try:
            tree = etree.HTML(html)
        except Exception:
            return {"list": []}
        if tree is None:
            return {"list": []}
        name = "".join(tree.xpath("//h1//text()")).strip().strip("《》") or ""
        if not name:
            try:
                name = "".join(tree.xpath('//h1//text() | //h2[contains(@class,"title")]//text()')).strip().strip("《》")
            except Exception:
                name = ""
        pic = ""
        try:
            for v in tree.xpath("//img/@data-src | //img/@src"):
                s = str(v or "").strip()
                if not s:
                    continue
                low = s.lower()
                if any(b.lower() in low for b in BADIMG):
                    continue
                if re.search(r"/cover/|/upload/|movie_cover|jinyingimage|7dgirl|cuinhri", s):
                    pic = s
                    break
            if not pic:
                for v in tree.xpath("//img/@data-src | //img/@src"):
                    if self._good_img(v):
                        pic = str(v).strip()
                        break
        except Exception:
            pic = ""
        year = "".join(tree.xpath('//a[contains(@href,"/year")]//text()')[:1]).strip()
        if not year:
            m = re.search(r"/vod/year(\d{4})", html or "")
            year = m.group(1) if m else ""
        if not year:
            # 兜底：上映/年份字段
            try:
                m = re.search(r"(?:年份|上映)\s*[:：]\s*((?:19|20)\d{2})", html or "")
                if m:
                    year = m.group(1)
            except Exception:
                pass
        area = "".join(tree.xpath('//a[contains(@href,"/area-")]//text()')[:1]).strip()
        tname = ""
        try:
            cand = [x.strip() for x in tree.xpath('//a[starts-with(@href,"/vod/") and not(contains(@href,"/year")) and not(contains(@href,"/area-"))]//text()') if x.strip()]
            cand = [x for x in cand if x not in ("片库",)]
            if cand:
                tname = cand[0]
        except Exception:
            tname = ""
        director = self._field(html, "导演")
        actor = self._field(html, "主演")
        eps_total = self._field(html, "集数")
        score = self._field(html, "评分")
        content = self._field(html, "剧情") or self._field(html, "简介") or ""
        try:
            if not content:
                m = re.search(r'<meta[^>]+name="description"[^>]+content="([^"]+)"', html or "")
                if m:
                    content = m.group(1).strip()
        except Exception:
            pass
        # 推荐位补副标题：详情页关联 video-card 的 tag/sub 通常为 6.7/类型+简介
        rec_remark = ""
        try:
            rec_cards = tree.xpath('//a[contains(@class,"video-card") and contains(@href,"/detail/")]')
            if rec_cards:
                a0 = rec_cards[0]
                rtags = [x.strip() for x in a0.xpath('.//span[contains(@class,"tag")]//text()') if x.strip()]
                rsub = "".join(a0.xpath('.//div[contains(@class,"subtitle")]//text()')).strip()
                if rsub == "My post subtitle":
                    rsub = ""
                rscore = ""
                for t in rtags:
                    if re.fullmatch(r"\d+(\.\d+)?", t):
                        try:
                            if float(t) != 0:
                                rscore = t
                                break
                        except Exception:
                            continue
                rec_remark = " ".join([x for x in [rscore, rsub] if x]).strip()[:40]
        except Exception:
            rec_remark = ""
        eps = []
        try:
            for a in tree.xpath('//ul[contains(@class,"video-episodes")]//a[contains(@href,"/play/")]'):
                lk = (a.get("href", "") or "").strip()
                nm = "".join(a.xpath(".//text()")).strip() or (a.get("title", "") or "").strip()
                if not lk or not nm:
                    continue
                if re.search(r"/play/\{\{|{{", lk):
                    continue
                nm = nm.replace("$", "").replace("#", "").strip() or "正片"
                item = nm + "$" + self._fix(lk)
                if item not in eps:
                    eps.append(item)
        except Exception:
            eps = []
        # 连续剧按真实选集数修正 remarks（站内集数偶发滞后）
        neps = len(eps)
        if neps > 1:
            remarks = "共%s集" % neps
        elif eps_total.isdigit() and eps_total != "1":
            remarks = "共%s集" % eps_total
        else:
            remarks = (score or eps_total or rec_remark or "").strip()
            # 0分视为无评分，用推荐副标题兜底
            if remarks in ("0分", "0.0分", "0", "0.0", "0.00", "") and rec_remark:
                remarks = rec_remark
        vod = {"vod_id": vid, "vod_name": name, "vod_pic": self._fix(pic), "vod_year": year, "vod_area": area, "type_name": tname, "vod_director": director, "vod_actor": actor, "vod_remarks": remarks, "vod_content": content}
        vod["vod_play_from"] = "影视天堂"
        vod["vod_play_url"] = "#".join(eps or ["正片$%s/play/%s/1" % (self.host, vid)])
        return {"list": [vod]}

    def playerContent(self, flag, id, vipFlags):
        try:
            token = str(id or "").strip()
        except Exception:
            return {"parse": 0, "url": ""}
        if not token:
            return {"parse": 0, "url": ""}
        # TVBox 传来的 id 偶发带中文集名(/play/68489/浪浪人生)，需 quote 编码
        try:
            if token.startswith("http"):
                parts = token.split("/")
                if len(parts) > 4 and any(ord(c) > 127 for c in parts[-1]):
                    token = "/".join(parts[:-1]) + "/" + quote(parts[-1], safe="")
            elif token.startswith("/play/"):
                segs = token.strip("/").split("/")
                if len(segs) >= 3 and any(ord(c) > 127 for c in segs[2]):
                    token = "/%s/%s/%s" % (segs[0], segs[1], quote(segs[2], safe=""))
        except Exception:
            pass
        pid = token if token.startswith("http") else self._fix(token)
        html = self._get(pid) or ""
        url = ""
        try:
            m = re.search(r'data-url="([^"]+\.m3u8[^"]*)"', html)
            if m:
                url = m.group(1).strip()
        except Exception:
            pass
        if not url:
            for p in [r'"(?:url|video_url|playUrl)"\s*:\s*"([^"]+\.(?:m3u8|mp4)[^"]*)"', r'url:\s*["\']([^"\']+\.(?:m3u8|mp4)[^"\']*)["\']', r'(https?://[^\s"\'<>]+\.m3u8[^\s"\'<>]*)', r'(https?://[^\s"\'<>]+\.mp4[^\s"\'<>]*)']:
                try:
                    m = re.search(p, (html or "").replace("\\/", "/"), re.S)
                    if m and m.group(1):
                        url = m.group(1).strip()
                        break
                except Exception:
                    continue
        if url:
            # 关键修复：播放页 data-url 是 HTML 转义的(&amp;)，不解码则签名参数断裂，
            # 源站(movie.7dgirl.org/yd-hls.tuafjz.cn)返回 0 字节/403，播放器报 Source error。
            try:
                url = _html.unescape(url).strip()
            except Exception:
                url = url.replace("&amp;", "&").strip()
        url = self._fix(url) if url else ""
        if not url:
            return {"parse": 1, "url": pid, "header": dict(self.headers)}
        return {"parse": 0, "url": url, "header": {"User-Agent": self.headers.get("User-Agent", "Mozilla/5.0"), "Referer": self.host + "/"}}

    def searchContentPage(self, key, quick, pg):
        return self.searchContent(key, quick, pg)

    def isVideoFormat(self, url):
        try:
            s = str(url or "").lower()
            return ".m3u8" in s or ".mp4" in s or ".flv" in s or ".mkv" in s
        except Exception:
            return False

    def manualVideoCheck(self):
        return False

    def localProxy(self, param):
        return None

    def destroy(self):
        return None
