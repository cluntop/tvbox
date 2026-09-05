package org.schabi.newpipe.extractor.channel;

import org.schabi.newpipe.extractor.InfoItemExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface ChannelInfoItemExtractor extends InfoItemExtractor {
    String getDescription();

    long getStreamCount();

    long getSubscriberCount();

    boolean isVerified();
}
