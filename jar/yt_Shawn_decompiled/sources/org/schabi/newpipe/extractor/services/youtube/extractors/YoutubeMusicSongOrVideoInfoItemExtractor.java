package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeMusicSongOrVideoInfoItemExtractor implements StreamInfoItemExtractor {
    private final JsonArray descriptionElements;
    private final String searchType;
    private final JsonObject songOrVideoInfoItem;

    public YoutubeMusicSongOrVideoInfoItemExtractor(JsonObject jsonObject, JsonArray jsonArray, String str) {
        this.songOrVideoInfoItem = jsonObject;
        this.descriptionElements = jsonArray;
        this.searchType = str;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final ContentAvailability getContentAvailability() {
        return ContentAvailability.UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() throws ParsingException {
        if (!Utils.isNullOrEmpty(this.descriptionElements.getObject(r0.size() - 1).getString("text"))) {
            return YoutubeParsingHelper.parseDurationString(r0);
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get duration");
        return 0L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.songOrVideoInfoItem.getArray("flexColumns").getObject(0).getObject("musicResponsiveListItemFlexColumnRenderer").getObject("text"));
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return textFromObject;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ String getShortDescription() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public StreamType getStreamType() {
        return StreamType.VIDEO_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getTextualUploadDate() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() throws ParsingException {
        try {
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(this.songOrVideoInfoItem.getObject("thumbnail").getObject("musicThumbnailRenderer").getObject("thumbnail").getArray("thumbnails"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get thumbnails", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public DateWrapper getUploadDate() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final List getUploaderAvatars() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() throws ParsingException {
        String string = this.descriptionElements.getObject(0).getString("text");
        if (!Utils.isNullOrEmpty(string)) {
            return string;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderUrl() throws ParsingException {
        boolean zEquals = this.searchType.equals(YoutubeSearchQueryHandlerFactory.MUSIC_VIDEOS);
        JsonObject jsonObject = this.songOrVideoInfoItem;
        if (zEquals) {
            Iterator<Object> it = jsonObject.getObject("menu").getObject("menuRenderer").getArray("items").iterator();
            while (it.hasNext()) {
                JsonObject object = ((JsonObject) it.next()).getObject("menuNavigationItemRenderer");
                if (object.getObject("icon").getString("iconType", VideoStream.RESOLUTION_UNKNOWN).equals("ARTIST")) {
                    return YoutubeParsingHelper.getUrlFromNavigationEndpoint(object.getObject("navigationEndpoint"));
                }
            }
            return null;
        }
        JsonObject object2 = jsonObject.getArray("flexColumns").getObject(1).getObject("musicResponsiveListItemFlexColumnRenderer").getObject("text").getArray("runs").getObject(0);
        if (!object2.has("navigationEndpoint")) {
            return null;
        }
        String urlFromNavigationEndpoint = YoutubeParsingHelper.getUrlFromNavigationEndpoint(object2.getObject("navigationEndpoint"));
        if (!Utils.isNullOrEmpty(urlFromNavigationEndpoint)) {
            return urlFromNavigationEndpoint;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader URL");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        String string = this.songOrVideoInfoItem.getObject("playlistItemData").getString(YoutubeParsingHelper.VIDEO_ID);
        if (!Utils.isNullOrEmpty(string)) {
            return com.github.catvod.spider.merge.b.b.n("https://music.youtube.com/watch?v=", string);
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get URL");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getViewCount() throws ParsingException {
        if (this.searchType.equals(YoutubeSearchQueryHandlerFactory.MUSIC_SONGS)) {
            return -1L;
        }
        String string = this.descriptionElements.getObject(r0.size() - 3).getString("text");
        if (Utils.isNullOrEmpty(string)) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get view count");
            return 0L;
        }
        try {
            return Utils.mixedNumberWordToLong(string);
        } catch (Parser.RegexException unused) {
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isAd() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public final /* synthetic */ boolean isShortFormContent() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
