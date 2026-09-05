package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.ArrayList;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o extends i {
    public static final LocalDate h = LocalDate.of(2000, 1, 1);
    public final com.github.catvod.spider.jdollar.time.chrono.b g;

    public o(com.github.catvod.spider.jdollar.time.temporal.p pVar, int i, int i2, com.github.catvod.spider.jdollar.time.chrono.b bVar, int i3) {
        super(pVar, i, i2, d0.NOT_NEGATIVE, i3);
        this.g = bVar;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final long a(w wVar, long j) {
        long jAbs = Math.abs(j);
        com.github.catvod.spider.jdollar.time.chrono.b bVar = this.g;
        long jH = bVar != null ? com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(wVar.a).C(bVar).h(this.a) : 0;
        long[] jArr = i.f;
        if (j >= jH) {
            long j2 = jArr[this.b];
            if (j < jH + j2) {
                return jAbs % j2;
            }
        }
        return jAbs % jArr[this.c];
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final boolean b(v vVar) {
        if (vVar.c) {
            return super.b(vVar);
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final int c(final v vVar, long j, int i, int i2) {
        v vVar2;
        final long j2;
        final int i3;
        final int i4;
        int iH;
        long j3;
        com.github.catvod.spider.jdollar.time.chrono.b bVar = this.g;
        if (bVar != null) {
            com.github.catvod.spider.jdollar.time.chrono.l lVar = vVar.c().c;
            if (lVar == null && (lVar = vVar.a.e) == null) {
                lVar = com.github.catvod.spider.jdollar.time.chrono.t.c;
            }
            iH = lVar.C(bVar).h(this.a);
            j2 = j;
            i3 = i;
            i4 = i2;
            Consumer consumer = new Consumer() { // from class: com.github.catvod.spider.jdollar.time.format.n
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.c(vVar, j2, i3, i4);
                }

                @Override // java.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                    return Consumer$CC.$default$andThen(this, consumer2);
                }
            };
            vVar2 = vVar;
            if (vVar2.e == null) {
                vVar2.e = new ArrayList();
            }
            vVar2.e.add(consumer);
        } else {
            vVar2 = vVar;
            j2 = j;
            i3 = i;
            i4 = i2;
            iH = 0;
        }
        int i5 = i4 - i3;
        int i6 = this.b;
        if (i5 != i6 || j2 < 0) {
            j3 = j2;
        } else {
            long j4 = i.f[i6];
            long j5 = iH;
            long j6 = j5 - (j5 % j4);
            long j7 = iH > 0 ? j6 + j2 : j6 - j2;
            j3 = j7 < j5 ? j4 + j7 : j7;
        }
        return vVar2.f(this.a, j3, i3, i4);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final i d() {
        if (this.e == -1) {
            return this;
        }
        return new o(this.a, this.b, this.c, this.g, -1);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final i e(int i) {
        return new o(this.a, this.b, this.c, this.g, this.e + i);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.i
    public final String toString() {
        return "ReducedValue(" + this.a + "," + this.b + "," + this.c + "," + Objects.requireNonNullElse(this.g, 0) + ")";
    }
}
