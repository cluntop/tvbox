package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.s;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class OffsetTime implements com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Comparable<OffsetTime>, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 7264499704384272492L;
    public final LocalTime a;
    public final ZoneOffset b;

    static {
        LocalTime localTime = LocalTime.e;
        ZoneOffset zoneOffset = ZoneOffset.g;
        localTime.getClass();
        of(localTime, zoneOffset);
        LocalTime localTime2 = LocalTime.f;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        localTime2.getClass();
        of(localTime2, zoneOffset2);
    }

    public OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        this.a = (LocalTime) Objects.requireNonNull(localTime, "time");
        this.b = (ZoneOffset) Objects.requireNonNull(zoneOffset, "offset");
    }

    public static OffsetTime of(LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetTime(localTime, zoneOffset);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 9, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS ? this.b.getTotalSeconds() : this.a.E(pVar) : pVar.y(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public final OffsetTime c(long j, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? T(this.a.c(j, temporalUnit), this.b) : (OffsetTime) temporalUnit.h(this, j);
    }

    public final OffsetTime T(LocalTime localTime, ZoneOffset zoneOffset) {
        return (this.a == localTime && this.b.equals(zoneOffset)) ? this : new OffsetTime(localTime, zoneOffset);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public final com.github.catvod.spider.jdollar.time.temporal.l b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (OffsetTime) pVar.A(this, j);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS;
        LocalTime localTime = this.a;
        if (pVar != aVar) {
            return T(localTime.b(j, pVar), this.b);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        return T(localTime, ZoneOffset.ofTotalSeconds(aVar2.b.a(j, aVar2)));
    }

    @Override // java.lang.Comparable
    public final int compareTo(OffsetTime offsetTime) {
        OffsetTime offsetTime2 = offsetTime;
        boolean zEquals = this.b.equals(offsetTime2.b);
        LocalTime localTime = this.a;
        if (zEquals) {
            return localTime.compareTo(offsetTime2.a);
        }
        int iCompare = Long.compare(localTime.d0() - (this.b.getTotalSeconds() * 1000000000), offsetTime2.a.d0() - (offsetTime2.b.getTotalSeconds() * 1000000000));
        return iCompare == 0 ? this.a.compareTo(offsetTime2.a) : iCompare;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S() || pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS : pVar != null && pVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetTime) {
            OffsetTime offsetTime = (OffsetTime) obj;
            if (this.a.equals(offsetTime.a) && this.b.equals(offsetTime.b)) {
                return true;
            }
        }
        return false;
    }

    public ZoneOffset getOffset() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return q.a(this, pVar);
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return (OffsetTime) com.github.catvod.spider.jdollar.com.android.tools.r8.a.a(localDate, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.i(this);
        }
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS) {
            return ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).b;
        }
        LocalTime localTime = this.a;
        localTime.getClass();
        return q.d(localTime, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(this.a.d0(), com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY).b(this.b.getTotalSeconds(), com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS);
    }

    public LocalTime toLocalTime() {
        return this.a;
    }

    public final String toString() {
        return this.a.toString() + this.b.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        if (mVar == q.d || mVar == q.e) {
            return this.b;
        }
        if (((mVar == q.a) || (mVar == q.b)) || mVar == q.f) {
            return null;
        }
        return mVar == q.g ? this.a : mVar == q.c ? ChronoUnit.NANOS : mVar.f(this);
    }
}
