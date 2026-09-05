package com.github.catvod.spider.merge.i;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import okhttp3.HttpUrl;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class c {

    @SerializedName("name")
    private String a;

    @SerializedName("stream_id")
    private String b;

    @SerializedName("stream_type")
    private String c;

    @SerializedName("stream_icon")
    private String d;

    @SerializedName("epg_channel_id")
    private String e;

    @SerializedName("category_id")
    private String f;

    @SerializedName("container_extension")
    private String g;

    public static HttpUrl.Builder a(a aVar) {
        return new HttpUrl.Builder().scheme(aVar.d.scheme()).host(aVar.d.host()).port(aVar.d.port());
    }

    public final String b() {
        return TextUtils.isEmpty(this.f) ? VideoStream.RESOLUTION_UNKNOWN : this.f;
    }

    public final String c() {
        return TextUtils.isEmpty(this.g) ? VideoStream.RESOLUTION_UNKNOWN : this.g;
    }

    public final String d() {
        return TextUtils.isEmpty(this.e) ? VideoStream.RESOLUTION_UNKNOWN : this.e;
    }

    public final String e() {
        return TextUtils.isEmpty(this.a) ? VideoStream.RESOLUTION_UNKNOWN : this.a;
    }

    public final String f() {
        return TextUtils.isEmpty(this.d) ? VideoStream.RESOLUTION_UNKNOWN : this.d;
    }

    public final String g() {
        return TextUtils.isEmpty(this.b) ? VideoStream.RESOLUTION_UNKNOWN : this.b;
    }

    public final String h() {
        return TextUtils.isEmpty(this.c) ? VideoStream.RESOLUTION_UNKNOWN : this.c;
    }
}
