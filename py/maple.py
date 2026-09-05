# -*- coding: utf-8 -*-
"""
枫叶影院 / 枫叶4K 合并版 (maple.py)
------------------------------------
合并自 maple/ 目录下多个版本:
  * 枫叶影院.py  —— 动态发布页 host + 多站点 + extend 兼容 + 稳健二次解析播放
  * 枫叶4k.py    —— parse_map 多线路解析 / 4K 标识提取
  * 枫叶.py      —— /index.php/ajax/data JSON 分类回调(规避 cupfox-list 验证码)

2026-08 实站适配(已在 www.cd-zj.com / www.zzztool.com 上验证):
  * /cupfox-list/ /list/ /cupfox-search/ HTML 路由均被"系统安全验证"验证码拦截
    -> 数字分类改用 /index.php/ajax/data JSON 接口(可正常返回)
  * suggest 联想搜索接口已关闭 -> searchContent 做 suggest + HTML 双兜底
  * 播放页 player_aaaa -> 二次解析(zzrs.mfdyvip.com / fgsrg.hzqingshan.com)可用
"""
import os
import re
import json
import time
import urllib.parse
from datetime import datetime

import requests
from bs4 import BeautifulSoup

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
    publish_url = "https://www.vip1949.com/"
    default_sites = [
        "https://www.zzztool.com",
        "https://maihaolian.com",
        "https://www.cd-zj.com",
    ]
    base_url = default_sites[0]
    cookie = "verify_success=1"
    debug = False
    timeout = 15

    # 二次解析接口: 播放页 url 的线路前缀 -> 解析服务域名
    parse_map = {
        'YYNB': 'https://zzrs.mfdyvip.com',
        'JD4K': 'https://fgsrg.hzqingshan.com',
    }

    # 动态 host 缓存
    _cache_host = ""
    _cache_time = 0
    CACHE_DURATION = 300  # 5 分钟

    # ----------------------------------------------------------
    # 基础请求
    # ----------------------------------------------------------
    def _log(self, *args):
        if self.debug:
            print("[maple]", *args)

    def _headers(self, referer=None):
        headers = {
            "User-Agent": "Mozilla/5.0 (Linux; Android 15; Pixel 9) AppleWebKit/537.36 Chrome/150.0.0.0 Mobile",
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Accept-Language": "zh-CN,zh;q=0.9",
        }
        if referer is None:
            headers["Referer"] = self.base_url + "/"
        elif referer:
            headers["Referer"] = referer
        if self.cookie:
            headers["Cookie"] = self.cookie
        return headers

    def _fetch(self, url, referer=None):
        """请求 HTML(相对路径自动拼接 base_url), 失败返回 ''"""
        try:
            if not url.startswith('http'):
                url = self.base_url + url
            r = requests.get(url, headers=self._headers(referer), timeout=self.timeout)
            r.encoding = r.apparent_encoding or 'utf-8'
            if r.status_code == 200:
                return r.text
            self._log('请求失败', r.status_code, url)
            return ''
        except Exception as e:
            self._log('请求异常', url, e)
            return ''

    def _fetch_json(self, url, referer=None):
        """请求 JSON 接口并解析为 dict, 失败返回 {}"""
        try:
            text = self._fetch(url, referer)
            if not text:
                return {}
            return json.loads(text)
        except Exception as e:
            self._log('_fetch_json异常', e)
            return {}

    def _fix_pic(self, u):
        if not u:
            return ''
        if u.startswith('//'):
            return 'https:' + u
        return u.replace('&amp;', '&')

    @staticmethod
    def _parse_extend(extend):
        """兼容 dict / JSON 字符串 / key=val&... / ; / | 管道多种格式"""
        if not extend:
            return {}
        if isinstance(extend, dict):
            return extend
        s = str(extend).strip()
        if '%' in s:
            # 兼容 URL 编码字符串(电报/订阅分享格式)
            try:
                s = urllib.parse.unquote(s)
            except Exception:
                pass
        try:
            return json.loads(s)
        except Exception:
            pass
        if '=' in s:
            d = {}
            # 兼容单组 key=value 或 key1=val1&key2=val2 等多组
            sep = '&' if '&' in s else (';' if ';' in s else None)
            parts = s.split(sep) if sep else [s]
            for part in parts:
                if '=' in part:
                    k, v = part.split('=', 1)
                    d[k.strip()] = v.strip()
            if d:
                return d
        if '|' in s:
            keys = ['type', 'area', 'class', 'lang', 'letter', 'orderBy', 'year']
            return {keys[i]: v.strip() for i, v in enumerate(s.split('|')) if i < len(keys)}
        return {}

    # ----------------------------------------------------------
    # 动态 host 获取(发布页)
    # ----------------------------------------------------------
    def check_url_online(self, url, timeout=3):
        try:
            r = requests.get(url, headers=self._headers(), timeout=timeout, allow_redirects=True)
            return 200 <= r.status_code < 400
        except Exception:
            return False

    def get_online_host(self, publish_url=None):
        publish_url = publish_url or self.publish_url
        try:
            r = requests.get(publish_url, headers=self._headers(), timeout=self.timeout)
            r.raise_for_status()
            html = r.content.decode('utf-8', 'ignore')
        except Exception as e:
            self._log('获取发布页异常', e)
            return self.default_sites[0]
        m = re.search(r'const\s+domains\s*=\s*(\[.*?\]);', html, re.S)
        if not m:
            self._log('发布页未找到 domains, 使用默认站点')
            return self.default_sites[0]
        js = m.group(1)
        # 修复 JS 裸键为标准 JSON(只给 { 或 , 后的裸键加引号, 避免误伤 https:)
        js = re.sub(r'([{,]\s*)(\w+)\s*:', r'\1"\2":', js)
        try:
            domains = json.loads(js)
        except Exception as e:
            self._log('domains JSON 解析失败', e)
            return self.default_sites[0]
        for item in domains:
            url = (item.get('url') or '').rstrip('/')
            if url and self.check_url_online(url):
                return url
        return self.default_sites[0]

    # ----------------------------------------------------------
    # 生命周期
    # ----------------------------------------------------------
    def init(self, extend=""):
        ext = self._parse_extend(extend)

        if isinstance(ext.get('parse_map'), dict) and ext['parse_map']:
            self.parse_map.update(ext['parse_map'])
        if isinstance(ext.get('default_sites'), list) and ext['default_sites']:
            self.default_sites = ext['default_sites']
        if ext.get('publish_url'):
            self.publish_url = ext['publish_url']

        # Cookie / fyck 文件
        if ext.get('cookie'):
            self.cookie = ext['cookie']
        elif ext.get('fyck'):
            path = ext['fyck']
            if not os.path.isabs(path):
                path = os.path.join(os.path.dirname(os.path.abspath(__file__)), path)
            try:
                with open(path, 'r', encoding='utf-8') as f:
                    self.cookie = f.read().strip()
                self._log('已读取 Cookie 文件, 长度', len(self.cookie))
            except Exception as e:
                self._log('读取 Cookie 文件失败', e)
                self.cookie = ''
        if not self.cookie:
            self.cookie = "verify_success=1"

        self.debug = bool(ext.get('debug', False))

        # 确定 base_url: host > sites/sitesIndex > 缓存 > 发布页 > 默认
        if ext.get('host'):
            self.base_url = str(ext['host']).rstrip('/')
        elif ext.get('sites') and isinstance(ext['sites'], list) and ext['sites']:
            self.default_sites = ext['sites']
            idx = int(ext.get('sitesIndex', 0) or 0)
            if idx < 0 or idx >= len(self.default_sites):
                idx = 0
            self.base_url = self.default_sites[idx]
        else:
            now = time.time()
            if self._cache_host and now - self._cache_time < self.CACHE_DURATION:
                self.base_url = self._cache_host
            else:
                host = self.get_online_host(self.publish_url)
                if host:
                    self.base_url = host
                    self._cache_host = host
                    self._cache_time = now
        self._log('最终 base_url:', self.base_url)

    def getName(self):
        return '枫叶影院'

    # ----------------------------------------------------------
    # 首页 + 筛选器
    # ----------------------------------------------------------
    def homeContent(self, filter):
        return {
            "class": [
                {'type_id': "/label/qq", 'type_name': "腾讯VIP精选"},
                {'type_id': "/label/bli", 'type_name': "B站VIP精选"},
                {'type_id': "/label/youku", 'type_name': "优酷VIP精选"},
                {"type_id": "2", "type_name": "电视剧"},
                {"type_id": "1", "type_name": "电影"},
                {"type_id": "4", "type_name": "动漫"},
                {"type_id": "3", "type_name": "综艺"},
                {"type_id": "5", "type_name": "热门短剧"},
            ],
            "filters": self._build_filters()
        }

    def homeVideoContent(self):
        html = self._fetch('/')
        return {"list": self._parse_video_list(html, is_home=True) if html else []}

    def _build_filters(self):
        area = [{"n": "全部", "v": ""}, {"n": "大陆", "v": "大陆"}, {"n": "香港", "v": "香港"},
                {"n": "台湾", "v": "台湾"}, {"n": "美国", "v": "美国"}, {"n": "韩国", "v": "韩国"},
                {"n": "日本", "v": "日本"}, {"n": "泰国", "v": "泰国"}, {"n": "新加坡", "v": "新加坡"},
                {"n": "马来西亚", "v": "马来西亚"}, {"n": "印度", "v": "印度"}, {"n": "英国", "v": "英国"},
                {"n": "法国", "v": "法国"}, {"n": "加拿大", "v": "加拿大"}, {"n": "西班牙", "v": "西班牙"},
                {"n": "俄罗斯", "v": "俄罗斯"}, {"n": "其它", "v": "其它"}]
        cur = datetime.now().year
        years = [{"n": "全部", "v": ""}] + [{"n": str(y), "v": str(y)} for y in range(cur, cur - 23, -1)]
        lang = [{"n": "全部", "v": ""}, {"n": "国语", "v": "国语"}, {"n": "英语", "v": "英语"},
                {"n": "粤语", "v": "粤语"}, {"n": "闽南语", "v": "闽南语"}, {"n": "韩语", "v": "韩语"},
                {"n": "日语", "v": "日语"}, {"n": "法语", "v": "法语"}, {"n": "德语", "v": "德语"},
                {"n": "其它", "v": "其它"}]
        sort = [{"n": "时间", "v": "time"}, {"n": "人气", "v": "hits"}, {"n": "评分", "v": "score"}]
        letter = [{"n": "全部", "v": ""}] + [{"n": c, "v": c} for c in "ABCDEFGHIJKLMNOPQRSTUVWXYZ"] \
            + [{"n": "0-9", "v": "0-9"}]

        def opts(pairs):
            return [{"n": k, "v": v} for k, v in pairs]

        return {
            "2": [
                {"key": "class", "name": "类型", "value": [
                    {"n": "全部", "v": "2"}, {"n": "国产剧", "v": "13"}, {"n": "日韩剧", "v": "15"},
                    {"n": "海外剧", "v": "16"}]},
                {"key": "area", "name": "地区", "value": area},
                {"key": "genre", "name": "剧情", "value": opts([
                    ("全部", ""), ("古装", "古装"), ("战争", "战争"), ("青春偶像", "青春偶像"),
                    ("喜剧", "喜剧"), ("家庭", "家庭"), ("犯罪", "犯罪"), ("动作", "动作"),
                    ("奇幻", "奇幻"), ("剧情", "剧情"), ("历史", "历史"), ("经典", "经典"),
                    ("乡村", "乡村"), ("情景", "情景"), ("商战", "商战"), ("网剧", "网剧"), ("其他", "其他")])},
                {"key": "year", "name": "年份", "value": years},
                {"key": "lang", "name": "语言", "value": lang},
                {"key": "letter", "name": "字母", "value": letter},
                {"key": "sort", "name": "排序", "value": sort},
            ],
            "1": [
                {"key": "class", "name": "类型", "value": [
                    {"n": "全部", "v": "1"}, {"n": "动作片", "v": "6"}, {"n": "喜剧片", "v": "7"},
                    {"n": "恐怖片", "v": "8"}, {"n": "科幻片", "v": "9"}, {"n": "爱情片", "v": "10"},
                    {"n": "剧情片", "v": "11"}, {"n": "战争片", "v": "12"}, {"n": "纪录片", "v": "20"}]},
                {"key": "area", "name": "地区", "value": area},
                {"key": "genre", "name": "剧情", "value": opts([
                    ("全部", ""), ("喜剧", "喜剧"), ("爱情", "爱情"), ("恐怖", "恐怖"), ("动作", "动作"),
                    ("科幻", "科幻"), ("剧情", "剧情"), ("战争", "战争"), ("警匪", "警匪"), ("犯罪", "犯罪"),
                    ("动画", "动画"), ("奇幻", "奇幻"), ("武侠", "武侠"), ("冒险", "冒险"), ("枪战", "枪战"),
                    ("悬疑", "悬疑"), ("惊悚", "惊悚"), ("经典", "经典"), ("青春", "青春"), ("文艺", "文艺"),
                    ("微电影", "微电影"), ("古装", "古装"), ("历史", "历史"), ("运动", "运动"),
                    ("农村", "农村"), ("儿童", "儿童"), ("网络电影", "网络电影")])},
                {"key": "year", "name": "年份", "value": years},
                {"key": "lang", "name": "语言", "value": lang},
                {"key": "letter", "name": "字母", "value": letter},
                {"key": "sort", "name": "排序", "value": sort},
            ],
            "4": [
                {"key": "class", "name": "类型", "value": [
                    {"n": "全部", "v": "4"}, {"n": "国产动漫", "v": "25"}, {"n": "日韩动漫", "v": "26"}]},
                {"key": "genre", "name": "剧情", "value": opts([
                    ("全部", ""), ("情感", "情感"), ("科幻", "科幻"), ("热血", "热血"), ("推理", "推理"),
                    ("搞笑", "搞笑"), ("冒险", "冒险"), ("奇幻", "奇幻"), ("战斗", "战斗"), ("校园", "校园"),
                    ("萝莉", "萝莉"), ("治愈", "治愈"), ("原创", "原创"), ("亲子", "亲子"), ("益智", "益智"),
                    ("励志", "励志"), ("其他", "其他")])},
                {"key": "area", "name": "地区", "value": area},
                {"key": "year", "name": "年份", "value": years},
                {"key": "lang", "name": "语言", "value": lang},
                {"key": "letter", "name": "字母", "value": letter},
                {"key": "sort", "name": "排序", "value": sort},
            ],
            "3": [
                {"key": "class", "name": "类型", "value": [
                    {"n": "全部", "v": "3"}, {"n": "大陆综艺", "v": "21"}, {"n": "日韩综艺", "v": "22"}]},
                {"key": "genre", "name": "剧情", "value": opts([
                    ("全部", ""), ("选秀", "选秀"), ("情感", "情感"), ("访谈", "访谈"), ("播报", "播报"),
                    ("音乐", "音乐"), ("美食", "美食"), ("旅游", "旅游"), ("搞笑", "搞笑"), ("游戏", "游戏"),
                    ("亲子", "亲子"), ("其它", "其它")])},
                {"key": "area", "name": "地区", "value": area},
                {"key": "year", "name": "年份", "value": years},
                {"key": "lang", "name": "语言", "value": lang},
                {"key": "letter", "name": "字母", "value": letter},
                {"key": "sort", "name": "排序", "value": sort},
            ],
        }

    # ----------------------------------------------------------
    # 分类
    # ----------------------------------------------------------
    def categoryContent(self, tid, pg, filter, extend):
        try:
            page = int(pg) if pg else 1
            tid = str(tid)
            is_label = tid.startswith('/label')
            ext = self._parse_extend(extend)

            args = {}
            if isinstance(filter, dict):
                args.update({k: str(v) for k, v in filter.items() if v})
            if isinstance(ext, dict):
                args.update({k: str(v) for k, v in ext.items() if v and k not in args})

            # 子类型(class)本身就是二级 tid
            route_tid = args.get('class', tid)

            # /label/ VIP 精选: 走 HTML 分页(无需验证码)
            if is_label:
                url = f'{tid}/page/{page}.html'
                html = self._fetch(url)
                if html and '系统安全验证' in html:
                    # 标签页也被验证码拦截时, 不产生垃圾 URL, 直接返回空列表
                    return {"list": [], "page": page, "pagecount": 0, "limit": 24, "total": 0}
                items = self._parse_video_list(html)
                total = page if len(items) < 24 else page + 2
                return {"list": items, "page": page, "pagecount": total, "limit": 24, "total": total * 24}
            else:
                tid = route_tid

            # 数字分类: 优先 ajax/data JSON 接口(/cupfox-list 被验证码拦截)
            limit = 20
            url = f'/index.php/ajax/data?mid=1&tid={tid}&page={page}&limit={limit}'
            area = args.get('area', '')
            year = args.get('year', '')
            lang = args.get('lang', '')
            letter = args.get('letter', '')
            sort = args.get('sort', '')
            if area:
                url += f'&area={urllib.parse.quote(area)}'
            if year:
                url += f'&year={urllib.parse.quote(year)}'
            if lang:
                url += f'&lang={urllib.parse.quote(lang)}'
            if letter:
                url += f'&letter={urllib.parse.quote(letter)}'
            if sort:
                url += f'&by={urllib.parse.quote(sort)}'

            data = self._fetch_json(url)
            if isinstance(data, dict) and data.get('list'):
                items = self._parse_ajax_list(data['list'])
                pagecount = int(data.get('pagecount', 0) or 0) or page
                total = int(data.get('total', 0) or 0)
                return {"list": items, "page": page, "pagecount": pagecount,
                        "limit": int(data.get('limit', limit) or limit), "total": total}

            # 兜底: HTML 分类路由
            prefix = 'list' if 'zzztool' in self.base_url else 'cupfox-list'
            if not (area or year or lang or letter or sort):
                url = f'/{prefix}/{tid}--------{page}---.html'
            else:
                url = f'/{prefix}/{tid}-{area}-{sort}-{lang}-{letter}--{page}---{year}.html'
            html = self._fetch(url)
            items = self._parse_video_list(html)
            pagecount = page
            if html and '系统安全验证' not in html:
                soup = BeautifulSoup(html, 'html.parser')
                tail = soup.select_one('a.page-link:contains("尾页")')
                if tail:
                    m = re.search(r'---(\d+)---', tail.get('href', ''))
                    if m:
                        pagecount = int(m.group(1))
            if not items:
                pagecount = 0
            return {"list": items, "page": page, "pagecount": pagecount, "limit": 36, "total": 9999}
        except Exception as e:
            self._log('categoryContent 异常', e)
            return {"list": [], "page": int(pg) if pg else 1, "pagecount": 0}

    # ----------------------------------------------------------
    # 列表解析
    # ----------------------------------------------------------
    def _parse_ajax_list(self, lst):
        videos, seen = [], set()
        for it in lst:
            if not isinstance(it, dict):
                continue
            vid = it.get('vod_id')
            if not vid:
                m = re.search(r'/detail/(\d+)\.html', it.get('detail_link', ''))
                if not m:
                    continue
                vid = m.group(1)
            vid = str(vid)
            if vid in seen:
                continue
            seen.add(vid)
            videos.append({
                "vod_id": vid,
                "vod_name": (it.get('vod_name') or '').strip(),
                "vod_pic": self._fix_pic(it.get('vod_pic', '')),
                "vod_remarks": (it.get('vod_remarks') or '').strip(),
                "vod_year": (it.get('vod_year') or '').strip(),
            })
        return videos

    def _parse_video_list(self, html, is_home=False, is_search=False):
        if not html:
            return []
        if '系统安全验证' in html:
            self._log('触发系统安全验证, 请更新Cookie')
            return []
        soup = BeautifulSoup(html, 'html.parser')
        videos, seen = [], set()
        is_zzz = 'zzztool' in self.base_url

        cards = soup.select('.module-item') if is_zzz else soup.select('a.public-list-exp')
        for el in cards:
            try:
                if is_zzz:
                    a = el if el.name == 'a' else el.select_one('a')
                    if not a:
                        continue
                    vod_id = a.get('href', '')
                    vod_name = a.get('title', '').strip() if a else ''
                    if not vod_name:
                        tag = el.select_one('.module-card-item-title strong')
                        vod_name = tag.get_text(strip=True) if tag else ''
                    img = el.select_one('.module-item-pic img')
                    vod_pic = self._fix_pic(img.get('data-src', '') or (img.get('src', '') if img else ''))
                    remarks = el.select_one('.module-item-note')
                    vod_remarks = remarks.get_text(strip=True) if remarks else ''
                    vod_year = vod_remarks
                    version_left = el.select_one('.module-item-version-left')
                    if version_left and version_left.get_text(strip=True):
                        vod_year = '「' + version_left.get_text(strip=True) + '」' + vod_year
                else:
                    a = el if el.name == 'a' else el.select_one('a.public-list-exp')
                    if not a:
                        continue
                    vod_id = a.get('href', '')
                    if is_search:
                        title_el = soup.select_one(f'a.thumb-txt[href="{vod_id}"]')
                        vod_name = title_el.text.strip() if title_el else ''
                    else:
                        vod_name = a.get('title', '').strip()
                        if not vod_name:
                            img = a.select_one('img')
                            vod_name = img.get('alt', '') if img else ''
                    img = a.select_one('img')
                    vod_pic = self._fix_pic(img.get('data-src', '')) if img else ''
                    remark_el = a.select_one('.ft2') or a.select_one('.public-list-prb')
                    vod_remarks = remark_el.text.strip() if remark_el else ''
                    span = ','.join([s.text for s in a.select('span.public-prt')])
                    vod_year = span

                if not vod_id or not vod_name:
                    continue
                m = re.search(r'/detail/(\d+)\.html', vod_id)
                if not m:
                    continue
                vod_id = m.group(1)
                if vod_id in seen:
                    continue
                seen.add(vod_id)
                videos.append({
                    "vod_id": vod_id,
                    "vod_name": vod_name.strip(),
                    "vod_pic": vod_pic,
                    "vod_remarks": vod_remarks,
                    "vod_year": vod_year,
                })
            except Exception as e:
                self._log('解析条目异常', e)
                continue
        return videos

    # ----------------------------------------------------------
    # 详情
    # ----------------------------------------------------------
    def detailContent(self, ids):
        result = {"list": []}
        if not ids:
            return result
        vid = str(ids[0]).split(',')[0].strip()
        try:
            html = self._fetch(f'/detail/{vid}.html')
            if not html:
                return result
            soup = BeautifulSoup(html, 'html.parser')
            is_zzz = 'zzztool' in self.base_url

            if is_zzz:
                name_el = soup.select_one('.module-info-heading h1')
                vod_name = name_el.get_text(strip=True) if name_el else ''
                pic_el = soup.select_one('.module-item-pic img')
                vod_pic = self._fix_pic(pic_el.get('data-src', '') or pic_el.get('src', '')) if pic_el else ''
                director = actor = ''
                for item in soup.select('.module-info-item'):
                    t = item.select_one('.module-info-item-title')
                    c = item.select_one('.module-info-item-content')
                    if not t or not c:
                        continue
                    tt = t.get_text(strip=True)
                    cc = c.get_text(strip=True)
                    if '导演' in tt:
                        director = cc
                    elif '主演' in tt:
                        actor = cc
                cont_el = soup.select_one('.module-info-introduction-content p')
                vod_content = cont_el.get_text(strip=True) if cont_el else ''
                play_from, play_url = [], []
                name_counts = {}
                for tab in soup.select('.mx-anthology-tab .mx-anthology-tab-label'):
                    raw = tab.get_text(strip=True)
                    if raw:
                        name_counts[raw] = name_counts.get(raw, 0) + 1
                        play_from.append(f"{raw}-{name_counts[raw]}" if name_counts[raw] > 1 else raw)
                for panel in soup.select('.mx-anthology-panel'):
                    eps = []
                    for a in panel.select('.mx-anthology-item a'):
                        title = a.get_text(strip=True)
                        href = a.get('href', '')
                        if title and href:
                            eps.append(f"{title}${href}")
                    if eps:
                        play_url.append('#'.join(reversed(eps)))
            else:
                name_el = soup.select_one('h3.slide-info-title')
                vod_name = name_el.get_text(strip=True) if name_el else ''
                pic_el = soup.select_one('img.lazy')
                vod_pic = self._fix_pic(pic_el.get('data-src', '')) if pic_el else ''
                director = actor = ''
                for el in soup.select('.slide-info'):
                    text = el.get_text(' ').strip()
                    if text.startswith('导演：'):
                        director = text.replace('导演：', '').strip()
                    elif text.startswith('演员：'):
                        actor = text.replace('演员：', '').strip()
                cont_el = soup.select_one('#height_limit')
                vod_content = cont_el.get_text(' ', strip=True) if cont_el else ''
                play_from, play_url = [], []
                name_counts = {}
                for tab in soup.select('.anthology-tab a.swiper-slide'):
                    raw = re.sub(r'<[^>]+>', '', str(tab)).strip() or tab.get_text(' ', strip=True).strip()
                    if raw:
                        name_counts[raw] = name_counts.get(raw, 0) + 1
                        play_from.append(f"{raw}-{name_counts[raw]}" if name_counts[raw] > 1 else raw)
                for block in soup.select('.anthology-list-box'):
                    eps = []
                    for a in block.select('li a'):
                        href = a.get('href', '')
                        m = re.search(r'/play/(.*?)\.html', href)
                        if m:
                            _ep = m.group(1)
                            if not _ep.startswith(vid + '-'):
                                _ep = f"{vid}-{_ep}"
                            eps.append(f"{a.get_text(strip=True)}${_ep}")
                    if eps:
                        play_url.append('#'.join(reversed(eps)))

            valid_from = [pf for i, pf in enumerate(play_from) if i < len(play_url)]
            result["list"].append({
                "vod_id": vid,
                "vod_name": vod_name,
                "vod_pic": vod_pic,
                "vod_director": director,
                "vod_actor": actor,
                "vod_content": vod_content,
                "vod_play_from": "$$$".join(valid_from),
                "vod_play_url": "$$$".join(play_url),
            })
        except Exception as e:
            self._log('detailContent 异常', e)
        return result

    # ----------------------------------------------------------
    # 搜索(suggest 接口已关闭, 做 HTML 兜底)
    # ----------------------------------------------------------
    def searchContent(self, key, quick, pg="1"):
        try:
            page = int(pg) if pg else 1
            try:
                decoded = urllib.parse.unquote(str(key))
            except Exception:
                decoded = str(key)
            kw = urllib.parse.quote(decoded)

            # 1) suggest JSON
            data = self._fetch_json(f'/index.php/ajax/suggest?mid=1&wd={kw}&limit=50')
            items = []
            if isinstance(data, dict) and data.get('list'):
                for it in data['list']:
                    if not isinstance(it, dict):
                        continue
                    vid = it.get('id')
                    if not vid:
                        continue
                    items.append({
                        "vod_id": str(vid),
                        "vod_name": (it.get('name') or '').strip(),
                        "vod_pic": self._fix_pic(it.get('pic', '')),
                        "vod_remarks": (it.get('remarks') or '').strip(),
                    })
                if items:
                    return {"list": items, "page": page, "pagecount": 1, "limit": 50, "total": len(items)}

            # 2) HTML 搜索兜底(cupfox-search, 可能触发验证码)
            _search_prefix = 'search' if 'zzztool' in self.base_url else 'cupfox-search'
            url = f'/{_search_prefix}/-------------.html?wd={kw}'
            html = self._fetch(url)
            if html and '系统安全验证' not in html:
                items = self._parse_video_list(html, is_search=True)
                return {"list": items, "page": page, "pagecount": 1, "limit": 36, "total": len(items)}
            return {"list": [], "page": page, "pagecount": 1, "limit": 50, "total": 0}
        except Exception as e:
            self._log('searchContent 异常', e)
            return {"list": [], "page": int(pg) if pg else 1, "pagecount": 1}

    # ----------------------------------------------------------
    # 播放(含二次解析)
    # ----------------------------------------------------------
    def _resolve_video_url(self, video_url, play_id=None):
        line_key = play_id if play_id else re.split(r'[-_]', video_url)[0]
        base_domain = self.parse_map.get(line_key)
        if not base_domain:
            self._log('未匹配到解析线路, 使用默认 JD4K')
            base_domain = self.parse_map.get('JD4K', 'https://fgsrg.hzqingshan.com')

        # 1) 获取 token
        token_page = self._fetch(f'{base_domain}/player/?url={video_url}', referer=self.base_url)
        if not token_page:
            raise RuntimeError("token 获取失败")
        token = ''
        m = re.search(r'data-te="([^"]+)"', token_page)
        if m:
            token = m.group(1)
        else:
            soup = BeautifulSoup(token_page, 'html.parser')
            el = soup.select_one('#player-data')
            if el:
                token = el.get('data-te', '')
        if not token:
            raise RuntimeError("未找到 token")

        # 2) 换取真实播放地址
        api_url = f'{base_domain}/player/mplayer.php'
        headers = self._headers(referer=self.base_url)
        headers['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8'
        resp = requests.post(api_url, data={'url': video_url, 'token': token},
                             headers=headers, timeout=self.timeout)
        data = resp.json()
        final_url = data.get('url', '')
        if not final_url:
            raise RuntimeError("解析结果为空")
        if final_url.startswith('/playproxy.php'):
            final_url = base_domain + final_url
        return final_url

    def playerContent(self, flag, id, vipFlags):
        play_url = id or ''
        try:
            if '$' in str(id):
                play_path = str(id).split('$')[-1]
            else:
                play_path = str(id)

            if play_path.startswith('http') and ('.m3u8' in play_path or '.mp4' in play_path):
                return {"parse": 0, "url": play_path, "header": self._headers()}

            if play_path.startswith('http'):
                play_url = play_path
            elif play_path.startswith('/play/'):
                play_url = self.base_url + play_path
            else:
                play_url = f'{self.base_url}/play/{play_path}.html'
            play_url = play_url.replace('.html.html', '.html')

            html = self._fetch(play_url)
            if not html:
                return {"parse": 0, "url": "", "msg": "播放页获取失败"}

            video_url, play_id = '', ''
            m = re.search(r'player_aaaa=(.*?)</script>', html, re.S)
            if m:
                try:
                    pd = json.loads(m.group(1))
                    video_url = pd.get('url', '') or ''
                    play_id = pd.get('from', '') or ''
                except Exception:
                    pass
            if not video_url:
                m2 = re.search(r'var\s+player_aaaa[\s\S]*?"url"\s*:\s*"([^"]+)"', html)
                if m2:
                    video_url = m2.group(1).replace('\\', '')
            if not video_url:
                m3 = re.search(r'<video[^>]+src="([^"]+)"', html, re.I)
                if m3:
                    video_url = m3.group(1)
            if not video_url:
                m4 = re.search(r'<iframe[^>]+src="([^"]+)"', html, re.I)
                if m4:
                    video_url = m4.group(1)
            if not video_url:
                m5 = re.search(r'(https?://[^\s"\'<>]+\.m3u8[^\s"\'<>]*)', html)
                if m5:
                    video_url = m5.group(1)
            if not video_url:
                return {"parse": 0, "url": "", "msg": "未找到视频地址"}

            if video_url.startswith('http') and ('.m3u8' in video_url or '.mp4' in video_url):
                return {"parse": 0, "url": video_url, "header": self._headers(referer=self.base_url)}

            final_url = self._resolve_video_url(video_url, play_id)
            return {"parse": 0, "url": final_url, "header": self._headers(referer=self.base_url)}
        except Exception as e:
            self._log('playerContent 异常', e)
            return {"parse": 1, "url": play_url, "msg": str(e)}

    # ----------------------------------------------------------
    # 其余必须接口
    # ----------------------------------------------------------
    def localProxy(self, param=''):
        return {}

    def isVideoFormat(self, url):
        return False

    def manualVideoCheck(self):
        return False

    def destroy(self):
        pass
