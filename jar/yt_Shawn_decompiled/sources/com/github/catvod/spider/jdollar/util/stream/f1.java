package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f1 extends h5 {
    public boolean b;
    public final com.github.catvod.spider.jdollar.util.k0 c;
    public final /* synthetic */ g1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(g1 g1Var, m5 m5Var) {
        super(m5Var);
        this.d = g1Var;
        m5 m5Var2 = this.a;
        Objects.requireNonNull(m5Var2);
        this.c = new com.github.catvod.spider.jdollar.util.k0(m5Var2, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.l5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(long j) throws Exception {
        LongStream longStream = (LongStream) ((com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g) this.d.n).apply(j);
        if (longStream != null) {
            try {
                boolean z = this.b;
                com.github.catvod.spider.jdollar.util.k0 k0Var = this.c;
                if (z) {
                    com.github.catvod.spider.jdollar.util.x0 x0VarSpliterator = longStream.sequential().spliterator();
                    while (!this.a.e() && x0VarSpliterator.tryAdvance((LongConsumer) k0Var)) {
                    }
                } else {
                    longStream.sequential().forEach(k0Var);
                }
            } catch (Throwable th) {
                try {
                    longStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (longStream != null) {
            longStream.close();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.h5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        this.b = true;
        return this.a.e();
    }
}
