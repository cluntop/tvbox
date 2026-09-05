package com.github.catvod.spider.merge.z;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a {
    public static final a c = new a("NUMERIC", 1, new int[]{10, 12, 14}, 1);
    public static final a d = new a("ALPHANUMERIC", 2, new int[]{9, 11, 13}, 2);
    public static final a e = new a("BYTE", 4, new int[]{8, 16, 16}, 4);
    public static final a f = new a("KANJI", 6, new int[]{8, 10, 12}, 8);
    public final int[] a;
    public final int b;

    public a(String str, int i, int[] iArr, int i2) {
        this.a = iArr;
        this.b = i2;
    }

    public final int a(d dVar) {
        int i = dVar.a;
        return this.a[i <= 9 ? (char) 0 : i <= 26 ? (char) 1 : (char) 2];
    }
}
