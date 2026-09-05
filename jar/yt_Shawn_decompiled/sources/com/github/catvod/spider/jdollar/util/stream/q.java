package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.Consumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class q extends d5 {
    public final /* synthetic */ int m;
    public final /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(e5 e5Var, Consumer consumer) {
        super(e5Var, 0);
        this.m = 3;
        this.n = consumer;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new o(this, m5Var, 0);
            case 1:
                return new s0(this, m5Var, 0);
            case 2:
                return new d1(this, m5Var, 0);
            case 3:
                return new m(this, m5Var, 1);
            default:
                return new m(this, m5Var, 2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.m = i2;
        this.n = obj;
    }
}
