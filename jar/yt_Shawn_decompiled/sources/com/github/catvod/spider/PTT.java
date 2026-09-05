package com.github.catvod.spider;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.a.e;
import com.github.catvod.spider.merge.o.d;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.u.c2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PTT extends Spider {
    public String a;

    public static HashMap a() {
        HashMap map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
        map.put("Accept-Language", "zh-TW,zh;q=0.9,en-US;q=0.8,en;q=0.7");
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List b(h hVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = hVar.T("div.card > div.embed-responsive").iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            n nVar2 = (n) nVar.T("a").get(0);
            n nVar3 = (n) nVar2.T("img").get(0);
            String strU = ((n) nVar.T("span.badge.badge-success").get(0)).U();
            String strB = nVar3.b("src");
            if (!strB.startsWith("http")) {
                if (strB.startsWith("/")) {
                    strB = strB.substring(1);
                }
                strB = "https://ptt.red/".concat(strB);
            }
            String strB2 = nVar3.b("alt");
            if (!TextUtils.isEmpty(strB2)) {
                arrayList.add(new com.github.catvod.spider.merge.a.h(nVar2.b("href").substring(1), strB2, strB, strU));
            }
        }
        return arrayList;
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        Uri.Builder builderBuildUpon = Uri.parse("https://ptt.red/p/" + str).buildUpon();
        if (!TextUtils.isEmpty(map.get("c"))) {
            builderBuildUpon.appendEncodedPath("c/" + map.get("c"));
        }
        if (!TextUtils.isEmpty(map.get("area"))) {
            builderBuildUpon.appendQueryParameter("area_id", map.get("area"));
        }
        if (!TextUtils.isEmpty(map.get("year"))) {
            builderBuildUpon.appendQueryParameter("year", map.get("year"));
        }
        if (!TextUtils.isEmpty(map.get("sort"))) {
            builderBuildUpon.appendQueryParameter("sort", map.get("sort"));
        }
        builderBuildUpon.appendQueryParameter("page", str2);
        return e.o(b(c2.T(com.github.catvod.spider.merge.g1.a.f(builderBuildUpon.toString(), a()))));
    }

    public String detailContent(List<String> list) {
        h hVarT = c2.T(com.github.catvod.spider.merge.g1.a.f(com.github.catvod.spider.merge.b.b.q(new StringBuilder("https://ptt.red/"), list.get(0), "/1"), a()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = hVarT.T("ul#w1 > li > a").iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            linkedHashMap.put(nVar.b("href").split("/")[3], nVar.b("title"));
        }
        com.github.catvod.spider.merge.q1.e eVarT = hVarT.T("div > a.seq.border");
        for (String str : linkedHashMap.keySet()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<E> it2 = eVarT.iterator();
            while (it2.hasNext()) {
                n nVar2 = (n) it2.next();
                arrayList2.add(nVar2.U() + "$" + list.get(0) + "/" + nVar2.b("href").split("/")[2] + "/" + str);
            }
            if (arrayList2.isEmpty()) {
                arrayList2.add("1$" + list.get(0) + "/1/" + str);
            }
            arrayList.add(TextUtils.join("#", arrayList2));
        }
        com.github.catvod.spider.merge.a.h hVar = new com.github.catvod.spider.merge.a.h();
        hVar.i(TextUtils.join("$$$", linkedHashMap.values()));
        hVar.j(TextUtils.join("$$$", arrayList));
        return e.j(hVar);
    }

    public String homeContent(boolean z) {
        h hVarT = c2.T(com.github.catvod.spider.merge.g1.a.f("https://ptt.red/", a()));
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = hVarT.T("li > a.px-2.px-sm-3.py-2.nav-link").iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            arrayList.add(new com.github.catvod.spider.merge.a.a(nVar.b("href").replace("/p/", VideoStream.RESOLUTION_UNKNOWN), nVar.U(), null));
        }
        return e.k(d.e(TextUtils.isEmpty(this.a) ? "{}" : com.github.catvod.spider.merge.g1.a.f(this.a, null)), arrayList);
    }

    public void init(Context context, String str) {
        this.a = str;
    }

    public String playerContent(String str, String str2, List<String> list) {
        Matcher matcher = Pattern.compile("contentUrl\":\"(.*?)\"").matcher(com.github.catvod.spider.merge.g1.a.f(com.github.catvod.spider.merge.b.b.n("https://ptt.red/", str2), a()));
        if (!matcher.find()) {
            return e.c(VideoStream.RESOLUTION_UNKNOWN);
        }
        e eVar = new e();
        eVar.q(matcher.group(1).replace("\\", VideoStream.RESOLUTION_UNKNOWN));
        return eVar.toString();
    }

    public String searchContent(String str, boolean z, String str2) {
        return e.o(b(c2.T(com.github.catvod.spider.merge.g1.a.f("https://ptt.red/".concat("q/" + str + "?page=" + str2), a()))));
    }

    public String searchContent(String str, boolean z) {
        return searchContent(str, z, "1");
    }
}
