package com.github.catvod.spider.jdollar.util.stream;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class d6 extends z5 {
    public s6 c;

    @Override // com.github.catvod.spider.jdollar.util.stream.k5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) {
        this.c.accept(i);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.github.catvod.spider.jdollar.util.stream.s6, com.github.catvod.spider.jdollar.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.github.catvod.spider.jdollar.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.github.catvod.spider.jdollar.util.stream.w6] */
    @Override // com.github.catvod.spider.jdollar.util.stream.g5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        if (j < 2147483639) {
            this.c = j > 0 ? new s6((int) j) : new w6();
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        int[] iArr = (int[]) this.c.b();
        Arrays.sort(iArr);
        long length = iArr.length;
        m5 m5Var = this.a;
        m5Var.c(length);
        int i = 0;
        if (this.b) {
            int length2 = iArr.length;
            while (i < length2) {
                int i2 = iArr[i];
                if (m5Var.e()) {
                    break;
                }
                m5Var.accept(i2);
                i++;
            }
        } else {
            int length3 = iArr.length;
            while (i < length3) {
                m5Var.accept(iArr[i]);
                i++;
            }
        }
        m5Var.end();
    }
}
