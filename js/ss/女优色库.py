import sys
import json
import re
import requests
from urllib.parse import urljoin

try:
    from base.spider import Spider as BaseSpider
except:
    class BaseSpider:
        def getName(self): return ""
        def init(self, extend=""): pass
        def homeContent(self, filter): pass
        def homeVideoContent(self): pass
        def categoryContent(self, tid, pg, filter, extend): pass
        def detailContent(self, ids): pass
        def searchContent(self, key, quick, pg="1"): pass
        def playerContent(self, flag, id, vipFlags): pass
        def localProxy(self, param): pass
        def isVideoFormat(self, url): pass
        def manualVideoCheck(self): pass
        def getCache(self, key): return None
        def setCache(self, key, value): pass
        def delCache(self, key): pass
        def getProxyUrl(self, local=""): return ""

class Spider(BaseSpider):
    def __init__(self):
        self.siteUrl = "http://tmx.nysk6.yachts"
        self.session = requests.Session()
        self.session.headers.update({
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
            "Accept-Language": "zh-CN,zh;q=0.9",
            "Referer": self.siteUrl + "/nysk/",
        })

    def getName(self):
        return "女优色库"

    def init(self, extend=""):
        pass

    def homeContent(self, filter):
        classes = [
            {"type_name": "国产精品", "type_id": "20"},
            {"type_name": "精品三级", "type_id": "21"},
            {"type_name": "主播大秀", "type_id": "22"},
            {"type_name": "抖阴视频", "type_id": "23"},
            {"type_name": "女神学生", "type_id": "24"},
            {"type_name": "美熟少妇", "type_id": "25"},
            {"type_name": "娇妻素人", "type_id": "26"},
            {"type_name": "空姐模特", "type_id": "27"},
            {"type_name": "国产爬灰聚麀", "type_id": "28"},
            {"type_name": "自慰群交", "type_id": "29"},
            {"type_name": "野合车震", "type_id": "30"},
            {"type_name": "职场同事", "type_id": "31"},
            {"type_name": "国产名人", "type_id": "32"},
        ]
        return {"class": classes}

    def homeVideoContent(self):
        return self.categoryContent("20", "1", False, {})

    def categoryContent(self, tid, pg, filter, extend):
        if int(pg) <= 1:
            url = self.siteUrl + "/vodtype/" + tid + ".html"
        else:
            url = self.siteUrl + "/vodtype/" + tid + "-" + pg + ".html"
        r = self.session.get(url, timeout=15)
        html = r.text
        videos = []
        lis = re.findall(r'<li>(.*?)</li>', html, re.S)
        for li in lis:
            a_match = re.search(r'<a\s+href=["\']([^"\']+)["\']\s+title=["\']([^"\']+)["\']', li, re.S)
            if a_match:
                href = a_match.group(1)
                title = a_match.group(2)
                img_match = re.search(r'<img\s+src=["\']([^"\']+)["\']', li, re.S)
                pic = img_match.group(1) if img_match else ""
                score_match = re.search(r'<span\s+class=["\']score["\']>([^<]+)</span>', li, re.S)
                score = score_match.group(1).strip() if score_match else ""
                vid = href.replace(".html", "").replace("/", "")
                videos.append({
                    "vod_id": vid,
                    "vod_name": title,
                    "vod_pic": pic,
                    "vod_remarks": score,
                })
        total_match = re.search(r'for\s*\(\s*var\s+i\s*=\s*0\s*;\s*i\s*<\s*(\d+)', html)
        total_page = int(total_match.group(1)) if total_match else 999
        return {
            "list": videos,
            "page": pg,
            "pagecount": total_page,
            "limit": 108,
            "total": total_page * 108,
        }

    def detailContent(self, ids):
        vid = ids[0]
        url = self.siteUrl + "/" + vid + ".html"
        r = self.session.get(url, timeout=15)
        html = r.text
        title_match = re.search(r'<title>(.*?)</title>', html, re.I)
        title = title_match.group(1).split("-")[0] if title_match else vid
        desc_match = re.search(r'<meta\s+name=["\']description["\']\s+content=["\']([^"\']+)', html, re.I)
        desc = desc_match.group(1) if desc_match else ""
        m3u8_match = re.search(r"const rawUrl\s*=\s*['\"]([^'\"]+)['\"]", html)
        play_url = m3u8_match.group(1) if m3u8_match else ""
        pic_match = re.search(r'<img[^>]+src=["\']([^"\']+)["\'][^>]*class=["\'][^"\']*(?:poster|thumb|vod_pic)["\']', html, re.I)
        pic = pic_match.group(1) if pic_match else ""
        if not pic:
            imgs = re.findall(r'<img[^>]+src=["\'](https?://[^"\']+)["\'][^>]*>', html, re.I)
            for img in imgs:
                if any(ext in img.lower() for ext in [".jpg", ".png", ".jpeg", ".webp"]):
                    pic = img
                    break
        vod = {
            "vod_id": vid,
            "vod_name": title,
            "vod_pic": pic,
            "vod_content": desc,
            "vod_play_from": "女优色库",
            "vod_play_url": "第1集$" + play_url,
        }
        return {"list": [vod]}

    def searchContent(self, key, quick, pg="1"):
        url = self.siteUrl + "/s/" + key + ".html"
        r = self.session.get(url, timeout=15)
        html = r.text
        videos = []
        lis = re.findall(r'<li>(.*?)</li>', html, re.S)
        for li in lis:
            a_match = re.search(r'<a\s+href=["\']([^"\']+)["\']\s+title=["\']([^"\']+)["\']', li, re.S)
            if a_match:
                href = a_match.group(1)
                title = a_match.group(2)
                img_match = re.search(r'<img\s+src=["\']([^"\']+)["\']', li, re.S)
                pic = img_match.group(1) if img_match else ""
                score_match = re.search(r'<span\s+class=["\']score["\']>([^<]+)</span>', li, re.S)
                score = score_match.group(1).strip() if score_match else ""
                vid = href.replace(".html", "").replace("/", "")
                videos.append({
                    "vod_id": vid,
                    "vod_name": title,
                    "vod_pic": pic,
                    "vod_remarks": score,
                })
        return {"list": videos, "page": pg}

    def playerContent(self, flag, id, vipFlags):
        return {
            "parse": 0,
            "playUrl": "",
            "url": id,
            "header": json.dumps({"Referer": self.siteUrl + "/", "User-Agent": self.session.headers.get("User-Agent")}),
        }

    def localProxy(self, param):
        return [200, "application/vnd.apple.mpegurl", ""]

    def isVideoFormat(self, url):
        return any(url.endswith(ext) for ext in [".m3u8", ".mp4", ".flv", ".ts"])

    def manualVideoCheck(self):
        return True
