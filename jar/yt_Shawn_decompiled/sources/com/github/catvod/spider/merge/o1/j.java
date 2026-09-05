package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ Class b;

    public /* synthetic */ j(Class cls, int i) {
        this.a = i;
        this.b = cls;
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
        Class cls = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return cls.isInstance((s) obj);
            default:
                return cls.isInstance(obj);
        }
    }
}
