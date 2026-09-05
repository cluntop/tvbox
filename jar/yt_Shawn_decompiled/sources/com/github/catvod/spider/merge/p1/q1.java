package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum q1 extends l3 {
    public q1() {
        super("ScriptDataDoubleEscapedDash", 29);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        o1 o1Var = l3.C;
        if (cB == 0) {
            t0Var.m(this);
            t0Var.f((char) 65533);
            t0Var.o(o1Var);
        } else if (cB == '-') {
            t0Var.f(cB);
            t0Var.o(l3.E);
        } else if (cB == '<') {
            t0Var.f(cB);
            t0Var.o(l3.F);
        } else if (cB != 65535) {
            t0Var.f(cB);
            t0Var.o(o1Var);
        } else {
            t0Var.l(this);
            t0Var.o(l3.a);
        }
    }
}
