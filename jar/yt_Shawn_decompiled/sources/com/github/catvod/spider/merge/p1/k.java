package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum k extends b0 {
    public k() {
        super("InTemplate", 17);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) throws IOException {
        int iD = com.github.catvod.spider.merge.u.o.d(r0Var.a);
        x xVar = b0.g;
        if (iD != 0) {
            u uVar = b0.d;
            if (iD == 1) {
                String strL = ((o0) r0Var).l();
                if (com.github.catvod.spider.merge.n1.i.d(strL, a0.J)) {
                    uVar.d(r0Var, bVar);
                    return true;
                }
                if (com.github.catvod.spider.merge.n1.i.d(strL, a0.K)) {
                    bVar.H();
                    z zVar = b0.i;
                    bVar.L(zVar);
                    bVar.l = zVar;
                    return bVar.I(r0Var);
                }
                if (strL.equals("col")) {
                    bVar.H();
                    e eVar = b0.l;
                    bVar.L(eVar);
                    bVar.l = eVar;
                    return bVar.I(r0Var);
                }
                if (strL.equals("tr")) {
                    bVar.H();
                    f fVar = b0.m;
                    bVar.L(fVar);
                    bVar.l = fVar;
                    return bVar.I(r0Var);
                }
                if (!strL.equals("td") && !strL.equals("th")) {
                    bVar.H();
                    bVar.L(xVar);
                    bVar.l = xVar;
                    return bVar.I(r0Var);
                }
                bVar.H();
                g gVar = b0.n;
                bVar.L(gVar);
                bVar.l = gVar;
                return bVar.I(r0Var);
            }
            if (iD == 2) {
                if (((n0) r0Var).l().equals("template")) {
                    uVar.d(r0Var, bVar);
                    return true;
                }
                bVar.k(this);
                return false;
            }
            if (iD != 3 && iD != 4) {
                if (iD != 6) {
                    com.github.catvod.spider.merge.s0.a.h("Unexpected state: ".concat(com.github.catvod.spider.merge.b.b.C(r0Var.a)));
                    return false;
                }
                if (bVar.C("template")) {
                    bVar.k(this);
                    bVar.G("template");
                    bVar.c();
                    bVar.H();
                    bVar.P();
                    if (bVar.l != b0.r && bVar.r.size() < 12) {
                        return bVar.I(r0Var);
                    }
                }
                return true;
            }
        }
        xVar.d(r0Var, bVar);
        return true;
    }
}
