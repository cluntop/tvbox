package org.schabi.newpipe.extractor.services.media_ccc.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.util.List;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class MediaCCCConferenceLinkHandlerFactory extends ListLinkHandlerFactory {
    public static final String CONFERENCE_API_ENDPOINT = "https://api.media.ccc.de/public/conferences/";
    public static final String CONFERENCE_PATH = "https://media.ccc.de/c/";
    private static final String ID_PATTERN = "(?:(?:(?:api\\.)?media\\.ccc\\.de/public/conferences/)|(?:media\\.ccc\\.de/[bc]/))([^/?&#]*)";
    private static final MediaCCCConferenceLinkHandlerFactory INSTANCE = new MediaCCCConferenceLinkHandlerFactory();

    private MediaCCCConferenceLinkHandlerFactory() {
    }

    public static MediaCCCConferenceLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableContentFilter() {
        return new String[]{"videos"};
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return Parser.matchGroup1(ID_PATTERN, str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return b.n(CONFERENCE_PATH, str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return getId(str) != null;
    }
}
