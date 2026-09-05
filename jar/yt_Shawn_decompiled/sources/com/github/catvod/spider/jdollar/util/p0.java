package com.github.catvod.spider.jdollar.util;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class p0 implements r0 {
    public final /* synthetic */ Spliterator.OfDouble a;

    public /* synthetic */ p0(Spliterator.OfDouble ofDouble) {
        this.a = ofDouble;
    }

    public static /* synthetic */ r0 a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof q0 ? ((q0) ofDouble).a : new p0(ofDouble);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfDouble ofDouble = this.a;
        if (obj instanceof p0) {
            obj = ((p0) obj).a;
        }
        return ofDouble.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((Spliterator.OfDouble) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ java.util.Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.a.tryAdvance((Spliterator.OfDouble) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.r0, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ r0 trySplit() {
        return a(this.a.trySplit());
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining((Consumer<? super Double>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.r0
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.a.forEachRemaining(doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.a.tryAdvance((Consumer<? super Double>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.r0
    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.a.tryAdvance(doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ a1 trySplit() {
        return y0.a(this.a.trySplit());
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return b1.a(this.a.trySplit());
    }
}
