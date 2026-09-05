package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum j1 extends l3 {
    public j1() {
        super("ScriptDataEscapedDashDash", 23);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        if (aVar.K()) {
            t0Var.l(this);
            t0Var.o(l3.a);
            return;
        }
        char cB = aVar.B();
        h1 h1Var = l3.v;
        if (cB == 0) {
            t0Var.m(this);
            t0Var.f((char) 65533);
            t0Var.o(h1Var);
        } else {
            if (cB == '-') {
                t0Var.f(cB);
                return;
            }
            if (cB == '<') {
                t0Var.o(l3.y);
            } else if (cB != '>') {
                t0Var.f(cB);
                t0Var.o(h1Var);
            } else {
                t0Var.f(cB);
                t0Var.o(l3.f);
            }
        }
    }
}
