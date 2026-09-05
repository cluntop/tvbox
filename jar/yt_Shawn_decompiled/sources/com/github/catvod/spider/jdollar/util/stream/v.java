package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v extends f5 {
    public boolean b;
    public final com.github.catvod.spider.jdollar.util.e0 c;
    public final /* synthetic */ w d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, m5 m5Var) {
        super(m5Var);
        this.d = wVar;
        m5 m5Var2 = this.a;
        Objects.requireNonNull(m5Var2);
        this.c = new com.github.catvod.spider.jdollar.util.e0(m5Var2, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.j5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(double d) throws Exception {
        DoubleStream doubleStream = (DoubleStream) ((com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g) this.d.n).apply(d);
        if (doubleStream != null) {
            try {
                boolean z = this.b;
                com.github.catvod.spider.jdollar.util.e0 e0Var = this.c;
                if (z) {
                    com.github.catvod.spider.jdollar.util.r0 r0VarSpliterator = doubleStream.sequential().spliterator();
                    while (!this.a.e() && r0VarSpliterator.tryAdvance((DoubleConsumer) e0Var)) {
                    }
                } else {
                    doubleStream.sequential().forEach(e0Var);
                }
            } catch (Throwable th) {
                try {
                    doubleStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (doubleStream != null) {
            doubleStream.close();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.f5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        this.b = true;
        return this.a.e();
    }
}
