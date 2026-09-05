package org.schabi.newpipe.extractor.services.youtube.extractors;

import java.io.Serializable;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
final class ItagInfo implements Serializable {
    private final String content;
    private boolean isUrl;
    private final ItagItem itagItem;

    public ItagInfo(String str, ItagItem itagItem) {
        this.content = str;
        this.itagItem = itagItem;
    }

    public String getContent() {
        return this.content;
    }

    public boolean getIsUrl() {
        return this.isUrl;
    }

    public ItagItem getItagItem() {
        return this.itagItem;
    }

    public void setIsUrl(boolean z) {
        this.isUrl = z;
    }
}
