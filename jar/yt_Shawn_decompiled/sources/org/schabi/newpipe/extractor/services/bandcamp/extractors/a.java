package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.github.catvod.spider.merge.o1.n;
import com.grack.nanojson.JsonObject;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
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
                return Objects.nonNull((n) obj);
            case 1:
                return BandcampChannelExtractor.lambda$getBanners$2((String) obj);
            case 2:
                return BandcampExtractorHelper.lambda$getImagesFromSearchResult$2((String) obj);
            case 3:
                return PeertubeParsingHelper.lambda$getImagesFromAvatarOrBannerArray$0((JsonObject) obj);
            case 4:
                return Parser.lambda$compatParseMap$1((String[]) obj);
            case 5:
                return Objects.nonNull((String) obj);
            default:
                return Utils.lambda$nonEmptyAndNullJoin$1((String) obj);
        }
    }
}
