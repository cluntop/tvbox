package com.github.catvod.spider.jdollar.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i1 extends com.github.catvod.spider.jdollar.time.chrono.m implements r0 {
    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.e(this, consumer);
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
        return com.github.catvod.spider.jdollar.time.chrono.m.n(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.m, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* bridge */ /* synthetic */ r0 trySplit() {
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.m, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* bridge */ /* synthetic */ a1 trySplit() {
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.r0
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.r0
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return false;
    }
}
