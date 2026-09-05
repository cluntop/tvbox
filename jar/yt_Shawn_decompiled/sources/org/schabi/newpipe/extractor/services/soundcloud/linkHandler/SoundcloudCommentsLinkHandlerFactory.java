package org.schabi.newpipe.extractor.services.soundcloud.linkHandler;

import java.io.IOException;
import java.util.List;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.utils.c;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class SoundcloudCommentsLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final SoundcloudCommentsLinkHandlerFactory INSTANCE = new SoundcloudCommentsLinkHandlerFactory();

    private SoundcloudCommentsLinkHandlerFactory() {
    }

    public static SoundcloudCommentsLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return SoundcloudStreamLinkHandlerFactory.getInstance().getId(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) throws ParsingException {
        try {
            return "https://api-v2.soundcloud.com/tracks/" + str + "/comments?client_id=" + SoundcloudParsingHelper.clientId() + "&threaded=0&filter_replies=1";
        } catch (IOException | ExtractionException unused) {
            c.a("Could not get comments");
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        try {
            getId(str);
            return true;
        } catch (ParsingException unused) {
            return false;
        }
    }
}
