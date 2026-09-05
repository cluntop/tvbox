package org.schabi.newpipe.extractor.channel;

import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Extractor;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class ChannelExtractor extends Extractor {
    public static final long UNKNOWN_SUBSCRIBER_COUNT = -1;

    public ChannelExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    public abstract List<Image> getAvatars();

    public abstract List<Image> getBanners();

    public abstract String getDescription();

    public abstract String getFeedUrl();

    public abstract List<Image> getParentChannelAvatars();

    public abstract String getParentChannelName();

    public abstract String getParentChannelUrl();

    public abstract long getSubscriberCount();

    public abstract List<ListLinkHandler> getTabs();

    public List<String> getTags() {
        return Collections.EMPTY_LIST;
    }

    public abstract boolean isVerified();
}
