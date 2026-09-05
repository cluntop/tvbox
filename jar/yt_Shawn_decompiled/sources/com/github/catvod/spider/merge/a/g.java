package com.github.catvod.spider.merge.a;

import com.google.gson.annotations.SerializedName;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class g {

    @SerializedName("type")
    private String a;

    @SerializedName("ratio")
    private Float b;

    public static g a() {
        Float fValueOf = Float.valueOf(1.0f);
        g gVar = new g();
        gVar.a = "rect";
        gVar.b = fValueOf;
        return gVar;
    }
}
