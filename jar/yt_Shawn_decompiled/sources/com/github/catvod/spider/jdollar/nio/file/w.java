package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.Map;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ w(Consumer consumer, int i) {
        this.a = i;
        this.b = consumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                this.b.accept(com.github.catvod.spider.jdollar.com.android.tools.r8.a.o(obj));
                break;
            case 1:
                this.b.accept(com.github.catvod.spider.jdollar.com.android.tools.r8.a.o(obj));
                break;
            default:
                this.b.accept(new com.github.catvod.spider.jdollar.util.r((Map.Entry) obj));
                break;
        }
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
