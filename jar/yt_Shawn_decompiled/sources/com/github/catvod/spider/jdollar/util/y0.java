package com.github.catvod.spider.jdollar.util;

import java.util.Spliterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class y0 implements a1 {
    public final /* synthetic */ Spliterator.OfPrimitive a;

    public /* synthetic */ y0(Spliterator.OfPrimitive ofPrimitive) {
        this.a = ofPrimitive;
    }

    public static /* synthetic */ a1 a(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof z0 ? ((z0) ofPrimitive).a : ofPrimitive instanceof Spliterator.OfDouble ? p0.a((Spliterator.OfDouble) ofPrimitive) : ofPrimitive instanceof Spliterator.OfInt ? s0.a((Spliterator.OfInt) ofPrimitive) : ofPrimitive instanceof Spliterator.OfLong ? v0.a((Spliterator.OfLong) ofPrimitive) : new y0(ofPrimitive);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfPrimitive ofPrimitive = this.a;
        if (obj instanceof y0) {
            obj = ((y0) obj).a;
        }
        return ofPrimitive.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((Spliterator.OfPrimitive) obj);
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
        return this.a.tryAdvance((Spliterator.OfPrimitive) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ a1 trySplit() {
        return a(this.a.trySplit());
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.a.tryAdvance(consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return b1.a(this.a.trySplit());
    }
}
