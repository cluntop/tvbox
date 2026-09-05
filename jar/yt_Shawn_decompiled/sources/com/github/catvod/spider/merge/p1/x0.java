package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum x0 extends l3 {
    public x0() {
        super("RCDATAEndTagName", 12);
    }

    public static void e(t0 t0Var, a aVar) {
        t0Var.h("</");
        t0Var.h(t0Var.f.j());
        aVar.W();
        t0Var.o(l3.c);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        if (aVar.Q()) {
            String strE = aVar.E(new com.github.catvod.spider.merge.b0.a(18));
            t0Var.j.i(strE);
            t0Var.f.b(strE);
            return;
        }
        char cB = aVar.B();
        if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r' || cB == ' ') {
            if (t0Var.n()) {
                t0Var.o(l3.H);
                return;
            } else {
                e(t0Var, aVar);
                return;
            }
        }
        if (cB == '/') {
            if (t0Var.n()) {
                t0Var.o(l3.P);
                return;
            } else {
                e(t0Var, aVar);
                return;
            }
        }
        if (cB != '>') {
            e(t0Var, aVar);
        } else if (!t0Var.n()) {
            e(t0Var, aVar);
        } else {
            t0Var.k();
            t0Var.o(l3.a);
        }
    }
}
