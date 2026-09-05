package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e7 extends h7 implements DoubleConsumer {
    public final double[] c;

    public e7(int i) {
        this.c = new double[i];
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h7
    public final void a(Object obj, long j) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i = 0; i < j; i++) {
            doubleConsumer.accept(this.c[i]);
        }
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        int i = this.b;
        this.b = i + 1;
        this.c[i] = d;
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }
}
