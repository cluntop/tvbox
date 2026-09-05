package com.github.catvod.spider.jdollar.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a7 {
    public static final a7 OP;
    public static final a7 SPLITERATOR;
    public static final a7 STREAM;
    public static final a7 TERMINAL_OP;
    public static final a7 UPSTREAM_TERMINAL_OP;
    public static final /* synthetic */ a7[] a;

    static {
        a7 a7Var = new a7("SPLITERATOR", 0);
        SPLITERATOR = a7Var;
        a7 a7Var2 = new a7("STREAM", 1);
        STREAM = a7Var2;
        a7 a7Var3 = new a7("OP", 2);
        OP = a7Var3;
        a7 a7Var4 = new a7("TERMINAL_OP", 3);
        TERMINAL_OP = a7Var4;
        a7 a7Var5 = new a7("UPSTREAM_TERMINAL_OP", 4);
        UPSTREAM_TERMINAL_OP = a7Var5;
        a = new a7[]{a7Var, a7Var2, a7Var3, a7Var4, a7Var5};
    }

    public static a7 valueOf(String str) {
        return (a7) Enum.valueOf(a7.class, str);
    }

    public static a7[] values() {
        return (a7[]) a.clone();
    }
}
