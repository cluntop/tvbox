package com.github.catvod.spider.merge.f1;

import com.github.catvod.spider.merge.a1.h;
import com.github.catvod.spider.merge.a1.n;
import com.github.catvod.spider.merge.a1.o;
import com.github.catvod.spider.merge.u.c2;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class f extends h implements o {
    public final com.github.catvod.spider.merge.a1.a a;
    public final int b;
    public byte[] c;
    public final byte[] d;
    public final byte[] e;
    public int f;

    public f(com.github.catvod.spider.merge.c1.a aVar) {
        this.a = aVar;
        aVar.getClass();
        this.b = 16;
        this.c = new byte[16];
        this.d = new byte[16];
        this.e = new byte[16];
        this.f = 0;
    }

    @Override // com.github.catvod.spider.merge.a1.a
    public final void a(boolean z, com.github.catvod.spider.merge.a1.c cVar) {
        if (!(cVar instanceof com.github.catvod.spider.merge.h1.h)) {
            com.github.catvod.spider.merge.s0.a.r("CTR/SIC mode requires ParametersWithIV");
            return;
        }
        com.github.catvod.spider.merge.h1.h hVar = (com.github.catvod.spider.merge.h1.h) cVar;
        byte[] bArrI = c2.i(hVar.a);
        this.c = bArrI;
        int length = bArrI.length;
        int i = this.b;
        if (i < length) {
            throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + i + " bytes.");
        }
        int i2 = 8 > i / 2 ? i / 2 : 8;
        if (i - bArrI.length > i2) {
            throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (i - i2) + " bytes.");
        }
        com.github.catvod.spider.merge.a1.c cVar2 = hVar.b;
        if (cVar2 != null) {
            this.a.a(true, cVar2);
        }
        reset();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    @Override // com.github.catvod.spider.merge.a1.a
    public final int b(int i, int i2, byte[] bArr, byte[] bArr2) throws androidx.startup.b {
        byte b;
        int i3 = this.f;
        int i4 = this.b;
        if (i3 != 0) {
            d(bArr, i, i4, bArr2, i2);
            return i4;
        }
        if (i + i4 > bArr.length) {
            throw new androidx.startup.b("input buffer too small");
        }
        if (i2 + i4 > bArr2.length) {
            throw new n("output buffer too short");
        }
        com.github.catvod.spider.merge.a1.a aVar = this.a;
        byte[] bArr3 = this.d;
        byte[] bArr4 = this.e;
        aVar.b(0, 0, bArr3, bArr4);
        for (int i5 = 0; i5 < i4; i5++) {
            bArr2[i2 + i5] = (byte) (bArr[i + i5] ^ bArr4[i5]);
        }
        int length = bArr3.length;
        do {
            length--;
            if (length < 0) {
                break;
            }
            b = (byte) (bArr3[length] + 1);
            bArr3[length] = b;
        } while (b == 0);
        return i4;
    }

    @Override // com.github.catvod.spider.merge.a1.a
    public final int c() {
        return this.a.c();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    @Override // com.github.catvod.spider.merge.a1.o
    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws androidx.startup.b {
        byte b;
        byte b2;
        if (i + i2 > bArr.length) {
            throw new androidx.startup.b("input buffer too small");
        }
        if (i3 + i2 > bArr2.length) {
            throw new n("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f;
            byte[] bArr3 = this.e;
            byte[] bArr4 = this.d;
            if (i5 == 0) {
                byte[] bArr5 = this.c;
                if (bArr5.length < this.b && bArr4[bArr5.length - 1] != bArr5[bArr5.length - 1]) {
                    com.github.catvod.spider.merge.s0.a.h("Counter in CTR/SIC mode out of range.");
                    return 0;
                }
                this.a.b(0, 0, bArr4, bArr3);
                byte b3 = bArr[i + i4];
                int i6 = this.f;
                this.f = i6 + 1;
                b = (byte) (b3 ^ bArr3[i6]);
            } else {
                byte b4 = bArr[i + i4];
                int i7 = i5 + 1;
                this.f = i7;
                b = (byte) (bArr3[i5] ^ b4);
                if (i7 == bArr4.length) {
                    this.f = 0;
                    int length = bArr4.length;
                    do {
                        length--;
                        if (length >= 0) {
                            b2 = (byte) (bArr4[length] + 1);
                            bArr4[length] = b2;
                        }
                    } while (b2 == 0);
                }
            }
            bArr2[i3 + i4] = b;
        }
        return i2;
    }

    @Override // com.github.catvod.spider.merge.a1.a
    public final void reset() {
        byte[] bArr = this.d;
        Arrays.fill(bArr, (byte) 0);
        byte[] bArr2 = this.c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        this.a.reset();
        this.f = 0;
    }
}
