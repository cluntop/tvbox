package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.Duration;
import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    public final transient g a;
    public final transient ZoneOffset b;
    public final transient ZoneId c;

    public k(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        this.a = (g) Objects.requireNonNull(gVar, "dateTime");
        this.b = (ZoneOffset) Objects.requireNonNull(zoneOffset, "offset");
        this.c = (ZoneId) Objects.requireNonNull(zoneId, "zone");
    }

    public static k S(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        Objects.requireNonNull(gVar, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new k(zoneId, (ZoneOffset) zoneId, gVar);
        }
        com.github.catvod.spider.jdollar.time.zone.f fVarT = zoneId.T();
        LocalDateTime localDateTimeT = LocalDateTime.T(gVar);
        List listF = fVarT.f(localDateTimeT);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() == 0) {
            Object objE = fVarT.e(localDateTimeT);
            com.github.catvod.spider.jdollar.time.zone.b bVar = objE instanceof com.github.catvod.spider.jdollar.time.zone.b ? (com.github.catvod.spider.jdollar.time.zone.b) objE : null;
            gVar = gVar.U(gVar.a, 0L, 0L, Duration.i(bVar.d.getTotalSeconds() - bVar.c.getTotalSeconds(), 0).getSeconds(), 0L);
            zoneOffset = bVar.d;
        } else {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
            }
            gVar = gVar;
        }
        Objects.requireNonNull(zoneOffset, "offset");
        return new k(zoneId, zoneOffset, gVar);
    }

    public static k T(l lVar, Instant instant, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.T().d(instant);
        Objects.requireNonNull(zoneOffsetD, "offset");
        return new k(zoneId, zoneOffsetD, (g) lVar.D(LocalDateTime.V(instant.getEpochSecond(), instant.getNano(), zoneOffsetD)));
    }

    public static k o(l lVar, com.github.catvod.spider.jdollar.time.temporal.l lVar2) {
        k kVar = (k) lVar2;
        if (lVar.equals(kVar.a())) {
            return kVar;
        }
        com.github.catvod.spider.jdollar.nio.file.b.m("Chronology mismatch, required: ", lVar.getId(), kVar.a().getId());
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new f0((byte) 3, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return o(a(), com.github.catvod.spider.jdollar.time.temporal.q.b(this, j, chronoUnit));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        int i = i.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        return i != 1 ? i != 2 ? ((g) q()).E(pVar) : getOffset().getTotalSeconds() : R();
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final /* synthetic */ long R() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.k(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final k c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return o(a(), temporalUnit.h(this, j));
        }
        return o(a(), this.a.c(j, temporalUnit).o(this));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final l a() {
        return e().a();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public final com.github.catvod.spider.jdollar.time.temporal.l b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return o(a(), pVar.A(this, j));
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        int i = j.a[aVar.ordinal()];
        if (i == 1) {
            return c(j - com.github.catvod.spider.jdollar.com.android.tools.r8.a.k(this), ChronoUnit.SECONDS);
        }
        if (i != 2) {
            return S(this.c, this.b, this.a.b(j, pVar));
        }
        ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(aVar.b.a(j, aVar));
        g gVar = this.a;
        gVar.getClass();
        return T(a(), Instant.ofEpochSecond(com.github.catvod.spider.jdollar.com.android.tools.r8.a.j(gVar, zoneOffsetOfTotalSeconds), gVar.toLocalTime().getNano()), this.c);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ChronoZonedDateTime<?> chronoZonedDateTime) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.d(this, chronoZonedDateTime);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) {
            return true;
        }
        return pVar != null && pVar.h(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final b e() {
        return ((g) q()).e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && com.github.catvod.spider.jdollar.com.android.tools.r8.a.d(this, (ChronoZonedDateTime) obj) == 0;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final ZoneOffset getOffset() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final ZoneId getZone() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.e(this, pVar);
    }

    public final int hashCode() {
        return (this.a.hashCode() ^ this.b.b) ^ Integer.rotateLeft(this.c.hashCode(), 3);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return o(a(), localDate.o(this));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? (pVar == com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS || pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS) ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).b : this.a.j(pVar) : pVar.i(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final e q() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final Instant toInstant() {
        return Instant.ofEpochSecond(R(), toLocalTime().getNano());
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final LocalTime toLocalTime() {
        return ((g) q()).toLocalTime();
    }

    public final String toString() {
        String str = this.a.toString() + this.b.c;
        ZoneOffset zoneOffset = this.b;
        ZoneId zoneId = this.c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime x(ZoneId zoneId) {
        return S(zoneId, this.b, this.a);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.i(this, mVar);
    }
}
