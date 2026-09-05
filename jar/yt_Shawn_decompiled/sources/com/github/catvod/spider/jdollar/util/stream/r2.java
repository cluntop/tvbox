package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r2 extends i2 {
    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final void forEach(Consumer consumer) {
        this.a.forEach(consumer);
        this.b.forEach(consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final g2 l(long j, long j2, IntFunction intFunction) {
        if (j == 0 && j2 == this.c) {
            return this;
        }
        long jCount = this.a.count();
        if (j >= jCount) {
            return this.b.l(j - jCount, j2 - jCount, intFunction);
        }
        g2 g2Var = this.a;
        if (j2 <= jCount) {
            return g2Var.l(j, j2, intFunction);
        }
        return v3.F(c7.REFERENCE, g2Var.l(j, jCount, intFunction), this.b.l(0L, j2 - jCount, intFunction));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final void m(Object[] objArr, int i) {
        Objects.requireNonNull(objArr);
        g2 g2Var = this.a;
        g2Var.m(objArr, i);
        this.b.m(objArr, i + ((int) g2Var.count()));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Object[] q(IntFunction intFunction) {
        long j = this.c;
        if (j >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) j);
        m(objArr, 0);
        return objArr;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Spliterator spliterator() {
        return new i3(this);
    }

    public final String toString() {
        long j = this.c;
        return j < 32 ? String.format("ConcNode[%s.%s]", this.a, this.b) : String.format("ConcNode[size=%d]", Long.valueOf(j));
    }
}
