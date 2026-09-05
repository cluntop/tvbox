package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonObject;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
class YoutubeShortsLockupInfoItemExtractor implements StreamInfoItemExtractor {
    private final JsonObject shortsLockupViewModel;

    public YoutubeShortsLockupInfoItemExtractor(JsonObject jsonObject) {
        this.shortsLockupViewModel = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final ContentAvailability getContentAvailability() {
        return ContentAvailability.UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.shortsLockupViewModel.getObject("overlayMetadata").getObject("primaryText").getString("content");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ String getShortDescription() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public StreamType getStreamType() {
        return StreamType.VIDEO_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getTextualUploadDate() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        boolean zHas = this.shortsLockupViewModel.has("thumbnail");
        JsonObject jsonObject = this.shortsLockupViewModel;
        return zHas ? YoutubeParsingHelper.getImagesFromThumbnailsArray(jsonObject.getObject("thumbnail").getArray("sources")) : YoutubeParsingHelper.getImagesFromThumbnailsArray(jsonObject.getObject("thumbnailViewModel").getObject("thumbnailViewModel").getObject("image").getArray("sources"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public DateWrapper getUploadDate() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final List getUploaderAvatars() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderUrl() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        String string = this.shortsLockupViewModel.getObject("onTap").getObject("innertubeCommand").getObject("reelWatchEndpoint").getString(YoutubeParsingHelper.VIDEO_ID);
        if (Utils.isNullOrEmpty(string)) {
            string = com.github.catvod.spider.merge.t0.a.c(this.shortsLockupViewModel, "inlinePlayerData", "onVisible", "innertubeCommand", "watchEndpoint").getString(YoutubeParsingHelper.VIDEO_ID);
        }
        if (Utils.isNullOrEmpty(string)) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get video ID");
            return null;
        }
        try {
            return YoutubeStreamLinkHandlerFactory.getInstance().getUrl(string);
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get URL", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getViewCount() throws ParsingException {
        String string = this.shortsLockupViewModel.getObject("overlayMetadata").getObject("secondaryText").getString("content");
        if (Utils.isNullOrEmpty(string)) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get short view count");
            return 0L;
        }
        if (string.contains("✪")) {
            return -1L;
        }
        if (string.toLowerCase().contains("no views")) {
            return 0L;
        }
        return Utils.mixedNumberWordToLong(string);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isAd() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isShortFormContent() {
        return true;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
