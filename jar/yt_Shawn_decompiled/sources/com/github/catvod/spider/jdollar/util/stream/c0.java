package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements java.util.stream.DoubleStream {
    public final /* synthetic */ DoubleStream a;

    public /* synthetic */ c0(DoubleStream doubleStream) {
        this.a = doubleStream;
    }

    public static /* synthetic */ java.util.stream.DoubleStream g(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof b0 ? ((b0) doubleStream).a : new c0(doubleStream);
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
        return this.a.t();
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
        return this.a.l();
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ OptionalDouble average() {
        return com.github.catvod.spider.jdollar.time.chrono.m.x(this.a.average());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.Stream boxed() {
        return Stream.Wrapper.convert(this.a.boxed());
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() throws Exception {
        this.a.close();
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.DoubleStream distinct() {
        return g(this.a.distinct());
    }

    public final /* synthetic */ java.util.stream.DoubleStream dropWhile(DoublePredicate doublePredicate) {
        return g(this.a.c());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        DoubleStream doubleStream = this.a;
        if (obj instanceof c0) {
            obj = ((c0) obj).a;
        }
        return doubleStream.equals(obj);
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.DoubleStream filter(DoublePredicate doublePredicate) {
        return g(this.a.b());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ OptionalDouble findAny() {
        return com.github.catvod.spider.jdollar.time.chrono.m.x(this.a.findAny());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ OptionalDouble findFirst() {
        return com.github.catvod.spider.jdollar.time.chrono.m.x(this.a.findFirst());
    }

    @Override // java.util.stream.DoubleStream
    public final java.util.stream.DoubleStream flatMap(DoubleFunction doubleFunction) {
        DoubleStream doubleStream = this.a;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(10);
        gVar.b = doubleFunction;
        return g(doubleStream.d(gVar));
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.a.forEach(doubleConsumer);
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.github.catvod.spider.jdollar.util.PrimitiveIterator$OfDouble] */
    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Iterator<Double> iterator2() {
        ?? it = this.a.iterator2();
        if (it == 0) {
            return null;
        }
        return it instanceof com.github.catvod.spider.jdollar.util.f0 ? ((com.github.catvod.spider.jdollar.util.f0) it).a : new com.github.catvod.spider.jdollar.util.g0(it);
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.DoubleStream limit(long j) {
        return g(this.a.limit(j));
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
        return g(this.a.e());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
        return c1.g(this.a.x());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        return m1.g(this.a.u());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.Stream mapToObj(DoubleFunction doubleFunction) {
        return Stream.Wrapper.convert(this.a.mapToObj(doubleFunction));
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ OptionalDouble max() {
        return com.github.catvod.spider.jdollar.time.chrono.m.x(this.a.max());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ OptionalDouble min() {
        return com.github.catvod.spider.jdollar.time.chrono.m.x(this.a.min());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
        return this.a.A();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
        return f.g(this.a.onClose(runnable));
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream parallel() {
        return f.g(this.a.parallel());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.DoubleStream peek(DoubleConsumer doubleConsumer) {
        return g(this.a.peek(doubleConsumer));
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.x(this.a.reduce(doubleBinaryOperator));
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream sequential() {
        return f.g(this.a.sequential());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.DoubleStream skip(long j) {
        return g(this.a.skip(j));
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ java.util.stream.DoubleStream sorted() {
        return g(this.a.sorted());
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ Spliterator<Double> spliterator() {
        return com.github.catvod.spider.jdollar.util.q0.a(this.a.spliterator());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ double sum() {
        return this.a.sum();
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleSummaryStatistics summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.DoubleSummaryStatistics");
    }

    public final /* synthetic */ java.util.stream.DoubleStream takeWhile(DoublePredicate doublePredicate) {
        return g(this.a.a());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ double[] toArray() {
        return this.a.toArray();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.BaseStream unordered() {
        return f.g(this.a.unordered());
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.DoubleStream parallel() {
        return g(this.a.parallel());
    }

    @Override // java.util.stream.DoubleStream
    public final /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        return this.a.reduce(d, doubleBinaryOperator);
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ java.util.stream.DoubleStream sequential() {
        return g(this.a.sequential());
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    /* renamed from: spliterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Spliterator<Double> spliterator2() {
        return Spliterator.Wrapper.convert(this.a.spliterator());
    }

    @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
    public final /* synthetic */ Iterator<Double> iterator() {
        return this.a.iterator2();
    }
}
