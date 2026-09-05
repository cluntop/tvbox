package com.github.catvod.spider.jdollar.util.stream;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface IntStream extends BaseStream<Integer, IntStream> {
    IntStream a();

    DoubleStream asDoubleStream();

    LongStream asLongStream();

    com.github.catvod.spider.jdollar.util.b0 average();

    IntStream b();

    Stream boxed();

    IntStream c();

    Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer);

    long count();

    IntStream distinct();

    DoubleStream f();

    com.github.catvod.spider.jdollar.util.c0 findAny();

    com.github.catvod.spider.jdollar.util.c0 findFirst();

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    LongStream i();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    Iterator<Integer> iterator();

    IntStream limit(long j);

    IntStream map(IntUnaryOperator intUnaryOperator);

    Stream mapToObj(IntFunction intFunction);

    com.github.catvod.spider.jdollar.util.c0 max();

    com.github.catvod.spider.jdollar.util.c0 min();

    boolean o();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    IntStream r(k0 k0Var);

    int reduce(int i, IntBinaryOperator intBinaryOperator);

    com.github.catvod.spider.jdollar.util.c0 reduce(IntBinaryOperator intBinaryOperator);

    boolean s();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    IntStream sequential();

    IntStream skip(long j);

    IntStream sorted();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    com.github.catvod.spider.jdollar.util.u0 spliterator();

    int sum();

    com.github.catvod.spider.jdollar.util.y summaryStatistics();

    int[] toArray();

    boolean w();
}
