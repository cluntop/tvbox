package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ s(int i) {
        this.a = i;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return YoutubeStreamInfoItemLockupExtractor.lambda$isChannelsMembersOnlyOrFirst$10((JsonObject) obj);
            case 1:
                return YoutubeStreamInfoItemLockupExtractor.lambda$getDuration$7((JsonObject) obj);
            case 2:
                return YoutubeStreamInfoItemLockupExtractor.lambda$getDuration$8((JsonObject) obj);
            case 3:
                return YoutubeStreamInfoItemLockupExtractor.lambda$determineStreamType$2((JsonObject) obj);
            case 4:
                return YoutubeStreamInfoItemLockupExtractor.lambda$determineStreamType$0((JsonObject) obj);
            case 5:
                return YoutubeStreamInfoItemLockupExtractor.lambda$determineStreamType$1((JsonObject) obj);
            case 6:
                return YoutubeSubscriptionExtractor.lambda$fromCsvInputStream$0((String) obj);
            case 7:
                return (JsonArray) JsonArray.class.cast(obj);
            default:
                return YoutubeSuggestionExtractor.lambda$suggestionList$0((JsonArray) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
