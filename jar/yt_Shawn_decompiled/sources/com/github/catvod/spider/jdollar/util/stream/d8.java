package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d8 extends f8 implements com.github.catvod.spider.jdollar.util.u0, IntConsumer {
    public int f;

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        this.f = i;
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i8
    public final Spliterator b(Spliterator spliterator) {
        return new d8((com.github.catvod.spider.jdollar.util.u0) spliterator, this);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.f(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f8
    public final void g(Object obj) {
        ((IntConsumer) obj).accept(this.f);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f8
    public final h7 h(int i) {
        return new f7(i);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.o(this, consumer);
    }
}
