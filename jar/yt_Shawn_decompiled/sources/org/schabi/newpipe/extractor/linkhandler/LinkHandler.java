package org.schabi.newpipe.extractor.linkhandler;

import java.io.Serializable;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class LinkHandler implements Serializable {
    protected final String id;
    protected final String originalUrl;
    protected final String url;

    public LinkHandler(String str, String str2, String str3) {
        this.originalUrl = str;
        this.url = str2;
        this.id = str3;
    }

    public String getBaseUrl() {
        return Utils.getBaseUrl(this.url);
    }

    public String getId() {
        return this.id;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public LinkHandler(LinkHandler linkHandler) {
        this(linkHandler.originalUrl, linkHandler.url, linkHandler.id);
    }
}
