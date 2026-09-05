package com.github.catvod.spider.jdollar.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements PrimitiveIterator$OfDouble, z {
    public final /* synthetic */ PrimitiveIterator.OfDouble a;

    public /* synthetic */ f0(PrimitiveIterator.OfDouble ofDouble) {
        this.a = ofDouble;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfDouble ofDouble = this.a;
        if (obj instanceof f0) {
            obj = ((f0) obj).a;
        }
        return ofDouble.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.n0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((PrimitiveIterator.OfDouble) obj);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfDouble, java.util.Iterator
    public final /* synthetic */ Double next() {
        return this.a.next();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfDouble
    public final /* synthetic */ double nextDouble() {
        return this.a.nextDouble();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.a.remove();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfDouble, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining((Consumer<? super Double>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfDouble
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.a.forEachRemaining(doubleConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.a.next();
    }
}
