package com.github.catvod.spider.merge.u;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class s0 {
    public static final byte[] a;

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        ByteBuffer.wrap(bArr);
        p.f(bArr, 0, 0, false);
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int b(byte[] bArr, int i, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }
}
