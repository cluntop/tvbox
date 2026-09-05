package com.github.catvod.spider.merge.a0;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b {
    public final byte[][] a;
    public final int b;
    public final int c;

    public b(int i, int i2) {
        this.a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
        this.b = i;
        this.c = i2;
    }

    public final byte a(int i, int i2) {
        return this.a[i2][i];
    }

    public final void b(int i, int i2, int i3) {
        this.a[i2][i] = (byte) i3;
    }

    public final String toString() {
        int i = this.b;
        int i2 = this.c;
        StringBuilder sb = new StringBuilder((i * 2 * i2) + 2);
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = this.a[i3];
            for (int i4 = 0; i4 < i; i4++) {
                byte b = bArr[i4];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
