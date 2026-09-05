package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum d extends b0 {
    public d() {
        super("InCaption", 10);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        boolean zD = r0Var.d();
        z zVar = b0.i;
        if (zD && ((n0) r0Var).l().equals("caption")) {
            if (!bVar.t("caption")) {
                bVar.k(this);
                return false;
            }
            bVar.n(false);
            if (!bVar.i("caption")) {
                bVar.k(this);
            }
            bVar.G("caption");
            bVar.c();
            bVar.l = zVar;
            return true;
        }
        if ((!r0Var.e() || !com.github.catvod.spider.merge.n1.i.d(((o0) r0Var).l(), a0.x)) && (!r0Var.d() || !((n0) r0Var).l().equals("table"))) {
            if (!r0Var.d() || !com.github.catvod.spider.merge.n1.i.d(((n0) r0Var).l(), a0.I)) {
                return b0.g.d(r0Var, bVar);
            }
            bVar.k(this);
            return false;
        }
        if (!bVar.t("caption")) {
            bVar.k(this);
            return false;
        }
        bVar.n(false);
        if (!bVar.i("caption")) {
            bVar.k(this);
        }
        bVar.G("caption");
        bVar.c();
        bVar.l = zVar;
        zVar.d(r0Var, bVar);
        return true;
    }
}
