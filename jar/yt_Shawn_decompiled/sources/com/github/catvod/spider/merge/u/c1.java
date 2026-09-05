package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c1 {
    public static b1 a(Object obj, Object obj2) {
        b1 b1VarB = (b1) obj;
        b1 b1Var = (b1) obj2;
        if (!b1Var.isEmpty()) {
            if (!b1VarB.a) {
                b1VarB = b1VarB.b();
            }
            b1VarB.a();
            if (!b1Var.isEmpty()) {
                b1VarB.putAll(b1Var);
            }
        }
        return b1VarB;
    }
}
