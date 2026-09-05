package com.github.catvod.spider.merge.f1;

import com.github.catvod.spider.merge.a1.h;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b extends h {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public int d;
    public com.github.catvod.spider.merge.a1.a e;
    public boolean f;

    @Override // com.github.catvod.spider.merge.a1.a
    public final void a(boolean z, com.github.catvod.spider.merge.a1.c cVar) {
        byte[] bArr = this.a;
        boolean z2 = this.f;
        this.f = z;
        if (cVar instanceof com.github.catvod.spider.merge.h1.h) {
            com.github.catvod.spider.merge.h1.h hVar = (com.github.catvod.spider.merge.h1.h) cVar;
            byte[] bArr2 = hVar.a;
            if (bArr2.length != this.d) {
                com.github.catvod.spider.merge.s0.a.r("initialisation vector must be the same length as block size");
                return;
            } else {
                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                cVar = hVar.b;
            }
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        reset();
        if (cVar != null) {
            this.e.a(z, cVar);
        } else {
            if (z2 == z) {
                return;
            }
            com.github.catvod.spider.merge.s0.a.r("cannot change encrypting state without providing key.");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    @Override // com.github.catvod.spider.merge.a1.a
    public final int b(int i, int i2, byte[] bArr, byte[] bArr2) throws androidx.startup.b {
        com.github.catvod.spider.merge.a1.a aVar = this.e;
        boolean z = this.f;
        int i3 = this.d;
        if (!z) {
            if (i + i3 > bArr.length) {
                throw new androidx.startup.b("input buffer too short");
            }
            System.arraycopy(bArr, i, this.c, 0, i3);
            int iB = aVar.b(i, i2, bArr, bArr2);
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i2 + i4;
                bArr2[i5] = (byte) (bArr2[i5] ^ this.b[i4]);
            }
            byte[] bArr3 = this.b;
            this.b = this.c;
            this.c = bArr3;
            return iB;
        }
        if (i + i3 > bArr.length) {
            throw new androidx.startup.b("input buffer too short");
        }
        int i6 = 0;
        while (true) {
            byte[] bArr4 = this.b;
            if (i6 >= i3) {
                int iB2 = aVar.b(0, i2, bArr4, bArr2);
                byte[] bArr5 = this.b;
                System.arraycopy(bArr2, i2, bArr5, 0, bArr5.length);
                return iB2;
            }
            bArr4[i6] = (byte) (bArr4[i6] ^ bArr[i + i6]);
            i6++;
        }
    }

    @Override // com.github.catvod.spider.merge.a1.a
    public final int c() {
        return this.e.c();
    }

    @Override // com.github.catvod.spider.merge.a1.a
    public final void reset() {
        byte[] bArr = this.a;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        Arrays.fill(this.c, (byte) 0);
        this.e.reset();
    }
}
