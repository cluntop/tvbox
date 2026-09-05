package org.schabi.newpipe.extractor.comments;

import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.stream.Description;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface CommentsInfoItemExtractor extends InfoItemExtractor {
    String getCommentId();

    Description getCommentText();

    int getLikeCount();

    Page getReplies();

    int getReplyCount();

    int getStreamPosition();

    String getTextualLikeCount();

    String getTextualUploadDate();

    DateWrapper getUploadDate();

    List<Image> getUploaderAvatars();

    String getUploaderName();

    String getUploaderUrl();

    boolean hasCreatorReply();

    boolean isChannelOwner();

    boolean isEdited();

    boolean isHeartedByUploader();

    boolean isPinned();

    boolean isUploaderVerified();
}
