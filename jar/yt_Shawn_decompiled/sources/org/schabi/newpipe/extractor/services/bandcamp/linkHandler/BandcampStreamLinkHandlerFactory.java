package org.schabi.newpipe.extractor.services.bandcamp.linkHandler;

import org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampExtractorHelper;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class BandcampStreamLinkHandlerFactory extends LinkHandlerFactory {
    private static final BandcampStreamLinkHandlerFactory INSTANCE = new BandcampStreamLinkHandlerFactory();

    private BandcampStreamLinkHandlerFactory() {
    }

    public static BandcampStreamLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return BandcampExtractorHelper.isRadioUrl(str) ? str.split("bandcamp.com/\\?show=")[1] : getUrl(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getUrl(String str) {
        return str.matches("\\d+") ? "https://bandcamp.com/?show=".concat(str) : Utils.replaceHttpWithHttps(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        if (BandcampExtractorHelper.isRadioUrl(str)) {
            return true;
        }
        if (str.toLowerCase().matches("https?://.+\\..+/track/.+")) {
            return BandcampExtractorHelper.isArtistDomain(str);
        }
        return false;
    }
}
