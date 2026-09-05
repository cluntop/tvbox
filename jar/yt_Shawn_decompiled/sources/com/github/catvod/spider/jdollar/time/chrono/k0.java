package com.github.catvod.spider.jdollar.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k0 implements n {
    public static final k0 BE;
    public static final k0 BEFORE_BE;
    public static final /* synthetic */ k0[] a;

    static {
        k0 k0Var = new k0("BEFORE_BE", 0);
        BEFORE_BE = k0Var;
        k0 k0Var2 = new k0("BE", 1);
        BE = k0Var2;
        a = new k0[]{k0Var, k0Var2};
    }

    public static k0 valueOf(String str) {
        return (k0) Enum.valueOf(k0.class, str);
    }

    public static k0[] values() {
        return (k0[]) a.clone();
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
