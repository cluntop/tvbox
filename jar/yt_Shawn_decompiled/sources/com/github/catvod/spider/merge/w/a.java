package com.github.catvod.spider.merge.w;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a implements Cloneable {
    public static final int[] c = new int[0];
    public int b = 0;
    public int[] a = c;

    public final void a(boolean z) {
        c(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i = this.b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.b++;
    }

    public final void b(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            com.github.catvod.spider.merge.s0.a.r("Num bits must be between 0 and 32");
            return;
        }
        int i3 = this.b;
        c(i3 + i2);
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (((1 << i4) & i) != 0) {
                int[] iArr = this.a;
                int i5 = i3 / 32;
                iArr[i5] = iArr[i5] | (1 << (i3 & 31));
            }
            i3++;
        }
        this.b = i3;
    }

    public final void c(int i) {
        if (i > this.a.length * 32) {
            int[] iArr = new int[(((int) Math.ceil(i / 0.75f)) + 31) / 32];
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            this.a = iArr;
        }
    }

    public final Object clone() {
        int[] iArr = (int[]) this.a.clone();
        int i = this.b;
        a aVar = new a();
        aVar.a = iArr;
        aVar.b = i;
        return aVar;
    }

    public final boolean d(int i) {
        return ((1 << (i & 31)) & this.a[i / 32]) != 0;
    }

    public final int e() {
        return (this.b + 7) / 8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && Arrays.equals(this.a, aVar.a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a) + (this.b * 31);
    }

    public final String toString() {
        int i = this.b;
        StringBuilder sb = new StringBuilder((i / 8) + i + 1);
        for (int i2 = 0; i2 < this.b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(d(i2) ? 'X' : '.');
        }
        return sb.toString();
    }
}
