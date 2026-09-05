package org.schabi.newpipe.extractor.services.soundcloud.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.util.List;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.exceptions.UnsupportedTabException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class SoundcloudChannelTabLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final SoundcloudChannelTabLinkHandlerFactory INSTANCE = new SoundcloudChannelTabLinkHandlerFactory();

    private SoundcloudChannelTabLinkHandlerFactory() {
    }

    public static SoundcloudChannelTabLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    public static String getUrlSuffix(String str) {
        str.getClass();
        switch (str) {
            case "playlists":
                return "/sets";
            case "albums":
                return "/albums";
            case "tracks":
                return "/tracks";
            case "likes":
                return "/likes";
            default:
                throw new UnsupportedTabException(str);
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String[] getAvailableContentFilter() {
        return new String[]{"tracks", "playlists", ChannelTabs.ALBUMS, ChannelTabs.LIKES};
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) {
        return SoundcloudChannelLinkHandlerFactory.getInstance().getId(str);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return b.z(SoundcloudChannelLinkHandlerFactory.getInstance().getUrl(str), getUrlSuffix(list.get(0)));
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return SoundcloudChannelLinkHandlerFactory.getInstance().onAcceptUrl(str);
    }
}
