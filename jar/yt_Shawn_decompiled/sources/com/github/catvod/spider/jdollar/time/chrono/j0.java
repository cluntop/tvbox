package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j0 extends d {
    private static final long serialVersionUID = -8722293800195731463L;
    public final transient LocalDate a;

    public j0(LocalDate localDate) {
        Objects.requireNonNull(localDate, "isoDate");
        this.a = localDate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new f0((byte) 8, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return (j0) super.t(j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        int i = i0.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i == 4) {
            int iW = W();
            if (iW < 1) {
                iW = 1 - iW;
            }
            return iW;
        }
        if (i == 5) {
            return ((W() * 12) + this.a.getMonthValue()) - 1;
        }
        if (i == 6) {
            return W();
        }
        if (i != 7) {
            return this.a.E(pVar);
        }
        return W() < 1 ? 0 : 1;
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
        return W() >= 1 ? k0.BE : k0.BEFORE_BE;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b L(com.github.catvod.spider.jdollar.time.temporal.o oVar) {
        return (j0) super.L(oVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    public final b T(long j) {
        return Y(this.a.f0(j));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    public final b U(long j) {
        return Y(this.a.g0(j));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    public final b V(long j) {
        return Y(this.a.i0(j));
    }

    public final int W() {
        return this.a.getYear() + 543;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.jdollar.time.chrono.j0 b(long r8, com.github.catvod.spider.jdollar.time.temporal.p r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.github.catvod.spider.jdollar.time.temporal.a
            if (r0 == 0) goto La4
            r0 = r10
            com.github.catvod.spider.jdollar.time.temporal.a r0 = (com.github.catvod.spider.jdollar.time.temporal.a) r0
            long r1 = r7.E(r0)
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 != 0) goto L10
            return r7
        L10:
            int[] r1 = com.github.catvod.spider.jdollar.time.chrono.i0.a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L4e
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L4e
            if (r2 == r3) goto L4e
            goto L64
        L25:
            com.github.catvod.spider.jdollar.time.chrono.h0 r10 = com.github.catvod.spider.jdollar.time.chrono.h0.c
            com.github.catvod.spider.jdollar.time.temporal.s r10 = r10.s(r0)
            r10.b(r8, r0)
            int r10 = r7.W()
            long r0 = (long) r10
            r2 = 12
            long r0 = r0 * r2
            com.github.catvod.spider.jdollar.time.LocalDate r10 = r7.a
            int r10 = r10.getMonthValue()
            long r2 = (long) r10
            long r0 = r0 + r2
            r2 = 1
            long r0 = r0 - r2
            long r8 = r8 - r0
            com.github.catvod.spider.jdollar.time.LocalDate r10 = r7.a
            com.github.catvod.spider.jdollar.time.LocalDate r8 = r10.g0(r8)
            com.github.catvod.spider.jdollar.time.chrono.j0 r8 = r7.Y(r8)
            return r8
        L4e:
            com.github.catvod.spider.jdollar.time.chrono.h0 r2 = com.github.catvod.spider.jdollar.time.chrono.h0.c
            com.github.catvod.spider.jdollar.time.temporal.s r2 = r2.s(r0)
            int r2 = r2.a(r8, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L8d
            if (r0 == r4) goto L80
            if (r0 == r3) goto L6f
        L64:
            com.github.catvod.spider.jdollar.time.LocalDate r0 = r7.a
            com.github.catvod.spider.jdollar.time.LocalDate r8 = r0.b(r8, r10)
            com.github.catvod.spider.jdollar.time.chrono.j0 r8 = r7.Y(r8)
            return r8
        L6f:
            com.github.catvod.spider.jdollar.time.LocalDate r8 = r7.a
            int r9 = r7.W()
            int r9 = (-542) - r9
            com.github.catvod.spider.jdollar.time.LocalDate r8 = r8.m0(r9)
            com.github.catvod.spider.jdollar.time.chrono.j0 r8 = r7.Y(r8)
            return r8
        L80:
            com.github.catvod.spider.jdollar.time.LocalDate r8 = r7.a
            int r2 = r2 + (-543)
            com.github.catvod.spider.jdollar.time.LocalDate r8 = r8.m0(r2)
            com.github.catvod.spider.jdollar.time.chrono.j0 r8 = r7.Y(r8)
            return r8
        L8d:
            com.github.catvod.spider.jdollar.time.LocalDate r8 = r7.a
            int r9 = r7.W()
            r10 = 1
            if (r9 < r10) goto L97
            goto L99
        L97:
            int r2 = 1 - r2
        L99:
            int r2 = r2 + (-543)
            com.github.catvod.spider.jdollar.time.LocalDate r8 = r8.m0(r2)
            com.github.catvod.spider.jdollar.time.chrono.j0 r8 = r7.Y(r8)
            return r8
        La4:
            com.github.catvod.spider.jdollar.time.chrono.b r8 = super.b(r8, r10)
            com.github.catvod.spider.jdollar.time.chrono.j0 r8 = (com.github.catvod.spider.jdollar.time.chrono.j0) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.time.chrono.j0.b(long, com.github.catvod.spider.jdollar.time.temporal.p):com.github.catvod.spider.jdollar.time.chrono.j0");
    }

    public final j0 Y(LocalDate localDate) {
        return localDate.equals(this.a) ? this : new j0(localDate);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final l a() {
        return h0.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b, com.github.catvod.spider.jdollar.time.temporal.l
    public final b c(long j, TemporalUnit temporalUnit) {
        return (j0) super.c(j, temporalUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            return this.a.equals(((j0) obj).a);
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final int hashCode() {
        h0.c.getClass();
        return this.a.hashCode() ^ 146118545;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return (j0) super.z(localDate);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.i(this);
        }
        if (!com.github.catvod.spider.jdollar.com.android.tools.r8.a.f(this, pVar)) {
            throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        int i = i0.a[aVar.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return this.a.j(pVar);
        }
        if (i != 4) {
            return h0.c.s(aVar);
        }
        com.github.catvod.spider.jdollar.time.temporal.s sVar = com.github.catvod.spider.jdollar.time.temporal.a.YEAR.b;
        return com.github.catvod.spider.jdollar.time.temporal.s.f(1L, W() <= 0 ? (-(sVar.a + 543)) + 1 : 543 + sVar.d);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b t(long j, TemporalUnit temporalUnit) {
        return (j0) super.t(j, temporalUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b z(com.github.catvod.spider.jdollar.time.temporal.m mVar) {
        return (j0) super.z(mVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    public final com.github.catvod.spider.jdollar.time.temporal.l c(long j, TemporalUnit temporalUnit) {
        return (j0) super.c(j, temporalUnit);
    }
}
