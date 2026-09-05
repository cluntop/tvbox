package com.github.catvod.spider.merge.h0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j {
    public static final j a;
    public static final j b;
    public static final j c;
    public static final j d;
    public static final /* synthetic */ j[] e;

    /* JADX INFO: Fake field, exist only in values array */
    j EF0;

    static {
        j jVar = new j("GET", 0);
        j jVar2 = new j("PUT", 1);
        a = jVar2;
        j jVar3 = new j("POST", 2);
        b = jVar3;
        j jVar4 = new j("DELETE", 3);
        j jVar5 = new j("HEAD", 4);
        c = jVar5;
        j jVar6 = new j("OPTIONS", 5);
        d = jVar6;
        e = new j[]{jVar, jVar2, jVar3, jVar4, jVar5, jVar6, new j("TRACE", 6), new j("CONNECT", 7), new j("PATCH", 8), new j("PROPFIND", 9), new j("PROPPATCH", 10), new j("MKCOL", 11), new j("MOVE", 12), new j("COPY", 13), new j("LOCK", 14), new j("UNLOCK", 15)};
    }

    public static j a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return (j) Enum.valueOf(j.class, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static j[] values() {
        return (j[]) e.clone();
    }
}
