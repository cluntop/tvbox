package org.schabi.newpipe.extractor;

import java.util.List;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class ListInfo<T extends InfoItem> extends Info {
    private final List<String> contentFilters;
    private Page nextPage;
    private List<T> relatedItems;
    private final String sortFilter;

    public ListInfo(int i, ListLinkHandler listLinkHandler, String str) {
        super(i, listLinkHandler, str);
        this.nextPage = null;
        this.contentFilters = listLinkHandler.getContentFilters();
        this.sortFilter = listLinkHandler.getSortFilter();
    }

    public List<String> getContentFilters() {
        return this.contentFilters;
    }

    public Page getNextPage() {
        return this.nextPage;
    }

    public List<T> getRelatedItems() {
        return this.relatedItems;
    }

    public String getSortFilter() {
        return this.sortFilter;
    }

    public boolean hasNextPage() {
        return Page.isValid(this.nextPage);
    }

    public void setNextPage(Page page) {
        this.nextPage = page;
    }

    public void setRelatedItems(List<T> list) {
        this.relatedItems = list;
    }

    public ListInfo(int i, String str, String str2, String str3, String str4, List<String> list, String str5) {
        super(i, str, str2, str3, str4);
        this.nextPage = null;
        this.contentFilters = list;
        this.sortFilter = str5;
    }
}
