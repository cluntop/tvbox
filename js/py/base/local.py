#coding=utf-8
#!/usr/bin/python
from re import sub
from requests import get
from urllib.parse import unquote
from threading import Thread, Event
from socketserver import ThreadingMixIn
from urllib.parse import urlparse, parse_qs
from importlib.machinery import SourceFileLoader
from http.server import BaseHTTPRequestHandler, HTTPServer

cache = {}
class ProxyServer(BaseHTTPRequestHandler):
    def do_GET(self):
        urlParts = urlparse(self.path)
        queryQarams = parse_qs(urlParts.query)
        do = queryQarams['do'][0]
        try:
            key = queryQarams['key'][0]
        except:
            key = ''
        try:
            value = queryQarams['value'][0]
        except:
            value = ''
        if do == 'set':
            cache[key] = value
            self.send_response(200)
            self.end_headers()
        if do == 'get':
            self.send_response(200)
            self.end_headers()
            if key in cache:
                self.wfile.write(cache[key].encode())
        elif do == 'delete':
            cache.pop(key, None)
            self.send_response(200)
            self.end_headers()
        else:
            self.send_response(200)
            self.end_headers()

    def do_POST(self):
        urlParts = urlparse(self.path)
        queryQarams = parse_qs(urlParts.query)
        key = queryQarams['key'][0]
        try:
            contentLength = int(self.headers.get('Content-Length', 0))
            value = self.rfile.read(contentLength).decode().replace('+', ' ')
            value = sub(r'value=(.*?)', '', unquote(value))
        except:
            value = ''
        cache[key] = value
        self.send_response(200)
        self.end_headers()

class ThreadedHTTPServer(ThreadingMixIn, HTTPServer):
    """Handle requests in a separate thread."""

def serveForever(event):
    try:
        while not event.is_set():
            ThreadedHTTPServer(('0.0.0.0', 9978), ProxyServer).handle_request()
        ThreadedHTTPServer(('0.0.0.0', 9978), ProxyServer).server_close()
    except Exception as erro:
        print(erro)
    finally:
        ThreadedHTTPServer(('0.0.0.0', 9978), ProxyServer).server_close()

def loadFromDisk(fileName):
    name = fileName.split('/')[-1].split('.')[0]
    sp = SourceFileLoader(name, fileName).load_module().Spider()
    return sp

def run(fileName, proxy=False):
    event = Event()
    if proxy:
        thread = Thread(target=serveForever, args=(event,), name='localProxy')
        thread.start()
    sp = loadFromDisk(f'../plugin/{fileName}.py')  #载入本地脚本
    sp.init('') # 初始化
    try:
        # formatJo = sp.decode('')
        # formatJo = sp.homeContent(True)  # 主页
        # formatJo = sp.homeVideoContent()  # 主页视频
        formatJo = sp.searchContentPage("繁花", False, '1') # 搜索
        # formatJo = sp.categoryContent('bilibili', 1, False, {})  # 分类
        # formatJo = sp.detailContent([''])  # 详情
        # formatJo = sp.playerContent("", '', {})  # 播放
        # formatJo = sp.localProxy({}) # 本地代理
        print(formatJo)
    except Exception as erro:
        print(erro)
    finally:
        event.set()
        try:
            get('http://127.0.0.1:9978/cache?do=none')
        except:
            pass

if __name__ == '__main__':
    """
    run(PY爬虫文件名, 是否启用本地代理)
    再去run函数中修改函数参数
    """
    run('py_bilibilivd', True)