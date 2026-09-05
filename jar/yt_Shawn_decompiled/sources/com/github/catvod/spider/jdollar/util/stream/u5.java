package com.github.catvod.spider.jdollar.util.stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class u5 extends f5 {
    public long b;
    public long c;
    public final /* synthetic */ v5 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u5(v5 v5Var, m5 m5Var) {
        super(m5Var);
        this.d = v5Var;
        this.b = v5Var.m;
        long j = v5Var.n;
        this.c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        long j = this.b;
        if (j != 0) {
            this.b = j - 1;
            return;
        }
        long j2 = this.c;
        if (j2 > 0) {
            this.c = j2 - 1;
            this.a.accept(d);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a.c(v3.x(j, this.d.m, this.c));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        return this.c == 0 || this.a.e();
    }
}
