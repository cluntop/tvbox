package com.github.catvod.spider.merge.f1;

import com.github.catvod.spider.merge.a1.l;
import com.github.catvod.spider.merge.a1.n;
import com.github.catvod.spider.merge.h1.g;
import com.github.catvod.spider.merge.h1.h;
import com.github.catvod.spider.merge.u.c2;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e implements a {
    public com.github.catvod.spider.merge.c1.a a;
    public com.github.catvod.spider.merge.g1.b b;
    public com.github.catvod.spider.merge.g1.a c;
    public boolean d;
    public boolean e;
    public int f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public byte[] m;
    public byte[] n;
    public byte[] o;
    public byte[] p;
    public byte[] q;
    public int r;
    public int s;
    public long t;
    public byte[] u;
    public int v;
    public long w;
    public long x;

    @Override // com.github.catvod.spider.merge.f1.a
    public final void a(boolean z, com.github.catvod.spider.merge.a1.c cVar) throws androidx.startup.b {
        byte[] bArrI;
        g gVar;
        byte b;
        byte[] bArr;
        com.github.catvod.spider.merge.g1.b bVar = this.b;
        com.github.catvod.spider.merge.c1.a aVar = this.a;
        this.d = z;
        this.m = null;
        this.e = true;
        if (cVar instanceof com.github.catvod.spider.merge.h1.a) {
            com.github.catvod.spider.merge.h1.a aVar2 = (com.github.catvod.spider.merge.h1.a) cVar;
            bArrI = c2.i(aVar2.b);
            this.i = c2.i(aVar2.a);
            int i = aVar2.d;
            if (i < 32 || i > 128 || i % 8 != 0) {
                com.github.catvod.spider.merge.s0.a.r(com.github.catvod.spider.merge.b.b.j(i, "Invalid value for MAC size: "));
                return;
            } else {
                this.f = i / 8;
                gVar = aVar2.c;
            }
        } else {
            if (!(cVar instanceof h)) {
                com.github.catvod.spider.merge.s0.a.r("invalid parameters passed to GCM");
                return;
            }
            h hVar = (h) cVar;
            bArrI = hVar.a;
            this.i = null;
            this.f = 16;
            gVar = (g) hVar.b;
        }
        this.l = new byte[z ? 16 : this.f + 16];
        if (bArrI == null || bArrI.length < 1) {
            com.github.catvod.spider.merge.s0.a.r("IV must be at least 1 byte");
            return;
        }
        if (z && (bArr = this.h) != null && Arrays.equals(bArr, bArrI)) {
            if (gVar == null) {
                com.github.catvod.spider.merge.s0.a.r("cannot reuse nonce for GCM encryption");
                return;
            }
            byte[] bArr2 = this.g;
            if (bArr2 != null && Arrays.equals(bArr2, gVar.a)) {
                com.github.catvod.spider.merge.s0.a.r("cannot reuse nonce for GCM encryption");
                return;
            }
        }
        this.h = bArrI;
        if (gVar != null) {
            this.g = gVar.a;
        }
        if (gVar != null) {
            aVar.a(true, gVar);
            byte[] bArr3 = new byte[16];
            this.j = bArr3;
            aVar.b(0, 0, bArr3, bArr3);
            byte[] bArr4 = this.j;
            if (((long[][]) bVar.c) == null) {
                bVar.c = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 256, 2);
            } else {
                byte[] bArr5 = (byte[]) bVar.b;
                int i2 = 0;
                for (int i3 = 0; i3 < 16; i3++) {
                    i2 |= bArr5[i3] ^ bArr4[i3];
                }
                b = ((byte) ((((i2 >>> 1) | (i2 & 1)) - 1) >> 31)) != 0 ? (byte) 1 : (byte) 1;
                this.c = null;
            }
            byte[] bArr6 = new byte[16];
            bVar.b = bArr6;
            for (int i4 = 0; i4 < 16; i4++) {
                bArr6[i4] = bArr4[i4];
            }
            byte[] bArr7 = (byte[]) bVar.b;
            long[] jArr = ((long[][]) bVar.c)[1];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 2; i5 < i7; i7 = 2) {
                jArr[i5] = ((c2.b(bArr7, i6) & 4294967295L) << 32) | (c2.b(bArr7, i6 + 4) & 4294967295L);
                i6 += 8;
                i5++;
            }
            long[] jArr2 = ((long[][]) bVar.c)[1];
            long j = jArr2[0];
            long j2 = jArr2[1];
            long j3 = j2 << 57;
            jArr2[0] = ((((j >>> 7) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7);
            jArr2[1] = (j << 57) | (j2 >>> 7);
            int i8 = 2;
            for (int i9 = 256; i8 < i9; i9 = 256) {
                long[][] jArr3 = (long[][]) bVar.c;
                long[] jArr4 = jArr3[i8 >> 1];
                long[] jArr5 = jArr3[i8];
                long j4 = jArr4[0];
                long j5 = jArr4[1];
                long j6 = j4 >> 63;
                long j7 = ((j4 ^ (j6 & (-2233785415175766016L))) << 1) | (j5 >>> 63);
                jArr5[0] = j7;
                long j8 = (-j6) | (j5 << 1);
                jArr5[1] = j8;
                long[] jArr6 = jArr3[1];
                long[] jArr7 = jArr3[i8 + 1];
                jArr7[0] = j7 ^ jArr6[0];
                jArr7[1] = j8 ^ jArr6[1];
                i8 += 2;
            }
            this.c = null;
        } else {
            b = 1;
            if (this.j == null) {
                com.github.catvod.spider.merge.s0.a.r("Key must be specified in initial init");
                return;
            }
        }
        byte[] bArr8 = new byte[16];
        this.k = bArr8;
        byte[] bArr9 = this.h;
        if (bArr9.length == 12) {
            System.arraycopy(bArr9, 0, bArr8, 0, bArr9.length);
            this.k[15] = b;
        } else {
            int length = bArr9.length;
            for (int i10 = 0; i10 < length; i10 += 16) {
                i(i10, Math.min(length - i10, 16), bArr8, bArr9);
            }
            byte[] bArr10 = new byte[16];
            c2.L(bArr10, 8, this.h.length * 8);
            byte[] bArr11 = this.k;
            c2.c0(bArr11, bArr10);
            bVar.g(bArr11);
        }
        this.n = new byte[16];
        this.o = new byte[16];
        this.p = new byte[16];
        this.u = new byte[16];
        this.v = 0;
        this.w = 0L;
        this.x = 0L;
        this.q = c2.i(this.k);
        this.r = -2;
        this.s = 0;
        this.t = 0L;
        byte[] bArr12 = this.i;
        if (bArr12 != null) {
            e(bArr12, 0, bArr12.length);
        }
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final int b(int i) {
        int i2 = i + this.s;
        if (!this.d) {
            int i3 = this.f;
            if (i2 < i3) {
                return 0;
            }
            i2 -= i3;
        }
        return i2 - (i2 % 16);
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final int c(int i) {
        int i2 = i + this.s;
        boolean z = this.d;
        int i3 = this.f;
        if (z) {
            return i2 + i3;
        }
        if (i2 < i3) {
            return 0;
        }
        return i2 - i3;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    @Override // com.github.catvod.spider.merge.f1.a
    public final int d(int i, int i2, byte[] bArr, byte[] bArr2) throws androidx.startup.b {
        int i3;
        f();
        if (bArr.length - i < i2) {
            throw new androidx.startup.b("Input buffer too short");
        }
        int i4 = 16;
        if (this.d) {
            int i5 = this.s;
            if (i5 > 0) {
                int i6 = 16 - i5;
                byte[] bArr3 = this.l;
                if (i2 < i6) {
                    System.arraycopy(bArr, i, bArr3, i5, i2);
                } else {
                    System.arraycopy(bArr, i, bArr3, i5, i6);
                    h(0, 0, this.l, bArr2);
                    i += i6;
                    i2 -= i6;
                }
            } else {
                i4 = 0;
            }
            int i7 = i2 + i;
            int i8 = i7 - 16;
            while (i <= i8) {
                h(i, i4, bArr, bArr2);
                i += 16;
                i4 += 16;
            }
            int i9 = i7 - i;
            this.s = i9;
            System.arraycopy(bArr, i, this.l, 0, i9);
            return i4;
        }
        byte[] bArr4 = this.l;
        int length = bArr4.length;
        int i10 = this.s;
        int i11 = length - i10;
        if (i2 >= i11) {
            if (i10 >= 16) {
                g(0, 0, bArr4, bArr2);
                byte[] bArr5 = this.l;
                int i12 = this.s - 16;
                this.s = i12;
                System.arraycopy(bArr5, 16, bArr5, 0, i12);
                if (i2 < i11 + 16) {
                    System.arraycopy(bArr, i, this.l, this.s, i2);
                    this.s += i2;
                    return 16;
                }
                i3 = 16;
            } else {
                i3 = 0;
            }
            byte[] bArr6 = this.l;
            int length2 = (i2 + i) - bArr6.length;
            int i13 = this.s;
            int i14 = 16 - i13;
            System.arraycopy(bArr, i, bArr6, i13, i14);
            g(0, i3, this.l, bArr2);
            int i15 = i + i14;
            int i16 = i3 + 16;
            while (i15 <= length2) {
                g(i15, i16, bArr, bArr2);
                i15 += 16;
                i16 += 16;
            }
            byte[] bArr7 = this.l;
            int length3 = (bArr7.length + length2) - i15;
            this.s = length3;
            System.arraycopy(bArr, i15, bArr7, 0, length3);
            return i16;
        }
        System.arraycopy(bArr, i, bArr4, i10, i2);
        this.s += i2;
        return 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    @Override // com.github.catvod.spider.merge.f1.a
    public final int doFinal(byte[] bArr, int i) throws l, androidx.startup.b {
        long j;
        long j2;
        char c;
        char c2;
        f();
        if (this.t == 0) {
            k();
        }
        int i2 = this.s;
        boolean z = this.d;
        int i3 = this.f;
        if (!z) {
            if (i2 < i3) {
                throw new l("data too short");
            }
            i2 -= i3;
            if (bArr.length - i < i2) {
                throw new n("Output buffer too short");
            }
        } else if (bArr.length - i < i3 + i2) {
            throw new n("Output buffer too short");
        }
        int i4 = 16;
        if (i2 > 0) {
            byte[] bArr2 = this.l;
            byte[] bArr3 = new byte[16];
            j(bArr3);
            if (!this.d) {
                i(0, i2, this.n, bArr2);
                int i5 = i2;
                while (true) {
                    i5--;
                    if (i5 < 0) {
                        break;
                    }
                    bArr2[i5] = (byte) (bArr2[i5] ^ bArr3[i5]);
                }
            } else {
                int i6 = i2;
                while (true) {
                    i6--;
                    if (i6 < 0) {
                        break;
                    }
                    bArr2[i6] = (byte) (bArr2[i6] ^ bArr3[i6]);
                }
                i(0, i2, this.n, bArr2);
            }
            System.arraycopy(bArr2, 0, bArr, i, i2);
            this.t += i2;
        }
        long j3 = this.w;
        int i7 = this.v;
        long j4 = j3 + i7;
        this.w = j4;
        if (j4 > this.x) {
            if (i7 > 0) {
                i(0, i7, this.o, this.u);
            }
            if (this.x > 0) {
                c2.c0(this.o, this.p);
            }
            long j5 = ((this.t * 8) + 127) >>> 7;
            byte[] bArr4 = new byte[16];
            if (this.c == null) {
                com.github.catvod.spider.merge.g1.a aVar = new com.github.catvod.spider.merge.g1.a();
                this.c = aVar;
                byte[] bArr5 = this.j;
                c = 7;
                long[] jArr = new long[2];
                j = 8;
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 2; i8 < i10; i10 = 2) {
                    jArr[i8] = (c2.b(bArr5, i9 + 4) & 4294967295L) | ((c2.b(bArr5, i9) & 4294967295L) << 32);
                    i9 += 8;
                    i8++;
                    aVar = aVar;
                    j5 = j5;
                }
                j2 = j5;
                c2 = 0;
                aVar.a = jArr;
            } else {
                j2 = j5;
                j = 8;
                c = 7;
                c2 = 0;
            }
            com.github.catvod.spider.merge.g1.a aVar2 = this.c;
            aVar2.getClass();
            long[] jArr2 = new long[2];
            jArr2[c2] = Long.MIN_VALUE;
            if (j2 > 0) {
                long[] jArr3 = new long[2];
                long[] jArr4 = (long[]) aVar2.a;
                jArr3[c2] = jArr4[c2];
                jArr3[1] = jArr4[1];
                while (true) {
                    if ((j2 & 1) != 0) {
                        c2.O(jArr2, jArr3);
                    }
                    long[] jArr5 = new long[4];
                    c2.C(jArr5, 0, jArr3[c2]);
                    c2.C(jArr5, 2, jArr3[1]);
                    long j6 = jArr5[0];
                    long j7 = jArr5[1];
                    long j8 = jArr5[2];
                    long j9 = jArr5[3];
                    long j10 = j8 ^ (((j9 << 63) ^ (j9 << 62)) ^ (j9 << 57));
                    jArr3[0] = j6 ^ (((j10 ^ (j10 >>> 1)) ^ (j10 >>> 2)) ^ (j10 >>> c));
                    jArr3[1] = (j7 ^ (((j9 ^ (j9 >>> 1)) ^ (j9 >>> 2)) ^ (j9 >>> c))) ^ (((j10 << 63) ^ (j10 << 62)) ^ (j10 << 57));
                    j2 >>>= 1;
                    if (j2 <= 0) {
                        break;
                    }
                    c2 = 0;
                }
            }
            int i11 = 0;
            int i12 = 2;
            for (int i13 = 0; i13 < 2; i13++) {
                c2.L(bArr4, i11, jArr2[i13]);
                i11 += 8;
            }
            byte[] bArr6 = this.o;
            long[] jArr6 = new long[2];
            int i14 = 0;
            int i15 = 0;
            while (i15 < i12) {
                jArr6[i15] = ((c2.b(bArr6, i14) & 4294967295L) << 32) | (c2.b(bArr6, i14 + 4) & 4294967295L);
                i14 += 8;
                i15++;
                i12 = 2;
            }
            long[] jArr7 = new long[i12];
            int i16 = 0;
            int i17 = 0;
            while (i17 < i12) {
                jArr7[i17] = (c2.b(bArr4, i16 + 4) & 4294967295L) | ((c2.b(bArr4, i16) & 4294967295L) << 32);
                i16 += 8;
                i17++;
                i12 = 2;
            }
            c2.O(jArr6, jArr7);
            int i18 = 0;
            for (int i19 = 0; i19 < 2; i19++) {
                c2.L(bArr6, i18, jArr6[i19]);
                i18 += 8;
            }
            c2.c0(this.n, this.o);
            i4 = 16;
        } else {
            j = 8;
        }
        byte[] bArr7 = new byte[i4];
        c2.L(bArr7, 0, this.w * j);
        c2.L(bArr7, 8, this.t * j);
        byte[] bArr8 = this.n;
        c2.c0(bArr8, bArr7);
        this.b.g(bArr8);
        byte[] bArr9 = new byte[i4];
        this.a.b(0, 0, this.k, bArr9);
        c2.c0(bArr9, this.n);
        int i20 = this.f;
        byte[] bArr10 = new byte[i20];
        this.m = bArr10;
        System.arraycopy(bArr9, 0, bArr10, 0, i20);
        if (this.d) {
            System.arraycopy(this.m, 0, bArr, i + this.s, this.f);
            i2 += this.f;
        } else {
            int i21 = this.f;
            byte[] bArr11 = new byte[i21];
            System.arraycopy(this.l, i2, bArr11, 0, i21);
            if (!c2.l(this.m, bArr11)) {
                throw new l("mac check in GCM failed");
            }
        }
        l(false);
        return i2;
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final void e(byte[] bArr, int i, int i2) {
        com.github.catvod.spider.merge.g1.b bVar = this.b;
        f();
        int i3 = this.v;
        if (i3 > 0) {
            int i4 = 16 - i3;
            byte[] bArr2 = this.u;
            if (i2 < i4) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.v += i2;
                return;
            }
            System.arraycopy(bArr, i, bArr2, i3, i4);
            byte[] bArr3 = this.o;
            c2.c0(bArr3, this.u);
            bVar.g(bArr3);
            this.w += 16;
            i += i4;
            i2 -= i4;
        }
        int i5 = i2 + i;
        int i6 = i5 - 16;
        while (i <= i6) {
            byte[] bArr4 = this.o;
            c2.d0(bArr4, bArr, i);
            bVar.g(bArr4);
            this.w += 16;
            i += 16;
        }
        int i7 = i5 - i;
        this.v = i7;
        System.arraycopy(bArr, i, this.u, 0, i7);
    }

    public final void f() {
        if (this.e) {
            return;
        }
        com.github.catvod.spider.merge.s0.a.h(this.d ? "GCM cipher cannot be reused for encryption" : "GCM cipher needs to be initialised");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    public final void g(int i, int i2, byte[] bArr, byte[] bArr2) throws androidx.startup.b {
        if (bArr2.length - i2 < 16) {
            throw new n("Output buffer too short");
        }
        if (this.t == 0) {
            k();
        }
        byte[] bArr3 = new byte[16];
        j(bArr3);
        byte[] bArr4 = this.n;
        c2.d0(bArr4, bArr, i);
        this.b.g(bArr4);
        int i3 = 0;
        do {
            bArr2[i2 + i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
            int i4 = i3 + 1;
            bArr2[i2 + i4] = (byte) (bArr[i4 + i] ^ bArr3[i4]);
            int i5 = i3 + 2;
            bArr2[i2 + i5] = (byte) (bArr[i5 + i] ^ bArr3[i5]);
            int i6 = i3 + 3;
            bArr2[i2 + i6] = (byte) (bArr[i6 + i] ^ bArr3[i6]);
            i3 += 4;
        } while (i3 < 16);
        this.t += 16;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    public final void h(int i, int i2, byte[] bArr, byte[] bArr2) throws androidx.startup.b {
        if (bArr2.length - i2 < 16) {
            throw new n("Output buffer too short");
        }
        if (this.t == 0) {
            k();
        }
        byte[] bArr3 = new byte[16];
        j(bArr3);
        c2.d0(bArr3, bArr, i);
        byte[] bArr4 = this.n;
        c2.c0(bArr4, bArr3);
        this.b.g(bArr4);
        System.arraycopy(bArr3, 0, bArr2, i2, 16);
        this.t += 16;
    }

    public final void i(int i, int i2, byte[] bArr, byte[] bArr2) {
        while (true) {
            i2--;
            if (i2 < 0) {
                this.b.g(bArr);
                return;
            }
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i + i2]);
        }
    }

    public final void j(byte[] bArr) throws androidx.startup.b {
        int i = this.r;
        if (i == 0) {
            com.github.catvod.spider.merge.s0.a.h("Attempt to process too many blocks");
            return;
        }
        this.r = i - 1;
        byte[] bArr2 = this.q;
        int i2 = (bArr2[15] & 255) + 1;
        bArr2[15] = (byte) i2;
        int i3 = (i2 >>> 8) + (bArr2[14] & 255);
        bArr2[14] = (byte) i3;
        int i4 = (i3 >>> 8) + (bArr2[13] & 255);
        bArr2[13] = (byte) i4;
        bArr2[12] = (byte) ((i4 >>> 8) + (bArr2[12] & 255));
        this.a.b(0, 0, bArr2, bArr);
    }

    public final void k() {
        if (this.w > 0) {
            System.arraycopy(this.o, 0, this.p, 0, 16);
            this.x = this.w;
        }
        int i = this.v;
        if (i > 0) {
            i(0, i, this.p, this.u);
            this.x += this.v;
        }
        if (this.x > 0) {
            System.arraycopy(this.p, 0, this.n, 0, 16);
        }
    }

    public final void l(boolean z) {
        this.a.getClass();
        this.n = new byte[16];
        this.o = new byte[16];
        this.p = new byte[16];
        this.u = new byte[16];
        this.v = 0;
        this.w = 0L;
        this.x = 0L;
        this.q = c2.i(this.k);
        this.r = -2;
        this.s = 0;
        this.t = 0L;
        byte[] bArr = this.l;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
        if (z) {
            this.m = null;
        }
        if (this.d) {
            this.e = false;
            return;
        }
        byte[] bArr2 = this.i;
        if (bArr2 != null) {
            e(bArr2, 0, bArr2.length);
        }
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final void reset() {
        l(true);
    }
}
