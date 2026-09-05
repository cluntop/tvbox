package com.github.catvod.spider.jdollar.util.stream;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface LongStream extends BaseStream<Long, LongStream> {
    LongStream a();

    DoubleStream asDoubleStream();

    com.github.catvod.spider.jdollar.util.b0 average();

    LongStream b();

    Stream boxed();

    LongStream c();

    Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    long count();

    LongStream d(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar);

    LongStream distinct();

    LongStream e();

    com.github.catvod.spider.jdollar.util.d0 findAny();

    com.github.catvod.spider.jdollar.util.d0 findFirst();

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    DoubleStream h();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    Iterator<Long> iterator();

    boolean j();

    LongStream limit(long j);

    Stream mapToObj(LongFunction longFunction);

    com.github.catvod.spider.jdollar.util.d0 max();

    com.github.catvod.spider.jdollar.util.d0 min();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    LongStream parallel();

    LongStream peek(LongConsumer longConsumer);

    boolean q();

    long reduce(long j, LongBinaryOperator longBinaryOperator);

    com.github.catvod.spider.jdollar.util.d0 reduce(LongBinaryOperator longBinaryOperator);

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    LongStream sequential();

    LongStream skip(long j);

    LongStream sorted();

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    com.github.catvod.spider.jdollar.util.x0 spliterator();

    long sum();

    com.github.catvod.spider.jdollar.util.a0 summaryStatistics();

    long[] toArray();

    boolean v();

    IntStream y();
}
