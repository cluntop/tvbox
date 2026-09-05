package com.github.catvod.spider.jdollar.util;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class s0 implements u0 {
    public final /* synthetic */ Spliterator.OfInt a;

    public /* synthetic */ s0(Spliterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public static /* synthetic */ u0 a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof t0 ? ((t0) ofInt).a : new s0(ofInt);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfInt ofInt = this.a;
        if (obj instanceof s0) {
            obj = ((s0) obj).a;
        }
        return ofInt.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((Spliterator.OfInt) obj);
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
        return this.a.tryAdvance((Spliterator.OfInt) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.u0, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ u0 trySplit() {
        return a(this.a.trySplit());
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining((Consumer<? super Integer>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.u0
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.a.forEachRemaining(intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.a.tryAdvance((Consumer<? super Integer>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.u0
    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.a.tryAdvance(intConsumer);
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
