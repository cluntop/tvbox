package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.github.catvod.spider.jdollar.util.Comparator;
import com.github.catvod.spider.merge.q1.w;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCRecentKiosk extends KioskExtractor<StreamInfoItem> {
    public static final String KIOSK_ID = "recent";
    private JsonObject doc;

    public MediaCCCRecentKiosk(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInitialPage$0(MediaCCCRecentKioskExtractor mediaCCCRecentKioskExtractor) {
        return mediaCCCRecentKioskExtractor.getDuration() > 0;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        JsonArray array = this.doc.getArray(MediaCCCSearchQueryHandlerFactory.EVENTS);
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId(), Comparator.EL.reversed(Comparator.CC.comparing(new d(5), Comparator.CC.nullsLast(Comparator.CC.comparing(new d(6))))));
        array.streamAsJsonObjects().map(new d(7)).filter(new c(3)).forEach(new w(2, streamInfoItemsCollector));
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return KIOSK_ID;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        return ListExtractor.InfoItemsPage.emptyPage();
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        try {
            this.doc = JsonParser.object().from(downloader.get("https://api.media.ccc.de/public/events/recent", getExtractorLocalization()).responseBody());
        } catch (JsonParserException e) {
            throw new ExtractionException("Could not parse json.", e);
        }
    }
}
