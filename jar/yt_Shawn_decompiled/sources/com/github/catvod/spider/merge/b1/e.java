package com.github.catvod.spider.merge.b1;

import com.github.catvod.spider.merge.a1.g;
import com.github.catvod.spider.merge.a1.k;
import com.github.catvod.spider.merge.u.c2;

/* loaded from: classes.dex */
public final class e implements k, com.github.catvod.spider.merge.j1.a {
    public static final long[] p = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    public final com.github.catvod.spider.merge.a1.d a;
    public final byte[] b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public final long[] n;
    public int o;

    public e() {
        this.b = new byte[8];
        this.n = new long[80];
        this.a = com.github.catvod.spider.merge.a1.d.a;
        this.c = 0;
        reset();
        g.a();
        reset();
    }

    public static long d(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    public static long e(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    public static long f(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    public static long g(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    @Override // com.github.catvod.spider.merge.j1.a
    public final com.github.catvod.spider.merge.j1.a a() {
        return new e(this);
    }

    @Override // com.github.catvod.spider.merge.j1.a
    public final void b(com.github.catvod.spider.merge.j1.a aVar) {
        h((e) aVar);
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final int c() {
        return 64;
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final int doFinal(byte[] bArr, int i) {
        long j = this.d;
        if (j > 2305843009213693951L) {
            this.e += j >>> 61;
            this.d = j & 2305843009213693951L;
        }
        long j2 = this.d << 3;
        long j3 = this.e;
        byte b = Byte.MIN_VALUE;
        while (true) {
            update(b);
            if (this.c == 0) {
                break;
            }
            b = 0;
        }
        if (this.o > 14) {
            i();
        }
        long[] jArr = this.n;
        jArr[14] = j3;
        jArr[15] = j2;
        i();
        c2.L(bArr, i, this.f);
        c2.L(bArr, i + 8, this.g);
        c2.L(bArr, i + 16, this.h);
        c2.L(bArr, i + 24, this.i);
        c2.L(bArr, i + 32, this.j);
        c2.L(bArr, i + 40, this.k);
        c2.L(bArr, i + 48, this.l);
        c2.L(bArr, i + 56, this.m);
        reset();
        return 64;
    }

    public final void h(e eVar) {
        byte[] bArr = eVar.b;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        this.c = eVar.c;
        this.d = eVar.d;
        this.e = eVar.e;
        this.f = eVar.f;
        this.g = eVar.g;
        this.h = eVar.h;
        this.i = eVar.i;
        this.j = eVar.j;
        this.k = eVar.k;
        this.l = eVar.l;
        this.m = eVar.m;
        long[] jArr = eVar.n;
        System.arraycopy(jArr, 0, this.n, 0, jArr.length);
        this.o = eVar.o;
    }

    public final void i() {
        long[] jArr;
        long j = this.d;
        if (j > 2305843009213693951L) {
            this.e += j >>> 61;
            this.d = j & 2305843009213693951L;
        }
        int i = 16;
        while (true) {
            jArr = this.n;
            if (i > 79) {
                break;
            }
            long j2 = jArr[i - 2];
            long j3 = ((j2 >>> 6) ^ (((j2 << 45) | (j2 >>> 19)) ^ ((j2 << 3) | (j2 >>> 61)))) + jArr[i - 7];
            long j4 = jArr[i - 15];
            jArr[i] = j3 + ((((j4 >>> 8) | (j4 << 56)) ^ ((j4 << 63) | (j4 >>> 1))) ^ (j4 >>> 7)) + jArr[i - 16];
            i++;
        }
        long j5 = this.f;
        long j6 = this.g;
        long j7 = this.h;
        long j8 = this.i;
        long j9 = this.j;
        long j10 = this.k;
        long j11 = this.l;
        long j12 = this.m;
        long j13 = j10;
        int i2 = 0;
        long j14 = j7;
        long j15 = j9;
        long j16 = j11;
        long j17 = j6;
        long jF = j5;
        long j18 = j8;
        int i3 = 0;
        while (i3 < 10) {
            int i4 = i3;
            long j19 = j13;
            long j20 = j15;
            long jG = g(j15) + d(j15, j19, j16);
            long[] jArr2 = p;
            int i5 = i2 + 1;
            long j21 = jG + jArr2[i2] + jArr[i2] + j12;
            long j22 = j18 + j21;
            long j23 = j17;
            long j24 = j14;
            long jF2 = f(jF) + e(jF, j23, j24) + j21;
            int i6 = i2 + 2;
            long jG2 = g(j22) + d(j22, j20, j19) + jArr2[i5] + jArr[i5] + j16;
            long j25 = j24 + jG2;
            long j26 = jF;
            long jF3 = f(jF2) + e(jF2, j26, j23) + jG2;
            int i7 = i2 + 3;
            long jG3 = g(j25) + d(j25, j22, j20) + jArr2[i6] + jArr[i6] + j19;
            long j27 = j23 + jG3;
            long jF4 = f(jF3) + e(jF3, jF2, j26) + jG3;
            int i8 = i2 + 4;
            long jG4 = g(j27) + d(j27, j25, j22) + jArr2[i7] + jArr[i7] + j20;
            long j28 = j26 + jG4;
            long jF5 = f(jF4) + e(jF4, jF3, jF2) + jG4;
            int i9 = i2 + 5;
            long jG5 = g(j28) + d(j28, j27, j25) + jArr2[i8] + jArr[i8] + j22;
            long j29 = jF2 + jG5;
            long jF6 = f(jF5) + e(jF5, jF4, jF3) + jG5;
            int i10 = i2 + 6;
            long jG6 = g(j29) + d(j29, j28, j27) + jArr2[i9] + jArr[i9] + j25;
            long j30 = jF3 + jG6;
            long jF7 = f(jF6) + e(jF6, jF5, jF4) + jG6;
            int i11 = i2 + 7;
            long jG7 = g(j30) + d(j30, j29, j28) + jArr2[i10] + jArr[i10] + j27;
            long j31 = jF4 + jG7;
            long jF8 = f(jF7) + e(jF7, jF6, jF5) + jG7;
            i2 += 8;
            long jG8 = g(j31) + d(j31, j30, j29) + jArr2[i11] + jArr[i11] + j28;
            long j32 = jF5 + jG8;
            j18 = jF6;
            j13 = j31;
            j14 = jF7;
            jF = jG8 + f(jF8) + e(jF8, jF7, jF6);
            j12 = j29;
            i3 = i4 + 1;
            j16 = j30;
            j15 = j32;
            j17 = jF8;
        }
        this.f += jF;
        this.g += j17;
        this.h += j14;
        this.i += j18;
        this.j += j15;
        this.k += j13;
        this.l += j16;
        this.m += j12;
        this.o = 0;
        for (int i12 = 0; i12 < 16; i12++) {
            jArr[i12] = 0;
        }
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final void reset() {
        this.d = 0L;
        this.e = 0L;
        int i = 0;
        this.c = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.o = 0;
        while (true) {
            long[] jArr = this.n;
            if (i == jArr.length) {
                this.f = 7640891576956012808L;
                this.g = -4942790177534073029L;
                this.h = 4354685564936845355L;
                this.i = -6534734903238641935L;
                this.j = 5840696475078001361L;
                this.k = -7276294671716946913L;
                this.l = 2270897969802886507L;
                this.m = 6620516959819538809L;
                return;
            }
            jArr[i] = 0;
            i++;
        }
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final void update(byte[] bArr, int i, int i2) {
        while (this.c != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (true) {
            byte[] bArr2 = this.b;
            if (i2 < bArr2.length) {
                break;
            }
            this.n[this.o] = (c2.b(bArr, i + 4) & 4294967295L) | ((c2.b(bArr, i) & 4294967295L) << 32);
            int i3 = this.o + 1;
            this.o = i3;
            if (i3 == 16) {
                i();
            }
            i += bArr2.length;
            i2 -= bArr2.length;
            this.d += bArr2.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }

    public e(e eVar) {
        this.b = new byte[8];
        this.n = new long[80];
        this.a = eVar.a;
        h(eVar);
        g.a();
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final void update(byte b) {
        int i = this.c;
        int i2 = i + 1;
        this.c = i2;
        byte[] bArr = this.b;
        bArr[i] = b;
        if (i2 == bArr.length) {
            this.n[this.o] = (c2.b(bArr, 4) & 4294967295L) | ((c2.b(bArr, 0) & 4294967295L) << 32);
            int i3 = this.o + 1;
            this.o = i3;
            if (i3 == 16) {
                i();
            }
            this.c = 0;
        }
        this.d++;
    }
}
