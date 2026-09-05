package com.github.catvod.spider.merge.x;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b {
    public final a a;
    public final int[] b;

    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = aVar;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int i2 = length - i;
        int[] iArr2 = new int[i2];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, i2);
    }

    public final b a(b bVar) {
        a aVar = bVar.a;
        a aVar2 = this.a;
        if (!aVar2.equals(aVar)) {
            com.github.catvod.spider.merge.s0.a.r("GenericGFPolys do not have same GenericGF field");
            return null;
        }
        if (c()) {
            return bVar;
        }
        if (bVar.c()) {
            return this;
        }
        int[] iArr = bVar.b;
        int[] iArr2 = this.b;
        if (iArr2.length > iArr.length) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = iArr2[i - length] ^ iArr[i];
        }
        return new b(aVar2, iArr3);
    }

    public final int b() {
        return this.b.length - 1;
    }

    public final boolean c() {
        return this.b[0] == 0;
    }

    public final String toString() {
        if (c()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int iB = b(); iB >= 0; iB--) {
            int[] iArr = this.b;
            int i = iArr[(iArr.length - 1) - iB];
            if (i != 0) {
                if (i < 0) {
                    if (iB == b()) {
                        sb.append("-");
                    } else {
                        sb.append(" - ");
                    }
                    i = -i;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iB == 0 || i != 1) {
                    a aVar = this.a;
                    if (i == 0) {
                        aVar.getClass();
                        throw new IllegalArgumentException();
                    }
                    int i2 = aVar.b[i];
                    if (i2 == 0) {
                        sb.append('1');
                    } else if (i2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i2);
                    }
                }
                if (iB != 0) {
                    if (iB == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iB);
                    }
                }
            }
        }
        return sb.toString();
    }
}
