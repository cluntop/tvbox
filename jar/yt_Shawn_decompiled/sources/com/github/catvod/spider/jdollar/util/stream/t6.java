package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t6 extends v6 implements com.github.catvod.spider.jdollar.util.x0 {
    public final /* synthetic */ u6 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t6(u6 u6Var, int i, int i2, int i3, int i4) {
        super(u6Var, i, i2, i3, i4);
        this.g = u6Var;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v6
    public final void a(int i, Object obj, Object obj2) {
        ((LongConsumer) obj2).accept(((long[]) obj)[i]);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v6
    public final com.github.catvod.spider.jdollar.util.a1 b(Object obj, int i, int i2) {
        long[] jArr = (long[]) obj;
        int i3 = i2 + i;
        Spliterators.a(((long[]) Objects.requireNonNull(jArr)).length, i, i3);
        return new com.github.catvod.spider.jdollar.util.o1(jArr, i, i3, 1040);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v6
    public final com.github.catvod.spider.jdollar.util.a1 c(int i, int i2, int i3, int i4) {
        return new t6(this.g, i, i2, i3, i4);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.g(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.p(this, consumer);
    }
}
