package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeCommentsInfoItemExtractor implements CommentsInfoItemExtractor {
    private static final String PUBLISHED_TIME_TEXT = "publishedTimeText";
    private final JsonObject commentRenderer;
    private final JsonObject commentRepliesRenderer;
    private final TimeAgoParser timeAgoParser;
    private final String url;

    public YoutubeCommentsInfoItemExtractor(JsonObject jsonObject, JsonObject jsonObject2, String str, TimeAgoParser timeAgoParser) {
        this.commentRenderer = jsonObject;
        this.commentRepliesRenderer = jsonObject2;
        this.url = str;
        this.timeAgoParser = timeAgoParser;
    }

    private List<Image> getAuthorThumbnails() throws ParsingException {
        try {
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(JsonUtils.getArray(this.commentRenderer, "authorThumbnail.thumbnails"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get author thumbnails", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getCommentId() throws ParsingException {
        try {
            return JsonUtils.getString(this.commentRenderer, "commentId");
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get comment id", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public Description getCommentText() throws ParsingException {
        try {
            JsonObject object = JsonUtils.getObject(this.commentRenderer, "contentText");
            return object.isEmpty() ? Description.EMPTY_DESCRIPTION : new Description(Utils.removeUTF8BOM(YoutubeParsingHelper.getTextFromObject(object, true)), 1);
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get comment text", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public int getLikeCount() throws ParsingException {
        try {
            String strRemoveNonDigitCharacters = Utils.removeNonDigitCharacters(JsonUtils.getString(this.commentRenderer, "actionButtons.commentActionButtonsRenderer.likeButton.toggleButtonRenderer.accessibilityData.accessibilityData.label"));
            try {
                if (Utils.isBlank(strRemoveNonDigitCharacters)) {
                    return 0;
                }
                return Integer.parseInt(strRemoveNonDigitCharacters);
            } catch (Exception e) {
                com.github.catvod.spider.merge.s0.a.m("Unexpected error while parsing like count as Integer", e);
                return 0;
            }
        } catch (Exception unused) {
            String textualLikeCount = getTextualLikeCount();
            try {
                if (Utils.isBlank(textualLikeCount)) {
                    return 0;
                }
                return (int) Utils.mixedNumberWordToLong(textualLikeCount);
            } catch (Exception e2) {
                com.github.catvod.spider.merge.s0.a.m("Unexpected error while converting textual like count to like count", e2);
                return 0;
            }
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        try {
            return YoutubeParsingHelper.getTextFromObject(JsonUtils.getObject(this.commentRenderer, "authorText"));
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public Page getReplies() {
        JsonObject jsonObject = this.commentRepliesRenderer;
        if (jsonObject == null) {
            return null;
        }
        try {
            return new Page(this.url, JsonUtils.getString(JsonUtils.getArray(jsonObject, "contents").getObject(0), "continuationItemRenderer.continuationEndpoint.continuationCommand.token"));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public int getReplyCount() {
        if (this.commentRenderer.has("replyCount")) {
            return this.commentRenderer.getInt("replyCount");
        }
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ int getStreamPosition() {
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getTextualLikeCount() throws ParsingException {
        try {
            if (!this.commentRenderer.has("voteCount")) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
            JsonObject object = JsonUtils.getObject(this.commentRenderer, "voteCount");
            return object.isEmpty() ? VideoStream.RESOLUTION_UNKNOWN : YoutubeParsingHelper.getTextFromObject(object);
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get the vote count", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getTextualUploadDate() throws ParsingException {
        try {
            return YoutubeParsingHelper.getTextFromObject(JsonUtils.getObject(this.commentRenderer, PUBLISHED_TIME_TEXT));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get publishedTimeText", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return getAuthorThumbnails();
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public DateWrapper getUploadDate() throws ParsingException {
        String textualUploadDate = getTextualUploadDate();
        if (textualUploadDate == null || textualUploadDate.isEmpty()) {
            return null;
        }
        return this.timeAgoParser.parse(textualUploadDate);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public List<Image> getUploaderAvatars() {
        return getAuthorThumbnails();
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderName() {
        try {
            return YoutubeParsingHelper.getTextFromObject(JsonUtils.getObject(this.commentRenderer, "authorText"));
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderUrl() {
        try {
            return "https://www.youtube.com/channel/" + JsonUtils.getString(this.commentRenderer, "authorEndpoint.browseEndpoint.browseId");
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.url;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean hasCreatorReply() {
        JsonObject jsonObject = this.commentRepliesRenderer;
        if (jsonObject == null) {
            return false;
        }
        return jsonObject.has("viewRepliesCreatorThumbnail");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isChannelOwner() {
        return this.commentRenderer.getBoolean("authorIsChannelOwner");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isEdited() throws ParsingException {
        try {
            if (!this.commentRenderer.has(PUBLISHED_TIME_TEXT)) {
                return false;
            }
            JsonObject object = JsonUtils.getObject(this.commentRenderer, PUBLISHED_TIME_TEXT);
            if (object.has("runs")) {
                return object.getArray("runs").size() > 1;
            }
            return false;
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not check whether the comment is edited", e);
            return false;
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isHeartedByUploader() {
        return this.commentRenderer.getObject("actionButtons").getObject("commentActionButtonsRenderer").has("creatorHeart");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isPinned() {
        return this.commentRenderer.has("pinnedCommentBadge");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean isUploaderVerified() {
        return this.commentRenderer.has("authorCommentBadge");
    }
}
