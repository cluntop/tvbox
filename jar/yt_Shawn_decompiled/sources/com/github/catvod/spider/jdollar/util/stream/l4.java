package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntBinaryOperator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l4 extends v3 {
    public final /* synthetic */ IntBinaryOperator h;
    public final /* synthetic */ int i;

    public l4(c7 c7Var, IntBinaryOperator intBinaryOperator, int i) {
        this.h = intBinaryOperator;
        this.i = i;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3
    public final q4 Y() {
        return new k4(this.i, this.h);
    }
}
