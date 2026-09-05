package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Iterator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class a0 extends a implements DoubleStream {
    public static com.github.catvod.spider.jdollar.util.r0 U(Spliterator spliterator) {
        if (spliterator instanceof com.github.catvod.spider.jdollar.util.r0) {
            return (com.github.catvod.spider.jdollar.util.r0) spliterator;
        }
        if (!p8.a) {
            throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
        }
        p8.a(a.class, "using DoubleStream.adapt(Spliterator<Double> s)");
        throw null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final boolean A() {
        return ((Boolean) C(v3.Q(t1.NONE))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final g2 E(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return v3.C(aVar, spliterator, z);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        DoubleConsumer e0Var;
        boolean zE;
        com.github.catvod.spider.jdollar.util.r0 r0VarU = U(spliterator);
        if (m5Var instanceof DoubleConsumer) {
            e0Var = (DoubleConsumer) m5Var;
        } else {
            if (p8.a) {
                p8.a(a.class, "using DoubleStream.adapt(Sink<Double> s)");
                throw null;
            }
            Objects.requireNonNull(m5Var);
            e0Var = new com.github.catvod.spider.jdollar.util.e0(m5Var, 1);
        }
        do {
            zE = m5Var.e();
            if (zE) {
                break;
            }
        } while (r0VarU.tryAdvance(e0Var));
        return zE;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final c7 H() {
        return c7.DOUBLE_VALUE;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final y1 J(long j, IntFunction intFunction) {
        return v3.G(j);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a
    public final Spliterator Q(a aVar, Supplier supplier, boolean z) {
        return new r7(aVar, supplier, z);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream a() {
        int i = h9.a;
        Objects.requireNonNull(null);
        return new f6(this, h9.a, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final com.github.catvod.spider.jdollar.util.b0 average() {
        double[] dArr = (double[]) collect(new j(13), new j(14), new j(15));
        if (dArr[2] <= 0.0d) {
            return com.github.catvod.spider.jdollar.util.b0.c;
        }
        Set set = Collectors.a;
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        if (Double.isNaN(d) && Double.isInfinite(d2)) {
            d = d2;
        }
        return new com.github.catvod.spider.jdollar.util.b0(d / dArr[2]);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream b() {
        Objects.requireNonNull(null);
        return new s(this, b7.t, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final Stream boxed() {
        return new q(this, 0, new j(5), 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream c() {
        int i = h9.a;
        Objects.requireNonNull(null);
        return new f6(this, h9.b, 2);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 0);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objDoubleConsumer);
        Objects.requireNonNull(pVar);
        return C(new a4(c7.DOUBLE_VALUE, pVar, objDoubleConsumer, supplier, 1));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final long count() {
        return ((Long) C(new c4(1))).longValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream d(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar) {
        Objects.requireNonNull(gVar);
        return new w(this, b7.p | b7.n | b7.t, gVar, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream distinct() {
        return ((e5) boxed()).distinct().mapToDouble(new j(6));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream e() {
        Objects.requireNonNull(null);
        return new s(this, b7.p | b7.n, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final com.github.catvod.spider.jdollar.util.b0 findAny() {
        return (com.github.catvod.spider.jdollar.util.b0) C(e0.d);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final com.github.catvod.spider.jdollar.util.b0 findFirst() {
        return (com.github.catvod.spider.jdollar.util.b0) C(e0.c);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public void forEach(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        C(new l0(doubleConsumer, false));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public void forEachOrdered(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        C(new l0(doubleConsumer, true));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.BaseStream
    /* renamed from: iterator */
    public final Iterator<Double> iterator2() {
        com.github.catvod.spider.jdollar.util.r0 r0VarSpliterator = spliterator();
        Objects.requireNonNull(r0VarSpliterator);
        return new com.github.catvod.spider.jdollar.util.f1(r0VarSpliterator);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final boolean l() {
        return ((Boolean) C(v3.Q(t1.ANY))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream limit(long j) {
        if (j >= 0) {
            return v3.R(this, 0L, j);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c(Long.toString(j));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final Stream mapToObj(DoubleFunction doubleFunction) {
        Objects.requireNonNull(doubleFunction);
        return new q(this, b7.p | b7.n, doubleFunction, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final com.github.catvod.spider.jdollar.util.b0 max() {
        return reduce(new j(8));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final com.github.catvod.spider.jdollar.util.b0 min() {
        return reduce(new j(12));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream peek(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new w(this, doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return ((Double) C(new e4(c7.DOUBLE_VALUE, doubleBinaryOperator, d))).doubleValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : v3.R(this, j, -1L);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c(Long.toString(j));
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final DoubleStream sorted() {
        return new f6(this, b7.q | b7.o, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.a, com.github.catvod.spider.jdollar.util.stream.BaseStream
    public final com.github.catvod.spider.jdollar.util.r0 spliterator() {
        return U(super.spliterator());
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final double sum() {
        double[] dArr = (double[]) collect(new j(9), new j(10), new j(11));
        Set set = Collectors.a;
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (Double.isNaN(d) && Double.isInfinite(d2)) ? d2 : d;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final com.github.catvod.spider.jdollar.util.x summaryStatistics() {
        return (com.github.catvod.spider.jdollar.util.x) collect(new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m(16), new j(16), new j(4));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final boolean t() {
        return ((Boolean) C(v3.Q(t1.ALL))).booleanValue();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final double[] toArray() {
        return (double[]) v3.K((a2) D(new j(7))).b();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final LongStream u() {
        Objects.requireNonNull(null);
        return new u(this, b7.p | b7.n, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final IntStream x() {
        Objects.requireNonNull(null);
        return new t(this, b7.p | b7.n, 0);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.DoubleStream
    public final com.github.catvod.spider.jdollar.util.b0 reduce(DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return (com.github.catvod.spider.jdollar.util.b0) C(new y3(c7.DOUBLE_VALUE, doubleBinaryOperator, 1));
    }
}
