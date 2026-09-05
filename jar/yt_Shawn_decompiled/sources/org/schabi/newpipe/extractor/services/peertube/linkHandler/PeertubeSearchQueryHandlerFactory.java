package org.schabi.newpipe.extractor.services.peertube.linkHandler;

import java.util.List;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PeertubeSearchQueryHandlerFactory extends SearchQueryHandlerFactory {
    public static final String CHANNELS = "channels";
    private static final PeertubeSearchQueryHandlerFactory INSTANCE = new PeertubeSearchQueryHandlerFactory();
    public static final String PLAYLISTS = "playlists";
    public static final String SEARCH_ENDPOINT_CHANNELS = "/api/v1/search/video-channels";
    public static final String SEARCH_ENDPOINT_PLAYLISTS = "/api/v1/search/video-playlists";
    public static final String SEARCH_ENDPOINT_VIDEOS = "/api/v1/search/videos";
    public static final String SEPIA_BASE_URL = "https://sepiasearch.org";
    public static final String SEPIA_VIDEOS = "sepia_videos";
    public static final String VIDEOS = "videos";

    private PeertubeSearchQueryHandlerFactory() {
    }

    public static PeertubeSearchQueryHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableContentFilter() {
        return new String[]{"videos", "playlists", "channels", SEPIA_VIDEOS};
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2, String str3) {
        return str3 + ((list.isEmpty() || list.get(0).equals("videos") || list.get(0).equals(SEPIA_VIDEOS)) ? SEARCH_ENDPOINT_VIDEOS : list.get(0).equals("channels") ? SEARCH_ENDPOINT_CHANNELS : SEARCH_ENDPOINT_PLAYLISTS) + "?search=" + Utils.encodeUrlUtf8(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory, org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        String baseUrl;
        if (!list.isEmpty() && list.get(0).startsWith("sepia_")) {
            baseUrl = SEPIA_BASE_URL;
        } else {
            baseUrl = ServiceList.PeerTube.getBaseUrl();
        }
        return getUrl(str, list, str2, baseUrl);
    }
}
