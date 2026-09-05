package org.schabi.newpipe.extractor.services.youtube.extractors.kiosk;

import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeTrendingGamingVideosExtractor extends YoutubeDesktopBaseKioskExtractor {
    public YoutubeTrendingGamingVideosExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str, "UCOpNcN46UbXVtpKMrmU4Abg", "Egh0cmVuZGluZw%3D%3D");
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeDesktopBaseKioskExtractor, org.schabi.newpipe.extractor.ListExtractor
    public /* bridge */ /* synthetic */ ListExtractor.InfoItemsPage getInitialPage() {
        return super.getInitialPage();
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeDesktopBaseKioskExtractor, org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeDesktopBaseKioskExtractor, org.schabi.newpipe.extractor.ListExtractor
    public /* bridge */ /* synthetic */ ListExtractor.InfoItemsPage getPage(Page page) {
        return super.getPage(page);
    }

    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeDesktopBaseKioskExtractor, org.schabi.newpipe.extractor.Extractor
    public /* bridge */ /* synthetic */ void onFetchPage(Downloader downloader) {
        super.onFetchPage(downloader);
    }
}
