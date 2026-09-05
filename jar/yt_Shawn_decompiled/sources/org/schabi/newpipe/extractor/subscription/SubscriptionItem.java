package org.schabi.newpipe.extractor.subscription;

import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SubscriptionItem implements Serializable {
    private final String name;
    private final int serviceId;
    private final String url;

    public SubscriptionItem(int i, String str, String str2) {
        this.serviceId = i;
        this.url = str;
        this.name = str2;
    }

    public String getName() {
        return this.name;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[name=" + this.name + " > " + this.serviceId + ":" + this.url + "]";
    }
}
