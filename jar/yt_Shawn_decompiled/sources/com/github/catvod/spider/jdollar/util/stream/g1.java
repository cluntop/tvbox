package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.LongConsumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g1 extends j1 {
    public final /* synthetic */ int m;
    public final /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(k1 k1Var, LongConsumer longConsumer) {
        super(k1Var, 0);
        this.m = 1;
        this.n = longConsumer;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new f1(this, m5Var);
            case 1:
                return new d1(this, m5Var, 1);
            case 2:
                return new y4(this, m5Var);
            default:
                return new m(this, m5Var, 5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.m = i2;
        this.n = obj;
    }
}
