package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class j3 implements Spliterator {
    public g2 a;
    public int b;
    public Spliterator c;
    public Spliterator d;
    public Deque e;

    public j3(g2 g2Var) {
        this.a = g2Var;
    }

    public static g2 a(Deque deque) {
        while (true) {
            ArrayDeque arrayDeque = (ArrayDeque) deque;
            g2 g2Var = (g2) arrayDeque.pollFirst();
            if (g2Var == null) {
                return null;
            }
            if (g2Var.s() != 0) {
                for (int iS = g2Var.s() - 1; iS >= 0; iS--) {
                    arrayDeque.addFirst(g2Var.a(iS));
                }
            } else if (g2Var.count() > 0) {
                return g2Var;
            }
        }
    }

    public final Deque b() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int iS = this.a.s();
        while (true) {
            iS--;
            if (iS < this.b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.a.a(iS));
        }
    }

    public final boolean c() {
        if (this.a == null) {
            return false;
        }
        if (this.d != null) {
            return true;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            this.d = spliterator;
            return true;
        }
        Deque dequeB = b();
        this.e = dequeB;
        g2 g2VarA = a(dequeB);
        if (g2VarA != null) {
            this.d = g2VarA.spliterator();
            return true;
        }
        this.a = null;
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        return 64;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        long jCount = 0;
        if (this.a == null) {
            return 0L;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i = this.b; i < this.a.s(); i++) {
            jCount += this.a.a(i).count();
        }
        return jCount;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return com.github.catvod.spider.jdollar.time.chrono.m.i(this);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return com.github.catvod.spider.jdollar.time.chrono.m.k(this, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        g2 g2Var = this.a;
        if (g2Var == null || this.d != null) {
            return null;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            return spliterator.trySplit();
        }
        int i = this.b;
        int iS = g2Var.s() - 1;
        g2 g2Var2 = this.a;
        int i2 = this.b;
        if (i < iS) {
            this.b = i2 + 1;
            return g2Var2.a(i2).spliterator();
        }
        g2 g2VarA = g2Var2.a(i2);
        this.a = g2VarA;
        int iS2 = g2VarA.s();
        g2 g2Var3 = this.a;
        if (iS2 != 0) {
            this.b = 1;
            return g2Var3.a(0).spliterator();
        }
        Spliterator spliterator2 = g2Var3.spliterator();
        this.c = spliterator2;
        return spliterator2.trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.a1 trySplit() {
        return (com.github.catvod.spider.jdollar.util.a1) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.u0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.u0) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.x0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.x0) trySplit();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.r0 trySplit() {
        return (com.github.catvod.spider.jdollar.util.r0) trySplit();
    }
}
