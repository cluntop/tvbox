package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum n extends b0 {
    public n() {
        super("InFrameset", 19);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) {
        o0 o0Var;
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
        if (!r0Var.e()) {
            if (r0Var.d() && ((n0) r0Var).l().equals("frameset")) {
                if (!bVar.i("frameset")) {
                    bVar.k(this);
                    return false;
                }
                bVar.F();
                if (!bVar.i("frameset")) {
                    bVar.l = b0.u;
                    return true;
                }
            } else {
                if (!r0Var.c()) {
                    bVar.k(this);
                    return false;
                }
                if (!bVar.i("html")) {
                    bVar.k(this);
                }
            }
            return true;
        }
        o0Var = (o0) r0Var;
        String strL = o0Var.l();
        strL.getClass();
        switch (strL) {
            case "frameset":
                bVar.x(o0Var);
                break;
            case "html":
                break;
            case "frame":
                bVar.y(o0Var);
                break;
            case "noframes":
                break;
            default:
                bVar.k(this);
                break;
        }
        return true;
    }
}
