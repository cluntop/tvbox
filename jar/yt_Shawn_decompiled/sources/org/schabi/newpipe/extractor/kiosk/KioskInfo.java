package org.schabi.newpipe.extractor.kiosk;

import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.ListInfo;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.utils.ExtractorHelper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class KioskInfo extends ListInfo<StreamInfoItem> {
    private KioskInfo(int i, ListLinkHandler listLinkHandler, String str) {
        super(i, listLinkHandler, str);
    }

    public static KioskInfo getInfo(KioskExtractor kioskExtractor) {
        KioskInfo kioskInfo = new KioskInfo(kioskExtractor.getServiceId(), kioskExtractor.getLinkHandler(), kioskExtractor.getName());
        ListExtractor.InfoItemsPage itemsPageOrLogError = ExtractorHelper.getItemsPageOrLogError(kioskInfo, kioskExtractor);
        kioskInfo.setRelatedItems(itemsPageOrLogError.getItems());
        kioskInfo.setNextPage(itemsPageOrLogError.getNextPage());
        return kioskInfo;
    }

    public static ListExtractor.InfoItemsPage<StreamInfoItem> getMoreItems(StreamingService streamingService, String str, Page page) {
        return streamingService.getKioskList().getExtractorByUrl(str, page).getPage(page);
    }

    public static KioskInfo getInfo(StreamingService streamingService, String str) {
        KioskExtractor extractorByUrl = streamingService.getKioskList().getExtractorByUrl(str, null);
        extractorByUrl.fetchPage();
        return getInfo(extractorByUrl);
    }

    public static KioskInfo getInfo(String str) {
        return getInfo(NewPipe.getServiceByUrl(str), str);
    }
}
