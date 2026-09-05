package com.github.catvod.spider.merge.b1;

import com.github.catvod.spider.merge.a1.k;

/* loaded from: classes.dex */
public abstract class a implements k, com.github.catvod.spider.merge.j1.a {
    public final com.github.catvod.spider.merge.a1.d a;
    public final byte[] b;
    public int c;
    public long d;

    public a(a aVar) {
        this.b = new byte[4];
        this.a = aVar.a;
        d(aVar);
    }

    public final void d(a aVar) {
        byte[] bArr = aVar.b;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        this.c = aVar.c;
        this.d = aVar.d;
    }

    public final void e() {
        long j = this.d << 3;
        byte b = Byte.MIN_VALUE;
        while (true) {
            update(b);
            if (this.c == 0) {
                g(j);
                f();
                return;
            }
            b = 0;
        }
    }

    public abstract void f();

    public abstract void g(long j);

    public abstract void h(byte[] bArr, int i);

    @Override // com.github.catvod.spider.merge.a1.k
    public void reset() {
        this.d = 0L;
        this.c = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i >= bArr.length) {
                return;
            }
            bArr[i] = 0;
            i++;
        }
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final void update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int iMax = Math.max(0, i2);
        int i4 = this.c;
        byte[] bArr2 = this.b;
        if (i4 != 0) {
            int i5 = 0;
            while (true) {
                if (i5 >= iMax) {
                    i3 = i5;
                    break;
                }
                int i6 = this.c;
                int i7 = i6 + 1;
                this.c = i7;
                int i8 = i5 + 1;
                bArr2[i6] = bArr[i5 + i];
                if (i7 == 4) {
                    h(bArr2, 0);
                    this.c = 0;
                    i3 = i8;
                    break;
                }
                i5 = i8;
            }
        }
        int i9 = iMax - 3;
        while (i3 < i9) {
            h(bArr, i + i3);
            i3 += 4;
        }
        while (i3 < iMax) {
            int i10 = this.c;
            this.c = i10 + 1;
            bArr2[i10] = bArr[i3 + i];
            i3++;
        }
        this.d += iMax;
    }

    public a(com.github.catvod.spider.merge.a1.d dVar) {
        this.b = new byte[4];
        this.a = dVar;
        this.c = 0;
    }

    @Override // com.github.catvod.spider.merge.a1.k
    public final void update(byte b) {
        int i = this.c;
        int i2 = i + 1;
        this.c = i2;
        byte[] bArr = this.b;
        bArr[i] = b;
        if (i2 == bArr.length) {
            h(bArr, 0);
            this.c = 0;
        }
        this.d++;
    }
}
