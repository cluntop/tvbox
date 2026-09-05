package org.schabi.newpipe.extractor.kiosk;

import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class KioskExtractor<T extends InfoItem> extends ListExtractor<T> {
    private final String id;

    public KioskExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler);
        this.id = str;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getId() {
        return this.id;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public abstract String getName();
}
