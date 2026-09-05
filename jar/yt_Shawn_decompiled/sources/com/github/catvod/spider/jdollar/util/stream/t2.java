package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t2 extends s2 implements v1 {
    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        int i = this.b;
        double[] dArr = this.a;
        if (i >= dArr.length) {
            com.github.catvod.spider.jdollar.nio.file.b.i("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(dArr.length)});
        } else {
            this.b = i + 1;
            dArr[i] = d;
        }
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v1, com.github.catvod.spider.jdollar.util.stream.y1
    public final a2 build() {
        int i = this.b;
        double[] dArr = this.a;
        if (i >= dArr.length) {
            return this;
        }
        com.github.catvod.spider.jdollar.nio.file.b.i("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(dArr.length)});
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        double[] dArr = this.a;
        if (j == dArr.length) {
            this.b = 0;
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.i("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(dArr.length)});
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        int i = this.b;
        double[] dArr = this.a;
        if (i >= dArr.length) {
            return;
        }
        com.github.catvod.spider.jdollar.nio.file.b.i("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(dArr.length)});
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5
    public final /* synthetic */ void r(Double d) {
        v3.d(this, d);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.s2
    public final String toString() {
        double[] dArr = this.a;
        return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(dArr.length - this.b), Arrays.toString(dArr));
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        r((Double) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.y1
    public final /* bridge */ /* synthetic */ g2 build() {
        build();
        return this;
    }
}
