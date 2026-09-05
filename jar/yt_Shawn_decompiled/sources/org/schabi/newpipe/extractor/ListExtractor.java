package org.schabi.newpipe.extractor;

import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class ListExtractor<R extends InfoItem> extends Extractor {
    public static final long ITEM_COUNT_INFINITE = -2;
    public static final long ITEM_COUNT_MORE_THAN_100 = -3;
    public static final long ITEM_COUNT_UNKNOWN = -1;

    public ListExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    public abstract InfoItemsPage<R> getInitialPage();

    @Override // org.schabi.newpipe.extractor.Extractor
    public ListLinkHandler getLinkHandler() {
        return (ListLinkHandler) super.getLinkHandler();
    }

    public abstract InfoItemsPage<R> getPage(Page page);

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public class InfoItemsPage<T extends InfoItem> {
        private static final InfoItemsPage<InfoItem> EMPTY;
        private final List<Throwable> errors;
        private final List<T> itemsList;
        private final Page nextPage;

        static {
            List list = Collections.EMPTY_LIST;
            EMPTY = new InfoItemsPage<>(list, null, list);
        }

        public InfoItemsPage(InfoItemsCollector<T, ?> infoItemsCollector, Page page) {
            this(infoItemsCollector.getItems(), page, infoItemsCollector.getErrors());
        }

        public static <T extends InfoItem> InfoItemsPage<T> emptyPage() {
            return (InfoItemsPage<T>) EMPTY;
        }

        public List<Throwable> getErrors() {
            return this.errors;
        }

        public List<T> getItems() {
            return this.itemsList;
        }

        public Page getNextPage() {
            return this.nextPage;
        }

        public boolean hasNextPage() {
            return Page.isValid(this.nextPage);
        }

        public InfoItemsPage(List<T> list, Page page, List<Throwable> list2) {
            this.itemsList = list;
            this.nextPage = page;
            this.errors = list2;
        }
    }
}
