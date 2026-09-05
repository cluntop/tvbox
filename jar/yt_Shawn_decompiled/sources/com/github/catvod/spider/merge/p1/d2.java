package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum d2 extends l3 {
    public d2() {
        super("SelfClosingStartTag", 41);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        e1 e1Var = l3.a;
        if (cB == '>') {
            t0Var.j.f = true;
            t0Var.k();
            t0Var.o(e1Var);
        } else if (cB == 65535) {
            t0Var.l(this);
            t0Var.o(e1Var);
        } else {
            aVar.W();
            t0Var.m(this);
            t0Var.o(l3.H);
        }
    }
}
