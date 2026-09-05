package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class a implements BaseStream {
    public final a a;
    public final a b;
    public final int c;
    public final a d;
    public int e;
    public int f;
    public Spliterator g;
    public Supplier h;
    public boolean i;
    public final boolean j;
    public Runnable k;
    public boolean l;

    public a(a aVar, int i) {
        if (aVar.i) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        aVar.i = true;
        aVar.d = this;
        this.b = aVar;
        this.c = b7.h & i;
        this.f = b7.h(i, aVar.f);
        a aVar2 = aVar.a;
        this.a = aVar2;
        if (M()) {
            aVar2.j = true;
        }
        this.e = aVar.e + 1;
    }

    public final Object C(n8 n8Var) {
        if (this.i) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.i = true;
        return this.a.l ? n8Var.b(this, O(n8Var.f())) : n8Var.a(this, O(n8Var.f()));
    }

    public final g2 D(IntFunction intFunction) {
        if (this.i) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.i = true;
        if (!this.a.l || this.b == null || !M()) {
            return p(O(0), true, intFunction);
        }
        this.e = 0;
        a aVar = this.b;
        return K(aVar, aVar.O(0), intFunction);
    }

    public abstract g2 E(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction);

    public final long F(Spliterator spliterator) {
        if (b7.SIZED.o(this.f)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    public abstract boolean G(Spliterator spliterator, m5 m5Var);

    public abstract c7 H();

    public abstract Spliterator I(Supplier supplier);

    public abstract y1 J(long j, IntFunction intFunction);

    public g2 K(a aVar, Spliterator spliterator, IntFunction intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    public Spliterator L(a aVar, Spliterator spliterator) {
        return K(aVar, spliterator, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(15)).spliterator();
    }

    public abstract boolean M();

    public abstract m5 N(int i, m5 m5Var);

    public final Spliterator O(int i) {
        int i2;
        int i3;
        a aVar = this.a;
        Spliterator spliteratorL = aVar.g;
        if (spliteratorL != null) {
            aVar.g = null;
        } else {
            Supplier supplier = aVar.h;
            if (supplier == null) {
                throw new IllegalStateException("source already consumed or closed");
            }
            spliteratorL = (Spliterator) supplier.get();
            this.a.h = null;
        }
        a aVar2 = this.a;
        if (aVar2.l && aVar2.j) {
            a aVar3 = aVar2.d;
            int i4 = 1;
            while (aVar2 != this) {
                int i5 = aVar3.c;
                if (aVar3.M()) {
                    if (b7.SHORT_CIRCUIT.o(i5)) {
                        i5 &= ~b7.u;
                    }
                    spliteratorL = aVar3.L(aVar2, spliteratorL);
                    if (spliteratorL.hasCharacteristics(64)) {
                        i2 = (~b7.t) & i5;
                        i3 = b7.s;
                    } else {
                        i2 = (~b7.s) & i5;
                        i3 = b7.t;
                    }
                    i5 = i2 | i3;
                    i4 = 0;
                }
                int i6 = i4 + 1;
                aVar3.e = i4;
                aVar3.f = b7.h(i5, aVar2.f);
                a aVar4 = aVar3;
                aVar3 = aVar3.d;
                aVar2 = aVar4;
                i4 = i6;
            }
        }
        if (i != 0) {
            this.f = b7.h(i, this.f);
        }
        return spliteratorL;
    }

    public final Spliterator P() {
        a aVar = this.a;
        if (this != aVar) {
            throw new IllegalStateException();
        }
        if (this.i) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.i = true;
        Spliterator spliterator = aVar.g;
        if (spliterator != null) {
            aVar.g = null;
            return spliterator;
        }
        Supplier supplier = aVar.h;
        if (supplier == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        Spliterator spliterator2 = (Spliterator) supplier.get();
        this.a.h = null;
        return spliterator2;
    }

    public abstract Spliterator Q(a aVar, Supplier supplier, boolean z);

    public final m5 R(Spliterator spliterator, m5 m5Var) {
        k(spliterator, S((m5) Objects.requireNonNull(m5Var)));
        return m5Var;
    }

    public final m5 S(m5 m5Var) {
        Objects.requireNonNull(m5Var);
        for (a aVar = this; aVar.e > 0; aVar = aVar.b) {
            m5Var = aVar.N(aVar.b.f, m5Var);
        }
        return m5Var;
    }

    public final Spliterator T(Spliterator spliterator) {
        return this.e == 0 ? spliterator : Q(this, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(7, spliterator), this.a.l);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.i = true;
        this.h = null;
        this.g = null;
        a aVar = this.a;
        Runnable runnable = aVar.k;
        if (runnable != null) {
            aVar.k = null;
            runnable.run();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final boolean isParallel() {
        return this.a.l;
    }

    public final void k(Spliterator spliterator, m5 m5Var) {
        Objects.requireNonNull(m5Var);
        if (b7.SHORT_CIRCUIT.o(this.f)) {
            n(spliterator, m5Var);
            return;
        }
        m5Var.c(spliterator.getExactSizeIfKnown());
        spliterator.forEachRemaining(m5Var);
        m5Var.end();
    }

    public final boolean n(Spliterator spliterator, m5 m5Var) {
        a aVar = this;
        while (aVar.e > 0) {
            aVar = aVar.b;
        }
        m5Var.c(spliterator.getExactSizeIfKnown());
        boolean zG = aVar.G(spliterator, m5Var);
        m5Var.end();
        return zG;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final BaseStream onClose(Runnable runnable) {
        if (this.i) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        Objects.requireNonNull(runnable);
        a aVar = this.a;
        Runnable runnable2 = aVar.k;
        if (runnable2 != null) {
            runnable = new l8(runnable2, runnable);
        }
        aVar.k = runnable;
        return this;
    }

    public final g2 p(Spliterator spliterator, boolean z, IntFunction intFunction) {
        if (this.a.l) {
            return E(this, spliterator, z, intFunction);
        }
        y1 y1VarJ = J(F(spliterator), intFunction);
        R(spliterator, y1VarJ);
        return y1VarJ.build();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final BaseStream parallel() {
        this.a.l = true;
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final BaseStream sequential() {
        this.a.l = false;
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public Spliterator spliterator() {
        if (this.i) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.i = true;
        a aVar = this.a;
        if (this != aVar) {
            return Q(this, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(6, this), aVar.l);
        }
        Spliterator spliterator = aVar.g;
        if (spliterator != null) {
            aVar.g = null;
            return spliterator;
        }
        Supplier supplier = aVar.h;
        if (supplier == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        aVar.h = null;
        return I(supplier);
    }

    public a(Spliterator spliterator, int i, boolean z) {
        this.b = null;
        this.g = spliterator;
        this.a = this;
        int i2 = b7.g & i;
        this.c = i2;
        this.f = (~(i2 << 1)) & b7.l;
        this.e = 0;
        this.l = z;
    }

    public a(Supplier supplier, int i, boolean z) {
        this.b = null;
        this.h = supplier;
        this.a = this;
        int i2 = b7.g & i;
        this.c = i2;
        this.f = (~(i2 << 1)) & b7.l;
        this.e = 0;
        this.l = z;
    }
}
