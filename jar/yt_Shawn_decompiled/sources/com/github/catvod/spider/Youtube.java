package com.github.catvod.spider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Base64;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.ClashCore;
import com.github.catvod.spider.Youtube;
import com.github.catvod.spider.jdollar.net.URLEncoder;
import com.github.catvod.spider.merge.a.e;
import com.github.catvod.spider.merge.a.h;
import com.github.catvod.spider.merge.n.a0;
import com.github.catvod.spider.merge.n.b0;
import com.github.catvod.spider.merge.n.c0;
import com.github.catvod.spider.merge.n.d0;
import com.github.catvod.spider.merge.n.i0;
import com.github.catvod.spider.merge.n.p;
import com.github.catvod.spider.merge.n.q;
import com.github.catvod.spider.merge.n.r;
import com.github.catvod.spider.merge.n.v;
import com.github.catvod.spider.merge.o.d;
import com.github.catvod.spider.merge.u.c2;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMixPlaylistExtractor;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.StreamInfo;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.SubtitlesStream;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Youtube extends Spider {
    public static boolean e;
    public String a = VideoStream.RESOLUTION_UNKNOWN;
    public final ArrayList b = new ArrayList();
    public final LinkedHashMap c = new LinkedHashMap();
    public final HashMap d = new HashMap();
    public static final Pattern f = Pattern.compile("^[A-Za-z0-9_-]{11}$");
    public static final HashMap g = new HashMap();
    public static final HashMap h = new HashMap();
    public static String i = VideoStream.RESOLUTION_UNKNOWN;
    public static String j = "WEB";
    public static String k = "2.20250122.04.00";
    public static String l = VideoStream.RESOLUTION_UNKNOWN;
    public static String m = VideoStream.RESOLUTION_UNKNOWN;
    public static final HashSet n = new HashSet();
    public static String o = VideoStream.RESOLUTION_UNKNOWN;
    public static String p = VideoStream.RESOLUTION_UNKNOWN;
    public static String q = "7.20260826.00.00";
    public static String r = VideoStream.RESOLUTION_UNKNOWN;
    public static String s = VideoStream.RESOLUTION_UNKNOWN;
    public static long t = 0;
    public static String u = VideoStream.RESOLUTION_UNKNOWN;
    public static String v = VideoStream.RESOLUTION_UNKNOWN;
    public static String w = VideoStream.RESOLUTION_UNKNOWN;
    public static long x = 0;
    public static long y = 5;
    public static String z = VideoStream.RESOLUTION_UNKNOWN;
    public static int A = -1;
    public static String B = VideoStream.RESOLUTION_UNKNOWN;
    public static String C = VideoStream.RESOLUTION_UNKNOWN;
    public static String D = VideoStream.RESOLUTION_UNKNOWN;
    public static String E = VideoStream.RESOLUTION_UNKNOWN;
    public static String F = VideoStream.RESOLUTION_UNKNOWN;
    public static String G = VideoStream.RESOLUTION_UNKNOWN;
    public static boolean H = false;
    public static String I = VideoStream.RESOLUTION_UNKNOWN;
    public static boolean J = true;
    public static int K = 0;
    public static long L = 0;
    public static final String M = VideoStream.RESOLUTION_UNKNOWN;
    public static int N = 0;
    public static boolean O = false;
    public static final HashMap P = new HashMap();

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: com.github.catvod.spider.Youtube$1, reason: invalid class name */
    class AnonymousClass1 implements ClashCore.DownloadProgressCallback {
        @Override // com.github.catvod.spider.ClashCore.DownloadProgressCallback
        public void onProgress(long j, long j2) {
            Init.post(new r(String.format(Locale.getDefault(), "下载内核 %.1f/%.1f MB (%d%%)", Double.valueOf((j / 1024.0d) / 1024.0d), Double.valueOf((j2 / 1024.0d) / 1024.0d), Integer.valueOf(j2 > 0 ? (int) ((j * 100) / j2) : 0)), 10));
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: com.github.catvod.spider.Youtube$2, reason: invalid class name */
    class AnonymousClass2 implements ClashCore.DownloadProgressCallback {
        @Override // com.github.catvod.spider.ClashCore.DownloadProgressCallback
        public void onProgress(long j, long j2) {
            Init.post(new r(String.format(Locale.getDefault(), "正在下载内核 %.1f/%.1f MB (%d%%)", Double.valueOf((j / 1024.0d) / 1024.0d), Double.valueOf((j2 / 1024.0d) / 1024.0d), Integer.valueOf(j2 > 0 ? (int) ((j * 100) / j2) : 0)), 11));
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class BrowseResult {
        public ArrayList a = new ArrayList();
        public String b = null;
    }

    public static JsonObject A() {
        JsonObject jsonObject = new JsonObject();
        String str = j;
        jsonObject.addProperty("clientName", (str == null || str.isEmpty()) ? "WEB" : j);
        String str2 = k;
        jsonObject.addProperty("clientVersion", (str2 == null || str2.isEmpty()) ? "2.20250122.04.00" : k);
        jsonObject.addProperty("hl", "zh-CN");
        jsonObject.addProperty("gl", "US");
        jsonObject.addProperty("utcOffsetMinutes", 480);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("lockedSafetyMode", Boolean.FALSE);
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("client", jsonObject);
        jsonObject3.add("user", jsonObject2);
        return jsonObject3;
    }

    public static String A0(String str, String str2, HashMap map) {
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            for (Map.Entry entry : map.entrySet()) {
                builderUrl.header((String) entry.getKey(), (String) entry.getValue());
            }
            String str3 = G;
            if (str3 != null && !str3.isEmpty()) {
                builderUrl.header("Cookie", G);
            }
            builderUrl.post(RequestBody.create(str2, MediaType.parse("application/x-www-form-urlencoded; charset=utf-8")));
            Response responseExecute = O0().newCall(builderUrl.build()).execute();
            int iCode = responseExecute.code();
            String strString = responseExecute.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute.body().string();
            responseExecute.close();
            SpiderDebug.log("[YouTube] httpPostForm code=" + iCode + " len=" + strString.length());
            return strString;
        } catch (Throwable th) {
            SpiderDebug.log("[YouTube] httpPostForm error: " + th.getMessage());
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static void B0() {
        if (e) {
            return;
        }
        try {
            SpiderDebug.log("[YouTube] initializing NewPipe...");
            NewPipe.init(NewPipeDownloader.get(), Localization.DEFAULT);
            e = true;
            SpiderDebug.log("[YouTube] NewPipe initialized successfully");
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] NewPipe init failed: " + e2.getClass().getName() + " - " + e2.getMessage());
            e2.printStackTrace();
        }
    }

    public static JsonObject C() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("clientName", "TVHTML5");
        String str = q;
        jsonObject.addProperty("clientVersion", (str == null || str.isEmpty()) ? "7.20260826.00.00" : q);
        jsonObject.addProperty("clientScreen", "WATCH");
        jsonObject.addProperty("platform", "TV");
        jsonObject.addProperty("userAgent", "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/Version");
        jsonObject.addProperty("acceptRegion", "US");
        jsonObject.addProperty("utcOffsetMinutes", 0);
        Boolean bool = Boolean.FALSE;
        jsonObject.addProperty("webpSupport", bool);
        Boolean bool2 = Boolean.TRUE;
        jsonObject.addProperty("animatedWebpSupport", bool2);
        jsonObject.addProperty("hl", "zh-CN");
        jsonObject.addProperty("gl", "US");
        if (!m.isEmpty()) {
            jsonObject.addProperty("visitorData", m);
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("appQuality", "TV_APP_QUALITY_FULL_ANIMATION");
        jsonObject2.addProperty("zylonLeftNav", bool2);
        jsonObject.add("tvAppInfo", jsonObject2);
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("enableSafetyMode", bool);
        jsonObject3.addProperty("lockedSafetyMode", bool);
        JsonObject jsonObject4 = new JsonObject();
        jsonObject4.add("client", jsonObject);
        jsonObject4.add("user", jsonObject3);
        return jsonObject4;
    }

    public static boolean C0(String str) {
        return str != null && f.matcher(str).matches();
    }

    public static String D(int i2, String str) {
        return "youtube:" + str + "_" + i2;
    }

    public static String D0() {
        ArrayList arrayList = new ArrayList();
        h hVar = new h();
        hVar.g("当前加载路径");
        hVar.k(M());
        hVar.b("hint:json");
        hVar.h(a1("#6366F1", "路"));
        arrayList.add(hVar);
        arrayList.add(a("选择本地 json 档案", "pick:json", "#6366F1", "文", false));
        arrayList.add(a("输入在线 json URL", "input:json", "#6366F1", "链", false));
        boolean zEquals = "@default".equals(D);
        String str = VideoStream.RESOLUTION_UNKNOWN;
        arrayList.add(n0("SET@@json:@default", "恢复出厂（跟随 ext）", zEquals ? "当前" : VideoStream.RESOLUTION_UNKNOWN, "#6366F1", "原"));
        if ("@none".equals(D)) {
            str = "当前";
        }
        arrayList.add(n0("SET@@json:@none", "不选择任何 json", str, "#6366F1", "空"));
        arrayList.add(a("设置 proxy", "set:proxy", "#6366F1", "代", false));
        h hVar2 = new h();
        StringBuilder sb = new StringBuilder("当前 proxy：");
        sb.append(E.isEmpty() ? "未设置" : E);
        hVar2.g(sb.toString());
        hVar2.k("仅用于 YouTube 请求");
        hVar2.b("hint:proxy");
        hVar2.h(a1("#6366F1", "代"));
        arrayList.add(hVar2);
        arrayList.add(a("查看出口 IP / 国家", "check:ip", "#0F766E", "IP", false));
        e eVar = new e();
        eVar.s(arrayList);
        eVar.g(1, 1, 0, 1);
        return eVar.toString();
    }

    public static String F() {
        String str;
        HashMap map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        String[] strArr = {"https://ipapi.co/json/", "https://api.ip.sb/geoip", "https://ipinfo.io/json"};
        String asString = VideoStream.RESOLUTION_UNKNOWN;
        String asString2 = VideoStream.RESOLUTION_UNKNOWN;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                JsonObject jsonObjectH = d.h(y0(strArr[i2], map));
                if (jsonObjectH.size() != 0) {
                    if (asString.isEmpty() && jsonObjectH.has("ip") && !jsonObjectH.get("ip").isJsonNull()) {
                        asString = jsonObjectH.get("ip").getAsString();
                    }
                    if (asString.isEmpty() && jsonObjectH.has("query") && !jsonObjectH.get("query").isJsonNull()) {
                        asString = jsonObjectH.get("query").getAsString();
                    }
                    if (asString2.isEmpty() && jsonObjectH.has("country_name") && !jsonObjectH.get("country_name").isJsonNull()) {
                        asString2 = jsonObjectH.get("country_name").getAsString();
                    }
                    if (asString2.isEmpty() && jsonObjectH.has("country") && !jsonObjectH.get("country").isJsonNull()) {
                        asString2 = jsonObjectH.get("country").getAsString();
                    }
                    if (asString2.isEmpty() && jsonObjectH.has("country_code") && !jsonObjectH.get("country_code").isJsonNull()) {
                        asString2 = jsonObjectH.get("country_code").getAsString();
                    }
                    if (asString.isEmpty() && asString2.isEmpty()) {
                    }
                }
            } catch (Exception unused) {
            }
        }
        try {
            Response responseExecute = O0().newCall(new Request.Builder().url("https://www.google.com/generate_204").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36").build()).execute();
            int iCode = responseExecute.code();
            str = (iCode == 204 || iCode == 200) ? "可达" : "异常(code=" + iCode + ")";
            responseExecute.close();
        } catch (Exception unused2) {
            str = "不可达";
        }
        StringBuilder sb = new StringBuilder("出口 IP: ");
        if (asString.isEmpty()) {
            asString = "未知";
        }
        sb.append(asString);
        sb.append("\n国家: ");
        if (asString2.isEmpty()) {
            asString2 = "未知";
        }
        sb.append(asString2);
        sb.append("\nGoogle: ");
        sb.append(str);
        if (E.isEmpty()) {
            sb.append("\n(未设置 proxy，直连)");
        }
        SpiderDebug.log("[YouTube] checkEgressIp: " + ((Object) sb));
        return sb.toString();
    }

    public static JsonObject F0() {
        try {
            File file = new File("/storage/emulated/0/TV/.ytb/setting.json");
            return !file.exists() ? new JsonObject() : d.h(S0(file));
        } catch (Exception unused) {
            return new JsonObject();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:51|(1:53)(2:54|(1:56)(5:57|(1:59)|117|118|(0)))|140|60|(1:64)|136|65|(2:67|(3:138|69|(1:73)))(1:77)|(5:142|79|(1:81)|82|(3:84|(4:87|(2:89|146)(4:90|(1:92)(3:93|(4:96|(2:98|150)(2:99|(2:101|(3:148|103|147)(1:152))(1:151))|105|94)|149)|89|146)|106|85)|145))|107|(1:109)|110|(1:112)|113|(1:115)|118|(0)) */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0267 A[LOOP:0: B:122:0x0261->B:124:0x0267, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void G(com.google.gson.JsonElement r19, java.util.ArrayList r20) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Youtube.G(com.google.gson.JsonElement, java.util.ArrayList):void");
    }

    public static String G0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(n0("HIS@@history", "播放历史", "在 YouTube 看过的视频", "#DC2626", "史"));
        arrayList.add(n0("HIS@@liked", "喜欢的视频", "你点赞过的视频", "#DB2777", "喜"));
        arrayList.add(n0("HIS@@watchlater", "稍后观看", "加入稍后观看的视频", "#4E6AF0", "后"));
        arrayList.add(n0("HIS@@subsfolder", "已订阅频道", "订阅频道 + 订阅动态", "#2E9E5B", "阅"));
        e eVar = new e();
        eVar.s(arrayList);
        eVar.g(1, 1, 0, 1);
        return eVar.toString();
    }

    public static String I() {
        String[] strArr = {"SAPISID", "__Secure-3PAPISID", "__Secure-1PAPISID", "__Secure-1PSID", "__Secure-3PSID", "SID", "HSID", "SSID", "APISID", "SIDCC", "__Secure-1PSIDTS", "__Secure-3PSIDTS", "LOGIN_INFO", YoutubeMixPlaylistExtractor.COOKIE_NAME};
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 14; i2++) {
            String str = strArr[i2];
            if (sb.length() > 0) {
                sb.append(Stream.ID_UNKNOWN);
            }
            sb.append(str);
            sb.append("=");
            sb.append(X(str).isEmpty() ? "0" : "1");
        }
        return sb.toString();
    }

    public static String I0(String str) {
        if (str == null) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        String strTrim = str.toLowerCase().trim();
        if (strTrim.startsWith("avc")) {
            return "avc";
        }
        if (strTrim.startsWith("hvc") || strTrim.startsWith("hev")) {
            return "hevc";
        }
        String str2 = "vp9";
        if (!strTrim.startsWith("vp09") && !strTrim.startsWith("vp9")) {
            str2 = "av1";
            if (!strTrim.startsWith("av01") && !strTrim.startsWith("av1")) {
                return strTrim.startsWith("mp4v") ? "mp4v" : strTrim;
            }
        }
        return str2;
    }

    public static void J(JsonObject jsonObject, JsonObject jsonObject2) {
        if (!jsonObject2.has("clickTrackingParams") && jsonObject.has("clickTrackingParams")) {
            jsonObject2.add("clickTrackingParams", jsonObject.get("clickTrackingParams"));
        }
    }

    public static String J0() {
        if (r.isEmpty()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        if (System.currentTimeMillis() >= t - 60000) {
            try {
                if (!s.isEmpty()) {
                    U();
                    String str = "client_id=" + T(o) + "&client_secret=" + T(p) + "&refresh_token=" + T(s) + "&grant_type=refresh_token";
                    HashMap map = new HashMap();
                    map.put("Content-Type", "application/x-www-form-urlencoded");
                    String strA0 = A0("https://www.youtube.com/o/oauth2/token", str, map);
                    JsonObject jsonObjectH = d.h(strA0);
                    if (jsonObjectH.has("access_token")) {
                        r = jsonObjectH.get("access_token").getAsString();
                        t = ((jsonObjectH.has("expires_in") ? jsonObjectH.get("expires_in").getAsLong() : 3600L) * 1000) + System.currentTimeMillis();
                        Y0();
                    } else {
                        SpiderDebug.log("[YouTube] refreshOauthToken resp=".concat(strA0));
                    }
                }
            } catch (Exception e2) {
                com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] refreshOauthToken error: "));
            }
        }
        if (r.isEmpty()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        return "Bearer " + r;
    }

    public static void K(JsonElement jsonElement, HashMap map) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return;
        }
        if (!jsonElement.isJsonObject()) {
            if (jsonElement.isJsonArray()) {
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    K(asJsonArray.get(i2), map);
                }
                return;
            }
            return;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        for (String str : asJsonObject.keySet()) {
            if (str.endsWith("Renderer") || str.endsWith("ViewModel")) {
                Integer num = (Integer) map.get(str);
                map.put(str, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
            K(asJsonObject.get(str), map);
        }
    }

    public static int K0(String str) {
        String strTrim;
        if (str == null) {
            strTrim = VideoStream.RESOLUTION_UNKNOWN;
        } else {
            try {
                strTrim = str.trim();
            } catch (Exception unused) {
                return -1;
            }
        }
        return Integer.parseInt(strTrim);
    }

    public static String L() {
        return z.isEmpty() ? "全部" : "avc".equals(z) ? "AVC (H.264)" : "hevc".equals(z) ? "HEVC (H.265)" : z.toUpperCase();
    }

    public static java.net.Proxy L0() {
        int port;
        SpiderDebug.log("[YouTube] parseProxy called, proxyFilter=[" + E + "]");
        String str = E;
        if (str != null && !str.isEmpty()) {
            try {
                String strTrim = E.trim();
                Proxy.Type type = Proxy.Type.HTTP;
                String lowerCase = strTrim.toLowerCase();
                if (lowerCase.startsWith("socks5://") || lowerCase.startsWith("socks://")) {
                    type = Proxy.Type.SOCKS;
                    port = 1080;
                } else {
                    port = 80;
                    if (!lowerCase.startsWith(Utils.HTTP) && !lowerCase.startsWith(Utils.HTTPS)) {
                        strTrim = Utils.HTTP.concat(strTrim);
                    }
                }
                URI uriCreate = URI.create(strTrim);
                if (uriCreate.getPort() > 0) {
                    port = uriCreate.getPort();
                }
                String host = uriCreate.getHost();
                if (host != null && !host.isEmpty()) {
                    SpiderDebug.log("[YouTube] parseProxy result: type=" + type + " host=" + host + " port=" + port);
                    return new java.net.Proxy(type, type == Proxy.Type.SOCKS ? InetSocketAddress.createUnresolved(host, port) : new InetSocketAddress(host, port));
                }
                return null;
            } catch (Throwable th) {
                SpiderDebug.log("[YouTube] parseProxy error: " + th.getMessage());
            }
        }
        return null;
    }

    public static String M() {
        return (D.isEmpty() || "@default".equals(D)) ? "ext 默认" : "@none".equals(D) ? "无" : D;
    }

    public static JsonObject M0(JsonObject jsonObject, String str) {
        try {
            String strQ0 = q0();
            if (strQ0.isEmpty()) {
                SpiderDebug.log("[YouTube] post " + str + " aborted: no API key");
                return new JsonObject();
            }
            String str2 = YoutubeParsingHelper.YOUTUBEI_V1_URL + str + "?key=" + strQ0;
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
            String strC1 = c1();
            String str3 = "NONE";
            if (!strC1.isEmpty()) {
                map.put("Authorization", strC1);
                str3 = "SAPISIDHASH";
            }
            map.put("Origin", "https://www.youtube.com");
            map.put("Referer", "https://www.youtube.com/");
            map.put("X-Youtube-Client-Name", "1");
            String str4 = k;
            map.put("X-Youtube-Client-Version", (str4 == null || str4.isEmpty()) ? "2.20250122.04.00" : k);
            SpiderDebug.log("[YouTube] POST " + str + " to " + str2.substring(0, Math.min(80, str2.length())) + " auth=" + str3);
            String strZ0 = z0(str2, jsonObject.toString(), map);
            StringBuilder sb = new StringBuilder("[YouTube] POST ");
            sb.append(str);
            sb.append(" response len=");
            sb.append(strZ0 == null ? 0 : strZ0.length());
            SpiderDebug.log(sb.toString());
            if (strZ0 != null && !strZ0.isEmpty()) {
                String strReplace = strZ0.replace("\n", Stream.ID_UNKNOWN).replace("\r", Stream.ID_UNKNOWN);
                SpiderDebug.log("[YouTube] POST " + str + " resp=" + strReplace.substring(0, Math.min(strReplace.length(), 3800)));
            }
            return d.e(strZ0).getAsJsonObject();
        } catch (Exception e2) {
            StringBuilder sbS = com.github.catvod.spider.merge.b.b.s("[YouTube] post ", str, " error: ");
            sbS.append(e2.getMessage());
            SpiderDebug.log(sbS.toString());
            e2.printStackTrace();
            return new JsonObject();
        }
    }

    public static String N() {
        if (A <= 0) {
            return "全部";
        }
        return A + "p";
    }

    public static JsonObject N0(JsonObject jsonObject, String str) {
        try {
            String strJ0 = J0();
            if (strJ0.isEmpty()) {
                return new JsonObject();
            }
            String str2 = YoutubeParsingHelper.YOUTUBEI_V1_URL + str + "?prettyPrint=false";
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
            map.put("Authorization", strJ0);
            map.put("Origin", "https://www.youtube.com");
            map.put("Referer", "https://www.youtube.com/");
            SpiderDebug.log("[YouTube] POST(oauth) " + str + " auth=OAUTH");
            String strZ0 = z0(str2, jsonObject.toString(), map);
            StringBuilder sb = new StringBuilder("[YouTube] POST(oauth) ");
            sb.append(str);
            sb.append(" response len=");
            sb.append(strZ0 == null ? 0 : strZ0.length());
            SpiderDebug.log(sb.toString());
            if (strZ0 != null && !strZ0.isEmpty()) {
                String strReplace = strZ0.replace("\n", Stream.ID_UNKNOWN).replace("\r", Stream.ID_UNKNOWN);
                SpiderDebug.log("[YouTube] POST(oauth) " + str + " resp=" + strReplace.substring(0, Math.min(strReplace.length(), 3800)));
            }
            return d.e(strZ0).getAsJsonObject();
        } catch (Exception e2) {
            StringBuilder sbS = com.github.catvod.spider.merge.b.b.s("[YouTube] postOauth ", str, " error: ");
            sbS.append(e2.getMessage());
            SpiderDebug.log(sbS.toString());
            return new JsonObject();
        }
    }

    public static OkHttpClient O0() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderWriteTimeout = builder.connectTimeout(15L, timeUnit).readTimeout(20L, timeUnit).writeTimeout(15L, timeUnit);
        java.net.Proxy proxyL0 = L0();
        if (proxyL0 != null) {
            SpiderDebug.log("[YouTube] proxyClient: using proxy");
            builderWriteTimeout.proxy(proxyL0);
        } else {
            SpiderDebug.log("[YouTube] proxyClient: direct connection (no proxy)");
        }
        return builderWriteTimeout.build();
    }

    public static Bitmap R0(String str) {
        try {
            com.github.catvod.spider.merge.w.b bVarX = c2.x(str);
            int i2 = bVarX.a;
            int i3 = bVarX.b;
            int[] iArr = new int[i2 * i3];
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr[(i4 * i2) + i5] = bVarX.a(i5, i4) ? -16777216 : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            SpiderDebug.log("[YouTube] qrBitmap error: " + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String S() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Youtube.S():java.lang.String");
    }

    public static String S0(File file) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(bArr, "UTF-8");
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String T(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static void U() {
        String strConcat;
        if (o.isEmpty() || p.isEmpty()) {
            try {
                HashMap map = new HashMap();
                map.put("User-Agent", "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/Version");
                map.put("Accept-Language", "en-US,en;q=0.9");
                String strY0 = y0("https://www.youtube.com/tv", map);
                String strConcat2 = VideoStream.RESOLUTION_UNKNOWN;
                Matcher matcher = Pattern.compile("id=\"base-js\" src=\"([^\"]+)\"|\\.src = '([^']*m=base[^']*)'").matcher(strY0);
                if (matcher.find()) {
                    strConcat2 = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
                }
                if (strConcat2.isEmpty()) {
                    SpiderDebug.log("[YouTube] oauth: base-js url not found (tv len=" + strY0.length() + ")");
                    return;
                }
                if (strConcat2.startsWith("//")) {
                    strConcat2 = "https:".concat(strConcat2);
                } else if (strConcat2.startsWith("/")) {
                    strConcat2 = "https://www.youtube.com".concat(strConcat2);
                }
                String strY02 = y0(strConcat2, map);
                Matcher matcher2 = Pattern.compile("clientId:\"([-\\w]+\\.apps\\.googleusercontent\\.com)\"").matcher(strY02);
                if (matcher2.find()) {
                    o = matcher2.group(1);
                }
                Matcher matcher3 = Pattern.compile("clientId:\"[-\\w]+\\.apps\\.googleusercontent\\.com\",\\s*\\w+:\"(\\w+)\"").matcher(strY02);
                if (matcher3.find()) {
                    p = matcher3.group(1);
                }
                Matcher matcher4 = Pattern.compile("clientVersion:\"([\\d.]+)\"").matcher(strY02);
                if (matcher4.find()) {
                    q = matcher4.group(1);
                }
                StringBuilder sb = new StringBuilder("[YouTube] oauth clientId=");
                String str = "EMPTY";
                if (o.isEmpty()) {
                    strConcat = "EMPTY";
                } else {
                    String str2 = o;
                    strConcat = str2.substring(0, Math.min(24, str2.length())).concat("...");
                }
                sb.append(strConcat);
                sb.append(" secret=");
                if (!p.isEmpty()) {
                    str = "SET";
                }
                sb.append(str);
                sb.append(" tvVer=");
                sb.append(q);
                sb.append(" baseJs=");
                sb.append(strConcat2.substring(0, Math.min(60, strConcat2.length())));
                SpiderDebug.log(sb.toString());
            } catch (Exception e2) {
                com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] ensureOauthCreds error: "));
            }
        }
    }

    public static long U0(StreamInfo streamInfo, List list, List list2) {
        try {
            long duration = streamInfo.getDuration();
            if (duration > 0 && duration < 2592000) {
                return duration;
            }
        } catch (Exception unused) {
        }
        Iterator it = list.iterator();
        long jMax = 0;
        while (it.hasNext()) {
            try {
                long approxDurationMs = ((AudioStream) it.next()).getItagItem().getApproxDurationMs();
                if (approxDurationMs > 0) {
                    jMax = Math.max(jMax, approxDurationMs);
                }
            } catch (Exception unused2) {
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            try {
                long approxDurationMs2 = ((VideoStream) it2.next()).getItagItem().getApproxDurationMs();
                if (approxDurationMs2 > 0) {
                    jMax = Math.max(jMax, approxDurationMs2);
                }
            } catch (Exception unused3) {
            }
        }
        if (jMax > 0) {
            return jMax / 1000;
        }
        return 0L;
    }

    public static String V(String str) {
        try {
            File externalFilesDir = Init.context().getExternalFilesDir(null);
            if (externalFilesDir == null) {
                externalFilesDir = Init.context().getFilesDir();
            }
            File file = new File(externalFilesDir, "youtube_diag_" + System.currentTimeMillis() + ".txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.getAbsolutePath();
        } catch (Throwable unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String V0(String str) {
        if (str != null && !str.isEmpty()) {
            String strTrim = str.trim();
            if (strTrim.startsWith("{")) {
                return strTrim;
            }
            if (strTrim.startsWith("http")) {
                try {
                    return com.github.catvod.spider.merge.g1.a.f(strTrim, null);
                } catch (Exception e2) {
                    com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] resolveExt URL failed: "));
                    return VideoStream.RESOLUTION_UNKNOWN;
                }
            }
            try {
                File file = new File(strTrim);
                if (!file.isAbsolute()) {
                    file = new File("/storage/emulated/0/TV", strTrim);
                }
                if (file.exists()) {
                    return S0(file);
                }
            } catch (Exception e3) {
                com.github.catvod.spider.merge.b.b.x(e3, new StringBuilder("[YouTube] resolveExt file failed: "));
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public static String W(JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        if (!jsonElement.isJsonObject()) {
            if (!jsonElement.isJsonArray()) {
                return null;
            }
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                String strW = W(asJsonArray.get(i2));
                if (strW != null) {
                    return strW;
                }
            }
            return null;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (asJsonObject.has("continuationCommand")) {
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("continuationCommand");
            if (asJsonObject2.has("token")) {
                return asJsonObject2.get("token").getAsString();
            }
        }
        if (asJsonObject.has("continuationItemRenderer")) {
            JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("continuationItemRenderer");
            if (asJsonObject3.has("continuationEndpoint")) {
                JsonObject asJsonObject4 = asJsonObject3.getAsJsonObject("continuationEndpoint");
                if (asJsonObject4.has("continuationCommand")) {
                    JsonObject asJsonObject5 = asJsonObject4.getAsJsonObject("continuationCommand");
                    if (asJsonObject5.has("token")) {
                        return asJsonObject5.get("token").getAsString();
                    }
                }
            }
        }
        Iterator it = asJsonObject.keySet().iterator();
        while (it.hasNext()) {
            String strW2 = W(asJsonObject.get((String) it.next()));
            if (strW2 != null) {
                return strW2;
            }
        }
        return null;
    }

    public static String W0(String str) {
        String upperCase = VideoStream.RESOLUTION_UNKNOWN;
        if (str == null || str.isEmpty()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("VD@@@") || strTrim.startsWith("PL@@@") || strTrim.startsWith("PD@@@") || strTrim.startsWith("CV@@@") || strTrim.startsWith("CP@@@") || strTrim.startsWith("ZB@@@") || strTrim.startsWith("DS@@@")) {
            return strTrim;
        }
        if (strTrim.length() >= 2) {
            upperCase = strTrim.substring(0, 2).toUpperCase();
        }
        if (upperCase.equals("PL")) {
            String strSubstring = strTrim.substring(2);
            return (strSubstring.length() < 8 || !strSubstring.matches("[A-Za-z0-9_-]+")) ? "PL@@@".concat(strSubstring) : "PL@@@".concat(strTrim);
        }
        if (upperCase.equals("PD")) {
            return "PD@@@".concat(strTrim.substring(2));
        }
        if (upperCase.equals("CV")) {
            return "CV@@@".concat(strTrim.substring(2));
        }
        if (upperCase.equals("CP")) {
            return "CP@@@".concat(strTrim.substring(2));
        }
        if (upperCase.equals("ZB")) {
            String strSubstring2 = strTrim.substring(2);
            return C0(strSubstring2) ? "ZB@@@".concat(strSubstring2) : "ZB_".concat(strSubstring2);
        }
        if (!upperCase.equals("DS")) {
            return strTrim.startsWith("LIST:") ? "LIST_".concat(strTrim.substring(5)) : (strTrim.length() < 3 || !strTrim.substring(0, 3).toUpperCase().equals("VD_")) ? strTrim.startsWith("UC") ? "CV@@@".concat(strTrim) : strTrim.startsWith("@") ? "CV@@@".concat(Y(strTrim)) : "VD_".concat(strTrim) : strTrim;
        }
        String strSubstring3 = strTrim.substring(2);
        return C0(strSubstring3) ? "DS@@@".concat(strSubstring3) : "DS_".concat(strSubstring3);
    }

    public static String X(String str) {
        String str2 = G;
        if (str2 == null || str2.isEmpty()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        for (String str3 : G.split(";")) {
            String strTrim = str3.trim();
            int iIndexOf = strTrim.indexOf(61);
            if (iIndexOf > 0 && str.equals(strTrim.substring(0, iIndexOf).trim())) {
                return strTrim.substring(iIndexOf + 1).trim();
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public static String X0() {
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder("=== YouTube 自诊断 ===\n[内核] ");
        boolean zIsRunning = ClashCore.isRunning();
        sb.append(zIsRunning ? "运行中" : "未运行");
        sb.append("\n[内核路径] ");
        sb.append(ClashCore.kernelPath());
        sb.append("\n");
        if (zIsRunning) {
            String logTail = ClashCore.readLogTail(3);
            if (!logTail.isEmpty() && !logTail.contains("不存在")) {
                sb.append("[内核日志] ");
                sb.append(logTail.replace("\n", " | "));
                sb.append("\n");
            }
        }
        sb.append("[代理配置] ");
        sb.append(E.isEmpty() ? "未设置(直连)" : E);
        sb.append("\n");
        if (zIsRunning) {
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder.connectTimeout(2L, timeUnit).readTimeout(2L, timeUnit).build().newCall(new Request.Builder().url("http://127.0.0.1:31600").build()).execute().close();
                z2 = true;
            } catch (Throwable unused) {
                z2 = false;
            }
            sb.append("[代理端口] ");
            sb.append(z2 ? "127.0.0.1:31600 正常" : "端口不可达");
            sb.append("\n");
        }
        String subscriptionUrl = ClashCore.getSubscriptionUrl();
        sb.append("[订阅源] ");
        if (subscriptionUrl.isEmpty()) {
            subscriptionUrl = "未设置";
        } else if (subscriptionUrl.length() > 50) {
            subscriptionUrl = subscriptionUrl.substring(0, 50).concat("...");
        }
        sb.append(subscriptionUrl);
        sb.append("\n[当前节点] ");
        String selectedNode = ClashCore.getSelectedNode();
        sb.append(selectedNode.isEmpty() ? "未选择(DIRECT)" : selectedNode);
        sb.append("\n");
        if (!selectedNode.isEmpty() && zIsRunning) {
            int iTestDelay = ClashCore.testDelay(selectedNode);
            sb.append("[节点连通] ");
            sb.append(iTestDelay >= 0 ? com.github.catvod.spider.merge.b.b.k(iTestDelay, "正常 ", "ms") : "超时/失败");
            sb.append("\n");
        }
        sb.append("[Google] ");
        sb.append(x0() ? "可达" : "不可达");
        sb.append("\n[YouTube API] ");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Response responseExecute = O0().newCall(new Request.Builder().url("https://www.youtube.com/generate_204").build()).execute();
            int iCode = responseExecute.code();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            responseExecute.close();
            if (iCode == 204 || iCode == 200) {
                str = "可达 (HTTP " + iCode + ", " + jCurrentTimeMillis2 + "ms)";
            } else {
                str = "异常 (HTTP " + iCode + ")";
            }
        } catch (Throwable th) {
            str = "不可达 (" + th.getMessage() + ")";
        }
        sb.append(str);
        sb.append("\n[图片加载] ");
        try {
            Response responseExecute2 = O0().newCall(new Request.Builder().url("https://img.youtube.com/vi/jNQXAC9IVRw/hqdefault.jpg").build()).execute();
            int iCode2 = responseExecute2.code();
            String strHeader = responseExecute2.header("Content-Type");
            long length = responseExecute2.body() == null ? 0L : responseExecute2.body().bytes().length;
            responseExecute2.close();
            if (iCode2 == 200 && strHeader != null && strHeader.contains("image")) {
                str2 = "正常 (HTTP 200, " + strHeader + ", " + length + "B)";
            } else {
                str2 = "异常 (HTTP " + iCode2 + ", " + strHeader + ")";
            }
        } catch (Throwable th2) {
            str2 = "失败 (" + th2.getMessage() + ")";
        }
        sb.append(str2);
        sb.append("\n");
        try {
            B0();
            StreamInfo info = StreamInfo.getInfo("https://www.youtube.com/watch?v=jNQXAC9IVRw");
            String hlsUrl = info.getHlsUrl();
            if (hlsUrl.isEmpty() && info.getVideoStreams() != null && !info.getVideoStreams().isEmpty()) {
                hlsUrl = info.getVideoStreams().get(0).getUrl();
            }
            if (hlsUrl.isEmpty() && info.getAudioStreams() != null && !info.getAudioStreams().isEmpty()) {
                hlsUrl = info.getAudioStreams().get(0).getUrl();
            }
            str3 = hlsUrl.isEmpty() ? "异常(未取到流)" : "正常(已取到流)";
        } catch (Throwable th3) {
            String message = th3.getMessage() == null ? VideoStream.RESOLUTION_UNKNOWN : th3.getMessage();
            if (message.contains("LOGIN_REQUIRED") || message.contains("SignInConfirmNotBot")) {
                str3 = "失败(节点IP被YouTube标记，需登录或换节点)";
            } else {
                str3 = "失败(" + th3.getClass().getSimpleName() + ")";
            }
        }
        sb.append("[视频播放] ");
        sb.append(str3);
        sb.append("\n");
        if (str3.contains("正常")) {
            sb.append("[视频流域名] ");
            try {
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                Response responseExecute3 = O0().newCall(new Request.Builder().url("https://www.googlevideo.com/generate_204").build()).execute();
                int iCode3 = responseExecute3.code();
                long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
                responseExecute3.close();
                if (iCode3 == 204 || iCode3 == 200) {
                    str4 = "可达 (" + jCurrentTimeMillis4 + "ms)";
                } else {
                    str4 = "异常 (HTTP " + iCode3 + ")";
                }
            } catch (Throwable th4) {
                str4 = "不可达 (" + th4.getMessage() + ")";
            }
            sb.append(str4);
            sb.append("\n");
        }
        sb.append("[DNS 解析] ");
        StringBuilder sb2 = new StringBuilder();
        try {
            InetAddress[] allByName = InetAddress.getAllByName("www.youtube.com");
            sb2.append("youtube.com=");
            sb2.append(allByName[0].getHostAddress());
            if (allByName[0].getHostAddress().startsWith("127.") || allByName[0].getHostAddress().startsWith("0.")) {
                sb2.append("(污染)");
            }
        } catch (Throwable unused2) {
            sb2.append("youtube.com=(解析失败)");
        }
        sb.append(sb2.toString());
        sb.append("\n");
        String str5 = !r.isEmpty() ? "已登录(OAuth)" : (G.isEmpty() || !H) ? !G.isEmpty() ? "Cookie已填但未验证" : "未登录" : "已登录(Cookie)";
        sb.append("[登录] ");
        sb.append(str5);
        sb.append("\n[出口] ");
        sb.append(F());
        sb.append("\n[节点数] ");
        sb.append(ClashCore.getCachedNodes().size());
        sb.append("\n");
        return sb.toString();
    }

    public static String Y(String str) {
        char cCharAt;
        int i2 = 0;
        while (i2 < str.length() && str.charAt(i2) == '@') {
            i2++;
        }
        StringBuilder sb = new StringBuilder("@");
        while (i2 < str.length() && (((cCharAt = str.charAt(i2)) >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '.' || cCharAt == '-' || cCharAt == '_')))) {
            sb.append(cCharAt);
            i2++;
        }
        return sb.toString();
    }

    public static void Y0() {
        try {
            File file = new File("/storage/emulated/0/TV/.ytb");
            if (!file.exists()) {
                file.mkdirs();
            }
            JsonObject jsonObject = new JsonObject();
            String str = "all";
            jsonObject.addProperty("codec", z.isEmpty() ? "all" : z);
            int i2 = A;
            jsonObject.addProperty("quality", i2 <= 0 ? "all" : String.valueOf(i2));
            jsonObject.addProperty("audio", B.isEmpty() ? "all" : B);
            if (!C.isEmpty()) {
                str = C;
            }
            jsonObject.addProperty("default", str);
            jsonObject.addProperty("json", D.isEmpty() ? "@default" : D);
            String str2 = E;
            String str3 = VideoStream.RESOLUTION_UNKNOWN;
            if (str2 == null) {
                str2 = VideoStream.RESOLUTION_UNKNOWN;
            }
            jsonObject.addProperty("proxy", str2);
            String str4 = G;
            if (str4 == null) {
                str4 = VideoStream.RESOLUTION_UNKNOWN;
            }
            jsonObject.addProperty("cookie", str4);
            jsonObject.addProperty("login", Boolean.valueOf(H));
            String str5 = r;
            if (str5 == null) {
                str5 = VideoStream.RESOLUTION_UNKNOWN;
            }
            jsonObject.addProperty("oauth_access", str5);
            String str6 = s;
            if (str6 == null) {
                str6 = VideoStream.RESOLUTION_UNKNOWN;
            }
            jsonObject.addProperty("oauth_refresh", str6);
            jsonObject.addProperty("oauth_expires", Long.valueOf(t));
            String str7 = o;
            if (str7 == null) {
                str7 = VideoStream.RESOLUTION_UNKNOWN;
            }
            jsonObject.addProperty("oauth_client_id", str7);
            String str8 = p;
            if (str8 != null) {
                str3 = str8;
            }
            jsonObject.addProperty("oauth_client_secret", str3);
            jsonObject.addProperty("clash_subscribe", ClashCore.getSubscribeUrl());
            jsonObject.addProperty("clash_local", ClashCore.getLocalFile());
            jsonObject.addProperty("clash_node", ClashCore.getSelectedNode());
            jsonObject.addProperty("clash_mirror", Integer.valueOf(ClashCore.getMirrorIndex()));
            JsonArray jsonArray = new JsonArray();
            Iterator it = n.iterator();
            while (it.hasNext()) {
                jsonArray.add((String) it.next());
            }
            jsonObject.add("subscribed", jsonArray);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("/storage/emulated/0/TV/.ytb/setting.json"));
            fileOutputStream.write(jsonObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] save settings error: "));
        }
    }

    public static JsonObject Z(String str) {
        try {
            Matcher matcher = Pattern.compile("ytInitialData\\s*=\\s*(\\{)", 32).matcher(str);
            if (matcher.find()) {
                String strB0 = b0(matcher.start(1), str);
                if (!strB0.isEmpty()) {
                    JsonObject asJsonObject = d.e(strB0).getAsJsonObject();
                    if (asJsonObject.size() > 0) {
                        return asJsonObject;
                    }
                }
            }
            int i2 = 0;
            while (true) {
                int iIndexOf = str.indexOf("\"responseContext\"", i2);
                if (iIndexOf < 0) {
                    break;
                }
                int iLastIndexOf = str.lastIndexOf(123, iIndexOf);
                if (iLastIndexOf >= 0) {
                    String strB02 = b0(iLastIndexOf, str);
                    if (strB02.isEmpty()) {
                        continue;
                    } else {
                        try {
                            JsonObject asJsonObject2 = d.e(strB02).getAsJsonObject();
                            if (asJsonObject2.size() > 0 && asJsonObject2.has("contents") && !asJsonObject2.has("playabilityStatus")) {
                                return asJsonObject2;
                            }
                        } catch (Exception unused) {
                            continue;
                        }
                    }
                }
                i2 = iIndexOf + 1;
            }
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] extractInitialData error: "));
        }
        return new JsonObject();
    }

    public static h a(String str, String str2, String str3, String str4, boolean z2) {
        h hVar = new h();
        StringBuilder sb = new StringBuilder();
        String str5 = VideoStream.RESOLUTION_UNKNOWN;
        sb.append(z2 ? "[当前] " : VideoStream.RESOLUTION_UNKNOWN);
        sb.append(str);
        hVar.g(sb.toString());
        if (z2) {
            str5 = "当前";
        }
        hVar.k(str5);
        hVar.b(str2);
        hVar.h(a1(str3, str4));
        return hVar;
    }

    public static JsonObject a0(String str) {
        int iLastIndexOf;
        try {
            Matcher matcher = Pattern.compile("ytInitialPlayerResponse\\s*=\\s*(\\{)", 32).matcher(str);
            if (matcher.find()) {
                String strB0 = b0(matcher.start(1), str);
                if (!strB0.isEmpty()) {
                    JsonObject asJsonObject = d.e(strB0).getAsJsonObject();
                    if (asJsonObject.size() > 0) {
                        return asJsonObject;
                    }
                }
            }
            int iIndexOf = str.indexOf("\"playabilityStatus\"");
            if (iIndexOf < 0) {
                iIndexOf = str.indexOf("\"videoDetails\"");
            }
            if (iIndexOf >= 0 && (iLastIndexOf = str.lastIndexOf(123, iIndexOf)) >= 0) {
                String strB02 = b0(iLastIndexOf, str);
                if (!strB02.isEmpty()) {
                    JsonObject asJsonObject2 = d.e(strB02).getAsJsonObject();
                    if (asJsonObject2.size() > 0) {
                        return asJsonObject2;
                    }
                }
            }
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] extractInitialPlayerResponse error: "));
        }
        return new JsonObject();
    }

    public static String a1(String str, String str2) {
        String strO = com.github.catvod.spider.merge.b.b.o(str, "|", str2);
        HashMap map = P;
        String str3 = (String) map.get(strO);
        if (str3 != null) {
            return str3;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.parseColor(str));
            canvas.drawRoundRect(0.0f, 0.0f, 96.0f, 96.0f, 24.0f, 24.0f, paint);
            if (!str2.isEmpty()) {
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setColor(-1);
                paint2.setTextAlign(Paint.Align.CENTER);
                paint2.setTypeface(Typeface.DEFAULT_BOLD);
                paint2.setTextSize(str2.length() > 1 ? 38.0f : 54.0f);
                Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
                canvas.drawText(str2, 48.0f, 48.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), paint2);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            bitmapCreateBitmap.recycle();
            String str4 = "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            map.put(strO, str4);
            return str4;
        } catch (Throwable unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static h b(String str, String str2, boolean z2) {
        return a(str, str2, "#6366F1", "项", z2);
    }

    public static String b0(int i2, String str) {
        if (i2 < 0 || i2 >= str.length() || str.charAt(i2) != '{') {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        for (int i4 = i2; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z2) {
                z2 = false;
            } else if (cCharAt == '\\') {
                z2 = true;
            } else if (cCharAt == '\"') {
                z3 = !z3;
            } else if (z3) {
                continue;
            } else if (cCharAt == '{') {
                i3++;
            } else if (cCharAt == '}' && i3 - 1 == 0) {
                return str.substring(i2, i4 + 1);
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public static String b1(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static boolean c(StringBuilder sb, SubtitlesStream subtitlesStream) {
        String strQ;
        String content = subtitlesStream.getContent();
        String languageTag = subtitlesStream.getLanguageTag() != null ? subtitlesStream.getLanguageTag() : "und";
        String displayLanguageName = subtitlesStream.getDisplayLanguageName() != null ? subtitlesStream.getDisplayLanguageName() : languageTag;
        if (content == null || content.isEmpty()) {
            return false;
        }
        if (content.contains("fmt=")) {
            strQ = content.replaceAll("fmt=[^&]*", "fmt=vtt");
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(content);
            strQ = com.github.catvod.spider.merge.b.b.q(sb2, content.contains("?") ? "&" : "?", "fmt=vtt");
        }
        String strReplace = strQ.replace("&", "&amp;");
        String strReplaceAll = languageTag.replaceAll("[^a-zA-Z0-9_-]", "_");
        Locale.getDefault();
        sb.append("<AdaptationSet mimeType='text/vtt' lang='" + languageTag + "' label='" + displayLanguageName + "'>\n<Role schemeIdUri='urn:mpeg:dash:role:2011' value='subtitle'/>\n<Representation id='sub-" + strReplaceAll + "' bandwidth='256' codecs='wvtt'>\n<BaseURL>" + strReplace + "</BaseURL>\n</Representation>\n</AdaptationSet>");
        return true;
    }

    public static String c1() {
        try {
            String strX = X("SAPISID");
            if (strX.isEmpty()) {
                strX = X("__Secure-1PAPISID");
            }
            if (strX.isEmpty()) {
                strX = X("__Secure-3PAPISID");
            }
            if (strX.isEmpty()) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            return "SAPISIDHASH " + jCurrentTimeMillis + "_" + b1(jCurrentTimeMillis + Stream.ID_UNKNOWN + strX + " https://www.youtube.com");
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static void d(List list, StringBuilder sb) {
        HashSet hashSet = new HashSet(Arrays.asList("zh-CN", "zh-TW", "zh-HK", "en", "ja", "ko", "th", "vi", "id", "ms"));
        Iterator it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubtitlesStream subtitlesStream = (SubtitlesStream) it.next();
            if (i2 >= 10) {
                break;
            }
            if (hashSet.contains(subtitlesStream.getLanguageTag() != null ? subtitlesStream.getLanguageTag() : "und") && c(sb, subtitlesStream)) {
                i2++;
            }
        }
        if (i2 < 5) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                SubtitlesStream subtitlesStream2 = (SubtitlesStream) it2.next();
                if (i2 >= 10) {
                    return;
                }
                if (!hashSet.contains(subtitlesStream2.getLanguageTag() != null ? subtitlesStream2.getLanguageTag() : "und") && c(sb, subtitlesStream2)) {
                    i2++;
                }
            }
        }
    }

    public static boolean d0(JsonObject jsonObject) {
        Boolean boolM0;
        try {
            Iterator it = k0(jsonObject, "subscribeButtonRenderer").iterator();
            while (it.hasNext()) {
                JsonObject jsonObject2 = (JsonObject) it.next();
                if (jsonObject2.has("subscribeButtonRenderer")) {
                    JsonObject asJsonObject = jsonObject2.getAsJsonObject("subscribeButtonRenderer");
                    if (asJsonObject.has("subscribed") && !asJsonObject.get("subscribed").isJsonNull()) {
                        return asJsonObject.get("subscribed").getAsBoolean();
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            Iterator it2 = k0(jsonObject, "subscribeButtonViewModel").iterator();
            while (it2.hasNext()) {
                JsonObject jsonObject3 = (JsonObject) it2.next();
                if (jsonObject3.has("subscribeButtonViewModel") && (boolM0 = m0(jsonObject3.getAsJsonObject("subscribeButtonViewModel"))) != null) {
                    return boolM0.booleanValue();
                }
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static void e(String str) {
        if ("all".equals(str)) {
            str = VideoStream.RESOLUTION_UNKNOWN;
        }
        B = str;
        Y0();
        YoutubeVr.setAudioFilter(B);
        StringBuilder sb = new StringBuilder("已设置音质：");
        sb.append(B.isEmpty() ? "全部" : B.toUpperCase());
        com.github.catvod.spider.merge.g1.a.e(sb.toString());
    }

    public static String e0(String str) {
        if (str.isEmpty()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        try {
            Matcher matcher = Pattern.compile("\"DATASYNC_ID\"\\s*:\\s*\"([^\"]+)\"").matcher(str);
            if (!matcher.find()) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            String strGroup = matcher.group(1);
            int iIndexOf = strGroup.indexOf("||");
            if (iIndexOf < 0) {
                return strGroup;
            }
            String strSubstring = strGroup.substring(iIndexOf + 2);
            return !strSubstring.isEmpty() ? strSubstring : strGroup.substring(0, iIndexOf);
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String e1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(n0("HIS@@subchannels", "订阅频道", "你订阅的频道列表", "#DC2626", "频"));
        arrayList.add(n0("HIS@@subscriptions", "订阅动态", "订阅频道的最新视频", "#4E6AF0", "动"));
        e eVar = new e();
        eVar.s(arrayList);
        eVar.g(1, 1, 0, 1);
        return eVar.toString();
    }

    public static void f(String str) {
        if ("all".equals(str)) {
            str = VideoStream.RESOLUTION_UNKNOWN;
        }
        z = str;
        Y0();
        YoutubeVr.setCodecFilter(z.isEmpty() ? C : z);
        com.github.catvod.spider.merge.g1.a.e("已设置视频格式：" + L());
    }

    public static String f0(String str) {
        try {
            if (str.contains("watch?v=")) {
                int iIndexOf = str.indexOf("watch?v=");
                int i2 = iIndexOf + 8;
                int iIndexOf2 = str.indexOf("&", i2);
                if (iIndexOf2 == -1) {
                    iIndexOf2 = str.length();
                }
                return str.substring(i2, Math.min(iIndexOf2, iIndexOf + 19));
            }
            if (str.contains("/v/")) {
                int iIndexOf3 = str.indexOf("/v/");
                return str.substring(iIndexOf3 + 3, Math.min(iIndexOf3 + 14, str.length()));
            }
            if (!str.contains("youtu.be/")) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            int iIndexOf4 = str.indexOf("youtu.be/");
            return str.substring(iIndexOf4 + 9, Math.min(iIndexOf4 + 20, str.length()));
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] extractVideoIdFromUrl error: "));
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static void f1(String str, boolean z2) {
        try {
            if (str.isEmpty()) {
                return;
            }
            if (r.isEmpty()) {
                SpiderDebug.log("[YouTube] subscribeChannel no oauth token");
                com.github.catvod.spider.merge.g1.a.e("订阅需要 OAuth 登录：请到「设置 → OAuth 登录」扫码/输码授权");
                return;
            }
            String str2 = z2 ? "subscription/subscribe" : "subscription/unsubscribe";
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("context", C());
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(str);
            jsonObject.add("channelIds", jsonArray);
            jsonObject.addProperty("params", VideoStream.RESOLUTION_UNKNOWN);
            JsonObject jsonObjectN0 = N0(jsonObject, str2);
            if (jsonObjectN0 != null) {
                String string = jsonObjectN0.toString();
                if (!string.contains("\"loggedOut\":true")) {
                    if (!string.contains("\"loggedOut\": true")) {
                        if (!string.contains("会话已过期")) {
                            if (!string.contains("signInEndpoint")) {
                                if (string.contains("ServiceLogin")) {
                                }
                            }
                        }
                    }
                }
                SpiderDebug.log("[YouTube] subscribeChannel still loggedOut with oauth=".concat(r.isEmpty() ? "NONE" : "SET"));
                com.github.catvod.spider.merge.g1.a.e("订阅失败：OAuth 授权可能已失效，请重新 OAuth 登录");
                return;
            }
            boolean z3 = (jsonObjectN0 == null || jsonObjectN0.has("error")) ? false : true;
            if (z3) {
                HashSet hashSet = n;
                if (z2) {
                    hashSet.add(str);
                } else {
                    hashSet.remove(str);
                }
            }
            StringBuilder sb = new StringBuilder("[YouTube] subscribeChannel ");
            sb.append(z2 ? "订阅" : "退订");
            sb.append(Stream.ID_UNKNOWN);
            sb.append(str);
            sb.append(" ok=");
            sb.append(z3);
            sb.append(" keys=");
            sb.append(jsonObjectN0 == null ? "null" : jsonObjectN0.keySet().toString());
            SpiderDebug.log(sb.toString());
            com.github.catvod.spider.merge.g1.a.e(z2 ? z3 ? "订阅成功" : "订阅失败" : z3 ? "退订成功" : "退订失败");
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] subscribeChannel error: "));
            com.github.catvod.spider.merge.g1.a.e(z2 ? "订阅失败" : "退订失败");
        }
    }

    public static void g(String str) {
        if ("all".equals(str)) {
            str = VideoStream.RESOLUTION_UNKNOWN;
        }
        C = str;
        Y0();
        YoutubeVr.setCodecFilter(z.isEmpty() ? C : z);
        StringBuilder sb = new StringBuilder("已设置默认起播格式：");
        sb.append(C.isEmpty() ? "不指定" : C.toUpperCase());
        com.github.catvod.spider.merge.g1.a.e(sb.toString());
    }

    public static String g0(h hVar) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = h.class.getDeclaredField("b");
            declaredField.setAccessible(true);
            String str = (String) declaredField.get(hVar);
            return str == null ? VideoStream.RESOLUTION_UNKNOWN : str.contains("@@@") ? str.split("@@@")[1] : str;
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0052 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:10:0x002f, B:13:0x0037, B:15:0x003e, B:19:0x0052, B:21:0x0058, B:23:0x005f, B:26:0x006f, B:28:0x0077, B:33:0x0094, B:35:0x009a, B:37:0x00a1, B:40:0x00b1, B:42:0x00b7, B:44:0x00be, B:30:0x007f, B:32:0x008f), top: B:171:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:10:0x002f, B:13:0x0037, B:15:0x003e, B:19:0x0052, B:21:0x0058, B:23:0x005f, B:26:0x006f, B:28:0x0077, B:33:0x0094, B:35:0x009a, B:37:0x00a1, B:40:0x00b1, B:42:0x00b7, B:44:0x00be, B:30:0x007f, B:32:0x008f), top: B:171:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:10:0x002f, B:13:0x0037, B:15:0x003e, B:19:0x0052, B:21:0x0058, B:23:0x005f, B:26:0x006f, B:28:0x0077, B:33:0x0094, B:35:0x009a, B:37:0x00a1, B:40:0x00b1, B:42:0x00b7, B:44:0x00be, B:30:0x007f, B:32:0x008f), top: B:171:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:10:0x002f, B:13:0x0037, B:15:0x003e, B:19:0x0052, B:21:0x0058, B:23:0x005f, B:26:0x006f, B:28:0x0077, B:33:0x0094, B:35:0x009a, B:37:0x00a1, B:40:0x00b1, B:42:0x00b7, B:44:0x00be, B:30:0x007f, B:32:0x008f), top: B:171:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g1(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 1081
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Youtube.g1(java.lang.String):java.lang.String");
    }

    public static String h0(String str) {
        if (str.isEmpty()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        try {
            Matcher matcher = Pattern.compile("\"VISITOR_DATA\"\\s*:\\s*\"([^\"]+)\"").matcher(str);
            return matcher.find() ? matcher.group(1) : VideoStream.RESOLUTION_UNKNOWN;
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String h1(String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Response responseExecute = O0().newCall(new Request.Builder().url(str).header("Range", "bytes=0-1023").build()).execute();
            int iCode = responseExecute.code();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            responseExecute.close();
            if (iCode != 200 && iCode != 206) {
                if (iCode == 403) {
                    return "✗ HTTP 403（IP 被限制或需要登录）";
                }
                return "✗ HTTP " + iCode;
            }
            return "✓ 可达 (" + jCurrentTimeMillis2 + " ms, HTTP " + iCode + ")";
        } catch (Throwable th) {
            String simpleName = th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage();
            return simpleName.toLowerCase().contains("timeout") ? "✗ 超时（网络问题或代理问题）" : simpleName.toLowerCase().contains("connect") ? "✗ 连接失败（网络或代理问题）" : com.github.catvod.spider.merge.b.b.A("✗ 失败 (", simpleName, ")");
        }
    }

    public static void i() {
        String hostString;
        Proxy.Type type;
        int port;
        java.net.Proxy proxyL0 = L0();
        Proxy.Type type2 = Proxy.Type.HTTP;
        if (proxyL0 == null || !(proxyL0.address() instanceof InetSocketAddress)) {
            hostString = VideoStream.RESOLUTION_UNKNOWN;
            type = type2;
            port = -1;
        } else {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyL0.address();
            hostString = inetSocketAddress.getHostString();
            port = inetSocketAddress.getPort();
            type = proxyL0.type();
        }
        NewPipeDownloader.setProxy(hostString, port, type);
        YoutubeVr.setProxy(hostString, port, type);
    }

    public static String i0(h hVar) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = h.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            String str = (String) declaredField.get(hVar);
            return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static boolean i1() {
        String str = G;
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            SpiderDebug.log("[YouTube] verifyLogin cookieFilter length=" + G.length());
            if (G.length() > 400) {
                StringBuilder sb = new StringBuilder("[YouTube] verifyLogin cookie preview: start=[");
                sb.append(G.substring(0, 200));
                sb.append("] end=[");
                String str2 = G;
                sb.append(str2.substring(str2.length() - 200));
                sb.append("]");
                SpiderDebug.log(sb.toString());
            } else {
                SpiderDebug.log("[YouTube] verifyLogin cookie full: [" + G + "]");
            }
            HashMap map = new HashMap();
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            String strY0 = y0("https://www.youtube.com/feed/history", map);
            if (strY0.isEmpty()) {
                SpiderDebug.log("[YouTube] verifyLogin html empty");
                return false;
            }
            JsonObject jsonObjectZ = Z(strY0);
            int size = k0(jsonObjectZ, "videoRenderer").size();
            int size2 = k0(jsonObjectZ, "compactVideoRenderer").size();
            int size3 = k0(jsonObjectZ, "lockupViewModel").size();
            int size4 = k0(jsonObjectZ, "richItemRenderer").size();
            int size5 = k0(jsonObjectZ, "continuationCommand").size();
            SpiderDebug.log("[YouTube] verifyLogin pageLen=" + strY0.length() + " vr=" + size + " cvr=" + size2 + " lv=" + size3 + " rich=" + size4 + " cont=" + size5 + " signIn=" + k0(jsonObjectZ, "signInPromptRenderer").size() + " cookieKeys: " + I());
            try {
                Matcher matcher = Pattern.compile("<title>([^<]*)</title>").matcher(strY0);
                if (matcher.find()) {
                    SpiderDebug.log("[YouTube] verifyLogin page title: " + matcher.group(1));
                }
            } catch (Exception unused) {
            }
            SpiderDebug.log("[YouTube] verifyLogin dataSize=" + jsonObjectZ.size() + " dataKeys=" + jsonObjectZ.keySet());
            int iIndexOf = strY0.indexOf("ytInitialData");
            SpiderDebug.log("[YouTube] verifyLogin ytInitialData idx=" + iIndexOf + " hasPlayerResponse=" + strY0.contains("ytInitialPlayerResponse") + " hasSignIn=" + strY0.contains("signInPromptRenderer"));
            if (iIndexOf >= 0) {
                SpiderDebug.log("[YouTube] verifyLogin ytInitialData ctx: " + strY0.substring(Math.max(0, iIndexOf - 20), Math.min(strY0.length(), iIndexOf + 300)).replaceAll("\\s+", Stream.ID_UNKNOWN));
            }
            if (strY0.length() < 3000) {
                String strTrim = strY0.replaceAll("\\s+", Stream.ID_UNKNOWN).trim();
                if (strTrim.length() > 200) {
                    strTrim = strTrim.substring(0, 200);
                }
                SpiderDebug.log("[YouTube] verifyLogin short html: ".concat(strTrim));
            }
            return size > 0 || size2 > 0 || size3 > 0 || size4 > 0 || size5 > 0;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] verifyLogin error: "));
            return false;
        }
    }

    public static String j0(h hVar) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = h.class.getDeclaredField("d");
            declaredField.setAccessible(true);
            String str = (String) declaredField.get(hVar);
            return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static ArrayList k0(JsonObject jsonObject, String str) {
        ArrayList arrayList = new ArrayList();
        l0(jsonObject, str, arrayList);
        return arrayList;
    }

    public static void l0(JsonElement jsonElement, String str, ArrayList arrayList) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return;
        }
        if (jsonElement.isJsonObject()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject.has(str)) {
                arrayList.add(asJsonObject);
            }
            Iterator it = asJsonObject.keySet().iterator();
            while (it.hasNext()) {
                l0(asJsonObject.get((String) it.next()), str, arrayList);
            }
            return;
        }
        if (jsonElement.isJsonArray()) {
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                l0(asJsonArray.get(i2), str, arrayList);
            }
        }
    }

    public static Boolean m0(JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull() || jsonElement.isJsonPrimitive()) {
            return null;
        }
        if (!jsonElement.isJsonObject()) {
            if (!jsonElement.isJsonArray()) {
                return null;
            }
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                Boolean boolM0 = m0(asJsonArray.get(i2));
                if (boolM0 != null) {
                    return boolM0;
                }
            }
            return null;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (asJsonObject.has("subscribed") && asJsonObject.get("subscribed").isJsonPrimitive()) {
            try {
                return Boolean.valueOf(asJsonObject.get("subscribed").getAsBoolean());
            } catch (Exception unused) {
                return null;
            }
        }
        Iterator it = asJsonObject.keySet().iterator();
        while (it.hasNext()) {
            Boolean boolM02 = m0(asJsonObject.get((String) it.next()));
            if (boolM02 != null) {
                return boolM02;
            }
        }
        return null;
    }

    public static h n0(String str, String str2, String str3, String str4, String str5) {
        h hVar = new h();
        hVar.f(str);
        hVar.g(str2);
        hVar.l("folder");
        hVar.k(str3);
        hVar.h(a1(str4, str5));
        return hVar;
    }

    public static String o(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null || str.isEmpty()) {
            String[] strArr = {"/storage/emulated/0", "/sdcard", "/storage"};
            for (int i2 = 0; i2 < 3; i2++) {
                String str2 = strArr[i2];
                if (new File(str2).isDirectory()) {
                    arrayList.add(n0(com.github.catvod.spider.merge.b.b.n("SET@@dir:", str2), str2, VideoStream.RESOLUTION_UNKNOWN, "#6366F1", "盘"));
                }
            }
        } else {
            File file = new File(str);
            if (file.isDirectory()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    arrayList.add(n0("SET@@dir:" + parentFile.getAbsolutePath(), "上级目录", VideoStream.RESOLUTION_UNKNOWN, "#6366F1", "上"));
                }
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (File file2 : fileArrListFiles) {
                        if (file2.isDirectory()) {
                            arrayList2.add(file2);
                        } else if (file2.getName().toLowerCase().endsWith(".json")) {
                            arrayList3.add(file2);
                        }
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        File file3 = (File) it.next();
                        arrayList.add(n0("SET@@dir:" + file3.getAbsolutePath(), file3.getName(), VideoStream.RESOLUTION_UNKNOWN, "#6366F1", "夹"));
                    }
                    Iterator it2 = arrayList3.iterator();
                    while (it2.hasNext()) {
                        File file4 = (File) it2.next();
                        boolean zEquals = file4.getAbsolutePath().equals(D);
                        String str3 = "SET@@json:" + file4.getAbsolutePath();
                        StringBuilder sb = new StringBuilder();
                        sb.append(zEquals ? "[当前] " : VideoStream.RESOLUTION_UNKNOWN);
                        sb.append(file4.getName());
                        arrayList.add(n0(str3, sb.toString(), file4.getAbsolutePath(), "#6366F1", "档"));
                    }
                }
            }
        }
        e eVar = new e();
        eVar.s(arrayList);
        eVar.g(1, 1, 0, 1);
        return eVar.toString();
    }

    public static String q0() {
        String strConcat;
        if (!i.isEmpty()) {
            return i;
        }
        try {
            SpiderDebug.log("[YouTube] fetching API key from homepage");
            HashMap map = new HashMap();
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            String strY0 = y0("https://www.youtube.com", map);
            Matcher matcher = Pattern.compile("\"INNERTUBE_API_KEY\"\\s*:\\s*\"([^\"]+)\"").matcher(strY0);
            if (matcher.find()) {
                i = matcher.group(1);
                StringBuilder sb = new StringBuilder("[YouTube] apiKey=");
                String str = i;
                sb.append(str.substring(0, Math.min(20, str.length())));
                sb.append("...");
                SpiderDebug.log(sb.toString());
            } else {
                SpiderDebug.log("[YouTube] apiKey not found in HTML (len=" + strY0.length() + ")");
            }
            Matcher matcher2 = Pattern.compile("\"INNERTUBE_CONTEXT_CLIENT_VERSION\"\\s*:\\s*\"([^\"]+)\"").matcher(strY0);
            if (matcher2.find()) {
                k = matcher2.group(1);
                SpiderDebug.log("[YouTube] clientVersion=" + k);
            }
            Matcher matcher3 = Pattern.compile("\"INNERTUBE_CONTEXT_CLIENT_NAME\"\\s*:\\s*\"([^\"]+)\"").matcher(strY0);
            if (matcher3.find()) {
                j = matcher3.group(1);
            }
            String strE0 = e0(strY0);
            if (!strE0.isEmpty()) {
                l = strE0;
            }
            String strH0 = h0(strY0);
            if (!strH0.isEmpty()) {
                m = strH0;
            }
            StringBuilder sb2 = new StringBuilder("[YouTube] dataSyncId=");
            String str2 = "EMPTY";
            if (l.isEmpty()) {
                strConcat = "EMPTY";
            } else {
                String str3 = l;
                strConcat = str3.substring(0, Math.min(8, str3.length())).concat("...");
            }
            sb2.append(strConcat);
            sb2.append(" visitorData=");
            if (!m.isEmpty()) {
                str2 = "SET";
            }
            sb2.append(str2);
            SpiderDebug.log(sb2.toString());
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] getApiKey error: " + e2.getMessage());
            e2.printStackTrace();
        }
        return i;
    }

    public static BrowseResult r(int i2, String str) {
        BrowseResult browseResult = new BrowseResult();
        if (i2 > 1) {
            return browseResult;
        }
        try {
            for (String str2 : str.split("[,|，、]")) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty()) {
                    h hVar = new h();
                    String strY = VideoStream.RESOLUTION_UNKNOWN;
                    int iIndexOf = strTrim.indexOf(64);
                    if (iIndexOf >= 0) {
                        strY = Y(strTrim.substring(iIndexOf));
                    }
                    if (strY.isEmpty()) {
                        hVar.f(strTrim);
                    } else {
                        hVar.f(strY);
                    }
                    hVar.g(strTrim);
                    hVar.l("folder");
                    browseResult.a.add(hVar);
                }
            }
            SpiderDebug.log("[YouTube] browseList items=" + browseResult.a.size());
            return browseResult;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseList error: "));
            return browseResult;
        }
    }

    public static String r0() {
        try {
            for (NetworkInterface networkInterface : (NetworkInterface[]) Collections.list(NetworkInterface.getNetworkInterfaces()).toArray(new NetworkInterface[0])) {
                for (InetAddress inetAddress : (InetAddress[]) Collections.list(networkInterface.getInetAddresses()).toArray(new InetAddress[0])) {
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        String hostAddress = inetAddress.getHostAddress();
                        if ((!hostAddress.startsWith("192.168.") || hostAddress.startsWith("192.168.43.")) && !hostAddress.startsWith("10.")) {
                        }
                        return hostAddress;
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] getLocalIpAddress error: "));
            return null;
        }
    }

    public static String s0(JsonObject jsonObject) {
        JsonObject asJsonObject;
        JsonObject asJsonObject2;
        JsonObject asJsonObject3;
        JsonObject asJsonObject4;
        try {
            asJsonObject = jsonObject.getAsJsonObject("metadata");
        } catch (Exception unused) {
        }
        if (asJsonObject != null && (asJsonObject2 = asJsonObject.getAsJsonObject("lockupMetadataViewModel")) != null && (asJsonObject3 = asJsonObject2.getAsJsonObject("metadata")) != null && (asJsonObject4 = asJsonObject3.getAsJsonObject("contentMetadataViewModel")) != null) {
            JsonArray asJsonArray = asJsonObject4.has("metadataRows") ? asJsonObject4.getAsJsonArray("metadataRows") : null;
            if (asJsonArray != null && asJsonArray.size() > 0) {
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    JsonObject asJsonObject5 = asJsonArray.get(i2).getAsJsonObject();
                    JsonArray asJsonArray2 = asJsonObject5.has("metadataParts") ? asJsonObject5.getAsJsonArray("metadataParts") : null;
                    if (asJsonArray2 != null && asJsonArray2.size() != 0) {
                        JsonObject asJsonObject6 = asJsonArray2.get(0).getAsJsonObject();
                        if (asJsonObject6.has("text")) {
                            JsonObject asJsonObject7 = asJsonObject6.getAsJsonObject("text");
                            if (asJsonObject7.has("content") && !asJsonObject7.get("content").isJsonNull()) {
                                String asString = asJsonObject7.get("content").getAsString();
                                if (!asString.isEmpty()) {
                                    return asString;
                                }
                            }
                            String strV0 = v0(asJsonObject7);
                            if (!strV0.isEmpty()) {
                                return strV0;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (O) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            O = true;
            SpiderDebug.log("[YouTube] getLockupChannel empty, lv keys=" + jsonObject.keySet().toString());
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public static String t0(JsonObject jsonObject) {
        JsonObject asJsonObject;
        JsonObject asJsonObject2;
        JsonObject asJsonObject3;
        try {
            JsonObject asJsonObject4 = jsonObject.getAsJsonObject("metadata");
            if (asJsonObject4 != null && (asJsonObject = asJsonObject4.getAsJsonObject("lockupMetadataViewModel")) != null && (asJsonObject2 = asJsonObject.getAsJsonObject("metadata")) != null && (asJsonObject3 = asJsonObject2.getAsJsonObject("contentMetadataViewModel")) != null) {
                JsonArray asJsonArray = asJsonObject3.has("metadataRows") ? asJsonObject3.getAsJsonArray("metadataRows") : null;
                if (asJsonArray == null) {
                    return VideoStream.RESOLUTION_UNKNOWN;
                }
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    JsonObject asJsonObject5 = asJsonArray.get(i2).getAsJsonObject();
                    JsonArray asJsonArray2 = asJsonObject5.has("metadataParts") ? asJsonObject5.getAsJsonArray("metadataParts") : null;
                    if (asJsonArray2 != null) {
                        for (int i3 = 0; i3 < asJsonArray2.size(); i3++) {
                            JsonObject asJsonObject6 = asJsonArray2.get(i3).getAsJsonObject();
                            if (asJsonObject6.has("text")) {
                                String strV0 = v0(asJsonObject6.get("text"));
                                if (!strV0.isEmpty() && (strV0.contains("ago") || strV0.contains("前") || strV0.contains("小时") || strV0.contains("分钟") || strV0.contains("秒") || strV0.contains("刚刚") || strV0.contains("昨天") || strV0.contains("前天") || strV0.contains("今天") || strV0.contains("天") || strV0.contains("周") || strV0.contains("月") || strV0.contains("年") || strV0.toLowerCase().contains("just now") || strV0.toLowerCase().contains("yesterday"))) {
                                    return strV0;
                                }
                            }
                        }
                    }
                }
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            return VideoStream.RESOLUTION_UNKNOWN;
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String u0(JsonObject jsonObject) {
        JsonObject asJsonObject;
        JsonObject asJsonObject2;
        JsonObject asJsonObject3;
        try {
            JsonObject asJsonObject4 = jsonObject.getAsJsonObject("metadata");
            if (asJsonObject4 != null && (asJsonObject = asJsonObject4.getAsJsonObject("lockupMetadataViewModel")) != null && (asJsonObject2 = asJsonObject.getAsJsonObject("metadata")) != null && (asJsonObject3 = asJsonObject2.getAsJsonObject("contentMetadataViewModel")) != null) {
                JsonArray asJsonArray = asJsonObject3.has("metadataRows") ? asJsonObject3.getAsJsonArray("metadataRows") : null;
                if (asJsonArray == null) {
                    return VideoStream.RESOLUTION_UNKNOWN;
                }
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    JsonObject asJsonObject5 = asJsonArray.get(i2).getAsJsonObject();
                    JsonArray asJsonArray2 = asJsonObject5.has("metadataParts") ? asJsonObject5.getAsJsonArray("metadataParts") : null;
                    if (asJsonArray2 != null) {
                        for (int i3 = 0; i3 < asJsonArray2.size(); i3++) {
                            JsonObject asJsonObject6 = asJsonArray2.get(i3).getAsJsonObject();
                            if (asJsonObject6.has("text")) {
                                String strV0 = v0(asJsonObject6.get("text"));
                                if (!strV0.isEmpty() && (strV0.contains("观看") || strV0.contains("次") || strV0.toLowerCase().contains("view") || strV0.toLowerCase().contains("watching") || strV0.toLowerCase().contains("watch"))) {
                                    return strV0;
                                }
                            }
                        }
                    }
                }
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            return VideoStream.RESOLUTION_UNKNOWN;
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String v0(JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        try {
            if (jsonElement.isJsonPrimitive()) {
                return jsonElement.getAsString();
            }
            if (!jsonElement.isJsonObject()) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject.has("simpleText")) {
                return asJsonObject.get("simpleText").getAsString();
            }
            if (asJsonObject.has("content")) {
                return asJsonObject.get("content").getAsString();
            }
            if (!asJsonObject.has("runs")) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            JsonArray asJsonArray = asJsonObject.getAsJsonArray("runs");
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                JsonElement jsonElement2 = asJsonArray.get(i2);
                if (jsonElement2.isJsonObject()) {
                    JsonObject asJsonObject2 = jsonElement2.getAsJsonObject();
                    if (asJsonObject2.has("text")) {
                        sb.append(asJsonObject2.get("text").getAsString());
                    }
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String w0(JsonElement jsonElement) {
        JsonArray asJsonArray;
        JsonArray asJsonArray2;
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        try {
            if (!jsonElement.isJsonObject()) {
                if (!jsonElement.isJsonArray()) {
                    return VideoStream.RESOLUTION_UNKNOWN;
                }
                JsonArray asJsonArray3 = jsonElement.getAsJsonArray();
                for (int size = asJsonArray3.size() - 1; size >= 0; size--) {
                    String strW0 = w0(asJsonArray3.get(size));
                    if (!strW0.isEmpty()) {
                        return strW0;
                    }
                }
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject.has("sources") && (asJsonArray2 = asJsonObject.getAsJsonArray("sources")) != null && asJsonArray2.size() > 0) {
                JsonObject asJsonObject2 = asJsonArray2.get(asJsonArray2.size() - 1).getAsJsonObject();
                if (asJsonObject2.has("url") && !asJsonObject2.get("url").isJsonNull()) {
                    String asString = asJsonObject2.get("url").getAsString();
                    if (asString.startsWith("//")) {
                        asString = "https:".concat(asString);
                    }
                    if (!asString.isEmpty()) {
                        return asString;
                    }
                }
            }
            if (asJsonObject.has("thumbnails") && (asJsonArray = asJsonObject.getAsJsonArray("thumbnails")) != null && asJsonArray.size() > 0) {
                JsonObject asJsonObject3 = asJsonArray.get(asJsonArray.size() - 1).getAsJsonObject();
                if (asJsonObject3.has("url") && !asJsonObject3.get("url").isJsonNull()) {
                    String asString2 = asJsonObject3.get("url").getAsString();
                    if (asString2.startsWith("//")) {
                        asString2 = "https:".concat(asString2);
                    }
                    if (!asString2.isEmpty()) {
                        return asString2;
                    }
                }
            }
            Iterator it = asJsonObject.keySet().iterator();
            while (it.hasNext()) {
                String strW02 = w0(asJsonObject.get((String) it.next()));
                if (!strW02.isEmpty()) {
                    return strW02;
                }
            }
            return VideoStream.RESOLUTION_UNKNOWN;
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static boolean x0() {
        try {
            Response responseExecute = O0().newCall(new Request.Builder().url("https://www.google.com/generate_204").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/120.0.0.0 Safari/537.36").build()).execute();
            int iCode = responseExecute.code();
            responseExecute.close();
            return iCode == 204 || iCode == 200;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String y0(String str, HashMap map) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            for (Map.Entry entry : map.entrySet()) {
                builderUrl.header((String) entry.getKey(), (String) entry.getValue());
            }
            String str2 = G;
            if (str2 != null && !str2.isEmpty()) {
                builderUrl.header("Cookie", G);
            }
            Response responseExecute = O0().newCall(builderUrl.build()).execute();
            String strString = responseExecute.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute.body().string();
            int iCode = responseExecute.code();
            responseExecute.close();
            SpiderDebug.log("[YouTube] httpGet " + str + " response code=" + iCode + " length=" + strString.length());
            return strString;
        } catch (SocketException e2) {
            StringBuilder sbS = com.github.catvod.spider.merge.b.b.s("[YouTube] httpGet ", str, " proxy connection failed (SocketException), trying direct connection: ");
            sbS.append(e2.getMessage());
            SpiderDebug.log(sbS.toString());
            try {
                OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(15L, timeUnit).readTimeout(20L, timeUnit).writeTimeout(15L, timeUnit).build();
                Request.Builder builderUrl2 = new Request.Builder().url(str);
                for (Map.Entry entry2 : map.entrySet()) {
                    builderUrl2.header((String) entry2.getKey(), (String) entry2.getValue());
                }
                String str3 = G;
                if (str3 != null && !str3.isEmpty()) {
                    builderUrl2.header("Cookie", G);
                }
                Response responseExecute2 = okHttpClientBuild.newCall(builderUrl2.build()).execute();
                String strString2 = responseExecute2.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute2.body().string();
                int iCode2 = responseExecute2.code();
                responseExecute2.close();
                SpiderDebug.log("[YouTube] httpGet " + str + " direct connection success: code=" + iCode2 + " length=" + strString2.length());
                return strString2;
            } catch (Throwable th) {
                StringBuilder sbS2 = com.github.catvod.spider.merge.b.b.s("[YouTube] httpGet ", str, " direct connection also failed: ");
                sbS2.append(th.getClass().getSimpleName());
                sbS2.append(" - ");
                sbS2.append(th.getMessage());
                SpiderDebug.log(sbS2.toString());
                return VideoStream.RESOLUTION_UNKNOWN;
            }
        } catch (SSLException e3) {
            StringBuilder sbS3 = com.github.catvod.spider.merge.b.b.s("[YouTube] httpGet ", str, " proxy SSL failed, trying direct connection: ");
            sbS3.append(e3.getMessage());
            SpiderDebug.log(sbS3.toString());
            try {
                OkHttpClient okHttpClientBuild2 = new OkHttpClient.Builder().connectTimeout(15L, timeUnit).readTimeout(20L, timeUnit).writeTimeout(15L, timeUnit).build();
                Request.Builder builderUrl3 = new Request.Builder().url(str);
                for (Map.Entry entry3 : map.entrySet()) {
                    builderUrl3.header((String) entry3.getKey(), (String) entry3.getValue());
                }
                String str4 = G;
                if (str4 != null && !str4.isEmpty()) {
                    builderUrl3.header("Cookie", G);
                }
                Response responseExecute3 = okHttpClientBuild2.newCall(builderUrl3.build()).execute();
                String strString3 = responseExecute3.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute3.body().string();
                int iCode3 = responseExecute3.code();
                responseExecute3.close();
                SpiderDebug.log("[YouTube] httpGet " + str + " direct connection success: code=" + iCode3 + " length=" + strString3.length());
                return strString3;
            } catch (Throwable th2) {
                StringBuilder sbS4 = com.github.catvod.spider.merge.b.b.s("[YouTube] httpGet ", str, " direct connection also failed: ");
                sbS4.append(th2.getClass().getSimpleName());
                sbS4.append(" - ");
                sbS4.append(th2.getMessage());
                SpiderDebug.log(sbS4.toString());
                return VideoStream.RESOLUTION_UNKNOWN;
            }
        } catch (Throwable th3) {
            StringBuilder sbS5 = com.github.catvod.spider.merge.b.b.s("[YouTube] httpGet ", str, " error: ");
            sbS5.append(th3.getClass().getSimpleName());
            sbS5.append(" - ");
            sbS5.append(th3.getMessage());
            SpiderDebug.log(sbS5.toString());
            th3.printStackTrace();
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String z0(String str, String str2, HashMap map) {
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            for (Map.Entry entry : map.entrySet()) {
                builderUrl.header((String) entry.getKey(), (String) entry.getValue());
            }
            String str3 = G;
            if (str3 != null && !str3.isEmpty()) {
                builderUrl.header("Cookie", G);
            }
            builderUrl.post(RequestBody.create(str2, MediaType.parse("application/json; charset=utf-8")));
            Response responseExecute = O0().newCall(builderUrl.build()).execute();
            String strString = responseExecute.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute.body().string();
            responseExecute.close();
            return strString;
        } catch (Throwable unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public final String B(StreamInfo streamInfo) {
        String str;
        String content;
        try {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            List<AudioStream> audioStreams = streamInfo.getAudioStreams();
            List<VideoStream> videoOnlyStreams = streamInfo.getVideoOnlyStreams();
            if (!z.isEmpty() || A > 0) {
                ArrayList arrayList = new ArrayList();
                for (VideoStream videoStream : videoOnlyStreams) {
                    if (z.isEmpty() || I0(videoStream.getCodec()).equals(z)) {
                        if (A <= 0 || videoStream.getHeight() <= A) {
                            arrayList.add(videoStream);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    videoOnlyStreams = arrayList;
                }
                SpiderDebug.log("[YouTube] video filter codec=" + z + " quality=" + A + " -> " + arrayList.size() + "/" + streamInfo.getVideoOnlyStreams().size() + " video streams");
            }
            boolean zEquals = true;
            if (C.isEmpty() || videoOnlyStreams.size() <= 1) {
                str = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (VideoStream videoStream2 : videoOnlyStreams) {
                    str = null;
                    try {
                        if (I0(videoStream2.getCodec()).equals(C)) {
                            arrayList2.add(videoStream2);
                        } else {
                            arrayList3.add(videoStream2);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.github.catvod.spider.merge.b.b.x(e, new StringBuilder("[YouTube] buildMpdFromNewPipe error: "));
                        return str;
                    }
                }
                str = null;
                if (!arrayList2.isEmpty()) {
                    arrayList2.addAll(arrayList3);
                    SpiderDebug.log("[YouTube] default codec=" + C + " -> " + arrayList2.size() + " preferred first of " + arrayList2.size());
                    videoOnlyStreams = arrayList2;
                }
            }
            if (!B.isEmpty()) {
                ArrayList arrayList4 = new ArrayList();
                for (AudioStream audioStream : audioStreams) {
                    String codec = audioStream.getCodec();
                    if (!B.isEmpty()) {
                        String str2 = "vorbis";
                        if (codec == null) {
                            str2 = VideoStream.RESOLUTION_UNKNOWN;
                        } else {
                            String strTrim = codec.toLowerCase().trim();
                            if (strTrim.startsWith("mp4a")) {
                                str2 = "aac";
                            } else if (strTrim.startsWith("opus")) {
                                str2 = "opus";
                            } else if (!strTrim.startsWith("vorbis")) {
                                str2 = strTrim;
                            }
                        }
                        zEquals = str2.equals(B);
                    }
                    if (zEquals) {
                        arrayList4.add(audioStream);
                    }
                    zEquals = true;
                }
                if (!arrayList4.isEmpty()) {
                    audioStreams = arrayList4;
                }
                SpiderDebug.log("[YouTube] audio filter=" + B + " -> " + arrayList4.size() + "/" + streamInfo.getAudioStreams().size() + " audio streams");
            }
            List<AudioStream> list = audioStreams;
            try {
                List<SubtitlesStream> subtitles = streamInfo.getSubtitles();
                if (subtitles != null && !subtitles.isEmpty()) {
                    d(subtitles, sb3);
                }
            } catch (Exception e3) {
                SpiderDebug.log("[YouTube] subtitle extraction error: " + e3.getMessage());
            }
            if (list.isEmpty() || videoOnlyStreams.isEmpty()) {
                if (!streamInfo.getVideoStreams().isEmpty() && (content = streamInfo.getVideoStreams().get(0).getContent()) != null && !content.isEmpty()) {
                    SpiderDebug.log("[YouTube] NewPipe fallback to progressive url");
                    return content;
                }
                if (!streamInfo.getHlsUrl().isEmpty()) {
                    SpiderDebug.log("[YouTube] NewPipe fallback to HLS url");
                    return streamInfo.getHlsUrl();
                }
                if (streamInfo.getDashMpdUrl().isEmpty()) {
                    SpiderDebug.log("[YouTube] NewPipe: no audio or video streams");
                    return str;
                }
                SpiderDebug.log("[YouTube] NewPipe fallback to dashMpdUrl");
                return streamInfo.getDashMpdUrl();
            }
            for (AudioStream audioStream2 : list) {
                sb2.append(o0(audioStream2, String.format(Locale.getDefault(), "subsegmentAlignment='true' audioSamplingRate='%d'", Integer.valueOf(audioStream2.getItagItem().getSampleRate()))));
            }
            for (VideoStream videoStream3 : videoOnlyStreams) {
                sb.append(p0(videoStream3, String.format(Locale.getDefault(), "height='%d' width='%d' frameRate='%d' maxPlayoutRate='1' startWithSAP='1'", Integer.valueOf(videoStream3.getHeight()), Integer.valueOf(videoStream3.getWidth()), Integer.valueOf(videoStream3.getFps()))));
            }
            long jU0 = U0(streamInfo, list, videoOnlyStreams);
            Locale.getDefault();
            return "data:application/dash+xml;base64," + Base64.encodeToString(("<MPD xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns='urn:mpeg:dash:schema:mpd:2011' xsi:schemaLocation='urn:mpeg:dash:schema:mpd:2011 DASH-MPD.xsd' type='static' mediaPresentationDuration='PT" + jU0 + "S' minBufferTime='PT1.500S' profiles='urn:mpeg:dash:profile:isoff-on-demand:2011'>\n<Period duration='PT" + jU0 + "S' start='PT0S'>\n" + sb3.toString() + "\n" + ((Object) sb) + "\n" + ((Object) sb2) + "\n</Period>\n</MPD>").getBytes(), 2);
        } catch (Exception e4) {
            e = e4;
            str = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String E(java.lang.String r4, java.lang.String r5) throws java.lang.NumberFormatException {
        /*
            r3 = this;
            java.lang.String r0 = "CV@@@"
            if (r5 == 0) goto L17
            java.lang.String r1 = r5.trim()     // Catch: java.lang.Exception -> L3c
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L3c
            if (r1 != 0) goto L17
            java.lang.String r5 = r5.trim()     // Catch: java.lang.NumberFormatException -> L17 java.lang.Exception -> L3c
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L17 java.lang.Exception -> L3c
            goto L18
        L17:
            r5 = 1
        L18:
            java.lang.String r1 = r0.concat(r4)     // Catch: java.lang.Exception -> L3c
            com.github.catvod.spider.Youtube$BrowseResult r1 = r3.m(r5, r4, r1)     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = r1.b     // Catch: java.lang.Exception -> L3c
            if (r2 == 0) goto L3e
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Exception -> L3c
            if (r2 != 0) goto L3e
            java.util.HashMap r2 = com.github.catvod.spider.Youtube.g     // Catch: java.lang.Exception -> L3c
            java.lang.String r4 = r0.concat(r4)     // Catch: java.lang.Exception -> L3c
            int r0 = r5 + 1
            java.lang.String r4 = D(r0, r4)     // Catch: java.lang.Exception -> L3c
            java.lang.String r0 = r1.b     // Catch: java.lang.Exception -> L3c
            r2.put(r4, r0)     // Catch: java.lang.Exception -> L3c
            goto L3e
        L3c:
            r4 = move-exception
            goto L60
        L3e:
            com.github.catvod.spider.merge.a.e r4 = new com.github.catvod.spider.merge.a.e     // Catch: java.lang.Exception -> L3c
            r4.<init>()     // Catch: java.lang.Exception -> L3c
            java.util.ArrayList r0 = r1.a     // Catch: java.lang.Exception -> L3c
            r4.s(r0)     // Catch: java.lang.Exception -> L3c
            java.util.ArrayList r0 = r1.a     // Catch: java.lang.Exception -> L3c
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L3c
            if (r0 == 0) goto L52
            r0 = r5
            goto L54
        L52:
            r0 = 99
        L54:
            r1 = 20
            r2 = 1980(0x7bc, float:2.775E-42)
            r4.g(r5, r0, r1, r2)     // Catch: java.lang.Exception -> L3c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L3c
            return r4
        L60:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "[YouTube] channelVideosPage error: "
            r5.<init>(r0)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.github.catvod.crawler.SpiderDebug.log(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r4 = com.github.catvod.spider.merge.a.e.o(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Youtube.E(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0215 A[PHI: r10
      0x0215: PHI (r10v23 java.lang.String) = 
      (r10v22 java.lang.String)
      (r10v22 java.lang.String)
      (r10v22 java.lang.String)
      (r10v24 java.lang.String)
      (r10v25 java.lang.String)
      (r10v25 java.lang.String)
     binds: [B:122:0x01fa, B:124:0x0202, B:126:0x020a, B:129:0x0213, B:132:0x021d, B:134:0x0225] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void E0() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Youtube.E0():void");
    }

    public final ArrayList H(JsonObject jsonObject) {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayList2 = new ArrayList();
            G(jsonObject, arrayList2);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                h hVarH0 = H0((JsonObject) it.next());
                if (hVarH0 != null) {
                    arrayList.add(hVarH0);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] collectVods error: "));
            return arrayList;
        }
    }

    public final h H0(JsonObject jsonObject) {
        try {
            boolean zHas = jsonObject.has("_type");
            String asString = VideoStream.RESOLUTION_UNKNOWN;
            String asString2 = zHas ? jsonObject.get("_type").getAsString() : VideoStream.RESOLUTION_UNKNOWN;
            h hVar = new h();
            String str = asString2;
            if ("video".equals(asString2)) {
                String asString3 = jsonObject.has(YoutubeParsingHelper.VIDEO_ID) ? jsonObject.get(YoutubeParsingHelper.VIDEO_ID).getAsString() : VideoStream.RESOLUTION_UNKNOWN;
                if (!asString3.isEmpty()) {
                    String strV0 = v0(jsonObject.has("title") ? jsonObject.get("title") : null);
                    String strW0 = w0(jsonObject.has("thumbnail") ? jsonObject.get("thumbnail") : null);
                    String strV02 = v0(jsonObject.has("lengthText") ? jsonObject.get("lengthText") : null);
                    String strV03 = v0(jsonObject.has("publishedTimeText") ? jsonObject.get("publishedTimeText") : null);
                    if (strV03.isEmpty()) {
                        strV03 = jsonObject.has("_published") ? jsonObject.get("_published").getAsString() : VideoStream.RESOLUTION_UNKNOWN;
                    }
                    String asString4 = jsonObject.has("_channel") ? jsonObject.get("_channel").getAsString() : VideoStream.RESOLUTION_UNKNOWN;
                    String strV04 = v0(jsonObject.has("viewCountText") ? jsonObject.get("viewCountText") : null);
                    if (strV04.isEmpty()) {
                        strV04 = jsonObject.has("_viewCount") ? jsonObject.get("_viewCount").getAsString() : VideoStream.RESOLUTION_UNKNOWN;
                    }
                    hVar.f("VD@@@".concat(asString3));
                    if (strV0.isEmpty()) {
                        strV0 = asString3;
                    }
                    hVar.g(strV0);
                    if (strW0.isEmpty()) {
                        strW0 = "https://img.youtube.com/vi/" + asString3 + "/hqdefault.jpg";
                    }
                    hVar.h(Q0(strW0));
                    StringBuilder sb = new StringBuilder();
                    if (!asString4.isEmpty()) {
                        sb.append(asString4);
                    }
                    if (!strV02.isEmpty()) {
                        if (sb.length() > 0) {
                            sb.append(" · ");
                        }
                        sb.append(strV02);
                    }
                    if (!strV04.isEmpty()) {
                        if (sb.length() > 0) {
                            sb.append(" · ");
                        }
                        sb.append(strV04);
                    }
                    hVar.k(sb.toString());
                    if (!strV03.isEmpty()) {
                        hVar.m(strV03);
                    }
                    if (jsonObject.has("clickTrackingParams")) {
                        asString = jsonObject.get("clickTrackingParams").getAsString();
                    } else if (jsonObject.has("trackingParams")) {
                        asString = jsonObject.get("trackingParams").getAsString();
                    }
                    String str2 = asString;
                    if (str2 != null && !str2.isEmpty()) {
                        h.put(asString3, str2);
                        return hVar;
                    }
                    SpiderDebug.log("[YouTube] nodeToVod no tracking, keys=" + jsonObject.keySet().toString());
                    return hVar;
                }
            } else {
                if (!"playlist".equals(str)) {
                    if ("channel".equals(str)) {
                        if (jsonObject.has("channelId")) {
                            asString = jsonObject.get("channelId").getAsString();
                        }
                        String str3 = asString;
                        if (!str3.isEmpty()) {
                            String strV05 = v0(jsonObject.has("title") ? jsonObject.get("title") : null);
                            String strW02 = w0(jsonObject.has("thumbnail") ? jsonObject.get("thumbnail") : null);
                            if (strW02.isEmpty()) {
                                strW02 = w0(jsonObject.has("thumbnails") ? jsonObject.get("thumbnails") : null);
                            }
                            String strV06 = v0(jsonObject.has("subscriberCountText") ? jsonObject.get("subscriberCountText") : null);
                            hVar.f("PD".concat(str3));
                            hVar.l("folder");
                            if (!strV05.isEmpty()) {
                                str3 = strV05;
                            }
                            hVar.g(str3);
                            hVar.h(Q0(strW02));
                            if (strV06.isEmpty()) {
                                strV06 = "频道";
                            }
                            hVar.k(strV06);
                        }
                    }
                    return hVar;
                }
                if (jsonObject.has("playlistId")) {
                    asString = jsonObject.get("playlistId").getAsString();
                }
                String str4 = asString;
                if (!str4.isEmpty()) {
                    String strV07 = v0(jsonObject.has("title") ? jsonObject.get("title") : null);
                    String strW03 = w0(jsonObject.has("thumbnail") ? jsonObject.get("thumbnail") : null);
                    if (strW03.isEmpty()) {
                        strW03 = w0(jsonObject.has("thumbnails") ? jsonObject.get("thumbnails") : null);
                    }
                    String strV08 = v0(jsonObject.has("videoCountText") ? jsonObject.get("videoCountText") : null);
                    hVar.f("PL@@@".concat(str4));
                    if (!strV07.isEmpty()) {
                        str4 = strV07;
                    }
                    hVar.g(str4);
                    hVar.h(Q0(strW03));
                    if (strV08.isEmpty()) {
                        strV08 = "播放列表";
                    }
                    hVar.k(strV08);
                    return hVar;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final h O(String str, String str2) throws NoSuchFieldException, SecurityException {
        String str3;
        String str4;
        try {
            if (str.startsWith("@")) {
                str3 = "https://www.youtube.com/" + str + "/playlists";
            } else {
                str3 = "https://www.youtube.com/channel/" + str + "/playlists";
            }
            HashMap map = new HashMap();
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            ArrayList arrayListH = H(Z(y0(str3, map)));
            if (arrayListH.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = arrayListH.iterator();
            String strJ0 = VideoStream.RESOLUTION_UNKNOWN;
            while (it.hasNext()) {
                h hVar = (h) it.next();
                try {
                    Field declaredField = h.class.getDeclaredField("b");
                    declaredField.setAccessible(true);
                    str4 = (String) declaredField.get(hVar);
                } catch (Exception unused) {
                }
                if (str4 == null) {
                    str4 = VideoStream.RESOLUTION_UNKNOWN;
                } else if (str4.contains("@@@")) {
                    str4 = str4.split("@@@")[1];
                }
                if (!str4.isEmpty()) {
                    arrayList.add(i0(hVar).replace("$", "＄").replace("#", "＃") + "$" + ("https://www.youtube.com/playlist?list=" + str4));
                    if (strJ0.isEmpty()) {
                        strJ0 = j0(hVar);
                    }
                }
            }
            h hVar2 = new h();
            hVar2.f(str2);
            hVar2.g("频道播放列表");
            hVar2.h(Q0(strJ0));
            hVar2.d("频道播放列表，共 " + arrayListH.size() + " 个");
            hVar2.k("共" + arrayListH.size() + "个列表");
            hVar2.i("YouTube");
            StringBuilder sb = new StringBuilder();
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                Object next = it2.next();
                while (true) {
                    sb.append((CharSequence) next);
                    if (!it2.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) "#");
                    next = it2.next();
                }
            }
            hVar2.j(sb.toString());
            return hVar2;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] detailChannelPlaylists error: "));
            return null;
        }
    }

    public final h P(String str, String str2) {
        String str3;
        try {
            if (str.startsWith("@")) {
                str3 = "https://www.youtube.com/" + str + "/videos";
            } else {
                str3 = "https://www.youtube.com/channel/" + str + "/videos";
            }
            HashMap map = new HashMap();
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            ArrayList arrayListH = H(Z(y0(str3, map)));
            if (arrayListH.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            String strJ0 = VideoStream.RESOLUTION_UNKNOWN;
            Iterator it = arrayListH.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                String strG0 = g0(hVar);
                if (!strG0.isEmpty() && C0(strG0)) {
                    arrayList.add(i0(hVar).replace("$", "＄").replace("#", "＃") + "$" + ("https://www.youtube.com/watch?v=" + strG0));
                    if (strJ0.isEmpty()) {
                        strJ0 = j0(hVar);
                    }
                }
            }
            h hVar2 = new h();
            hVar2.f(str2);
            hVar2.g("频道视频");
            hVar2.h(Q0(strJ0));
            hVar2.d("频道最新视频，共 " + arrayListH.size() + " 条");
            hVar2.k("共" + arrayListH.size() + "条");
            hVar2.i("YouTube");
            StringBuilder sb = new StringBuilder();
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                Object next = it2.next();
                while (true) {
                    sb.append((CharSequence) next);
                    if (!it2.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) "#");
                    next = it2.next();
                }
            }
            hVar2.j(sb.toString());
            return hVar2;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] detailChannelVideos error: "));
            return null;
        }
    }

    public final String P0(String str) {
        try {
            String strEncodeToString = Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 11);
            return (Proxy.getUrl() + "?do=csp&siteKey=" + ((Spider) this).siteKey + "&type=media&u=" + strEncodeToString).replace("&", "&amp;");
        } catch (Throwable unused) {
            return str.replace("&", "&amp;");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.merge.a.h Q(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Youtube.Q(java.lang.String, java.lang.String):com.github.catvod.spider.merge.a.h");
    }

    public final String Q0(String str) {
        String str2;
        if (str == null || str.isEmpty() || (str2 = E) == null || str2.isEmpty()) {
            return str;
        }
        if (!str.contains("youtube.com") && !str.contains("ytimg") && !str.contains("ggpht")) {
            return str;
        }
        try {
            return Proxy.getUrl() + "?do=csp&siteKey=" + ((Spider) this).siteKey + "&type=img&u=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 11);
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.merge.a.h R(java.lang.String r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 912
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Youtube.R(java.lang.String, java.lang.String):com.github.catvod.spider.merge.a.h");
    }

    public final String T0() {
        try {
            return F.isEmpty() ? e.o(new ArrayList()) : F.startsWith("LIST:") ? e.o(s(F.substring(5))) : e.o(u(1, F, "home_recommend", VideoStream.RESOLUTION_UNKNOWN, VideoStream.RESOLUTION_UNKNOWN).a);
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] recommendVideos error: " + e2.getMessage());
            return e.o(new ArrayList());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0245  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String Z0(int r24, java.lang.String r25) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 2482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.Youtube.Z0(int, java.lang.String):java.lang.String");
    }

    public String action(String str) throws Throwable {
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] action error: "));
        }
        if (str == null) {
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if (str.startsWith("set:codec:")) {
            f(str.substring(10));
            SettingsUI.refreshCategory();
            return e.f("已设置视频格式：" + L());
        }
        if (str.startsWith("set:quality:")) {
            String strSubstring = str.substring(12);
            A = "all".equals(strSubstring) ? -1 : K0(strSubstring);
            Y0();
            YoutubeVr.setQualityFilter(A);
            com.github.catvod.spider.merge.g1.a.e("已设置画质：".concat(N()));
            SettingsUI.refreshCategory();
            return e.f("已设置画质：".concat(N()));
        }
        if (str.startsWith("set:audio:")) {
            e(str.substring(10));
            SettingsUI.refreshCategory();
            StringBuilder sb = new StringBuilder("已设置音质：");
            sb.append(B.isEmpty() ? "全部" : B.toUpperCase());
            return e.f(sb.toString());
        }
        if (str.startsWith("set:default:")) {
            g(str.substring(12));
            SettingsUI.refreshCategory();
            StringBuilder sb2 = new StringBuilder("已设置默认起播格式：");
            sb2.append(C.isEmpty() ? "不指定" : C.toUpperCase());
            return e.f(sb2.toString());
        }
        int i2 = 1;
        if ("toggle:newpipe_fallback".equals(str)) {
            J = !J;
            SpiderDebug.log("[YouTube] NewPipe Fallback toggled: " + J);
            SettingsUI.refreshCategory();
            return e.f("NewPipe 备用 ".concat(J ? "已启用" : "已禁用"));
        }
        if ("reload:json".equals(str)) {
            E0();
            return e.f("已重新加载配置：" + M());
        }
        if ("open:search".equals(str)) {
            SettingsUI.searchDialog("Youtube搜查", "输入关键词", new String[]{"影片", "频道", "列表", "短剧"}, N, new com.github.catvod.spider.merge.b0.a(11), new q(this, i2));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        int i3 = 0;
        if ("clear:search".equals(str)) {
            I = VideoStream.RESOLUTION_UNKNOWN;
            N = 0;
            SettingsUI.refreshCategory();
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        int i4 = 5;
        if ("pick:json".equals(str)) {
            SettingsUI.pickFile(new q(this, i4));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        int i5 = 6;
        int i6 = 7;
        if ("input:json".equals(str)) {
            SettingsUI.inputWithQR("输入在线 json URL", "http://服务器/xxx.json", ("@default".equals(D) || "@none".equals(D) || D.isEmpty()) ? VideoStream.RESOLUTION_UNKNOWN : D, new q(this, i5), new q(this, i6));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("hint:json".equals(str)) {
            return e.f("当前配置：" + M());
        }
        if ("hint:proxy".equals(str)) {
            StringBuilder sb3 = new StringBuilder("当前 proxy：");
            sb3.append(E.isEmpty() ? "未设置（直连）" : E);
            return e.f(sb3.toString());
        }
        if ("hint:localfile".equals(str)) {
            StringBuilder sb4 = new StringBuilder("当前本地档案：");
            sb4.append(ClashCore.getLocalFile().isEmpty() ? "未设置（使用订阅地址）" : ClashCore.getLocalFile());
            return e.f(sb4.toString());
        }
        if ("hint:version".equals(str)) {
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("set:proxy".equals(str)) {
            SettingsUI.input("设置 proxy", "如 http://127.0.0.1:7890 或 socks5://127.0.0.1:1080（留空=不使用）", E, new com.github.catvod.spider.merge.b0.a(this, 7));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("set:subscribe".equals(str)) {
            SettingsUI.inputWithQR("设置订阅地址", "如 https://sub.maflya.com/xxx（clash 订阅）", ClashCore.getSubscribeUrl(), new com.github.catvod.spider.merge.b0.a(this, 8), new q(this, 8));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("set:localfile".equals(str)) {
            SettingsUI.input("设置本地档案", "如 /sdcard/Download/clash.yaml（留空则使用订阅地址）\n\n用途：订阅源需代理时，把订阅内容存成本地文件", ClashCore.getLocalFile(), new com.github.catvod.spider.merge.b0.a(this, 9));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("pick:localfile".equals(str)) {
            SettingsUI.pickFile(new com.github.catvod.spider.merge.b0.a(this, 10));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if (str.startsWith("set:mirror:")) {
            ClashCore.setMirrorIndex(K0(str.substring(11)));
            Y0();
            com.github.catvod.spider.merge.g1.a.e("已选择镜像：" + ClashCore.getMirrorLabel());
            SettingsUI.refreshCategory();
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        Runnable runnable = null;
        if ("proxy:fetch".equals(str)) {
            if (!ClashCore.isArchSupported()) {
                return e.f("设备架构不支持代理功能（mihomo 仅支持 ARM/x86_64 架构）");
            }
            if (ClashCore.getSubscribeUrl().isEmpty() && ClashCore.getLocalFile().isEmpty()) {
                return e.f("请先设置订阅地址或本地档案");
            }
            boolean zIsEmpty = ClashCore.getLocalFile().isEmpty();
            boolean zIsEmpty2 = ClashCore.getSubscribeUrl().isEmpty();
            if (!zIsEmpty && !zIsEmpty2) {
                Init.post(new v(this, i4));
                return e.f(VideoStream.RESOLUTION_UNKNOWN);
            }
            com.github.catvod.spider.merge.g1.a.e("正在拉取节点 ...");
            Init.execute(new c0(runnable, i3));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        int i7 = 2;
        if ("proxy:start".equals(str)) {
            boolean zIsEmpty3 = ClashCore.getLocalFile().isEmpty();
            boolean zIsEmpty4 = ClashCore.getSubscribeUrl().isEmpty();
            if (!zIsEmpty3 && !zIsEmpty4) {
                Init.post(new v(this, i6));
                return e.f(VideoStream.RESOLUTION_UNKNOWN);
            }
            String strS = S();
            if (strS.isEmpty()) {
                d1();
                return e.f(VideoStream.RESOLUTION_UNKNOWN);
            }
            Init.post(new a0(this, strS, i7));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("proxy:stop".equals(str)) {
            ClashCore.stop();
            E = VideoStream.RESOLUTION_UNKNOWN;
            Y0();
            i();
            com.github.catvod.spider.merge.g1.a.e("代理已停止（直连）");
            SettingsUI.refreshCategory();
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("proxy:delete".equals(str)) {
            if (!ClashCore.isInstalled()) {
                com.github.catvod.spider.merge.g1.a.e("内核未安装，无需删除");
                return e.f(VideoStream.RESOLUTION_UNKNOWN);
            }
            com.github.catvod.spider.merge.g1.a.e("正在删除内核 ...");
            Init.execute(new i0(1));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("proxy:redownload".equals(str)) {
            com.github.catvod.spider.merge.g1.a.e("正在删除旧内核并重新下载（约 20MB）...");
            Init.execute(new Runnable(this) { // from class: com.github.catvod.spider.a
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z2 = Youtube.e;
                    ClashCore.deleteKernel();
                    Init.post(new d0(0, ClashCore.install(new Youtube.AnonymousClass2())));
                }
            });
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if (str.startsWith("proxy:node:")) {
            int iK0 = K0(str.substring(11));
            List<String> cachedNodes = ClashCore.getCachedNodes();
            String str2 = iK0 < 0 ? "DIRECT" : (iK0 < 0 || iK0 >= cachedNodes.size()) ? VideoStream.RESOLUTION_UNKNOWN : cachedNodes.get(iK0);
            if (str2.isEmpty()) {
                return e.f(VideoStream.RESOLUTION_UNKNOWN);
            }
            ClashCore.setSelectedNode(str2);
            Y0();
            if ("DIRECT".equals(str2)) {
                ClashCore.stop();
                E = VideoStream.RESOLUTION_UNKNOWN;
                Y0();
                i();
                com.github.catvod.spider.merge.g1.a.e("已选择直连，代理已停止");
                SettingsUI.refreshCategory();
                return e.f(VideoStream.RESOLUTION_UNKNOWN);
            }
            if (ClashCore.isRunning()) {
                com.github.catvod.spider.merge.g1.a.e("正在切换节点 ...");
                Init.execute(new r(str2, i7));
                return e.f(VideoStream.RESOLUTION_UNKNOWN);
            }
            com.github.catvod.spider.merge.g1.a.e("已选节点：" + str2 + "（启动代理后生效）");
            SettingsUI.refreshCategory();
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        int i8 = 4;
        if ("proxy:test".equals(str)) {
            String selectedNode = ClashCore.getSelectedNode();
            if (selectedNode.isEmpty()) {
                return e.f("请先选择节点");
            }
            if (!ClashCore.isRunning()) {
                com.github.catvod.spider.merge.g1.a.e("正在启动代理 ...");
                if (!ClashCore.start()) {
                    return e.f("代理启动失败");
                }
            }
            com.github.catvod.spider.merge.g1.a.e("正在测试 ...");
            Init.execute(new r(this, selectedNode, i8));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("proxy:testall".equals(str)) {
            if (!ClashCore.isRunning()) {
                com.github.catvod.spider.merge.g1.a.e("正在启动代理 ...");
                if (!ClashCore.start()) {
                    return e.f("代理启动失败");
                }
            }
            if (ClashCore.getCachedNodes().isEmpty()) {
                return e.f("请先「更新节点」");
            }
            com.github.catvod.spider.merge.g1.a.e("正在测速全部节点 ...");
            ClashCore.testAllNodes(new p(4));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("proxy:diag:all".equals(str)) {
            SettingsUI.confirm("诊断测试", "选择诊断类型：\n\n1. 快速诊断：检查环境和配置\n2. 测试视频：输入 videoId 测试\n3. 测试节点：测试当前节点延迟\n\n点击继续选择具体操作", new v(this, i3), null);
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("check:ip".equals(str)) {
            com.github.catvod.spider.merge.g1.a.e("正在检测出口 IP ...");
            Init.execute(new p(this, 5));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("logout:cookie".equals(str)) {
            G = VideoStream.RESOLUTION_UNKNOWN;
            H = false;
            Y0();
            com.github.catvod.spider.merge.g1.a.e("已登出（Cookie 已清除）");
            SettingsUI.refreshCategory();
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("check:login".equals(str)) {
            String str3 = G;
            if (str3 != null && !str3.isEmpty()) {
                com.github.catvod.spider.merge.g1.a.e("正在验证登录状态 ...");
                Init.execute(new p(this, 6));
                return e.f(VideoStream.RESOLUTION_UNKNOWN);
            }
            com.github.catvod.spider.merge.g1.a.e("未设置 Cookie，未登录");
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("proxy:diag:quick".equals(str)) {
            com.github.catvod.spider.merge.g1.a.e("正在自诊断 ...");
            Init.execute(new p(this, 7));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("proxy:diag:video".equals(str)) {
            SettingsUI.input("测试具体视频", "输入视频 ID 或完整 URL\n例如: jNQXAC9IVRw 或 https://www.youtube.com/watch?v=jNQXAC9IVRw", VideoStream.RESOLUTION_UNKNOWN, new q(this, i7));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("oauth:login".equals(str)) {
            com.github.catvod.spider.merge.g1.a.e("正在请求 OAuth 验证码 ...");
            Init.execute(new v(this, i7));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if (str.startsWith("sub:")) {
            f1(str.substring(4), true);
            SettingsUI.refreshCategory();
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if (str.startsWith("unsub:")) {
            f1(str.substring(6), false);
            SettingsUI.refreshCategory();
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        if ("set:cookie".equals(str)) {
            SettingsUI.inputWithQR("登录 YouTube（Cookie）", "粘贴浏览器 Cookie 头，如 SAPISID=xxx; __Secure-3PAPISID=xxx; LOGIN_INFO=xxx（留空=清除登录）", G, new q(this, 3), new q(this, i8));
            return e.f(VideoStream.RESOLUTION_UNKNOWN);
        }
        return e.f(VideoStream.RESOLUTION_UNKNOWN);
    }

    public final ArrayList c0(JsonObject jsonObject) {
        h hVarH0;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = k0(jsonObject, "twoColumnWatchNextResults").iterator();
            while (it.hasNext()) {
                JsonObject jsonObject2 = (JsonObject) it.next();
                ArrayList arrayList2 = new ArrayList();
                G(jsonObject2, arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    JsonObject jsonObject3 = (JsonObject) it2.next();
                    if ("video".equals(jsonObject3.has("_type") ? jsonObject3.get("_type").getAsString() : VideoStream.RESOLUTION_UNKNOWN) && (hVarH0 = H0(jsonObject3)) != null) {
                        arrayList.add(hVarH0);
                    }
                }
            }
            return arrayList;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] extractRelatedVideos error: "));
            return arrayList;
        }
    }

    public String categoryContent(String str, String str2, boolean z2, HashMap<String, String> map) throws NumberFormatException {
        int i2;
        try {
            SpiderDebug.log("[YouTube] categoryContent tid=" + str + " pg=" + str2 + " extend=" + map);
            if (str != null && str.startsWith("SET")) {
                try {
                    i2 = Integer.parseInt(str2);
                } catch (Exception unused) {
                    i2 = 1;
                }
                return Z0(i2, str);
            }
            if ("REC@@recommend".equals(str)) {
                return T0();
            }
            if (str != null && str.startsWith("SUB@@")) {
                return E(str.substring(5), str2);
            }
            if (str != null && str.startsWith("UNSUB@@")) {
                return E(str.substring(7), str2);
            }
            int i3 = Integer.parseInt(str2);
            if ("HIS@@folder".equals(str)) {
                return G0();
            }
            boolean zEquals = "HIS@@history".equals(str);
            HashMap map2 = g;
            if (zEquals) {
                BrowseResult browseResultP = p(i3, str);
                String str3 = browseResultP.b;
                if (str3 != null && !str3.isEmpty()) {
                    map2.put(D(i3 + 1, str), browseResultP.b);
                }
                e eVar = new e();
                eVar.s(browseResultP.a);
                eVar.g(i3, browseResultP.a.isEmpty() ? i3 : 99, 20, 1980);
                return eVar.toString();
            }
            if ("HIS@@liked".equals(str)) {
                BrowseResult browseResultQ = q(i3, str);
                String str4 = browseResultQ.b;
                if (str4 != null && !str4.isEmpty()) {
                    map2.put(D(i3 + 1, str), browseResultQ.b);
                }
                e eVar2 = new e();
                eVar2.s(browseResultQ.a);
                eVar2.g(i3, browseResultQ.a.isEmpty() ? i3 : 99, 20, 1980);
                return eVar2.toString();
            }
            if ("HIS@@watchlater".equals(str)) {
                BrowseResult browseResultZ = z(i3, str);
                String str5 = browseResultZ.b;
                if (str5 != null && !str5.isEmpty()) {
                    map2.put(D(i3 + 1, str), browseResultZ.b);
                }
                e eVar3 = new e();
                eVar3.s(browseResultZ.a);
                eVar3.g(i3, browseResultZ.a.isEmpty() ? i3 : 99, 20, 1980);
                return eVar3.toString();
            }
            if ("HIS@@subsfolder".equals(str)) {
                return e1();
            }
            if ("HIS@@subchannels".equals(str)) {
                BrowseResult browseResultX = x(i3, str);
                String str6 = browseResultX.b;
                if (str6 != null && !str6.isEmpty()) {
                    map2.put(D(i3 + 1, str), browseResultX.b);
                }
                e eVar4 = new e();
                eVar4.s(browseResultX.a);
                eVar4.g(i3, browseResultX.a.isEmpty() ? i3 : 99, 20, 1980);
                return eVar4.toString();
            }
            if ("HIS@@subscriptions".equals(str)) {
                BrowseResult browseResultY = y(i3, str);
                String str7 = browseResultY.b;
                if (str7 != null && !str7.isEmpty()) {
                    map2.put(D(i3 + 1, str), browseResultY.b);
                }
                e eVar5 = new e();
                eVar5.s(browseResultY.a);
                eVar5.g(i3, browseResultY.a.isEmpty() ? i3 : 99, 20, 1980);
                return eVar5.toString();
            }
            String str8 = map != null ? map.get("tid") : null;
            String str9 = map != null ? map.get("date") : null;
            String strW0 = (str8 == null || str8.isEmpty()) ? W0(str) : W0(str8);
            SpiderDebug.log("[YouTube] resolved rawKey=".concat(strW0));
            BrowseResult browseResultJ = j(strW0, i3, str, str9);
            String str10 = browseResultJ.b;
            if (str10 != null && !str10.isEmpty()) {
                map2.put(D(i3 + 1, str), browseResultJ.b);
            }
            e eVar6 = new e();
            eVar6.s(browseResultJ.a);
            String str11 = browseResultJ.b;
            if (str11 == null || str11.isEmpty()) {
                i = i3;
            }
            eVar6.g(i3, i, 20, 1980);
            return eVar6.toString();
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] categoryContent error: " + e2.getMessage());
            e2.printStackTrace();
            return e.o(new ArrayList());
        }
    }

    public final void d1() {
        Init.execute(new Runnable() { // from class: com.github.catvod.spider.b
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                boolean z2 = Youtube.e;
                if (!ClashCore.isInstalled()) {
                    Init.post(new p(28));
                    if (!ClashCore.install(new Youtube.AnonymousClass1())) {
                        Init.post(new p(29));
                        return;
                    }
                    Init.post(new i0(0));
                }
                StringBuilder sb = new StringBuilder();
                Init.post(new b0(this.a, ClashCore.start(sb), sb));
            }
        });
    }

    public String detailContent(List<String> list) {
        try {
            String str = list.get(0);
            SpiderDebug.log("[YouTube] detailContent id=" + str);
            String strSubstring = str.substring(0, Math.min(5, str.length()));
            String str2 = str.contains("@@@") ? str.split("@@@", 2)[1] : str;
            h hVarR = (strSubstring.startsWith("VD") || strSubstring.startsWith("ZB") || strSubstring.startsWith("DS")) ? R(str2, str) : strSubstring.startsWith("PL") ? Q(str2, str) : (strSubstring.startsWith("CV") || strSubstring.startsWith("PD")) ? P(str2, str) : strSubstring.startsWith("CP") ? O(str2, str) : R(str, str);
            return hVarR == null ? e.o(new ArrayList()) : e.j(hVarR);
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] detailContent error: " + e2.getMessage());
            e2.printStackTrace();
            return e.o(new ArrayList());
        }
    }

    public final void h(String str) throws NumberFormatException {
        D = str;
        Y0();
        E0();
        com.github.catvod.spider.merge.g1.a.e("已设置配置：" + M());
    }

    public String homeContent(boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.github.catvod.spider.merge.a.a("SET", "设置", "1"));
        if (!F.isEmpty()) {
            arrayList.add(new com.github.catvod.spider.merge.a.a("REC@@recommend", "推荐", "1"));
        }
        if (H) {
            arrayList.add(new com.github.catvod.spider.merge.a.a("HIS@@folder", "▶ 我的", "1"));
        }
        arrayList.addAll(this.b);
        return e.m(arrayList, this.c);
    }

    public String homeVideoContent() {
        return e.o(new ArrayList());
    }

    public void init(Context context, String str) throws NumberFormatException {
        SpiderDebug.log("[YouTube] init extend=".concat(str == null ? "null" : str.substring(0, Math.min(100, str.length()))));
        Init.init(context);
        B0();
        if (str == null) {
            str = VideoStream.RESOLUTION_UNKNOWN;
        }
        this.a = str;
        E0();
    }

    public final BrowseResult j(String str, int i2, String str2, String str3) {
        SpiderDebug.log("[YouTube] browse called: rawKey=" + str + " page=" + i2);
        try {
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] browse exception: " + e2.getClass().getName() + " - " + e2.getMessage());
            e2.printStackTrace();
        }
        if (str.startsWith("VD_")) {
            String strSubstring = str.substring(3);
            SpiderDebug.log("[YouTube] routing to browseSearch, keyword=".concat(strSubstring));
            return u(i2, strSubstring, str2, str3, VideoStream.RESOLUTION_UNKNOWN);
        }
        if (str.startsWith("ZB_")) {
            return u(i2, str.substring(3), str2, str3, "live");
        }
        if (str.startsWith("DS_")) {
            return u(i2, str.substring(3), str2, str3, ChannelTabs.SHORTS);
        }
        if (str.startsWith("LIST_")) {
            return r(i2, str.substring(5));
        }
        if (!str.startsWith("VD@@@") && !str.startsWith("ZB@@@") && !str.startsWith("DS@@@")) {
            if (str.startsWith("PL@@@")) {
                String strSubstring2 = str.substring(5);
                SpiderDebug.log("[YouTube] routing to browsePlaylist, id=".concat(strSubstring2));
                return t(i2, strSubstring2, str2);
            }
            if (str.startsWith("CV@@@")) {
                String strSubstring3 = str.substring(5);
                SpiderDebug.log("[YouTube] routing to browseChannelVideos, id=".concat(strSubstring3));
                return m(i2, strSubstring3, str2);
            }
            if (str.startsWith("CP@@@")) {
                String strSubstring4 = str.substring(5);
                SpiderDebug.log("[YouTube] routing to browseChannelPlaylists, id=".concat(strSubstring4));
                return l(i2, strSubstring4, str2);
            }
            if (!str.startsWith("PD@@@")) {
                SpiderDebug.log("[YouTube] browse: no route matched, returning empty");
                return new BrowseResult();
            }
            String strSubstring5 = str.substring(5);
            SpiderDebug.log("[YouTube] routing to browseChannelHome, value=".concat(strSubstring5));
            return (strSubstring5.startsWith("UC") || strSubstring5.startsWith("@")) ? i2 > 1 ? new BrowseResult() : k(strSubstring5) : u(i2, strSubstring5, str2, str3, "channel");
        }
        String strSubstring6 = str.substring(5);
        SpiderDebug.log("[YouTube] routing to browseSingleVideo, id=".concat(strSubstring6));
        return w(strSubstring6);
    }

    public final BrowseResult k(String str) {
        BrowseResult browseResult = new BrowseResult();
        h hVar = new h();
        hVar.f("CV@@@".concat(str));
        hVar.l("folder");
        hVar.g("频道视频");
        hVar.h(Q0("https://www.youtube.com/img/desktop/yt_1200.png"));
        hVar.k("浏览频道全部视频");
        h hVar2 = new h();
        hVar2.f("CP@@@".concat(str));
        hVar2.l("folder");
        hVar2.g("频道列表");
        hVar2.h(Q0("https://www.youtube.com/img/desktop/yt_1200.png"));
        hVar2.k("浏览频道播放列表");
        browseResult.a.add(hVar);
        browseResult.a.add(hVar2);
        return browseResult;
    }

    public final BrowseResult l(int i2, String str, String str2) {
        String strW;
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        boolean z2 = true;
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseChannelPlaylists error: "));
        }
        if (i2 <= 1) {
            String str3 = str.startsWith("@") ? "https://www.youtube.com/" + str + "/playlists" : "https://www.youtube.com/channel/" + str + "/playlists";
            HashMap map2 = new HashMap();
            map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            String strY0 = y0(str3, map2);
            JsonObject jsonObjectZ = Z(strY0);
            browseResult.a = H(jsonObjectZ);
            try {
                strW = W(jsonObjectZ);
            } catch (Exception unused) {
                strW = null;
            }
            browseResult.b = strW;
            StringBuilder sb = new StringBuilder("[YouTube] browseChannelPlaylists url=");
            sb.append(str3);
            sb.append(" pageLen=");
            sb.append(strY0.length());
            sb.append(" vods=");
            sb.append(browseResult.a.size());
            sb.append(" token=");
            if (browseResult.b == null) {
                z2 = false;
            }
            sb.append(z2);
            SpiderDebug.log(sb.toString());
            return browseResult;
        }
        String str4 = (String) map.get(D(i2, str2));
        if (str4 != null) {
            BrowseResult browseResultN = n(str4, "browse");
            String str5 = browseResultN.b;
            if (str5 == null || str5.isEmpty()) {
                return browseResultN;
            }
            map.put(D(i2 + 1, str2), browseResultN.b);
            return browseResultN;
        }
        SpiderDebug.log("[YouTube] browseChannelPlaylists: no token for page " + i2 + ", fetching from page 1");
        BrowseResult browseResultL = l(1, str, str2);
        String str6 = browseResultL.b;
        if (str6 != null && !str6.isEmpty()) {
            map.put(D(2, str2), browseResultL.b);
        }
        for (int i3 = 2; i3 <= i2; i3++) {
            String str7 = browseResultL.b;
            if (str7 == null) {
                break;
            }
            browseResultL = n(str7, "browse");
            map.put(D(i3, str2), str7);
            String str8 = browseResultL.b;
            if (str8 != null && !str8.isEmpty()) {
                map.put(D(i3 + 1, str2), browseResultL.b);
            }
        }
        return browseResultL;
    }

    public final BrowseResult m(int i2, String str, String str2) {
        String strW;
        String str3;
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        boolean z2 = true;
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseChannelVideos error: "));
        }
        if (i2 > 1) {
            String str4 = (String) map.get(D(i2, str2));
            if (str4 != null) {
                BrowseResult browseResultN = n(str4, "browse");
                String str5 = browseResultN.b;
                if (str5 == null || str5.isEmpty()) {
                    return browseResultN;
                }
                map.put(D(i2 + 1, str2), browseResultN.b);
                return browseResultN;
            }
            SpiderDebug.log("[YouTube] browseChannelVideos: no token for page " + i2 + ", fetching from page 1");
            BrowseResult browseResultM = m(1, str, str2);
            String str6 = browseResultM.b;
            if (str6 != null && !str6.isEmpty()) {
                map.put(D(2, str2), browseResultM.b);
            }
            for (int i3 = 2; i3 <= i2; i3++) {
                String str7 = browseResultM.b;
                if (str7 == null) {
                    break;
                }
                browseResultM = n(str7, "browse");
                map.put(D(i3, str2), str7);
                String str8 = browseResultM.b;
                if (str8 != null && !str8.isEmpty()) {
                    map.put(D(i3 + 1, str2), browseResultM.b);
                }
            }
            return browseResultM;
        }
        String str9 = str.startsWith("@") ? "https://www.youtube.com/" + str + "/videos" : "https://www.youtube.com/channel/" + str + "/videos";
        HashMap map2 = new HashMap();
        map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        String strY0 = y0(str9, map2);
        JsonObject jsonObjectZ = Z(strY0);
        browseResult.a = H(jsonObjectZ);
        try {
            strW = W(jsonObjectZ);
        } catch (Exception unused) {
            strW = null;
        }
        browseResult.b = strW;
        if (i2 == 1 && (str3 = r) != null && !str3.isEmpty()) {
            boolean z3 = n.contains(str) || d0(jsonObjectZ);
            h hVar = new h();
            hVar.f("SUBACT@@".concat(str));
            hVar.g(z3 ? "退订该频道" : "订阅该频道");
            hVar.k(z3 ? "点击退订" : "点击订阅");
            hVar.b(z3 ? "unsub:".concat(str) : "sub:".concat(str));
            hVar.h(a1("#DC2626", z3 ? "退" : "订"));
            browseResult.a.add(0, hVar);
        }
        HashMap map3 = new HashMap();
        K(jsonObjectZ, map3);
        StringBuilder sb = new StringBuilder("[YouTube] browseChannelVideos url=");
        sb.append(str9);
        sb.append(" pageLen=");
        sb.append(strY0.length());
        sb.append(" vods=");
        sb.append(browseResult.a.size());
        sb.append(" token=");
        if (browseResult.b == null) {
            z2 = false;
        }
        sb.append(z2);
        sb.append(" rendererKeys=");
        sb.append(map3);
        SpiderDebug.log(sb.toString());
        return browseResult;
    }

    public final BrowseResult n(String str, String str2) {
        String strW;
        BrowseResult browseResult = new BrowseResult();
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("context", A());
            jsonObject.addProperty("continuation", str);
            JsonObject jsonObjectM0 = M0(jsonObject, str2);
            browseResult.a = H(jsonObjectM0);
            try {
                strW = W(jsonObjectM0);
            } catch (Exception unused) {
                strW = null;
            }
            browseResult.b = strW;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseContinuation error: "));
        }
        return browseResult;
    }

    public final String o0(AudioStream audioStream, String str) {
        int itag = audioStream.getItag();
        int bitrate = audioStream.getBitrate();
        return String.format(Locale.getDefault(), "<AdaptationSet lang='chi'>\n<ContentComponent contentType='%s'/>\n<Representation id='%d' bandwidth='%d' codecs='%s' mimeType='%s' %s>\n<BaseURL>%s</BaseURL>\n<SegmentBase indexRange='%s'>\n<Initialization range='%s'/>\n</SegmentBase>\n</Representation>\n</AdaptationSet>", "audio", Integer.valueOf(itag), Integer.valueOf(bitrate), audioStream.getCodec(), audioStream.getFormat().getMimeType(), str, P0(audioStream.getContent()), audioStream.getIndexStart() + "-" + audioStream.getIndexEnd(), audioStream.getInitStart() + "-" + audioStream.getInitEnd());
    }

    public final BrowseResult p(int i2, String str) {
        String strW;
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        boolean z2 = true;
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseHistory error: "));
        }
        if (i2 <= 1) {
            HashMap map2 = new HashMap();
            map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            String strY0 = y0("https://www.youtube.com/feed/history", map2);
            JsonObject jsonObjectZ = Z(strY0);
            browseResult.a = H(jsonObjectZ);
            try {
                strW = W(jsonObjectZ);
            } catch (Exception unused) {
                strW = null;
            }
            browseResult.b = strW;
            StringBuilder sb = new StringBuilder("[YouTube] browseHistory pageLen=");
            sb.append(strY0.length());
            sb.append(" vods=");
            sb.append(browseResult.a.size());
            sb.append(" vr=");
            sb.append(k0(jsonObjectZ, "videoRenderer").size());
            sb.append(" compact=");
            sb.append(k0(jsonObjectZ, "compactVideoRenderer").size());
            sb.append(" token=");
            if (browseResult.b == null) {
                z2 = false;
            }
            sb.append(z2);
            SpiderDebug.log(sb.toString());
            return browseResult;
        }
        String str2 = (String) map.get(D(i2, str));
        if (str2 != null) {
            BrowseResult browseResultN = n(str2, "browse");
            String str3 = browseResultN.b;
            if (str3 == null || str3.isEmpty()) {
                return browseResultN;
            }
            map.put(D(i2 + 1, str), browseResultN.b);
            return browseResultN;
        }
        BrowseResult browseResultP = p(1, str);
        if (browseResultP.b != null) {
            map.put(D(2, str), browseResultP.b);
        }
        for (int i3 = 2; i3 <= i2; i3++) {
            String str4 = browseResultP.b;
            if (str4 == null) {
                break;
            }
            browseResultP = n(str4, "browse");
            map.put(D(i3, str), str4);
            if (browseResultP.b != null) {
                map.put(D(i3 + 1, str), browseResultP.b);
            }
        }
        return browseResultP;
    }

    public final String p0(VideoStream videoStream, String str) {
        int itag = videoStream.getItag();
        int bitrate = videoStream.getBitrate();
        return String.format(Locale.getDefault(), "<AdaptationSet lang='chi'>\n<ContentComponent contentType='%s'/>\n<Representation id='%d' bandwidth='%d' codecs='%s' mimeType='%s' %s>\n<BaseURL>%s</BaseURL>\n<SegmentBase indexRange='%s'>\n<Initialization range='%s'/>\n</SegmentBase>\n</Representation>\n</AdaptationSet>", "video", Integer.valueOf(itag), Integer.valueOf(bitrate), videoStream.getCodec(), videoStream.getFormat().getMimeType(), str, P0(videoStream.getContent()), videoStream.getIndexStart() + "-" + videoStream.getIndexEnd(), videoStream.getInitStart() + "-" + videoStream.getInitEnd());
    }

    public String playerContent(String str, String str2, List<String> list) {
        StreamInfo info;
        String dashMpdUrl;
        try {
            SpiderDebug.log("[YouTube] playerContent id=" + str2);
            String strExtractVideoId = (str2.contains("youtube.com") || str2.contains("youtu.be")) ? YoutubeVr.extractVideoId(str2) : str2;
            if (!strExtractVideoId.isEmpty() && C0(strExtractVideoId)) {
                SpiderDebug.log("[YouTube] extracted videoId=".concat(strExtractVideoId));
                String str3 = G;
                if (str3 != null && !str3.isEmpty()) {
                    Init.execute(new r(this, strExtractVideoId, 5));
                }
                try {
                    SpiderDebug.log("[YouTube] trying NewPipe...");
                    B0();
                    info = StreamInfo.getInfo("https://www.youtube.com/watch?v=".concat(strExtractVideoId));
                    StringBuilder sb = new StringBuilder("[YouTube] NewPipe streamType=");
                    sb.append(info.getStreamType());
                    sb.append(" duration=");
                    sb.append(info.getDuration());
                    sb.append("s hls=");
                    sb.append(!info.getHlsUrl().isEmpty());
                    sb.append(" dash=");
                    sb.append(!info.getDashMpdUrl().isEmpty());
                    SpiderDebug.log(sb.toString());
                    StreamType streamType = info.getStreamType();
                    dashMpdUrl = null;
                    if (streamType == StreamType.LIVE_STREAM || streamType == StreamType.AUDIO_LIVE_STREAM) {
                        if (!info.getHlsUrl().isEmpty()) {
                            dashMpdUrl = info.getHlsUrl();
                        } else if (!info.getDashMpdUrl().isEmpty()) {
                            dashMpdUrl = info.getDashMpdUrl();
                        }
                    }
                } catch (Throwable th) {
                    SpiderDebug.log("[YouTube] NewPipe failed: " + (th.getClass().getName() + " - " + th.getMessage()) + ", falling back to VR...");
                    if (th.getMessage() != null && (th.getMessage().contains("Sign in to confirm") || th.getMessage().contains("not a bot") || th.getMessage().contains("LOGIN_REQUIRED"))) {
                        Init.post(new p(10));
                    }
                }
                if (dashMpdUrl != null) {
                    SpiderDebug.log("[YouTube] NewPipe live ok: ".concat(dashMpdUrl.substring(0, Math.min(60, dashMpdUrl.length()))));
                    e eVar = new e();
                    eVar.q(dashMpdUrl);
                    eVar.i();
                    return eVar.toString();
                }
                String strB = B(info);
                if (strB != null) {
                    SpiderDebug.log("[YouTube] NewPipe VOD ok len=" + strB.length());
                    e eVar2 = new e();
                    eVar2.q(strB);
                    eVar2.i();
                    return eVar2.toString();
                }
                SpiderDebug.log("[YouTube] NewPipe returned no streams, falling back to VR...");
                SpiderDebug.log("[YouTube] using YoutubeVr.getPlayUrl as fallback...");
                String playUrl = YoutubeVr.getPlayUrl(strExtractVideoId);
                if (playUrl == null) {
                    SpiderDebug.log("[YouTube] all playback methods failed for videoId=".concat(strExtractVideoId));
                    com.github.catvod.spider.merge.g1.a.e("该视频无法播放，所有方法均失败");
                    return e.c("无法获取播放链接");
                }
                SpiderDebug.log("[YouTube] VR fallback ok len=" + playUrl.length());
                e eVar3 = new e();
                eVar3.q(playUrl);
                eVar3.i();
                return eVar3.toString();
            }
            SpiderDebug.log("[YouTube] invalid videoId from: ".concat(str2));
            e eVar4 = new e();
            eVar4.q(str2);
            eVar4.i();
            return eVar4.toString();
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] playerContent error: " + e2.getClass().getName() + " - " + e2.getMessage());
            e2.printStackTrace();
            e eVar5 = new e();
            eVar5.q(str2);
            eVar5.i();
            return eVar5.toString();
        }
    }

    public Object[] proxy(Map<String, String> map) {
        String str = map.get("type");
        String string = map.get("u");
        if ((!"media".equals(str) && !"img".equals(str)) || string == null || string.isEmpty()) {
            return null;
        }
        try {
            int length = string.length() % 4;
            if (length != 0) {
                StringBuilder sb = new StringBuilder(string);
                while (length < 4) {
                    sb.append('=');
                    length++;
                }
                string = sb.toString();
            }
            String str2 = new String(Base64.decode(string, 8), StandardCharsets.UTF_8);
            String str3 = map.get("range");
            if (str3 == null || str3.isEmpty()) {
                str3 = map.get("Range");
            }
            Request.Builder builderUrl = new Request.Builder().url(str2);
            if (str3 != null && !str3.isEmpty()) {
                builderUrl.header("Range", str3);
            }
            Response responseExecute = O0().newCall(builderUrl.build()).execute();
            int iCode = responseExecute.code();
            String strHeader = responseExecute.header("Content-Type");
            if (strHeader == null || strHeader.isEmpty()) {
                strHeader = "application/octet-stream";
            }
            String strHeader2 = responseExecute.header("Content-Range");
            byte[] bArrBytes = responseExecute.body() == null ? new byte[0] : responseExecute.body().bytes();
            responseExecute.close();
            HashMap map2 = new HashMap();
            if (strHeader2 != null && !strHeader2.isEmpty()) {
                map2.put("Content-Range", strHeader2);
            }
            map2.put("Content-Length", String.valueOf(bArrBytes.length));
            map2.put("Accept-Ranges", "bytes");
            return new Object[]{Integer.valueOf(iCode), strHeader, new ByteArrayInputStream(bArrBytes), map2};
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] proxyMedia error: " + e2.getClass().getSimpleName() + " / " + e2.getMessage());
            return new Object[]{500, "text/plain; charset=utf-8", new ByteArrayInputStream(("proxy media error: " + e2.getMessage()).getBytes(StandardCharsets.UTF_8))};
        }
    }

    public final BrowseResult q(int i2, String str) {
        String strW;
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        boolean z2 = true;
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseLiked error: "));
        }
        if (i2 <= 1) {
            HashMap map2 = new HashMap();
            map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            String strY0 = y0("https://www.youtube.com/playlist?list=LL", map2);
            JsonObject jsonObjectZ = Z(strY0);
            browseResult.a = H(jsonObjectZ);
            try {
                strW = W(jsonObjectZ);
            } catch (Exception unused) {
                strW = null;
            }
            browseResult.b = strW;
            StringBuilder sb = new StringBuilder("[YouTube] browseLiked pageLen=");
            sb.append(strY0.length());
            sb.append(" vods=");
            sb.append(browseResult.a.size());
            sb.append(" pvr=");
            sb.append(k0(jsonObjectZ, "playlistVideoRenderer").size());
            sb.append(" token=");
            if (browseResult.b == null) {
                z2 = false;
            }
            sb.append(z2);
            SpiderDebug.log(sb.toString());
            return browseResult;
        }
        String str2 = (String) map.get(D(i2, str));
        if (str2 != null) {
            BrowseResult browseResultN = n(str2, "browse");
            String str3 = browseResultN.b;
            if (str3 == null || str3.isEmpty()) {
                return browseResultN;
            }
            map.put(D(i2 + 1, str), browseResultN.b);
            return browseResultN;
        }
        BrowseResult browseResultQ = q(1, str);
        if (browseResultQ.b != null) {
            map.put(D(2, str), browseResultQ.b);
        }
        for (int i3 = 2; i3 <= i2; i3++) {
            String str4 = browseResultQ.b;
            if (str4 == null) {
                break;
            }
            browseResultQ = n(str4, "browse");
            map.put(D(i3, str), str4);
            if (browseResultQ.b != null) {
                map.put(D(i3 + 1, str), browseResultQ.b);
            }
        }
        return browseResultQ;
    }

    public final ArrayList s(String str) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        try {
            String[] strArrSplit = str.split("[,|，、]");
            for (String str2 : strArrSplit) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty()) {
                    String strY = VideoStream.RESOLUTION_UNKNOWN;
                    int iIndexOf = strTrim.indexOf(64);
                    if (iIndexOf >= 0) {
                        strY = Y(strTrim.substring(iIndexOf));
                    }
                    Iterator it = (strY.isEmpty() ? u(1, strTrim, "rec_" + strTrim, VideoStream.RESOLUTION_UNKNOWN, VideoStream.RESOLUTION_UNKNOWN) : m(1, strY, "rec_" + strY)).a.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        h hVar = (h) it.next();
                        if (i2 >= 20) {
                            break;
                        }
                        if (hVar.a() != null && hashSet.add(hVar.a())) {
                            arrayList.add(hVar);
                            i2++;
                        }
                    }
                }
            }
            SpiderDebug.log("[YouTube] browseListVideos items=" + strArrSplit.length + " vods=" + arrayList.size());
            return arrayList;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseListVideos error: "));
            return arrayList;
        }
    }

    public String searchContent(String str, boolean z2, String str2) throws NumberFormatException {
        try {
            SpiderDebug.log("[YouTube] search key=" + str + " pg=" + str2);
            if (str == null || !str.toLowerCase().trim().endsWith(".json") || (!str.startsWith(Utils.HTTP) && !str.startsWith(Utils.HTTPS) && !str.startsWith("/") && !str.contains("/"))) {
                int i2 = Integer.parseInt(str2);
                String str3 = "search_" + str;
                BrowseResult browseResultJ = j("VD_" + str, i2, str3, VideoStream.RESOLUTION_UNKNOWN);
                String str4 = browseResultJ.b;
                if (str4 != null && !str4.isEmpty()) {
                    g.put(D(i2 + 1, str3), browseResultJ.b);
                }
                e eVar = new e();
                eVar.s(browseResultJ.a);
                eVar.g(i2, browseResultJ.b != null ? 99 : i2, 20, browseResultJ.a.size());
                return eVar.toString();
            }
            String strTrim = str.trim();
            D = strTrim;
            Y0();
            E0();
            h hVar = new h();
            hVar.g("已设置配置路径");
            hVar.k(strTrim);
            e eVar2 = new e();
            eVar2.s(Collections.singletonList(hVar));
            eVar2.g(1, 1, 0, 1);
            return eVar2.toString();
        } catch (Exception e2) {
            SpiderDebug.log("[YouTube] search error: " + e2.getMessage());
            return e.o(new ArrayList());
        }
    }

    public final BrowseResult t(int i2, String str, String str2) {
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browsePlaylist error: "));
        }
        if (!str.startsWith("PL") && !str.startsWith("UU") && !str.startsWith("FL") && !str.startsWith("VL") && !str.startsWith("RD") && str.length() <= 20) {
            return u(i2, str, str2, VideoStream.RESOLUTION_UNKNOWN, "playlist");
        }
        String strW = null;
        if (i2 <= 1) {
            String strConcat = "https://www.youtube.com/playlist?list=".concat(str.startsWith("VL") ? str.substring(2) : str);
            HashMap map2 = new HashMap();
            map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            JsonObject jsonObjectZ = Z(y0(strConcat, map2));
            browseResult.a = H(jsonObjectZ);
            ArrayList arrayList = new ArrayList();
            Iterator it = browseResult.a.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                String strA = hVar.a();
                if (strA != null && strA.startsWith("VD@@@")) {
                    arrayList.add(hVar);
                }
            }
            browseResult.a = arrayList;
            try {
                strW = W(jsonObjectZ);
            } catch (Exception unused) {
            }
            browseResult.b = strW;
            return browseResult;
        }
        String str3 = (String) map.get(D(i2, str2));
        if (str3 != null) {
            BrowseResult browseResultN = n(str3, "browse");
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = browseResultN.a.iterator();
            while (it2.hasNext()) {
                h hVar2 = (h) it2.next();
                String strA2 = hVar2.a();
                if (strA2 != null && strA2.startsWith("VD@@@")) {
                    arrayList2.add(hVar2);
                }
            }
            browseResultN.a = arrayList2;
            if (arrayList2.isEmpty()) {
                browseResultN.b = null;
            }
            String str4 = browseResultN.b;
            if (str4 != null && !str4.isEmpty()) {
                map.put(D(i2 + 1, str2), browseResultN.b);
            }
            return browseResultN;
        }
        SpiderDebug.log("[YouTube] browsePlaylist: no token for page " + i2 + ", fetching from page 1");
        BrowseResult browseResultT = t(1, str, str2);
        String str5 = browseResultT.b;
        if (str5 != null && !str5.isEmpty()) {
            map.put(D(2, str2), browseResultT.b);
        }
        for (int i3 = 2; i3 <= i2; i3++) {
            String str6 = browseResultT.b;
            if (str6 == null) {
                break;
            }
            browseResultT = n(str6, "browse");
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = browseResultT.a.iterator();
            while (it3.hasNext()) {
                h hVar3 = (h) it3.next();
                String strA3 = hVar3.a();
                if (strA3 != null && strA3.startsWith("VD@@@")) {
                    arrayList3.add(hVar3);
                }
            }
            browseResultT.a = arrayList3;
            if (arrayList3.isEmpty()) {
                browseResultT.b = null;
            }
            map.put(D(i3, str2), str6);
            String str7 = browseResultT.b;
            if (str7 != null && !str7.isEmpty()) {
                map.put(D(i3 + 1, str2), browseResultT.b);
            }
        }
        return browseResultT;
    }

    public final BrowseResult u(int i2, String str, String str2, String str3, String str4) {
        String strW;
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        try {
            SpiderDebug.log("[YouTube] browseSearch keyword=" + str + " page=" + i2 + " type=" + str4);
            if (J && K >= 3) {
                long jCurrentTimeMillis = System.currentTimeMillis() - L;
                if (jCurrentTimeMillis < 60000) {
                    SpiderDebug.log("[YouTube] API failure threshold reached (" + K + " failures), using NewPipe Fallback directly");
                    return v(i2, str);
                }
                K = 0;
                SpiderDebug.log("[YouTube] Resetting API failure counter after " + (jCurrentTimeMillis / 1000) + "s, retrying InnerTube API");
            }
            try {
            } catch (Exception e2) {
                e = e2;
                SpiderDebug.log("[YouTube] browseSearch API error: " + e.getMessage());
                e.printStackTrace();
                K = K + 1;
                L = System.currentTimeMillis();
                SpiderDebug.log("[YouTube] API failure count: " + K + "/3");
                if (J) {
                    SpiderDebug.log("[YouTube] Trying NewPipe Fallback after API failure");
                    return v(i2, str);
                }
                return browseResult;
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (i2 <= 1) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("context", A());
            jsonObject.addProperty("query", str);
            if ("playlist".equals(str4)) {
                jsonObject.addProperty("params", "EgIQAw==");
            } else if ("channel".equals(str4)) {
                jsonObject.addProperty("params", "EgIQAg==");
            } else if ("live".equals(str4)) {
                jsonObject.addProperty("params", "EgJAAQ==");
            } else if (ChannelTabs.SHORTS.equals(str4)) {
                jsonObject.addProperty("params", "EgIYAQ==");
            } else if (str3 != null && str3.equals("latest")) {
                jsonObject.addProperty("params", "EgQIAhAB");
            }
            SpiderDebug.log("[YouTube] calling POST search with keyword: " + str);
            JsonObject jsonObjectM0 = M0(jsonObject, "search");
            StringBuilder sb = new StringBuilder("[YouTube] search response size: ");
            sb.append(jsonObjectM0 == null ? 0 : jsonObjectM0.toString().length());
            SpiderDebug.log(sb.toString());
            browseResult.a = H(jsonObjectM0);
            try {
                strW = W(jsonObjectM0);
            } catch (Exception unused) {
                strW = null;
            }
            browseResult.b = strW;
            StringBuilder sb2 = new StringBuilder("[YouTube] browseSearch collected ");
            sb2.append(browseResult.a.size());
            sb2.append(" vods, nextToken=");
            sb2.append(browseResult.b != null ? "yes" : "no");
            SpiderDebug.log(sb2.toString());
            K = 0;
            return browseResult;
        }
        String strD = D(i2, str2);
        String str5 = (String) map.get(strD);
        StringBuilder sb3 = new StringBuilder("[YouTube] page > 1, looking for cached token with key=");
        sb3.append(strD);
        sb3.append(" found=");
        sb3.append(str5 != null);
        SpiderDebug.log(sb3.toString());
        if (str5 != null) {
            SpiderDebug.log("[YouTube] using cached continuation token: ".concat(str5.substring(0, Math.min(50, str5.length()))));
            BrowseResult browseResultN = n(str5, "search");
            String str6 = browseResultN.b;
            if (str6 != null && !str6.isEmpty()) {
                map.put(D(i2 + 1, str2), browseResultN.b);
            }
            return browseResultN;
        }
        SpiderDebug.log("[YouTube] no cached token found for page " + i2 + ", fetching from page 1 to page " + i2);
        BrowseResult browseResultU = u(1, str, str2, str3, str4);
        String str7 = browseResultU.b;
        if (str7 != null && !str7.isEmpty()) {
            map.put(D(2, str2), browseResultU.b);
        }
        for (int i3 = 2; i3 <= i2; i3++) {
            String str8 = browseResultU.b;
            if (str8 == null) {
                break;
            }
            browseResultU = n(str8, "search");
            map.put(D(i3, str2), str8);
            String str9 = browseResultU.b;
            if (str9 != null && !str9.isEmpty()) {
                map.put(D(i3 + 1, str2), browseResultU.b);
            }
        }
        SpiderDebug.log("[YouTube] reached target page " + i2 + " via loop, vods=" + browseResultU.a.size());
        return browseResultU;
    }

    public final BrowseResult v(int i2, String str) {
        BrowseResult browseResult = new BrowseResult();
        try {
            SpiderDebug.log("[YouTube] NewPipe Fallback: searching keyword=" + str + " page=" + i2);
            SearchExtractor searchExtractor = ServiceList.YouTube.getSearchExtractor(str);
            searchExtractor.fetchPage();
            ListExtractor.InfoItemsPage<InfoItem> initialPage = searchExtractor.getInitialPage();
            if (i2 > 1) {
                for (int i3 = 1; i3 < i2 && initialPage.hasNextPage(); i3++) {
                    Page nextPage = initialPage.getNextPage();
                    if (nextPage == null) {
                        break;
                    }
                    initialPage = searchExtractor.getPage(nextPage);
                }
            }
            for (T t2 : initialPage.getItems()) {
                if (t2 instanceof StreamInfoItem) {
                    StreamInfoItem streamInfoItem = (StreamInfoItem) t2;
                    h hVar = new h();
                    String strF0 = f0(streamInfoItem.getUrl());
                    if (!strF0.isEmpty()) {
                        hVar.f("VD@@@" + strF0);
                        hVar.g(streamInfoItem.getName());
                        String url = VideoStream.RESOLUTION_UNKNOWN;
                        if (!streamInfoItem.getThumbnails().isEmpty()) {
                            url = streamInfoItem.getThumbnails().get(0).getUrl();
                        }
                        try {
                            hVar.h(Q0(url));
                            long duration = streamInfoItem.getDuration();
                            if (duration > 0) {
                                long j2 = duration / 3600;
                                long j3 = (duration % 3600) / 60;
                                long j4 = duration % 60;
                                if (j2 > 0) {
                                    hVar.k(String.format("%d:%02d:%02d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)));
                                } else {
                                    hVar.k(String.format("%d:%02d", Long.valueOf(j3), Long.valueOf(j4)));
                                }
                            }
                            browseResult.a.add(hVar);
                        } catch (Exception e2) {
                            e = e2;
                            SpiderDebug.log("[YouTube] NewPipe Fallback error: " + e.getMessage());
                            e.printStackTrace();
                            return browseResult;
                        }
                    }
                }
            }
            if (initialPage.hasNextPage()) {
                browseResult.b = "newpipe_has_next";
            }
            SpiderDebug.log("[YouTube] NewPipe Fallback: collected " + browseResult.a.size() + " vods, hasNext=" + initialPage.hasNextPage());
            return browseResult;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final BrowseResult w(String str) {
        BrowseResult browseResult = new BrowseResult();
        h hVar = new h();
        hVar.f("VD@@@".concat(str));
        hVar.g("YouTube 视频 ".concat(str));
        hVar.h(Q0("https://img.youtube.com/vi/" + str + "/hqdefault.jpg"));
        hVar.k("视频");
        browseResult.a.add(hVar);
        return browseResult;
    }

    public final BrowseResult x(int i2, String str) {
        String strW;
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        boolean z2 = true;
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseSubscribedChannels error: "));
        }
        if (i2 > 1) {
            String str2 = (String) map.get(D(i2, str));
            if (str2 != null) {
                BrowseResult browseResultN = n(str2, "browse");
                if (browseResultN.b == null) {
                    return browseResultN;
                }
                map.put(D(i2 + 1, str), browseResultN.b);
                return browseResultN;
            }
            BrowseResult browseResultX = x(1, str);
            if (browseResultX.b != null) {
                map.put(D(2, str), browseResultX.b);
            }
            for (int i3 = 2; i3 <= i2; i3++) {
                String str3 = browseResultX.b;
                if (str3 == null) {
                    break;
                }
                browseResultX = n(str3, "browse");
                map.put(D(i3, str), str3);
                if (browseResultX.b != null) {
                    map.put(D(i3 + 1, str), browseResultX.b);
                }
            }
            return browseResultX;
        }
        HashMap map2 = new HashMap();
        map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        String strY0 = y0("https://www.youtube.com/feed/channels", map2);
        JsonObject jsonObjectZ = Z(strY0);
        Iterator it = H(jsonObjectZ).iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            String strG0 = g0(hVar);
            if (!strG0.isEmpty()) {
                hVar.f("CV@@@" + strG0);
            }
            browseResult.a.add(hVar);
        }
        try {
            strW = W(jsonObjectZ);
        } catch (Exception unused) {
            strW = null;
        }
        browseResult.b = strW;
        StringBuilder sb = new StringBuilder();
        sb.append("[YouTube] browseSubscribedChannels pageLen=");
        sb.append(strY0.length());
        sb.append(" vods=");
        sb.append(browseResult.a.size());
        sb.append(" token=");
        if (browseResult.b == null) {
            z2 = false;
        }
        sb.append(z2);
        SpiderDebug.log(sb.toString());
        return browseResult;
    }

    public final BrowseResult y(int i2, String str) {
        String strW;
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        boolean z2 = true;
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseSubscriptions error: "));
        }
        if (i2 > 1) {
            String str2 = (String) map.get(D(i2, str));
            if (str2 != null) {
                BrowseResult browseResultN = n(str2, "browse");
                if (browseResultN.b == null) {
                    return browseResultN;
                }
                map.put(D(i2 + 1, str), browseResultN.b);
                return browseResultN;
            }
            BrowseResult browseResultY = y(1, str);
            if (browseResultY.b != null) {
                map.put(D(2, str), browseResultY.b);
            }
            for (int i3 = 2; i3 <= i2; i3++) {
                String str3 = browseResultY.b;
                if (str3 == null) {
                    break;
                }
                browseResultY = n(str3, "browse");
                map.put(D(i3, str), str3);
                if (browseResultY.b != null) {
                    map.put(D(i3 + 1, str), browseResultY.b);
                }
            }
            return browseResultY;
        }
        HashMap map2 = new HashMap();
        map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        String strY0 = y0("https://www.youtube.com/feed/subscriptions", map2);
        JsonObject jsonObjectZ = Z(strY0);
        browseResult.a = H(jsonObjectZ);
        try {
            strW = W(jsonObjectZ);
        } catch (Exception unused) {
            strW = null;
        }
        browseResult.b = strW;
        HashMap map3 = new HashMap();
        K(jsonObjectZ, map3);
        StringBuilder sb = new StringBuilder("[YouTube] browseSubscriptions pageLen=");
        sb.append(strY0.length());
        sb.append(" vods=");
        sb.append(browseResult.a.size());
        sb.append(" token=");
        if (browseResult.b == null) {
            z2 = false;
        }
        sb.append(z2);
        sb.append(" rendererKeys=");
        sb.append(map3);
        SpiderDebug.log(sb.toString());
        return browseResult;
    }

    public final BrowseResult z(int i2, String str) {
        String strW;
        HashMap map = g;
        BrowseResult browseResult = new BrowseResult();
        boolean z2 = true;
        try {
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("[YouTube] browseUserPlaylist error: "));
        }
        if (i2 > 1) {
            String str2 = (String) map.get(D(i2, str));
            if (str2 != null) {
                BrowseResult browseResultN = n(str2, "browse");
                if (browseResultN.b == null) {
                    return browseResultN;
                }
                map.put(D(i2 + 1, str), browseResultN.b);
                return browseResultN;
            }
            BrowseResult browseResultZ = z(1, str);
            if (browseResultZ.b != null) {
                map.put(D(2, str), browseResultZ.b);
            }
            for (int i3 = 2; i3 <= i2; i3++) {
                String str3 = browseResultZ.b;
                if (str3 == null) {
                    break;
                }
                browseResultZ = n(str3, "browse");
                map.put(D(i3, str), str3);
                if (browseResultZ.b != null) {
                    map.put(D(i3 + 1, str), browseResultZ.b);
                }
            }
            return browseResultZ;
        }
        HashMap map2 = new HashMap();
        map2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        String strY0 = y0("https://www.youtube.com/playlist?list=WL", map2);
        JsonObject jsonObjectZ = Z(strY0);
        browseResult.a = H(jsonObjectZ);
        try {
            strW = W(jsonObjectZ);
        } catch (Exception unused) {
            strW = null;
        }
        browseResult.b = strW;
        StringBuilder sb = new StringBuilder("[YouTube] browseUserPlaylist WL pageLen=");
        sb.append(strY0.length());
        sb.append(" vods=");
        sb.append(browseResult.a.size());
        sb.append(" pvr=");
        sb.append(k0(jsonObjectZ, "playlistVideoRenderer").size());
        sb.append(" token=");
        if (browseResult.b == null) {
            z2 = false;
        }
        sb.append(z2);
        SpiderDebug.log(sb.toString());
        if (strY0.length() < 3000) {
            String strTrim = strY0.replaceAll("\\s+", Stream.ID_UNKNOWN).trim();
            if (strTrim.length() > 200) {
                strTrim = strTrim.substring(0, 200);
            }
            SpiderDebug.log("[YouTube] browseUserPlaylist WL short html: ".concat(strTrim));
        }
        return browseResult;
    }

    public String searchContent(String str, boolean z2) {
        return searchContent(str, z2, "1");
    }
}
