package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum j2 extends l3 {
    public j2() {
        super("Comment", 47);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        char cJ = aVar.J();
        if (cJ == 0) {
            t0Var.m(this);
            aVar.j();
            t0Var.m.g((char) 65533);
        } else {
            if (cJ == '-') {
                t0Var.a(l3.W);
                return;
            }
            if (cJ != 65535) {
                k0 k0Var = t0Var.m;
                k0Var.d.b(aVar.G('-', 0));
            } else {
                t0Var.l(this);
                t0Var.i();
                t0Var.o(l3.a);
            }
        }
    }
}
