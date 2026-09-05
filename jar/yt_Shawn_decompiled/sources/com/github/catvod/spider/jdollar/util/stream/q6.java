package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class q6 extends w6 implements DoubleConsumer {
    @Override // java.util.function.DoubleConsumer
    public void accept(double d) {
        y();
        double[] dArr = (double[]) this.e;
        int i = this.b;
        this.b = i + 1;
        dArr[i] = d;
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            h((DoubleConsumer) consumer);
        } else {
            if (p8.a) {
                p8.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                throw null;
            }
            com.github.catvod.spider.jdollar.time.chrono.m.e((p6) spliterator(), consumer);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        com.github.catvod.spider.jdollar.util.r0 r0VarSpliterator = spliterator();
        Objects.requireNonNull(r0VarSpliterator);
        return new com.github.catvod.spider.jdollar.util.f1(r0VarSpliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final Object newArray(int i) {
        return new double[i];
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final void t(Object obj, int i, int i2, Object obj2) {
        double[] dArr = (double[]) obj;
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj2;
        while (i < i2) {
            doubleConsumer.accept(dArr[i]);
            i++;
        }
    }

    public final String toString() {
        double[] dArr = (double[]) b();
        if (dArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.c), Arrays.toString(dArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(dArr, 200)));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final int u(Object obj) {
        return ((double[]) obj).length;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6
    public final Object[] x() {
        return new double[8][];
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w6, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.github.catvod.spider.jdollar.util.r0 spliterator() {
        return new p6(this, 0, this.c, 0, this.b);
    }
}
