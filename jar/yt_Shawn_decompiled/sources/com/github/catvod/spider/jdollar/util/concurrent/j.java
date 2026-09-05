package com.github.catvod.spider.jdollar.util.concurrent;

import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j extends p implements Spliterator {
    public final /* synthetic */ int i;
    public long j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(l[] lVarArr, int i, int i2, int i3, long j, int i4) {
        super(lVarArr, i, i2, i3);
        this.i = i4;
        this.j = j;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final int characteristics() {
        switch (this.i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return 4353;
            default:
                return 4352;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final long estimateSize() {
        switch (this.i) {
        }
        return this.j;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        switch (this.i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                consumer.getClass();
                while (true) {
                    l lVarA = a();
                    if (lVarA == null) {
                        break;
                    } else {
                        consumer.accept(lVarA.b);
                    }
                }
            default:
                consumer.getClass();
                while (true) {
                    l lVarA2 = a();
                    if (lVarA2 == null) {
                        break;
                    } else {
                        consumer.accept(lVarA2.c);
                    }
                }
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Comparator getComparator() {
        switch (this.i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                throw new IllegalStateException();
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        switch (this.i) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.i(this);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        switch (this.i) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.k(this, i);
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        switch (this.i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                consumer.getClass();
                l lVarA = a();
                if (lVarA != null) {
                    consumer.accept(lVarA.b);
                    break;
                }
                break;
            default:
                consumer.getClass();
                l lVarA2 = a();
                if (lVarA2 != null) {
                    consumer.accept(lVarA2.c);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.Spliterator
    public final Spliterator trySplit() {
        switch (this.i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                int i = this.f;
                int i2 = this.g;
                int i3 = (i + i2) >>> 1;
                if (i3 <= i) {
                    return null;
                }
                l[] lVarArr = this.a;
                this.g = i3;
                long j = this.j >>> 1;
                this.j = j;
                return new j(lVarArr, this.h, i3, i2, j, 0);
            default:
                int i4 = this.f;
                int i5 = this.g;
                int i6 = (i4 + i5) >>> 1;
                if (i6 <= i4) {
                    return null;
                }
                l[] lVarArr2 = this.a;
                this.g = i6;
                long j2 = this.j >>> 1;
                this.j = j2;
                return new j(lVarArr2, this.h, i6, i5, j2, 1);
        }
    }
}
