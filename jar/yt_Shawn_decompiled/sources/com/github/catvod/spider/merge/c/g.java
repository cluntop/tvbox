package com.github.catvod.spider.merge.c;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class g {

    @SerializedName("code")
    private Integer a;

    @SerializedName("message")
    private String b;

    @SerializedName("data")
    private b c;

    public static g b(String str) {
        return (g) new Gson().fromJson(str, g.class);
    }

    public final b a() {
        b bVar = this.c;
        return bVar == null ? new b() : bVar;
    }
}
