package com.github.catvod.spider.merge.h;

import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.spider.merge.a.h;
import com.github.catvod.spider.merge.o.e;
import com.google.gson.annotations.SerializedName;
import com.thegrizzlylabs.sardineandroid.DavResource;
import com.thegrizzlylabs.sardineandroid.impl.OkHttpSardine;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class a {

    @SerializedName("name")
    private String a;

    @SerializedName("server")
    private String b;

    @SerializedName("user")
    private String c;

    @SerializedName("pass")
    private String d;

    @SerializedName("path")
    private String e;
    public OkHttpSardine f;

    public a(String str) {
        this.a = str;
    }

    public final String a() {
        return (TextUtils.isEmpty(this.b) ? VideoStream.RESOLUTION_UNKNOWN : this.b).replace(c(), VideoStream.RESOLUTION_UNKNOWN);
    }

    public final String b() {
        return TextUtils.isEmpty(this.a) ? VideoStream.RESOLUTION_UNKNOWN : this.a;
    }

    public final String c() {
        return TextUtils.isEmpty(this.e) ? VideoStream.RESOLUTION_UNKNOWN : this.e;
    }

    public final OkHttpSardine d() {
        if (this.f == null) {
            OkHttpSardine okHttpSardine = new OkHttpSardine();
            this.f = okHttpSardine;
            boolean zIsEmpty = TextUtils.isEmpty(this.c);
            String str = VideoStream.RESOLUTION_UNKNOWN;
            okHttpSardine.setCredentials(zIsEmpty ? VideoStream.RESOLUTION_UNKNOWN : this.c, TextUtils.isEmpty(this.d) ? VideoStream.RESOLUTION_UNKNOWN : this.d);
            String path = Uri.parse(TextUtils.isEmpty(this.b) ? VideoStream.RESOLUTION_UNKNOWN : this.b).getPath();
            if (!TextUtils.isEmpty(path)) {
                str = path;
            }
            this.e = str;
        }
        return this.f;
    }

    public final h e(DavResource davResource, String str) {
        return new h(b() + davResource.getPath(), davResource.getName(), str, e.b(davResource.getContentLength().longValue()), davResource.isDirectory());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return b().equals(((a) obj).b());
        }
        return false;
    }
}
