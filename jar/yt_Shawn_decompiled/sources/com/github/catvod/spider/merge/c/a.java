package com.github.catvod.spider.merge.c;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class a {

    @SerializedName("duration")
    private String a;

    @SerializedName("minBufferTime")
    private String b;

    @SerializedName("video")
    private List<c> c;

    @SerializedName("audio")
    private List<c> d;

    public final List a() {
        List<c> list = this.d;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final String b() {
        String str = this.a;
        return str == null ? "0" : str;
    }

    public final String c() {
        String str = this.b;
        return str == null ? "0" : str;
    }

    public final List d() {
        List<c> list = this.c;
        return list == null ? Collections.EMPTY_LIST : list;
    }
}
