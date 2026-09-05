package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h0 extends a implements Serializable {
    public static final h0 c = new h0();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map.put("en", new String[]{"BB", "BE"});
        map.put("th", new String[]{"BB", "BE"});
        map2.put("en", new String[]{"B.B.", "B.E."});
        map2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        map3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        map3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private h0() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b C(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof j0 ? (j0) temporalAccessor : new j0(LocalDate.U(temporalAccessor));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b K(int i, int i2, int i3) {
        return new j0(LocalDate.of(i - 543, i2, i3));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a, com.github.catvod.spider.jdollar.time.chrono.l
    public final b M(Map map, com.github.catvod.spider.jdollar.time.format.c0 c0Var) {
        return (j0) super.M(map, c0Var);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final ChronoZonedDateTime N(Instant instant, ZoneId zoneId) {
        return k.T(this, instant, zoneId);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final boolean Q(long j) {
        return t.c.Q(j - 543);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b f(long j) {
        return new j0(LocalDate.c0(j));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String getId() {
        return "ThaiBuddhist";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.a
    public final b i() {
        return new j0(LocalDate.U(LocalDate.b0(com.github.catvod.spider.jdollar.com.android.tools.r8.a.T())));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final String l() {
        return "buddhist";
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final b m(int i, int i2) {
        return new j0(LocalDate.d0(i - 543, i2));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final com.github.catvod.spider.jdollar.time.temporal.s s(com.github.catvod.spider.jdollar.time.temporal.a aVar) {
        int i = g0.a[aVar.ordinal()];
        if (i == 1) {
            com.github.catvod.spider.jdollar.time.temporal.s sVar = com.github.catvod.spider.jdollar.time.temporal.a.PROLEPTIC_MONTH.b;
            return com.github.catvod.spider.jdollar.time.temporal.s.f(sVar.a + 6516, sVar.d + 6516);
        }
        if (i == 2) {
            com.github.catvod.spider.jdollar.time.temporal.s sVar2 = com.github.catvod.spider.jdollar.time.temporal.a.YEAR.b;
            return com.github.catvod.spider.jdollar.time.temporal.s.g(1L, (-(sVar2.a + 543)) + 1, sVar2.d + 543);
        }
        if (i != 3) {
            return aVar.b;
        }
        com.github.catvod.spider.jdollar.time.temporal.s sVar3 = com.github.catvod.spider.jdollar.time.temporal.a.YEAR.b;
        return com.github.catvod.spider.jdollar.time.temporal.s.f(sVar3.a + 543, sVar3.d + 543);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final List u() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.B(k0.values());
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final n v(int i) {
        if (i == 0) {
            return k0.BEFORE_BE;
        }
        if (i == 1) {
            return k0.BE;
        }
        com.github.catvod.spider.jdollar.nio.file.b.d("Invalid era: ", i);
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.l
    public final int w(n nVar, int i) {
        if (nVar instanceof k0) {
            return nVar == k0.BE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    public Object writeReplace() {
        return new f0((byte) 1, this);
    }
}
