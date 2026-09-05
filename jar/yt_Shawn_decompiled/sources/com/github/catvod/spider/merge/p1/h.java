package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum h extends b0 {
    public h() {
        super("InCell", 14);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        boolean zD = r0Var.d();
        x xVar = b0.g;
        if (!zD) {
            if (!r0Var.e() || !com.github.catvod.spider.merge.n1.i.d(((o0) r0Var).l(), a0.x)) {
                return xVar.d(r0Var, bVar);
            }
            if (!bVar.t("td") && !bVar.t("th")) {
                bVar.k(this);
                return false;
            }
            if (bVar.t("td")) {
                bVar.J("td");
            } else {
                bVar.J("th");
            }
            return bVar.I(r0Var);
        }
        String strL = ((n0) r0Var).l();
        if (!com.github.catvod.spider.merge.n1.i.d(strL, a0.u)) {
            if (com.github.catvod.spider.merge.n1.i.d(strL, a0.v)) {
                bVar.k(this);
                return false;
            }
            if (!com.github.catvod.spider.merge.n1.i.d(strL, a0.w)) {
                return xVar.d(r0Var, bVar);
            }
            if (!bVar.t(strL)) {
                bVar.k(this);
                return false;
            }
            if (bVar.t("td")) {
                bVar.J("td");
            } else {
                bVar.J("th");
            }
            return bVar.I(r0Var);
        }
        boolean zT = bVar.t(strL);
        g gVar = b0.n;
        if (!zT) {
            bVar.k(this);
            bVar.l = gVar;
            return false;
        }
        bVar.n(false);
        if (!bVar.i(strL)) {
            bVar.k(this);
        }
        bVar.G(strL);
        bVar.c();
        bVar.l = gVar;
        return true;
    }
}
