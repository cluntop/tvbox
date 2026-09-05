package com.github.catvod.spider.jdollar.util.concurrent;

import com.github.catvod.spider.jdollar.util.stream.b7;
import com.github.catvod.spider.jdollar.util.stream.c0;
import com.github.catvod.spider.jdollar.util.stream.c1;
import com.github.catvod.spider.jdollar.util.stream.h1;
import com.github.catvod.spider.jdollar.util.stream.m1;
import com.github.catvod.spider.jdollar.util.stream.x;
import com.github.catvod.spider.jdollar.util.stream.x0;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ThreadLocalRandom extends Random {
    private static final long serialVersionUID = -5851777807851030925L;
    public long a;
    public int b;
    public final boolean c;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("rnd", Long.TYPE), new ObjectStreamField("initialized", Boolean.TYPE)};
    public static final ThreadLocal d = new ThreadLocal();
    public static final AtomicInteger e = new AtomicInteger();
    public static final t f = new t();
    public static final AtomicLong g = new AtomicLong(f(System.currentTimeMillis()) ^ f(System.nanoTime()));

    static {
        if (((Boolean) AccessController.doPrivileged(new com.github.catvod.spider.jdollar.nio.file.spi.a(2))).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            long j = seed[0] & 255;
            for (int i = 1; i < 8; i++) {
                j = (j << 8) | (seed[i] & 255);
            }
            g.set(j);
        }
    }

    private ThreadLocalRandom() {
        this.c = true;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f.get();
        if (threadLocalRandom.b == 0) {
            d();
        }
        return threadLocalRandom;
    }

    public static final void d() {
        int iAddAndGet = e.addAndGet(-1640531527);
        if (iAddAndGet == 0) {
            iAddAndGet = 1;
        }
        long jF = f(g.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f.get();
        threadLocalRandom.a = jF;
        threadLocalRandom.b = iAddAndGet;
    }

    public static int e(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        return (int) (((j2 ^ (j2 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    public static long f(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    private Object readResolve() {
        return current();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("rnd", this.a);
        putFieldPutFields.put("initialized", true);
        objectOutputStream.writeFields();
    }

    public final double a(double d2, double d3) {
        double dNextLong = (nextLong() >>> 11) * 1.1102230246251565E-16d;
        if (d2 >= d3) {
            return dNextLong;
        }
        double d4 = ((d3 - d2) * dNextLong) + d2;
        return d4 >= d3 ? Double.longBitsToDouble(Double.doubleToLongBits(d3) - 1) : d4;
    }

    public final int b(int i, int i2) {
        int iE = e(g());
        if (i >= i2) {
            return iE;
        }
        int i3 = i2 - i;
        int i4 = i3 - 1;
        if ((i3 & i4) == 0) {
            return (iE & i4) + i;
        }
        if (i3 > 0) {
            int iE2 = iE >>> 1;
            while (true) {
                int i5 = iE2 + i4;
                int i6 = iE2 % i3;
                if (i5 - i6 >= 0) {
                    return i6 + i;
                }
                iE2 = e(g()) >>> 1;
            }
        } else {
            while (true) {
                if (iE >= i && iE < i2) {
                    return iE;
                }
                iE = e(g());
            }
        }
    }

    public final long c(long j, long j2) {
        long jF = f(g());
        if (j >= j2) {
            return jF;
        }
        long j3 = j2 - j;
        long j4 = j3 - 1;
        if ((j3 & j4) == 0) {
            return (jF & j4) + j;
        }
        if (j3 > 0) {
            while (true) {
                long j5 = jF >>> 1;
                long j6 = j5 + j4;
                long j7 = j5 % j3;
                if (j6 - j7 >= 0) {
                    return j7 + j;
                }
                jF = f(g());
            }
        } else {
            while (true) {
                if (jF >= j && jF < j2) {
                    return jF;
                }
                jF = f(g());
            }
        }
    }

    @Override // java.util.Random
    public final DoubleStream doubles(long j, double d2, double d3) {
        if (j < 0) {
            com.github.catvod.spider.jdollar.nio.file.b.c("size must be non-negative");
            return null;
        }
        if (d2 < d3) {
            u uVar = new u(0L, j, d2, d3);
            return c0.g(new x(uVar, b7.j(uVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return null;
    }

    public final long g() {
        long j = this.a - 7046029254386353131L;
        this.a = j;
        return j;
    }

    @Override // java.util.Random
    public final IntStream ints(long j, int i, int i2) {
        if (j < 0) {
            com.github.catvod.spider.jdollar.nio.file.b.c("size must be non-negative");
            return null;
        }
        if (i < i2) {
            v vVar = new v(0L, j, i, i2);
            return c1.g(new x0(vVar, b7.j(vVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final LongStream longs(long j, long j2, long j3) {
        if (j < 0) {
            com.github.catvod.spider.jdollar.nio.file.b.c("size must be non-negative");
            return null;
        }
        if (j2 < j3) {
            w wVar = new w(0L, j, j2, j3);
            return m1.g(new h1(wVar, b7.j(wVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final int next(int i) {
        return nextInt() >>> (32 - i);
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return e(g()) < 0;
    }

    public double nextDouble(double d2) {
        if (d2 > 0.0d) {
            double dF = (f(g()) >>> 11) * 1.1102230246251565E-16d * d2;
            return dF < d2 ? dF : Double.longBitsToDouble(Double.doubleToLongBits(d2) - 1);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be positive");
        return 0.0d;
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return (e(g()) >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public final double nextGaussian() {
        ThreadLocal threadLocal = d;
        Double d2 = (Double) threadLocal.get();
        if (d2 != null) {
            threadLocal.set(null);
            return d2.doubleValue();
        }
        while (true) {
            double dNextDouble = (nextDouble() * 2.0d) - 1.0d;
            double dNextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d3 = (dNextDouble2 * dNextDouble2) + (dNextDouble * dNextDouble);
            if (d3 < 1.0d && d3 != 0.0d) {
                double dSqrt = StrictMath.sqrt((StrictMath.log(d3) * (-2.0d)) / d3);
                d.set(Double.valueOf(dNextDouble2 * dSqrt));
                return dNextDouble * dSqrt;
            }
        }
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        if (i <= 0) {
            com.github.catvod.spider.jdollar.nio.file.b.c("bound must be positive");
            return 0;
        }
        int iE = e(g());
        int i2 = i - 1;
        if ((i & i2) == 0) {
            return iE & i2;
        }
        while (true) {
            int i3 = iE >>> 1;
            int i4 = i3 + i2;
            int i5 = i3 % i;
            if (i4 - i5 >= 0) {
                return i5;
            }
            iE = e(g());
        }
    }

    public long nextLong(long j) {
        if (j <= 0) {
            com.github.catvod.spider.jdollar.nio.file.b.c("bound must be positive");
            return 0L;
        }
        long jF = f(g());
        long j2 = j - 1;
        if ((j & j2) == 0) {
            return jF & j2;
        }
        while (true) {
            long j3 = jF >>> 1;
            long j4 = j3 + j2;
            long j5 = j3 % j;
            if (j4 - j5 >= 0) {
                return j5;
            }
            jF = f(g());
        }
    }

    @Override // java.util.Random
    public final void setSeed(long j) {
        if (this.c) {
            throw new UnsupportedOperationException();
        }
    }

    public /* synthetic */ ThreadLocalRandom(int i) {
        this();
    }

    @Override // java.util.Random
    public final int nextInt() {
        return e(g());
    }

    public int nextInt(int i, int i2) {
        if (i < i2) {
            return b(i, i2);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return 0;
    }

    @Override // java.util.Random
    public final IntStream ints() {
        v vVar = new v(0L, Long.MAX_VALUE, ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE, 0);
        return c1.g(new x0(vVar, b7.j(vVar), false));
    }

    @Override // java.util.Random
    public final DoubleStream doubles() {
        u uVar = new u(0L, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d);
        return c0.g(new x(uVar, b7.j(uVar), false));
    }

    @Override // java.util.Random
    public final LongStream longs() {
        w wVar = new w(0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L);
        return m1.g(new h1(wVar, b7.j(wVar), false));
    }

    @Override // java.util.Random
    public final double nextDouble() {
        return (f(g()) >>> 11) * 1.1102230246251565E-16d;
    }

    public final double nextDouble(double d2, double d3) {
        if (d2 < d3) {
            return a(d2, d3);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return 0.0d;
    }

    @Override // java.util.Random
    public final IntStream ints(long j) {
        if (j >= 0) {
            v vVar = new v(0L, j, ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE, 0);
            return c1.g(new x0(vVar, b7.j(vVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("size must be non-negative");
        return null;
    }

    @Override // java.util.Random
    public final DoubleStream doubles(long j) {
        if (j >= 0) {
            u uVar = new u(0L, j, Double.MAX_VALUE, 0.0d);
            return c0.g(new x(uVar, b7.j(uVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("size must be non-negative");
        return null;
    }

    @Override // java.util.Random
    public final LongStream longs(long j) {
        if (j >= 0) {
            w wVar = new w(0L, j, Long.MAX_VALUE, 0L);
            return m1.g(new h1(wVar, b7.j(wVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("size must be non-negative");
        return null;
    }

    @Override // java.util.Random
    public final long nextLong() {
        return f(g());
    }

    public long nextLong(long j, long j2) {
        if (j < j2) {
            return c(j, j2);
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return 0L;
    }

    @Override // java.util.Random
    public final IntStream ints(int i, int i2) {
        if (i < i2) {
            v vVar = new v(0L, Long.MAX_VALUE, i, i2);
            return c1.g(new x0(vVar, b7.j(vVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final DoubleStream doubles(double d2, double d3) {
        if (d2 < d3) {
            u uVar = new u(0L, Long.MAX_VALUE, d2, d3);
            return c0.g(new x(uVar, b7.j(uVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return null;
    }

    @Override // java.util.Random
    public final LongStream longs(long j, long j2) {
        if (j < j2) {
            w wVar = new w(0L, Long.MAX_VALUE, j, j2);
            return m1.g(new h1(wVar, b7.j(wVar), false));
        }
        com.github.catvod.spider.jdollar.nio.file.b.c("bound must be greater than origin");
        return null;
    }
}
