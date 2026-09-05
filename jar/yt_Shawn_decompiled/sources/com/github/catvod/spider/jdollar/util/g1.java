package com.github.catvod.spider.jdollar.util;

import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g1 implements Spliterator {
    public final Object[] a;
    public int b;
    public final int c;
    public final int d;

    public g1(Object[] objArr, int i, int i2, int i3) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
        this.d = i3 | 16448;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return this.d;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        return this.c - this.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int i;
        consumer.getClass();
        Object[] objArr = this.a;
        int length = objArr.length;
        int i2 = this.c;
        if (length < i2 || (i = this.b) < 0) {
            return;
        }
        this.b = i2;
        if (i < i2) {
            do {
                consumer.accept(objArr[i]);
                i++;
            } while (i < i2);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final java.util.Comparator getComparator() {
        if (com.github.catvod.spider.jdollar.time.chrono.m.k(this, 4)) {
            return null;
        }
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
        consumer.getClass();
        int i = this.b;
        if (i < 0 || i >= this.c) {
            return false;
        }
        this.b = i + 1;
        consumer.accept(this.a[i]);
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        int i = this.b;
        int i2 = (this.c + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        this.b = i2;
        return new g1(this.a, i, i2, this.d);
    }
}
