package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class v3 implements n8 {
    public static final y2 a = new y2();
    public static final w2 b = new w2();
    public static final x2 c = new x2();
    public static final v2 d = new v2();
    public static final int[] e = new int[0];
    public static final long[] f = new long[0];
    public static final double[] g = new double[0];

    public static long A(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    public static g2 B(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        long jF = aVar.F(spliterator);
        if (jF < 0 || !spliterator.hasCharacteristics(16384)) {
            k0 k0Var = new k0();
            k0Var.a = intFunction;
            g2 g2Var = (g2) new l2(aVar, spliterator, k0Var, new u0(26), 3).invoke();
            return z ? J(g2Var, intFunction) : g2Var;
        }
        if (jF >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) jF);
        new q3(spliterator, aVar, objArr).invoke();
        return new j2(objArr);
    }

    public static a2 C(a aVar, Spliterator spliterator, boolean z) {
        long jF = aVar.F(spliterator);
        if (jF < 0 || !spliterator.hasCharacteristics(16384)) {
            a2 a2Var = (a2) new l2(aVar, spliterator, new u0(20), new u0(21), 0).invoke();
            return z ? K(a2Var) : a2Var;
        }
        if (jF >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        double[] dArr = new double[(int) jF];
        new n3(spliterator, aVar, dArr).invoke();
        return new s2(dArr);
    }

    public static c2 D(a aVar, Spliterator spliterator, boolean z) {
        long jF = aVar.F(spliterator);
        if (jF < 0 || !spliterator.hasCharacteristics(16384)) {
            c2 c2Var = (c2) new l2(aVar, spliterator, new u0(22), new u0(23), 1).invoke();
            return z ? L(c2Var) : c2Var;
        }
        if (jF >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        int[] iArr = new int[(int) jF];
        new o3(spliterator, aVar, iArr).invoke();
        return new b3(iArr);
    }

    public static e2 E(a aVar, Spliterator spliterator, boolean z) {
        long jF = aVar.F(spliterator);
        if (jF < 0 || !spliterator.hasCharacteristics(16384)) {
            e2 e2Var = (e2) new l2(aVar, spliterator, new u0(24), new u0(25), 2).invoke();
            return z ? M(e2Var) : e2Var;
        }
        if (jF >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        long[] jArr = new long[(int) jF];
        new p3(spliterator, aVar, jArr).invoke();
        return new k3(jArr);
    }

    public static i2 F(c7 c7Var, g2 g2Var, g2 g2Var2) {
        int i = h2.a[c7Var.ordinal()];
        if (i == 1) {
            return new r2(g2Var, g2Var2);
        }
        if (i == 2) {
            return new o2((c2) g2Var, (c2) g2Var2);
        }
        if (i == 3) {
            return new p2((e2) g2Var, (e2) g2Var2);
        }
        if (i == 4) {
            return new n2((a2) g2Var, (a2) g2Var2);
        }
        throw new IllegalStateException("Unknown shape " + c7Var);
    }

    public static v1 G(long j) {
        return (j < 0 || j >= 2147483639) ? new u2() : new t2(j);
    }

    public static z2 H(c7 c7Var) {
        int i = h2.a[c7Var.ordinal()];
        if (i == 1) {
            return a;
        }
        if (i == 2) {
            return b;
        }
        if (i == 3) {
            return c;
        }
        if (i == 4) {
            return d;
        }
        throw new IllegalStateException("Unknown shape " + c7Var);
    }

    public static int I(long j) {
        return (j != -1 ? b7.u : 0) | b7.t;
    }

    public static g2 J(g2 g2Var, IntFunction intFunction) {
        if (g2Var.s() <= 0) {
            return g2Var;
        }
        long jCount = g2Var.count();
        if (jCount >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) jCount);
        new u3(g2Var, objArr, 1).invoke();
        return new j2(objArr);
    }

    public static a2 K(a2 a2Var) {
        if (a2Var.s() <= 0) {
            return a2Var;
        }
        long jCount = a2Var.count();
        if (jCount >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        double[] dArr = new double[(int) jCount];
        new t3(a2Var, dArr, 0).invoke();
        return new s2(dArr);
    }

    public static c2 L(c2 c2Var) {
        if (c2Var.s() <= 0) {
            return c2Var;
        }
        long jCount = c2Var.count();
        if (jCount >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        int[] iArr = new int[(int) jCount];
        new t3(c2Var, iArr, 0).invoke();
        return new b3(iArr);
    }

    public static e2 M(e2 e2Var) {
        if (e2Var.s() <= 0) {
            return e2Var;
        }
        long jCount = e2Var.count();
        if (jCount >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        long[] jArr = new long[(int) jCount];
        new t3(e2Var, jArr, 0).invoke();
        return new k3(jArr);
    }

    public static com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g N(Function function) {
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g gVar = new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(11);
        gVar.b = function;
        return gVar;
    }

    public static w1 O(long j) {
        return (j < 0 || j >= 2147483639) ? new d3() : new c3(j);
    }

    public static x1 P(long j) {
        return (j < 0 || j >= 2147483639) ? new m3() : new l3(j);
    }

    public static com.github.catvod.spider.jdollar.nio.file.d0 Q(t1 t1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(t1Var);
        return new com.github.catvod.spider.jdollar.nio.file.d0(c7.DOUBLE_VALUE, t1Var, new n1(t1Var, 2));
    }

    public static v5 R(a0 a0Var, long j, long j2) {
        if (j >= 0) {
            return new v5(a0Var, I(j2), j, j2);
        }
        com.github.catvod.spider.jdollar.nio.file.b.a(j);
        return null;
    }

    public static com.github.catvod.spider.jdollar.nio.file.d0 S(t1 t1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(t1Var);
        return new com.github.catvod.spider.jdollar.nio.file.d0(c7.INT_VALUE, t1Var, new n1(t1Var, 1));
    }

    public static q5 T(a1 a1Var, long j, long j2) {
        if (j >= 0) {
            return new q5(a1Var, I(j2), j, j2);
        }
        com.github.catvod.spider.jdollar.nio.file.b.a(j);
        return null;
    }

    public static com.github.catvod.spider.jdollar.nio.file.d0 U(t1 t1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(t1Var);
        return new com.github.catvod.spider.jdollar.nio.file.d0(c7.LONG_VALUE, t1Var, new n1(t1Var, 0));
    }

    public static s5 V(k1 k1Var, long j, long j2) {
        if (j >= 0) {
            return new s5(k1Var, I(j2), j, j2);
        }
        com.github.catvod.spider.jdollar.nio.file.b.a(j);
        return null;
    }

    public static com.github.catvod.spider.jdollar.nio.file.d0 W(t1 t1Var, Predicate predicate) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(t1Var);
        return new com.github.catvod.spider.jdollar.nio.file.d0(c7.REFERENCE, t1Var, new com.github.catvod.spider.jdollar.nio.file.d0(6, t1Var, predicate));
    }

    public static o5 X(e5 e5Var, long j, long j2) {
        if (j >= 0) {
            return new o5(e5Var, I(j2), j, j2);
        }
        com.github.catvod.spider.jdollar.nio.file.b.a(j);
        return null;
    }

    public static void c() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void d(j5 j5Var, Double d2) {
        if (p8.a) {
            p8.a(j5Var.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
        j5Var.accept(d2.doubleValue());
    }

    public static void g(k5 k5Var, Integer num) {
        if (p8.a) {
            p8.a(k5Var.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
        k5Var.accept(num.intValue());
    }

    public static void i(l5 l5Var, Long l) {
        if (p8.a) {
            p8.a(l5Var.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
        l5Var.accept(l.longValue());
    }

    public static void k() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void l() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static Object[] m(f2 f2Var, IntFunction intFunction) {
        if (p8.a) {
            p8.a(f2Var.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        }
        if (f2Var.count() >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) f2Var.count());
        f2Var.m(objArr, 0);
        return objArr;
    }

    public static void n(a2 a2Var, Double[] dArr, int i) {
        if (p8.a) {
            p8.a(a2Var.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) a2Var.b();
        for (int i2 = 0; i2 < dArr2.length; i2++) {
            dArr[i + i2] = Double.valueOf(dArr2[i2]);
        }
    }

    public static void o(c2 c2Var, Integer[] numArr, int i) {
        if (p8.a) {
            p8.a(c2Var.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) c2Var.b();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i + i2] = Integer.valueOf(iArr[i2]);
        }
    }

    public static void p(e2 e2Var, Long[] lArr, int i) {
        if (p8.a) {
            p8.a(e2Var.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) e2Var.b();
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i + i2] = Long.valueOf(jArr[i2]);
        }
    }

    public static void q(a2 a2Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            a2Var.h((DoubleConsumer) consumer);
        } else {
            if (p8.a) {
                p8.a(a2Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((com.github.catvod.spider.jdollar.util.r0) a2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void r(c2 c2Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            c2Var.h((IntConsumer) consumer);
        } else {
            if (p8.a) {
                p8.a(c2Var.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                throw null;
            }
            ((com.github.catvod.spider.jdollar.util.u0) c2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void s(e2 e2Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            e2Var.h((LongConsumer) consumer);
        } else {
            if (p8.a) {
                p8.a(e2Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((com.github.catvod.spider.jdollar.util.x0) e2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static a2 t(a2 a2Var, long j, long j2) {
        if (j == 0 && j2 == a2Var.count()) {
            return a2Var;
        }
        long j3 = j2 - j;
        com.github.catvod.spider.jdollar.util.r0 r0Var = (com.github.catvod.spider.jdollar.util.r0) a2Var.spliterator();
        v1 v1VarG = G(j3);
        v1VarG.c(j3);
        int i = 0;
        for (int i2 = 0; i2 < j && r0Var.tryAdvance((DoubleConsumer) new z1(i)); i2++) {
        }
        if (j2 == a2Var.count()) {
            r0Var.forEachRemaining((DoubleConsumer) v1VarG);
        } else {
            while (i < j3 && r0Var.tryAdvance((DoubleConsumer) v1VarG)) {
                i++;
            }
        }
        v1VarG.end();
        return v1VarG.build();
    }

    public static c2 u(c2 c2Var, long j, long j2) {
        if (j == 0 && j2 == c2Var.count()) {
            return c2Var;
        }
        long j3 = j2 - j;
        com.github.catvod.spider.jdollar.util.u0 u0Var = (com.github.catvod.spider.jdollar.util.u0) c2Var.spliterator();
        w1 w1VarO = O(j3);
        w1VarO.c(j3);
        int i = 0;
        for (int i2 = 0; i2 < j && u0Var.tryAdvance((IntConsumer) new b2(i)); i2++) {
        }
        if (j2 == c2Var.count()) {
            u0Var.forEachRemaining((IntConsumer) w1VarO);
        } else {
            while (i < j3 && u0Var.tryAdvance((IntConsumer) w1VarO)) {
                i++;
            }
        }
        w1VarO.end();
        return w1VarO.build();
    }

    public static e2 v(e2 e2Var, long j, long j2) {
        if (j == 0 && j2 == e2Var.count()) {
            return e2Var;
        }
        long j3 = j2 - j;
        com.github.catvod.spider.jdollar.util.x0 x0Var = (com.github.catvod.spider.jdollar.util.x0) e2Var.spliterator();
        x1 x1VarP = P(j3);
        x1VarP.c(j3);
        int i = 0;
        for (int i2 = 0; i2 < j && x0Var.tryAdvance((LongConsumer) new d2(i)); i2++) {
        }
        if (j2 == e2Var.count()) {
            x0Var.forEachRemaining((LongConsumer) x1VarP);
        } else {
            while (i < j3 && x0Var.tryAdvance((LongConsumer) x1VarP)) {
                i++;
            }
        }
        x1VarP.end();
        return x1VarP.build();
    }

    public static g2 w(g2 g2Var, long j, long j2, IntFunction intFunction) {
        if (j == 0 && j2 == g2Var.count()) {
            return g2Var;
        }
        Spliterator spliterator = g2Var.spliterator();
        long j3 = j2 - j;
        y1 y1VarZ = z(j3, intFunction);
        y1VarZ.c(j3);
        for (int i = 0; i < j && spliterator.tryAdvance(new u0(18)); i++) {
        }
        if (j2 == g2Var.count()) {
            spliterator.forEachRemaining(y1VarZ);
        } else {
            for (int i2 = 0; i2 < j3 && spliterator.tryAdvance(y1VarZ); i2++) {
            }
        }
        y1VarZ.end();
        return y1VarZ.build();
    }

    public static long x(long j, long j2, long j3) {
        if (j >= 0) {
            return Math.max(-1L, Math.min(j - j2, j3));
        }
        return -1L;
    }

    public static Spliterator y(c7 c7Var, Spliterator spliterator, long j, long j2) {
        long jA = A(j, j2);
        int i = w5.a[c7Var.ordinal()];
        if (i == 1) {
            return new a8(spliterator, j, jA);
        }
        if (i == 2) {
            return new x7((com.github.catvod.spider.jdollar.util.u0) spliterator, j, jA);
        }
        if (i == 3) {
            return new y7((com.github.catvod.spider.jdollar.util.x0) spliterator, j, jA);
        }
        if (i == 4) {
            return new w7((com.github.catvod.spider.jdollar.util.r0) spliterator, j, jA);
        }
        throw new IllegalStateException("Unknown shape " + c7Var);
    }

    public static y1 z(long j, IntFunction intFunction) {
        return (j < 0 || j >= 2147483639) ? new s3() : new a3(j, intFunction);
    }

    public abstract q4 Y();

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public Object a(a aVar, Spliterator spliterator) {
        q4 q4VarY = Y();
        aVar.R(spliterator, q4VarY);
        return q4VarY.get();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public Object b(a aVar, Spliterator spliterator) {
        return ((q4) new x4(this, aVar, spliterator).invoke()).get();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.n8
    public /* synthetic */ int f() {
        return 0;
    }
}
