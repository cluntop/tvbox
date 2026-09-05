package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class j0 extends r0 {
    public static final String e = String.valueOf((char) 0);
    public final com.github.catvod.spider.merge.g1.b d;

    public j0(j0 j0Var) {
        super(5);
        com.github.catvod.spider.merge.g1.b bVar = new com.github.catvod.spider.merge.g1.b(7, false);
        this.d = bVar;
        this.b = j0Var.b;
        this.c = j0Var.c;
        String strJ = j0Var.d.j();
        bVar.i();
        bVar.b = strJ;
    }

    @Override // com.github.catvod.spider.merge.p1.r0
    public final void f() {
        this.b = -1;
        this.c = -1;
        this.d.i();
    }

    public String toString() {
        return this.d.j();
    }

    public j0() {
        super(5);
        this.d = new com.github.catvod.spider.merge.g1.b(7, false);
    }
}
