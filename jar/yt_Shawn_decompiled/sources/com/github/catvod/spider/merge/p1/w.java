package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum w extends b0 {
    public w() {
        super("AfterHead", 5);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (b0.a(r0Var)) {
            bVar.u((j0) r0Var, false);
        } else if (r0Var.a()) {
            bVar.w((k0) r0Var);
        } else if (r0Var.b()) {
            bVar.k(this);
        } else {
            boolean zE = r0Var.e();
            u uVar = b0.d;
            if (zE) {
                o0 o0Var = (o0) r0Var;
                String strL = o0Var.l();
                boolean zEquals = strL.equals("html");
                x xVar = b0.g;
                if (zEquals) {
                    return xVar.d(r0Var, bVar);
                }
                if (strL.equals("body")) {
                    bVar.x(o0Var);
                    bVar.u = false;
                    bVar.l = xVar;
                } else if (strL.equals("frameset")) {
                    bVar.x(o0Var);
                    bVar.l = b0.t;
                } else if (com.github.catvod.spider.merge.n1.i.d(strL, a0.g)) {
                    bVar.k(this);
                    com.github.catvod.spider.merge.o1.n nVar = bVar.o;
                    bVar.e.add(nVar);
                    uVar.d(r0Var, bVar);
                    bVar.O(nVar);
                } else {
                    if (strL.equals("head")) {
                        bVar.k(this);
                        return false;
                    }
                    bVar.K("body");
                    bVar.u = true;
                    bVar.I(r0Var);
                }
            } else if (r0Var.d()) {
                String strL2 = ((n0) r0Var).l();
                if (com.github.catvod.spider.merge.n1.i.d(strL2, a0.d)) {
                    bVar.K("body");
                    bVar.u = true;
                    bVar.I(r0Var);
                } else {
                    if (!strL2.equals("template")) {
                        bVar.k(this);
                        return false;
                    }
                    uVar.d(r0Var, bVar);
                }
            } else {
                bVar.K("body");
                bVar.u = true;
                bVar.I(r0Var);
            }
        }
        return true;
    }
}
