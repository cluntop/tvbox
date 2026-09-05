package com.github.catvod.spider.jdollar.time.temporal;

import com.github.catvod.spider.jdollar.time.format.b0;
import com.github.catvod.spider.jdollar.time.format.c0;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t implements p {
    public static final s f = s.f(1, 7);
    public static final s g = s.g(0, 4, 6);
    public static final s h = s.g(0, 52, 54);
    public static final s i = s.g(1, 52, 53);
    public final String a;
    public final u b;
    public final TemporalUnit c;
    public final TemporalUnit d;
    public final s e;

    public t(String str, u uVar, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, s sVar) {
        this.a = str;
        this.b = uVar;
        this.c = temporalUnit;
        this.d = temporalUnit2;
        this.e = sVar;
    }

    public static int a(int i2, int i3) {
        return ((i3 - 1) + (i2 + 7)) / 7;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final l A(l lVar, long j) {
        if (this.e.a(j, this) == lVar.h(this)) {
            return lVar;
        }
        if (this.d != ChronoUnit.FOREVER) {
            return lVar.c(r0 - r1, this.c);
        }
        u uVar = this.b;
        return e(com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(lVar), (int) j, lVar.h(uVar.e), lVar.h(uVar.c));
    }

    public final int b(TemporalAccessor temporalAccessor) {
        return q.e(temporalAccessor.h(a.DAY_OF_WEEK) - this.b.a.getValue()) + 1;
    }

    public final int c(TemporalAccessor temporalAccessor) {
        int iB = b(temporalAccessor);
        int iH = temporalAccessor.h(a.YEAR);
        a aVar = a.DAY_OF_YEAR;
        int iH2 = temporalAccessor.h(aVar);
        int iK = k(iH2, iB);
        int iA = a(iK, iH2);
        return iA == 0 ? iH - 1 : iA >= a(iK, ((int) temporalAccessor.j(aVar).d) + this.b.b) ? iH + 1 : iH;
    }

    public final int d(TemporalAccessor temporalAccessor) {
        int iA;
        int iB = b(temporalAccessor);
        a aVar = a.DAY_OF_YEAR;
        int iH = temporalAccessor.h(aVar);
        int iK = k(iH, iB);
        int iA2 = a(iK, iH);
        return iA2 == 0 ? d(com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(temporalAccessor).C(temporalAccessor).t(iH, ChronoUnit.DAYS)) : (iA2 <= 50 || iA2 < (iA = a(iK, ((int) temporalAccessor.j(aVar).d) + this.b.b))) ? iA2 : (iA2 - iA) + 1;
    }

    public final com.github.catvod.spider.jdollar.time.chrono.b e(com.github.catvod.spider.jdollar.time.chrono.l lVar, int i2, int i3, int i4) {
        com.github.catvod.spider.jdollar.time.chrono.b bVarK = lVar.K(i2, 1, 1);
        int iK = k(1, b(bVarK));
        int i5 = i4 - 1;
        return bVarK.c(((Math.min(i3, a(iK, bVarK.O() + this.b.b) - 1) - 1) * 7) + i5 + (-iK), (TemporalUnit) ChronoUnit.DAYS);
    }

    public final s f(TemporalAccessor temporalAccessor, a aVar) {
        int iK = k(temporalAccessor.h(aVar), b(temporalAccessor));
        s sVarJ = temporalAccessor.j(aVar);
        return s.f(a(iK, (int) sVarJ.a), a(iK, (int) sVarJ.d));
    }

    public final s g(TemporalAccessor temporalAccessor) {
        a aVar = a.DAY_OF_YEAR;
        if (!temporalAccessor.d(aVar)) {
            return h;
        }
        int iB = b(temporalAccessor);
        int iH = temporalAccessor.h(aVar);
        int iK = k(iH, iB);
        int iA = a(iK, iH);
        if (iA == 0) {
            return g(com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(temporalAccessor).C(temporalAccessor).t(iH + 7, ChronoUnit.DAYS));
        }
        return iA >= a(iK, this.b.b + ((int) temporalAccessor.j(aVar).d)) ? g(com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(temporalAccessor).C(temporalAccessor).c((r0 - iH) + 8, (TemporalUnit) ChronoUnit.DAYS)) : s.f(1L, r1 - 1);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final boolean h(TemporalAccessor temporalAccessor) {
        if (!temporalAccessor.d(a.DAY_OF_WEEK)) {
            return false;
        }
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.d;
        if (temporalUnit == chronoUnit) {
            return true;
        }
        if (temporalUnit == ChronoUnit.MONTHS) {
            return temporalAccessor.d(a.DAY_OF_MONTH);
        }
        if (temporalUnit == ChronoUnit.YEARS) {
            return temporalAccessor.d(a.DAY_OF_YEAR);
        }
        if (temporalUnit == u.h) {
            return temporalAccessor.d(a.DAY_OF_YEAR);
        }
        if (temporalUnit == ChronoUnit.FOREVER) {
            return temporalAccessor.d(a.YEAR);
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final s i(TemporalAccessor temporalAccessor) {
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.d;
        if (temporalUnit == chronoUnit) {
            return this.e;
        }
        if (temporalUnit == ChronoUnit.MONTHS) {
            return f(temporalAccessor, a.DAY_OF_MONTH);
        }
        if (temporalUnit == ChronoUnit.YEARS) {
            return f(temporalAccessor, a.DAY_OF_YEAR);
        }
        if (temporalUnit == u.h) {
            return g(temporalAccessor);
        }
        if (temporalUnit == ChronoUnit.FOREVER) {
            return a.YEAR.b;
        }
        throw new IllegalStateException("unreachable, rangeUnit: " + temporalUnit + ", this: " + this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final boolean isDateBased() {
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final TemporalAccessor j(Map map, b0 b0Var, c0 c0Var) {
        com.github.catvod.spider.jdollar.time.chrono.b bVarC;
        com.github.catvod.spider.jdollar.time.chrono.b bVarC2;
        com.github.catvod.spider.jdollar.time.chrono.b bVarC3;
        long jLongValue = ((Long) map.get(this)).longValue();
        int iY = com.github.catvod.spider.jdollar.com.android.tools.r8.a.y(jLongValue);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        s sVar = this.e;
        u uVar = this.b;
        TemporalUnit temporalUnit = this.d;
        if (temporalUnit == chronoUnit) {
            long jE = q.e((sVar.a(jLongValue, this) - 1) + (uVar.a.getValue() - 1)) + 1;
            map.remove(this);
            map.put(a.DAY_OF_WEEK, Long.valueOf(jE));
            return null;
        }
        a aVar = a.DAY_OF_WEEK;
        if (!map.containsKey(aVar)) {
            return null;
        }
        int iE = q.e(aVar.b.a(((Long) map.get(aVar)).longValue(), aVar) - uVar.a.getValue()) + 1;
        com.github.catvod.spider.jdollar.time.chrono.l lVarW = com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(b0Var);
        a aVar2 = a.YEAR;
        if (!map.containsKey(aVar2)) {
            if ((temporalUnit != u.h && temporalUnit != ChronoUnit.FOREVER) || !map.containsKey(uVar.f) || !map.containsKey(uVar.e)) {
                return null;
            }
            t tVar = uVar.f;
            int iA = tVar.e.a(((Long) map.get(tVar)).longValue(), uVar.f);
            if (c0Var == c0.LENIENT) {
                bVarC = e(lVarW, iA, 1, iE).c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(((Long) map.get(uVar.e)).longValue(), 1L), (TemporalUnit) chronoUnit);
            } else {
                t tVar2 = uVar.e;
                com.github.catvod.spider.jdollar.time.chrono.b bVarE = e(lVarW, iA, tVar2.e.a(((Long) map.get(tVar2)).longValue(), uVar.e), iE);
                if (c0Var == c0.STRICT && c(bVarE) != iA) {
                    com.github.catvod.spider.jdollar.nio.file.b.k("Strict mode rejected resolved date as it is in a different week-based-year");
                    return null;
                }
                bVarC = bVarE;
            }
            map.remove(this);
            map.remove(uVar.f);
            map.remove(uVar.e);
            map.remove(aVar);
            return bVarC;
        }
        int iA2 = aVar2.b.a(((Long) map.get(aVar2)).longValue(), aVar2);
        ChronoUnit chronoUnit2 = ChronoUnit.MONTHS;
        if (temporalUnit == chronoUnit2) {
            a aVar3 = a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                long jLongValue2 = ((Long) map.get(aVar3)).longValue();
                long j = iY;
                if (c0Var == c0.LENIENT) {
                    com.github.catvod.spider.jdollar.time.chrono.b bVarC4 = lVarW.K(iA2, 1, 1).c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(jLongValue2, 1L), (TemporalUnit) chronoUnit2);
                    int iB = b(bVarC4);
                    int iH = bVarC4.h(a.DAY_OF_MONTH);
                    bVarC3 = bVarC4.c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(j, a(k(iH, iB), iH)), 7L), iE - b(bVarC4)), (TemporalUnit) ChronoUnit.DAYS);
                } else {
                    com.github.catvod.spider.jdollar.time.chrono.b bVarK = lVarW.K(iA2, aVar3.b.a(jLongValue2, aVar3), 1);
                    long jA = sVar.a(j, this);
                    int iB2 = b(bVarK);
                    int iH2 = bVarK.h(a.DAY_OF_MONTH);
                    com.github.catvod.spider.jdollar.time.chrono.b bVarC5 = bVarK.c((((int) (jA - a(k(iH2, iB2), iH2))) * 7) + (iE - b(bVarK)), (TemporalUnit) ChronoUnit.DAYS);
                    if (c0Var == c0.STRICT && bVarC5.E(aVar3) != jLongValue2) {
                        com.github.catvod.spider.jdollar.nio.file.b.k("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                    bVarC3 = bVarC5;
                }
                map.remove(this);
                map.remove(aVar2);
                map.remove(aVar3);
                map.remove(aVar);
                return bVarC3;
            }
        }
        if (temporalUnit != ChronoUnit.YEARS) {
            return null;
        }
        long j2 = iY;
        com.github.catvod.spider.jdollar.time.chrono.b bVarK2 = lVarW.K(iA2, 1, 1);
        if (c0Var == c0.LENIENT) {
            int iB3 = b(bVarK2);
            int iH3 = bVarK2.h(a.DAY_OF_YEAR);
            bVarC2 = bVarK2.c(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(j2, a(k(iH3, iB3), iH3)), 7L), iE - b(bVarK2)), (TemporalUnit) ChronoUnit.DAYS);
        } else {
            long jA2 = sVar.a(j2, this);
            int iB4 = b(bVarK2);
            int iH4 = bVarK2.h(a.DAY_OF_YEAR);
            com.github.catvod.spider.jdollar.time.chrono.b bVarC6 = bVarK2.c((((int) (jA2 - a(k(iH4, iB4), iH4))) * 7) + (iE - b(bVarK2)), (TemporalUnit) ChronoUnit.DAYS);
            if (c0Var == c0.STRICT && bVarC6.E(aVar2) != iA2) {
                com.github.catvod.spider.jdollar.nio.file.b.k("Strict mode rejected resolved date as it is in a different year");
                return null;
            }
            bVarC2 = bVarC6;
        }
        map.remove(this);
        map.remove(aVar2);
        map.remove(aVar);
        return bVarC2;
    }

    public final int k(int i2, int i3) {
        int iE = q.e(i2 - i3);
        return iE + 1 > this.b.b ? 7 - iE : -iE;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final s o() {
        return this.e;
    }

    public final String toString() {
        return this.a + "[" + this.b.toString() + "]";
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final long y(TemporalAccessor temporalAccessor) {
        int iC;
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        TemporalUnit temporalUnit = this.d;
        if (temporalUnit == chronoUnit) {
            iC = b(temporalAccessor);
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            int iB = b(temporalAccessor);
            int iH = temporalAccessor.h(a.DAY_OF_MONTH);
            iC = a(k(iH, iB), iH);
        } else if (temporalUnit == ChronoUnit.YEARS) {
            int iB2 = b(temporalAccessor);
            int iH2 = temporalAccessor.h(a.DAY_OF_YEAR);
            iC = a(k(iH2, iB2), iH2);
        } else if (temporalUnit == u.h) {
            iC = d(temporalAccessor);
        } else {
            if (temporalUnit != ChronoUnit.FOREVER) {
                throw new IllegalStateException("unreachable, rangeUnit: " + temporalUnit + ", this: " + this);
            }
            iC = c(temporalAccessor);
        }
        return iC;
    }
}
