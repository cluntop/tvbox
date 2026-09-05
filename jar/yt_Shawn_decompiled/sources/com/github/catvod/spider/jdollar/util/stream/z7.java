package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class z7 extends b8 implements com.github.catvod.spider.jdollar.util.a1 {
    public z7(com.github.catvod.spider.jdollar.util.a1 a1Var, long j, long j2) {
        super(a1Var, j, j2, 0L, Math.min(a1Var.estimateSize(), j2));
    }

    public abstract Object b();

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        long j = this.e;
        long j2 = this.a;
        if (j2 >= j) {
            return;
        }
        long j3 = this.d;
        if (j3 >= j) {
            return;
        }
        if (j3 >= j2 && ((com.github.catvod.spider.jdollar.util.a1) this.c).estimateSize() + j3 <= this.b) {
            ((com.github.catvod.spider.jdollar.util.a1) this.c).forEachRemaining(obj);
            this.d = this.e;
            return;
        }
        while (j2 > this.d) {
            ((com.github.catvod.spider.jdollar.util.a1) this.c).tryAdvance(b());
            this.d++;
        }
        while (this.d < this.e) {
            ((com.github.catvod.spider.jdollar.util.a1) this.c).tryAdvance(obj);
            this.d++;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return com.github.catvod.spider.jdollar.time.chrono.m.i(this);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return com.github.catvod.spider.jdollar.time.chrono.m.k(this, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final boolean tryAdvance(Object obj) {
        long j;
        Objects.requireNonNull(obj);
        long j2 = this.e;
        long j3 = this.a;
        if (j3 >= j2) {
            return false;
        }
        while (true) {
            j = this.d;
            if (j3 <= j) {
                break;
            }
            ((com.github.catvod.spider.jdollar.util.a1) this.c).tryAdvance(b());
            this.d++;
        }
        if (j >= this.e) {
            return false;
        }
        this.d = j + 1;
        return ((com.github.catvod.spider.jdollar.util.a1) this.c).tryAdvance(obj);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }
}
