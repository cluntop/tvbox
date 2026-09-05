package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c3 extends b3 implements w1 {
    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        int i2 = this.b;
        int[] iArr = this.a;
        if (i2 >= iArr.length) {
            com.github.catvod.spider.jdollar.nio.file.b.i("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(iArr.length)});
        } else {
            this.b = i2 + 1;
            iArr[i2] = i;
        }
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.w1, com.github.catvod.spider.jdollar.util.stream.y1
    public final c2 build() {
        int i = this.b;
        int[] iArr = this.a;
        if (i >= iArr.length) {
            return this;
        }
        com.github.catvod.spider.jdollar.nio.file.b.i("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr.length)});
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        int[] iArr = this.a;
        if (j == iArr.length) {
            this.b = 0;
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.i("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(iArr.length)});
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        v3.g(this, num);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        int i = this.b;
        int[] iArr = this.a;
        if (i >= iArr.length) {
            return;
        }
        com.github.catvod.spider.jdollar.nio.file.b.i("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr.length)});
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.b3
    public final String toString() {
        int[] iArr = this.a;
        return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(iArr.length - this.b), Arrays.toString(iArr));
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(double d) {
        v3.c();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.y1
    public final /* bridge */ /* synthetic */ g2 build() {
        build();
        return this;
    }
}
