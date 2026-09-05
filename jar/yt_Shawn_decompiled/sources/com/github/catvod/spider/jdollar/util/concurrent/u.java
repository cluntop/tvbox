package com.github.catvod.spider.jdollar.util.concurrent;

import com.github.catvod.spider.jdollar.util.r0;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class u implements r0 {
    public long a;
    public final long b;
    public final double c;
    public final double d;

    public u(long j, long j2, double d, double d2) {
        this.a = j;
        this.b = j2;
        this.c = d;
        this.d = d2;
    }

    @Override // com.github.catvod.spider.jdollar.util.r0, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final u trySplit() {
        long j = this.a;
        long j2 = (this.b + j) >>> 1;
        if (j2 <= j) {
            return null;
        }
        this.a = j2;
        return new u(j, j2, this.c, this.d);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        return this.b - this.a;
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j = this.a;
        long j2 = this.b;
        if (j < j2) {
            this.a = j2;
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            do {
                doubleConsumer.accept(threadLocalRandomCurrent.a(this.c, this.d));
                j++;
            } while (j < j2);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Comparator getComparator() {
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

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j = this.a;
        if (j >= this.b) {
            return false;
        }
        doubleConsumer.accept(ThreadLocalRandom.current().a(this.c, this.d));
        this.a = j + 1;
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.n(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.e(this, consumer);
    }
}
