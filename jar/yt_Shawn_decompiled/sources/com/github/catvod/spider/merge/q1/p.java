package com.github.catvod.spider.merge.q1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class p {
    public int a() {
        return 5;
    }

    public abstract boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2);

    public boolean c(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.r rVar) {
        return false;
    }

    public final boolean d(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.s sVar) {
        if (sVar instanceof com.github.catvod.spider.merge.o1.n) {
            return b(nVar, (com.github.catvod.spider.merge.o1.n) sVar);
        }
        if ((sVar instanceof com.github.catvod.spider.merge.o1.r) && f()) {
            return c(nVar, (com.github.catvod.spider.merge.o1.r) sVar);
        }
        return false;
    }

    public void e() {
    }

    public boolean f() {
        return false;
    }
}
