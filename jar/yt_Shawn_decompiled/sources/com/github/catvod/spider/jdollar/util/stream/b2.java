package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.IntConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b2 implements IntConsumer {
    public final /* synthetic */ int a;

    public /* synthetic */ b2(int i) {
        this.a = i;
    }

    private final void accept$j$$util$stream$Node$OfInt$0(int i) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfInt$0(int i) {
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        int i2 = this.a;
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.a) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }
}
