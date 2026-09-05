package com.github.catvod.spider.jdollar.util;

import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class x implements DoubleConsumer {
    public double a;
    public double b;
    private long count;
    private double sum;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    public final void a(x xVar) {
        this.count += xVar.count;
        this.b += xVar.b;
        b(xVar.sum);
        b(xVar.a);
        this.min = Math.min(this.min, xVar.min);
        this.max = Math.max(this.max, xVar.max);
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.count++;
        this.b += d;
        b(d);
        this.min = Math.min(this.min, d);
        this.max = Math.max(this.max, d);
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    public final void b(double d) {
        double d2 = d - this.a;
        double d3 = this.sum;
        double d4 = d3 + d2;
        this.a = (d4 - d3) - d2;
        this.sum = d4;
    }

    public final String toString() {
        double d;
        String simpleName = x.class.getSimpleName();
        Long lValueOf = Long.valueOf(this.count);
        double d2 = this.sum + this.a;
        if (Double.isNaN(d2) && Double.isInfinite(this.b)) {
            d2 = this.b;
        }
        Double dValueOf = Double.valueOf(d2);
        Double dValueOf2 = Double.valueOf(this.min);
        if (this.count > 0) {
            double d3 = this.sum + this.a;
            if (Double.isNaN(d3) && Double.isInfinite(this.b)) {
                d3 = this.b;
            }
            d = d3 / this.count;
        } else {
            d = 0.0d;
        }
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", simpleName, lValueOf, dValueOf, dValueOf2, Double.valueOf(d), Double.valueOf(this.max));
    }
}
