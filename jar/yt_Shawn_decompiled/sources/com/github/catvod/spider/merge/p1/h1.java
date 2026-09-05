package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum h1 extends l3 {
    public h1() {
        super("ScriptDataEscaped", 21);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) {
        if (aVar.K()) {
            t0Var.l(this);
            t0Var.o(l3.a);
            return;
        }
        char cJ = aVar.J();
        if (cJ == 0) {
            t0Var.m(this);
            aVar.j();
            t0Var.f((char) 65533);
        } else if (cJ == '-') {
            t0Var.f('-');
            t0Var.a(l3.w);
        } else if (cJ != '<') {
            t0Var.h(aVar.G('-', '<', 0));
        } else {
            t0Var.a(l3.y);
        }
    }
}
