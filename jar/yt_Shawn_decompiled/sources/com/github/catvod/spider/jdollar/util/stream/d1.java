package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d1 extends h5 {
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d1(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.b = i;
        this.c = aVar;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        int i = this.b;
        m5 m5Var = this.a;
        a aVar = this.c;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                m5Var.accept((m5) ((LongFunction) ((q) aVar).n).apply(j));
                break;
            default:
                ((LongConsumer) ((g1) aVar).n).accept(j);
                m5Var.accept(j);
                break;
        }
    }
}
