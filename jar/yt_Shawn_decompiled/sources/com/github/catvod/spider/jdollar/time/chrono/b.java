package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface b extends com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Comparable {
    long F();

    e G(LocalTime localTime);

    n H();

    b L(com.github.catvod.spider.jdollar.time.temporal.o oVar);

    int O();

    /* renamed from: P */
    int compareTo(b bVar);

    l a();

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    b b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar);

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    b c(long j, TemporalUnit temporalUnit);

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar);

    boolean equals(Object obj);

    int hashCode();

    boolean r();

    b t(long j, TemporalUnit temporalUnit);

    String toString();

    b z(com.github.catvod.spider.jdollar.time.temporal.m mVar);
}
