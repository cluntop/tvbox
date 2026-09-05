package com.github.catvod.spider.merge.x;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a {
    public static final a g;
    public final int[] a;
    public final int[] b;
    public final b c;
    public final int d;
    public final int e;
    public final int f;

    static {
        new a(4201, 4096, 1);
        new a(1033, 1024, 1);
        new a(67, 64, 1);
        new a(19, 16, 1);
        g = new a(285, 256, 0);
        new a(301, 256, 1);
    }

    public a(int i, int i2, int i3) {
        this.e = i;
        this.d = i2;
        this.f = i3;
        this.a = new int[i2];
        this.b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.a[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.b[this.a[i6]] = i6;
        }
        this.c = new b(this, new int[]{0});
    }

    public final int a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.b;
        return this.a[(iArr[i] + iArr[i2]) % (this.d - 1)];
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.e) + ',' + this.d + ')';
    }
}
