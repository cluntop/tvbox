package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b9 extends b {
    public final a j;
    public final IntFunction k;
    public final boolean l;
    public long m;
    public boolean n;
    public volatile boolean o;

    public b9(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction) {
        super(aVar2, spliterator);
        this.j = aVar;
        this.k = intFunction;
        this.l = b7.ORDERED.o(aVar2.f);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final Object a() {
        y1 y1VarJ = this.a.J(-1L, this.k);
        m5 m5VarN = this.j.N(this.a.f, y1VarJ);
        a aVar = this.a;
        boolean zN = aVar.n(this.b, aVar.S(m5VarN));
        this.n = zN;
        if (zN) {
            g();
        }
        g2 g2VarBuild = y1VarJ.build();
        this.m = g2VarBuild.count();
        return g2VarBuild;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final d c(Spliterator spliterator) {
        return new b9(this, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.b
    public final void f() {
        this.i = true;
        if (this.l && this.o) {
            d(v3.H(this.j.H()));
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.b
    public final Object h() {
        return v3.H(this.j.H());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    @Override // com.github.catvod.spider.jdollar.util.stream.d, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCompletion(java.util.concurrent.CountedCompleter r9) {
        /*
            r8 = this;
            com.github.catvod.spider.jdollar.util.stream.d r0 = r8.d
            if (r0 != 0) goto L6
            goto L8b
        L6:
            com.github.catvod.spider.jdollar.util.stream.b9 r0 = (com.github.catvod.spider.jdollar.util.stream.b9) r0
            boolean r0 = r0.n
            com.github.catvod.spider.jdollar.util.stream.d r1 = r8.e
            com.github.catvod.spider.jdollar.util.stream.b9 r1 = (com.github.catvod.spider.jdollar.util.stream.b9) r1
            boolean r1 = r1.n
            r0 = r0 | r1
            r8.n = r0
            boolean r0 = r8.l
            r1 = 0
            if (r0 == 0) goto L2a
            boolean r0 = r8.i
            if (r0 == 0) goto L2a
            r8.m = r1
            com.github.catvod.spider.jdollar.util.stream.a r0 = r8.j
            com.github.catvod.spider.jdollar.util.stream.c7 r0 = r0.H()
            com.github.catvod.spider.jdollar.util.stream.z2 r0 = com.github.catvod.spider.jdollar.util.stream.v3.H(r0)
            goto L88
        L2a:
            boolean r0 = r8.l
            if (r0 == 0) goto L41
            com.github.catvod.spider.jdollar.util.stream.d r0 = r8.d
            com.github.catvod.spider.jdollar.util.stream.b9 r0 = (com.github.catvod.spider.jdollar.util.stream.b9) r0
            boolean r3 = r0.n
            if (r3 == 0) goto L41
            long r1 = r0.m
            r8.m = r1
            java.lang.Object r0 = r0.i()
            com.github.catvod.spider.jdollar.util.stream.g2 r0 = (com.github.catvod.spider.jdollar.util.stream.g2) r0
            goto L88
        L41:
            com.github.catvod.spider.jdollar.util.stream.d r0 = r8.d
            com.github.catvod.spider.jdollar.util.stream.b9 r0 = (com.github.catvod.spider.jdollar.util.stream.b9) r0
            long r3 = r0.m
            com.github.catvod.spider.jdollar.util.stream.d r5 = r8.e
            com.github.catvod.spider.jdollar.util.stream.b9 r5 = (com.github.catvod.spider.jdollar.util.stream.b9) r5
            long r6 = r5.m
            long r3 = r3 + r6
            r8.m = r3
            long r3 = r0.m
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 != 0) goto L5d
            java.lang.Object r0 = r5.i()
            com.github.catvod.spider.jdollar.util.stream.g2 r0 = (com.github.catvod.spider.jdollar.util.stream.g2) r0
            goto L88
        L5d:
            long r3 = r5.m
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 != 0) goto L6a
            java.lang.Object r0 = r0.i()
            com.github.catvod.spider.jdollar.util.stream.g2 r0 = (com.github.catvod.spider.jdollar.util.stream.g2) r0
            goto L88
        L6a:
            com.github.catvod.spider.jdollar.util.stream.a r0 = r8.j
            com.github.catvod.spider.jdollar.util.stream.c7 r0 = r0.H()
            com.github.catvod.spider.jdollar.util.stream.d r1 = r8.d
            com.github.catvod.spider.jdollar.util.stream.b9 r1 = (com.github.catvod.spider.jdollar.util.stream.b9) r1
            java.lang.Object r1 = r1.i()
            com.github.catvod.spider.jdollar.util.stream.g2 r1 = (com.github.catvod.spider.jdollar.util.stream.g2) r1
            com.github.catvod.spider.jdollar.util.stream.d r2 = r8.e
            com.github.catvod.spider.jdollar.util.stream.b9 r2 = (com.github.catvod.spider.jdollar.util.stream.b9) r2
            java.lang.Object r2 = r2.i()
            com.github.catvod.spider.jdollar.util.stream.g2 r2 = (com.github.catvod.spider.jdollar.util.stream.g2) r2
            com.github.catvod.spider.jdollar.util.stream.i2 r0 = com.github.catvod.spider.jdollar.util.stream.v3.F(r0, r1, r2)
        L88:
            r8.d(r0)
        L8b:
            r0 = 1
            r8.o = r0
            super.onCompletion(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.stream.b9.onCompletion(java.util.concurrent.CountedCompleter):void");
    }

    public b9(b9 b9Var, Spliterator spliterator) {
        super(b9Var, spliterator);
        this.j = b9Var.j;
        this.k = b9Var.k;
        this.l = b9Var.l;
    }
}
