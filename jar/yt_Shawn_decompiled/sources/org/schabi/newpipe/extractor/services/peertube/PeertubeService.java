package org.schabi.newpipe.extractor.services.peertube;

import java.util.EnumSet;
import java.util.List;
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
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.a;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeAccountExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeChannelExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeChannelTabExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeCommentsExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubePlaylistExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeSearchExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeStreamExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeSuggestionExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeTrendingExtractor;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeCommentsLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubePlaylistLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeTrendingLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.subscription.SubscriptionExtractor;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeService extends StreamingService {
    private PeertubeInstance instance;

    public PeertubeService(int i, PeertubeInstance peertubeInstance) {
        super(i, "PeerTube", EnumSet.of(StreamingService.ServiceInfo.MediaCapability.VIDEO, StreamingService.ServiceInfo.MediaCapability.COMMENTS));
        this.instance = peertubeInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$0(PeertubeTrendingLinkHandlerFactory peertubeTrendingLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new PeertubeTrendingExtractor(this, peertubeTrendingLinkHandlerFactory.fromId(str2), str2);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public String getBaseUrl() {
        return this.instance.getUrl();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ChannelExtractor getChannelExtractor(ListLinkHandler listLinkHandler) {
        return listLinkHandler.getUrl().contains("/video-channels/") ? new PeertubeChannelExtractor(this, listLinkHandler) : new PeertubeAccountExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getChannelLHFactory() {
        return PeertubeChannelLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ChannelTabExtractor getChannelTabExtractor(ListLinkHandler listLinkHandler) {
        return new PeertubeChannelTabExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getChannelTabLHFactory() {
        return PeertubeChannelTabLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public CommentsExtractor getCommentsExtractor(ListLinkHandler listLinkHandler) {
        return new PeertubeCommentsExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getCommentsLHFactory() {
        return PeertubeCommentsLinkHandlerFactory.getInstance();
    }

    public PeertubeInstance getInstance() {
        return this.instance;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public KioskList getKioskList() throws ExtractionException {
        PeertubeTrendingLinkHandlerFactory peertubeTrendingLinkHandlerFactory = PeertubeTrendingLinkHandlerFactory.getInstance();
        a aVar = new a(this, peertubeTrendingLinkHandlerFactory, 3);
        KioskList kioskList = new KioskList(this);
        try {
            kioskList.addKioskEntry(aVar, peertubeTrendingLinkHandlerFactory, "Trending");
            kioskList.addKioskEntry(aVar, peertubeTrendingLinkHandlerFactory, PeertubeTrendingLinkHandlerFactory.KIOSK_MOST_LIKED);
            kioskList.addKioskEntry(aVar, peertubeTrendingLinkHandlerFactory, PeertubeTrendingLinkHandlerFactory.KIOSK_RECENT);
            kioskList.addKioskEntry(aVar, peertubeTrendingLinkHandlerFactory, PeertubeTrendingLinkHandlerFactory.KIOSK_LOCAL);
            kioskList.setDefaultKiosk("Trending");
            return kioskList;
        } catch (Exception e) {
            throw new ExtractionException(e);
        }
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public PlaylistExtractor getPlaylistExtractor(ListLinkHandler listLinkHandler) {
        return new PeertubePlaylistExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getPlaylistLHFactory() {
        return PeertubePlaylistLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SearchExtractor getSearchExtractor(SearchQueryHandler searchQueryHandler) {
        List<String> contentFilters = searchQueryHandler.getContentFilters();
        boolean z = false;
        if (!contentFilters.isEmpty() && contentFilters.get(0).startsWith("sepia_")) {
            z = true;
        }
        return new PeertubeSearchExtractor(this, searchQueryHandler, z);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SearchQueryHandlerFactory getSearchQHFactory() {
        return PeertubeSearchQueryHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public StreamExtractor getStreamExtractor(LinkHandler linkHandler) {
        return new PeertubeStreamExtractor(this, linkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public LinkHandlerFactory getStreamLHFactory() {
        return PeertubeStreamLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SubscriptionExtractor getSubscriptionExtractor() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SuggestionExtractor getSuggestionExtractor() {
        return new PeertubeSuggestionExtractor(this);
    }

    public void setInstance(PeertubeInstance peertubeInstance) {
        this.instance = peertubeInstance;
    }

    public PeertubeService(int i) {
        this(i, PeertubeInstance.DEFAULT_INSTANCE);
    }
}
