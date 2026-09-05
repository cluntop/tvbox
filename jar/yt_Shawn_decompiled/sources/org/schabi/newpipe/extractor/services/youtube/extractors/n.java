package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.grack.nanojson.JsonObject;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Predicate {
    public final /* synthetic */ int a;

    public /* synthetic */ n(int i) {
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
                return Objects.nonNull((ItagInfo) obj);
            case 1:
                return YoutubeChannelExtractor.lambda$getTabsForNonAgeRestrictedChannels$5((JsonObject) obj);
            case 2:
                return String.class.isInstance(obj);
            case 3:
                return YoutubeChannelTabExtractor.lambda$getTabData$2((JsonObject) obj);
            case 4:
                return YoutubeChannelTabExtractor.lambda$getTabData$5((JsonObject) obj);
            case 5:
                return YoutubeChannelTabExtractor.lambda$getPage$0((JsonObject) obj);
            case 6:
                return Objects.nonNull((JsonObject) obj);
            case 7:
                return YoutubeCommentsExtractor.lambda$findInitialCommentsToken$0((JsonObject) obj);
            case 8:
                return YoutubeMixOrPlaylistLockupInfoItemExtractor.lambda$getStreamCount$0((JsonObject) obj);
            case 9:
                return YoutubeMixOrPlaylistLockupInfoItemExtractor.lambda$getStreamCount$2((JsonObject) obj);
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return YoutubeMusicSearchExtractor.lambda$isCorrectedSearch$3((JsonObject) obj);
            case 11:
                return YoutubeMusicSearchExtractor.lambda$getItemSectionRendererContents$1((JsonObject) obj);
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return YoutubePlaylistExtractor.lambda$getInitialPage$6((JsonObject) obj);
            case 13:
                return YoutubePlaylistExtractor.lambda$getNextPageFrom$7((JsonObject) obj);
            case 14:
                return YoutubePlaylistExtractor.lambda$getUploaderInfo$0((JsonObject) obj);
            case 15:
                return YoutubePlaylistExtractor.lambda$getPlaylistInfo$3((JsonObject) obj);
            case 16:
                return YoutubeStreamExtractor.lambda$parseLikeCountFromLikeButtonViewModel$10((JsonObject) obj);
            case 17:
                return YoutubeStreamExtractor.lambda$parseLikeCountFromLikeButtonRenderer$8((JsonObject) obj);
            case 18:
                return Objects.nonNull((InfoItemExtractor) obj);
            case 19:
                return YoutubeStreamExtractor.lambda$getPrivacy$19((JsonObject) obj);
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                return YoutubeStreamExtractor.lambda$getStreamSegments$20((JsonObject) obj);
            case 21:
                return YoutubeStreamExtractor.lambda$getAgeLimit$6((String) obj);
            case 22:
                return "BADGE_STYLE_TYPE_MEMBERS_ONLY".equals((String) obj);
            case 23:
                return YoutubeStreamInfoItemExtractor.lambda$getDuration$0((JsonObject) obj);
            case 24:
                return YoutubeStreamInfoItemExtractor.lambda$getDuration$2((String) obj);
            case 25:
                return YoutubeStreamInfoItemExtractor.lambda$isShortFormContent$3((JsonObject) obj);
            case 26:
                return YoutubeStreamInfoItemExtractor.lambda$isShortFormContent$5((JsonObject) obj);
            case 27:
                return YoutubeStreamInfoItemLockupExtractor.lambda$determineStreamType$6((JsonObject) obj);
            case 28:
                return "BADGE_MEMBERS_ONLY".equals((String) obj);
            default:
                return "LIVE".equals((String) obj);
        }
    }
}
