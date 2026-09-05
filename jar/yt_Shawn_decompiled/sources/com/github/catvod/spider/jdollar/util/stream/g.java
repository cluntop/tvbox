package com.github.catvod.spider.jdollar.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Collector {
    public final /* synthetic */ java.util.stream.Collector a;

    public /* synthetic */ g(java.util.stream.Collector collector) {
        this.a = collector;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final /* synthetic */ BiConsumer accumulator() {
        return this.a.accumulator();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final /* synthetic */ Set characteristics() {
        return z6.a(this.a.characteristics());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final /* synthetic */ BinaryOperator combiner() {
        return this.a.combiner();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Collector collector = this.a;
        if (obj instanceof g) {
            obj = ((g) obj).a;
        }
        return collector.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final /* synthetic */ Function finisher() {
        return this.a.finisher();
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final /* synthetic */ Supplier supplier() {
        return this.a.supplier();
    }
}
