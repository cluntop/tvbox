package com.github.catvod.spider.jdollar.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c7 {
    public static final c7 DOUBLE_VALUE;
    public static final c7 INT_VALUE;
    public static final c7 LONG_VALUE;
    public static final c7 REFERENCE;
    public static final /* synthetic */ c7[] a;

    static {
        c7 c7Var = new c7("REFERENCE", 0);
        REFERENCE = c7Var;
        c7 c7Var2 = new c7("INT_VALUE", 1);
        INT_VALUE = c7Var2;
        c7 c7Var3 = new c7("LONG_VALUE", 2);
        LONG_VALUE = c7Var3;
        c7 c7Var4 = new c7("DOUBLE_VALUE", 3);
        DOUBLE_VALUE = c7Var4;
        a = new c7[]{c7Var, c7Var2, c7Var3, c7Var4};
    }

    public static c7 valueOf(String str) {
        return (c7) Enum.valueOf(c7.class, str);
    }

    public static c7[] values() {
        return (c7[]) a.clone();
    }
}
