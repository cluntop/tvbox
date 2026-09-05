package org.schabi.newpipe.extractor.linkhandler;

import com.github.catvod.spider.jdollar.util.Objects;
import java.util.ArrayList;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class ListLinkHandlerFactory extends LinkHandlerFactory {
    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public ListLinkHandler fromId(String str) {
        return new ListLinkHandler(super.fromId(str));
    }

    public ListLinkHandler fromQuery(String str, List<String> list, String str2) {
        String url = getUrl(str, list, str2);
        return new ListLinkHandler(url, url, str, list, str2);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public ListLinkHandler fromUrl(String str, String str2) {
        Objects.requireNonNull(str, "URL may not be null");
        return new ListLinkHandler(super.fromUrl(str, str2));
    }

    public String[] getAvailableContentFilter() {
        return new String[0];
    }

    public String[] getAvailableSortFilter() {
        return new String[0];
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getUrl(String str) {
        return getUrl(str, new ArrayList(0), VideoStream.RESOLUTION_UNKNOWN);
    }

    public abstract String getUrl(String str, List<String> list, String str2);

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public ListLinkHandler fromId(String str, String str2) {
        return new ListLinkHandler(super.fromId(str, str2));
    }

    public String getUrl(String str, List<String> list, String str2, String str3) {
        return getUrl(str, list, str2);
    }

    public ListLinkHandler fromQuery(String str, List<String> list, String str2, String str3) {
        String url = getUrl(str, list, str2, str3);
        return new ListLinkHandler(url, url, str, list, str2);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getUrl(String str, String str2) {
        return getUrl(str, new ArrayList(0), VideoStream.RESOLUTION_UNKNOWN, str2);
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public ListLinkHandler fromUrl(String str) {
        String strFollowGoogleRedirectIfNeeded = Utils.followGoogleRedirectIfNeeded(str);
        return fromUrl(strFollowGoogleRedirectIfNeeded, Utils.getBaseUrl(strFollowGoogleRedirectIfNeeded));
    }
}
