package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c1 implements java.util.stream.IntStream {
    public final /* synthetic */ IntStream a;

    public /* synthetic */ c1(IntStream intStream) {
        this.a = intStream;
    }

    public static /* synthetic */ java.util.stream.IntStream g(IntStream intStream) {
        if (intStream == null) {
            return null;
        }
        return intStream instanceof b1 ? ((b1) intStream).a : new c1(intStream);
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
        return this.a.o();
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
        return this.a.w();
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.DoubleStream asDoubleStream() {
        return c0.g(this.a.asDoubleStream());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.LongStream asLongStream() {
        return m1.g(this.a.asLongStream());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ OptionalDouble average() {
        return com.github.catvod.spider.jdollar.time.chrono.m.x(this.a.average());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.Stream boxed() {
        return Stream.Wrapper.convert(this.a.boxed());
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() throws Exception {
        this.a.close();
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objIntConsumer, biConsumer);
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.IntStream distinct() {
        return g(this.a.distinct());
    }

    public final /* synthetic */ java.util.stream.IntStream dropWhile(IntPredicate intPredicate) {
        return g(this.a.c());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        IntStream intStream = this.a;
        if (obj instanceof c1) {
            obj = ((c1) obj).a;
        }
        return intStream.equals(obj);
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.IntStream filter(IntPredicate intPredicate) {
        return g(this.a.b());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ OptionalInt findAny() {
        return com.github.catvod.spider.jdollar.time.chrono.m.y(this.a.findAny());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ OptionalInt findFirst() {
        return com.github.catvod.spider.jdollar.time.chrono.m.y(this.a.findFirst());
    }

    @Override // java.util.stream.IntStream
    public final java.util.stream.IntStream flatMap(IntFunction intFunction) {
        IntStream intStream = this.a;
        k0 k0Var = new k0();
        k0Var.a = intFunction;
        return g(intStream.r(k0Var));
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ void forEach(IntConsumer intConsumer) {
        this.a.forEach(intConsumer);
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
        this.a.forEachOrdered(intConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfInt] */
    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Iterator<Integer> iterator2() {
        ?? it = this.a.iterator2();
        if (it == 0) {
            return null;
        }
        return it instanceof com.github.catvod.spider.jdollar.util.i0 ? ((com.github.catvod.spider.jdollar.util.i0) it).a : new com.github.catvod.spider.jdollar.util.j0(it);
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.IntStream limit(long j) {
        return g(this.a.limit(j));
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
        return g(this.a.map(intUnaryOperator));
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
        return c0.g(this.a.f());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.LongStream mapToLong(IntToLongFunction intToLongFunction) {
        return m1.g(this.a.i());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.Stream mapToObj(IntFunction intFunction) {
        return Stream.Wrapper.convert(this.a.mapToObj(intFunction));
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ OptionalInt max() {
        return com.github.catvod.spider.jdollar.time.chrono.m.y(this.a.max());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ OptionalInt min() {
        return com.github.catvod.spider.jdollar.time.chrono.m.y(this.a.min());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
        return this.a.s();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
        return f.g(this.a.onClose(runnable));
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream parallel() {
        return f.g(this.a.parallel());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.IntStream peek(IntConsumer intConsumer) {
        return g(this.a.peek(intConsumer));
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.y(this.a.reduce(intBinaryOperator));
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream sequential() {
        return f.g(this.a.sequential());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.IntStream skip(long j) {
        return g(this.a.skip(j));
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ java.util.stream.IntStream sorted() {
        return g(this.a.sorted());
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ Spliterator<Integer> spliterator() {
        return com.github.catvod.spider.jdollar.util.t0.a(this.a.spliterator());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ int sum() {
        return this.a.sum();
    }

    @Override // java.util.stream.IntStream
    public final IntSummaryStatistics summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
    }

    public final /* synthetic */ java.util.stream.IntStream takeWhile(IntPredicate intPredicate) {
        return g(this.a.a());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ int[] toArray() {
        return this.a.toArray();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream unordered() {
        return f.g(this.a.unordered());
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.IntStream parallel() {
        return g(this.a.parallel());
    }

    @Override // java.util.stream.IntStream
    public final /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
        return this.a.reduce(i, intBinaryOperator);
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.IntStream sequential() {
        return g(this.a.sequential());
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    /* renamed from: spliterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Spliterator<Integer> spliterator2() {
        return Spliterator.Wrapper.convert(this.a.spliterator());
    }

    @Override // java.util.stream.IntStream, java.util.stream.BaseStream
    public final /* synthetic */ Iterator<Integer> iterator() {
        return this.a.iterator2();
    }
}
