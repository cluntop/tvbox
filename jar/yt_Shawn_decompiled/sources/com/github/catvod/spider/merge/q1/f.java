package com.github.catvod.spider.merge.q1;

import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ p b;
    public final /* synthetic */ com.github.catvod.spider.merge.o1.n c;

    public /* synthetic */ f(p pVar, com.github.catvod.spider.merge.o1.n nVar, int i) {
        this.a = i;
        this.b = pVar;
        this.c = nVar;
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.a;
        return Predicate$CC.$default$and(this, predicate);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        switch (this.a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.a;
        com.github.catvod.spider.merge.o1.n nVar = this.c;
        p pVar = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return pVar.b(nVar, (com.github.catvod.spider.merge.o1.n) obj);
            default:
                return pVar.d(nVar, (com.github.catvod.spider.merge.o1.s) obj);
        }
    }
}
