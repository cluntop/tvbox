package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class x4 extends d {
    public final v3 h;

    public x4(x4 x4Var, Spliterator spliterator) {
        super(x4Var, spliterator);
        this.h = x4Var.h;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final Object a() {
        a aVar = this.a;
        q4 q4VarY = this.h.Y();
        aVar.R(this.b, q4VarY);
        return q4VarY;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public final d c(Spliterator spliterator) {
        return new x4(this, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.d;
        if (dVar != null) {
            q4 q4Var = (q4) ((x4) dVar).f;
            q4Var.j((q4) ((x4) this.e).f);
            this.f = q4Var;
        }
        super.onCompletion(countedCompleter);
    }

    public x4(v3 v3Var, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.h = v3Var;
    }
}
