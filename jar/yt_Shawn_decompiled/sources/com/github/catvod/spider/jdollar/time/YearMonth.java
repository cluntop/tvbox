package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.chrono.t;
import com.github.catvod.spider.jdollar.time.format.c0;
import com.github.catvod.spider.jdollar.time.format.d0;
import com.github.catvod.spider.jdollar.time.format.u;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.time.temporal.s;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YearMonth implements com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Comparable<YearMonth>, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 4183400860270640070L;
    public final int a;
    public final int b;

    static {
        u uVar = new u();
        uVar.n(com.github.catvod.spider.jdollar.time.temporal.a.YEAR, 4, 10, d0.EXCEEDS_PAD);
        uVar.d('-');
        uVar.m(com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR, 2);
        uVar.r(Locale.getDefault(), c0.SMART, null);
    }

    public YearMonth(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public static YearMonth of(int i, int i2) {
        com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(i);
        com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR.E(i2);
        return new YearMonth(i, i2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 12, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        int i;
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        int i2 = n.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i2 == 1) {
            i = this.b;
        } else {
            if (i2 == 2) {
                return S();
            }
            if (i2 == 3) {
                int i3 = this.a;
                if (i3 < 1) {
                    i3 = 1 - i3;
                }
                return i3;
            }
            if (i2 != 4) {
                if (i2 == 5) {
                    return this.a < 1 ? 0 : 1;
                }
                throw new r(b.a("Unsupported field: ", pVar));
            }
            i = this.a;
        }
        return i;
    }

    public final long S() {
        return ((this.a * 12) + this.b) - 1;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final YearMonth c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (YearMonth) temporalUnit.h(this, j);
        }
        switch (n.b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return U(j);
            case 2:
                return V(j);
            case 3:
                return V(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 10L));
            case 4:
                return V(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 100L));
            case 5:
                return V(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 1000L));
            case 6:
                com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.ERA;
                return b(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(E(aVar), j), aVar);
            default:
                com.github.catvod.spider.jdollar.nio.file.b.b(temporalUnit, "Unsupported unit: ");
                return null;
        }
    }

    public final YearMonth U(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.a * 12) + (this.b - 1) + j;
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        return W(aVar.b.a(com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j2, 12L), aVar), ((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j2, 12L)) + 1);
    }

    public final YearMonth V(long j) {
        if (j == 0) {
            return this;
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        return W(aVar.b.a(this.a + j, aVar), this.b);
    }

    public final YearMonth W(int i, int i2) {
        return (this.a == i && this.b == i2) ? this : new YearMonth(i, i2);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final YearMonth b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (YearMonth) pVar.A(this, j);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        aVar.E(j);
        int i = n.a[aVar.ordinal()];
        if (i == 1) {
            int i2 = (int) j;
            com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR.E(i2);
            return W(this.a, i2);
        }
        if (i == 2) {
            return U(j - S());
        }
        if (i == 3) {
            if (this.a < 1) {
                j = 1 - j;
            }
            int i3 = (int) j;
            com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(i3);
            return W(i3, this.b);
        }
        if (i == 4) {
            int i4 = (int) j;
            com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(i4);
            return W(i4, this.b);
        }
        if (i != 5) {
            throw new r(b.a("Unsupported field: ", pVar));
        }
        if (E(com.github.catvod.spider.jdollar.time.temporal.a.ERA) == j) {
            return this;
        }
        int i5 = 1 - this.a;
        com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(i5);
        return W(i5, this.b);
    }

    @Override // java.lang.Comparable
    public final int compareTo(YearMonth yearMonth) {
        YearMonth yearMonth2 = yearMonth;
        int i = this.a - yearMonth2.a;
        return i == 0 ? this.b - yearMonth2.b : i;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.YEAR || pVar == com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR || pVar == com.github.catvod.spider.jdollar.time.temporal.a.PROLEPTIC_MONTH || pVar == com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA || pVar == com.github.catvod.spider.jdollar.time.temporal.a.ERA : pVar != null && pVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YearMonth) {
            YearMonth yearMonth = (YearMonth) obj;
            if (this.a == yearMonth.a && this.b == yearMonth.b) {
                return true;
            }
        }
        return false;
    }

    public int getMonthValue() {
        return this.b;
    }

    public int getYear() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return j(pVar).a(E(pVar), pVar);
    }

    public final int hashCode() {
        return this.a ^ (this.b << 27);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return (YearMonth) com.github.catvod.spider.jdollar.com.android.tools.r8.a.a(localDate, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA) {
            return s.f(1L, getYear() <= 0 ? 1000000000L : 999999999L);
        }
        return q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        if (com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(lVar).equals(t.c)) {
            return lVar.b(S(), com.github.catvod.spider.jdollar.time.temporal.a.PROLEPTIC_MONTH);
        }
        com.github.catvod.spider.jdollar.nio.file.b.k("Adjustment only supported on ISO date-time");
        return null;
    }

    public final String toString() {
        int iAbs = Math.abs(this.a);
        StringBuilder sb = new StringBuilder(9);
        int i = this.a;
        if (iAbs >= 1000) {
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(this.b < 10 ? "-0" : "-");
        sb.append(this.b);
        return sb.toString();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == q.b ? t.c : mVar == q.c ? ChronoUnit.MONTHS : q.c(this, mVar);
    }
}
