package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonObject;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
class YoutubeShowRendererInfoItemExtractor extends YoutubeBaseShowInfoItemExtractor {
    private final JsonObject longBylineText;
    private final JsonObject shortBylineText;

    public YoutubeShowRendererInfoItemExtractor(JsonObject jsonObject) {
        super(jsonObject);
        this.shortBylineText = jsonObject.getObject("shortBylineText");
        this.longBylineText = jsonObject.getObject("longBylineText");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderName() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.longBylineText);
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return textFromObject;
        }
        String textFromObject2 = YoutubeParsingHelper.getTextFromObject(this.shortBylineText);
        if (!Utils.isNullOrEmpty(textFromObject2)) {
            return textFromObject2;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderUrl() throws ParsingException {
        String urlFromObject = YoutubeParsingHelper.getUrlFromObject(this.longBylineText);
        if (urlFromObject != null) {
            return urlFromObject;
        }
        String urlFromObject2 = YoutubeParsingHelper.getUrlFromObject(this.shortBylineText);
        if (urlFromObject2 != null) {
            return urlFromObject2;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get uploader URL");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
