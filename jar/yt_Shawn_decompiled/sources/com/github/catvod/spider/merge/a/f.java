package com.github.catvod.spider.merge.a;

import com.google.gson.annotations.SerializedName;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class f {

    @SerializedName("url")
    private String a;

    @SerializedName("name")
    private String b;

    @SerializedName("lang")
    private String c;

    @SerializedName("format")
    private String d;

    @SerializedName("flag")
    private int e;

    public final void a(String str) {
        str.getClass();
        switch (str) {
            case "ass":
            case "ssa":
                this.d = "text/x-ssa";
                break;
            case "vtt":
                this.d = "text/vtt";
                break;
            default:
                this.d = "application/x-subrip";
                break;
        }
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(String str) {
        this.a = str;
    }
}
