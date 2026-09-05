package org.schabi.newpipe.extractor.services.youtube.extractors;

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
public class YoutubeMixOrPlaylistLockupInfoItemExtractor implements PlaylistInfoItemExtractor {
    private final JsonObject firstMetadataRow;
    private final JsonObject lockupMetadataViewModel;
    private final JsonObject lockupViewModel;
    private PlaylistInfo.PlaylistType playlistType;
    private final JsonObject thumbnailViewModel;

    public YoutubeMixOrPlaylistLockupInfoItemExtractor(JsonObject jsonObject) {
        this.lockupViewModel = jsonObject;
        this.thumbnailViewModel = com.github.catvod.spider.merge.t0.a.c(jsonObject, "contentImage", "collectionThumbnailViewModel", "primaryThumbnail", "thumbnailViewModel");
        JsonObject object = jsonObject.getObject("metadata").getObject("lockupMetadataViewModel");
        this.lockupMetadataViewModel = object;
        this.firstMetadataRow = object.getObject("metadata").getObject("contentMetadataViewModel").getArray("metadataRows").getObject(0);
        try {
            this.playlistType = YoutubeParsingHelper.extractPlaylistTypeFromPlaylistId(getPlaylistId());
        } catch (ParsingException unused) {
            this.playlistType = PlaylistInfo.PlaylistType.NORMAL;
        }
    }

    private String getPlaylistId() throws ParsingException {
        String string = this.lockupViewModel.getString("contentId");
        if (Utils.isNullOrEmpty(string)) {
            string = this.lockupViewModel.getObject("rendererContext").getObject("commandContext").getObject("watchEndpoint").getString("playlistId");
        }
        if (!Utils.isNullOrEmpty(string)) {
            return string;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get playlist ID");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getStreamCount$0(JsonObject jsonObject) {
        return jsonObject.has("thumbnailOverlayBadgeViewModel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getStreamCount$1() {
        return new ParsingException("Could not get thumbnailOverlayBadgeViewModel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getStreamCount$2(JsonObject jsonObject) {
        return jsonObject.has("thumbnailBadgeViewModel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getStreamCount$3() {
        return new ParsingException("Could not get thumbnailBadgeViewModel");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.lockupMetadataViewModel.getObject("title").getString("content");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public PlaylistInfo.PlaylistType getPlaylistType() {
        return this.playlistType;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public long getStreamCount() throws ParsingException {
        if (this.playlistType != PlaylistInfo.PlaylistType.NORMAL) {
            return -2L;
        }
        try {
            return Long.parseLong(Utils.removeNonDigitCharacters(this.thumbnailViewModel.getArray("overlays").streamAsJsonObjects().filter(new n(8)).findFirst().orElseThrow(new i(4)).getObject("thumbnailOverlayBadgeViewModel").getArray("thumbnailBadges").streamAsJsonObjects().filter(new n(9)).findFirst().orElseThrow(new i(5)).getObject("thumbnailBadgeViewModel").getString("text")));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get playlist stream count", e);
            return 0L;
        }
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return YoutubeParsingHelper.getImagesFromThumbnailsArray(this.thumbnailViewModel.getObject("image").getArray("sources"));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderName() {
        return this.firstMetadataRow.getArray("metadataParts").getObject(0).getObject("text").getString("content");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderUrl() {
        if (this.playlistType != PlaylistInfo.PlaylistType.NORMAL) {
            return null;
        }
        return YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.firstMetadataRow.getArray("metadataParts").getObject(0).getObject("text").getArray("commandRuns").getObject(0).getObject("onTap").getObject("innertubeCommand"));
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        if (this.playlistType == PlaylistInfo.PlaylistType.NORMAL) {
            try {
                return YoutubePlaylistLinkHandlerFactory.getInstance().getUrl(getPlaylistId());
            } catch (Exception unused) {
            }
        }
        return YoutubeParsingHelper.getUrlFromNavigationEndpoint(this.lockupViewModel.getObject("rendererContext").getObject("commandContext").getObject("onTap").getObject("innertubeCommand"));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public boolean isUploaderVerified() {
        if (this.playlistType != PlaylistInfo.PlaylistType.NORMAL) {
            return false;
        }
        return YoutubeParsingHelper.hasArtistOrVerifiedIconBadgeAttachment(this.firstMetadataRow.getArray("metadataParts").getObject(0).getObject("text").getArray("attachmentRuns"));
    }
}
