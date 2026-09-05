package org.schabi.newpipe.extractor.feed;

import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.s0.a;
import java.util.List;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.ListInfo;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.utils.ExtractorHelper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class FeedInfo extends ListInfo<StreamInfoItem> {
    public FeedInfo(int i, String str, String str2, String str3, String str4, List<String> list, String str5) {
        super(i, str, str2, str3, str4, list, str5);
    }

    public static FeedInfo getInfo(FeedExtractor feedExtractor) {
        feedExtractor.fetchPage();
        FeedInfo feedInfo = new FeedInfo(feedExtractor.getServiceId(), feedExtractor.getId(), feedExtractor.getUrl(), feedExtractor.getOriginalUrl(), feedExtractor.getName(), null, null);
        ListExtractor.InfoItemsPage itemsPageOrLogError = ExtractorHelper.getItemsPageOrLogError(feedInfo, feedExtractor);
        feedInfo.setRelatedItems(itemsPageOrLogError.getItems());
        feedInfo.setNextPage(itemsPageOrLogError.getNextPage());
        return feedInfo;
    }

    public static FeedInfo getInfo(StreamingService streamingService, String str) {
        FeedExtractor feedExtractor = streamingService.getFeedExtractor(str);
        if (feedExtractor != null) {
            feedExtractor.fetchPage();
            return getInfo(feedExtractor);
        }
        a.r(b.A("Service \"", streamingService.getServiceInfo().getName(), "\" doesn't support FeedExtractor."));
        return null;
    }

    public static FeedInfo getInfo(String str) {
        return getInfo(NewPipe.getServiceByUrl(str), str);
    }
}
