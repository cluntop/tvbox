package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q8 extends c5 implements y8 {
    public final /* synthetic */ int m;
    public final /* synthetic */ Predicate n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q8(e5 e5Var, int i, Predicate predicate, int i2) {
        super(e5Var, i);
        this.m = i2;
        this.n = predicate;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 K(a aVar, Spliterator spliterator, IntFunction intFunction) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return (g2) new b9(this, aVar, spliterator, intFunction).invoke();
            default:
                return (g2) new a9(this, aVar, spliterator, intFunction).invoke();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator L(a aVar, Spliterator spliterator) {
        int i = 19;
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return b7.ORDERED.o(aVar.f) ? K(aVar, spliterator, new u0(i)).spliterator() : new f9(aVar.T(spliterator), this.n, 1);
            default:
                return b7.ORDERED.o(aVar.f) ? K(aVar, spliterator, new u0(i)).spliterator() : new f9(aVar.T(spliterator), this.n, 0);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new l(this, m5Var);
            default:
                return new r8(this, m5Var, false);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.y8
    public z8 g(y1 y1Var, boolean z) {
        return new r8(this, y1Var, z);
    }
}
