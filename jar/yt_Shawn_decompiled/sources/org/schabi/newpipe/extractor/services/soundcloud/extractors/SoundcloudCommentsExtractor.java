package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.Iterator;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.comments.CommentsExtractor;
import org.schabi.newpipe.extractor.comments.CommentsInfoItem;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemsCollector;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudCommentsExtractor extends CommentsExtractor {
    public SoundcloudCommentsExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    private void collectStreamsFrom(CommentsInfoItemsCollector commentsInfoItemsCollector, JsonArray jsonArray) {
        String url = getUrl();
        Iterator<Object> it = jsonArray.iterator();
        while (it.hasNext()) {
            commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new SoundcloudCommentsInfoItemExtractor((JsonObject) it.next(), url));
        }
    }

    private ListExtractor.InfoItemsPage<CommentsInfoItem> getPage(String str) throws ParsingException {
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(NewPipe.getDownloader().get(str).responseBody());
            CommentsInfoItemsCollector commentsInfoItemsCollector = new CommentsInfoItemsCollector(getServiceId());
            collectStreamsFrom(commentsInfoItemsCollector, jsonObjectFrom.getArray("collection"));
            String string = jsonObjectFrom.getString("next_href");
            return new ListExtractor.InfoItemsPage<>(commentsInfoItemsCollector, Utils.isNullOrEmpty(string) ? null : new Page(string));
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<CommentsInfoItem> getInitialPage() {
        return getPage(getUrl());
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<CommentsInfoItem> getPage(Page page) {
        if (page != null && !Utils.isNullOrEmpty(page.getUrl())) {
            return getPage(page.getUrl());
        }
        return ListExtractor.InfoItemsPage.emptyPage();
    }
}
