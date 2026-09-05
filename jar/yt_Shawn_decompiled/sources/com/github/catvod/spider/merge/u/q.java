package com.github.catvod.spider.merge.u;

import java.util.List;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q {
    public final p a;
    public int b;
    public int c;
    public int d = 0;

    public q(p pVar) {
        byte[] bArr = s0.a;
        if (pVar == null) {
            throw new NullPointerException("input");
        }
        this.a = pVar;
        pVar.b = this;
    }

    public static void w(int i) throws u0 {
        if ((i & 3) != 0) {
            throw u0.f();
        }
    }

    public static void x(int i) throws u0 {
        if ((i & 7) != 0) {
            throw u0.f();
        }
    }

    public final int a() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.z();
        }
        int i2 = this.b;
        return (i2 == 0 || i2 == this.c) ? ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE : i2 >>> 3;
    }

    public final void b(Object obj, s1 s1Var, y yVar) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            s1Var.i(obj, this, yVar);
            if (this.b == this.c) {
            } else {
                throw u0.f();
            }
        } finally {
            this.c = i;
        }
    }

    public final void c(Object obj, s1 s1Var, y yVar) throws u0 {
        p pVar = this.a;
        int iA = pVar.A();
        if (pVar.a + 0 >= 100) {
            throw new u0("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i = pVar.i(iA);
        pVar.a++;
        s1Var.i(obj, this, yVar);
        pVar.a(0);
        pVar.a--;
        pVar.h(i);
    }

    public final void d(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof g;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(pVar.j()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iD = pVar.d() + pVar.A();
            do {
                list.add(Boolean.valueOf(pVar.j()));
            } while (pVar.d() < iD);
            u(iD);
            return;
        }
        g gVar = (g) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                gVar.b(pVar.j());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iD2 = pVar.d() + pVar.A();
        do {
            gVar.b(pVar.j());
        } while (pVar.d() < iD2);
        u(iD2);
    }

    public final l e() throws t0 {
        v(2);
        return this.a.k();
    }

    public final void f(r0 r0Var) throws t0 {
        int iZ;
        if ((this.b & 7) != 2) {
            throw u0.c();
        }
        do {
            r0Var.add(e());
            p pVar = this.a;
            if (pVar.e()) {
                return;
            } else {
                iZ = pVar.z();
            }
        } while (iZ == this.b);
        this.d = iZ;
    }

    public final void g(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof v;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(pVar.l()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iA = pVar.A();
            x(iA);
            int iD = pVar.d() + iA;
            do {
                list.add(Double.valueOf(pVar.l()));
            } while (pVar.d() < iD);
            return;
        }
        v vVar = (v) list;
        int i3 = i & 7;
        if (i3 == 1) {
            do {
                vVar.b(pVar.l());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iA2 = pVar.A();
        x(iA2);
        int iD2 = pVar.d() + iA2;
        do {
            vVar.b(pVar.l());
        } while (pVar.d() < iD2);
    }

    public final void h(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof k0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(pVar.m()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iD = pVar.d() + pVar.A();
            do {
                list.add(Integer.valueOf(pVar.m()));
            } while (pVar.d() < iD);
            u(iD);
            return;
        }
        k0 k0Var = (k0) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                k0Var.b(pVar.m());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iD2 = pVar.d() + pVar.A();
        do {
            k0Var.b(pVar.m());
        } while (pVar.d() < iD2);
        u(iD2);
    }

    public final void i(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof k0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 2) {
                int iA = pVar.A();
                w(iA);
                int iD = pVar.d() + iA;
                do {
                    list.add(Integer.valueOf(pVar.n()));
                } while (pVar.d() < iD);
                return;
            }
            if (i2 != 5) {
                throw u0.c();
            }
            do {
                list.add(Integer.valueOf(pVar.n()));
                if (pVar.e()) {
                    return;
                } else {
                    iZ = pVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        k0 k0Var = (k0) list;
        int i3 = i & 7;
        if (i3 == 2) {
            int iA2 = pVar.A();
            w(iA2);
            int iD2 = pVar.d() + iA2;
            do {
                k0Var.b(pVar.n());
            } while (pVar.d() < iD2);
            return;
        }
        if (i3 != 5) {
            throw u0.c();
        }
        do {
            k0Var.b(pVar.n());
            if (pVar.e()) {
                return;
            } else {
                iZ2 = pVar.z();
            }
        } while (iZ2 == this.b);
        this.d = iZ2;
    }

    public final void j(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof y0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(pVar.o()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iA = pVar.A();
            x(iA);
            int iD = pVar.d() + iA;
            do {
                list.add(Long.valueOf(pVar.o()));
            } while (pVar.d() < iD);
            return;
        }
        y0 y0Var = (y0) list;
        int i3 = i & 7;
        if (i3 == 1) {
            do {
                y0Var.b(pVar.o());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iA2 = pVar.A();
        x(iA2);
        int iD2 = pVar.d() + iA2;
        do {
            y0Var.b(pVar.o());
        } while (pVar.d() < iD2);
    }

    public final void k(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof c0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 2) {
                int iA = pVar.A();
                w(iA);
                int iD = pVar.d() + iA;
                do {
                    list.add(Float.valueOf(pVar.p()));
                } while (pVar.d() < iD);
                return;
            }
            if (i2 != 5) {
                throw u0.c();
            }
            do {
                list.add(Float.valueOf(pVar.p()));
                if (pVar.e()) {
                    return;
                } else {
                    iZ = pVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        c0 c0Var = (c0) list;
        int i3 = i & 7;
        if (i3 == 2) {
            int iA2 = pVar.A();
            w(iA2);
            int iD2 = pVar.d() + iA2;
            do {
                c0Var.b(pVar.p());
            } while (pVar.d() < iD2);
            return;
        }
        if (i3 != 5) {
            throw u0.c();
        }
        do {
            c0Var.b(pVar.p());
            if (pVar.e()) {
                return;
            } else {
                iZ2 = pVar.z();
            }
        } while (iZ2 == this.b);
        this.d = iZ2;
    }

    public final void l(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof k0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(pVar.q()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iD = pVar.d() + pVar.A();
            do {
                list.add(Integer.valueOf(pVar.q()));
            } while (pVar.d() < iD);
            u(iD);
            return;
        }
        k0 k0Var = (k0) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                k0Var.b(pVar.q());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iD2 = pVar.d() + pVar.A();
        do {
            k0Var.b(pVar.q());
        } while (pVar.d() < iD2);
        u(iD2);
    }

    public final void m(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof y0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(pVar.r()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iD = pVar.d() + pVar.A();
            do {
                list.add(Long.valueOf(pVar.r()));
            } while (pVar.d() < iD);
            u(iD);
            return;
        }
        y0 y0Var = (y0) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                y0Var.b(pVar.r());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iD2 = pVar.d() + pVar.A();
        do {
            y0Var.b(pVar.r());
        } while (pVar.d() < iD2);
        u(iD2);
    }

    public final void n(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof k0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 2) {
                int iA = pVar.A();
                w(iA);
                int iD = pVar.d() + iA;
                do {
                    list.add(Integer.valueOf(pVar.t()));
                } while (pVar.d() < iD);
                return;
            }
            if (i2 != 5) {
                throw u0.c();
            }
            do {
                list.add(Integer.valueOf(pVar.t()));
                if (pVar.e()) {
                    return;
                } else {
                    iZ = pVar.z();
                }
            } while (iZ == this.b);
            this.d = iZ;
            return;
        }
        k0 k0Var = (k0) list;
        int i3 = i & 7;
        if (i3 == 2) {
            int iA2 = pVar.A();
            w(iA2);
            int iD2 = pVar.d() + iA2;
            do {
                k0Var.b(pVar.t());
            } while (pVar.d() < iD2);
            return;
        }
        if (i3 != 5) {
            throw u0.c();
        }
        do {
            k0Var.b(pVar.t());
            if (pVar.e()) {
                return;
            } else {
                iZ2 = pVar.z();
            }
        } while (iZ2 == this.b);
        this.d = iZ2;
    }

    public final void o(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof y0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(pVar.u()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iA = pVar.A();
            x(iA);
            int iD = pVar.d() + iA;
            do {
                list.add(Long.valueOf(pVar.u()));
            } while (pVar.d() < iD);
            return;
        }
        y0 y0Var = (y0) list;
        int i3 = i & 7;
        if (i3 == 1) {
            do {
                y0Var.b(pVar.u());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iA2 = pVar.A();
        x(iA2);
        int iD2 = pVar.d() + iA2;
        do {
            y0Var.b(pVar.u());
        } while (pVar.d() < iD2);
    }

    public final void p(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof k0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(pVar.v()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iD = pVar.d() + pVar.A();
            do {
                list.add(Integer.valueOf(pVar.v()));
            } while (pVar.d() < iD);
            u(iD);
            return;
        }
        k0 k0Var = (k0) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                k0Var.b(pVar.v());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iD2 = pVar.d() + pVar.A();
        do {
            k0Var.b(pVar.v());
        } while (pVar.d() < iD2);
        u(iD2);
    }

    public final void q(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof y0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(pVar.w()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iD = pVar.d() + pVar.A();
            do {
                list.add(Long.valueOf(pVar.w()));
            } while (pVar.d() < iD);
            u(iD);
            return;
        }
        y0 y0Var = (y0) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                y0Var.b(pVar.w());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iD2 = pVar.d() + pVar.A();
        do {
            y0Var.b(pVar.w());
        } while (pVar.d() < iD2);
        u(iD2);
    }

    public final void r(r0 r0Var, boolean z) throws t0 {
        String strX;
        int iZ;
        if ((this.b & 7) != 2) {
            throw u0.c();
        }
        do {
            p pVar = this.a;
            if (z) {
                v(2);
                strX = pVar.y();
            } else {
                v(2);
                strX = pVar.x();
            }
            r0Var.add(strX);
            if (pVar.e()) {
                return;
            } else {
                iZ = pVar.z();
            }
        } while (iZ == this.b);
        this.d = iZ;
    }

    public final void s(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof k0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(pVar.A()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iD = pVar.d() + pVar.A();
            do {
                list.add(Integer.valueOf(pVar.A()));
            } while (pVar.d() < iD);
            u(iD);
            return;
        }
        k0 k0Var = (k0) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                k0Var.b(pVar.A());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iD2 = pVar.d() + pVar.A();
        do {
            k0Var.b(pVar.A());
        } while (pVar.d() < iD2);
        u(iD2);
    }

    public final void t(List list) throws u0 {
        int iZ;
        int iZ2;
        boolean z = list instanceof y0;
        int i = this.b;
        p pVar = this.a;
        if (!z) {
            int i2 = i & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(pVar.B()));
                    if (pVar.e()) {
                        return;
                    } else {
                        iZ = pVar.z();
                    }
                } while (iZ == this.b);
                this.d = iZ;
                return;
            }
            if (i2 != 2) {
                throw u0.c();
            }
            int iD = pVar.d() + pVar.A();
            do {
                list.add(Long.valueOf(pVar.B()));
            } while (pVar.d() < iD);
            u(iD);
            return;
        }
        y0 y0Var = (y0) list;
        int i3 = i & 7;
        if (i3 == 0) {
            do {
                y0Var.b(pVar.B());
                if (pVar.e()) {
                    return;
                } else {
                    iZ2 = pVar.z();
                }
            } while (iZ2 == this.b);
            this.d = iZ2;
            return;
        }
        if (i3 != 2) {
            throw u0.c();
        }
        int iD2 = pVar.d() + pVar.A();
        do {
            y0Var.b(pVar.B());
        } while (pVar.d() < iD2);
        u(iD2);
    }

    public final void u(int i) throws u0 {
        if (this.a.d() != i) {
            throw u0.g();
        }
    }

    public final void v(int i) throws t0 {
        if ((this.b & 7) != i) {
            throw u0.c();
        }
    }
}
