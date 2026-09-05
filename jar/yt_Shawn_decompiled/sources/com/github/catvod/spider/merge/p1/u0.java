package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum u0 extends l3 {
    public u0() {
        super("TagName", 9);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        t0Var.j.i(aVar.E(new com.github.catvod.spider.merge.b0.a(18)));
        char cB = aVar.B();
        if (cB == 0) {
            t0Var.j.i(l3.t0);
            return;
        }
        if (cB != ' ') {
            if (cB == '/') {
                t0Var.o(l3.P);
                return;
            }
            e1 e1Var = l3.a;
            if (cB == '>') {
                t0Var.k();
                t0Var.o(e1Var);
                return;
            }
            if (cB == 65535) {
                t0Var.l(this);
                t0Var.o(e1Var);
                return;
            } else if (cB != '\t' && cB != '\n' && cB != '\f' && cB != '\r') {
                p0 p0Var = t0Var.j;
                p0Var.getClass();
                p0Var.i(String.valueOf(cB));
                return;
            }
        }
        t0Var.o(l3.H);
    }
}
