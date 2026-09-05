package org.schabi.newpipe.extractor.channel;

import org.schabi.newpipe.extractor.InfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ChannelInfoItemsCollector extends InfoItemsCollector<ChannelInfoItem, ChannelInfoItemExtractor> {
    public ChannelInfoItemsCollector(int i) {
        super(i);
    }

    @Override // org.schabi.newpipe.extractor.Collector
    public ChannelInfoItem extract(ChannelInfoItemExtractor channelInfoItemExtractor) {
        ChannelInfoItem channelInfoItem = new ChannelInfoItem(getServiceId(), channelInfoItemExtractor.getUrl(), channelInfoItemExtractor.getName());
        try {
            channelInfoItem.setSubscriberCount(channelInfoItemExtractor.getSubscriberCount());
        } catch (Exception e) {
            addError(e);
        }
        try {
            channelInfoItem.setStreamCount(channelInfoItemExtractor.getStreamCount());
        } catch (Exception e2) {
            addError(e2);
        }
        try {
            channelInfoItem.setThumbnails(channelInfoItemExtractor.getThumbnails());
        } catch (Exception e3) {
            addError(e3);
        }
        try {
            channelInfoItem.setDescription(channelInfoItemExtractor.getDescription());
        } catch (Exception e4) {
            addError(e4);
        }
        try {
            channelInfoItem.setVerified(channelInfoItemExtractor.isVerified());
        } catch (Exception e5) {
            addError(e5);
        }
        return channelInfoItem;
    }
}
