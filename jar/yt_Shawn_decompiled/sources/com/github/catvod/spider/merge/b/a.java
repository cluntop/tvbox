package com.github.catvod.spider.merge.b;

import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class a {

    @SerializedName("params")
    private List<e> a;

    @SerializedName("login")
    private d b;

    @SerializedName("name")
    private String c;

    @SerializedName("server")
    private String d;

    @SerializedName("version")
    private int e;

    @SerializedName("path")
    private String f;

    @SerializedName("token")
    private String g;

    @SerializedName("search")
    private Boolean h;

    @SerializedName("hidden")
    private Boolean i;

    public a(String str) {
        this.c = str;
    }

    public final void a() {
        if (this.f == null) {
            boolean zIsEmpty = TextUtils.isEmpty(this.d);
            String str = VideoStream.RESOLUTION_UNKNOWN;
            String path = Uri.parse(zIsEmpty ? VideoStream.RESOLUTION_UNKNOWN : this.d).getPath();
            if (!TextUtils.isEmpty(path)) {
                str = path;
            }
            this.f = str;
        }
        if (this.e == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(d());
            sb.append("/api/public/settings");
            this.e = com.github.catvod.spider.merge.g1.a.f(sb.toString(), null).contains("v2.") ? 2 : 3;
        }
    }

    public final String b(String str) {
        List<e> arrayList = this.a;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        for (e eVar : arrayList) {
            if (str.startsWith(eVar.b())) {
                return eVar.a();
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public final HashMap c() {
        HashMap map = new HashMap();
        map.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36");
        if (!(TextUtils.isEmpty(this.g) ? VideoStream.RESOLUTION_UNKNOWN : this.g).isEmpty()) {
            map.put("Authorization", this.g);
        }
        return map;
    }

    public final String d() {
        return (TextUtils.isEmpty(this.d) ? VideoStream.RESOLUTION_UNKNOWN : this.d).replace(g(), VideoStream.RESOLUTION_UNKNOWN);
    }

    public final d e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return f().equals(((a) obj).f());
        }
        return false;
    }

    public final String f() {
        return TextUtils.isEmpty(this.c) ? VideoStream.RESOLUTION_UNKNOWN : this.c;
    }

    public final String g() {
        return TextUtils.isEmpty(this.f) ? VideoStream.RESOLUTION_UNKNOWN : this.f;
    }

    public final Boolean h() {
        Boolean bool = this.i;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public final boolean i() {
        return this.e == 3;
    }

    public final String j(String str) {
        if (!i()) {
            HashMap map = new HashMap();
            map.put("keyword", str);
            map.put("path", "/");
            return new Gson().toJson(map);
        }
        HashMap map2 = new HashMap();
        map2.put("keywords", str);
        map2.put("page", 1);
        map2.put("parent", "/");
        map2.put("per_page", 100);
        return new Gson().toJson(map2);
    }

    public final Boolean k() {
        Boolean bool = this.h;
        return Boolean.valueOf(bool == null || bool.booleanValue());
    }

    public final void l(String str) {
        this.g = str;
    }
}
