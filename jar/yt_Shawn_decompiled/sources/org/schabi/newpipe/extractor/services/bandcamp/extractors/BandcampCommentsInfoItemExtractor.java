package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampCommentsInfoItemExtractor implements CommentsInfoItemExtractor {
    private final JsonObject review;
    private final String url;

    public BandcampCommentsInfoItemExtractor(JsonObject jsonObject, String str) {
        this.review = jsonObject;
        this.url = str;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ String getCommentId() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public Description getCommentText() {
        return new Description(this.review.getString("why"), 3);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ int getLikeCount() {
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return getCommentText().getContent();
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
    public final /* synthetic */ int getStreamPosition() {
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ String getTextualLikeCount() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ String getTextualUploadDate() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return getUploaderAvatars();
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ DateWrapper getUploadDate() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public List<Image> getUploaderAvatars() {
        return BandcampExtractorHelper.getImagesFromImageId(this.review.getLong("image_id"), false);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderName() {
        return this.review.getString("name");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ String getUploaderUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
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
    public final /* synthetic */ boolean isUploaderVerified() {
        return false;
    }
}
