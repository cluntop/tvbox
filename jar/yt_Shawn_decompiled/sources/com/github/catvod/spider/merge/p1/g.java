package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum g extends b0 {
    public g() {
        super("InRow", 13);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        boolean zE = r0Var.e();
        z zVar = b0.i;
        f fVar = b0.m;
        if (zE) {
            o0 o0Var = (o0) r0Var;
            String strL = o0Var.l();
            if (com.github.catvod.spider.merge.n1.i.d(strL, a0.u)) {
                bVar.f();
                bVar.x(o0Var);
                bVar.l = b0.o;
                bVar.q.add(null);
                return true;
            }
            if (!com.github.catvod.spider.merge.n1.i.d(strL, a0.C)) {
                return zVar.d(r0Var, bVar);
            }
            if (!bVar.t("tr")) {
                bVar.k(this);
                return false;
            }
            bVar.f();
            bVar.F();
            bVar.l = fVar;
            return bVar.I(r0Var);
        }
        if (!r0Var.d()) {
            return zVar.d(r0Var, bVar);
        }
        String strL2 = ((n0) r0Var).l();
        if (strL2.equals("tr")) {
            if (!bVar.t(strL2)) {
                bVar.k(this);
                return false;
            }
            bVar.f();
            bVar.F();
            bVar.l = fVar;
            return true;
        }
        if (strL2.equals("table")) {
            if (!bVar.t("tr")) {
                bVar.k(this);
                return false;
            }
            bVar.f();
            bVar.F();
            bVar.l = fVar;
            return bVar.I(r0Var);
        }
        if (!com.github.catvod.spider.merge.n1.i.d(strL2, a0.r)) {
            if (!com.github.catvod.spider.merge.n1.i.d(strL2, a0.D)) {
                return zVar.d(r0Var, bVar);
            }
            bVar.k(this);
            return false;
        }
        if (!bVar.t(strL2)) {
            bVar.k(this);
            return false;
        }
        if (!bVar.t("tr")) {
            return false;
        }
        bVar.f();
        bVar.F();
        bVar.l = fVar;
        return bVar.I(r0Var);
    }
}
