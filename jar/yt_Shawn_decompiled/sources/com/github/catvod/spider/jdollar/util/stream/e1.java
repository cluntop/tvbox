package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e1 extends h5 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(m5 m5Var) {
        super(m5Var);
        this.b = 0;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.a.accept(j);
                return;
            case 1:
                LongUnaryOperator longUnaryOperator = null;
                longUnaryOperator.applyAsLong(j);
                throw null;
            case 2:
                LongToIntFunction longToIntFunction = null;
                longToIntFunction.applyAsInt(j);
                throw null;
            case 3:
                LongToDoubleFunction longToDoubleFunction = null;
                longToDoubleFunction.applyAsDouble(j);
                throw null;
            default:
                LongPredicate longPredicate = null;
                longPredicate.test(j);
                throw null;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
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
    public /* synthetic */ e1(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.b = i;
    }
}
