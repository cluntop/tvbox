package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum p extends b0 {
    public p() {
        super("AfterAfterBody", 21);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (r0Var.a()) {
            bVar.w((k0) r0Var);
            return true;
        }
        boolean zB = r0Var.b();
        x xVar = b0.g;
        if (zB || (r0Var.e() && ((o0) r0Var).l().equals("html"))) {
            return xVar.d(r0Var, bVar);
        }
        if (b0.a(r0Var)) {
            bVar.v((j0) r0Var, bVar.d);
            return true;
        }
        if (r0Var.c()) {
            return true;
        }
        bVar.k(this);
        if (!bVar.C("body")) {
            bVar.e.add(bVar.d.W());
        }
        bVar.l = xVar;
        return bVar.I(r0Var);
    }
}
