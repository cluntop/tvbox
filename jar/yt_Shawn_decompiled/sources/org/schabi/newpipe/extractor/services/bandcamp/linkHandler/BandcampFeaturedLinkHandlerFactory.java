package org.schabi.newpipe.extractor.services.bandcamp.linkHandler;

import java.util.List;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampExtractorHelper;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampFeaturedExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampRadioExtractor;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class BandcampFeaturedLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final BandcampFeaturedLinkHandlerFactory INSTANCE = new BandcampFeaturedLinkHandlerFactory();

    private BandcampFeaturedLinkHandlerFactory() {
    }

    public static BandcampFeaturedLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        String strReplaceHttpWithHttps = Utils.replaceHttpWithHttps(str);
        if (BandcampExtractorHelper.isRadioUrl(strReplaceHttpWithHttps) || strReplaceHttpWithHttps.equals(BandcampRadioExtractor.RADIO_API_URL)) {
            return BandcampRadioExtractor.KIOSK_RADIO;
        }
        if (strReplaceHttpWithHttps.equals(BandcampFeaturedExtractor.FEATURED_API_URL)) {
            return BandcampFeaturedExtractor.KIOSK_FEATURED;
        }
        return null;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        if (str.equals(BandcampFeaturedExtractor.KIOSK_FEATURED)) {
            return BandcampFeaturedExtractor.FEATURED_API_URL;
        }
        if (str.equals(BandcampRadioExtractor.KIOSK_RADIO)) {
            return BandcampRadioExtractor.RADIO_API_URL;
        }
        return null;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        String strReplaceHttpWithHttps = Utils.replaceHttpWithHttps(str);
        return strReplaceHttpWithHttps.equals(BandcampFeaturedExtractor.FEATURED_API_URL) || strReplaceHttpWithHttps.equals(BandcampRadioExtractor.RADIO_API_URL) || BandcampExtractorHelper.isRadioUrl(strReplaceHttpWithHttps);
    }
}
