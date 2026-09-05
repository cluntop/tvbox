package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
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
public final /* synthetic */ class b1 implements IntStream {
    public final /* synthetic */ java.util.stream.IntStream a;

    public /* synthetic */ b1(java.util.stream.IntStream intStream) {
        this.a = intStream;
    }

    public static /* synthetic */ IntStream g(java.util.stream.IntStream intStream) {
        if (intStream == null) {
            return null;
        }
        return intStream instanceof c1 ? ((c1) intStream).a : new b1(intStream);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream a() {
        return g(this.a.takeWhile(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ DoubleStream asDoubleStream() {
        return b0.g(this.a.asDoubleStream());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ LongStream asLongStream() {
        return l1.g(this.a.asLongStream());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.b0 average() {
        return com.github.catvod.spider.jdollar.time.chrono.m.t(this.a.average());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream b() {
        return g(this.a.filter(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ Stream boxed() {
        return y6.g(this.a.boxed());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream c() {
        return g(this.a.dropWhile(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.a.close();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objIntConsumer, biConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream distinct() {
        return g(this.a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.IntStream intStream = this.a;
        if (obj instanceof b1) {
            obj = ((b1) obj).a;
        }
        return intStream.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ DoubleStream f() {
        return b0.g(this.a.mapToDouble(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.c0 findAny() {
        return com.github.catvod.spider.jdollar.time.chrono.m.u(this.a.findAny());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.c0 findFirst() {
        return com.github.catvod.spider.jdollar.time.chrono.m.u(this.a.findFirst());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ void forEach(IntConsumer intConsumer) {
        this.a.forEach(intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
        this.a.forEachOrdered(intConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ LongStream i() {
        return l1.g(this.a.mapToLong(null));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfInt] */
    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator */
    public final /* synthetic */ Iterator<Integer> iterator2() {
        ?? it = this.a.iterator();
        if (it == 0) {
            return null;
        }
        return it instanceof com.github.catvod.spider.jdollar.util.j0 ? ((com.github.catvod.spider.jdollar.util.j0) it).a : new com.github.catvod.spider.jdollar.util.i0(it);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream limit(long j) {
        return g(this.a.limit(j));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream map(IntUnaryOperator intUnaryOperator) {
        return g(this.a.map(intUnaryOperator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ Stream mapToObj(IntFunction intFunction) {
        return y6.g(this.a.mapToObj(intFunction));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.c0 max() {
        return com.github.catvod.spider.jdollar.time.chrono.m.u(this.a.max());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.c0 min() {
        return com.github.catvod.spider.jdollar.time.chrono.m.u(this.a.min());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ boolean o() {
        return this.a.allMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return e.g(this.a.onClose(runnable));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return e.g(this.a.parallel());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream peek(IntConsumer intConsumer) {
        return g(this.a.peek(intConsumer));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream r(k0 k0Var) {
        java.util.stream.IntStream intStream = this.a;
        k0 k0Var2 = new k0();
        k0Var2.a = k0Var;
        return g(intStream.flatMap(k0Var2));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.c0 reduce(IntBinaryOperator intBinaryOperator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.u(this.a.reduce(intBinaryOperator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ boolean s() {
        return this.a.noneMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return e.g(this.a.sequential());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream skip(long j) {
        return g(this.a.skip(j));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ IntStream sorted() {
        return g(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfInt] */
    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.u0 spliterator() {
        return com.github.catvod.spider.jdollar.util.s0.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ int sum() {
        return this.a.sum();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final com.github.catvod.spider.jdollar.util.y summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ int[] toArray() {
        return this.a.toArray();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return e.g(this.a.unordered());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ boolean w() {
        return this.a.anyMatch(null);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ IntStream parallel() {
        return g(this.a.parallel());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
        return this.a.reduce(i, intBinaryOperator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ IntStream sequential() {
        return g(this.a.sequential());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return com.github.catvod.spider.jdollar.util.b1.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public final /* synthetic */ Iterator<Integer> iterator2() {
        return this.a.iterator();
    }
}
