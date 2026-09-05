package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t7 extends d7 implements com.github.catvod.spider.jdollar.util.u0 {
    @Override // com.github.catvod.spider.jdollar.util.stream.d7
    public final void d() {
        s6 s6Var = new s6();
        this.h = s6Var;
        Objects.requireNonNull(s6Var);
        this.e = this.b.S(new s7(s6Var, 1));
        this.f = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(17, this);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7
    public final d7 e(Spliterator spliterator) {
        return new t7(this.b, spliterator, this.a);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(IntConsumer intConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(intConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(intConsumer);
        c();
        Objects.requireNonNull(intConsumer);
        s7 s7Var = new s7(intConsumer, 0);
        this.b.R(this.d, s7Var);
        this.i = true;
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final boolean tryAdvance(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        boolean zA = a();
        if (zA) {
            s6 s6Var = (s6) this.h;
            long j = this.g;
            int iV = s6Var.v(j);
            intConsumer.accept((s6Var.c == 0 && iV == 0) ? ((int[]) s6Var.e)[(int) j] : ((int[][]) s6Var.f)[iV][(int) (j - s6Var.d[iV])]);
        }
        return zA;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final com.github.catvod.spider.jdollar.util.u0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final com.github.catvod.spider.jdollar.util.a1 trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d7, com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) super.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.f(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.o(this, consumer);
    }
}
