package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum z0 extends l3 {
    public z0() {
        super("RawtextEndTagOpen", 14);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        if (aVar.Q()) {
            t0Var.d(false);
            t0Var.o(l3.p);
        } else {
            t0Var.h("</");
            t0Var.o(l3.e);
        }
    }
}
