package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime;
import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.time.temporal.s;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ZonedDateTime implements com.github.catvod.spider.jdollar.time.temporal.l, ChronoZonedDateTime<LocalDate>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;
    public final LocalDateTime a;
    public final ZoneOffset b;
    public final ZoneId c;

    public ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.a = localDateTime;
        this.b = zoneOffset;
        this.c = zoneId;
    }

    public static ZonedDateTime S(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        com.github.catvod.spider.jdollar.time.zone.f fVarT = zoneId.T();
        List listF = fVarT.f(localDateTime);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() == 0) {
            Object objE = fVarT.e(localDateTime);
            com.github.catvod.spider.jdollar.time.zone.b bVar = objE instanceof com.github.catvod.spider.jdollar.time.zone.b ? (com.github.catvod.spider.jdollar.time.zone.b) objE : null;
            localDateTime = localDateTime.Y(Duration.i(bVar.d.getTotalSeconds() - bVar.c.getTotalSeconds(), 0).getSeconds());
            zoneOffset = bVar.d;
        } else if (zoneOffset == null || !listF.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) Objects.requireNonNull((ZoneOffset) listF.get(0), "offset");
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    public static ZonedDateTime o(long j, int i, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.T().d(Instant.ofEpochSecond(j, i));
        return new ZonedDateTime(LocalDateTime.V(j, i, zoneOffsetD), zoneOffsetD, zoneId);
    }

    public static ZonedDateTime ofInstant(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneOffset, "offset");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId.T().f(localDateTime).contains(zoneOffset)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        localDateTime.getClass();
        return o(com.github.catvod.spider.jdollar.com.android.tools.r8.a.j(localDateTime, zoneOffset), localDateTime.b.getNano(), zoneId);
    }

    public static ZonedDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (ZonedDateTime) dateTimeFormatter.a(charSequence, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(5));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 6, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        int i = p.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        return i != 1 ? i != 2 ? this.a.E(pVar) : getOffset().getTotalSeconds() : com.github.catvod.spider.jdollar.com.android.tools.r8.a.k(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final /* synthetic */ long R() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.k(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ZonedDateTime) temporalUnit.h(this, j);
        }
        boolean zIsDateBased = temporalUnit.isDateBased();
        LocalDateTime localDateTime = this.a;
        if (!zIsDateBased) {
            return ofInstant(localDateTime.c(j, temporalUnit), this.b, this.c);
        }
        return S(localDateTime.c(j, temporalUnit), this.b, this.c);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final com.github.catvod.spider.jdollar.time.chrono.l a() {
        return ((LocalDate) e()).a();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public final com.github.catvod.spider.jdollar.time.temporal.l b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (ZonedDateTime) pVar.A(this, j);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        int i = p.a[aVar.ordinal()];
        if (i == 1) {
            return o(j, this.a.b.getNano(), this.c);
        }
        if (i != 2) {
            return S(this.a.b(j, pVar), this.b, this.c);
        }
        ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(aVar.b.a(j, aVar));
        return (zoneOffsetOfTotalSeconds.equals(this.b) || !this.c.T().f(this.a).contains(zoneOffsetOfTotalSeconds)) ? this : new ZonedDateTime(this.a, zoneOffsetOfTotalSeconds, this.c);
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
    public final com.github.catvod.spider.jdollar.time.chrono.b e() {
        return this.a.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.a.equals(zonedDateTime.a) && this.b.equals(zonedDateTime.b) && this.c.equals(zonedDateTime.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public ZoneOffset getOffset() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public ZoneId getZone() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return com.github.catvod.spider.jdollar.com.android.tools.r8.a.e(this, pVar);
        }
        int i = p.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.h(pVar) : getOffset().getTotalSeconds();
        }
        throw new r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public final int hashCode() {
        return (this.a.hashCode() ^ this.b.b) ^ Integer.rotateLeft(this.c.hashCode(), 3);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return S(LocalDateTime.of(localDate, this.a.toLocalTime()), this.b, this.c);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? (pVar == com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS || pVar == com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS) ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).b : this.a.j(pVar) : pVar.i(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final Instant toInstant() {
        return Instant.ofEpochSecond(R(), toLocalTime().getNano());
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    /* renamed from: toLocalDateTime, reason: merged with bridge method [inline-methods] */
    public LocalDateTime q() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime
    public final LocalTime toLocalTime() {
        return this.a.toLocalTime();
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
        Objects.requireNonNull(zoneId, "zone");
        return this.c.equals(zoneId) ? this : S(this.a, this.b, zoneId);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == q.f ? this.a.e() : com.github.catvod.spider.jdollar.com.android.tools.r8.a.i(this, mVar);
    }
}
