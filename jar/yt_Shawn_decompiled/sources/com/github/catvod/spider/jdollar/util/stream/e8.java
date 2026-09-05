package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e8 extends f8 implements com.github.catvod.spider.jdollar.util.x0, LongConsumer {
    public long f;

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.f = j;
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i8
    public final Spliterator b(Spliterator spliterator) {
        return new e8((com.github.catvod.spider.jdollar.util.x0) spliterator, this);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.g(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f8
    public final void g(Object obj) {
        ((LongConsumer) obj).accept(this.f);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f8
    public final h7 h(int i) {
        return new g7(i);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.p(this, consumer);
    }
}
