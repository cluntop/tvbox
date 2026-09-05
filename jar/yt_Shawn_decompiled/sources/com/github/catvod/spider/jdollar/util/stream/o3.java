package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o3 extends r3 implements k5 {
    public final int[] h;

    public o3(o3 o3Var, Spliterator spliterator, long j, long j2) {
        super(o3Var, spliterator, j, j2, o3Var.h.length);
        this.h = o3Var.h;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r3
    public final r3 a(Spliterator spliterator, long j, long j2) {
        return new o3(this, spliterator, j, j2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.r3, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        int i2 = this.f;
        if (i2 >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i2));
        }
        int[] iArr = this.h;
        this.f = i2 + 1;
        iArr[i2] = i;
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        v3.g(this, num);
    }

    public o3(Spliterator spliterator, a aVar, int[] iArr) {
        super(spliterator, aVar, iArr.length);
        this.h = iArr;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }
}
