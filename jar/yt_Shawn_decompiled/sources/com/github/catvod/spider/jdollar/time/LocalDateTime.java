package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.time.temporal.s;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class LocalDateTime implements com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, com.github.catvod.spider.jdollar.time.chrono.e, Serializable {
    public static final LocalDateTime c = of(LocalDate.d, LocalTime.e);
    public static final LocalDateTime d = of(LocalDate.e, LocalTime.f);
    private static final long serialVersionUID = 6207766400415563566L;
    public final LocalDate a;
    public final LocalTime b;

    public LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.a = localDate;
        this.b = localTime;
    }

    public static LocalDateTime T(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).q();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.U(temporalAccessor), LocalTime.U(temporalAccessor));
        } catch (DateTimeException e) {
            com.github.catvod.spider.jdollar.nio.file.b.h("Unable to obtain LocalDateTime from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e);
            return null;
        }
    }

    public static LocalDateTime V(long j, int i, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j2 = i;
        com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND.E(j2);
        return new LocalDateTime(LocalDate.c0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j + zoneOffset.getTotalSeconds(), 86400L)), LocalTime.W((((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(r5, 86400L)) * 1000000000) + j2));
    }

    public static LocalDateTime now() {
        a aVarT = com.github.catvod.spider.jdollar.com.android.tools.r8.a.T();
        Objects.requireNonNull(aVarT, "clock");
        Instant instantOfEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        return V(instantOfEpochMilli.getEpochSecond(), instantOfEpochMilli.getNano(), aVarT.a.T().d(instantOfEpochMilli));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return V(instant.getEpochSecond(), instant.getNano(), zoneId.T().d(instant));
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.a(charSequence, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(3));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 5, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S() ? this.b.E(pVar) : this.a.E(pVar) : pVar.y(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final int compareTo(com.github.catvod.spider.jdollar.time.chrono.e eVar) {
        return eVar instanceof LocalDateTime ? S((LocalDateTime) eVar) : com.github.catvod.spider.jdollar.com.android.tools.r8.a.c(this, eVar);
    }

    public final int S(LocalDateTime localDateTime) {
        int iS = this.a.S(localDateTime.e());
        return iS == 0 ? this.b.compareTo(localDateTime.toLocalTime()) : iS;
    }

    public final boolean U(com.github.catvod.spider.jdollar.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return S((LocalDateTime) eVar) < 0;
        }
        long jF = ((LocalDate) e()).F();
        long jF2 = eVar.e().F();
        return jF < jF2 || (jF == jF2 && toLocalTime().d0() < eVar.toLocalTime().d0());
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.h(this, j);
        }
        switch (f.a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return Z(this.a, 0L, 0L, 0L, j);
            case 2:
                LocalDateTime localDateTimeX = X(j / 86400000000L);
                return localDateTimeX.Z(localDateTimeX.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimeX2 = X(j / 86400000);
                return localDateTimeX2.Z(localDateTimeX2.a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return Y(j);
            case 5:
                return Z(this.a, 0L, j, 0L, 0L);
            case 6:
                return Z(this.a, j, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimeX3 = X(j / 256);
                return localDateTimeX3.Z(localDateTimeX3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return b0(this.a.c(j, temporalUnit), this.b);
        }
    }

    public final LocalDateTime X(long j) {
        return b0(this.a.f0(j), this.b);
    }

    public final LocalDateTime Y(long j) {
        return Z(this.a, 0L, 0L, j, 0L);
    }

    public final LocalDateTime Z(LocalDate localDate, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        LocalTime localTime = this.b;
        if (j5 == 0) {
            return b0(localDate, localTime);
        }
        long j6 = j / 24;
        long j7 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
        long jD0 = localTime.d0();
        long j8 = j7 + jD0;
        long jZ = com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j8, 86400000000000L) + j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long jM = com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j8, 86400000000000L);
        return b0(localDate.f0(jZ), jM == jD0 ? this.b : LocalTime.W(jM));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.e
    public final com.github.catvod.spider.jdollar.time.chrono.l a() {
        return ((LocalDate) e()).a();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (LocalDateTime) pVar.A(this, j);
        }
        boolean zS = ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S();
        LocalDate localDate = this.a;
        return zS ? b0(localDate, this.b.b(j, pVar)) : b0(localDate.b(j, pVar), this.b);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.e
    /* renamed from: atZone, reason: merged with bridge method [inline-methods] */
    public ZonedDateTime B(ZoneId zoneId) {
        return ZonedDateTime.S(this, null, zoneId);
    }

    public final LocalDateTime b0(LocalDate localDate, LocalTime localTime) {
        return (this.a == localDate && this.b == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar != null && pVar.h(this);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        return aVar.isDateBased() || aVar.S();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.a.equals(localDateTime.a) && this.b.equals(localDateTime.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S() ? this.b.h(pVar) : this.a.h(pVar) : q.a(this, pVar);
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return b0(localDate, this.b);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.i(this);
        }
        if (!((com.github.catvod.spider.jdollar.time.temporal.a) pVar).S()) {
            return this.a.j(pVar);
        }
        LocalTime localTime = this.b;
        localTime.getClass();
        return q.d(localTime, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: minus, reason: merged with bridge method [inline-methods] */
    public LocalDateTime t(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? c(Long.MAX_VALUE, temporalUnit).c(1L, temporalUnit) : c(-j, temporalUnit);
    }

    public LocalDateTime minusDays(long j) {
        return j == Long.MIN_VALUE ? X(Long.MAX_VALUE).X(1L) : X(-j);
    }

    public LocalDateTime minusYears(long j) {
        LocalDate localDate = this.a;
        if (j != Long.MIN_VALUE) {
            return b0(localDate.i0(-j), this.b);
        }
        LocalDateTime localDateTimeB0 = b0(localDate.i0(Long.MAX_VALUE), this.b);
        return localDateTimeB0.b0(localDateTimeB0.a.i0(1L), localDateTimeB0.b);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(((LocalDate) e()).F(), com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY).b(toLocalTime().d0(), com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.e
    /* renamed from: toLocalDate, reason: merged with bridge method [inline-methods] */
    public LocalDate e() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.e
    public LocalTime toLocalTime() {
        return this.b;
    }

    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    public LocalDateTime truncatedTo(TemporalUnit temporalUnit) {
        LocalDate localDate = this.a;
        LocalTime localTimeW = this.b;
        localTimeW.getClass();
        if (temporalUnit != ChronoUnit.NANOS) {
            Duration duration = temporalUnit.getDuration();
            if (duration.getSeconds() > 86400) {
                throw new r("Unit is too large to be used for truncation");
            }
            long j = duration.a;
            long j2 = duration.b;
            if (j < 0) {
                j++;
                j2 -= 1000000000;
            }
            long jN = com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 1000000000L), j2);
            if (86400000000000L % jN != 0) {
                throw new r("Unit must divide into a standard day without remainder");
            }
            localTimeW = LocalTime.W((localTimeW.d0() / jN) * jN);
        }
        return b0(localDate, localTimeW);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == q.f ? this.a : com.github.catvod.spider.jdollar.com.android.tools.r8.a.h(this, mVar);
    }
}
