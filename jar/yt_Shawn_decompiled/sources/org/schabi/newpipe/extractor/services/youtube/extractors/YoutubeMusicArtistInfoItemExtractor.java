package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeMusicArtistInfoItemExtractor implements ChannelInfoItemExtractor {
    private final JsonObject artistInfoItem;

    public YoutubeMusicArtistInfoItemExtractor(JsonObject jsonObject) {
        this.artistInfoItem = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public String getDescription() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() throws ParsingException {
        String textFromObject = YoutubeParsingHelper.getTextFromObject(this.artistInfoItem.getArray("flexColumns").getObject(0).getObject("musicResponsiveListItemFlexColumnRenderer").getObject("text"));
        if (!Utils.isNullOrEmpty(textFromObject)) {
            return textFromObject;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get name");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getStreamCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getSubscriberCount() throws ParsingException {
        String string = this.artistInfoItem.getArray("flexColumns").getObject(r0.size() - 1).getObject("musicResponsiveListItemFlexColumnRenderer").getObject("text").getArray("runs").getObject(r0.size() - 1).getString("text");
        if (Utils.isNullOrEmpty(string)) {
            org.schabi.newpipe.extractor.utils.c.a("Could not get subscriber count");
            return 0L;
        }
        try {
            return Utils.mixedNumberWordToLong(string);
        } catch (Parser.RegexException unused) {
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() throws ParsingException {
        try {
            return YoutubeParsingHelper.getImagesFromThumbnailsArray(this.artistInfoItem.getObject("thumbnail").getObject("musicThumbnailRenderer").getObject("thumbnail").getArray("thumbnails"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get thumbnails", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() throws ParsingException {
        String urlFromNavigationEndpoint = YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.artistInfoItem.getObject("navigationEndpoint"));
        if (!Utils.isNullOrEmpty(urlFromNavigationEndpoint)) {
            return urlFromNavigationEndpoint;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get URL");
        return null;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public boolean isVerified() {
        return true;
    }
}
