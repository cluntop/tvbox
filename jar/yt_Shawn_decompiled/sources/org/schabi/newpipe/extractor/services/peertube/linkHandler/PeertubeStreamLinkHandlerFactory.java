package org.schabi.newpipe.extractor.services.peertube.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.net.MalformedURLException;
import java.net.URL;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PeertubeStreamLinkHandlerFactory extends LinkHandlerFactory {
    private static final String ID_PATTERN = "(/w/|(/videos/(watch/|embed/)?))(?!p/)([^/?&#]*)";
    private static final PeertubeStreamLinkHandlerFactory INSTANCE = new PeertubeStreamLinkHandlerFactory();
    public static final String VIDEO_API_ENDPOINT = "/api/v1/videos/";
    private static final String VIDEO_PATH = "/videos/watch/";

    private PeertubeStreamLinkHandlerFactory() {
    }

    public static PeertubeStreamLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return Parser.matchGroup(ID_PATTERN, str, 4);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getUrl(String str) {
        return getUrl(str, ServiceList.PeerTube.getBaseUrl());
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        if (str.contains("/playlist/")) {
            return false;
        }
        try {
            new URL(str);
            getId(str);
            return true;
        } catch (MalformedURLException | ParsingException unused) {
            return false;
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getUrl(String str, String str2) {
        return b.o(str2, VIDEO_PATH, str);
    }
}
