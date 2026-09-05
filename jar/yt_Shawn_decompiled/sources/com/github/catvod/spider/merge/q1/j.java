package com.github.catvod.spider.merge.q1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j extends p {
    public final String a;
    public final com.github.catvod.spider.merge.m1.f b;

    public j(String str, com.github.catvod.spider.merge.m1.f fVar) {
        this.a = com.github.catvod.spider.merge.n1.a.d(str);
        this.b = fVar;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        return 8;
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final boolean b(com.github.catvod.spider.merge.o1.n nVar, com.github.catvod.spider.merge.o1.n nVar2) {
        String str = this.a;
        return nVar2.m(str) && this.b.b(nVar2.b(str)).find();
    }

    public final String toString() {
        return "[" + this.a + "~=" + this.b.toString() + "]";
    }
}
