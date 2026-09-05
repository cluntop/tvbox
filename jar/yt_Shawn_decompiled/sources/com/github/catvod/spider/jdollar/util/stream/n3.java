package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n3 extends r3 implements j5 {
    public final double[] h;

    public n3(n3 n3Var, Spliterator spliterator, long j, long j2) {
        super(n3Var, spliterator, j, j2, n3Var.h.length);
        this.h = n3Var.h;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r3
    public final r3 a(Spliterator spliterator, long j, long j2) {
        return new n3(this, spliterator, j, j2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r3, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        double[] dArr = this.h;
        this.f = i + 1;
        dArr[i] = d;
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5
    public final /* synthetic */ void r(Double d) {
        v3.d(this, d);
    }

    public n3(Spliterator spliterator, a aVar, double[] dArr) {
        super(spliterator, aVar, dArr.length);
        this.h = dArr;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        r((Double) obj);
    }
}
