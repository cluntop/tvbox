package org.schabi.newpipe.extractor.services.youtube.linkHandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeTrendingMoviesAndShowsTrailersLinkHandlerFactory extends ListLinkHandlerFactory {
    public static final YoutubeTrendingMoviesAndShowsTrailersLinkHandlerFactory INSTANCE = new YoutubeTrendingMoviesAndShowsTrailersLinkHandlerFactory();
    public static final String KIOSK_ID = "trending_movies_and_shows";
    private static final String PATH = "/charts/TrendingTrailers";

    private YoutubeTrendingMoviesAndShowsTrailersLinkHandlerFactory() {
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return KIOSK_ID;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return "https://charts.youtube.com/charts/TrendingTrailers";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        URL urlStringToURL;
        try {
            urlStringToURL = Utils.stringToURL(str);
        } catch (MalformedURLException unused) {
        }
        return Utils.isHTTP(urlStringToURL) && "charts.youtube.com".equals(urlStringToURL.getHost().toLowerCase(Locale.ROOT)) && PATH.equals(urlStringToURL.getPath());
    }
}
