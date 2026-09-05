package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.s0.a;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.comments.CommentsExtractor;
import org.schabi.newpipe.extractor.comments.CommentsInfoItem;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemsCollector;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeCommentsExtractor extends CommentsExtractor {
    static final String CHILDREN = "children";
    private static final String IS_DELETED = "isDeleted";
    private static final String TOTAL = "total";
    private Boolean isReply;

    public PeertubeCommentsExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
        this.isReply = null;
    }

    private void collectCommentsFrom(CommentsInfoItemsCollector commentsInfoItemsCollector, JsonObject jsonObject) {
        Iterator<Object> it = jsonObject.getArray("data").iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JsonObject) {
                JsonObject jsonObject2 = (JsonObject) next;
                if (!jsonObject2.getBoolean(IS_DELETED)) {
                    commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new PeertubeCommentsInfoItemExtractor(jsonObject2, null, getUrl(), getBaseUrl(), isReply()));
                }
            }
        }
    }

    private void collectRepliesFrom(CommentsInfoItemsCollector commentsInfoItemsCollector, JsonObject jsonObject) {
        Iterator<Object> it = jsonObject.getArray(CHILDREN).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JsonObject) {
                JsonObject jsonObject2 = (JsonObject) next;
                JsonObject object = jsonObject2.getObject("comment");
                JsonArray array = jsonObject2.getArray(CHILDREN);
                if (!object.getBoolean(IS_DELETED)) {
                    commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new PeertubeCommentsInfoItemExtractor(object, array, getUrl(), getBaseUrl(), isReply()));
                }
            }
        }
    }

    private boolean isReply() {
        if (this.isReply == null) {
            if (getOriginalUrl().contains("/videos/watch/")) {
                this.isReply = Boolean.FALSE;
            } else {
                this.isReply = Boolean.valueOf(getOriginalUrl().contains("/comment-threads/"));
            }
        }
        return this.isReply.booleanValue();
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<CommentsInfoItem> getInitialPage() {
        return isReply() ? getPage(new Page(getOriginalUrl())) : getPage(new Page(b.z(getUrl(), "?start=0&count=12")));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<CommentsInfoItem> getPage(Page page) throws ExtractionException {
        long size;
        JsonObject jsonObjectFrom = null;
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            a.r("Page doesn't contain an URL");
            return null;
        }
        CommentsInfoItemsCollector commentsInfoItemsCollector = new CommentsInfoItemsCollector(getServiceId());
        if (page.getBody() == null) {
            Response response = getDownloader().get(page.getUrl());
            if (response != null && !Utils.isBlank(response.responseBody())) {
                try {
                    jsonObjectFrom = JsonParser.object().from(response.responseBody());
                } catch (Exception e) {
                    a.m("Could not parse json data for comments info", e);
                    return null;
                }
            }
            if (jsonObjectFrom == null) {
                throw new ExtractionException("Unable to get PeerTube kiosk info");
            }
            PeertubeParsingHelper.validate(jsonObjectFrom);
            if (isReply() || jsonObjectFrom.has(CHILDREN)) {
                size = jsonObjectFrom.getArray(CHILDREN).size();
                collectRepliesFrom(commentsInfoItemsCollector, jsonObjectFrom);
            } else {
                size = jsonObjectFrom.getLong(TOTAL);
                collectCommentsFrom(commentsInfoItemsCollector, jsonObjectFrom);
            }
        } else {
            try {
                JsonObject jsonObjectFrom2 = JsonParser.object().from(new String(page.getBody(), StandardCharsets.UTF_8));
                this.isReply = Boolean.TRUE;
                long size2 = jsonObjectFrom2.getArray(CHILDREN).size();
                collectRepliesFrom(commentsInfoItemsCollector, jsonObjectFrom2);
                size = size2;
            } catch (JsonParserException e2) {
                a.m("Could not parse json data for nested comments  info", e2);
                return null;
            }
        }
        return new ListExtractor.InfoItemsPage<>(commentsInfoItemsCollector, PeertubeParsingHelper.getNextPage(page.getUrl(), size));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
    }
}
