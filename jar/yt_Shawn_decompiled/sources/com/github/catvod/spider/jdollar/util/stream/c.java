package com.github.catvod.spider.jdollar.util.stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class c {
    public final int a;
    public int b;
    public int c;
    public long[] d;

    public c(int i) {
        if (i >= 0) {
            this.a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i - 1));
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.n("Illegal Capacity: ", i);
            throw null;
        }
    }

    public abstract void clear();

    public final long count() {
        int i = this.c;
        return i == 0 ? this.b : this.d[i] + this.b;
    }

    public c() {
        this.a = 4;
    }
}
