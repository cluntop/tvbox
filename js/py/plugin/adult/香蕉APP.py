# -*- coding: utf-8 -*-
# by @嗷呜
import random
import string
import sys
sys.path.append('..')
from base.spider import Spider


class Spider(Spider):

    def init(self, extend=""):
        self.host,self.headers = self.getat()
        pass

    def getName(self):
        pass

    def isVideoFormat(self, url):
        pass

    def manualVideoCheck(self):
        pass

    def destroy(self):
        pass

    def homeContent(self, filter):
        data=self.fetch(f'{self.host}/vod/listing-0-0-0-0-0-0-0-0-0-0',headers=self.headers).json()
        result = {}
        classes = [{
                'type_name': '全部',
                'type_id': '0'
            }]
        filters = {}
        ft=[]
        filter_keys = ['orders', 'areas', 'years', 'definitions', 'durations', 'mosaics', 'langvoices']
        for key in filter_keys:
            if key in data['data']:
                filter_item = {
                    'key': key,
                    'name': key,
                    'value': []
                }
                for item in data['data'][key]:
                    first_two = dict(list(item.items())[:2])
                    filter_item['value'].append({
                        'v': list(first_two.values())[0],
                        'n': list(first_two.values())[1]
                    })
                ft.append(filter_item)
        filters['0']=ft
        for k in data['data']['categories']:
            classes.append({
                'type_name': k['catename'],
                'type_id': k['cateid']
            })
            filters[k['cateid']]=ft

        result['class'] = classes
        result['filters'] =filters
        result['list'] = self.getlist(data['data']['vodrows'])
        return result

    def homeVideoContent(self):
        pass

    def categoryContent(self, tid, pg, filter, extend):
        data=self.fetch(f'{self.host}/vod/listing-{tid}-{extend.get("areas","0")}-{extend.get("years","0")}-1-{extend.get("definitions","0")}-{extend.get("durations","0")}-{extend.get("mosaics","0")}-{extend.get("langvoices","0")}-{extend.get("orders","0")}-{pg}',headers=self.headers).json()
        result = {}
        result['list'] = self.getlist(data['data']['vodrows'])
        result['page'] = pg
        result['pagecount'] = 9999
        result['limit'] = 90
        result['total'] = 999999
        return result

    def detailContent(self, ids):
        data=self.fetch(f'{self.host}/vod/reqplay/{ids[0]}',headers=self.headers).json()
        vod = {
            'vod_play_from': data['errmsg'],
            'vod_play_url': '#'.join([f"{i['hdtype']}${i['httpurl']}" for i in data['data']['httpurls']]),
        }
        return {'list':[vod]}

    def searchContent(self, key, quick, pg="1"):
        data=self.fetch(f'{self.host}/search?page={pg}&wd={key}',headers=self.headers).json()
        return {'list':self.getlist(data['data']['vodrows']),'page':pg}

    def playerContent(self, flag, id, vipFlags):
        return  {'parse': 0, 'url': id, 'header': {'User-Agent':'ExoPlayer'}}

    def localProxy(self, param):
        pass

    def getlist(self,data):
        vlist=[]
        for i in data:
            if i['isvip'] !='1':
                vlist.append({
                    'vod_id': i['vodid'],
                    'vod_name': i['title'],
                    'vod_pic': i['coverpic'],
                    'vod_year': i.get('duration'),
                    'vod_remarks': i.get('catename'),
                    'style': {"type": "rect", "ratio": 1.33}
                })
        return vlist

    def getat(self):
        headers = {
            'User-Agent': 'Mozilla/5.0 (Linux; Android 11; M2012K10C Build/RP1A.200720.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/87.0.4280.141 Mobile Safari/537.36',
            'Accept': 'application/json, text/plain, */*',
            'x-auth-uuid': self.random_str(32),
            'x-system': 'Android',
            'x-version': '5.0.5',
            'x-channel': 'xj2',
            'x-requested-with': 'com.uyvzkv.pnjzdv',
            'sec-fetch-site': 'cross-site',
            'sec-fetch-mode': 'cors',
            'sec-fetch-dest': 'empty',
            'accept-language': 'zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7',
        }
        host=f'https://{self.random_str(6)}.bjhpz.com'
        data=self.fetch(f'{host}/init',headers=headers).json()
        headers.update({'x-cookie-auth': data['data']['globalData'].get('xxx_api_auth')})
        return host,headers

    def random_str(self,length=16):
        chars = string.ascii_lowercase + string.digits
        return ''.join(random.choice(chars) for _ in range(length))

