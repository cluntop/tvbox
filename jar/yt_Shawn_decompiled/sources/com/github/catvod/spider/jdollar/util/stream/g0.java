package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g0 extends i0 implements l5 {
    public static final d0 c;
    public static final d0 d;

    static {
        c7 c7Var = c7.LONG_VALUE;
        j jVar = new j(21);
        j jVar2 = new j(22);
        com.github.catvod.spider.jdollar.util.d0 d0Var = com.github.catvod.spider.jdollar.util.d0.c;
        c = new d0(true, c7Var, d0Var, jVar, jVar2);
        d = new d0(false, c7Var, d0Var, new j(21), new j(22));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i0, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        r(Long.valueOf(j));
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.a) {
            return new com.github.catvod.spider.jdollar.util.d0(((Long) this.b).longValue());
        }
        return null;
    }
}
