package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.grack.nanojson.JsonObject;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCConferenceLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCLiveStreamKioskExtractor implements StreamInfoItemExtractor {
    private final JsonObject conferenceInfo;
    private final String group;
    private final JsonObject roomInfo;

    public MediaCCCLiveStreamKioskExtractor(JsonObject jsonObject, String str, JsonObject jsonObject2) {
        this.conferenceInfo = jsonObject;
        this.group = str;
        this.roomInfo = jsonObject2;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final ContentAvailability getContentAvailability() {
        return ContentAvailability.UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() {
        return 0L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.roomInfo.getObject("talks").getObject("current").getString("title");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ String getShortDescription() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public StreamType getStreamType() {
        Iterator<Object> it = this.roomInfo.getArray("streams").iterator();
        while (it.hasNext()) {
            if ("video".equals(((JsonObject) it.next()).getString("type"))) {
                return StreamType.LIVE_STREAM;
            }
        }
        return StreamType.AUDIO_LIVE_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getTextualUploadDate() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return MediaCCCParsingHelper.getThumbnailsFromLiveStreamItem(this.roomInfo);
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
        return this.conferenceInfo.getString("conference") + " - " + this.group + " - " + this.roomInfo.getString("display");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderUrl() {
        return com.github.catvod.spider.merge.b.b.n(MediaCCCConferenceLinkHandlerFactory.CONFERENCE_PATH, this.conferenceInfo.getString("slug"));
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.roomInfo.getString("link");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getViewCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isAd() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ boolean isShortFormContent() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
