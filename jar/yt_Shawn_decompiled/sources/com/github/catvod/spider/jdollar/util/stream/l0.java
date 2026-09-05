package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l0 extends p0 implements j5 {
    public final DoubleConsumer b;

    public l0(DoubleConsumer doubleConsumer, boolean z) {
        super(z);
        this.b = doubleConsumer;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final Object a(a aVar, Spliterator spliterator) {
        aVar.R(spliterator, this);
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.p0, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        this.b.accept(d);
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final /* bridge */ /* synthetic */ Object b(a aVar, Spliterator spliterator) {
        g(aVar, spliterator);
        return null;
    }

    @Override // java.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5
    public final /* synthetic */ void r(Double d) {
        v3.d(this, d);
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        r((Double) obj);
    }
}
