package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeMixOrPlaylistInfoItemExtractor implements PlaylistInfoItemExtractor {
    private final JsonObject mixInfoItem;

    public YoutubeMixOrPlaylistInfoItemExtractor(JsonObject jsonObject) {
        this.mixInfoItem = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.mixInfoItem.getObject("title"));
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return textFromObject;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public PlaylistInfo.PlaylistType getPlaylistType() {
        return YoutubeParsingHelper.extractPlaylistTypeFromPlaylistUrl(getUrl());
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public long getStreamCount() throws ParsingException {
        if (YoutubeParsingHelper.getTextFromObject(this.mixInfoItem.getObject("videoCountShortText")) != null) {
            try {
                return Integer.parseInt(r0);
            } catch (NumberFormatException unused) {
                return -2L;
            }
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not extract item count for playlist/mix info item");
        return 0L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return YoutubeParsingHelper.getThumbnailsFromInfoItem(this.mixInfoItem);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderName() {
        return YoutubeParsingHelper.getTextFromObject(this.mixInfoItem.getObject("longBylineText"));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderUrl() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        String string = this.mixInfoItem.getString("shareUrl");
        if (!Utils.isNullOrEmpty(string)) {
            return string;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get url");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
