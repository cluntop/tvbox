package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoubleConsumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w extends z {
    public final /* synthetic */ int m;
    public final /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(a0 a0Var, DoubleConsumer doubleConsumer) {
        super(a0Var, 0);
        this.m = 1;
        this.n = doubleConsumer;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new v(this, m5Var);
            case 1:
                return new o(this, m5Var, 1);
            case 2:
                return new m(this, m5Var, 6);
            default:
                return new y4(this, m5Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.m = i2;
        this.n = obj;
    }
}
