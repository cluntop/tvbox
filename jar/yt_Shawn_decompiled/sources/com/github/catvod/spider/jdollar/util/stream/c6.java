package com.github.catvod.spider.jdollar.util.stream;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c6 extends y5 {
    public q6 c;

    @Override // com.github.catvod.spider.jdollar.util.stream.j5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) {
        this.c.accept(d);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.github.catvod.spider.jdollar.util.stream.q6, com.github.catvod.spider.jdollar.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.github.catvod.spider.jdollar.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.github.catvod.spider.jdollar.util.stream.w6] */
    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        if (j < 2147483639) {
            this.c = j > 0 ? new q6((int) j) : new w6();
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        double[] dArr = (double[]) this.c.b();
        Arrays.sort(dArr);
        long length = dArr.length;
        m5 m5Var = this.a;
        m5Var.c(length);
        int i = 0;
        if (this.b) {
            int length2 = dArr.length;
            while (i < length2) {
                double d = dArr[i];
                if (m5Var.e()) {
                    break;
                }
                m5Var.accept(d);
                i++;
            }
        } else {
            int length3 = dArr.length;
            while (i < length3) {
                m5Var.accept(dArr[i]);
                i++;
            }
        }
        m5Var.end();
    }
}
