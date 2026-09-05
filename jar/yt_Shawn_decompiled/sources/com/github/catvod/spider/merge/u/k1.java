package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k1 implements s1 {
    public final g1 a;
    public final w1 b;
    public final z c;

    public k1(w1 w1Var, z zVar, g1 g1Var) {
        this.b = w1Var;
        zVar.getClass();
        this.c = zVar;
        this.a = g1Var;
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final int a(j0 j0Var) {
        this.b.getClass();
        return j0Var.unknownFields.hashCode();
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final void b(Object obj, Object obj2) {
        t1.k(this.b, obj, obj2);
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final boolean c(j0 j0Var, j0 j0Var2) {
        this.b.getClass();
        return j0Var.unknownFields.equals(j0Var2.unknownFields);
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final void d(Object obj) {
        this.b.getClass();
        v1 v1Var = ((j0) obj).unknownFields;
        if (v1Var.e) {
            v1Var.e = false;
        }
        this.c.getClass();
        o.c(obj);
        throw null;
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final int e(j0 j0Var) {
        this.b.getClass();
        v1 v1Var = j0Var.unknownFields;
        int i = v1Var.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < v1Var.a; i2++) {
            int i3 = v1Var.b[i2] >>> 3;
            l lVar = (l) v1Var.c[i2];
            iA += u.a(3, lVar) + u.e(i3) + u.d(2) + (u.d(1) * 2);
        }
        v1Var.d = iA;
        return iA;
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final void f(Object obj, byte[] bArr, int i, int i2, f fVar) {
        j0 j0Var = (j0) obj;
        if (j0Var.unknownFields == v1.f) {
            j0Var.unknownFields = new v1();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final boolean g(Object obj) {
        this.c.getClass();
        o.c(obj);
        throw null;
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final void h(Object obj, a1 a1Var) {
        this.c.getClass();
        o.c(obj);
        throw null;
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final void i(Object obj, q qVar, y yVar) {
        this.b.getClass();
        w1.a(obj);
        this.c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.github.catvod.spider.merge.u.s1
    public final Object j() {
        g1 g1Var = this.a;
        return g1Var instanceof j0 ? ((j0) g1Var).newMutableInstance() : g1Var.newBuilderForType().buildPartial();
    }
}
