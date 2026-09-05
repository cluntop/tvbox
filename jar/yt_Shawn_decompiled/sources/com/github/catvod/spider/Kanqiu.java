package com.github.catvod.spider;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.a.e;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.q1.p;
import com.github.catvod.spider.merge.q1.v;
import com.github.catvod.spider.merge.u.c2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Kanqiu extends Spider {
    public static String a = "https://www.88kanqiu.tw";

    public static String a(String str) {
        String strSubstring;
        if (str.startsWith(Utils.HTTP) || str.startsWith(Utils.HTTPS)) {
            return str;
        }
        if (str.startsWith("//")) {
            return "https:".concat(str);
        }
        if (a.endsWith("/")) {
            strSubstring = a.substring(0, r0.length() - 1);
        } else {
            strSubstring = a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strSubstring);
        return com.github.catvod.spider.merge.b.b.q(sb, str.startsWith("/") ? VideoStream.RESOLUTION_UNKNOWN : "/", str);
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> map) {
        if (map.get("cateId") != null) {
            str = map.get("cateId");
        }
        String strConcat = a.concat((str == null || str.isEmpty()) ? VideoStream.RESOLUTION_UNKNOWN : com.github.catvod.spider.merge.b.b.A("/match/", str, "/live"));
        HashMap map2 = new HashMap();
        map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
        h hVarT = c2.T(com.github.catvod.spider.merge.g1.a.f(strConcat, map2));
        ArrayList arrayList = new ArrayList();
        Iterator<E> it = hVarT.T(".list-group-item.group-game-item").iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            nVar.getClass();
            c2.P(".pay-btn > a[href]");
            p pVarH = v.H(".pay-btn > a[href]");
            n nVar2 = (n) c2.X(pVarH, nVar).findFirst().orElse(null);
            pVarH.e();
            if (nVar2 != null) {
                String strA = a(nVar2.b("href"));
                String strG = nVar.T(".row.d-none").g();
                if (strG.isEmpty()) {
                    strG = nVar.U();
                }
                c2.P(".col-xs-1 img");
                p pVarH2 = v.H(".col-xs-1 img");
                n nVar3 = (n) c2.X(pVarH2, nVar).findFirst().orElse(null);
                pVarH2.e();
                String strTrim = nVar3 == null ? VideoStream.RESOLUTION_UNKNOWN : nVar3.b("data-src").trim();
                if (strTrim.isEmpty() && nVar3 != null) {
                    strTrim = nVar3.b("src").trim();
                }
                arrayList.add(new com.github.catvod.spider.merge.a.h(strA, strG, strTrim.isEmpty() ? "https://pic.imgdb.cn/item/657673d6c458853aeff94ab9.jpg" : a(strTrim), nVar2.U()));
            }
        }
        e eVar = new e();
        eVar.g(1, 1, 0, arrayList.size());
        eVar.s(arrayList);
        return eVar.toString();
    }

    public String detailContent(List<String> list) throws JSONException {
        if (list.get(0).equals(a)) {
            return e.c("比赛尚未开始");
        }
        String strSubstring = list.get(0);
        if (strSubstring.endsWith("/play")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 5);
        }
        String strConcat = strSubstring.concat("/source");
        HashMap map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
        String strF = com.github.catvod.spider.merge.g1.a.f(strConcat, map);
        String strSubstring2 = VideoStream.RESOLUTION_UNKNOWN;
        try {
            String strOptString = new JSONObject(strF).optString("data");
            if (strOptString.length() > 8) {
                strSubstring2 = strOptString.substring(6, strOptString.length() - 2);
            }
        } catch (JSONException unused) {
        }
        if (strSubstring2.isEmpty()) {
            return e.c("比赛尚未开始");
        }
        try {
            JSONArray jSONArray = new JSONObject(new String(Base64.decode(strSubstring2, 0))).getJSONArray("links");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(jSONObjectOptJSONObject.optString("name") + "$" + jSONObjectOptJSONObject.optString("url").replace("#", "***"));
                }
            }
            com.github.catvod.spider.merge.a.h hVar = new com.github.catvod.spider.merge.a.h();
            hVar.f(list.get(0));
            hVar.i("Qile");
            hVar.j(TextUtils.join("#", arrayList));
            return e.j(hVar);
        } catch (IllegalArgumentException | JSONException unused2) {
            return e.c("比赛尚未开始");
        }
    }

    public String homeContent(boolean z) {
        ArrayList arrayList = new ArrayList();
        List listAsList = Arrays.asList(VideoStream.RESOLUTION_UNKNOWN, "1", "8", "21");
        List listAsList2 = Arrays.asList("全部直播", "篮球直播", "足球直播", "其他直播");
        for (int i = 0; i < listAsList.size(); i++) {
            arrayList.add(new com.github.catvod.spider.merge.a.a((String) listAsList.get(i), (String) listAsList2.get(i), null));
        }
        return e.n(arrayList, new JSONObject("{\"1\": [{\"key\": \"cateId\", \"name\": \"类型\", \"value\": [{\"n\": \"NBA\", \"v\": \"1\"}, {\"n\": \"CBA\", \"v\": \"2\"}, {\"n\": \"篮球综合\", \"v\": \"4\"}, {\"n\": \"纬来体育\", \"v\": \"21\"}]}],\"8\": [{\"key\": \"cateId\", \"name\": \"类型\", \"value\": [{\"n\": \"英超\", \"v\": \"8\"}, {\"n\": \"西甲\", \"v\": \"9\"}, {\"n\": \"意甲\", \"v\": \"10\"}, {\"n\": \"欧冠\", \"v\": \"12\"}, {\"n\": \"欧联\", \"v\": \"13\"}, {\"n\": \"德甲\", \"v\": \"14\"}, {\"n\": \"法甲\", \"v\": \"15\"}, {\"n\": \"欧国联\", \"v\": \"16\"}, {\"n\": \"足总杯\", \"v\": \"27\"}, {\"n\": \"国王杯\", \"v\": \"33\"}, {\"n\": \"中超\", \"v\": \"7\"}, {\"n\": \"亚冠\", \"v\": \"11\"}, {\"n\": \"足球综合\", \"v\": \"23\"}, {\"n\": \"欧协联\", \"v\": \"28\"}, {\"n\": \"美职联\", \"v\": \"26\"}]}], \"29\": [{\"key\": \"cateId\", \"name\": \"类型\", \"value\": [{\"n\": \"网球\", \"v\": \"29\"}, {\"n\": \"斯洛克\", \"v\": \"30\"}, {\"n\": \"MLB\", \"v\": \"38\"}, {\"n\": \"UFC\", \"v\": \"32\"}, {\"n\": \"NFL\", \"v\": \"25\"}, {\"n\": \"CCTV5\", \"v\": \"18\"}]}]}"));
    }

    public void init(Context context, String str) {
        if (str.isEmpty()) {
            return;
        }
        a = str;
    }

    public String playerContent(String str, String str2, List<String> list) {
        e eVar = new e();
        eVar.q(str2.replace("***", "#"));
        eVar.h();
        HashMap map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
        eVar.d(map);
        return eVar.toString();
    }
}
