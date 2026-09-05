package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum f2 extends l3 {
    public f2() {
        super("MarkupDeclarationOpen", 43);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        if (aVar.M("--")) {
            t0Var.m.f();
            t0Var.o(l3.T);
            return;
        }
        if (aVar.N("DOCTYPE")) {
            t0Var.o(l3.Z);
            return;
        }
        if (aVar.M("[CDATA[")) {
            t0Var.e();
            t0Var.o(l3.q0);
            return;
        }
        if (t0Var.g != 2 || !aVar.Q()) {
            t0Var.m(this);
            t0Var.m.f();
            t0Var.o(l3.Q);
        } else {
            q0 q0Var = t0Var.n;
            q0Var.f();
            q0Var.k = true;
            t0Var.j = q0Var;
            t0Var.o(l3.j);
        }
    }
}
