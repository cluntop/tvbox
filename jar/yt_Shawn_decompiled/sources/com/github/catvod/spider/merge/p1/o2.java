package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum o2 extends l3 {
    public o2() {
        super("Doctype", 51);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        p2 p2Var = l3.a0;
        if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r' || cB == ' ') {
            t0Var.o(p2Var);
            return;
        }
        if (cB != '>') {
            if (cB != 65535) {
                t0Var.m(this);
                t0Var.o(p2Var);
                return;
            }
            t0Var.l(this);
        }
        t0Var.m(this);
        l0 l0Var = t0Var.l;
        l0Var.f();
        l0Var.i = true;
        t0Var.j();
        t0Var.o(l3.a);
    }
}
