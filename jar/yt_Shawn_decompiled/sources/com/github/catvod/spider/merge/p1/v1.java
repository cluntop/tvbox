package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum v1 extends l3 {
    public v1() {
        super("AttributeName", 34);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        aVar.T();
        String strH = aVar.H(l3.r0);
        p0 p0Var = t0Var.j;
        p0Var.getClass();
        p0Var.h.b(strH.replace((char) 0, (char) 65533));
        char cB = aVar.B();
        w1 w1Var = l3.J;
        if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r' || cB == ' ') {
            t0Var.o(w1Var);
            return;
        }
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
            switch (cB) {
                case '=':
                    t0Var.o(l3.K);
                    return;
                case '>':
                    t0Var.k();
                    t0Var.o(e1Var);
                    return;
                case '?':
                    if (t0Var.g == 2 && (t0Var.j instanceof q0)) {
                        t0Var.o(w1Var);
                        return;
                    }
                    break;
            }
            t0Var.j.h.a(cB);
            return;
        }
        t0Var.m(this);
        t0Var.j.h.a(cB);
    }
}
