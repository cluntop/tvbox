package com.github.catvod.spider.merge.i;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class a {

    @SerializedName("vod")
    private boolean a;

    @SerializedName("live")
    private boolean b;

    @SerializedName("formats")
    private List<String> c;
    public HttpUrl d;
    public String e;
    public String f;

    public final List a() {
        List<String> list = this.c;
        return list == null ? Arrays.asList("ts") : list;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.a;
    }
}
