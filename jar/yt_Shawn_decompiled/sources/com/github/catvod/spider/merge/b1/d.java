package com.github.catvod.spider.merge.b1;

import com.github.catvod.spider.merge.a1.g;
import com.github.catvod.spider.merge.u.c2;

/* loaded from: classes.dex */
public final class d extends a {
    public static final int[] o = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int[] m;
    public int n;

    public d() {
        super(com.github.catvod.spider.merge.a1.d.a);
        this.m = new int[64];
        g.a();
        reset();
    }

    public static int i(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    public static int j(int i, int i2, int i3) {
        return ((i ^ i2) & i3) | (i & i2);
    }

    public static int k(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    public static int l(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    @Override // com.github.catvod.spider.merge.j1.a
    public final com.github.catvod.spider.merge.j1.a a() {
        d dVar = new d(this);
        dVar.m = new int[64];
        dVar.m(this);
        return dVar;
    }

    @Override // com.github.catvod.spider.merge.j1.a
    public final void b(com.github.catvod.spider.merge.j1.a aVar) {
        m((d) aVar);
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final int c() {
        return 32;
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final int doFinal(byte[] bArr, int i) {
        e();
        c2.E(bArr, this.e, i);
        c2.E(bArr, this.f, i + 4);
        c2.E(bArr, this.g, i + 8);
        c2.E(bArr, this.h, i + 12);
        c2.E(bArr, this.i, i + 16);
        c2.E(bArr, this.j, i + 20);
        c2.E(bArr, this.k, i + 24);
        c2.E(bArr, this.l, i + 28);
        reset();
        return 32;
    }

    @Override // com.github.catvod.spider.merge.b1.a
    public final void f() {
        int[] iArr = this.m;
        for (int i = 16; i <= 63; i++) {
            int i2 = iArr[i - 2];
            int i3 = ((i2 >>> 10) ^ (((i2 >>> 17) | (i2 << 15)) ^ ((i2 >>> 19) | (i2 << 13)))) + iArr[i - 7];
            int i4 = iArr[i - 15];
            iArr[i] = i3 + ((i4 >>> 3) ^ (((i4 >>> 7) | (i4 << 25)) ^ ((i4 >>> 18) | (i4 << 14)))) + iArr[i - 16];
        }
        int iJ = this.e;
        int iJ2 = this.f;
        int iJ3 = this.g;
        int iJ4 = this.h;
        int i5 = this.i;
        int i6 = this.j;
        int i7 = this.k;
        int i8 = this.l;
        int i9 = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = i(i5, i6, i7) + l(i5);
            int[] iArr2 = o;
            int i12 = i11 + iArr2[i9] + iArr[i9] + i8;
            int i13 = iJ4 + i12;
            int iJ5 = j(iJ, iJ2, iJ3) + k(iJ) + i12;
            int i14 = i9 + 1;
            int i15 = i(i13, i5, i6) + l(i13) + iArr2[i14] + iArr[i14] + i7;
            int i16 = iJ3 + i15;
            int iJ6 = j(iJ5, iJ, iJ2) + k(iJ5) + i15;
            int i17 = i9 + 2;
            int i18 = i(i16, i13, i5) + l(i16) + iArr2[i17] + iArr[i17] + i6;
            int i19 = iJ2 + i18;
            int iJ7 = j(iJ6, iJ5, iJ) + k(iJ6) + i18;
            int i20 = i9 + 3;
            int i21 = i(i19, i16, i13) + l(i19) + iArr2[i20] + iArr[i20] + i5;
            int i22 = iJ + i21;
            int iJ8 = j(iJ7, iJ6, iJ5) + k(iJ7) + i21;
            int i23 = i9 + 4;
            int i24 = i(i22, i19, i16) + l(i22) + iArr2[i23] + iArr[i23] + i13;
            i8 = iJ5 + i24;
            iJ4 = j(iJ8, iJ7, iJ6) + k(iJ8) + i24;
            int i25 = i9 + 5;
            int i26 = i(i8, i22, i19) + l(i8) + iArr2[i25] + iArr[i25] + i16;
            i7 = iJ6 + i26;
            iJ3 = j(iJ4, iJ8, iJ7) + k(iJ4) + i26;
            int i27 = i9 + 6;
            int i28 = i(i7, i8, i22) + l(i7) + iArr2[i27] + iArr[i27] + i19;
            i6 = iJ7 + i28;
            iJ2 = j(iJ3, iJ4, iJ8) + k(iJ3) + i28;
            int i29 = i9 + 7;
            int i30 = i(i6, i7, i8) + l(i6) + iArr2[i29] + iArr[i29] + i22;
            i5 = iJ8 + i30;
            iJ = j(iJ2, iJ3, iJ4) + k(iJ2) + i30;
            i9 += 8;
        }
        this.e += iJ;
        this.f += iJ2;
        this.g += iJ3;
        this.h += iJ4;
        this.i += i5;
        this.j += i6;
        this.k += i7;
        this.l += i8;
        this.n = 0;
        for (int i31 = 0; i31 < 16; i31++) {
            iArr[i31] = 0;
        }
    }

    @Override // com.github.catvod.spider.merge.b1.a
    public final void g(long j) {
        if (this.n > 14) {
            f();
        }
        int[] iArr = this.m;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // com.github.catvod.spider.merge.b1.a
    public final void h(byte[] bArr, int i) {
        this.m[this.n] = c2.b(bArr, i);
        int i2 = this.n + 1;
        this.n = i2;
        if (i2 == 16) {
            f();
        }
    }

    public final void m(d dVar) {
        d(dVar);
        this.e = dVar.e;
        this.f = dVar.f;
        this.g = dVar.g;
        this.h = dVar.h;
        this.i = dVar.i;
        this.j = dVar.j;
        this.k = dVar.k;
        this.l = dVar.l;
        int[] iArr = dVar.m;
        System.arraycopy(iArr, 0, this.m, 0, iArr.length);
        this.n = dVar.n;
    }

    @Override // com.github.catvod.spider.merge.b1.a, com.github.catvod.spider.merge.a1.k
    public final void reset() {
        super.reset();
        this.e = 1779033703;
        this.f = -1150833019;
        this.g = 1013904242;
        this.h = -1521486534;
        this.i = 1359893119;
        this.j = -1694144372;
        this.k = 528734635;
        this.l = 1541459225;
        this.n = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.m;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }
}
