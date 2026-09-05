package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class z2 implements g2 {
    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public g2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final long count() {
        return 0L;
    }

    public final void f(int i, Object obj) {
    }

    public final void h(Object obj) {
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public /* synthetic */ g2 l(long j, long j2, IntFunction intFunction) {
        return v3.w(this, j, j2, intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Object[] q(IntFunction intFunction) {
        return (Object[]) intFunction.apply(0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ int s() {
        return 0;
    }
}
