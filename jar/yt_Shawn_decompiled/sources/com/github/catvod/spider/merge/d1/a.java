package com.github.catvod.spider.merge.d1;

import com.github.catvod.spider.merge.a1.i;
import com.github.catvod.spider.merge.e1.c;
import java.math.BigInteger;

/* loaded from: classes.dex */
public final class a implements i {
    public static final BigInteger i = BigInteger.valueOf(2147483647L);
    public static final BigInteger j = BigInteger.valueOf(2);
    public final c a;
    public final int b;
    public byte[] c;
    public byte[] d;
    public int e;
    public byte[] f;
    public int g;
    public final byte[] h;

    public a(c cVar) {
        this.a = cVar;
        int i2 = cVar.b;
        this.b = i2;
        this.h = new byte[i2];
    }

    public final void a() {
        int i2 = (this.g / this.b) + 1;
        byte[] bArr = this.f;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length != 4) {
                        com.github.catvod.spider.merge.s0.a.h("Unsupported size of counter i");
                        return;
                    }
                    bArr[0] = (byte) (i2 >>> 24);
                }
                bArr[bArr.length - 3] = (byte) (i2 >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i2 >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i2;
        byte[] bArr2 = this.c;
        int length2 = bArr2.length;
        c cVar = this.a;
        cVar.update(bArr2, 0, length2);
        byte[] bArr3 = this.f;
        cVar.update(bArr3, 0, bArr3.length);
        byte[] bArr4 = this.d;
        cVar.update(bArr4, 0, bArr4.length);
        cVar.a(this.h);
    }
}
