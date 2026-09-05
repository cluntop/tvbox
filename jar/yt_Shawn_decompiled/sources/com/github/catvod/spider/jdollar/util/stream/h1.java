package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.LongConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h1 extends k1 {
    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator I(Supplier supplier) {
        return new m7(supplier);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean M() {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k1, com.github.catvod.spider.jdollar.util.stream.LongStream
    public final void forEach(LongConsumer longConsumer) {
        if (this.a.l) {
            super.forEach(longConsumer);
        } else {
            k1.U(P()).forEachRemaining(longConsumer);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k1, com.github.catvod.spider.jdollar.util.stream.LongStream
    public final void forEachOrdered(LongConsumer longConsumer) {
        if (this.a.l) {
            super.forEachOrdered(longConsumer);
        } else {
            k1.U(P()).forEachRemaining(longConsumer);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final LongStream parallel() {
        this.a.l = true;
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final LongStream sequential() {
        this.a.l = false;
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final BaseStream unordered() {
        return !b7.ORDERED.o(this.f) ? this : new u(this, b7.r, 4);
    }
}
