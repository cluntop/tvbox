package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import java.io.IOException;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudChartsExtractor extends KioskExtractor<StreamInfoItem> {
    private StreamInfoItemsCollector initialFetchCollector;
    private String initialFetchNextPageUrl;

    public SoundcloudChartsExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        return new ListExtractor.InfoItemsPage<>(this.initialFetchCollector, new Page(this.initialFetchNextPageUrl));
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return getId();
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't contain an URL");
            return null;
        }
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, new Page(SoundcloudParsingHelper.getStreamsFromApi(streamInfoItemsCollector, page.getUrl(), true)));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        if (this.initialFetchNextPageUrl != null) {
            return;
        }
        this.initialFetchCollector = new StreamInfoItemsCollector(getServiceId());
        String strA = com.github.catvod.spider.merge.b.b.A("https://api-v2.soundcloud.com/charts?genre=soundcloud:genres:all-music&client_id=", SoundcloudParsingHelper.clientId(), "&kind=trending");
        ContentCountry contentCountry = ServiceList.SoundCloud.getContentCountry();
        String strO = getService().getSupportedCountries().contains(contentCountry) ? com.github.catvod.spider.merge.b.b.o(strA, "&region=soundcloud:regions:", contentCountry.getCountryCode()) : null;
        try {
            StreamInfoItemsCollector streamInfoItemsCollector = this.initialFetchCollector;
            if (strO == null) {
                strO = strA;
            }
            this.initialFetchNextPageUrl = SoundcloudParsingHelper.getStreamsFromApi(streamInfoItemsCollector, strO, true);
        } catch (IOException unused) {
            this.initialFetchNextPageUrl = SoundcloudParsingHelper.getStreamsFromApi(this.initialFetchCollector, strA, true);
        }
    }
}
