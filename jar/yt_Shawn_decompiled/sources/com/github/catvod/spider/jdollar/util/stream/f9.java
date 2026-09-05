package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class f9 extends g9 implements Consumer {
    public final Predicate e;
    public Object f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f9(Spliterator spliterator, f9 f9Var, int i) {
        super(spliterator, f9Var);
        this.g = i;
        this.e = f9Var.e;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.d = (this.d + 1) & 63;
        this.f = obj;
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g9
    public final Spliterator b(Spliterator spliterator) {
        switch (this.g) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new f9(spliterator, this, 0);
            default:
                return new f9(spliterator, this, 1);
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        boolean zTryAdvance;
        boolean zTest;
        int i = this.g;
        Predicate predicate = this.e;
        Spliterator spliterator = this.a;
        boolean z = false;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                if (!this.c) {
                    return spliterator.tryAdvance(consumer);
                }
                this.c = false;
                while (true) {
                    zTryAdvance = spliterator.tryAdvance(this);
                    if (zTryAdvance && a() && predicate.test(this.f)) {
                        z = true;
                    }
                }
                if (!zTryAdvance) {
                    return zTryAdvance;
                }
                if (z) {
                    this.b.set(true);
                }
                consumer.accept(this.f);
                return zTryAdvance;
            default:
                if (this.c && a() && spliterator.tryAdvance(this)) {
                    zTest = predicate.test(this.f);
                    if (zTest) {
                        consumer.accept(this.f);
                        return true;
                    }
                } else {
                    zTest = true;
                }
                this.c = false;
                if (!zTest) {
                    this.b.set(true);
                }
                return false;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g9, com.github.catvod.spider.jdollar.util.Spliterator
    public Spliterator trySplit() {
        switch (this.g) {
            case 1:
                if (!this.b.get()) {
                    break;
                }
                break;
        }
        return super.trySplit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f9(Spliterator spliterator, Predicate predicate, int i) {
        super(spliterator);
        this.g = i;
        this.e = predicate;
    }
}
