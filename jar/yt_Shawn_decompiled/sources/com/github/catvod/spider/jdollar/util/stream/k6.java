package com.github.catvod.spider.jdollar.util.stream;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k6 extends y5 {
    public double[] c;
    public int d;

    @Override // com.github.catvod.spider.jdollar.util.stream.j5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        double[] dArr = this.c;
        int i = this.d;
        this.d = i + 1;
        dArr[i] = d;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        if (j < 2147483639) {
            this.c = new double[(int) j];
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        int i = 0;
        Arrays.sort(this.c, 0, this.d);
        long j = this.d;
        m5 m5Var = this.a;
        m5Var.c(j);
        if (this.b) {
            while (i < this.d && !m5Var.e()) {
                m5Var.accept(this.c[i]);
                i++;
            }
        } else {
            while (i < this.d) {
                m5Var.accept(this.c[i]);
                i++;
            }
        }
        m5Var.end();
        this.c = null;
    }
}
