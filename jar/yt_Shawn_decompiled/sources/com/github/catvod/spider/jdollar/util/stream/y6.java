package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class y6 implements Stream {
    public final /* synthetic */ java.util.stream.Stream a;

    public /* synthetic */ y6(java.util.stream.Stream stream) {
        this.a = stream;
    }

    public static /* synthetic */ Stream g(java.util.stream.Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Stream.Wrapper ? Stream.this : new y6(stream);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ IntStream B(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        return b1.g(this.a.flatMapToInt(v3.N(gVar)));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.a.allMatch(predicate);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.a.anyMatch(predicate);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.a.close();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Object collect(Collector collector) {
        return this.a.collect(collector == null ? null : collector instanceof g ? ((g) collector).a : new h(collector));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream distinct() {
        return g(this.a.distinct());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream dropWhile(Predicate predicate) {
        return g(this.a.dropWhile(predicate));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Stream stream = this.a;
        if (obj instanceof y6) {
            obj = ((y6) obj).a;
        }
        return stream.equals(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream filter(Predicate predicate) {
        return g(this.a.filter(predicate));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Optional findAny() {
        return com.github.catvod.spider.jdollar.time.chrono.m.s(this.a.findAny());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Optional findFirst() {
        return com.github.catvod.spider.jdollar.time.chrono.m.s(this.a.findFirst());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream flatMap(Function function) {
        return g(this.a.flatMap(v3.N(function)));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ void forEach(Consumer consumer) {
        this.a.forEach(consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.a.forEachOrdered(consumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator */
    public final /* synthetic */ Iterator iterator2() {
        return this.a.iterator();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream limit(long j) {
        return g(this.a.limit(j));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ LongStream m(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        return l1.g(this.a.flatMapToLong(v3.N(gVar)));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream map(Function function) {
        return g(this.a.map(function));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
        return b0.g(this.a.mapToDouble(toDoubleFunction));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ IntStream mapToInt(ToIntFunction toIntFunction) {
        return b1.g(this.a.mapToInt(toIntFunction));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ LongStream mapToLong(ToLongFunction toLongFunction) {
        return l1.g(this.a.mapToLong(toLongFunction));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Optional max(Comparator comparator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.s(this.a.max(comparator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Optional min(Comparator comparator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.s(this.a.min(comparator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.a.noneMatch(predicate);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return e.g(this.a.onClose(runnable));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return e.g(this.a.parallel());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream peek(Consumer consumer) {
        return g(this.a.peek(consumer));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Optional reduce(BinaryOperator binaryOperator) {
        return com.github.catvod.spider.jdollar.time.chrono.m.s(this.a.reduce(binaryOperator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return e.g(this.a.sequential());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream skip(long j) {
        return g(this.a.skip(j));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream sorted() {
        return g(this.a.sorted());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return com.github.catvod.spider.jdollar.util.b1.a(this.a.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream takeWhile(Predicate predicate) {
        return g(this.a.takeWhile(predicate));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Object[] toArray() {
        return this.a.toArray();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return e.g(this.a.unordered());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ DoubleStream z(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        return b0.g(this.a.flatMapToDouble(v3.N(gVar)));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.a.toArray(intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.a.reduce(obj, biFunction, binaryOperator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return g(this.a.sorted(comparator));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
        return this.a.reduce(obj, binaryOperator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.a.collect(supplier, biConsumer, biConsumer2);
    }
}
