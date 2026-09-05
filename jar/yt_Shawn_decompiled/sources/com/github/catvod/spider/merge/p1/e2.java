package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum e2 extends l3 {
    public e2() {
        super("BogusComment", 42);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        k0 k0Var = t0Var.m;
        k0Var.d.b(aVar.F('>'));
        char cJ = aVar.J();
        if (cJ == '>' || cJ == 65535) {
            aVar.B();
            t0Var.i();
            t0Var.o(l3.a);
        }
    }
}
