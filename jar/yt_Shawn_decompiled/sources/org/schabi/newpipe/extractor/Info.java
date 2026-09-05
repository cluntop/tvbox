package org.schabi.newpipe.extractor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ExtractorLogger;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class Info implements Serializable {
    private static final String TAG = "Info";
    private final List<Throwable> errors;
    private final String id;
    private final String name;
    private String originalUrl;
    private final int serviceId;
    private final String url;

    public Info(int i, String str, String str2, String str3, String str4) {
        this.errors = new ArrayList();
        this.serviceId = i;
        this.id = str;
        this.url = str2;
        this.originalUrl = str3;
        this.name = str4;
        ExtractorLogger.d(TAG, "Base Created {}", this);
    }

    public void addAllErrors(Collection<Throwable> collection) {
        this.errors.addAll(collection);
    }

    public void addError(Throwable th) {
        this.errors.add(th);
    }

    public List<Throwable> getErrors() {
        return this.errors;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public StreamingService getService() {
        try {
            return NewPipe.getService(this.serviceId);
        } catch (ExtractionException e) {
            throw new RuntimeException("Info object has invalid service id", e);
        }
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setOriginalUrl(String str) {
        this.originalUrl = str;
    }

    public String toString() {
        String strA = this.url.equals(this.originalUrl) ? VideoStream.RESOLUTION_UNKNOWN : com.github.catvod.spider.merge.b.b.A(" (originalUrl=\"", this.originalUrl, "\")");
        return getClass().getSimpleName() + "[url=\"" + this.url + "\"" + strA + ", name=\"" + this.name + "\"]";
    }

    public Info(int i, LinkHandler linkHandler, String str) {
        this(i, linkHandler.getId(), linkHandler.getUrl(), linkHandler.getOriginalUrl(), str);
    }
}
