package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g0 implements Comparable {
    public static final String b;
    public final m a;

    static {
        String str = File.separator;
        str.getClass();
        b = str;
    }

    public g0(m mVar) {
        mVar.getClass();
        this.a = mVar;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = com.github.catvod.spider.merge.z0.f.a(this);
        m mVar = this.a;
        if (iA == -1) {
            iA = 0;
        } else if (iA < mVar.d() && mVar.i(iA) == 92) {
            iA++;
        }
        int iD = mVar.d();
        int i = iA;
        while (iA < iD) {
            if (mVar.i(iA) == 47 || mVar.i(iA) == 92) {
                arrayList.add(mVar.o(i, iA));
                i = iA + 1;
            }
            iA++;
        }
        if (i < mVar.d()) {
            arrayList.add(mVar.o(i, mVar.d()));
        }
        return arrayList;
    }

    public final g0 b() {
        m mVar = com.github.catvod.spider.merge.z0.f.d;
        m mVar2 = this.a;
        if (Intrinsics.areEqual(mVar2, mVar)) {
            return null;
        }
        m mVar3 = com.github.catvod.spider.merge.z0.f.a;
        if (Intrinsics.areEqual(mVar2, mVar3)) {
            return null;
        }
        m mVar4 = com.github.catvod.spider.merge.z0.f.b;
        if (Intrinsics.areEqual(mVar2, mVar4)) {
            return null;
        }
        m mVar5 = com.github.catvod.spider.merge.z0.f.e;
        mVar2.getClass();
        mVar5.getClass();
        int iD = mVar2.d();
        byte[] bArr = mVar5.a;
        if (mVar2.l(iD - bArr.length, mVar5, bArr.length) && (mVar2.d() == 2 || mVar2.l(mVar2.d() - 3, mVar3, 1) || mVar2.l(mVar2.d() - 3, mVar4, 1))) {
            return null;
        }
        int iK = m.k(mVar2, mVar3);
        if (iK == -1) {
            iK = m.k(mVar2, mVar4);
        }
        if (iK == 2 && f() != null) {
            if (mVar2.d() == 3) {
                return null;
            }
            return new g0(m.p(mVar2, 0, 3, 1));
        }
        if (iK == 1) {
            mVar4.getClass();
            if (mVar2.l(0, mVar4, mVar4.d())) {
                return null;
            }
        }
        if (iK != -1 || f() == null) {
            return iK == -1 ? new g0(mVar) : iK == 0 ? new g0(m.p(mVar2, 0, 1, 1)) : new g0(m.p(mVar2, 0, iK, 1));
        }
        if (mVar2.d() == 2) {
            return null;
        }
        return new g0(m.p(mVar2, 0, 2, 1));
    }

    public final g0 c(g0 g0Var) {
        g0Var.getClass();
        m mVar = g0Var.a;
        int iA = com.github.catvod.spider.merge.z0.f.a(this);
        m mVar2 = this.a;
        g0 g0Var2 = iA == -1 ? null : new g0(mVar2.o(0, iA));
        int iA2 = com.github.catvod.spider.merge.z0.f.a(g0Var);
        if (!Intrinsics.areEqual(g0Var2, iA2 != -1 ? new g0(mVar.o(0, iA2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + g0Var).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = g0Var.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(arrayListA.get(i), arrayListA2.get(i))) {
            i++;
        }
        if (i == iMin && mVar2.d() == mVar.d()) {
            return com.github.catvod.spider.merge.h0.f.e(".");
        }
        if (arrayListA2.subList(i, arrayListA2.size()).indexOf(com.github.catvod.spider.merge.z0.f.e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + g0Var).toString());
        }
        if (Intrinsics.areEqual(mVar, com.github.catvod.spider.merge.z0.f.d)) {
            return this;
        }
        j jVar = new j();
        m mVarC = com.github.catvod.spider.merge.z0.f.c(g0Var);
        if (mVarC == null && (mVarC = com.github.catvod.spider.merge.z0.f.c(this)) == null) {
            mVarC = com.github.catvod.spider.merge.z0.f.f(b);
        }
        int size = arrayListA2.size();
        for (int i2 = i; i2 < size; i2++) {
            jVar.M(com.github.catvod.spider.merge.z0.f.e);
            jVar.M(mVarC);
        }
        int size2 = arrayListA.size();
        while (i < size2) {
            jVar.M((m) arrayListA.get(i));
            jVar.M(mVarC);
            i++;
        }
        return com.github.catvod.spider.merge.z0.f.d(jVar, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g0 g0Var = (g0) obj;
        g0Var.getClass();
        return this.a.compareTo(g0Var.a);
    }

    public final g0 d(String str) {
        str.getClass();
        j jVar = new j();
        jVar.T(str);
        return com.github.catvod.spider.merge.z0.f.b(this, com.github.catvod.spider.merge.z0.f.d(jVar, false), false);
    }

    public final Path e() {
        Path path = Paths.get(this.a.r(), new String[0]);
        path.getClass();
        return path;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof g0) && Intrinsics.areEqual(((g0) obj).a, this.a);
    }

    public final Character f() {
        m mVar = com.github.catvod.spider.merge.z0.f.a;
        m mVar2 = this.a;
        if (m.g(mVar2, mVar) != -1 || mVar2.d() < 2 || mVar2.i(1) != 58) {
            return null;
        }
        char cI = (char) mVar2.i(0);
        if (('a' > cI || cI >= '{') && ('A' > cI || cI >= '[')) {
            return null;
        }
        return Character.valueOf(cI);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final File toFile() {
        return new File(this.a.r());
    }

    public final String toString() {
        return this.a.r();
    }
}
