package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class z0 implements e1 {
    public e1[] a;

    @Override // com.github.catvod.spider.merge.u.e1
    public final r1 a(Class cls) {
        for (e1 e1Var : this.a) {
            if (e1Var.b(cls)) {
                return e1Var.a(cls);
            }
        }
        com.github.catvod.spider.merge.s0.a.v("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    @Override // com.github.catvod.spider.merge.u.e1
    public final boolean b(Class cls) {
        for (e1 e1Var : this.a) {
            if (e1Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
