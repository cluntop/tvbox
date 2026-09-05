package com.github.catvod.spider.merge.p1;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t0 {
    public static final char[] u;
    public static final int[] v = {8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
    public final a a;
    public final c0 b;
    public final o0 h;
    public final n0 i;
    public p0 j;
    public final q0 n;
    public String o;
    public String p;
    public int q;
    public l3 c = l3.a;
    public r0 d = null;
    public boolean e = false;
    public final com.github.catvod.spider.merge.g1.b f = new com.github.catvod.spider.merge.g1.b(7, false);
    public final j0 k = new j0();
    public final l0 l = new l0();
    public final k0 m = new k0();
    public int r = 0;
    public final int[] s = new int[1];
    public final int[] t = new int[2];
    public final int g = 1;

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        u = cArr;
        Arrays.sort(cArr);
    }

    public t0(b bVar) {
        o0 o0Var = new o0(2, bVar);
        this.h = o0Var;
        this.j = o0Var;
        this.i = new n0(3, bVar);
        q0 q0Var = new q0(6, bVar);
        q0Var.k = true;
        this.n = q0Var;
        this.a = bVar.b;
        this.b = bVar.a.b;
    }

    public final void a(l3 l3Var) {
        o(l3Var);
        this.a.j();
    }

    public final void b(String str, Object... objArr) {
        c0 c0Var = this.b;
        if (c0Var.a()) {
            c0Var.add(new com.github.catvod.spider.merge.g1.b(this.a, String.format("Invalid character reference: ".concat(str), objArr)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x01dd, code lost:
    
        if (r0.P('=', '-', '_') == false) goto L116;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] c(java.lang.Character r14, boolean r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 579
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.p1.t0.c(java.lang.Character, boolean):int[]");
    }

    public final p0 d(boolean z) {
        p0 p0Var;
        if (z) {
            p0Var = this.h;
            p0Var.f();
        } else {
            p0Var = this.i;
            p0Var.f();
        }
        this.j = p0Var;
        return p0Var;
    }

    public final void e() {
        this.f.i();
    }

    public final void f(char c) {
        j0 j0Var = this.k;
        j0Var.d.a(c);
        j0Var.b = this.r;
        j0Var.c = this.a.T();
    }

    public final void g(r0 r0Var) {
        if (this.e) {
            throw new com.github.catvod.spider.merge.m1.g("Must be false");
        }
        this.d = r0Var;
        this.e = true;
        r0Var.b = this.q;
        a aVar = this.a;
        r0Var.c = aVar.T();
        this.r = aVar.T();
        int i = r0Var.a;
        if (i == 2) {
            this.o = ((o0) r0Var).d.j();
            this.p = null;
        } else if (i == 3) {
            n0 n0Var = (n0) r0Var;
            if (n0Var.g != null) {
                Object[] objArr = {n0Var.l()};
                c0 c0Var = this.b;
                if (c0Var.a()) {
                    c0Var.add(new com.github.catvod.spider.merge.g1.b(aVar, "Attributes incorrectly present on end tag [/%s]", objArr));
                }
            }
        }
    }

    public final void h(String str) {
        j0 j0Var = this.k;
        j0Var.d.b(str);
        j0Var.b = this.r;
        j0Var.c = this.a.T();
    }

    public final void i() {
        g(this.m);
    }

    public final void j() {
        g(this.l);
    }

    public final void k() {
        p0 p0Var = this.j;
        if (p0Var.h.f()) {
            p0Var.k();
        }
        g(this.j);
    }

    public final void l(l3 l3Var) {
        c0 c0Var = this.b;
        if (c0Var.a()) {
            c0Var.add(new com.github.catvod.spider.merge.g1.b(this.a, "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[]{l3Var}));
        }
    }

    public final void m(l3 l3Var) {
        c0 c0Var = this.b;
        if (c0Var.a()) {
            a aVar = this.a;
            c0Var.add(new com.github.catvod.spider.merge.g1.b(aVar, "Unexpected character '%s' in input state [%s]", new Object[]{Character.valueOf(aVar.J()), l3Var}));
        }
    }

    public final boolean n() {
        return this.o != null && this.j.d.j().equalsIgnoreCase(this.o);
    }

    public final void o(l3 l3Var) {
        if (l3Var == l3.h) {
            this.q = this.a.T();
        }
        this.c = l3Var;
    }
}
