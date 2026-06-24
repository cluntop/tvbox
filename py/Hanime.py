# -*- coding: utf-8 -*-
import json
import sys
import re
import html as html_parser
from urllib.parse import quote

sys.path.append('..')
from base.spider import Spider

class Spider(Spider):
    def init(self, extend=""):
        self.host = "https://hanime1.best"
        self.headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36',
            'Referer': f'{self.host}/',
        }

    def getName(self):
        return "Hanime"

    def homeContent(self, filter):
        classes = [
            {'type_name': '最新上市', 'type_id': 'latest_rank'},
            {'type_name': '裏番', 'type_id': '裏番'},
            {'type_name': '泡麵番', 'type_id': '泡麵番'},
            {'type_name': 'Motion Anime', 'type_id': 'Motion Anime'},
            {'type_name': '3DCG', 'type_id': '3DCG'},
            {'type_name': '2D動畫', 'type_id': '2D動畫'},
            {'type_name': 'AI生成', 'type_id': 'AI生成'},
            {'type_name': 'MMD', 'type_id': 'MMD'},
            {'type_name': 'Cosplay', 'type_id': 'Cosplay'},
            {'type_name': '本日排行', 'type_id': 'daily_rank'},
            {'type_name': '本週排行', 'type_id': 'weekly_rank'},
            {'type_name': '本月排行', 'type_id': 'monthly_rank'}
        ]
        sort_options = [
            {"n": "最新上市", "v": "最新上市"},
            {"n": "最新上傳", "v": "最新上傳"},
            {"n": "本日排行", "v": "本日排行"},
            {"n": "本週排行", "v": "本週排行"},
            {"n": "本月排行", "v": "本月排行"},
            {"n": "觀看次數", "v": "觀看次數"}
        ]
        filters = {}
        for item in classes:
            filters[item['type_id']] = [{"key": "sort", "name": "排序", "value": sort_options}]
        return {'class': classes, 'filters': filters}

    def categoryContent(self, tid, pg, filter, extend):
        page = int(pg)
        sort = extend.get('sort', '最新上市')
        
        if 'rank' in tid or tid == 'latest_rank':
            rank_map = {'latest_rank': '最新上市', 'daily_rank': '本日排行', 'weekly_rank': '本週排行', 'monthly_rank': '本月排行'}
            url = f"{self.host}/search?sort={quote(rank_map.get(tid, '最新上市'))}&page={page}"
        else:
            # 分类请求必须使用 genre 参数
            url = f"{self.host}/search?genre={quote(tid)}&sort={quote(sort)}&page={page}"

        try:
            content = self.fetch(url, headers=self.headers).text
            vods = self.parse_vod_list(content)
            
            # 提取总页数
            pc_match = re.search(r'\/ (\d+)', content)
            pagecount = int(pc_match.group(1)) if pc_match else page + 1
            
            return {'list': vods, 'page': page, 'pagecount': pagecount}
        except:
            return {'list': []}

    def parse_vod_list(self, html):
        vods = []
        seen = set()

        # 模式1：适配搜索结果/分类页卡片布局 (video-item-container)
        p1 = re.compile(r'class="video-item-container".*?href="[^"]*v=(\d+)".*?src="([^"]+)".*?class="duration">(.*?)<.*?class="title">(.*?)<', re.S)
        
        # 模式2：适配首页/行布局 (home-rows)
        p2 = re.compile(r'href="[^"]*watch\?v=(\d+)".*?src="([^"]+)".*?class="home-rows-videos-title"[^>]*>(.*?)</div>', re.S)

        # 优先匹配卡片布局
        for vid, pic, dur, title in p1.findall(html):
            if vid not in seen:
                seen.add(vid)
                vods.append({
                    "vod_id": vid,
                    "vod_name": html_parser.unescape(title).strip(),
                    "vod_pic": pic,
                    "vod_remarks": dur.strip()
                })

        # 补充匹配行布局
        if not vods:
            for vid, pic, title in p2.findall(html):
                if vid not in seen:
                    seen.add(vid)
                    vods.append({
                        "vod_id": vid,
                        "vod_name": html_parser.unescape(title).strip(),
                        "vod_pic": pic,
                        "vod_remarks": ""
                    })
        return vods

    def detailContent(self, ids):
        vid = ids[0]
        url = f"{self.host}/watch?v={vid}"
        try:
            html = self.fetch(url, headers=self.headers).text
            title = re.search(r'<meta property="og:title" content="(.*?)"', html).group(1)
            pic = re.search(r'<meta property="og:image" content="(.*?)"', html).group(1)
            
            # 解析播放源并识别清晰度
            sources = re.findall(r'<source[^>]+src="([^"]+)"', html)
            if not sources:
                sources = re.findall(r'https?://[^\s"\'<>]+?\.mp4[^\s"\'<>]*', html)

            play_parts = []
            seen_urls = set()
            for s_url in sources:
                s_url = html_parser.unescape(s_url).replace('&amp;', '&')
                if s_url in seen_urls: continue
                seen_urls.add(s_url)

                # 画质识别逻辑
                if '1080' in s_url: tag = "1080P"
                elif '720' in s_url: tag = "720P"
                else: tag = "标清"
                
                play_parts.append(f"{tag}${s_url}")

            # 画质由高到低排序
            play_parts.sort(key=lambda x: 0 if "1080" in x else (1 if "720" in x else 2))

            return {'list': [{
                "vod_id": vid,
                "vod_name": title,
                "vod_pic": pic,
                "vod_play_from": "Hanime",
                "vod_play_url": "#".join(play_parts)
            }]}
        except:
            return {'list': []}

    def searchContent(self, key, quick, pg="1", extend=None):
        url = f"{self.host}/search?query={quote(key)}&page={pg}"
        try:
            html = self.fetch(url, headers=self.headers).text
            return {'list': self.parse_vod_list(html), 'page': pg}
        except:
            return {'list': []}

    def playerContent(self, flag, id, vipFlags):
        # 修复播放问题的关键：伪造 Referer
        headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36',
            'Referer': 'https://hanime1.me/', # 必须指向原站
            'Connection': 'keep-alive'
        }
        return {'parse': 0, 'url': id, 'header': headers}
