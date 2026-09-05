package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoublePredicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w8 extends f5 {
    public final boolean b;

    public w8(f6 f6Var, m5 m5Var) {
        super(m5Var);
        this.b = true;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        if (this.b) {
            DoublePredicate doublePredicate = null;
            doublePredicate.test(d);
            throw null;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        return !this.b || this.a.e();
    }
}
