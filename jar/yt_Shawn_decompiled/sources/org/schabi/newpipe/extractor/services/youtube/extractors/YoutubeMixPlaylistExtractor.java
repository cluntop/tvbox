package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonBuilder;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ContentNotAvailableException;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ImageSuffix;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeMixPlaylistExtractor extends PlaylistExtractor {
    public static final String COOKIE_NAME = "VISITOR_INFO1_LIVE";
    private static final List<ImageSuffix> IMAGE_URL_SUFFIXES_AND_RESOLUTIONS;
    private String cookieValue;
    private JsonObject initialData;
    private JsonObject playlistData;

    static {
        ImageSuffix imageSuffix = new ImageSuffix("default.jpg", 90, 120, Image.ResolutionLevel.LOW);
        Image.ResolutionLevel resolutionLevel = Image.ResolutionLevel.MEDIUM;
        Object[] objArr = {imageSuffix, new ImageSuffix("mqdefault.jpg", 180, 320, resolutionLevel), new ImageSuffix("hqdefault.jpg", 360, 480, resolutionLevel)};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        IMAGE_URL_SUFFIXES_AND_RESOLUTIONS = DesugarCollections.unmodifiableList(arrayList);
    }

    public YoutubeMixPlaylistExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    private void collectStreamsFrom(StreamInfoItemsCollector streamInfoItemsCollector, List<Object> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        Stream<R> map = new JsonArray(list).streamAsJsonObjects().map(new k(getTimeAgoParser(), i));
        Objects.requireNonNull(streamInfoItemsCollector);
        map.forEachOrdered(new l(i, streamInfoItemsCollector));
    }

    private Page getNextPageFrom(JsonObject jsonObject, Map<String, String> map) throws ExtractionException {
        JsonObject jsonObject2 = (JsonObject) jsonObject.getArray("contents").get(jsonObject.getArray("contents").size() - 1);
        if (jsonObject2 == null || jsonObject2.getObject("playlistPanelVideoRenderer") == null) {
            throw new ExtractionException("Could not extract next page url");
        }
        JsonObject object = jsonObject2.getObject("playlistPanelVideoRenderer").getObject("navigationEndpoint").getObject("watchEndpoint");
        String string = object.getString("playlistId");
        String string2 = object.getString(YoutubeParsingHelper.VIDEO_ID);
        return new Page("https://www.youtube.com/youtubei/v1/next?prettyPrint=false", null, null, map, JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(getExtractorLocalization(), getExtractorContentCountry()).value(YoutubeParsingHelper.VIDEO_ID, string2).value("playlistId", string).value("playlistIndex", object.getInt("index")).value("params", object.getString("params")).done()).getBytes(StandardCharsets.UTF_8));
    }

    private List<Image> getThumbnailsFromPlaylistId(String str) {
        return getThumbnailsFromVideoId(YoutubeParsingHelper.extractVideoIdFromMixId(str));
    }

    private List<Image> getThumbnailsFromVideoId(String str) {
        return (List) Collection$EL.stream(IMAGE_URL_SUFFIXES_AND_RESOLUTIONS).map(new j(com.github.catvod.spider.merge.b.b.A("https://i.ytimg.com/vi/", str, "/"), 0)).collect(Collectors.toUnmodifiableList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ YoutubeStreamInfoItemExtractor lambda$collectStreamsFrom$0(TimeAgoParser timeAgoParser, JsonObject jsonObject) {
        return new YoutubeStreamInfoItemExtractor(jsonObject.getObject("playlistPanelVideoRenderer"), timeAgoParser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Image lambda$getThumbnailsFromVideoId$1(String str, ImageSuffix imageSuffix) {
        return new Image(com.github.catvod.spider.merge.b.b.z(str, imageSuffix.getSuffix()), imageSuffix.getHeight(), imageSuffix.getWidth(), imageSuffix.getResolutionLevel());
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        collectStreamsFrom(streamInfoItemsCollector, this.playlistData.getArray("contents"));
        HashMap map = new HashMap();
        map.put(COOKIE_NAME, this.cookieValue);
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, getNextPageFrom(this.playlistData, map));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() throws ParsingException {
        String textAtKey = YoutubeParsingHelper.getTextAtKey(this.playlistData, "title");
        if (!Utils.isNullOrEmpty(textAtKey)) {
            return textAtKey;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get playlist name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't contain an URL");
            return null;
        }
        if (!page.getCookies().containsKey(COOKIE_NAME)) {
            com.github.catvod.spider.merge.s0.a.r("Cookie 'VISITOR_INFO1_LIVE' is missing");
            return null;
        }
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        JsonObject jsonObjectC = com.github.catvod.spider.merge.t0.a.c(JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(getDownloader().postWithContentTypeJson(page.getUrl(), YoutubeParsingHelper.getYouTubeHeaders(), page.getBody(), getExtractorLocalization()))), "contents", "twoColumnWatchNextResults", "playlist", "playlist");
        JsonArray array = jsonObjectC.getArray("contents");
        collectStreamsFrom(streamInfoItemsCollector, array.subList(jsonObjectC.getInt("currentIndex") + 1, array.size()));
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, getNextPageFrom(jsonObjectC, page.getCookies()));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public PlaylistInfo.PlaylistType getPlaylistType() {
        return YoutubeParsingHelper.extractPlaylistTypeFromPlaylistId(this.playlistData.getString("playlistId"));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public long getStreamCount() {
        return -2L;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getThumbnails() throws ParsingException {
        try {
            return getThumbnailsFromPlaylistId(this.playlistData.getString("playlistId"));
        } catch (Exception e) {
            try {
                return getThumbnailsFromVideoId(this.initialData.getObject("currentVideoEndpoint").getObject("watchEndpoint").getString(YoutubeParsingHelper.VIDEO_ID));
            } catch (Exception unused) {
                com.github.catvod.spider.merge.s0.a.m("Could not get playlist thumbnails", e);
                return null;
            }
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getUploaderAvatars() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderName() {
        return "YouTube";
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public boolean isUploaderVerified() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws MalformedURLException, ExtractionException {
        Localization extractorLocalization = getExtractorLocalization();
        URL urlStringToURL = Utils.stringToURL(getUrl());
        String id = getId();
        String queryValue = Utils.getQueryValue(urlStringToURL, "v");
        String queryValue2 = Utils.getQueryValue(urlStringToURL, "index");
        JsonBuilder<JsonObject> jsonBuilderValue = YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, getExtractorContentCountry()).value("playlistId", id);
        if (queryValue != null) {
            jsonBuilderValue.value(YoutubeParsingHelper.VIDEO_ID, queryValue);
        }
        if (queryValue2 != null) {
            jsonBuilderValue.value("playlistIndex", Integer.parseInt(queryValue2));
        }
        byte[] bytes = JsonWriter.string(jsonBuilderValue.done()).getBytes(StandardCharsets.UTF_8);
        Response responsePostWithContentTypeJson = getDownloader().postWithContentTypeJson("https://www.youtube.com/youtubei/v1/next?prettyPrint=false", YoutubeParsingHelper.getYouTubeHeaders(), bytes, extractorLocalization);
        JsonObject jsonObject = JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(responsePostWithContentTypeJson));
        this.initialData = jsonObject;
        JsonObject jsonObjectC = com.github.catvod.spider.merge.t0.a.c(jsonObject, "contents", "twoColumnWatchNextResults", "playlist", "playlist");
        this.playlistData = jsonObjectC;
        if (!Utils.isNullOrEmpty(jsonObjectC)) {
            this.cookieValue = YoutubeParsingHelper.extractCookieValue(COOKIE_NAME, responsePostWithContentTypeJson);
            return;
        }
        ExtractionException extractionException = new ExtractionException("Could not get playlistData");
        if (!YoutubeParsingHelper.isConsentAccepted()) {
            throw new ContentNotAvailableException("Consent is required in some countries to view Mix playlists", extractionException);
        }
        throw extractionException;
    }
}
