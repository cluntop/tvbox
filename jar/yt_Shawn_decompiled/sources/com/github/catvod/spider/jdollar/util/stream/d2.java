package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.LongConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class d2 implements LongConsumer {
    public final /* synthetic */ int a;

    public /* synthetic */ d2(int i) {
        this.a = i;
    }

    private final void accept$j$$util$stream$Node$OfLong$0(long j) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfLong$0(long j) {
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        int i = this.a;
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.a) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }
}
