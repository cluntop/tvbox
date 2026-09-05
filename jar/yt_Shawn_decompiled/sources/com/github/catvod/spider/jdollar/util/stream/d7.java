package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Comparator;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d7 implements Spliterator {
    public final boolean a;
    public final a b;
    public Supplier c;
    public Spliterator d;
    public m5 e;
    public BooleanSupplier f;
    public long g;
    public c h;
    public boolean i;

    public d7(a aVar, Supplier supplier, boolean z) {
        this.b = aVar;
        this.c = supplier;
        this.d = null;
        this.a = z;
    }

    public final boolean a() {
        c cVar = this.h;
        if (cVar == null) {
            if (this.i) {
                return false;
            }
            c();
            d();
            this.g = 0L;
            this.e.c(this.d.getExactSizeIfKnown());
            return b();
        }
        long j = this.g + 1;
        this.g = j;
        boolean z = j < cVar.count();
        if (z) {
            return z;
        }
        this.g = 0L;
        this.h.clear();
        return b();
    }

    public final boolean b() {
        while (this.h.count() == 0) {
            if (this.e.e() || !this.f.getAsBoolean()) {
                if (this.i) {
                    return false;
                }
                this.e.end();
                this.i = true;
            }
        }
        return true;
    }

    public final void c() {
        if (this.d == null) {
            this.d = (Spliterator) this.c.get();
            this.c = null;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        c();
        int i = this.b.f;
        int i2 = i & ((~i) >> 1) & b7.j & b7.f;
        return (i2 & 64) != 0 ? (i2 & (-16449)) | (this.d.characteristics() & 16448) : i2;
    }

    public abstract void d();

    public abstract d7 e(Spliterator spliterator);

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        c();
        return this.d.estimateSize();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Comparator getComparator() {
        if (com.github.catvod.spider.jdollar.time.chrono.m.k(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long getExactSizeIfKnown() {
        c();
        if (b7.SIZED.o(this.b.f)) {
            return this.d.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return com.github.catvod.spider.jdollar.time.chrono.m.k(this, i);
    }

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.d);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public Spliterator trySplit() {
        if (!this.a || this.h != null || this.i) {
            return null;
        }
        c();
        Spliterator spliteratorTrySplit = this.d.trySplit();
        if (spliteratorTrySplit == null) {
            return null;
        }
        return e(spliteratorTrySplit);
    }

    public d7(a aVar, Spliterator spliterator, boolean z) {
        this.b = aVar;
        this.c = null;
        this.d = spliterator;
        this.a = z;
    }
}
