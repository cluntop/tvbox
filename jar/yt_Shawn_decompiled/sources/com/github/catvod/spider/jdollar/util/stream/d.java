package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d extends CountedCompleter {
    public static final int g = ForkJoinPool.getCommonPoolParallelism() << 2;
    public final a a;
    public Spliterator b;
    public long c;
    public d d;
    public d e;
    public Object f;

    public d(d dVar, Spliterator spliterator) {
        super(dVar);
        this.b = spliterator;
        this.a = dVar.a;
        this.c = dVar.c;
    }

    public static long e(long j) {
        long j2 = j / g;
        if (j2 > 0) {
            return j2;
        }
        return 1L;
    }

    public abstract Object a();

    public final boolean b() {
        return ((d) getCompleter()) == null;
    }

    public abstract d c(Spliterator spliterator);

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.b;
        long jEstimateSize = spliterator.estimateSize();
        long jE = this.c;
        if (jE == 0) {
            jE = e(jEstimateSize);
            this.c = jE;
        }
        boolean z = false;
        d dVar = this;
        while (jEstimateSize > jE && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            d dVarC = dVar.c(spliteratorTrySplit);
            dVar.d = dVarC;
            d dVarC2 = dVar.c(spliterator);
            dVar.e = dVarC2;
            dVar.setPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
                dVar = dVarC;
                dVarC = dVarC2;
            } else {
                dVar = dVarC2;
            }
            z = !z;
            dVarC.fork();
            jEstimateSize = spliterator.estimateSize();
        }
        dVar.d(dVar.a());
        dVar.tryComplete();
    }

    public void d(Object obj) {
        this.f = obj;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.f;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.b = null;
        this.e = null;
        this.d = null;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public d(a aVar, Spliterator spliterator) {
        super(null);
        this.a = aVar;
        this.b = spliterator;
        this.c = 0L;
    }
}
