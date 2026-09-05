package org.schabi.newpipe.extractor.services.soundcloud.linkHandler;

import java.util.List;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class SoundcloudChartsLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final SoundcloudChartsLinkHandlerFactory INSTANCE = new SoundcloudChartsLinkHandlerFactory();
    private static final String URL_PATTERN = "^https?://(www\\.|m\\.)?soundcloud.com/charts(/top|/new)?/?([#?].*)?$";

    private SoundcloudChartsLinkHandlerFactory() {
    }

    public static SoundcloudChartsLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return "New & hot";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return "https://soundcloud.com/charts/new";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return Parser.isMatch(URL_PATTERN, str.toLowerCase());
    }
}
