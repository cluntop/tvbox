package org.schabi.newpipe.extractor.comments;

import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.stream.Description;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class CommentsInfoItem extends InfoItem {
    public static final int NO_LIKE_COUNT = -1;
    public static final int NO_STREAM_POSITION = -1;
    public static final int UNKNOWN_REPLY_COUNT = -1;
    private String commentId;
    private Description commentText;
    private boolean creatorReply;
    private boolean heartedByUploader;
    private boolean isChannelOwner;
    private boolean isEdited;
    private int likeCount;
    private boolean pinned;
    private Page replies;
    private int replyCount;
    private int streamPosition;
    private String textualLikeCount;
    private String textualUploadDate;
    private DateWrapper uploadDate;
    private List<Image> uploaderAvatars;
    private String uploaderName;
    private String uploaderUrl;
    private boolean uploaderVerified;

    public CommentsInfoItem(int i, String str, String str2) {
        super(InfoItem.InfoType.COMMENT, i, str, str2);
        this.commentText = Description.EMPTY_DESCRIPTION;
        this.uploaderAvatars = Collections.EMPTY_LIST;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public Description getCommentText() {
        return this.commentText;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public Page getReplies() {
        return this.replies;
    }

    public int getReplyCount() {
        return this.replyCount;
    }

    public int getStreamPosition() {
        return this.streamPosition;
    }

    public String getTextualLikeCount() {
        return this.textualLikeCount;
    }

    public String getTextualUploadDate() {
        return this.textualUploadDate;
    }

    public DateWrapper getUploadDate() {
        return this.uploadDate;
    }

    public List<Image> getUploaderAvatars() {
        return this.uploaderAvatars;
    }

    public String getUploaderName() {
        return this.uploaderName;
    }

    public String getUploaderUrl() {
        return this.uploaderUrl;
    }

    public boolean hasCreatorReply() {
        return this.creatorReply;
    }

    public boolean isChannelOwner() {
        return this.isChannelOwner;
    }

    public boolean isEdited() {
        return this.isEdited;
    }

    public boolean isHeartedByUploader() {
        return this.heartedByUploader;
    }

    public boolean isPinned() {
        return this.pinned;
    }

    public boolean isUploaderVerified() {
        return this.uploaderVerified;
    }

    public void setChannelOwner(boolean z) {
        this.isChannelOwner = z;
    }

    public void setCommentId(String str) {
        this.commentId = str;
    }

    public void setCommentText(Description description) {
        this.commentText = description;
    }

    public void setCreatorReply(boolean z) {
        this.creatorReply = z;
    }

    public void setEdited(boolean z) {
        this.isEdited = z;
    }

    public void setHeartedByUploader(boolean z) {
        this.heartedByUploader = z;
    }

    public void setLikeCount(int i) {
        this.likeCount = i;
    }

    public void setPinned(boolean z) {
        this.pinned = z;
    }

    public void setReplies(Page page) {
        this.replies = page;
    }

    public void setReplyCount(int i) {
        this.replyCount = i;
    }

    public void setStreamPosition(int i) {
        this.streamPosition = i;
    }

    public void setTextualLikeCount(String str) {
        this.textualLikeCount = str;
    }

    public void setTextualUploadDate(String str) {
        this.textualUploadDate = str;
    }

    public void setUploadDate(DateWrapper dateWrapper) {
        this.uploadDate = dateWrapper;
    }

    public void setUploaderAvatars(List<Image> list) {
        this.uploaderAvatars = list;
    }

    public void setUploaderName(String str) {
        this.uploaderName = str;
    }

    public void setUploaderUrl(String str) {
        this.uploaderUrl = str;
    }

    public void setUploaderVerified(boolean z) {
        this.uploaderVerified = z;
    }
}
