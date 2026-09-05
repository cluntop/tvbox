package org.schabi.newpipe.extractor.services.youtube.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.util.List;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.UnsupportedTabException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeChannelTabLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final YoutubeChannelTabLinkHandlerFactory INSTANCE = new YoutubeChannelTabLinkHandlerFactory();

    private YoutubeChannelTabLinkHandlerFactory() {
    }

    public static YoutubeChannelTabLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    public static String getUrlSuffix(String str) {
        str.getClass();
        switch (str) {
            case "playlists":
                return "/playlists";
            case "albums":
                return "/releases";
            case "shorts":
                return "/shorts";
            case "videos":
                return "/videos";
            case "livestreams":
                return "/streams";
            default:
                throw new UnsupportedTabException(str);
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableContentFilter() {
        return new String[]{"videos", ChannelTabs.SHORTS, ChannelTabs.LIVESTREAMS, ChannelTabs.ALBUMS, "playlists"};
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return YoutubeChannelLinkHandlerFactory.getInstance().getId(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return b.A("https://www.youtube.com/", str, getUrlSuffix(list.get(0)));
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
