package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class x5 extends b {
    public final a j;
    public final IntFunction k;
    public final long l;
    public final long m;
    public long n;
    public volatile boolean o;

    public x5(x5 x5Var, Spliterator spliterator) {
        super(x5Var, spliterator);
        this.j = x5Var.j;
        this.k = x5Var.k;
        this.l = x5Var.l;
        this.m = x5Var.m;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final Object a() {
        if (b()) {
            b7 b7Var = b7.SIZED;
            a aVar = this.j;
            int i = aVar.c;
            int i2 = b7Var.e;
            y1 y1VarJ = this.j.J((i & i2) == i2 ? aVar.F(this.b) : -1L, this.k);
            m5 m5VarN = this.j.N(this.a.f, y1VarJ);
            a aVar2 = this.a;
            aVar2.n(this.b, aVar2.S(m5VarN));
            return y1VarJ.build();
        }
        y1 y1VarJ2 = this.j.J(-1L, this.k);
        if (this.l == 0) {
            m5 m5VarN2 = this.j.N(this.a.f, y1VarJ2);
            a aVar3 = this.a;
            aVar3.n(this.b, aVar3.S(m5VarN2));
        } else {
            this.a.R(this.b, y1VarJ2);
        }
        g2 g2VarBuild = y1VarJ2.build();
        this.n = g2VarBuild.count();
        this.o = true;
        this.b = null;
        return g2VarBuild;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final d c(Spliterator spliterator) {
        return new x5(this, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.b
    public final void f() {
        this.i = true;
        if (this.o) {
            d(v3.H(this.j.H()));
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.b
    public final Object h() {
        return v3.H(this.j.H());
    }

    public final long j(long j) {
        if (this.o) {
            return this.n;
        }
        x5 x5Var = (x5) this.d;
        x5 x5Var2 = (x5) this.e;
        if (x5Var == null || x5Var2 == null) {
            return this.n;
        }
        long j2 = x5Var.j(j);
        return j2 >= j ? j2 : x5Var2.j(j) + j2;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        x5 x5Var;
        g2 g2VarH;
        d dVar = this.d;
        if (dVar != null) {
            this.n = ((x5) dVar).n + ((x5) this.e).n;
            if (this.i) {
                this.n = 0L;
                g2VarH = v3.H(this.j.H());
            } else {
                g2VarH = this.n == 0 ? v3.H(this.j.H()) : ((x5) this.d).n == 0 ? (g2) ((x5) this.e).i() : v3.F(this.j.H(), (g2) ((x5) this.d).i(), (g2) ((x5) this.e).i());
            }
            g2 g2VarL = g2VarH;
            if (b()) {
                g2VarL = g2VarL.l(this.l, this.m >= 0 ? Math.min(g2VarL.count(), this.l + this.m) : this.n, this.k);
            }
            d(g2VarL);
            this.o = true;
        }
        if (this.m >= 0 && !b()) {
            long j = this.l + this.m;
            long j2 = this.o ? this.n : j(j);
            if (j2 >= j) {
                g();
            } else {
                x5 x5Var2 = (x5) ((d) getCompleter());
                x5 x5Var3 = this;
                while (true) {
                    if (x5Var2 == null) {
                        if (j2 >= j) {
                            break;
                        }
                    } else {
                        if (x5Var3 == x5Var2.e && (x5Var = (x5) x5Var2.d) != null) {
                            long j3 = x5Var.j(j) + j2;
                            if (j3 >= j) {
                                break;
                            } else {
                                j2 = j3;
                            }
                        }
                        x5Var3 = x5Var2;
                        x5Var2 = (x5) ((d) x5Var2.getCompleter());
                    }
                }
                g();
            }
        }
        super.onCompletion(countedCompleter);
    }

    public x5(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction, long j, long j2) {
        super(aVar2, spliterator);
        this.j = aVar;
        this.k = intFunction;
        this.l = j;
        this.m = j2;
    }
}
