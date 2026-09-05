package com.github.catvod.spider.jdollar.util;

import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l1 extends com.github.catvod.spider.jdollar.time.chrono.m implements Spliterator {
    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
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
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return false;
    }
}
