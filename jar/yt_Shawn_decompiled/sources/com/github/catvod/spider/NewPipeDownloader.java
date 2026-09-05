package com.github.catvod.spider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Request;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class NewPipeDownloader extends Downloader {
    public static volatile String a = "";
    public static volatile int b = -1;
    public static volatile Proxy.Type c = Proxy.Type.HTTP;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class Loader {
        public static volatile NewPipeDownloader a = new NewPipeDownloader();
    }

    public static OkHttpClient a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderWriteTimeout = builder.connectTimeout(15L, timeUnit).readTimeout(20L, timeUnit).writeTimeout(15L, timeUnit);
        if (!a.isEmpty() && b > 0) {
            builderWriteTimeout.proxy(new java.net.Proxy(c, c == Proxy.Type.SOCKS ? InetSocketAddress.createUnresolved(a, b) : new InetSocketAddress(a, b)));
        }
        return builderWriteTimeout.build();
    }

    public static NewPipeDownloader get() {
        return Loader.a;
    }

    public static void setProxy(String str, int i, Proxy.Type type) {
        if (str == null) {
            str = VideoStream.RESOLUTION_UNKNOWN;
        }
        a = str;
        b = i;
        if (type == null) {
            type = Proxy.Type.HTTP;
        }
        c = type;
    }

    @Override // org.schabi.newpipe.extractor.downloader.Downloader
    public Response execute(Request request) throws IOException {
        String strUrl = request.url();
        Map<String, List<String>> mapHeaders = request.headers();
        byte[] bArrDataToSend = request.dataToSend();
        HashMap map = new HashMap();
        if (mapHeaders != null) {
            for (Map.Entry<String, List<String>> entry : mapHeaders.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    map.put(entry.getKey(), entry.getValue().get(0));
                }
            }
        }
        if (!map.containsKey("User-Agent")) {
            map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:128.0) Gecko/20100101 Firefox/128.0");
        }
        try {
            Request.Builder builderUrl = new Request.Builder().url(strUrl);
            for (Map.Entry entry2 : map.entrySet()) {
                builderUrl.header((String) entry2.getKey(), (String) entry2.getValue());
            }
            if (bArrDataToSend == null || bArrDataToSend.length <= 0) {
                builderUrl.get();
            } else {
                builderUrl.post(RequestBody.create(bArrDataToSend, MediaType.parse(map.containsKey("Content-Type") ? (String) map.get("Content-Type") : "application/json; charset=utf-8")));
            }
            okhttp3.Response responseExecute = a().newCall(builderUrl.build()).execute();
            int iCode = responseExecute.code();
            String strString = responseExecute.body() == null ? VideoStream.RESOLUTION_UNKNOWN : responseExecute.body().string();
            responseExecute.close();
            return new Response(iCode, "OK", new HashMap(), strString, strUrl);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException("NewPipe request failed: " + e2.getClass().getSimpleName() + " / " + e2.getMessage(), e2);
        }
    }
}
