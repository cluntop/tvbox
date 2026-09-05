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
public final class Year implements com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Comparable<Year>, Serializable {
    public static final /* synthetic */ int b = 0;
    private static final long serialVersionUID = -23038383694477807L;
    public final int a;

    static {
        u uVar = new u();
        uVar.n(com.github.catvod.spider.jdollar.time.temporal.a.YEAR, 4, 10, d0.EXCEEDS_PAD);
        uVar.r(Locale.getDefault(), c0.SMART, null);
    }

    public Year(int i) {
        this.a = i;
    }

    public static Year of(int i) {
        com.github.catvod.spider.jdollar.time.temporal.a.YEAR.E(i);
        return new Year(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 11, this);
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
        int i = m.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i == 1) {
            int i2 = this.a;
            if (i2 < 1) {
                i2 = 1 - i2;
            }
            return i2;
        }
        if (i == 2) {
            return this.a;
        }
        if (i == 3) {
            return this.a < 1 ? 0 : 1;
        }
        throw new r(b.a("Unsupported field: ", pVar));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public final Year c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Year) temporalUnit.h(this, j);
        }
        int i = m.b[((ChronoUnit) temporalUnit).ordinal()];
        if (i == 1) {
            return T(j);
        }
        if (i == 2) {
            return T(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 10L));
        }
        if (i == 3) {
            return T(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 100L));
        }
        if (i == 4) {
            return T(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 1000L));
        }
        if (i == 5) {
            com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.ERA;
            return b(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(E(aVar), j), aVar);
        }
        com.github.catvod.spider.jdollar.nio.file.b.b(temporalUnit, "Unsupported unit: ");
        return null;
    }

    public final Year T(long j) {
        if (j == 0) {
            return this;
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR;
        return of(aVar.b.a(this.a + j, aVar));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final Year b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (Year) pVar.A(this, j);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        aVar.E(j);
        int i = m.a[aVar.ordinal()];
        if (i == 1) {
            if (this.a < 1) {
                j = 1 - j;
            }
            return of((int) j);
        }
        if (i == 2) {
            return of((int) j);
        }
        if (i == 3) {
            return E(com.github.catvod.spider.jdollar.time.temporal.a.ERA) == j ? this : of(1 - this.a);
        }
        throw new r(b.a("Unsupported field: ", pVar));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Year year) {
        return this.a - year.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.YEAR || pVar == com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA || pVar == com.github.catvod.spider.jdollar.time.temporal.a.ERA : pVar != null && pVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.a == ((Year) obj).a;
    }

    public int getValue() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return j(pVar).a(E(pVar), pVar);
    }

    public final int hashCode() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return (Year) com.github.catvod.spider.jdollar.com.android.tools.r8.a.a(localDate, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA) {
            return s.f(1L, this.a <= 0 ? 1000000000L : 999999999L);
        }
        return q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        if (com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(lVar).equals(t.c)) {
            return lVar.b(this.a, com.github.catvod.spider.jdollar.time.temporal.a.YEAR);
        }
        com.github.catvod.spider.jdollar.nio.file.b.k("Adjustment only supported on ISO date-time");
        return null;
    }

    public final String toString() {
        return Integer.toString(this.a);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == q.b ? t.c : mVar == q.c ? ChronoUnit.YEARS : q.c(this, mVar);
    }
}
