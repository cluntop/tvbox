package org.schabi.newpipe.extractor.services.bandcamp;

import java.util.EnumSet;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.comments.CommentsExtractor;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.kiosk.KioskList;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampChannelExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampChannelTabExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampCommentsExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampExtractorHelper;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampFeaturedExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampPlaylistExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampRadioExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampRadioStreamExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampSearchExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampSuggestionExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.linkHandler.BandcampChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.linkHandler.BandcampChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.linkHandler.BandcampCommentsLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.linkHandler.BandcampFeaturedLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.linkHandler.BandcampPlaylistLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.linkHandler.BandcampSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.linkHandler.BandcampStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.subscription.SubscriptionExtractor;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampService extends StreamingService {
    public BandcampService(int i) {
        super(i, "Bandcamp", EnumSet.of(StreamingService.ServiceInfo.MediaCapability.AUDIO, StreamingService.ServiceInfo.MediaCapability.COMMENTS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$0(ListLinkHandlerFactory listLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new BandcampFeaturedExtractor(this, listLinkHandlerFactory.fromUrl(BandcampFeaturedExtractor.FEATURED_API_URL), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$1(ListLinkHandlerFactory listLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new BandcampRadioExtractor(this, listLinkHandlerFactory.fromUrl(BandcampRadioExtractor.RADIO_API_URL), str2);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public String getBaseUrl() {
        return BandcampExtractorHelper.BASE_URL;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ChannelExtractor getChannelExtractor(ListLinkHandler listLinkHandler) {
        return new BandcampChannelExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getChannelLHFactory() {
        return BandcampChannelLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ChannelTabExtractor getChannelTabExtractor(ListLinkHandler listLinkHandler) {
        return listLinkHandler instanceof ReadyChannelTabListLinkHandler ? ((ReadyChannelTabListLinkHandler) listLinkHandler).getChannelTabExtractor(this) : new BandcampChannelTabExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getChannelTabLHFactory() {
        return BandcampChannelTabLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public CommentsExtractor getCommentsExtractor(ListLinkHandler listLinkHandler) {
        return new BandcampCommentsExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getCommentsLHFactory() {
        return BandcampCommentsLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public KioskList getKioskList() throws ExtractionException {
        KioskList kioskList = new KioskList(this);
        final BandcampFeaturedLinkHandlerFactory bandcampFeaturedLinkHandlerFactory = BandcampFeaturedLinkHandlerFactory.getInstance();
        try {
            final int i = 0;
            kioskList.addKioskEntry(new KioskList.KioskExtractorFactory(this) { // from class: org.schabi.newpipe.extractor.services.bandcamp.a
                public final /* synthetic */ BandcampService b;

                {
                    this.b = this;
                }

                @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
                public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
                    int i2 = i;
                    ListLinkHandlerFactory listLinkHandlerFactory = bandcampFeaturedLinkHandlerFactory;
                    BandcampService bandcampService = this.b;
                    switch (i2) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            return bandcampService.lambda$getKioskList$0(listLinkHandlerFactory, streamingService, str, str2);
                        default:
                            return bandcampService.lambda$getKioskList$1(listLinkHandlerFactory, streamingService, str, str2);
                    }
                }
            }, bandcampFeaturedLinkHandlerFactory, BandcampFeaturedExtractor.KIOSK_FEATURED);
            final int i2 = 1;
            kioskList.addKioskEntry(new KioskList.KioskExtractorFactory(this) { // from class: org.schabi.newpipe.extractor.services.bandcamp.a
                public final /* synthetic */ BandcampService b;

                {
                    this.b = this;
                }

                @Override // org.schabi.newpipe.extractor.kiosk.KioskList.KioskExtractorFactory
                public final KioskExtractor createNewKiosk(StreamingService streamingService, String str, String str2) {
                    int i22 = i2;
                    ListLinkHandlerFactory listLinkHandlerFactory = bandcampFeaturedLinkHandlerFactory;
                    BandcampService bandcampService = this.b;
                    switch (i22) {
                        case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                            return bandcampService.lambda$getKioskList$0(listLinkHandlerFactory, streamingService, str, str2);
                        default:
                            return bandcampService.lambda$getKioskList$1(listLinkHandlerFactory, streamingService, str, str2);
                    }
                }
            }, bandcampFeaturedLinkHandlerFactory, BandcampRadioExtractor.KIOSK_RADIO);
            kioskList.setDefaultKiosk(BandcampFeaturedExtractor.KIOSK_FEATURED);
            return kioskList;
        } catch (Exception e) {
            throw new ExtractionException(e);
        }
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public PlaylistExtractor getPlaylistExtractor(ListLinkHandler listLinkHandler) {
        return new BandcampPlaylistExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getPlaylistLHFactory() {
        return BandcampPlaylistLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SearchExtractor getSearchExtractor(SearchQueryHandler searchQueryHandler) {
        return new BandcampSearchExtractor(this, searchQueryHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SearchQueryHandlerFactory getSearchQHFactory() {
        return BandcampSearchQueryHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public StreamExtractor getStreamExtractor(LinkHandler linkHandler) {
        return BandcampExtractorHelper.isRadioUrl(linkHandler.getUrl()) ? new BandcampRadioStreamExtractor(this, linkHandler) : new BandcampStreamExtractor(this, linkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public LinkHandlerFactory getStreamLHFactory() {
        return BandcampStreamLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SubscriptionExtractor getSubscriptionExtractor() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SuggestionExtractor getSuggestionExtractor() {
        return new BandcampSuggestionExtractor(this);
    }
}
