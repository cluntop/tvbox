package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum z extends b0 {
    public z() {
        super("InTable", 8);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (r0Var.a == 5 && com.github.catvod.spider.merge.n1.i.d(bVar.h().d.c, a0.z)) {
            bVar.s.clear();
            bVar.m = bVar.l;
            bVar.l = b0.j;
            return bVar.I(r0Var);
        }
        if (r0Var.a()) {
            bVar.w((k0) r0Var);
            return true;
        }
        if (r0Var.b()) {
            bVar.k(this);
            return false;
        }
        boolean zE = r0Var.e();
        u uVar = b0.d;
        if (!zE) {
            if (!r0Var.d()) {
                if (!r0Var.c()) {
                    e(r0Var, bVar);
                    return true;
                }
                if (bVar.i("html")) {
                    bVar.k(this);
                }
                return true;
            }
            String strL = ((n0) r0Var).l();
            if (strL.equals("table")) {
                if (!bVar.t(strL)) {
                    bVar.k(this);
                    return false;
                }
                bVar.G("table");
                bVar.P();
                return true;
            }
            if (com.github.catvod.spider.merge.n1.i.d(strL, a0.y)) {
                bVar.k(this);
                return false;
            }
            if (strL.equals("template")) {
                uVar.d(r0Var, bVar);
                return true;
            }
            e(r0Var, bVar);
            return true;
        }
        o0 o0Var = (o0) r0Var;
        String strL2 = o0Var.l();
        if (strL2.equals("caption")) {
            bVar.e();
            bVar.q.add(null);
            bVar.x(o0Var);
            bVar.l = b0.k;
            return true;
        }
        if (strL2.equals("colgroup")) {
            bVar.e();
            bVar.x(o0Var);
            bVar.l = b0.l;
            return true;
        }
        if (strL2.equals("col")) {
            bVar.e();
            bVar.K("colgroup");
            return bVar.I(r0Var);
        }
        if (com.github.catvod.spider.merge.n1.i.d(strL2, a0.r)) {
            bVar.e();
            bVar.x(o0Var);
            bVar.l = b0.m;
            return true;
        }
        if (com.github.catvod.spider.merge.n1.i.d(strL2, a0.s)) {
            bVar.e();
            bVar.K("tbody");
            return bVar.I(r0Var);
        }
        if (strL2.equals("table")) {
            bVar.k(this);
            if (bVar.t(strL2)) {
                bVar.G(strL2);
                if (bVar.P()) {
                    return bVar.I(r0Var);
                }
                bVar.x(o0Var);
                return true;
            }
        } else {
            if (com.github.catvod.spider.merge.n1.i.d(strL2, a0.t)) {
                return uVar.d(r0Var, bVar);
            }
            if (strL2.equals("input")) {
                com.github.catvod.spider.merge.o1.c cVar = o0Var.g;
                if (cVar == null || !cVar.e("type").equalsIgnoreCase("hidden")) {
                    e(r0Var, bVar);
                    return true;
                }
                bVar.y(o0Var);
                return true;
            }
            if (!strL2.equals("form")) {
                e(r0Var, bVar);
                return true;
            }
            bVar.k(this);
            if (bVar.p == null && !bVar.C("template")) {
                bVar.A(o0Var, false, false);
                return true;
            }
        }
        return false;
    }

    public final void e(r0 r0Var, b bVar) throws IOException {
        bVar.k(this);
        bVar.v = true;
        b0.g.d(r0Var, bVar);
        bVar.v = false;
    }
}
