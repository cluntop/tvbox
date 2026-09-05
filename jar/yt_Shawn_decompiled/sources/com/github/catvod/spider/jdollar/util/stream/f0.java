package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f0 extends i0 implements k5 {
    public static final d0 c;
    public static final d0 d;

    static {
        c7 c7Var = c7.INT_VALUE;
        j jVar = new j(19);
        j jVar2 = new j(20);
        com.github.catvod.spider.jdollar.util.c0 c0Var = com.github.catvod.spider.jdollar.util.c0.c;
        c = new d0(true, c7Var, c0Var, jVar, jVar2);
        d = new d0(false, c7Var, c0Var, new j(19), new j(20));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i0, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        r(Integer.valueOf(i));
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.a) {
            return new com.github.catvod.spider.jdollar.util.c0(((Integer) this.b).intValue());
        }
        return null;
    }
}
