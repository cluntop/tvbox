package com.github.catvod.spider.jdollar.util.concurrent;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g extends l {
    public final l[] e;

    public g(l[] lVarArr) {
        super(-1, null, null);
        this.e = lVarArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        return r0;
     */
    @Override // com.github.catvod.spider.jdollar.util.concurrent.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.jdollar.util.concurrent.l a(int r4, java.lang.Object r5) {
        /*
            r3 = this;
            com.github.catvod.spider.jdollar.util.concurrent.l[] r0 = r3.e
        L2:
            int r1 = r0.length
            if (r1 == 0) goto L34
            int r1 = r1 + (-1)
            r1 = r1 & r4
            com.github.catvod.spider.jdollar.util.concurrent.l r0 = com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap.k(r0, r1)
            if (r0 != 0) goto Lf
            goto L34
        Lf:
            int r1 = r0.a
            if (r1 != r4) goto L20
            java.lang.Object r2 = r0.b
            if (r2 == r5) goto L1f
            if (r2 == 0) goto L20
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L20
        L1f:
            return r0
        L20:
            if (r1 >= 0) goto L30
            boolean r1 = r0 instanceof com.github.catvod.spider.jdollar.util.concurrent.g
            if (r1 == 0) goto L2b
            com.github.catvod.spider.jdollar.util.concurrent.g r0 = (com.github.catvod.spider.jdollar.util.concurrent.g) r0
            com.github.catvod.spider.jdollar.util.concurrent.l[] r0 = r0.e
            goto L2
        L2b:
            com.github.catvod.spider.jdollar.util.concurrent.l r4 = r0.a(r4, r5)
            return r4
        L30:
            com.github.catvod.spider.jdollar.util.concurrent.l r0 = r0.d
            if (r0 != 0) goto Lf
        L34:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.concurrent.g.a(int, java.lang.Object):com.github.catvod.spider.jdollar.util.concurrent.l");
    }
}
