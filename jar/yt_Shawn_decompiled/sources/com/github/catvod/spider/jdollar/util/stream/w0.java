package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class w0 extends g5 {
    public boolean b;
    public final com.github.catvod.spider.jdollar.util.h0 c;
    public final /* synthetic */ t0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(t0 t0Var, m5 m5Var) {
        super(m5Var);
        this.d = t0Var;
        m5 m5Var2 = this.a;
        Objects.requireNonNull(m5Var2);
        this.c = new com.github.catvod.spider.jdollar.util.h0(m5Var2, 1);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.k5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void accept(int i) throws Exception {
        IntStream intStream = (IntStream) ((k0) this.d.n).apply(i);
        if (intStream != null) {
            try {
                boolean z = this.b;
                com.github.catvod.spider.jdollar.util.h0 h0Var = this.c;
                if (z) {
                    com.github.catvod.spider.jdollar.util.u0 u0VarSpliterator = intStream.sequential().spliterator();
                    while (!this.a.e() && u0VarSpliterator.tryAdvance((IntConsumer) h0Var)) {
                    }
                } else {
                    intStream.sequential().forEach(h0Var);
                }
            } catch (Throwable th) {
                try {
                    intStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (intStream != null) {
            intStream.close();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        this.b = true;
        return this.a.e();
    }
}
