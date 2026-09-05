package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum e1 extends l3 {
    public e1() {
        super("Data", 0);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cJ = aVar.J();
        if (cJ == 0) {
            t0Var.m(this);
            t0Var.f(aVar.B());
        } else {
            if (cJ == '&') {
                t0Var.a(l3.b);
                return;
            }
            if (cJ == '<') {
                t0Var.a(l3.h);
            } else if (cJ != 65535) {
                t0Var.h(aVar.C());
            } else {
                t0Var.g(new m0());
            }
        }
    }
}
