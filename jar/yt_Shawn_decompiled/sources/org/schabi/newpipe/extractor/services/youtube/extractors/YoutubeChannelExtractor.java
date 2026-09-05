package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler;
import org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelTabExtractor;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeChannelExtractor extends ChannelExtractor {
    private static final String AVATAR = "avatar";
    private static final String BANNER = "banner";
    private static final String CONTENT = "content";
    private static final String CONTENTS = "contents";
    private static final String CONTENT_PREVIEW_IMAGE_VIEW_MODEL = "contentPreviewImageViewModel";
    private static final String IMAGE = "image";
    private static final String METADATA = "metadata";
    private static final String PAGE_HEADER_VIEW_MODEL = "pageHeaderViewModel";
    private static final String SOURCES = "sources";
    private static final String TAB_RENDERER = "tabRenderer";
    private static final String THUMBNAILS = "thumbnails";
    private JsonObject channelAgeGateRenderer;
    private YoutubeChannelHelper.ChannelHeader channelHeader;
    private String channelId;
    private JsonObject jsonResponse;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelExtractor$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType;

        static {
            int[] iArr = new int[YoutubeChannelHelper.ChannelHeader.HeaderType.values().length];
            $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType = iArr;
            try {
                iArr[YoutubeChannelHelper.ChannelHeader.HeaderType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[YoutubeChannelHelper.ChannelHeader.HeaderType.INTERACTIVE_TABBED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[YoutubeChannelHelper.ChannelHeader.HeaderType.C4_TABBED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[YoutubeChannelHelper.ChannelHeader.HeaderType.CAROUSEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public YoutubeChannelExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    private long getSubscriberCountFromPageChannelHeader(JsonObject jsonObject) throws ParsingException {
        JsonObject object = jsonObject.getObject(CONTENT).getObject(PAGE_HEADER_VIEW_MODEL).getObject(METADATA);
        if (!object.has("contentMetadataViewModel")) {
            return -1L;
        }
        JsonArray array = object.getObject("contentMetadataViewModel").getArray("metadataRows").getObject(Math.max(0, r7.size() - 1)).getArray("metadataParts");
        if (array.size() < 2) {
            return -1L;
        }
        try {
            return Utils.mixedNumberWordToLong(array.getObject(0).getObject("text").getString(CONTENT));
        } catch (NumberFormatException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get subscriber count", e);
            return 0L;
        }
    }

    private List<ListLinkHandler> getTabsForAgeRestrictedChannels() {
        ArrayList arrayList = new ArrayList();
        String url = getUrl();
        lambda$getTabsForAgeRestrictedChannels$8(arrayList, url, "videos");
        lambda$getTabsForAgeRestrictedChannels$8(arrayList, url, ChannelTabs.SHORTS);
        lambda$getTabsForAgeRestrictedChannels$8(arrayList, url, ChannelTabs.LIVESTREAMS);
        return DesugarCollections.unmodifiableList(arrayList);
    }

    private List<ListLinkHandler> getTabsForNonAgeRestrictedChannels() {
        JsonArray array = this.jsonResponse.getObject(CONTENTS).getObject("twoColumnBrowseResultsRenderer").getArray("tabs");
        final ArrayList arrayList = new ArrayList();
        final org.schabi.newpipe.extractor.services.soundcloud.extractors.a aVar = new org.schabi.newpipe.extractor.services.soundcloud.extractors.a(2, this, arrayList);
        final String name = getName();
        final String url = getUrl();
        final String id = getId();
        array.streamAsJsonObjects().filter(new n(1)).map(new h(4)).forEach(new Consumer() { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.lambda$getTabsForNonAgeRestrictedChannels$7(arrayList, name, id, url, aVar, (JsonObject) obj);
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        return DesugarCollections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getAvatars$0() {
        return new ParsingException("Could not get avatars");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonArray lambda$getAvatars$1(YoutubeChannelHelper.ChannelHeader channelHeader) {
        int i = AnonymousClass1.$SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[channelHeader.headerType.ordinal()];
        if (i != 1) {
            JsonObject jsonObject = channelHeader.json;
            return i != 2 ? jsonObject.getObject(AVATAR).getArray(THUMBNAILS) : jsonObject.getObject("boxArt").getArray(THUMBNAILS);
        }
        JsonObject object = channelHeader.json.getObject(CONTENT).getObject(PAGE_HEADER_VIEW_MODEL).getObject(IMAGE);
        return object.has(CONTENT_PREVIEW_IMAGE_VIEW_MODEL) ? object.getObject(CONTENT_PREVIEW_IMAGE_VIEW_MODEL).getObject(IMAGE).getArray(SOURCES) : object.has("decoratedAvatarViewModel") ? com.github.catvod.spider.merge.t0.a.c(object, "decoratedAvatarViewModel", AVATAR, "avatarViewModel", IMAGE).getArray(SOURCES) : new JsonArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getAvatars$2() {
        return new ParsingException("Could not get avatars");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonArray lambda$getBanners$3(YoutubeChannelHelper.ChannelHeader channelHeader) {
        YoutubeChannelHelper.ChannelHeader.HeaderType headerType = channelHeader.headerType;
        YoutubeChannelHelper.ChannelHeader.HeaderType headerType2 = YoutubeChannelHelper.ChannelHeader.HeaderType.PAGE;
        JsonObject jsonObject = channelHeader.json;
        if (headerType != headerType2) {
            return jsonObject.getObject(BANNER).getArray(THUMBNAILS);
        }
        JsonObject object = jsonObject.getObject(CONTENT).getObject(PAGE_HEADER_VIEW_MODEL);
        return object.has(BANNER) ? object.getObject(BANNER).getObject("imageBannerViewModel").getObject(IMAGE).getArray(SOURCES) : new JsonArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTabsForAgeRestrictedChannels$8(List list, String str, String str2) {
        list.add(new ReadyChannelTabListLinkHandler(com.github.catvod.spider.merge.b.b.o(str, "/", str2), this.channelId, str2, new c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ChannelTabExtractor lambda$getTabsForNonAgeRestrictedChannels$3bf8a84$1(JsonObject jsonObject, YoutubeChannelHelper.ChannelHeader channelHeader, String str, String str2, String str3, StreamingService streamingService, ListLinkHandler listLinkHandler) {
        return new YoutubeChannelTabExtractor.VideosTabExtractor(streamingService, listLinkHandler, jsonObject, channelHeader, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTabsForNonAgeRestrictedChannels$4(List list, String str) {
        try {
            YoutubeChannelTabLinkHandlerFactory youtubeChannelTabLinkHandlerFactory = YoutubeChannelTabLinkHandlerFactory.getInstance();
            String str2 = this.channelId;
            Object[] objArr = {str};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            list.add(youtubeChannelTabLinkHandlerFactory.fromQuery(str2, DesugarCollections.unmodifiableList(arrayList), VideoStream.RESOLUTION_UNKNOWN));
        } catch (ParsingException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTabsForNonAgeRestrictedChannels$5(JsonObject jsonObject) {
        return jsonObject.has(TAB_RENDERER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getTabsForNonAgeRestrictedChannels$6(JsonObject jsonObject) {
        return jsonObject.getObject(TAB_RENDERER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void lambda$getTabsForNonAgeRestrictedChannels$7(java.util.List r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.util.function.Consumer r17, com.grack.nanojson.JsonObject r18) {
        /*
            r12 = this;
            r0 = r17
            java.lang.String r1 = "endpoint"
            r3 = r18
            com.grack.nanojson.JsonObject r1 = r3.getObject(r1)
            java.lang.String r2 = "commandMetadata"
            com.grack.nanojson.JsonObject r1 = r1.getObject(r2)
            java.lang.String r2 = "webCommandMetadata"
            com.grack.nanojson.JsonObject r1 = r1.getObject(r2)
            java.lang.String r2 = "url"
            java.lang.String r1 = r1.getString(r2)
            if (r1 == 0) goto Lab
            java.lang.String r2 = "/"
            java.lang.String[] r2 = r1.split(r2)
            int r4 = r2.length
            if (r4 != 0) goto L29
            goto Lab
        L29:
            int r4 = r2.length
            r5 = 1
            int r4 = r4 - r5
            r2 = r2[r4]
            org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper$ChannelHeader r4 = r12.channelHeader
            if (r4 != 0) goto L34
            r4 = 0
            goto L3e
        L34:
            org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper$ChannelHeader r6 = new org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper$ChannelHeader
            com.grack.nanojson.JsonObject r7 = r4.json
            org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper$ChannelHeader$HeaderType r4 = r4.headerType
            r6.<init>(r7, r4)
            r4 = r6
        L3e:
            r2.getClass()
            int r6 = r2.hashCode()
            java.lang.String r8 = "videos"
            java.lang.String r7 = "shorts"
            java.lang.String r9 = "playlists"
            r10 = 0
            r11 = -1
            switch(r6) {
                case -1881890573: goto L76;
                case -1865828127: goto L6f;
                case -903148681: goto L66;
                case -816678056: goto L5d;
                case -551298740: goto L52;
                default: goto L50;
            }
        L50:
            r5 = -1
            goto L80
        L52:
            java.lang.String r5 = "releases"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L5b
            goto L50
        L5b:
            r5 = 4
            goto L80
        L5d:
            boolean r2 = r2.equals(r8)
            if (r2 != 0) goto L64
            goto L50
        L64:
            r5 = 3
            goto L80
        L66:
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L6d
            goto L50
        L6d:
            r5 = 2
            goto L80
        L6f:
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L80
            goto L50
        L76:
            java.lang.String r5 = "streams"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L7f
            goto L50
        L7f:
            r5 = 0
        L80:
            switch(r5) {
                case 0: goto La6;
                case 1: goto La2;
                case 2: goto L9e;
                case 3: goto L8a;
                case 4: goto L84;
                default: goto L83;
            }
        L83:
            goto Lab
        L84:
            java.lang.String r13 = "albums"
            r0.accept(r13)
            return
        L8a:
            org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler r0 = new org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler
            java.lang.String r9 = r12.channelId
            org.schabi.newpipe.extractor.services.youtube.extractors.a r2 = new org.schabi.newpipe.extractor.services.youtube.extractors.a
            r5 = r14
            r6 = r15
            r7 = r16
            r2.<init>(r3, r4, r5, r6, r7)
            r0.<init>(r1, r9, r8, r2)
            r13.add(r10, r0)
            return
        L9e:
            r0.accept(r7)
            return
        La2:
            r0.accept(r9)
            return
        La6:
            java.lang.String r13 = "livestreams"
            r0.accept(r13)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeChannelExtractor.lambda$getTabsForNonAgeRestrictedChannels$7(java.util.List, java.lang.String, java.lang.String, java.lang.String, java.util.function.Consumer, com.grack.nanojson.JsonObject):void");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getAvatars() {
        assertPageFetched();
        JsonObject jsonObject = this.channelAgeGateRenderer;
        return jsonObject != null ? (List) Optional.ofNullable(jsonObject.getObject(AVATAR).getArray(THUMBNAILS)).map(new h(6)).orElseThrow(new i(1)) : (List) Optional.ofNullable(this.channelHeader).map(new h(3)).map(new h(6)).orElseThrow(new i(2));
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getBanners() {
        assertPageFetched();
        return this.channelAgeGateRenderer != null ? Collections.EMPTY_LIST : (List) Optional.ofNullable(this.channelHeader).map(new h(5)).map(new h(6)).orElse(Collections.EMPTY_LIST);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getDescription() throws ParsingException {
        assertPageFetched();
        if (this.channelAgeGateRenderer != null) {
            return null;
        }
        try {
            YoutubeChannelHelper.ChannelHeader channelHeader = this.channelHeader;
            return (channelHeader == null || channelHeader.headerType != YoutubeChannelHelper.ChannelHeader.HeaderType.INTERACTIVE_TABBED) ? this.jsonResponse.getObject(METADATA).getObject("channelMetadataRenderer").getString("description") : YoutubeParsingHelper.getTextFromObject(channelHeader.json.getObject("description"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get channel description", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getFeedUrl() throws ParsingException {
        try {
            return YoutubeParsingHelper.getFeedUrlFrom(getId());
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get feed URL", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getId() {
        assertPageFetched();
        return YoutubeChannelHelper.getChannelId(this.channelHeader, this.jsonResponse, this.channelId);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        assertPageFetched();
        return YoutubeChannelHelper.getChannelName(this.channelHeader, this.channelAgeGateRenderer, this.jsonResponse);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getParentChannelAvatars() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getParentChannelName() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getParentChannelUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public long getSubscriberCount() throws ParsingException {
        YoutubeChannelHelper.ChannelHeader channelHeader;
        YoutubeChannelHelper.ChannelHeader.HeaderType headerType;
        assertPageFetched();
        if (this.channelAgeGateRenderer != null || (channelHeader = this.channelHeader) == null || (headerType = channelHeader.headerType) == YoutubeChannelHelper.ChannelHeader.HeaderType.INTERACTIVE_TABBED) {
            return -1L;
        }
        JsonObject jsonObject = channelHeader.json;
        if (headerType == YoutubeChannelHelper.ChannelHeader.HeaderType.PAGE) {
            return getSubscriberCountFromPageChannelHeader(jsonObject);
        }
        JsonObject object = jsonObject.has("subscriberCountText") ? jsonObject.getObject("subscriberCountText") : jsonObject.has("subtitle") ? jsonObject.getObject("subtitle") : null;
        if (object != null) {
            try {
                return Utils.mixedNumberWordToLong(YoutubeParsingHelper.getTextFromObject(object));
            } catch (NumberFormatException e) {
                com.github.catvod.spider.merge.s0.a.m("Could not get subscriber count", e);
                return 0L;
            }
        }
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<ListLinkHandler> getTabs() {
        assertPageFetched();
        return this.channelAgeGateRenderer == null ? getTabsForNonAgeRestrictedChannels() : getTabsForAgeRestrictedChannels();
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<String> getTags() {
        assertPageFetched();
        return this.channelAgeGateRenderer != null ? Collections.EMPTY_LIST : (List) Collection$EL.stream(this.jsonResponse.getObject("microformat").getObject("microformatDataRenderer").getArray("tags")).filter(new n(2)).map(new h(7)).collect(Collectors.toUnmodifiableList());
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getUrl() {
        try {
            return YoutubeChannelLinkHandlerFactory.getInstance().getUrl("channel/" + getId());
        } catch (ParsingException unused) {
            return super.getUrl();
        }
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public boolean isVerified() throws ParsingException {
        assertPageFetched();
        if (this.channelAgeGateRenderer != null) {
            return false;
        }
        YoutubeChannelHelper.ChannelHeader channelHeader = this.channelHeader;
        if (channelHeader != null) {
            return YoutubeChannelHelper.isChannelVerified(channelHeader);
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get channel verified status, no channel header has been extracted");
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        YoutubeChannelHelper.ChannelResponseData channelResponse = YoutubeChannelHelper.getChannelResponse(YoutubeChannelHelper.resolveChannelId(super.getId()), "EgZ2aWRlb3PyBgQKAjoA", getExtractorLocalization(), getExtractorContentCountry());
        JsonObject jsonObject = channelResponse.jsonResponse;
        this.jsonResponse = jsonObject;
        this.channelHeader = YoutubeChannelHelper.getChannelHeader(jsonObject);
        this.channelId = channelResponse.channelId;
        this.channelAgeGateRenderer = YoutubeChannelHelper.getChannelAgeGateRenderer(this.jsonResponse);
    }
}
