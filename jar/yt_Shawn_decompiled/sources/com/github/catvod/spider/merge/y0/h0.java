package com.github.catvod.spider.merge.y0;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h0 implements r0 {
    public final l a;
    public final j b;
    public m0 c;
    public int d;
    public boolean e;
    public long f;

    public h0(l lVar) {
        this.a = lVar;
        j jVarA = lVar.a();
        this.b = jVarA;
        m0 m0Var = jVarA.a;
        this.c = m0Var;
        this.d = m0Var != null ? m0Var.b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r3 == r5.b) goto L15;
     */
    @Override // com.github.catvod.spider.merge.y0.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long read(com.github.catvod.spider.merge.y0.j r9, long r10) {
        /*
            r8 = this;
            r9.getClass()
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L65
            boolean r3 = r8.e
            if (r3 != 0) goto L5f
            com.github.catvod.spider.merge.y0.m0 r3 = r8.c
            com.github.catvod.spider.merge.y0.j r4 = r8.b
            if (r3 == 0) goto L27
            com.github.catvod.spider.merge.y0.m0 r5 = r4.a
            if (r3 != r5) goto L21
            int r3 = r8.d
            r5.getClass()
            int r5 = r5.b
            if (r3 != r5) goto L21
            goto L27
        L21:
            java.lang.String r9 = "Peek source is invalid because upstream source was used"
            com.github.catvod.spider.merge.s0.a.h(r9)
            return r0
        L27:
            if (r2 != 0) goto L2a
            return r0
        L2a:
            long r0 = r8.f
            r2 = 1
            long r0 = r0 + r2
            com.github.catvod.spider.merge.y0.l r2 = r8.a
            boolean r0 = r2.request(r0)
            if (r0 != 0) goto L3a
            r9 = -1
            return r9
        L3a:
            com.github.catvod.spider.merge.y0.m0 r0 = r8.c
            if (r0 != 0) goto L48
            com.github.catvod.spider.merge.y0.m0 r0 = r4.a
            if (r0 == 0) goto L48
            r8.c = r0
            int r0 = r0.b
            r8.d = r0
        L48:
            long r0 = r4.b
            long r2 = r8.f
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            com.github.catvod.spider.merge.y0.j r2 = r8.b
            long r4 = r8.f
            r3 = r9
            r2.z(r3, r4, r6)
            long r9 = r8.f
            long r9 = r9 + r6
            r8.f = r9
            return r6
        L5f:
            java.lang.String r9 = "closed"
            com.github.catvod.spider.merge.s0.a.h(r9)
            return r0
        L65:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = com.github.catvod.spider.merge.b.b.m(r9, r10)
            com.github.catvod.spider.merge.s0.a.e(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.y0.h0.read(com.github.catvod.spider.merge.y0.j, long):long");
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final u0 timeout() {
        return this.a.timeout();
    }
}
