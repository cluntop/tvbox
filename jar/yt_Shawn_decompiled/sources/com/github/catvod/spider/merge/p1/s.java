package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum s extends b0 {
    public s() {
        super("BeforeHtml", 1);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        if (r0Var.b()) {
            bVar.k(this);
            return false;
        }
        if (r0Var.a()) {
            bVar.w((k0) r0Var);
            return true;
        }
        if (b0.a(r0Var)) {
            bVar.u((j0) r0Var, false);
            return true;
        }
        boolean zE = r0Var.e();
        t tVar = b0.c;
        if (zE) {
            o0 o0Var = (o0) r0Var;
            if (o0Var.l().equals("html")) {
                bVar.x(o0Var);
                bVar.l = tVar;
                return true;
            }
        }
        if (r0Var.d() && com.github.catvod.spider.merge.n1.i.d(((n0) r0Var).l(), a0.e)) {
            bVar.K("html");
            bVar.l = tVar;
            return bVar.I(r0Var);
        }
        if (r0Var.d()) {
            bVar.k(this);
            return false;
        }
        bVar.K("html");
        bVar.l = tVar;
        return bVar.I(r0Var);
    }
}
