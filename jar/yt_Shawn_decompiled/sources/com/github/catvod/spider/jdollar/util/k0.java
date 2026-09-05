package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.util.stream.m5;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements LongConsumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ k0(Consumer consumer, int i) {
        this.a = i;
        this.b = consumer;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        int i = this.a;
        Consumer consumer = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                consumer.accept(Long.valueOf(j));
                break;
            default:
                ((m5) consumer).accept(j);
                break;
        }
    }

    @Override // java.util.function.LongConsumer
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.a) {
        }
        return com.github.catvod.spider.jdollar.time.chrono.m.c(this, longConsumer);
    }
}
