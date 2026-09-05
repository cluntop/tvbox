package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a9 extends d {
    public final a h;
    public final IntFunction i;
    public final boolean j;
    public long k;
    public long l;

    public a9(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction) {
        super(aVar2, spliterator);
        this.h = aVar;
        this.i = intFunction;
        this.j = b7.ORDERED.o(aVar2.f);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    @Override // com.github.catvod.spider.jdollar.util.stream.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a() {
        /*
            r5 = this;
            boolean r0 = r5.b()
            if (r0 != 0) goto L1c
            boolean r1 = r5.j
            if (r1 == 0) goto L1c
            com.github.catvod.spider.jdollar.util.stream.b7 r1 = com.github.catvod.spider.jdollar.util.stream.b7.SIZED
            com.github.catvod.spider.jdollar.util.stream.a r2 = r5.h
            int r3 = r2.c
            int r1 = r1.e
            r3 = r3 & r1
            if (r3 != r1) goto L1c
            com.github.catvod.spider.jdollar.util.Spliterator r1 = r5.b
            long r1 = r2.F(r1)
            goto L1e
        L1c:
            r1 = -1
        L1e:
            com.github.catvod.spider.jdollar.util.stream.a r3 = r5.a
            java.util.function.IntFunction r4 = r5.i
            com.github.catvod.spider.jdollar.util.stream.y1 r1 = r3.J(r1, r4)
            com.github.catvod.spider.jdollar.util.stream.a r2 = r5.h
            com.github.catvod.spider.jdollar.util.stream.y8 r2 = (com.github.catvod.spider.jdollar.util.stream.y8) r2
            boolean r3 = r5.j
            if (r3 == 0) goto L32
            if (r0 != 0) goto L32
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            com.github.catvod.spider.jdollar.util.stream.z8 r0 = r2.g(r1, r0)
            com.github.catvod.spider.jdollar.util.stream.a r2 = r5.a
            com.github.catvod.spider.jdollar.util.Spliterator r3 = r5.b
            r2.R(r3, r0)
            com.github.catvod.spider.jdollar.util.stream.g2 r1 = r1.build()
            long r2 = r1.count()
            r5.k = r2
            long r2 = r0.i()
            r5.l = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.stream.a9.a():java.lang.Object");
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final d c(Spliterator spliterator) {
        return new a9(this, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.d;
        if (dVar != null) {
            if (this.j) {
                a9 a9Var = (a9) dVar;
                long j = a9Var.l;
                this.l = j;
                if (j == a9Var.k) {
                    this.l = j + ((a9) this.e).l;
                }
            }
            a9 a9Var2 = (a9) dVar;
            long j2 = a9Var2.k;
            a9 a9Var3 = (a9) this.e;
            this.k = j2 + a9Var3.k;
            g2 g2VarF = a9Var2.k == 0 ? (g2) a9Var3.f : a9Var3.k == 0 ? (g2) a9Var2.f : v3.F(this.h.H(), (g2) ((a9) this.d).f, (g2) ((a9) this.e).f);
            if (b() && this.j) {
                g2VarF = g2VarF.l(this.l, g2VarF.count(), this.i);
            }
            this.f = g2VarF;
        }
        super.onCompletion(countedCompleter);
    }

    public a9(a9 a9Var, Spliterator spliterator) {
        super(a9Var, spliterator);
        this.h = a9Var.h;
        this.i = a9Var.i;
        this.j = a9Var.j;
    }
}
