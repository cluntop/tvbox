package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class u {
    public static final boolean b = b2.e;
    public a1 a;

    public static int a(int i, l lVar) {
        int iD = d(i);
        int size = lVar.size();
        return e(size) + size + iD;
    }

    public static int b(int i) {
        return e((i >> 31) ^ (i << 1));
    }

    public static int c(long j) {
        return f((j >> 63) ^ (j << 1));
    }

    public static int d(int i) {
        return e(i << 3);
    }

    public static int e(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int f(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public abstract void g(byte b2);

    public abstract void h(int i, boolean z);

    public abstract void i(int i, l lVar);

    public abstract void j(int i, int i2);

    public abstract void k(int i);

    public abstract void l(int i, long j);

    public abstract void m(long j);

    public abstract void n(int i, int i2);

    public abstract void o(int i);

    public abstract void p(byte[] bArr, int i, int i2);

    public abstract void q(int i, String str);

    public abstract void r(int i, int i2);

    public abstract void s(int i, int i2);

    public abstract void t(int i);

    public abstract void u(int i, long j);

    public abstract void v(long j);
}
