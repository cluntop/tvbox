package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.Objects;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.utils.ExtractorLogger;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class Extractor {
    private final Downloader downloader;
    private final LinkHandler linkHandler;
    private final StreamingService service;
    private final String TAG = getClass().getSimpleName() + "@" + hashCode();
    private Localization forcedLocalization = null;
    private ContentCountry forcedContentCountry = null;
    private boolean pageFetched = false;

    public Extractor(StreamingService streamingService, LinkHandler linkHandler) {
        Objects.requireNonNull(streamingService, "service is null");
        this.service = streamingService;
        Objects.requireNonNull(linkHandler, "LinkHandler is null");
        this.linkHandler = linkHandler;
        Downloader downloader = NewPipe.getDownloader();
        Objects.requireNonNull(downloader, "downloader is null");
        this.downloader = downloader;
    }

    public void assertPageFetched() {
        if (this.pageFetched) {
            return;
        }
        com.github.catvod.spider.merge.s0.a.h("Page is not fetched. Make sure you call fetchPage()");
    }

    public void fetchPage() {
        ExtractorLogger.d(this.TAG, "base fetchPage called");
        if (this.pageFetched) {
            ExtractorLogger.d(this.TAG, "Page already fetched; returning");
        } else {
            onFetchPage(this.downloader);
            this.pageFetched = true;
        }
    }

    public void forceContentCountry(ContentCountry contentCountry) {
        this.forcedContentCountry = contentCountry;
    }

    public void forceLocalization(Localization localization) {
        this.forcedLocalization = localization;
    }

    public String getBaseUrl() {
        return this.linkHandler.getBaseUrl();
    }

    public Downloader getDownloader() {
        return this.downloader;
    }

    public ContentCountry getExtractorContentCountry() {
        ContentCountry contentCountry = this.forcedContentCountry;
        return contentCountry == null ? getService().getContentCountry() : contentCountry;
    }

    public Localization getExtractorLocalization() {
        Localization localization = this.forcedLocalization;
        return localization == null ? getService().getLocalization() : localization;
    }

    public String getId() {
        return this.linkHandler.getId();
    }

    public LinkHandler getLinkHandler() {
        return this.linkHandler;
    }

    public abstract String getName();

    public String getOriginalUrl() {
        return this.linkHandler.getOriginalUrl();
    }

    public StreamingService getService() {
        return this.service;
    }

    public int getServiceId() {
        return this.service.getServiceId();
    }

    public TimeAgoParser getTimeAgoParser() {
        return getService().getTimeAgoParser(getExtractorLocalization());
    }

    public String getUrl() {
        return this.linkHandler.getUrl();
    }

    public boolean isPageFetched() {
        return this.pageFetched;
    }

    public abstract void onFetchPage(Downloader downloader);

    public String toString() {
        return getClass().getSimpleName();
    }
}
