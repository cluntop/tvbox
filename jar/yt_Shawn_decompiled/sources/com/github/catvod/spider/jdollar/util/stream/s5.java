package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s5 extends i1 {
    public final /* synthetic */ long m;
    public final /* synthetic */ long n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s5(k1 k1Var, int i, long j, long j2) {
        super(k1Var, i);
        this.m = j;
        this.n = j2;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 K(a aVar, Spliterator spliterator, IntFunction intFunction) {
        long jMin;
        long j;
        long jF = aVar.F(spliterator);
        if (jF > 0 && spliterator.hasCharacteristics(16384)) {
            a aVar2 = aVar;
            while (aVar2.e > 0) {
                aVar2 = aVar2.b;
            }
            return v3.E(aVar, v3.y(aVar2.H(), spliterator, this.m, this.n), true);
        }
        if (b7.ORDERED.o(aVar.f)) {
            return (g2) new x5(this, aVar, spliterator, intFunction, this.m, this.n).invoke();
        }
        com.github.catvod.spider.jdollar.util.x0 x0Var = (com.github.catvod.spider.jdollar.util.x0) aVar.T(spliterator);
        long j2 = this.m;
        long j3 = this.n;
        if (j2 <= jF) {
            long j4 = jF - j2;
            jMin = j3 >= 0 ? Math.min(j3, j4) : j4;
            j = 0;
        } else {
            jMin = j3;
            j = j2;
        }
        return v3.E(this, new e8(x0Var, j, jMin), true);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator L(a aVar, Spliterator spliterator) {
        long jF = aVar.F(spliterator);
        if (jF > 0 && spliterator.hasCharacteristics(16384)) {
            com.github.catvod.spider.jdollar.util.x0 x0Var = (com.github.catvod.spider.jdollar.util.x0) aVar.T(spliterator);
            long j = this.m;
            return new y7(x0Var, j, v3.A(j, this.n));
        }
        if (b7.ORDERED.o(aVar.f)) {
            return ((g2) new x5(this, aVar, spliterator, new u0(29), this.m, this.n).invoke()).spliterator();
        }
        com.github.catvod.spider.jdollar.util.x0 x0Var2 = (com.github.catvod.spider.jdollar.util.x0) aVar.T(spliterator);
        long j2 = this.m;
        long j3 = this.n;
        if (j2 <= jF) {
            long jMin = jF - j2;
            if (j3 >= 0) {
                jMin = Math.min(j3, jMin);
            }
            j3 = jMin;
            j2 = 0;
        }
        return new e8(x0Var2, j2, j3);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        return new r5(this, m5Var);
    }
}
