package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c9 extends g9 implements DoubleConsumer, com.github.catvod.spider.jdollar.util.r0 {
    public double e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c9(Spliterator spliterator, int i) {
        super(spliterator);
        this.f = i;
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.d = (this.d + 1) & 63;
        this.e = d;
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g9
    public final Spliterator b(Spliterator spliterator) {
        switch (this.f) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new c9((com.github.catvod.spider.jdollar.util.r0) spliterator, this, 0);
            default:
                return new c9((com.github.catvod.spider.jdollar.util.r0) spliterator, this, 1);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        while (tryAdvance(doubleConsumer)) {
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.r0
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        int i = this.f;
        Spliterator spliterator = this.a;
        DoublePredicate doublePredicate = null;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!this.c) {
                    return ((com.github.catvod.spider.jdollar.util.r0) spliterator).tryAdvance(doubleConsumer);
                }
                this.c = false;
                boolean zTryAdvance = ((com.github.catvod.spider.jdollar.util.r0) spliterator).tryAdvance((DoubleConsumer) this);
                if (zTryAdvance && a()) {
                    doublePredicate.test(this.e);
                    throw null;
                }
                if (!zTryAdvance) {
                    return zTryAdvance;
                }
                doubleConsumer.accept(this.e);
                return zTryAdvance;
            default:
                if (this.c && a() && ((com.github.catvod.spider.jdollar.util.r0) spliterator).tryAdvance((DoubleConsumer) this)) {
                    doublePredicate.test(this.e);
                    throw null;
                }
                this.c = false;
                return false;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g9, com.github.catvod.spider.jdollar.util.Spliterator
    public com.github.catvod.spider.jdollar.util.r0 trySplit() {
        switch (this.f) {
            case 1:
                if (this.b.get()) {
                    return null;
                }
                return (com.github.catvod.spider.jdollar.util.r0) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c9(Spliterator spliterator, g9 g9Var, int i) {
        super(spliterator, g9Var);
        this.f = i;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g9, com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.github.catvod.spider.jdollar.time.chrono.m.e(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g9, com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        switch (this.f) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g9, com.github.catvod.spider.jdollar.util.Spliterator
    public /* bridge */ /* synthetic */ com.github.catvod.spider.jdollar.util.a1 trySplit() {
        switch (this.f) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return com.github.catvod.spider.jdollar.time.chrono.m.n(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.a1
    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f) {
            case 1:
                tryAdvance((DoubleConsumer) obj);
                return false;
            default:
                return tryAdvance((DoubleConsumer) obj);
        }
    }
}
