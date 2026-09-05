package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum p2 extends l3 {
    public p2() {
        super("BeforeDoctypeName", 52);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        boolean zQ = aVar.Q();
        q2 q2Var = l3.b0;
        if (zQ) {
            t0Var.l.f();
            t0Var.o(q2Var);
            return;
        }
        char cB = aVar.B();
        if (cB == 0) {
            t0Var.m(this);
            l0 l0Var = t0Var.l;
            l0Var.f();
            l0Var.d.a((char) 65533);
            t0Var.o(q2Var);
            return;
        }
        if (cB != ' ') {
            if (cB == 65535) {
                t0Var.l(this);
                l0 l0Var2 = t0Var.l;
                l0Var2.f();
                l0Var2.i = true;
                t0Var.j();
                t0Var.o(l3.a);
                return;
            }
            if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r') {
                return;
            }
            t0Var.l.f();
            t0Var.l.d.a(cB);
            t0Var.o(q2Var);
        }
    }
}
