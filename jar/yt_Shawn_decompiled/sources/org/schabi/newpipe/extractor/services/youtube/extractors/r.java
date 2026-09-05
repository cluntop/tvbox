package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ r(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return ((YoutubeStreamExtractor) obj2).lambda$getAudioStreamBuilderHelper$16((ItagInfo) obj);
            default:
                return ((YoutubeSubscriptionExtractor) obj2).lambda$fromCsvInputStream$2((String[]) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
