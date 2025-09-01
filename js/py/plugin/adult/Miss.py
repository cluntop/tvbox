# -*- coding: utf-8 -*-
# by @嗷呜
import copy
import gzip
import json
import re
import sys
import time
import uuid
from base64 import b64decode
from urllib.parse import urlparse, urlunparse
from Crypto.Hash import SHA1, HMAC
from pyquery import PyQuery as pq
sys.path.append('..')
from base.spider import Spider


class Spider(Spider):

    def init(self, extend=""):
        '''
        {
            "": "",
            "ext": {
                "site": "https://missav.ai",
                "cfproxy": ""
            }
        }
        自备:过cf代理如https://xx.vvvv.cc/proxy?url=
        '''
        try:
            ext=json.loads(extend)
            self.host,self.pcf,self.phost=ext.get('site',''),ext.get('cfproxy',''),''
            if self.pcf:
                parsed_url=urlparse(self.pcf)
                self.phost=parsed_url.scheme + "://" + parsed_url.netloc
        except:
            pass
        self.headers = {
            'referer': f'{self.host}',
            'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36'
        }
        pass

    def getName(self):
        pass

    def isVideoFormat(self, url):
        pass

    def manualVideoCheck(self):
        pass

    def destroy(self):
        pass

    xhost='https://client-rapi-missav.recombee.com'

    fts = 'H4sIAAAAAAAAA23P30rDMBQG8FeRXM8X8FVGGZk90rA0HU3SMcZgXjn8V6p2BS2KoOiFAwUn2iK+TBP7GBpYXbG9/c6Pc77TnaABjNHOFtojVIDPUQcx7IJJvl9ydX30GwSYSpN0J4iZgTqJiywrPlN1vm/GJiPMJgGxJaZo2qnc3WXDuZIKMqSwUcX7Ui8O1DJRH3Gldh3CgMM2l31BhNGW8euq3PNFrac+PVNZ2NYzjMrbY53c6/Sm2uwDBczB7mGxqaDTWfkV6atXvXiu4FD2KeHOf3nxViahjv8YxwHYtWfyQ3NvFZYP85oSno3HvYDAiNevPqnosWFHAAPahnU6b2DXY8Jp0bO8QdfEmlo/SBd5PPUBAAA='

    actfts = 'H4sIAAAAAAAAA5WVS2sUQRRG/0rT6xTcqq5Xiwjm/X6sQxZjbBLRBBeOIEGIIEgWrtwI4lJEQsjGhU6Iv2bGcf6FVUUydW/d1SxT55sDfbpmsn9WP+/e1A+q+rh7dnT8qp6rT3snXTz4N7icXH4OB697L/rxZP+sPo1g+Ot8PPg+vvoyOb+IOJ7Vb+fuqGxkJSrZmMOTexiORDjAGxs3GvDGinCANjp5NPbo4NHYo5PHYI8OHoM9JnkM9pjgMdhjksdijwkeiz02eSz22OCx2GOTx2GPDR6HPS55HPa44HHY45LHY48LHo89Pnk89vjg8djjk6fFHh88bfAcxNXduz/sv0Qvfnz74+/X65lf/OMqfzD9ndF8geYzWijQQkaLBVrMaKlASxktF2g5o5UCrWS0WqDVjNYKtJbReoHWM9oo0EZGmwXazGirQFsZbRdoO6OdAu1ktFug3Yz2CrRH70TvqEN3YvT75+TP+5nvxMNKwf0pCIWur4JwM5spVCAaRJtI9ZQ2IPBPg47UTKkGgb/wJlI7pQYE/ho/QsiCaFv61E+7J338Izj6MJi8+xSefnhzO/PTK1CmGt58G118zM+pDBloPtBk0PBBQwaKDxQZSD6QZAB8QN6UbNlAtmTg+cCTgeMDRwaWDywZ8JKSlJS8pCQlJS8pSUnJS0pSUvKSkpSUvKQkJYGXBFISeEkgJYGXBFISeEkgJYGXBFISeEkgJYGXBFISeEkgJYGXBFISeElI/7QO/gOZ7bAksggAAA=='

    def homeContent(self, filter):
        html = self.getpq(f"{self.host}/cn",headers=self.headers)
        result = {}
        filters = {}
        classes=[]
        for i in list(html('.mt-4.space-y-4').items())[:2]:
            for j in i('ul li').items():
                id=j('a').attr('href').split('/')[-1]
                classes.append({
                    'type_name': j.text(),
                    'type_id': id
                })
                filters[id] = copy.deepcopy(self.ungzip(self.fts))
                if id=='actresses':filters[id].extend(self.ungzip(self.actfts))
        result['class'] = classes
        result['filters'] = filters
        result['list'] = self.getlist(html('.grid-cols-2.md\\:grid-cols-3 .thumbnail.group'))
        return result

    def homeVideoContent(self):
        pass

    def categoryContent(self, tid, pg, filter, extend):
        params={
            'page':'' if pg=='1' else pg
        }
        ft = {
            'filters': extend.get('filters', ''),
            'sort': extend.get('sort', '')
        }
        if tid in ['makers', 'genres']:
            ft = {}
        elif tid == 'actresses':
            ft = {
                'height': extend.get('height', ''),
                'cup': extend.get('cup', ''),
                'debut': extend.get('debut', ''),
                'age': extend.get('age', ''),
                'sort': extend.get('sort', '')
            }
        params.update(ft)
        params = {k: v for k, v in params.items() if v != ""}
        url=tid if 'http' in tid else f"{self.host}/cn/{tid}"
        data=self.getpq(url,headers=self.headers,params=params)
        result = {}
        if tid in ['makers', 'genres']:
            videos = self.gmsca(data)
        elif tid == 'actresses':
            videos = self.actca(data)
        else:
            videos = self.getlist(data('.grid-cols-2.md\\:grid-cols-3 .thumbnail.group'))
        result['list'] = videos
        result['page'] = pg
        result['pagecount'] = 9999
        result['limit'] = 90
        result['total'] = 999999
        return result

    def detailContent(self, ids):
        v=self.getpq(ids[0],headers=self.headers)
        sctx=v('body script').text()
        urls=self.execute_js(sctx)
        if not urls:urls=f"嗅探${ids[0]}"
        c=v('.space-y-2 .text-secondary')
        ac,dt,bq=[],[],[]
        for i in c.items():
            if re.search(r"导演:|女优:",i.text()):
                ac.extend(['[a=cr:' + json.dumps({'id': j.attr('href'), 'name': j.text()}) + '/]' + j.text() + '[/a]' for j in i('a').items()])
            elif '发行商:' in i.text():
                dt.extend(['[a=cr:' + json.dumps({'id': j.attr('href'), 'name': j.text()}) + '/]' + j.text() + '[/a]' for j in i('a').items()])
            elif re.search(r"标籤:|系列:|类型:",i.text()):
                bq.extend(['[a=cr:' + json.dumps({'id': j.attr('href'), 'name': j.text()}) + '/]' + j.text() + '[/a]' for j in i('a').items()])
        np={'MissAV':urls,'相关视频':self.getfov(ids[0])}
        vod = {
            'type_name': c.eq(-3)('a').text(),
            'vod_year': c.eq(0)('span').text(),
            'vod_remarks': ' '.join(bq),
            'vod_actor': ' '.join(ac),
            'vod_director': ' '.join(dt),
            'vod_content': v('.text-secondary.break-all').text()
        }
        names,plist=[],[]
        for i,j in np.items():
            if j:
                names.append(i)
                plist.append(j)
        vod['vod_play_from']='$$$'.join(names)
        vod['vod_play_url']='$$$'.join(plist)
        return {'list': [vod]}

    def searchContent(self, key, quick, pg="1"):
        data=self.getpq(f"{self.host}/cn/search/{key}",headers=self.headers,params={'page':pg})
        return {'list': self.getlist(data('.grid-cols-2.md\\:grid-cols-3 .thumbnail.group')),'page':pg}

    def playerContent(self, flag, id, vipFlags):
        p=0 if '嗅' in flag else 1
        if '相关' in flag:
            try:
                v = self.getpq(id, headers=self.headers)
                sctx = v('body script').text()
                urls = self.execute_js(sctx)
                if not urls: raise Exception("没有找到地址")
                p,id=0,urls.split('#')[0].split('$')[-1]
            except:
                p=1
        return {'parse': p, 'url': id, 'header': self.headers}

    def localProxy(self, param):
        pass

    def josn_to_params(self, params, skip_empty=False):
        query = []
        for k, v in params.items():
            if skip_empty and not v:
                continue
            query.append(f"{k}={v}")
        return "&".join(query)

    def getpq(self, url, headers=None,params='',min=0,max=3):
        if not min and self.phost in url:
            url=url.replace(self.phost,self.host)
        if params=={}:params=''
        if params:
            params=f"?{self.josn_to_params(params)}"
        response=self.fetch(f"{self.pcf}{url}{params}", headers=headers,verify=False)
        res=response.text
        if 300 <= response.status_code < 400:
            if min >= max:raise Exception(f"重定向次数过多: {res}")
            match = re.search(r"url=['\"](https?://[^'\"]+)['\"]", res)
            if match:
                url = match.group(1).replace(self.phost, self.host)
                return self.getpq(url, headers=headers,params='',min=min+1,max=max)
        try:
            return pq(res)
        except Exception as e:
            print(f"{str(e)}")
            return pq(res.encode('utf-8'))

    def getlist(self,data):
        videos = []
        names,ids=[],[]
        for i in data.items():
            k = i('.overflow-hidden.shadow-lg a')
            id=k.eq(0).attr('href')
            name=i('.text-secondary').text()
            if id and id not in ids and name not in names:
                ids.append(id)
                names.append(name)
                videos.append({
                    'vod_id': id,
                    'vod_name': name,
                    'vod_pic': k.eq(0)('img').attr('data-src'),
                    'vod_year': '' if len(list(k.items())) < 3 else k.eq(1).text(),
                    'vod_remarks': k.eq(-1).text(),
                    'style': {"type": "rect", "ratio": 1.33}
                })
        return videos

    def gmsca(self,data):
        acts=[]
        for i in data('.grid.grid-cols-2.md\\:grid-cols-3 div').items():
            acts.append({
                'vod_id': i('.text-nord13').attr('href'),
                'vod_name': i('.text-nord13').text(),
                'vod_pic': '',
                'vod_remarks': i('.text-nord10').text(),
                'vod_tag': 'folder',
                'style': {"type": "rect", "ratio": 1.33}
            })
        return acts

    def actca(self,data):
        acts=[]
        for i in data('.max-w-full ul li').items():
            acts.append({
                'vod_id': i('a').attr('href'),
                'vod_name': i('img').attr('alt'),
                'vod_pic': i('img').attr('src'),
                'vod_year': i('.text-nord10').eq(-1).text(),
                'vod_remarks': i('.text-nord10').eq(0).text(),
                'vod_tag': 'folder',
                'style': {"type": "oval"}
            })
        return acts

    def getfov(self, url):
        try:
            h=self.headers.copy()
            ids=url.split('/')
            h.update({'referer':f'{url}/'})
            t=str(int(time.time()))
            params = {
                'frontend_timestamp': t,
                'frontend_sign': self.getsign(f"/missav-default/batch/?frontend_timestamp={t}"),
            }
            uid=str(uuid.uuid4())
            json_data = {
                'requests': [
                    {
                        'method': 'POST',
                        'path': f'/recomms/items/{ids[-1]}/items/',
                        'params': {
                            'targetUserId': uid,
                            'count': 13,
                            'scenario': 'desktop-watch-next-side',
                            'returnProperties': True,
                            'includedProperties': [
                                'title_cn',
                                'duration',
                                'has_chinese_subtitle',
                                'has_english_subtitle',
                                'is_uncensored_leak',
                                'dm',
                            ],
                            'cascadeCreate': True,
                        },
                    },
                    {
                        'method': 'POST',
                        'path': f'/recomms/items/{ids[-1]}/items/',
                        'params': {
                            'targetUserId': uid,
                            'count': 12,
                            'scenario': 'desktop-watch-next-bottom',
                            'returnProperties': True,
                            'includedProperties': [
                                'title_cn',
                                'duration',
                                'has_chinese_subtitle',
                                'has_english_subtitle',
                                'is_uncensored_leak',
                                'dm',
                            ],
                            'cascadeCreate': True,
                        },
                    },
                ],
                'distinctRecomms': True,
            }
            data = self.post(f'{self.xhost}/missav-default/batch/', params=params,headers=h, json=json_data).json()
            vdata=[]
            for i in data:
                for j in i['json']['recomms']:
                    if j.get('id'):
                        vdata.append(f"{j['values']['title_cn']}${self.host}/cn/{j['id']}")
            return '#'.join(vdata)
        except Exception as e:
            print(f"获取推荐失败: {e}")
            return ''

    def getsign(self, text):
        message_bytes = text.encode('utf-8')
        key_bytes = b'Ikkg568nlM51RHvldlPvc2GzZPE9R4XGzaH9Qj4zK9npbbbTly1gj9K4mgRn0QlV'
        h = HMAC.new(key_bytes, digestmod=SHA1)
        h.update(message_bytes)
        signature = h.hexdigest()
        return signature

    def ungzip(self, data):
        result=gzip.decompress(b64decode(data)).decode('utf-8')
        return json.loads(result)

    def execute_js(self, jstxt):
        js_code = re.search(r"eval\(function\(p,a,c,k,e,d\).*?return p\}(.*?)\)\)", jstxt).group(0)
        try:
            from com.whl.quickjs.wrapper import QuickJSContext
            ctx = QuickJSContext.create()
            ctx.evaluate(js_code)
            result = []
            common_vars = ["source", "source842", "source1280"]
            for var_name in common_vars:
                try:
                    value = ctx.getGlobalObject().getProperty(var_name)
                    if value is not None:
                        if isinstance(value, str):
                            value_str = value
                        else:
                            value_str = value.toString()
                        if "http" in value_str:
                            result.append(f"{var_name}${value_str}")
                            self.log(f"找到变量 {var_name} = {value_str[:50]}...")
                except Exception as var_err:
                    self.log(f"获取变量 {var_name} 失败: {var_err}")
            ctx.destroy()
            return '#'.join(result)
        except Exception as e:
            self.log(f"执行失败: {e}")
            return None

