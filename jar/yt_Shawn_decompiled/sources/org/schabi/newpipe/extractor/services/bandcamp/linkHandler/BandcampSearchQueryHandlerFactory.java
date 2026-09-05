package org.schabi.newpipe.extractor.services.bandcamp.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.util.List;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class BandcampSearchQueryHandlerFactory extends SearchQueryHandlerFactory {
    private static final BandcampSearchQueryHandlerFactory INSTANCE = new BandcampSearchQueryHandlerFactory();

    private BandcampSearchQueryHandlerFactory() {
    }

    public static BandcampSearchQueryHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.SearchQueryHandlerFactory, org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return b.A("https://bandcamp.com/search?q=", Utils.encodeUrlUtf8(str), "&page=1");
    }
}
