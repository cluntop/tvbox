package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k0 extends r0 {
    public final com.github.catvod.spider.merge.g1.b d;

    public k0() {
        super(4);
        this.d = new com.github.catvod.spider.merge.g1.b(7, false);
    }

    @Override // com.github.catvod.spider.merge.p1.r0
    public final void f() {
        this.b = -1;
        this.c = -1;
        this.d.i();
    }

    public final void g(char c) {
        this.d.a(c);
    }

    public final String toString() {
        return "<!--" + this.d.j() + "-->";
    }
}
