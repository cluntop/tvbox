package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum p1 extends l3 {
    public p1() {
        super("CharacterReferenceInData", 1);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        int[] iArrC = t0Var.c(null, false);
        if (iArrC == null) {
            t0Var.f('&');
        } else {
            t0Var.h(new String(iArrC, 0, iArrC.length));
        }
        t0Var.o(l3.a);
    }
}
