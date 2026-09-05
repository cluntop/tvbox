package org.schabi.newpipe.extractor.services.youtube;

import java.util.EnumSet;
import java.util.List;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.comments.CommentsExtractor;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.feed.FeedExtractor;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.kiosk.KioskList;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeCommentsExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeFeedExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMixPlaylistExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicSearchExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubePlaylistExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeSearchExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeSubscriptionExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeSuggestionExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeLiveExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeTrendingExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeTrendingGamingVideosExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeTrendingMoviesAndShowsTrailersExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeTrendingMusicExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeTrendingPodcastsEpisodesExtractor;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeCommentsLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeLiveLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubePlaylistLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeTrendingGamingVideosLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeTrendingLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeTrendingMoviesAndShowsTrailersLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeTrendingMusicLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeTrendingPodcastsEpisodesLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.subscription.SubscriptionExtractor;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeService extends StreamingService {
    private static final List<Localization> SUPPORTED_LANGUAGES = Localization.listFrom("en-GB");
    private static final List<ContentCountry> SUPPORTED_COUNTRIES = ContentCountry.listFrom("DZ", "AR", "AU", "AT", "AZ", "BH", "BD", "BY", "BE", "BO", "BA", "BR", "BG", "KH", "CA", "CL", "CO", "CR", "HR", "CY", "CZ", "DK", "DO", "EC", "EG", "SV", "EE", "FI", "FR", "GE", "DE", "GH", "GR", "GT", "HN", "HK", "HU", "IS", "IN", "ID", "IQ", "IE", "IL", "IT", "JM", "JP", "JO", "KZ", "KE", "KW", "LA", "LV", "LB", "LY", "LI", "LT", "LU", "MY", "MT", "MX", "ME", "MA", "NP", "NL", "NZ", "NI", "NG", "MK", "NO", "OM", "PK", "PA", "PG", "PY", "PE", "PH", "PL", "PT", "PR", "QA", "RO", "RU", "SA", "SN", "RS", "SG", "SK", "SI", "ZA", "KR", "ES", "LK", "SE", "CH", "TW", "TZ", "TH", "TN", "TR", "UG", "UA", "AE", "GB", "US", "UY", "VE", "VN", "YE", "ZW");

    public YoutubeService(int i) {
        super(i, "YouTube", EnumSet.of(StreamingService.ServiceInfo.MediaCapability.AUDIO, StreamingService.ServiceInfo.MediaCapability.VIDEO, StreamingService.ServiceInfo.MediaCapability.LIVE, StreamingService.ServiceInfo.MediaCapability.COMMENTS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$0(ListLinkHandlerFactory listLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new YoutubeLiveExtractor(this, listLinkHandlerFactory.fromUrl(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$1(ListLinkHandlerFactory listLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new YoutubeTrendingPodcastsEpisodesExtractor(this, listLinkHandlerFactory.fromUrl(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$2(ListLinkHandlerFactory listLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new YoutubeTrendingGamingVideosExtractor(this, listLinkHandlerFactory.fromUrl(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$3(ListLinkHandlerFactory listLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new YoutubeTrendingMoviesAndShowsTrailersExtractor(this, listLinkHandlerFactory.fromUrl(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$4(ListLinkHandlerFactory listLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new YoutubeTrendingMusicExtractor(this, listLinkHandlerFactory.fromUrl(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$5(ListLinkHandlerFactory listLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new YoutubeTrendingExtractor(this, listLinkHandlerFactory.fromUrl(str), str2);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public String getBaseUrl() {
        return "https://youtube.com";
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ChannelExtractor getChannelExtractor(ListLinkHandler listLinkHandler) {
        return new YoutubeChannelExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getChannelLHFactory() {
        return YoutubeChannelLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ChannelTabExtractor getChannelTabExtractor(ListLinkHandler listLinkHandler) {
        return listLinkHandler instanceof ReadyChannelTabListLinkHandler ? ((ReadyChannelTabListLinkHandler) listLinkHandler).getChannelTabExtractor(this) : new YoutubeChannelTabExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getChannelTabLHFactory() {
        return YoutubeChannelTabLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public CommentsExtractor getCommentsExtractor(ListLinkHandler listLinkHandler) {
        return new YoutubeCommentsExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getCommentsLHFactory() {
        return YoutubeCommentsLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public FeedExtractor getFeedExtractor(String str) {
        return new YoutubeFeedExtractor(this, getChannelLHFactory().fromUrl(str));
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public KioskList getKioskList() throws ExtractionException {
        KioskList kioskList = new KioskList(this);
        final YoutubeTrendingLinkHandlerFactory youtubeTrendingLinkHandlerFactory = YoutubeTrendingLinkHandlerFactory.INSTANCE;
        final YoutubeLiveLinkHandlerFactory youtubeLiveLinkHandlerFactory = YoutubeLiveLinkHandlerFactory.INSTANCE;
        final YoutubeTrendingPodcastsEpisodesLinkHandlerFactory youtubeTrendingPodcastsEpisodesLinkHandlerFactory = YoutubeTrendingPodcastsEpisodesLinkHandlerFactory.INSTANCE;
        final YoutubeTrendingGamingVideosLinkHandlerFactory youtubeTrendingGamingVideosLinkHandlerFactory = YoutubeTrendingGamingVideosLinkHandlerFactory.INSTANCE;
        final YoutubeTrendingMoviesAndShowsTrailersLinkHandlerFactory youtubeTrendingMoviesAndShowsTrailersLinkHandlerFactory = YoutubeTrendingMoviesAndShowsTrailersLinkHandlerFactory.INSTANCE;
        final YoutubeTrendingMusicLinkHandlerFactory youtubeTrendingMusicLinkHandlerFactory = YoutubeTrendingMusicLinkHandlerFactory.INSTANCE;
        try {
            final int i = 0;
            kioskList.addKioskEntry(new KioskList.KioskExtractorFactory(this) { // from class: org.schabi.newpipe.extractor.services.youtube.f
                public final /* synthetic */ YoutubeService b;

                {
                    this.b = this;
                }

                @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
                public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
                    int i2 = i;
                    ListLinkHandlerFactory listLinkHandlerFactory = youtubeLiveLinkHandlerFactory;
                    YoutubeService youtubeService = this.b;
                    switch (i2) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            return youtubeService.lambda$getKioskList$0(listLinkHandlerFactory, streamingService, str, str2);
                        case 1:
                            return youtubeService.lambda$getKioskList$1(listLinkHandlerFactory, streamingService, str, str2);
                        case 2:
                            return youtubeService.lambda$getKioskList$2(listLinkHandlerFactory, streamingService, str, str2);
                        case 3:
                            return youtubeService.lambda$getKioskList$3(listLinkHandlerFactory, streamingService, str, str2);
                        case 4:
                            return youtubeService.lambda$getKioskList$4(listLinkHandlerFactory, streamingService, str, str2);
                        default:
                            return youtubeService.lambda$getKioskList$5(listLinkHandlerFactory, streamingService, str, str2);
                    }
                }
            }, youtubeLiveLinkHandlerFactory, "live");
            final int i2 = 1;
            kioskList.addKioskEntry(new KioskList.KioskExtractorFactory(this) { // from class: org.schabi.newpipe.extractor.services.youtube.f
                public final /* synthetic */ YoutubeService b;

                {
                    this.b = this;
                }

                @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
                public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
                    int i22 = i2;
                    ListLinkHandlerFactory listLinkHandlerFactory = youtubeTrendingPodcastsEpisodesLinkHandlerFactory;
                    YoutubeService youtubeService = this.b;
                    switch (i22) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            return youtubeService.lambda$getKioskList$0(listLinkHandlerFactory, streamingService, str, str2);
                        case 1:
                            return youtubeService.lambda$getKioskList$1(listLinkHandlerFactory, streamingService, str, str2);
                        case 2:
                            return youtubeService.lambda$getKioskList$2(listLinkHandlerFactory, streamingService, str, str2);
                        case 3:
                            return youtubeService.lambda$getKioskList$3(listLinkHandlerFactory, streamingService, str, str2);
                        case 4:
                            return youtubeService.lambda$getKioskList$4(listLinkHandlerFactory, streamingService, str, str2);
                        default:
                            return youtubeService.lambda$getKioskList$5(listLinkHandlerFactory, streamingService, str, str2);
                    }
                }
            }, youtubeTrendingPodcastsEpisodesLinkHandlerFactory, YoutubeTrendingPodcastsEpisodesLinkHandlerFactory.KIOSK_ID);
            final int i3 = 2;
            kioskList.addKioskEntry(new KioskList.KioskExtractorFactory(this) { // from class: org.schabi.newpipe.extractor.services.youtube.f
                public final /* synthetic */ YoutubeService b;

                {
                    this.b = this;
                }

                @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
                public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
                    int i22 = i3;
                    ListLinkHandlerFactory listLinkHandlerFactory = youtubeTrendingGamingVideosLinkHandlerFactory;
                    YoutubeService youtubeService = this.b;
                    switch (i22) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            return youtubeService.lambda$getKioskList$0(listLinkHandlerFactory, streamingService, str, str2);
                        case 1:
                            return youtubeService.lambda$getKioskList$1(listLinkHandlerFactory, streamingService, str, str2);
                        case 2:
                            return youtubeService.lambda$getKioskList$2(listLinkHandlerFactory, streamingService, str, str2);
                        case 3:
                            return youtubeService.lambda$getKioskList$3(listLinkHandlerFactory, streamingService, str, str2);
                        case 4:
                            return youtubeService.lambda$getKioskList$4(listLinkHandlerFactory, streamingService, str, str2);
                        default:
                            return youtubeService.lambda$getKioskList$5(listLinkHandlerFactory, streamingService, str, str2);
                    }
                }
            }, youtubeTrendingGamingVideosLinkHandlerFactory, YoutubeTrendingGamingVideosLinkHandlerFactory.KIOSK_ID);
            final int i4 = 3;
            kioskList.addKioskEntry(new KioskList.KioskExtractorFactory(this) { // from class: org.schabi.newpipe.extractor.services.youtube.f
                public final /* synthetic */ YoutubeService b;

                {
                    this.b = this;
                }

                @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
                public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
                    int i22 = i4;
                    ListLinkHandlerFactory listLinkHandlerFactory = youtubeTrendingMoviesAndShowsTrailersLinkHandlerFactory;
                    YoutubeService youtubeService = this.b;
                    switch (i22) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            return youtubeService.lambda$getKioskList$0(listLinkHandlerFactory, streamingService, str, str2);
                        case 1:
                            return youtubeService.lambda$getKioskList$1(listLinkHandlerFactory, streamingService, str, str2);
                        case 2:
                            return youtubeService.lambda$getKioskList$2(listLinkHandlerFactory, streamingService, str, str2);
                        case 3:
                            return youtubeService.lambda$getKioskList$3(listLinkHandlerFactory, streamingService, str, str2);
                        case 4:
                            return youtubeService.lambda$getKioskList$4(listLinkHandlerFactory, streamingService, str, str2);
                        default:
                            return youtubeService.lambda$getKioskList$5(listLinkHandlerFactory, streamingService, str, str2);
                    }
                }
            }, youtubeTrendingMoviesAndShowsTrailersLinkHandlerFactory, YoutubeTrendingMoviesAndShowsTrailersLinkHandlerFactory.KIOSK_ID);
            final int i5 = 4;
            kioskList.addKioskEntry(new KioskList.KioskExtractorFactory(this) { // from class: org.schabi.newpipe.extractor.services.youtube.f
                public final /* synthetic */ YoutubeService b;

                {
                    this.b = this;
                }

                @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
                public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
                    int i22 = i5;
                    ListLinkHandlerFactory listLinkHandlerFactory = youtubeTrendingMusicLinkHandlerFactory;
                    YoutubeService youtubeService = this.b;
                    switch (i22) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            return youtubeService.lambda$getKioskList$0(listLinkHandlerFactory, streamingService, str, str2);
                        case 1:
                            return youtubeService.lambda$getKioskList$1(listLinkHandlerFactory, streamingService, str, str2);
                        case 2:
                            return youtubeService.lambda$getKioskList$2(listLinkHandlerFactory, streamingService, str, str2);
                        case 3:
                            return youtubeService.lambda$getKioskList$3(listLinkHandlerFactory, streamingService, str, str2);
                        case 4:
                            return youtubeService.lambda$getKioskList$4(listLinkHandlerFactory, streamingService, str, str2);
                        default:
                            return youtubeService.lambda$getKioskList$5(listLinkHandlerFactory, streamingService, str, str2);
                    }
                }
            }, youtubeTrendingMusicLinkHandlerFactory, YoutubeTrendingMusicLinkHandlerFactory.KIOSK_ID);
            final int i6 = 5;
            kioskList.addKioskEntry(new KioskList.KioskExtractorFactory(this) { // from class: org.schabi.newpipe.extractor.services.youtube.f
                public final /* synthetic */ YoutubeService b;

                {
                    this.b = this;
                }

                @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
                public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
                    int i22 = i6;
                    ListLinkHandlerFactory listLinkHandlerFactory = youtubeTrendingLinkHandlerFactory;
                    YoutubeService youtubeService = this.b;
                    switch (i22) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            return youtubeService.lambda$getKioskList$0(listLinkHandlerFactory, streamingService, str, str2);
                        case 1:
                            return youtubeService.lambda$getKioskList$1(listLinkHandlerFactory, streamingService, str, str2);
                        case 2:
                            return youtubeService.lambda$getKioskList$2(listLinkHandlerFactory, streamingService, str, str2);
                        case 3:
                            return youtubeService.lambda$getKioskList$3(listLinkHandlerFactory, streamingService, str, str2);
                        case 4:
                            return youtubeService.lambda$getKioskList$4(listLinkHandlerFactory, streamingService, str, str2);
                        default:
                            return youtubeService.lambda$getKioskList$5(listLinkHandlerFactory, streamingService, str, str2);
                    }
                }
            }, youtubeTrendingLinkHandlerFactory, "Trending");
            kioskList.setDefaultKiosk("live");
            return kioskList;
        } catch (Exception e) {
            throw new ExtractionException(e);
        }
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public PlaylistExtractor getPlaylistExtractor(ListLinkHandler listLinkHandler) {
        return YoutubeParsingHelper.isYoutubeMixId(listLinkHandler.getId()) ? new YoutubeMixPlaylistExtractor(this, listLinkHandler) : new YoutubePlaylistExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getPlaylistLHFactory() {
        return YoutubePlaylistLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SearchExtractor getSearchExtractor(SearchQueryHandler searchQueryHandler) {
        List<String> contentFilters = searchQueryHandler.getContentFilters();
        return (contentFilters.isEmpty() || !contentFilters.get(0).startsWith("music_")) ? new YoutubeSearchExtractor(this, searchQueryHandler) : new YoutubeMusicSearchExtractor(this, searchQueryHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SearchQueryHandlerFactory getSearchQHFactory() {
        return YoutubeSearchQueryHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public StreamExtractor getStreamExtractor(LinkHandler linkHandler) {
        return new YoutubeStreamExtractor(this, linkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public LinkHandlerFactory getStreamLHFactory() {
        return YoutubeStreamLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SubscriptionExtractor getSubscriptionExtractor() {
        return new YoutubeSubscriptionExtractor(this);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SuggestionExtractor getSuggestionExtractor() {
        return new YoutubeSuggestionExtractor(this);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public List<ContentCountry> getSupportedCountries() {
        return SUPPORTED_COUNTRIES;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public List<Localization> getSupportedLocalizations() {
        return SUPPORTED_LANGUAGES;
    }
}
