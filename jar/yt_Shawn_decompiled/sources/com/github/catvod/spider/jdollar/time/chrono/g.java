package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g implements e, com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;
    public final transient b a;
    public final transient LocalTime b;

    public g(b bVar, LocalTime localTime) {
        Objects.requireNonNull(bVar, "date");
        Objects.requireNonNull(localTime, "time");
        this.a = bVar;
        this.b = localTime;
    }

    public static g S(l lVar, com.github.catvod.spider.jdollar.time.temporal.l lVar2) {
        g gVar = (g) lVar2;
        if (lVar.equals(gVar.a.a())) {
            return gVar;
        }
        com.github.catvod.spider.jdollar.nio.file.b.m("Chronology mismatch, required: ", lVar.getId(), gVar.a.a().getId());
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new f0((byte) 2, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return S(this.a.a(), com.github.catvod.spider.jdollar.time.temporal.q.b(this, j, chronoUnit));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.e
    public final ChronoZonedDateTime B(ZoneId zoneId) {
        return k.S(zoneId, null, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S() ? this.b.E(pVar) : this.a.E(pVar) : pVar.y(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: J */
    public final /* synthetic */ int compareTo(e eVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.c(this, eVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final g c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return S(this.a.a(), temporalUnit.h(this, j));
        }
        switch (f.a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return U(this.a, 0L, 0L, 0L, j);
            case 2:
                g gVarW = W(this.a.c(j / 86400000000L, (TemporalUnit) ChronoUnit.DAYS), this.b);
                return gVarW.U(gVarW.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                g gVarW2 = W(this.a.c(j / 86400000, (TemporalUnit) ChronoUnit.DAYS), this.b);
                return gVarW2.U(gVarW2.a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return U(this.a, 0L, 0L, j, 0L);
            case 5:
                return U(this.a, 0L, j, 0L, 0L);
            case 6:
                return U(this.a, j, 0L, 0L, 0L);
            case 7:
                g gVarW3 = W(this.a.c(j / 256, (TemporalUnit) ChronoUnit.DAYS), this.b);
                return gVarW3.U(gVarW3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return W(this.a.c(j, temporalUnit), this.b);
        }
    }

    public final g U(b bVar, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        LocalTime localTime = this.b;
        if (j5 == 0) {
            return W(bVar, localTime);
        }
        long j6 = j / 24;
        long j7 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
        long jD0 = localTime.d0();
        long j8 = j7 + jD0;
        long jZ = com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j8, 86400000000000L) + j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long jM = com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j8, 86400000000000L);
        return W(bVar.c(jZ, (TemporalUnit) ChronoUnit.DAYS), jM == jD0 ? this.b : LocalTime.W(jM));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final g b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return S(this.a.a(), pVar.A(this, j));
        }
        boolean zS = ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S();
        b bVar = this.a;
        return zS ? W(bVar, this.b.b(j, pVar)) : W(bVar.b(j, pVar), this.b);
    }

    public final g W(com.github.catvod.spider.jdollar.time.temporal.l lVar, LocalTime localTime) {
        b bVar = this.a;
        return (bVar == lVar && this.b == localTime) ? this : new g(d.S(bVar.a(), lVar), localTime);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.e
    public final l a() {
        return this.a.a();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar != null && pVar.h(this);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        return aVar.isDateBased() || aVar.S();
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.e
    public final b e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && com.github.catvod.spider.jdollar.com.android.tools.r8.a.c(this, (e) obj) == 0;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S() ? this.b.h(pVar) : this.a.h(pVar) : j(pVar).a(E(pVar), pVar);
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return W(localDate, this.b);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.i(this);
        }
        if (!((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S()) {
            return this.a.j(pVar);
        }
        LocalTime localTime = this.b;
        localTime.getClass();
        return com.github.catvod.spider.jdollar.time.temporal.q.d(localTime, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(e().F(), com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY).b(toLocalTime().d0(), com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.e
    public final LocalTime toLocalTime() {
        return this.b;
    }

    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.h(this, mVar);
    }
}
