package com.github.catvod.spider.merge.o1;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonObject;
import java.io.Serializable;
import java.util.Map;
import java.util.function.Function;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCLiveStreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Serializable b;

    public /* synthetic */ k(Serializable serializable, int i) {
        this.a = i;
        this.b = serializable;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.a;
        Serializable serializable = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return ((Class) serializable).cast((s) obj);
            case 1:
                return ((Class) serializable).cast(obj);
            default:
                return MediaCCCLiveStreamExtractor.lambda$getStreams$7((JsonObject) serializable, (Map.Entry) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
