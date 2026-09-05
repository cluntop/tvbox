package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.Supplier;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class n1 implements Supplier {
    public final /* synthetic */ int a;
    public final /* synthetic */ t1 b;

    public /* synthetic */ n1(t1 t1Var, int i) {
        this.a = i;
        this.b = t1Var;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new q1(this.b);
            case 1:
                return new p1(this.b);
            default:
                return new r1(this.b);
        }
    }
}
