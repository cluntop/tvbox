package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.grack.nanojson.JsonObject;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudPlaylistInfoItemExtractor implements PlaylistInfoItemExtractor {
    private static final String ARTWORK_URL_KEY = "artwork_url";
    private static final String AVATAR_URL_KEY = "avatar_url";
    private static final String USER_KEY = "user";
    private final JsonObject itemObject;

    public SoundcloudPlaylistInfoItemExtractor(JsonObject jsonObject) {
        this.itemObject = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.itemObject.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final PlaylistInfo.PlaylistType getPlaylistType() {
        return PlaylistInfo.PlaylistType.NORMAL;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public long getStreamCount() {
        return this.itemObject.getLong("track_count");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() throws ParsingException {
        if (this.itemObject.isString(ARTWORK_URL_KEY)) {
            String string = this.itemObject.getString(ARTWORK_URL_KEY);
            if (!Utils.isNullOrEmpty(string)) {
                return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(string);
            }
        }
        try {
            Iterator<Object> it = this.itemObject.getArray("tracks").iterator();
            while (it.hasNext()) {
                JsonObject jsonObject = (JsonObject) it.next();
                if (jsonObject.isString(ARTWORK_URL_KEY)) {
                    String string2 = jsonObject.getString(ARTWORK_URL_KEY);
                    if (!Utils.isNullOrEmpty(string2)) {
                        return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(string2);
                    }
                }
                String string3 = jsonObject.getObject(USER_KEY).getString(AVATAR_URL_KEY);
                if (!Utils.isNullOrEmpty(string3)) {
                    return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(string3);
                }
            }
        } catch (Exception unused) {
        }
        try {
            return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(this.itemObject.getObject(USER_KEY).getString(AVATAR_URL_KEY));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Failed to extract playlist thumbnails", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderName() throws ParsingException {
        try {
            return this.itemObject.getObject(USER_KEY).getString("username");
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Failed to extract playlist uploader", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderUrl() {
        return this.itemObject.getObject(USER_KEY).getString("permalink_url");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return Utils.replaceHttpWithHttps(this.itemObject.getString("permalink_url"));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public boolean isUploaderVerified() {
        return this.itemObject.getObject(USER_KEY).getBoolean("verified");
    }
}
