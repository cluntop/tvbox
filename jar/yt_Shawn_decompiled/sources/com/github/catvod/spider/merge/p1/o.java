package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum o extends b0 {
    public o() {
        super("AfterFrameset", 20);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (b0.a(r0Var)) {
            bVar.u((j0) r0Var, false);
            return true;
        }
        if (r0Var.a()) {
            bVar.w((k0) r0Var);
            return true;
        }
        if (r0Var.b()) {
            bVar.k(this);
            return false;
        }
        if (r0Var.e() && ((o0) r0Var).l().equals("html")) {
            return b0.g.d(r0Var, bVar);
        }
        if (r0Var.d() && ((n0) r0Var).l().equals("html")) {
            bVar.l = b0.w;
            return true;
        }
        if (r0Var.e() && ((o0) r0Var).l().equals("noframes")) {
            return b0.d.d(r0Var, bVar);
        }
        if (r0Var.c()) {
            return true;
        }
        bVar.k(this);
        return false;
    }
}
