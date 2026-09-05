package org.schabi.newpipe.extractor.services.youtube.extractors.kiosk;

import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.UnsupportedContentInCountryException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeTrendingMusicExtractor extends YoutubeChartsBaseKioskExtractor {
    public YoutubeTrendingMusicExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str, "TRENDING_VIDEOS");
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeChartsBaseKioskExtractor, org.schabi.newpipe.extractor.ListExtractor
    public /* bridge */ /* synthetic */ ListExtractor.InfoItemsPage getInitialPage() {
        return super.getInitialPage();
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeChartsBaseKioskExtractor, org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return "Trending Music Videos";
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeChartsBaseKioskExtractor, org.schabi.newpipe.extractor.ListExtractor
    public /* bridge */ /* synthetic */ ListExtractor.InfoItemsPage getPage(Page page) {
        return super.getPage(page);
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeChartsBaseKioskExtractor, org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws UnsupportedContentInCountryException {
        if (!YoutubeChartsBaseKioskExtractor.YT_CHARTS_SUPPORTED_COUNTRY_CODES.contains(getExtractorContentCountry().getCountryCode())) {
            throw new UnsupportedContentInCountryException("YouTube Charts doesn't support this country for trending music videos charts");
        }
        super.onFetchPage(downloader);
    }
}
