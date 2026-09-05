package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum d3 extends l3 {
    public d3() {
        super("AfterDoctypeSystemIdentifier", 65);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r' || cB == ' ') {
            return;
        }
        e1 e1Var = l3.a;
        if (cB == '>') {
            t0Var.j();
            t0Var.o(e1Var);
            return;
        }
        e3 e3Var = l3.o0;
        if (cB == '[') {
            if (t0Var.g == 2) {
                t0Var.l.getClass();
                t0Var.o(l3.p0);
                return;
            } else {
                t0Var.m(this);
                t0Var.o(e3Var);
                return;
            }
        }
        if (cB != 65535) {
            t0Var.m(this);
            t0Var.o(e3Var);
        } else {
            t0Var.l(this);
            t0Var.l.i = true;
            t0Var.j();
            t0Var.o(e1Var);
        }
    }
}
