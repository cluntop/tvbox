package com.github.catvod.spider.merge.a;

import com.google.gson.annotations.SerializedName;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class h {

    @SerializedName("type_name")
    private String a;

    @SerializedName("vod_id")
    private String b;

    @SerializedName("vod_name")
    private String c;

    @SerializedName("vod_pic")
    private String d;

    @SerializedName("vod_remarks")
    private String e;

    @SerializedName("vod_year")
    private String f;

    @SerializedName("vod_area")
    private String g;

    @SerializedName("vod_actor")
    private String h;

    @SerializedName("vod_director")
    private String i;

    @SerializedName("vod_content")
    private String j;

    @SerializedName("vod_play_from")
    private String k;

    @SerializedName("vod_play_url")
    private String l;

    @SerializedName("vod_tag")
    private String m;

    @SerializedName("action")
    private String n;

    @SerializedName("style")
    private g o;

    public h(String str, String str2, String str3, String str4, boolean z) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.m = z ? "folder" : "file";
    }

    public final String a() {
        return this.b;
    }

    public final void b(String str) {
        this.n = str;
    }

    public final void c(String str) {
        this.a = str;
    }

    public final void d(String str) {
        this.j = str;
    }

    public final void e(String str) {
        this.i = str;
    }

    public final void f(String str) {
        this.b = str;
    }

    public final void g(String str) {
        this.c = str;
    }

    public final void h(String str) {
        this.d = str;
    }

    public final void i(String str) {
        this.k = str;
    }

    public final void j(String str) {
        this.l = str;
    }

    public final void k(String str) {
        this.e = str;
    }

    public final void l(String str) {
        this.m = str;
    }

    public final void m(String str) {
        this.f = str;
    }

    public h(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public h(String str, String str2, String str3, String str4) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public h(String str, String str2, String str3, g gVar, String str4) {
        this.b = VideoStream.RESOLUTION_UNKNOWN;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.o = gVar;
        this.n = str4;
    }

    public h() {
    }
}
