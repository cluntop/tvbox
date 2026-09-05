package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum a2 extends l3 {
    public a2() {
        super("Rcdata", 2);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cJ = aVar.J();
        if (cJ == 0) {
            t0Var.m(this);
            aVar.j();
            t0Var.f((char) 65533);
        } else {
            if (cJ == '&') {
                t0Var.a(l3.d);
                return;
            }
            if (cJ == '<') {
                t0Var.a(l3.k);
            } else if (cJ != 65535) {
                t0Var.h(aVar.C());
            } else {
                t0Var.g(new m0());
            }
        }
    }
}
