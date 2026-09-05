package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.github.catvod.spider.merge.u.c2;
import java.util.Iterator;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ContentNotAvailableException;
import org.schabi.newpipe.extractor.feed.FeedExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeFeedExtractor extends FeedExtractor {
    private static final String WEBSITE_CHANNEL_BASE_URL = "https://www.youtube.com/channel/";
    private com.github.catvod.spider.merge.o1.h document;

    public YoutubeFeedExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getId() {
        return getUrl().replace(WEBSITE_CHANNEL_BASE_URL, VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        com.github.catvod.spider.merge.q1.e eVarT = this.document.T("feed > entry");
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        Iterator<E> it = eVarT.iterator();
        while (it.hasNext()) {
            streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeFeedInfoItemExtractor((com.github.catvod.spider.merge.o1.n) it.next()));
        }
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) this.document.T("feed > author > name").c();
        return nVar == null ? VideoStream.RESOLUTION_UNKNOWN : nVar.U();
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        return ListExtractor.InfoItemsPage.emptyPage();
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getUrl() {
        com.github.catvod.spider.merge.o1.n nVar = (com.github.catvod.spider.merge.o1.n) this.document.T("feed > author > uri").c();
        if (nVar != null) {
            String strU = nVar.U();
            if (!strU.equals(VideoStream.RESOLUTION_UNKNOWN)) {
                return strU;
            }
        }
        com.github.catvod.spider.merge.o1.n nVar2 = (com.github.catvod.spider.merge.o1.n) this.document.T("feed > link[rel*=alternate]").c();
        return nVar2 != null ? nVar2.b("href") : VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ContentNotAvailableException {
        Response response = downloader.get(YoutubeParsingHelper.getFeedUrlFrom(getLinkHandler().getId()));
        if (response.responseCode() == 404) {
            throw new ContentNotAvailableException("Could not get feed: 404 - not found");
        }
        this.document = c2.T(response.responseBody());
    }
}
