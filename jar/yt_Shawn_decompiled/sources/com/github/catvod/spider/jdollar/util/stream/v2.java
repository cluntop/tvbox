package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v2 extends z2 implements a2 {
    @Override // com.github.catvod.spider.jdollar.util.stream.z2, com.github.catvod.spider.jdollar.util.stream.g2
    public final f2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f2
    public final /* bridge */ /* synthetic */ Object b() {
        return v3.g;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ void forEach(Consumer consumer) {
        v3.q(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.z2, com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ g2 l(long j, long j2, IntFunction intFunction) {
        return v3.t(this, j, j2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ void m(Object[] objArr, int i) {
        v3.n(this, (Double[]) objArr, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.a1 spliterator() {
        return Spliterators.d;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return Spliterators.d;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.z2, com.github.catvod.spider.jdollar.util.stream.g2
    public final /* bridge */ /* synthetic */ g2 a(int i) {
        a(i);
        throw null;
    }
}
