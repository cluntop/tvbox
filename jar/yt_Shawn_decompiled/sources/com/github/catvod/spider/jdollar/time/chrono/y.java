package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y extends d {
    public static final LocalDate d = LocalDate.of(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    public final transient LocalDate a;
    public final transient z b;
    public final transient int c;

    public y(LocalDate localDate) {
        if (localDate.Y(d)) {
            com.github.catvod.spider.jdollar.nio.file.b.k("JapaneseDate before Meiji 6 is not supported");
            throw null;
        }
        z zVarF = z.f(localDate);
        this.b = zVarF;
        this.c = (localDate.getYear() - zVarF.b.getYear()) + 1;
        this.a = localDate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new f0((byte) 4, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return (y) super.t(j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        switch (x.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()]) {
            case 2:
                int i = this.c;
                LocalDate localDate = this.a;
                return i == 1 ? (localDate.X() - this.b.b.X()) + 1 : localDate.X();
            case 3:
                return this.c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
            case 8:
                return this.b.a;
            default:
                return this.a.E(pVar);
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final long F() {
        return this.a.F();
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final e G(LocalTime localTime) {
        return new g(this, localTime);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final n H() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b L(com.github.catvod.spider.jdollar.time.temporal.o oVar) {
        return (y) super.L(oVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final int O() {
        z zVarG = this.b.g();
        int iO = (zVarG == null || zVarG.b.getYear() != this.a.getYear()) ? this.a.O() : zVarG.b.X() - 1;
        return this.c == 1 ? iO - (this.b.b.X() - 1) : iO;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    public final b T(long j) {
        return Z(this.a.f0(j));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    public final b U(long j) {
        return Z(this.a.g0(j));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    public final b V(long j) {
        return Z(this.a.i0(j));
    }

    public final y W(long j, ChronoUnit chronoUnit) {
        return (y) super.c(j, (TemporalUnit) chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final y b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (y) super.b(j, pVar);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        if (E(aVar) == j) {
            return this;
        }
        int[] iArr = x.a;
        int i = iArr[aVar.ordinal()];
        if (i == 3 || i == 8 || i == 9) {
            w wVar = w.c;
            int iA = wVar.s(aVar).a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 3) {
                return Z(this.a.m0(wVar.w(this.b, iA)));
            }
            if (i2 == 8) {
                return Z(this.a.m0(wVar.w(z.k(iA), this.c)));
            }
            if (i2 == 9) {
                return Z(this.a.m0(iA));
            }
        }
        return Z(this.a.b(j, pVar));
    }

    public final y Y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return (y) super.z(mVar);
    }

    public final y Z(LocalDate localDate) {
        return localDate.equals(this.a) ? this : new y(localDate);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final l a() {
        return w.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b, com.github.catvod.spider.jdollar.time.temporal.l
    public final b c(long j, TemporalUnit temporalUnit) {
        return (y) super.c(j, temporalUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b, com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || pVar == com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || pVar == com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_MONTH || pVar == com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).isDateBased() : pVar != null && pVar.h(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return this.a.equals(((y) obj).a);
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final int hashCode() {
        w.c.getClass();
        return this.a.hashCode() ^ (-688086063);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return (y) super.z(localDate);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.i(this);
        }
        if (!d(pVar)) {
            throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        int i = x.a[aVar.ordinal()];
        if (i == 1) {
            return com.github.catvod.spider.jdollar.time.temporal.s.f(1L, this.a.Z());
        }
        if (i == 2) {
            return com.github.catvod.spider.jdollar.time.temporal.s.f(1L, O());
        }
        if (i != 3) {
            return w.c.s(aVar);
        }
        int year = this.b.b.getYear();
        return this.b.g() != null ? com.github.catvod.spider.jdollar.time.temporal.s.f(1L, (r0.b.getYear() - year) + 1) : com.github.catvod.spider.jdollar.time.temporal.s.f(1L, 999999999 - year);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b t(long j, TemporalUnit temporalUnit) {
        return (y) super.t(j, temporalUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b z(com.github.catvod.spider.jdollar.time.temporal.m mVar) {
        return (y) super.z(mVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    public final com.github.catvod.spider.jdollar.time.temporal.l c(long j, TemporalUnit temporalUnit) {
        return (y) super.c(j, temporalUnit);
    }

    public y(z zVar, int i, LocalDate localDate) {
        if (!localDate.Y(d)) {
            this.b = zVar;
            this.c = i;
            this.a = localDate;
            return;
        }
        com.github.catvod.spider.jdollar.nio.file.b.k("JapaneseDate before Meiji 6 is not supported");
        throw null;
    }
}
