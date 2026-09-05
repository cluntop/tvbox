package com.github.catvod.spider.jdollar.util.stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r5 extends h5 {
    public long b;
    public long c;
    public final /* synthetic */ s5 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r5(s5 s5Var, m5 m5Var) {
        super(m5Var);
        this.d = s5Var;
        this.b = s5Var.m;
        long j = s5Var.n;
        this.c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        long j2 = this.b;
        if (j2 != 0) {
            this.b = j2 - 1;
            return;
        }
        long j3 = this.c;
        if (j3 > 0) {
            this.c = j3 - 1;
            this.a.accept(j);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a.c(v3.x(j, this.d.m, this.c));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        return this.c == 0 || this.a.e();
    }
}
