package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum j3 extends l3 {
    public j3() {
        super("TagOpen", 7);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cJ = aVar.J();
        if (cJ == '!') {
            t0Var.a(l3.R);
            return;
        }
        if (cJ == '/') {
            t0Var.a(l3.i);
            return;
        }
        if (cJ == '?') {
            if (t0Var.g == 2) {
                t0Var.a(l3.S);
                return;
            } else {
                t0Var.m.f();
                t0Var.o(l3.Q);
                return;
            }
        }
        if (aVar.Q()) {
            t0Var.d(true);
            t0Var.o(l3.j);
        } else {
            t0Var.m(this);
            t0Var.f('<');
            t0Var.o(l3.a);
        }
    }
}
