package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum q extends b0 {
    public q() {
        super("AfterAfterFrameset", 22);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (r0Var.a()) {
            bVar.w((k0) r0Var);
            return true;
        }
        if (r0Var.b() || b0.a(r0Var) || (r0Var.e() && ((o0) r0Var).l().equals("html"))) {
            return b0.g.d(r0Var, bVar);
        }
        if (r0Var.c()) {
            return true;
        }
        if (r0Var.e() && ((o0) r0Var).l().equals("noframes")) {
            return b0.d.d(r0Var, bVar);
        }
        bVar.k(this);
        return false;
    }
}
