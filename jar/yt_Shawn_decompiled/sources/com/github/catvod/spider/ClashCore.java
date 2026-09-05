package com.github.catvod.spider;

import android.os.Build;
import android.util.Base64;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.jdollar.net.URLDecoder;
import com.github.catvod.spider.jdollar.net.URLEncoder;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import com.github.catvod.spider.merge.o.d;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ClashCore {
    public static volatile String a = "";
    public static volatile String b = "";
    public static volatile String c = "";
    public static volatile int d;
    public static volatile Process g;
    public static volatile OkHttpClient k;
    public static final ArrayList e = new ArrayList();
    public static final ConcurrentHashMap f = new ConcurrentHashMap();
    public static volatile boolean h = false;
    public static final String[] i = {VideoStream.RESOLUTION_UNKNOWN, "https://gh-proxy.com/", "https://ghproxy.net/", "https://mirror.ghproxy.com/", "https://ghfast.top/"};
    public static final String[] j = {"国外直连 (GitHub)", "国内镜像 gh-proxy.com", "国内镜像 ghproxy.net", "国内镜像 mirror.ghproxy.com", "国内镜像 ghfast.top"};

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface DownloadProgressCallback {
        void onProgress(long j, long j2);
    }

    public static String a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null) {
                    String lowerCase = str.toLowerCase();
                    if (lowerCase.contains("arm64") || lowerCase.contains("aarch64")) {
                        return "arm64";
                    }
                    if (lowerCase.contains("x86_64") || lowerCase.contains("amd64")) {
                        return "amd64";
                    }
                }
            }
            for (String str2 : strArr) {
                if (str2 != null && str2.toLowerCase().contains("armeabi")) {
                    return "armv7";
                }
            }
        }
        String str3 = Build.CPU_ABI;
        String lowerCase2 = str3 == null ? VideoStream.RESOLUTION_UNKNOWN : str3.toLowerCase();
        if (lowerCase2.contains("arm64") || lowerCase2.contains("aarch64")) {
            return "arm64";
        }
        if (lowerCase2.contains("x86_64") || lowerCase2.contains("amd64")) {
            return "amd64";
        }
        if (lowerCase2.contains("armeabi")) {
            return "armv7";
        }
        return null;
    }

    public static File b() {
        return new File(f(), "mihomo");
    }

    public static String c() throws Exception {
        String str = (b == null || b.isEmpty()) ? a : b;
        if (str.isEmpty()) {
            throw new Exception("未设置订阅地址");
        }
        String strK = k(j(n(str)));
        if (strK.isEmpty()) {
            throw new Exception("节点源里没有找到 proxies 节点段");
        }
        ArrayList arrayListO = o(strK);
        StringBuilder sbS = com.github.catvod.spider.merge.b.b.s("mixed-port: 31600\nexternal-controller: 127.0.0.1:31601\nallow-lan: false\nmode: rule\nlog-level: warning\nipv6: false\ntcp-concurrent: true\n", strK, "\nproxy-groups:\n  - name: \"节点选择\"\n    type: select\n    proxies:\n");
        Iterator it = arrayListO.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            sbS.append("      - \"");
            sbS.append(str2 == null ? VideoStream.RESOLUTION_UNKNOWN : str2.replace("\\", "\\\\").replace("\"", "\\\""));
            sbS.append("\"\n");
        }
        sbS.append("      - DIRECT\nrules:\n  - MATCH,节点选择\n");
        ArrayList arrayList = e;
        synchronized (arrayList) {
            arrayList.clear();
            arrayList.addAll(arrayListO);
        }
        return sbS.toString();
    }

    public static void clearCachedNodes() {
        ArrayList arrayList = e;
        synchronized (arrayList) {
            arrayList.clear();
        }
        clearDelayCache();
    }

    public static void clearDelayCache() {
        f.clear();
    }

    public static OkHttpClient d() {
        if (k == null) {
            synchronized (ClashCore.class) {
                try {
                    if (k == null) {
                        OkHttpClient.Builder builder = new OkHttpClient.Builder();
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        k = builder.connectTimeout(15L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(15L, timeUnit).build();
                    }
                } finally {
                }
            }
        }
        return k;
    }

    public static void deleteKernel() {
        stop();
        try {
            File fileB = b();
            boolean z = !fileB.exists() || fileB.delete();
            StringBuilder sb = new StringBuilder("[ClashCore] deleteKernel ");
            sb.append(z ? "OK" : "FAIL");
            sb.append(": ");
            sb.append(fileB.getAbsolutePath());
            SpiderDebug.log(sb.toString());
        } catch (Throwable unused) {
        }
    }

    public static String e() {
        String strA = a();
        if (strA == null) {
            return null;
        }
        return "https://github.com/MetaCubeX/mihomo/releases/download/v1.19.30/".concat("amd64".equals(strA) ? "mihomo-android-amd64-v1.19.30.gz" : "armv7".equals(strA) ? "mihomo-android-armv7-v1.19.30.gz" : "mihomo-android-arm64-v8-v1.19.30.gz");
    }

    public static File f() {
        return new File(Init.context().getFilesDir(), "mihomo");
    }

    public static List<String> fetchNodes() throws Exception {
        String str = (b == null || b.isEmpty()) ? a : b;
        if (str.isEmpty()) {
            throw new Exception("未设置订阅地址");
        }
        String strK = k(j(n(str)));
        if (strK.isEmpty()) {
            throw new Exception("节点源里没有找到 proxies 节点段");
        }
        ArrayList arrayListO = o(strK);
        if (arrayListO.isEmpty()) {
            throw new Exception("没有解析到任何节点");
        }
        ArrayList arrayList = e;
        synchronized (arrayList) {
            arrayList.clear();
            arrayList.addAll(arrayListO);
        }
        return arrayListO;
    }

    public static boolean g(String str, File file, DownloadProgressCallback downloadProgressCallback) {
        Response responseExecute;
        InputStream inputStreamByteStream;
        FileOutputStream fileOutputStream = null;
        try {
            long j2 = 0;
            responseExecute = d().newBuilder().readTimeout(0L, TimeUnit.MILLISECONDS).build().newCall(new Request.Builder().url(str).header("User-Agent", "clash-verge/v1.0").build()).execute();
            try {
                if (responseExecute.code() != 200) {
                    responseExecute.close();
                    return false;
                }
                long jContentLength = responseExecute.body().contentLength();
                inputStreamByteStream = responseExecute.body().byteStream();
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[65536];
                        loop0: while (true) {
                            long j3 = j2;
                            while (true) {
                                int i2 = inputStreamByteStream.read(bArr);
                                if (i2 <= 0) {
                                    break loop0;
                                }
                                fileOutputStream2.write(bArr, 0, i2);
                                j2 += i2;
                                if (downloadProgressCallback == null || (j2 - j3 < 1048576 && j2 != jContentLength)) {
                                }
                            }
                            downloadProgressCallback.onProgress(j2, jContentLength);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable unused) {
                        }
                        try {
                            inputStreamByteStream.close();
                        } catch (Throwable unused2) {
                        }
                        responseExecute.close();
                        return true;
                    } catch (Throwable unused3) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (inputStreamByteStream != null) {
                            try {
                                inputStreamByteStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        if (responseExecute != null) {
                            responseExecute.close();
                        }
                        return false;
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                inputStreamByteStream = null;
            }
        } catch (Throwable unused8) {
            responseExecute = null;
            inputStreamByteStream = null;
        }
    }

    public static List<String> getCachedNodes() {
        ArrayList arrayList;
        ArrayList arrayList2 = e;
        synchronized (arrayList2) {
            arrayList = new ArrayList(arrayList2);
        }
        return arrayList;
    }

    public static int getDelay(String str) {
        Integer num = (Integer) f.get(str);
        if (num == null) {
            return -2;
        }
        return num.intValue();
    }

    public static String getLocalFile() {
        return b;
    }

    public static int getMirrorIndex() {
        return d;
    }

    public static String getMirrorLabel() {
        return j[(d < 0 || d >= j.length) ? 0 : d];
    }

    public static String[] getMirrorLabels() {
        return j;
    }

    public static String getSelectedNode() {
        return c;
    }

    public static String getSubscribeUrl() {
        return a;
    }

    public static String getSubscriptionUrl() {
        return a == null ? VideoStream.RESOLUTION_UNKNOWN : a;
    }

    public static String h() {
        String str = i[(d < 0 || d >= i.length) ? 0 : d];
        if (str.isEmpty()) {
            return e();
        }
        return str + e();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:44|3|4|(1:6)(1:7)|8|40|9|10|(4:46|11|(1:13)(1:14)|15)|42|22|(1:24)(1:25)|26|30|(1:32)(1:35)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x010b, code lost:
    
        r11.append("sh -c chmod: 异常(");
        r11.append(r0.getMessage());
        r11.append(")\n");
        com.github.catvod.crawler.SpiderDebug.log("[ClashCore] chmod via sh failed: " + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e5 A[Catch: all -> 0x010a, TryCatch #1 {all -> 0x010a, blocks: (B:22:0x00b6, B:26:0x00f4, B:25:0x00e5), top: B:42:0x00b6, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String i(java.io.File r17) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.ClashCore.i(java.io.File):java.lang.String");
    }

    public static boolean install(DownloadProgressCallback downloadProgressCallback) {
        try {
            if (!isArchSupported()) {
                SpiderDebug.log("[ClashCore] install failed: 设备架构不支持代理功能（mihomo 仅支持 ARM/x86_64 架构）");
                return false;
            }
            File fileF = f();
            if (!fileF.exists() && !fileF.mkdirs()) {
                throw new Exception("mihomo 目录创建失败");
            }
            File fileB = b();
            if (isInstalled()) {
                return true;
            }
            String strH = h();
            if (strH == null) {
                throw new Exception("无法确定下载地址（架构不支持）");
            }
            SpiderDebug.log("[ClashCore] install downloading: ".concat(strH));
            File file = new File(fileF, "mihomo.gz");
            if (!g(strH, file, downloadProgressCallback)) {
                throw new Exception("下载失败");
            }
            SpiderDebug.log("[ClashCore] install downloaded " + file.length() + " bytes, gunzip...");
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(file));
            FileOutputStream fileOutputStream = new FileOutputStream(fileB);
            byte[] bArr = new byte[65536];
            while (true) {
                int i2 = gZIPInputStream.read(bArr);
                if (i2 <= 0) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    gZIPInputStream.close();
                    file.delete();
                    SpiderDebug.log("[ClashCore] install permission setup:\n" + i(fileB));
                    SpiderDebug.log("[ClashCore] install OK: " + fileB.getAbsolutePath() + " (" + fileB.length() + " bytes)");
                    return true;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th) {
            SpiderDebug.log("[ClashCore] install error: " + th.getClass().getSimpleName() + "/" + th.getMessage());
            return false;
        }
    }

    public static boolean isArchSupported() {
        return a() != null;
    }

    public static boolean isInstalled() {
        File fileB = b();
        return fileB.exists() && fileB.length() > 0;
    }

    public static boolean isRunning() {
        return h;
    }

    /* JADX WARN: Removed duplicated region for block: B:243:0x050f A[Catch: all -> 0x0508, TRY_LEAVE, TryCatch #5 {all -> 0x0508, blocks: (B:238:0x04fd, B:243:0x050f, B:248:0x051f, B:251:0x0527), top: B:394:0x04fd }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x051f A[Catch: all -> 0x0508, TRY_ENTER, TryCatch #5 {all -> 0x0508, blocks: (B:238:0x04fd, B:243:0x050f, B:248:0x051f, B:251:0x0527), top: B:394:0x04fd }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0527 A[Catch: all -> 0x0508, TRY_LEAVE, TryCatch #5 {all -> 0x0508, blocks: (B:238:0x04fd, B:243:0x050f, B:248:0x051f, B:251:0x0527), top: B:394:0x04fd }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x053a A[Catch: all -> 0x05d6, TRY_LEAVE, TryCatch #13 {all -> 0x05d6, blocks: (B:235:0x04ef, B:246:0x0519, B:254:0x0533, B:257:0x053a, B:261:0x0565), top: B:410:0x04ef }] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 1991
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.ClashCore.j(java.lang.String):java.lang.String");
    }

    public static String k(String str) {
        String[] strArrSplit = str.split("\n");
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (z) {
                if (strTrim.isEmpty()) {
                    sb.append('\n');
                } else if (!strTrim.startsWith("#")) {
                    if (!str2.startsWith(Stream.ID_UNKNOWN) && !str2.startsWith("\t") && !str2.startsWith("-")) {
                        break;
                    }
                    sb.append(str2);
                    sb.append('\n');
                } else {
                    continue;
                }
            } else if (strTrim.equals("proxies:") || strTrim.equals("Proxy:")) {
                sb.append(str2);
                sb.append('\n');
                z = true;
            }
        }
        return sb.toString().trim();
    }

    public static String kernelPath() {
        return b().getAbsolutePath();
    }

    public static String l(String str) {
        try {
            Response responseExecute = d().newCall(new Request.Builder().url(str).header("User-Agent", "clash-verge/v1.0").build()).execute();
            String strString = responseExecute.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute.body().string();
            responseExecute.close();
            return strString;
        } catch (Throwable unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static int m(String str, String str2) {
        String strString = VideoStream.RESOLUTION_UNKNOWN;
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            builderUrl.put(RequestBody.create(str2, MediaType.parse("application/json; charset=utf-8")));
            Response responseExecute = d().newCall(builderUrl.build()).execute();
            int iCode = responseExecute.code();
            if (iCode >= 400) {
                try {
                    if (responseExecute.body() != null) {
                        strString = responseExecute.body().string();
                    }
                } catch (Throwable unused) {
                }
                SpiderDebug.log("[ClashCore] httpPut " + iCode + " url=" + str + " req=" + str2 + " resp=" + strString);
            }
            responseExecute.close();
            return iCode;
        } catch (Throwable unused2) {
            return -1;
        }
    }

    public static String n(String str) throws Exception {
        boolean zStartsWith = str.startsWith(Utils.HTTP);
        String strConcat = VideoStream.RESOLUTION_UNKNOWN;
        if (zStartsWith || str.startsWith(Utils.HTTPS)) {
            Response response = null;
            try {
                try {
                    Response responseExecute = d().newCall(new Request.Builder().url(str).header("User-Agent", "clash-verge/v1.0").build()).execute();
                    int iCode = responseExecute.code();
                    String strString = responseExecute.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute.body().string();
                    if (iCode != 200) {
                        String strTrim = strString.trim();
                        if (strTrim.length() > 200) {
                            strTrim = strTrim.substring(0, 200);
                        }
                        StringBuilder sb = new StringBuilder("订阅源返回 HTTP ");
                        sb.append(iCode);
                        if (!strTrim.isEmpty()) {
                            strConcat = "：".concat(strTrim);
                        }
                        sb.append(strConcat);
                        throw new Exception(sb.toString());
                    }
                    if (strString.trim().isEmpty()) {
                        throw new Exception("订阅源返回 200 但内容为空");
                    }
                    responseExecute.close();
                    strConcat = strString;
                } catch (IOException e2) {
                    String simpleName = e2.getClass().getSimpleName();
                    if (e2.getMessage() != null && !e2.getMessage().isEmpty()) {
                        simpleName = simpleName + "：" + e2.getMessage();
                    }
                    SpiderDebug.log("[ClashCore] 订阅拉取网络失败: ".concat(simpleName));
                    throw new Exception("订阅源无法直连（" + simpleName + "）。订阅源可能需代理访问，建议改用本地档案或稍后重试");
                }
            } finally {
                if (0 != 0) {
                    response.close();
                }
            }
        } else {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                throw new Exception("本地档案不存在：".concat(str));
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                fileInputStream.close();
                strConcat = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
            } catch (Throwable unused) {
            }
        }
        if (strConcat.trim().isEmpty()) {
            throw new Exception("节点源返回空内容");
        }
        SpiderDebug.log("[ClashCore] src len=" + strConcat.length() + " head=" + (strConcat.length() > 200 ? strConcat.substring(0, 200) : strConcat).replaceAll("\\s+", Stream.ID_UNKNOWN));
        if (strConcat.contains("proxies:") || strConcat.contains("Proxy:")) {
            return strConcat;
        }
        try {
            String str2 = new String(Base64.decode(strConcat.trim(), 0), StandardCharsets.UTF_8);
            if (!str2.contains("proxies:")) {
                if (!str2.contains("Proxy:")) {
                    return strConcat;
                }
            }
            try {
                SpiderDebug.log("[ClashCore] src is base64, decoded len=" + str2.length());
            } catch (Throwable unused2) {
            }
            return str2;
        } catch (Throwable unused3) {
            return strConcat;
        }
    }

    public static ArrayList o(String str) {
        int iIndexOf;
        String strTrim;
        int iIndexOf2;
        int iIndexOf3;
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split("\n")) {
            String strTrim2 = str2.trim();
            if (strTrim2.startsWith("-") && (iIndexOf = strTrim2.indexOf("name:")) >= 0) {
                String strTrim3 = strTrim2.substring(iIndexOf + 5).trim().trim();
                if (strTrim3.length() >= 2 && strTrim3.startsWith("\"") && strTrim3.endsWith("\"")) {
                    strTrim = strTrim3.substring(1, strTrim3.length() - 1);
                } else if (strTrim3.length() >= 2 && strTrim3.startsWith("'") && strTrim3.endsWith("'")) {
                    strTrim = strTrim3.substring(1, strTrim3.length() - 1);
                } else if (strTrim3.startsWith("'") && (iIndexOf3 = strTrim3.indexOf("'", 1)) >= 0) {
                    strTrim = strTrim3.substring(1, iIndexOf3).trim();
                } else if (!strTrim3.startsWith("\"") || (iIndexOf2 = strTrim3.indexOf("\"", 1)) < 0) {
                    int iIndexOf4 = strTrim3.indexOf(44);
                    if (iIndexOf4 >= 0) {
                        strTrim3 = strTrim3.substring(0, iIndexOf4).trim();
                    }
                    strTrim = strTrim3.trim();
                } else {
                    strTrim = strTrim3.substring(1, iIndexOf2).trim();
                }
                if (!strTrim.isEmpty()) {
                    String lowerCase = strTrim.toLowerCase();
                    String[] strArr = {"获取时间", "赞助", "pay.", "感谢", "公益", "安卓", "苹果", "karing", "shadowrocket", "自动更新", "节点订阅", "节点来自", "网友提供", "剩余流量", "套餐到期", "到期时间", "官网"};
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 17) {
                            arrayList.add(strTrim);
                            break;
                        }
                        if (lowerCase.contains(strArr[i2])) {
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return arrayList;
    }

    public static HashMap p(String str) {
        HashMap map = new HashMap();
        if (!str.isEmpty()) {
            for (String str2 : str.split("&")) {
                int iIndexOf = str2.indexOf(61);
                if (iIndexOf >= 0) {
                    map.put(str2.substring(0, iIndexOf), r(str2.substring(iIndexOf + 1)));
                }
            }
        }
        return map;
    }

    public static boolean ping() throws InterruptedException {
        for (int i2 = 0; i2 < 8; i2++) {
            try {
                String strL = l("http://127.0.0.1:31601/version");
                if (strL != null && strL.contains("version")) {
                    return true;
                }
            } catch (Throwable unused) {
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
        }
        return false;
    }

    public static String q(String str) {
        try {
            if (str.contains("-") || str.contains("_")) {
                str = str.replace('-', '+').replace('_', '/');
            }
            while (str.length() % 4 != 0) {
                str = str + "=";
            }
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String r(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String readLogTail(int i2) {
        try {
            File file = new File(f(), "mihomo.log");
            if (!file.exists()) {
                return "(日志文件不存在)";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            LinkedList linkedList = new LinkedList();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                linkedList.add(line);
                if (linkedList.size() > i2) {
                    linkedList.removeFirst();
                }
            }
            bufferedReader.close();
            StringBuilder sb = new StringBuilder();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
            return sb.toString();
        } catch (Throwable th) {
            return "(读取日志失败: " + th.getMessage() + ")";
        }
    }

    public static void setLocalFile(String str) {
        b = str == null ? VideoStream.RESOLUTION_UNKNOWN : str.trim();
    }

    public static void setMirrorIndex(int i2) {
        if (i2 < 0 || i2 >= i.length) {
            return;
        }
        d = i2;
    }

    public static void setSelectedNode(String str) {
        c = str == null ? VideoStream.RESOLUTION_UNKNOWN : str.trim();
    }

    public static void setSubscribeUrl(String str) {
        a = str == null ? VideoStream.RESOLUTION_UNKNOWN : str.trim();
    }

    public static boolean start(StringBuilder sb) throws InterruptedException {
        String strConcat;
        stop();
        int i2 = 0;
        try {
        } catch (Throwable th) {
            String message = th.getMessage() != null ? th.getMessage() : th.getClass().getSimpleName();
            if (message.contains("未设置订阅地址")) {
                strConcat = "启动失败: 未设置订阅地址";
            } else if (message.contains("Permission denied") || message.contains("error=13")) {
                strConcat = "启动失败: 权限被拒绝";
            } else if (message.contains("节点源里没有找到")) {
                strConcat = "启动失败: 订阅地址无效（未找到节点）";
            } else if (message.contains("没有解析到任何节点")) {
                strConcat = "启动失败: 订阅地址无效（没有可用节点）";
            } else if (message.contains("订阅源无法直连") || message.contains("订阅源返回 HTTP") || message.contains("订阅源返回 200 但内容为空")) {
                strConcat = "启动失败: ".concat(message);
            } else {
                strConcat = "进程启动失败: " + th.getClass().getSimpleName() + " / " + message;
            }
            SpiderDebug.log("[ClashCore] start error: ".concat(strConcat));
            h = false;
            if (sb != null) {
                sb.append(strConcat);
                if (message.contains("Permission denied") || message.contains("error=13")) {
                    File fileB = b();
                    String strI = i(fileB);
                    sb.append("\n\n【权限诊断】\n");
                    sb.append(strI);
                    sb.append("\n\n路径: ");
                    sb.append(fileB.getAbsolutePath());
                    sb.append("\n文件大小: ");
                    sb.append(fileB.length());
                    sb.append(" bytes");
                    sb.append("\n\n建议: 尝试\"删除内核\"后重新\"获取内核\"，或检查设备 SELinux 设置");
                }
                if (message.contains("未设置订阅地址")) {
                    sb.append("\n\n请先在\"代理/节点\"设置中填写订阅地址");
                }
            }
        }
        if (!isInstalled() && !install()) {
            SpiderDebug.log("[ClashCore] start abort: 内核未安装且自动下载失败");
            if (sb != null) {
                sb.append("内核未安装且自动下载失败");
                return false;
            }
            return false;
        }
        File fileB2 = b();
        i(fileB2);
        String strC = c();
        File file = new File(f(), "config.yaml");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(strC.getBytes(StandardCharsets.UTF_8));
        fileOutputStream.flush();
        fileOutputStream.close();
        SpiderDebug.log("[ClashCore] config written: " + file.getAbsolutePath() + " (" + strC.length() + " bytes)");
        ProcessBuilder processBuilder = new ProcessBuilder(fileB2.getAbsolutePath(), "-d", f().getAbsolutePath(), "-f", file.getAbsolutePath());
        processBuilder.directory(f());
        processBuilder.redirectErrorStream(true);
        if (Build.VERSION.SDK_INT >= 26) {
            processBuilder.redirectOutput(ProcessBuilder.Redirect.to(new File(f(), "mihomo.log")));
            g = processBuilder.start();
        } else {
            g = processBuilder.start();
            new Thread(new com.github.catvod.spider.merge.n.a(i2, g.getInputStream(), new FileOutputStream(new File(f(), "mihomo.log")))).start();
        }
        SpiderDebug.log("[ClashCore] process started: " + fileB2.getAbsolutePath());
        try {
            Thread.sleep(500L);
        } catch (Throwable unused) {
        }
        boolean zPing = ping();
        h = zPing;
        if (!zPing && sb != null) {
            sb.append("控制器端口不可达，内核可能崩溃。最后日志:\n");
            sb.append(readLogTail(10));
        }
        SpiderDebug.log("[ClashCore] start ".concat(zPing ? "OK (controller reachable)" : "FAIL (controller not reachable)"));
        return zPing;
    }

    public static void stop() {
        h = false;
        Process process = g;
        g = null;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (process != null) {
            try {
                process.destroy();
                if (!process.waitFor(2L, timeUnit)) {
                    process.destroyForcibly();
                }
            } catch (Throwable unused) {
            }
        }
        try {
            new ProcessBuilder("sh", "-c", "pkill -9 -x mihomo 2>/dev/null; killall -9 mihomo 2>/dev/null; true").start().waitFor(2L, timeUnit);
        } catch (Throwable unused2) {
        }
        SpiderDebug.log("[ClashCore] stopped");
    }

    public static boolean switchNode(String str) {
        if (str != null && !str.isEmpty() && (h || start())) {
            try {
                String str2 = "{\"name\":\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"}";
                String str3 = "http://127.0.0.1:31601/proxies/" + URLEncoder.encode("节点选择", "UTF-8").replace("+", "%20");
                int iM = m(str3, str2);
                if (iM != 204 && iM != 200) {
                    String strL = VideoStream.RESOLUTION_UNKNOWN;
                    try {
                        strL = l(str3);
                        if (strL.length() > 600) {
                            strL = strL.substring(0, 600);
                        }
                    } catch (Throwable unused) {
                    }
                    SpiderDebug.log("[ClashCore] switchNode fail code=" + iM + " name=" + str + " members=" + strL);
                }
                c = str;
                SpiderDebug.log("[ClashCore] switchNode OK: ".concat(str));
                return true;
            } catch (Throwable th) {
                SpiderDebug.log("[ClashCore] switchNode error: " + th.getMessage());
            }
        }
        return false;
    }

    public static void testAllNodes(final Runnable runnable) {
        List<String> cachedNodes = getCachedNodes();
        clearDelayCache();
        if (cachedNodes.isEmpty() || !h) {
            if (runnable != null) {
                Init.post(runnable);
                return;
            }
            return;
        }
        final ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(8);
        final CountDownLatch countDownLatch = new CountDownLatch(cachedNodes.size());
        for (final String str : cachedNodes) {
            executorServiceNewFixedThreadPool.execute(new Runnable() { // from class: com.github.catvod.spider.ClashCore.1
                @Override // java.lang.Runnable
                public void run() {
                    CountDownLatch countDownLatch2 = countDownLatch;
                    try {
                        ClashCore.testDelay(str);
                        countDownLatch2.countDown();
                    } catch (Throwable unused) {
                        countDownLatch2.countDown();
                    }
                }
            });
        }
        new Thread(new Runnable() { // from class: com.github.catvod.spider.ClashCore.2
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                try {
                    countDownLatch.await(300L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                }
                executorServiceNewFixedThreadPool.shutdownNow();
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    Init.post(runnable2);
                }
            }
        }).start();
    }

    public static int testDelay(String str) {
        int asInt = -1;
        if (str != null && !str.isEmpty()) {
            try {
                String strL = l("http://127.0.0.1:31601/proxies/" + URLEncoder.encode(str, "UTF-8").replace("+", "%20") + "/delay?url=" + URLEncoder.encode("http://www.gstatic.com/generate_204", "UTF-8") + "&timeout=3000");
                JsonObject jsonObjectH = d.h(strL);
                if (!jsonObjectH.has("delay") || jsonObjectH.get("delay").isJsonNull()) {
                    String strTrim = strL == null ? VideoStream.RESOLUTION_UNKNOWN : strL.trim();
                    if (strTrim.length() > 160) {
                        strTrim = strTrim.substring(0, 160);
                    }
                    SpiderDebug.log("[ClashCore] testDelay fail: " + str + " resp=" + strTrim);
                } else {
                    asInt = jsonObjectH.get("delay").getAsInt();
                }
            } catch (Throwable th) {
                StringBuilder sbS = com.github.catvod.spider.merge.b.b.s("[ClashCore] testDelay error: ", str, Stream.ID_UNKNOWN);
                sbS.append(th.getMessage());
                SpiderDebug.log(sbS.toString());
            }
            f.put(str, Integer.valueOf(asInt));
        }
        return asInt;
    }

    public static boolean install() {
        return install(null);
    }

    public static boolean start() {
        return start(null);
    }
}
