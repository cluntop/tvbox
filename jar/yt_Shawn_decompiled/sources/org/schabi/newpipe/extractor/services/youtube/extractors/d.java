package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(String str, int i) {
        this.a = i;
        this.b = str;
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
                return YoutubeChannelTabExtractor.lambda$getTabData$4(this.b, (JsonObject) obj);
            case 1:
                return YoutubeCommentsExtractor.lambda$getMutationPayloadFromEntityKey$2(this.b, (JsonObject) obj);
            default:
                return YoutubeStreamExtractor.lambda$getVideoInfoRenderer$12(this.b, (JsonObject) obj);
        }
    }
}
