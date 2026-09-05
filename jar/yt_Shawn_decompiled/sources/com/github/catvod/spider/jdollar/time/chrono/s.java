package com.github.catvod.spider.jdollar.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s implements n {
    public static final s AH;
    public static final /* synthetic */ s[] a;

    static {
        s sVar = new s("AH", 0);
        AH = sVar;
        a = new s[]{sVar};
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) a.clone();
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
        return 1;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return m.h(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar == com.github.catvod.spider.jdollar.time.temporal.a.ERA ? com.github.catvod.spider.jdollar.time.temporal.s.f(1L, 1L) : com.github.catvod.spider.jdollar.time.temporal.q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(1L, com.github.catvod.spider.jdollar.time.temporal.a.ERA);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return m.m(this, mVar);
    }
}
