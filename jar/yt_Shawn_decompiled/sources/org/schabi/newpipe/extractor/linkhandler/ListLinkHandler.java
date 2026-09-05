package org.schabi.newpipe.extractor.linkhandler;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ListLinkHandler extends LinkHandler {
    protected final List<String> contentFilters;
    protected final String sortFilter;

    public ListLinkHandler(ListLinkHandler listLinkHandler) {
        this(listLinkHandler.originalUrl, listLinkHandler.url, listLinkHandler.id, listLinkHandler.contentFilters, listLinkHandler.sortFilter);
    }

    public List<String> getContentFilters() {
        return this.contentFilters;
    }

    public String getSortFilter() {
        return this.sortFilter;
    }

    public ListLinkHandler(String str, String str2, String str3, List<String> list, String str4) {
        super(str, str2, str3);
        this.contentFilters = DesugarCollections.unmodifiableList(list);
        this.sortFilter = str4;
    }

    public ListLinkHandler(LinkHandler linkHandler) {
        this(linkHandler.originalUrl, linkHandler.url, linkHandler.id, Collections.EMPTY_LIST, VideoStream.RESOLUTION_UNKNOWN);
    }
}
