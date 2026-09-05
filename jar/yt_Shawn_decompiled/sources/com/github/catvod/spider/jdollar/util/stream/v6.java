package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class v6 implements com.github.catvod.spider.jdollar.util.a1 {
    public int a;
    public final int b;
    public int c;
    public final int d;
    public Object e;
    public final /* synthetic */ w6 f;

    public v6(w6 w6Var, int i, int i2, int i3, int i4) {
        this.f = w6Var;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        Object[] objArr = w6Var.f;
        this.e = objArr == null ? w6Var.e : objArr[i];
    }

    public abstract void a(int i, Object obj, Object obj2);

    public abstract com.github.catvod.spider.jdollar.util.a1 b(Object obj, int i, int i2);

    public abstract com.github.catvod.spider.jdollar.util.a1 c(int i, int i2, int i3, int i4);

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return 16464;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        int i = this.a;
        int i2 = this.d;
        int i3 = this.b;
        if (i == i3) {
            return i2 - this.c;
        }
        long[] jArr = this.f.d;
        return ((jArr[i3] + i2) - jArr[i]) - this.c;
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(Object obj) {
        w6 w6Var;
        Objects.requireNonNull(obj);
        int i = this.a;
        int i2 = this.d;
        int i3 = this.b;
        if (i < i3 || (i == i3 && this.c < i2)) {
            int i4 = this.c;
            while (true) {
                w6Var = this.f;
                if (i >= i3) {
                    break;
                }
                Object obj2 = w6Var.f[i];
                w6Var.t(obj2, i4, w6Var.u(obj2), obj);
                i++;
                i4 = 0;
            }
            w6Var.t(this.a == i3 ? this.e : w6Var.f[i3], i4, i2, obj);
            this.a = i3;
            this.c = i2;
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
        Objects.requireNonNull(obj);
        int i = this.a;
        int i2 = this.b;
        if (i >= i2 && (i != i2 || this.c >= this.d)) {
            return false;
        }
        Object obj2 = this.e;
        int i3 = this.c;
        this.c = i3 + 1;
        a(i3, obj2, obj);
        int i4 = this.c;
        Object obj3 = this.e;
        w6 w6Var = this.f;
        if (i4 == w6Var.u(obj3)) {
            this.c = 0;
            int i5 = this.a + 1;
            this.a = i5;
            Object[] objArr = w6Var.f;
            if (objArr != null && i5 <= i2) {
                this.e = objArr[i5];
            }
        }
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final com.github.catvod.spider.jdollar.util.a1 trySplit() {
        int i = this.a;
        int i2 = this.b;
        if (i < i2) {
            int i3 = i2 - 1;
            int i4 = this.c;
            w6 w6Var = this.f;
            com.github.catvod.spider.jdollar.util.a1 a1VarC = c(i, i3, i4, w6Var.u(w6Var.f[i3]));
            this.a = i2;
            this.c = 0;
            this.e = w6Var.f[i2];
            return a1VarC;
        }
        if (i != i2) {
            return null;
        }
        int i5 = this.c;
        int i6 = (this.d - i5) / 2;
        if (i6 == 0) {
            return null;
        }
        com.github.catvod.spider.jdollar.util.a1 a1VarB = b(this.e, i5, i6);
        this.c += i6;
        return a1VarB;
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

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.u0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) trySplit();
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.x0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.a1, com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.r0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) trySplit();
    }
}
