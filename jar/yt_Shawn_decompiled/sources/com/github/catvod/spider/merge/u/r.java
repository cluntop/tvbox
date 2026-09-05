package com.github.catvod.spider.merge.u;

import java.util.Locale;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r extends u {
    public final byte[] c;
    public final int d;
    public int e;

    public r(byte[] bArr, int i) {
        if (((bArr.length - i) | i) >= 0) {
            this.c = bArr;
            this.e = 0;
            this.d = i;
        } else {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("Array range is invalid. Buffer.length=" + bArr.length + ", offset=0, length=" + i);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void g(byte b) throws s {
        int i = this.e;
        try {
            int i2 = i + 1;
            try {
                this.c[i] = b;
                this.e = i2;
            } catch (IndexOutOfBoundsException e) {
                e = e;
                i = i2;
                throw new s(i, this.d, 1, e);
            }
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void h(int i, boolean z) throws s {
        r(i, 0);
        g(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void i(int i, l lVar) throws s {
        r(i, 2);
        t(lVar.size());
        lVar.p(this);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void j(int i, int i2) throws s {
        r(i, 5);
        k(i2);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void k(int i) throws s {
        int i2 = this.e;
        try {
            byte[] bArr = this.c;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.e = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new s(i2, this.d, 4, e);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void l(int i, long j) throws s {
        r(i, 1);
        m(j);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void m(long j) throws s {
        int i = this.e;
        try {
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
        } catch (IndexOutOfBoundsException e) {
            throw new s(i, this.d, 8, e);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void n(int i, int i2) throws s {
        r(i, 0);
        o(i2);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void o(int i) throws s {
        if (i >= 0) {
            t(i);
        } else {
            v(i);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void p(byte[] bArr, int i, int i2) throws s {
        try {
            System.arraycopy(bArr, i, this.c, this.e, i2);
            this.e += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new s(this.e, this.d, i2, e);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void q(int i, String str) throws s {
        r(i, 2);
        int i2 = this.e;
        try {
            int iE = u.e(str.length() * 3);
            int iE2 = u.e(str.length());
            byte[] bArr = this.c;
            if (iE2 != iE) {
                t(e2.a(str));
                int i3 = this.e;
                this.e = e2.a.y(str, bArr, i3, bArr.length - i3);
                return;
            }
            int i4 = i2 + iE2;
            this.e = i4;
            int iY = e2.a.y(str, bArr, i4, bArr.length - i4);
            this.e = i2;
            t((iY - i2) - iE2);
            this.e = iY;
        } catch (IndexOutOfBoundsException e) {
            throw new s(e);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void r(int i, int i2) throws s {
        t((i << 3) | i2);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void s(int i, int i2) throws s {
        r(i, 0);
        t(i2);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void t(int i) throws s {
        int i2;
        int i3 = this.e;
        while (true) {
            int i4 = i & (-128);
            byte[] bArr = this.c;
            if (i4 == 0) {
                i2 = i3 + 1;
                bArr[i3] = (byte) i;
                this.e = i2;
                return;
            } else {
                i2 = i3 + 1;
                try {
                    bArr[i3] = (byte) (i | 128);
                    i >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e) {
                    throw new s(i2, this.d, 1, e);
                }
            }
            throw new s(i2, this.d, 1, e);
        }
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void u(int i, long j) throws s {
        r(i, 0);
        v(j);
    }

    @Override // com.github.catvod.spider.merge.u.u
    public final void v(long j) throws s {
        int i;
        int i2 = this.e;
        boolean z = u.b;
        byte[] bArr = this.c;
        if (!z || w() < 10) {
            while ((j & (-128)) != 0) {
                i = i2 + 1;
                try {
                    bArr[i2] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i2 = i;
                } catch (IndexOutOfBoundsException e) {
                    throw new s(i, this.d, 1, e);
                }
            }
            i = i2 + 1;
            bArr[i2] = (byte) j;
        } else {
            while ((j & (-128)) != 0) {
                b2.k(bArr, i2, (byte) (((int) j) | 128));
                j >>>= 7;
                i2++;
            }
            i = i2 + 1;
            b2.k(bArr, i2, (byte) j);
        }
        this.e = i;
    }

    public final int w() {
        return this.d - this.e;
    }
}
