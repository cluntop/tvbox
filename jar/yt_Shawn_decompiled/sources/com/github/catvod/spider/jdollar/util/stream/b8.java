package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b8 {
    public final long a;
    public final long b;
    public Spliterator c;
    public long d;
    public long e;

    public b8(Spliterator spliterator, long j, long j2, long j3, long j4) {
        this.c = spliterator;
        this.a = j;
        this.b = j2;
        this.d = j3;
        this.e = j4;
    }

    public abstract Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4);

    public final int characteristics() {
        return this.c.characteristics();
    }

    public final long estimateSize() {
        long j = this.e;
        long j2 = this.a;
        if (j2 < j) {
            return j - Math.max(j2, this.d);
        }
        return 0L;
    }

    public final Spliterator trySplit() {
        long j = this.e;
        if (this.a >= j || this.d >= j) {
            return null;
        }
        while (true) {
            Spliterator spliteratorTrySplit = this.c.trySplit();
            if (spliteratorTrySplit == null) {
                return null;
            }
            long jEstimateSize = spliteratorTrySplit.estimateSize() + this.d;
            long jMin = Math.min(jEstimateSize, this.b);
            long j2 = this.a;
            if (j2 >= jMin) {
                this.d = jMin;
            } else {
                long j3 = this.b;
                if (jMin < j3) {
                    long j4 = this.d;
                    if (j4 < j2 || jEstimateSize > j3) {
                        this.d = jMin;
                        return a(spliteratorTrySplit, j2, j3, j4, jMin);
                    }
                    this.d = jMin;
                    return spliteratorTrySplit;
                }
                this.c = spliteratorTrySplit;
                this.e = jMin;
            }
        }
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.a1 m0trySplit() {
        return (com.github.catvod.spider.jdollar.util.a1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.u0 m2trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.x0 m3trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.r0 m1trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) trySplit();
    }
}
