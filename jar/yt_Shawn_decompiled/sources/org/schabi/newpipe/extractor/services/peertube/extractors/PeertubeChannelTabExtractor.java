package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.merge.s0.a;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeChannelTabExtractor extends ChannelTabExtractor {
    private final String baseUrl;

    public PeertubeChannelTabExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
        this.baseUrl = getBaseUrl();
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        return getPage(new Page(this.baseUrl + PeertubeChannelLinkHandlerFactory.API_ENDPOINT + getId() + PeertubeChannelTabLinkHandlerFactory.getUrlSuffix(getName()) + "?start=0&count=12"));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) throws ExtractionException {
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
                a.m("Could not parse json data for account info", e);
                return null;
            }
        }
        if (jsonObjectFrom == null) {
            throw new ExtractionException("Unable to get account channel list");
        }
        PeertubeParsingHelper.validate(jsonObjectFrom);
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        PeertubeParsingHelper.collectItemsFrom(multiInfoItemsCollector, jsonObjectFrom, getBaseUrl());
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, PeertubeParsingHelper.getNextPage(page.getUrl(), jsonObjectFrom.getLong("total")));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
    }
}
