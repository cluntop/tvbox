package org.schabi.newpipe.extractor.services.media_ccc.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.util.List;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class MediaCCCSearchQueryHandlerFactory extends SearchQueryHandlerFactory {
    public static final String ALL = "all";
    public static final String CONFERENCES = "conferences";
    public static final String EVENTS = "events";
    private static final MediaCCCSearchQueryHandlerFactory INSTANCE = new MediaCCCSearchQueryHandlerFactory();

    private MediaCCCSearchQueryHandlerFactory() {
    }

    public static MediaCCCSearchQueryHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableContentFilter() {
        return new String[]{"all", "conferences", EVENTS};
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableSortFilter() {
        return new String[0];
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory, org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return b.n("https://media.ccc.de/public/events/search?q=", Utils.encodeUrlUtf8(str));
    }
}
