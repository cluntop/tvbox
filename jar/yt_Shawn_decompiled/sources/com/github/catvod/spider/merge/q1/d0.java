package com.github.catvod.spider.merge.q1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d0 extends e0 {
    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        return this.a.a() * 3;
    }

    @Override // com.github.catvod.spider.merge.q1.e0
    public final boolean g(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.s sVar) {
        if (nVar == sVar) {
            return false;
        }
        com.github.catvod.spider.merge.o1.n nVar2 = sVar.a;
        for (com.github.catvod.spider.merge.o1.s sVarL = nVar2 != null ? nVar2.l() : sVar; sVarL != null && sVarL != sVar; sVarL = sVarL.q()) {
            if (h(nVar, sVarL)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return String.format("%s ~ ", this.a);
    }
}
