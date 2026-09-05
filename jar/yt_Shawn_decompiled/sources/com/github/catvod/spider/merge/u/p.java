package com.github.catvod.spider.merge.u;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class p {
    public int a;
    public q b;

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static m f(byte[] bArr, int i, int i2, boolean z) {
        m mVar = new m(bArr, i, i2, z);
        try {
            mVar.i(i2);
            return mVar;
        } catch (u0 e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static p g(InputStream inputStream) {
        return inputStream == null ? f(s0.a, 0, 0, false) : new n(inputStream);
    }

    public static int s(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw u0.g();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw u0.g();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw u0.d();
    }

    public abstract int A();

    public abstract long B();

    public abstract void a(int i);

    public abstract int d();

    public abstract boolean e();

    public abstract void h(int i);

    public abstract int i(int i);

    public abstract boolean j();

    public abstract k k();

    public abstract double l();

    public abstract int m();

    public abstract int n();

    public abstract long o();

    public abstract float p();

    public abstract int q();

    public abstract long r();

    public abstract int t();

    public abstract long u();

    public abstract int v();

    public abstract long w();

    public abstract String x();

    public abstract String y();

    public abstract int z();
}
