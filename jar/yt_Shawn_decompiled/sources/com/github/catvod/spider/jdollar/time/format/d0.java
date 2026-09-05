package com.github.catvod.spider.jdollar.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d0 {
    public static final d0 ALWAYS;
    public static final d0 EXCEEDS_PAD;
    public static final d0 NEVER;
    public static final d0 NORMAL;
    public static final d0 NOT_NEGATIVE;
    public static final /* synthetic */ d0[] a;

    static {
        d0 d0Var = new d0("NORMAL", 0);
        NORMAL = d0Var;
        d0 d0Var2 = new d0("ALWAYS", 1);
        ALWAYS = d0Var2;
        d0 d0Var3 = new d0("NEVER", 2);
        NEVER = d0Var3;
        d0 d0Var4 = new d0("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = d0Var4;
        d0 d0Var5 = new d0("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = d0Var5;
        a = new d0[]{d0Var, d0Var2, d0Var3, d0Var4, d0Var5};
    }

    public static d0 valueOf(String str) {
        return (d0) Enum.valueOf(d0.class, str);
    }

    public static d0[] values() {
        return (d0[]) a.clone();
    }
}
