package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i6 extends c5 {
    public final boolean m;
    public final Comparator n;

    public i6(e5 e5Var, Comparator comparator) {
        super(e5Var, b7.q | b7.p);
        this.m = false;
        this.n = (Comparator) Objects.requireNonNull(comparator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 K(a aVar, Spliterator spliterator, IntFunction intFunction) {
        if (b7.SORTED.o(aVar.f) && this.m) {
            return aVar.p(spliterator, false, intFunction);
        }
        Object[] objArrQ = aVar.p(spliterator, true, intFunction).q(intFunction);
        Arrays.sort(objArrQ, this.n);
        return new j2(objArrQ);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        Objects.requireNonNull(m5Var);
        if (b7.SORTED.o(i) && this.m) {
            return m5Var;
        }
        boolean zO = b7.SIZED.o(i);
        Comparator comparator = this.n;
        return zO ? new n6(m5Var, comparator) : new j6(m5Var, comparator);
    }

    public i6(e5 e5Var) {
        super(e5Var, b7.q | b7.o);
        this.m = true;
        this.n = com.github.catvod.spider.jdollar.util.f.INSTANCE;
    }
}
