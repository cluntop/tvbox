package com.github.catvod.spider.merge.p1;

import java.util.ArrayList;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b {
    public e0 a;
    public a b;
    public t0 c;
    public com.github.catvod.spider.merge.o1.h d;
    public ArrayList e;
    public String f;
    public r0 g;
    public d0 h;
    public h0 i;
    public o0 j;
    public b0 l;
    public b0 m;
    public boolean n;
    public com.github.catvod.spider.merge.o1.n o;
    public com.github.catvod.spider.merge.o1.q p;
    public ArrayList q;
    public ArrayList r;
    public ArrayList s;
    public n0 t;
    public boolean u;
    public boolean v;
    public static final String[] x = {"applet", "caption", "html", "marquee", "object", "table", "td", "template", "th"};
    public static final String[] y = {"annotation-xml", "mi", "mn", "mo", "ms", "mtext"};
    public static final String[] z = {"desc", "foreignobject", "title"};
    public static final String[] A = {"ol", "ul"};
    public static final String[] B = {"button"};
    public static final String[] C = {"html", "table"};
    public static final String[] D = {"optgroup", "option"};
    public static final String[] E = {"dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc"};
    public static final String[] F = {"caption", "colgroup", "dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};
    public static final String[] G = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "keygen", "li", "link", "listing", "main", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "search", "section", "select", "source", "style", "summary", "table", "tbody", "td", "template", "textarea", "tfoot", "th", "thead", "title", "tr", "track", "ul", "wbr", "xmp"};
    public static final String[] H = {"annotation-xml", "mi", "mn", "mo", "ms", "mtext"};
    public static final String[] I = {"mi", "mn", "mo", "ms", "mtext"};
    public static final String[] J = {"desc", "foreignObject", "title"};
    public static final String[] K = {"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
    public final n0 k = new n0(3, this);
    public final String[] w = {null};

    public static boolean B(com.github.catvod.spider.merge.o1.n nVar) {
        String str;
        f0 f0Var = nVar.d;
        String str2 = f0Var.a;
        str = f0Var.c;
        str2.getClass();
        switch (str2) {
            case "http://www.w3.org/1999/xhtml":
                return com.github.catvod.spider.merge.n1.i.d(str, G);
            case "http://www.w3.org/2000/svg":
                return com.github.catvod.spider.merge.n1.i.d(str, J);
            case "http://www.w3.org/1998/Math/MathML":
                return com.github.catvod.spider.merge.n1.i.d(str, H);
            default:
                return false;
        }
    }

    public static boolean D(ArrayList arrayList, com.github.catvod.spider.merge.o1.n nVar) {
        int size = arrayList.size();
        int i = size - 1;
        int i2 = i >= 256 ? size - 257 : 0;
        while (i >= i2) {
            if (((com.github.catvod.spider.merge.o1.n) arrayList.get(i)) == nVar) {
                return true;
            }
            i--;
        }
        return false;
    }

    public final void A(o0 o0Var, boolean z2, boolean z3) {
        com.github.catvod.spider.merge.o1.q qVar = (com.github.catvod.spider.merge.o1.q) g(o0Var, "http://www.w3.org/1999/xhtml", false);
        if (!z3 || !C("template")) {
            this.p = qVar;
        }
        j(qVar);
        if (z2) {
            return;
        }
        F();
    }

    public final boolean C(String str) {
        return o(str) != null;
    }

    public final boolean E(String[] strArr) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            if (!com.github.catvod.spider.merge.n1.i.d(((com.github.catvod.spider.merge.o1.n) this.e.get(size)).d.c, strArr)) {
                return true;
            }
        }
        return false;
    }

    public final com.github.catvod.spider.merge.o1.n F() {
        return (com.github.catvod.spider.merge.o1.n) this.e.remove(this.e.size() - 1);
    }

    public final void G(String str) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            f0 f0Var = F().d;
            if (f0Var.c.equals(str) && f0Var.a.equals("http://www.w3.org/1999/xhtml")) {
                return;
            }
        }
    }

    public final void H() {
        if (this.r.size() > 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean I(com.github.catvod.spider.merge.p1.r0 r11) {
        /*
            r10 = this;
            java.util.ArrayList r0 = r10.e
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 == 0) goto Lb
            goto Lc0
        Lb:
            com.github.catvod.spider.merge.o1.n r0 = r10.h()
            com.github.catvod.spider.merge.p1.f0 r2 = r0.d
            java.lang.String r3 = r2.a
            java.lang.String r4 = "http://www.w3.org/1999/xhtml"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L1d
            goto Lc0
        L1d:
            java.lang.String r4 = r2.a
            java.lang.String r5 = "http://www.w3.org/1998/Math/MathML"
            boolean r6 = r5.equals(r4)
            r7 = 5
            if (r6 == 0) goto L56
            java.lang.String r6 = r2.c
            java.lang.String[] r8 = com.github.catvod.spider.merge.p1.b.I
            boolean r6 = com.github.catvod.spider.merge.n1.i.d(r6, r8)
            if (r6 == 0) goto L56
            boolean r6 = r11.e()
            if (r6 == 0) goto L51
            r6 = r11
            com.github.catvod.spider.merge.p1.o0 r6 = (com.github.catvod.spider.merge.p1.o0) r6
            java.lang.String r8 = r6.e
            java.lang.String r9 = "mglyph"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L51
            java.lang.String r8 = "malignmark"
            java.lang.String r6 = r6.e
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L51
            goto Lc0
        L51:
            int r6 = r11.a
            if (r6 != r7) goto L56
            goto Lc0
        L56:
            boolean r3 = r5.equals(r3)
            java.lang.String r6 = "annotation-xml"
            if (r3 == 0) goto L78
            boolean r3 = r0.o(r6)
            if (r3 == 0) goto L78
            boolean r3 = r11.e()
            if (r3 == 0) goto L78
            r3 = r11
            com.github.catvod.spider.merge.p1.o0 r3 = (com.github.catvod.spider.merge.p1.o0) r3
            java.lang.String r3 = r3.e
            java.lang.String r8 = "svg"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L78
            goto Lc0
        L78:
            boolean r3 = r5.equals(r4)
            if (r3 == 0) goto L9f
            boolean r3 = r0.o(r6)
            if (r3 == 0) goto L9f
            java.lang.String r3 = "encoding"
            java.lang.String r0 = r0.b(r3)
            java.lang.String r0 = com.github.catvod.spider.merge.n1.a.d(r0)
            java.lang.String r3 = "text/html"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto Lb1
            java.lang.String r3 = "application/xhtml+xml"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L9f
            goto Lb1
        L9f:
            java.lang.String r0 = "http://www.w3.org/2000/svg"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto Lbc
            java.lang.String r0 = r2.b
            java.lang.String[] r2 = com.github.catvod.spider.merge.p1.b.J
            boolean r0 = com.github.catvod.spider.merge.n1.i.c(r0, r2)
            if (r0 == 0) goto Lbc
        Lb1:
            boolean r0 = r11.e()
            if (r0 != 0) goto Lc0
            int r0 = r11.a
            if (r0 != r7) goto Lbc
            goto Lc0
        Lbc:
            boolean r1 = r11.c()
        Lc0:
            if (r1 == 0) goto Lc5
            com.github.catvod.spider.merge.p1.b0 r0 = r10.l
            goto Lc7
        Lc5:
            com.github.catvod.spider.merge.p1.r r0 = com.github.catvod.spider.merge.p1.b0.x
        Lc7:
            boolean r11 = r0.d(r11, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.p1.b.I(com.github.catvod.spider.merge.p1.r0):boolean");
    }

    public final boolean J(String str) {
        r0 r0Var = this.g;
        n0 n0Var = this.k;
        if (r0Var == n0Var) {
            n0 n0Var2 = new n0(3, this);
            n0Var2.j(str);
            return I(n0Var2);
        }
        n0Var.f();
        n0Var.j(str);
        return I(n0Var);
    }

    public final void K(String str) {
        o0 o0Var = this.j;
        if (this.g == o0Var) {
            o0 o0Var2 = new o0(2, this);
            o0Var2.j(str);
            I(o0Var2);
        } else {
            o0Var.f();
            o0Var.j(str);
            I(o0Var);
        }
    }

    public final void L(b0 b0Var) {
        this.r.add(b0Var);
    }

    public final void M() {
        com.github.catvod.spider.merge.o1.n nVar;
        if (this.e.size() > 256) {
            return;
        }
        boolean z2 = true;
        if (this.q.size() > 0) {
            ArrayList arrayList = this.q;
            nVar = (com.github.catvod.spider.merge.o1.n) arrayList.get(arrayList.size() - 1);
        } else {
            nVar = null;
        }
        if (nVar == null || D(this.e, nVar)) {
            return;
        }
        int size = this.q.size();
        int i = size - 12;
        if (i < 0) {
            i = 0;
        }
        int i2 = size - 1;
        int i3 = i2;
        while (i3 != i) {
            i3--;
            nVar = (com.github.catvod.spider.merge.o1.n) this.q.get(i3);
            if (nVar == null || D(this.e, nVar)) {
                z2 = false;
                break;
            }
        }
        while (true) {
            if (!z2) {
                i3++;
                nVar = (com.github.catvod.spider.merge.o1.n) this.q.get(i3);
            }
            com.github.catvod.spider.merge.u.c2.R(nVar);
            com.github.catvod.spider.merge.o1.n nVar2 = new com.github.catvod.spider.merge.o1.n(this.i.d(nVar.r(), nVar.d.c, "http://www.w3.org/1999/xhtml", this.h.a), null, nVar.d().clone());
            j(nVar2);
            this.q.set(i3, nVar2);
            if (i3 == i2) {
                return;
            } else {
                z2 = false;
            }
        }
    }

    public final void N(com.github.catvod.spider.merge.o1.n nVar) {
        for (int size = this.q.size() - 1; size >= 0; size--) {
            if (((com.github.catvod.spider.merge.o1.n) this.q.get(size)) == nVar) {
                this.q.remove(size);
                return;
            }
        }
    }

    public final void O(com.github.catvod.spider.merge.o1.n nVar) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            if (((com.github.catvod.spider.merge.o1.n) this.e.get(size)) == nVar) {
                this.e.remove(size);
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x004d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean P() {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.p1.b.P():boolean");
    }

    public final f0 Q(o0 o0Var) {
        return this.i.d(o0Var.d.j(), o0Var.e, "http://www.w3.org/1999/xhtml", this.h.a);
    }

    public final com.github.catvod.spider.merge.o1.n a(com.github.catvod.spider.merge.o1.n nVar) {
        if (!D(this.e, nVar)) {
            return null;
        }
        for (int size = this.e.size() - 1; size > 0; size--) {
            if (((com.github.catvod.spider.merge.o1.n) this.e.get(size)) == nVar) {
                return (com.github.catvod.spider.merge.o1.n) this.e.get(size - 1);
            }
        }
        return null;
    }

    public final void b(com.github.catvod.spider.merge.o1.n nVar) {
        int size = this.q.size();
        int i = size - 13;
        int i2 = 0;
        if (i < 0) {
            i = 0;
        }
        for (int i3 = size - 1; i3 >= i; i3--) {
            com.github.catvod.spider.merge.o1.n nVar2 = (com.github.catvod.spider.merge.o1.n) this.q.get(i3);
            if (nVar2 == null) {
                return;
            }
            if (nVar.d.c.equals(nVar2.d.c) && nVar.d().equals(nVar2.d())) {
                i2++;
            }
            if (i2 == 3) {
                this.q.remove(i3);
                return;
            }
        }
    }

    public final void c() {
        while (!this.q.isEmpty()) {
            int size = this.q.size();
            if ((size > 0 ? (com.github.catvod.spider.merge.o1.n) this.q.remove(size - 1) : null) == null) {
                return;
            }
        }
    }

    public final void d(String... strArr) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) this.e.get(size);
            if ("http://www.w3.org/1999/xhtml".equals(nVar.d.a) && (com.github.catvod.spider.merge.n1.i.c(nVar.d.c, strArr) || nVar.o("html"))) {
                return;
            }
            F();
        }
    }

    public final void e() {
        d("table", "template");
    }

    public final void f() {
        d("tr", "template");
    }

    public final com.github.catvod.spider.merge.o1.n g(o0 o0Var, String str, boolean z2) {
        int i;
        com.github.catvod.spider.merge.o1.c cVar = o0Var.g;
        if (cVar != null && cVar.size() != 0) {
            if (!z2 && !this.h.b) {
                for (int i2 = 0; i2 < cVar.a; i2++) {
                    String str2 = cVar.b[i2];
                    if (!com.github.catvod.spider.merge.o1.c.l(str2)) {
                        cVar.b[i2] = com.github.catvod.spider.merge.n1.a.c(str2);
                    }
                }
            }
            d0 d0Var = this.h;
            if (cVar.a == 0) {
                i = 0;
            } else {
                boolean z3 = d0Var.b;
                int i3 = 0;
                i = 0;
                while (i3 < cVar.a) {
                    String str3 = cVar.b[i3];
                    i3++;
                    int i4 = i3;
                    while (i4 < cVar.a) {
                        if ((z3 && str3.equals(cVar.b[i4])) || (!z3 && str3.equalsIgnoreCase(cVar.b[i4]))) {
                            i++;
                            cVar.n(i4);
                            i4--;
                        }
                        i4++;
                    }
                }
            }
            if (i > 0) {
                l("Dropped duplicate attribute(s) in tag [%s]", o0Var.e);
            }
        }
        f0 f0VarD = this.i.d(o0Var.d.j(), o0Var.e, str, (z2 ? d0.d : this.h).a);
        return f0VarD.c.equals("form") ? new com.github.catvod.spider.merge.o1.q(f0VarD, cVar) : new com.github.catvod.spider.merge.o1.n(f0VarD, null, cVar);
    }

    public final com.github.catvod.spider.merge.o1.n h() {
        int size = this.e.size();
        return size > 0 ? (com.github.catvod.spider.merge.o1.n) this.e.get(size - 1) : this.d;
    }

    public final boolean i(String str) {
        com.github.catvod.spider.merge.o1.n nVarH;
        if (this.e.size() == 0 || (nVarH = h()) == null) {
            return false;
        }
        f0 f0Var = nVarH.d;
        return f0Var.c.equals(str) && f0Var.a.equals("http://www.w3.org/1999/xhtml");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(com.github.catvod.spider.merge.o1.n r13) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.p1.b.j(com.github.catvod.spider.merge.o1.n):void");
    }

    public final void k(b0 b0Var) {
        if (this.a.b.a()) {
            this.a.b.add(new com.github.catvod.spider.merge.g1.b(this.b, "Unexpected %s token [%s] when in state [%s]", new Object[]{this.g.getClass().getSimpleName(), this.g, b0Var}));
        }
    }

    public final void l(String str, Object... objArr) {
        c0 c0Var = this.a.b;
        if (c0Var.a()) {
            c0Var.add(new com.github.catvod.spider.merge.g1.b(this.b, str, objArr));
        }
    }

    public final void m(String str) {
        while (com.github.catvod.spider.merge.n1.i.d(h().d.c, E)) {
            if (str != null && i(str)) {
                return;
            } else {
                F();
            }
        }
    }

    public final void n(boolean z2) {
        String[] strArr = z2 ? F : E;
        while ("http://www.w3.org/1999/xhtml".equals(h().d.a) && com.github.catvod.spider.merge.n1.i.d(h().d.c, strArr)) {
            F();
        }
    }

    public final com.github.catvod.spider.merge.o1.n o(String str) {
        int size = this.e.size();
        int i = size - 1;
        int i2 = i >= 256 ? size - 257 : 0;
        while (i >= i2) {
            com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) this.e.get(i);
            f0 f0Var = nVar.d;
            if (f0Var.c.equals(str) && f0Var.a.equals("http://www.w3.org/1999/xhtml")) {
                return nVar;
            }
            i--;
        }
        return null;
    }

    public final boolean p(String str) {
        String[] strArr = this.w;
        strArr[0] = str;
        return s(strArr, x, B);
    }

    public final boolean q(String str) {
        String[] strArr = this.w;
        strArr[0] = str;
        return s(strArr, x, null);
    }

    public final boolean r(String str) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            String str2 = ((com.github.catvod.spider.merge.o1.n) this.e.get(size)).d.c;
            if (str2.equals(str)) {
                return true;
            }
            if (!com.github.catvod.spider.merge.n1.i.d(str2, D)) {
                return false;
            }
        }
        return false;
    }

    public final boolean s(String[] strArr, String[] strArr2, String[] strArr3) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            f0 f0Var = ((com.github.catvod.spider.merge.o1.n) this.e.get(size)).d;
            String str = f0Var.c;
            String str2 = f0Var.a;
            if (str2.equals("http://www.w3.org/1999/xhtml")) {
                if (com.github.catvod.spider.merge.n1.i.d(str, strArr)) {
                    return true;
                }
                if (com.github.catvod.spider.merge.n1.i.d(str, strArr2)) {
                    return false;
                }
                if (strArr3 != null && com.github.catvod.spider.merge.n1.i.d(str, strArr3)) {
                    return false;
                }
            } else if (strArr2 != x) {
                continue;
            } else {
                if (str2.equals("http://www.w3.org/1998/Math/MathML") && com.github.catvod.spider.merge.n1.i.d(str, y)) {
                    return false;
                }
                if (str2.equals("http://www.w3.org/2000/svg") && com.github.catvod.spider.merge.n1.i.d(str, z)) {
                    return false;
                }
            }
        }
        return false;
    }

    public final boolean t(String str) {
        String[] strArr = this.w;
        strArr[0] = str;
        return s(strArr, C, null);
    }

    public final String toString() {
        return "TreeBuilder{currentToken=" + this.g + ", state=" + this.l + ", currentElement=" + h() + '}';
    }

    public final void u(j0 j0Var, boolean z2) {
        com.github.catvod.spider.merge.g1.b bVar = j0Var.d;
        String strJ = bVar.j();
        if (strJ.indexOf(0) != -1) {
            String strReplace = z2 ? strJ.replace((char) 0, (char) 65533) : strJ.replace(j0.e, VideoStream.RESOLUTION_UNKNOWN);
            bVar.i();
            bVar.b = strReplace;
        }
        v(j0Var, h());
    }

    public final void v(j0 j0Var, com.github.catvod.spider.merge.o1.n nVar) {
        String strJ = j0Var.d.j();
        nVar.D(j0Var instanceof i0 ? new com.github.catvod.spider.merge.o1.d(strJ) : nVar.d.b(256) ? new com.github.catvod.spider.merge.o1.f(strJ) : new com.github.catvod.spider.merge.o1.z(strJ));
    }

    public final void w(k0 k0Var) {
        h().D(new com.github.catvod.spider.merge.o1.e(k0Var.d.j()));
    }

    public final com.github.catvod.spider.merge.o1.n x(o0 o0Var) {
        com.github.catvod.spider.merge.o1.n nVarG = g(o0Var, "http://www.w3.org/1999/xhtml", false);
        f0 f0Var = nVarG.d;
        j(nVarG);
        if (o0Var.f) {
            f0Var.d |= 32;
            if (!f0Var.c()) {
                if ((f0Var.d & 1) == 0 || !f0Var.d()) {
                    t0 t0Var = this.c;
                    Object[] objArr = {f0Var.c};
                    c0 c0Var = t0Var.b;
                    if (c0Var.a()) {
                        c0Var.add(new com.github.catvod.spider.merge.g1.b(t0Var.a, "Tag [%s] cannot be self-closing; not a void tag", objArr));
                    }
                } else {
                    this.c.o(l3.a);
                    t0 t0Var2 = this.c;
                    n0 n0Var = this.t;
                    n0Var.f();
                    n0Var.j(f0Var.b);
                    t0Var2.g(n0Var);
                }
            }
        }
        if (f0Var.c()) {
            F();
        }
        return nVarG;
    }

    public final com.github.catvod.spider.merge.o1.n y(o0 o0Var) {
        com.github.catvod.spider.merge.o1.n nVarG = g(o0Var, "http://www.w3.org/1999/xhtml", false);
        j(nVarG);
        F();
        return nVarG;
    }

    public final void z(o0 o0Var, String str) {
        com.github.catvod.spider.merge.o1.n nVarG = g(o0Var, str, true);
        j(nVarG);
        if (o0Var.f) {
            nVarG.d.d |= 32;
            F();
        }
    }
}
