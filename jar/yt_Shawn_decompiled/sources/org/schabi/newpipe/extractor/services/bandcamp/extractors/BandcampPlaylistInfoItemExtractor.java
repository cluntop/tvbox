package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.merge.o1.n;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.Description;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampPlaylistInfoItemExtractor implements PlaylistInfoItemExtractor {
    private final n resultInfo;
    private final n searchResult;

    public BandcampPlaylistInfoItemExtractor(n nVar) {
        this.searchResult = nVar;
        this.resultInfo = (n) nVar.N("result-info").c();
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final Description getDescription() {
        return Description.EMPTY_DESCRIPTION;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.resultInfo.N("heading").g();
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public final PlaylistInfo.PlaylistType getPlaylistType() {
        return PlaylistInfo.PlaylistType.NORMAL;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public long getStreamCount() {
        return Integer.parseInt(this.resultInfo.N("length").g().split(" track")[0]);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return BandcampExtractorHelper.getImagesFromSearchResult(this.searchResult);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderName() {
        return this.resultInfo.N("subhead").g().split(" by")[0];
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public String getUploaderUrl() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.resultInfo.N("itemurl").g();
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistInfoItemExtractor
    public boolean isUploaderVerified() {
        return false;
    }
}
