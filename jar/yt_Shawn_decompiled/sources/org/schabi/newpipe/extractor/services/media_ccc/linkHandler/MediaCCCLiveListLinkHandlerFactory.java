package org.schabi.newpipe.extractor.services.media_ccc.linkHandler;

import java.util.List;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class MediaCCCLiveListLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final MediaCCCLiveListLinkHandlerFactory INSTANCE = new MediaCCCLiveListLinkHandlerFactory();
    private static final String STREAM_PATTERN = "^(?:https?://)?media\\.ccc\\.de/live$";

    private MediaCCCLiveListLinkHandlerFactory() {
    }

    public static MediaCCCLiveListLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return "live";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return "https://media.ccc.de/live";
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return Pattern.matches(STREAM_PATTERN, str);
    }
}
