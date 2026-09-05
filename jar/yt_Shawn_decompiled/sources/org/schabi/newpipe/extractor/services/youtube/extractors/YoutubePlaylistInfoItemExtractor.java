package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubePlaylistLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubePlaylistInfoItemExtractor implements PlaylistInfoItemExtractor {
    private final JsonObject playlistInfoItem;

    public YoutubePlaylistInfoItemExtractor(JsonObject jsonObject) {
        this.playlistInfoItem = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() throws ParsingException {
        try {
            return YoutubeParsingHelper.getTextFromObject(this.playlistInfoItem.getObject("title"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get name", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final PlaylistInfo.PlaylistType getPlaylistType() {
        return PlaylistInfo.PlaylistType.NORMAL;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public long getStreamCount() throws ParsingException {
        String string = this.playlistInfoItem.getString("videoCount");
        if (string == null) {
            string = YoutubeParsingHelper.getTextFromObject(this.playlistInfoItem.getObject("videoCountText"));
        }
        if (string == null) {
            string = YoutubeParsingHelper.getTextFromObject(this.playlistInfoItem.getObject("videoCountShortText"));
        }
        if (string == null) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get stream count");
            return 0L;
        }
        try {
            return Long.parseLong(Utils.removeNonDigitCharacters(string));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get stream count", e);
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() throws ParsingException {
        try {
            JsonArray array = this.playlistInfoItem.getArray("thumbnails").getObject(0).getArray("thumbnails");
            if (array.isEmpty()) {
                array = this.playlistInfoItem.getObject("thumbnail").getArray("thumbnails");
            }
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(array);
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get thumbnails", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderName() throws ParsingException {
        try {
            return YoutubeParsingHelper.getTextFromObject(this.playlistInfoItem.getObject("longBylineText"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get uploader name", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderUrl() throws ParsingException {
        try {
            return YoutubeParsingHelper.getUrlFromObject(this.playlistInfoItem.getObject("longBylineText"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get uploader url", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        try {
            return YoutubePlaylistLinkHandlerFactory.getInstance().getUrl(this.playlistInfoItem.getString("playlistId"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get url", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public boolean isUploaderVerified() throws ParsingException {
        try {
            return YoutubeParsingHelper.isVerified(this.playlistInfoItem.getArray("ownerBadges"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get uploader verification info", e);
            return false;
        }
    }
}
