package com.github.catvod.spider.merge.b1;

import com.github.catvod.spider.merge.a1.g;
import com.github.catvod.spider.merge.u.c2;

/* loaded from: classes.dex */
public final class c extends a {
    public int e;
    public int f;
    public int g;
    public int h;
    public int[] i;
    public int j;

    public c() {
        super(com.github.catvod.spider.merge.a1.d.a);
        this.i = new int[16];
        g.a();
        reset();
    }

    public static int i(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    public static int j(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    @Override // com.github.catvod.spider.merge.j1.a
    public final com.github.catvod.spider.merge.j1.a a() {
        c cVar = new c(this);
        cVar.i = new int[16];
        cVar.k(this);
        return cVar;
    }

    @Override // com.github.catvod.spider.merge.j1.a
    public final void b(com.github.catvod.spider.merge.j1.a aVar) {
        k((c) aVar);
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
        int iC = com.github.catvod.spider.merge.b.b.c(i5, iArr[0], -680876936, 7, i2);
        int iC2 = com.github.catvod.spider.merge.b.b.c(i(iC, i2, i3) + i4, iArr[1], -389564586, 12, iC);
        int iC3 = com.github.catvod.spider.merge.b.b.c(i(iC2, iC, i2) + i3, iArr[2], 606105819, 17, iC2);
        int iC4 = com.github.catvod.spider.merge.b.b.c(i(iC3, iC2, iC) + i2, iArr[3], -1044525330, 22, iC3);
        int iC5 = com.github.catvod.spider.merge.b.b.c(i(iC4, iC3, iC2) + iC, iArr[4], -176418897, 7, iC4);
        int iC6 = com.github.catvod.spider.merge.b.b.c(i(iC5, iC4, iC3) + iC2, iArr[5], 1200080426, 12, iC5);
        int iC7 = com.github.catvod.spider.merge.b.b.c(i(iC6, iC5, iC4) + iC3, iArr[6], -1473231341, 17, iC6);
        int iC8 = com.github.catvod.spider.merge.b.b.c(i(iC7, iC6, iC5) + iC4, iArr[7], -45705983, 22, iC7);
        int iC9 = com.github.catvod.spider.merge.b.b.c(i(iC8, iC7, iC6) + iC5, iArr[8], 1770035416, 7, iC8);
        int iC10 = com.github.catvod.spider.merge.b.b.c(i(iC9, iC8, iC7) + iC6, iArr[9], -1958414417, 12, iC9);
        int iC11 = com.github.catvod.spider.merge.b.b.c(i(iC10, iC9, iC8) + iC7, iArr[10], -42063, 17, iC10);
        int iC12 = com.github.catvod.spider.merge.b.b.c(i(iC11, iC10, iC9) + iC8, iArr[11], -1990404162, 22, iC11);
        int iC13 = com.github.catvod.spider.merge.b.b.c(i(iC12, iC11, iC10) + iC9, iArr[12], 1804603682, 7, iC12);
        int iC14 = com.github.catvod.spider.merge.b.b.c(i(iC13, iC12, iC11) + iC10, iArr[13], -40341101, 12, iC13);
        int iC15 = com.github.catvod.spider.merge.b.b.c(i(iC14, iC13, iC12) + iC11, iArr[14], -1502002290, 17, iC14);
        int iC16 = com.github.catvod.spider.merge.b.b.c(i(iC15, iC14, iC13) + iC12, iArr[15], 1236535329, 22, iC15);
        int iC17 = com.github.catvod.spider.merge.b.b.c(j(iC16, iC15, iC14) + iC13, iArr[1], -165796510, 5, iC16);
        int iC18 = com.github.catvod.spider.merge.b.b.c(j(iC17, iC16, iC15) + iC14, iArr[6], -1069501632, 9, iC17);
        int iC19 = com.github.catvod.spider.merge.b.b.c(j(iC18, iC17, iC16) + iC15, iArr[11], 643717713, 14, iC18);
        int iC20 = com.github.catvod.spider.merge.b.b.c(j(iC19, iC18, iC17) + iC16, iArr[0], -373897302, 20, iC19);
        int iC21 = com.github.catvod.spider.merge.b.b.c(j(iC20, iC19, iC18) + iC17, iArr[5], -701558691, 5, iC20);
        int iC22 = com.github.catvod.spider.merge.b.b.c(j(iC21, iC20, iC19) + iC18, iArr[10], 38016083, 9, iC21);
        int iC23 = com.github.catvod.spider.merge.b.b.c(j(iC22, iC21, iC20) + iC19, iArr[15], -660478335, 14, iC22);
        int iC24 = com.github.catvod.spider.merge.b.b.c(j(iC23, iC22, iC21) + iC20, iArr[4], -405537848, 20, iC23);
        int iC25 = com.github.catvod.spider.merge.b.b.c(j(iC24, iC23, iC22) + iC21, iArr[9], 568446438, 5, iC24);
        int iC26 = com.github.catvod.spider.merge.b.b.c(j(iC25, iC24, iC23) + iC22, iArr[14], -1019803690, 9, iC25);
        int iC27 = com.github.catvod.spider.merge.b.b.c(j(iC26, iC25, iC24) + iC23, iArr[3], -187363961, 14, iC26);
        int iC28 = com.github.catvod.spider.merge.b.b.c(j(iC27, iC26, iC25) + iC24, iArr[8], 1163531501, 20, iC27);
        int iC29 = com.github.catvod.spider.merge.b.b.c(j(iC28, iC27, iC26) + iC25, iArr[13], -1444681467, 5, iC28);
        int iC30 = com.github.catvod.spider.merge.b.b.c(j(iC29, iC28, iC27) + iC26, iArr[2], -51403784, 9, iC29);
        int iC31 = com.github.catvod.spider.merge.b.b.c(j(iC30, iC29, iC28) + iC27, iArr[7], 1735328473, 14, iC30);
        int iC32 = com.github.catvod.spider.merge.b.b.c(j(iC31, iC30, iC29) + iC28, iArr[12], -1926607734, 20, iC31);
        int iC33 = com.github.catvod.spider.merge.b.b.c(iC29 + ((iC32 ^ iC31) ^ iC30), iArr[5], -378558, 4, iC32);
        int iC34 = com.github.catvod.spider.merge.b.b.c(iC30 + ((iC33 ^ iC32) ^ iC31), iArr[8], -2022574463, 11, iC33);
        int iC35 = com.github.catvod.spider.merge.b.b.c(iC31 + ((iC34 ^ iC33) ^ iC32), iArr[11], 1839030562, 16, iC34);
        int iC36 = com.github.catvod.spider.merge.b.b.c(iC32 + ((iC35 ^ iC34) ^ iC33), iArr[14], -35309556, 23, iC35);
        int iC37 = com.github.catvod.spider.merge.b.b.c(iC33 + ((iC36 ^ iC35) ^ iC34), iArr[1], -1530992060, 4, iC36);
        int iC38 = com.github.catvod.spider.merge.b.b.c(iC34 + ((iC37 ^ iC36) ^ iC35), iArr[4], 1272893353, 11, iC37);
        int iC39 = com.github.catvod.spider.merge.b.b.c(iC35 + ((iC38 ^ iC37) ^ iC36), iArr[7], -155497632, 16, iC38);
        int iC40 = com.github.catvod.spider.merge.b.b.c(iC36 + ((iC39 ^ iC38) ^ iC37), iArr[10], -1094730640, 23, iC39);
        int iC41 = com.github.catvod.spider.merge.b.b.c(iC37 + ((iC40 ^ iC39) ^ iC38), iArr[13], 681279174, 4, iC40);
        int iC42 = com.github.catvod.spider.merge.b.b.c(iC38 + ((iC41 ^ iC40) ^ iC39), iArr[0], -358537222, 11, iC41);
        int iC43 = com.github.catvod.spider.merge.b.b.c(iC39 + ((iC42 ^ iC41) ^ iC40), iArr[3], -722521979, 16, iC42);
        int iC44 = com.github.catvod.spider.merge.b.b.c(iC40 + ((iC43 ^ iC42) ^ iC41), iArr[6], 76029189, 23, iC43);
        int iC45 = com.github.catvod.spider.merge.b.b.c(iC41 + ((iC44 ^ iC43) ^ iC42), iArr[9], -640364487, 4, iC44);
        int iC46 = com.github.catvod.spider.merge.b.b.c(iC42 + ((iC45 ^ iC44) ^ iC43), iArr[12], -421815835, 11, iC45);
        int iC47 = com.github.catvod.spider.merge.b.b.c(iC43 + ((iC46 ^ iC45) ^ iC44), iArr[15], 530742520, 16, iC46);
        int iC48 = com.github.catvod.spider.merge.b.b.c(iC44 + ((iC47 ^ iC46) ^ iC45), iArr[2], -995338651, 23, iC47);
        int iC49 = com.github.catvod.spider.merge.b.b.c(iC45 + (((~iC46) | iC48) ^ iC47), iArr[0], -198630844, 6, iC48);
        int iC50 = com.github.catvod.spider.merge.b.b.c(iC46 + (((~iC47) | iC49) ^ iC48), iArr[7], 1126891415, 10, iC49);
        int iC51 = com.github.catvod.spider.merge.b.b.c(iC47 + (((~iC48) | iC50) ^ iC49), iArr[14], -1416354905, 15, iC50);
        int iC52 = com.github.catvod.spider.merge.b.b.c(iC48 + (((~iC49) | iC51) ^ iC50), iArr[5], -57434055, 21, iC51);
        int iC53 = com.github.catvod.spider.merge.b.b.c(iC49 + (((~iC50) | iC52) ^ iC51), iArr[12], 1700485571, 6, iC52);
        int iC54 = com.github.catvod.spider.merge.b.b.c(iC50 + (((~iC51) | iC53) ^ iC52), iArr[3], -1894986606, 10, iC53);
        int iC55 = com.github.catvod.spider.merge.b.b.c(iC51 + (((~iC52) | iC54) ^ iC53), iArr[10], -1051523, 15, iC54);
        int iC56 = com.github.catvod.spider.merge.b.b.c(iC52 + (((~iC53) | iC55) ^ iC54), iArr[1], -2054922799, 21, iC55);
        int iC57 = com.github.catvod.spider.merge.b.b.c(iC53 + (((~iC54) | iC56) ^ iC55), iArr[8], 1873313359, 6, iC56);
        int iC58 = com.github.catvod.spider.merge.b.b.c(iC54 + (((~iC55) | iC57) ^ iC56), iArr[15], -30611744, 10, iC57);
        int iC59 = com.github.catvod.spider.merge.b.b.c(iC55 + (((~iC56) | iC58) ^ iC57), iArr[6], -1560198380, 15, iC58);
        int iC60 = com.github.catvod.spider.merge.b.b.c(iC56 + (((~iC57) | iC59) ^ iC58), iArr[13], 1309151649, 21, iC59);
        int iC61 = com.github.catvod.spider.merge.b.b.c(iC57 + (((~iC58) | iC60) ^ iC59), iArr[4], -145523070, 6, iC60);
        int iC62 = com.github.catvod.spider.merge.b.b.c(iC58 + (((~iC59) | iC61) ^ iC60), iArr[11], -1120210379, 10, iC61);
        int iC63 = com.github.catvod.spider.merge.b.b.c(iC59 + (((~iC60) | iC62) ^ iC61), iArr[2], 718787259, 15, iC62);
        int iC64 = com.github.catvod.spider.merge.b.b.c(iC60 + (((~iC61) | iC63) ^ iC62), iArr[9], -343485551, 21, iC63);
        this.e += iC61;
        this.f += iC64;
        this.g += iC63;
        this.h += iC62;
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

    public final void k(c cVar) {
        d(cVar);
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        int[] iArr = cVar.i;
        System.arraycopy(iArr, 0, this.i, 0, iArr.length);
        this.j = cVar.j;
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
