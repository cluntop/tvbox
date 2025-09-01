"""

作者 乐哥 🚓 内容均从互联网收集而来 仅供交流学习使用 版权归原创者所有 如侵犯了您的权益 请通知作者 将及时删除侵权内容
                    ====================lege====================

"""

import requests
from bs4 import BeautifulSoup
import re
from base.spider import Spider
import sys
import json
import base64
import urllib.parse
from Crypto.Cipher import ARC4
from Crypto.Util.Padding import unpad
import binascii

sys.path.append('..')

xurl = "https://www.fullhd.xxx/zh/"

headerx = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36'
          }

pm = ''

class Spider(Spider):
    global xurl
    global headerx

    def getName(self):
        return "首页"

    def init(self, extend):
        pass

    def isVideoFormat(self, url):
        pass

    def manualVideoCheck(self):
        pass

    def extract_middle_text(self, text, start_str, end_str, pl, start_index1: str = '', end_index2: str = ''):
        if pl == 3:
            plx = []
            while True:
                start_index = text.find(start_str)
                if start_index == -1:
                    break
                end_index = text.find(end_str, start_index + len(start_str))
                if end_index == -1:
                    break
                middle_text = text[start_index + len(start_str):end_index]
                plx.append(middle_text)
                text = text.replace(start_str + middle_text + end_str, '')
            if len(plx) > 0:
                purl = ''
                for i in range(len(plx)):
                    matches = re.findall(start_index1, plx[i])
                    output = ""
                    for match in matches:
                        match3 = re.search(r'(?:^|[^0-9])(\d+)(?:[^0-9]|$)', match[1])
                        if match3:
                            number = match3.group(1)
                        else:
                            number = 0
                        if 'http' not in match[0]:
                            output += f"#{'📽️' + match[1]}${number}{xurl}{match[0]}"
                        else:
                            output += f"#{'📽️' + match[1]}${number}{match[0]}"
                    output = output[1:]
                    purl = purl + output + "$$$"
                purl = purl[:-3]
                return purl
            else:
                return ""
        else:
            start_index = text.find(start_str)
            if start_index == -1:
                return ""
            end_index = text.find(end_str, start_index + len(start_str))
            if end_index == -1:
                return ""

        if pl == 0:
            middle_text = text[start_index + len(start_str):end_index]
            return middle_text.replace("\\", "")

        if pl == 1:
            middle_text = text[start_index + len(start_str):end_index]
            matches = re.findall(start_index1, middle_text)
            if matches:
                jg = ' '.join(matches)
                return jg

        if pl == 2:
            middle_text = text[start_index + len(start_str):end_index]
            matches = re.findall(start_index1, middle_text)
            if matches:
                new_list = [f'✨{item}' for item in matches]
                jg = '$$$'.join(new_list)
                return jg

    def homeContent(self, filter):
        result = {}
        result = {"class": [{"type_id": "latest-updates", "type_name": "最新视频🌠"},
                            {"type_id": "top-rated", "type_name": "最佳视频🌠"},
                            {"type_id": "most-popular", "type_name": "热门影片🌠"}],
                 }

        return result

    def homeVideoContent(self):
        videos = []
        try:
            detail = requests.get(url=xurl, headers=headerx)
            detail.encoding = "utf-8"
            res = detail.text
            doc = BeautifulSoup(res, "lxml")

            soups = doc.find_all('div', class_="margin-fix")

            if soups and len(soups) > 1:
                soups = soups[0]
                vods = soups.find_all('div', class_="item")

                for vod in vods:

                    names = vod.find_all('a')
                    name = names[0]['title']

                    ids = vod.find_all('a')
                    id = ids[0]['href']

                    pics = vod.find('img', class_="lazyload")
                    pic = pics['data-src']

                    if 'http' not in pic:
                        pic = xurl + pic

                    remarks = vod.find('div', class_="img thumb__img")
                    remark = remarks.text.strip()

                    video = {
                        "vod_id": id,
                        "vod_name": name,
                        "vod_pic": pic,
                        "vod_remarks": remark
                             }
                    videos.append(video)

            result = {'list': videos}
            return result
        except:
            pass

    def categoryContent(self, cid, pg, filter, ext):
        result = {}
        if pg:
            page = int(pg)
        else:
            page = 1
        page = int(pg)
        videos = []

        if page == '1':
            url = f'{xurl}/{cid}/'

        else:
            url = f'{xurl}/{cid}/{str(page)}/'

        try:
            detail = requests.get(url=url, headers=headerx)
            detail.encoding = "utf-8"
            res = detail.text
            doc = BeautifulSoup(res, "lxml")

            soups = doc.find_all('div', class_="margin-fix")

            for soup in soups:
                vods = soup.find_all('div', class_="item")

                for vod in vods:

                    names = vod.find_all('a')
                    name = names[0]['title']

                    ids = vod.find_all('a')
                    id = ids[0]['href']

                    pics = vod.find('img', class_="lazyload")
                    pic = pics['data-src']

                    if 'http' not in pic:
                        pic = xurl + pic

                    remarks = vod.find('div', class_="img thumb__img")
                    remark = remarks.text.strip()

                    video = {
                        "vod_id": id,
                        "vod_name": name,
                        "vod_pic": pic,
                        "vod_remarks": remark
                             }
                    videos.append(video)

        except:
            pass
        result = {'list': videos}
        result['page'] = pg
        result['pagecount'] = 9999
        result['limit'] = 90
        result['total'] = 999999
        return result

    def detailContent(self, ids):
        global pm
        did = ids[0]
        result = {}
        videos = []
        playurl = ''
        if 'http' not in did:
            did = xurl + did
        res1 = requests.get(url=did, headers=headerx)
        res1.encoding = "utf-8"
        res = res1.text

        content = '资源来源于网络🚓侵权请联系删除👉' + self.extract_middle_text(res,'<h1>','</h1>', 0)

        yanuan = self.extract_middle_text(res, '<span>Pornstars:</span>','</div>',1, 'href=".*?">(.*?)</a>')

        bofang = did

        videos.append({
            "vod_id": did,
            "vod_actor": yanuan,
            "vod_director": '',
            "vod_content": content,
            "vod_play_from": '💗数逼毛💗',
            "vod_play_url": bofang
                     })

        result['list'] = videos
        return result

    def playerContent(self, flag, id, vipFlags):
        parts = id.split("http")
        xiutan = 0
        if xiutan == 0:
            if len(parts) > 1:
                before_https, after_https = parts[0], 'http' + parts[1]
            res = requests.get(url=after_https, headers=headerx)
            res = res.text

            url2 = self.extract_middle_text(res, '<video', '</video>', 0).replace('\\', '')
            soup = BeautifulSoup(url2, 'html.parser')
            first_source = soup.find('source')
            src_value = first_source.get('src')

            response = requests.head(src_value, allow_redirects=False)
            if response.status_code == 302:
                redirect_url = response.headers['Location']

            response = requests.head(redirect_url, allow_redirects=False)
            if response.status_code == 302:
                redirect_url = response.headers['Location']

            result = {}
            result["parse"] = xiutan
            result["playUrl"] = ''
            result["url"] = redirect_url
            result["header"] = headerx
            return result

    def searchContentPage(self, key, quick, page):
        result = {}
        videos = []
        if not page:
            page = '1'
        if page == '1':
            url = f'{xurl}/search/{key}/'

        else:
            url = f'{xurl}/search/{key}/{str(page)}/'

        detail = requests.get(url=url, headers=headerx)
        detail.encoding = "utf-8"
        res = detail.text
        doc = BeautifulSoup(res, "lxml")

        soups = doc.find_all('div', class_="margin-fix")

        for soup in soups:
            vods = soup.find_all('div', class_="item")

            for vod in vods:

                    names = vod.find_all('a')
                    name = names[0]['title']

                    ids = vod.find_all('a')
                    id = ids[0]['href']

                    pics = vod.find('img', class_="lazyload")
                    pic = pics['data-src']

                    if 'http' not in pic:
                        pic = xurl + pic

                    remarks = vod.find('div', class_="img thumb__img")
                    remark = remarks.text.strip()

                    video = {
                        "vod_id": id,
                        "vod_name": name,
                        "vod_pic": pic,
                        "vod_remarks": remark
                             }
                    videos.append(video)

        result['list'] = videos
        result['page'] = page
        result['pagecount'] = 9999
        result['limit'] = 90
        result['total'] = 999999
        return result

    def searchContent(self, key, quick):
        return self.searchContentPage(key, quick, '1')

    def localProxy(self, params):
        if params['type'] == "m3u8":
            return self.proxyM3u8(params)
        elif params['type'] == "media":
            return self.proxyMedia(params)
        elif params['type'] == "ts":
            return self.proxyTs(params)
        return None




