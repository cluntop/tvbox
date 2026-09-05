package com.github.catvod.spider.jdollar.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements PrimitiveIterator$OfInt, z {
    public final /* synthetic */ PrimitiveIterator.OfInt a;

    public /* synthetic */ i0(PrimitiveIterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfInt ofInt = this.a;
        if (obj instanceof i0) {
            obj = ((i0) obj).a;
        }
        return ofInt.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.n0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((PrimitiveIterator.OfInt) obj);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfInt, java.util.Iterator
    public final /* synthetic */ Integer next() {
        return this.a.next();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfInt
    public final /* synthetic */ int nextInt() {
        return this.a.nextInt();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.a.remove();
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfInt, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining((Consumer<? super Integer>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfInt
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.a.forEachRemaining(intConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.a.next();
    }
}
