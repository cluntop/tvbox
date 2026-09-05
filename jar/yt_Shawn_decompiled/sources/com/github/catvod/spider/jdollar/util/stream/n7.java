package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class n7 extends o7 implements com.github.catvod.spider.jdollar.util.a1 {
    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(Object obj) {
        ((com.github.catvod.spider.jdollar.util.a1) a()).forEachRemaining(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final boolean tryAdvance(Object obj) {
        return ((com.github.catvod.spider.jdollar.util.a1) a()).tryAdvance(obj);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }
}
