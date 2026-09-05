package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.List;
import com.github.catvod.spider.jdollar.util.Objects;
import java.util.ArrayList;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j6 extends b6 {
    public ArrayList d;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.d.add(obj);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        if (j < 2147483639) {
            this.d = j >= 0 ? new ArrayList((int) j) : new ArrayList();
        } else {
            com.github.catvod.spider.jdollar.nio.file.b.c("Stream size exceeds max array size");
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void end() {
        List.EL.sort(this.d, this.b);
        long size = this.d.size();
        m5 m5Var = this.a;
        m5Var.c(size);
        boolean z = this.c;
        ArrayList arrayList = this.d;
        if (z) {
            int size2 = arrayList.size();
            int i = 0;
            while (i < size2) {
                Object obj = arrayList.get(i);
                i++;
                if (m5Var.e()) {
                    break;
                } else {
                    m5Var.accept((m5) obj);
                }
            }
        } else {
            Objects.requireNonNull(m5Var);
            Collection$EL.a(arrayList, new com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g(13, m5Var));
        }
        m5Var.end();
        this.d = null;
    }
}
