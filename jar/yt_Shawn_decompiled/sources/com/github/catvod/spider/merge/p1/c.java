package com.github.catvod.spider.merge.p1;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum c extends b0 {
    public c() {
        super("InTableText", 9);
    }

    @Override // com.github.catvod.spider.merge.p1.b0
    public final boolean d(r0 r0Var, b bVar) throws IOException {
        if (r0Var.a == 5) {
            bVar.s.add(new j0((j0) r0Var));
            return true;
        }
        if (bVar.s.size() > 0) {
            r0 r0Var2 = bVar.g;
            Iterator it = bVar.s.iterator();
            while (it.hasNext()) {
                j0 j0Var = (j0) it.next();
                bVar.g = j0Var;
                if (b0.a(j0Var)) {
                    bVar.u(j0Var, false);
                } else {
                    bVar.k(this);
                    boolean zD = com.github.catvod.spider.merge.n1.i.d(bVar.h().d.c, a0.z);
                    x xVar = b0.g;
                    if (zD) {
                        bVar.v = true;
                        xVar.d(j0Var, bVar);
                        bVar.v = false;
                    } else {
                        xVar.d(j0Var, bVar);
                    }
                }
            }
            bVar.g = r0Var2;
            bVar.s.clear();
        }
        bVar.l = bVar.m;
        return bVar.I(r0Var);
    }
}
