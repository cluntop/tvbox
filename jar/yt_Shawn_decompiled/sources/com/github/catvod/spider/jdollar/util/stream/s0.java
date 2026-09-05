package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s0 extends g5 {
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.b = i;
        this.c = aVar;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        int i2 = this.b;
        a aVar = this.c;
        m5 m5Var = this.a;
        switch (i2) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                m5Var.accept((m5) ((IntFunction) ((q) aVar).n).apply(i));
                break;
            case 1:
                ((IntConsumer) ((t0) aVar).n).accept(i);
                m5Var.accept(i);
                break;
            default:
                m5Var.accept(((IntUnaryOperator) ((t0) aVar).n).applyAsInt(i));
                break;
        }
    }
}
