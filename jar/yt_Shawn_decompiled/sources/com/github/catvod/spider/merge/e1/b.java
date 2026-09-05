package com.github.catvod.spider.merge.e1;

import com.github.catvod.spider.merge.a1.m;

/* loaded from: classes.dex */
public final class b implements m {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public int e;
    public com.github.catvod.spider.merge.f1.b f;
    public int g;
    public byte[] h;
    public byte[] i;

    @Override // com.github.catvod.spider.merge.a1.m
    public final int a(byte[] bArr) throws androidx.startup.b {
        byte[] bArr2;
        int i = this.g;
        byte[] bArr3 = this.c;
        byte[] bArr4 = this.d;
        com.github.catvod.spider.merge.f1.b bVar = this.f;
        int iC = bVar.e.c();
        int i2 = this.e;
        if (i2 == iC) {
            bArr2 = this.h;
        } else {
            int length = bArr4.length;
            bArr4[i2] = Byte.MIN_VALUE;
            while (true) {
                i2++;
                if (i2 >= bArr4.length) {
                    break;
                }
                bArr4[i2] = 0;
            }
            bArr2 = this.i;
        }
        for (int i3 = 0; i3 < bArr3.length; i3++) {
            bArr4[i3] = (byte) (bArr4[i3] ^ bArr2[i3]);
        }
        bVar.b(0, 0, bArr4, bArr3);
        System.arraycopy(bArr3, 0, bArr, 0, i);
        reset();
        return i;
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final int b() {
        return this.g;
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void c(com.github.catvod.spider.merge.a1.c cVar) throws androidx.startup.b {
        com.github.catvod.spider.merge.f1.b bVar = this.f;
        bVar.a(true, cVar);
        byte[] bArr = this.b;
        byte[] bArr2 = new byte[bArr.length];
        bVar.b(0, 0, bArr, bArr2);
        byte[] bArrD = d(bArr2);
        this.h = bArrD;
        this.i = d(bArrD);
        reset();
    }

    public final byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int length = bArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length < 0) {
                int i2 = (-i) & 255;
                int length2 = bArr.length - 3;
                byte b = bArr2[length2];
                byte[] bArr3 = this.a;
                bArr2[length2] = (byte) (b ^ (bArr3[1] & i2));
                int length3 = bArr.length - 2;
                bArr2[length3] = (byte) ((bArr3[2] & i2) ^ bArr2[length3]);
                int length4 = bArr.length - 1;
                bArr2[length4] = (byte) ((i2 & bArr3[3]) ^ bArr2[length4]);
                return bArr2;
            }
            int i3 = bArr[length] & 255;
            bArr2[length] = (byte) (i | (i3 << 1));
            i = (i3 >>> 7) & 1;
        }
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.d;
            if (i >= bArr.length) {
                this.e = 0;
                this.f.reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void update(byte[] bArr, int i, int i2) throws androidx.startup.b {
        byte[] bArr2 = this.c;
        byte[] bArr3 = this.d;
        com.github.catvod.spider.merge.f1.b bVar = this.f;
        if (i2 < 0) {
            com.github.catvod.spider.merge.s0.a.r("Can't have a negative input length!");
            return;
        }
        int iC = bVar.e.c();
        int i3 = this.e;
        int i4 = iC - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, bArr3, i3, i4);
            bVar.b(0, 0, bArr3, bArr2);
            this.e = 0;
            i2 -= i4;
            i += i4;
            while (i2 > iC) {
                bVar.b(i, 0, bArr, bArr2);
                i2 -= iC;
                i += iC;
            }
        }
        System.arraycopy(bArr, i, bArr3, this.e, i2);
        this.e += i2;
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void update(byte b) throws androidx.startup.b {
        int i = this.e;
        byte[] bArr = this.d;
        if (i == bArr.length) {
            this.f.b(0, 0, bArr, this.c);
            this.e = 0;
        }
        int i2 = this.e;
        this.e = i2 + 1;
        bArr[i2] = b;
    }
}
