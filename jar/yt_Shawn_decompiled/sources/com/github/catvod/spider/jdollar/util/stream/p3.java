package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class p3 extends r3 implements l5 {
    public final long[] h;

    public p3(p3 p3Var, Spliterator spliterator, long j, long j2) {
        super(p3Var, spliterator, j, j2, p3Var.h.length);
        this.h = p3Var.h;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r3
    public final r3 a(Spliterator spliterator, long j, long j2) {
        return new p3(this, spliterator, j, j2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r3, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        long[] jArr = this.h;
        this.f = i + 1;
        jArr[i] = j;
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5
    public final /* synthetic */ void o(Long l) {
        v3.i(this, l);
    }

    public p3(Spliterator spliterator, a aVar, long[] jArr) {
        super(spliterator, aVar, jArr.length);
        this.h = jArr;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Long) obj);
    }
}
