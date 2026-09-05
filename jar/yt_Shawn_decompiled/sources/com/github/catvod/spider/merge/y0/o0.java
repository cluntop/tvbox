package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.u.c2;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.collections.ArraysKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o0 extends m {
    public final transient byte[][] e;
    public final transient int[] f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(byte[][] bArr, int[] iArr) {
        super(m.d.a);
        bArr.getClass();
        this.e = bArr;
        this.f = iArr;
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final String a() {
        return u().a();
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final m c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.e;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            messageDigest.update(bArr[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        return new m(bArrDigest);
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final int d() {
        return this.f[this.e.length - 1];
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final String e() {
        return u().e();
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (mVar.d() == d() && l(0, mVar, d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final int f(byte[] bArr, int i) {
        bArr.getClass();
        return u().f(bArr, i);
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final byte[] h() {
        return t();
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.e;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            int[] iArr = this.f;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr2 = bArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.b = i4;
        return i4;
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final byte i(int i) {
        byte[][] bArr = this.e;
        int length = bArr.length - 1;
        int[] iArr = this.f;
        c2.g(iArr[length], i, 1L);
        int i2 = com.github.catvod.spider.merge.z0.b.i(this, i);
        return bArr[i2][(i - (i2 == 0 ? 0 : iArr[i2 - 1])) + iArr[bArr.length + i2]];
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final int j(byte[] bArr, int i) {
        bArr.getClass();
        return u().j(bArr, i);
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final boolean l(int i, m mVar, int i2) {
        mVar.getClass();
        if (i >= 0 && i <= d() - i2) {
            int i3 = i2 + i;
            int i4 = com.github.catvod.spider.merge.z0.b.i(this, i);
            int i5 = 0;
            while (i < i3) {
                int[] iArr = this.f;
                int i6 = i4 == 0 ? 0 : iArr[i4 - 1];
                int i7 = iArr[i4] - i6;
                byte[][] bArr = this.e;
                int i8 = iArr[bArr.length + i4];
                int iMin = Math.min(i3, i7 + i6) - i;
                if (mVar.m(bArr[i4], i5, (i - i6) + i8, iMin)) {
                    i5 += iMin;
                    i += iMin;
                    i4++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final boolean m(byte[] bArr, int i, int i2, int i3) {
        bArr.getClass();
        if (i < 0 || i > d() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int i5 = com.github.catvod.spider.merge.z0.b.i(this, i);
        while (i < i4) {
            int[] iArr = this.f;
            int i6 = i5 == 0 ? 0 : iArr[i5 - 1];
            int i7 = iArr[i5] - i6;
            byte[][] bArr2 = this.e;
            int i8 = iArr[bArr2.length + i5];
            int iMin = Math.min(i4, i7 + i6) - i;
            if (!c2.a(bArr2[i5], (i - i6) + i8, i2, bArr, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            i5++;
        }
        return true;
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final String n(Charset charset) {
        charset.getClass();
        return u().n(charset);
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final m o(int i, int i2) {
        if (i < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.k(i, "beginIndex=", " < 0"));
            return null;
        }
        if (i2 > d()) {
            StringBuilder sbR = com.github.catvod.spider.merge.b.b.r(i2, "endIndex=", " > length(");
            sbR.append(d());
            sbR.append(')');
            throw new IllegalArgumentException(sbR.toString().toString());
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            com.github.catvod.spider.merge.s0.a.s("endIndex=", i2, i, " < beginIndex=");
            return null;
        }
        if (i == 0 && i2 == d()) {
            return this;
        }
        if (i == i2) {
            return m.d;
        }
        int i4 = com.github.catvod.spider.merge.z0.b.i(this, i);
        int i5 = com.github.catvod.spider.merge.z0.b.i(this, i2 - 1);
        byte[][] bArr = this.e;
        byte[][] bArr2 = (byte[][]) ArraysKt.copyOfRange(bArr, i4, i5 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f;
        if (i4 <= i5) {
            int i6 = i4;
            int i7 = 0;
            while (true) {
                iArr[i7] = Math.min(iArr2[i6] - i, i3);
                int i8 = i7 + 1;
                iArr[i7 + bArr2.length] = iArr2[bArr.length + i6];
                if (i6 == i5) {
                    break;
                }
                i6++;
                i7 = i8;
            }
        }
        int i9 = i4 != 0 ? iArr2[i4 - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i - i9) + iArr[length];
        return new o0(bArr2, iArr);
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final m q() {
        return u().q();
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final void s(int i, j jVar) {
        int i2 = com.github.catvod.spider.merge.z0.b.i(this, 0);
        int i3 = 0;
        while (i3 < i) {
            int[] iArr = this.f;
            int i4 = i2 == 0 ? 0 : iArr[i2 - 1];
            int i5 = iArr[i2] - i4;
            byte[][] bArr = this.e;
            int i6 = iArr[bArr.length + i2];
            int iMin = Math.min(i, i5 + i4) - i3;
            int i7 = (i3 - i4) + i6;
            m0 m0Var = new m0(bArr[i2], i7, i7 + iMin, true, false);
            m0 m0Var2 = jVar.a;
            if (m0Var2 == null) {
                m0Var.g = m0Var;
                m0Var.f = m0Var;
                jVar.a = m0Var;
            } else {
                m0 m0Var3 = m0Var2.g;
                m0Var3.getClass();
                m0Var3.b(m0Var);
            }
            i3 += iMin;
            i2++;
        }
        jVar.b += i;
    }

    public final byte[] t() {
        byte[] bArr = new byte[d()];
        byte[][] bArr2 = this.e;
        int length = bArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.f;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(bArr2[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // com.github.catvod.spider.merge.y0.m
    public final String toString() {
        return u().toString();
    }

    public final m u() {
        return new m(t());
    }
}
