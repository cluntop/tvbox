package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
class YoutubeCommentsEUVMInfoItemExtractor implements CommentsInfoItemExtractor {
    private static final String AUTHOR = "author";
    private static final String PROPERTIES = "properties";
    private static final String PUBLISHED_TIME = "publishedTime";
    private final JsonObject commentEntityPayload;
    private final JsonObject commentRepliesRenderer;
    private final JsonObject commentViewModel;
    private final JsonObject engagementToolbarStateEntityPayload;
    private final TimeAgoParser timeAgoParser;
    private final String videoUrl;

    public YoutubeCommentsEUVMInfoItemExtractor(JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3, JsonObject jsonObject4, String str, TimeAgoParser timeAgoParser) {
        this.commentViewModel = jsonObject;
        this.commentRepliesRenderer = jsonObject2;
        this.commentEntityPayload = jsonObject3;
        this.engagementToolbarStateEntityPayload = jsonObject4;
        this.videoUrl = str;
        this.timeAgoParser = timeAgoParser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getReplies$0(JsonObject jsonObject) {
        return jsonObject.getObject("continuationItemRenderer", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getReplies$1(JsonObject jsonObject) {
        return jsonObject.getObject("continuationEndpoint").getObject("continuationCommand").getString("token");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getReplies$2() {
        return new ParsingException("Could not get comment replies continuation");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getCommentId() throws ParsingException {
        String string = this.commentEntityPayload.getObject(PROPERTIES).getString("commentId");
        if (!Utils.isNullOrEmpty(string)) {
            return string;
        }
        String string2 = this.commentViewModel.getString("commentId");
        if (!Utils.isNullOrEmpty(string2)) {
            return string2;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get comment ID");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public Description getCommentText() {
        return new Description(YoutubeDescriptionHelper.attributedDescriptionToHtml(this.commentEntityPayload.getObject(PROPERTIES).getObject("content")), 1);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public int getLikeCount() throws ParsingException {
        String textualLikeCount = getTextualLikeCount();
        try {
            if (Utils.isBlank(textualLikeCount)) {
                return 0;
            }
            return (int) Utils.mixedNumberWordToLong(textualLikeCount);
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Unexpected error while converting textual like count to like count", e);
            return 0;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return getUploaderName();
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public Page getReplies() {
        if (Utils.isNullOrEmpty(this.commentRepliesRenderer)) {
            return null;
        }
        return new Page(this.videoUrl, (String) this.commentRepliesRenderer.getArray("contents").streamAsJsonObjects().map(new h(0)).filter(new n(6)).findFirst().map(new h(1)).orElseThrow(new i(0)));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public int getReplyCount() {
        String string = this.commentEntityPayload.getObject("toolbar").getString("replyCount");
        if (Utils.isNullOrEmpty(string)) {
            return 0;
        }
        return (int) Utils.mixedNumberWordToLong(string);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ int getStreamPosition() {
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getTextualLikeCount() {
        return this.commentEntityPayload.getObject("toolbar").getString("likeCountNotliked");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getTextualUploadDate() {
        return this.commentEntityPayload.getObject(PROPERTIES).getString(PUBLISHED_TIME);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return getUploaderAvatars();
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public DateWrapper getUploadDate() {
        String textualUploadDate = getTextualUploadDate();
        if (Utils.isNullOrEmpty(textualUploadDate)) {
            return null;
        }
        return this.timeAgoParser.parse(textualUploadDate);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public List<Image> getUploaderAvatars() {
        return YoutubeParsingHelper.getImagesFromThumbnailsArray(this.commentEntityPayload.getObject("avatar").getObject("image").getArray("sources"));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderName() {
        return this.commentEntityPayload.getObject(AUTHOR).getString("displayName");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderUrl() throws ParsingException {
        JsonObject object = this.commentEntityPayload.getObject(AUTHOR);
        String string = object.getString("channelId");
        if (Utils.isNullOrEmpty(string)) {
            string = object.getObject("channelCommand").getObject("innertubeCommand").getObject("browseEndpoint").getString("browseId");
            if (Utils.isNullOrEmpty(string)) {
                string = com.github.catvod.spider.merge.t0.a.c(object, "avatar", "endpoint", "innertubeCommand", "browseEndpoint").getString("browseId");
                if (Utils.isNullOrEmpty(string)) {
                    org.schabi.newpipe.extractor.utils.c.a("Could not get channel ID");
                    return null;
                }
            }
        }
        return com.github.catvod.spider.merge.b.b.n("https://www.youtube.com/channel/", string);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.videoUrl;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean hasCreatorReply() {
        JsonObject jsonObject = this.commentRepliesRenderer;
        return jsonObject != null && jsonObject.has("viewRepliesCreatorThumbnail");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isChannelOwner() {
        return this.commentEntityPayload.getObject(AUTHOR).getBoolean("isCreator");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isEdited() throws ParsingException {
        try {
            JsonObject object = this.commentEntityPayload.getObject(PROPERTIES);
            if (object != null && object.has(PUBLISHED_TIME)) {
                String string = object.getString(PUBLISHED_TIME, VideoStream.RESOLUTION_UNKNOWN);
                if (string.contains("(")) {
                    if (string.contains(")")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not check whether the comment is edited", e);
            return false;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isHeartedByUploader() {
        return "TOOLBAR_HEART_STATE_HEARTED".equals(this.engagementToolbarStateEntityPayload.getString("heartState"));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isPinned() {
        return this.commentViewModel.has("pinnedText");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isUploaderVerified() {
        JsonObject object = this.commentEntityPayload.getObject(AUTHOR);
        return object.getBoolean("isVerified") || object.getBoolean("isArtist");
    }
}
