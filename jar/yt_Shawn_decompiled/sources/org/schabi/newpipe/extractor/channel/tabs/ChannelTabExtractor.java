package org.schabi.newpipe.extractor.channel.tabs;

import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class ChannelTabExtractor extends ListExtractor<InfoItem> {
    public ChannelTabExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return getLinkHandler().getContentFilters().get(0);
    }
}
