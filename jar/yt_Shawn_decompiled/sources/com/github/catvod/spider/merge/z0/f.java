package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.y0.g0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class f {
    public static final com.github.catvod.spider.merge.y0.m a;
    public static final com.github.catvod.spider.merge.y0.m b;
    public static final com.github.catvod.spider.merge.y0.m c;
    public static final com.github.catvod.spider.merge.y0.m d;
    public static final com.github.catvod.spider.merge.y0.m e;

    static {
        com.github.catvod.spider.merge.y0.m mVar = com.github.catvod.spider.merge.y0.m.d;
        a = com.github.catvod.spider.merge.h0.f.d("/");
        b = com.github.catvod.spider.merge.h0.f.d("\\");
        c = com.github.catvod.spider.merge.h0.f.d("/\\");
        d = com.github.catvod.spider.merge.h0.f.d(".");
        e = com.github.catvod.spider.merge.h0.f.d("..");
    }

    public static final int a(g0 g0Var) {
        com.github.catvod.spider.merge.y0.m mVar = g0Var.a;
        if (mVar.d() != 0) {
            if (mVar.i(0) != 47) {
                if (mVar.i(0) == 92) {
                    if (mVar.d() > 2 && mVar.i(1) == 92) {
                        com.github.catvod.spider.merge.y0.m mVar2 = b;
                        mVar2.getClass();
                        int iF = mVar.f(mVar2.h(), 2);
                        return iF == -1 ? mVar.d() : iF;
                    }
                } else if (mVar.d() > 2 && mVar.i(1) == 58 && mVar.i(2) == 92) {
                    char cI = (char) mVar.i(0);
                    if ('a' <= cI && cI < '{') {
                        return 3;
                    }
                    if ('A' <= cI && cI < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final g0 b(g0 g0Var, g0 g0Var2, boolean z) {
        g0Var2.getClass();
        if (a(g0Var2) != -1 || g0Var2.f() != null) {
            return g0Var2;
        }
        com.github.catvod.spider.merge.y0.m mVarC = c(g0Var);
        if (mVarC == null && (mVarC = c(g0Var2)) == null) {
            mVarC = f(g0.b);
        }
        com.github.catvod.spider.merge.y0.j jVar = new com.github.catvod.spider.merge.y0.j();
        jVar.M(g0Var.a);
        if (jVar.b > 0) {
            jVar.M(mVarC);
        }
        jVar.M(g0Var2.a);
        return d(jVar, z);
    }

    public static final com.github.catvod.spider.merge.y0.m c(g0 g0Var) {
        com.github.catvod.spider.merge.y0.m mVar = g0Var.a;
        com.github.catvod.spider.merge.y0.m mVar2 = a;
        if (com.github.catvod.spider.merge.y0.m.g(mVar, mVar2) != -1) {
            return mVar2;
        }
        com.github.catvod.spider.merge.y0.m mVar3 = g0Var.a;
        com.github.catvod.spider.merge.y0.m mVar4 = b;
        if (com.github.catvod.spider.merge.y0.m.g(mVar3, mVar4) != -1) {
            return mVar4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113 A[EDGE_INSN: B:100:0x0113->B:82:0x0113 BREAK  A[LOOP:1: B:54:0x00ae->B:113:0x00ae], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.github.catvod.spider.merge.y0.g0 d(com.github.catvod.spider.merge.y0.j r17, boolean r18) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.z0.f.d(com.github.catvod.spider.merge.y0.j, boolean):com.github.catvod.spider.merge.y0.g0");
    }

    public static final com.github.catvod.spider.merge.y0.m e(byte b2) {
        if (b2 == 47) {
            return a;
        }
        if (b2 == 92) {
            return b;
        }
        com.github.catvod.spider.merge.s0.a.r(com.github.catvod.spider.merge.b.b.j(b2, "not a directory separator: "));
        return null;
    }

    public static final com.github.catvod.spider.merge.y0.m f(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return a;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return b;
        }
        com.github.catvod.spider.merge.s0.a.r(com.github.catvod.spider.merge.b.b.n("not a directory separator: ", str));
        return null;
    }
}
