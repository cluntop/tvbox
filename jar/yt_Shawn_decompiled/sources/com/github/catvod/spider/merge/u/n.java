package com.github.catvod.spider.merge.u;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n extends p {
    public final InputStream c;
    public final byte[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j = ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;

    public n(InputStream inputStream) {
        byte[] bArr = s0.a;
        if (inputStream == null) {
            throw new NullPointerException("input");
        }
        this.c = inputStream;
        this.d = new byte[4096];
        this.e = 0;
        this.g = 0;
        this.i = 0;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int A() {
        return H();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long B() {
        return I();
    }

    public final byte[] C(int i) throws IOException {
        byte[] bArrD = D(i);
        if (bArrD != null) {
            return bArrD;
        }
        int i2 = this.g;
        int i3 = this.e;
        int length = i3 - i2;
        this.i += i3;
        this.g = 0;
        this.e = 0;
        ArrayList arrayListE = E(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, i2, bArr, 0, length);
        Iterator it = arrayListE.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] D(int i) throws IOException {
        if (i == 0) {
            return s0.a;
        }
        if (i < 0) {
            throw u0.e();
        }
        int i2 = this.i;
        int i3 = this.g;
        int i4 = i2 + i3 + i;
        if (i4 - ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE > 0) {
            throw new u0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i5 = this.j;
        if (i4 > i5) {
            M((i5 - i2) - i3);
            throw u0.g();
        }
        int i6 = this.e - i3;
        int i7 = i - i6;
        InputStream inputStream = this.c;
        if (i7 >= 4096) {
            try {
                if (i7 > inputStream.available()) {
                    return null;
                }
            } catch (u0 e) {
                e.a = true;
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, this.g, bArr, 0, i6);
        this.i += this.e;
        this.g = 0;
        this.e = 0;
        while (i6 < i) {
            try {
                int i8 = inputStream.read(bArr, i6, i - i6);
                if (i8 == -1) {
                    throw u0.g();
                }
                this.i += i8;
                i6 += i8;
            } catch (u0 e2) {
                e2.a = true;
                throw e2;
            }
        }
        return bArr;
    }

    public final ArrayList E(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                try {
                    int i3 = this.c.read(bArr, i2, iMin - i2);
                    if (i3 == -1) {
                        throw u0.g();
                    }
                    this.i += i3;
                    i2 += i3;
                } catch (u0 e) {
                    e.a = true;
                    throw e;
                }
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int F() throws u0 {
        int i = this.g;
        if (this.e - i < 4) {
            L(4);
            i = this.g;
        }
        this.g = i + 4;
        byte[] bArr = this.d;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long G() throws u0 {
        int i = this.g;
        if (this.e - i < 8) {
            L(8);
            i = this.g;
        }
        this.g = i + 8;
        byte[] bArr = this.d;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final int H() {
        int i;
        int i2 = this.g;
        int i3 = this.e;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.d;
            byte b = bArr[i2];
            if (b >= 0) {
                this.g = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.g = i5;
                return i;
            }
        }
        return (int) J();
    }

    public final long I() {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.g;
        int i2 = this.e;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.d;
            byte b = bArr[i];
            if (b >= 0) {
                this.g = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            j4 = (-2080896) ^ i9;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (bArr[i8] << 28);
                            if (j6 >= 0) {
                                j2 = 266354560;
                            } else {
                                i8 = i + 6;
                                long j7 = j6 ^ (bArr[i4] << 35);
                                if (j7 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (bArr[i8] << 42);
                                    if (j6 >= 0) {
                                        j2 = 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j7 = j6 ^ (bArr[i4] << 49);
                                        if (j7 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            j6 = j7 ^ (bArr[i8] << 56);
                                            if (j6 >= 0) {
                                                j2 = 71499008037633920L;
                                            } else {
                                                int i10 = i + 10;
                                                long j8 = (bArr[i4] << 63) ^ j6;
                                                if (j8 >= 0) {
                                                    j = j8 ^ (-9151873028817141888L);
                                                    i4 = i10;
                                                }
                                            }
                                        }
                                    }
                                }
                                j4 = j3 ^ j7;
                            }
                            j = j2 ^ j6;
                        }
                        i4 = i8;
                        j = j4;
                    }
                }
                this.g = i4;
                return j;
            }
        }
        return J();
    }

    public final long J() throws u0 {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.g == this.e) {
                L(1);
            }
            int i2 = this.g;
            this.g = i2 + 1;
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((this.d[i2] & 128) == 0) {
                return j;
            }
        }
        throw u0.d();
    }

    public final void K() {
        int i = this.e + this.f;
        this.e = i;
        int i2 = this.i + i;
        int i3 = this.j;
        if (i2 <= i3) {
            this.f = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f = i4;
        this.e = i - i4;
    }

    public final void L(int i) throws u0 {
        if (N(i)) {
            return;
        }
        if (i <= (ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE - this.i) - this.g) {
            throw u0.g();
        }
        throw new u0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    public final void M(int i) throws u0 {
        int i2 = this.e;
        int i3 = this.g;
        if (i <= i2 - i3 && i >= 0) {
            this.g = i3 + i;
            return;
        }
        InputStream inputStream = this.c;
        if (i < 0) {
            throw u0.e();
        }
        int i4 = this.i;
        int i5 = i4 + i3;
        int i6 = i5 + i;
        int i7 = this.j;
        if (i6 > i7) {
            M((i7 - i4) - i3);
            throw u0.g();
        }
        this.i = i5;
        int i8 = i2 - i3;
        this.e = 0;
        this.g = 0;
        while (i8 < i) {
            long j = i - i8;
            try {
                try {
                    long jSkip = inputStream.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        throw new IllegalStateException(inputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i8 += (int) jSkip;
                    }
                } catch (u0 e) {
                    e.a = true;
                    throw e;
                }
            } catch (Throwable th) {
                this.i += i8;
                K();
                throw th;
            }
        }
        this.i += i8;
        K();
        if (i8 >= i) {
            return;
        }
        int i9 = this.e;
        int i10 = i9 - this.g;
        this.g = i9;
        L(1);
        while (true) {
            int i11 = i - i10;
            int i12 = this.e;
            if (i11 <= i12) {
                this.g = i11;
                return;
            } else {
                i10 += i12;
                this.g = i12;
                L(1);
            }
        }
    }

    public final boolean N(int i) throws IOException {
        InputStream inputStream = this.c;
        int i2 = this.g;
        int i3 = i2 + i;
        int i4 = this.e;
        if (i3 <= i4) {
            com.github.catvod.spider.merge.s0.a.h(com.github.catvod.spider.merge.b.b.k(i, "refillBuffer() called when ", " bytes were already available in buffer"));
            return false;
        }
        int i5 = this.i;
        if (i <= (ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE - i5) - i2 && i5 + i2 + i <= this.j) {
            byte[] bArr = this.d;
            if (i2 > 0) {
                if (i4 > i2) {
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.i += i2;
                this.e -= i2;
                this.g = 0;
            }
            int i6 = this.e;
            try {
                int i7 = inputStream.read(bArr, i6, Math.min(bArr.length - i6, (ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE - this.i) - i6));
                if (i7 == 0 || i7 < -1 || i7 > bArr.length) {
                    throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i7 + "\nThe InputStream implementation is buggy.");
                }
                if (i7 > 0) {
                    this.e += i7;
                    K();
                    if (this.e >= i || N(i)) {
                        return true;
                    }
                }
            } catch (u0 e) {
                e.a = true;
                throw e;
            }
        }
        return false;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final void a(int i) throws u0 {
        if (this.h != i) {
            throw new u0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int d() {
        return this.i + this.g;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final boolean e() {
        return this.g == this.e && !N(1);
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final void h(int i) {
        this.j = i;
        K();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int i(int i) throws u0 {
        if (i < 0) {
            throw u0.e();
        }
        int i2 = this.i + this.g + i;
        if (i2 < 0) {
            throw new u0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i3 = this.j;
        if (i2 > i3) {
            throw u0.g();
        }
        this.j = i2;
        K();
        return i3;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final boolean j() {
        return I() != 0;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final k k() throws IOException {
        int iH = H();
        int i = this.e;
        int i2 = this.g;
        int i3 = i - i2;
        byte[] bArr = this.d;
        if (iH <= i3 && iH > 0) {
            k kVarD = l.d(bArr, i2, iH);
            this.g += iH;
            return kVarD;
        }
        if (iH == 0) {
            return l.b;
        }
        if (iH < 0) {
            throw u0.e();
        }
        byte[] bArrD = D(iH);
        if (bArrD != null) {
            return l.d(bArrD, 0, bArrD.length);
        }
        int i4 = this.g;
        int i5 = this.e;
        int length = i5 - i4;
        this.i += i5;
        this.g = 0;
        this.e = 0;
        ArrayList arrayListE = E(iH - length);
        byte[] bArr2 = new byte[iH];
        System.arraycopy(bArr, i4, bArr2, 0, length);
        Iterator it = arrayListE.iterator();
        while (it.hasNext()) {
            byte[] bArr3 = (byte[]) it.next();
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        try {
            k kVar = l.b;
            return iH == 0 ? l.b : new k(bArr2);
        } catch (u0 e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final double l() {
        return Double.longBitsToDouble(G());
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int m() {
        return H();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int n() {
        return F();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long o() {
        return G();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final float p() {
        return Float.intBitsToFloat(F());
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int q() {
        return H();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long r() {
        return I();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int t() {
        return F();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long u() {
        return G();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int v() {
        return p.b(H());
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long w() {
        return p.c(I());
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final String x() throws u0 {
        int iH = H();
        byte[] bArr = this.d;
        if (iH > 0) {
            int i = this.e;
            int i2 = this.g;
            if (iH <= i - i2) {
                String str = new String(bArr, i2, iH, StandardCharsets.UTF_8);
                this.g += iH;
                return str;
            }
        }
        if (iH == 0) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        if (iH < 0) {
            throw u0.e();
        }
        if (iH > this.e) {
            return new String(C(iH), StandardCharsets.UTF_8);
        }
        L(iH);
        String str2 = new String(bArr, this.g, iH, StandardCharsets.UTF_8);
        this.g += iH;
        return str2;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final String y() throws IOException {
        int iH = H();
        int i = this.g;
        int i2 = this.e;
        int i3 = i2 - i;
        byte[] bArrC = this.d;
        if (iH <= i3 && iH > 0) {
            this.g = i + iH;
        } else {
            if (iH == 0) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            if (iH < 0) {
                throw u0.e();
            }
            i = 0;
            if (iH <= i2) {
                L(iH);
                this.g = iH;
            } else {
                bArrC = C(iH);
            }
        }
        if (iH != 0) {
            return e2.a.s(bArrC, i, iH);
        }
        c2 c2Var = e2.a;
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int z() throws u0 {
        if (e()) {
            this.h = 0;
            return 0;
        }
        int iH = H();
        this.h = iH;
        if ((iH >>> 3) != 0) {
            return iH;
        }
        throw u0.a();
    }
}
