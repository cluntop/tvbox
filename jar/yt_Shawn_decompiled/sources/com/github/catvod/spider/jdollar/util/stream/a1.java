package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
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
public abstract class a1 extends a implements IntStream {
    public static com.github.catvod.spider.jdollar.util.u0 U(Spliterator spliterator) {
        if (spliterator instanceof com.github.catvod.spider.jdollar.util.u0) {
            return (com.github.catvod.spider.jdollar.util.u0) spliterator;
        }
        if (!p8.a) {
            throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
        }
        p8.a(a.class, "using IntStream.adapt(Spliterator<Integer> s)");
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 E(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return v3.D(aVar, spliterator, z);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        IntConsumer h0Var;
        boolean zE;
        com.github.catvod.spider.jdollar.util.u0 u0VarU = U(spliterator);
        if (m5Var instanceof IntConsumer) {
            h0Var = (IntConsumer) m5Var;
        } else {
            if (p8.a) {
                p8.a(a.class, "using IntStream.adapt(Sink<Integer> s)");
                throw null;
            }
            Objects.requireNonNull(m5Var);
            h0Var = new com.github.catvod.spider.jdollar.util.h0(m5Var, 1);
        }
        do {
            zE = m5Var.e();
            if (zE) {
                break;
            }
        } while (u0VarU.tryAdvance(h0Var));
        return zE;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final c7 H() {
        return c7.INT_VALUE;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final y1 J(long j, IntFunction intFunction) {
        return v3.O(j);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator Q(a aVar, Supplier supplier, boolean z) {
        return new t7(aVar, supplier, z);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream a() {
        int i = h9.a;
        Objects.requireNonNull(null);
        return new g6(this, h9.a, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final DoubleStream asDoubleStream() {
        return new s(this, 0, 3);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final LongStream asLongStream() {
        return new u(this, 0, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final com.github.catvod.spider.jdollar.util.b0 average() {
        long j = ((long[]) collect(new u0(2), new u0(3), new u0(4)))[0];
        return j > 0 ? new com.github.catvod.spider.jdollar.util.b0(r0[1] / j) : com.github.catvod.spider.jdollar.util.b0.c;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream b() {
        Objects.requireNonNull(null);
        return new t(this, b7.t, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final Stream boxed() {
        return new q(this, 0, new u0(6), 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream c() {
        int i = h9.a;
        Objects.requireNonNull(null);
        return new g6(this, h9.b, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 1);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objIntConsumer);
        Objects.requireNonNull(pVar);
        return C(new a4(c7.INT_VALUE, pVar, objIntConsumer, supplier, 4));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final long count() {
        return ((Long) C(new c4(3))).longValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream distinct() {
        return ((e5) boxed()).distinct().mapToInt(new u0(5));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final DoubleStream f() {
        Objects.requireNonNull(null);
        return new s(this, b7.p | b7.n, 4);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final com.github.catvod.spider.jdollar.util.c0 findAny() {
        return (com.github.catvod.spider.jdollar.util.c0) C(f0.d);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final com.github.catvod.spider.jdollar.util.c0 findFirst() {
        return (com.github.catvod.spider.jdollar.util.c0) C(f0.c);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public void forEach(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        C(new m0(intConsumer, false));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public void forEachOrdered(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        C(new m0(intConsumer, true));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final LongStream i() {
        Objects.requireNonNull(null);
        return new u(this, b7.p | b7.n, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator */
    public final Iterator<Integer> iterator2() {
        com.github.catvod.spider.jdollar.util.u0 u0VarSpliterator = spliterator();
        Objects.requireNonNull(u0VarSpliterator);
        return new com.github.catvod.spider.jdollar.util.d1(u0VarSpliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream limit(long j) {
        if (j >= 0) {
            return v3.T(this, 0L, j);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c(Long.toString(j));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream map(IntUnaryOperator intUnaryOperator) {
        Objects.requireNonNull(intUnaryOperator);
        return new t0(this, b7.p | b7.n, intUnaryOperator, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new q(this, b7.p | b7.n, intFunction, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final com.github.catvod.spider.jdollar.util.c0 max() {
        return reduce(new u0(1));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final com.github.catvod.spider.jdollar.util.c0 min() {
        return reduce(new j(27));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final boolean o() {
        return ((Boolean) C(v3.S(t1.ALL))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream peek(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new t0(this, intConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream r(k0 k0Var) {
        Objects.requireNonNull(k0Var);
        return new t0(this, b7.p | b7.n | b7.t, k0Var, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final int reduce(int i, IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return ((Integer) C(new l4(c7.INT_VALUE, intBinaryOperator, i))).intValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final boolean s() {
        return ((Boolean) C(v3.S(t1.NONE))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : v3.T(this, j, -1L);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c(Long.toString(j));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final IntStream sorted() {
        return new g6(this, b7.q | b7.o, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final com.github.catvod.spider.jdollar.util.u0 spliterator() {
        return U(super.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final int sum() {
        return reduce(0, new u0(0));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final com.github.catvod.spider.jdollar.util.y summaryStatistics() {
        return (com.github.catvod.spider.jdollar.util.y) collect(new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(23), new j(28), new j(29));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final int[] toArray() {
        return (int[]) v3.L((c2) D(new j(26))).b();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final boolean w() {
        return ((Boolean) C(v3.S(t1.ANY))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.IntStream
    public final com.github.catvod.spider.jdollar.util.c0 reduce(IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return (com.github.catvod.spider.jdollar.util.c0) C(new y3(c7.INT_VALUE, intBinaryOperator, 3));
    }
}
