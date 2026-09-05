package com.github.catvod.spider.jdollar.time.temporal;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.format.b0;
import com.github.catvod.spider.jdollar.time.format.c0;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class g implements p {
    public static final g DAY_OF_QUARTER;
    public static final g QUARTER_OF_YEAR;
    public static final g WEEK_BASED_YEAR;
    public static final g WEEK_OF_WEEK_BASED_YEAR;
    public static final int[] a;
    public static final /* synthetic */ g[] b;

    static {
        g gVar = new g() { // from class: com.github.catvod.spider.jdollar.time.temporal.c
            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final l A(l lVar, long j) {
                long jY = y(lVar);
                o().b(j, this);
                a aVar = a.DAY_OF_YEAR;
                return lVar.b((j - jY) + lVar.E(aVar), aVar);
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final boolean h(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.d(a.DAY_OF_YEAR) || !temporalAccessor.d(a.MONTH_OF_YEAR) || !temporalAccessor.d(a.YEAR)) {
                    return false;
                }
                g gVar2 = i.a;
                return com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(temporalAccessor).equals(com.github.catvod.spider.jdollar.time.chrono.t.c);
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final s i(TemporalAccessor temporalAccessor) {
                if (!h(temporalAccessor)) {
                    throw new r("Unsupported field: DayOfQuarter");
                }
                long jE = temporalAccessor.E(g.QUARTER_OF_YEAR);
                if (jE == 1) {
                    return com.github.catvod.spider.jdollar.time.chrono.t.c.Q(temporalAccessor.E(a.YEAR)) ? s.f(1L, 91L) : s.f(1L, 90L);
                }
                return jE == 2 ? s.f(1L, 91L) : (jE == 3 || jE == 4) ? s.f(1L, 92L) : o();
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.g, com.github.catvod.spider.jdollar.time.temporal.p
            public final TemporalAccessor j(Map map, b0 b0Var, c0 c0Var) {
                LocalDate localDateOf;
                long jP;
                a aVar = a.YEAR;
                Long l = (Long) map.get(aVar);
                p pVar = g.QUARTER_OF_YEAR;
                Long l2 = (Long) map.get(pVar);
                if (l != null && l2 != null) {
                    int iA = aVar.b.a(l.longValue(), aVar);
                    long jLongValue = ((Long) map.get(g.DAY_OF_QUARTER)).longValue();
                    g gVar2 = i.a;
                    if (com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(b0Var).equals(com.github.catvod.spider.jdollar.time.chrono.t.c)) {
                        if (c0Var == c0.LENIENT) {
                            localDateOf = LocalDate.of(iA, 1, 1).g0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(l2.longValue(), 1L), 3L));
                            jP = com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(jLongValue, 1L);
                        } else {
                            localDateOf = LocalDate.of(iA, ((pVar.o().a(l2.longValue(), pVar) - 1) * 3) + 1, 1);
                            if (jLongValue < 1 || jLongValue > 90) {
                                if (c0Var == c0.STRICT) {
                                    i(localDateOf).b(jLongValue, this);
                                } else {
                                    o().b(jLongValue, this);
                                }
                            }
                            jP = jLongValue - 1;
                        }
                        map.remove(this);
                        map.remove(aVar);
                        map.remove(pVar);
                        return localDateOf.f0(jP);
                    }
                    com.github.catvod.spider.jdollar.nio.file.b.k("Resolve requires IsoChronology");
                }
                return null;
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final s o() {
                return s.g(1L, 90L, 92L);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final long y(TemporalAccessor temporalAccessor) {
                if (!h(temporalAccessor)) {
                    throw new r("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.h(a.DAY_OF_YEAR) - g.a[((temporalAccessor.h(a.MONTH_OF_YEAR) - 1) / 3) + (com.github.catvod.spider.jdollar.time.chrono.t.c.Q(temporalAccessor.E(a.YEAR)) ? 4 : 0)];
            }
        };
        DAY_OF_QUARTER = gVar;
        g gVar2 = new g() { // from class: com.github.catvod.spider.jdollar.time.temporal.d
            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final l A(l lVar, long j) {
                long jY = y(lVar);
                o().b(j, this);
                a aVar = a.MONTH_OF_YEAR;
                return lVar.b(((j - jY) * 3) + lVar.E(aVar), aVar);
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final boolean h(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.d(a.MONTH_OF_YEAR)) {
                    return false;
                }
                g gVar3 = i.a;
                return com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(temporalAccessor).equals(com.github.catvod.spider.jdollar.time.chrono.t.c);
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final s i(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return o();
                }
                throw new r("Unsupported field: QuarterOfYear");
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final s o() {
                return s.f(1L, 4L);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final long y(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return (temporalAccessor.E(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new r("Unsupported field: QuarterOfYear");
            }
        };
        QUARTER_OF_YEAR = gVar2;
        g gVar3 = new g() { // from class: com.github.catvod.spider.jdollar.time.temporal.e
            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final l A(l lVar, long j) {
                o().b(j, this);
                return lVar.c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(j, y(lVar)), ChronoUnit.WEEKS);
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final boolean h(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.d(a.EPOCH_DAY)) {
                    return false;
                }
                g gVar4 = i.a;
                return com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(temporalAccessor).equals(com.github.catvod.spider.jdollar.time.chrono.t.c);
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final s i(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return g.U(LocalDate.U(temporalAccessor));
                }
                throw new r("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.g, com.github.catvod.spider.jdollar.time.temporal.p
            public final TemporalAccessor j(Map map, b0 b0Var, c0 c0Var) {
                LocalDate localDateB;
                long j;
                p pVar = g.WEEK_BASED_YEAR;
                Long l = (Long) map.get(pVar);
                a aVar = a.DAY_OF_WEEK;
                Long l2 = (Long) map.get(aVar);
                if (l != null && l2 != null) {
                    int iA = pVar.o().a(l.longValue(), pVar);
                    long jLongValue = ((Long) map.get(g.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                    g gVar4 = i.a;
                    if (com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(b0Var).equals(com.github.catvod.spider.jdollar.time.chrono.t.c)) {
                        LocalDate localDateOf = LocalDate.of(iA, 1, 4);
                        if (c0Var == c0.LENIENT) {
                            long jLongValue2 = l2.longValue();
                            if (jLongValue2 > 7) {
                                long j2 = jLongValue2 - 1;
                                localDateOf = localDateOf.h0(j2 / 7);
                                j = j2 % 7;
                            } else {
                                if (jLongValue2 < 1) {
                                    localDateOf = localDateOf.h0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(jLongValue2, 7L) / 7);
                                    j = (jLongValue2 + 6) % 7;
                                }
                                localDateB = localDateOf.h0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(jLongValue, 1L)).b(jLongValue2, aVar);
                            }
                            jLongValue2 = j + 1;
                            localDateB = localDateOf.h0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(jLongValue, 1L)).b(jLongValue2, aVar);
                        } else {
                            int iA2 = aVar.b.a(l2.longValue(), aVar);
                            if (jLongValue < 1 || jLongValue > 52) {
                                if (c0Var == c0.STRICT) {
                                    g.U(localDateOf).b(jLongValue, this);
                                } else {
                                    o().b(jLongValue, this);
                                }
                            }
                            localDateB = localDateOf.h0(jLongValue - 1).b(iA2, aVar);
                        }
                        map.remove(this);
                        map.remove(pVar);
                        map.remove(aVar);
                        return localDateB;
                    }
                    com.github.catvod.spider.jdollar.nio.file.b.k("Resolve requires IsoChronology");
                }
                return null;
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final s o() {
                return s.g(1L, 52L, 53L);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final long y(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return g.E(LocalDate.U(temporalAccessor));
                }
                throw new r("Unsupported field: WeekOfWeekBasedYear");
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = gVar3;
        g gVar4 = new g() { // from class: com.github.catvod.spider.jdollar.time.temporal.f
            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final l A(l lVar, long j) {
                if (!h(lVar)) {
                    throw new r("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.b.a(j, g.WEEK_BASED_YEAR);
                LocalDate localDateU = LocalDate.U(lVar);
                int iH = localDateU.h(a.DAY_OF_WEEK);
                int iE = g.E(localDateU);
                if (iE == 53 && g.T(iA) == 52) {
                    iE = 52;
                }
                return lVar.z(LocalDate.of(iA, 1, 4).f0(((iE - 1) * 7) + (iH - r6.h(r0))));
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final boolean h(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.d(a.EPOCH_DAY)) {
                    return false;
                }
                g gVar5 = i.a;
                return com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(temporalAccessor).equals(com.github.catvod.spider.jdollar.time.chrono.t.c);
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final s i(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return a.YEAR.b;
                }
                throw new r("Unsupported field: WeekBasedYear");
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final s o() {
                return a.YEAR.b;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }

            @Override // com.github.catvod.spider.jdollar.time.temporal.p
            public final long y(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return g.S(LocalDate.U(temporalAccessor));
                }
                throw new r("Unsupported field: WeekBasedYear");
            }
        };
        WEEK_BASED_YEAR = gVar4;
        b = new g[]{gVar, gVar2, gVar3, gVar4};
        a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static int E(LocalDate localDate) {
        int iOrdinal = localDate.W().ordinal();
        int iX = localDate.X() - 1;
        int i = (3 - iOrdinal) + iX;
        int i2 = i - ((i / 7) * 7);
        int i3 = i2 - 3;
        if (i3 < -3) {
            i3 = i2 + 4;
        }
        if (iX < i3) {
            if (localDate.X() != 180) {
                localDate = LocalDate.d0(localDate.a, 180);
            }
            return (int) U(localDate.i0(-1L)).d;
        }
        int i4 = ((iX - i3) / 7) + 1;
        if (i4 != 53 || i3 == -3 || (i3 == -2 && localDate.r())) {
            return i4;
        }
        return 1;
    }

    public static int S(LocalDate localDate) {
        int year = localDate.getYear();
        int iX = localDate.X();
        if (iX <= 3) {
            return iX - localDate.W().ordinal() < -2 ? year - 1 : year;
        }
        if (iX >= 363) {
            return ((iX - 363) - (localDate.r() ? 1 : 0)) - localDate.W().ordinal() >= 0 ? year + 1 : year;
        }
        return year;
    }

    public static int T(int i) {
        LocalDate localDateOf = LocalDate.of(i, 1, 1);
        if (localDateOf.W() != com.github.catvod.spider.jdollar.time.c.THURSDAY) {
            return (localDateOf.W() == com.github.catvod.spider.jdollar.time.c.WEDNESDAY && localDateOf.r()) ? 53 : 52;
        }
        return 53;
    }

    public static s U(LocalDate localDate) {
        return s.f(1L, T(S(localDate)));
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) b.clone();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final boolean isDateBased() {
        return true;
    }

    public /* synthetic */ TemporalAccessor j(Map map, b0 b0Var, c0 c0Var) {
        return null;
    }
}
