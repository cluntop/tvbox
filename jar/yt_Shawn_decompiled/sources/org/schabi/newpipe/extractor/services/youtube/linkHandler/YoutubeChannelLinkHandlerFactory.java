package org.schabi.newpipe.extractor.services.youtube.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeChannelLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final YoutubeChannelLinkHandlerFactory INSTANCE = new YoutubeChannelLinkHandlerFactory();
    private static final Pattern EXCLUDED_SEGMENTS = Pattern.compile("playlist|watch|attribution_link|watch_popup|embed|feed|select_site|account|reporthistory|redirect");

    private YoutubeChannelLinkHandlerFactory() {
    }

    public static YoutubeChannelLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    private boolean isCustomShortChannelUrl(String[] strArr) {
        return (strArr.length != 1 || strArr[0].isEmpty() || EXCLUDED_SEGMENTS.matcher(strArr[0]).matches()) ? false : true;
    }

    private boolean isHandle(String[] strArr) {
        return strArr.length > 0 && strArr[0].startsWith("@");
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) throws ParsingException {
        try {
            URL urlStringToURL = Utils.stringToURL(str);
            String path = urlStringToURL.getPath();
            if (!Utils.isHTTP(urlStringToURL) || (!YoutubeParsingHelper.isYoutubeURL(urlStringToURL) && !YoutubeParsingHelper.isInvidiousURL(urlStringToURL) && !YoutubeParsingHelper.isHooktubeURL(urlStringToURL))) {
                throw new ParsingException("The URL given is not a YouTube URL");
            }
            String strSubstring = path.substring(1);
            String[] strArrSplit = strSubstring.split("/");
            if (!isHandle(strArrSplit) && !isCustomShortChannelUrl(strArrSplit)) {
                if (!strSubstring.startsWith("user/") && !strSubstring.startsWith("channel/") && !strSubstring.startsWith("c/")) {
                    throw new ParsingException("The given URL is not a channel, a user or a handle URL");
                }
                String str2 = strArrSplit[1];
                if (Utils.isBlank(str2)) {
                    throw new ParsingException("The given ID is not a YouTube channel or user ID");
                }
                return strArrSplit[0] + "/" + str2;
            }
            return strArrSplit[0];
        } catch (Exception e) {
            throw new ParsingException(b.n("Could not parse URL :", e.getMessage()), e);
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return b.n("https://www.youtube.com/", str);
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
