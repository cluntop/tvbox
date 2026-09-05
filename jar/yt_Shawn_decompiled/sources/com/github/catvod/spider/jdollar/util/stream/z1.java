package com.github.catvod.spider.jdollar.util.stream;

import java.util.function.DoubleConsumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class z1 implements DoubleConsumer {
    public final /* synthetic */ int a;

    public /* synthetic */ z1(int i) {
        this.a = i;
    }

    private final void accept$j$$util$stream$Node$OfDouble$0(double d) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfDouble$0(double d) {
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        int i = this.a;
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.a) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }
}
