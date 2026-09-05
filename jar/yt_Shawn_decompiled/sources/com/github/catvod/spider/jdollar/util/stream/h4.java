package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.stream.Collector;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h4 extends v3 {
    public final /* synthetic */ BinaryOperator h;
    public final /* synthetic */ BiConsumer i;
    public final /* synthetic */ Supplier j;
    public final /* synthetic */ Collector k;

    public h4(c7 c7Var, BinaryOperator binaryOperator, BiConsumer biConsumer, Supplier supplier, Collector collector) {
        this.h = binaryOperator;
        this.i = biConsumer;
        this.j = supplier;
        this.k = collector;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3
    public final q4 Y() {
        return new i4(this.j, this.i, this.h);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.v3, com.github.catvod.spider.jdollar.util.stream.n8
    public final int f() {
        if (this.k.characteristics().contains(Collector.Characteristics.UNORDERED)) {
            return b7.r;
        }
        return 0;
    }
}
