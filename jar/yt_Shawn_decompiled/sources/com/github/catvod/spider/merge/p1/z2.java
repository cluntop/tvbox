package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum z2 extends l3 {
    public z2() {
        super("AfterDoctypeSystemKeyword", 61);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r' || cB == ' ') {
            t0Var.o(l3.k0);
            return;
        }
        if (cB == '\"') {
            t0Var.m(this);
            t0Var.o(l3.l0);
            return;
        }
        if (cB == '\'') {
            t0Var.m(this);
            t0Var.o(l3.m0);
            return;
        }
        e1 e1Var = l3.a;
        if (cB == '>') {
            t0Var.m(this);
            t0Var.l.i = true;
            t0Var.j();
            t0Var.o(e1Var);
            return;
        }
        if (cB != 65535) {
            t0Var.m(this);
            t0Var.l.i = true;
            t0Var.j();
        } else {
            t0Var.l(this);
            t0Var.l.i = true;
            t0Var.j();
            t0Var.o(e1Var);
        }
    }
}
