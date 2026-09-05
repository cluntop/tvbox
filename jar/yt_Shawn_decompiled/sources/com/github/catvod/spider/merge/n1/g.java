package com.github.catvod.spider.merge.n1;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.o1.s;
import com.github.catvod.spider.merge.o1.z;
import com.grack.nanojson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampChannelExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampCommentsExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampExtractorHelper;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampPlaylistExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampRelatedPlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampSearchExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampSuggestionExtractor;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeStreamExtractor;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.timeago.PatternsHolder;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ g(int i) {
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
                h hVar = (h) obj;
                String strL = i.l(hVar.a);
                hVar.a = null;
                return strL;
            case 1:
                s sVar = (s) obj;
                return sVar instanceof z ? ((z) sVar).D() : sVar.o("br") ? "\n" : VideoStream.RESOLUTION_UNKNOWN;
            case 2:
                return DesugarCollections.unmodifiableList((List) obj);
            case 3:
                return new HashMap();
            case 4:
                return ((n) obj).P();
            case 5:
                return ((n) obj).U();
            case 6:
                return ((s) obj).u();
            case 7:
                return new WeakHashMap();
            case 8:
                return ((MediaFormat) obj).getSuffix();
            case 9:
                return MediaFormat.lambda$getFormatById$3((MediaFormat) obj);
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return ((MediaFormat) obj).getMimeType();
            case 11:
                return ((MediaFormat) obj).getName();
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return Localization.fromLocale((Locale) obj);
            case 13:
                return (ChronoUnit) ((Map.Entry) obj).getKey();
            case 14:
                return BandcampChannelExtractor.lambda$getBanners$0((n) obj);
            case 15:
                return BandcampChannelExtractor.lambda$getBanners$1((n) obj);
            case 16:
                return BandcampChannelExtractor.lambda$getBanners$3((String) obj);
            case 17:
                return BandcampCommentsExtractor.lambda$getNextPageToken$0((JsonObject) obj);
            case 18:
                return BandcampExtractorHelper.lambda$getImagesFromSearchResult$0((n) obj);
            case 19:
                return BandcampExtractorHelper.lambda$getImagesFromSearchResult$1((n) obj);
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                return BandcampPlaylistExtractor.lambda$getUploaderAvatars$0((n) obj);
            case 21:
                return BandcampSearchExtractor.lambda$getPage$0((n) obj);
            case 22:
                return BandcampSearchExtractor.lambda$getPage$1((n) obj);
            case 23:
                return BandcampStreamExtractor.lambda$getUploaderAvatars$0((n) obj);
            case 24:
                return BandcampStreamExtractor.lambda$getCategory$1((n) obj);
            case 25:
                return new BandcampRelatedPlaylistInfoItemExtractor((n) obj);
            case 26:
                return BandcampSuggestionExtractor.lambda$suggestionList$0((JsonObject) obj);
            case 27:
                return PeertubeStreamExtractor.lambda$extractLiveVideoStreams$1((JsonObject) obj);
            case 28:
                return (String) ((Map.Entry) obj).getKey();
            default:
                return PatternsHolder.lambda$putSpecialCase$0((ChronoUnit) obj);
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
