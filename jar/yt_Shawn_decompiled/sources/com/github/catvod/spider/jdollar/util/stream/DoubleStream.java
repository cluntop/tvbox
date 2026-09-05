package com.github.catvod.spider.jdollar.util.stream;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface DoubleStream extends BaseStream<Double, DoubleStream> {
    boolean A();

    DoubleStream a();

    com.github.catvod.spider.jdollar.util.b0 average();

    DoubleStream b();

    Stream boxed();

    DoubleStream c();

    Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    long count();

    DoubleStream d(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar);

    DoubleStream distinct();

    DoubleStream e();

    com.github.catvod.spider.jdollar.util.b0 findAny();

    com.github.catvod.spider.jdollar.util.b0 findFirst();

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    Iterator<Double> iterator();

    boolean l();

    DoubleStream limit(long j);

    Stream mapToObj(DoubleFunction doubleFunction);

    com.github.catvod.spider.jdollar.util.b0 max();

    com.github.catvod.spider.jdollar.util.b0 min();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    DoubleStream parallel();

    DoubleStream peek(DoubleConsumer doubleConsumer);

    double reduce(double d, DoubleBinaryOperator doubleBinaryOperator);

    com.github.catvod.spider.jdollar.util.b0 reduce(DoubleBinaryOperator doubleBinaryOperator);

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    DoubleStream sequential();

    DoubleStream skip(long j);

    DoubleStream sorted();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    com.github.catvod.spider.jdollar.util.r0 spliterator();

    double sum();

    com.github.catvod.spider.jdollar.util.x summaryStatistics();

    boolean t();

    double[] toArray();

    LongStream u();

    IntStream x();
}
