package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class h0 implements IntConsumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ h0(Consumer consumer, int i) {
        this.a = i;
        this.b = consumer;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        int i2 = this.a;
        Consumer consumer = this.b;
        switch (i2) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                consumer.accept(Integer.valueOf(i));
                break;
            default:
                ((m5) consumer).accept(i);
                break;
        }
    }

    @Override // java.util.function.IntConsumer
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.a) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.b(this, intConsumer);
    }
}
