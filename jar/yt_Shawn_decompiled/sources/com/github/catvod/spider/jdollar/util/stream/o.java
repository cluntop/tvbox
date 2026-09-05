package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o extends f5 {
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.b = i;
        this.c = aVar;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        int i = this.b;
        m5 m5Var = this.a;
        a aVar = this.c;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                m5Var.accept((m5) ((DoubleFunction) ((q) aVar).n).apply(d));
                break;
            default:
                ((DoubleConsumer) ((w) aVar).n).accept(d);
                m5Var.accept(d);
                break;
        }
    }
}
