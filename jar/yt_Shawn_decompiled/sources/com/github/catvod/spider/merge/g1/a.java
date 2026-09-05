package com.github.catvod.spider.merge.g1;

import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.Init;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.m.c;
import com.github.catvod.spider.merge.m.d;
import com.github.catvod.spider.merge.n1.i;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.o1.s;
import com.github.catvod.spider.merge.o1.z;
import com.github.catvod.spider.merge.p1.f0;
import com.github.catvod.spider.merge.q1.u;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* loaded from: classes.dex */
public final class a implements u {
    public Object a;

    public static void c() {
        OkHttpClient okHttpClientD = d();
        for (Call call : okHttpClientD.dispatcher().queuedCalls()) {
            if ("Market".equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : okHttpClientD.dispatcher().runningCalls()) {
            if ("Market".equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    public static OkHttpClient d() {
        Dns dnsSafeDns;
        try {
            OkHttpClient okHttpClientClient = Spider.client();
            Objects.requireNonNull(okHttpClientClient);
            return okHttpClientClient;
        } catch (Throwable unused) {
            a aVar = c.a;
            OkHttpClient okHttpClient = (OkHttpClient) aVar.a;
            if (okHttpClient != null) {
                return okHttpClient;
            }
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            try {
                dnsSafeDns = Spider.safeDns();
                Objects.requireNonNull(dnsSafeDns);
            } catch (Throwable unused2) {
                dnsSafeDns = Dns.SYSTEM;
            }
            OkHttpClient.Builder builderDns = builder.dns(dnsSafeDns);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder builderHostnameVerifier = builderDns.connectTimeout(15000L, timeUnit).readTimeout(15000L, timeUnit).writeTimeout(15000L, timeUnit).hostnameVerifier(new com.github.catvod.spider.merge.m.a());
            SSLContext sSLContext = null;
            try {
                SSLContext sSLContext2 = SSLContext.getInstance("TLS");
                sSLContext2.init(null, new TrustManager[]{new com.github.catvod.spider.merge.m.b()}, new SecureRandom());
                sSLContext = sSLContext2;
            } catch (Throwable unused3) {
            }
            OkHttpClient okHttpClientBuild = builderHostnameVerifier.sslSocketFactory(sSLContext.getSocketFactory(), new com.github.catvod.spider.merge.m.b()).build();
            aVar.a = okHttpClientBuild;
            return okHttpClientBuild;
        }
    }

    public static void e(String str) {
        Init.post(new com.github.catvod.spider.merge.o.c(str));
    }

    public static String f(String str, HashMap map) {
        String str2 = (String) new d("GET", str, null, map).g(d()).b;
        return TextUtils.isEmpty(str2) ? VideoStream.RESOLUTION_UNKNOWN : str2;
    }

    @Override // com.github.catvod.spider.merge.q1.u
    public void a(s sVar, int i) {
        StringBuilder sb = (StringBuilder) this.a;
        if (sVar instanceof n) {
            n nVar = (n) sVar;
            f0 f0Var = nVar.d;
            s sVarQ = sVar.q();
            if (!f0Var.b(1024) && (f0Var.d & 4) == 0) {
                for (int i2 = 0; i2 < nVar.e.size(); i2++) {
                    s sVarF = nVar.f(i2);
                    if (!(sVarF instanceof n) || !((n) sVarF).Q()) {
                    }
                }
                return;
            }
            if (((sVarQ instanceof z) || ((sVarQ instanceof n) && (((n) sVarQ).d.d & 4) == 0)) && !z.G(sb)) {
                sb.append(' ');
            }
        }
    }

    @Override // com.github.catvod.spider.merge.q1.u
    public void b(s sVar, int i) {
        char c;
        StringBuilder sb = (StringBuilder) this.a;
        if (sVar instanceof z) {
            n.F(sb, (z) sVar);
            return;
        }
        if (sVar instanceof n) {
            n nVar = (n) sVar;
            if (sb.length() > 0) {
                if (!nVar.Q() && !nVar.o("br")) {
                    if (!nVar.d.b(1024) || nVar.e.size() <= 0) {
                        return;
                    }
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    s sVarF = nVar;
                    int i2 = 0;
                    while (sVarF != null) {
                        char c2 = 1;
                        if (!(sVarF instanceof z) || i.f(((z) sVarF).D())) {
                            c = 1;
                        } else {
                            atomicBoolean.set(true);
                            c = 5;
                        }
                        if (c == 5) {
                            break;
                        }
                        if (c != 1 || sVarF.g() <= 0) {
                            while (sVarF.q() == null && i2 > 0) {
                                if (c == 1 || c == 2) {
                                    c = 1;
                                }
                                n nVar2 = sVarF.a;
                                i2--;
                                if (c == 4) {
                                    sVarF.z();
                                }
                                sVarF = nVar2;
                                c = 1;
                            }
                            if (c != 1 && c != 2) {
                                c2 = c;
                            }
                            if (sVarF == nVar) {
                                break;
                            }
                            s sVarQ = sVarF.q();
                            if (c2 == 4) {
                                sVarF.z();
                            }
                            sVarF = sVarQ;
                        } else {
                            sVarF = sVarF.f(0);
                            i2++;
                        }
                    }
                    if (!atomicBoolean.get()) {
                        return;
                    }
                }
                if (z.G(sb)) {
                    return;
                }
                sb.append(' ');
            }
        }
    }
}
