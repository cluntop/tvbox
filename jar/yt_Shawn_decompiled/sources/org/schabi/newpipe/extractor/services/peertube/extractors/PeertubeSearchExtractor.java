package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.s0.a;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeSearchExtractor extends SearchExtractor {
    private final boolean sepia;

    public PeertubeSearchExtractor(StreamingService streamingService, SearchQueryHandler searchQueryHandler, boolean z) {
        super(streamingService, searchQueryHandler);
        this.sepia = z;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        return getPage(new Page(b.z(getUrl(), "&start=0&count=12")));
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public List<MetaInfo> getMetaInfo() {
        return Collections.EMPTY_LIST;
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
                a.m("Could not parse json data for search info", e);
                return null;
            }
        }
        if (jsonObjectFrom == null) {
            throw new ExtractionException("Unable to get PeerTube search info");
        }
        PeertubeParsingHelper.validate(jsonObjectFrom);
        long j = jsonObjectFrom.getLong("total");
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        PeertubeParsingHelper.collectItemsFrom(multiInfoItemsCollector, jsonObjectFrom, getBaseUrl(), this.sepia);
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, PeertubeParsingHelper.getNextPage(page.getUrl(), j));
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public String getSearchSuggestion() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public boolean isCorrectedSearch() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
    }

    public PeertubeSearchExtractor(StreamingService streamingService, SearchQueryHandler searchQueryHandler) {
        this(streamingService, searchQueryHandler, false);
    }
}
