package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum k3 extends l3 {
    public k3() {
        super("EndTagOpen", 8);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        boolean zK = aVar.K();
        e1 e1Var = l3.a;
        if (zK) {
            t0Var.l(this);
            t0Var.h("</");
            t0Var.o(e1Var);
        } else if (aVar.Q()) {
            t0Var.d(false);
            t0Var.o(l3.j);
        } else {
            if (aVar.O('>')) {
                t0Var.m(this);
                t0Var.a(e1Var);
                return;
            }
            t0Var.m(this);
            k0 k0Var = t0Var.m;
            k0Var.f();
            k0Var.g('/');
            t0Var.o(l3.Q);
        }
    }
}
