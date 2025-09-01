# -*- coding: utf-8 -*-
# by @嗷呜
import json
import sys
import time
import uuid
from base64 import b64decode, b64encode
from concurrent.futures import ThreadPoolExecutor, as_completed

from Crypto.Cipher import AES
from Crypto.Hash import SHA256, MD5
from Crypto.PublicKey import RSA
from Crypto.Signature import pkcs1_15
from Crypto.Util.Padding import unpad

sys.path.append('..')
from base.spider import Spider


class Spider(Spider):

    def init(self, extend=""):
        self.host, self.appKey, self.rsakey = self.userinfo()
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
        data = self.fetch(f"{self.host}/api.php/zjv6.vod/types", headers=self.getheader()).json()
        dy = {"class": "类型", "area": "地区", "lang": "语言", "year": "年份", "letter": "字母", "by": "排序", }
        filters = {}
        classes = []
        json_data = data['data']['list']
        for item in json_data:
            has_non_empty_field = False
            jsontype_extend = item["type_extend"]
            jsontype_extend['by'] = '按更新,按播放,按评分,按收藏'
            classes.append({"type_name": item["type_name"], "type_id": item["type_id"]})
            for key in dy:
                if key in jsontype_extend and jsontype_extend[key].strip() != "":
                    has_non_empty_field = True
                    break
            if has_non_empty_field:
                filters[str(item["type_id"])] = []
                for dkey in jsontype_extend:
                    if dkey in dy and jsontype_extend[dkey].strip() != "":
                        values = jsontype_extend[dkey].split(",")
                        sl = {'按更新': 'time', '按播放': 'hits', '按评分': 'score', '按收藏': 'store_num'}
                        value_array = [
                            {"n": value.strip(), "v": sl[value.strip()] if dkey == "by" else value.strip()}
                            for value in values
                            if value.strip() != ""
                        ]
                        filters[str(item["type_id"])].append(
                            {"key": dkey, "name": dy[dkey], "value": value_array}
                        )
        result = {"class": classes, "filters": filters}
        return result

    def homeVideoContent(self):
        data = self.fetch(f"{self.host}/api.php/zjv6.vod/vodPhbAll", headers=self.getheader()).json()
        return {'list': data['data']['list'][0]['vod_list']}

    def categoryContent(self, tid, pg, filter, extend):
        params = {
            "type": tid,
            "class": extend.get('class', ''),
            "lang": extend.get('lang', ''),
            "area": extend.get('area', ''),
            "year": extend.get('year', ''),
            "by": extend.get('by', ''),
            "page": pg,
            "limit": "12"
        }
        data = self.fetch(f"{self.host}/api.php/zjv6.vod", headers=self.getheader(), params=params).json()
        result = {}
        result['list'] = data['data']['list']
        result['page'] = pg
        result['pagecount'] = 9999
        result['limit'] = 90
        result['total'] = 999999
        return result

    def detailContent(self, ids):
        data = self.fetch(f"{self.host}/api.php/zjv6.vod/detail?vod_id={ids[0]}&rel_limit=10",
                          headers=self.getheader()).json()
        vod = data['data']
        v, np = {'vod_play_from': [], 'vod_play_url': []}, {}
        for i in vod['vod_play_list']:
            n = i['player_info']['show']
            np[n] = []
            for j in i['urls']:
                j['parse'] = i['player_info']['parse2']
                nm = j.pop('name')
                np[n].append(f"{nm}${self.e64(json.dumps(j))}")
        for key, value in np.items():
            v['vod_play_from'].append(key)
            v['vod_play_url'].append('#'.join(value))
        v['vod_play_from'] = '$$$'.join(v['vod_play_from'])
        v['vod_play_url'] = '$$$'.join(v['vod_play_url'])
        vod.update(v)
        vod.pop('vod_play_list', None)
        vod.pop('type', None)
        return {'list': [vod]}

    def searchContent(self, key, quick, pg="1"):
        data = self.fetch(f"{self.host}/api.php/zjv6.vod?page={pg}&limit=20&wd={key}", headers=self.getheader()).json()
        return {'list': data['data']['list'], 'page': pg}

    def playerContent(self, flag, id, vipFlags):
        ids = json.loads(self.d64(id))
        target_url = ids['url']
        try:
            parse_str = ids.get('parse', '')
            if parse_str:
                parse_urls = parse_str.split(',')
                result_url = self.try_all_parses(parse_urls, target_url)
                if result_url:
                    return {
                        'parse': 0,
                        'url': result_url,
                        'header': {'User-Agent': 'dart:io'}
                    }
            return {
                'parse': 1,
                'url': target_url,
                'header': {'User-Agent': 'dart:io'}
            }

        except Exception as e:
            print(e)
            return {
                'parse': 1,
                'url': target_url,
                'header': {'User-Agent': 'dart:io'}
            }

    def liveContent(self, url):
        pass

    def localProxy(self, param):
        pass

    def userinfo(self):
        t = str(int(time.time() * 1000))
        uid = self.generate_uid()
        sign = self.md5(f"appKey=3bbf7348cf314874883a18d6b6fcf67a&uid={uid}&time={t}")
        headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36',
            'Connection': 'Keep-Alive',
            'appKey': '3bbf7348cf314874883a18d6b6fcf67a',
            'uid': uid,
            'time': t,
            'sign': sign,
        }

        params = {
            'access_token': '74d5879931b9774be10dee3d8c51008e',
        }

        response = self.fetch('https://gitee.com/api/v5/repos/aycapp/openapi/contents/wawaconf.txt', params=params,
                              headers=headers).json()
        data = json.loads(self.decrypt(response['content']))
        return data['baseUrl'], data['appKey'], data['appSecret']

    def e64(self, text):
        try:
            text_bytes = text.encode('utf-8')
            encoded_bytes = b64encode(text_bytes)
            return encoded_bytes.decode('utf-8')
        except Exception as e:
            print(f"Base64编码错误: {str(e)}")
            return ""

    def d64(self, encoded_text):
        try:
            encoded_bytes = encoded_text.encode('utf-8')
            decoded_bytes = b64decode(encoded_bytes)
            return decoded_bytes.decode('utf-8')
        except Exception as e:
            print(f"Base64解码错误: {str(e)}")
            return ""

    def md5(self, text):
        h = MD5.new()
        h.update(text.encode('utf-8'))
        return h.hexdigest()

    def generate_uid(self):
        return uuid.uuid4().hex

    def getheader(self):
        t = str(int(time.time() * 1000))
        uid = self.generate_uid()
        sign = self.sign_message(f"appKey={self.appKey}&time={t}&uid={uid}")
        headers = {
            'User-Agent': 'okhttp/4.9.3',
            'Connection': 'Keep-Alive',
            'uid': uid,
            'time': t,
            'appKey': self.appKey,
            'sign': sign,
        }
        return headers

    def decrypt(self, encrypted_data):
        key = b64decode('Crm4FXWkk5JItpYirFDpqg==')
        cipher = AES.new(key, AES.MODE_ECB)
        encrypted = bytes.fromhex(self.d64(encrypted_data))
        decrypted = cipher.decrypt(encrypted)
        unpadded = unpad(decrypted, AES.block_size)
        return unpadded.decode('utf-8')

    def sign_message(self, message):
        private_key_str = f"-----BEGIN PRIVATE KEY-----\n{self.rsakey}\n-----END PRIVATE KEY-----"
        private_key = RSA.import_key(private_key_str)
        message_hash = SHA256.new(message.encode('utf-8'))
        signature = pkcs1_15.new(private_key).sign(message_hash)
        signature_b64 = b64encode(signature).decode('utf-8')
        return signature_b64

    def fetch_url(self, parse_url, target_url):
        try:
            response = self.fetch(f"{parse_url.replace('..', '.')}{target_url}",
                                  headers={"user-agent": "okhttp/4.1.0/luob.app"}, timeout=5)
            if response.status_code == 200:
                try:
                    data = response.json()
                    result_url = data.get('url') or data.get('data', {}).get('url')
                    if result_url:
                        return result_url
                except:
                    pass
            return None
        except:
            return None

    def try_all_parses(self, parse_urls, target_url):
        with ThreadPoolExecutor(max_workers=(len(parse_urls))) as executor:
            future_to_url = {
                executor.submit(self.fetch_url, parse_url.strip(), target_url): parse_url
                for parse_url in parse_urls if parse_url.strip()
            }

            for future in as_completed(future_to_url):
                try:
                    result = future.result()
                    if result:
                        return result
                except:
                    continue
        return None

