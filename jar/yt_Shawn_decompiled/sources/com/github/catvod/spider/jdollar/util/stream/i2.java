package com.github.catvod.spider.jdollar.util.stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class i2 implements g2 {
    public final g2 a;
    public final g2 b;
    public final long c;

    public i2(g2 g2Var, g2 g2Var2) {
        this.a = g2Var;
        this.b = g2Var2;
        this.c = g2Var2.count() + g2Var.count();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final g2 a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            return this.b;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final long count() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final int s() {
        return 2;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public /* bridge */ /* synthetic */ f2 a(int i) {
        return (f2) a(i);
    }
}
