package com.github.catvod.spider.merge.w;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b implements Cloneable {
    public int a;
    public int b;
    public int c;
    public int[] d;

    public final boolean a(int i, int i2) {
        return ((this.d[(i / 32) + (i2 * this.c)] >>> (i & 31)) & 1) != 0;
    }

    public final Object clone() {
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        int[] iArr = (int[]) this.d.clone();
        b bVar = new b();
        bVar.a = i;
        bVar.b = i2;
        bVar.c = i3;
        bVar.d = iArr;
        return bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && Arrays.equals(this.d, bVar.d);
    }

    public final int hashCode() {
        int i = this.a;
        return Arrays.hashCode(this.d) + (((((((i * 31) + i) * 31) + this.b) * 31) + this.c) * 31);
    }

    public final String toString() {
        int i = this.b;
        int i2 = this.a;
        StringBuilder sb = new StringBuilder((i2 + 1) * i);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(a(i4, i3) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
