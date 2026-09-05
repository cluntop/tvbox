package org.schabi.newpipe.extractor.services.youtube.linkHandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeTrendingPodcastsEpisodesLinkHandlerFactory extends ListLinkHandlerFactory {
    public static final YoutubeTrendingPodcastsEpisodesLinkHandlerFactory INSTANCE = new YoutubeTrendingPodcastsEpisodesLinkHandlerFactory();
    public static final String KIOSK_ID = "trending_podcasts_episodes";
    private static final String PATH = "/podcasts/popularepisodes";

    private YoutubeTrendingPodcastsEpisodesLinkHandlerFactory() {
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return KIOSK_ID;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return "https://www.youtube.com/podcasts/popularepisodes";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        URL urlStringToURL;
        try {
            urlStringToURL = Utils.stringToURL(str);
        } catch (MalformedURLException unused) {
        }
        return Utils.isHTTP(urlStringToURL) && (YoutubeParsingHelper.isYoutubeURL(urlStringToURL) || YoutubeParsingHelper.isInvidiousURL(urlStringToURL)) && PATH.equals(urlStringToURL.getPath());
    }
}
