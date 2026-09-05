package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Collector;
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
public abstract class e5 extends a implements Stream {
    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final IntStream B(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        Objects.requireNonNull(gVar);
        return new t0(this, b7.p | b7.n | b7.t, gVar, 4);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 E(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return v3.B(aVar, spliterator, z, intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        boolean zE;
        do {
            zE = m5Var.e();
            if (zE) {
                break;
            }
        } while (spliterator.tryAdvance(m5Var));
        return zE;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final c7 H() {
        return c7.REFERENCE;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator I(Supplier supplier) {
        return new o7(supplier);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final y1 J(long j, IntFunction intFunction) {
        return v3.z(j, intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator Q(a aVar, Supplier supplier, boolean z) {
        return new k8(aVar, supplier, z);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) C(v3.W(t1.ALL, predicate))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) C(v3.W(t1.ANY, predicate))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Object collect(Collector collector) {
        Collector collector2;
        Object objC;
        if (this.a.l && collector.characteristics().contains(Collector.Characteristics.CONCURRENT) && (!b7.ORDERED.o(this.f) || collector.characteristics().contains(Collector.Characteristics.UNORDERED))) {
            objC = collector.supplier().get();
            forEach(new com.github.catvod.spider.jdollar.nio.file.d0(8, collector.accumulator(), objC));
            collector2 = collector;
        } else {
            Supplier supplier = ((Collector) Objects.requireNonNull(collector)).supplier();
            collector2 = collector;
            objC = C(new h4(c7.REFERENCE, collector.combiner(), collector.accumulator(), supplier, collector2));
        }
        return collector2.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH) ? objC : collector2.finisher().apply(objC);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final long count() {
        return ((Long) C(new c4(2))).longValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream distinct() {
        return new n(this, b7.m | b7.t);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream dropWhile(Predicate predicate) {
        int i = h9.a;
        Objects.requireNonNull(predicate);
        return new q8(this, h9.b, predicate, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream filter(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new q(this, b7.t, predicate, 4);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Optional findAny() {
        return (Optional) C(h0.d);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Optional findFirst() {
        return (Optional) C(h0.c);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream flatMap(Function function) {
        Objects.requireNonNull(function);
        return new a5(this, b7.p | b7.n | b7.t, function, 1);
    }

    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        C(new o0(consumer, false));
    }

    public void forEachOrdered(Consumer consumer) {
        Objects.requireNonNull(consumer);
        C(new o0(consumer, true));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator */
    public final Iterator iterator2() {
        Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new com.github.catvod.spider.jdollar.util.c1(spliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream limit(long j) {
        if (j >= 0) {
            return v3.X(this, 0L, j);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c(Long.toString(j));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final LongStream m(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        Objects.requireNonNull(gVar);
        return new g1(this, b7.p | b7.n | b7.t, gVar, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream map(Function function) {
        Objects.requireNonNull(function);
        return new a5(this, b7.p | b7.n, function, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new w(this, b7.p | b7.n, toDoubleFunction, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final IntStream mapToInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new t0(this, b7.p | b7.n, toIntFunction, 3);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final LongStream mapToLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new g1(this, b7.p | b7.n, toLongFunction, 3);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Optional max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new com.github.catvod.spider.jdollar.util.function.a(comparator, 0));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Optional min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new com.github.catvod.spider.jdollar.util.function.a(comparator, 1));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) C(v3.W(t1.NONE, predicate))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream peek(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new q(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(binaryOperator);
        return C(new a4(c7.REFERENCE, binaryOperator, biFunction, obj, 2));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : v3.X(this, j, -1L);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c(Long.toString(j));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream sorted() {
        return new i6(this);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream takeWhile(Predicate predicate) {
        int i = h9.a;
        Objects.requireNonNull(predicate);
        return new q8(this, h9.a, predicate, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Object[] toArray(IntFunction intFunction) {
        return v3.J(D(intFunction), intFunction).q(intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final DoubleStream z(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        Objects.requireNonNull(gVar);
        return new w(this, b7.p | b7.n | b7.t, gVar, 3);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return new i6(this, comparator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Object[] toArray() {
        return toArray(new u0(27));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        Objects.requireNonNull(binaryOperator);
        return C(new a4(c7.REFERENCE, binaryOperator, binaryOperator, obj, 2));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Optional reduce(BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (Optional) C(new y3(c7.REFERENCE, binaryOperator, 2));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.Stream
    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return C(new a4(c7.REFERENCE, biConsumer2, biConsumer, supplier, 3));
    }
}
