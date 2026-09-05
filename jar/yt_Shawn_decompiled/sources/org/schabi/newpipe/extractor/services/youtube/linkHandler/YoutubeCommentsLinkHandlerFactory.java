package org.schabi.newpipe.extractor.services.youtube.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.util.List;
import org.schabi.newpipe.extractor.exceptions.FoundAdException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeCommentsLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final YoutubeCommentsLinkHandlerFactory INSTANCE = new YoutubeCommentsLinkHandlerFactory();

    private YoutubeCommentsLinkHandlerFactory() {
    }

    public static YoutubeCommentsLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return YoutubeStreamLinkHandlerFactory.getInstance().getId(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory, org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getUrl(String str) {
        return b.n("https://www.youtube.com/watch?v=", str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) throws FoundAdException {
        try {
            getId(str);
            return true;
        } catch (FoundAdException e) {
            throw e;
        } catch (ParsingException unused) {
            return false;
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return getUrl(str);
    }
}
