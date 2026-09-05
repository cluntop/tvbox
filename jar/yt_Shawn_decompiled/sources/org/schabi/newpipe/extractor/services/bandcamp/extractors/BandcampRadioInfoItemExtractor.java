package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.grack.nanojson.JsonObject;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampRadioInfoItemExtractor implements StreamInfoItemExtractor {
    private final JsonObject show;

    public BandcampRadioInfoItemExtractor(JsonObject jsonObject) {
        this.show = jsonObject;
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
        return this.show.getString("subtitle");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getShortDescription() {
        return this.show.getString("desc");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public StreamType getStreamType() {
        return StreamType.AUDIO_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getTextualUploadDate() {
        return this.show.getString("date");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return BandcampExtractorHelper.getImagesFromImageId(this.show.getLong("image_id"), false);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public DateWrapper getUploadDate() {
        return BandcampExtractorHelper.parseDate(getTextualUploadDate());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final List getUploaderAvatars() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() {
        return this.show.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return com.github.catvod.spider.merge.b.b.j(this.show.getInt("id"), "https://bandcamp.com/?show=");
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
