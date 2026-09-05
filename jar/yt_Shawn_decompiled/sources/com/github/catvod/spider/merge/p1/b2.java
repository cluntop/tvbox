package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum b2 extends l3 {
    public b2() {
        super("AttributeValue_unquoted", 39);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        aVar.T();
        String strH = aVar.H(l3.s0);
        if (strH.length() > 0) {
            t0Var.j.i.b(strH);
        }
        int iT = aVar.T();
        char cB = aVar.B();
        if (cB == 0) {
            t0Var.m(this);
            t0Var.j.g(iT, aVar.T(), (char) 65533);
            return;
        }
        if (cB != ' ') {
            if (cB != '\"' && cB != '`') {
                e1 e1Var = l3.a;
                if (cB == 65535) {
                    t0Var.l(this);
                    t0Var.o(e1Var);
                    return;
                }
                if (cB != '\t' && cB != '\n' && cB != '\f' && cB != '\r') {
                    if (cB == '&') {
                        int[] iArrC = t0Var.c('>', true);
                        p0 p0Var = t0Var.j;
                        if (iArrC != null) {
                            p0Var.h(iArrC, iT, aVar.T());
                            return;
                        } else {
                            p0Var.g(iT, aVar.T(), '&');
                            return;
                        }
                    }
                    if (cB != '\'') {
                        switch (cB) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                t0Var.k();
                                t0Var.o(e1Var);
                                break;
                            default:
                                t0Var.j.g(iT, aVar.T(), cB);
                                break;
                        }
                        return;
                    }
                }
            }
            t0Var.m(this);
            t0Var.j.g(iT, aVar.T(), cB);
            return;
        }
        t0Var.o(l3.H);
    }
}
