package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n0 extends p0 implements l5 {
    public final LongConsumer b;

    public n0(LongConsumer longConsumer, boolean z) {
        super(z);
        this.b = longConsumer;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final Object a(a aVar, Spliterator spliterator) {
        aVar.R(spliterator, this);
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.p0, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        this.b.accept(j);
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final /* bridge */ /* synthetic */ Object b(a aVar, Spliterator spliterator) {
        g(aVar, spliterator);
        return null;
    }

    @Override // java.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5
    public final /* synthetic */ void o(Long l) {
        v3.i(this, l);
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Long) obj);
    }
}
