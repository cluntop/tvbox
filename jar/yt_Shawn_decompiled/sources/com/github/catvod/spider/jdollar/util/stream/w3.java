package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.LongBinaryOperator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w3 extends v3 {
    public final /* synthetic */ LongBinaryOperator h;
    public final /* synthetic */ long i;

    public w3(c7 c7Var, LongBinaryOperator longBinaryOperator, long j) {
        this.h = longBinaryOperator;
        this.i = j;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3
    public final q4 Y() {
        return new o4(this.i, this.h);
    }
}
