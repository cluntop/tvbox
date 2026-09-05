package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.Comparator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g8 extends i8 implements Spliterator, Consumer {
    public Object f;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f = obj;
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i8
    public final Spliterator b(Spliterator spliterator) {
        return new g8(spliterator, this);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        i7 i7Var = null;
        while (true) {
            h8 h8VarF = f();
            if (h8VarF == h8.NO_MORE) {
                return;
            }
            h8 h8Var = h8.MAYBE_MORE;
            Spliterator spliterator = this.a;
            if (h8VarF != h8Var) {
                spliterator.forEachRemaining(consumer);
                return;
            }
            int i = this.c;
            if (i7Var == null) {
                i7Var = new i7(i);
            } else {
                i7Var.a = 0;
            }
            long j = 0;
            while (spliterator.tryAdvance(i7Var)) {
                j++;
                if (j >= i) {
                    break;
                }
            }
            if (j == 0) {
                return;
            }
            long jA = a(j);
            for (int i2 = 0; i2 < jA; i2++) {
                consumer.accept(i7Var.b[i2]);
            }
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

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (f() != h8.NO_MORE && this.a.tryAdvance(this)) {
            if (a(1L) == 1) {
                consumer.accept(this.f);
                this.f = null;
                return true;
            }
        }
        return false;
    }
}
