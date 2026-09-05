package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class u1 extends b {
    public final com.github.catvod.spider.jdollar.nio.file.d0 j;

    public u1(u1 u1Var, Spliterator spliterator) {
        super(u1Var, spliterator);
        this.j = u1Var.j;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final Object a() {
        a aVar = this.a;
        s1 s1Var = (s1) ((Supplier) this.j.c).get();
        aVar.R(this.b, s1Var);
        boolean z = s1Var.b;
        if (z == ((t1) this.j.b).b) {
            Boolean boolValueOf = Boolean.valueOf(z);
            AtomicReference atomicReference = this.h;
            while (!atomicReference.compareAndSet(null, boolValueOf) && atomicReference.get() == null) {
            }
        }
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final d c(Spliterator spliterator) {
        return new u1(this, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.b
    public final Object h() {
        return Boolean.valueOf(!((t1) this.j.b).b);
    }

    public u1(com.github.catvod.spider.jdollar.nio.file.d0 d0Var, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.j = d0Var;
    }
}
