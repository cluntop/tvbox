package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.time.format.DateTimeParseException;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Map;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.AccountTerminatedException;
import org.schabi.newpipe.extractor.exceptions.AgeRestrictedContentException;
import org.schabi.newpipe.extractor.exceptions.ContentNotAvailableException;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.GeographicRestrictionException;
import org.schabi.newpipe.extractor.exceptions.PaidContentException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.PrivateContentException;
import org.schabi.newpipe.extractor.exceptions.SignInConfirmNotBotException;
import org.schabi.newpipe.extractor.exceptions.YoutubeMusicPremiumContentException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.localization.TimeAgoPatternsManager;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;
import org.schabi.newpipe.extractor.services.youtube.PoTokenProvider;
import org.schabi.newpipe.extractor.services.youtube.PoTokenResult;
import org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeJavaScriptPlayerManager;
import org.schabi.newpipe.extractor.services.youtube.YoutubeMetaInfoHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeStreamHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.stream.DeliveryMethod;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.Frameset;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamSegment;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.SubtitlesStream;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.LocaleCompat;
import org.schabi.newpipe.extractor.utils.Pair;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeStreamExtractor extends StreamExtractor {
    private static final String ADAPTIVE_FORMATS = "adaptiveFormats";
    private static final String CAPTIONS = "captions";
    private static final String CIPHER = "cipher";
    private static final String FORMATS = "formats";
    private static final String NEXT = "next";
    private static final String PLAYABILITY_STATUS = "playabilityStatus";
    private static final String PLAYER_CAPTIONS_TRACKLIST_RENDERER = "playerCaptionsTracklistRenderer";
    private static final String PREMIERED = "Premiered ";
    private static final String PREMIERED_ON = "Premiered on ";
    private static final String SIGNATURE_CIPHER = "signatureCipher";
    private static final String STREAMING_DATA = "streamingData";
    private static final String THUMBNAIL = "thumbnail";
    private static final String THUMBNAILS = "thumbnails";
    private static final String TITLE = "title";
    private static final String VIDEO_DETAILS = "videoDetails";
    private static boolean fetchIosClient;
    private static PoTokenProvider poTokenProvider;
    private int ageLimit;
    private String androidCpn;
    private JsonObject androidStreamingData;
    private String androidStreamingUrlsPoToken;
    private String iosCpn;
    private JsonObject iosStreamingData;
    private String iosStreamingUrlsPoToken;
    private JsonObject nextResponse;
    private JsonObject playerCaptionsTracklistRenderer;
    private JsonObject playerMicroFormatRenderer;
    private JsonObject playerResponse;
    private StreamType streamType;
    private JsonArray thumbnailsArray;
    private JsonObject videoPrimaryInfoRenderer;
    private JsonObject videoSecondaryInfoRenderer;
    private String visionOsCpn;
    private JsonObject visionOsStreamingData;

    public YoutubeStreamExtractor(StreamingService streamingService, LinkHandler linkHandler) {
        super(streamingService, linkHandler);
        this.ageLimit = -1;
    }

    private ItagInfo buildAndAddItagInfoToList(String str, JsonObject jsonObject, ItagItem itagItem, ItagItem.ItagType itagType, String str2, String str3) {
        String string;
        if (jsonObject.has("url")) {
            string = jsonObject.getString("url");
        } else {
            String string2 = jsonObject.getString(CIPHER, jsonObject.getString(SIGNATURE_CIPHER));
            if (Utils.isNullOrEmpty(string2)) {
                return null;
            }
            Map<String, String> mapCompatParseMap = Parser.compatParseMap(string2);
            String strDeobfuscateSignature = YoutubeJavaScriptPlayerManager.deobfuscateSignature(str, (String) Map.EL.getOrDefault(mapCompatParseMap, "s", VideoStream.RESOLUTION_UNKNOWN));
            string = mapCompatParseMap.get("url") + "&" + mapCompatParseMap.get("sp") + "=" + strDeobfuscateSignature;
        }
        String strO = com.github.catvod.spider.merge.b.b.o(YoutubeJavaScriptPlayerManager.getUrlWithThrottlingParameterDeobfuscated(str, string), "&cpn=", str2);
        if (str3 != null) {
            strO = com.github.catvod.spider.merge.b.b.o(strO, "&pot=", str3);
        }
        JsonObject object = jsonObject.getObject("initRange");
        JsonObject object2 = jsonObject.getObject("indexRange");
        String string3 = jsonObject.getString("mimeType", VideoStream.RESOLUTION_UNKNOWN);
        char c = 1;
        String str4 = string3.contains("codecs") ? string3.split("\"")[1] : VideoStream.RESOLUTION_UNKNOWN;
        itagItem.setBitrate(jsonObject.getInt("bitrate"));
        itagItem.setWidth(jsonObject.getInt("width"));
        itagItem.setHeight(jsonObject.getInt("height"));
        itagItem.setInitStart(Integer.parseInt(object.getString(PeertubeParsingHelper.START_KEY, "-1")));
        itagItem.setInitEnd(Integer.parseInt(object.getString("end", "-1")));
        itagItem.setIndexStart(Integer.parseInt(object2.getString(PeertubeParsingHelper.START_KEY, "-1")));
        itagItem.setIndexEnd(Integer.parseInt(object2.getString("end", "-1")));
        itagItem.setQuality(jsonObject.getString("quality"));
        itagItem.setCodec(str4);
        itagItem.setIsDrc(Boolean.valueOf(jsonObject.getBoolean("isDrc", Boolean.FALSE)));
        itagItem.setLastModified(Long.parseLong(jsonObject.getString("lastModified", "-1")));
        itagItem.setXtags(jsonObject.getString("xtags"));
        StreamType streamType = this.streamType;
        if (streamType == StreamType.LIVE_STREAM || streamType == StreamType.POST_LIVE_STREAM) {
            itagItem.setTargetDurationSec(jsonObject.getInt("targetDurationSec"));
        }
        if (itagType == ItagItem.ItagType.VIDEO || itagType == ItagItem.ItagType.VIDEO_ONLY) {
            itagItem.setFps(jsonObject.getInt("fps"));
        } else if (itagType == ItagItem.ItagType.AUDIO) {
            itagItem.setSampleRate(Integer.parseInt(jsonObject.getString("audioSampleRate")));
            itagItem.setAudioChannels(jsonObject.getInt("audioChannels", 2));
            String string4 = jsonObject.getObject("audioTrack").getString("id");
            if (!Utils.isNullOrEmpty(string4)) {
                itagItem.setAudioTrackId(string4);
                int iIndexOf = string4.indexOf(".");
                if (iIndexOf != -1) {
                    LocaleCompat.forLanguageTag(string4.substring(0, iIndexOf)).ifPresent(new l(c == true ? 1 : 0, itagItem));
                }
                itagItem.setAudioTrackType(YoutubeParsingHelper.extractAudioTrackType(itagItem.getXtags()));
            }
            itagItem.setAudioTrackName(jsonObject.getObject("audioTrack").getString("displayName"));
        }
        itagItem.setContentLength(Long.parseLong(jsonObject.getString("contentLength", String.valueOf(-1L))));
        itagItem.setApproxDurationMs(Long.parseLong(jsonObject.getString("approxDurationMs", String.valueOf(-1L))));
        ItagInfo itagInfo = new ItagInfo(strO, itagItem);
        StreamType streamType2 = this.streamType;
        if (streamType2 == StreamType.VIDEO_STREAM) {
            itagInfo.setIsUrl(!jsonObject.getString("type", VideoStream.RESOLUTION_UNKNOWN).equalsIgnoreCase("FORMAT_STREAM_TYPE_OTF"));
            return itagInfo;
        }
        itagInfo.setIsUrl(streamType2 != StreamType.POST_LIVE_STREAM);
        return itagInfo;
    }

    private static void checkPlayabilityStatus(JsonObject jsonObject) throws ContentNotAvailableException, SignInConfirmNotBotException {
        String string = jsonObject.getString("status");
        if (string == null || string.equalsIgnoreCase("ok")) {
            return;
        }
        String string2 = jsonObject.getString("reason");
        if (string2 != null) {
            if (string.equalsIgnoreCase("login_required")) {
                if (string2.contains("inappropriate for some users")) {
                    throw new AgeRestrictedContentException("This age-restricted video cannot be watched anonymously");
                }
                if (string2.contains("private")) {
                    throw new PrivateContentException("This video is private");
                }
                if (string2.contains("a bot")) {
                    throw new SignInConfirmNotBotException("YouTube probably temporarily blocked anonymous watch access with this IP , got error " + string + ": \"" + string2 + "\"");
                }
            }
            if (string.equalsIgnoreCase("unplayable") || string.equalsIgnoreCase("error")) {
                if (string2.contains("Music Premium")) {
                    throw new YoutubeMusicPremiumContentException();
                }
                if (string2.contains("payment")) {
                    throw new PaidContentException("This video is a paid video");
                }
                if (string2.contains("members")) {
                    throw new PaidContentException("This video is only available for members of the channel of this video");
                }
                if (string2.contains("country")) {
                    throw new GeographicRestrictionException("This video is not available in client's country.");
                }
                if (string2.contains("closed") || string2.contains("terminated")) {
                    throw new AccountTerminatedException(string2);
                }
            }
        }
        throw new ContentNotAvailableException("Got error " + string + ": \"" + string2 + "\"");
    }

    private void fetchAndroidClient(Localization localization, ContentCountry contentCountry, String str, PoTokenResult poTokenResult) throws ExtractionException {
        String strGenerateContentPlaybackNonce = YoutubeParsingHelper.generateContentPlaybackNonce();
        this.androidCpn = strGenerateContentPlaybackNonce;
        if (poTokenResult == null) {
            this.playerResponse = YoutubeStreamHelper.getAndroidReelPlayerResponse(contentCountry, localization, str, strGenerateContentPlaybackNonce);
        } else {
            this.playerResponse = YoutubeStreamHelper.getAndroidPlayerResponse(contentCountry, localization, str, strGenerateContentPlaybackNonce, poTokenResult);
        }
        checkPlayabilityStatus(this.playerResponse.getObject(PLAYABILITY_STATUS));
        if (isPlayerResponseNotValid(this.playerResponse, str)) {
            throw new ExtractionException("ANDROID player response is not valid");
        }
        this.androidStreamingData = this.playerResponse.getObject(STREAMING_DATA);
        this.playerCaptionsTracklistRenderer = this.playerResponse.getObject(CAPTIONS).getObject(PLAYER_CAPTIONS_TRACKLIST_RENDERER);
        if (poTokenResult != null) {
            this.androidStreamingUrlsPoToken = poTokenResult.streamingDataPoToken;
        }
    }

    private void fetchIosClient(Localization localization, ContentCountry contentCountry, String str, PoTokenResult poTokenResult) {
        try {
            String strGenerateContentPlaybackNonce = YoutubeParsingHelper.generateContentPlaybackNonce();
            this.iosCpn = strGenerateContentPlaybackNonce;
            JsonObject iosPlayerResponse = YoutubeStreamHelper.getIosPlayerResponse(contentCountry, localization, str, strGenerateContentPlaybackNonce, poTokenResult);
            if (isPlayerResponseNotValid(iosPlayerResponse, str)) {
                return;
            }
            this.iosStreamingData = iosPlayerResponse.getObject(STREAMING_DATA);
            if (Utils.isNullOrEmpty(this.playerCaptionsTracklistRenderer)) {
                this.playerCaptionsTracklistRenderer = iosPlayerResponse.getObject(CAPTIONS).getObject(PLAYER_CAPTIONS_TRACKLIST_RENDERER);
            }
            if (poTokenResult != null) {
                this.iosStreamingUrlsPoToken = poTokenResult.streamingDataPoToken;
            }
        } catch (Exception unused) {
        }
    }

    private void fetchVisionOsClient(Localization localization, ContentCountry contentCountry, String str) {
        try {
            String strGenerateContentPlaybackNonce = YoutubeParsingHelper.generateContentPlaybackNonce();
            this.visionOsCpn = strGenerateContentPlaybackNonce;
            JsonObject visionOsPlayerResponse = YoutubeStreamHelper.getVisionOsPlayerResponse(contentCountry, localization, str, strGenerateContentPlaybackNonce);
            if (isPlayerResponseNotValid(visionOsPlayerResponse, str)) {
                return;
            }
            this.visionOsStreamingData = visionOsPlayerResponse.getObject(STREAMING_DATA);
            if (Utils.isNullOrEmpty(this.playerCaptionsTracklistRenderer)) {
                this.playerCaptionsTracklistRenderer = visionOsPlayerResponse.getObject(CAPTIONS).getObject(PLAYER_CAPTIONS_TRACKLIST_RENDERER);
            }
        } catch (Exception unused) {
        }
    }

    private void fetchWebClientMetadataAndSetThumbnails(Localization localization, ContentCountry contentCountry, String str) {
        try {
            JsonObject webMetadataPlayerResponse = YoutubeStreamHelper.getWebMetadataPlayerResponse(localization, contentCountry, str);
            if (isPlayerResponseNotValid(webMetadataPlayerResponse, str)) {
                return;
            }
            this.playerMicroFormatRenderer = webMetadataPlayerResponse.getObject("microformat").getObject("playerMicroformatRenderer");
            JsonObject object = webMetadataPlayerResponse.getObject(VIDEO_DETAILS).getObject(THUMBNAIL);
            if (object.containsKey(THUMBNAILS)) {
                this.thumbnailsArray = object.getArray(THUMBNAILS);
            } else {
                this.thumbnailsArray = this.playerResponse.getObject(VIDEO_DETAILS).getObject(THUMBNAIL).getArray(THUMBNAILS);
            }
        } catch (Exception unused) {
            this.playerMicroFormatRenderer = new JsonObject();
            this.thumbnailsArray = this.playerResponse.getObject(VIDEO_DETAILS).getObject(THUMBNAIL).getArray(THUMBNAILS);
        }
    }

    private Function<ItagInfo, AudioStream> getAudioStreamBuilderHelper() {
        return new r(0, this);
    }

    private int getDurationFromFirstAdaptiveFormat(List<JsonObject> list) throws ParsingException {
        Iterator<JsonObject> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().getArray(ADAPTIVE_FORMATS).isEmpty()) {
                try {
                    return Math.round(Long.parseLong(r0.getObject(0).getString("approxDurationMs")) / 1000.0f);
                } catch (NumberFormatException unused) {
                }
            }
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get duration");
        return 0;
    }

    private <T extends Stream> List<T> getItags(final String str, final ItagItem.ItagType itagType, Function<ItagInfo, T> function, String str2) throws ParsingException {
        try {
            final String id = getId();
            ArrayList arrayList = new ArrayList();
            Stream.CC.of((Object[]) new Pair[]{new Pair(this.androidStreamingData, new Pair(this.androidCpn, this.androidStreamingUrlsPoToken)), new Pair(this.visionOsStreamingData, new Pair(this.visionOsCpn, null)), new Pair(this.iosStreamingData, new Pair(this.iosCpn, this.iosStreamingUrlsPoToken))}).flatMap(new Function() { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.p
                @Override // java.util.function.Function
                public /* synthetic */ Function andThen(Function function2) {
                    return Function$CC.$default$andThen(this, function2);
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.lambda$getItags$14(id, str, itagType, (Pair) obj);
                }

                @Override // java.util.function.Function
                public /* synthetic */ Function compose(Function function2) {
                    return Function$CC.$default$compose(this, function2);
                }
            }).map(function).forEachOrdered(new l(3, arrayList));
            return arrayList;
        } catch (Exception e) {
            throw new ParsingException(com.github.catvod.spider.merge.b.b.A("Could not get ", str2, " streams"), e);
        }
    }

    private static String getManifestUrl(String str, List<Pair<JsonObject, String>> list, String str2) {
        String strZ = com.github.catvod.spider.merge.b.b.z(str, "ManifestUrl");
        for (Pair<JsonObject, String> pair : list) {
            if (pair.getFirst() != null) {
                String string = ((JsonObject) pair.getFirst()).getString(strZ);
                if (!Utils.isNullOrEmpty(string)) {
                    if (pair.getSecond() == null) {
                        return com.github.catvod.spider.merge.b.b.o(string, "?", str2);
                    }
                    return string + "?pot=" + ((String) pair.getSecond()) + "&" + str2;
                }
            }
        }
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    private com.github.catvod.spider.jdollar.util.stream.Stream<ItagInfo> getStreamsFromStreamingDataKey(String str, JsonObject jsonObject, String str2, ItagItem.ItagType itagType, String str3, String str4) {
        return (jsonObject == null || !jsonObject.has(str2)) ? Stream.CC.empty() : jsonObject.getArray(str2).streamAsJsonObjects().map(new f(this, itagType, str, str3, str4)).filter(new n(0));
    }

    private JsonObject getVideoInfoRenderer(String str) {
        return (JsonObject) com.github.catvod.spider.merge.t0.a.c(this.nextResponse, "contents", "twoColumnWatchNextResults", "results", "results").getArray("contents").streamAsJsonObjects().filter(new d(str, 2)).map(new j(str, 1)).findFirst().orElse(new JsonObject());
    }

    private JsonObject getVideoPrimaryInfoRenderer() {
        JsonObject jsonObject = this.videoPrimaryInfoRenderer;
        if (jsonObject != null) {
            return jsonObject;
        }
        JsonObject videoInfoRenderer = getVideoInfoRenderer("videoPrimaryInfoRenderer");
        this.videoPrimaryInfoRenderer = videoInfoRenderer;
        return videoInfoRenderer;
    }

    private JsonObject getVideoSecondaryInfoRenderer() {
        JsonObject jsonObject = this.videoSecondaryInfoRenderer;
        if (jsonObject != null) {
            return jsonObject;
        }
        JsonObject videoInfoRenderer = getVideoInfoRenderer("videoSecondaryInfoRenderer");
        this.videoSecondaryInfoRenderer = videoInfoRenderer;
        return videoInfoRenderer;
    }

    private Function<ItagInfo, VideoStream> getVideoStreamBuilderHelper(final boolean z) {
        return new Function() { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.o
            @Override // java.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$getVideoStreamBuilderHelper$17(z, (ItagInfo) obj);
            }

            @Override // java.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        };
    }

    private static boolean isPlayerResponseNotValid(JsonObject jsonObject, String str) {
        return !str.equals(jsonObject.getObject(VIDEO_DETAILS).getString(YoutubeParsingHelper.VIDEO_ID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.github.catvod.spider.jdollar.util.stream.Stream lambda$getAgeLimit$3(JsonObject jsonObject) {
        return jsonObject.getObject("metadataRowRenderer").getArray("contents").streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.github.catvod.spider.jdollar.util.stream.Stream lambda$getAgeLimit$4(JsonObject jsonObject) {
        return jsonObject.getArray("runs").streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getAgeLimit$5(JsonObject jsonObject) {
        return jsonObject.getString("text", VideoStream.RESOLUTION_UNKNOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAgeLimit$6(String str) {
        return str.contains("Age-restricted");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AudioStream lambda$getAudioStreamBuilderHelper$16(ItagInfo itagInfo) {
        ItagItem itagItem = itagInfo.getItagItem();
        AudioStream.Builder itagItem2 = new AudioStream.Builder().setId(String.valueOf(itagItem.id)).setContent(itagInfo.getContent(), itagInfo.getIsUrl()).setMediaFormat(itagItem.getMediaFormat()).setAverageBitrate(itagItem.getAverageBitrate()).setAudioTrackId(itagItem.getAudioTrackId()).setAudioTrackName(itagItem.getAudioTrackName()).setAudioLocale(itagItem.getAudioLocale()).setAudioTrackType(itagItem.getAudioTrackType()).setItagItem(itagItem);
        StreamType streamType = this.streamType;
        if (streamType == StreamType.LIVE_STREAM || streamType == StreamType.POST_LIVE_STREAM || !itagInfo.getIsUrl()) {
            itagItem2.setDeliveryMethod(DeliveryMethod.DASH);
        }
        return itagItem2.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.github.catvod.spider.jdollar.util.stream.Stream lambda$getItags$14(String str, String str2, ItagItem.ItagType itagType, Pair pair) {
        return getStreamsFromStreamingDataKey(str, (JsonObject) pair.getFirst(), str2, itagType, (String) ((Pair) pair.getSecond()).getFirst(), (String) ((Pair) pair.getSecond()).getSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getItags$15(List list, org.schabi.newpipe.extractor.stream.Stream stream) {
        if (org.schabi.newpipe.extractor.stream.Stream.containSimilarStream(stream, list)) {
            return;
        }
        list.add(stream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPrivacy$19(JsonObject jsonObject) {
        return "PRIVACY_UNLISTED".equals(jsonObject.getObject("metadataBadgeRenderer").getObject("icon").getString("iconType"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InfoItemExtractor lambda$getRelatedItems$11(TimeAgoParser timeAgoParser, JsonObject jsonObject) {
        if (jsonObject.has("compactVideoRenderer")) {
            return new YoutubeStreamInfoItemExtractor(jsonObject.getObject("compactVideoRenderer"), timeAgoParser);
        }
        if (jsonObject.has("compactRadioRenderer")) {
            return new YoutubeMixOrPlaylistInfoItemExtractor(jsonObject.getObject("compactRadioRenderer"));
        }
        if (jsonObject.has("compactPlaylistRenderer")) {
            return new YoutubeMixOrPlaylistInfoItemExtractor(jsonObject.getObject("compactPlaylistRenderer"));
        }
        if (!jsonObject.has("lockupViewModel")) {
            return null;
        }
        JsonObject object = jsonObject.getObject("lockupViewModel");
        String string = object.getString("contentType");
        if ("LOCKUP_CONTENT_TYPE_PLAYLIST".equals(string) || "LOCKUP_CONTENT_TYPE_PODCAST".equals(string)) {
            return new YoutubeMixOrPlaylistLockupInfoItemExtractor(object);
        }
        if ("LOCKUP_CONTENT_TYPE_VIDEO".equals(string)) {
            return new YoutubeStreamInfoItemLockupExtractor(object, timeAgoParser);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getStreamSegments$20(JsonObject jsonObject) {
        return "engagement-panel-macro-markers-description-chapters".equals(jsonObject.getObject("engagementPanelSectionListRenderer").getString("panelIdentifier"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonArray lambda$getStreamSegments$21(JsonObject jsonObject) {
        return jsonObject.getObject("engagementPanelSectionListRenderer").getObject("content").getObject("macroMarkersListRenderer").getArray("contents");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getStreamSegments$22(JsonObject jsonObject) {
        return jsonObject.getObject("macroMarkersListItemRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ItagInfo lambda$getStreamsFromStreamingDataKey$18(ItagItem.ItagType itagType, String str, String str2, String str3, JsonObject jsonObject) {
        try {
            ItagItem itag = ItagItem.getItag(jsonObject.getInt("itag"));
            ItagItem.ItagType itagType2 = itag.itagType;
            if (itagType2 == itagType) {
                return buildAndAddItagInfoToList(str, jsonObject, itag, itagType2, str2, str3);
            }
            return null;
        } catch (ExtractionException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Optional lambda$getUploadDate$0(String str) {
        return parseOptionalDate(str, "dd MMM yyyy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DateWrapper lambda$getUploadDate$1(LocalDate localDate) {
        return new DateWrapper(localDate.atStartOfDay(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getUploadDate$2(String str) {
        return new ParsingException(com.github.catvod.spider.merge.b.b.A("Could not parse upload date \"", str, "\""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getVideoInfoRenderer$12(String str, JsonObject jsonObject) {
        return jsonObject.has(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getVideoInfoRenderer$13(String str, JsonObject jsonObject) {
        return jsonObject.getObject(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoStream lambda$getVideoStreamBuilderHelper$17(boolean z, ItagInfo itagInfo) {
        ItagItem itagItem = itagInfo.getItagItem();
        VideoStream.Builder itagItem2 = new VideoStream.Builder().setId(String.valueOf(itagItem.id)).setContent(itagInfo.getContent(), itagInfo.getIsUrl()).setMediaFormat(itagItem.getMediaFormat()).setIsVideoOnly(z).setItagItem(itagItem);
        String resolutionString = itagItem.getResolutionString();
        if (resolutionString == null) {
            resolutionString = VideoStream.RESOLUTION_UNKNOWN;
        }
        itagItem2.setResolution(resolutionString);
        if (this.streamType != StreamType.VIDEO_STREAM || !itagInfo.getIsUrl()) {
            itagItem2.setDeliveryMethod(DeliveryMethod.DASH);
        }
        return itagItem2.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$parseLikeCountFromLikeButtonRenderer$7(JsonObject jsonObject) {
        return jsonObject.getObject("segmentedLikeDislikeButtonRenderer").getObject("likeButton").getObject("toggleButtonRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseLikeCountFromLikeButtonRenderer$8(JsonObject jsonObject) {
        return !Utils.isNullOrEmpty(jsonObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseLikeCountFromLikeButtonViewModel$10(JsonObject jsonObject) {
        return !Utils.isNullOrEmpty(jsonObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$parseLikeCountFromLikeButtonViewModel$9(JsonObject jsonObject) {
        return com.github.catvod.spider.merge.t0.a.c(jsonObject, "segmentedLikeDislikeButtonViewModel", "likeButtonViewModel", "likeButtonViewModel", "toggleButtonViewModel").getObject("toggleButtonViewModel").getObject("defaultButtonViewModel").getObject("buttonViewModel");
    }

    private static long parseLikeCountFromLikeButtonRenderer(JsonArray jsonArray) throws ParsingException {
        int i = 17;
        String string = null;
        JsonObject jsonObject = (JsonObject) jsonArray.streamAsJsonObjects().map(new h(i)).filter(new n(i)).findFirst().orElse(null);
        if (jsonObject != null) {
            String string2 = jsonObject.getObject("accessibilityData").getObject("accessibilityData").getString("label");
            if (string2 == null) {
                string2 = jsonObject.getObject("accessibility").getString("label");
            }
            string = string2 == null ? jsonObject.getObject("defaultText").getObject("accessibility").getObject("accessibilityData").getString("label") : string2;
            if (string != null && string.toLowerCase().contains("no likes")) {
                return 0L;
            }
        }
        if (string == null) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get like count from accessibility data");
            return 0L;
        }
        try {
            return Long.parseLong(Utils.removeNonDigitCharacters(string));
        } catch (NumberFormatException e) {
            throw new ParsingException(com.github.catvod.spider.merge.b.b.A("Could not parse \"", string, "\" as a long"), e);
        }
    }

    private static long parseLikeCountFromLikeButtonViewModel(JsonArray jsonArray) throws ParsingException {
        int i = 16;
        JsonObject jsonObject = (JsonObject) jsonArray.streamAsJsonObjects().map(new h(i)).filter(new n(i)).findFirst().orElse(null);
        if (jsonObject == null) {
            org.schabi.newpipe.extractor.utils.c.a("Could not find buttonViewModel object");
            return 0L;
        }
        String string = jsonObject.getString("accessibilityText");
        if (string == null) {
            org.schabi.newpipe.extractor.utils.c.a("Could not find buttonViewModel's accessibilityText string");
            return 0L;
        }
        try {
            return Long.parseLong(Utils.removeNonDigitCharacters(string));
        } catch (NumberFormatException e) {
            throw new ParsingException(com.github.catvod.spider.merge.b.b.A("Could not parse \"", string, "\" as a long"), e);
        }
    }

    private Optional<LocalDate> parseOptionalDate(String str, String str2) {
        try {
            return Optional.of(LocalDate.parse(str, DateTimeFormatter.ofPattern(str2, Locale.ENGLISH)));
        } catch (DateTimeParseException unused) {
            return Optional.empty();
        }
    }

    public static void setFetchIosClient(boolean z) {
        fetchIosClient = z;
    }

    public static void setPoTokenProvider(PoTokenProvider poTokenProvider2) {
        poTokenProvider = poTokenProvider2;
    }

    private void setStreamType() {
        if (this.playerResponse.getObject(PLAYABILITY_STATUS).has("liveStreamability")) {
            this.streamType = StreamType.LIVE_STREAM;
        } else if (this.playerResponse.getObject(VIDEO_DETAILS).getBoolean("isPostLiveDvr", Boolean.FALSE)) {
            this.streamType = StreamType.POST_LIVE_STREAM;
        } else {
            this.streamType = StreamType.VIDEO_STREAM;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public int getAgeLimit() {
        int i = this.ageLimit;
        if (i != -1) {
            return i;
        }
        int i2 = getVideoSecondaryInfoRenderer().getObject("metadataRowContainer").getObject("metadataRowContainerRenderer").getArray("rows").streamAsJsonObjects().flatMap(new h(21)).flatMap(new h(22)).map(new h(23)).anyMatch(new n(21)) ? 18 : 0;
        this.ageLimit = i2;
        return i2;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<AudioStream> getAudioStreams() {
        assertPageFetched();
        return getItags(ADAPTIVE_FORMATS, ItagItem.ItagType.AUDIO, getAudioStreamBuilderHelper(), "audio");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getCategory() {
        return this.playerMicroFormatRenderer.getString("category", VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getDashMpdUrl() {
        assertPageFetched();
        Object[] objArr = {new Pair(this.androidStreamingData, this.androidStreamingUrlsPoToken)};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        return getManifestUrl("dash", com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList), "mpd_version=7");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public Description getDescription() {
        assertPageFetched();
        String textFromObject = YoutubeParsingHelper.getTextFromObject(getVideoSecondaryInfoRenderer().getObject("description"), true);
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return new Description(textFromObject, 1);
        }
        String strAttributedDescriptionToHtml = YoutubeDescriptionHelper.attributedDescriptionToHtml(getVideoSecondaryInfoRenderer().getObject("attributedDescription"));
        if (!Utils.isNullOrEmpty(strAttributedDescriptionToHtml)) {
            return new Description(strAttributedDescriptionToHtml, 1);
        }
        String string = this.playerResponse.getObject(VIDEO_DETAILS).getString("shortDescription");
        if (string == null) {
            string = YoutubeParsingHelper.getTextFromObject(this.playerMicroFormatRenderer.getObject("description"));
        }
        return new Description(string, 3);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getErrorMessage() {
        try {
            return YoutubeParsingHelper.getTextFromObject(this.playerResponse.getObject(PLAYABILITY_STATUS).getObject("errorScreen").getObject("playerErrorMessageRenderer").getObject("reason"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.util.ArrayList] */
    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Frameset> getFrames() throws NumberFormatException, ExtractionException {
        ?? SingletonList;
        String str = "playerLiveStoryboardSpecRenderer";
        try {
            JsonObject object = this.playerResponse.getObject("storyboards");
            if (!object.has("playerLiveStoryboardSpecRenderer")) {
                str = "playerStoryboardSpecRenderer";
            }
            JsonObject object2 = object.getObject(str);
            if (object2 == null) {
                return Collections.EMPTY_LIST;
            }
            String string = object2.getString("spec");
            if (string == null) {
                return Collections.EMPTY_LIST;
            }
            String[] strArrSplit = string.split("\\|");
            String str2 = strArrSplit[0];
            ArrayList arrayList = new ArrayList(strArrSplit.length - 1);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].split("#");
                if (strArrSplit2.length == 8 && Integer.parseInt(strArrSplit2[5]) != 0) {
                    int i2 = Integer.parseInt(strArrSplit2[2]);
                    int i3 = Integer.parseInt(strArrSplit2[3]);
                    int i4 = Integer.parseInt(strArrSplit2[4]);
                    String str3 = str2.replace("$L", String.valueOf(i - 1)).replace("$N", strArrSplit2[6]) + "&sigh=" + strArrSplit2[7];
                    if (str3.contains("$M")) {
                        int iCeil = (int) Math.ceil(i2 / (i3 * i4));
                        SingletonList = new ArrayList(iCeil);
                        for (int i5 = 0; i5 < iCeil; i5++) {
                            SingletonList.add(str3.replace("$M", String.valueOf(i5)));
                        }
                    } else {
                        SingletonList = Collections.singletonList(str3);
                    }
                    arrayList.add(new Frameset(SingletonList, Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1]), i2, Integer.parseInt(strArrSplit2[5]), i3, i4));
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new ExtractionException("Could not get frames", e);
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getHlsUrl() {
        assertPageFetched();
        Object[] objArr = {new Pair(this.visionOsStreamingData, null), new Pair(this.iosStreamingData, this.iosStreamingUrlsPoToken), new Pair(this.androidStreamingData, this.androidStreamingUrlsPoToken)};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return getManifestUrl("hls", DesugarCollections.unmodifiableList(arrayList), VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public Locale getLanguageInfo() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getLength() {
        assertPageFetched();
        try {
            return Long.parseLong(this.playerResponse.getObject(VIDEO_DETAILS).getString("lengthSeconds"));
        } catch (Exception unused) {
            return getDurationFromFirstAdaptiveFormat(Arrays.asList(this.androidStreamingData, this.iosStreamingData));
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getLicence() {
        JsonObject object = getVideoSecondaryInfoRenderer().getObject("metadataRowContainer").getObject("metadataRowContainerRenderer").getArray("rows").getObject(0).getObject("metadataRowRenderer");
        String textFromObject = YoutubeParsingHelper.getTextFromObject(object.getArray("contents").getObject(0));
        return (textFromObject == null || !"Licence".equals(YoutubeParsingHelper.getTextFromObject(object.getObject(TITLE)))) ? "YouTube licence" : textFromObject;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getLikeCount() throws ParsingException {
        assertPageFetched();
        if (!this.playerResponse.getObject(VIDEO_DETAILS).getBoolean("allowRatings")) {
            return -1L;
        }
        JsonArray array = getVideoPrimaryInfoRenderer().getObject("videoActions").getObject("menuRenderer").getArray("topLevelButtons");
        try {
            try {
                return parseLikeCountFromLikeButtonViewModel(array);
            } catch (ParsingException unused) {
                return parseLikeCountFromLikeButtonRenderer(array);
            }
        } catch (ParsingException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get like count", e);
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<MetaInfo> getMetaInfo() {
        return YoutubeMetaInfoHelper.getMetaInfo(com.github.catvod.spider.merge.t0.a.c(this.nextResponse, "contents", "twoColumnWatchNextResults", "results", "results").getArray("contents"));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() throws ParsingException {
        assertPageFetched();
        String string = this.playerResponse.getObject(VIDEO_DETAILS).getString(TITLE);
        if (!Utils.isNullOrEmpty(string)) {
            return string;
        }
        String textFromObject = YoutubeParsingHelper.getTextFromObject(getVideoPrimaryInfoRenderer().getObject(TITLE));
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return textFromObject;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public StreamExtractor.Privacy getPrivacy() {
        return (this.playerMicroFormatRenderer.getBoolean("isUnlisted") || getVideoPrimaryInfoRenderer().getArray("badges").streamAsJsonObjects().anyMatch(new n(19))) ? StreamExtractor.Privacy.UNLISTED : StreamExtractor.Privacy.PUBLIC;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public MultiInfoItemsCollector getRelatedItems() throws ParsingException {
        assertPageFetched();
        if (getAgeLimit() != 0) {
            return null;
        }
        try {
            MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
            this.nextResponse.getObject("contents").getObject("twoColumnWatchNextResults").getObject("secondaryResults").getObject("secondaryResults").getArray("results").streamAsJsonObjects().map(new k(getTimeAgoParser(), 1)).filter(new n(18)).forEach(new l(2, multiInfoItemsCollector));
            return multiInfoItemsCollector;
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get related videos", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<StreamSegment> getStreamSegments() throws ParsingException {
        if (!this.nextResponse.has("engagementPanels")) {
            return Collections.EMPTY_LIST;
        }
        int i = 20;
        JsonArray jsonArray = (JsonArray) this.nextResponse.getArray("engagementPanels").streamAsJsonObjects().filter(new n(i)).map(new h(19)).findFirst().orElse(null);
        if (jsonArray == null) {
            return Collections.EMPTY_LIST;
        }
        long length = getLength();
        ArrayList arrayList = new ArrayList();
        for (JsonObject jsonObject : jsonArray.streamAsJsonObjects().map(new h(i))) {
            int i2 = jsonObject.getObject("onTap").getObject("watchEndpoint").getInt("startTimeSeconds", -1);
            if (i2 == -1) {
                org.schabi.newpipe.extractor.utils.c.a("Could not get stream segment start time.");
                return null;
            }
            if (i2 > length) {
                break;
            }
            String textFromObject = YoutubeParsingHelper.getTextFromObject(jsonObject.getObject(TITLE));
            if (Utils.isNullOrEmpty(textFromObject)) {
                org.schabi.newpipe.extractor.utils.c.a("Could not get stream segment title.");
                return null;
            }
            StreamSegment streamSegment = new StreamSegment(textFromObject, i2);
            streamSegment.setUrl(getUrl() + "?t=" + i2);
            if (jsonObject.has(THUMBNAIL)) {
                JsonArray array = jsonObject.getObject(THUMBNAIL).getArray(THUMBNAILS);
                if (!array.isEmpty()) {
                    streamSegment.setPreviewUrl(YoutubeParsingHelper.fixThumbnailUrl(array.getObject(array.size() - 1).getString("url")));
                }
            }
            arrayList.add(streamSegment);
        }
        return arrayList;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public StreamType getStreamType() {
        assertPageFetched();
        return this.streamType;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<SubtitlesStream> getSubtitles(MediaFormat mediaFormat) {
        assertPageFetched();
        ArrayList arrayList = new ArrayList();
        JsonArray array = this.playerCaptionsTracklistRenderer.getArray("captionTracks");
        for (int i = 0; i < array.size(); i++) {
            String string = array.getObject(i).getString("languageCode");
            String string2 = array.getObject(i).getString("baseUrl");
            String string3 = array.getObject(i).getString("vssId");
            if (string != null && string2 != null && string3 != null) {
                boolean zStartsWith = string3.startsWith("a.");
                String strReplaceAll = string2.replaceAll("&fmt=[^&]*", VideoStream.RESOLUTION_UNKNOWN).replaceAll("&tlang=[^&]*", VideoStream.RESOLUTION_UNKNOWN);
                arrayList.add(new SubtitlesStream.Builder().setContent(strReplaceAll + "&fmt=" + mediaFormat.getSuffix(), true).setMediaFormat(mediaFormat).setLanguageCode(string).setAutoGenerated(zStartsWith).build());
            }
        }
        return arrayList;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<SubtitlesStream> getSubtitlesDefault() {
        return getSubtitles(MediaFormat.TTML);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<String> getTags() {
        return JsonUtils.getStringListFromJsonArray(this.playerResponse.getObject(VIDEO_DETAILS).getArray("keywords"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getTextualUploadDate() {
        String textFromObject;
        String string = this.playerMicroFormatRenderer.getString("uploadDate", VideoStream.RESOLUTION_UNKNOWN);
        if (string.isEmpty()) {
            string = this.playerMicroFormatRenderer.getString("publishDate", VideoStream.RESOLUTION_UNKNOWN);
        }
        if (!string.isEmpty()) {
            return string;
        }
        JsonObject object = this.playerMicroFormatRenderer.getObject("liveBroadcastDetails");
        String string2 = object.getString("endTimestamp", VideoStream.RESOLUTION_UNKNOWN);
        if (string2.isEmpty()) {
            string2 = object.getString("startTimestamp", VideoStream.RESOLUTION_UNKNOWN);
        }
        if (!string2.isEmpty()) {
            return string2;
        }
        if (getStreamType() == StreamType.LIVE_STREAM || (textFromObject = YoutubeParsingHelper.getTextFromObject(getVideoPrimaryInfoRenderer().getObject("dateText"))) == null) {
            return null;
        }
        return textFromObject.startsWith(PREMIERED_ON) ? textFromObject.substring(13) : textFromObject.startsWith(PREMIERED) ? textFromObject.substring(10) : textFromObject;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getThumbnails() throws ParsingException {
        assertPageFetched();
        try {
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(this.thumbnailsArray);
        } catch (Exception unused) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get thumbnails");
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getTimeStamp() {
        long timestampSeconds = getTimestampSeconds("((#|&|\\?)t=\\d*h?\\d*m?\\d+s?)");
        if (timestampSeconds == -2) {
            return 0L;
        }
        return timestampSeconds;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public DateWrapper getUploadDate() {
        final String textualUploadDate = getTextualUploadDate();
        try {
            try {
                return DateWrapper.fromOffsetDateTime(textualUploadDate);
            } catch (ParsingException unused) {
                return (DateWrapper) parseOptionalDate(textualUploadDate, "MMM dd, yyyy").or(new Supplier() { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.q
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return this.a.lambda$getUploadDate$0(textualUploadDate);
                    }
                }).map(new h(18)).orElseThrow(new e(1, textualUploadDate));
            }
        } catch (ParsingException unused2) {
            return TimeAgoPatternsManager.getTimeAgoParserFor(new Localization("en")).parse(textualUploadDate);
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getUploaderAvatars() throws ParsingException {
        assertPageFetched();
        JsonObject object = getVideoSecondaryInfoRenderer().getObject("owner").getObject("videoOwnerRenderer");
        List<Image> imagesFromThumbnailsArray = object.has("avatarStack") ? YoutubeParsingHelper.getImagesFromThumbnailsArray(object.getObject("avatarStack").getObject("avatarStackViewModel").getArray("avatars").getObject(0).getObject("avatarViewModel").getObject("image").getArray("sources")) : YoutubeParsingHelper.getImagesFromThumbnailsArray(object.getObject(THUMBNAIL).getArray(THUMBNAILS));
        if (!imagesFromThumbnailsArray.isEmpty() || this.ageLimit != 0) {
            return imagesFromThumbnailsArray;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader avatars");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderName() throws ParsingException {
        assertPageFetched();
        String string = this.playerResponse.getObject(VIDEO_DETAILS).getString("author");
        if (!Utils.isNullOrEmpty(string)) {
            return string;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getUploaderSubscriberCount() throws ParsingException {
        JsonObject object = JsonUtils.getObject(this.videoSecondaryInfoRenderer, "owner.videoOwnerRenderer");
        String textFromObject = object.has("subscriberCountText") ? YoutubeParsingHelper.getTextFromObject(object.getObject("subscriberCountText")) : YoutubeParsingHelper.getFirstCollaborator(object.getObject("navigationEndpoint")).getObject("subtitle").getString("content").split("•")[1];
        if (Utils.isNullOrEmpty(textFromObject)) {
            return -1L;
        }
        try {
            return Utils.mixedNumberWordToLong(textFromObject);
        } catch (NumberFormatException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get uploader subscriber count", e);
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderUrl() throws ParsingException {
        assertPageFetched();
        String string = this.playerResponse.getObject(VIDEO_DETAILS).getString("channelId");
        if (Utils.isNullOrEmpty(string)) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get uploader url");
            return null;
        }
        return YoutubeChannelLinkHandlerFactory.getInstance().getUrl("channel/" + string);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoOnlyStreams() {
        assertPageFetched();
        return getItags(ADAPTIVE_FORMATS, ItagItem.ItagType.VIDEO_ONLY, getVideoStreamBuilderHelper(true), "video-only");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoStreams() {
        assertPageFetched();
        return getItags(FORMATS, ItagItem.ItagType.VIDEO, getVideoStreamBuilderHelper(false), "video");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getViewCount() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(getVideoPrimaryInfoRenderer().getObject("viewCount").getObject("videoViewCountRenderer").getObject("viewCount"));
        if (Utils.isNullOrEmpty(textFromObject)) {
            textFromObject = this.playerResponse.getObject(VIDEO_DETAILS).getString("viewCount");
            if (Utils.isNullOrEmpty(textFromObject)) {
                org.schabi.newpipe.extractor.utils.c.a("Could not get view count");
                return 0L;
            }
        }
        if (textFromObject.toLowerCase().contains("no views")) {
            return 0L;
        }
        return Long.parseLong(Utils.removeNonDigitCharacters(textFromObject));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public boolean isUploaderVerified() {
        JsonObject object = getVideoSecondaryInfoRenderer().getObject("owner").getObject("videoOwnerRenderer");
        if (object.has("badges")) {
            return YoutubeParsingHelper.isVerified(object.getArray("badges"));
        }
        JsonObject firstCollaborator = YoutubeParsingHelper.getFirstCollaborator(object.getObject("navigationEndpoint"));
        if (firstCollaborator == null) {
            return false;
        }
        return YoutubeParsingHelper.hasArtistOrVerifiedIconBadgeAttachment(firstCollaborator.getObject(TITLE).getArray("attachmentRuns"));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        String id = getId();
        Localization extractorLocalization = getExtractorLocalization();
        ContentCountry extractorContentCountry = getExtractorContentCountry();
        PoTokenProvider poTokenProvider2 = poTokenProvider;
        boolean z = poTokenProvider2 == null;
        fetchAndroidClient(extractorLocalization, extractorContentCountry, id, z ? null : poTokenProvider2.getAndroidClientPoToken(id));
        setStreamType();
        if (fetchIosClient) {
            fetchIosClient(extractorLocalization, extractorContentCountry, id, z ? null : poTokenProvider2.getIosClientPoToken(id));
        }
        fetchVisionOsClient(extractorLocalization, extractorContentCountry, id);
        fetchWebClientMetadataAndSetThumbnails(extractorLocalization, extractorContentCountry, id);
        this.nextResponse = YoutubeParsingHelper.getJsonPostResponse(NEXT, JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, extractorContentCountry).value(YoutubeParsingHelper.VIDEO_ID, id).value(YoutubeParsingHelper.CONTENT_CHECK_OK, true).value(YoutubeParsingHelper.RACY_CHECK_OK, true).done()).getBytes(StandardCharsets.UTF_8), extractorLocalization);
    }
}
