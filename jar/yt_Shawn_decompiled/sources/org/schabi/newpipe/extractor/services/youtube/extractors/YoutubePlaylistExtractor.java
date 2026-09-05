package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Base64;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubePlaylistExtractor extends PlaylistExtractor {
    private static final String APPEND_CONTINUATION_ITEMS_ACTION = "appendContinuationItemsAction";
    private static final String BROWSE_ENDPOINT = "browse";
    private static final String COMMAND_EXECUTOR_COMMAND = "commandExecutorCommand";
    private static final String CONTINUATION_COMMAND = "continuationCommand";
    private static final String CONTINUATION_ITEMS = "continuationItems";
    private static final String HEADER = "header";
    private static final String LOCKUP_VIEW_MODEL = "lockupViewModel";
    private static final String MICROFORMAT = "microformat";
    private static final String ON_RESPONSE_RECEIVED_ACTIONS = "onResponseReceivedActions";
    private static final String PLAYLIST_CONTINUATION_PROPERTIES_BASE64 = "CADCBgIIAA%3D%3D";
    private static final String PLAYLIST_VIDEO_RENDERER = "playlistVideoRenderer";
    private static final String REEL_ITEM_RENDERER = "reelItemRenderer";
    private static final String RICH_ITEM_RENDERER = "richItemRenderer";
    private static final String SIDEBAR = "sidebar";
    private static final String THUMBNAIL = "thumbnail";
    private static final String THUMBNAILS = "thumbnails";
    private static final String TITLE = "title";
    private static final String VIDEO_OWNER_RENDERER = "videoOwnerRenderer";
    private JsonObject browseMetadataResponse;
    private JsonObject initialBrowseContinuationResponse;
    private boolean isNewPlaylistInterface;
    private JsonObject playlistHeader;
    private JsonObject playlistInfo;
    private JsonObject uploaderInfo;

    public YoutubePlaylistExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    private boolean checkIfResponseIsNewPlaylistInterface() {
        return this.browseMetadataResponse.has(HEADER) && !this.browseMetadataResponse.has(SIDEBAR);
    }

    private void collectStreamsFrom(final StreamInfoItemsCollector streamInfoItemsCollector, JsonArray jsonArray, final boolean z) {
        final TimeAgoParser timeAgoParser = getTimeAgoParser();
        jsonArray.streamAsJsonObjects().forEach(new Consumer() { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.lambda$collectStreamsFrom$8(streamInfoItemsCollector, timeAgoParser, z, this, (JsonObject) obj);
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
    }

    private Page getNextPageFrom(JsonArray jsonArray, boolean z) {
        String string;
        if (Utils.isNullOrEmpty(jsonArray)) {
            return null;
        }
        JsonObject object = jsonArray.getObject(jsonArray.size() - 1);
        if (object.has("continuationItemRenderer")) {
            JsonObject object2 = object.getObject("continuationItemRenderer").getObject("continuationEndpoint");
            if (object2.has(COMMAND_EXECUTOR_COMMAND)) {
                object2 = object2.getObject(COMMAND_EXECUTOR_COMMAND).getArray("commands").streamAsJsonObjects().filter(new n(13)).findFirst().orElse(new JsonObject());
            }
            string = object2.getObject(CONTINUATION_COMMAND).getString("token");
        } else {
            if (!object.has("continuationItemViewModel")) {
                return null;
            }
            string = com.github.catvod.spider.merge.t0.a.c(object, "continuationItemViewModel", CONTINUATION_COMMAND, "innertubeCommand", CONTINUATION_COMMAND).getString("token");
        }
        if (Utils.isNullOrEmpty(string)) {
            return null;
        }
        return new Page("https://www.youtube.com/youtubei/v1/browse?prettyPrint=false", String.valueOf(z), JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(getExtractorLocalization(), getExtractorContentCountry()).value("continuation", string).done()).getBytes(StandardCharsets.UTF_8));
    }

    private JsonObject getPlaylistHeader() {
        if (this.playlistHeader == null) {
            this.playlistHeader = this.browseMetadataResponse.getObject(HEADER).getObject("playlistHeaderRenderer");
        }
        return this.playlistHeader;
    }

    private JsonObject getPlaylistInfo() {
        if (this.playlistInfo == null) {
            int i = 15;
            this.playlistInfo = (JsonObject) this.browseMetadataResponse.getObject(SIDEBAR).getObject("playlistSidebarRenderer").getArray("items").streamAsJsonObjects().filter(new n(i)).map(new h(i)).findFirst().orElseThrow(new i(7));
        }
        return this.playlistInfo;
    }

    private JsonObject getUploaderInfo() {
        if (this.uploaderInfo == null) {
            int i = 14;
            this.uploaderInfo = (JsonObject) this.browseMetadataResponse.getObject(SIDEBAR).getObject("playlistSidebarRenderer").getArray("items").streamAsJsonObjects().filter(new n(i)).map(new h(i)).findFirst().orElseThrow(new i(6));
        }
        return this.uploaderInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$collectStreamsFrom$8(StreamInfoItemsCollector streamInfoItemsCollector, TimeAgoParser timeAgoParser, final boolean z, final PlaylistExtractor playlistExtractor, JsonObject jsonObject) {
        if (jsonObject.has(PLAYLIST_VIDEO_RENDERER)) {
            streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeStreamInfoItemExtractor(jsonObject.getObject(PLAYLIST_VIDEO_RENDERER), timeAgoParser) { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubePlaylistExtractor.1
                @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
                public String getUploaderName() {
                    return z ? playlistExtractor.getUploaderName() : super.getUploaderName();
                }

                @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
                public String getUploaderUrl() {
                    return z ? playlistExtractor.getUploaderUrl() : super.getUploaderUrl();
                }
            });
            return;
        }
        if (!jsonObject.has(RICH_ITEM_RENDERER)) {
            if (jsonObject.has(LOCKUP_VIEW_MODEL)) {
                streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeStreamInfoItemLockupExtractor(jsonObject.getObject(LOCKUP_VIEW_MODEL), timeAgoParser) { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubePlaylistExtractor.2
                    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
                    public String getUploaderName() {
                        return z ? playlistExtractor.getUploaderName() : super.getUploaderName();
                    }

                    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
                    public String getUploaderUrl() {
                        return z ? playlistExtractor.getUploaderUrl() : super.getUploaderUrl();
                    }

                    @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor
                    public boolean isChannelOrCoursePlaylistLockupItem() {
                        return z;
                    }
                });
                return;
            }
            return;
        }
        JsonObject object = jsonObject.getObject(RICH_ITEM_RENDERER);
        if (object.has("content")) {
            JsonObject object2 = object.getObject("content");
            if (object2.has(REEL_ITEM_RENDERER)) {
                streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeReelInfoItemExtractor(object2.getObject(REEL_ITEM_RENDERER)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInitialPage$6(JsonObject jsonObject) {
        return "engagement-panel-course-metadata".equals(jsonObject.getObject("showEngagementPanelEndpoint").getObject("identifier").getString("tag"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getNextPageFrom$7(JsonObject jsonObject) {
        return jsonObject.has(CONTINUATION_COMMAND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPlaylistInfo$3(JsonObject jsonObject) {
        return jsonObject.has("playlistSidebarPrimaryInfoRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getPlaylistInfo$4(JsonObject jsonObject) {
        return jsonObject.getObject("playlistSidebarPrimaryInfoRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getPlaylistInfo$5() {
        return new ParsingException("Could not get playlist info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getUploaderInfo$0(JsonObject jsonObject) {
        return jsonObject.getObject("playlistSidebarSecondaryInfoRenderer").getObject("videoOwner").has(VIDEO_OWNER_RENDERER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getUploaderInfo$1(JsonObject jsonObject) {
        return jsonObject.getObject("playlistSidebarSecondaryInfoRenderer").getObject("videoOwner").getObject(VIDEO_OWNER_RENDERER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getUploaderInfo$2() {
        return new ParsingException("Could not get uploader info");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public Description getDescription() {
        return new Description(YoutubeParsingHelper.getTextFromObject(getPlaylistInfo().getObject("description"), true), 1);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        JsonArray array = this.initialBrowseContinuationResponse.getArray(ON_RESPONSE_RECEIVED_ACTIONS).getObject(0).getObject("reloadContinuationItemsCommand").getArray(CONTINUATION_ITEMS);
        if (array.isEmpty()) {
            array = this.initialBrowseContinuationResponse.getArray(ON_RESPONSE_RECEIVED_ACTIONS).getObject(0).getObject(APPEND_CONTINUATION_ITEMS_ACTION).getArray(CONTINUATION_ITEMS);
        }
        boolean zAnyMatch = getPlaylistHeader().getObject("onDescriptionTap").getObject(COMMAND_EXECUTOR_COMMAND).getArray("commands").streamAsJsonObjects().anyMatch(new n(12));
        collectStreamsFrom(streamInfoItemsCollector, array, zAnyMatch);
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, getNextPageFrom(array, zAnyMatch));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(getPlaylistInfo().getObject(TITLE));
        return !Utils.isNullOrEmpty(textFromObject) ? textFromObject : this.browseMetadataResponse.getObject(MICROFORMAT).getObject("microformatDataRenderer").getString(TITLE);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't contain an URL");
            return null;
        }
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        JsonArray array = YoutubeParsingHelper.getJsonPostResponse(BROWSE_ENDPOINT, page.getBody(), getExtractorLocalization()).getArray(ON_RESPONSE_RECEIVED_ACTIONS).getObject(0).getObject(APPEND_CONTINUATION_ITEMS_ACTION).getArray(CONTINUATION_ITEMS);
        boolean z = Boolean.parseBoolean(page.getId());
        collectStreamsFrom(streamInfoItemsCollector, array, z);
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, getNextPageFrom(array, z));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public PlaylistInfo.PlaylistType getPlaylistType() {
        return YoutubeParsingHelper.extractPlaylistTypeFromPlaylistUrl(getUrl());
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public long getStreamCount() {
        String textFromObject;
        String textFromObject2;
        if (this.isNewPlaylistInterface) {
            String textFromObject3 = YoutubeParsingHelper.getTextFromObject(getPlaylistHeader().getObject("numVideosText"));
            if (textFromObject3 != null) {
                try {
                    return Long.parseLong(Utils.removeNonDigitCharacters(textFromObject3));
                } catch (NumberFormatException unused) {
                }
            }
            String textFromObject4 = YoutubeParsingHelper.getTextFromObject(getPlaylistHeader().getArray("byline").getObject(0).getObject("text"));
            if (textFromObject4 != null) {
                try {
                    return Long.parseLong(Utils.removeNonDigitCharacters(textFromObject4));
                } catch (NumberFormatException unused2) {
                }
            }
        }
        JsonArray array = (this.isNewPlaylistInterface ? getPlaylistHeader() : getPlaylistInfo()).getArray("briefStats");
        if (!array.isEmpty() && (textFromObject2 = YoutubeParsingHelper.getTextFromObject(array.getObject(0))) != null) {
            return Long.parseLong(Utils.removeNonDigitCharacters(textFromObject2));
        }
        JsonArray array2 = (this.isNewPlaylistInterface ? getPlaylistHeader() : getPlaylistInfo()).getArray("stats");
        if (array2.isEmpty() || (textFromObject = YoutubeParsingHelper.getTextFromObject(array2.getObject(0))) == null) {
            return -1L;
        }
        return Long.parseLong(Utils.removeNonDigitCharacters(textFromObject));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getThumbnails() throws ParsingException {
        JsonArray array = this.isNewPlaylistInterface ? getPlaylistHeader().getObject("playlistHeaderBanner").getObject("heroPlaylistThumbnailRenderer").getObject(THUMBNAIL).getArray(THUMBNAILS) : this.playlistInfo.getObject("thumbnailRenderer").getObject("playlistVideoThumbnailRenderer").getObject(THUMBNAIL).getArray(THUMBNAILS);
        if (!Utils.isNullOrEmpty(array)) {
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(array);
        }
        JsonArray array2 = this.browseMetadataResponse.getObject(MICROFORMAT).getObject("microformatDataRenderer").getObject(THUMBNAIL).getArray(THUMBNAILS);
        if (!Utils.isNullOrEmpty(array2)) {
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(array2);
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get playlist thumbnails");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getUploaderAvatars() throws ParsingException {
        if (this.isNewPlaylistInterface) {
            return Collections.EMPTY_LIST;
        }
        try {
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(getUploaderInfo().getObject(THUMBNAIL).getArray(THUMBNAILS));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get playlist uploader avatars", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderName() throws ParsingException {
        try {
            return YoutubeParsingHelper.getTextFromObject(this.isNewPlaylistInterface ? getPlaylistHeader().getObject("ownerText") : getUploaderInfo().getObject(TITLE));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get playlist uploader name", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderUrl() throws ParsingException {
        try {
            return YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.isNewPlaylistInterface ? getPlaylistHeader().getObject("ownerText").getArray("runs").getObject(0).getObject("navigationEndpoint") : getUploaderInfo().getObject("navigationEndpoint"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get playlist uploader url", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public boolean isUploaderVerified() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        String id = getId();
        Localization extractorLocalization = getExtractorLocalization();
        String strString = JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, getExtractorContentCountry()).value("browseId", "VL" + id).value("params", "wgYCCAA%3D").done());
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = strString.getBytes(charset);
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{"$fields=sidebar,header,microformat,alerts"}[0];
        JsonObject jsonPostResponse = YoutubeParsingHelper.getJsonPostResponse(BROWSE_ENDPOINT, com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList), bytes, extractorLocalization);
        this.browseMetadataResponse = jsonPostResponse;
        YoutubeParsingHelper.defaultAlertsCheck(jsonPostResponse);
        this.isNewPlaylistInterface = checkIfResponseIsNewPlaylistInterface();
        this.initialBrowseContinuationResponse = YoutubeParsingHelper.getJsonPostResponse(BROWSE_ENDPOINT, JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, getExtractorContentCountry()).value("continuation", Utils.encodeUrlUtf8(Base64.getUrlEncoder().encodeToString(((PlaylistProtobufContinuation.PlaylistContinuation) PlaylistProtobufContinuation.PlaylistContinuation.newBuilder().setParameters((PlaylistProtobufContinuation.ContinuationParams) PlaylistProtobufContinuation.ContinuationParams.newBuilder().setBrowseId("VL" + id).setPlaylistId(id).setContinuationProperties(PLAYLIST_CONTINUATION_PROPERTIES_BASE64).build()).build()).toByteArray()))).done()).getBytes(charset), extractorLocalization);
    }
}
