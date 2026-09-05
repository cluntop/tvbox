package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.Year;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.ZonedDateTime;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t extends a implements Serializable {
    public static final t c = new t();
    private static final long serialVersionUID = -1440403870442975015L;

    private t() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a
    public final b A(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        int iA = aVar.b.a(((Long) map.remove(aVar)).longValue(), aVar);
        boolean z = true;
        if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
            return LocalDate.of(iA, 1, 1).g0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L)).f0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L));
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = aVar2.b.a(((Long) map.remove(aVar2)).longValue(), aVar2);
        com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH;
        int iA3 = aVar3.b.a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.SMART) {
            if (iA2 == 4 || iA2 == 6 || iA2 == 9 || iA2 == 11) {
                iA3 = Math.min(iA3, 30);
            } else if (iA2 == 2) {
                com.github.catvod.spider.jdollar.time.i iVar = com.github.catvod.spider.jdollar.time.i.FEBRUARY;
                long j = iA;
                int i = Year.b;
                if ((3 & j) != 0 || (j % 100 == 0 && j % 400 != 0)) {
                    z = false;
                }
                iA3 = Math.min(iA3, iVar.T(z));
            }
        }
        return LocalDate.of(iA, iA2, iA3);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b C(TemporalAccessor temporalAccessor) {
        return LocalDate.U(temporalAccessor);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a, com.github.catvod.spider.jdollar.time.chrono.l
    public final e D(LocalDateTime localDateTime) {
        return LocalDateTime.T(localDateTime);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a
    public final b E(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                aVar.E(l.longValue());
            }
            Long l2 = (Long) map.remove(com.github.catvod.spider.jdollar.time.temporal.a.ERA);
            if (l2 == null) {
                com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
                Long l3 = (Long) map.get(aVar2);
                if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.STRICT) {
                    a.h(map, aVar2, (l3 == null || l3.longValue() > 0) ? l.longValue() : com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(1L, l.longValue()));
                } else if (l3 != null) {
                    long jLongValue = l3.longValue();
                    long jLongValue2 = l.longValue();
                    if (jLongValue <= 0) {
                        jLongValue2 = com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(1L, jLongValue2);
                    }
                    a.h(map, aVar2, jLongValue2);
                } else {
                    map.put(aVar, l);
                }
            } else if (l2.longValue() == 1) {
                a.h(map, com.github.catvod.spider.jdollar.time.temporal.a.YEAR, l.longValue());
            } else {
                if (l2.longValue() != 0) {
                    com.github.catvod.spider.jdollar.nio.file.b.j(l2, "Invalid value for era: ");
                    return null;
                }
                a.h(map, com.github.catvod.spider.jdollar.time.temporal.a.YEAR, com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(1L, l.longValue()));
            }
        } else {
            com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.ERA;
            if (map.containsKey(aVar3)) {
                aVar3.E(((Long) map.get(aVar3)).longValue());
            }
        }
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b K(int i, int i2, int i3) {
        return LocalDate.of(i, i2, i3);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a, com.github.catvod.spider.jdollar.time.chrono.l
    public final b M(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        return (LocalDate) super.M(map, c0Var);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final ChronoZonedDateTime N(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.o(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final boolean Q(long j) {
        if ((3 & j) == 0) {
            return j % 100 != 0 || j % 400 == 0;
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b f(long j) {
        return LocalDate.c0(j);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String getId() {
        return "ISO";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a
    public final b i() {
        com.github.catvod.spider.jdollar.time.a aVarT = com.github.catvod.spider.jdollar.com.android.tools.r8.a.T();
        Objects.requireNonNull(aVarT, "clock");
        return LocalDate.U(LocalDate.b0(aVarT));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String l() {
        return "iso8601";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b m(int i, int i2) {
        return LocalDate.d0(i, i2);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final com.github.catvod.spider.jdollar.time.temporal.s s(com.github.catvod.spider.jdollar.time.temporal.a aVar) {
        return aVar.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final List u() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.B(u.values());
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final n v(int i) {
        if (i == 0) {
            return u.BCE;
        }
        if (i == 1) {
            return u.CE;
        }
        com.github.catvod.spider.jdollar.nio.file.b.d("Invalid era: ", i);
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final int w(n nVar, int i) {
        if (nVar instanceof u) {
            return nVar == u.CE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    public Object writeReplace() {
        return new f0((byte) 1, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a
    public final void y(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                aVar.E(l.longValue());
            }
            a.h(map, com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR, ((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(l.longValue(), 12L)) + 1);
            a.h(map, com.github.catvod.spider.jdollar.time.temporal.a.YEAR, com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(l.longValue(), 12L));
        }
    }
}
