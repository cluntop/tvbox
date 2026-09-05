package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoublePredicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class x8 extends f5 implements z8 {
    public x8(f6 f6Var, m5 m5Var, boolean z) {
        super(m5Var);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        DoublePredicate doublePredicate = null;
        doublePredicate.test(d);
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.z8
    public final long i() {
        return 0L;
    }
}
