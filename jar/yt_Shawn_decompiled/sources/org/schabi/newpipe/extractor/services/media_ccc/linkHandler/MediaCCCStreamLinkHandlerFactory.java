package org.schabi.newpipe.extractor.services.media_ccc.linkHandler;

import com.github.catvod.spider.merge.b.b;
import org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.extractors.MediaCCCParsingHelper;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class MediaCCCStreamLinkHandlerFactory extends LinkHandlerFactory {
    private static final MediaCCCStreamLinkHandlerFactory INSTANCE = new MediaCCCStreamLinkHandlerFactory();
    private static final String LIVE_STREAM_ID_PATTERN = "streaming\\.media\\.ccc\\.de\\/(\\w+\\/\\w+)";
    private static final String LIVE_STREAM_PATH = "https://streaming.media.ccc.de/";
    private static final String RECORDING_ID_PATTERN = "(?:(?:(?:api\\.)?media\\.ccc\\.de/public/events/)|(?:media\\.ccc\\.de/v/))([^/?&#]*)";
    public static final String VIDEO_API_ENDPOINT = "https://api.media.ccc.de/public/events/";
    private static final String VIDEO_PATH = "https://media.ccc.de/v/";

    private MediaCCCStreamLinkHandlerFactory() {
    }

    public static MediaCCCStreamLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        String strMatchGroup1;
        try {
            strMatchGroup1 = Parser.matchGroup1(LIVE_STREAM_ID_PATTERN, str);
        } catch (Parser.RegexException unused) {
            strMatchGroup1 = null;
        }
        return strMatchGroup1 == null ? Parser.matchGroup1(RECORDING_ID_PATTERN, str) : strMatchGroup1;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getUrl(String str) {
        return MediaCCCParsingHelper.isLiveStreamId(str) ? b.n(LIVE_STREAM_PATH, str) : b.n(VIDEO_PATH, str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return getId(str) != null;
    }
}
