package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum j extends b0 {
    public j() {
        super("InSelectInTable", 16);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        boolean zE = r0Var.e();
        String[] strArr = a0.F;
        if (zE && com.github.catvod.spider.merge.n1.i.d(((o0) r0Var).l(), strArr)) {
            bVar.k(this);
            bVar.G("select");
            bVar.P();
            return bVar.I(r0Var);
        }
        if (r0Var.d()) {
            n0 n0Var = (n0) r0Var;
            if (com.github.catvod.spider.merge.n1.i.d(n0Var.l(), strArr)) {
                bVar.k(this);
                if (!bVar.t(n0Var.l())) {
                    return false;
                }
                bVar.G("select");
                bVar.P();
                return bVar.I(r0Var);
            }
        }
        return b0.p.d(r0Var, bVar);
    }
}
