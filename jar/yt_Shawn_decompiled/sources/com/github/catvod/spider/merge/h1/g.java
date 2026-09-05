package com.github.catvod.spider.merge.h1;

/* loaded from: classes.dex */
public class g implements com.github.catvod.spider.merge.a1.c {
    public final byte[] a;

    public g(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }
}
