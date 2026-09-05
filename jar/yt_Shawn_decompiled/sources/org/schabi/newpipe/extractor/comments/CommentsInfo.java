package org.schabi.newpipe.extractor.comments;

import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.ListInfo;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.utils.ExtractorHelper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class CommentsInfo extends ListInfo<CommentsInfoItem> {
    private int commentsCount;
    private boolean commentsDisabled;
    private transient CommentsExtractor commentsExtractor;

    private CommentsInfo(int i, ListLinkHandler listLinkHandler, String str) {
        super(i, listLinkHandler, str);
        this.commentsDisabled = false;
    }

    public static CommentsInfo getInfo(CommentsExtractor commentsExtractor) {
        if (commentsExtractor == null) {
            return null;
        }
        commentsExtractor.fetchPage();
        CommentsInfo commentsInfo = new CommentsInfo(commentsExtractor.getServiceId(), commentsExtractor.getLinkHandler(), commentsExtractor.getName());
        commentsInfo.setCommentsExtractor(commentsExtractor);
        ListExtractor.InfoItemsPage itemsPageOrLogError = ExtractorHelper.getItemsPageOrLogError(commentsInfo, commentsExtractor);
        commentsInfo.setCommentsDisabled(commentsExtractor.isCommentsDisabled());
        commentsInfo.setRelatedItems(itemsPageOrLogError.getItems());
        try {
            commentsInfo.setCommentsCount(commentsExtractor.getCommentsCount());
        } catch (Exception e) {
            commentsInfo.addError(e);
        }
        commentsInfo.setNextPage(itemsPageOrLogError.getNextPage());
        return commentsInfo;
    }

    public static ListExtractor.InfoItemsPage<CommentsInfoItem> getMoreItems(CommentsInfo commentsInfo, Page page) {
        return getMoreItems(NewPipe.getService(commentsInfo.getServiceId()), commentsInfo.getUrl(), page);
    }

    public int getCommentsCount() {
        return this.commentsCount;
    }

    public CommentsExtractor getCommentsExtractor() {
        return this.commentsExtractor;
    }

    public boolean isCommentsDisabled() {
        return this.commentsDisabled;
    }

    public void setCommentsCount(int i) {
        this.commentsCount = i;
    }

    public void setCommentsDisabled(boolean z) {
        this.commentsDisabled = z;
    }

    public void setCommentsExtractor(CommentsExtractor commentsExtractor) {
        this.commentsExtractor = commentsExtractor;
    }

    public static ListExtractor.InfoItemsPage<CommentsInfoItem> getMoreItems(StreamingService streamingService, CommentsInfo commentsInfo, Page page) {
        return getMoreItems(streamingService, commentsInfo.getUrl(), page);
    }

    public static ListExtractor.InfoItemsPage<CommentsInfoItem> getMoreItems(StreamingService streamingService, String str, Page page) {
        return streamingService.getCommentsExtractor(str).getPage(page);
    }

    public static CommentsInfo getInfo(StreamingService streamingService, String str) {
        return getInfo(streamingService.getCommentsExtractor(str));
    }

    public static CommentsInfo getInfo(String str) {
        return getInfo(NewPipe.getServiceByUrl(str), str);
    }
}
