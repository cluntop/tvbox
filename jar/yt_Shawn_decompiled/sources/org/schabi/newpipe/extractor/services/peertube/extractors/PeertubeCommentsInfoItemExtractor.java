package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeCommentsInfoItemExtractor implements CommentsInfoItemExtractor {
    private final String baseUrl;
    private final JsonArray children;
    private final boolean isReply;
    private final JsonObject item;
    private Integer replyCount;
    private final String url;

    public PeertubeCommentsInfoItemExtractor(JsonObject jsonObject, JsonArray jsonArray, String str, String str2, boolean z) {
        this.item = jsonObject;
        this.children = jsonArray;
        this.url = str;
        this.baseUrl = str2;
        this.isReply = z;
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getCommentId() {
        return Objects.toString(Long.valueOf(this.item.getLong("id")), null);
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public Description getCommentText() {
        String string = JsonUtils.getString(this.item, "text");
        try {
            return new Description(c2.T(string).W().U(), 3);
        } catch (Exception unused) {
            return new Description(string.replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", VideoStream.RESOLUTION_UNKNOWN), 3);
        }
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public final /* synthetic */ int getLikeCount() {
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return JsonUtils.getString(this.item, "account.displayName");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public Page getReplies() {
        JsonArray jsonArray;
        if (getReplyCount() == 0) {
            return null;
        }
        String string = JsonUtils.getNumber(this.item, "threadId").toString();
        String strO = b.o(this.url, "/", string);
        if (!this.isReply || (jsonArray = this.children) == null || jsonArray.isEmpty()) {
            return new Page(strO, string);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("children", this.children);
        return new Page(strO, string, JsonWriter.string(jsonObject).getBytes(StandardCharsets.UTF_8));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public int getReplyCount() {
        if (this.replyCount == null) {
            JsonArray jsonArray = this.children;
            if (jsonArray == null || jsonArray.isEmpty()) {
                this.replyCount = Integer.valueOf(JsonUtils.getNumber(this.item, "totalReplies").intValue());
            } else {
                this.replyCount = Integer.valueOf(this.children.size());
            }
        }
        return this.replyCount.intValue();
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
    public String getTextualUploadDate() {
        return JsonUtils.getString(this.item, "createdAt");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return getUploaderAvatars();
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public DateWrapper getUploadDate() {
        return DateWrapper.fromInstant(getTextualUploadDate());
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public List<Image> getUploaderAvatars() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(this.baseUrl, this.item.getObject("account"));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderName() {
        return b.o(JsonUtils.getString(this.item, "account.name"), "@", JsonUtils.getString(this.item, "account.host"));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public String getUploaderUrl() {
        return ServiceList.PeerTube.getChannelLHFactory().fromId(b.p("accounts/", JsonUtils.getString(this.item, "account.name"), "@", JsonUtils.getString(this.item, "account.host")), this.baseUrl).getUrl();
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return b.o(this.url, "/", getCommentId());
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor
    public boolean hasCreatorReply() {
        return this.item.has("totalRepliesFromVideoAuthor") && this.item.getInt("totalRepliesFromVideoAuthor") > 0;
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
