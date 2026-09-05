package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a5 extends d5 {
    public final /* synthetic */ int m;
    public final /* synthetic */ Function n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a5(e5 e5Var, int i, Function function, int i2) {
        super(e5Var, i);
        this.m = i2;
        this.n = function;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final m5 N(int i, m5 m5Var) {
        switch (this.m) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new m(this, m5Var, 3);
            default:
                return new l(this, m5Var);
        }
    }
}
