package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.grack.nanojson.JsonObject;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeStreamInfoItemExtractor implements StreamInfoItemExtractor {
    private static final Pattern ACCESSIBILITY_DATA_VIEW_COUNT_REGEX = Pattern.compile("([\\d,]+) views$");
    private static final String NO_VIEWS_LOWERCASE = "no views";
    private StreamType cachedStreamType;
    private Boolean isPremiere;
    private final TimeAgoParser timeAgoParser;
    private final JsonObject videoInfo;

    public YoutubeStreamInfoItemExtractor(JsonObject jsonObject, TimeAgoParser timeAgoParser) {
        this.videoInfo = jsonObject;
        this.timeAgoParser = timeAgoParser;
    }

    private Instant getInstantFromPremiere() throws ParsingException {
        String string = this.videoInfo.getObject("upcomingEventData").getString("startTime");
        try {
            return Instant.ofEpochSecond(Long.parseLong(string));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m(com.github.catvod.spider.merge.b.b.A("Could not parse date from premiere: \"", string, "\""), e);
            return null;
        }
    }

    private long getViewCountFromAccessibilityData() {
        String string = this.videoInfo.getObject("title").getObject("accessibility").getObject("accessibilityData").getString("label", VideoStream.RESOLUTION_UNKNOWN);
        if (string.toLowerCase().endsWith(NO_VIEWS_LOWERCASE)) {
            return 0L;
        }
        return Long.parseLong(Utils.removeNonDigitCharacters(Parser.matchGroup1(ACCESSIBILITY_DATA_VIEW_COUNT_REGEX, string)));
    }

    private long getViewCountFromViewCountText(String str, boolean z) {
        if (str.toLowerCase().contains(NO_VIEWS_LOWERCASE)) {
            return 0L;
        }
        if (str.toLowerCase().contains("recommended")) {
            return -1L;
        }
        return z ? Utils.mixedNumberWordToLong(str) : Long.parseLong(Utils.removeNonDigitCharacters(str));
    }

    private boolean isMembersOnly() {
        return this.videoInfo.getArray("badges").streamAsJsonObjects().map(new h(24)).anyMatch(new n(22));
    }

    private boolean isPremiere() {
        if (this.isPremiere == null) {
            this.isPremiere = Boolean.valueOf(this.videoInfo.has("upcomingEventData"));
        }
        return this.isPremiere.booleanValue();
    }

    private boolean isPremium() {
        Iterator<Object> it = this.videoInfo.getArray("badges").iterator();
        while (it.hasNext()) {
            if (((JsonObject) it.next()).getObject("metadataBadgeRenderer").getString("label", VideoStream.RESOLUTION_UNKNOWN).equals("Premium")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getDuration$0(JsonObject jsonObject) {
        return jsonObject.has("thumbnailOverlayTimeStatusRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getDuration$1(JsonObject jsonObject) {
        return YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("thumbnailOverlayTimeStatusRenderer").getObject("text"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getDuration$2(String str) {
        return !Utils.isNullOrEmpty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isMembersOnly$6(JsonObject jsonObject) {
        return jsonObject.getObject("metadataBadgeRenderer").getString("style");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isShortFormContent$3(JsonObject jsonObject) {
        return jsonObject.has("thumbnailOverlayTimeStatusRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$isShortFormContent$4(JsonObject jsonObject) {
        return jsonObject.getObject("thumbnailOverlayTimeStatusRenderer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isShortFormContent$5(JsonObject jsonObject) {
        return jsonObject.getString("style", VideoStream.RESOLUTION_UNKNOWN).equalsIgnoreCase("SHORTS") || jsonObject.getObject("icon").getString("iconType", VideoStream.RESOLUTION_UNKNOWN).toLowerCase().contains(ChannelTabs.SHORTS);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public ContentAvailability getContentAvailability() {
        return isPremiere() ? ContentAvailability.UPCOMING : isMembersOnly() ? ContentAvailability.MEMBERSHIP : isPremium() ? ContentAvailability.PAID : ContentAvailability.AVAILABLE;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() throws ParsingException {
        if (getStreamType() == StreamType.LIVE_STREAM) {
            return -1L;
        }
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.videoInfo.getObject("lengthText"));
        if (Utils.isNullOrEmpty(textFromObject)) {
            textFromObject = this.videoInfo.getString("lengthSeconds");
            if (Utils.isNullOrEmpty(textFromObject)) {
                while (((List) this.videoInfo.getArray("thumbnailOverlays").streamAsJsonObjects().filter(new n(23)).map(new h(25)).filter(new n(24)).collect(Collectors.toList())).iterator().hasNext()) {
                    try {
                        return YoutubeParsingHelper.parseDurationString((String) r1.next());
                    } catch (ParsingException unused) {
                    }
                }
            }
            if (Utils.isNullOrEmpty(textFromObject)) {
                if (isPremiere()) {
                    return -1L;
                }
                org.schabi.newpipe.extractor.utils.c.a("Could not get duration");
                return 0L;
            }
        }
        return YoutubeParsingHelper.parseDurationString(textFromObject);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() throws ParsingException {
        JsonObject object = this.videoInfo.getObject("title");
        String textFromObject = YoutubeParsingHelper.getTextFromObject(object);
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return textFromObject;
        }
        if (!Utils.isNullOrEmpty(object) && !object.has("runs")) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getShortDescription() {
        boolean zHas = this.videoInfo.has("detailedMetadataSnippets");
        JsonObject jsonObject = this.videoInfo;
        if (zHas) {
            return YoutubeParsingHelper.getTextFromObject(jsonObject.getArray("detailedMetadataSnippets").getObject(0).getObject("snippetText"));
        }
        if (jsonObject.has("descriptionSnippet")) {
            return YoutubeParsingHelper.getTextFromObject(this.videoInfo.getObject("descriptionSnippet"));
        }
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public StreamType getStreamType() {
        StreamType streamType = this.cachedStreamType;
        if (streamType != null) {
            return streamType;
        }
        Iterator<Object> it = this.videoInfo.getArray("badges").iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JsonObject) {
                JsonObject object = ((JsonObject) next).getObject("metadataBadgeRenderer");
                if (object.getString("style", VideoStream.RESOLUTION_UNKNOWN).equals("BADGE_STYLE_TYPE_LIVE_NOW") || object.getString("label", VideoStream.RESOLUTION_UNKNOWN).equals("LIVE NOW")) {
                    StreamType streamType2 = StreamType.LIVE_STREAM;
                    this.cachedStreamType = streamType2;
                    return streamType2;
                }
            }
        }
        Iterator<Object> it2 = this.videoInfo.getArray("thumbnailOverlays").iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if ((next2 instanceof JsonObject) && ((JsonObject) next2).getObject("thumbnailOverlayTimeStatusRenderer").getString("style", VideoStream.RESOLUTION_UNKNOWN).equalsIgnoreCase("LIVE")) {
                StreamType streamType3 = StreamType.LIVE_STREAM;
                this.cachedStreamType = streamType3;
                return streamType3;
            }
        }
        StreamType streamType4 = StreamType.VIDEO_STREAM;
        this.cachedStreamType = streamType4;
        return streamType4;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getTextualUploadDate() {
        if (getStreamType() == StreamType.LIVE_STREAM) {
            return null;
        }
        if (isPremiere()) {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.ofInstant(getInstantFromPremiere(), ZoneId.systemDefault()));
        }
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.videoInfo.getObject("publishedTimeText"));
        if (Utils.isNullOrEmpty(textFromObject) && this.videoInfo.has("videoInfo")) {
            textFromObject = this.videoInfo.getObject("videoInfo").getArray("runs").getObject(2).getString("text");
        }
        if (Utils.isNullOrEmpty(textFromObject)) {
            return null;
        }
        return textFromObject;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return YoutubeParsingHelper.getThumbnailsFromInfoItem(this.videoInfo);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public DateWrapper getUploadDate() throws ParsingException {
        if (getStreamType() == StreamType.LIVE_STREAM) {
            return null;
        }
        if (isPremiere()) {
            return new DateWrapper(getInstantFromPremiere());
        }
        String textualUploadDate = getTextualUploadDate();
        if (this.timeAgoParser == null || Utils.isNullOrEmpty(textualUploadDate)) {
            return null;
        }
        try {
            return this.timeAgoParser.parse(textualUploadDate);
        } catch (ParsingException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get upload date", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public List<Image> getUploaderAvatars() {
        boolean zHas = this.videoInfo.has("channelThumbnailSupportedRenderers");
        JsonObject jsonObject = this.videoInfo;
        return zHas ? YoutubeParsingHelper.getImagesFromThumbnailsArray(JsonUtils.getArray(jsonObject, "channelThumbnailSupportedRenderers.channelThumbnailWithLinkRenderer.thumbnail.thumbnails")) : jsonObject.has("channelThumbnail") ? YoutubeParsingHelper.getImagesFromThumbnailsArray(JsonUtils.getArray(this.videoInfo, "channelThumbnail.thumbnails")) : Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.videoInfo.getObject("longBylineText"));
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return textFromObject;
        }
        String textFromObject2 = YoutubeParsingHelper.getTextFromObject(this.videoInfo.getObject("ownerText"));
        if (!Utils.isNullOrEmpty(textFromObject2)) {
            return textFromObject2;
        }
        String textFromObject3 = YoutubeParsingHelper.getTextFromObject(this.videoInfo.getObject("shortBylineText"));
        if (!Utils.isNullOrEmpty(textFromObject3)) {
            return textFromObject3;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderUrl() throws ParsingException {
        String urlFromNavigationEndpoint = YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.videoInfo.getObject("longBylineText").getArray("runs").getObject(0).getObject("navigationEndpoint"));
        if (!Utils.isNullOrEmpty(urlFromNavigationEndpoint)) {
            return urlFromNavigationEndpoint;
        }
        String urlFromNavigationEndpoint2 = YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.videoInfo.getObject("ownerText").getArray("runs").getObject(0).getObject("navigationEndpoint"));
        if (!Utils.isNullOrEmpty(urlFromNavigationEndpoint2)) {
            return urlFromNavigationEndpoint2;
        }
        String urlFromNavigationEndpoint3 = YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.videoInfo.getObject("shortBylineText").getArray("runs").getObject(0).getObject("navigationEndpoint"));
        if (!Utils.isNullOrEmpty(urlFromNavigationEndpoint3)) {
            return urlFromNavigationEndpoint3;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader url");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        try {
            return YoutubeStreamLinkHandlerFactory.getInstance().getUrl(this.videoInfo.getString(YoutubeParsingHelper.VIDEO_ID));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get url", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getViewCount() {
        if (!isPremium() && !isPremiere()) {
            String textFromObject = YoutubeParsingHelper.getTextFromObject(this.videoInfo.getObject("viewCountText"));
            if (!Utils.isNullOrEmpty(textFromObject)) {
                try {
                    return getViewCountFromViewCountText(textFromObject, false);
                } catch (Exception unused) {
                }
            }
            if (getStreamType() != StreamType.LIVE_STREAM) {
                try {
                    return getViewCountFromAccessibilityData();
                } catch (Exception unused2) {
                }
            }
            if (this.videoInfo.has("videoInfo")) {
                try {
                    return getViewCountFromViewCountText(this.videoInfo.getObject("videoInfo").getArray("runs").getObject(0).getString("text", VideoStream.RESOLUTION_UNKNOWN), true);
                } catch (Exception unused3) {
                }
            }
            if (this.videoInfo.has("shortViewCountText")) {
                try {
                    String textFromObject2 = YoutubeParsingHelper.getTextFromObject(this.videoInfo.getObject("shortViewCountText"));
                    if (!Utils.isNullOrEmpty(textFromObject2)) {
                        return getViewCountFromViewCountText(textFromObject2, true);
                    }
                } catch (Exception unused4) {
                }
            }
        }
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isAd() {
        return isPremium() || getName().equals("[Private video]") || getName().equals("[Deleted video]");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isShortFormContent() throws ParsingException {
        try {
            String string = this.videoInfo.getObject("navigationEndpoint").getObject("commandMetadata").getObject("webCommandMetadata").getString("webPageType");
            boolean zHas = !Utils.isNullOrEmpty(string) && string.equals("WEB_PAGE_TYPE_SHORTS");
            if (!zHas) {
                zHas = this.videoInfo.getObject("navigationEndpoint").has("reelWatchEndpoint");
            }
            return (zHas || !this.videoInfo.has("thumbnailOverlays")) ? zHas : this.videoInfo.getArray("thumbnailOverlays").streamAsJsonObjects().filter(new n(25)).map(new h(26)).anyMatch(new n(26));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not determine if this is short-form content", e);
            return false;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isUploaderVerified() {
        return YoutubeParsingHelper.isVerified(this.videoInfo.getArray("ownerBadges"));
    }
}
