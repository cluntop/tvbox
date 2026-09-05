package com.github.catvod.spider.jdollar.util.stream;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n6 extends b6 {
    public Object[] d;
    public int e;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Object[] objArr = this.d;
        int i = this.e;
        this.e = i + 1;
        objArr[i] = obj;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        if (j < 2147483639) {
            this.d = new Object[(int) j];
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        int i = 0;
        Arrays.sort(this.d, 0, this.e, this.b);
        long j = this.e;
        m5 m5Var = this.a;
        m5Var.c(j);
        if (this.c) {
            while (i < this.e && !m5Var.e()) {
                m5Var.accept((m5) this.d[i]);
                i++;
            }
        } else {
            while (i < this.e) {
                m5Var.accept((m5) this.d[i]);
                i++;
            }
        }
        m5Var.end();
        this.d = null;
    }
}
