package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum x1 extends l3 {
    public x1() {
        super("BeforeAttributeValue", 36);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        b2 b2Var = l3.N;
        if (cB == 0) {
            t0Var.m(this);
            t0Var.j.g(aVar.T() - 1, aVar.T(), (char) 65533);
            t0Var.o(b2Var);
            return;
        }
        if (cB != ' ') {
            if (cB == '\"') {
                t0Var.o(l3.L);
                return;
            }
            if (cB != '`') {
                e1 e1Var = l3.a;
                if (cB == 65535) {
                    t0Var.l(this);
                    t0Var.k();
                    t0Var.o(e1Var);
                    return;
                }
                if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r') {
                    return;
                }
                if (cB == '&') {
                    aVar.W();
                    t0Var.o(b2Var);
                    return;
                }
                if (cB == '\'') {
                    t0Var.o(l3.M);
                    return;
                }
                switch (cB) {
                    case '<':
                    case '=':
                        break;
                    case '>':
                        t0Var.m(this);
                        t0Var.k();
                        t0Var.o(e1Var);
                        break;
                    default:
                        aVar.W();
                        t0Var.o(b2Var);
                        break;
                }
                return;
            }
            t0Var.m(this);
            t0Var.j.g(aVar.T() - 1, aVar.T(), cB);
            t0Var.o(b2Var);
        }
    }
}
