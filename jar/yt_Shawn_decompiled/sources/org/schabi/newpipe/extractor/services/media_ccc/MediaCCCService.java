package org.schabi.newpipe.extractor.services.media_ccc;

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
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCChannelTabExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCConferenceExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCConferenceKiosk;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCLiveStreamExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCLiveStreamKiosk;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCParsingHelper;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCRecentKiosk;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCSearchExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCStreamExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCConferenceLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCConferencesListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCLiveListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCRecentListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.subscription.SubscriptionExtractor;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCService extends StreamingService {
    public MediaCCCService(int i) {
        super(i, "media.ccc.de", EnumSet.of(StreamingService.ServiceInfo.MediaCapability.AUDIO, StreamingService.ServiceInfo.MediaCapability.VIDEO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$0(MediaCCCConferencesListLinkHandlerFactory mediaCCCConferencesListLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new MediaCCCConferenceKiosk(this, mediaCCCConferencesListLinkHandlerFactory.fromUrl(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$1(MediaCCCRecentListLinkHandlerFactory mediaCCCRecentListLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new MediaCCCRecentKiosk(this, mediaCCCRecentListLinkHandlerFactory.fromUrl(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ KioskExtractor lambda$getKioskList$2(MediaCCCLiveListLinkHandlerFactory mediaCCCLiveListLinkHandlerFactory, StreamingService streamingService, String str, String str2) {
        return new MediaCCCLiveStreamKiosk(this, mediaCCCLiveListLinkHandlerFactory.fromUrl(str), str2);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public String getBaseUrl() {
        return "https://media.ccc.de";
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ChannelExtractor getChannelExtractor(ListLinkHandler listLinkHandler) {
        return new MediaCCCConferenceExtractor(this, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getChannelLHFactory() {
        return MediaCCCConferenceLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ChannelTabExtractor getChannelTabExtractor(ListLinkHandler listLinkHandler) {
        return listLinkHandler instanceof ReadyChannelTabListLinkHandler ? ((ReadyChannelTabListLinkHandler) listLinkHandler).getChannelTabExtractor(this) : new MediaCCCChannelTabExtractor(this, listLinkHandler, null);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getChannelTabLHFactory() {
        return MediaCCCConferenceLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public CommentsExtractor getCommentsExtractor(ListLinkHandler listLinkHandler) {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getCommentsLHFactory() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public KioskList getKioskList() throws ExtractionException {
        KioskList kioskList = new KioskList(this);
        MediaCCCConferencesListLinkHandlerFactory mediaCCCConferencesListLinkHandlerFactory = MediaCCCConferencesListLinkHandlerFactory.getInstance();
        MediaCCCRecentListLinkHandlerFactory mediaCCCRecentListLinkHandlerFactory = MediaCCCRecentListLinkHandlerFactory.getInstance();
        MediaCCCLiveListLinkHandlerFactory mediaCCCLiveListLinkHandlerFactory = MediaCCCLiveListLinkHandlerFactory.getInstance();
        try {
            kioskList.addKioskEntry(new a(this, mediaCCCConferencesListLinkHandlerFactory, 0), mediaCCCConferencesListLinkHandlerFactory, "conferences");
            kioskList.addKioskEntry(new a(this, mediaCCCRecentListLinkHandlerFactory, 1), mediaCCCRecentListLinkHandlerFactory, MediaCCCRecentKiosk.KIOSK_ID);
            kioskList.addKioskEntry(new a(this, mediaCCCLiveListLinkHandlerFactory, 2), mediaCCCLiveListLinkHandlerFactory, "live");
            kioskList.setDefaultKiosk(MediaCCCRecentKiosk.KIOSK_ID);
            return kioskList;
        } catch (Exception e) {
            throw new ExtractionException(e);
        }
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public PlaylistExtractor getPlaylistExtractor(ListLinkHandler listLinkHandler) {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public ListLinkHandlerFactory getPlaylistLHFactory() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SearchExtractor getSearchExtractor(SearchQueryHandler searchQueryHandler) {
        return new MediaCCCSearchExtractor(this, searchQueryHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SearchQueryHandlerFactory getSearchQHFactory() {
        return MediaCCCSearchQueryHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public StreamExtractor getStreamExtractor(LinkHandler linkHandler) {
        return MediaCCCParsingHelper.isLiveStreamId(linkHandler.getId()) ? new MediaCCCLiveStreamExtractor(this, linkHandler) : new MediaCCCStreamExtractor(this, linkHandler);
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public LinkHandlerFactory getStreamLHFactory() {
        return MediaCCCStreamLinkHandlerFactory.getInstance();
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SubscriptionExtractor getSubscriptionExtractor() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.StreamingService
    public SuggestionExtractor getSuggestionExtractor() {
        return null;
    }
}
