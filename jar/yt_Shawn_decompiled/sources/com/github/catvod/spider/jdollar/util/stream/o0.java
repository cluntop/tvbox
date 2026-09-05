package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o0 extends p0 {
    public final Consumer b;

    public o0(Consumer consumer, boolean z) {
        super(z);
        this.b = consumer;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final Object a(a aVar, Spliterator spliterator) {
        aVar.R(spliterator, this);
        return null;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.b.accept(obj);
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
}
