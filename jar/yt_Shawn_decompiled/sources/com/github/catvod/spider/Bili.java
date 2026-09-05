package com.github.catvod.spider;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.jdollar.net.URLEncoder;
import com.github.catvod.spider.merge.a.e;
import com.github.catvod.spider.merge.a.h;
import com.github.catvod.spider.merge.c.c;
import com.github.catvod.spider.merge.c.f;
import com.github.catvod.spider.merge.c.g;
import com.github.catvod.spider.merge.c.i;
import com.github.catvod.spider.merge.o.d;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Bili extends Spider {
    public String a;
    public JsonObject b;
    public boolean c;
    public boolean d;
    public i e;

    public static String a(c cVar, String str) {
        String str2 = cVar.g() + "_" + cVar.c();
        String str3 = cVar.h().split("/")[0];
        String strReplace = cVar.b().replace("&", "&amp;");
        Locale.getDefault();
        return "<AdaptationSet>\n<ContentComponent contentType=\"" + str3 + "\"/>\n<Representation id=\"" + str2 + "\" bandwidth=\"" + cVar.a() + "\" codecs=\"" + cVar.d() + "\" mimeType=\"" + cVar.h() + "\" " + str + " startWithSAP=\"" + cVar.k() + "\">\n<BaseURL>" + strReplace + "</BaseURL>\n<SegmentBase indexRange=\"" + cVar.j().a() + "\">\n<Initialization range=\"" + cVar.j().b() + "\"/>\n</SegmentBase>\n</Representation>\n</AdaptationSet>";
    }

    public static String c(c cVar) {
        if (!cVar.h().startsWith("video")) {
            if (!cVar.h().startsWith("audio")) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            HashMap map = new HashMap();
            map.put("30280", "192000");
            map.put("30232", "132000");
            map.put("30216", "64000");
            return a(cVar, String.format("numChannels='2' sampleRate='%s'", map.get(cVar.g())));
        }
        Locale.getDefault();
        return a(cVar, "height='" + cVar.f() + "' width='" + cVar.l() + "' frameRate='" + cVar.e() + "' sar='" + cVar.i() + "'");
    }

    public final HashMap b() {
        HashMap map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
        map.put("Referer", "https://www.bilibili.com");
        String str = this.a;
        if (str != null) {
            map.put("cookie", str);
        }
        return map;
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        if (str.endsWith("/{pg}")) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("mid", str.split("/")[0]);
            linkedHashMap.put("pn", str2);
            ArrayList arrayList = new ArrayList();
            Iterator it = f.a(g.b(com.github.catvod.spider.merge.g1.a.f("https://api.bilibili.com/x/space/wbi/arc/search?".concat(this.e.a(linkedHashMap)), b())).a().g().getAsJsonObject().get("vlist")).iterator();
            while (it.hasNext()) {
                arrayList.add(((f) it.next()).b());
            }
            return e.o(arrayList);
        }
        String str3 = map.containsKey("order") ? map.get("order") : "totalrank";
        String str4 = map.containsKey("duration") ? map.get("duration") : "0";
        if (map.containsKey("tid")) {
            str = str + Stream.ID_UNKNOWN + map.get("tid");
        }
        g gVarB = g.b(com.github.catvod.spider.merge.g1.a.f("https://api.bilibili.com/x/web-interface/search/type?search_type=video&keyword=" + URLEncoder.encode(str) + "&order=" + str3 + "&duration=" + str4 + "&page=" + str2, b()));
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = f.a(gVarB.a().k()).iterator();
        while (it2.hasNext()) {
            arrayList2.add(((f) it2.next()).b());
        }
        return e.o(arrayList2);
    }

    public String detailContent(List<String> list) {
        if (!this.c) {
            com.github.catvod.spider.merge.c.b bVarA = g.b(com.github.catvod.spider.merge.g1.a.f("https://api.bilibili.com/x/web-interface/nav", b())).a();
            this.c = bVarA.o();
            this.d = bVarA.p();
            this.e = bVarA.n();
        }
        String[] strArrSplit = list.get(0).split("@");
        String str = strArrSplit[0];
        String str2 = strArrSplit[1];
        com.github.catvod.spider.merge.c.b bVarA2 = g.b(com.github.catvod.spider.merge.g1.a.f(com.github.catvod.spider.merge.b.b.n("https://api.bilibili.com/x/web-interface/view?aid=", str2), b())).a();
        h hVar = new h();
        hVar.f(list.get(0));
        hVar.h(bVarA2.j());
        hVar.g(bVarA2.l());
        hVar.c(bVarA2.m());
        hVar.d(bVarA2.e());
        hVar.e(bVarA2.h().a());
        hVar.k((bVarA2.f().longValue() / 60) + "分鐘");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sbS = com.github.catvod.spider.merge.b.b.s("https://api.bilibili.com/x/player/playurl?avid=", str2, "&cid=");
        sbS.append(bVarA2.c());
        sbS.append("&qn=127&fnval=4048&fourk=1");
        com.github.catvod.spider.merge.c.b bVarA3 = g.b(com.github.catvod.spider.merge.g1.a.f(sbS.toString(), b())).a();
        for (int i = 0; i < bVarA3.b().size(); i++) {
            int iIntValue = ((Integer) bVarA3.b().get(i)).intValue();
            if ((this.c || iIntValue <= 32) && (this.d || iIntValue <= 80)) {
                arrayList2.add((Integer) bVarA3.b().get(i));
                arrayList.add((String) bVarA3.a().get(i));
            }
        }
        ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (com.github.catvod.spider.merge.c.e eVar : bVarA2.i()) {
            arrayList3.add(eVar.b() + "$" + str2 + "+" + eVar.a() + "+" + TextUtils.join(":", arrayList2) + "+" + TextUtils.join(":", arrayList));
        }
        linkedHashMap.put("B站", TextUtils.join("#", arrayList3));
        ArrayList arrayList4 = new ArrayList();
        JsonArray asJsonArray = d.e(com.github.catvod.spider.merge.g1.a.f(com.github.catvod.spider.merge.b.b.n("https://api.bilibili.com/x/web-interface/archive/related?bvid=", str), b())).getAsJsonObject().getAsJsonArray("data");
        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
            JsonObject asJsonObject = asJsonArray.get(i2).getAsJsonObject();
            arrayList4.add(asJsonObject.get("title").getAsString() + "$" + asJsonObject.get("aid").getAsInt() + "+" + asJsonObject.get("cid").getAsInt() + "+" + TextUtils.join(":", arrayList2) + "+" + TextUtils.join(":", arrayList));
        }
        linkedHashMap.put("相关", TextUtils.join("#", arrayList4));
        hVar.i(TextUtils.join("$$$", linkedHashMap.keySet()));
        hVar.j(TextUtils.join("$$$", linkedHashMap.values()));
        return e.j(hVar);
    }

    public String homeContent(boolean z) {
        String str = null;
        if (this.b.has("json")) {
            return com.github.catvod.spider.merge.g1.a.f(this.b.get("json").getAsString(), null);
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] strArrSplit = this.b.get("type").getAsString().split("#");
        int length = strArrSplit.length;
        int i = 0;
        while (i < length) {
            String str2 = strArrSplit[i];
            arrayList.add(new com.github.catvod.spider.merge.a.a(str2, str2, str));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new com.github.catvod.spider.merge.a.d("order", "排序", Arrays.asList(new com.github.catvod.spider.merge.a.c("預設", "totalrank"), new com.github.catvod.spider.merge.a.c("最多點擊", "click"), new com.github.catvod.spider.merge.a.c("最新發布", "pubdate"), new com.github.catvod.spider.merge.a.c("最多彈幕", "dm"), new com.github.catvod.spider.merge.a.c("最多收藏", "stow"))));
            arrayList2.add(new com.github.catvod.spider.merge.a.d("duration", "時長", Arrays.asList(new com.github.catvod.spider.merge.a.c("全部時長", "0"), new com.github.catvod.spider.merge.a.c("60分鐘以上", "4"), new com.github.catvod.spider.merge.a.c("30~60分鐘", "3"), new com.github.catvod.spider.merge.a.c("10~30分鐘", "2"), new com.github.catvod.spider.merge.a.c("10分鐘以下", "1"))));
            linkedHashMap.put(str2, arrayList2);
            i++;
            str = null;
        }
        return e.m(arrayList, linkedHashMap);
    }

    public String homeVideoContent() {
        g gVarB = g.b(com.github.catvod.spider.merge.g1.a.f("https://api.bilibili.com/x/web-interface/popular?ps=20", b()));
        ArrayList arrayList = new ArrayList();
        Iterator it = f.a(gVarB.a().g()).iterator();
        while (it.hasNext()) {
            arrayList.add(((f) it.next()).b());
        }
        return e.o(arrayList);
    }

    public void init(Context context, String str) {
        String str2;
        JsonObject jsonObjectH = d.h(str);
        this.b = jsonObjectH;
        String asString = jsonObjectH.get("cookie").getAsString();
        this.a = asString;
        if (asString.startsWith("http")) {
            this.a = com.github.catvod.spider.merge.g1.a.f(this.a, null).trim();
        }
        if (TextUtils.isEmpty(this.a)) {
            String strConcat = ".".concat("bilibili");
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory());
            File file = new File(com.github.catvod.spider.merge.b.b.q(sb, File.separator, "TV"));
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                str2 = new String(d.f(new File(file, strConcat)), StandardCharsets.UTF_8);
            } catch (IOException unused) {
                str2 = VideoStream.RESOLUTION_UNKNOWN;
            }
            this.a = str2;
        }
        if (TextUtils.isEmpty(this.a)) {
            this.a = "buvid3=84B0395D-C9F2-C490-E92E-A09AB48FE26E71636infoc";
        }
    }

    public String playerContent(String str, String str2, List<String> list) {
        String[] strArrSplit = str2.split("\\+");
        String str3 = strArrSplit[0];
        String str4 = strArrSplit[1];
        String[] strArrSplit2 = strArrSplit[3].split(":");
        String[] strArrSplit3 = strArrSplit[2].split(":");
        ArrayList arrayList = new ArrayList();
        String strConcat = "https://api.bilibili.com/x/v1/dm/list.so?oid=".concat(str4);
        for (int i = 0; i < strArrSplit2.length; i++) {
            arrayList.add(strArrSplit2[i]);
            arrayList.add(Proxy.getUrl(((Spider) this).siteKey, "&aid=" + str3 + "&cid=" + str4 + "&qn=" + strArrSplit3[i] + "&type=mpd"));
        }
        e eVar = new e();
        eVar.r(arrayList);
        com.github.catvod.spider.merge.a.b bVar = new com.github.catvod.spider.merge.a.b();
        bVar.a();
        bVar.b(strConcat);
        eVar.a(Arrays.asList(bVar));
        eVar.b();
        eVar.d(b());
        return eVar.toString();
    }

    public Object[] proxy(Map<String, String> map) {
        String str = map.get("aid");
        String str2 = map.get("cid");
        String str3 = map.get("qn");
        StringBuilder sb = new StringBuilder("https://api.bilibili.com/x/player/playurl?avid=");
        sb.append(str);
        sb.append("&cid=");
        sb.append(str2);
        sb.append("&qn=");
        com.github.catvod.spider.merge.c.a aVarD = g.b(com.github.catvod.spider.merge.g1.a.f(com.github.catvod.spider.merge.b.b.q(sb, str3, "&fnval=4048&fourk=1"), b())).a().d();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (c cVar : aVarD.a()) {
            HashMap map2 = new HashMap();
            map2.put("30280", "192000");
            map2.put("30232", "132000");
            map2.put("30216", "64000");
            Iterator it = map2.keySet().iterator();
            while (it.hasNext()) {
                if (cVar.g().equals((String) it.next())) {
                    sb3.append(c(cVar));
                }
            }
        }
        for (c cVar2 : aVarD.d()) {
            if (cVar2.g().equals(str3)) {
                sb2.append(c(cVar2));
            }
        }
        String string = sb2.toString();
        String string2 = sb3.toString();
        Locale.getDefault();
        String strB = aVarD.b();
        String strC = aVarD.c();
        String strB2 = aVarD.b();
        StringBuilder sb4 = new StringBuilder("<MPD xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"urn:mpeg:dash:schema:mpd:2011\" xsi:schemaLocation=\"urn:mpeg:dash:schema:mpd:2011 DASH-MPD.xsd\" type=\"static\" mediaPresentationDuration=\"PT");
        sb4.append(strB);
        sb4.append("S\" minBufferTime=\"PT");
        sb4.append(strC);
        sb4.append("S\" profiles=\"urn:mpeg:dash:profile:isoff-on-demand:2011\">\n<Period duration=\"PT");
        sb4.append(strB2);
        sb4.append("S\" start=\"PT0S\">\n");
        sb4.append(string);
        sb4.append("\n");
        return new Object[]{200, "application/dash+xml", new ByteArrayInputStream(com.github.catvod.spider.merge.b.b.q(sb4, string2, "\n</Period>\n</MPD>").getBytes())};
    }

    public String searchContent(String str, boolean z) {
        return categoryContent(str, "1", true, new HashMap<>());
    }

    public String searchContent(String str, boolean z, String str2) {
        return categoryContent(str, str2, true, new HashMap<>());
    }
}
