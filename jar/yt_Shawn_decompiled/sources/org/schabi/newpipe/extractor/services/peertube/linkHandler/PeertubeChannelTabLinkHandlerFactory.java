package org.schabi.newpipe.extractor.services.peertube.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.util.List;
import org.schabi.newpipe.extractor.exceptions.UnsupportedTabException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PeertubeChannelTabLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final PeertubeChannelTabLinkHandlerFactory INSTANCE = new PeertubeChannelTabLinkHandlerFactory();

    private PeertubeChannelTabLinkHandlerFactory() {
    }

    public static PeertubeChannelTabLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    public static String getUrlSuffix(String str) {
        str.getClass();
        switch (str) {
            case "playlists":
                return "/video-playlists";
            case "videos":
                return "/videos";
            case "channels":
                return "/video-channels";
            default:
                throw new UnsupportedTabException(str);
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableContentFilter() {
        return new String[]{"videos", "channels", "playlists"};
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return PeertubeChannelLinkHandlerFactory.getInstance().getId(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2, String str3) {
        return b.z(PeertubeChannelLinkHandlerFactory.getInstance().getUrl(str, null, null, str3), getUrlSuffix(list.get(0)));
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return PeertubeChannelLinkHandlerFactory.getInstance().onAcceptUrl(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return b.z(PeertubeChannelLinkHandlerFactory.getInstance().getUrl(str), getUrlSuffix(list.get(0)));
    }
}
