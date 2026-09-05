package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j0 extends b {
    public final d0 j;
    public final boolean k;

    public j0(j0 j0Var, Spliterator spliterator) {
        super(j0Var, spliterator);
        this.k = j0Var.k;
        this.j = j0Var.j;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final Object a() {
        a aVar = this.a;
        o8 o8Var = (o8) this.j.d.get();
        aVar.R(this.b, o8Var);
        Object obj = o8Var.get();
        if (this.k) {
            if (obj != null) {
                d dVar = this;
                while (dVar != null) {
                    d dVar2 = (d) dVar.getCompleter();
                    if (dVar2 != null && dVar2.d != dVar) {
                        g();
                        return obj;
                    }
                    dVar = dVar2;
                }
                AtomicReference atomicReference = this.h;
                while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
                }
                return obj;
            }
        } else if (obj != null) {
            AtomicReference atomicReference2 = this.h;
            while (!atomicReference2.compareAndSet(null, obj) && atomicReference2.get() == null) {
            }
        }
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final d c(Spliterator spliterator) {
        return new j0(this, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.b
    public final Object h() {
        return this.j.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        if (this.k) {
            j0 j0Var = (j0) this.d;
            j0 j0Var2 = null;
            while (true) {
                if (j0Var != j0Var2) {
                    Object objI = j0Var.i();
                    if (objI != null && this.j.c.test(objI)) {
                        d(objI);
                        d dVar = this;
                        while (true) {
                            if (dVar != null) {
                                d dVar2 = (d) dVar.getCompleter();
                                if (dVar2 != null && dVar2.d != dVar) {
                                    g();
                                    break;
                                }
                                dVar = dVar2;
                            } else {
                                AtomicReference atomicReference = this.h;
                                while (!atomicReference.compareAndSet(null, objI) && atomicReference.get() == null) {
                                }
                            }
                        }
                    } else {
                        j0Var2 = j0Var;
                        j0Var = (j0) this.e;
                    }
                } else {
                    break;
                }
            }
        }
        super.onCompletion(countedCompleter);
    }

    public j0(d0 d0Var, boolean z, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.k = z;
        this.j = d0Var;
    }
}
