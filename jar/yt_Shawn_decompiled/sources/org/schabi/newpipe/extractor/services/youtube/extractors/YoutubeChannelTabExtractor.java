package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Optional;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeChannelTabExtractor extends ChannelTabExtractor {
    protected YoutubeChannelHelper.ChannelHeader channelHeader;
    private String channelId;
    private JsonObject jsonResponse;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$org$schabi$newpipe$extractor$services$youtube$extractors$YoutubeChannelTabExtractor$VerifiedStatus;

        static {
            int[] iArr = new int[VerifiedStatus.values().length];
            $SwitchMap$org$schabi$newpipe$extractor$services$youtube$extractors$YoutubeChannelTabExtractor$VerifiedStatus = iArr;
            try {
                iArr[VerifiedStatus.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$services$youtube$extractors$YoutubeChannelTabExtractor$VerifiedStatus[VerifiedStatus.UNVERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    enum VerifiedStatus {
        VERIFIED,
        UNVERIFIED,
        UNKNOWN
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class VideosTabExtractor extends YoutubeChannelTabExtractor {
        private final String channelId;
        private final String channelName;
        private final String channelUrl;
        private final JsonObject tabRenderer;

        public VideosTabExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, JsonObject jsonObject, YoutubeChannelHelper.ChannelHeader channelHeader, String str, String str2, String str3) {
            super(streamingService, listLinkHandler);
            this.channelHeader = channelHeader;
            this.tabRenderer = jsonObject;
            this.channelId = str2;
            this.channelName = str;
            this.channelUrl = str3;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor
        public String getChannelName() {
            return this.channelName;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor, org.schabi.newpipe.extractor.Extractor
        public String getId() {
            return this.channelId;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor
        public Optional<JsonObject> getTabData() {
            return Optional.of(this.tabRenderer);
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor, org.schabi.newpipe.extractor.Extractor
        public String getUrl() {
            return this.channelUrl;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor, org.schabi.newpipe.extractor.Extractor
        public void onFetchPage(Downloader downloader) {
        }
    }

    public YoutubeChannelTabExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: collectItem, reason: merged with bridge method [inline-methods] */
    public Optional<JsonObject> lambda$collectItemsFrom$6(MultiInfoItemsCollector multiInfoItemsCollector, JsonObject jsonObject, VerifiedStatus verifiedStatus, String str, String str2) {
        TimeAgoParser timeAgoParser = getTimeAgoParser();
        if (jsonObject.has("richItemRenderer")) {
            JsonObject object = jsonObject.getObject("richItemRenderer").getObject("content");
            if (object.has("videoRenderer")) {
                commitVideo(multiInfoItemsCollector, timeAgoParser, object.getObject("videoRenderer"), verifiedStatus, str, str2);
            } else if (object.has("reelItemRenderer")) {
                commitReel(multiInfoItemsCollector, object.getObject("reelItemRenderer"), verifiedStatus, str, str2);
            } else if (object.has("shortsLockupViewModel")) {
                commitShortsLockup(multiInfoItemsCollector, object.getObject("shortsLockupViewModel"), verifiedStatus, str, str2);
            } else if (object.has("playlistRenderer")) {
                commitPlaylist(multiInfoItemsCollector, object.getObject("playlistRenderer"), verifiedStatus, str, str2);
            } else if (object.has("lockupViewModel")) {
                commitLockup(multiInfoItemsCollector, verifiedStatus, str, str2, timeAgoParser, object);
            }
        } else if (jsonObject.has("gridVideoRenderer")) {
            commitVideo(multiInfoItemsCollector, timeAgoParser, jsonObject.getObject("gridVideoRenderer"), verifiedStatus, str, str2);
        } else if (jsonObject.has("gridPlaylistRenderer")) {
            commitPlaylist(multiInfoItemsCollector, jsonObject.getObject("gridPlaylistRenderer"), verifiedStatus, str, str2);
        } else if (jsonObject.has("gridShowRenderer")) {
            multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeGridShowRendererChannelInfoItemExtractor(jsonObject.getObject("gridShowRenderer"), verifiedStatus, str, str2, 0));
        } else {
            if (jsonObject.has("shelfRenderer")) {
                return lambda$collectItemsFrom$6(multiInfoItemsCollector, jsonObject.getObject("shelfRenderer").getObject("content"), verifiedStatus, str, str2);
            }
            if (jsonObject.has("itemSectionRenderer")) {
                return collectItemsFrom(multiInfoItemsCollector, jsonObject.getObject("itemSectionRenderer").getArray("contents"), verifiedStatus, str, str2);
            }
            if (jsonObject.has("horizontalListRenderer")) {
                return collectItemsFrom(multiInfoItemsCollector, jsonObject.getObject("horizontalListRenderer").getArray("items"), verifiedStatus, str, str2);
            }
            if (jsonObject.has("expandedShelfContentsRenderer")) {
                return collectItemsFrom(multiInfoItemsCollector, jsonObject.getObject("expandedShelfContentsRenderer").getArray("items"), verifiedStatus, str, str2);
            }
            if (jsonObject.has("lockupViewModel")) {
                commitLockup(multiInfoItemsCollector, verifiedStatus, str, str2, timeAgoParser, jsonObject);
            } else if (jsonObject.has("continuationItemRenderer")) {
                return Optional.ofNullable(jsonObject.getObject("continuationItemRenderer"));
            }
        }
        return Optional.empty();
    }

    private Optional<JsonObject> collectItemsFrom(MultiInfoItemsCollector multiInfoItemsCollector, JsonArray jsonArray, List<String> list) {
        YoutubeChannelTabExtractor youtubeChannelTabExtractor;
        MultiInfoItemsCollector multiInfoItemsCollector2;
        JsonArray jsonArray2;
        VerifiedStatus verifiedStatus;
        String str;
        String str2;
        VerifiedStatus verifiedStatusValueOf;
        if (list.size() >= 3) {
            String str3 = list.get(0);
            String str4 = list.get(1);
            try {
                verifiedStatusValueOf = VerifiedStatus.valueOf(list.get(2));
            } catch (IllegalArgumentException unused) {
                verifiedStatusValueOf = VerifiedStatus.UNKNOWN;
            }
            multiInfoItemsCollector2 = multiInfoItemsCollector;
            jsonArray2 = jsonArray;
            verifiedStatus = verifiedStatusValueOf;
            str = str3;
            str2 = str4;
            youtubeChannelTabExtractor = this;
        } else {
            youtubeChannelTabExtractor = this;
            multiInfoItemsCollector2 = multiInfoItemsCollector;
            jsonArray2 = jsonArray;
            verifiedStatus = VerifiedStatus.UNKNOWN;
            str = null;
            str2 = null;
        }
        return youtubeChannelTabExtractor.collectItemsFrom(multiInfoItemsCollector2, jsonArray2, verifiedStatus, str, str2);
    }

    private void commitLockup(MultiInfoItemsCollector multiInfoItemsCollector, VerifiedStatus verifiedStatus, String str, String str2, TimeAgoParser timeAgoParser, JsonObject jsonObject) {
        JsonObject object = jsonObject.getObject("lockupViewModel");
        String string = object.getString("contentType");
        if ("LOCKUP_CONTENT_TYPE_PLAYLIST".equals(string) || "LOCKUP_CONTENT_TYPE_PODCAST".equals(string)) {
            commitPlaylistLockup(multiInfoItemsCollector, object, verifiedStatus, str, str2);
        } else if ("LOCKUP_CONTENT_TYPE_VIDEO".equals(string)) {
            commitVideoLockup(multiInfoItemsCollector, timeAgoParser, object, verifiedStatus, str, str2);
        }
    }

    private void commitPlaylist(MultiInfoItemsCollector multiInfoItemsCollector, JsonObject jsonObject, final VerifiedStatus verifiedStatus, final String str, final String str2) {
        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubePlaylistInfoItemExtractor(jsonObject) { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor.6
            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubePlaylistInfoItemExtractor, org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
            public String getUploaderName() {
                return Utils.isNullOrEmpty(str) ? super.getUploaderName() : str;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubePlaylistInfoItemExtractor, org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
            public String getUploaderUrl() {
                return Utils.isNullOrEmpty(str2) ? super.getUploaderName() : str2;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubePlaylistInfoItemExtractor, org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
            public boolean isUploaderVerified() {
                int i = AnonymousClass7.$SwitchMap$org$schabi$newpipe$extractor$services$youtube$extractors$YoutubeChannelTabExtractor$VerifiedStatus[verifiedStatus.ordinal()];
                if (i == 1) {
                    return true;
                }
                if (i != 2) {
                    return super.isUploaderVerified();
                }
                return false;
            }
        });
    }

    private void commitPlaylistLockup(MultiInfoItemsCollector multiInfoItemsCollector, JsonObject jsonObject, final VerifiedStatus verifiedStatus, final String str, final String str2) {
        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeMixOrPlaylistLockupInfoItemExtractor(jsonObject) { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor.4
            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMixOrPlaylistLockupInfoItemExtractor, org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
            public String getUploaderName() {
                return Utils.isNullOrEmpty(str) ? super.getUploaderName() : str;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMixOrPlaylistLockupInfoItemExtractor, org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
            public String getUploaderUrl() {
                return Utils.isNullOrEmpty(str2) ? super.getUploaderName() : str2;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeMixOrPlaylistLockupInfoItemExtractor, org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
            public boolean isUploaderVerified() {
                int i = AnonymousClass7.$SwitchMap$org$schabi$newpipe$extractor$services$youtube$extractors$YoutubeChannelTabExtractor$VerifiedStatus[verifiedStatus.ordinal()];
                if (i == 1) {
                    return true;
                }
                if (i != 2) {
                    return super.isUploaderVerified();
                }
                return false;
            }
        });
    }

    private static void commitReel(MultiInfoItemsCollector multiInfoItemsCollector, JsonObject jsonObject, final VerifiedStatus verifiedStatus, final String str, final String str2) {
        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeReelInfoItemExtractor(jsonObject) { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor.1
            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeReelInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public String getUploaderName() {
                return Utils.isNullOrEmpty(str) ? super.getUploaderName() : str;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeReelInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public String getUploaderUrl() {
                return Utils.isNullOrEmpty(str2) ? super.getUploaderName() : str2;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeReelInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public boolean isUploaderVerified() {
                return verifiedStatus == VerifiedStatus.VERIFIED;
            }
        });
    }

    private static void commitShortsLockup(MultiInfoItemsCollector multiInfoItemsCollector, JsonObject jsonObject, final VerifiedStatus verifiedStatus, final String str, final String str2) {
        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeShortsLockupInfoItemExtractor(jsonObject) { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor.2
            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeShortsLockupInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public String getUploaderName() {
                return Utils.isNullOrEmpty(str) ? super.getUploaderName() : str;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeShortsLockupInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public String getUploaderUrl() {
                return Utils.isNullOrEmpty(str2) ? super.getUploaderName() : str2;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeShortsLockupInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public boolean isUploaderVerified() {
                return verifiedStatus == VerifiedStatus.VERIFIED;
            }
        });
    }

    private void commitVideo(MultiInfoItemsCollector multiInfoItemsCollector, TimeAgoParser timeAgoParser, JsonObject jsonObject, final VerifiedStatus verifiedStatus, final String str, final String str2) {
        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeStreamInfoItemExtractor(jsonObject, timeAgoParser) { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor.5
            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public String getUploaderName() {
                return Utils.isNullOrEmpty(str) ? super.getUploaderName() : str;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public String getUploaderUrl() {
                return Utils.isNullOrEmpty(str2) ? super.getUploaderName() : str2;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public boolean isUploaderVerified() {
                int i = AnonymousClass7.$SwitchMap$org$schabi$newpipe$extractor$services$youtube$extractors$YoutubeChannelTabExtractor$VerifiedStatus[verifiedStatus.ordinal()];
                if (i == 1) {
                    return true;
                }
                if (i != 2) {
                    return super.isUploaderVerified();
                }
                return false;
            }
        });
    }

    private static void commitVideoLockup(MultiInfoItemsCollector multiInfoItemsCollector, TimeAgoParser timeAgoParser, JsonObject jsonObject, final VerifiedStatus verifiedStatus, final String str, final String str2) {
        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new YoutubeStreamInfoItemLockupExtractor(jsonObject, timeAgoParser) { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor.3
            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public List<Image> getUploaderAvatars() {
                return Collections.EMPTY_LIST;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public String getUploaderName() {
                return Utils.isNullOrEmpty(str) ? super.getUploaderName() : str;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public String getUploaderUrl() {
                return Utils.isNullOrEmpty(str2) ? super.getUploaderName() : str2;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor
            public boolean isChannelOrCoursePlaylistLockupItem() {
                return true;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor, org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
            public boolean isUploaderVerified() {
                return verifiedStatus == VerifiedStatus.VERIFIED;
            }
        });
    }

    private String getChannelTabsParameters() throws ParsingException {
        String name;
        name = getName();
        name.getClass();
        switch (name) {
            case "playlists":
                return "EglwbGF5bGlzdHPyBgQKAkIA";
            case "albums":
                return "EghyZWxlYXNlc_IGBQoDsgEA";
            case "shorts":
                return "EgZzaG9ydHPyBgUKA5oBAA%3D%3D";
            case "videos":
                return "EgZ2aWRlb3PyBgQKAjoA";
            case "livestreams":
                return "EgdzdHJlYW1z8gYECgJ6AA%3D%3D";
            default:
                throw new ParsingException("Unsupported channel tab: ".concat(name));
        }
    }

    private Page getNextPageFrom(JsonObject jsonObject, List<String> list) {
        if (Utils.isNullOrEmpty(jsonObject)) {
            return null;
        }
        return new Page("https://www.youtube.com/youtubei/v1/browse?prettyPrint=false", null, list, null, JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(getExtractorLocalization(), getExtractorContentCountry()).value("continuation", jsonObject.getObject("continuationEndpoint").getObject("continuationCommand").getString("token")).done()).getBytes(StandardCharsets.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Optional lambda$collectItemsFrom$7(Optional optional) {
        return optional;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Optional lambda$collectItemsFrom$8(Optional optional, Optional optional2) {
        return optional.or(new e(0, optional2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPage$0(JsonObject jsonObject) {
        return jsonObject.has("appendContinuationItemsAction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getPage$1(JsonObject jsonObject) {
        return jsonObject.getObject("appendContinuationItemsAction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTabData$2(JsonObject jsonObject) {
        return jsonObject.has("tabRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getTabData$3(JsonObject jsonObject) {
        return jsonObject.getObject("tabRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTabData$4(String str, JsonObject jsonObject) {
        return jsonObject.getObject("endpoint").getObject("commandMetadata").getObject("webCommandMetadata").getString("url", VideoStream.RESOLUTION_UNKNOWN).endsWith(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTabData$5(JsonObject jsonObject) {
        JsonArray array = jsonObject.getObject("content").getObject("sectionListRenderer").getArray("contents").getObject(0).getObject("itemSectionRenderer").getArray("contents");
        return (array.size() == 1 && array.getObject(0).has("messageRenderer")) ? false : true;
    }

    public String getChannelName() {
        return YoutubeChannelHelper.getChannelName(this.channelHeader, YoutubeChannelHelper.getChannelAgeGateRenderer(this.jsonResponse), this.jsonResponse);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getId() {
        return YoutubeChannelHelper.getChannelId(this.channelHeader, this.jsonResponse, this.channelId);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        JsonArray jsonArray;
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        JsonArray jsonArray2 = new JsonArray();
        Optional<JsonObject> tabData = getTabData();
        if (tabData.isPresent()) {
            JsonObject object = tabData.get().getObject("content");
            JsonArray array = object.getObject("sectionListRenderer").getArray("contents").getObject(0).getObject("itemSectionRenderer").getArray("contents").getObject(0).getObject("gridRenderer").getArray("items");
            if (array.isEmpty()) {
                array = object.getObject("richGridRenderer").getArray("contents");
                if (array.isEmpty()) {
                    jsonArray2 = object.getObject("sectionListRenderer").getArray("contents");
                    jsonArray = jsonArray2;
                }
            }
            jsonArray = array;
        } else {
            jsonArray = jsonArray2;
        }
        YoutubeChannelHelper.ChannelHeader channelHeader = this.channelHeader;
        VerifiedStatus verifiedStatus = channelHeader == null ? VerifiedStatus.UNKNOWN : YoutubeChannelHelper.isChannelVerified(channelHeader) ? VerifiedStatus.VERIFIED : VerifiedStatus.UNVERIFIED;
        String channelName = getChannelName();
        String url = getUrl();
        JsonObject jsonObjectOrElse = collectItemsFrom(multiInfoItemsCollector, jsonArray, verifiedStatus, channelName, url).orElse(null);
        Object[] objArr = {channelName, url, verifiedStatus.toString()};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, getNextPageFrom(jsonObjectOrElse, DesugarCollections.unmodifiableList(arrayList)));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) {
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't contain an URL");
            return null;
        }
        List<String> ids = page.getIds();
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, getNextPageFrom(collectItemsFrom(multiInfoItemsCollector, ((JsonObject) YoutubeParsingHelper.getJsonPostResponse("browse", page.getBody(), getExtractorLocalization()).getArray("onResponseReceivedActions").streamAsJsonObjects().filter(new n(5)).map(new h(9)).findFirst().orElse(new JsonObject())).getArray("continuationItems"), ids).orElse(null), ids));
    }

    public Optional<JsonObject> getTabData() {
        return this.jsonResponse.getObject("contents").getObject("twoColumnBrowseResultsRenderer").getArray("tabs").streamAsJsonObjects().filter(new n(3)).map(new h(8)).filter(new d(YoutubeChannelTabLinkHandlerFactory.getUrlSuffix(getName()), 0)).findFirst().filter(new n(4));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getUrl() {
        try {
            YoutubeChannelTabLinkHandlerFactory youtubeChannelTabLinkHandlerFactory = YoutubeChannelTabLinkHandlerFactory.getInstance();
            String str = "channel/" + getId();
            Object[] objArr = {getName()};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            return youtubeChannelTabLinkHandlerFactory.getUrl(str, DesugarCollections.unmodifiableList(arrayList), VideoStream.RESOLUTION_UNKNOWN);
        } catch (ParsingException unused) {
            return super.getUrl();
        }
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        YoutubeChannelHelper.ChannelResponseData channelResponse = YoutubeChannelHelper.getChannelResponse(YoutubeChannelHelper.resolveChannelId(super.getId()), getChannelTabsParameters(), getExtractorLocalization(), getExtractorContentCountry());
        JsonObject jsonObject = channelResponse.jsonResponse;
        this.jsonResponse = jsonObject;
        this.channelHeader = YoutubeChannelHelper.getChannelHeader(jsonObject);
        this.channelId = channelResponse.channelId;
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    final class YoutubeGridShowRendererChannelInfoItemExtractor extends YoutubeBaseShowInfoItemExtractor {
        private final String channelName;
        private final String channelUrl;
        private final VerifiedStatus verifiedStatus;

        private YoutubeGridShowRendererChannelInfoItemExtractor(JsonObject jsonObject, VerifiedStatus verifiedStatus, String str, String str2) {
            super(jsonObject);
            this.verifiedStatus = verifiedStatus;
            this.channelName = str;
            this.channelUrl = str2;
        }

        @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
        public String getUploaderName() {
            return this.channelName;
        }

        @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
        public String getUploaderUrl() {
            return this.channelUrl;
        }

        @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
        public boolean isUploaderVerified() throws ParsingException {
            int i = AnonymousClass7.$SwitchMap$org$schabi$newpipe$extractor$services$youtube$extractors$YoutubeChannelTabExtractor$VerifiedStatus[this.verifiedStatus.ordinal()];
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            org.schabi.newpipe.extractor.utils.c.a("Could not get uploader verification status");
            return false;
        }

        public /* synthetic */ YoutubeGridShowRendererChannelInfoItemExtractor(JsonObject jsonObject, VerifiedStatus verifiedStatus, String str, String str2, int i) {
            this(jsonObject, verifiedStatus, str, str2);
        }
    }

    private Optional<JsonObject> collectItemsFrom(MultiInfoItemsCollector multiInfoItemsCollector, JsonArray jsonArray, VerifiedStatus verifiedStatus, String str, String str2) {
        return (Optional) jsonArray.streamAsJsonObjects().map(new f(this, multiInfoItemsCollector, verifiedStatus, str, str2)).reduce(Optional.empty(), new g());
    }
}
