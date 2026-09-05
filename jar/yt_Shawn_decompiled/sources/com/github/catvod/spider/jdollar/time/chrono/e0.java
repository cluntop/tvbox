package com.github.catvod.spider.jdollar.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e0 implements n {
    public static final e0 BEFORE_ROC;
    public static final e0 ROC;
    public static final /* synthetic */ e0[] a;

    static {
        e0 e0Var = new e0("BEFORE_ROC", 0);
        BEFORE_ROC = e0Var;
        e0 e0Var2 = new e0("ROC", 1);
        ROC = e0Var2;
        a = new e0[]{e0Var, e0Var2};
    }

    public static e0 valueOf(String str) {
        return (e0) Enum.valueOf(e0.class, str);
    }

    public static e0[] values() {
        return (e0[]) a.clone();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return m.j(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return m.l(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.n
    public final int getValue() {
        return ordinal();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return m.h(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.time.temporal.q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(getValue(), com.github.catvod.spider.jdollar.time.temporal.a.ERA);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return m.m(this, mVar);
    }
}
