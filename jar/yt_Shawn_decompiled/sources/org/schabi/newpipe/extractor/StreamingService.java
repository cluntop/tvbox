package org.schabi.newpipe.extractor;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.comments.CommentsExtractor;
import org.schabi.newpipe.extractor.feed.FeedExtractor;
import org.schabi.newpipe.extractor.kiosk.KioskList;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.localization.TimeAgoPatternsManager;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.subscription.SubscriptionExtractor;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class StreamingService {
    private final int serviceId;
    private final ServiceInfo serviceInfo;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public enum LinkType {
        NONE,
        STREAM,
        CHANNEL,
        PLAYLIST
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public class ServiceInfo {
        private final Set<MediaCapability> mediaCapabilities;
        private final String name;

        /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
        public enum MediaCapability {
            AUDIO,
            VIDEO,
            LIVE,
            COMMENTS
        }

        public ServiceInfo(String str, Set<MediaCapability> set) {
            this.name = str;
            this.mediaCapabilities = set;
        }

        public Set<MediaCapability> getMediaCapabilities() {
            return this.mediaCapabilities;
        }

        public String getName() {
            return this.name;
        }
    }

    public StreamingService(int i, String str, Set<ServiceInfo.MediaCapability> set) {
        this.serviceId = i;
        this.serviceInfo = new ServiceInfo(str, set);
    }

    public abstract String getBaseUrl();

    public ChannelExtractor getChannelExtractor(String str, List<String> list, String str2) {
        return getChannelExtractor(getChannelLHFactory().fromQuery(str, list, str2));
    }

    public abstract ChannelExtractor getChannelExtractor(ListLinkHandler listLinkHandler);

    public abstract ListLinkHandlerFactory getChannelLHFactory();

    public abstract ChannelTabExtractor getChannelTabExtractor(ListLinkHandler listLinkHandler);

    public ChannelTabExtractor getChannelTabExtractorFromId(String str, String str2) {
        return getChannelTabExtractor(getChannelTabLHFactory().fromQuery(str, Collections.singletonList(str2), VideoStream.RESOLUTION_UNKNOWN));
    }

    public ChannelTabExtractor getChannelTabExtractorFromIdAndBaseUrl(String str, String str2, String str3) {
        return getChannelTabExtractor(getChannelTabLHFactory().fromQuery(str, Collections.singletonList(str2), VideoStream.RESOLUTION_UNKNOWN, str3));
    }

    public abstract ListLinkHandlerFactory getChannelTabLHFactory();

    public CommentsExtractor getCommentsExtractor(String str) {
        ListLinkHandlerFactory commentsLHFactory = getCommentsLHFactory();
        if (commentsLHFactory == null) {
            return null;
        }
        return getCommentsExtractor(commentsLHFactory.fromUrl(str));
    }

    public abstract CommentsExtractor getCommentsExtractor(ListLinkHandler listLinkHandler);

    public abstract ListLinkHandlerFactory getCommentsLHFactory();

    public ContentCountry getContentCountry() {
        ContentCountry preferredContentCountry = NewPipe.getPreferredContentCountry();
        return getSupportedCountries().contains(preferredContentCountry) ? preferredContentCountry : ContentCountry.DEFAULT;
    }

    public FeedExtractor getFeedExtractor(String str) {
        return null;
    }

    public abstract KioskList getKioskList();

    public final LinkType getLinkTypeByUrl(String str) {
        String strFollowGoogleRedirectIfNeeded = Utils.followGoogleRedirectIfNeeded(str);
        LinkHandlerFactory streamLHFactory = getStreamLHFactory();
        ListLinkHandlerFactory channelLHFactory = getChannelLHFactory();
        ListLinkHandlerFactory playlistLHFactory = getPlaylistLHFactory();
        return (streamLHFactory == null || !streamLHFactory.acceptUrl(strFollowGoogleRedirectIfNeeded)) ? (channelLHFactory == null || !channelLHFactory.acceptUrl(strFollowGoogleRedirectIfNeeded)) ? (playlistLHFactory == null || !playlistLHFactory.acceptUrl(strFollowGoogleRedirectIfNeeded)) ? LinkType.NONE : LinkType.PLAYLIST : LinkType.CHANNEL : LinkType.STREAM;
    }

    public Localization getLocalization() {
        Localization preferredLocalization = NewPipe.getPreferredLocalization();
        if (getSupportedLocalizations().contains(preferredLocalization)) {
            return preferredLocalization;
        }
        for (Localization localization : getSupportedLocalizations()) {
            if (localization.getLanguageCode().equals(preferredLocalization.getLanguageCode())) {
                return localization;
            }
        }
        return Localization.DEFAULT;
    }

    public PlaylistExtractor getPlaylistExtractor(String str, List<String> list, String str2) {
        return getPlaylistExtractor(getPlaylistLHFactory().fromQuery(str, list, str2));
    }

    public abstract PlaylistExtractor getPlaylistExtractor(ListLinkHandler listLinkHandler);

    public abstract ListLinkHandlerFactory getPlaylistLHFactory();

    public SearchExtractor getSearchExtractor(String str, List<String> list, String str2) {
        return getSearchExtractor(getSearchQHFactory().fromQuery(str, list, str2));
    }

    public abstract SearchExtractor getSearchExtractor(SearchQueryHandler searchQueryHandler);

    public abstract SearchQueryHandlerFactory getSearchQHFactory();

    public final int getServiceId() {
        return this.serviceId;
    }

    public ServiceInfo getServiceInfo() {
        return this.serviceInfo;
    }

    public StreamExtractor getStreamExtractor(String str) {
        return getStreamExtractor(getStreamLHFactory().fromUrl(str));
    }

    public abstract StreamExtractor getStreamExtractor(LinkHandler linkHandler);

    public abstract LinkHandlerFactory getStreamLHFactory();

    public abstract SubscriptionExtractor getSubscriptionExtractor();

    public abstract SuggestionExtractor getSuggestionExtractor();

    public List<ContentCountry> getSupportedCountries() {
        return Collections.singletonList(ContentCountry.DEFAULT);
    }

    public List<Localization> getSupportedLocalizations() {
        return Collections.singletonList(Localization.DEFAULT);
    }

    public TimeAgoParser getTimeAgoParser(Localization localization) {
        TimeAgoParser timeAgoParserFor;
        TimeAgoParser timeAgoParserFor2 = TimeAgoPatternsManager.getTimeAgoParserFor(localization);
        if (timeAgoParserFor2 != null) {
            return timeAgoParserFor2;
        }
        if (!localization.getCountryCode().isEmpty() && (timeAgoParserFor = TimeAgoPatternsManager.getTimeAgoParserFor(new Localization(localization.getLanguageCode()))) != null) {
            return timeAgoParserFor;
        }
        throw new IllegalArgumentException("Localization is not supported (\"" + localization + "\")");
    }

    public String toString() {
        return this.serviceId + ":" + this.serviceInfo.getName();
    }

    public ChannelExtractor getChannelExtractor(String str) {
        return getChannelExtractor(getChannelLHFactory().fromUrl(str));
    }

    public PlaylistExtractor getPlaylistExtractor(String str) {
        return getPlaylistExtractor(getPlaylistLHFactory().fromUrl(str));
    }

    public SearchExtractor getSearchExtractor(String str) {
        return getSearchExtractor(getSearchQHFactory().fromQuery(str));
    }
}
