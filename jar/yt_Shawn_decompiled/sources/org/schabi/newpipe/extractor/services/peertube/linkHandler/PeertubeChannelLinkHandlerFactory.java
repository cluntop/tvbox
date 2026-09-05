package org.schabi.newpipe.extractor.services.peertube.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PeertubeChannelLinkHandlerFactory extends ListLinkHandlerFactory {
    public static final String API_ENDPOINT = "/api/v1/";
    private static final String ID_PATTERN = "((accounts|a)|(video-channels|c))/([^/?&#]*)";
    private static final String ID_URL_PATTERN = "/((accounts|a)|(video-channels|c))/([^/?&#]*)";
    private static final PeertubeChannelLinkHandlerFactory INSTANCE = new PeertubeChannelLinkHandlerFactory();

    private PeertubeChannelLinkHandlerFactory() {
    }

    private String fixId(String str) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        return str.startsWith("a/") ? "accounts".concat(str.substring(1)) : str.startsWith("c/") ? "video-channels".concat(str.substring(1)) : str;
    }

    public static PeertubeChannelLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return fixId(Parser.matchGroup(ID_URL_PATTERN, str, 0));
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2, String str3) {
        return str.matches(ID_PATTERN) ? b.o(str3, "/", fixId(str)) : b.o(str3, "/accounts/", str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        try {
            new URL(str);
            if (str.contains("/accounts/") || str.contains("/a/") || str.contains("/video-channels/")) {
                return true;
            }
            return str.contains("/c/");
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return getUrl(str, list, str2, ServiceList.PeerTube.getBaseUrl());
    }
}
