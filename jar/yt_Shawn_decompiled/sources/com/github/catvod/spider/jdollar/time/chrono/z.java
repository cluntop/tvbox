package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.LocalDate;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class z implements n, Serializable {
    public static final z d;
    public static final z[] e;
    private static final long serialVersionUID = 1466499369062886794L;
    public final transient int a;
    public final transient LocalDate b;
    public final transient String c;

    static {
        z zVar = new z(-1, LocalDate.of(1868, 1, 1), "Meiji");
        d = zVar;
        e = new z[]{zVar, new z(0, LocalDate.of(1912, 7, 30), "Taisho"), new z(1, LocalDate.of(1926, 12, 25), "Showa"), new z(2, LocalDate.of(1989, 1, 8), "Heisei"), new z(3, LocalDate.of(2019, 5, 1), "Reiwa")};
    }

    public z(int i, LocalDate localDate, String str) {
        this.a = i;
        this.b = localDate;
        this.c = str;
    }

    public static z f(LocalDate localDate) {
        if (localDate.Y(y.d)) {
            com.github.catvod.spider.jdollar.nio.file.b.k("JapaneseDate before Meiji 6 are not supported");
            return null;
        }
        for (int length = e.length - 1; length >= 0; length--) {
            z zVar = e[length];
            if (localDate.compareTo(zVar.b) >= 0) {
                return zVar;
            }
        }
        return null;
    }

    public static z k(int i) {
        int i2 = i + 1;
        if (i2 >= 0) {
            z[] zVarArr = e;
            if (i2 < zVarArr.length) {
                return zVarArr[i2];
            }
        }
        com.github.catvod.spider.jdollar.nio.file.b.d("Invalid era: ", i);
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new f0((byte) 5, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return m.j(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return m.l(this, pVar);
    }

    public final z g() {
        if (this == e[r0.length - 1]) {
            return null;
        }
        return k(this.a + 1);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.n
    public final int getValue() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return m.h(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.ERA;
        return pVar == aVar ? w.c.s(aVar) : com.github.catvod.spider.jdollar.time.temporal.q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(getValue(), com.github.catvod.spider.jdollar.time.temporal.a.ERA);
    }

    public final String toString() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final /* synthetic */ Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return m.m(this, mVar);
    }
}
