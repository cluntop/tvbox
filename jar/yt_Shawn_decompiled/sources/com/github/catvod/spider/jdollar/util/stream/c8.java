package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c8 extends f8 implements com.github.catvod.spider.jdollar.util.r0, DoubleConsumer {
    public double f;

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f = d;
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i8
    public final Spliterator b(Spliterator spliterator) {
        return new c8((com.github.catvod.spider.jdollar.util.r0) spliterator, this);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.e(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f8
    public final void g(Object obj) {
        ((DoubleConsumer) obj).accept(this.f);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f8
    public final h7 h(int i) {
        return new e7(i);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.n(this, consumer);
    }
}
