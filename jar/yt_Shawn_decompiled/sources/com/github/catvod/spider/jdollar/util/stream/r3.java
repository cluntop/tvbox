package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class r3 extends CountedCompleter implements m5 {
    public final Spliterator a;
    public final a b;
    public final long c;
    public final long d;
    public final long e;
    public int f;
    public int g;

    public r3(r3 r3Var, Spliterator spliterator, long j, long j2, int i) {
        super(r3Var);
        this.a = spliterator;
        this.b = r3Var.b;
        this.c = r3Var.c;
        this.d = j;
        this.e = j2;
        if (j < 0 || j2 < 0 || (j + j2) - 1 >= i) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)));
        }
    }

    public abstract r3 a(Spliterator spliterator, long j, long j2);

    public /* synthetic */ void accept(double d) {
        v3.c();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        long j2 = this.e;
        if (j > j2) {
            throw new IllegalStateException("size passed to Sink.begin exceeds array length");
        }
        int i = (int) this.d;
        this.f = i;
        this.g = i + ((int) j2);
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.a;
        r3 r3VarA = this;
        while (spliterator.estimateSize() > r3VarA.c && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            r3VarA.setPendingCount(1);
            long jEstimateSize = spliteratorTrySplit.estimateSize();
            r3 r3Var = r3VarA;
            r3Var.a(spliteratorTrySplit, r3VarA.d, jEstimateSize).fork();
            r3VarA = r3Var.a(spliterator, r3Var.d + jEstimateSize, r3Var.e - jEstimateSize);
        }
        r3 r3Var2 = r3VarA;
        r3Var2.b.R(spliterator, r3Var2);
        r3Var2.propagateCompletion();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void end() {
    }

    public /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }

    public r3(Spliterator spliterator, a aVar, int i) {
        this.a = spliterator;
        this.b = aVar;
        this.c = d.e(spliterator.estimateSize());
        this.d = 0L;
        this.e = i;
    }
}
