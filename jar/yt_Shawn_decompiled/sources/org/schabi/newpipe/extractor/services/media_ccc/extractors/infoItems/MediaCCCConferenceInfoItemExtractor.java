package org.schabi.newpipe.extractor.services.media_ccc.extractors.infoItems;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCParsingHelper;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCConferenceInfoItemExtractor implements ChannelInfoItemExtractor {
    private final JsonObject conference;

    public MediaCCCConferenceInfoItemExtractor(JsonObject jsonObject) {
        this.conference = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public String getDescription() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.conference.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getStreamCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getSubscriberCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return MediaCCCParsingHelper.getImageListFromLogoImageUrl(this.conference.getString("logo_url"));
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.conference.getString("url");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public boolean isVerified() {
        return false;
    }
}
