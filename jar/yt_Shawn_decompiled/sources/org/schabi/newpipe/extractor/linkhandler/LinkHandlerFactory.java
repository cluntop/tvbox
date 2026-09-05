package org.schabi.newpipe.extractor.linkhandler;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.s0.a;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class LinkHandlerFactory {
    public boolean acceptUrl(String str) {
        return onAcceptUrl(str);
    }

    public LinkHandler fromId(String str) {
        Objects.requireNonNull(str, "ID cannot be null");
        String url = getUrl(str);
        return new LinkHandler(url, url, str);
    }

    public LinkHandler fromUrl(String str, String str2) throws ParsingException {
        Objects.requireNonNull(str, "URL cannot be null");
        if (!acceptUrl(str)) {
            throw new ParsingException("URL not accepted: ".concat(str));
        }
        String id = getId(str);
        return new LinkHandler(str, getUrl(id, str2), id);
    }

    public abstract String getId(String str);

    public abstract String getUrl(String str);

    public String getUrl(String str, String str2) {
        return getUrl(str);
    }

    public abstract boolean onAcceptUrl(String str);

    public LinkHandler fromId(String str, String str2) {
        Objects.requireNonNull(str, "ID cannot be null");
        String url = getUrl(str, str2);
        return new LinkHandler(url, url, str);
    }

    public LinkHandler fromUrl(String str) {
        if (!Utils.isNullOrEmpty(str)) {
            String strFollowGoogleRedirectIfNeeded = Utils.followGoogleRedirectIfNeeded(str);
            return fromUrl(strFollowGoogleRedirectIfNeeded, Utils.getBaseUrl(strFollowGoogleRedirectIfNeeded));
        }
        a.r("The url is null or empty");
        return null;
    }
}
