package com.github.catvod.spider.merge.m;

import android.text.TextUtils;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.n1.i;
import com.github.catvod.spider.merge.o1.g;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.o1.p;
import com.github.catvod.spider.merge.o1.r;
import com.github.catvod.spider.merge.o1.s;
import com.github.catvod.spider.merge.o1.z;
import com.github.catvod.spider.merge.q1.u;
import com.github.catvod.spider.merge.u.c2;
import java.io.IOException;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class d implements u {
    public final Object a;
    public final Object b;
    public final Object c;

    public d(String str, String str2, String str3, Map map) {
        this.c = str2;
        this.a = map;
        Request.Builder builder = new Request.Builder();
        str.equals("GET");
        if (str.equals("POST")) {
            builder.post(!TextUtils.isEmpty(str3) ? RequestBody.create(MediaType.get("application/json; charset=utf-8"), str3) : new FormBody.Builder().build());
        }
        if (map != null) {
            for (String str4 : map.keySet()) {
                builder.addHeader(str4, (String) map.get(str4));
            }
        }
        this.b = builder.url((String) this.c).build();
    }

    @Override // com.github.catvod.spider.merge.q1.u
    public void a(s sVar, int i) throws androidx.startup.b, IOException {
        if (sVar instanceof n) {
            e((n) sVar, i);
        }
    }

    @Override // com.github.catvod.spider.merge.q1.u
    public void b(s sVar, int i) throws androidx.startup.b, IOException {
        if (sVar.getClass() == z.class) {
            f((z) sVar, 0, i);
        } else if (sVar instanceof n) {
            c((n) sVar, i);
        } else {
            d((r) sVar, i);
        }
    }

    public void c(n nVar, int i) throws androidx.startup.b, IOException {
        nVar.v((com.github.catvod.spider.merge.n1.a) this.b, (g) this.c);
    }

    public void d(r rVar, int i) {
        rVar.v((com.github.catvod.spider.merge.n1.a) this.b, (g) this.c);
    }

    public void e(n nVar, int i) throws androidx.startup.b, IOException {
        nVar.R((com.github.catvod.spider.merge.n1.a) this.b, (g) this.c);
    }

    public void f(z zVar, int i, int i2) {
        com.github.catvod.spider.merge.n1.a aVar = (com.github.catvod.spider.merge.n1.a) this.b;
        String strD = zVar.D();
        g gVar = (g) this.c;
        p.c(strD, aVar, gVar.a, gVar.b, i | 1);
    }

    public com.github.catvod.spider.merge.g1.b g(OkHttpClient okHttpClient) {
        try {
            Response responseExecute = okHttpClient.newCall((Request) this.b).execute();
            try {
                responseExecute.code();
                com.github.catvod.spider.merge.g1.b bVar = new com.github.catvod.spider.merge.g1.b(responseExecute.body().string(), responseExecute.headers().toMultimap());
                responseExecute.close();
                return bVar;
            } finally {
            }
        } catch (IOException e) {
            SpiderDebug.log(e);
            return new com.github.catvod.spider.merge.g1.b(4);
        }
    }

    public void h(int i) throws androidx.startup.b, IOException {
        String strValueOf;
        com.github.catvod.spider.merge.n1.a aVarA = ((com.github.catvod.spider.merge.n1.a) this.b).a('\n');
        g gVar = (g) this.c;
        int iMin = i * gVar.d;
        int i2 = gVar.e;
        String[] strArr = i.a;
        c2.H("width must be >= 0", iMin >= 0);
        c2.I(i2 >= -1);
        if (i2 != -1) {
            iMin = Math.min(iMin, i2);
        }
        String[] strArr2 = i.a;
        if (iMin < 21) {
            strValueOf = strArr2[iMin];
        } else {
            char[] cArr = new char[iMin];
            for (int i3 = 0; i3 < iMin; i3++) {
                cArr[i3] = ' ';
            }
            strValueOf = String.valueOf(cArr);
        }
        aVarA.b(strValueOf);
    }

    public d(s sVar, com.github.catvod.spider.merge.n1.a aVar, g gVar) {
        this.a = sVar;
        this.b = aVar;
        this.c = gVar;
    }
}
