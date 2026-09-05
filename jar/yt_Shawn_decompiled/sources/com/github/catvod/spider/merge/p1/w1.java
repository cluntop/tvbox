package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum w1 extends l3 {
    public w1() {
        super("AfterAttributeName", 35);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        v1 v1Var = l3.I;
        if (cB == 0) {
            t0Var.m(this);
            t0Var.j.h.a((char) 65533);
            t0Var.o(v1Var);
            return;
        }
        if (cB != ' ') {
            if (cB != '\"' && cB != '\'') {
                if (cB == '/') {
                    t0Var.o(l3.P);
                    return;
                }
                e1 e1Var = l3.a;
                if (cB == 65535) {
                    t0Var.l(this);
                    t0Var.o(e1Var);
                    return;
                }
                if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r') {
                    return;
                }
                switch (cB) {
                    case '<':
                        break;
                    case '=':
                        t0Var.o(l3.K);
                        break;
                    case '>':
                        t0Var.k();
                        t0Var.o(e1Var);
                        break;
                    default:
                        t0Var.j.k();
                        aVar.W();
                        t0Var.o(v1Var);
                        break;
                }
                return;
            }
            t0Var.m(this);
            t0Var.j.k();
            t0Var.j.h.a(cB);
            t0Var.o(v1Var);
        }
    }
}
