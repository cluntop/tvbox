package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.chrono.t;
import com.github.catvod.spider.jdollar.time.chrono.u;
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
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class LocalDate implements com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, com.github.catvod.spider.jdollar.time.chrono.b, Serializable {
    public static final LocalDate d = of(-999999999, 1, 1);
    public static final LocalDate e = of(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;
    public final int a;
    public final short b;
    public final short c;

    static {
        of(1970, 1, 1);
    }

    public LocalDate(int i, int i2, int i3) {
        this.a = i;
        this.b = (short) i2;
        this.c = (short) i3;
    }

    public static LocalDate T(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (t.c.Q(i)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    com.github.catvod.spider.jdollar.nio.file.b.e("Invalid date 'February 29' as '", i, "' is not a leap year");
                    return null;
                }
                throw new DateTimeException("Invalid date '" + i.V(i2).name() + Stream.ID_UNKNOWN + i3 + "'");
            }
        }
        return new LocalDate(i, i2, i3);
    }

    public static LocalDate U(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalDate localDate = (LocalDate) temporalAccessor.y(q.f);
        if (localDate != null) {
            return localDate;
        }
        com.github.catvod.spider.jdollar.nio.file.b.g("Unable to obtain LocalDate from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public static LocalDate b0(a aVar) {
        Objects.requireNonNull(aVar, "clock");
        Instant instantOfEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zoneId = aVar.a;
        Objects.requireNonNull(instantOfEpochMilli, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return c0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(instantOfEpochMilli.getEpochSecond() + zoneId.T().d(instantOfEpochMilli).getTotalSeconds(), 86400L));
    }

    public static LocalDate c0(long j) {
        long j2;
        com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY.E(j);
        long j3 = 719468 + j;
        if (j3 < 0) {
            long j4 = ((j + 719469) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        int i3 = ((i2 + 2) % 12) + 1;
        int i4 = (i - (((i2 * 306) + 5) / 10)) + 1;
        long j7 = j5 + j2 + (i2 / 10);
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        return new LocalDate(aVar.b.a(j7, aVar), i3, i4);
    }

    public static LocalDate d0(int i, int i2) {
        long j = i;
        com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(j);
        com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_YEAR.E(i2);
        boolean zQ = t.c.Q(j);
        if (i2 == 366 && !zQ) {
            com.github.catvod.spider.jdollar.nio.file.b.e("Invalid date 'DayOfYear 366' as '", i, "' is not a leap year");
            return null;
        }
        i iVarV = i.V(((i2 - 1) / 31) + 1);
        if (i2 > (iVarV.T(zQ) + iVarV.S(zQ)) - 1) {
            iVarV = i.a[(iVarV.ordinal() + 13) % 12];
        }
        return new LocalDate(i, iVarV.getValue(), (i2 - iVarV.S(zQ)) + 1);
    }

    public static LocalDate j0(int i, int i2, int i3) {
        if (i2 == 2) {
            i3 = Math.min(i3, t.c.Q((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return new LocalDate(i, i2, i3);
    }

    public static LocalDate of(int i, int i2, int i3) {
        com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(i);
        com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR.E(i2);
        com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH.E(i3);
        return T(i, i2, i3);
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.a(charSequence, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 3, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY ? F() : pVar == com.github.catvod.spider.jdollar.time.temporal.a.PROLEPTIC_MONTH ? ((this.a * 12) + this.b) - 1 : V(pVar) : pVar.y(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final long F() {
        long j = this.a;
        long j2 = this.b;
        long j3 = 365 * j;
        long j4 = (((367 * j2) - 362) / 12) + (j >= 0 ? ((j + 399) / 400) + (((3 + j) / 4) - ((99 + j) / 100)) + j3 : j3 - ((j / (-400)) + ((j / (-4)) - (j / (-100))))) + (this.c - 1);
        if (j2 > 2) {
            j4 = !r() ? j4 - 2 : j4 - 1;
        }
        return j4 - 719528;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final com.github.catvod.spider.jdollar.time.chrono.e G(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final com.github.catvod.spider.jdollar.time.chrono.n H() {
        return getYear() >= 1 ? u.CE : u.BCE;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final com.github.catvod.spider.jdollar.time.chrono.b L(com.github.catvod.spider.jdollar.time.temporal.o oVar) {
        if (oVar != null) {
            Period period = (Period) oVar;
            return g0((period.a * 12) + period.b).f0(period.getDays());
        }
        Objects.requireNonNull(oVar, "amountToAdd");
        return (LocalDate) ((Period) oVar).h(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final int O() {
        return r() ? 366 : 365;
    }

    @Override // java.lang.Comparable
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public final int compareTo(com.github.catvod.spider.jdollar.time.chrono.b bVar) {
        return bVar instanceof LocalDate ? S((LocalDate) bVar) : com.github.catvod.spider.jdollar.com.android.tools.r8.a.b(this, bVar);
    }

    public final int S(LocalDate localDate) {
        int i = this.a - localDate.a;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - localDate.b;
        return i2 == 0 ? this.c - localDate.c : i2;
    }

    public final int V(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        switch (e.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()]) {
            case 1:
                return this.c;
            case 2:
                return X();
            case 3:
                return ((this.c - 1) / 7) + 1;
            case 4:
                int i = this.a;
                return i >= 1 ? i : 1 - i;
            case 5:
                return W().getValue();
            case 6:
                return ((this.c - 1) % 7) + 1;
            case 7:
                return ((X() - 1) % 7) + 1;
            case 8:
                throw new r("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((X() - 1) / 7) + 1;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return this.b;
            case 11:
                throw new r("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return this.a;
            case 13:
                return this.a >= 1 ? 1 : 0;
            default:
                throw new r(b.a("Unsupported field: ", pVar));
        }
    }

    public final c W() {
        return c.S(((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(F() + 3, 7L)) + 1);
    }

    public final int X() {
        return (i.V(this.b).S(r()) + this.c) - 1;
    }

    public final boolean Y(com.github.catvod.spider.jdollar.time.chrono.b bVar) {
        return bVar instanceof LocalDate ? S((LocalDate) bVar) < 0 : F() < bVar.F();
    }

    public final int Z() {
        short s = this.b;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : r() ? 29 : 28;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final com.github.catvod.spider.jdollar.time.chrono.l a() {
        return t.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    /* renamed from: a0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final LocalDate t(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? c(Long.MAX_VALUE, temporalUnit).c(1L, temporalUnit) : c(-j, temporalUnit);
    }

    public ZonedDateTime atStartOfDay(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        LocalDateTime localDateTimeOf = LocalDateTime.of(this, LocalTime.g);
        if (!(zoneId instanceof ZoneOffset)) {
            Object objE = zoneId.T().e(localDateTimeOf);
            com.github.catvod.spider.jdollar.time.zone.b bVar = objE instanceof com.github.catvod.spider.jdollar.time.zone.b ? (com.github.catvod.spider.jdollar.time.zone.b) objE : null;
            if (bVar != null && bVar.h()) {
                localDateTimeOf = bVar.b.Y(bVar.d.getTotalSeconds() - bVar.c.getTotalSeconds());
            }
        }
        return ZonedDateTime.S(localDateTimeOf, null, zoneId);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.f(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final LocalDate c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.h(this, j);
        }
        switch (e.b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return f0(j);
            case 2:
                return h0(j);
            case 3:
                return g0(j);
            case 4:
                return i0(j);
            case 5:
                return i0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 10L));
            case 6:
                return i0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 100L));
            case 7:
                return i0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 1000L));
            case 8:
                com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.ERA;
                return b(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(E(aVar), j), aVar);
            default:
                com.github.catvod.spider.jdollar.nio.file.b.b(temporalUnit, "Unsupported unit: ");
                return null;
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && S((LocalDate) obj) == 0;
    }

    public final LocalDate f0(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = this.c + j;
        if (j2 > 0) {
            if (j2 <= 28) {
                return new LocalDate(this.a, this.b, (int) j2);
            }
            if (j2 <= 59) {
                long jZ = Z();
                if (j2 <= jZ) {
                    return new LocalDate(this.a, this.b, (int) j2);
                }
                short s = this.b;
                if (s < 12) {
                    return new LocalDate(this.a, s + 1, (int) (j2 - jZ));
                }
                com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(this.a + 1);
                return new LocalDate(this.a + 1, 1, (int) (j2 - jZ));
            }
        }
        return c0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(F(), j));
    }

    public final LocalDate g0(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.a * 12) + (this.b - 1) + j;
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        return j0(aVar.b.a(com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j2, 12L), aVar), ((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j2, 12L)) + 1, this.c);
    }

    public int getDayOfMonth() {
        return this.c;
    }

    public int getMonthValue() {
        return this.b;
    }

    public int getYear() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? V(pVar) : q.a(this, pVar);
    }

    public final LocalDate h0(long j) {
        return f0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 7L));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final int hashCode() {
        int i = this.a;
        return (((i << 11) + (this.b << 6)) + this.c) ^ (i & (-2048));
    }

    public final LocalDate i0(long j) {
        if (j == 0) {
            return this;
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        return j0(aVar.b.a(this.a + j, aVar), this.b, this.c);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.i(this);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        if (!aVar.isDateBased()) {
            throw new r(b.a("Unsupported field: ", pVar));
        }
        int i = e.a[aVar.ordinal()];
        if (i == 1) {
            return s.f(1L, Z());
        }
        if (i == 2) {
            return s.f(1L, O());
        }
        if (i != 3) {
            return i != 4 ? aVar.b : getYear() <= 0 ? s.f(1L, 1000000000L) : s.f(1L, 999999999L);
        }
        return s.f(1L, (i.V(this.b) != i.FEBRUARY || r()) ? 5L : 4L);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final LocalDate b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (LocalDate) pVar.A(this, j);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        aVar.E(j);
        switch (e.a[aVar.ordinal()]) {
            case 1:
                int i = (int) j;
                if (this.c != i) {
                    return of(this.a, this.b, i);
                }
                return this;
            case 2:
                int i2 = (int) j;
                if (X() != i2) {
                    return d0(this.a, i2);
                }
                return this;
            case 3:
                return h0(j - E(com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.a < 1) {
                    j = 1 - j;
                }
                return m0((int) j);
            case 5:
                return f0(j - W().getValue());
            case 6:
                return f0(j - E(com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return f0(j - E(com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return c0(j);
            case 9:
                return h0(j - E(com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                int i3 = (int) j;
                if (this.b != i3) {
                    com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR.E(i3);
                    return j0(this.a, i3, this.c);
                }
                return this;
            case 11:
                return g0(j - (((this.a * 12) + this.b) - 1));
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return m0((int) j);
            case 13:
                if (E(com.github.catvod.spider.jdollar.time.temporal.a.ERA) != j) {
                    return m0(1 - this.a);
                }
                return this;
            default:
                throw new r(b.a("Unsupported field: ", pVar));
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    /* renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final LocalDate z(com.github.catvod.spider.jdollar.time.temporal.m mVar) {
        return mVar instanceof LocalDate ? (LocalDate) mVar : (LocalDate) mVar.o(this);
    }

    public final LocalDate m0(int i) {
        if (this.a == i) {
            return this;
        }
        com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(i);
        return j0(i, this.b, this.c);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.a(this, lVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final boolean r() {
        return t.c.Q(this.a);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final String toString() {
        int i = this.a;
        short s = this.b;
        short s2 = this.c;
        int iAbs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        return sb.toString();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == q.f ? this : com.github.catvod.spider.jdollar.com.android.tools.r8.a.g(this, mVar);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.g);
    }
}
