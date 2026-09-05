package com.github.catvod.spider.merge.f;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class b {

    @SerializedName("data")
    private List<b> a;

    @SerializedName("id")
    private String b;

    @SerializedName("name")
    private String c;

    @SerializedName("playing")
    private String d;

    @SerializedName("port")
    private String e;

    @SerializedName("stat")
    private c f;

    public final List a() {
        List<b> list = this.a;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final String b() {
        String str = this.b;
        return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
    }

    public final String c() {
        String str = this.c;
        return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
    }

    public final String d() {
        String str = this.d;
        return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
    }

    public final String e() {
        String str = this.e;
        return str == null ? VideoStream.RESOLUTION_UNKNOWN : str;
    }

    public final c f() {
        c cVar = this.f;
        return cVar == null ? new c() : cVar;
    }
}
