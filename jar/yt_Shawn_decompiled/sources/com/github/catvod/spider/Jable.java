package com.github.catvod.spider;

import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.jdollar.net.URLEncoder;
import com.github.catvod.spider.merge.a.e;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.q1.p;
import com.github.catvod.spider.merge.q1.v;
import com.github.catvod.spider.merge.u.c2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Jable extends Spider {
    public static String a(String str, String str2) {
        StringBuilder sbS = com.github.catvod.spider.merge.b.b.s("https://jable.tv/categories/", str, "/?mode=async&function=get_block&block_id=list_videos_common_videos_list&sort_by=post_date&from=");
        sbS.append(String.format(Locale.getDefault(), "%02d", Integer.valueOf(Integer.parseInt(str2))));
        sbS.append("&_=");
        sbS.append(System.currentTimeMillis());
        return sbS.toString();
    }

    public static HashMap b() {
        HashMap map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
        map.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
        map.put("Accept-Language", "zh-TW,zh;q=0.9,en-US;q=0.8,en;q=0.7");
        map.put("Referer", "https://jable.tv/");
        return map;
    }

    public static String c(String str) {
        int iIndexOf = str.indexOf(63);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        String[] strArrSplit = str.split("/");
        for (int length = strArrSplit.length - 1; length >= 0; length--) {
            if (!strArrSplit[length].isEmpty()) {
                return strArrSplit[length];
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public static ArrayList d(h hVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = hVar.T("div.img-box > a, div.horizontal-img-box > a").iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            String strC = c(nVar.b("href"));
            String strG = nVar.T("div.absolute-center > h4").g();
            if (strG.isEmpty()) {
                strG = nVar.T("div.detail > h6.title").g();
            }
            if (!strC.isEmpty() && !strG.isEmpty()) {
                arrayList.add(new com.github.catvod.spider.merge.a.a(strC, strG, null));
            }
        }
        return arrayList;
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        return e.o(e(c2.T(com.github.catvod.spider.merge.g1.a.f(a(str, str2), b()))));
    }

    public String detailContent(List<String> list) {
        int i = 0;
        h hVarT = c2.T(com.github.catvod.spider.merge.g1.a.f("https://jable.tv/videos/".concat(list.get(0)).concat("/"), b()));
        String str = list.get(0);
        String strA = hVarT.T("meta[property=og:title]").a("content");
        String strA2 = hVarT.T("meta[property=og:image]").a("content");
        c2.P("span.inactive-color");
        p pVarH = v.H("span.inactive-color");
        n nVar = (n) c2.X(pVarH, hVarT).findFirst().orElse(null);
        pVarH.e();
        String str2 = VideoStream.RESOLUTION_UNKNOWN;
        String strU = nVar == null ? VideoStream.RESOLUTION_UNKNOWN : nVar.U();
        com.github.catvod.spider.merge.a.h hVar = new com.github.catvod.spider.merge.a.h();
        hVar.f(str);
        hVar.h(strA2);
        hVar.m(strU.replace("上市於 ", VideoStream.RESOLUTION_UNKNOWN));
        hVar.g(strA);
        hVar.i("Jable");
        StringBuilder sb = new StringBuilder("播放$");
        String strP = hVarT.P();
        Pattern pattern = com.github.catvod.spider.merge.o.e.a;
        String[] strArrSplit = strP.split("var");
        int length = strArrSplit.length;
        while (true) {
            if (i >= length) {
                break;
            }
            String str3 = strArrSplit[i];
            if (!str3.contains("hlsUrl")) {
                i++;
            } else if (str3.contains("'")) {
                str2 = str3.split("'")[1];
            } else if (str3.contains("\"")) {
                str2 = str3.split("\"")[1];
            }
        }
        sb.append(str2);
        hVar.j(sb.toString());
        return e.j(hVar);
    }

    public final List e(h hVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = hVar.T("div.video-img-box").iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            String strA = nVar.T("img").a("data-src");
            if (strA.isEmpty()) {
                strA = nVar.T("img").a("src");
            }
            String strA2 = nVar.T("a").a("href");
            String strG = nVar.T("div.detail > h6").g();
            String strC = c(strA2);
            if (!strA.endsWith(".gif") && !strG.isEmpty() && !strC.isEmpty()) {
                arrayList.add(new com.github.catvod.spider.merge.a.h(strC, strG, strA));
            }
        }
        return arrayList;
    }

    public String homeContent(boolean z) {
        h hVarT = c2.T(com.github.catvod.spider.merge.g1.a.f("https://jable.tv", b()));
        ArrayList arrayListD = d(hVarT);
        List listE = e(hVarT);
        Iterator it = d(c2.T(com.github.catvod.spider.merge.g1.a.f("https://jable.tv/categories/", b()))).iterator();
        while (it.hasNext()) {
            com.github.catvod.spider.merge.a.a aVar = (com.github.catvod.spider.merge.a.a) it.next();
            if (!arrayListD.contains(aVar)) {
                arrayListD.add(aVar);
            }
        }
        if (((ArrayList) listE).isEmpty() && !arrayListD.isEmpty()) {
            listE = e(c2.T(com.github.catvod.spider.merge.g1.a.f(a(((com.github.catvod.spider.merge.a.a) arrayListD.get(0)).a(), "1"), b())));
        }
        return e.l(arrayListD, (ArrayList) listE);
    }

    public String playerContent(String str, String str2, List<String> list) {
        e eVar = new e();
        eVar.q(str2);
        eVar.d(b());
        return eVar.toString();
    }

    public String searchContent(String str, boolean z) {
        return e.o(e(c2.T(com.github.catvod.spider.merge.g1.a.f("https://jable.tv/search/".concat(URLEncoder.encode(str)).concat("/"), b()))));
    }
}
