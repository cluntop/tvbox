package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.util.Locale;
import java.util.Map;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class a implements l {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    static {
        new Locale("ja", "JP", "JP");
    }

    public static void h(Map map, com.github.catvod.spider.jdollar.time.temporal.a aVar, long j) {
        Long l = (Long) map.get(aVar);
        if (l == null || l.longValue() == j) {
            map.put(aVar, Long.valueOf(j));
            return;
        }
        throw new DateTimeException("Conflict found: " + aVar + Stream.ID_UNKNOWN + l + " differs from " + aVar + Stream.ID_UNKNOWN + j);
    }

    public static l j(l lVar, String str) {
        String strL;
        l lVar2 = (l) a.putIfAbsent(str, lVar);
        if (lVar2 == null && (strL = lVar.l()) != null) {
            b.putIfAbsent(strL, lVar);
        }
        return lVar2;
    }

    public static b o(b bVar, long j, long j2, long j3) {
        long j4;
        b bVarC = bVar.c(j, (TemporalUnit) ChronoUnit.MONTHS);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        b bVarC2 = bVarC.c(j2, (TemporalUnit) chronoUnit);
        if (j3 <= 7) {
            if (j3 < 1) {
                bVarC2 = bVarC2.c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(j3, 7L) / 7, (TemporalUnit) chronoUnit);
                j4 = (j3 + 6) % 7;
            }
            return bVarC2.z(new com.github.catvod.spider.jdollar.time.temporal.n(com.github.catvod.spider.jdollar.time.c.S((int) j3).getValue(), 0));
        }
        long j5 = j3 - 1;
        bVarC2 = bVarC2.c(j5 / 7, (TemporalUnit) chronoUnit);
        j4 = j5 % 7;
        j3 = j4 + 1;
        return bVarC2.z(new com.github.catvod.spider.jdollar.time.temporal.n(com.github.catvod.spider.jdollar.time.c.S((int) j3).getValue(), 0));
    }

    public b A(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        int iA = s(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
            long jP = com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return K(iA, 1, 1).c(jP, (TemporalUnit) ChronoUnit.MONTHS).c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH;
        int iA3 = s(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.SMART) {
            return K(iA, iA2, iA3);
        }
        try {
            return K(iA, iA2, iA3);
        } catch (DateTimeException unused) {
            return K(iA, iA2, 1).z(new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(7));
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public e D(LocalDateTime localDateTime) {
        try {
            return C(localDateTime).G(LocalTime.U(localDateTime));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e);
        }
    }

    public b E(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA;
        Long l = (Long) map.remove(aVar);
        if (l == null) {
            com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.ERA;
            if (!map.containsKey(aVar2)) {
                return null;
            }
            s(aVar2).b(((Long) map.get(aVar2)).longValue(), aVar2);
            return null;
        }
        Long l2 = (Long) map.remove(com.github.catvod.spider.jdollar.time.temporal.a.ERA);
        int iA = c0Var != com.github.catvod.spider.jdollar.time.format.c0.LENIENT ? s(aVar).a(l.longValue(), aVar) : com.github.catvod.spider.jdollar.com.android.tools.r8.a.y(l.longValue());
        if (l2 != null) {
            h(map, com.github.catvod.spider.jdollar.time.temporal.a.YEAR, w(v(s(r2).a(l2.longValue(), r2)), iA));
            return null;
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        if (map.containsKey(aVar3)) {
            h(map, aVar3, w(m(s(aVar3).a(((Long) map.get(aVar3)).longValue(), aVar3), 1).H(), iA));
            return null;
        }
        if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.STRICT) {
            map.put(aVar, l);
            return null;
        }
        if (u().isEmpty()) {
            h(map, aVar3, iA);
            return null;
        }
        h(map, aVar3, w((n) r9.get(r9.size() - 1), iA));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public b M(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return f(((Long) map.remove(aVar)).longValue());
        }
        y(map, c0Var);
        b bVarE = E(map, c0Var);
        if (bVarE != null) {
            return bVarE;
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        if (map.containsKey(aVar2)) {
            com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                if (map.containsKey(com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH)) {
                    return A(map, c0Var);
                }
                com.github.catvod.spider.jdollar.time.temporal.a aVar4 = com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    com.github.catvod.spider.jdollar.time.temporal.a aVar5 = com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(aVar5)) {
                        int iA = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                            long jP = com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar3)).longValue(), 1L);
                            return K(iA, 1, 1).c(jP, (TemporalUnit) ChronoUnit.MONTHS).c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar4)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar5)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                        }
                        int iA2 = s(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        int iA3 = s(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                        b bVarC = K(iA, iA2, 1).c((s(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((iA3 - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                        if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.STRICT || bVarC.h(aVar3) == iA2) {
                            return bVarC;
                        }
                        com.github.catvod.spider.jdollar.nio.file.b.k("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                    com.github.catvod.spider.jdollar.time.temporal.a aVar6 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_WEEK;
                    if (map.containsKey(aVar6)) {
                        int iA4 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                            return o(K(iA4, 1, 1), com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar3)).longValue(), 1L), com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar4)).longValue(), 1L), com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar6)).longValue(), 1L));
                        }
                        int iA5 = s(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        b bVarZ = K(iA4, iA5, 1).c((s(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).z(new com.github.catvod.spider.jdollar.time.temporal.n(com.github.catvod.spider.jdollar.time.c.S(s(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).getValue(), 0));
                        if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.STRICT || bVarZ.h(aVar3) == iA5) {
                            return bVarZ;
                        }
                        com.github.catvod.spider.jdollar.nio.file.b.k("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                }
            }
            com.github.catvod.spider.jdollar.time.temporal.a aVar7 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar7)) {
                int iA6 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                    return m(iA6, s(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
                }
                return m(iA6, 1).c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar7)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
            }
            com.github.catvod.spider.jdollar.time.temporal.a aVar8 = com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey(aVar8)) {
                com.github.catvod.spider.jdollar.time.temporal.a aVar9 = com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey(aVar9)) {
                    int iA7 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                        return m(iA7, 1).c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar8)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar9)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int iA8 = s(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8);
                    b bVarC2 = m(iA7, 1).c((s(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((iA8 - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                    if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.STRICT || bVarC2.h(aVar2) == iA7) {
                        return bVarC2;
                    }
                    com.github.catvod.spider.jdollar.nio.file.b.k("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
                com.github.catvod.spider.jdollar.time.temporal.a aVar10 = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_WEEK;
                if (map.containsKey(aVar10)) {
                    int iA9 = s(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (c0Var == com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                        return o(m(iA9, 1), 0L, com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar8)).longValue(), 1L), com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.remove(aVar10)).longValue(), 1L));
                    }
                    b bVarZ2 = m(iA9, 1).c((s(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).z(new com.github.catvod.spider.jdollar.time.temporal.n(com.github.catvod.spider.jdollar.time.c.S(s(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).getValue(), 0));
                    if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.STRICT || bVarZ2.h(aVar2) == iA9) {
                        return bVarZ2;
                    }
                    com.github.catvod.spider.jdollar.nio.file.b.k("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
            }
        }
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return getId().compareTo(((l) obj).getId());
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && getId().compareTo(((a) obj).getId()) == 0;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    public abstract /* synthetic */ b i();

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String toString() {
        return getId();
    }

    public void y(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (c0Var != com.github.catvod.spider.jdollar.time.format.c0.LENIENT) {
                aVar.E(l.longValue());
            }
            b bVarB = i().b(1L, (com.github.catvod.spider.jdollar.time.temporal.p) com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH).b(l.longValue(), (com.github.catvod.spider.jdollar.time.temporal.p) aVar);
            h(map, com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR, bVarB.h(r0));
            h(map, com.github.catvod.spider.jdollar.time.temporal.a.YEAR, bVarB.h(r0));
        }
    }
}
