package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r7 extends d7 implements com.github.catvod.spider.jdollar.util.r0 {
    @Override // com.github.catvod.spider.jdollar.util.stream.d7
    public final void d() {
        q6 q6Var = new q6();
        this.h = q6Var;
        Objects.requireNonNull(q6Var);
        this.e = this.b.S(new q7(q6Var, 1));
        this.f = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(16, this);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7
    public final d7 e(Spliterator spliterator) {
        return new r7(this.b, spliterator, this.a);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(doubleConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(doubleConsumer);
        c();
        Objects.requireNonNull(doubleConsumer);
        q7 q7Var = new q7(doubleConsumer, 0);
        this.b.R(this.d, q7Var);
        this.i = true;
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        boolean zA = a();
        if (zA) {
            q6 q6Var = (q6) this.h;
            long j = this.g;
            int iV = q6Var.v(j);
            doubleConsumer.accept((q6Var.c == 0 && iV == 0) ? ((double[]) q6Var.e)[(int) j] : ((double[][]) q6Var.f)[iV][(int) (j - q6Var.d[iV])]);
        }
        return zA;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final com.github.catvod.spider.jdollar.util.r0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final com.github.catvod.spider.jdollar.util.a1 trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.e(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.n(this, consumer);
    }
}
