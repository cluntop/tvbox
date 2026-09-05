package com.github.catvod.spider.merge.h1;

import com.github.catvod.spider.merge.u.c2;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e {
    public final byte[] a;
    public final int b;

    public e(byte[] bArr, int i) {
        this.a = c2.i(bArr);
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (eVar.b != this.b) {
            return false;
        }
        return Arrays.equals(this.a, eVar.a);
    }

    public final int hashCode() {
        int i;
        byte[] bArr = this.a;
        if (bArr == null) {
            i = 0;
        } else {
            int length = bArr.length;
            int i2 = length + 1;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                i2 = (i2 * 257) ^ bArr[length];
            }
            i = i2;
        }
        return i ^ this.b;
    }
}
