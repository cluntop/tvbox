package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class l1 implements LongStream {
    public final /* synthetic */ java.util.stream.LongStream a;

    public /* synthetic */ l1(java.util.stream.LongStream longStream) {
        this.a = longStream;
    }

    public static /* synthetic */ LongStream g(java.util.stream.LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof m1 ? ((m1) longStream).a : new l1(longStream);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream a() {
        return g(this.a.takeWhile(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ DoubleStream asDoubleStream() {
        return b0.g(this.a.asDoubleStream());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.b0 average() {
        return com.github.catvod.spider.jdollar.time.chrono.m.t(this.a.average());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream b() {
        return g(this.a.filter(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ Stream boxed() {
        return y6.g(this.a.boxed());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream c() {
        return g(this.a.dropWhile(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.a.close();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objLongConsumer, biConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream d(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        java.util.stream.LongStream longStream = this.a;
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar2 = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(12);
        gVar2.b = gVar;
        return g(longStream.flatMap(gVar2));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream distinct() {
        return g(this.a.distinct());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream e() {
        return g(this.a.map(null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.LongStream longStream = this.a;
        if (obj instanceof l1) {
            obj = ((l1) obj).a;
        }
        return longStream.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.d0 findAny() {
        return com.github.catvod.spider.jdollar.time.chrono.m.v(this.a.findAny());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.d0 findFirst() {
        return com.github.catvod.spider.jdollar.time.chrono.m.v(this.a.findFirst());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.a.forEach(longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.a.forEachOrdered(longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ DoubleStream h() {
        return b0.g(this.a.mapToDouble(null));
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfLong] */
    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator */
    public final /* synthetic */ Iterator<Long> iterator2() {
        ?? it = this.a.iterator();
        if (it == 0) {
            return null;
        }
        return it instanceof com.github.catvod.spider.jdollar.util.m0 ? ((com.github.catvod.spider.jdollar.util.m0) it).a : new com.github.catvod.spider.jdollar.util.l0(it);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ boolean j() {
        return this.a.noneMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream limit(long j) {
        return g(this.a.limit(j));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ Stream mapToObj(LongFunction longFunction) {
        return y6.g(this.a.mapToObj(longFunction));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.d0 max() {
        return com.github.catvod.spider.jdollar.time.chrono.m.v(this.a.max());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.d0 min() {
        return com.github.catvod.spider.jdollar.time.chrono.m.v(this.a.min());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return e.g(this.a.onClose(runnable));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return e.g(this.a.parallel());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream peek(LongConsumer longConsumer) {
        return g(this.a.peek(longConsumer));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ boolean q() {
        return this.a.anyMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.d0 reduce(LongBinaryOperator longBinaryOperator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.v(this.a.reduce(longBinaryOperator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return e.g(this.a.sequential());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream skip(long j) {
        return g(this.a.skip(j));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ LongStream sorted() {
        return g(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfLong] */
    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.x0 spliterator() {
        return com.github.catvod.spider.jdollar.util.v0.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ long sum() {
        return this.a.sum();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final com.github.catvod.spider.jdollar.util.a0 summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ long[] toArray() {
        return this.a.toArray();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return e.g(this.a.unordered());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ boolean v() {
        return this.a.allMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ IntStream y() {
        return b1.g(this.a.mapToInt(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ LongStream parallel() {
        return g(this.a.parallel());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final /* synthetic */ long reduce(long j, LongBinaryOperator longBinaryOperator) {
        return this.a.reduce(j, longBinaryOperator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ LongStream sequential() {
        return g(this.a.sequential());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return com.github.catvod.spider.jdollar.util.b1.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Iterator<Long> iterator2() {
        return this.a.iterator();
    }
}
