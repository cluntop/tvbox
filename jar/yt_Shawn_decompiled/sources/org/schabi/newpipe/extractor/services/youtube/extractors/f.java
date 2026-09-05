package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Function;
import org.schabi.newpipe.extractor.Extractor;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Function {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Extractor d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ f(YoutubeChannelTabExtractor youtubeChannelTabExtractor, MultiInfoItemsCollector multiInfoItemsCollector, YoutubeChannelTabExtractor.VerifiedStatus verifiedStatus, String str, String str2) {
        this.d = youtubeChannelTabExtractor;
        this.e = multiInfoItemsCollector;
        this.f = verifiedStatus;
        this.b = str;
        this.c = str2;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.a;
        Object obj2 = this.f;
        Object obj3 = this.e;
        Extractor extractor = this.d;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return ((YoutubeChannelTabExtractor) extractor).lambda$collectItemsFrom$6((MultiInfoItemsCollector) obj3, (YoutubeChannelTabExtractor.VerifiedStatus) obj2, this.b, this.c, (JsonObject) obj);
            default:
                return ((YoutubeStreamExtractor) extractor).lambda$getStreamsFromStreamingDataKey$18((ItagItem.ItagType) obj3, this.b, this.c, (String) obj2, (JsonObject) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }

    public /* synthetic */ f(YoutubeStreamExtractor youtubeStreamExtractor, ItagItem.ItagType itagType, String str, String str2, String str3) {
        this.d = youtubeStreamExtractor;
        this.e = itagType;
        this.b = str;
        this.c = str2;
        this.f = str3;
    }
}
