package org.schabi.newpipe.extractor.services.bandcamp.extractors.streaminfoitem;

import com.grack.nanojson.JsonObject;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampExtractorHelper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampDiscographStreamInfoItemExtractor extends BandcampStreamInfoItemExtractor {
    private final JsonObject discograph;

    public BandcampDiscographStreamInfoItemExtractor(JsonObject jsonObject, String str) {
        super(str);
        this.discograph = jsonObject;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.discograph.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return BandcampExtractorHelper.getImagesFromImageId(this.discograph.getLong("art_id"), true);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() {
        return this.discograph.getString("band_name");
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return BandcampExtractorHelper.getStreamUrlFromIds(this.discograph.getLong("band_id"), this.discograph.getLong("item_id"), this.discograph.getString("item_type"));
    }
}
