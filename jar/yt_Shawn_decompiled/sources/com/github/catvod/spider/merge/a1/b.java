package com.github.catvod.spider.merge.a1;

/* loaded from: classes.dex */
public final class b {
    public byte[] a;
    public int b;
    public boolean c;
    public com.github.catvod.spider.merge.c1.b d;
    public h e;
    public boolean f;
    public boolean g;

    public final int a(byte[] bArr, int i) {
        byte[] bArr2 = this.a;
        try {
            int i2 = this.b;
            if (i + i2 > bArr.length) {
                throw new n("output buffer too short for doFinal()");
            }
            int i3 = 0;
            if (i2 != 0) {
                if (!this.f) {
                    throw new androidx.startup.b("data not block size aligned");
                }
                this.d.b(0, 0, bArr2, bArr2);
                int i4 = this.b;
                this.b = 0;
                System.arraycopy(bArr2, 0, bArr, i, i4);
                i3 = i4;
            }
            b();
            return i3;
        } catch (Throwable th) {
            b();
            throw th;
        }
    }

    public final void b() {
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                this.b = 0;
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }
}
