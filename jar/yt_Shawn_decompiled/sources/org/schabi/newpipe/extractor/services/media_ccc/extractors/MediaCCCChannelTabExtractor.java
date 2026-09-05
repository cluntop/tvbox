package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.github.catvod.spider.jdollar.util.Objects;
import com.grack.nanojson.JsonObject;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.infoItems.MediaCCCStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCSearchQueryHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCChannelTabExtractor extends ChannelTabExtractor {
    private JsonObject conferenceData;

    public MediaCCCChannelTabExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, JsonObject jsonObject) {
        super(streamingService, listLinkHandler);
        this.conferenceData = jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInitialPage$0(MultiInfoItemsCollector multiInfoItemsCollector, JsonObject jsonObject) {
        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new MediaCCCStreamInfoItemExtractor(jsonObject));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        JsonObject jsonObject = this.conferenceData;
        Objects.requireNonNull(jsonObject);
        jsonObject.getArray(MediaCCCSearchQueryHandlerFactory.EVENTS).streamAsJsonObjects().forEach(new a(multiInfoItemsCollector, 0));
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) {
        return ListExtractor.InfoItemsPage.emptyPage();
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        if (this.conferenceData == null) {
            this.conferenceData = MediaCCCConferenceExtractor.fetchConferenceData(downloader, getId());
        }
    }
}
