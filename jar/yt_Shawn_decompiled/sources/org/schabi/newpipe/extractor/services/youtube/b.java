package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int i) {
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
                return YoutubeChannelHelper.lambda$getChannelAgeGateRenderer$11((JsonObject) obj);
            case 1:
                return YoutubeChannelHelper.lambda$getChannelId$6((JsonObject) obj);
            case 2:
                return YoutubeChannelHelper.lambda$getChannelHeader$1((JsonObject) obj);
            case 3:
                return YoutubeMetaInfoHelper.lambda$getEmergencyOneboxRenderer$0(obj);
            case 4:
                return YoutubeParsingHelper.lambda$hasArtistOrVerifiedIconBadgeAttachment$8((JsonObject) obj);
            case 5:
                return YoutubeParsingHelper.lambda$hasArtistOrVerifiedIconBadgeAttachment$9((JsonObject) obj);
            case 6:
                return YoutubeParsingHelper.lambda$getImagesFromThumbnailsArray$6((JsonObject) obj);
            case 7:
                return YoutubeParsingHelper.lambda$getClientVersionFromServiceTrackingParam$5((String) obj);
            default:
                return YoutubeParsingHelper.lambda$extractAudioTrackType$10((Xtags.KeyValuePair) obj);
        }
    }
}
