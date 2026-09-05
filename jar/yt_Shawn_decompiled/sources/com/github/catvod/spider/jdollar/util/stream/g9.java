package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class g9 implements Spliterator {
    public final Spliterator a;
    public final AtomicBoolean b;
    public boolean c;
    public int d;

    public g9(Spliterator spliterator) {
        this.c = true;
        this.a = spliterator;
        this.b = new AtomicBoolean();
    }

    public final boolean a() {
        return (this.d == 0 && this.b.get()) ? false : true;
    }

    public abstract Spliterator b(Spliterator spliterator);

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return this.a.characteristics() & (-16449);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public void forEachRemaining(Consumer consumer) {
        while (tryAdvance(consumer)) {
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long getExactSizeIfKnown() {
        return -1L;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return com.github.catvod.spider.jdollar.time.chrono.m.k(this, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public Spliterator trySplit() {
        Spliterator spliteratorTrySplit = this.a.trySplit();
        if (spliteratorTrySplit != null) {
            return b(spliteratorTrySplit);
        }
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.u0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) trySplit();
    }

    public g9(Spliterator spliterator, g9 g9Var) {
        this.c = true;
        this.a = spliterator;
        g9Var.getClass();
        this.b = g9Var.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.x0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.r0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.a1 trySplit() {
        return (com.github.catvod.spider.jdollar.util.a1) trySplit();
    }
}
