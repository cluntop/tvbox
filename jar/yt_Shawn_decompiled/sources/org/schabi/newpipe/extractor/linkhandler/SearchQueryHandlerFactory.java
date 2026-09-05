package org.schabi.newpipe.extractor.linkhandler;

import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class SearchQueryHandlerFactory extends ListLinkHandlerFactory {
    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public SearchQueryHandler fromQuery(String str, List<String> list, String str2) {
        return new SearchQueryHandler(super.fromQuery(str, list, str2));
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return getSearchString(str);
    }

    public String getSearchString(String str) {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public abstract String getUrl(String str, List<String> list, String str2);

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public /* bridge */ /* synthetic */ ListLinkHandler fromQuery(String str, List list, String str2) {
        return fromQuery(str, (List<String>) list, str2);
    }

    public SearchQueryHandler fromQuery(String str) {
        return fromQuery(str, Collections.EMPTY_LIST, VideoStream.RESOLUTION_UNKNOWN);
    }
}
