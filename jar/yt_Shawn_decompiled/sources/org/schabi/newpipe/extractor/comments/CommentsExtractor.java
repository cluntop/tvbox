package org.schabi.newpipe.extractor.comments;

import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class CommentsExtractor extends ListExtractor<CommentsInfoItem> {
    public CommentsExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    public int getCommentsCount() {
        return -1;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return "Comments";
    }

    public boolean isCommentsDisabled() {
        return false;
    }
}
