package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeChannelInfoItemExtractor implements ChannelInfoItemExtractor {
    private final String baseUrl;
    private final JsonObject item;

    public PeertubeChannelInfoItemExtractor(JsonObject jsonObject, String str) {
        this.item = jsonObject;
        this.baseUrl = str;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public String getDescription() {
        return this.item.getString("description");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.item.getString("displayName");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getStreamCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getSubscriberCount() {
        return this.item.getInt("followersCount");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(this.baseUrl, this.item);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.item.getString("url");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public boolean isVerified() {
        return false;
    }
}
