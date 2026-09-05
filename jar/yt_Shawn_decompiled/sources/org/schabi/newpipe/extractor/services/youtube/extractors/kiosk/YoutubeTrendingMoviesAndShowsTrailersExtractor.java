package org.schabi.newpipe.extractor.services.youtube.extractors.kiosk;

import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeTrendingMoviesAndShowsTrailersExtractor extends YoutubeChartsBaseKioskExtractor {
    public YoutubeTrendingMoviesAndShowsTrailersExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str, "TRENDING_MOVIES");
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeChartsBaseKioskExtractor, org.schabi.newpipe.extractor.ListExtractor
    public /* bridge */ /* synthetic */ ListExtractor.InfoItemsPage getInitialPage() {
        return super.getInitialPage();
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeChartsBaseKioskExtractor, org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return "Trending Movie Trailers";
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeChartsBaseKioskExtractor, org.schabi.newpipe.extractor.ListExtractor
    public /* bridge */ /* synthetic */ ListExtractor.InfoItemsPage getPage(Page page) {
        return super.getPage(page);
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeChartsBaseKioskExtractor, org.schabi.newpipe.extractor.Extractor
    public /* bridge */ /* synthetic */ void onFetchPage(Downloader downloader) {
        super.onFetchPage(downloader);
    }
}
