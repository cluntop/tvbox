package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l3 extends k3 implements x1 {
    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        int i = this.b;
        long[] jArr = this.a;
        if (i >= jArr.length) {
            com.github.catvod.spider.jdollar.nio.file.b.i("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(jArr.length)});
        } else {
            this.b = i + 1;
            jArr[i] = j;
        }
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.x1, com.github.catvod.spider.jdollar.util.stream.y1
    public final e2 build() {
        int i = this.b;
        long[] jArr = this.a;
        if (i >= jArr.length) {
            return this;
        }
        com.github.catvod.spider.jdollar.nio.file.b.i("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(jArr.length)});
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        long[] jArr = this.a;
        if (j == jArr.length) {
            this.b = 0;
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.i("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j), Integer.valueOf(jArr.length)});
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        int i = this.b;
        long[] jArr = this.a;
        if (i >= jArr.length) {
            return;
        }
        com.github.catvod.spider.jdollar.nio.file.b.i("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(jArr.length)});
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5
    public final /* synthetic */ void o(Long l) {
        v3.i(this, l);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k3
    public final String toString() {
        long[] jArr = this.a;
        return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(jArr.length - this.b), Arrays.toString(jArr));
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Long) obj);
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
