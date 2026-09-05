package com.github.catvod.spider.jdollar.util;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j1 extends com.github.catvod.spider.jdollar.time.chrono.m implements u0 {
    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.f(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final java.util.Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return com.github.catvod.spider.jdollar.time.chrono.m.i(this);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return com.github.catvod.spider.jdollar.time.chrono.m.k(this, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.o(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.m, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* bridge */ /* synthetic */ u0 trySplit() {
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.m, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* bridge */ /* synthetic */ a1 trySplit() {
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.u0
    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.u0
    public final boolean tryAdvance(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return false;
    }
}
