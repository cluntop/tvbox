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
abstract class YoutubeBaseShowInfoItemExtractor implements PlaylistInfoItemExtractor {
    protected final JsonObject showRenderer;

    public YoutubeBaseShowInfoItemExtractor(JsonObject jsonObject) {
        this.showRenderer = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.showRenderer.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final PlaylistInfo.PlaylistType getPlaylistType() {
        return PlaylistInfo.PlaylistType.NORMAL;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public long getStreamCount() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.showRenderer.getObject("thumbnailOverlays").getObject("thumbnailOverlayBottomPanelRenderer").getObject("text"));
        if (textFromObject == null) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get stream count");
            return 0L;
        }
        try {
            return Long.parseLong(Utils.removeNonDigitCharacters(textFromObject));
        } catch (NumberFormatException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not convert stream count to a long", e);
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return YoutubeParsingHelper.getThumbnailsFromInfoItem(this.showRenderer.getObject("thumbnailRenderer").getObject("showCustomThumbnailRenderer"));
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.showRenderer.getObject("navigationEndpoint"));
    }
}
