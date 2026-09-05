package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum l1 extends l3 {
    public l1() {
        super("ScriptDataEscapedEndTagOpen", 25);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        if (!aVar.Q()) {
            t0Var.h("</");
            t0Var.o(l3.v);
            return;
        }
        t0Var.d(false);
        p0 p0Var = t0Var.j;
        char cJ = aVar.J();
        p0Var.getClass();
        p0Var.i(String.valueOf(cJ));
        t0Var.f.a(aVar.J());
        t0Var.a(l3.A);
    }
}
