package com.github.catvod.spider.jdollar.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class l0 implements PrimitiveIterator$OfLong, z {
    public final /* synthetic */ PrimitiveIterator.OfLong a;

    public /* synthetic */ l0(PrimitiveIterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfLong ofLong = this.a;
        if (obj instanceof l0) {
            obj = ((l0) obj).a;
        }
        return ofLong.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.n0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((PrimitiveIterator.OfLong) obj);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfLong, java.util.Iterator
    public final /* synthetic */ Long next() {
        return this.a.next();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfLong
    public final /* synthetic */ long nextLong() {
        return this.a.nextLong();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.a.remove();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining((Consumer<? super Long>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfLong
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.a.forEachRemaining(longConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.a.next();
    }
}
