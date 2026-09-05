package org.schabi.newpipe.extractor.services.peertube.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PeertubeCommentsLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final String COMMENTS_ENDPOINT = "/api/v1/videos/%s/comment-threads";
    private static final PeertubeCommentsLinkHandlerFactory INSTANCE = new PeertubeCommentsLinkHandlerFactory();

    private PeertubeCommentsLinkHandlerFactory() {
    }

    public static PeertubeCommentsLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return PeertubeStreamLinkHandlerFactory.getInstance().getId(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2, String str3) {
        return b.z(str3, b.A(PeertubeStreamLinkHandlerFactory.VIDEO_API_ENDPOINT, str, "/comment-threads"));
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        try {
            new URL(str);
            if (str.contains("/videos/")) {
                return true;
            }
            return str.contains("/w/");
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return getUrl(str, list, str2, ServiceList.PeerTube.getBaseUrl());
    }
}
