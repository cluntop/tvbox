package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Objects;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonBuilder;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.youtube.YoutubeMetaInfoHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeSearchExtractor extends SearchExtractor {
    private final boolean extractChannelResults;
    private final boolean extractPlaylistResults;
    private final boolean extractVideoResults;
    private JsonObject initialData;
    private final String searchType;

    public YoutubeSearchExtractor(StreamingService streamingService, SearchQueryHandler searchQueryHandler) {
        super(streamingService, searchQueryHandler);
        List<String> contentFilters = searchQueryHandler.getContentFilters();
        String str = Utils.isNullOrEmpty(contentFilters) ? null : contentFilters.get(0);
        this.searchType = str;
        this.extractVideoResults = str == null || "all".equals(str) || "videos".equals(str);
        this.extractChannelResults = str == null || "all".equals(str) || "channels".equals(str);
        this.extractPlaylistResults = str == null || "all".equals(str) || "playlists".equals(str);
    }

    private void collectStreamsFrom(MultiInfoItemsCollector multiInfoItemsCollector, JsonArray jsonArray) throws SearchExtractor.NothingFoundException {
        TimeAgoParser timeAgoParser = getTimeAgoParser();
        Iterator<Object> it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonObject jsonObject = (JsonObject) it.next();
            if (jsonObject.has("backgroundPromoRenderer")) {
                throw new SearchExtractor.NothingFoundException(YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("backgroundPromoRenderer").getObject("bodyText")));
            }
            if (jsonObject.has("videoRenderer") && this.extractVideoResults) {
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeStreamInfoItemExtractor(jsonObject.getObject("videoRenderer"), timeAgoParser));
            } else if (jsonObject.has("channelRenderer") && this.extractChannelResults) {
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeChannelInfoItemExtractor(jsonObject.getObject("channelRenderer")));
            } else if (jsonObject.has("playlistRenderer") && this.extractPlaylistResults) {
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubePlaylistInfoItemExtractor(jsonObject.getObject("playlistRenderer")));
            } else if (jsonObject.has("showRenderer") && this.extractPlaylistResults) {
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeShowRendererInfoItemExtractor(jsonObject.getObject("showRenderer")));
            } else if (jsonObject.has("lockupViewModel")) {
                JsonObject object = jsonObject.getObject("lockupViewModel");
                String string = object.getString("contentType");
                if (("LOCKUP_CONTENT_TYPE_PLAYLIST".equals(string) || "LOCKUP_CONTENT_TYPE_PODCAST".equals(string)) && this.extractPlaylistResults) {
                    multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeMixOrPlaylistLockupInfoItemExtractor(object));
                } else if ("LOCKUP_CONTENT_TYPE_VIDEO".equals(string) && this.extractVideoResults) {
                    multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeStreamInfoItemLockupExtractor(object, timeAgoParser));
                }
            }
        }
    }

    private Page getNextPageFrom(JsonObject jsonObject) {
        if (Utils.isNullOrEmpty(jsonObject)) {
            return null;
        }
        return new Page("https://www.youtube.com/youtubei/v1/search?prettyPrint=false", jsonObject.getObject("continuationEndpoint").getObject("continuationCommand").getString("token"));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() throws SearchExtractor.NothingFoundException {
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        Iterator<Object> it = com.github.catvod.spider.merge.t0.a.c(this.initialData, "contents", "twoColumnSearchResultsRenderer", "primaryContents", "sectionListRenderer").getArray("contents").iterator();
        Page nextPageFrom = null;
        while (it.hasNext()) {
            JsonObject jsonObject = (JsonObject) it.next();
            if (jsonObject.has("itemSectionRenderer")) {
                collectStreamsFrom(multiInfoItemsCollector, jsonObject.getObject("itemSectionRenderer").getArray("contents"));
            } else if (jsonObject.has("continuationItemRenderer")) {
                nextPageFrom = getNextPageFrom(jsonObject.getObject("continuationItemRenderer"));
            }
        }
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, nextPageFrom);
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public List<MetaInfo> getMetaInfo() {
        return YoutubeMetaInfoHelper.getMetaInfo(com.github.catvod.spider.merge.t0.a.c(this.initialData, "contents", "twoColumnSearchResultsRenderer", "primaryContents", "sectionListRenderer").getArray("contents"));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) throws SearchExtractor.NothingFoundException {
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't contain an URL");
            return null;
        }
        Localization extractorLocalization = getExtractorLocalization();
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        JsonArray array = YoutubeParsingHelper.getJsonPostResponse("search", JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, getExtractorContentCountry()).value("continuation", page.getId()).done()).getBytes(StandardCharsets.UTF_8), extractorLocalization).getArray("onResponseReceivedCommands").getObject(0).getObject("appendContinuationItemsAction").getArray("continuationItems");
        collectStreamsFrom(multiInfoItemsCollector, array.getObject(0).getObject("itemSectionRenderer").getArray("contents"));
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, getNextPageFrom(array.getObject(1).getObject("continuationItemRenderer")));
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public String getSearchSuggestion() {
        JsonObject object = com.github.catvod.spider.merge.t0.a.c(this.initialData, "contents", "twoColumnSearchResultsRenderer", "primaryContents", "sectionListRenderer").getArray("contents").getObject(0).getObject("itemSectionRenderer");
        JsonObject object2 = object.getArray("contents").getObject(0).getObject("didYouMeanRenderer");
        return !object2.isEmpty() ? JsonUtils.getString(object2, "correctedQueryEndpoint.searchEndpoint.query") : (String) Objects.requireNonNullElse(YoutubeParsingHelper.getTextFromObject(object.getArray("contents").getObject(0).getObject("showingResultsForRenderer").getObject("correctedQuery")), VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getUrl() {
        return com.github.catvod.spider.merge.b.b.o(super.getUrl(), "&gl=", getExtractorContentCountry().getCountryCode());
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public boolean isCorrectedSearch() {
        return !com.github.catvod.spider.merge.t0.a.c(this.initialData, "contents", "twoColumnSearchResultsRenderer", "primaryContents", "sectionListRenderer").getArray("contents").getObject(0).getObject("itemSectionRenderer").getArray("contents").getObject(0).getObject("showingResultsForRenderer").isEmpty();
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        String searchString = super.getSearchString();
        Localization extractorLocalization = getExtractorLocalization();
        String searchParameter = YoutubeSearchQueryHandlerFactory.getSearchParameter(this.searchType);
        JsonBuilder<JsonObject> jsonBuilderValue = YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, getExtractorContentCountry()).value("query", searchString);
        if (!Utils.isNullOrEmpty(searchParameter)) {
            jsonBuilderValue.value("params", searchParameter);
        }
        this.initialData = YoutubeParsingHelper.getJsonPostResponse("search", JsonWriter.string(jsonBuilderValue.done()).getBytes(StandardCharsets.UTF_8), extractorLocalization);
    }
}
