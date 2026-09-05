package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum q2 extends l3 {
    public q2() {
        super("DoctypeName", 53);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        if (aVar.Q()) {
            t0Var.l.d.b(aVar.D());
            return;
        }
        char cB = aVar.B();
        if (cB == 0) {
            t0Var.m(this);
            t0Var.l.d.a((char) 65533);
            return;
        }
        if (cB != ' ') {
            e1 e1Var = l3.a;
            if (cB == '>') {
                t0Var.j();
                t0Var.o(e1Var);
                return;
            }
            if (cB == 65535) {
                t0Var.l(this);
                t0Var.l.i = true;
                t0Var.j();
                t0Var.o(e1Var);
                return;
            }
            if (cB != '\t' && cB != '\n' && cB != '\f' && cB != '\r') {
                t0Var.l.d.a(cB);
                return;
            }
        }
        t0Var.o(l3.c0);
    }
}
