package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b1 implements Spliterator {
    public final /* synthetic */ java.util.Spliterator a;

    public /* synthetic */ b1(java.util.Spliterator spliterator) {
        this.a = spliterator;
    }

    public static /* synthetic */ Spliterator a(java.util.Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof Spliterator.Wrapper ? Spliterator.this : spliterator instanceof Spliterator.OfPrimitive ? y0.a((Spliterator.OfPrimitive) spliterator) : new b1(spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.Spliterator spliterator = this.a;
        if (obj instanceof b1) {
            obj = ((b1) obj).a;
        }
        return spliterator.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(consumer);
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

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.a.tryAdvance(consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return a(this.a.trySplit());
    }
}
