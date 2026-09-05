package com.github.catvod.spider;

import android.net.Uri;
import android.util.Base64;
import com.github.catvod.crawler.SpiderDebug;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeVr {
    public static final Pattern a = Pattern.compile("(?:v=|youtu\\.be/|embed/|shorts/)([\\w-]{11})");
    public static final Pattern b = Pattern.compile("\"visitorData\"\\s*:\\s*\"([^\"]+)\"");
    public static volatile String c = VideoStream.RESOLUTION_UNKNOWN;
    public static volatile long d = 0;
    public static volatile String e = VideoStream.RESOLUTION_UNKNOWN;
    public static volatile int f = -1;
    public static volatile String g = VideoStream.RESOLUTION_UNKNOWN;
    public static volatile String h = VideoStream.RESOLUTION_UNKNOWN;
    public static volatile int i = -1;
    public static volatile Proxy.Type j = Proxy.Type.HTTP;

    public static String a(JSONObject jSONObject, String str) throws NumberFormatException {
        char c2;
        char c3;
        int i2;
        String str2;
        try {
            String strOptString = jSONObject.optString("url", VideoStream.RESOLUTION_UNKNOWN);
            if (strOptString.isEmpty()) {
                return null;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("initRange");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("indexRange");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null) {
                int iOptInt = jSONObject.optInt("itag");
                int iOptInt2 = jSONObject.optInt("bitrate");
                String strOptString2 = jSONObject.optString("mimeType", VideoStream.RESOLUTION_UNKNOWN);
                String strL = l(strOptString2);
                int iIndexOf = strOptString2.indexOf(59);
                if (iIndexOf >= 0) {
                    strOptString2 = strOptString2.substring(0, iIndexOf).trim();
                }
                String str3 = jSONObjectOptJSONObject.optString(PeertubeParsingHelper.START_KEY) + "-" + jSONObjectOptJSONObject.optString("end");
                String str4 = jSONObjectOptJSONObject2.optString(PeertubeParsingHelper.START_KEY) + "-" + jSONObjectOptJSONObject2.optString("end");
                if ("video".equals(str)) {
                    c2 = 2;
                    c3 = 0;
                    str2 = String.format(Locale.getDefault(), "height='%d' width='%d' frameRate='%d' maxPlayoutRate='1' startWithSAP='1'", Integer.valueOf(jSONObject.optInt("height")), Integer.valueOf(jSONObject.optInt("width")), Integer.valueOf(jSONObject.optInt("fps")));
                } else {
                    c2 = 2;
                    c3 = 0;
                    Locale locale = Locale.getDefault();
                    try {
                        i2 = Integer.parseInt(jSONObject.optString("audioSampleRate").trim());
                    } catch (Exception unused) {
                        i2 = 0;
                    }
                    str2 = String.format(locale, "subsegmentAlignment='true' audioSamplingRate='%d'", Integer.valueOf(i2));
                }
                Locale locale2 = Locale.getDefault();
                Integer numValueOf = Integer.valueOf(iOptInt);
                Integer numValueOf2 = Integer.valueOf(iOptInt2);
                String strReplace = strOptString.replace("&", "&amp;");
                Object[] objArr = new Object[9];
                objArr[c3] = str;
                objArr[1] = numValueOf;
                objArr[c2] = numValueOf2;
                objArr[3] = strL;
                objArr[4] = strOptString2;
                objArr[5] = str2;
                objArr[6] = strReplace;
                objArr[7] = str4;
                objArr[8] = str3;
                return String.format(locale2, "<AdaptationSet lang='chi'>\n<ContentComponent contentType='%s'/>\n<Representation id='%d' bandwidth='%d' codecs='%s' mimeType='%s' %s>\n<BaseURL>%s</BaseURL>\n<SegmentBase indexRange='%s'>\n<Initialization range='%s'/>\n</SegmentBase>\n</Representation>\n</AdaptationSet>", objArr);
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(java.lang.String r12, java.lang.String r13) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.YoutubeVr.b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0097 A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:3:0x0007, B:7:0x0013, B:10:0x001d, B:12:0x0025, B:16:0x002f, B:18:0x0035, B:21:0x003d, B:24:0x004b, B:38:0x0089, B:40:0x0097, B:43:0x00ab, B:45:0x00b7, B:46:0x00c8, B:27:0x005c, B:30:0x0069, B:32:0x0071, B:34:0x0077), top: B:52:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7 A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:3:0x0007, B:7:0x0013, B:10:0x001d, B:12:0x0025, B:16:0x002f, B:18:0x0035, B:21:0x003d, B:24:0x004b, B:38:0x0089, B:40:0x0097, B:43:0x00ab, B:45:0x00b7, B:46:0x00c8, B:27:0x005c, B:30:0x0069, B:32:0x0071, B:34:0x0077), top: B:52:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.YoutubeVr.c(org.json.JSONObject):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ad A[Catch: Exception -> 0x0089, TryCatch #1 {Exception -> 0x0089, blocks: (B:20:0x004a, B:22:0x0050, B:41:0x008e, B:25:0x0059, B:27:0x0063, B:29:0x0069, B:31:0x0075, B:33:0x007b, B:35:0x007f, B:40:0x008c, B:48:0x00a7, B:50:0x00ad, B:82:0x0127, B:53:0x00b9, B:55:0x00c5, B:57:0x00cb, B:60:0x00d9, B:64:0x00e2, B:66:0x00e6, B:69:0x00f0, B:71:0x00f8, B:74:0x010b, B:76:0x0113, B:79:0x011a, B:81:0x0122, B:83:0x012d, B:87:0x0173, B:91:0x018d, B:101:0x01b2), top: B:109:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019b A[Catch: Exception -> 0x01b2, TRY_LEAVE, TryCatch #2 {Exception -> 0x01b2, blocks: (B:92:0x0191, B:94:0x019b), top: B:111:0x0191 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(org.json.JSONObject r21, org.json.JSONObject r22, java.lang.String r23) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.YoutubeVr.d(org.json.JSONObject, org.json.JSONObject, java.lang.String):java.lang.String");
    }

    public static OkHttpClient e() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderWriteTimeout = builder.connectTimeout(15L, timeUnit).readTimeout(20L, timeUnit).writeTimeout(15L, timeUnit);
        if (h != null && !h.isEmpty() && i > 0) {
            builderWriteTimeout.proxy(new java.net.Proxy(j, j == Proxy.Type.SOCKS ? InetSocketAddress.createUnresolved(h, i) : new InetSocketAddress(h, i)));
        }
        return builderWriteTimeout.build();
    }

    public static String extractVideoId(String str) {
        if (str == null || str.isEmpty()) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("v");
            if (queryParameter != null) {
                if (queryParameter.length() == 11) {
                    return queryParameter;
                }
            }
        } catch (Exception unused) {
        }
        Matcher matcher = a.matcher(str);
        return matcher.find() ? matcher.group(1) : VideoStream.RESOLUTION_UNKNOWN;
    }

    public static String f(String str) {
        try {
            Matcher matcher = Pattern.compile("height='(\\d+)'").matcher(new String(Base64.decode(str.substring(str.indexOf("base64,") + 7), 2)));
            int iMax = 0;
            while (matcher.find()) {
                iMax = Math.max(iMax, Integer.parseInt(matcher.group(1)));
            }
            if (iMax <= 0) {
                return "unknown";
            }
            return iMax + "p";
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public static String g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!c.isEmpty() && jCurrentTimeMillis - d < 1800000) {
            return c;
        }
        try {
            HashMap map = new HashMap();
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:128.0) Gecko/20100101 Firefox/128.0");
            String strH = h(map);
            Matcher matcher = b.matcher(strH);
            if (matcher.find()) {
                c = matcher.group(1);
                d = jCurrentTimeMillis;
                SpiderDebug.log("visitorData refreshed len=" + c.length());
            } else {
                StringBuilder sb = new StringBuilder("visitorData not found in html len=");
                sb.append(strH == null ? 0 : strH.length());
                SpiderDebug.log(sb.toString());
            }
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("visitorData error: "));
        }
        return c;
    }

    public static String getLiveUrl(String str) {
        return getPlayUrl(str);
    }

    public static String getMpd(String str) {
        return getPlayUrl(str);
    }

    public static String getPlayUrl(String str) {
        try {
            SpiderDebug.log("=== YT getPlayUrl start videoId=" + str + " ===");
            if (str != null && !str.isEmpty()) {
                String[] strArr = {"ANDROID", "VR", "IOS", "MWEB"};
                for (int i2 = 0; i2 < 4; i2++) {
                    String str2 = strArr[i2];
                    SpiderDebug.log("--- trying client: " + str2 + " ---");
                    String strM = m(str, str2);
                    if (strM == null || strM.isEmpty()) {
                        SpiderDebug.log("--- client " + str2 + " no body ---");
                    } else {
                        JSONObject jSONObject = new JSONObject(strM);
                        if ("OK".equals(n(jSONObject))) {
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("streamingData");
                            if (jSONObjectOptJSONObject != null) {
                                String strOptString = jSONObjectOptJSONObject.optString("hlsManifestUrl", VideoStream.RESOLUTION_UNKNOWN);
                                if (!strOptString.isEmpty()) {
                                    SpiderDebug.log("=== YT getPlayUrl SUCCESS client=" + str2 + " LIVE hls ===");
                                    return strOptString;
                                }
                                String strOptString2 = jSONObjectOptJSONObject.optString("dashManifestUrl", VideoStream.RESOLUTION_UNKNOWN);
                                if (!strOptString2.isEmpty()) {
                                    SpiderDebug.log("=== YT getPlayUrl SUCCESS client=" + str2 + " LIVE dash ===");
                                    return strOptString2;
                                }
                                String strD = d(jSONObject, jSONObjectOptJSONObject, str2);
                                if (strD != null) {
                                    SpiderDebug.log("=== YT getPlayUrl SUCCESS client=" + str2 + " VOD maxRes=" + f(strD) + " ===");
                                    return strD;
                                }
                                SpiderDebug.log("--- client " + str2 + " failed ---");
                            }
                        } else {
                            SpiderDebug.log("--- client " + str2 + " not playable: " + n(jSONObject) + " ---");
                        }
                    }
                }
                SpiderDebug.log("=== YT getPlayUrl FAILED all clients exhausted ===");
            }
            return null;
        } catch (Exception e2) {
            com.github.catvod.spider.merge.b.b.x(e2, new StringBuilder("getPlayUrl error: "));
            return null;
        }
    }

    public static String h(HashMap map) {
        Request.Builder builderUrl = new Request.Builder().url("https://www.youtube.com/");
        for (Map.Entry entry : map.entrySet()) {
            builderUrl.header((String) entry.getKey(), (String) entry.getValue());
        }
        Response responseExecute = e().newCall(builderUrl.build()).execute();
        String strString = responseExecute.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute.body().string();
        responseExecute.close();
        return strString;
    }

    public static String i(String str, HashMap map) {
        Request.Builder builderUrl = new Request.Builder().url("https://youtubei.googleapis.com/youtubei/v1/player?prettyPrint=false");
        for (Map.Entry entry : map.entrySet()) {
            builderUrl.header((String) entry.getKey(), (String) entry.getValue());
        }
        builderUrl.post(RequestBody.create(str, MediaType.parse("application/json; charset=utf-8")));
        Response responseExecute = e().newCall(builderUrl.build()).execute();
        String strString = responseExecute.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute.body().string();
        responseExecute.close();
        return strString;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[PHI: r0
      0x002e: PHI (r0v6 java.lang.String) = (r0v4 java.lang.String), (r0v5 java.lang.String) binds: [B:13:0x002c, B:16:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean j(java.lang.String r2) {
        /*
            java.lang.String r0 = com.github.catvod.spider.YoutubeVr.g
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La
            r2 = 1
            return r2
        La:
            java.lang.String r2 = l(r2)
            if (r2 != 0) goto L13
            java.lang.String r2 = ""
            goto L39
        L13:
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r2 = r2.trim()
            java.lang.String r0 = "mp4a"
            boolean r0 = r2.startsWith(r0)
            if (r0 == 0) goto L26
            java.lang.String r2 = "aac"
            goto L39
        L26:
            java.lang.String r0 = "opus"
            boolean r1 = r2.startsWith(r0)
            if (r1 == 0) goto L30
        L2e:
            r2 = r0
            goto L39
        L30:
            java.lang.String r0 = "vorbis"
            boolean r1 = r2.startsWith(r0)
            if (r1 == 0) goto L39
            goto L2e
        L39:
            java.lang.String r0 = com.github.catvod.spider.YoutubeVr.g
            boolean r2 = r2.equals(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.YoutubeVr.j(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023 A[PHI: r0
      0x0023: PHI (r0v14 java.lang.String) = (r0v2 java.lang.String), (r0v13 java.lang.String) binds: [B:10:0x0021, B:28:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061 A[PHI: r1
      0x0061: PHI (r1v2 java.lang.String) = (r1v1 java.lang.String), (r1v1 java.lang.String), (r1v3 java.lang.String), (r1v3 java.lang.String) binds: [B:18:0x003e, B:20:0x0044, B:23:0x004f, B:25:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean k(java.lang.String r2) {
        /*
            java.lang.String r0 = com.github.catvod.spider.YoutubeVr.e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La
            r2 = 1
            return r2
        La:
            java.lang.String r2 = l(r2)
            if (r2 != 0) goto L13
            java.lang.String r2 = ""
            goto L65
        L13:
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r2 = r2.trim()
            java.lang.String r0 = "avc"
            boolean r1 = r2.startsWith(r0)
            if (r1 == 0) goto L25
        L23:
            r2 = r0
            goto L65
        L25:
            java.lang.String r0 = "hvc"
            boolean r0 = r2.startsWith(r0)
            if (r0 != 0) goto L63
            java.lang.String r0 = "hev"
            boolean r0 = r2.startsWith(r0)
            if (r0 == 0) goto L36
            goto L63
        L36:
            java.lang.String r0 = "vp09"
            boolean r0 = r2.startsWith(r0)
            java.lang.String r1 = "vp9"
            if (r0 != 0) goto L61
            boolean r0 = r2.startsWith(r1)
            if (r0 == 0) goto L47
            goto L61
        L47:
            java.lang.String r0 = "av01"
            boolean r0 = r2.startsWith(r0)
            java.lang.String r1 = "av1"
            if (r0 != 0) goto L61
            boolean r0 = r2.startsWith(r1)
            if (r0 == 0) goto L58
            goto L61
        L58:
            java.lang.String r0 = "mp4v"
            boolean r1 = r2.startsWith(r0)
            if (r1 == 0) goto L65
            goto L23
        L61:
            r2 = r1
            goto L65
        L63:
            java.lang.String r2 = "hevc"
        L65:
            java.lang.String r0 = com.github.catvod.spider.YoutubeVr.e
            boolean r2 = r2.equals(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.YoutubeVr.k(java.lang.String):boolean");
    }

    public static String l(String str) {
        int iIndexOf = str.indexOf("codecs=");
        return iIndexOf < 0 ? VideoStream.RESOLUTION_UNKNOWN : str.substring(iIndexOf + 7).replace("\"", VideoStream.RESOLUTION_UNKNOWN).trim();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m(java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "requestPlayer ("
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Exception -> L3c
            r1.<init>()     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/json"
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = "X-Goog-Api-Format-Version"
            java.lang.String r3 = "2"
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L3c
            int r2 = r6.hashCode()     // Catch: java.lang.Exception -> L3c
            r3 = -143408561(0xfffffffff773c24f, float:-4.9440202E33)
            if (r2 == r3) goto L5c
            r3 = 2690(0xa82, float:3.77E-42)
            if (r2 == r3) goto L51
            r3 = 2748(0xabc, float:3.851E-42)
            if (r2 == r3) goto L4a
            r3 = 72685(0x11bed, float:1.01853E-40)
            if (r2 == r3) goto L3f
            r3 = 2379719(0x244fc7, float:3.334697E-39)
            if (r2 == r3) goto L31
            goto L67
        L31:
            java.lang.String r2 = "MWEB"
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> L3c
            if (r2 == 0) goto L67
            java.lang.String r2 = "Mozilla/5.0 (Linux; Android 13; Pixel 7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36"
            goto L69
        L3c:
            r5 = move-exception
            goto Lbd
        L3f:
            java.lang.String r2 = "IOS"
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> L3c
            if (r2 == 0) goto L67
            java.lang.String r2 = "com.google.ios.youtube/19.45.4 (iPhone16,2; U; CPU iOS 18_1_0 like Mac OS X;)"
            goto L69
        L4a:
            java.lang.String r2 = "VR"
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> L3c
            goto L67
        L51:
            java.lang.String r2 = "TV"
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> L3c
            if (r2 == 0) goto L67
            java.lang.String r2 = "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/Version"
            goto L69
        L5c:
            java.lang.String r2 = "ANDROID"
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> L3c
            if (r2 == 0) goto L67
            java.lang.String r2 = "com.google.android.youtube/19.49.37 (Linux; U; Android 13; en_US) gzip"
            goto L69
        L67:
            java.lang.String r2 = "com.google.android.apps.youtube.vr.oculus/1.66.10 (Linux; U; Android 12L; eureka-user Build/SQ3A.220605.009.A1) gzip"
        L69:
            java.lang.String r3 = "User-Agent"
            r1.put(r3, r2)     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = g()     // Catch: java.lang.Exception -> L3c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3c
            r3.<init>(r0)     // Catch: java.lang.Exception -> L3c
            r3.append(r6)     // Catch: java.lang.Exception -> L3c
            java.lang.String r4 = ") videoId="
            r3.append(r4)     // Catch: java.lang.Exception -> L3c
            r3.append(r5)     // Catch: java.lang.Exception -> L3c
            java.lang.String r4 = " visitorDataLen="
            r3.append(r4)     // Catch: java.lang.Exception -> L3c
            int r2 = r2.length()     // Catch: java.lang.Exception -> L3c
            r3.append(r2)     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L3c
            com.github.catvod.crawler.SpiderDebug.log(r2)     // Catch: java.lang.Exception -> L3c
            java.lang.String r5 = b(r5, r6)     // Catch: java.lang.Exception -> L3c
            java.lang.String r5 = i(r5, r1)     // Catch: java.lang.Exception -> L3c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3c
            r1.<init>(r0)     // Catch: java.lang.Exception -> L3c
            r1.append(r6)     // Catch: java.lang.Exception -> L3c
            java.lang.String r2 = ") bodyLen="
            r1.append(r2)     // Catch: java.lang.Exception -> L3c
            if (r5 != 0) goto Lae
            r2 = 0
            goto Lb2
        Lae:
            int r2 = r5.length()     // Catch: java.lang.Exception -> L3c
        Lb2:
            r1.append(r2)     // Catch: java.lang.Exception -> L3c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L3c
            com.github.catvod.crawler.SpiderDebug.log(r1)     // Catch: java.lang.Exception -> L3c
            return r5
        Lbd:
            java.lang.String r1 = ") error: "
            java.lang.StringBuilder r6 = com.github.catvod.spider.merge.b.b.s(r0, r6, r1)
            java.lang.Class r0 = r5.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r6.append(r0)
            java.lang.String r0 = " / "
            r6.append(r0)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.github.catvod.crawler.SpiderDebug.log(r5)
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.YoutubeVr.m(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String n(JSONObject jSONObject) {
        String strOptString;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("playabilityStatus");
        String strConcat = VideoStream.RESOLUTION_UNKNOWN;
        if (jSONObjectOptJSONObject == null) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        String strOptString2 = jSONObjectOptJSONObject.optString("status", VideoStream.RESOLUTION_UNKNOWN);
        if (!"OK".equals(strOptString2)) {
            String strOptString3 = jSONObjectOptJSONObject.optString("reason", VideoStream.RESOLUTION_UNKNOWN);
            try {
                strOptString = jSONObjectOptJSONObject.optJSONObject("errorScreen").optJSONObject("playerErrorMessageRenderer").optJSONObject("reason").optString("simpleText", VideoStream.RESOLUTION_UNKNOWN);
            } catch (Exception unused) {
                strOptString = VideoStream.RESOLUTION_UNKNOWN;
            }
            StringBuilder sb = new StringBuilder("playabilityStatus=");
            sb.append(strOptString2);
            sb.append(" reason=");
            sb.append(strOptString3);
            if (!strOptString.isEmpty()) {
                strConcat = " subReason=".concat(strOptString);
            }
            sb.append(strConcat);
            SpiderDebug.log(sb.toString());
        }
        return strOptString2;
    }

    public static void setAudioFilter(String str) {
        g = str == null ? VideoStream.RESOLUTION_UNKNOWN : str.trim().toLowerCase();
    }

    public static void setCodecFilter(String str) {
        e = str == null ? VideoStream.RESOLUTION_UNKNOWN : str.trim().toLowerCase();
    }

    public static void setProxy(String str, int i2, Proxy.Type type) {
        if (str == null) {
            str = VideoStream.RESOLUTION_UNKNOWN;
        }
        h = str;
        i = i2;
        if (type == null) {
            type = Proxy.Type.HTTP;
        }
        j = type;
    }

    public static void setQualityFilter(int i2) {
        f = i2;
    }
}
