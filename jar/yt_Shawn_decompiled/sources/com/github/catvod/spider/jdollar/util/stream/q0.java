package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q0 extends CountedCompleter {
    public final a a;
    public Spliterator b;
    public final long c;
    public final ConcurrentHashMap d;
    public final p0 e;
    public final q0 f;
    public g2 g;

    public q0(a aVar, Spliterator spliterator, p0 p0Var) {
        super(null);
        this.a = aVar;
        this.b = spliterator;
        this.c = d.e(spliterator.estimateSize());
        this.d = new ConcurrentHashMap(Math.max(16, d.g << 1), 1);
        this.e = p0Var;
        this.f = null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.b;
        long j = this.c;
        boolean z = false;
        q0 q0Var = this;
        while (spliterator.estimateSize() > j && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            q0 q0Var2 = new q0(q0Var, spliteratorTrySplit, q0Var.f);
            q0 q0Var3 = new q0(q0Var, spliterator, q0Var2);
            q0Var.addToPendingCount(1);
            q0Var3.addToPendingCount(1);
            q0Var.d.put(q0Var2, q0Var3);
            if (q0Var.f != null) {
                q0Var2.addToPendingCount(1);
                if (q0Var.d.replace(q0Var.f, q0Var, q0Var2)) {
                    q0Var.addToPendingCount(-1);
                } else {
                    q0Var2.addToPendingCount(-1);
                }
            }
            if (z) {
                spliterator = spliteratorTrySplit;
                q0Var = q0Var2;
                q0Var2 = q0Var3;
            } else {
                q0Var = q0Var3;
            }
            z = !z;
            q0Var2.fork();
        }
        if (q0Var.getPendingCount() > 0) {
            j jVar = new j(25);
            a aVar = q0Var.a;
            y1 y1VarJ = aVar.J(aVar.F(spliterator), jVar);
            q0Var.a.R(spliterator, y1VarJ);
            q0Var.g = y1VarJ.build();
            q0Var.b = null;
        }
        q0Var.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        g2 g2Var = this.g;
        if (g2Var != null) {
            g2Var.forEach(this.e);
            this.g = null;
        } else {
            Spliterator spliterator = this.b;
            if (spliterator != null) {
                this.a.R(spliterator, this.e);
                this.b = null;
            }
        }
        q0 q0Var = (q0) this.d.g(this, null, null);
        if (q0Var != null) {
            q0Var.tryComplete();
        }
    }

    public q0(q0 q0Var, Spliterator spliterator, q0 q0Var2) {
        super(q0Var);
        this.a = q0Var.a;
        this.b = spliterator;
        this.c = q0Var.c;
        this.d = q0Var.d;
        this.e = q0Var.e;
        this.f = q0Var2;
    }
}
