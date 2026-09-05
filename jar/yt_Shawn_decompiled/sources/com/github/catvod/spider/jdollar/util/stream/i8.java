package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class i8 {
    public final Spliterator a;
    public final boolean b;
    public final int c;
    public final long d;
    public final AtomicLong e;

    public i8(Spliterator spliterator, long j, long j2) {
        this.a = spliterator;
        this.b = j2 < 0;
        this.d = j2 >= 0 ? j2 : 0L;
        this.c = 128;
        this.e = new AtomicLong(j2 >= 0 ? j + j2 : j);
    }

    public final long a(long j) {
        long j2;
        boolean z;
        long jMin;
        do {
            j2 = this.e.get();
            z = this.b;
            if (j2 != 0) {
                jMin = Math.min(j2, j);
                if (jMin <= 0) {
                    break;
                }
            } else {
                if (z) {
                    return j;
                }
                return 0L;
            }
        } while (!this.e.compareAndSet(j2, j2 - jMin));
        if (z) {
            return Math.max(j - jMin, 0L);
        }
        long j3 = this.d;
        return j2 > j3 ? Math.max(jMin - (j2 - j3), 0L) : jMin;
    }

    public abstract Spliterator b(Spliterator spliterator);

    public final int characteristics() {
        return this.a.characteristics() & (-16465);
    }

    public final long estimateSize() {
        return this.a.estimateSize();
    }

    public final h8 f() {
        return this.e.get() > 0 ? h8.MAYBE_MORE : this.b ? h8.UNLIMITED : h8.NO_MORE;
    }

    public final Spliterator trySplit() {
        Spliterator spliteratorTrySplit;
        if (this.e.get() == 0 || (spliteratorTrySplit = this.a.trySplit()) == null) {
            return null;
        }
        return b(spliteratorTrySplit);
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.a1 m4trySplit() {
        return (com.github.catvod.spider.jdollar.util.a1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.u0 m6trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.x0 m7trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.r0 m5trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) trySplit();
    }

    public i8(Spliterator spliterator, i8 i8Var) {
        this.a = spliterator;
        this.b = i8Var.b;
        this.e = i8Var.e;
        this.d = i8Var.d;
        this.c = i8Var.c;
    }
}
