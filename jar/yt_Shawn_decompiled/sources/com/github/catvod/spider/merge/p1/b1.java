package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum b1 extends l3 {
    public b1() {
        super("ScriptDataLessthanSign", 16);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        char cB = aVar.B();
        if (cB == '!') {
            t0Var.h("<!");
            t0Var.o(l3.t);
            return;
        }
        if (cB == '/') {
            t0Var.e();
            t0Var.o(l3.r);
        } else if (cB != 65535) {
            t0Var.f('<');
            aVar.W();
            t0Var.o(l3.f);
        } else {
            t0Var.f('<');
            t0Var.l(this);
            t0Var.o(l3.a);
        }
    }
}
