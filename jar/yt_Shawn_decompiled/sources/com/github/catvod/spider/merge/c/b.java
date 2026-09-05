package com.github.catvod.spider.merge.c;

import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class b {

    @SerializedName("result")
    private JsonElement a;

    @SerializedName("list")
    private JsonElement b;

    @SerializedName("isLogin")
    private Boolean c;

    @SerializedName("vipStatus")
    private Integer d;

    @SerializedName("qrcode_key")
    private String e;

    @SerializedName("url")
    private String f;

    @SerializedName("aid")
    private String g;

    @SerializedName("cid")
    private String h;

    @SerializedName("title")
    private String i;

    @SerializedName("tname")
    private String j;

    @SerializedName("pic")
    private String k;

    @SerializedName("duration")
    private Long l;

    @SerializedName("desc")
    private String m;

    @SerializedName("accept_description")
    private List<String> n;

    @SerializedName("accept_quality")
    private List<Integer> o;

    @SerializedName("pages")
    private List<e> p;

    @SerializedName("dash")
    private a q;

    @SerializedName("owner")
    private d r;

    @SerializedName("wbi_img")
    private i s;

    public final List a() {
        List<String> list = this.n;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final List b() {
        List<Integer> list = this.o;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final String c() {
        return TextUtils.isEmpty(this.h) ? VideoStream.RESOLUTION_UNKNOWN : this.h;
    }

    public final a d() {
        a aVar = this.q;
        return aVar == null ? new a() : aVar;
    }

    public final String e() {
        return TextUtils.isEmpty(this.m) ? VideoStream.RESOLUTION_UNKNOWN : this.m;
    }

    public final Long f() {
        Long l = this.l;
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public final JsonElement g() {
        return this.b;
    }

    public final d h() {
        d dVar = this.r;
        return dVar == null ? new d() : dVar;
    }

    public final List i() {
        List<e> list = this.p;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final String j() {
        return TextUtils.isEmpty(this.k) ? VideoStream.RESOLUTION_UNKNOWN : this.k;
    }

    public final JsonElement k() {
        return this.a;
    }

    public final String l() {
        return TextUtils.isEmpty(this.i) ? VideoStream.RESOLUTION_UNKNOWN : this.i;
    }

    public final String m() {
        return TextUtils.isEmpty(this.j) ? VideoStream.RESOLUTION_UNKNOWN : this.j;
    }

    public final i n() {
        i iVar = this.s;
        return iVar == null ? new i() : iVar;
    }

    public final boolean o() {
        Boolean bool = this.c;
        return bool != null && bool.booleanValue();
    }

    public final boolean p() {
        Integer num = this.d;
        return (num == null || num.intValue() == 0) ? false : true;
    }
}
