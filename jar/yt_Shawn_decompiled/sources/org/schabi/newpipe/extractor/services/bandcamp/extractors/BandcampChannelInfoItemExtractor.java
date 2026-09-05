package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.merge.o1.n;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampChannelInfoItemExtractor implements ChannelInfoItemExtractor {
    private final n resultInfo;
    private final n searchResult;

    public BandcampChannelInfoItemExtractor(n nVar) {
        this.searchResult = nVar;
        this.resultInfo = (n) nVar.N("result-info").c();
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public String getDescription() {
        return this.resultInfo.N("subhead").g();
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getName() {
        return this.resultInfo.N("heading").g();
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getStreamCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public long getSubscriberCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public List<Image> getThumbnails() {
        return BandcampExtractorHelper.getImagesFromSearchResult(this.searchResult);
    }

    @Override // org.schabi.newpipe.extractor.InfoItemExtractor
    public String getUrl() {
        return this.resultInfo.N("itemurl").g();
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelInfoItemExtractor
    public boolean isVerified() {
        return false;
    }
}
