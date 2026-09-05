package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t4 extends w4 implements k5 {
    @Override // com.github.catvod.spider.jdollar.util.stream.w4, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        this.b++;
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        v3.g(this, num);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.q4
    public final void j(q4 q4Var) {
        this.b += ((w4) q4Var).b;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }
}
