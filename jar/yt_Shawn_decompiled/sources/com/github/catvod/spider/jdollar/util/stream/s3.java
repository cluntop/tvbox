package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s3 extends x6 implements g2, y1 {
    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final g2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(double d) {
        v3.c();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.y1
    public final g2 build() {
        return this;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        clear();
        t(j);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ g2 l(long j, long j2, IntFunction intFunction) {
        return v3.w(this, j, j2, intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final void m(Object[] objArr, int i) {
        long j = i;
        long jCount = count() + j;
        if (jCount > objArr.length || jCount < j) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.c == 0) {
            System.arraycopy(this.e, 0, objArr, i, this.b);
            return;
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            Object[] objArr2 = this.f[i2];
            System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
            i += this.f[i2].length;
        }
        int i3 = this.b;
        if (i3 > 0) {
            System.arraycopy(this.e, 0, objArr, i, i3);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Object[] q(IntFunction intFunction) {
        long jCount = count();
        if (jCount >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) jCount);
        m(objArr, 0);
        return objArr;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ int s() {
        return 0;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(int i) {
        v3.k();
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.m5
    public final /* synthetic */ void accept(long j) {
        v3.l();
        throw null;
    }
}
