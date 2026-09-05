package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum m2 extends l3 {
    public m2() {
        super("CommentEnd", 49);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        j2 j2Var = l3.V;
        if (cB == 0) {
            t0Var.m(this);
            k0 k0Var = t0Var.m;
            k0Var.d.b("--");
            k0Var.g((char) 65533);
            t0Var.o(j2Var);
            return;
        }
        if (cB == '!') {
            t0Var.o(l3.Y);
            return;
        }
        if (cB == '-') {
            t0Var.m.g('-');
            return;
        }
        e1 e1Var = l3.a;
        if (cB == '>') {
            t0Var.i();
            t0Var.o(e1Var);
        } else if (cB == 65535) {
            t0Var.l(this);
            t0Var.i();
            t0Var.o(e1Var);
        } else {
            k0 k0Var2 = t0Var.m;
            k0Var2.d.b("--");
            k0Var2.g(cB);
            t0Var.o(j2Var);
        }
    }
}
