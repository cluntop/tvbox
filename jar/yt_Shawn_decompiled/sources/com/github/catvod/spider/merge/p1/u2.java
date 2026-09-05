package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum u2 extends l3 {
    public u2() {
        super("DoctypePublicIdentifier_doubleQuoted", 57);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        if (cB == 0) {
            t0Var.m(this);
            t0Var.l.f.a((char) 65533);
            return;
        }
        if (cB == '\"') {
            t0Var.o(l3.h0);
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
            t0Var.l.f.a(cB);
            return;
        }
        t0Var.l(this);
        t0Var.l.i = true;
        t0Var.j();
        t0Var.o(e1Var);
    }
}
