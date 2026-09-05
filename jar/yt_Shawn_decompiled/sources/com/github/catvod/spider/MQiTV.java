package com.github.catvod.spider;

import android.content.Context;
import android.net.Uri;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.jdollar.util.concurrent.ThreadLocalRandom;
import com.github.catvod.spider.merge.f.d;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MQiTV extends Spider {
    public List a;

    public static Object[] a(String str) {
        HashMap map = new HashMap();
        map.put("Location", str);
        return new Object[]{302, "text/plain", new ByteArrayInputStream("302 Found".getBytes()), map};
    }

    public List<com.github.catvod.spider.merge.f.a> getConfigs() {
        List<com.github.catvod.spider.merge.f.a> arrayList = this.a;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.a = arrayList;
        return arrayList;
    }

    public void init(Context context, String str) {
        this.a = (List) new Gson().fromJson(str, TypeToken.getParameterized(List.class, new Type[]{com.github.catvod.spider.merge.f.a.class}).getType());
    }

    public String liveContent(String str) {
        StringBuilder sb = new StringBuilder();
        for (com.github.catvod.spider.merge.f.a aVar : getConfigs()) {
            if (!aVar.a().isEmpty()) {
                sb.append(aVar.b());
                sb.append(",#genre#\n");
                Uri uri = aVar.e;
                if (uri == null) {
                    uri = Uri.parse(aVar.d());
                }
                aVar.e = uri;
                boolean z = uri.getPort() != -1;
                for (com.github.catvod.spider.merge.f.b bVar : aVar.a()) {
                    String strE = z ? bVar.e() : "5003";
                    String url = Proxy.getUrl(((Spider) this).siteKey, "&id=" + bVar.b() + "&ip=" + aVar.d() + "&playing=" + bVar.d() + "&port=" + strE + "&type=m3u8");
                    sb.append(bVar.c());
                    sb.append(",");
                    sb.append(url);
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public Object[] proxy(Map<String, String> map) {
        String str = map.get("ip");
        String str2 = map.get("port");
        String str3 = map.get("playing");
        if (str2 == null) {
            str2 = "5003";
        }
        com.github.catvod.spider.merge.f.a aVar = new com.github.catvod.spider.merge.f.a(str);
        int iIndexOf = getConfigs().indexOf(aVar);
        if (iIndexOf != -1) {
            aVar = getConfigs().get(iIndexOf);
        } else {
            getConfigs().add(aVar);
        }
        boolean zIsEmpty = aVar.e().isEmpty();
        int i = 1;
        String string = VideoStream.RESOLUTION_UNKNOWN;
        if (zIsEmpty) {
            Pattern patternCompile = Pattern.compile(".*?([0-9a-zA-Z]{11,}).*", 2);
            Pattern patternCompile2 = Pattern.compile(".*?(([a-fA-F0-9]{2}:){5}[a-fA-F0-9]{2}).*", 2);
            Iterator it = aVar.a().iterator();
            while (it.hasNext()) {
                for (String str4 : ((com.github.catvod.spider.merge.f.b) it.next()).f().a()) {
                    if (aVar.e().size() < 5) {
                        Matcher matcher = patternCompile.matcher(str4);
                        Matcher matcher2 = patternCompile2.matcher(str4);
                        String strGroup = matcher.matches() ? matcher.group(i) : VideoStream.RESOLUTION_UNKNOWN;
                        String strGroup2 = matcher2.matches() ? matcher2.group(i) : VideoStream.RESOLUTION_UNKNOWN;
                        if (!strGroup.isEmpty() && !strGroup2.isEmpty()) {
                            d dVar = new d();
                            Matcher matcher3 = Pattern.compile("\"Token\"\\s*:\\s*\"(.*?)\"", 2).matcher(com.github.catvod.spider.merge.g1.a.f(String.format(Locale.getDefault(), "%s/HSAndroidLogin.ecgi?ty=json&net_account=%s&mac_address1=%s&_=%d", aVar.d(), strGroup, strGroup2, Long.valueOf(System.currentTimeMillis())), null));
                            String strGroup3 = matcher3.find() ? matcher3.group(1) : VideoStream.RESOLUTION_UNKNOWN;
                            dVar.a = strGroup3;
                            if (strGroup3 == null) {
                                strGroup3 = VideoStream.RESOLUTION_UNKNOWN;
                            }
                            if (!strGroup3.isEmpty()) {
                                aVar.e().add(dVar);
                            }
                        }
                        i = 1;
                    }
                }
            }
        }
        String str5 = (aVar.e().isEmpty() ? new d() : (d) aVar.e().get(ThreadLocalRandom.current().nextInt(aVar.e().size()))).a;
        if (str5 == null) {
            str5 = VideoStream.RESOLUTION_UNKNOWN;
        }
        if (str5.isEmpty()) {
            return a(aVar.c(str2, str3));
        }
        String str6 = map.get("id");
        Matcher matcher4 = Pattern.compile("\"Reason\":\"(.*?)\"", 2).matcher(com.github.catvod.spider.merge.g1.a.f(aVar.d() + "/ualive?cid=" + str6 + "&token=" + str5, null));
        String strGroup4 = matcher4.find() ? matcher4.group(1) : VideoStream.RESOLUTION_UNKNOWN;
        if (!"OK".equals(strGroup4)) {
            aVar.d.clear();
            aVar.c.clear();
            aVar.d = null;
            aVar.c = null;
        }
        if (!"OK".equals(strGroup4)) {
            return proxy(map);
        }
        StringBuilder sb = new StringBuilder(Utils.HTTP);
        Uri uri = aVar.e;
        if (uri == null) {
            uri = Uri.parse(aVar.d());
        }
        aVar.e = uri;
        sb.append(uri.getHost());
        sb.append(":");
        sb.append(str2);
        sb.append("/");
        String string2 = sb.toString();
        String strF = com.github.catvod.spider.merge.g1.a.f(string2 + str6 + ".m3u8?token=" + str5, null);
        if (!strF.isEmpty() && !strF.contains("\"Reason\"")) {
            String[] strArrSplit = strF.split("\\r?\\n");
            StringBuilder sb2 = new StringBuilder();
            for (String strConcat : strArrSplit) {
                if (!strConcat.startsWith("#") && !strConcat.startsWith("http")) {
                    strConcat = string2.concat(strConcat);
                }
                sb2.append(strConcat);
                sb2.append("\n");
            }
            string = sb2.toString();
        }
        return string.isEmpty() ? a(aVar.c(str2, str3)) : new Object[]{200, "application/vnd.apple.mpegurl", new ByteArrayInputStream(string.getBytes())};
    }
}
