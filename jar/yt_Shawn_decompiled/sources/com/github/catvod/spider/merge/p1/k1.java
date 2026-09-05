package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum k1 extends l3 {
    public k1() {
        super("ScriptDataEscapedLessthanSign", 24);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        if (aVar.Q()) {
            t0Var.e();
            t0Var.f.a(aVar.J());
            t0Var.f('<');
            t0Var.f(aVar.J());
            t0Var.a(l3.B);
            return;
        }
        if (aVar.O('/')) {
            t0Var.e();
            t0Var.a(l3.z);
        } else {
            t0Var.f('<');
            t0Var.o(l3.v);
        }
    }
}
