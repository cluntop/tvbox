package org.schabi.newpipe.extractor.comments;

import java.util.ArrayList;
import java.util.List;
import org.schabi.newpipe.extractor.InfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class CommentsInfoItemsCollector extends InfoItemsCollector<CommentsInfoItem, CommentsInfoItemExtractor> {
    public CommentsInfoItemsCollector(int i) {
        super(i);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemsCollector
    public void commit(CommentsInfoItemExtractor commentsInfoItemExtractor) {
        try {
            addItem(extract(commentsInfoItemExtractor));
        } catch (Exception e) {
            addError(e);
        }
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public CommentsInfoItem extract(CommentsInfoItemExtractor commentsInfoItemExtractor) {
        CommentsInfoItem commentsInfoItem = new CommentsInfoItem(getServiceId(), commentsInfoItemExtractor.getUrl(), commentsInfoItemExtractor.getName());
        try {
            commentsInfoItem.setCommentId(commentsInfoItemExtractor.getCommentId());
        } catch (Exception e) {
            addError(e);
        }
        try {
            commentsInfoItem.setCommentText(commentsInfoItemExtractor.getCommentText());
        } catch (Exception e2) {
            addError(e2);
        }
        try {
            commentsInfoItem.setUploaderName(commentsInfoItemExtractor.getUploaderName());
        } catch (Exception e3) {
            addError(e3);
        }
        try {
            commentsInfoItem.setUploaderAvatars(commentsInfoItemExtractor.getUploaderAvatars());
        } catch (Exception e4) {
            addError(e4);
        }
        try {
            commentsInfoItem.setUploaderUrl(commentsInfoItemExtractor.getUploaderUrl());
        } catch (Exception e5) {
            addError(e5);
        }
        try {
            commentsInfoItem.setTextualUploadDate(commentsInfoItemExtractor.getTextualUploadDate());
        } catch (Exception e6) {
            addError(e6);
        }
        try {
            commentsInfoItem.setUploadDate(commentsInfoItemExtractor.getUploadDate());
        } catch (Exception e7) {
            addError(e7);
        }
        try {
            commentsInfoItem.setLikeCount(commentsInfoItemExtractor.getLikeCount());
        } catch (Exception e8) {
            addError(e8);
        }
        try {
            commentsInfoItem.setTextualLikeCount(commentsInfoItemExtractor.getTextualLikeCount());
        } catch (Exception e9) {
            addError(e9);
        }
        try {
            commentsInfoItem.setThumbnails(commentsInfoItemExtractor.getThumbnails());
        } catch (Exception e10) {
            addError(e10);
        }
        try {
            commentsInfoItem.setHeartedByUploader(commentsInfoItemExtractor.isHeartedByUploader());
        } catch (Exception e11) {
            addError(e11);
        }
        try {
            commentsInfoItem.setPinned(commentsInfoItemExtractor.isPinned());
        } catch (Exception e12) {
            addError(e12);
        }
        try {
            commentsInfoItem.setStreamPosition(commentsInfoItemExtractor.getStreamPosition());
        } catch (Exception e13) {
            addError(e13);
        }
        try {
            commentsInfoItem.setReplyCount(commentsInfoItemExtractor.getReplyCount());
        } catch (Exception e14) {
            addError(e14);
        }
        try {
            commentsInfoItem.setReplies(commentsInfoItemExtractor.getReplies());
        } catch (Exception e15) {
            addError(e15);
        }
        try {
            commentsInfoItem.setChannelOwner(commentsInfoItemExtractor.isChannelOwner());
        } catch (Exception e16) {
            addError(e16);
        }
        try {
            commentsInfoItem.setCreatorReply(commentsInfoItemExtractor.hasCreatorReply());
        } catch (Exception e17) {
            addError(e17);
        }
        try {
            commentsInfoItem.setEdited(commentsInfoItemExtractor.isEdited());
        } catch (Exception e18) {
            addError(e18);
        }
        return commentsInfoItem;
    }

    public List<CommentsInfoItem> getCommentsInfoItemList() {
        return new ArrayList(super.getItems());
    }
}
