package org.schabi.newpipe.extractor.suggestion;

import java.util.List;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class SuggestionExtractor {
    private ContentCountry forcedContentCountry;
    private Localization forcedLocalization;
    private final StreamingService service;

    public SuggestionExtractor(StreamingService streamingService) {
        this.service = streamingService;
    }

    public void forceContentCountry(ContentCountry contentCountry) {
        this.forcedContentCountry = contentCountry;
    }

    public void forceLocalization(Localization localization) {
        this.forcedLocalization = localization;
    }

    public ContentCountry getExtractorContentCountry() {
        ContentCountry contentCountry = this.forcedContentCountry;
        return contentCountry == null ? getService().getContentCountry() : contentCountry;
    }

    public Localization getExtractorLocalization() {
        Localization localization = this.forcedLocalization;
        return localization == null ? getService().getLocalization() : localization;
    }

    public StreamingService getService() {
        return this.service;
    }

    public int getServiceId() {
        return this.service.getServiceId();
    }

    public abstract List<String> suggestionList(String str);
}
