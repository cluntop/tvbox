package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e0 extends i0 implements j5 {
    public static final d0 c;
    public static final d0 d;

    static {
        c7 c7Var = c7.DOUBLE_VALUE;
        j jVar = new j(17);
        j jVar2 = new j(18);
        com.github.catvod.spider.jdollar.util.b0 b0Var = com.github.catvod.spider.jdollar.util.b0.c;
        c = new d0(true, c7Var, b0Var, jVar, jVar2);
        d = new d0(false, c7Var, b0Var, new j(17), new j(18));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i0, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d2) {
        r(Double.valueOf(d2));
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.a) {
            return new com.github.catvod.spider.jdollar.util.b0(((Double) this.b).doubleValue());
        }
        return null;
    }
}
