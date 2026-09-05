package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.lang.Iterable;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class w6 extends c implements Iterable, Iterable {
    public Object e;
    public Object[] f;

    public w6(int i) {
        super(i);
        this.e = newArray(1 << this.a);
    }

    public Object b() {
        long jCount = count();
        if (jCount >= 2147483639) {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
            return null;
        }
        Object objNewArray = newArray((int) jCount);
        f(0, objNewArray);
        return objNewArray;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.c
    public final void clear() {
        Object[] objArr = this.f;
        if (objArr != null) {
            this.e = objArr[0];
            this.f = null;
            this.d = null;
        }
        this.b = 0;
        this.c = 0;
    }

    public void f(int i, Object obj) {
        long j = i;
        long jCount = count() + j;
        if (jCount > u(obj) || jCount < j) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.c == 0) {
            System.arraycopy(this.e, 0, obj, i, this.b);
            return;
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            Object obj2 = this.f[i2];
            System.arraycopy(obj2, 0, obj, i, u(obj2));
            i += u(this.f[i2]);
        }
        int i3 = this.b;
        if (i3 > 0) {
            System.arraycopy(this.e, 0, obj, i, i3);
        }
    }

    public void h(Object obj) {
        for (int i = 0; i < this.c; i++) {
            Object obj2 = this.f[i];
            t(obj2, 0, u(obj2), obj);
        }
        t(this.e, 0, this.b, obj);
    }

    public abstract Object newArray(int i);

    public abstract Spliterator spliterator();

    @Override // java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    public abstract void t(Object obj, int i, int i2, Object obj2);

    public abstract int u(Object obj);

    public final int v(long j) {
        if (this.c == 0) {
            if (j < this.b) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        if (j >= count()) {
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        for (int i = 0; i <= this.c; i++) {
            if (j < this.d[i] + u(this.f[i])) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException(Long.toString(j));
    }

    public final void w(long j) {
        long jU;
        int i = this.c;
        if (i == 0) {
            jU = u(this.e);
        } else {
            jU = u(this.f[i]) + this.d[i];
        }
        if (j > jU) {
            if (this.f == null) {
                Object[] objArrX = x();
                this.f = objArrX;
                this.d = new long[8];
                objArrX[0] = this.e;
            }
            int i2 = this.c + 1;
            while (j > jU) {
                Object[] objArr = this.f;
                if (i2 >= objArr.length) {
                    int length = objArr.length * 2;
                    this.f = Arrays.copyOf(objArr, length);
                    this.d = Arrays.copyOf(this.d, length);
                }
                int iMin = this.a;
                if (i2 != 0 && i2 != 1) {
                    iMin = Math.min((iMin + i2) - 1, 30);
                }
                int i3 = 1 << iMin;
                this.f[i2] = newArray(i3);
                long[] jArr = this.d;
                jArr[i2] = jArr[i2 - 1] + u(this.f[r6]);
                jU += i3;
                i2++;
            }
        }
    }

    public abstract Object[] x();

    public final void y() {
        long jU;
        if (this.b == u(this.e)) {
            if (this.f == null) {
                Object[] objArrX = x();
                this.f = objArrX;
                this.d = new long[8];
                objArrX[0] = this.e;
            }
            int i = this.c;
            int i2 = i + 1;
            Object[] objArr = this.f;
            if (i2 >= objArr.length || objArr[i2] == null) {
                if (i == 0) {
                    jU = u(this.e);
                } else {
                    jU = u(objArr[i]) + this.d[i];
                }
                w(jU + 1);
            }
            this.b = 0;
            int i3 = this.c + 1;
            this.c = i3;
            this.e = this.f[i3];
        }
    }

    public w6() {
        this.e = newArray(16);
    }
}
