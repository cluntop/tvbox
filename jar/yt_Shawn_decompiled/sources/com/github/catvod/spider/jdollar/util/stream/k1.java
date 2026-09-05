package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class k1 extends a implements LongStream {
    public static com.github.catvod.spider.jdollar.util.x0 U(Spliterator spliterator) {
        if (spliterator instanceof com.github.catvod.spider.jdollar.util.x0) {
            return (com.github.catvod.spider.jdollar.util.x0) spliterator;
        }
        if (!p8.a) {
            throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
        }
        p8.a(a.class, "using LongStream.adapt(Spliterator<Long> s)");
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 E(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return v3.E(aVar, spliterator, z);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        LongConsumer k0Var;
        boolean zE;
        com.github.catvod.spider.jdollar.util.x0 x0VarU = U(spliterator);
        if (m5Var instanceof LongConsumer) {
            k0Var = (LongConsumer) m5Var;
        } else {
            if (p8.a) {
                p8.a(a.class, "using LongStream.adapt(Sink<Long> s)");
                throw null;
            }
            Objects.requireNonNull(m5Var);
            k0Var = new com.github.catvod.spider.jdollar.util.k0(m5Var, 1);
        }
        do {
            zE = m5Var.e();
            if (zE) {
                break;
            }
        } while (x0VarU.tryAdvance(k0Var));
        return zE;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final c7 H() {
        return c7.LONG_VALUE;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final y1 J(long j, IntFunction intFunction) {
        return v3.P(j);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator Q(a aVar, Supplier supplier, boolean z) {
        return new v7(aVar, supplier, z);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream a() {
        int i = h9.a;
        Objects.requireNonNull(null);
        return new h6(this, h9.a, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final DoubleStream asDoubleStream() {
        return new s(this, b7.n, 5);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final com.github.catvod.spider.jdollar.util.b0 average() {
        long j = ((long[]) collect(new u0(11), new u0(12), new u0(13)))[0];
        return j > 0 ? new com.github.catvod.spider.jdollar.util.b0(r0[1] / j) : com.github.catvod.spider.jdollar.util.b0.c;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream b() {
        Objects.requireNonNull(null);
        return new u(this, b7.t, 5);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final Stream boxed() {
        return new q(this, 0, new u0(10), 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream c() {
        int i = h9.a;
        Objects.requireNonNull(null);
        return new h6(this, h9.b, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 2);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objLongConsumer);
        Objects.requireNonNull(pVar);
        return C(new a4(c7.LONG_VALUE, pVar, objLongConsumer, supplier, 0));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final long count() {
        return ((Long) C(new c4(0))).longValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream d(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        Objects.requireNonNull(gVar);
        return new g1(this, b7.p | b7.n | b7.t, gVar, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream distinct() {
        return ((e5) boxed()).distinct().mapToLong(new u0(17));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream e() {
        Objects.requireNonNull(null);
        return new u(this, b7.p | b7.n, 3);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final com.github.catvod.spider.jdollar.util.d0 findAny() {
        return (com.github.catvod.spider.jdollar.util.d0) C(g0.d);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final com.github.catvod.spider.jdollar.util.d0 findFirst() {
        return (com.github.catvod.spider.jdollar.util.d0) C(g0.c);
    }

    public void forEach(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        C(new n0(longConsumer, false));
    }

    public void forEachOrdered(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        C(new n0(longConsumer, true));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final DoubleStream h() {
        Objects.requireNonNull(null);
        return new s(this, b7.p | b7.n, 6);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public final Iterator<Long> iterator2() {
        com.github.catvod.spider.jdollar.util.x0 x0VarSpliterator = spliterator();
        Objects.requireNonNull(x0VarSpliterator);
        return new com.github.catvod.spider.jdollar.util.e1(x0VarSpliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final boolean j() {
        return ((Boolean) C(v3.U(t1.NONE))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream limit(long j) {
        if (j >= 0) {
            return v3.V(this, 0L, j);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c(Long.toString(j));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final Stream mapToObj(LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new q(this, b7.p | b7.n, longFunction, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final com.github.catvod.spider.jdollar.util.d0 max() {
        return reduce(new u0(14));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final com.github.catvod.spider.jdollar.util.d0 min() {
        return reduce(new u0(16));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream peek(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new g1(this, longConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final boolean q() {
        return ((Boolean) C(v3.U(t1.ANY))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final long reduce(long j, LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return ((Long) C(new w3(c7.LONG_VALUE, longBinaryOperator, j))).longValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : v3.V(this, j, -1L);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c(Long.toString(j));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final LongStream sorted() {
        return new h6(this, b7.q | b7.o, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final com.github.catvod.spider.jdollar.util.x0 spliterator() {
        return U(super.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final long sum() {
        return reduce(0L, new u0(15));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final com.github.catvod.spider.jdollar.util.a0 summaryStatistics() {
        return (com.github.catvod.spider.jdollar.util.a0) collect(new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(24), new u0(7), new u0(8));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final long[] toArray() {
        return (long[]) v3.M((e2) D(new u0(9))).b();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final boolean v() {
        return ((Boolean) C(v3.U(t1.ALL))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final IntStream y() {
        Objects.requireNonNull(null);
        return new t(this, b7.p | b7.n, 3);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.LongStream
    public final com.github.catvod.spider.jdollar.util.d0 reduce(LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return (com.github.catvod.spider.jdollar.util.d0) C(new y3(c7.LONG_VALUE, longBinaryOperator, 0));
    }
}
