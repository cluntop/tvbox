package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w1 {
    public static v1 a(Object obj) {
        j0 j0Var = (j0) obj;
        v1 v1Var = j0Var.unknownFields;
        if (v1Var != v1.f) {
            return v1Var;
        }
        v1 v1Var2 = new v1();
        j0Var.unknownFields = v1Var2;
        return v1Var2;
    }

    public static boolean b(int i, q qVar, Object obj) throws u0 {
        int i2 = qVar.b;
        p pVar = qVar.a;
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            qVar.v(0);
            ((v1) obj).f(i3 << 3, Long.valueOf(pVar.r()));
            return true;
        }
        if (i4 == 1) {
            qVar.v(1);
            ((v1) obj).f((i3 << 3) | 1, Long.valueOf(pVar.o()));
            return true;
        }
        if (i4 == 2) {
            ((v1) obj).f((i3 << 3) | 2, qVar.e());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                if (i != 0) {
                    return false;
                }
                throw new u0("Protocol message end-group tag did not match expected tag.");
            }
            if (i4 != 5) {
                throw u0.c();
            }
            qVar.v(5);
            ((v1) obj).f(5 | (i3 << 3), Integer.valueOf(pVar.n()));
            return true;
        }
        v1 v1Var = new v1();
        int i5 = i3 << 3;
        int i6 = i5 | 4;
        int i7 = i + 1;
        if (i7 >= 100) {
            throw new u0("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (qVar.a() != Integer.MAX_VALUE && b(i7, qVar, v1Var)) {
        }
        if (i6 != qVar.b) {
            throw new u0("Protocol message end-group tag did not match expected tag.");
        }
        if (v1Var.e) {
            v1Var.e = false;
        }
        ((v1) obj).f(i5 | 3, v1Var);
        return true;
    }
}
