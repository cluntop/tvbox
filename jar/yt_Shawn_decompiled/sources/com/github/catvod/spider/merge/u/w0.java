package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w0 {
    public static r0 a(Object obj, long j) {
        r0 r0Var = (r0) b2.c.i(obj, j);
        if (((d) r0Var).a) {
            return r0Var;
        }
        int size = r0Var.size();
        r0 r0VarJ = r0Var.j(size == 0 ? 10 : size * 2);
        b2.p(obj, j, r0VarJ);
        return r0VarJ;
    }
}
