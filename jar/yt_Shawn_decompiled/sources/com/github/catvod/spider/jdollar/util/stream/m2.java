package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class m2 extends d {
    public final a h;
    public final LongFunction i;
    public final BinaryOperator j;

    public m2(m2 m2Var, Spliterator spliterator) {
        super(m2Var, spliterator);
        this.h = m2Var.h;
        this.i = m2Var.i;
        this.j = m2Var.j;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    public d c(Spliterator spliterator) {
        return new m2(this, spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final g2 a() {
        y1 y1Var = (y1) this.i.apply(this.h.F(this.b));
        this.h.R(this.b, y1Var);
        return y1Var.build();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.d;
        if (dVar != null) {
            this.f = (g2) this.j.apply((g2) ((m2) dVar).f, (g2) ((m2) this.e).f);
        }
        super.onCompletion(countedCompleter);
    }

    public m2(a aVar, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator) {
        super(aVar, spliterator);
        this.h = aVar;
        this.i = longFunction;
        this.j = binaryOperator;
    }
}
