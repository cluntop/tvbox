package com.github.catvod.spider.merge.b1;

import com.github.catvod.spider.merge.a1.g;
import com.github.catvod.spider.merge.u.c2;

/* loaded from: classes.dex */
public final class b extends a {
    public int e;
    public int f;
    public int g;
    public int h;
    public int[] i;
    public int j;

    public static int i(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    public static int j(int i, int i2, int i3) {
        return (i & (i2 | i3)) | (i2 & i3);
    }

    public static int l(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    @Override // com.github.catvod.spider.merge.j1.a
    public final com.github.catvod.spider.merge.j1.a a() {
        b bVar = new b(this.a);
        bVar.i = new int[16];
        g.a();
        bVar.k(this);
        return bVar;
    }

    @Override // com.github.catvod.spider.merge.j1.a
    public final void b(com.github.catvod.spider.merge.j1.a aVar) {
        k((b) aVar);
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final int c() {
        return 16;
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final int doFinal(byte[] bArr, int i) {
        e();
        c2.F(bArr, this.e, i);
        c2.F(bArr, this.f, i + 4);
        c2.F(bArr, this.g, i + 8);
        c2.F(bArr, this.h, i + 12);
        reset();
        return 16;
    }

    @Override // com.github.catvod.spider.merge.b1.a
    public final void f() {
        int i = this.e;
        int i2 = this.f;
        int i3 = this.g;
        int i4 = this.h;
        int i5 = i(i2, i3, i4) + i;
        int[] iArr = this.i;
        int iL = l(i5 + iArr[0], 3);
        int iL2 = l(i(iL, i2, i3) + i4 + iArr[1], 7);
        int iL3 = l(i(iL2, iL, i2) + i3 + iArr[2], 11);
        int iL4 = l(i(iL3, iL2, iL) + i2 + iArr[3], 19);
        int iL5 = l(i(iL4, iL3, iL2) + iL + iArr[4], 3);
        int iL6 = l(i(iL5, iL4, iL3) + iL2 + iArr[5], 7);
        int iL7 = l(i(iL6, iL5, iL4) + iL3 + iArr[6], 11);
        int iL8 = l(i(iL7, iL6, iL5) + iL4 + iArr[7], 19);
        int iL9 = l(i(iL8, iL7, iL6) + iL5 + iArr[8], 3);
        int iL10 = l(i(iL9, iL8, iL7) + iL6 + iArr[9], 7);
        int iL11 = l(i(iL10, iL9, iL8) + iL7 + iArr[10], 11);
        int iL12 = l(i(iL11, iL10, iL9) + iL8 + iArr[11], 19);
        int iL13 = l(i(iL12, iL11, iL10) + iL9 + iArr[12], 3);
        int iL14 = l(i(iL13, iL12, iL11) + iL10 + iArr[13], 7);
        int iL15 = l(i(iL14, iL13, iL12) + iL11 + iArr[14], 11);
        int iL16 = l(i(iL15, iL14, iL13) + iL12 + iArr[15], 19);
        int iB = com.github.catvod.spider.merge.b.b.b(j(iL16, iL15, iL14) + iL13, iArr[0], 1518500249, 3);
        int iB2 = com.github.catvod.spider.merge.b.b.b(j(iB, iL16, iL15) + iL14, iArr[4], 1518500249, 5);
        int iB3 = com.github.catvod.spider.merge.b.b.b(j(iB2, iB, iL16) + iL15, iArr[8], 1518500249, 9);
        int iB4 = com.github.catvod.spider.merge.b.b.b(j(iB3, iB2, iB) + iL16, iArr[12], 1518500249, 13);
        int iB5 = com.github.catvod.spider.merge.b.b.b(j(iB4, iB3, iB2) + iB, iArr[1], 1518500249, 3);
        int iB6 = com.github.catvod.spider.merge.b.b.b(j(iB5, iB4, iB3) + iB2, iArr[5], 1518500249, 5);
        int iB7 = com.github.catvod.spider.merge.b.b.b(j(iB6, iB5, iB4) + iB3, iArr[9], 1518500249, 9);
        int iB8 = com.github.catvod.spider.merge.b.b.b(j(iB7, iB6, iB5) + iB4, iArr[13], 1518500249, 13);
        int iB9 = com.github.catvod.spider.merge.b.b.b(j(iB8, iB7, iB6) + iB5, iArr[2], 1518500249, 3);
        int iB10 = com.github.catvod.spider.merge.b.b.b(j(iB9, iB8, iB7) + iB6, iArr[6], 1518500249, 5);
        int iB11 = com.github.catvod.spider.merge.b.b.b(j(iB10, iB9, iB8) + iB7, iArr[10], 1518500249, 9);
        int iB12 = com.github.catvod.spider.merge.b.b.b(j(iB11, iB10, iB9) + iB8, iArr[14], 1518500249, 13);
        int iB13 = com.github.catvod.spider.merge.b.b.b(j(iB12, iB11, iB10) + iB9, iArr[3], 1518500249, 3);
        int iB14 = com.github.catvod.spider.merge.b.b.b(j(iB13, iB12, iB11) + iB10, iArr[7], 1518500249, 5);
        int iB15 = com.github.catvod.spider.merge.b.b.b(j(iB14, iB13, iB12) + iB11, iArr[11], 1518500249, 9);
        int iB16 = com.github.catvod.spider.merge.b.b.b(j(iB15, iB14, iB13) + iB12, iArr[15], 1518500249, 13);
        int iB17 = com.github.catvod.spider.merge.b.b.b(iB13 + ((iB16 ^ iB15) ^ iB14), iArr[0], 1859775393, 3);
        int iB18 = com.github.catvod.spider.merge.b.b.b(iB14 + ((iB17 ^ iB16) ^ iB15), iArr[8], 1859775393, 9);
        int iB19 = com.github.catvod.spider.merge.b.b.b(iB15 + ((iB18 ^ iB17) ^ iB16), iArr[4], 1859775393, 11);
        int iB20 = com.github.catvod.spider.merge.b.b.b(iB16 + ((iB19 ^ iB18) ^ iB17), iArr[12], 1859775393, 15);
        int iB21 = com.github.catvod.spider.merge.b.b.b(iB17 + ((iB20 ^ iB19) ^ iB18), iArr[2], 1859775393, 3);
        int iB22 = com.github.catvod.spider.merge.b.b.b(iB18 + ((iB21 ^ iB20) ^ iB19), iArr[10], 1859775393, 9);
        int iB23 = com.github.catvod.spider.merge.b.b.b(iB19 + ((iB22 ^ iB21) ^ iB20), iArr[6], 1859775393, 11);
        int iB24 = com.github.catvod.spider.merge.b.b.b(iB20 + ((iB23 ^ iB22) ^ iB21), iArr[14], 1859775393, 15);
        int iB25 = com.github.catvod.spider.merge.b.b.b(iB21 + ((iB24 ^ iB23) ^ iB22), iArr[1], 1859775393, 3);
        int iB26 = com.github.catvod.spider.merge.b.b.b(iB22 + ((iB25 ^ iB24) ^ iB23), iArr[9], 1859775393, 9);
        int iB27 = com.github.catvod.spider.merge.b.b.b(iB23 + ((iB26 ^ iB25) ^ iB24), iArr[5], 1859775393, 11);
        int iB28 = com.github.catvod.spider.merge.b.b.b(iB24 + ((iB27 ^ iB26) ^ iB25), iArr[13], 1859775393, 15);
        int iB29 = com.github.catvod.spider.merge.b.b.b(iB25 + ((iB28 ^ iB27) ^ iB26), iArr[3], 1859775393, 3);
        int iB30 = com.github.catvod.spider.merge.b.b.b(iB26 + ((iB29 ^ iB28) ^ iB27), iArr[11], 1859775393, 9);
        int iB31 = com.github.catvod.spider.merge.b.b.b(iB27 + ((iB30 ^ iB29) ^ iB28), iArr[7], 1859775393, 11);
        int iB32 = com.github.catvod.spider.merge.b.b.b(iB28 + ((iB31 ^ iB30) ^ iB29), iArr[15], 1859775393, 15);
        this.e += iB29;
        this.f += iB32;
        this.g += iB31;
        this.h += iB30;
        this.j = 0;
        for (int i6 = 0; i6 != iArr.length; i6++) {
            iArr[i6] = 0;
        }
    }

    @Override // com.github.catvod.spider.merge.b1.a
    public final void g(long j) {
        if (this.j > 14) {
            f();
        }
        int[] iArr = this.i;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // com.github.catvod.spider.merge.b1.a
    public final void h(byte[] bArr, int i) {
        int[] iArr = this.i;
        int i2 = this.j;
        this.j = i2 + 1;
        iArr[i2] = c2.K(bArr, i);
        if (this.j == 16) {
            f();
        }
    }

    public final void k(b bVar) {
        d(bVar);
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        int[] iArr = bVar.i;
        System.arraycopy(iArr, 0, this.i, 0, iArr.length);
        this.j = bVar.j;
    }

    @Override // com.github.catvod.spider.merge.b1.a, com.github.catvod.spider.merge.a1.k
    public final void reset() {
        super.reset();
        this.e = 1732584193;
        this.f = -271733879;
        this.g = -1732584194;
        this.h = 271733878;
        this.j = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.i;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }
}
