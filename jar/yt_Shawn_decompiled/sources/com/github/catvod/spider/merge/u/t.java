package com.github.catvod.spider.merge.u;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t extends u {
    public final byte[] c;
    public final int d;
    public int e;
    public final OutputStream f;

    public t(OutputStream outputStream, int i) {
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.f = outputStream;
        if (i < 0) {
            com.github.catvod.spider.merge.s0.a.r("bufferSize must be >= 0");
            throw null;
        }
        byte[] bArr = new byte[Math.max(i, 20)];
        this.c = bArr;
        this.d = bArr.length;
    }

    public final void A(long j) {
        boolean z = u.b;
        byte[] bArr = this.c;
        if (z) {
            while (true) {
                long j2 = j & (-128);
                int i = this.e;
                if (j2 == 0) {
                    this.e = i + 1;
                    b2.k(bArr, i, (byte) j);
                    return;
                } else {
                    this.e = i + 1;
                    b2.k(bArr, i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
            }
        } else {
            while (true) {
                long j3 = j & (-128);
                int i2 = this.e;
                if (j3 == 0) {
                    this.e = i2 + 1;
                    bArr[i2] = (byte) j;
                    return;
                } else {
                    this.e = i2 + 1;
                    bArr[i2] = (byte) (((int) j) | 128);
                    j >>>= 7;
                }
            }
        }
    }

    public final void B() {
        this.f.write(this.c, 0, this.e);
        this.e = 0;
    }

    public final void C(int i) {
        if (this.d - this.e < i) {
            B();
        }
    }

    public final void D(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.e;
        int i4 = this.d;
        int i5 = i4 - i3;
        byte[] bArr2 = this.c;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.e += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i3, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.e = i4;
        B();
        if (i7 > i4) {
            this.f.write(bArr, i6, i7);
        } else {
            System.arraycopy(bArr, i6, bArr2, 0, i7);
            this.e = i7;
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void g(byte b) {
        if (this.e == this.d) {
            B();
        }
        int i = this.e;
        this.c[i] = b;
        this.e = i + 1;
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void h(int i, boolean z) {
        C(11);
        y(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        int i2 = this.e;
        this.c[i2] = b;
        this.e = i2 + 1;
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void i(int i, l lVar) {
        r(i, 2);
        t(lVar.size());
        lVar.p(this);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void j(int i, int i2) {
        C(14);
        y(i, 5);
        w(i2);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void k(int i) {
        C(4);
        w(i);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void l(int i, long j) {
        C(18);
        y(i, 1);
        x(j);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void m(long j) {
        C(8);
        x(j);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void n(int i, int i2) {
        C(20);
        y(i, 0);
        if (i2 >= 0) {
            z(i2);
        } else {
            A(i2);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void o(int i) {
        if (i >= 0) {
            t(i);
        } else {
            v(i);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void p(byte[] bArr, int i, int i2) throws IOException {
        D(bArr, i, i2);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void q(int i, String str) throws d2, IOException {
        r(i, 2);
        int length = str.length() * 3;
        int iE = u.e(length);
        int i2 = iE + length;
        int i3 = this.d;
        if (i2 > i3) {
            byte[] bArr = new byte[length];
            int iY = e2.a.y(str, bArr, 0, length);
            t(iY);
            D(bArr, 0, iY);
            return;
        }
        if (i2 > i3 - this.e) {
            B();
        }
        int iE2 = u.e(str.length());
        int i4 = this.e;
        byte[] bArr2 = this.c;
        try {
            if (iE2 != iE) {
                int iA = e2.a(str);
                z(iA);
                this.e = e2.a.y(str, bArr2, this.e, iA);
                return;
            }
            int i5 = i4 + iE2;
            this.e = i5;
            int iY2 = e2.a.y(str, bArr2, i5, i3 - i5);
            this.e = i4;
            z((iY2 - i4) - iE2);
            this.e = iY2;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new s(e);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void r(int i, int i2) {
        t((i << 3) | i2);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void s(int i, int i2) {
        C(20);
        y(i, 0);
        z(i2);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void t(int i) {
        C(5);
        z(i);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void u(int i, long j) {
        C(20);
        y(i, 0);
        A(j);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void v(long j) {
        C(10);
        A(j);
    }

    public final void w(int i) {
        int i2 = this.e;
        byte[] bArr = this.c;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
        this.e = i2 + 4;
    }

    public final void x(long j) {
        int i = this.e;
        byte[] bArr = this.c;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
        this.e = i + 8;
    }

    public final void y(int i, int i2) {
        z((i << 3) | i2);
    }

    public final void z(int i) {
        boolean z = u.b;
        byte[] bArr = this.c;
        if (z) {
            while (true) {
                int i2 = i & (-128);
                int i3 = this.e;
                if (i2 == 0) {
                    this.e = i3 + 1;
                    b2.k(bArr, i3, (byte) i);
                    return;
                } else {
                    this.e = i3 + 1;
                    b2.k(bArr, i3, (byte) (i | 128));
                    i >>>= 7;
                }
            }
        } else {
            while (true) {
                int i4 = i & (-128);
                int i5 = this.e;
                if (i4 == 0) {
                    this.e = i5 + 1;
                    bArr[i5] = (byte) i;
                    return;
                } else {
                    this.e = i5 + 1;
                    bArr[i5] = (byte) (i | 128);
                    i >>>= 7;
                }
            }
        }
    }
}
