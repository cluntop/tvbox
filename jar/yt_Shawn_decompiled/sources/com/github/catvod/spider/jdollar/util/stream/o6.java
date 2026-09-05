package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.DesugarArrays;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o6 implements Spliterator {
    public int a;
    public final int b;
    public int c;
    public final int d;
    public Object[] e;
    public final /* synthetic */ x6 f;

    public o6(x6 x6Var, int i, int i2, int i3, int i4) {
        this.f = x6Var;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        Object[][] objArr = x6Var.f;
        this.e = objArr == null ? x6Var.e : objArr[i];
    }

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

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        x6 x6Var;
        Objects.requireNonNull(consumer);
        int i = this.a;
        int i2 = this.d;
        int i3 = this.b;
        if (i < i3 || (i == i3 && this.c < i2)) {
            int i4 = this.c;
            while (true) {
                x6Var = this.f;
                if (i >= i3) {
                    break;
                }
                Object[] objArr = x6Var.f[i];
                while (i4 < objArr.length) {
                    consumer.accept(objArr[i4]);
                    i4++;
                }
                i++;
                i4 = 0;
            }
            Object[] objArr2 = this.a == i3 ? this.e : x6Var.f[i3];
            while (i4 < i2) {
                consumer.accept(objArr2[i4]);
                i4++;
            }
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

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int i = this.a;
        int i2 = this.b;
        if (i >= i2 && (i != i2 || this.c >= this.d)) {
            return false;
        }
        Object[] objArr = this.e;
        int i3 = this.c;
        this.c = i3 + 1;
        consumer.accept(objArr[i3]);
        if (this.c == this.e.length) {
            this.c = 0;
            int i4 = this.a + 1;
            this.a = i4;
            Object[][] objArr2 = this.f.f;
            if (objArr2 != null && i4 <= i2) {
                this.e = objArr2[i4];
            }
        }
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        int i = this.a;
        int i2 = this.b;
        if (i < i2) {
            int i3 = i2 - 1;
            int i4 = this.c;
            x6 x6Var = this.f;
            o6 o6Var = new o6(x6Var, i, i3, i4, x6Var.f[i3].length);
            this.a = i2;
            this.c = 0;
            this.e = x6Var.f[i2];
            return o6Var;
        }
        if (i != i2) {
            return null;
        }
        int i5 = this.c;
        int i6 = (this.d - i5) / 2;
        if (i6 == 0) {
            return null;
        }
        com.github.catvod.spider.jdollar.util.g1 g1VarA = DesugarArrays.a(this.e, i5, i5 + i6);
        this.c += i6;
        return g1VarA;
    }
}
