package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.DoubleConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class x extends a0 {
    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator I(Supplier supplier) {
        return new k7(supplier);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean M() {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a0, com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final void forEach(DoubleConsumer doubleConsumer) {
        if (this.a.l) {
            super.forEach(doubleConsumer);
        } else {
            a0.U(P()).forEachRemaining(doubleConsumer);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a0, com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final void forEachOrdered(DoubleConsumer doubleConsumer) {
        if (this.a.l) {
            super.forEachOrdered(doubleConsumer);
        } else {
            a0.U(P()).forEachRemaining(doubleConsumer);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final DoubleStream parallel() {
        this.a.l = true;
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final DoubleStream sequential() {
        this.a.l = false;
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final BaseStream unordered() {
        return !b7.ORDERED.o(this.f) ? this : new s(this, b7.r, 1);
    }
}
