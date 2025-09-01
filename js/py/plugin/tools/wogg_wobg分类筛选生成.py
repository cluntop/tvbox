import re
import asyncio
from urllib.parse import unquote
import aiohttp
from pyquery import PyQuery as pq

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7',
    'Accept-Language': 'zh-CN,zh;q=0.9'
}

async def fetch(session, url):
    async with session.get(url, headers=headers) as response:
        return await response.text()

def grtclass(data):
    classes = []
    vdata = []
    for i in data.items():
        j = i('a').attr('href')
        if j and ('type' in j or 'show' in j):
            id = re.search(r'\d+', j)
            if id:
                id = id.group(0)
            else:
                id = j.split('/')[-1].split('.')[0]
            if id not in vdata:
                vdata.append(id)
                classes.append({
                    'type_name': i('a').text(),
                    'type_id': id
                })
    return classes

def get_k(text,type):
    key = ''
    cates={"class": "类型,剧情", "area": "地区", "lang": "语言", "year": "年份,时间", "letter": "字母", "by": "排序","sort": "排序"}
    for i,x in cates.items():
        if type== 'wobg' and i in text:
            key = i
            break
        elif type == 'wogg':
            for j in x.split(','):
                if j in text:
                    key = i
                    break

        if type == 'wobg':
            if not key:
                if 'id' in text:
                    key = 'id'
    return key

def get_v(text,key,type):
    if type == 'wobg':
        return text.split(f'{key}/')[-1].split('/')[0].split('.')[0]
    else:
        v=text.split('/',-1)[-1].split('.')[0][1:].replace('-','')
        if v=='09':v='0-9'
        return v

async def c(session, host):
    html = await fetch(session, host)
    data = pq(html)
    classes = grtclass(data('.drop-content-items li'))
    if not len(classes): classes = grtclass(data('.nav-menu-items li'))
    return classes

async def get_ft(session, url,type):
    print(f"请求: {url}")
    html = await fetch(session, url)
    data = pq(html)
    ft = []
    for i in list(data('div.library-box.scroll-box').items())[1:]:
        n = i('a.library-item-first').text()
        c = i('.library-list a')
        if type == 'wobg':
            key = get_k(c.eq(0).attr('href'), type)
        else:
            key = get_k(n,type)
        ft.append({
            'name': n or key,
            'key': key,
            'value': [{'v': unquote(get_v(j.attr('href'),key,type)), 'n': j.text()} for j in c.items()]
        })
    return ft

async def main(host,type):
    async with aiohttp.ClientSession() as session:
        categories = await c(session, host)
        print(f"分类: {categories}")
        tasks = []
        fts = {}
        if len(categories):
            for i in categories:
                path=f"/index.php/vod/show/id/{i['type_id']}.html" if type == 'wobg' else f"/vodtype/{i['type_id']}.html"
                task = asyncio.create_task(get_ft(session, f"{host}{path}",type))
                tasks.append((i['type_id'], task))
            for type_id, task in tasks:
                fts[type_id] = await task
        return {'class': categories, 'filters': fts}

if __name__ == '__main__':
    # url = 'http://wogg.xxooo.cf'
    url = 'http://2xiaopan.fun'
    types = ['wobg','wogg']
    loop = asyncio.get_event_loop()
    result = loop.run_until_complete(main(url, types[0]))
    print('分类筛选生成结果:')
    print(result)