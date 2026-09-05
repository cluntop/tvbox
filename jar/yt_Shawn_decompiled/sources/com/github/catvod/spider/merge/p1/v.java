package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum v extends b0 {
    public v() {
        super("InHeadNoscript", 4);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (r0Var.b()) {
            bVar.k(this);
            return true;
        }
        if (r0Var.e() && ((o0) r0Var).l().equals("html")) {
            return b0.g.d(r0Var, bVar);
        }
        boolean zD = r0Var.d();
        u uVar = b0.d;
        if (zD && ((n0) r0Var).l().equals("noscript")) {
            bVar.F();
            bVar.l = uVar;
            return true;
        }
        if (b0.a(r0Var) || r0Var.a() || (r0Var.e() && com.github.catvod.spider.merge.n1.i.d(((o0) r0Var).l(), a0.f))) {
            return uVar.d(r0Var, bVar);
        }
        if (r0Var.d() && ((n0) r0Var).l().equals("br")) {
            bVar.k(this);
            j0 j0Var = new j0();
            String string = r0Var.toString();
            com.github.catvod.spider.merge.g1.b bVar2 = j0Var.d;
            bVar2.i();
            bVar2.b = string;
            bVar.u(j0Var, false);
            return true;
        }
        if ((r0Var.e() && com.github.catvod.spider.merge.n1.i.d(((o0) r0Var).l(), a0.H)) || r0Var.d()) {
            bVar.k(this);
            return false;
        }
        bVar.k(this);
        j0 j0Var2 = new j0();
        String string2 = r0Var.toString();
        com.github.catvod.spider.merge.g1.b bVar3 = j0Var2.d;
        bVar3.i();
        bVar3.b = string2;
        bVar.u(j0Var2, false);
        return true;
    }
}
