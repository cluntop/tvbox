package org.schabi.newpipe.extractor.services.youtube.extractors.kiosk;

import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeTrendingExtractor extends KioskExtractor<StreamInfoItem> {
    public static final String KIOSK_ID = "Trending";
    private static final String VIDEOS_TAB_PARAMS = "4gIOGgxtb3N0X3BvcHVsYXI%3D";
    private JsonObject initialData;

    public YoutubeTrendingExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str);
    }

    private JsonObject getTrendingTab() {
        int i = 1;
        return (JsonObject) this.initialData.getObject("contents").getObject("twoColumnBrowseResultsRenderer").getArray("tabs").streamAsJsonObjects().map(new d(i)).filter(new c(i)).filter(new c(2)).findFirst().orElseThrow(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInitialPage$0(JsonObject jsonObject) {
        return jsonObject.has("richItemRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getInitialPage$1(JsonObject jsonObject) {
        return jsonObject.getObject("richItemRenderer").getObject("content").getObject("videoRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInitialPage$2(StreamInfoItemsCollector streamInfoItemsCollector, TimeAgoParser timeAgoParser, JsonObject jsonObject) {
        streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeStreamInfoItemExtractor(jsonObject, timeAgoParser));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getInitialPage$3(JsonObject jsonObject) {
        return jsonObject.getObject("itemSectionRenderer").getArray("contents").streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getInitialPage$4(JsonObject jsonObject) {
        return jsonObject.getObject("shelfRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInitialPage$5(JsonObject jsonObject) {
        return !jsonObject.has("title");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getInitialPage$6(JsonObject jsonObject) {
        return jsonObject.getObject("content").getObject("expandedShelfContentsRenderer").getArray("items").streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getInitialPage$7(JsonObject jsonObject) {
        return jsonObject.getObject("videoRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInitialPage$8(StreamInfoItemsCollector streamInfoItemsCollector, TimeAgoParser timeAgoParser, JsonObject jsonObject) {
        streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeStreamInfoItemExtractor(jsonObject, timeAgoParser));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTrendingTab$10(JsonObject jsonObject) {
        return jsonObject.getBoolean("selected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTrendingTab$11(JsonObject jsonObject) {
        return jsonObject.has("content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getTrendingTab$12() {
        return new ParsingException("Could not get \"Now\" or \"Videos\" trending tab");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getTrendingTab$9(JsonObject jsonObject) {
        return jsonObject.getObject("tabRenderer");
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        TimeAgoParser timeAgoParser = getTimeAgoParser();
        JsonObject trendingTab = getTrendingTab();
        JsonObject object = trendingTab.getObject("content");
        boolean zEquals = trendingTab.getObject("endpoint").getObject("browseEndpoint").getString("params", VideoStream.RESOLUTION_UNKNOWN).equals(VIDEOS_TAB_PARAMS);
        int i = 2;
        int i2 = 4;
        int i3 = 3;
        if (object.has("richGridRenderer")) {
            object.getObject("richGridRenderer").getArray("contents").streamAsJsonObjects().filter(new c(i3)).map(new d(i2)).forEachOrdered(new b(streamInfoItemsCollector, timeAgoParser, i));
        } else if (object.has("sectionListRenderer")) {
            Stream map = object.getObject("sectionListRenderer").getArray("contents").streamAsJsonObjects().flatMap(new d(5)).map(new d(6));
            (zEquals ? map.findFirst().stream() : map.filter(new c(i2))).flatMap(new d(i)).map(new d(i3)).forEachOrdered(new b(streamInfoItemsCollector, timeAgoParser, 1));
        }
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() throws ParsingException {
        JsonObject object = this.initialData.getObject("header");
        String textAtKey = object.has("feedTabbedHeaderRenderer") ? YoutubeParsingHelper.getTextAtKey(object.getObject("feedTabbedHeaderRenderer"), "title") : object.has("c4TabbedHeaderRenderer") ? YoutubeParsingHelper.getTextAtKey(object.getObject("c4TabbedHeaderRenderer"), "title") : object.has("pageHeaderRenderer") ? YoutubeParsingHelper.getTextAtKey(object.getObject("pageHeaderRenderer"), "pageTitle") : null;
        if (!Utils.isNullOrEmpty(textAtKey)) {
            return textAtKey;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get Trending name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        return ListExtractor.InfoItemsPage.emptyPage();
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        this.initialData = YoutubeParsingHelper.getJsonPostResponse("browse", JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(getExtractorLocalization(), getExtractorContentCountry()).value("browseId", "FEtrending").value("params", VIDEOS_TAB_PARAMS).done()).getBytes(StandardCharsets.UTF_8), getExtractorLocalization());
    }
}
