package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y3 extends v3 {
    public final /* synthetic */ int h;
    public final /* synthetic */ Object i;

    public /* synthetic */ y3(c7 c7Var, Object obj, int i) {
        this.h = i;
        this.i = obj;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3
    public final q4 Y() {
        switch (this.h) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new p4((LongBinaryOperator) this.i);
            case 1:
                return new b4((DoubleBinaryOperator) this.i);
            case 2:
                return new g4((BinaryOperator) this.i);
            default:
                return new m4((IntBinaryOperator) this.i);
        }
    }
}
