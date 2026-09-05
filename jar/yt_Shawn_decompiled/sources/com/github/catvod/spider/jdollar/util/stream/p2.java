package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class p2 extends q2 implements e2 {
    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ void forEach(Consumer consumer) {
        v3.s(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ g2 l(long j, long j2, IntFunction intFunction) {
        return v3.v(this, j, j2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ void m(Object[] objArr, int i) {
        v3.p(this, (Long[]) objArr, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2
    public final Object newArray(int i) {
        return new long[i];
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final com.github.catvod.spider.jdollar.util.a1 spliterator() {
        return new g3(this);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Spliterator spliterator() {
        return new g3(this);
    }
}
