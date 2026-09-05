package com.github.catvod.spider.jdollar.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e1 implements PrimitiveIterator$OfLong, LongConsumer, z {
    public boolean a = false;
    public long b;
    public final /* synthetic */ x0 c;

    public e1(x0 x0Var) {
        this.c = x0Var;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.a = true;
        this.b = j;
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfLong, java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            forEachRemaining((LongConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (q1.a) {
            q1.a(e1.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        forEachRemaining((LongConsumer) new k0(consumer, 0));
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.a) {
            this.c.tryAdvance((LongConsumer) this);
        }
        return this.a;
    }

    @Override // java.util.Iterator
    public final Long next() {
        if (!q1.a) {
            return Long.valueOf(nextLong());
        }
        q1.a(e1.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfLong
    public final long nextLong() {
        if (!this.a && !hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = false;
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.n0
    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        while (hasNext()) {
            longConsumer.accept(nextLong());
        }
    }
}
