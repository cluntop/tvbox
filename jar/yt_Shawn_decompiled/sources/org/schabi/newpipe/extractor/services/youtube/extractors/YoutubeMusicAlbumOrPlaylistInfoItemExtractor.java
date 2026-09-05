package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeMusicAlbumOrPlaylistInfoItemExtractor implements PlaylistInfoItemExtractor {
    private final JsonObject albumOrPlaylistInfoItem;
    private final JsonObject descriptionElementUploader;

    public YoutubeMusicAlbumOrPlaylistInfoItemExtractor(JsonObject jsonObject, JsonArray jsonArray, String str) {
        this.albumOrPlaylistInfoItem = jsonObject;
        this.descriptionElementUploader = jsonArray.getObject(YoutubeSearchQueryHandlerFactory.MUSIC_ALBUMS.equals(str) ? 2 : 0);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.albumOrPlaylistInfoItem.getArray("flexColumns").getObject(0).getObject("musicResponsiveListItemFlexColumnRenderer").getObject("text"));
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return textFromObject;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final PlaylistInfo.PlaylistType getPlaylistType() {
        return PlaylistInfo.PlaylistType.NORMAL;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public long getStreamCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() throws ParsingException {
        try {
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(this.albumOrPlaylistInfoItem.getObject("thumbnail").getObject("musicThumbnailRenderer").getObject("thumbnail").getArray("thumbnails"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get thumbnails", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderName() throws ParsingException {
        String string = this.descriptionElementUploader.getString("text");
        if (!Utils.isNullOrEmpty(string)) {
            return string;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderUrl() {
        Iterator<Object> it = this.albumOrPlaylistInfoItem.getObject("menu").getObject("menuRenderer").getArray("items").iterator();
        while (it.hasNext()) {
            JsonObject object = ((JsonObject) it.next()).getObject("menuNavigationItemRenderer");
            if (object.getObject("icon").getString("iconType", VideoStream.RESOLUTION_UNKNOWN).equals("ARTIST")) {
                return YoutubeParsingHelper.getUrlFromNavigationEndpoint(object.getObject("navigationEndpoint"));
            }
        }
        if (this.descriptionElementUploader.has("navigationEndpoint")) {
            return YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.descriptionElementUploader.getObject("navigationEndpoint"));
        }
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        String string = com.github.catvod.spider.merge.t0.a.c(this.albumOrPlaylistInfoItem.getObject("menu").getObject("menuRenderer").getArray("items").getObject(4), "toggleMenuServiceItemRenderer", "toggledServiceEndpoint", "likeEndpoint", "target").getString("playlistId");
        if (Utils.isNullOrEmpty(string)) {
            string = com.github.catvod.spider.merge.t0.a.c(this.albumOrPlaylistInfoItem, "overlay", "musicItemThumbnailOverlayRenderer", "content", "musicPlayButtonRenderer").getObject("playNavigationEndpoint").getObject("watchPlaylistEndpoint").getString("playlistId");
        }
        if (!Utils.isNullOrEmpty(string)) {
            return com.github.catvod.spider.merge.b.b.n("https://music.youtube.com/playlist?list=", string);
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get URL");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
