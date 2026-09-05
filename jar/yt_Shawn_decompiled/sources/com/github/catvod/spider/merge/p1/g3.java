package com.github.catvod.spider.merge.p1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum g3 extends l3 {
    public g3() {
        super("CdataSection", 68);
    }

    @Override // com.github.catvod.spider.merge.p1.l3
    public final void d(t0 t0Var, a aVar) throws IOException {
        String strA;
        int iS = aVar.S("]]>");
        if (iS != -1) {
            strA = a.A(aVar.c, aVar.a, aVar.d, iS);
            aVar.d += iS;
        } else {
            int i = aVar.e;
            int i2 = aVar.d;
            if (i - i2 < 3) {
                strA = aVar.I();
            } else {
                int i3 = i - 2;
                strA = a.A(aVar.c, aVar.a, i2, i3 - i2);
                aVar.d = i3;
            }
        }
        t0Var.f.b(strA);
        if (aVar.M("]]>") || aVar.K()) {
            String strJ = t0Var.f.j();
            i0 i0Var = new i0();
            com.github.catvod.spider.merge.g1.b bVar = i0Var.d;
            bVar.i();
            bVar.b = strJ;
            t0Var.g(i0Var);
            t0Var.o(l3.a);
        }
    }
}
