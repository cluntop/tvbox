package org.schabi.newpipe.extractor.utils;

import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Info;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.InfoItemsCollector;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfo;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ExtractorHelper {
    private ExtractorHelper() {
    }

    public static <T extends InfoItem> ListExtractor.InfoItemsPage<T> getItemsPageOrLogError(Info info, ListExtractor<T> listExtractor) {
        try {
            ListExtractor.InfoItemsPage<T> infoItemsPage = (ListExtractor.InfoItemsPage<T>) listExtractor.getInitialPage();
            info.addAllErrors(infoItemsPage.getErrors());
            return infoItemsPage;
        } catch (Exception e) {
            info.addError(e);
            return ListExtractor.InfoItemsPage.emptyPage();
        }
    }

    public static List<InfoItem> getRelatedItemsOrLogError(StreamInfo streamInfo, StreamExtractor streamExtractor) {
        try {
            InfoItemsCollector<? extends InfoItem, ? extends InfoItemExtractor> relatedItems = streamExtractor.getRelatedItems();
            if (relatedItems == null) {
                return Collections.EMPTY_LIST;
            }
            streamInfo.addAllErrors(relatedItems.getErrors());
            return relatedItems.getItems();
        } catch (Exception e) {
            streamInfo.addError(e);
            return Collections.EMPTY_LIST;
        }
    }

    @Deprecated
    public static List<InfoItem> getRelatedVideosOrLogError(StreamInfo streamInfo, StreamExtractor streamExtractor) {
        return getRelatedItemsOrLogError(streamInfo, streamExtractor);
    }
}
