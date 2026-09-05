package com.github.catvod.spider.jdollar.util;

import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s implements Spliterator {
    public final Spliterator a;

    public s(Spliterator spliterator) {
        this.a = spliterator;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return this.a.characteristics();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        this.a.forEachRemaining(new com.github.catvod.spider.jdollar.nio.file.w(consumer, 2));
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final java.util.Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean hasCharacteristics(int i) {
        return this.a.hasCharacteristics(i);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return this.a.tryAdvance(new com.github.catvod.spider.jdollar.nio.file.w(consumer, 2));
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator spliteratorTrySplit = this.a.trySplit();
        if (spliteratorTrySplit == null) {
            return null;
        }
        return new s(spliteratorTrySplit);
    }
}
