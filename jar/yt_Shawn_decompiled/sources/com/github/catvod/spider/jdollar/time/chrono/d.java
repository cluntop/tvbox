package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import java.io.Serializable;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d implements b, com.github.catvod.spider.jdollar.time.temporal.l, com.github.catvod.spider.jdollar.time.temporal.m, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public static b S(l lVar, com.github.catvod.spider.jdollar.time.temporal.l lVar2) {
        b bVar = (b) lVar2;
        if (lVar.equals(bVar.a())) {
            return bVar;
        }
        com.github.catvod.spider.jdollar.nio.file.b.m("Chronology mismatch, expected: ", lVar.getId(), bVar.a().getId());
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public long F() {
        return E(com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public e G(LocalTime localTime) {
        return new g(this, localTime);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public n H() {
        return a().v(com.github.catvod.spider.jdollar.time.temporal.q.a(this, com.github.catvod.spider.jdollar.time.temporal.a.ERA));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public b L(com.github.catvod.spider.jdollar.time.temporal.o oVar) {
        return S(a(), oVar.h(this));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public int O() {
        return r() ? 366 : 365;
    }

    @Override // java.lang.Comparable
    /* renamed from: P */
    public final /* synthetic */ int compareTo(b bVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.b(this, bVar);
    }

    public abstract b T(long j);

    public abstract b U(long j);

    public abstract b V(long j);

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public b b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) {
            throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
        }
        return S(a(), pVar.A(this, j));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public b c(long j, TemporalUnit temporalUnit) {
        boolean z = temporalUnit instanceof ChronoUnit;
        if (!z) {
            if (!z) {
                return S(a(), temporalUnit.h(this, j));
            }
            com.github.catvod.spider.jdollar.nio.file.b.b(temporalUnit, "Unsupported unit: ");
            return null;
        }
        switch (c.a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return T(j);
            case 2:
                return T(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 7L));
            case 3:
                return U(j);
            case 4:
                return V(j);
            case 5:
                return V(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 10L));
            case 6:
                return V(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 100L));
            case 7:
                return V(com.github.catvod.spider.jdollar.com.android.tools.r8.a.O(j, 1000L));
            case 8:
                com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.ERA;
                return b(com.github.catvod.spider.jdollar.com.android.tools.r8.a.N(E(aVar), j), (com.github.catvod.spider.jdollar.time.temporal.p) aVar);
            default:
                com.github.catvod.spider.jdollar.nio.file.b.b(temporalUnit, "Unsupported unit: ");
                return null;
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b, com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public /* synthetic */ boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.f(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && com.github.catvod.spider.jdollar.com.android.tools.r8.a.b(this, (b) obj) == 0;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.time.temporal.q.a(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public int hashCode() {
        long jF = F();
        return a().hashCode() ^ ((int) (jF ^ (jF >>> 32)));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public /* synthetic */ com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return com.github.catvod.spider.jdollar.time.temporal.q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final /* synthetic */ com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.a(this, lVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public boolean r() {
        return a().Q(E(com.github.catvod.spider.jdollar.time.temporal.a.YEAR));
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public b t(long j, TemporalUnit temporalUnit) {
        return S(a(), com.github.catvod.spider.jdollar.time.temporal.q.b(this, j, temporalUnit));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final String toString() {
        long jE = E(com.github.catvod.spider.jdollar.time.temporal.a.YEAR_OF_ERA);
        long jE2 = E(com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR);
        long jE3 = E(com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(a().toString());
        sb.append(Stream.ID_UNKNOWN);
        sb.append(H());
        sb.append(Stream.ID_UNKNOWN);
        sb.append(jE);
        sb.append(jE2 < 10 ? "-0" : "-");
        sb.append(jE2);
        sb.append(jE3 < 10 ? "-0" : "-");
        sb.append(jE3);
        return sb.toString();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.g(this, mVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.l
    public b z(com.github.catvod.spider.jdollar.time.temporal.m mVar) {
        return S(a(), mVar.o(this));
    }
}
