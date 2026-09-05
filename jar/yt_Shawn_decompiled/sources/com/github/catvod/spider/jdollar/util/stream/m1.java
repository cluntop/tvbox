package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import java.util.Iterator;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class m1 implements java.util.stream.LongStream {
    public final /* synthetic */ LongStream a;

    public /* synthetic */ m1(LongStream longStream) {
        this.a = longStream;
    }

    public static /* synthetic */ java.util.stream.LongStream g(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof l1 ? ((l1) longStream).a : new m1(longStream);
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ boolean allMatch(LongPredicate longPredicate) {
        return this.a.v();
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ boolean anyMatch(LongPredicate longPredicate) {
        return this.a.q();
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.DoubleStream asDoubleStream() {
        return c0.g(this.a.asDoubleStream());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ OptionalDouble average() {
        return com.github.catvod.spider.jdollar.time.chrono.m.x(this.a.average());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.Stream boxed() {
        return Stream.Wrapper.convert(this.a.boxed());
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() throws Exception {
        this.a.close();
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objLongConsumer, biConsumer);
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.LongStream distinct() {
        return g(this.a.distinct());
    }

    public final /* synthetic */ java.util.stream.LongStream dropWhile(LongPredicate longPredicate) {
        return g(this.a.c());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        LongStream longStream = this.a;
        if (obj instanceof m1) {
            obj = ((m1) obj).a;
        }
        return longStream.equals(obj);
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.LongStream filter(LongPredicate longPredicate) {
        return g(this.a.b());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ OptionalLong findAny() {
        return com.github.catvod.spider.jdollar.time.chrono.m.z(this.a.findAny());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ OptionalLong findFirst() {
        return com.github.catvod.spider.jdollar.time.chrono.m.z(this.a.findFirst());
    }

    @Override // java.util.stream.LongStream
    public final java.util.stream.LongStream flatMap(LongFunction longFunction) {
        LongStream longStream = this.a;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(12);
        gVar.b = longFunction;
        return g(longStream.d(gVar));
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.a.forEach(longConsumer);
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.a.forEachOrdered(longConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfLong] */
    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Iterator<Long> iterator2() {
        ?? it = this.a.iterator2();
        if (it == 0) {
            return null;
        }
        return it instanceof com.github.catvod.spider.jdollar.util.l0 ? ((com.github.catvod.spider.jdollar.util.l0) it).a : new com.github.catvod.spider.jdollar.util.m0(it);
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.LongStream limit(long j) {
        return g(this.a.limit(j));
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.LongStream map(LongUnaryOperator longUnaryOperator) {
        return g(this.a.e());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
        return c0.g(this.a.h());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.IntStream mapToInt(LongToIntFunction longToIntFunction) {
        return c1.g(this.a.y());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.Stream mapToObj(LongFunction longFunction) {
        return Stream.Wrapper.convert(this.a.mapToObj(longFunction));
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ OptionalLong max() {
        return com.github.catvod.spider.jdollar.time.chrono.m.z(this.a.max());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ OptionalLong min() {
        return com.github.catvod.spider.jdollar.time.chrono.m.z(this.a.min());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ boolean noneMatch(LongPredicate longPredicate) {
        return this.a.j();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
        return f.g(this.a.onClose(runnable));
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream parallel() {
        return f.g(this.a.parallel());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.LongStream peek(LongConsumer longConsumer) {
        return g(this.a.peek(longConsumer));
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.z(this.a.reduce(longBinaryOperator));
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream sequential() {
        return f.g(this.a.sequential());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.LongStream skip(long j) {
        return g(this.a.skip(j));
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ java.util.stream.LongStream sorted() {
        return g(this.a.sorted());
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ Spliterator<Long> spliterator() {
        return com.github.catvod.spider.jdollar.util.w0.a(this.a.spliterator());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ long sum() {
        return this.a.sum();
    }

    @Override // java.util.stream.LongStream
    public final LongSummaryStatistics summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics");
    }

    public final /* synthetic */ java.util.stream.LongStream takeWhile(LongPredicate longPredicate) {
        return g(this.a.a());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ long[] toArray() {
        return this.a.toArray();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream unordered() {
        return f.g(this.a.unordered());
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.LongStream parallel() {
        return g(this.a.parallel());
    }

    @Override // java.util.stream.LongStream
    public final /* synthetic */ long reduce(long j, LongBinaryOperator longBinaryOperator) {
        return this.a.reduce(j, longBinaryOperator);
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.LongStream sequential() {
        return g(this.a.sequential());
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    /* renamed from: spliterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Spliterator<Long> spliterator2() {
        return Spliterator.Wrapper.convert(this.a.spliterator());
    }

    @Override // java.util.stream.LongStream, java.util.stream.BaseStream
    public final /* synthetic */ Iterator<Long> iterator() {
        return this.a.iterator2();
    }
}
