# -*- coding: utf-8 -*-
import re
import json
from base64 import b64decode
from urllib.parse import quote, unquote

import requests
from lxml import etree

try:
    from base.spider import Spider as BaseSpider
except Exception:
    class BaseSpider(object):
        pass

UA = ("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
      "(KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36")
DEFAULT_HOST = "https://www.cy1899.top"
PAGE_SIZE = 16


class Spider(BaseSpider):
    def getName(self):
        return "纯欲18+"

    def init(self, extend=""):
        host = DEFAULT_HOST
        if isinstance(extend, str) and extend.strip().startswith("http"):
            host = extend.strip().rstrip("/")
        self.host = host
        self.home = self.host + "/video"
        self.headers = {
            "User-Agent": UA,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Accept-Language": "zh-CN,zh;q=0.9",
            "Referer": self.host + "/",
        }
        self.categories = [
            {"type_id": "ai短剧", "type_name": "AI短剧"},
            {"type_id": "无码", "type_name": "无码"},
            {"type_id": "国产", "type_name": "国产"},
            {"type_id": "自拍", "type_name": "自拍"},
            {"type_id": "主播", "type_name": "主播"},
            {"type_id": "自慰", "type_name": "自慰"},
            {"type_id": "网曝", "type_name": "网曝"},
            {"type_id": "网红", "type_name": "网红"},
            {"type_id": "麻豆", "type_name": "麻豆"},
            {"type_id": "高清", "type_name": "高清"},
            {"type_id": "换脸", "type_name": "换脸"},
            {"type_id": "制服", "type_name": "制服"},
            {"type_id": "美乳", "type_name": "美乳"},
            {"type_id": "调教", "type_name": "调教"},
            {"type_id": "女同", "type_name": "女同"},
            {"type_id": "人妻", "type_name": "人妻"},
            {"type_id": "多人", "type_name": "多人"},
            {"type_id": "女优", "type_name": "女优"},
            {"type_id": "韩国", "type_name": "韩国"},
            {"type_id": "字幕", "type_name": "字幕"},
            {"type_id": "萝莉", "type_name": "萝莉"},
            {"type_id": "乱伦", "type_name": "乱伦"},
            {"type_id": "欧美", "type_name": "欧美"},
        ]

    def getDependence(self):
        return []

    def action(self, action):
        return {}

    # ---------------- 网络 ----------------
    def _get(self, url, referer=None):
        headers = dict(self.headers)
        if referer:
            headers["Referer"] = referer
        text = ""
        net = getattr(self, "net", None)
        if net is not None:
            try:
                res = net.req(url, {"headers": headers, "timeout": 20000})
                if isinstance(res, dict):
                    code = res.get("code") or 0
                    if code and int(code) >= 400:
                        return ""
                    text = res.get("content") or ""
            except Exception:
                text = ""
        if not text:
            try:
                r = requests.get(url, headers=headers, timeout=20, verify=False)
                r.encoding = "utf-8"
                if r.status_code != 200:
                    return ""
                text = r.text
            except Exception:
                return ""
        return text or ""

    def _fetch(self, url, referer=None):
        """请求并处理域名过期页：自动切换到新域名后重试同一路径。"""
        html = self._get(url, referer)
        if not html:
            return html
        if ("域名已过期" not in html
                and "域名已停止使用" not in html):
            return html
        m = re.search(r'https?://([\w.\-]+)/video', html)
        if not m:
            raise RuntimeError("站点域名已过期，且未找到新地址")
        new_host = "https://" + m.group(1)
        if new_host.rstrip("/") == self.host.rstrip("/"):
            raise RuntimeError("站点域名已过期")
        self.host = new_host
        self.home = self.host + "/video"
        self.headers["Referer"] = self.host + "/"
        path = re.sub(r'^https?://[^/]+', '', url)
        html = self._get(self.host + path, self.home + "/")
        if not html or "域名已过期" in html:
            raise RuntimeError("新域名访问失败: %s" % self.host)
        return html

    def _fix(self, u):
        if not u:
            return ""
        u = u.strip()
        if u.startswith("//"):
            return "https:" + u
        if u.startswith("/"):
            return self.host + u
        return u

    # ---------------- 解析 ----------------
    def _pagecount(self, html):
        if not html:
            return 0
        m = re.search(r'name="page"[^>]*max="(\d+)"', html)
        if m:
            try:
                return max(1, int(m.group(1)))
            except Exception:
                pass
        nums = re.findall(r'[?&]page=(\d+)', html)
        return max([int(n) for n in nums] or [1])

    def _total(self, html):
        m = re.search(r'找到\s*(\d+)\s*个记录', html or "")
        if m:
            try:
                return int(m.group(1))
            except Exception:
                return None
        return None

    def _items(self, html):
        """div.data 列表块：分类页 / 搜索页共用。"""
        if not html:
            return []
        tree = etree.HTML(html)
        out, seen = [], set()
        for d in tree.xpath('//div[contains(@class,"data")]'):
            try:
                a = d.xpath('.//a[contains(@href,"/video/player/")]')
                if not a:
                    continue
                m = re.search(r'/video/player/(\d+)', a[0].get("href", ""))
                if not m or m.group(1) in seen:
                    continue
                title = "".join(d.xpath('.//p[contains(@class,"title")]//text()')).strip()
                if not title:
                    continue
                pic = (d.xpath('.//img/@data-src') or d.xpath('.//img/@src') or [""])[0]
                remark = "".join(d.xpath('.//span[contains(@class,"update_times")]//text()')).strip()
                cls = "".join(d.xpath('.//p[contains(@class,"category")]//a//text()')).strip()
                seen.add(m.group(1))
                item = {"vod_id": m.group(1), "vod_name": title, "vod_pic": self._fix(pic)}
                if remark or cls:
                    item["vod_remarks"] = remark or cls
                out.append(item)
            except Exception:
                continue
        return out

    def _home_items(self, html):
        """首页 video_item 卡片。"""
        if not html:
            return []
        tree = etree.HTML(html)
        out, seen = [], set()
        for card in tree.xpath('//div[contains(@class,"video_item")]'):
            try:
                a = card.xpath('.//a[contains(@class,"title")]')
                if not a:
                    a = card.xpath('.//a[contains(@href,"/video/player/")]')
                if not a:
                    continue
                m = re.search(r'/video/player/(\d+)', a[0].get("href", ""))
                if not m or m.group(1) in seen:
                    continue
                title = "".join(a[0].xpath(".//text()")).strip()
                if not title:
                    continue
                pic = (card.xpath('.//img/@data-src') or card.xpath('.//img/@src') or [""])[0]
                cls = "".join(card.xpath('.//a[contains(@class,"category")]//text()')).strip()
                seen.add(m.group(1))
                item = {"vod_id": m.group(1), "vod_name": title, "vod_pic": self._fix(pic)}
                if cls:
                    item["vod_remarks"] = cls
                out.append(item)
            except Exception:
                continue
        return out

    def _nav(self, html):
        if not html:
            return self.categories
        tree = etree.HTML(html)
        out, seen = [], set()
        for a in tree.xpath('//nav//a[contains(@href,"/video/category/")]'):
            try:
                name = "".join(a.xpath(".//text()")).strip()
                tid = unquote(a.get("href", "").split("/video/category/")[-1].strip("/"))
                if not name or not tid or tid in seen:
                    continue
                seen.add(tid)
                out.append({"type_id": tid, "type_name": name})
            except Exception:
                continue
        return out or self.categories

    # ---------------- 接口 ----------------
    def homeContent(self, filter):
        html = self._fetch(self.home)
        if not html:
            raise RuntimeError("首页请求失败")
        return {"class": self._nav(html), "list": self._home_items(html), "filters": {}}

    def homeVideoContent(self):
        html = self._fetch(self.home)
        return {"list": self._home_items(html)}

    def categoryContent(self, tid, pg, filter, extend):
        try:
            pg = max(1, int(pg or 1))
        except Exception:
            pg = 1
        tid = unquote(str(tid or "").strip().strip("/"))
        url = "%s/category/%s?page=%d" % (self.home, quote(tid), pg)
        html = self._fetch(url, self.home + "/")
        if not html:
            raise RuntimeError("分类页请求失败: %s" % tid)
        res = {
            "page": pg,
            "pagecount": self._pagecount(html),
            "limit": PAGE_SIZE,
            "list": self._items(html),
        }
        total = self._total(html)
        if total is not None:
            res["total"] = total
        return res

    def _b64(self, s):
        """站点把播放地址 base64 编码后放在 data-src，兼容明文。"""
        s = (s or "").strip()
        if not s:
            return ""
        if s.startswith("http"):
            return s
        padded = s + "=" * (-len(s) % 4)
        for cand in (padded, s):
            try:
                out = b64decode(cand).decode("utf-8")
                if out.startswith("http"):
                    return out
            except Exception:
                continue
        return ""

    def detailContent(self, ids):
        vid = str(ids[0]) if isinstance(ids, (list, tuple)) else str(ids)
        vid = vid.strip()
        html = self._fetch("%s/player/%s" % (self.home, vid), self.home + "/")
        if not html:
            raise RuntimeError("详情页请求失败: %s" % vid)
        tree = etree.HTML(html)
        name = "".join(tree.xpath('//h1[contains(@class,"title")]//text()')).strip()
        name = re.sub(r'^正在播放[:：]\s*', '', name)
        if not name:
            tm0 = re.search(r'<title>([^<]+?)</title>', html)
            name = tm0.group(1).split(" - ")[0].strip() if tm0 else vid
        pic = (tree.xpath('//img[contains(@style,"max-width")]/@src') or [""])[0]

        eps = []
        for btn in tree.xpath('//*[contains(@class,"episode_btn")]'):
            src = (btn.get("data-src") or "").strip()
            play = self._b64(src)
            if not play:
                continue
            label = "".join(btn.xpath(".//text()")).strip() or ("第%d集" % (len(eps) + 1))
            label = label.replace("$", "").replace("#", "")
            eps.append("%s$%s" % (label, play))
        if not eps:
            m = re.search(r'<video[^>]*data-src="([^"]+)"', html)
            if m:
                play = self._b64(m.group(1))
                if play:
                    eps.append("第1集$" + play)
        if not eps:
            raise RuntimeError("未解析到播放地址: %s" % vid)

        info = {
            "vod_id": vid,
            "vod_name": name,
            "vod_pic": self._fix(pic),
            "vod_play_from": self.getName(),
            "vod_play_url": "#".join(eps),
        }
        tm = re.search(r'<title>([^<]+?)</title>', html)
        if tm:
            parts = [p.strip() for p in tm.group(1).split("-")]
            if len(parts) >= 3:
                info["vod_remarks"] = parts[1]
                info["vod_class"] = parts[1]
        if "vod_remarks" not in info and len(eps) > 1:
            info["vod_remarks"] = "共%d集" % len(eps)
        return {"list": [info]}

    def searchContent(self, key, quick, pg="1"):
        try:
            pg = max(1, int(pg or 1))
        except Exception:
            pg = 1
        url = "%s/search/?keyword=%s&page=%d" % (self.home, quote(str(key).strip()), pg)
        html = self._fetch(url, self.home + "/")
        if not html:
            raise RuntimeError("搜索请求失败")
        total = self._total(html)
        # 0 结果时站内会填充“其它精彩视频”，必须丢弃
        if total == 0:
            return {"list": [], "page": pg, "pagecount": 0,
                    "limit": PAGE_SIZE, "total": 0}
        res = {"list": self._items(html), "page": pg,
               "pagecount": self._pagecount(html), "limit": PAGE_SIZE}
        if total is not None:
            res["total"] = total
        return res

    def playerContent(self, flag, id, vipFlags):
        url = self._b64(id) or self._fix(id)
        return {
            "parse": 0,
            "url": url,
            "header": {"User-Agent": UA, "Referer": self.host + "/"},
        }

    def isVideoFormat(self, url):
        u = (url or "").split("?")[0].lower()
        return u.endswith(".m3u8") or u.endswith(".mp4") or ".m3u8" in u or ".mp4" in u

    def manualVideoCheck(self):
        return False

    def localProxy(self, param):
        if isinstance(param, str):
            try:
                param = json.loads(param)
            except Exception:
                param = {}
        if not isinstance(param, dict):
            param = {}
        return [404, "text/plain", b"Not Found", {}]

    def destroy(self):
        return None
