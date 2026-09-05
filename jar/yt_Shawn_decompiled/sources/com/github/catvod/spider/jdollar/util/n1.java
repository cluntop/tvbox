package com.github.catvod.spider.jdollar.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class n1 implements Spliterator {
    public final Collection a;
    public Iterator b;
    public final int c;
    public long d;
    public int e;

    public n1(Iterator it, int i) {
        this.a = null;
        this.b = it;
        this.d = Long.MAX_VALUE;
        this.c = i & (-16449);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        if (this.b != null) {
            return this.d;
        }
        this.b = this.a.iterator();
        long size = this.a.size();
        this.d = size;
        return size;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        Iterator it = this.b;
        if (it == null) {
            it = this.a.iterator();
            this.b = it;
            this.d = this.a.size();
        }
        com.github.catvod.spider.jdollar.time.chrono.m.A(it, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public java.util.Comparator getComparator() {
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
        if (this.b == null) {
            this.b = this.a.iterator();
            this.d = this.a.size();
        }
        if (!this.b.hasNext()) {
            return false;
        }
        consumer.accept(this.b.next());
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        long size;
        Iterator it = this.b;
        if (it == null) {
            it = this.a.iterator();
            this.b = it;
            size = this.a.size();
            this.d = size;
        } else {
            size = this.d;
        }
        if (size <= 1 || !it.hasNext()) {
            return null;
        }
        int i = this.e + 1024;
        if (i > size) {
            i = (int) size;
        }
        if (i > 33554432) {
            i = 33554432;
        }
        Object[] objArr = new Object[i];
        int i2 = 0;
        do {
            objArr[i2] = it.next();
            i2++;
            if (i2 >= i) {
                break;
            }
        } while (it.hasNext());
        this.e = i2;
        long j = this.d;
        if (j != Long.MAX_VALUE) {
            this.d = j - i2;
        }
        return new g1(objArr, 0, i2, this.c);
    }

    public n1(int i, Collection collection) {
        this.a = collection;
        this.b = null;
        this.c = i | 16448;
    }
}
