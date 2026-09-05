package com.github.catvod.spider.merge.y0;

import com.github.catvod.spider.merge.u.c2;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j implements l, k, Cloneable, ByteChannel {
    public m0 a;
    public long b;

    public final byte A(long j) {
        c2.g(this.b, j, 1L);
        m0 m0Var = this.a;
        m0Var.getClass();
        long j2 = this.b;
        if (j2 - j < j) {
            while (j2 > j) {
                m0Var = m0Var.g;
                m0Var.getClass();
                j2 -= m0Var.c - m0Var.b;
            }
            return m0Var.a[(int) ((m0Var.b + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = m0Var.c;
            int i2 = m0Var.b;
            long j4 = (i - i2) + j3;
            if (j4 > j) {
                return m0Var.a[(int) ((i2 + j) - j3)];
            }
            m0Var = m0Var.f;
            m0Var.getClass();
            j3 = j4;
        }
    }

    public final long B(byte b, long j, long j2) {
        m0 m0Var;
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + this.b + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        long j4 = this.b;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j == j2 || (m0Var = this.a) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                m0Var = m0Var.g;
                m0Var.getClass();
                j4 -= m0Var.c - m0Var.b;
            }
            while (j4 < j2) {
                byte[] bArr = m0Var.a;
                int iMin = (int) Math.min(m0Var.c, (m0Var.b + j2) - j4);
                for (int i = (int) ((m0Var.b + j) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return (i - m0Var.b) + j4;
                    }
                }
                j4 += m0Var.c - m0Var.b;
                m0Var = m0Var.f;
                m0Var.getClass();
                j = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = (m0Var.c - m0Var.b) + j3;
            if (j5 > j) {
                break;
            }
            m0Var = m0Var.f;
            m0Var.getClass();
            j3 = j5;
        }
        while (j3 < j2) {
            byte[] bArr2 = m0Var.a;
            int iMin2 = (int) Math.min(m0Var.c, (m0Var.b + j2) - j3);
            for (int i2 = (int) ((m0Var.b + j) - j3); i2 < iMin2; i2++) {
                if (bArr2[i2] == b) {
                    return (i2 - m0Var.b) + j3;
                }
            }
            j3 += m0Var.c - m0Var.b;
            m0Var = m0Var.f;
            m0Var.getClass();
            j = j3;
        }
        return -1L;
    }

    public final long C(m mVar) {
        int i;
        int i2;
        mVar.getClass();
        mVar.getClass();
        m0 m0Var = this.a;
        if (m0Var == null) {
            return -1L;
        }
        long j = this.b;
        long j2 = 0;
        if (j < 0) {
            while (j > 0) {
                m0Var = m0Var.g;
                m0Var.getClass();
                j -= m0Var.c - m0Var.b;
            }
            if (mVar.d() == 2) {
                byte bI = mVar.i(0);
                byte bI2 = mVar.i(1);
                while (j < this.b) {
                    byte[] bArr = m0Var.a;
                    i = (int) ((m0Var.b + j2) - j);
                    int i3 = m0Var.c;
                    while (i < i3) {
                        byte b = bArr[i];
                        if (b == bI || b == bI2) {
                            i2 = m0Var.b;
                        } else {
                            i++;
                        }
                    }
                    j2 = (m0Var.c - m0Var.b) + j;
                    m0Var = m0Var.f;
                    m0Var.getClass();
                    j = j2;
                }
                return -1L;
            }
            byte[] bArrH = mVar.h();
            while (j < this.b) {
                byte[] bArr2 = m0Var.a;
                i = (int) ((m0Var.b + j2) - j);
                int i4 = m0Var.c;
                while (i < i4) {
                    byte b2 = bArr2[i];
                    for (byte b3 : bArrH) {
                        if (b2 == b3) {
                            i2 = m0Var.b;
                        }
                    }
                    i++;
                }
                j2 = (m0Var.c - m0Var.b) + j;
                m0Var = m0Var.f;
                m0Var.getClass();
                j = j2;
            }
            return -1L;
        }
        j = 0;
        while (true) {
            long j3 = (m0Var.c - m0Var.b) + j;
            if (j3 > 0) {
                break;
            }
            m0Var = m0Var.f;
            m0Var.getClass();
            j = j3;
        }
        if (mVar.d() == 2) {
            byte bI3 = mVar.i(0);
            byte bI4 = mVar.i(1);
            while (j < this.b) {
                byte[] bArr3 = m0Var.a;
                i = (int) ((m0Var.b + j2) - j);
                int i5 = m0Var.c;
                while (i < i5) {
                    byte b4 = bArr3[i];
                    if (b4 == bI3 || b4 == bI4) {
                        i2 = m0Var.b;
                    } else {
                        i++;
                    }
                }
                j2 = (m0Var.c - m0Var.b) + j;
                m0Var = m0Var.f;
                m0Var.getClass();
                j = j2;
            }
            return -1L;
        }
        byte[] bArrH2 = mVar.h();
        while (j < this.b) {
            byte[] bArr4 = m0Var.a;
            i = (int) ((m0Var.b + j2) - j);
            int i6 = m0Var.c;
            while (i < i6) {
                byte b5 = bArr4[i];
                for (byte b6 : bArrH2) {
                    if (b5 == b6) {
                        i2 = m0Var.b;
                    }
                }
                i++;
            }
            j2 = (m0Var.c - m0Var.b) + j;
            m0Var = m0Var.f;
            m0Var.getClass();
            j = j2;
        }
        return -1L;
        return (i - i2) + j;
    }

    public final boolean D(int i, m mVar, long j) {
        mVar.getClass();
        if (i >= 0 && j >= 0 && i + j <= this.b && i <= mVar.d()) {
            return i == 0 || com.github.catvod.spider.merge.z0.a.a(this, mVar, j, j + 1, i) != -1;
        }
        return false;
    }

    public final void E(h hVar) {
        hVar.getClass();
        byte[] bArr = com.github.catvod.spider.merge.z0.a.a;
        if (hVar.a != null) {
            com.github.catvod.spider.merge.s0.a.h("already attached to a buffer");
        } else {
            hVar.a = this;
            hVar.b = true;
        }
    }

    public final byte[] F(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount: ", j));
            return null;
        }
        if (this.b < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public final short G() throws EOFException {
        short s = readShort();
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public final String H(long j, Charset charset) throws EOFException {
        charset.getClass();
        if (j < 0 || j > 2147483647L) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount: ", j));
            return null;
        }
        if (this.b < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        m0 m0Var = this.a;
        m0Var.getClass();
        int i = m0Var.b;
        if (i + j > m0Var.c) {
            return new String(F(j), charset);
        }
        int i2 = (int) j;
        String str = new String(m0Var.a, i, i2, charset);
        int i3 = m0Var.b + i2;
        m0Var.b = i3;
        this.b -= j;
        if (i3 == m0Var.c) {
            this.a = m0Var.a();
            n0.a(m0Var);
        }
        return str;
    }

    public final String I() {
        return H(this.b, Charsets.UTF_8);
    }

    public final int J() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.b == 0) {
            throw new EOFException();
        }
        byte bA = A(0L);
        if ((bA & 128) == 0) {
            i = bA & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((bA & 224) == 192) {
            i = bA & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bA & 240) == 224) {
            i = bA & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bA & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = bA & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.b < j) {
            StringBuilder sbR = com.github.catvod.spider.merge.b.b.r(i2, "size < ", ": ");
            sbR.append(this.b);
            sbR.append(" (to read code point prefixed 0x");
            sbR.append(c2.Z(bA));
            sbR.append(')');
            throw new EOFException(sbR.toString());
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bA2 = A(j2);
            if ((bA2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i = (i << 6) | (bA2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 > i || i >= 57344) && i >= i3) {
            return i;
        }
        return 65533;
    }

    public final m K(int i) {
        if (i == 0) {
            return m.d;
        }
        c2.g(this.b, 0L, i);
        m0 m0Var = this.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            m0Var.getClass();
            int i5 = m0Var.c;
            int i6 = m0Var.b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            m0Var = m0Var.f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        m0 m0Var2 = this.a;
        int i7 = 0;
        while (i2 < i) {
            m0Var2.getClass();
            bArr[i7] = m0Var2.a;
            i2 += m0Var2.c - m0Var2.b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = m0Var2.b;
            m0Var2.d = true;
            i7++;
            m0Var2 = m0Var2.f;
        }
        return new o0(bArr, iArr);
    }

    public final m0 L(int i) {
        if (i < 1 || i > 8192) {
            com.github.catvod.spider.merge.s0.a.r("unexpected capacity");
            return null;
        }
        m0 m0Var = this.a;
        if (m0Var == null) {
            m0 m0VarB = n0.b();
            this.a = m0VarB;
            m0VarB.g = m0VarB;
            m0VarB.f = m0VarB;
            return m0VarB;
        }
        m0 m0Var2 = m0Var.g;
        m0Var2.getClass();
        if (m0Var2.c + i <= 8192 && m0Var2.e) {
            return m0Var2;
        }
        m0 m0VarB2 = n0.b();
        m0Var2.b(m0VarB2);
        return m0VarB2;
    }

    public final void M(m mVar) {
        mVar.getClass();
        mVar.s(mVar.d(), this);
    }

    public final void N(int i) {
        m0 m0VarL = L(1);
        byte[] bArr = m0VarL.a;
        int i2 = m0VarL.c;
        m0VarL.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
    }

    public final void O(long j) {
        boolean z;
        if (j == 0) {
            N(48);
            return;
        }
        if (j < 0) {
            j = -j;
            if (j < 0) {
                T("-9223372036854775808");
                return;
            }
            z = true;
        } else {
            z = false;
        }
        byte[] bArr = com.github.catvod.spider.merge.z0.a.a;
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j)) * 10) >>> 5;
        int i = iNumberOfLeadingZeros + (j > com.github.catvod.spider.merge.z0.a.b[iNumberOfLeadingZeros] ? 1 : 0);
        if (z) {
            i++;
        }
        m0 m0VarL = L(i);
        byte[] bArr2 = m0VarL.a;
        int i2 = m0VarL.c + i;
        while (j != 0) {
            i2--;
            bArr2[i2] = com.github.catvod.spider.merge.z0.a.a[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr2[i2 - 1] = 45;
        }
        m0VarL.c += i;
        this.b += i;
    }

    public final void P(long j) {
        if (j == 0) {
            N(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        m0 m0VarL = L(i);
        byte[] bArr = m0VarL.a;
        int i2 = m0VarL.c;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = com.github.catvod.spider.merge.z0.a.a[(int) (15 & j)];
            j >>>= 4;
        }
        m0VarL.c += i;
        this.b += i;
    }

    public final void Q(int i) {
        m0 m0VarL = L(4);
        byte[] bArr = m0VarL.a;
        int i2 = m0VarL.c;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        m0VarL.c = i2 + 4;
        this.b += 4;
    }

    public final void R(int i) {
        m0 m0VarL = L(2);
        byte[] bArr = m0VarL.a;
        int i2 = m0VarL.c;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        m0VarL.c = i2 + 2;
        this.b += 2;
    }

    public final void S(String str, int i, int i2, Charset charset) {
        if (i < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.j(i, "beginIndex < 0: "));
            return;
        }
        if (i2 < i) {
            com.github.catvod.spider.merge.s0.a.s("endIndex < beginIndex: ", i2, i, " < ");
            return;
        }
        if (i2 > str.length()) {
            com.github.catvod.spider.merge.s0.a.u(com.github.catvod.spider.merge.b.b.r(i2, "endIndex > string.length: ", " > "), str.length());
        } else {
            if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                U(str, i, i2);
                return;
            }
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            bytes.getClass();
            m25write(bytes, 0, bytes.length);
        }
    }

    public final void T(String str) {
        str.getClass();
        U(str, 0, str.length());
    }

    public final void U(String str, int i, int i2) {
        char cCharAt;
        str.getClass();
        if (i < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.j(i, "beginIndex < 0: "));
            return;
        }
        if (i2 < i) {
            com.github.catvod.spider.merge.s0.a.s("endIndex < beginIndex: ", i2, i, " < ");
            return;
        }
        if (i2 > str.length()) {
            com.github.catvod.spider.merge.s0.a.u(com.github.catvod.spider.merge.b.b.r(i2, "endIndex > string.length: ", " > "), str.length());
            return;
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                m0 m0VarL = L(1);
                byte[] bArr = m0VarL.a;
                int i3 = m0VarL.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = m0VarL.c;
                int i6 = (i3 + i) - i5;
                m0VarL.c = i5 + i6;
                this.b += i6;
            } else {
                if (cCharAt2 < 2048) {
                    m0 m0VarL2 = L(2);
                    byte[] bArr2 = m0VarL2.a;
                    int i7 = m0VarL2.c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    m0VarL2.c = i7 + 2;
                    this.b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    m0 m0VarL3 = L(3);
                    byte[] bArr3 = m0VarL3.a;
                    int i8 = m0VarL3.c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    m0VarL3.c = i8 + 3;
                    this.b += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        N(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        m0 m0VarL4 = L(4);
                        byte[] bArr4 = m0VarL4.a;
                        int i11 = m0VarL4.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        m0VarL4.c = i11 + 4;
                        this.b += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void V(int i) {
        if (i < 128) {
            N(i);
            return;
        }
        if (i < 2048) {
            m0 m0VarL = L(2);
            byte[] bArr = m0VarL.a;
            int i2 = m0VarL.c;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            m0VarL.c = i2 + 2;
            this.b += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            N(63);
            return;
        }
        if (i < 65536) {
            m0 m0VarL2 = L(3);
            byte[] bArr2 = m0VarL2.a;
            int i3 = m0VarL2.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            m0VarL2.c = i3 + 3;
            this.b += 3;
            return;
        }
        if (i > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + c2.a0(i));
        }
        m0 m0VarL3 = L(4);
        byte[] bArr3 = m0VarL3.a;
        int i4 = m0VarL3.c;
        bArr3[i4] = (byte) ((i >> 18) | 240);
        bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i4 + 3] = (byte) ((i & 63) | 128);
        m0VarL3.c = i4 + 4;
        this.b += 4;
    }

    @Override // com.github.catvod.spider.merge.y0.l, com.github.catvod.spider.merge.y0.k
    public final j a() {
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k b(String str, int i, int i2) {
        U(str, i, i2);
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k c(long j) {
        P(j);
        return this;
    }

    public final Object clone() {
        j jVar = new j();
        if (this.b == 0) {
            return jVar;
        }
        m0 m0Var = this.a;
        m0Var.getClass();
        m0 m0VarC = m0Var.c();
        jVar.a = m0VarC;
        m0VarC.g = m0VarC;
        m0VarC.f = m0VarC;
        for (m0 m0Var2 = m0Var.f; m0Var2 != m0Var; m0Var2 = m0Var2.f) {
            m0 m0Var3 = m0VarC.g;
            m0Var3.getClass();
            m0Var2.getClass();
            m0Var3.b(m0Var2.c());
        }
        jVar.b = this.b;
        return jVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.github.catvod.spider.merge.y0.p0
    public final void close() {
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final m d() {
        return e(this.b);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final m e(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount: ", j));
            return null;
        }
        if (this.b < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new m(F(j));
        }
        m mVarK = K((int) j);
        skip(j);
        return mVarK;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        long j = this.b;
        j jVar = (j) obj;
        if (j != jVar.b) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        m0 m0Var = this.a;
        m0Var.getClass();
        m0 m0Var2 = jVar.a;
        m0Var2.getClass();
        int i = m0Var.b;
        int i2 = m0Var2.b;
        long j2 = 0;
        while (j2 < this.b) {
            long jMin = Math.min(m0Var.c - i, m0Var2.c - i2);
            long j3 = 0;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (m0Var.a[i] != m0Var2.a[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == m0Var.c) {
                m0Var = m0Var.f;
                m0Var.getClass();
                i = m0Var.b;
            }
            if (i2 == m0Var2.c) {
                m0Var2 = m0Var2.f;
                m0Var2.getClass();
                i2 = m0Var2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final boolean f(long j, m mVar) {
        mVar.getClass();
        return D(mVar.d(), mVar, j);
    }

    @Override // com.github.catvod.spider.merge.y0.k, com.github.catvod.spider.merge.y0.p0, java.io.Flushable
    public final void flush() {
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final void g(j jVar, long j) throws EOFException {
        jVar.getClass();
        long j2 = this.b;
        if (j2 >= j) {
            jVar.write(this, j);
        } else {
            jVar.write(this, j2);
            throw new EOFException();
        }
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k h(int i) {
        V(i);
        return this;
    }

    public final int hashCode() {
        m0 m0Var = this.a;
        if (m0Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = m0Var.c;
            for (int i3 = m0Var.b; i3 < i2; i3++) {
                i = (i * 31) + m0Var.a[i3];
            }
            m0Var = m0Var.f;
            m0Var.getClass();
        } while (m0Var != this.a);
        return i;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final int i(f0 f0Var) throws EOFException {
        f0Var.getClass();
        int iD = com.github.catvod.spider.merge.z0.a.d(this, f0Var, false);
        if (iD == -1) {
            return -1;
        }
        skip(f0Var.a[iD].d());
        return iD;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final void j() throws EOFException {
        skip(this.b);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final long k(long j, m mVar) {
        mVar.getClass();
        byte[] bArr = com.github.catvod.spider.merge.z0.a.a;
        return com.github.catvod.spider.merge.z0.a.a(this, mVar, 0L, j, mVar.d());
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final String l() {
        return s(Long.MAX_VALUE);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final byte[] m() {
        return F(this.b);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final boolean n() {
        return this.b == 0;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k o(m mVar) {
        M(mVar);
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final long p(r0 r0Var) {
        r0Var.getClass();
        long j = 0;
        while (true) {
            long j2 = r0Var.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final l0 peek() {
        return new l0(new h0(this));
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k q() {
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r1 = new com.github.catvod.spider.merge.y0.j();
        r1.O(r8);
        r1.N(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if (r2 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: ".concat(r1.I()));
     */
    @Override // com.github.catvod.spider.merge.y0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long r() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.y0.j.r():long");
    }

    public final int read(byte[] bArr, int i, int i2) {
        bArr.getClass();
        c2.g(bArr.length, i, i2);
        m0 m0Var = this.a;
        if (m0Var == null) {
            return -1;
        }
        int iMin = Math.min(i2, m0Var.c - m0Var.b);
        byte[] bArr2 = m0Var.a;
        int i3 = m0Var.b;
        ArraysKt.copyInto(bArr2, bArr, i, i3, i3 + iMin);
        int i4 = m0Var.b + iMin;
        m0Var.b = i4;
        this.b -= iMin;
        if (i4 == m0Var.c) {
            this.a = m0Var.a();
            n0.a(m0Var);
        }
        return iMin;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final byte readByte() throws EOFException {
        if (this.b == 0) {
            throw new EOFException();
        }
        m0 m0Var = this.a;
        m0Var.getClass();
        int i = m0Var.b;
        int i2 = m0Var.c;
        int i3 = i + 1;
        byte b = m0Var.a[i];
        this.b--;
        if (i3 != i2) {
            m0Var.b = i3;
            return b;
        }
        this.a = m0Var.a();
        n0.a(m0Var);
        return b;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final void readFully(byte[] bArr) throws EOFException {
        bArr.getClass();
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final int readInt() throws EOFException {
        if (this.b < 4) {
            throw new EOFException();
        }
        m0 m0Var = this.a;
        m0Var.getClass();
        int i = m0Var.b;
        int i2 = m0Var.c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = m0Var.a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.b -= 4;
        if (i5 != i2) {
            m0Var.b = i5;
            return i6;
        }
        this.a = m0Var.a();
        n0.a(m0Var);
        return i6;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final long readLong() throws EOFException {
        if (this.b < 8) {
            throw new EOFException();
        }
        m0 m0Var = this.a;
        m0Var.getClass();
        int i = m0Var.b;
        int i2 = m0Var.c;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = m0Var.a;
        int i3 = i + 7;
        long j = ((bArr[i + 3] & 255) << 32) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (bArr[i3] & 255);
        this.b -= 8;
        if (i4 != i2) {
            m0Var.b = i4;
            return j2;
        }
        this.a = m0Var.a();
        n0.a(m0Var);
        return j2;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final short readShort() throws EOFException {
        if (this.b < 2) {
            throw new EOFException();
        }
        m0 m0Var = this.a;
        m0Var.getClass();
        int i = m0Var.b;
        int i2 = m0Var.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = m0Var.a;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.b -= 2;
        if (i5 == i2) {
            this.a = m0Var.a();
            n0.a(m0Var);
        } else {
            m0Var.b = i5;
        }
        return (short) i6;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final boolean request(long j) {
        return this.b >= j;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final String s(long j) throws EOFException {
        if (j < 0) {
            com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("limit < 0: ", j));
            return null;
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jB = B((byte) 10, 0L, j2);
        if (jB != -1) {
            return com.github.catvod.spider.merge.z0.a.c(this, jB);
        }
        if (j2 < this.b && A(j2 - 1) == 13 && A(j2) == 10) {
            return com.github.catvod.spider.merge.z0.a.c(this, j2);
        }
        j jVar = new j();
        z(jVar, 0L, Math.min(32L, this.b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.b, j) + " content=" + jVar.e(jVar.b).e() + (char) 8230);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            m0 m0Var = this.a;
            if (m0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, m0Var.c - m0Var.b);
            long j2 = iMin;
            this.b -= j2;
            j -= j2;
            int i = m0Var.b + iMin;
            m0Var.b = i;
            if (i == m0Var.c) {
                this.a = m0Var.a();
                n0.a(m0Var);
            }
        }
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final void t(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final u0 timeout() {
        return u0.NONE;
    }

    public final String toString() {
        long j = this.b;
        if (j <= 2147483647L) {
            return K((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.b).toString());
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k u(String str) {
        T(str);
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k v(long j) {
        O(j);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0095 A[EDGE_INSN: B:43:0x0095->B:37:0x0095 BREAK  A[LOOP:0: B:5:0x000b->B:45:?], SYNTHETIC] */
    @Override // com.github.catvod.spider.merge.y0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long w() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9c
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.github.catvod.spider.merge.y0.m0 r6 = r15.a
            r6.getClass()
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.c
        L16:
            if (r8 >= r9) goto L81
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L25
            r11 = 57
            if (r10 > r11) goto L25
            int r11 = r10 + (-48)
            goto L3a
        L25:
            r11 = 97
            if (r10 < r11) goto L30
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L30
            int r11 = r10 + (-87)
            goto L3a
        L30:
            r11 = 65
            if (r10 < r11) goto L65
            r11 = 70
            if (r10 > r11) goto L65
            int r11 = r10 + (-55)
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L16
        L4a:
            com.github.catvod.spider.merge.y0.j r0 = new com.github.catvod.spider.merge.y0.j
            r0.<init>()
            r0.P(r4)
            r0.N(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.I()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L65:
            if (r0 == 0) goto L69
            r1 = 1
            goto L81
        L69:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = com.github.catvod.spider.merge.u.c2.Z(r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L81:
            if (r8 != r9) goto L8d
            com.github.catvod.spider.merge.y0.m0 r7 = r6.a()
            r15.a = r7
            com.github.catvod.spider.merge.y0.n0.a(r6)
            goto L8f
        L8d:
            r6.b = r8
        L8f:
            if (r1 != 0) goto L95
            com.github.catvod.spider.merge.y0.m0 r6 = r15.a
            if (r6 != 0) goto Lb
        L95:
            long r1 = r15.b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.b = r1
            return r4
        L9c:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.y0.j.w():long");
    }

    @Override // com.github.catvod.spider.merge.y0.p0
    public final void write(j jVar, long j) {
        m0 m0VarB;
        jVar.getClass();
        if (jVar == this) {
            com.github.catvod.spider.merge.s0.a.r("source == this");
            return;
        }
        c2.g(jVar.b, 0L, j);
        while (j > 0) {
            m0 m0Var = jVar.a;
            m0Var.getClass();
            int i = m0Var.c;
            jVar.a.getClass();
            int i2 = 0;
            if (j < i - r1.b) {
                m0 m0Var2 = this.a;
                m0 m0Var3 = m0Var2 != null ? m0Var2.g : null;
                if (m0Var3 != null && m0Var3.e) {
                    if ((m0Var3.c + j) - (m0Var3.d ? 0 : m0Var3.b) <= 8192) {
                        m0 m0Var4 = jVar.a;
                        m0Var4.getClass();
                        m0Var4.d(m0Var3, (int) j);
                        jVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                m0 m0Var5 = jVar.a;
                m0Var5.getClass();
                int i3 = (int) j;
                if (i3 <= 0 || i3 > m0Var5.c - m0Var5.b) {
                    com.github.catvod.spider.merge.s0.a.r("byteCount out of range");
                    return;
                }
                if (i3 >= 1024) {
                    m0VarB = m0Var5.c();
                } else {
                    m0VarB = n0.b();
                    byte[] bArr = m0Var5.a;
                    byte[] bArr2 = m0VarB.a;
                    int i4 = m0Var5.b;
                    ArraysKt.n(i4, i4 + i3, bArr, bArr2);
                }
                m0VarB.c = m0VarB.b + i3;
                m0Var5.b += i3;
                m0 m0Var6 = m0Var5.g;
                m0Var6.getClass();
                m0Var6.b(m0VarB);
                jVar.a = m0VarB;
            }
            m0 m0Var7 = jVar.a;
            m0Var7.getClass();
            long j2 = m0Var7.c - m0Var7.b;
            jVar.a = m0Var7.a();
            m0 m0Var8 = this.a;
            if (m0Var8 == null) {
                this.a = m0Var7;
                m0Var7.g = m0Var7;
                m0Var7.f = m0Var7;
            } else {
                m0 m0Var9 = m0Var8.g;
                m0Var9.getClass();
                m0Var9.b(m0Var7);
                m0 m0Var10 = m0Var7.g;
                if (m0Var10 == m0Var7) {
                    com.github.catvod.spider.merge.s0.a.h("cannot compact");
                    return;
                }
                m0Var10.getClass();
                if (m0Var10.e) {
                    int i5 = m0Var7.c - m0Var7.b;
                    m0 m0Var11 = m0Var7.g;
                    m0Var11.getClass();
                    int i6 = 8192 - m0Var11.c;
                    m0 m0Var12 = m0Var7.g;
                    m0Var12.getClass();
                    if (!m0Var12.d) {
                        m0 m0Var13 = m0Var7.g;
                        m0Var13.getClass();
                        i2 = m0Var13.b;
                    }
                    if (i5 <= i6 + i2) {
                        m0 m0Var14 = m0Var7.g;
                        m0Var14.getClass();
                        m0Var7.d(m0Var14, i5);
                        m0Var7.a();
                        n0.a(m0Var7);
                    }
                }
            }
            jVar.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k writeByte(int i) {
        N(i);
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k writeInt(int i) {
        Q(i);
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k writeShort(int i) {
        R(i);
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final String x(Charset charset) {
        charset.getClass();
        return H(this.b, charset);
    }

    @Override // com.github.catvod.spider.merge.y0.l
    public final InputStream y() {
        return new i(this);
    }

    public final void z(j jVar, long j, long j2) {
        jVar.getClass();
        long j3 = j;
        c2.g(this.b, j3, j2);
        if (j2 == 0) {
            return;
        }
        jVar.b += j2;
        m0 m0Var = this.a;
        while (true) {
            m0Var.getClass();
            long j4 = m0Var.c - m0Var.b;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            m0Var = m0Var.f;
        }
        m0 m0Var2 = m0Var;
        long j5 = j2;
        while (j5 > 0) {
            m0Var2.getClass();
            m0 m0VarC = m0Var2.c();
            int i = m0VarC.b + ((int) j3);
            m0VarC.b = i;
            m0VarC.c = Math.min(i + ((int) j5), m0VarC.c);
            m0 m0Var3 = jVar.a;
            if (m0Var3 == null) {
                m0VarC.g = m0VarC;
                m0VarC.f = m0VarC;
                jVar.a = m0VarC;
            } else {
                m0 m0Var4 = m0Var3.g;
                m0Var4.getClass();
                m0Var4.b(m0VarC);
            }
            j5 -= m0VarC.c - m0VarC.b;
            m0Var2 = m0Var2.f;
            j3 = 0;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        m0 m0Var = this.a;
        if (m0Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), m0Var.c - m0Var.b);
        byteBuffer.put(m0Var.a, m0Var.b, iMin);
        int i = m0Var.b + iMin;
        m0Var.b = i;
        this.b -= iMin;
        if (i == m0Var.c) {
            this.a = m0Var.a();
            n0.a(m0Var);
        }
        return iMin;
    }

    @Override // com.github.catvod.spider.merge.y0.r0
    public final long read(j jVar, long j) {
        jVar.getClass();
        if (j >= 0) {
            long j2 = this.b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            jVar.write(this, j);
            return j;
        }
        com.github.catvod.spider.merge.s0.a.e(com.github.catvod.spider.merge.b.b.m("byteCount < 0: ", j));
        return 0L;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final /* bridge */ /* synthetic */ k write(byte[] bArr, int i, int i2) {
        m25write(bArr, i, i2);
        return this;
    }

    @Override // com.github.catvod.spider.merge.y0.k
    public final k write(byte[] bArr) {
        bArr.getClass();
        m25write(bArr, 0, bArr.length);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            m0 m0VarL = L(1);
            int iMin = Math.min(i, 8192 - m0VarL.c);
            byteBuffer.get(m0VarL.a, m0VarL.c, iMin);
            i -= iMin;
            m0VarL.c += iMin;
        }
        this.b += iRemaining;
        return iRemaining;
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m25write(byte[] bArr, int i, int i2) {
        bArr.getClass();
        long j = i2;
        c2.g(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            m0 m0VarL = L(1);
            int iMin = Math.min(i3 - i, 8192 - m0VarL.c);
            int i4 = i + iMin;
            ArraysKt.copyInto(bArr, m0VarL.a, m0VarL.c, i, i4);
            m0VarL.c += iMin;
            i = i4;
        }
        this.b += j;
    }
}
