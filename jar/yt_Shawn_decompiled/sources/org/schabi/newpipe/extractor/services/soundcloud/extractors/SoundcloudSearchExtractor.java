package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntUnaryOperator;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.InfoItemsCollector;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudSearchExtractor extends SearchExtractor {
    private static final String COLLECTION = "collection";
    private static final String TOTAL_RESULTS = "total_results";
    private JsonObject initialSearchObject;

    public SoundcloudSearchExtractor(StreamingService streamingService, SearchQueryHandler searchQueryHandler) {
        super(streamingService, searchQueryHandler);
    }

    private InfoItemsCollector<InfoItem, InfoItemExtractor> collectItems(JsonArray jsonArray) {
        JsonObject jsonObject;
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        Iterator<Object> it = jsonArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JsonObject) {
                jsonObject = (JsonObject) next;
                String string = jsonObject.getString("kind", VideoStream.RESOLUTION_UNKNOWN);
                string.getClass();
                switch (string) {
                    case "user":
                        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new SoundcloudChannelInfoItemExtractor(jsonObject));
                        break;
                    case "track":
                        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new SoundcloudStreamInfoItemExtractor(jsonObject));
                        break;
                    case "playlist":
                        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new SoundcloudPlaylistInfoItemExtractor(jsonObject));
                        break;
                }
            }
        }
        return multiInfoItemsCollector;
    }

    private Page getNextPageFromCurrentUrl(String str, IntUnaryOperator intUnaryOperator) throws ParsingException {
        int offsetFromUrl = getOffsetFromUrl(str);
        return new Page(str.replace(com.github.catvod.spider.merge.b.b.j(offsetFromUrl, "&offset="), "&offset=" + intUnaryOperator.applyAsInt(offsetFromUrl)));
    }

    private int getOffsetFromUrl(String str) throws ParsingException {
        try {
            return Integer.parseInt(Parser.compatParseMap(new URL(str).getQuery()).get("offset"));
        } catch (MalformedURLException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get offset from page URL", e);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getInitialPage$0(int i) {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getPage$1(int i) {
        return i + 10;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        return this.initialSearchObject.getInt(TOTAL_RESULTS) > 10 ? new ListExtractor.InfoItemsPage<>(collectItems(this.initialSearchObject.getArray(COLLECTION)), getNextPageFromCurrentUrl(getUrl(), new b(1))) : new ListExtractor.InfoItemsPage<>(collectItems(this.initialSearchObject.getArray(COLLECTION)), null);
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public List<MetaInfo> getMetaInfo() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) throws ParsingException {
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't contain an URL");
            return null;
        }
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(getDownloader().get(page.getUrl(), getExtractorLocalization()).responseBody());
            JsonArray array = jsonObjectFrom.getArray(COLLECTION);
            return getOffsetFromUrl(page.getUrl()) + 10 < jsonObjectFrom.getInt(TOTAL_RESULTS) ? new ListExtractor.InfoItemsPage<>(collectItems(array), getNextPageFromCurrentUrl(page.getUrl(), new b(0))) : new ListExtractor.InfoItemsPage<>(collectItems(array), null);
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
            return null;
        }
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
    public void onFetchPage(Downloader downloader) throws SearchExtractor.NothingFoundException, ParsingException {
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(getDownloader().get(getUrl(), getExtractorLocalization()).responseBody());
            this.initialSearchObject = jsonObjectFrom;
            if (jsonObjectFrom.getArray(COLLECTION).isEmpty()) {
                throw new SearchExtractor.NothingFoundException("Nothing found");
            }
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
        }
    }
}
