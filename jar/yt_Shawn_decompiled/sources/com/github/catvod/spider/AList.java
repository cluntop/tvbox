package com.github.catvod.spider;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.a.e;
import com.github.catvod.spider.merge.a.h;
import com.github.catvod.spider.merge.b.c;
import com.github.catvod.spider.merge.b.f;
import com.github.catvod.spider.merge.m.d;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class AList extends Spider {
    public ExecutorService a;
    public List b;
    public String c;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class Job implements Callable<List<h>> {
        public final com.github.catvod.spider.merge.b.a a;
        public final String b;

        public Job(com.github.catvod.spider.merge.b.a aVar, String str) {
            this.a = aVar;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        public List<h> call() {
            AList aList = AList.this;
            com.github.catvod.spider.merge.b.a aVar = this.a;
            try {
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                sb.append(aVar.d());
                sb.append(aVar.i() ? "/api/fs/search" : "/api/public/search");
                String string = sb.toString();
                String strJ = aVar.j(this.b);
                aList.getClass();
                String strD = AList.d(aVar, string, strJ, true);
                for (c cVar : (List) new Gson().fromJson(aVar.i() ? new JSONObject(strD).getJSONObject("data").getJSONArray("content").toString() : new JSONObject(strD).getJSONArray("data").toString(), TypeToken.getParameterized(List.class, new Type[]{c.class}).getType())) {
                    if (!cVar.h(aVar.i())) {
                        arrayList.add(cVar.e(aVar));
                    }
                }
                return arrayList;
            } catch (Exception unused) {
                return Collections.EMPTY_LIST;
            }
        }
    }

    public static String d(com.github.catvod.spider.merge.b.a aVar, String str, String str2, boolean z) throws JSONException {
        String str3 = (String) new d("POST", str, str2, aVar.c()).g(com.github.catvod.spider.merge.g1.a.d()).b;
        boolean zIsEmpty = TextUtils.isEmpty(str3);
        String str4 = VideoStream.RESOLUTION_UNKNOWN;
        if (zIsEmpty) {
            str3 = VideoStream.RESOLUTION_UNKNOWN;
        }
        SpiderDebug.log(str3);
        if (z && str3.contains("Guest user is disabled")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", aVar.e().b());
                jSONObject.put("password", aVar.e().a());
                String str5 = (String) new d("POST", aVar.d() + "/api/auth/login", jSONObject.toString(), null).g(com.github.catvod.spider.merge.g1.a.d()).b;
                if (!TextUtils.isEmpty(str5)) {
                    str4 = str5;
                }
                aVar.l(new JSONObject(str4).getJSONObject("data").getString("token"));
                return d(aVar, str, str2, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str3;
    }

    public final c a(String str) throws JSONException {
        try {
            String strSubstring = str.contains("/") ? str.substring(0, str.indexOf("/")) : str;
            String strSubstring2 = str.contains("/") ? str.substring(str.indexOf("/")) : VideoStream.RESOLUTION_UNKNOWN;
            com.github.catvod.spider.merge.b.a aVarB = b(strSubstring);
            if (!strSubstring2.startsWith(aVarB.g())) {
                strSubstring2 = aVarB.g() + strSubstring2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", strSubstring2);
            jSONObject.put("password", aVarB.b(strSubstring2));
            StringBuilder sb = new StringBuilder();
            sb.append(aVarB.d());
            sb.append(aVarB.i() ? "/api/fs/get" : "/api/public/path");
            String strD = d(aVarB, sb.toString(), jSONObject.toString(), true);
            return (c) new Gson().fromJson(aVarB.i() ? new JSONObject(strD).getJSONObject("data").toString() : new JSONObject(strD).getJSONObject("data").getJSONArray("files").getJSONObject(0).toString(), c.class);
        } catch (Exception unused) {
            return new c();
        }
    }

    public final com.github.catvod.spider.merge.b.a b(String str) {
        List list = this.b;
        com.github.catvod.spider.merge.b.a aVar = (com.github.catvod.spider.merge.b.a) list.get(list.indexOf(new com.github.catvod.spider.merge.b.a(str)));
        aVar.a();
        return aVar;
    }

    public final List c(String str, boolean z) throws JSONException {
        try {
            String strSubstring = str.contains("/") ? str.substring(0, str.indexOf("/")) : str;
            String strSubstring2 = str.contains("/") ? str.substring(str.indexOf("/")) : VideoStream.RESOLUTION_UNKNOWN;
            com.github.catvod.spider.merge.b.a aVarB = b(strSubstring);
            if (!strSubstring2.startsWith(aVarB.g())) {
                strSubstring2 = aVarB.g() + strSubstring2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", strSubstring2);
            jSONObject.put("password", aVarB.b(strSubstring2));
            StringBuilder sb = new StringBuilder();
            sb.append(aVarB.d());
            sb.append(aVarB.i() ? "/api/fs/list" : "/api/public/path");
            String strD = d(aVarB, sb.toString(), jSONObject.toString(), true);
            List list = (List) new Gson().fromJson(aVarB.i() ? new JSONObject(strD).getJSONObject("data").getJSONArray("content").toString() : new JSONObject(strD).getJSONObject("data").getJSONArray("files").toString(), TypeToken.getParameterized(List.class, new Type[]{c.class}).getType());
            Iterator it = list.iterator();
            if (z) {
                while (it.hasNext()) {
                    if (((c) it.next()).h(aVarB.i())) {
                        it.remove();
                    }
                }
            }
            return list;
        } catch (Exception unused) {
            return Collections.EMPTY_LIST;
        }
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        boolean zContainsKey = map.containsKey("type");
        String str3 = VideoStream.RESOLUTION_UNKNOWN;
        String str4 = zContainsKey ? map.get("type") : VideoStream.RESOLUTION_UNKNOWN;
        if (map.containsKey("order")) {
            str3 = map.get("order");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (c cVar : c(str, true)) {
            if (cVar.i()) {
                arrayList.add(cVar);
            } else {
                arrayList2.add(cVar);
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            Collections.sort(arrayList, new f(str4, str3, 0));
            Collections.sort(arrayList2, new f(str4, str3, 0));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(((c) it.next()).f(str));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((c) it2.next()).f(str));
        }
        e eVar = new e();
        eVar.s(arrayList3);
        eVar.g(1, 1, 0, 1);
        return eVar.toString();
    }

    public void destroy() {
        this.a.shutdownNow();
    }

    public String detailContent(List<String> list) throws JSONException {
        String str = list.get(0);
        String strSubstring = str.contains("/") ? str.substring(0, str.indexOf("/")) : str;
        String strSubstring2 = str.substring(0, str.lastIndexOf("/"));
        String strSubstring3 = strSubstring2.substring(strSubstring2.lastIndexOf("/") + 1);
        com.github.catvod.spider.merge.b.a aVarB = b(strSubstring);
        h hVar = new h();
        hVar.i(strSubstring);
        hVar.f(str);
        hVar.g(strSubstring3);
        ArrayList arrayList = new ArrayList();
        List<c> listC = c(strSubstring2, false);
        for (c cVar : listC) {
            if (cVar.j(aVarB.i())) {
                StringBuilder sb = new StringBuilder();
                sb.append(cVar.b());
                sb.append("$");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cVar.g(strSubstring2));
                StringBuilder sb3 = new StringBuilder();
                for (c cVar2 : listC) {
                    String strA = com.github.catvod.spider.merge.o.e.a(cVar2.b());
                    if (com.github.catvod.spider.merge.o.e.c.contains(com.github.catvod.spider.merge.o.e.a(strA).toLowerCase())) {
                        sb3.append("~~~");
                        sb3.append(cVar2.b());
                        sb3.append("@@@");
                        sb3.append(strA);
                        sb3.append("@@@");
                        sb3.append(cVar2.g(strSubstring2));
                    }
                }
                sb2.append(sb3.toString());
                String string = sb2.toString();
                if (string.contains("#")) {
                    string = string.replace("#", "***");
                }
                sb.append(string);
                arrayList.add(sb.toString());
            }
        }
        hVar.j(TextUtils.join("#", arrayList));
        return e.j(hVar);
    }

    public String homeContent(boolean z) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (com.github.catvod.spider.merge.b.a aVar : this.b) {
            if (!aVar.h().booleanValue()) {
                arrayList.add(new com.github.catvod.spider.merge.a.a(aVar.f(), aVar.f(), "1"));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String strA = ((com.github.catvod.spider.merge.a.a) it.next()).a();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new com.github.catvod.spider.merge.a.d("type", "排序類型", Arrays.asList(new com.github.catvod.spider.merge.a.c("預設", VideoStream.RESOLUTION_UNKNOWN), new com.github.catvod.spider.merge.a.c("名稱", "name"), new com.github.catvod.spider.merge.a.c("大小", "size"), new com.github.catvod.spider.merge.a.c("修改時間", "date"))));
            arrayList2.add(new com.github.catvod.spider.merge.a.d("order", "排序方式", Arrays.asList(new com.github.catvod.spider.merge.a.c("預設", VideoStream.RESOLUTION_UNKNOWN), new com.github.catvod.spider.merge.a.c("⬆", "asc"), new com.github.catvod.spider.merge.a.c("⬇", "desc"))));
            linkedHashMap.put(strA, arrayList2);
        }
        return e.m(arrayList, linkedHashMap);
    }

    public void init(Context context, String str) {
        this.a = Executors.newCachedThreadPool();
        this.c = str;
        List list = this.b;
        if (list == null || list.isEmpty()) {
            if (this.c.startsWith("http")) {
                this.c = com.github.catvod.spider.merge.g1.a.f(this.c, null);
            }
            this.b = (List) new Gson().fromJson(this.c, TypeToken.getParameterized(List.class, new Type[]{com.github.catvod.spider.merge.b.a.class}).getType());
        }
    }

    public String playerContent(String str, String str2, List<String> list) {
        HashMap map;
        if (str2.contains("***")) {
            str2 = str2.replace("***", "#");
        }
        String[] strArrSplit = str2.split("~~~");
        String strD = a(strArrSplit[0]).d();
        e eVar = new e();
        eVar.q(strD);
        try {
            Uri uri = Uri.parse(strD);
            map = new HashMap();
            if (uri.getHost().contains("115")) {
                map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
            }
            if (uri.getHost().contains("baidupcs.com")) {
                map.put("User-Agent", "pan.baidu.com");
            }
        } catch (Exception unused) {
            map = new HashMap();
        }
        eVar.d(map);
        ArrayList arrayList = new ArrayList();
        for (String str3 : strArrSplit) {
            if (str3.contains("@@@")) {
                String[] strArrSplit2 = str3.split("@@@");
                String str4 = strArrSplit2[0];
                String str5 = strArrSplit2[1];
                String strD2 = a(strArrSplit2[2]).d();
                com.github.catvod.spider.merge.a.f fVar = new com.github.catvod.spider.merge.a.f();
                fVar.b(str4);
                fVar.a(str5);
                fVar.c(strD2);
                arrayList.add(fVar);
            }
        }
        eVar.p(arrayList);
        return eVar.toString();
    }

    public String searchContent(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.github.catvod.spider.merge.b.a aVar : this.b) {
            if (aVar.k().booleanValue()) {
                aVar.a();
                arrayList2.add(new Job(aVar, str));
            }
        }
        Iterator it = this.a.invokeAll(arrayList2, 15L, TimeUnit.SECONDS).iterator();
        while (it.hasNext()) {
            arrayList.addAll((Collection) ((Future) it.next()).get());
        }
        return e.o(arrayList);
    }
}
