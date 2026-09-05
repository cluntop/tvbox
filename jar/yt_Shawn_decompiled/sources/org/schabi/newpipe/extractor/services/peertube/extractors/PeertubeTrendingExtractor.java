package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.s0.a;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeTrendingExtractor extends KioskExtractor<StreamInfoItem> {
    public PeertubeTrendingExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        return getPage(new Page(b.z(getUrl(), "&start=0&count=12")));
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return getId();
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) throws ExtractionException {
        JsonObject jsonObjectFrom = null;
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            a.r("Page doesn't contain an URL");
            return null;
        }
        Response response = getDownloader().get(page.getUrl());
        if (response != null && !Utils.isBlank(response.responseBody())) {
            try {
                jsonObjectFrom = JsonParser.object().from(response.responseBody());
            } catch (Exception e) {
                a.m("Could not parse json data for kiosk info", e);
                return null;
            }
        }
        if (jsonObjectFrom == null) {
            throw new ExtractionException("Unable to get PeerTube kiosk info");
        }
        PeertubeParsingHelper.validate(jsonObjectFrom);
        long j = jsonObjectFrom.getLong("total");
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        PeertubeParsingHelper.collectItemsFrom(streamInfoItemsCollector, jsonObjectFrom, getBaseUrl());
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, PeertubeParsingHelper.getNextPage(page.getUrl(), j));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
    }
}
