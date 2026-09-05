package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class e0 implements DoubleConsumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ e0(Consumer consumer, int i) {
        this.a = i;
        this.b = consumer;
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        int i = this.a;
        Consumer consumer = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                consumer.accept(Double.valueOf(d));
                break;
            default:
                ((m5) consumer).accept(d);
                break;
        }
    }

    @Override // java.util.function.DoubleConsumer
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.a) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.a(this, doubleConsumer);
    }
}
