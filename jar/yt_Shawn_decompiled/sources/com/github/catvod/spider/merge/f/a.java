package com.github.catvod.spider.merge.f;

import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class a {

    @SerializedName("name")
    private String a;

    @SerializedName("url")
    private String b;
    public List c;
    public List d;
    public Uri e;

    public a(String str) {
        this.b = str;
    }

    public final List a() {
        b bVar;
        List listA = this.d;
        if (listA == null) {
            com.github.catvod.spider.merge.m.d dVar = new com.github.catvod.spider.merge.m.d("GET", d() + "/api/post?item=itv_traffic", null, null);
            OkHttpClient.Builder builderNewBuilder = com.github.catvod.spider.merge.g1.a.d().newBuilder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            String str = (String) dVar.g(builderNewBuilder.connectTimeout(3000L, timeUnit).readTimeout(3000L, timeUnit).writeTimeout(3000L, timeUnit).build()).b;
            if (TextUtils.isEmpty(str)) {
                str = VideoStream.RESOLUTION_UNKNOWN;
            }
            try {
                bVar = (b) new Gson().fromJson(str, b.class);
                if (bVar == null) {
                    bVar = new b();
                }
            } catch (Exception unused) {
                bVar = new b();
            }
            listA = bVar.a();
        }
        this.d = listA;
        return listA;
    }

    public final String b() {
        String str = this.a;
        return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
    }

    public final String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(Utils.HTTP);
        Uri uri = this.e;
        if (uri == null) {
            uri = Uri.parse(d());
        }
        this.e = uri;
        sb.append(uri.getHost());
        sb.append(":");
        sb.append(str);
        sb.append("/");
        sb.append(str2.replace(":/", VideoStream.RESOLUTION_UNKNOWN));
        return sb.toString();
    }

    public final String d() {
        String str = this.b;
        return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
    }

    public final List e() {
        List arrayList = this.c;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        this.c = arrayList;
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return d().equals(((a) obj).d());
        }
        return false;
    }
}
