package com.github.catvod.spider.merge.e1;

import com.github.catvod.spider.merge.a1.m;

/* loaded from: classes.dex */
public final class a implements m {
    public byte[] a;
    public byte[] b;
    public int c;
    public com.github.catvod.spider.merge.f1.b d;
    public int e;

    @Override // com.github.catvod.spider.merge.a1.m
    public final int a(byte[] bArr) throws androidx.startup.b {
        int i = this.e;
        byte[] bArr2 = this.a;
        byte[] bArr3 = this.b;
        com.github.catvod.spider.merge.f1.b bVar = this.d;
        int iC = bVar.e.c();
        while (true) {
            int i2 = this.c;
            if (i2 >= iC) {
                bVar.b(0, 0, bArr3, bArr2);
                System.arraycopy(bArr2, 0, bArr, 0, i);
                reset();
                return i;
            }
            bArr3[i2] = 0;
            this.c = i2 + 1;
        }
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final int b() {
        return this.e;
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void c(com.github.catvod.spider.merge.a1.c cVar) {
        reset();
        this.d.a(true, cVar);
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i >= bArr.length) {
                this.c = 0;
                this.d.reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void update(byte[] bArr, int i, int i2) throws androidx.startup.b {
        byte[] bArr2 = this.a;
        byte[] bArr3 = this.b;
        com.github.catvod.spider.merge.f1.b bVar = this.d;
        if (i2 < 0) {
            com.github.catvod.spider.merge.s0.a.r("Can't have a negative input length!");
            return;
        }
        int iC = bVar.e.c();
        int i3 = this.c;
        int i4 = iC - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, bArr3, i3, i4);
            bVar.b(0, 0, bArr3, bArr2);
            this.c = 0;
            i2 -= i4;
            i += i4;
            while (i2 > iC) {
                bVar.b(i, 0, bArr, bArr2);
                i2 -= iC;
                i += iC;
            }
        }
        System.arraycopy(bArr, i, bArr3, this.c, i2);
        this.c += i2;
    }

    @Override // com.github.catvod.spider.merge.a1.m
    public final void update(byte b) throws androidx.startup.b {
        int i = this.c;
        byte[] bArr = this.b;
        if (i == bArr.length) {
            this.d.b(0, 0, bArr, this.a);
            this.c = 0;
        }
        int i2 = this.c;
        this.c = i2 + 1;
        bArr[i2] = b;
    }
}
