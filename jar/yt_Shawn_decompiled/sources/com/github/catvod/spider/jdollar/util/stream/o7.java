package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class o7 implements Spliterator {
    public final Supplier a;
    public Spliterator b;

    public o7(Supplier supplier) {
        this.a = supplier;
    }

    public final Spliterator a() {
        if (this.b == null) {
            this.b = (Spliterator) this.a.get();
        }
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return a().characteristics();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        return a().estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        a().forEachRemaining(consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Comparator getComparator() {
        return a().getComparator();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long getExactSizeIfKnown() {
        return a().getExactSizeIfKnown();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return com.github.catvod.spider.jdollar.time.chrono.m.k(this, i);
    }

    public final String toString() {
        return getClass().getName() + "[" + a() + "]";
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        return a().tryAdvance(consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        return a().trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.a1 trySplit() {
        return (com.github.catvod.spider.jdollar.util.a1) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.u0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.x0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.r0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) trySplit();
    }
}
