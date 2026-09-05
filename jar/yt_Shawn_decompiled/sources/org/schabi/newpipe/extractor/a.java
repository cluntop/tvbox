package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.grack.nanojson.JsonObject;
import java.util.Map;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCLiveStreamExtractor;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeTrendingLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(String str, int i) {
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
        int i = this.a;
        String str = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return MediaFormat.lambda$getFromMimeType$1(str, (MediaFormat) obj);
            case 1:
                return MediaFormat.lambda$getAllFromMimeType$2(str, (MediaFormat) obj);
            case 2:
                return MediaFormat.lambda$getFromSuffix$4(str, (MediaFormat) obj);
            case 3:
                return NewPipe.lambda$getService$2(str, (StreamingService) obj);
            case 4:
                return MediaCCCLiveStreamExtractor.lambda$getManifestOfDeliveryMethodWanted$1(str, (JsonObject) obj);
            case 5:
                return MediaCCCLiveStreamExtractor.lambda$getStreams$5(str, (JsonObject) obj);
            case 6:
                return PeertubeTrendingLinkHandlerFactory.lambda$getId$0(str, (Map.Entry) obj);
            case 7:
                return YoutubeParsingHelper.lambda$getClientVersionFromServiceTrackingParam$1(str, (JsonObject) obj);
            default:
                return YoutubeParsingHelper.lambda$getClientVersionFromServiceTrackingParam$3(str, (JsonObject) obj);
        }
    }
}
