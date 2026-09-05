package org.schabi.newpipe.extractor.services.peertube.extractors;

import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.suggestion.SuggestionExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeSuggestionExtractor extends SuggestionExtractor {
    public PeertubeSuggestionExtractor(StreamingService streamingService) {
        super(streamingService);
    }

    @Override // org.schabi.newpipe.extractor.suggestion.SuggestionExtractor
    public List<String> suggestionList(String str) {
        return Collections.EMPTY_LIST;
    }
}
