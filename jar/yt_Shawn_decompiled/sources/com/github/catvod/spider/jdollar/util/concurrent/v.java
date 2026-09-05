package com.github.catvod.spider.jdollar.util.concurrent;

import com.github.catvod.spider.jdollar.util.u0;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v implements u0 {
    public long a;
    public final long b;
    public final int c;
    public final int d;

    public v(long j, long j2, int i, int i2) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = i2;
    }

    @Override // com.github.catvod.spider.jdollar.util.u0, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final v trySplit() {
        long j = this.a;
        long j2 = (this.b + j) >>> 1;
        if (j2 <= j) {
            return null;
        }
        this.a = j2;
        return new v(j, j2, this.c, this.d);
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
    public final void forEachRemaining(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j = this.a;
        long j2 = this.b;
        if (j < j2) {
            this.a = j2;
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            do {
                intConsumer.accept(threadLocalRandomCurrent.b(this.c, this.d));
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
    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j = this.a;
        if (j >= this.b) {
            return false;
        }
        intConsumer.accept(ThreadLocalRandom.current().b(this.c, this.d));
        this.a = j + 1;
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.o(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.f(this, consumer);
    }
}
