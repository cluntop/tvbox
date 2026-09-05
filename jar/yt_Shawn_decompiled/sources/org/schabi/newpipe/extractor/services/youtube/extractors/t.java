package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.subscription.SubscriptionItem;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements Predicate {
    public final /* synthetic */ int a;

    public /* synthetic */ t(int i) {
        this.a = i;
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.a;
        return Predicate$CC.$default$and(this, predicate);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        switch (this.a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.a;
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return YoutubeStreamInfoItemLockupExtractor.lambda$determineStreamType$3((JsonObject) obj);
            case 1:
                return YoutubeSubscriptionExtractor.lambda$fromCsvInputStream$1((String[]) obj);
            case 2:
                return Objects.nonNull((SubscriptionItem) obj);
            case 3:
                return JsonArray.class.isInstance(obj);
            default:
                return YoutubeSuggestionExtractor.lambda$suggestionList$1((String) obj);
        }
    }
}
