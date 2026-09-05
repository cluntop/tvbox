package org.schabi.newpipe.extractor.channel;

import org.schabi.newpipe.extractor.InfoItem;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ChannelInfoItem extends InfoItem {
    private String description;
    private long streamCount;
    private long subscriberCount;
    private boolean verified;

    public ChannelInfoItem(int i, String str, String str2) {
        super(InfoItem.InfoType.CHANNEL, i, str, str2);
        this.subscriberCount = -1L;
        this.streamCount = -1L;
        this.verified = false;
    }

    public String getDescription() {
        return this.description;
    }

    public long getStreamCount() {
        return this.streamCount;
    }

    public long getSubscriberCount() {
        return this.subscriberCount;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setStreamCount(long j) {
        this.streamCount = j;
    }

    public void setSubscriberCount(long j) {
        this.subscriberCount = j;
    }

    public void setVerified(boolean z) {
        this.verified = z;
    }
}
