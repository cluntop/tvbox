package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.Spliterators;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class s2 implements a2 {
    public final double[] a;
    public int b;

    public s2(long j) {
        if (j >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            throw null;
        }
        this.a = new double[(int) j];
        this.b = 0;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2, com.github.catvod.spider.jdollar.util.stream.g2
    public final f2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2
    public final Object b() {
        double[] dArr = this.a;
        int length = dArr.length;
        int i = this.b;
        return length == i ? dArr : Arrays.copyOf(dArr, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final long count() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2
    public final void f(int i, Object obj) {
        int i2 = this.b;
        System.arraycopy(this.a, 0, (double[]) obj, i, i2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ void forEach(Consumer consumer) {
        v3.q(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2
    public final void h(Object obj) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i = 0; i < this.b; i++) {
            doubleConsumer.accept(this.a[i]);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ g2 l(long j, long j2, IntFunction intFunction) {
        return v3.t(this, j, j2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ void m(Object[] objArr, int i) {
        v3.n(this, (Double[]) objArr, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ Object[] q(IntFunction intFunction) {
        return v3.m(this, intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ int s() {
        return 0;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2, com.github.catvod.spider.jdollar.util.stream.g2
    public final com.github.catvod.spider.jdollar.util.a1 spliterator() {
        int i = this.b;
        double[] dArr = this.a;
        Spliterators.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i);
        return new com.github.catvod.spider.jdollar.util.h1(dArr, 0, i, 1040);
    }

    public String toString() {
        double[] dArr = this.a;
        return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(dArr.length - this.b), Arrays.toString(dArr));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* bridge */ /* synthetic */ g2 a(int i) {
        a(i);
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Spliterator spliterator() {
        int i = this.b;
        double[] dArr = this.a;
        Spliterators.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i);
        return new com.github.catvod.spider.jdollar.util.h1(dArr, 0, i, 1040);
    }

    public s2(double[] dArr) {
        this.a = dArr;
        this.b = dArr.length;
    }
}
