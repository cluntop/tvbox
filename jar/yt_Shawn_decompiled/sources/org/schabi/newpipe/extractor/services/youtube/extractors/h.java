package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.function.Function;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ h(int i) {
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
                return YoutubeCommentsEUVMInfoItemExtractor.lambda$getReplies$0((JsonObject) obj);
            case 1:
                return YoutubeCommentsEUVMInfoItemExtractor.lambda$getReplies$1((JsonObject) obj);
            case 2:
                return YoutubeStreamInfoItemLockupExtractor.MultiChannelImageViewModel.lambda$forUploaderUrlExtraction$0((JsonObject) obj);
            case 3:
                return YoutubeChannelExtractor.lambda$getAvatars$1((YoutubeChannelHelper.ChannelHeader) obj);
            case 4:
                return YoutubeChannelExtractor.lambda$getTabsForNonAgeRestrictedChannels$6((JsonObject) obj);
            case 5:
                return YoutubeChannelExtractor.lambda$getBanners$3((YoutubeChannelHelper.ChannelHeader) obj);
            case 6:
                return YoutubeParsingHelper.getImagesFromThumbnailsArray((JsonArray) obj);
            case 7:
                return (String) String.class.cast(obj);
            case 8:
                return YoutubeChannelTabExtractor.lambda$getTabData$3((JsonObject) obj);
            case 9:
                return YoutubeChannelTabExtractor.lambda$getPage$1((JsonObject) obj);
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return YoutubeCommentsExtractor.lambda$findInitialCommentsToken$1((JsonObject) obj);
            case 11:
                return YoutubeMusicSearchExtractor.lambda$collectMusicStreamsFrom$4((JsonObject) obj);
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return YoutubeMusicSearchExtractor.lambda$getItemSectionRendererContents$0((JsonObject) obj);
            case 13:
                return YoutubeMusicSearchExtractor.lambda$getItemSectionRendererContents$2((JsonObject) obj);
            case 14:
                return YoutubePlaylistExtractor.lambda$getUploaderInfo$1((JsonObject) obj);
            case 15:
                return YoutubePlaylistExtractor.lambda$getPlaylistInfo$4((JsonObject) obj);
            case 16:
                return YoutubeStreamExtractor.lambda$parseLikeCountFromLikeButtonViewModel$9((JsonObject) obj);
            case 17:
                return YoutubeStreamExtractor.lambda$parseLikeCountFromLikeButtonRenderer$7((JsonObject) obj);
            case 18:
                return YoutubeStreamExtractor.lambda$getUploadDate$1((LocalDate) obj);
            case 19:
                return YoutubeStreamExtractor.lambda$getStreamSegments$21((JsonObject) obj);
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                return YoutubeStreamExtractor.lambda$getStreamSegments$22((JsonObject) obj);
            case 21:
                return YoutubeStreamExtractor.lambda$getAgeLimit$3((JsonObject) obj);
            case 22:
                return YoutubeStreamExtractor.lambda$getAgeLimit$4((JsonObject) obj);
            case 23:
                return YoutubeStreamExtractor.lambda$getAgeLimit$5((JsonObject) obj);
            case 24:
                return YoutubeStreamInfoItemExtractor.lambda$isMembersOnly$6((JsonObject) obj);
            case 25:
                return YoutubeStreamInfoItemExtractor.lambda$getDuration$1((JsonObject) obj);
            case 26:
                return YoutubeStreamInfoItemExtractor.lambda$isShortFormContent$4((JsonObject) obj);
            case 27:
                return YoutubeStreamInfoItemLockupExtractor.lambda$isChannelsMembersOnlyOrFirst$9((JsonObject) obj);
            case 28:
                return YoutubeStreamInfoItemLockupExtractor.lambda$determineStreamType$4((JsonObject) obj);
            default:
                return YoutubeStreamInfoItemLockupExtractor.lambda$determineStreamType$5((JsonObject) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
