package com.github.catvod.spider.jdollar.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c0 {
    public static final c0 LENIENT;
    public static final c0 SMART;
    public static final c0 STRICT;
    public static final /* synthetic */ c0[] a;

    static {
        c0 c0Var = new c0("STRICT", 0);
        STRICT = c0Var;
        c0 c0Var2 = new c0("SMART", 1);
        SMART = c0Var2;
        c0 c0Var3 = new c0("LENIENT", 2);
        LENIENT = c0Var3;
        a = new c0[]{c0Var, c0Var2, c0Var3};
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) a.clone();
    }
}
