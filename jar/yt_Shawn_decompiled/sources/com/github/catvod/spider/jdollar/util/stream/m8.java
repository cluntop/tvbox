package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.Comparator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class m8 implements Consumer, Spliterator {
    public int a;
    public Object b;
    public x6 c;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        if (i == 0) {
            this.b = obj;
            this.a = i + 1;
        } else {
            if (i <= 0) {
                throw new IllegalStateException();
            }
            if (this.c == null) {
                x6 x6Var = new x6();
                this.c = x6Var;
                x6Var.accept(this.b);
                this.a++;
            }
            this.c.accept(obj);
        }
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return 17488;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        return (-this.a) - 1;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        if (this.a == -2) {
            consumer.accept(this.b);
            this.a = -1;
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
        if (this.a != -2) {
            return false;
        }
        consumer.accept(this.b);
        this.a = -1;
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        return null;
    }
}
