package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;
import kotlin.sequences.Sequence;
import kotlin.streams.jdk8.StreamsKt;
import org.schabi.newpipe.extractor.exceptions.ContentNotAvailableException;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeChannelHelper {
    private static final String BROWSE_ENDPOINT = "browseEndpoint";
    private static final String BROWSE_ID = "browseId";
    private static final String C4_TABBED_HEADER_RENDERER = "c4TabbedHeaderRenderer";
    private static final String CAROUSEL_HEADER_RENDERER = "carouselHeaderRenderer";
    private static final String CONTENT = "content";
    private static final String CONTENTS = "contents";
    private static final String HEADER = "header";
    private static final String PAGE_HEADER_VIEW_MODEL = "pageHeaderViewModel";
    private static final String TAB_RENDERER = "tabRenderer";
    private static final String TITLE = "title";
    private static final String TOPIC_CHANNEL_DETAILS_RENDERER = "topicChannelDetailsRenderer";

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType;

        static {
            int[] iArr = new int[ChannelHeader.HeaderType.values().length];
            $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType = iArr;
            try {
                iArr[ChannelHeader.HeaderType.CAROUSEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[ChannelHeader.HeaderType.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[ChannelHeader.HeaderType.INTERACTIVE_TABBED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[ChannelHeader.HeaderType.C4_TABBED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class ChannelHeader implements Serializable {
        public final HeaderType headerType;
        public final JsonObject json;

        /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
        public enum HeaderType {
            C4_TABBED,
            INTERACTIVE_TABBED,
            CAROUSEL,
            PAGE
        }

        public ChannelHeader(JsonObject jsonObject, HeaderType headerType) {
            this.json = jsonObject;
            this.headerType = headerType;
        }
    }

    private YoutubeChannelHelper() {
    }

    private static void checkIfChannelResponseIsValid(JsonObject jsonObject) throws ContentNotAvailableException {
        if (Utils.isNullOrEmpty(jsonObject.getObject("error"))) {
            return;
        }
        JsonObject object = jsonObject.getObject("error");
        if (object.getInt("code") != 404) {
            throw new ContentNotAvailableException(com.github.catvod.spider.merge.b.b.p("Got error:\"", object.getString("status"), "\": ", object.getString("message")));
        }
        throw new ContentNotAvailableException("This channel doesn't exist.");
    }

    public static JsonObject getChannelAgeGateRenderer(JsonObject jsonObject) {
        return (JsonObject) jsonObject.getObject(CONTENTS).getObject("twoColumnBrowseResultsRenderer").getArray("tabs").streamAsJsonObjects().flatMap(new a(1)).filter(new b(0)).map(new a(2)).findFirst().orElse(null);
    }

    public static ChannelHeader getChannelHeader(JsonObject jsonObject) {
        JsonObject object = jsonObject.getObject(HEADER);
        if (object.has(C4_TABBED_HEADER_RENDERER)) {
            return (ChannelHeader) Optional.of(object.getObject(C4_TABBED_HEADER_RENDERER)).map(new a(4)).orElse(null);
        }
        if (object.has(CAROUSEL_HEADER_RENDERER)) {
            return (ChannelHeader) object.getObject(CAROUSEL_HEADER_RENDERER).getArray(CONTENTS).streamAsJsonObjects().filter(new b(2)).findFirst().map(new a(5)).map(new a(6)).orElse(null);
        }
        if (object.has("pageHeaderRenderer")) {
            return (ChannelHeader) Optional.of(object.getObject("pageHeaderRenderer")).map(new a(7)).orElse(null);
        }
        if (object.has("interactiveTabbedHeaderRenderer")) {
            return (ChannelHeader) Optional.of(object.getObject("interactiveTabbedHeaderRenderer")).map(new a(0)).orElse(null);
        }
        return null;
    }

    public static String getChannelId(ChannelHeader channelHeader, JsonObject jsonObject, String str) throws ParsingException {
        if (channelHeader != null) {
            int i = AnonymousClass1.$SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[channelHeader.headerType.ordinal()];
            int i2 = 1;
            if (i == 1) {
                String string = channelHeader.json.getObject(HEADER).getObject(CAROUSEL_HEADER_RENDERER).getArray(CONTENTS).streamAsJsonObjects().filter(new b(i2)).findFirst().orElse(new JsonObject()).getObject(TOPIC_CHANNEL_DETAILS_RENDERER).getObject("navigationEndpoint").getObject(BROWSE_ENDPOINT).getString(BROWSE_ID);
                if (!Utils.isNullOrEmpty(string)) {
                    return string;
                }
            } else if (i == 4) {
                String string2 = channelHeader.json.getObject(HEADER).getObject(C4_TABBED_HEADER_RENDERER).getString("channelId", VideoStream.RESOLUTION_UNKNOWN);
                if (!Utils.isNullOrEmpty(string2)) {
                    return string2;
                }
                String string3 = channelHeader.json.getObject("navigationEndpoint").getObject(BROWSE_ENDPOINT).getString(BROWSE_ID);
                if (!Utils.isNullOrEmpty(string3)) {
                    return string3;
                }
            }
        }
        String string4 = jsonObject.getObject("metadata").getObject("channelMetadataRenderer").getString("externalChannelId");
        if (!Utils.isNullOrEmpty(string4)) {
            return string4;
        }
        if (!Utils.isNullOrEmpty(str)) {
            return str;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get channel ID");
        return null;
    }

    public static String getChannelName(ChannelHeader channelHeader, JsonObject jsonObject, final JsonObject jsonObject2) throws ParsingException {
        if (jsonObject != null) {
            String string = jsonObject.getString("channelTitle");
            if (!Utils.isNullOrEmpty(string)) {
                return string;
            }
            org.schabi.newpipe.extractor.utils.c.a("Could not get channel name");
            return null;
        }
        String string2 = jsonObject2.getObject("metadata").getObject("channelMetadataRenderer").getString(TITLE);
        if (!Utils.isNullOrEmpty(string2)) {
            return string2;
        }
        final int i = 1;
        return (String) Optional.ofNullable(channelHeader).map(new a(3)).or(new Supplier() { // from class: com.github.catvod.spider.merge.u0.a
            @Override // java.util.function.Supplier
            public final Object get() {
                int i2 = i;
                Object obj = jsonObject2;
                switch (i2) {
                    case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                        return StreamsKt.a((Sequence) obj);
                    default:
                        return YoutubeChannelHelper.lambda$getChannelName$8((JsonObject) obj);
                }
            }
        }).orElseThrow(new c());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x008b, code lost:
    
        if (r2 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008d, code lost:
    
        org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper.defaultAlertsCheck(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0095, code lost:
    
        return new org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper.ChannelResponseData(r2, r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009d, code lost:
    
        throw new org.schabi.newpipe.extractor.exceptions.ExtractionException("Got no channel response after 3 redirects");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper.ChannelResponseData getChannelResponse(java.lang.String r7, java.lang.String r8, org.schabi.newpipe.extractor.localization.Localization r9, org.schabi.newpipe.extractor.localization.ContentCountry r10) {
        /*
            r0 = 0
            r1 = 0
        L2:
            r2 = 3
            if (r1 >= r2) goto L8a
            com.grack.nanojson.JsonBuilder r2 = org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper.prepareDesktopJsonBuilder(r9, r10)
            java.lang.String r3 = "browseId"
            com.grack.nanojson.JsonBuilder r2 = r2.value(r3, r7)
            java.lang.String r4 = "params"
            com.grack.nanojson.JsonBuilder r2 = r2.value(r4, r8)
            java.lang.Object r2 = r2.done()
            java.lang.String r2 = com.grack.nanojson.JsonWriter.string(r2)
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r2 = r2.getBytes(r4)
            java.lang.String r4 = "browse"
            com.grack.nanojson.JsonObject r2 = org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper.getJsonPostResponse(r4, r2, r9)
            checkIfChannelResponseIsValid(r2)
            java.lang.String r4 = "onResponseReceivedActions"
            com.grack.nanojson.JsonArray r4 = r2.getArray(r4)
            com.grack.nanojson.JsonObject r4 = r4.getObject(r0)
            java.lang.String r5 = "navigateAction"
            com.grack.nanojson.JsonObject r4 = r4.getObject(r5)
            java.lang.String r5 = "endpoint"
            com.grack.nanojson.JsonObject r4 = r4.getObject(r5)
            java.lang.String r5 = "commandMetadata"
            com.grack.nanojson.JsonObject r5 = r4.getObject(r5)
            java.lang.String r6 = "webCommandMetadata"
            com.grack.nanojson.JsonObject r5 = r5.getObject(r6)
            java.lang.String r6 = "webPageType"
            java.lang.String r5 = r5.getString(r6)
            java.lang.String r6 = "browseEndpoint"
            com.grack.nanojson.JsonObject r4 = r4.getObject(r6)
            java.lang.String r6 = ""
            java.lang.String r3 = r4.getString(r3, r6)
            java.lang.String r4 = "WEB_PAGE_TYPE_BROWSE"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 != 0) goto L70
            java.lang.String r4 = "WEB_PAGE_TYPE_CHANNEL"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L8b
        L70:
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L8b
            java.lang.String r7 = "UC"
            boolean r7 = r3.startsWith(r7)
            if (r7 == 0) goto L82
            int r1 = r1 + 1
            r7 = r3
            goto L2
        L82:
            org.schabi.newpipe.extractor.exceptions.ExtractionException r7 = new org.schabi.newpipe.extractor.exceptions.ExtractionException
            java.lang.String r8 = "Redirected id is not pointing to a channel"
            r7.<init>(r8)
            throw r7
        L8a:
            r2 = 0
        L8b:
            if (r2 == 0) goto L96
            org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper.defaultAlertsCheck(r2)
            org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper$ChannelResponseData r8 = new org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper$ChannelResponseData
            r8.<init>(r2, r7, r0)
            return r8
        L96:
            org.schabi.newpipe.extractor.exceptions.ExtractionException r7 = new org.schabi.newpipe.extractor.exceptions.ExtractionException
            java.lang.String r8 = "Got no channel response after 3 redirects"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper.getChannelResponse(java.lang.String, java.lang.String, org.schabi.newpipe.extractor.localization.Localization, org.schabi.newpipe.extractor.localization.ContentCountry):org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper$ChannelResponseData");
    }

    public static boolean isChannelVerified(ChannelHeader channelHeader) {
        int i = AnonymousClass1.$SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[channelHeader.headerType.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            JsonObject jsonObject = channelHeader.json;
            return i != 3 ? YoutubeParsingHelper.isVerified(jsonObject.getArray("badges")) : jsonObject.has("autoGenerated");
        }
        JsonObject object = channelHeader.json.getObject(CONTENT).getObject(PAGE_HEADER_VIEW_MODEL);
        boolean zHasArtistOrVerifiedIconBadgeAttachment = YoutubeParsingHelper.hasArtistOrVerifiedIconBadgeAttachment(object.getObject(TITLE).getObject("dynamicTextViewModel").getObject("text").getArray("attachmentRuns"));
        if (zHasArtistOrVerifiedIconBadgeAttachment || !object.getObject("image").has("contentPreviewImageViewModel")) {
            return zHasArtistOrVerifiedIconBadgeAttachment;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getChannelAgeGateRenderer$10(JsonObject jsonObject) {
        return jsonObject.getObject(TAB_RENDERER).getObject(CONTENT).getObject("sectionListRenderer").getArray(CONTENTS).streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getChannelAgeGateRenderer$11(JsonObject jsonObject) {
        return jsonObject.has("channelAgeGateRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getChannelAgeGateRenderer$12(JsonObject jsonObject) {
        return jsonObject.getObject("channelAgeGateRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ChannelHeader lambda$getChannelHeader$0(JsonObject jsonObject) {
        return new ChannelHeader(jsonObject, ChannelHeader.HeaderType.C4_TABBED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getChannelHeader$1(JsonObject jsonObject) {
        return jsonObject.has(TOPIC_CHANNEL_DETAILS_RENDERER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getChannelHeader$2(JsonObject jsonObject) {
        return jsonObject.getObject(TOPIC_CHANNEL_DETAILS_RENDERER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ChannelHeader lambda$getChannelHeader$3(JsonObject jsonObject) {
        return new ChannelHeader(jsonObject, ChannelHeader.HeaderType.CAROUSEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ChannelHeader lambda$getChannelHeader$4(JsonObject jsonObject) {
        return new ChannelHeader(jsonObject, ChannelHeader.HeaderType.PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ChannelHeader lambda$getChannelHeader$5(JsonObject jsonObject) {
        return new ChannelHeader(jsonObject, ChannelHeader.HeaderType.INTERACTIVE_TABBED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getChannelId$6(JsonObject jsonObject) {
        return jsonObject.has(TOPIC_CHANNEL_DETAILS_RENDERER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getChannelName$7(ChannelHeader channelHeader) {
        JsonObject jsonObject = channelHeader.json;
        int i = AnonymousClass1.$SwitchMap$org$schabi$newpipe$extractor$services$youtube$YoutubeChannelHelper$ChannelHeader$HeaderType[channelHeader.headerType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return com.github.catvod.spider.merge.t0.a.c(jsonObject, CONTENT, PAGE_HEADER_VIEW_MODEL, TITLE, "dynamicTextViewModel").getObject("text").getString(CONTENT, jsonObject.getString("pageTitle"));
            }
            if (i != 3) {
                return jsonObject.getString(TITLE);
            }
        }
        return YoutubeParsingHelper.getTextFromObject(jsonObject.getObject(TITLE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Optional lambda$getChannelName$8(JsonObject jsonObject) {
        return Optional.ofNullable(jsonObject.getObject("microformat").getObject("microformatDataRenderer").getString(TITLE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getChannelName$9() {
        return new ParsingException("Could not get channel name");
    }

    public static String resolveChannelId(String str) throws ExtractionException {
        String[] strArrSplit = str.split("/");
        if (strArrSplit[0].startsWith("UC")) {
            return strArrSplit[0];
        }
        if (!strArrSplit[0].equals("channel")) {
            String strConcat = "https://www.youtube.com/".concat(str);
            JsonObject jsonObject = new JsonObject();
            String string = VideoStream.RESOLUTION_UNKNOWN;
            for (int i = 0; strConcat != null && i < 3; i++) {
                Localization localization = Localization.DEFAULT;
                JsonObject jsonPostResponse = YoutubeParsingHelper.getJsonPostResponse("navigation/resolve_url", JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(localization, ContentCountry.DEFAULT).value("url", strConcat).done()).getBytes(StandardCharsets.UTF_8), localization);
                checkIfChannelResponseIsValid(jsonPostResponse);
                jsonObject = jsonPostResponse.getObject("endpoint");
                string = jsonObject.getObject("commandMetadata").getObject("webCommandMetadata").getString("webPageType");
                strConcat = "WEB_PAGE_TYPE_UNKNOWN".equals(string) ? jsonObject.getObject("urlEndpoint").getString("url") : null;
            }
            String string2 = jsonObject.getObject(BROWSE_ENDPOINT).getString(BROWSE_ID, VideoStream.RESOLUTION_UNKNOWN);
            if (("WEB_PAGE_TYPE_BROWSE".equalsIgnoreCase(string) || "WEB_PAGE_TYPE_CHANNEL".equalsIgnoreCase(string)) && !string2.isEmpty()) {
                if (string2.startsWith("UC")) {
                    return string2;
                }
                throw new ExtractionException("Redirected id is not pointing to a channel");
            }
            if (strArrSplit.length < 2) {
                throw new ExtractionException("Failed to resolve channelId for ".concat(str));
            }
        }
        return strArrSplit[1];
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class ChannelResponseData {
        public final String channelId;
        public final JsonObject jsonResponse;

        private ChannelResponseData(JsonObject jsonObject, String str) {
            this.jsonResponse = jsonObject;
            this.channelId = str;
        }

        public /* synthetic */ ChannelResponseData(JsonObject jsonObject, String str, int i) {
            this(jsonObject, str);
        }
    }
}
