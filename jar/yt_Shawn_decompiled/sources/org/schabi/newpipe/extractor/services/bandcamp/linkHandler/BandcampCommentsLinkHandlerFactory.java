package org.schabi.newpipe.extractor.services.bandcamp.linkHandler;

import java.util.List;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampExtractorHelper;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class BandcampCommentsLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final BandcampCommentsLinkHandlerFactory INSTANCE = new BandcampCommentsLinkHandlerFactory();

    private BandcampCommentsLinkHandlerFactory() {
    }

    public static BandcampCommentsLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return Utils.replaceHttpWithHttps(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return Utils.replaceHttpWithHttps(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        if (BandcampExtractorHelper.isRadioUrl(str)) {
            return true;
        }
        if (str.toLowerCase().matches("https?://.+\\..+/(track|album)/.+")) {
            return BandcampExtractorHelper.isArtistDomain(str);
        }
        return false;
    }
}
