package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum l extends b0 {
    public l() {
        super("AfterBody", 18);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) throws IOException {
        com.github.catvod.spider.merge.o1.n nVarO = bVar.o("html");
        boolean zA = b0.a(r0Var);
        x xVar = b0.g;
        if (zA) {
            if (nVarO != null) {
                bVar.v((j0) r0Var, nVarO);
                return true;
            }
            xVar.d(r0Var, bVar);
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
            return xVar.d(r0Var, bVar);
        }
        if (r0Var.d() && ((n0) r0Var).l().equals("html")) {
            bVar.l = b0.v;
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
