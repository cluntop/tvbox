package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum f extends b0 {
    public f() {
        super("InTableBody", 12);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        int iD = com.github.catvod.spider.merge.u.o.d(r0Var.a);
        z zVar = b0.i;
        if (iD == 1) {
            o0 o0Var = (o0) r0Var;
            String strL = o0Var.l();
            if (strL.equals("tr")) {
                bVar.d("tbody", "tfoot", "thead", "template");
                bVar.x(o0Var);
                bVar.l = b0.n;
                return true;
            }
            if (!com.github.catvod.spider.merge.n1.i.d(strL, a0.u)) {
                return com.github.catvod.spider.merge.n1.i.d(strL, a0.A) ? e(r0Var, bVar) : zVar.d(r0Var, bVar);
            }
            bVar.k(this);
            bVar.K("tr");
            return bVar.I(o0Var);
        }
        if (iD != 2) {
            return zVar.d(r0Var, bVar);
        }
        String strL2 = ((n0) r0Var).l();
        if (!com.github.catvod.spider.merge.n1.i.d(strL2, a0.G)) {
            if (strL2.equals("table")) {
                return e(r0Var, bVar);
            }
            if (!com.github.catvod.spider.merge.n1.i.d(strL2, a0.B)) {
                return zVar.d(r0Var, bVar);
            }
            bVar.k(this);
            return false;
        }
        if (!bVar.t(strL2)) {
            bVar.k(this);
            return false;
        }
        bVar.d("tbody", "tfoot", "thead", "template");
        bVar.F();
        bVar.l = zVar;
        return true;
    }

    public final boolean e(r0 r0Var, b bVar) {
        if (!bVar.t("tbody") && !bVar.t("thead") && !bVar.q("tfoot")) {
            bVar.k(this);
            return false;
        }
        bVar.d("tbody", "tfoot", "thead", "template");
        bVar.J(bVar.h().d.c);
        return bVar.I(r0Var);
    }
}
