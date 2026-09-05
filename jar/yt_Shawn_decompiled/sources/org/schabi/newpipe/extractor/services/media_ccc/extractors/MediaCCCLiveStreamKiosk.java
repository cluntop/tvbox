package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCLiveStreamKiosk extends KioskExtractor<StreamInfoItem> {
    public static final String KIOSK_ID = "live";
    private JsonArray doc;

    public MediaCCCLiveStreamKiosk(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        for (int i = 0; i < this.doc.size(); i++) {
            JsonObject object = this.doc.getObject(i);
            if (object.getBoolean("isCurrentlyStreaming")) {
                JsonArray array = object.getArray("groups");
                for (int i2 = 0; i2 < array.size(); i2++) {
                    String string = array.getObject(i2).getString("group");
                    JsonArray array2 = array.getObject(i2).getArray("rooms");
                    for (int i3 = 0; i3 < array2.size(); i3++) {
                        streamInfoItemsCollector.commit((StreamInfoItemExtractor) new MediaCCCLiveStreamKioskExtractor(object, string, array2.getObject(i3)));
                    }
                }
            }
        }
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return "live";
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        return ListExtractor.InfoItemsPage.emptyPage();
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        this.doc = MediaCCCParsingHelper.getLiveStreams(downloader, getExtractorLocalization());
    }
}
