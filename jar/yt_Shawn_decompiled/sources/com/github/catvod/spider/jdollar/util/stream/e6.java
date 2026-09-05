package com.github.catvod.spider.jdollar.util.stream;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class e6 extends a6 {
    public u6 c;

    @Override // com.github.catvod.spider.jdollar.util.stream.l5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) {
        this.c.accept(j);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.github.catvod.spider.jdollar.util.stream.u6, com.github.catvod.spider.jdollar.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.github.catvod.spider.jdollar.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.github.catvod.spider.jdollar.util.stream.w6] */
    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        if (j < 2147483639) {
            this.c = j > 0 ? new u6((int) j) : new w6();
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        long[] jArr = (long[]) this.c.b();
        Arrays.sort(jArr);
        long length = jArr.length;
        m5 m5Var = this.a;
        m5Var.c(length);
        int i = 0;
        if (this.b) {
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                if (m5Var.e()) {
                    break;
                }
                m5Var.accept(j);
                i++;
            }
        } else {
            int length3 = jArr.length;
            while (i < length3) {
                m5Var.accept(jArr[i]);
                i++;
            }
        }
        m5Var.end();
    }
}
