package com.github.catvod.spider.merge.a;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class e {

    @SerializedName("class")
    private List<a> a;

    @SerializedName("list")
    private List<h> b;

    @SerializedName("filters")
    private LinkedHashMap<String, List<d>> c;

    @SerializedName("header")
    private String d;

    @SerializedName("format")
    private String e;

    @SerializedName("danmaku")
    private List<b> f;

    @SerializedName("click")
    private String g;

    @SerializedName("msg")
    private String h;

    @SerializedName("url")
    private Object i;

    @SerializedName("subs")
    private List<f> j;

    @SerializedName("parse")
    private int k;

    @SerializedName("jx")
    private int l;

    @SerializedName("page")
    private Integer m;

    @SerializedName("pagecount")
    private Integer n;

    @SerializedName("limit")
    private Integer o;

    @SerializedName("total")
    private Integer p;

    public static String c(String str) {
        e eVar = new e();
        eVar.b = Collections.EMPTY_LIST;
        eVar.h = str;
        return eVar.toString();
    }

    public static String f(String str) {
        e eVar = new e();
        eVar.h = str;
        return eVar.toString();
    }

    public static String j(h hVar) {
        e eVar = new e();
        eVar.b = Arrays.asList(hVar);
        return eVar.toString();
    }

    public static String k(JsonElement jsonElement, ArrayList arrayList) {
        e eVar = new e();
        eVar.a = arrayList;
        if (jsonElement != null) {
            eVar.c = (LinkedHashMap) new Gson().fromJson(jsonElement.toString(), TypeToken.getParameterized(LinkedHashMap.class, new Type[]{String.class, TypeToken.getParameterized(List.class, new Type[]{d.class}).getType()}).getType());
        }
        return eVar.toString();
    }

    public static String l(ArrayList arrayList, ArrayList arrayList2) {
        e eVar = new e();
        eVar.a = arrayList;
        eVar.b = arrayList2;
        return eVar.toString();
    }

    public static String m(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        e eVar = new e();
        eVar.a = arrayList;
        eVar.c = linkedHashMap;
        return eVar.toString();
    }

    public static String n(ArrayList arrayList, JSONObject jSONObject) {
        e eVar = new e();
        eVar.a = arrayList;
        eVar.c = (LinkedHashMap) new Gson().fromJson(jSONObject.toString(), TypeToken.getParameterized(LinkedHashMap.class, new Type[]{String.class, TypeToken.getParameterized(List.class, new Type[]{d.class}).getType()}).getType());
        return eVar.toString();
    }

    public static String o(List list) {
        if (list != null && !list.isEmpty()) {
            if (list.get(0) instanceof h) {
                e eVar = new e();
                eVar.b = list;
                return eVar.toString();
            }
            if (list.get(0) instanceof a) {
                e eVar2 = new e();
                eVar2.a = list;
                return eVar2.toString();
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    public final void a(List list) {
        this.f = list;
    }

    public final void b() {
        this.e = "application/dash+xml";
    }

    public final void d(HashMap map) {
        if (map.isEmpty()) {
            return;
        }
        this.d = new Gson().toJson(map);
    }

    public final void e() {
        this.l = 1;
    }

    public final void g(int i, int i2, int i3, int i4) {
        if (i <= 0) {
            i = ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;
        }
        this.m = Integer.valueOf(i);
        if (i3 <= 0) {
            i3 = ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;
        }
        this.o = Integer.valueOf(i3);
        if (i4 <= 0) {
            i4 = ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;
        }
        this.p = Integer.valueOf(i4);
        if (i2 <= 0) {
            i2 = ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;
        }
        this.n = Integer.valueOf(i2);
    }

    public final void h() {
        this.k = 1;
    }

    public final void i() {
        this.k = 0;
    }

    public final void p(ArrayList arrayList) {
        this.j = arrayList;
    }

    public final void q(String str) {
        this.i = str;
    }

    public final void r(ArrayList arrayList) {
        this.i = arrayList;
    }

    public final void s(List list) {
        this.b = list;
    }

    public final String toString() {
        return new Gson().newBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
