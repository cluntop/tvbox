package com.github.catvod.spider.merge.q1;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b0 extends e0 {
    public final ArrayList d;
    public int e;

    public b0(p pVar) {
        super(pVar);
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        this.e = 2;
        arrayList.add(pVar);
        this.e = pVar.a() + this.e;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        return this.e;
    }

    @Override // com.github.catvod.spider.merge.q1.e0, com.github.catvod.spider.merge.q1.p
    public final void e() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((p) it.next()).e();
        }
        super.e();
    }

    @Override // com.github.catvod.spider.merge.q1.e0
    public final boolean g(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.s sVar) {
        if (sVar == nVar) {
            return false;
        }
        ArrayList arrayList = this.d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (sVar == null || !((p) arrayList.get(size)).d(nVar, sVar)) {
                return false;
            }
            sVar = sVar.x();
        }
        return true;
    }

    public final String toString() {
        return com.github.catvod.spider.merge.n1.i.j(this.d, " > ");
    }
}
