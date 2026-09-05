package org.schabi.newpipe.extractor.linkhandler;

import java.util.List;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SearchQueryHandler extends ListLinkHandler {
    public SearchQueryHandler(ListLinkHandler listLinkHandler) {
        this(listLinkHandler.originalUrl, listLinkHandler.url, listLinkHandler.id, listLinkHandler.contentFilters, listLinkHandler.sortFilter);
    }

    public String getSearchString() {
        return getId();
    }

    public SearchQueryHandler(String str, String str2, String str3, List<String> list, String str4) {
        super(str, str2, str3, list, str4);
    }
}
