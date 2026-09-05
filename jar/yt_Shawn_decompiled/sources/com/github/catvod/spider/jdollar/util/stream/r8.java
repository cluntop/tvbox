package com.github.catvod.spider.jdollar.util.stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r8 extends i5 implements z8 {
    public long b;
    public boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ q8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r8(q8 q8Var, m5 m5Var, boolean z) {
        super(m5Var);
        this.e = q8Var;
        this.d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // java.util.function.Consumer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void accept(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r6.c
            if (r0 != 0) goto L15
            com.github.catvod.spider.jdollar.util.stream.q8 r0 = r6.e
            java.util.function.Predicate r0 = r0.n
            boolean r0 = r0.test(r7)
            r1 = r0 ^ 1
            r6.c = r1
            if (r0 != 0) goto L13
            goto L15
        L13:
            r0 = 0
            goto L16
        L15:
            r0 = 1
        L16:
            boolean r1 = r6.d
            if (r1 == 0) goto L23
            if (r0 != 0) goto L23
            long r2 = r6.b
            r4 = 1
            long r2 = r2 + r4
            r6.b = r2
        L23:
            if (r1 != 0) goto L29
            if (r0 == 0) goto L28
            goto L29
        L28:
            return
        L29:
            com.github.catvod.spider.jdollar.util.stream.m5 r0 = r6.a
            r0.accept(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.stream.r8.accept(java.lang.Object):void");
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.z8
    public final long i() {
        return this.b;
    }
}
