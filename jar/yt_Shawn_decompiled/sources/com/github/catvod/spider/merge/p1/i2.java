package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum i2 extends l3 {
    public i2() {
        super("CommentStartDash", 46);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        j2 j2Var = l3.V;
        if (cB == 0) {
            t0Var.m(this);
            t0Var.m.g((char) 65533);
            t0Var.o(j2Var);
            return;
        }
        if (cB == '-') {
            t0Var.o(l3.X);
            return;
        }
        e1 e1Var = l3.a;
        if (cB == '>') {
            t0Var.m(this);
            t0Var.i();
            t0Var.o(e1Var);
        } else if (cB != 65535) {
            t0Var.m.g(cB);
            t0Var.o(j2Var);
        } else {
            t0Var.l(this);
            t0Var.i();
            t0Var.o(e1Var);
        }
    }
}
