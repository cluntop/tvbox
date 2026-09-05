package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y4 extends i5 {
    public final /* synthetic */ int b = 0;
    public boolean c;
    public final Object d;
    public final /* synthetic */ a e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(w wVar, m5 m5Var) {
        super(m5Var);
        this.e = wVar;
        m5 m5Var2 = this.a;
        Objects.requireNonNull(m5Var2);
        this.d = new com.github.catvod.spider.jdollar.util.e0(m5Var2, 1);
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) throws Exception {
        int i = this.b;
        m5 m5Var = this.a;
        a aVar = this.e;
        Object obj2 = this.d;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                com.github.catvod.spider.jdollar.util.k0 k0Var = (com.github.catvod.spider.jdollar.util.k0) obj2;
                LongStream longStream = (LongStream) ((com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g) ((g1) aVar).n).apply((com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g) obj);
                if (longStream != null) {
                    try {
                        if (this.c) {
                            com.github.catvod.spider.jdollar.util.x0 x0VarSpliterator = longStream.sequential().spliterator();
                            while (!m5Var.e() && x0VarSpliterator.tryAdvance((LongConsumer) k0Var)) {
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
                    return;
                }
                return;
            case 1:
                com.github.catvod.spider.jdollar.util.h0 h0Var = (com.github.catvod.spider.jdollar.util.h0) obj2;
                IntStream intStream = (IntStream) ((com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g) ((t0) aVar).n).apply((com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g) obj);
                if (intStream != null) {
                    try {
                        if (this.c) {
                            com.github.catvod.spider.jdollar.util.u0 u0VarSpliterator = intStream.sequential().spliterator();
                            while (!m5Var.e() && u0VarSpliterator.tryAdvance((IntConsumer) h0Var)) {
                            }
                        } else {
                            intStream.sequential().forEach(h0Var);
                        }
                    } catch (Throwable th3) {
                        try {
                            intStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
                if (intStream != null) {
                    intStream.close();
                    return;
                }
                return;
            default:
                com.github.catvod.spider.jdollar.util.e0 e0Var = (com.github.catvod.spider.jdollar.util.e0) obj2;
                DoubleStream doubleStream = (DoubleStream) ((com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g) ((w) aVar).n).apply((com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g) obj);
                if (doubleStream != null) {
                    try {
                        if (this.c) {
                            com.github.catvod.spider.jdollar.util.r0 r0VarSpliterator = doubleStream.sequential().spliterator();
                            while (!m5Var.e() && r0VarSpliterator.tryAdvance((DoubleConsumer) e0Var)) {
                            }
                        } else {
                            doubleStream.sequential().forEach(e0Var);
                        }
                    } catch (Throwable th5) {
                        try {
                            doubleStream.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
                if (doubleStream != null) {
                    doubleStream.close();
                    return;
                }
                return;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public final void c(long j) {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.a.c(-1L);
                break;
            case 1:
                this.a.c(-1L);
                break;
            default:
                this.a.c(-1L);
                break;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.i5, com.github.catvod.spider.jdollar.util.stream.m5
    public final boolean e() {
        switch (this.b) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.c = true;
                break;
            case 1:
                this.c = true;
                break;
            default:
                this.c = true;
                break;
        }
        return this.a.e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(t0 t0Var, m5 m5Var) {
        super(m5Var);
        this.e = t0Var;
        m5 m5Var2 = this.a;
        Objects.requireNonNull(m5Var2);
        this.d = new com.github.catvod.spider.jdollar.util.h0(m5Var2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(g1 g1Var, m5 m5Var) {
        super(m5Var);
        this.e = g1Var;
        m5 m5Var2 = this.a;
        Objects.requireNonNull(m5Var2);
        this.d = new com.github.catvod.spider.jdollar.util.k0(m5Var2, 1);
    }
}
