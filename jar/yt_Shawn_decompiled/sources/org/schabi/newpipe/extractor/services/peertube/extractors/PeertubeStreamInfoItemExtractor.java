package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.merge.b.b;
import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.utils.JsonUtils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeStreamInfoItemExtractor implements StreamInfoItemExtractor {
    private String baseUrl;
    protected final JsonObject item;

    public PeertubeStreamInfoItemExtractor(JsonObject jsonObject, String str) {
        this.item = jsonObject;
        this.baseUrl = str;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final ContentAvailability getContentAvailability() {
        return ContentAvailability.UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() {
        return this.item.getLong("duration");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return JsonUtils.getString(this.item, "name");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ String getShortDescription() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public StreamType getStreamType() {
        return this.item.getBoolean("isLive") ? StreamType.LIVE_STREAM : StreamType.VIDEO_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getTextualUploadDate() {
        return JsonUtils.getString(this.item, "publishedAt");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return PeertubeParsingHelper.getThumbnailsFromPlaylistOrVideoItem(this.baseUrl, this.item);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public DateWrapper getUploadDate() {
        return DateWrapper.fromInstant(getTextualUploadDate());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public List<Image> getUploaderAvatars() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(this.baseUrl, this.item.getObject("account"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() {
        return JsonUtils.getString(this.item, "account.displayName");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderUrl() {
        return ServiceList.PeerTube.getChannelLHFactory().fromId(b.p("accounts/", JsonUtils.getString(this.item, "account.name"), "@", JsonUtils.getString(this.item, "account.host")), this.baseUrl).getUrl();
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return ServiceList.PeerTube.getStreamLHFactory().fromId(JsonUtils.getString(this.item, "uuid"), this.baseUrl).getUrl();
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getViewCount() {
        return this.item.getLong("views");
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

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }
}
