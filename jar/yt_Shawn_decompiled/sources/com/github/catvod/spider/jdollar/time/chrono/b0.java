package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b0 extends a implements Serializable {
    public static final b0 c = new b0();
    private static final long serialVersionUID = 1039765215346859963L;

    private b0() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b C(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof d0 ? (d0) temporalAccessor : new d0(LocalDate.U(temporalAccessor));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b K(int i, int i2, int i3) {
        return new d0(LocalDate.of(i + 1911, i2, i3));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a, com.github.catvod.spider.jdollar.time.chrono.l
    public final b M(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        return (d0) super.M(map, c0Var);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final ChronoZonedDateTime N(Instant instant, ZoneId zoneId) {
        return k.T(this, instant, zoneId);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final boolean Q(long j) {
        return t.c.Q(j + 1911);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b f(long j) {
        return new d0(LocalDate.c0(j));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String getId() {
        return "Minguo";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a
    public final b i() {
        return new d0(LocalDate.U(LocalDate.b0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.T())));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String l() {
        return "roc";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b m(int i, int i2) {
        return new d0(LocalDate.d0(i + 1911, i2));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final com.github.catvod.spider.jdollar.time.temporal.s s(com.github.catvod.spider.jdollar.time.temporal.a aVar) {
        int i = a0.a[aVar.ordinal()];
        if (i == 1) {
            com.github.catvod.spider.jdollar.time.temporal.s sVar = com.github.catvod.spider.jdollar.time.temporal.a.PROLEPTIC_MONTH.b;
            return com.github.catvod.spider.jdollar.time.temporal.s.f(sVar.a - 22932, sVar.d - 22932);
        }
        if (i == 2) {
            com.github.catvod.spider.jdollar.time.temporal.s sVar2 = com.github.catvod.spider.jdollar.time.temporal.a.YEAR.b;
            return com.github.catvod.spider.jdollar.time.temporal.s.g(1L, sVar2.d - 1911, (-sVar2.a) + 1912);
        }
        if (i != 3) {
            return aVar.b;
        }
        com.github.catvod.spider.jdollar.time.temporal.s sVar3 = com.github.catvod.spider.jdollar.time.temporal.a.YEAR.b;
        return com.github.catvod.spider.jdollar.time.temporal.s.f(sVar3.a - 1911, sVar3.d - 1911);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final List u() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.B(e0.values());
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final n v(int i) {
        if (i == 0) {
            return e0.BEFORE_ROC;
        }
        if (i == 1) {
            return e0.ROC;
        }
        com.github.catvod.spider.jdollar.nio.file.b.d("Invalid era: ", i);
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final int w(n nVar, int i) {
        if (nVar instanceof e0) {
            return nVar == e0.ROC ? i : 1 - i;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    public Object writeReplace() {
        return new f0((byte) 1, this);
    }
}
