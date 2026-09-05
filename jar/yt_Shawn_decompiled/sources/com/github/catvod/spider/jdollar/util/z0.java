package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class z0 implements Spliterator.OfPrimitive {
    public final /* synthetic */ a1 a;

    public /* synthetic */ z0(a1 a1Var) {
        this.a = a1Var;
    }

    public static /* synthetic */ Spliterator.OfPrimitive a(a1 a1Var) {
        if (a1Var == null) {
            return null;
        }
        return a1Var instanceof y0 ? ((y0) a1Var).a : a1Var instanceof r0 ? q0.a((r0) a1Var) : a1Var instanceof u0 ? t0.a((u0) a1Var) : a1Var instanceof x0 ? w0.a((x0) a1Var) : new z0(a1Var);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        a1 a1Var = this.a;
        if (obj instanceof z0) {
            obj = ((z0) obj).a;
        }
        return a1Var.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ java.util.Comparator getComparator() {
        return this.a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.a.tryAdvance(obj);
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return a(this.a.trySplit());
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(consumer);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.a.tryAdvance(consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ java.util.Spliterator trySplit() {
        return Spliterator.Wrapper.convert(this.a.trySplit());
    }
}
