package com.github.catvod.spider.merge.c;

import com.google.gson.annotations.SerializedName;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class c {

    @SerializedName("id")
    private String a;

    @SerializedName("baseUrl")
    private String b;

    @SerializedName("bandwidth")
    private String c;

    @SerializedName("mimeType")
    private String d;

    @SerializedName("codecs")
    private String e;

    @SerializedName("width")
    private String f;

    @SerializedName("height")
    private String g;

    @SerializedName("frameRate")
    private String h;

    @SerializedName("sar")
    private String i;

    @SerializedName("startWithSap")
    private String j;

    @SerializedName(YoutubeDashManifestCreatorsUtils.SEGMENT_BASE)
    private h k;

    @SerializedName("codecid")
    private String l;

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.l;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.h;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.a;
    }

    public final String h() {
        return this.d;
    }

    public final String i() {
        return this.i;
    }

    public final h j() {
        return this.k;
    }

    public final String k() {
        return this.j;
    }

    public final String l() {
        return this.f;
    }
}
