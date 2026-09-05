package com.github.catvod.spider.jdollar.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k implements Collector {
    public final Supplier a;
    public final BiConsumer b;
    public final BinaryOperator c;
    public final Function d;
    public final Set e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
        this(supplier, biConsumer, binaryOperator, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(26), set);
        Set set2 = Collectors.a;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final BiConsumer accumulator() {
        return this.b;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final Set characteristics() {
        return this.e;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final BinaryOperator combiner() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final Function finisher() {
        return this.d;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Collector
    public final Supplier supplier() {
        return this.a;
    }

    public k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
        this.a = supplier;
        this.b = biConsumer;
        this.c = binaryOperator;
        this.d = function;
        this.e = set;
    }
}
