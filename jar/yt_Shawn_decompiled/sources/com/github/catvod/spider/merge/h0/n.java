package com.github.catvod.spider.merge.h0;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n implements m {
    public static final n c = new n("OK", 1, 200, "OK");
    public static final n d = new n("BAD_REQUEST", 12, 400, "Bad Request");
    public static final n e = new n("NOT_FOUND", 15, 404, "Not Found");
    public static final n f = new n("INTERNAL_ERROR", 28, 500, "Internal Server Error");
    public final int a;
    public final String b;

    public n(String str, int i, int i2, String str2) {
        this.a = i2;
        this.b = str2;
    }
}
