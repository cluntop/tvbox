package com.github.catvod.spider.jdollar.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h8 {
    public static final h8 MAYBE_MORE;
    public static final h8 NO_MORE;
    public static final h8 UNLIMITED;
    public static final /* synthetic */ h8[] a;

    static {
        h8 h8Var = new h8("NO_MORE", 0);
        NO_MORE = h8Var;
        h8 h8Var2 = new h8("MAYBE_MORE", 1);
        MAYBE_MORE = h8Var2;
        h8 h8Var3 = new h8("UNLIMITED", 2);
        UNLIMITED = h8Var3;
        a = new h8[]{h8Var, h8Var2, h8Var3};
    }

    public static h8 valueOf(String str) {
        return (h8) Enum.valueOf(h8.class, str);
    }

    public static h8[] values() {
        return (h8[]) a.clone();
    }
}
