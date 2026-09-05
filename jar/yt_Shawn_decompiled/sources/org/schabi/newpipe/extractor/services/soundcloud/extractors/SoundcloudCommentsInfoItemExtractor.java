package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.github.catvod.spider.jdollar.util.Objects;
import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudCommentsInfoItemExtractor implements CommentsInfoItemExtractor {
    private final JsonObject json;
    private final String url;

    public SoundcloudCommentsInfoItemExtractor(JsonObject jsonObject, String str) {
        this.json = jsonObject;
        this.url = str;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getCommentId() {
        return Objects.toString(Long.valueOf(this.json.getLong("id")), null);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public Description getCommentText() {
        return new Description(this.json.getString("body"), 3);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ int getLikeCount() {
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.json.getObject("user").getString("permalink");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ Page getReplies() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ int getReplyCount() {
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public int getStreamPosition() {
        return this.json.getInt("timestamp") / 1000;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ String getTextualLikeCount() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getTextualUploadDate() {
        return this.json.getString("created_at");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(this.json.getObject("user").getString("avatar_url"));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public DateWrapper getUploadDate() {
        return SoundcloudParsingHelper.parseDate(getTextualUploadDate());
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public List<Image> getUploaderAvatars() {
        return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(this.json.getObject("user").getString("avatar_url"));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderName() {
        return this.json.getObject("user").getString("username");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderUrl() {
        return this.json.getObject("user").getString("permalink_url");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.url;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ boolean hasCreatorReply() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ boolean isChannelOwner() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ boolean isEdited() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ boolean isHeartedByUploader() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ boolean isPinned() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isUploaderVerified() {
        return this.json.getObject("user").getBoolean("verified");
    }
}
