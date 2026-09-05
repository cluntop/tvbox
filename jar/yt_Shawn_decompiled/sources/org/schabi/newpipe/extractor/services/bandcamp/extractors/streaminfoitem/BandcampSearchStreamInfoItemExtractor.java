package org.schabi.newpipe.extractor.services.bandcamp.extractors.streaminfoitem;

import com.github.catvod.spider.merge.o1.n;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampExtractorHelper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampSearchStreamInfoItemExtractor extends BandcampStreamInfoItemExtractor {
    private final n resultInfo;
    private final n searchResult;

    public BandcampSearchStreamInfoItemExtractor(n nVar, String str) {
        super(str);
        this.searchResult = nVar;
        this.resultInfo = (n) nVar.N("result-info").c();
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public long getDuration() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.resultInfo.N("heading").g();
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return BandcampExtractorHelper.getImagesFromSearchResult(this.searchResult);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
    public String getUploaderName() {
        String[] strArrSplit = this.resultInfo.N("subhead").g().split("by ");
        return strArrSplit.length > 1 ? strArrSplit[1] : strArrSplit[0];
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.resultInfo.N("itemurl").g();
    }
}
