package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class m0 extends p0 implements k5 {
    public final IntConsumer b;

    public m0(IntConsumer intConsumer, boolean z) {
        super(z);
        this.b = intConsumer;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final Object a(a aVar, Spliterator spliterator) {
        aVar.R(spliterator, this);
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.p0, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        this.b.accept(i);
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final /* bridge */ /* synthetic */ Object b(a aVar, Spliterator spliterator) {
        g(aVar, spliterator);
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        v3.g(this, num);
    }

    @Override // java.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }
}
