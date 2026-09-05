package com.github.catvod.spider.merge.p1;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum e extends b0 {
    public e() {
        super("InColumnGroup", 11);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
    @Override // com.github.catvod.spider.merge.p1.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(com.github.catvod.spider.merge.p1.r0 r11, com.github.catvod.spider.merge.p1.b r12) {
        /*
            r10 = this;
            boolean r0 = com.github.catvod.spider.merge.p1.b0.a(r11)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Le
            com.github.catvod.spider.merge.p1.j0 r11 = (com.github.catvod.spider.merge.p1.j0) r11
            r12.u(r11, r1)
            return r2
        Le:
            int r0 = r11.a
            int r0 = com.github.catvod.spider.merge.u.o.d(r0)
            if (r0 == 0) goto Lb7
            java.lang.String r3 = "template"
            java.lang.String r4 = "html"
            r5 = 2
            com.github.catvod.spider.merge.p1.u r6 = com.github.catvod.spider.merge.p1.b0.d
            if (r0 == r2) goto L71
            if (r0 == r5) goto L3e
            r1 = 3
            if (r0 == r1) goto L38
            r1 = 6
            if (r0 == r1) goto L2c
            boolean r11 = r10.e(r11, r12)
            return r11
        L2c:
            boolean r0 = r12.i(r4)
            if (r0 == 0) goto L33
            return r2
        L33:
            boolean r11 = r10.e(r11, r12)
            return r11
        L38:
            com.github.catvod.spider.merge.p1.k0 r11 = (com.github.catvod.spider.merge.p1.k0) r11
            r12.w(r11)
            return r2
        L3e:
            r0 = r11
            com.github.catvod.spider.merge.p1.n0 r0 = (com.github.catvod.spider.merge.p1.n0) r0
            java.lang.String r0 = r0.l()
            r0.getClass()
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L6d
            java.lang.String r3 = "colgroup"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L5b
            boolean r11 = r10.e(r11, r12)
            return r11
        L5b:
            boolean r11 = r12.i(r0)
            if (r11 != 0) goto L65
            r12.k(r10)
            return r1
        L65:
            r12.F()
            com.github.catvod.spider.merge.p1.z r11 = com.github.catvod.spider.merge.p1.b0.i
            r12.l = r11
            return r2
        L6d:
            r6.d(r11, r12)
            return r2
        L71:
            r0 = r11
            com.github.catvod.spider.merge.p1.o0 r0 = (com.github.catvod.spider.merge.p1.o0) r0
            java.lang.String r7 = r0.l()
            r7.getClass()
            int r8 = r7.hashCode()
            r9 = -1
            switch(r8) {
                case -1321546630: goto L99;
                case 98688: goto L8e;
                case 3213227: goto L85;
                default: goto L83;
            }
        L83:
            r1 = -1
            goto La0
        L85:
            boolean r1 = r7.equals(r4)
            if (r1 != 0) goto L8c
            goto L83
        L8c:
            r1 = 2
            goto La0
        L8e:
            java.lang.String r1 = "col"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L97
            goto L83
        L97:
            r1 = 1
            goto La0
        L99:
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto La0
            goto L83
        La0:
            switch(r1) {
                case 0: goto Lb3;
                case 1: goto Laf;
                case 2: goto La8;
                default: goto La3;
            }
        La3:
            boolean r11 = r10.e(r11, r12)
            return r11
        La8:
            com.github.catvod.spider.merge.p1.x r0 = com.github.catvod.spider.merge.p1.b0.g
            boolean r11 = r0.d(r11, r12)
            return r11
        Laf:
            r12.y(r0)
            return r2
        Lb3:
            r6.d(r11, r12)
            return r2
        Lb7:
            r12.k(r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.p1.e.d(com.github.catvod.spider.merge.p1.r0, com.github.catvod.spider.merge.p1.b):boolean");
    }

    public final boolean e(r0 r0Var, b bVar) {
        if (!bVar.i("colgroup")) {
            bVar.k(this);
            return false;
        }
        bVar.F();
        bVar.l = b0.i;
        bVar.I(r0Var);
        return true;
    }
}
