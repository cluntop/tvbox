package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampPlaylistInfoItemFeaturedExtractor implements PlaylistInfoItemExtractor {
    private final JsonObject featuredStory;

    public BandcampPlaylistInfoItemFeaturedExtractor(JsonObject jsonObject) {
        this.featuredStory = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.featuredStory.getString("album_title");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final PlaylistInfo.PlaylistType getPlaylistType() {
        return PlaylistInfo.PlaylistType.NORMAL;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public long getStreamCount() {
        return this.featuredStory.getInt("num_streamable_tracks");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        boolean zHas = this.featuredStory.has("art_id");
        JsonObject jsonObject = this.featuredStory;
        return zHas ? BandcampExtractorHelper.getImagesFromImageId(jsonObject.getLong("art_id"), true) : BandcampExtractorHelper.getImagesFromImageId(jsonObject.getLong("item_art_id"), true);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderName() {
        return this.featuredStory.getString("band_name");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderUrl() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return Utils.replaceHttpWithHttps(this.featuredStory.getString("item_url"));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
