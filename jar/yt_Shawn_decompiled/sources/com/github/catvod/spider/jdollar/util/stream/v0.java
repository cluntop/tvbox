package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v0 extends g5 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v0(int i, m5 m5Var) {
        super(m5Var);
        this.b = i;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.a.accept(i);
                return;
            case 1:
                this.a.accept(i);
                return;
            case 2:
                IntToLongFunction intToLongFunction = null;
                intToLongFunction.applyAsLong(i);
                throw null;
            case 3:
                IntToDoubleFunction intToDoubleFunction = null;
                intToDoubleFunction.applyAsDouble(i);
                throw null;
            default:
                IntPredicate intPredicate = null;
                intPredicate.test(i);
                throw null;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g5, com.github.catvod.spider.jdollar.util.stream.m5
    public void c(long j) {
        switch (this.b) {
            case 4:
                this.a.c(-1L);
                break;
            default:
                super.c(j);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v0(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.b = i;
    }
}
