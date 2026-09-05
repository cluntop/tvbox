package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class t5 implements IntFunction, Consumer {
    public final /* synthetic */ int a;

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$0(Object obj) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$1(Object obj) {
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
        int i = this.a;
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return new Double[i];
            case 1:
            case 2:
            default:
                return new Double[i];
            case 3:
                return new Integer[i];
            case 4:
                return new Integer[i];
            case 5:
                return new Long[i];
            case 6:
                return new Long[i];
            case 7:
                return new Double[i];
        }
    }
}
