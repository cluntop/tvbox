package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d0 implements n8 {
    public final int a;
    public final Object b;
    public final Predicate c;
    public final Supplier d;

    public d0(boolean z, c7 c7Var, Object obj, Predicate predicate, Supplier supplier) {
        this.a = (z ? 0 : b7.r) | b7.u;
        this.b = obj;
        this.c = predicate;
        this.d = supplier;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final Object a(a aVar, Spliterator spliterator) {
        o8 o8Var = (o8) this.d.get();
        aVar.R(spliterator, o8Var);
        Object obj = o8Var.get();
        return obj != null ? obj : this.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final Object b(a aVar, Spliterator spliterator) {
        return new j0(this, b7.ORDERED.o(aVar.f), aVar, spliterator).invoke();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public final int f() {
        return this.a;
    }
}
