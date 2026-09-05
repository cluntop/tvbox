package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class f8 extends i8 implements com.github.catvod.spider.jdollar.util.a1 {
    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        h7 h7VarH = null;
        while (true) {
            h8 h8VarF = f();
            if (h8VarF == h8.NO_MORE) {
                return;
            }
            h8 h8Var = h8.MAYBE_MORE;
            Spliterator spliterator = this.a;
            if (h8VarF != h8Var) {
                ((com.github.catvod.spider.jdollar.util.a1) spliterator).forEachRemaining(obj);
                return;
            }
            int i = this.c;
            if (h7VarH == null) {
                h7VarH = h(i);
            } else {
                h7VarH.b = 0;
            }
            long j = 0;
            while (((com.github.catvod.spider.jdollar.util.a1) spliterator).tryAdvance(h7VarH)) {
                j++;
                if (j >= i) {
                    break;
                }
            }
            if (j == 0) {
                return;
            } else {
                h7VarH.a(obj, a(j));
            }
        }
    }

    public abstract void g(Object obj);

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return com.github.catvod.spider.jdollar.time.chrono.m.i(this);
    }

    public abstract h7 h(int i);

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return com.github.catvod.spider.jdollar.time.chrono.m.k(this, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        while (f() != h8.NO_MORE && ((com.github.catvod.spider.jdollar.util.a1) this.a).tryAdvance(this)) {
            if (a(1L) == 1) {
                g(obj);
                return true;
            }
        }
        return false;
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
