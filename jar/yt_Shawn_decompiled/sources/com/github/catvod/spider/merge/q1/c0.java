package com.github.catvod.spider.merge.q1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c0 extends e0 {
    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        return this.a.a() + 2;
    }

    @Override // com.github.catvod.spider.merge.q1.e0
    public final boolean g(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.s sVar) {
        com.github.catvod.spider.merge.o1.s sVarY;
        if (nVar == sVar) {
            return false;
        }
        if (!this.b) {
            sVar.getClass();
            while (true) {
                sVar = sVar.y();
                if (sVar == null) {
                    sVarY = null;
                    break;
                }
                if (sVar instanceof com.github.catvod.spider.merge.o1.n) {
                    sVarY = (com.github.catvod.spider.merge.o1.n) sVar;
                    break;
                }
            }
        } else {
            sVarY = sVar.y();
        }
        return sVarY != null && h(nVar, sVarY);
    }

    public final String toString() {
        return String.format("%s + ", this.a);
    }
}
