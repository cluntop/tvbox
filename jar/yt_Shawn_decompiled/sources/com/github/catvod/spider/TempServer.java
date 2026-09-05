package com.github.catvod.spider;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.h0.h;
import com.github.catvod.spider.merge.h0.i;
import com.github.catvod.spider.merge.h0.j;
import com.github.catvod.spider.merge.h0.n;
import com.github.catvod.spider.merge.h0.o;
import com.github.catvod.spider.merge.h0.t;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class TempServer extends t {
    public volatile String l;
    public final Object m;
    public final String n;

    public TempServer(int i, String str) {
        super(i);
        this.l = null;
        this.m = new Object();
        this.n = str;
    }

    public String getReceivedUrl() {
        String str;
        synchronized (this.m) {
            str = this.l;
        }
        return str;
    }

    @Override // com.github.catvod.spider.merge.h0.t
    public o serve(i iVar) throws UnsupportedEncodingException {
        String str = ((h) iVar).f;
        h hVar = (h) iVar;
        if (j.d.equals(hVar.g)) {
            o oVarNewFixedLengthResponse = t.newFixedLengthResponse(n.c, "text/plain", VideoStream.RESOLUTION_UNKNOWN);
            oVarNewFixedLengthResponse.j("Access-Control-Allow-Origin", "*");
            oVarNewFixedLengthResponse.j("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            oVarNewFixedLengthResponse.j("Access-Control-Allow-Headers", "Content-Type");
            return oVarNewFixedLengthResponse;
        }
        if ("/".equals(str) || str.isEmpty()) {
            n nVar = n.f;
            String str2 = this.n;
            try {
                InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("assets/" + str2);
                if (resourceAsStream == null) {
                    resourceAsStream = getClass().getClassLoader().getResourceAsStream(str2);
                }
                if (resourceAsStream != null) {
                    return t.newChunkedResponse(n.c, "text/html; charset=utf-8", resourceAsStream);
                }
                SpiderDebug.log("[TempServer] " + str2 + " not found in jar");
                return t.newFixedLengthResponse(nVar, "text/plain", "HTML file not found in jar");
            } catch (Exception e) {
                SpiderDebug.log("[TempServer] serveHtml error: " + e.getClass().getSimpleName() + " / " + e.getMessage());
                return t.newFixedLengthResponse(nVar, "text/plain", "Failed to load page: " + e.getMessage());
            }
        }
        if (!"/submit".equals(str) || !j.b.equals(hVar.g)) {
            return t.newFixedLengthResponse(n.e, "text/plain", "404 Not Found");
        }
        try {
            h hVar2 = (h) iVar;
            hVar2.g(new HashMap());
            HashMap map = new HashMap();
            for (String str3 : hVar2.h.keySet()) {
                map.put(str3, ((List) hVar2.h.get(str3)).get(0));
            }
            String str4 = (String) map.get("url");
            String str5 = (String) map.get("keyword");
            String str6 = (String) map.get("type");
            SpiderDebug.log("[TempServer] handleSubmit received params: " + map.keySet());
            if (str5 != null && !str5.trim().isEmpty()) {
                StringBuilder sb = new StringBuilder("SEARCH:");
                sb.append(str5.trim());
                sb.append("|TYPE:");
                if (str6 == null) {
                    str6 = "0";
                }
                sb.append(str6);
                String string = sb.toString();
                synchronized (this.m) {
                    this.l = string;
                    SpiderDebug.log("[TempServer] Stored search data: ".concat(string));
                    this.m.notifyAll();
                }
                SpiderDebug.log("[TempServer] Received search request successfully");
                o oVarNewFixedLengthResponse2 = t.newFixedLengthResponse(n.c, "text/plain", "OK");
                oVarNewFixedLengthResponse2.j("Access-Control-Allow-Origin", "*");
                return oVarNewFixedLengthResponse2;
            }
            if (str4 == null || str4.trim().isEmpty()) {
                SpiderDebug.log("[TempServer] No valid data received");
                o oVarNewFixedLengthResponse3 = t.newFixedLengthResponse(n.d, "text/plain", "URL or keyword is required");
                oVarNewFixedLengthResponse3.j("Access-Control-Allow-Origin", "*");
                return oVarNewFixedLengthResponse3;
            }
            if (str4.length() > 400) {
                SpiderDebug.log("[TempServer] Cookie preview: start=[" + str4.substring(0, 200) + "] end=[" + str4.substring(str4.length() - 200) + "]");
            } else {
                SpiderDebug.log("[TempServer] URL full: [" + str4 + "]");
            }
            synchronized (this.m) {
                this.l = str4.trim();
                SpiderDebug.log("[TempServer] Stored url length=" + this.l.length());
                this.m.notifyAll();
            }
            SpiderDebug.log("[TempServer] Received subscription URL/Cookie successfully");
            o oVarNewFixedLengthResponse4 = t.newFixedLengthResponse(n.c, "text/plain", "OK");
            oVarNewFixedLengthResponse4.j("Access-Control-Allow-Origin", "*");
            return oVarNewFixedLengthResponse4;
        } catch (Exception e2) {
            SpiderDebug.log("[TempServer] handleSubmit error: " + e2.getMessage());
            e2.printStackTrace();
            o oVarNewFixedLengthResponse5 = t.newFixedLengthResponse(n.f, "text/plain", "Error: " + e2.getMessage());
            oVarNewFixedLengthResponse5.j("Access-Control-Allow-Origin", "*");
            return oVarNewFixedLengthResponse5;
        }
        SpiderDebug.log("[TempServer] handleSubmit error: " + e2.getMessage());
        e2.printStackTrace();
        o oVarNewFixedLengthResponse52 = t.newFixedLengthResponse(n.f, "text/plain", "Error: " + e2.getMessage());
        oVarNewFixedLengthResponse52.j("Access-Control-Allow-Origin", "*");
        return oVarNewFixedLengthResponse52;
    }

    public String waitForUrl(long j) {
        String str;
        SpiderDebug.log("[TempServer] waitForUrl started, timeout=" + j + "ms");
        synchronized (this.m) {
            try {
                try {
                    if (this.l == null) {
                        SpiderDebug.log("[TempServer] receivedUrl is null, waiting...");
                        this.m.wait(j);
                        SpiderDebug.log("[TempServer] wait finished, receivedUrl=" + this.l);
                    } else {
                        SpiderDebug.log("[TempServer] receivedUrl already set: " + this.l);
                    }
                    str = this.l;
                } catch (InterruptedException unused) {
                    SpiderDebug.log("[TempServer] waitForUrl interrupted");
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public TempServer(int i) {
        this(i, "sub_input.html");
    }
}
