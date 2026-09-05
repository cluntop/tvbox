package org.schabi.newpipe.extractor.services.media_ccc.linkHandler;

import java.util.List;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class MediaCCCConferencesListLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final MediaCCCConferencesListLinkHandlerFactory INSTANCE = new MediaCCCConferencesListLinkHandlerFactory();

    private MediaCCCConferencesListLinkHandlerFactory() {
    }

    public static MediaCCCConferencesListLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return "conferences";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return "https://media.ccc.de/public/conferences";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return str.equals("https://media.ccc.de/b/conferences") || str.equals("https://media.ccc.de/public/conferences") || str.equals("https://api.media.ccc.de/public/conferences");
    }
}
