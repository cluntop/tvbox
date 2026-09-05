package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum u extends b0 {
    public u() {
        super("InHead", 3);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (b0.a(r0Var)) {
            bVar.u((j0) r0Var, false);
            return true;
        }
        int iD = com.github.catvod.spider.merge.u.o.d(r0Var.a);
        if (iD == 0) {
            bVar.k(this);
            return false;
        }
        if (iD != 1) {
            if (iD != 2) {
                if (iD != 3) {
                    bVar.J("head");
                    return bVar.I(r0Var);
                }
                bVar.w((k0) r0Var);
                return true;
            }
            String strL = ((n0) r0Var).l();
            if (strL.equals("head")) {
                bVar.F();
                bVar.l = b0.f;
                return true;
            }
            if (com.github.catvod.spider.merge.n1.i.d(strL, a0.c)) {
                bVar.J("head");
                return bVar.I(r0Var);
            }
            if (!strL.equals("template")) {
                bVar.k(this);
                return false;
            }
            if (!bVar.C(strL)) {
                bVar.k(this);
                return true;
            }
            bVar.n(true);
            if (!bVar.i(strL)) {
                bVar.k(this);
            }
            bVar.G(strL);
            bVar.c();
            bVar.H();
            bVar.P();
            return true;
        }
        o0 o0Var = (o0) r0Var;
        String strL2 = o0Var.l();
        if (strL2.equals("html")) {
            return b0.g.d(r0Var, bVar);
        }
        if (com.github.catvod.spider.merge.n1.i.d(strL2, a0.a)) {
            com.github.catvod.spider.merge.o1.n nVarY = bVar.y(o0Var);
            if (strL2.equals("base") && nVarY.m("href") && !bVar.n) {
                String strA = nVarY.a("href");
                if (strA.length() != 0) {
                    bVar.f = strA;
                    bVar.n = true;
                    com.github.catvod.spider.merge.o1.h hVar = bVar.d;
                    hVar.getClass();
                    hVar.J(strA);
                }
            }
            return true;
        }
        if (strL2.equals("meta")) {
            bVar.y(o0Var);
            return true;
        }
        if (strL2.equals("title")) {
            b0.b(o0Var, bVar, bVar.Q(o0Var).f());
            return true;
        }
        if (com.github.catvod.spider.merge.n1.i.d(strL2, a0.b)) {
            b0.b(o0Var, bVar, bVar.Q(o0Var).f());
            return true;
        }
        if (strL2.equals("noscript")) {
            bVar.x(o0Var);
            bVar.l = b0.e;
            return true;
        }
        if (strL2.equals("script")) {
            bVar.c.o(l3.f);
            bVar.m = bVar.l;
            bVar.l = b0.h;
            bVar.x(o0Var);
            return true;
        }
        if (strL2.equals("head")) {
            bVar.k(this);
            return false;
        }
        if (!strL2.equals("template")) {
            bVar.J("head");
            return bVar.I(r0Var);
        }
        bVar.x(o0Var);
        bVar.q.add(null);
        bVar.u = false;
        k kVar = b0.r;
        bVar.l = kVar;
        bVar.L(kVar);
        return true;
    }
}
