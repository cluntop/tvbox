# -*- coding: utf-8 -*-
# by @嗷呜
import json
import sys
from base64 import b64decode, b64encode
from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad, pad
from concurrent.futures import ThreadPoolExecutor
sys.path.append('..')
from base.spider import Spider


class Spider(Spider):

    def init(self, extend=""):
        self.host = self.gethost()
        self.hkey,self.playerinfos=self.getinfo()
        pass

    def getName(self):
        pass

    def isVideoFormat(self, url):
        pass

    def manualVideoCheck(self):
        pass

    def destroy(self):
        pass

    headers = {
        'User-Agent': 'Dalvik/1.4.0 (Linux; U; Android 11; Redmi Build/M2012K10C)',
       'version': '1.4.0'
    }

    keys=['rectangleadsadxa','aassddwwxxllsx1x']

    def homeContent(self, filter):
        cdata=self.getdata('/api.php/v1.home/types')
        result = {}
        classes = []
        filters = {}
        for i in cdata['data']['types'][1:]:
            classes.append({
                'type_id': i['type_id'],
                'type_name': i['type_name']
            })
        with ThreadPoolExecutor(max_workers=len(classes)) as executor:
            futures = [executor.submit(self.getf, i['type_id'])
                       for i in classes]
            for future in futures:
                try:
                    type_id, filter_data = future.result()
                    if len(filter_data):filters[type_id] = filter_data
                except Exception as e:
                    print(f'处理筛选数据失败: {e}')
        result['class'] = classes
        result['filters'] = filters
        return result

    def homeVideoContent(self):
        data=self.getdata('/api.php/v1.home/data?type_id=26')
        return {'list':data['data']['banners']}

    def categoryContent(self, tid, pg, filter, extend):
        json_data = {
            'area': extend.get('area', '全部地区'),
            'lang': extend.get('lang', '全部语言'),
            'rank': extend.get('rank', '最新'),
            'type': extend.get('type', '全部类型'),
            'type_id': int(tid),
            'year': extend.get('year', '全部年代'),
        }
        data=self.getdata(f'/api.php/v1.classify/content?page={pg}',method=False,json_data=json_data)
        result = {}
        result['list'] = data['data']['video_list']
        result['page'] = pg
        result['pagecount'] = 9999
        result['limit'] = 90
        result['total'] = 999999
        return result

    def detailContent(self, ids):
        data=self.getdata(f'/api.php/v1.player/details?vod_id={ids[0]}')
        vod = data['data']['detail']
        plist,names = [],[]
        for i in vod['play_url_list']:
            names.append(i['show'])
            plist.append('#'.join([f"{j['name']}${i['from']}@@{j['url']}" for j in i['urls']]))
        vod.pop('play_url_list', None)
        vod.update({'vod_play_from': '$$$'.join(names), 'vod_play_url': '$$$'.join(plist)})
        return {'list':[vod]}

    def searchContent(self, key, quick, pg="1"):
        data=self.getdata(f'/api.php/v1.search/data?wd={key}&type_id=0&page={pg}')
        return {'list': data['data']['search_data'], 'page': pg}

    def playerContent(self, flag, id, vipFlags):
        ids=id.split('@@')
        try:
            body={'parse':self.getparse(ids[0]),'url':ids[-1],'matching':''}
            data=self.getdata(f'/shark/api.php?action=parsevod',method=False,data=body)
            url=data.get('url') or data['data'].get('url')
            if not url:
                raise ValueError("解析失败")
            p=0
        except:
            p,url = 1,ids[-1]
        return  {'parse': p, 'url': url, 'header': {'User-Agent':'aliplayer(appv=1.4.0&av=6.16.0&av2=6.16.0_40316683&os=android&ov=11&dm=M2012K10C)'}}

    def localProxy(self, param):
        pass

    def getparse(self,id):
        for i in self.playerinfos:
            if i['playername']==id:
                j= i['playerjiekou']
                return self.aes(j,self.hkey)
        return ''

    def gethost(self):
        headers = {
            'User-Agent': 'okhttp/4.11.0',
            'Connection': 'Keep-Alive'
        }
        response = self.fetch('https://shopv1.oss-accelerate.aliyuncs.com/api.txt', headers=headers).text
        host=json.loads(self.aes(response.strip(),self.keys[0]))[0]
        return host

    def getinfo(self):
        data=self.post(f'{self.host}/shark/api.php?action=configs',headers=self.headers,data={'username':'','token':''}).text
        datas=json.loads(self.aes(data))
        hkey = datas['config']['hulue'].split('&')[0]
        playerinfos = datas['playerinfos']
        return hkey,playerinfos

    def getdata(self,parh,method=True,data=None,json_data=None):
        url = f'{self.host}{parh}'
        if method:
            response = self.fetch(url, headers=self.headers).text
        else:
            response = self.post(url, headers=self.headers, data=data, json=json_data).text
        return json.loads(self.aes(response))

    def getf(self, type_id):
        try:
            fdata = self.getdata(f'/api.php/v1.classify/types?type_id={type_id}')
            filter_list = []
            for key, value in fdata['data'].items():
                if len(value):
                    filter_list.append({
                        'key': key.split('_')[0],
                        'name': key.split('_')[0],
                        'value': [{'n': j['type_name'], 'v': j['type_name']} for j in value if j.get('type_name')]
                    })
            return type_id, filter_list
        except Exception as e:
            print(f'获取type_id={type_id}的筛选数据失败: {e}')
            return type_id, []

    def aes(self, word,key=None, b=True):
        if not key:key=self.keys[1]
        cipher = AES.new(key.encode(), AES.MODE_ECB)
        word = word.encode('utf-8-sig').decode('ascii', errors='ignore')
        if b:
            word = b64decode(word)
            decrypted = cipher.decrypt(word)
            word = unpad(decrypted, AES.block_size).decode()
        else:
            padded = pad(word.encode(), AES.block_size)
            encrypted = cipher.encrypt(padded)
            word = b64encode(encrypted).decode()
        return word

