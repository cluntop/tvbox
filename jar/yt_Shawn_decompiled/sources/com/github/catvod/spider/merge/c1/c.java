package com.github.catvod.spider.merge.c1;

import com.github.catvod.spider.merge.a1.d;
import com.github.catvod.spider.merge.a1.f;
import com.github.catvod.spider.merge.a1.n;
import com.github.catvod.spider.merge.a1.o;
import com.github.catvod.spider.merge.h1.g;

/* loaded from: classes.dex */
public final class c implements o {
    public byte[] a;
    public int b;
    public int c;
    public byte[] d;

    @Override // com.github.catvod.spider.merge.a1.o
    public final void a(boolean z, com.github.catvod.spider.merge.a1.c cVar) {
        if (!(cVar instanceof g)) {
            com.github.catvod.spider.merge.s0.a.r("invalid parameter passed to RC4 init - ".concat(cVar.getClass().getName()));
            return;
        }
        byte[] bArr = ((g) cVar).a;
        this.d = bArr;
        b(bArr);
        if (cVar instanceof d) {
            com.github.catvod.spider.merge.s0.a.r("params should not be CryptoServicePurpose");
        } else {
            ((f) com.github.catvod.spider.merge.a1.g.b.get()).getClass();
        }
    }

    public final void b(byte[] bArr) {
        this.d = bArr;
        this.b = 0;
        this.c = 0;
        if (this.a == null) {
            this.a = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.a[i] = (byte) i;
        }
        int length = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = bArr[length] & 255;
            byte[] bArr2 = this.a;
            byte b = bArr2[i3];
            i2 = (i4 + b + i2) & 255;
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
            length = (length + 1) % bArr.length;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: androidx.startup.b */
    @Override // com.github.catvod.spider.merge.a1.o
    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws androidx.startup.b {
        if (i + i2 > bArr.length) {
            throw new androidx.startup.b("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new n("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = (this.b + 1) & 255;
            this.b = i5;
            byte[] bArr3 = this.a;
            byte b = bArr3[i5];
            int i6 = (this.c + b) & 255;
            this.c = i6;
            bArr3[i5] = bArr3[i6];
            bArr3[i6] = b;
            bArr2[i4 + i3] = (byte) (bArr3[(bArr3[i5] + b) & 255] ^ bArr[i4 + i]);
        }
        return i2;
    }

    @Override // com.github.catvod.spider.merge.a1.o
    public final void reset() {
        b(this.d);
    }
}
