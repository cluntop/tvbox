package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import com.grack.nanojson.JsonStringWriter;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeMusicSearchExtractor extends SearchExtractor {
    private List<JsonObject> cachedItemSectionRendererContents;
    private JsonObject initialData;

    public YoutubeMusicSearchExtractor(StreamingService streamingService, SearchQueryHandler searchQueryHandler) {
        super(streamingService, searchQueryHandler);
    }

    private void collectMusicStreamsFrom(MultiInfoItemsCollector multiInfoItemsCollector, JsonArray jsonArray) {
        jsonArray.streamAsJsonObjects().map(new h(11)).filter(new n(6)).forEachOrdered(new org.schabi.newpipe.extractor.services.soundcloud.extractors.a(3, getLinkHandler().getContentFilters().get(0), multiInfoItemsCollector));
    }

    private List<JsonObject> getItemSectionRendererContents() {
        List<JsonObject> list = this.cachedItemSectionRendererContents;
        if (list != null) {
            return list;
        }
        List<JsonObject> list2 = (List) this.initialData.getObject("contents").getObject("tabbedSearchResultsRenderer").getArray("tabs").getObject(0).getObject("tabRenderer").getObject("content").getObject("sectionListRenderer").getArray("contents").streamAsJsonObjects().map(new h(12)).filter(new n(11)).map(new h(13)).collect(Collectors.toList());
        this.cachedItemSectionRendererContents = list2;
        return list2;
    }

    private Page getNextPageFrom(JsonArray jsonArray) {
        if (Utils.isNullOrEmpty(jsonArray)) {
            return null;
        }
        String string = jsonArray.getObject(0).getObject("nextContinuationData").getString("continuation");
        return new Page("https://music.youtube.com/youtubei/v1/search?ctoken=" + string + "&continuation=" + string + "&prettyPrint=false");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$collectMusicStreamsFrom$4(JsonObject jsonObject) {
        return jsonObject.getObject("musicResponsiveListItemRenderer", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void lambda$collectMusicStreamsFrom$5(java.lang.String r4, org.schabi.newpipe.extractor.MultiInfoItemsCollector r5, com.grack.nanojson.JsonObject r6) {
        /*
            java.lang.String r0 = "musicItemRendererDisplayPolicy"
            java.lang.String r1 = ""
            java.lang.String r0 = r6.getString(r0, r1)
            java.lang.String r1 = "MUSIC_ITEM_RENDERER_DISPLAY_POLICY_GREY_OUT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L11
            goto L72
        L11:
            java.lang.String r0 = "flexColumns"
            com.grack.nanojson.JsonArray r0 = r6.getArray(r0)
            r1 = 1
            com.grack.nanojson.JsonObject r0 = r0.getObject(r1)
            java.lang.String r2 = "musicResponsiveListItemFlexColumnRenderer"
            com.grack.nanojson.JsonObject r0 = r0.getObject(r2)
            java.lang.String r2 = "text"
            com.grack.nanojson.JsonObject r0 = r0.getObject(r2)
            java.lang.String r2 = "runs"
            com.grack.nanojson.JsonArray r0 = r0.getArray(r2)
            r4.getClass()
            int r2 = r4.hashCode()
            r3 = -1
            switch(r2) {
                case -1778518201: goto L65;
                case -566908430: goto L5c;
                case 1499667262: goto L51;
                case 1589120868: goto L46;
                case 2098153138: goto L3b;
                default: goto L39;
            }
        L39:
            r1 = -1
            goto L6f
        L3b:
            java.lang.String r1 = "music_videos"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L44
            goto L39
        L44:
            r1 = 4
            goto L6f
        L46:
            java.lang.String r1 = "music_songs"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L4f
            goto L39
        L4f:
            r1 = 3
            goto L6f
        L51:
            java.lang.String r1 = "music_albums"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L5a
            goto L39
        L5a:
            r1 = 2
            goto L6f
        L5c:
            java.lang.String r2 = "music_artists"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L6f
            goto L39
        L65:
            java.lang.String r1 = "music_playlists"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L6e
            goto L39
        L6e:
            r1 = 0
        L6f:
            switch(r1) {
                case 0: goto L85;
                case 1: goto L7c;
                case 2: goto L85;
                case 3: goto L73;
                case 4: goto L73;
                default: goto L72;
            }
        L72:
            return
        L73:
            org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicSongOrVideoInfoItemExtractor r1 = new org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicSongOrVideoInfoItemExtractor
            r1.<init>(r6, r0, r4)
            r5.commit(r1)
            return
        L7c:
            org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicArtistInfoItemExtractor r4 = new org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicArtistInfoItemExtractor
            r4.<init>(r6)
            r5.commit(r4)
            return
        L85:
            org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicAlbumOrPlaylistInfoItemExtractor r1 = new org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicAlbumOrPlaylistInfoItemExtractor
            r1.<init>(r6, r0, r4)
            r5.commit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMusicSearchExtractor.lambda$collectMusicStreamsFrom$5(java.lang.String, org.schabi.newpipe.extractor.MultiInfoItemsCollector, com.grack.nanojson.JsonObject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getItemSectionRendererContents$0(JsonObject jsonObject) {
        return jsonObject.getObject("itemSectionRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getItemSectionRendererContents$1(JsonObject jsonObject) {
        return !jsonObject.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getItemSectionRendererContents$2(JsonObject jsonObject) {
        return jsonObject.getArray("contents").getObject(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isCorrectedSearch$3(JsonObject jsonObject) {
        return jsonObject.has("showingResultsForRenderer");
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        Iterator<Object> it = JsonUtils.getArray(JsonUtils.getArray(this.initialData, "contents.tabbedSearchResultsRenderer.tabs").getObject(0), "tabRenderer.content.sectionListRenderer.contents").iterator();
        Page nextPageFrom = null;
        while (it.hasNext()) {
            JsonObject jsonObject = (JsonObject) it.next();
            if (jsonObject.has("musicShelfRenderer")) {
                JsonObject object = jsonObject.getObject("musicShelfRenderer");
                collectMusicStreamsFrom(multiInfoItemsCollector, object.getArray("contents"));
                nextPageFrom = getNextPageFrom(object.getArray("continuations"));
            }
        }
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, nextPageFrom);
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
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        try {
            JsonObject object = JsonParser.object().from(YoutubeParsingHelper.getValidJsonResponseBody(getDownloader().postWithContentTypeJson(page.getUrl(), YoutubeParsingHelper.getYoutubeMusicHeaders(), ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) JsonWriter.string().object()).object("context")).object("client")).value("clientName", "WEB_REMIX")).value("clientVersion", YoutubeParsingHelper.getYoutubeMusicClientVersion())).value("hl", "en-GB")).value("gl", getExtractorContentCountry().getCountryCode())).value("platform", "DESKTOP")).value("utcOffsetMinutes", 0)).end()).object("request")).array("internalExperimentFlags")).end()).value("useSsl", true)).end()).object("user")).value("lockedSafetyMode", false)).end()).end()).end()).done().getBytes(StandardCharsets.UTF_8)))).getObject("continuationContents").getObject("musicShelfContinuation");
            collectMusicStreamsFrom(multiInfoItemsCollector, object.getArray("contents"));
            return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, getNextPageFrom(object.getArray("continuations")));
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse JSON", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public String getSearchSuggestion() {
        for (JsonObject jsonObject : getItemSectionRendererContents()) {
            JsonObject object = jsonObject.getObject("didYouMeanRenderer");
            if (!object.isEmpty()) {
                return YoutubeParsingHelper.getTextFromObject(object.getObject("correctedQuery"));
            }
            JsonObject object2 = jsonObject.getObject("showingResultsForRenderer");
            if (!object2.isEmpty()) {
                return JsonUtils.getString(object2, "correctedQueryEndpoint.searchEndpoint.query");
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.search.SearchExtractor
    public boolean isCorrectedSearch() {
        return Collection$EL.stream(getItemSectionRendererContents()).anyMatch(new n(10));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ParsingException {
        String str;
        String str2 = getLinkHandler().getContentFilters().get(0);
        str2.getClass();
        switch (str2) {
            case "music_playlists":
                str = "Eg-KAQwIABAAGAAgACgBMABqChAEEAUQAxAKEAk%3D";
                break;
            case "music_artists":
                str = "Eg-KAQwIABAAGAAgASgAMABqChAEEAUQAxAKEAk%3D";
                break;
            case "music_albums":
                str = "Eg-KAQwIABAAGAEgACgAMABqChAEEAUQAxAKEAk%3D";
                break;
            case "music_songs":
                str = "Eg-KAQwIARAAGAAgACgAMABqChAEEAUQAxAKEAk%3D";
                break;
            case "music_videos":
                str = "Eg-KAQwIABABGAAgACgAMABqChAEEAUQAxAKEAk%3D";
                break;
            default:
                str = null;
                break;
        }
        try {
            this.initialData = JsonParser.object().from(YoutubeParsingHelper.getValidJsonResponseBody(getDownloader().postWithContentTypeJson("https://music.youtube.com/youtubei/v1/search?prettyPrint=false", YoutubeParsingHelper.getYoutubeMusicHeaders(), ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) JsonWriter.string().object()).object("context")).object("client")).value("clientName", "WEB_REMIX")).value("clientVersion", YoutubeParsingHelper.getYoutubeMusicClientVersion())).value("hl", "en-GB")).value("gl", getExtractorContentCountry().getCountryCode())).value("platform", "DESKTOP")).value("utcOffsetMinutes", 0)).end()).object("request")).array("internalExperimentFlags")).end()).value("useSsl", true)).end()).object("user")).value("lockedSafetyMode", false)).end()).end()).value("query", getSearchString())).value("params", str)).end()).done().getBytes(StandardCharsets.UTF_8))));
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse JSON", e);
        }
    }
}
