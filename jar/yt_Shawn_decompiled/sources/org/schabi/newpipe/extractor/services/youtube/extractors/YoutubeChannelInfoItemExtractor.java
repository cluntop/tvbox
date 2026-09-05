package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeChannelInfoItemExtractor implements ChannelInfoItemExtractor {
    private final JsonObject channelInfoItem;
    private final boolean withHandle;

    public YoutubeChannelInfoItemExtractor(JsonObject jsonObject) {
        this.channelInfoItem = jsonObject;
        String textFromObject = YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("subscriberCountText"));
        this.withHandle = textFromObject != null ? textFromObject.startsWith("@") : false;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public String getDescription() throws ParsingException {
        try {
            if (this.channelInfoItem.has("descriptionSnippet")) {
                return YoutubeParsingHelper.getTextFromObject(this.channelInfoItem.getObject("descriptionSnippet"));
            }
            return null;
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get description", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() throws ParsingException {
        try {
            return YoutubeParsingHelper.getTextFromObject(this.channelInfoItem.getObject("title"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get name", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getStreamCount() throws ParsingException {
        try {
            if (!this.withHandle && this.channelInfoItem.has("videoCountText")) {
                return Long.parseLong(Utils.removeNonDigitCharacters(YoutubeParsingHelper.getTextFromObject(this.channelInfoItem.getObject("videoCountText"))));
            }
            return -1L;
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get stream count", e);
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getSubscriberCount() throws ParsingException {
        try {
            if (!this.channelInfoItem.has("subscriberCountText")) {
                return -1L;
            }
            boolean z = this.withHandle;
            JsonObject jsonObject = this.channelInfoItem;
            if (!z) {
                return Utils.mixedNumberWordToLong(YoutubeParsingHelper.getTextFromObject(jsonObject.getObject("subscriberCountText")));
            }
            if (jsonObject.has("videoCountText")) {
                return Utils.mixedNumberWordToLong(YoutubeParsingHelper.getTextFromObject(this.channelInfoItem.getObject("videoCountText")));
            }
            return -1L;
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get subscriber count", e);
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() throws ParsingException {
        try {
            return YoutubeParsingHelper.getThumbnailsFromInfoItem(this.channelInfoItem);
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get thumbnails", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        try {
            return YoutubeChannelLinkHandlerFactory.getInstance().getUrl("channel/" + this.channelInfoItem.getString("channelId"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get url", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public boolean isVerified() {
        return YoutubeParsingHelper.isVerified(this.channelInfoItem.getArray("ownerBadges"));
    }
}
