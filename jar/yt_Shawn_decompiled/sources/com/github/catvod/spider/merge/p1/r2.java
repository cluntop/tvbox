package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum r2 extends l3 {
    public r2() {
        super("AfterDoctypeName", 54);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        boolean zK = aVar.K();
        e1 e1Var = l3.a;
        if (zK) {
            t0Var.l(this);
            t0Var.l.i = true;
            t0Var.j();
            t0Var.o(e1Var);
            return;
        }
        if (aVar.P('\t', '\n', '\r', '\f', ' ')) {
            aVar.j();
            return;
        }
        if (aVar.O('>')) {
            t0Var.j();
            t0Var.a(e1Var);
            return;
        }
        int i = t0Var.g;
        l0 l0Var = t0Var.l;
        if (i == 2 && aVar.O('[')) {
            l0Var.getClass();
            t0Var.a(l3.p0);
            return;
        }
        if (aVar.N("PUBLIC")) {
            l0Var.e = "PUBLIC";
            t0Var.o(l3.d0);
        } else if (aVar.N("SYSTEM")) {
            l0Var.e = "SYSTEM";
            t0Var.o(l3.j0);
        } else {
            t0Var.m(this);
            l0Var.i = true;
            t0Var.a(l3.o0);
        }
    }
}
