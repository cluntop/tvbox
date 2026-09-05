package com.github.catvod.spider.merge.q1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s extends t {
    public final Class a;
    public final String b;

    public s(Class cls, String str) {
        this.a = cls;
        this.b = "::".concat(str);
    }

    @Override // com.github.catvod.spider.merge.q1.p
    public final int a() {
        return 1;
    }

    @Override // com.github.catvod.spider.merge.q1.t
    public final boolean g(com.github.catvod.spider.merge.o1.s sVar) {
        return this.a.isInstance(sVar);
    }

    public final String toString() {
        return this.b;
    }
}
