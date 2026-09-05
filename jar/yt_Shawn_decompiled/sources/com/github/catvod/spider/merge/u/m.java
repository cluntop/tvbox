package com.github.catvod.spider.merge.u;

import java.nio.charset.StandardCharsets;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class m extends p {
    public final byte[] c;
    public int d;
    public int e;
    public int f;
    public final int g;
    public int h;
    public int i = ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;

    public m(byte[] bArr, int i, int i2, boolean z) {
        this.c = bArr;
        this.d = i2 + i;
        this.f = i;
        this.g = i;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int A() {
        return F();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long B() {
        return H();
    }

    public final int C() throws u0 {
        int i = this.f;
        if (this.d - i < 4) {
            throw u0.g();
        }
        this.f = i + 4;
        byte[] bArr = this.c;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long D() throws u0 {
        int i = this.f;
        if (this.d - i < 8) {
            throw u0.g();
        }
        this.f = i + 8;
        byte[] bArr = this.c;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final int E() {
        return G();
    }

    public final int F() {
        return G();
    }

    public final int G() {
        int i;
        int i2 = this.f;
        int i3 = this.d;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.c;
            byte b = bArr[i2];
            if (b >= 0) {
                this.f = i4;
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
                this.f = i5;
                return i;
            }
        }
        return (int) I();
    }

    public final long H() {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.f;
        int i2 = this.d;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.c;
            byte b = bArr[i];
            if (b >= 0) {
                this.f = i3;
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
                this.f = i4;
                return j;
            }
        }
        return I();
    }

    public final long I() throws u0 {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.f;
            if (i2 == this.d) {
                throw u0.g();
            }
            this.f = i2 + 1;
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((this.c[i2] & 128) == 0) {
                return j;
            }
        }
        throw u0.d();
    }

    public final void J() {
        int i = this.d + this.e;
        this.d = i;
        int i2 = i - this.g;
        int i3 = this.i;
        if (i2 <= i3) {
            this.e = 0;
            return;
        }
        int i4 = i2 - i3;
        this.e = i4;
        this.d = i - i4;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final void a(int i) throws u0 {
        if (this.h != i) {
            throw new u0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int d() {
        return this.f - this.g;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final boolean e() {
        return this.f == this.d;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final void h(int i) {
        this.i = i;
        J();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int i(int i) throws u0 {
        if (i < 0) {
            throw u0.e();
        }
        int iD = d() + i;
        if (iD < 0) {
            throw new u0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i2 = this.i;
        if (iD > i2) {
            throw u0.g();
        }
        this.i = iD;
        J();
        return i2;
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final boolean j() {
        return H() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // com.github.catvod.spider.merge.u.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.merge.u.k k() throws com.github.catvod.spider.merge.u.u0 {
        /*
            r4 = this;
            int r0 = r4.F()
            byte[] r1 = r4.c
            if (r0 <= 0) goto L19
            int r2 = r4.d
            int r3 = r4.f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            com.github.catvod.spider.merge.u.k r1 = com.github.catvod.spider.merge.u.l.d(r1, r3, r0)
            int r2 = r4.f
            int r2 = r2 + r0
            r4.f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.github.catvod.spider.merge.u.k r0 = com.github.catvod.spider.merge.u.l.b
            return r0
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.d
            int r3 = r4.f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f = r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L48
            if (r0 != 0) goto L43
            byte[] r0 = com.github.catvod.spider.merge.u.s0.a
        L35:
            com.github.catvod.spider.merge.u.k r1 = com.github.catvod.spider.merge.u.l.b
            int r1 = r0.length
            if (r1 != 0) goto L3d
            com.github.catvod.spider.merge.u.k r0 = com.github.catvod.spider.merge.u.l.b
            return r0
        L3d:
            com.github.catvod.spider.merge.u.k r1 = new com.github.catvod.spider.merge.u.k
            r1.<init>(r0)
            return r1
        L43:
            com.github.catvod.spider.merge.u.u0 r0 = com.github.catvod.spider.merge.u.u0.e()
            throw r0
        L48:
            com.github.catvod.spider.merge.u.u0 r0 = com.github.catvod.spider.merge.u.u0.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.u.m.k():com.github.catvod.spider.merge.u.k");
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final double l() {
        return Double.longBitsToDouble(D());
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int m() {
        return E();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int n() {
        return C();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long o() {
        return D();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final float p() {
        return Float.intBitsToFloat(C());
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int q() {
        return E();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long r() {
        return H();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int t() {
        return C();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long u() {
        return D();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int v() {
        return p.b(F());
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final long w() {
        return p.c(H());
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final String x() throws u0 {
        int iF = F();
        if (iF > 0) {
            int i = this.d;
            int i2 = this.f;
            if (iF <= i - i2) {
                String str = new String(this.c, i2, iF, StandardCharsets.UTF_8);
                this.f += iF;
                return str;
            }
        }
        if (iF == 0) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        if (iF < 0) {
            throw u0.e();
        }
        throw u0.g();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final String y() throws u0 {
        int iF = F();
        String strS = VideoStream.RESOLUTION_UNKNOWN;
        if (iF > 0) {
            int i = this.d;
            int i2 = this.f;
            if (iF <= i - i2) {
                if (iF == 0) {
                    c2 c2Var = e2.a;
                } else {
                    strS = e2.a.s(this.c, i2, iF);
                }
                this.f += iF;
                return strS;
            }
        }
        if (iF == 0) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        if (iF <= 0) {
            throw u0.e();
        }
        throw u0.g();
    }

    @Override // com.github.catvod.spider.merge.u.p
    public final int z() throws u0 {
        if (e()) {
            this.h = 0;
            return 0;
        }
        int iF = F();
        this.h = iF;
        if ((iF >>> 3) != 0) {
            return iF;
        }
        throw u0.a();
    }
}
