package com.github.catvod.spider.jdollar.util;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class v0 implements x0 {
    public final /* synthetic */ Spliterator.OfLong a;

    public /* synthetic */ v0(Spliterator.OfLong ofLong) {
        this.a = ofLong;
    }

    public static /* synthetic */ x0 a(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof w0 ? ((w0) ofLong).a : new v0(ofLong);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfLong ofLong = this.a;
        if (obj instanceof v0) {
            obj = ((v0) obj).a;
        }
        return ofLong.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining((Spliterator.OfLong) obj);
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
        return this.a.tryAdvance((Spliterator.OfLong) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.x0, com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ x0 trySplit() {
        return a(this.a.trySplit());
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining((Consumer<? super Long>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.x0
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.a.forEachRemaining(longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.a.tryAdvance((Consumer<? super Long>) consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.x0
    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.a.tryAdvance(longConsumer);
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
