package org.schabi.newpipe.extractor.search;

import java.util.List;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class SearchExtractor extends ListExtractor<InfoItem> {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public class NothingFoundException extends ExtractionException {
        public NothingFoundException(String str) {
            super(str);
        }
    }

    public SearchExtractor(StreamingService streamingService, SearchQueryHandler searchQueryHandler) {
        super(streamingService, searchQueryHandler);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor, org.schabi.newpipe.extractor.Extractor
    public SearchQueryHandler getLinkHandler() {
        return (SearchQueryHandler) super.getLinkHandler();
    }

    public abstract List<MetaInfo> getMetaInfo();

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return getLinkHandler().getSearchString();
    }

    public String getSearchString() {
        return getLinkHandler().getSearchString();
    }

    public abstract String getSearchSuggestion();

    public abstract boolean isCorrectedSearch();
}
