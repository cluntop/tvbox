package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s4 extends w4 implements j5 {
    @Override // com.github.catvod.spider.jdollar.util.stream.w4, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        this.b++;
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.q4
    public final void j(q4 q4Var) {
        this.b += ((w4) q4Var).b;
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
