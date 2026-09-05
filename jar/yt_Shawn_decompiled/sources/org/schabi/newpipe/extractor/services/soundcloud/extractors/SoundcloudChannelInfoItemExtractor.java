package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudChannelInfoItemExtractor implements ChannelInfoItemExtractor {
    private final JsonObject itemObject;

    public SoundcloudChannelInfoItemExtractor(JsonObject jsonObject) {
        this.itemObject = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public String getDescription() {
        return this.itemObject.getString("description", VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.itemObject.getString("username");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getStreamCount() {
        return this.itemObject.getLong("track_count");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getSubscriberCount() {
        return this.itemObject.getLong("followers_count");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(this.itemObject.getString("avatar_url"));
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return Utils.replaceHttpWithHttps(this.itemObject.getString("permalink_url"));
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public boolean isVerified() {
        return this.itemObject.getBoolean("verified");
    }
}
