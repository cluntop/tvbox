package com.github.catvod.spider.merge.q1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a0 extends e0 {
    public static final com.github.catvod.spider.merge.g1.b e = new com.github.catvod.spider.merge.g1.b(new com.github.catvod.spider.merge.n1.b(7));
    public final boolean d;

    public a0(p pVar) {
        boolean z;
        super(pVar);
        if (pVar instanceof d) {
            Iterator it = ((d) pVar).a.iterator();
            while (it.hasNext()) {
                p pVar2 = (p) it.next();
                if ((pVar2 instanceof d0) || (pVar2 instanceof c0)) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        this.d = z;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        return this.a.a() * 10;
    }

    @Override // com.github.catvod.spider.merge.q1.e0, com.github.catvod.spider.merge.q1.p
    public final boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2) {
        boolean z = this.d;
        p pVar = this.a;
        if (z) {
            com.github.catvod.spider.merge.o1.n nVar3 = nVar2.a;
            for (com.github.catvod.spider.merge.o1.n nVarM = nVar3 != null ? nVar3.M() : nVar2; nVarM != null; nVarM = nVarM.p()) {
                if (nVarM != nVar2 && pVar.b(nVar2, nVarM)) {
                    return true;
                }
            }
        }
        com.github.catvod.spider.merge.g1.b bVar = e;
        com.github.catvod.spider.merge.o1.t tVar = (com.github.catvod.spider.merge.o1.t) bVar.c();
        if (tVar.f.isInstance(nVar2)) {
            tVar.b = nVar2;
        }
        tVar.c = nVar2;
        tVar.d = nVar2;
        tVar.a = nVar2;
        tVar.e = nVar2.x();
        while (tVar.hasNext()) {
            try {
                tVar.a();
                com.github.catvod.spider.merge.o1.s sVar = tVar.b;
                if (sVar == null) {
                    throw new NoSuchElementException();
                }
                tVar.d = tVar.c;
                tVar.c = sVar;
                tVar.e = sVar.x();
                tVar.b = null;
                if (sVar != nVar2 && pVar.d(nVar2, sVar)) {
                    return true;
                }
            } finally {
                bVar.h(tVar);
            }
        }
        bVar.h(tVar);
        return false;
    }

    @Override // com.github.catvod.spider.merge.q1.e0
    public final boolean g(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.s sVar) {
        return false;
    }

    public final String toString() {
        return String.format(":has(%s)", this.a);
    }
}
