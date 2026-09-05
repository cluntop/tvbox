package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.LongPredicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class u8 extends h5 {
    public final boolean b;

    public u8(h6 h6Var, m5 m5Var) {
        super(m5Var);
        this.b = true;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        if (this.b) {
            LongPredicate longPredicate = null;
            longPredicate.test(j);
            throw null;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        return !this.b || this.a.e();
    }
}
