package com.github.catvod.spider.merge.o1;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class u extends com.github.catvod.spider.merge.m.d {
    public boolean d;

    public static boolean i(s sVar) {
        return (sVar instanceof z) && com.github.catvod.spider.merge.n1.i.f(((z) sVar).D());
    }

    @Override // com.github.catvod.spider.merge.m.d
    public final void c(n nVar, int i) throws androidx.startup.b, IOException {
        if (k(nVar)) {
            h(i);
        }
        nVar.v((com.github.catvod.spider.merge.n1.a) this.b, (g) this.c);
        if (nVar.d.b(64)) {
            this.d = true;
        }
    }

    @Override // com.github.catvod.spider.merge.m.d
    public final void d(r rVar, int i) throws androidx.startup.b, IOException {
        if (k(rVar)) {
            h(i);
        }
        rVar.v((com.github.catvod.spider.merge.n1.a) this.b, (g) this.c);
    }

    @Override // com.github.catvod.spider.merge.m.d
    public final void e(n nVar, int i) throws androidx.startup.b, IOException {
        s sVarL = nVar.l();
        while (i(sVarL)) {
            sVarL = sVarL.q();
        }
        if (k(sVarL)) {
            h(i);
        }
        nVar.R((com.github.catvod.spider.merge.n1.a) this.b, (g) this.c);
        if (this.d && nVar.d.b(64)) {
            do {
                nVar = nVar.a;
                if (nVar == null) {
                    this.d = false;
                    return;
                }
            } while ((nVar.d.d & 64) == 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    @Override // com.github.catvod.spider.merge.m.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(com.github.catvod.spider.merge.o1.z r5, int r6, int r7) throws androidx.startup.b, java.io.IOException {
        /*
            r4 = this;
            boolean r6 = r4.d
            r0 = 0
            if (r6 != 0) goto L7c
            com.github.catvod.spider.merge.o1.n r6 = r5.a
            boolean r6 = r4.j(r6)
            r1 = 4
            if (r6 != 0) goto L10
            r0 = 4
            goto L61
        L10:
            com.github.catvod.spider.merge.o1.s r6 = r5.y()
            com.github.catvod.spider.merge.o1.s r2 = r5.q()
            boolean r3 = r6 instanceof com.github.catvod.spider.merge.o1.n
            if (r3 == 0) goto L22
            boolean r3 = r4.j(r6)
            if (r3 == 0) goto L30
        L22:
            if (r6 == 0) goto L2e
            boolean r3 = r6 instanceof com.github.catvod.spider.merge.o1.z
            if (r3 != 0) goto L30
            boolean r6 = r4.k(r6)
            if (r6 == 0) goto L30
        L2e:
            r1 = 12
        L30:
            if (r2 == 0) goto L5c
            boolean r6 = r2 instanceof com.github.catvod.spider.merge.o1.z
            if (r6 != 0) goto L3d
            boolean r6 = r4.k(r2)
            if (r6 == 0) goto L3d
            goto L5c
        L3d:
            boolean r6 = i(r2)
            if (r6 == 0) goto L48
            com.github.catvod.spider.merge.o1.s r2 = r2.q()
            goto L3d
        L48:
            boolean r6 = r2 instanceof com.github.catvod.spider.merge.o1.z
            if (r6 == 0) goto L60
            com.github.catvod.spider.merge.o1.r r2 = (com.github.catvod.spider.merge.o1.r) r2
            java.lang.String r6 = r2.D()
            int r6 = r6.codePointAt(r0)
            boolean r6 = com.github.catvod.spider.merge.n1.i.i(r6)
            if (r6 == 0) goto L60
        L5c:
            r6 = r1 | 16
            r0 = r6
            goto L61
        L60:
            r0 = r1
        L61:
            java.lang.String r6 = r5.D()
            boolean r6 = com.github.catvod.spider.merge.n1.i.f(r6)
            if (r6 != 0) goto L7c
            com.github.catvod.spider.merge.o1.n r6 = r5.a
            boolean r6 = r4.j(r6)
            if (r6 == 0) goto L7c
            boolean r6 = r4.k(r5)
            if (r6 == 0) goto L7c
            r4.h(r7)
        L7c:
            super.f(r5, r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.o1.u.f(com.github.catvod.spider.merge.o1.z, int, int):void");
    }

    public boolean j(s sVar) {
        if (sVar != null && (sVar instanceof n)) {
            n nVar = (n) sVar;
            if (!nVar.o("br") && !nVar.Q()) {
                if ((nVar.d.d & 1) == 0) {
                    if (!(nVar.a instanceof h)) {
                        n nVarM = nVar.M();
                        for (int i = 0; i < 5 && nVarM != null; i++) {
                            if (!nVarM.Q() && (nVarM.d.d & 1) != 0) {
                                nVarM = nVarM.p();
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean k(s sVar) {
        if (sVar != null && sVar != ((s) this.a) && !this.d && !i(sVar)) {
            if (j(sVar)) {
                return true;
            }
            s sVarY = sVar.y();
            while (i(sVarY)) {
                sVarY = sVarY.y();
            }
            if (j(sVarY)) {
                return true;
            }
            n nVar = sVar.a;
            if (j(nVar) && !nVar.d.b(8)) {
                s sVarL = nVar.l();
                int i = 0;
                while (true) {
                    if (i >= 5 || sVarL == null) {
                        break;
                    }
                    if (!(sVarL instanceof z)) {
                        if (sVarY == null) {
                            return true;
                        }
                        if ((sVarY instanceof z) || (!j(sVarY) && (sVarY instanceof n))) {
                            break;
                        }
                        return true;
                    }
                    sVarL = sVarL.q();
                    i++;
                }
            }
        }
        return false;
    }
}
