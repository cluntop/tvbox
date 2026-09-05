package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.i.c;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class XtreamCode extends Spider {
    public ArrayList a;
    public com.github.catvod.spider.merge.i.a b;

    public static String a(com.github.catvod.spider.merge.i.a aVar, String str) {
        return aVar.d.newBuilder().addQueryParameter("action", str).build().toString();
    }

    public void init(Context context, String str) {
        com.github.catvod.spider.merge.i.a aVar = (com.github.catvod.spider.merge.i.a) new Gson().fromJson(str, com.github.catvod.spider.merge.i.a.class);
        if (aVar == null) {
            aVar = new com.github.catvod.spider.merge.i.a();
        }
        this.b = aVar;
        this.a = new ArrayList();
    }

    public String liveContent(String str) {
        com.github.catvod.spider.merge.i.a aVar = this.b;
        aVar.getClass();
        HttpUrl httpUrl = HttpUrl.parse(str);
        aVar.d = httpUrl;
        aVar.e = httpUrl.queryParameter("username");
        aVar.f = aVar.d.queryParameter("password");
        com.github.catvod.spider.merge.i.a aVar2 = this.b;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (aVar2.b()) {
            List list = (List) new Gson().fromJson(com.github.catvod.spider.merge.g1.a.f(a(aVar2, "get_live_categories"), null), TypeToken.getParameterized(List.class, new Type[]{com.github.catvod.spider.merge.i.b.class}).getType());
            if (list == null) {
                list = Collections.EMPTY_LIST;
            }
            arrayList.addAll(list);
        }
        if (aVar2.c()) {
            List list2 = (List) new Gson().fromJson(com.github.catvod.spider.merge.g1.a.f(a(aVar2, "get_vod_categories"), null), TypeToken.getParameterized(List.class, new Type[]{com.github.catvod.spider.merge.i.b.class}).getType());
            if (list2 == null) {
                list2 = Collections.EMPTY_LIST;
            }
            arrayList.addAll(list2);
        }
        com.github.catvod.spider.merge.i.a aVar3 = this.b;
        ArrayList arrayList2 = new ArrayList();
        if (aVar3.b()) {
            List list3 = (List) new Gson().fromJson(com.github.catvod.spider.merge.g1.a.f(a(aVar3, "get_live_streams"), null), TypeToken.getParameterized(List.class, new Type[]{c.class}).getType());
            if (list3 == null) {
                list3 = Collections.EMPTY_LIST;
            }
            arrayList2.addAll(list3);
        }
        if (aVar3.c()) {
            List list4 = (List) new Gson().fromJson(com.github.catvod.spider.merge.g1.a.f(a(aVar3, "get_vod_streams"), null), TypeToken.getParameterized(List.class, new Type[]{c.class}).getType());
            if (list4 == null) {
                list4 = Collections.EMPTY_LIST;
            }
            arrayList2.addAll(list4);
        }
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.github.catvod.spider.merge.i.b bVar = (com.github.catvod.spider.merge.i.b) it.next();
            map.put(bVar.a(), bVar.b());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            if (map.containsKey(cVar.b())) {
                ArrayList arrayList3 = this.a;
                com.github.catvod.spider.merge.d.b bVarA = com.github.catvod.spider.merge.d.b.a((String) map.get(cVar.b()));
                Iterator it3 = arrayList3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        arrayList3.add(bVarA);
                        break;
                    }
                    com.github.catvod.spider.merge.d.b bVar2 = (com.github.catvod.spider.merge.d.b) it3.next();
                    if (bVar2.c().equals(bVarA.c())) {
                        bVarA = bVar2;
                        break;
                    }
                }
                com.github.catvod.spider.merge.d.a aVarA = com.github.catvod.spider.merge.d.a.a(cVar.e());
                int iIndexOf = bVarA.b().indexOf(aVarA);
                if (iIndexOf != -1) {
                    aVarA = (com.github.catvod.spider.merge.d.a) bVarA.b().get(iIndexOf);
                } else {
                    bVarA.b().add(aVarA);
                }
                if (!cVar.f().isEmpty()) {
                    aVarA.d(cVar.f());
                }
                if (!cVar.d().isEmpty()) {
                    aVarA.f(cVar.d());
                }
                List listC = aVarA.c();
                com.github.catvod.spider.merge.i.a aVar4 = this.b;
                ArrayList arrayList4 = new ArrayList();
                if (cVar.c().isEmpty()) {
                    for (String str2 : aVar4.a()) {
                        arrayList4.add(c.a(aVar4).addPathSegment(cVar.h()).addPathSegment(aVar4.e).addPathSegment(aVar4.f).addPathSegment(cVar.g() + "." + str2 + "$" + str2.toUpperCase()).build().toString());
                    }
                } else {
                    arrayList4.add(c.a(aVar4).addPathSegment(cVar.h()).addPathSegment(aVar4.e).addPathSegment(aVar4.f).addPathSegment(cVar.g() + "." + cVar.c()).build().toString());
                }
                listC.addAll(arrayList4);
            }
        }
        Iterator it4 = this.a.iterator();
        while (it4.hasNext()) {
            for (com.github.catvod.spider.merge.d.a aVar5 : ((com.github.catvod.spider.merge.d.b) it4.next()).b()) {
                if (aVar5.b().isEmpty()) {
                    i++;
                    aVar5.e(i);
                }
            }
        }
        return new Gson().toJson(this.a);
    }
}
