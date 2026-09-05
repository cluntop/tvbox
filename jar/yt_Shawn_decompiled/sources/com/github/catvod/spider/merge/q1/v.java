package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.merge.p1.s0;
import com.github.catvod.spider.merge.u.c2;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v implements AutoCloseable {
    public static final char[] d = {'>', '+', '~'};
    public static final String[] e = {"=", "!=", "^=", "$=", "*=", "~="};
    public static final char[] f = {',', ')'};
    public static final Pattern g = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);
    public static final Pattern h = Pattern.compile("([+-])?(\\d+)");
    public final s0 a;
    public final String b;
    public boolean c;

    public v(String str) {
        c2.P(str);
        String strTrim = str.trim();
        this.b = strTrim;
        this.a = new s0(strTrim);
    }

    public static p H(String str) {
        try {
            v vVar = new v(str);
            try {
                p pVarJ = vVar.J();
                s0 s0Var = vVar.a;
                s0Var.B();
                com.github.catvod.spider.merge.p1.a aVar = s0Var.a;
                if (!aVar.K()) {
                    throw new x("Could not parse query '%s': unexpected token at '%s'", vVar.b, aVar.I());
                }
                vVar.close();
                return pVarJ;
            } finally {
            }
        } catch (IllegalArgumentException e2) {
            throw new x(e2.getMessage());
        }
    }

    public static p j(p pVar, p pVar2) {
        if (pVar == null) {
            return pVar2;
        }
        if (!(pVar instanceof b)) {
            return new b(Arrays.asList(pVar, pVar2));
        }
        b bVar = (b) pVar;
        bVar.a.add(pVar2);
        bVar.g();
        return pVar;
    }

    public final String A() {
        return this.a.z('(', ')');
    }

    public final p B(boolean z) {
        String str = z ? ":containsOwn" : ":contains";
        String strE = s0.E(A());
        c2.Q(strE, str.concat("(text) query must not be empty"));
        return this.c ? new r(strE) : z ? new h(strE, 4) : new h(strE, 5);
    }

    public final p C(boolean z) {
        String str = z ? ":containsWholeOwnText" : ":containsWholeText";
        String strE = s0.E(A());
        c2.Q(strE, str.concat("(text) query must not be empty"));
        boolean z2 = false;
        return z ? new h(strE, 6, z2) : new h(strE, 7, z2);
    }

    public final n D(boolean z, boolean z2) throws NumberFormatException {
        int i;
        int i2;
        String strD = com.github.catvod.spider.merge.n1.a.d(A());
        if ("odd".equals(strD)) {
            i2 = 2;
            i = 1;
        } else {
            if ("even".equals(strD)) {
                i2 = 2;
            } else {
                Matcher matcher = g.matcher(strD);
                if (matcher.matches()) {
                    i2 = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", VideoStream.RESOLUTION_UNKNOWN)) : "-".equals(matcher.group(2)) ? -1 : 1;
                    if (matcher.group(4) != null) {
                        i = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", VideoStream.RESOLUTION_UNKNOWN));
                    }
                } else {
                    Matcher matcher2 = h.matcher(strD);
                    if (!matcher2.matches()) {
                        throw new x("Could not parse nth-index '%s': unexpected format", strD);
                    }
                    i = Integer.parseInt(matcher2.group().replaceFirst("^\\+", VideoStream.RESOLUTION_UNKNOWN));
                    i2 = 0;
                }
            }
            i = 0;
        }
        return z2 ? z ? new n(i2, i, 2) : new n(i2, i, 3) : z ? new n(i2, i, 1) : new n(i2, i, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p E(s0 s0Var) {
        int i;
        Object[] objArr;
        com.github.catvod.spider.merge.p1.a aVar = s0Var.a;
        StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
        loop0: while (true) {
            i = 0;
            objArr = 0;
            if (aVar.K()) {
                break;
            }
            for (int i2 = 0; i2 < 6; i2++) {
                if (aVar.R(e[i2])) {
                    break loop0;
                }
            }
            sbB.append(aVar.B());
        }
        String strD = com.github.catvod.spider.merge.n1.a.d(com.github.catvod.spider.merge.n1.i.l(sbB));
        c2.P(strD);
        if (strD.equals("abs:")) {
            throw new com.github.catvod.spider.merge.m1.g("Absolute attribute key must have a name");
        }
        s0Var.B();
        if (aVar.K()) {
            return strD.startsWith("^") ? new h(strD.substring(1), 1) : strD.equals("*") ? new h(VideoStream.RESOLUTION_UNKNOWN, 1) : new h(strD, i, objArr == true ? 1 : 0);
        }
        if (s0Var.D('=')) {
            return new i(strD, aVar.I(), 0);
        }
        if (aVar.N("!=")) {
            return new i(strD, aVar.I(), 3);
        }
        if (aVar.N("^=")) {
            return new i(strD, aVar.I(), 4);
        }
        if (aVar.N("$=")) {
            return new i(strD, aVar.I(), 2);
        }
        if (aVar.N("*=")) {
            return new i(strD, aVar.I(), 1);
        }
        if (aVar.N("~=")) {
            return new j(strD, com.github.catvod.spider.merge.m1.f.a(aVar.I()));
        }
        throw new x("Could not parse attribute query '%s': unexpected token at '%s'", this.b, aVar.I());
    }

    public final p F(boolean z) {
        String str = z ? ":matchesOwn" : ":matches";
        String strA = A();
        c2.Q(strA, str.concat("(regex) query must not be empty"));
        com.github.catvod.spider.merge.m1.f fVarA = com.github.catvod.spider.merge.m1.f.a(strA);
        return this.c ? new r(fVarA) : z ? new o(fVarA, 1) : new o(fVarA, 0);
    }

    public final p G(boolean z) {
        String str = z ? ":matchesWholeOwnText" : ":matchesWholeText";
        String strA = A();
        c2.Q(strA, str.concat("(regex) query must not be empty"));
        com.github.catvod.spider.merge.m1.f fVarA = com.github.catvod.spider.merge.m1.f.a(strA);
        return z ? new o(fVarA, 2) : new o(fVarA, 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a5, code lost:
    
        return r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.github.catvod.spider.merge.q1.p] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.github.catvod.spider.merge.q1.p] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.github.catvod.spider.merge.q1.p] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.github.catvod.spider.merge.q1.b0, com.github.catvod.spider.merge.q1.e0] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.github.catvod.spider.merge.q1.p] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.merge.q1.p I() {
        /*
            r8 = this;
            com.github.catvod.spider.merge.p1.s0 r0 = r8.a
            r0.B()
            com.github.catvod.spider.merge.p1.a r1 = r0.a
            char[] r2 = com.github.catvod.spider.merge.q1.v.d
            boolean r3 = r1.P(r2)
            if (r3 == 0) goto L17
            com.github.catvod.spider.merge.q1.g r3 = new com.github.catvod.spider.merge.q1.g
            r4 = 8
            r3.<init>(r4)
            goto L1b
        L17:
            com.github.catvod.spider.merge.q1.p r3 = r8.K()
        L1b:
            boolean r4 = r0.B()
            r5 = 0
            r6 = 32
            if (r4 == 0) goto L27
            r4 = 32
            goto L28
        L27:
            r4 = 0
        L28:
            boolean r7 = r1.P(r2)
            if (r7 == 0) goto L33
            char r4 = r1.B()
            goto L3c
        L33:
            char[] r7 = com.github.catvod.spider.merge.q1.v.f
            boolean r7 = r1.P(r7)
            if (r7 == 0) goto L3c
            goto La5
        L3c:
            if (r4 == 0) goto La5
            com.github.catvod.spider.merge.q1.p r7 = r8.K()
            if (r4 == r6) goto L9a
            r6 = 43
            if (r4 == r6) goto L90
            r6 = 62
            if (r4 == r6) goto L6b
            r6 = 126(0x7e, float:1.77E-43)
            if (r4 != r6) goto L5a
            com.github.catvod.spider.merge.q1.d0 r4 = new com.github.catvod.spider.merge.q1.d0
            r4.<init>(r3)
            com.github.catvod.spider.merge.q1.p r3 = j(r4, r7)
            goto L1b
        L5a:
            com.github.catvod.spider.merge.q1.x r0 = new com.github.catvod.spider.merge.q1.x
            java.lang.Character r1 = java.lang.Character.valueOf(r4)
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r1
            java.lang.String r1 = "Unknown combinator '%s'"
            r0.<init>(r1, r2)
            throw r0
        L6b:
            boolean r4 = r3 instanceof com.github.catvod.spider.merge.q1.b0
            if (r4 == 0) goto L72
            com.github.catvod.spider.merge.q1.b0 r3 = (com.github.catvod.spider.merge.q1.b0) r3
            goto L78
        L72:
            com.github.catvod.spider.merge.q1.b0 r4 = new com.github.catvod.spider.merge.q1.b0
            r4.<init>(r3)
            r3 = r4
        L78:
            java.util.ArrayList r4 = r3.d
            r4.add(r7)
            int r4 = r3.e
            int r5 = r7.a()
            int r5 = r5 + r4
            r3.e = r5
            boolean r4 = r3.b
            boolean r5 = r7.f()
            r4 = r4 | r5
            r3.b = r4
            goto L1b
        L90:
            com.github.catvod.spider.merge.q1.c0 r4 = new com.github.catvod.spider.merge.q1.c0
            r4.<init>(r3)
            com.github.catvod.spider.merge.q1.p r3 = j(r4, r7)
            goto L1b
        L9a:
            com.github.catvod.spider.merge.q1.z r4 = new com.github.catvod.spider.merge.q1.z
            r4.<init>(r3, r5)
            com.github.catvod.spider.merge.q1.p r3 = j(r4, r7)
            goto L1b
        La5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.q1.v.I():com.github.catvod.spider.merge.q1.p");
    }

    public final p J() {
        p pVarI = I();
        while (this.a.D(',')) {
            p pVarI2 = I();
            if (pVarI instanceof c) {
                c cVar = (c) pVarI;
                cVar.a.add(pVarI2);
                cVar.g();
            } else {
                pVarI = new c(pVarI, pVarI2);
            }
        }
        return pVarI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p K() {
        p hVar;
        p pVarJ;
        s0 s0Var = this.a;
        s0Var.B();
        com.github.catvod.spider.merge.p1.a aVar = s0Var.a;
        int i = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        if (Character.isLetterOrDigit(aVar.J()) || aVar.R("*|")) {
            StringBuilder sbB = com.github.catvod.spider.merge.n1.i.b();
            while (!aVar.K()) {
                char cJ = aVar.J();
                if (cJ != '\\') {
                    if (!Character.isLetterOrDigit(aVar.J()) && !aVar.P(s0.b)) {
                        break;
                    }
                    sbB.append(cJ);
                    s0Var.j();
                } else {
                    s0Var.j();
                    if (aVar.K()) {
                        break;
                    }
                    sbB.append(aVar.B());
                }
            }
            String strD = com.github.catvod.spider.merge.n1.a.d(com.github.catvod.spider.merge.n1.i.l(sbB));
            c2.P(strD);
            int i2 = 9;
            if (strD.startsWith("*|")) {
                String strSubstring = strD.substring(2);
                hVar = new c(new h(strSubstring, i2, objArr4 == true ? 1 : 0), new h(":".concat(strSubstring), 10, objArr3 == true ? 1 : 0));
            } else if (strD.endsWith("|*")) {
                hVar = new h(strD.substring(0, strD.length() - 2).concat(":"), 11, objArr2 == true ? 1 : 0);
            } else {
                if (strD.contains("|")) {
                    strD = strD.replace("|", ":");
                }
                hVar = new h(strD, i2, objArr == true ? 1 : 0);
            }
            pVarJ = hVar;
        } else {
            pVarJ = s0Var.D('*') ? new g(i) : null;
        }
        while (true) {
            p pVarL = L();
            if (pVarL == null) {
                break;
            }
            pVarJ = j(pVarJ, pVarL);
        }
        if (pVarJ != null) {
            return pVarJ;
        }
        throw new x("Could not parse query '%s': unexpected token at '%s'", this.b, aVar.I());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.merge.q1.p L() {
        /*
            Method dump skipped, instructions count: 1166
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.q1.v.L():com.github.catvod.spider.merge.q1.p");
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    public final String toString() {
        return this.b;
    }

    public final int z() {
        String strTrim = A().trim();
        boolean z = false;
        if (strTrim != null && strTrim.length() != 0) {
            int length = strTrim.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                if (!com.github.catvod.spider.merge.n1.i.g(strTrim.charAt(i))) {
                    break;
                }
                i++;
            }
        }
        c2.H("Index must be numeric", z);
        return Integer.parseInt(strTrim);
    }
}
