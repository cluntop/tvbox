package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class p1 extends s1 implements k5 {
    @Override // com.github.catvod.spider.jdollar.util.stream.s1, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        if (this.a) {
            return;
        }
        IntPredicate intPredicate = null;
        intPredicate.test(i);
        throw null;
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        v3.g(this, num);
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }
}
