package com.github.catvod.spider.merge.f1;

import com.github.catvod.spider.merge.a1.l;
import com.github.catvod.spider.merge.a1.n;
import com.github.catvod.spider.merge.h1.h;
import com.github.catvod.spider.merge.u.c2;
import java.io.IOException;

/* loaded from: classes.dex */
public final class d implements a {
    public com.github.catvod.spider.merge.c1.a a;
    public int b;
    public boolean c;
    public byte[] d;
    public byte[] e;
    public int f;
    public com.github.catvod.spider.merge.a1.c g;
    public byte[] h;
    public c i;
    public c j;

    public static int g(int i, boolean z) {
        if (!z || (i >= 32 && i <= 128 && (i & 15) == 0)) {
            return i >>> 3;
        }
        com.github.catvod.spider.merge.s0.a.r("tag length in octets must be one of {4,6,8,10,12,14,16}");
        return 0;
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final void a(boolean z, com.github.catvod.spider.merge.a1.c cVar) {
        String strConcat;
        com.github.catvod.spider.merge.a1.c cVar2;
        this.c = z;
        if (cVar instanceof com.github.catvod.spider.merge.h1.a) {
            com.github.catvod.spider.merge.h1.a aVar = (com.github.catvod.spider.merge.h1.a) cVar;
            this.d = c2.i(aVar.b);
            this.e = c2.i(aVar.a);
            this.f = g(aVar.d, z);
            cVar2 = aVar.c;
        } else if (!(cVar instanceof h)) {
            strConcat = "invalid parameters passed to CCM: ".concat(cVar.getClass().getName());
            com.github.catvod.spider.merge.s0.a.r(strConcat);
        } else {
            h hVar = (h) cVar;
            this.d = hVar.a;
            this.e = null;
            this.f = g(64, z);
            cVar2 = hVar.b;
        }
        if (cVar2 != null) {
            this.g = cVar2;
        }
        byte[] bArr = this.d;
        if (bArr != null && bArr.length >= 7 && bArr.length <= 13) {
            reset();
        } else {
            strConcat = "nonce must have length from 7 to 13 octets";
            com.github.catvod.spider.merge.s0.a.r(strConcat);
        }
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final int b(int i) {
        return 0;
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final int c(int i) {
        int size = this.j.size() + i;
        boolean z = this.c;
        int i2 = this.f;
        if (z) {
            return size + i2;
        }
        if (size < i2) {
            return 0;
        }
        return size - i2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    @Override // com.github.catvod.spider.merge.f1.a
    public final int d(int i, int i2, byte[] bArr, byte[] bArr2) throws androidx.startup.b, IOException {
        if (bArr.length < i + i2) {
            throw new androidx.startup.b("Input buffer too short");
        }
        this.j.write(bArr, i, i2);
        return 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    @Override // com.github.catvod.spider.merge.f1.a
    public final int doFinal(byte[] bArr, int i) throws l, androidx.startup.b {
        int i2;
        c cVar = this.j;
        byte[] bArrJ = cVar.j();
        int size = cVar.size();
        byte[] bArr2 = this.h;
        int i3 = this.b;
        if (this.g == null) {
            com.github.catvod.spider.merge.s0.a.h("CCM cipher unitialized.");
            return 0;
        }
        byte[] bArr3 = this.d;
        int length = bArr3.length;
        int i4 = 15 - length;
        if (i4 < 4) {
            if (size - (!this.c ? 16 : 0) >= (1 << (i4 * 8))) {
                com.github.catvod.spider.merge.s0.a.h("CCM packet too large for choice of q");
                return 0;
            }
        }
        byte[] bArr4 = new byte[i3];
        bArr4[0] = (byte) ((14 - length) & 7);
        System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
        f fVar = new f(this.a);
        boolean z = this.c;
        com.github.catvod.spider.merge.a1.c cVar2 = this.g;
        h hVar = new h();
        byte[] bArr5 = new byte[i3];
        hVar.a = bArr5;
        hVar.b = cVar2;
        System.arraycopy(bArr4, 0, bArr5, 0, i3);
        fVar.a(z, hVar);
        boolean z2 = this.c;
        int i5 = this.f;
        if (z2) {
            i2 = i5 + size;
            if (bArr.length < i2 + i) {
                throw new n("Output buffer too short.");
            }
            f(0, size, bArrJ, bArr2);
            byte[] bArr6 = new byte[i3];
            fVar.b(0, 0, bArr2, bArr6);
            int i6 = i;
            int i7 = 0;
            while (i7 < size - i3) {
                fVar.b(i7, i6, bArrJ, bArr);
                i6 += i3;
                i7 += i3;
            }
            byte[] bArr7 = new byte[i3];
            int i8 = size - i7;
            System.arraycopy(bArrJ, i7, bArr7, 0, i8);
            fVar.b(0, 0, bArr7, bArr7);
            System.arraycopy(bArr7, 0, bArr, i6, i8);
            System.arraycopy(bArr6, 0, bArr, i + size, this.f);
        } else {
            if (size < i5) {
                throw new l("data too short");
            }
            int i9 = size - i5;
            if (bArr.length < i9 + i) {
                throw new n("Output buffer too short.");
            }
            System.arraycopy(bArrJ, i9, bArr2, 0, i5);
            fVar.b(0, 0, bArr2, bArr2);
            for (int i10 = this.f; i10 != bArr2.length; i10++) {
                bArr2[i10] = 0;
            }
            int i11 = i;
            int i12 = 0;
            while (i12 < i9 - i3) {
                fVar.b(i12, i11, bArrJ, bArr);
                i11 += i3;
                i12 += i3;
            }
            byte[] bArr8 = new byte[i3];
            int i13 = i9 - i12;
            System.arraycopy(bArrJ, i12, bArr8, 0, i13);
            fVar.b(0, 0, bArr8, bArr8);
            System.arraycopy(bArr8, 0, bArr, i11, i13);
            byte[] bArr9 = new byte[i3];
            f(i, i9, bArr, bArr9);
            if (!c2.l(bArr2, bArr9)) {
                throw new l("mac check in CCM failed");
            }
            i2 = i9;
        }
        reset();
        return i2;
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final void e(byte[] bArr, int i, int i2) throws IOException {
        this.i.write(bArr, i, i2);
    }

    public final void f(int i, int i2, byte[] bArr, byte[] bArr2) throws androidx.startup.b {
        c cVar = this.i;
        com.github.catvod.spider.merge.c1.a aVar = this.a;
        int i3 = this.f * 8;
        com.github.catvod.spider.merge.e1.a aVar2 = new com.github.catvod.spider.merge.e1.a();
        if (i3 % 8 != 0) {
            com.github.catvod.spider.merge.s0.a.r("MAC size must be multiple of 8");
            return;
        }
        b bVar = new b();
        bVar.e = aVar;
        aVar.getClass();
        bVar.d = 16;
        bVar.a = new byte[16];
        bVar.b = new byte[16];
        bVar.c = new byte[16];
        aVar2.d = bVar;
        int i4 = i3 / 8;
        aVar2.e = i4;
        aVar2.a = new byte[16];
        aVar2.b = new byte[16];
        aVar2.c = 0;
        aVar2.c(this.g);
        byte[] bArr3 = new byte[16];
        int size = cVar.size();
        byte[] bArr4 = this.e;
        if (size + (bArr4 == null ? 0 : bArr4.length) > 0) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i5 = 2;
        byte b = (byte) (((((i4 - 2) / 2) & 7) << 3) | bArr3[0]);
        bArr3[0] = b;
        byte[] bArr5 = this.d;
        bArr3[0] = (byte) (b | ((14 - bArr5.length) & 7));
        System.arraycopy(bArr5, 0, bArr3, 1, bArr5.length);
        int i6 = i2;
        int i7 = 1;
        while (i6 > 0) {
            bArr3[16 - i7] = (byte) (i6 & 255);
            i6 >>>= 8;
            i7++;
        }
        aVar2.update(bArr3, 0, 16);
        int size2 = cVar.size();
        byte[] bArr6 = this.e;
        if (size2 + (bArr6 == null ? 0 : bArr6.length) > 0) {
            int size3 = cVar.size();
            byte[] bArr7 = this.e;
            int length = size3 + (bArr7 == null ? 0 : bArr7.length);
            if (length < 65280) {
                aVar2.update((byte) (length >> 8));
                aVar2.update((byte) length);
            } else {
                aVar2.update((byte) -1);
                aVar2.update((byte) -2);
                aVar2.update((byte) (length >> 24));
                aVar2.update((byte) (length >> 16));
                aVar2.update((byte) (length >> 8));
                aVar2.update((byte) length);
                i5 = 6;
            }
            byte[] bArr8 = this.e;
            if (bArr8 != null) {
                aVar2.update(bArr8, 0, bArr8.length);
            }
            if (cVar.size() > 0) {
                aVar2.update(cVar.j(), 0, cVar.size());
            }
            int i8 = (i5 + length) % 16;
            if (i8 != 0) {
                while (i8 != 16) {
                    aVar2.update((byte) 0);
                    i8++;
                }
            }
        }
        aVar2.update(bArr, i, i2);
        aVar2.a(bArr2);
    }

    @Override // com.github.catvod.spider.merge.f1.a
    public final void reset() {
        this.a.getClass();
        this.i.reset();
        this.j.reset();
    }
}
