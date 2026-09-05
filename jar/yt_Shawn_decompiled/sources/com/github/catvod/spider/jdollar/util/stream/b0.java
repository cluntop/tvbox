package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements DoubleStream {
    public final /* synthetic */ java.util.stream.DoubleStream a;

    public /* synthetic */ b0(java.util.stream.DoubleStream doubleStream) {
        this.a = doubleStream;
    }

    public static /* synthetic */ DoubleStream g(java.util.stream.DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof c0 ? ((c0) doubleStream).a : new b0(doubleStream);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ boolean A() {
        return this.a.noneMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream a() {
        return g(this.a.takeWhile(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.b0 average() {
        return com.github.catvod.spider.jdollar.time.chrono.m.t(this.a.average());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream b() {
        return g(this.a.filter(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ Stream boxed() {
        return y6.g(this.a.boxed());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream c() {
        return g(this.a.dropWhile(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.a.close();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream d(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        java.util.stream.DoubleStream doubleStream = this.a;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar2 = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(10);
        gVar2.b = gVar;
        return g(doubleStream.flatMap(gVar2));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream distinct() {
        return g(this.a.distinct());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream e() {
        return g(this.a.map(null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.DoubleStream doubleStream = this.a;
        if (obj instanceof b0) {
            obj = ((b0) obj).a;
        }
        return doubleStream.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.b0 findAny() {
        return com.github.catvod.spider.jdollar.time.chrono.m.t(this.a.findAny());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.b0 findFirst() {
        return com.github.catvod.spider.jdollar.time.chrono.m.t(this.a.findFirst());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.a.forEach(doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfDouble] */
    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator */
    public final /* synthetic */ Iterator<Double> iterator2() {
        ?? it = this.a.iterator();
        if (it == 0) {
            return null;
        }
        return it instanceof com.github.catvod.spider.jdollar.util.g0 ? ((com.github.catvod.spider.jdollar.util.g0) it).a : new com.github.catvod.spider.jdollar.util.f0(it);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ boolean l() {
        return this.a.anyMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream limit(long j) {
        return g(this.a.limit(j));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return y6.g(this.a.mapToObj(doubleFunction));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.b0 max() {
        return com.github.catvod.spider.jdollar.time.chrono.m.t(this.a.max());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.b0 min() {
        return com.github.catvod.spider.jdollar.time.chrono.m.t(this.a.min());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return e.g(this.a.onClose(runnable));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return e.g(this.a.parallel());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
        return g(this.a.peek(doubleConsumer));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.b0 reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.t(this.a.reduce(doubleBinaryOperator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return e.g(this.a.sequential());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream skip(long j) {
        return g(this.a.skip(j));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream sorted() {
        return g(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfDouble] */
    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.r0 spliterator() {
        return com.github.catvod.spider.jdollar.util.p0.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ double sum() {
        return this.a.sum();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final com.github.catvod.spider.jdollar.util.x summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ boolean t() {
        return this.a.allMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ double[] toArray() {
        return this.a.toArray();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ LongStream u() {
        return l1.g(this.a.mapToLong(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return e.g(this.a.unordered());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ IntStream x() {
        return b1.g(this.a.mapToInt(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ DoubleStream parallel() {
        return g(this.a.parallel());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        return this.a.reduce(d, doubleBinaryOperator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ DoubleStream sequential() {
        return g(this.a.sequential());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return com.github.catvod.spider.jdollar.util.b1.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Iterator<Double> iterator2() {
        return this.a.iterator();
    }
}
