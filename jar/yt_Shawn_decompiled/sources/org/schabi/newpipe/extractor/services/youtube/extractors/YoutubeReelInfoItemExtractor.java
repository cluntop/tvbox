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
public class YoutubeReelInfoItemExtractor implements StreamInfoItemExtractor {
    private final JsonObject reelInfo;

    public YoutubeReelInfoItemExtractor(JsonObject jsonObject) {
        this.reelInfo = jsonObject;
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
        return YoutubeParsingHelper.getTextFromObject(this.reelInfo.getObject("headline"));
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
        return YoutubeParsingHelper.getThumbnailsFromInfoItem(this.reelInfo);
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
        try {
            return YoutubeStreamLinkHandlerFactory.getInstance().getUrl(this.reelInfo.getString(YoutubeParsingHelper.VIDEO_ID));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get URL", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getViewCount() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.reelInfo.getObject("viewCountText"));
        if (Utils.isNullOrEmpty(textFromObject)) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get short view count");
            return 0L;
        }
        if (textFromObject.toLowerCase().contains("no views")) {
            return 0L;
        }
        return Utils.mixedNumberWordToLong(textFromObject);
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
