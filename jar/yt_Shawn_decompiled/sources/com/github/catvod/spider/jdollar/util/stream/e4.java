package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoubleBinaryOperator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e4 extends v3 {
    public final /* synthetic */ DoubleBinaryOperator h;
    public final /* synthetic */ double i;

    public e4(c7 c7Var, DoubleBinaryOperator doubleBinaryOperator, double d) {
        this.h = doubleBinaryOperator;
        this.i = d;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3
    public final q4 Y() {
        return new z3(this.i, this.h);
    }
}
