package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v7 extends d7 implements com.github.catvod.spider.jdollar.util.x0 {
    @Override // com.github.catvod.spider.jdollar.util.stream.d7
    public final void d() {
        u6 u6Var = new u6();
        this.h = u6Var;
        Objects.requireNonNull(u6Var);
        this.e = this.b.S(new u7(u6Var, 1));
        this.f = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(18, this);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7
    public final d7 e(Spliterator spliterator) {
        return new v7(this.b, spliterator, this.a);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(LongConsumer longConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(longConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(longConsumer);
        c();
        Objects.requireNonNull(longConsumer);
        u7 u7Var = new u7(longConsumer, 0);
        this.b.R(this.d, u7Var);
        this.i = true;
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        boolean zA = a();
        if (zA) {
            u6 u6Var = (u6) this.h;
            long j = this.g;
            int iV = u6Var.v(j);
            longConsumer.accept((u6Var.c == 0 && iV == 0) ? ((long[]) u6Var.e)[(int) j] : ((long[][]) u6Var.f)[iV][(int) (j - u6Var.d[iV])]);
        }
        return zA;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final com.github.catvod.spider.jdollar.util.x0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final com.github.catvod.spider.jdollar.util.a1 trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.g(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.p(this, consumer);
    }
}
