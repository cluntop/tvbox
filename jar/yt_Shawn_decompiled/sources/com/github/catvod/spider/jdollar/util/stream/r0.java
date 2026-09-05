package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r0 extends CountedCompleter {
    public Spliterator a;
    public final m5 b;
    public final a c;
    public long d;

    public r0(r0 r0Var, Spliterator spliterator) {
        super(r0Var);
        this.a = spliterator;
        this.b = r0Var.b;
        this.d = r0Var.d;
        this.c = r0Var.c;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.a;
        long jEstimateSize = spliterator.estimateSize();
        long jE = this.d;
        if (jE == 0) {
            jE = d.e(jEstimateSize);
            this.d = jE;
        }
        boolean zO = b7.SHORT_CIRCUIT.o(this.c.f);
        m5 m5Var = this.b;
        boolean z = false;
        r0 r0Var = this;
        while (true) {
            if (zO && m5Var.e()) {
                break;
            }
            if (jEstimateSize <= jE || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                break;
            }
            r0 r0Var2 = new r0(r0Var, spliteratorTrySplit);
            r0Var.addToPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
            } else {
                r0 r0Var3 = r0Var;
                r0Var = r0Var2;
                r0Var2 = r0Var3;
            }
            z = !z;
            r0Var.fork();
            r0Var = r0Var2;
            jEstimateSize = spliterator.estimateSize();
        }
        r0Var.c.k(spliterator, m5Var);
        r0Var.a = null;
        r0Var.propagateCompletion();
    }

    public r0(a aVar, Spliterator spliterator, m5 m5Var) {
        super(null);
        this.b = m5Var;
        this.c = aVar;
        this.a = spliterator;
        this.d = 0L;
    }
}
