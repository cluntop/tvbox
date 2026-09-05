package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.time.format.DateTimeParseException;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeStreamInfoItemLockupExtractor implements StreamInfoItemExtractor {
    private static final String NO_VIEWS_LOWERCASE = "no views";
    private static final DateTimeFormatter PREMIERES_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
    private static final String PREMIERES_LIVES_TEXT = "Scheduled for ";
    private static final String PREMIERES_VIDEOS_TEXT = "Premieres ";
    private ChannelImageViewModel cachedChannelImageViewModel;
    private String cachedDateText;
    private final JsonArray cachedMetadataRows;
    private String cachedName;
    private StreamType cachedStreamType;
    private final JsonObject lockupViewModel;
    private final TimeAgoParser timeAgoParser;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    abstract class ChannelImageViewModel {
        protected JsonObject viewModel;

        public ChannelImageViewModel(JsonObject jsonObject) {
            this.viewModel = jsonObject;
        }

        public abstract JsonObject forAvatarExtraction();

        public abstract JsonObject forUploaderUrlExtraction();
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class MultiChannelImageViewModel extends ChannelImageViewModel {
        public MultiChannelImageViewModel(JsonObject jsonObject) {
            super(jsonObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ JsonObject lambda$forUploaderUrlExtraction$0(JsonObject jsonObject) {
            return jsonObject.getObject("listItemViewModel");
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor.ChannelImageViewModel
        public JsonObject forAvatarExtraction() {
            return this.viewModel.getArray("avatars").getObject(0);
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor.ChannelImageViewModel
        public JsonObject forUploaderUrlExtraction() {
            return (JsonObject) com.github.catvod.spider.merge.t0.a.c(com.github.catvod.spider.merge.t0.a.c(this.viewModel, "rendererContext", "commandContext", "onTap", "innertubeCommand"), "showDialogCommand", "panelLoadingStrategy", "inlineContent", "dialogViewModel").getObject("customContent").getObject("listViewModel").getArray("listItems").streamAsJsonObjects().map(new h(2)).findFirst().orElse(null);
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class SingleChannelImageViewModel extends ChannelImageViewModel {
        public SingleChannelImageViewModel(JsonObject jsonObject) {
            super(jsonObject);
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor.ChannelImageViewModel
        public JsonObject forAvatarExtraction() {
            return this.viewModel.getObject("avatar");
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor.ChannelImageViewModel
        public JsonObject forUploaderUrlExtraction() {
            return this.viewModel;
        }
    }

    public YoutubeStreamInfoItemLockupExtractor(JsonObject jsonObject, TimeAgoParser timeAgoParser) {
        this.lockupViewModel = jsonObject;
        this.timeAgoParser = timeAgoParser;
        this.cachedMetadataRows = com.github.catvod.spider.merge.t0.a.c(jsonObject, "metadata", "lockupMetadataViewModel", "metadata", "contentMetadataViewModel").getArray("metadataRows");
    }

    private ChannelImageViewModel channelImageViewModel() {
        if (this.cachedChannelImageViewModel == null) {
            this.cachedChannelImageViewModel = determineChannelImageViewModel();
        }
        return this.cachedChannelImageViewModel;
    }

    private ChannelImageViewModel determineChannelImageViewModel() throws ParsingException {
        JsonObject object = this.lockupViewModel.getObject("metadata").getObject("lockupMetadataViewModel").getObject("image");
        JsonObject object2 = object.getObject("decoratedAvatarViewModel", null);
        if (object2 != null) {
            return new SingleChannelImageViewModel(object2);
        }
        JsonObject object3 = object.getObject("avatarStackViewModel", null);
        if (object3 != null) {
            return new MultiChannelImageViewModel(object3);
        }
        org.schabi.newpipe.extractor.utils.c.a("Failed to determine channel image view model");
        return null;
    }

    private StreamType determineStreamType() {
        JsonArray array = JsonUtils.getArray(this.lockupViewModel, "contentImage.thumbnailViewModel.overlays");
        return array.streamAsJsonObjects().flatMap(new s(4)).map(new s(5)).anyMatch(new t(0)) ? StreamType.LIVE_STREAM : array.streamAsJsonObjects().flatMap(new h(28)).map(new h(29)).anyMatch(new n(27)) ? StreamType.LIVE_STREAM : StreamType.VIDEO_STREAM;
    }

    private String getDateFromPremiere(String str) {
        return str.replace(PREMIERES_VIDEOS_TEXT, VideoStream.RESOLUTION_UNKNOWN).replace(PREMIERES_LIVES_TEXT, VideoStream.RESOLUTION_UNKNOWN);
    }

    private String getDateText() throws ParsingException {
        String str = this.cachedDateText;
        if (str != null) {
            return str;
        }
        List<JsonArray> metadataPartsFromMetadataRows = getMetadataPartsFromMetadataRows();
        if (metadataPartsFromMetadataRows.isEmpty()) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get date text: no metadata part from metadata rows");
            return null;
        }
        JsonArray jsonArray = metadataPartsFromMetadataRows.get(metadataPartsFromMetadataRows.size() - 1);
        if (jsonArray.isEmpty()) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get date text: no metadata part in the metadata parts array");
            return null;
        }
        String textContentFromMetadataPart = getTextContentFromMetadataPart(jsonArray.getObject(jsonArray.size() - 1));
        this.cachedDateText = textContentFromMetadataPart;
        return textContentFromMetadataPart;
    }

    private List<JsonArray> getMetadataPartsFromMetadataRows() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cachedMetadataRows.size(); i++) {
            JsonObject object = this.cachedMetadataRows.getObject(i);
            if (object.has("metadataParts")) {
                arrayList.add(object.getArray("metadataParts"));
            }
        }
        return arrayList;
    }

    private String getTextContentFromMetadataPart(JsonObject jsonObject) {
        return jsonObject.getObject("text").getString("content");
    }

    private long getViewCountFromViewCountText(String str) {
        if (str.toLowerCase().contains(NO_VIEWS_LOWERCASE)) {
            return 0L;
        }
        if (str.toLowerCase().contains("recommended")) {
            return -1L;
        }
        return Utils.mixedNumberWordToLong(str);
    }

    private boolean isChannelsMembersOnlyOrFirst() {
        return this.cachedMetadataRows.streamAsJsonObjects().flatMap(new h(27)).map(new s(0)).anyMatch(new n(28));
    }

    private boolean isLive() {
        return getStreamType() != StreamType.VIDEO_STREAM;
    }

    private boolean isPremiere() throws ParsingException {
        String dateText = getDateText();
        return dateText.contains(PREMIERES_VIDEOS_TEXT) || dateText.contains(PREMIERES_LIVES_TEXT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$determineStreamType$0(JsonObject jsonObject) {
        return jsonObject.getObject("thumbnailOverlayBadgeViewModel").getArray("thumbnailBadges").streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$determineStreamType$1(JsonObject jsonObject) {
        return jsonObject.getObject("thumbnailBadgeViewModel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$determineStreamType$2(JsonObject jsonObject) {
        return jsonObject.getObject("clientResource").getString("imageName");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$determineStreamType$3(JsonObject jsonObject) {
        if ("THUMBNAIL_OVERLAY_BADGE_STYLE_LIVE".equals(jsonObject.getString("badgeStyle"))) {
            return true;
        }
        return jsonObject.getObject("icon").getArray("sources").streamAsJsonObjects().map(new s(3)).anyMatch(new n(29));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$determineStreamType$4(JsonObject jsonObject) {
        return jsonObject.getObject("thumbnailBottomOverlayViewModel").getArray("badges").streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$determineStreamType$5(JsonObject jsonObject) {
        return jsonObject.getObject("thumbnailBadgeViewModel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$determineStreamType$6(JsonObject jsonObject) {
        return "THUMBNAIL_OVERLAY_BADGE_STYLE_LIVE".equals(jsonObject.getString("badgeStyle"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getDuration$7(JsonObject jsonObject) {
        return jsonObject.getObject("thumbnailBottomOverlayViewModel").getArray("badges").streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getDuration$8(JsonObject jsonObject) {
        return jsonObject.getObject("thumbnailBadgeViewModel").getString("text");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isChannelsMembersOnlyOrFirst$10(JsonObject jsonObject) {
        return jsonObject.getObject("badgeViewModel").getString("badgeStyle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$isChannelsMembersOnlyOrFirst$9(JsonObject jsonObject) {
        return jsonObject.getArray("badges").streamAsJsonObjects();
    }

    private String resolveUploaderUrlFromRelativeUrl(String str) {
        YoutubeChannelLinkHandlerFactory youtubeChannelLinkHandlerFactory = YoutubeChannelLinkHandlerFactory.getInstance();
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        return youtubeChannelLinkHandlerFactory.getUrl(str);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public ContentAvailability getContentAvailability() {
        return isChannelsMembersOnlyOrFirst() ? ContentAvailability.MEMBERSHIP : isLive() ? ContentAvailability.AVAILABLE : isPremiere() ? ContentAvailability.UPCOMING : ContentAvailability.AVAILABLE;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() throws ParsingException {
        if (isLive() || isPremiere()) {
            return -1L;
        }
        List list = (List) JsonUtils.getArray(this.lockupViewModel, "contentImage.thumbnailViewModel.overlays").streamAsJsonObjects().flatMap(new s(1)).map(new s(2)).collect(Collectors.toList());
        if (list.isEmpty()) {
            return -1L;
        }
        Iterator it = list.iterator();
        ParsingException e = null;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.matches(".*\\d.*")) {
                try {
                    return YoutubeParsingHelper.parseDurationString(str);
                } catch (ParsingException e2) {
                    e = e2;
                }
            }
        }
        if (e == null) {
            return -1L;
        }
        com.github.catvod.spider.merge.s0.a.m("Could not get duration", e);
        return 0L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() throws ParsingException {
        String str = this.cachedName;
        if (str != null) {
            return str;
        }
        String string = JsonUtils.getString(this.lockupViewModel, "metadata.lockupMetadataViewModel.title.content");
        if (Utils.isNullOrEmpty(string)) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get name");
            return null;
        }
        this.cachedName = string;
        return string;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ String getShortDescription() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public StreamType getStreamType() {
        if (this.cachedStreamType == null) {
            this.cachedStreamType = determineStreamType();
        }
        return this.cachedStreamType;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getTextualUploadDate() throws ParsingException {
        if (isLive()) {
            return null;
        }
        String dateText = getDateText();
        return isPremiere() ? getDateFromPremiere(dateText) : dateText;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return YoutubeParsingHelper.getImagesFromThumbnailsArray(JsonUtils.getArray(this.lockupViewModel, "contentImage.thumbnailViewModel.image.sources"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public DateWrapper getUploadDate() throws ParsingException {
        String textualUploadDate;
        if (this.timeAgoParser == null || (textualUploadDate = getTextualUploadDate()) == null) {
            return null;
        }
        if (!isPremiere()) {
            return this.timeAgoParser.parse(textualUploadDate);
        }
        try {
            return new DateWrapper(LocalDateTime.parse(getDateFromPremiere(getDateText()), PREMIERES_DATE_FORMATTER).B(ZoneOffset.UTC).toInstant(), false);
        } catch (DateTimeParseException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse premiere upload date", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public List<Image> getUploaderAvatars() {
        return YoutubeParsingHelper.getImagesFromThumbnailsArray(JsonUtils.getArray(channelImageViewModel().forAvatarExtraction(), "avatarViewModel.image.sources"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() throws ParsingException {
        List<JsonArray> metadataPartsFromMetadataRows = getMetadataPartsFromMetadataRows();
        if (metadataPartsFromMetadataRows.isEmpty()) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get uploader name: no metadata row");
            return null;
        }
        String textContentFromMetadataPart = getTextContentFromMetadataPart(metadataPartsFromMetadataRows.get(0).getObject(0));
        if (!Utils.isNullOrEmpty(textContentFromMetadataPart)) {
            return textContentFromMetadataPart;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderUrl() throws ParsingException {
        JsonObject jsonObjectC = com.github.catvod.spider.merge.t0.a.c(channelImageViewModel().forUploaderUrlExtraction(), "rendererContext", "commandContext", "onTap", "innertubeCommand");
        JsonObject object = jsonObjectC.getObject("browseEndpoint");
        String string = object.getString("browseId");
        if (string != null && string.startsWith("UC")) {
            return YoutubeChannelLinkHandlerFactory.getInstance().getUrl("channel/".concat(string));
        }
        String string2 = object.getString("canonicalBaseUrl");
        if (!Utils.isNullOrEmpty(string2)) {
            return resolveUploaderUrlFromRelativeUrl(string2);
        }
        String string3 = jsonObjectC.getObject("commandMetadata").getObject("webCommandMetadata").getString("url");
        if (!Utils.isNullOrEmpty(string3)) {
            return resolveUploaderUrlFromRelativeUrl(string3);
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader url");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        try {
            String string = this.lockupViewModel.getString("contentId");
            if (Utils.isNullOrEmpty(string)) {
                string = JsonUtils.getString(this.lockupViewModel, "rendererContext.commandContext.onTap.innertubeCommand.watchEndpoint.videoId");
            }
            return YoutubeStreamLinkHandlerFactory.getInstance().getUrl(string);
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get url", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getViewCount() throws ParsingException {
        if (isChannelsMembersOnlyOrFirst()) {
            return -1L;
        }
        List<JsonArray> metadataPartsFromMetadataRows = getMetadataPartsFromMetadataRows();
        if (metadataPartsFromMetadataRows.isEmpty()) {
            if (isLive() && isChannelOrCoursePlaylistLockupItem()) {
                return 0L;
            }
            org.schabi.newpipe.extractor.utils.c.a("Could not get view count: no metadata part from metadata rows");
            return 0L;
        }
        if (isPremiere()) {
            return -1L;
        }
        if (isLive() && metadataPartsFromMetadataRows.size() == 1 && !isChannelOrCoursePlaylistLockupItem()) {
            return 0L;
        }
        JsonArray jsonArray = metadataPartsFromMetadataRows.get(metadataPartsFromMetadataRows.size() - 1);
        if (jsonArray.isEmpty()) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get view count: no metadata part in the metadata parts array");
            return 0L;
        }
        String textContentFromMetadataPart = getTextContentFromMetadataPart(jsonArray.getObject(0));
        if (!Utils.isNullOrEmpty(textContentFromMetadataPart)) {
            return getViewCountFromViewCountText(textContentFromMetadataPart);
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get view count");
        return 0L;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isAd() throws ParsingException {
        String name = getName();
        return "[Private video]".equals(name) || "[Deleted video]".equals(name);
    }

    public boolean isChannelOrCoursePlaylistLockupItem() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ boolean isShortFormContent() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isUploaderVerified() throws ParsingException {
        List<JsonArray> metadataPartsFromMetadataRows = getMetadataPartsFromMetadataRows();
        if (!metadataPartsFromMetadataRows.isEmpty()) {
            return YoutubeParsingHelper.hasArtistOrVerifiedIconBadgeAttachment(metadataPartsFromMetadataRows.get(0).getObject(0).getObject("text").getArray("attachmentRuns"));
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader verified status: no metadata row");
        return false;
    }
}
