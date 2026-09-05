package org.schabi.newpipe.extractor.services.youtube.linkHandler;

import com.github.catvod.spider.merge.b.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubePlaylistLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final YoutubePlaylistLinkHandlerFactory INSTANCE = new YoutubePlaylistLinkHandlerFactory();

    private YoutubePlaylistLinkHandlerFactory() {
    }

    public static YoutubePlaylistLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory, org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public ListLinkHandler fromUrl(String str) throws ParsingException {
        try {
            URL urlStringToURL = Utils.stringToURL(str);
            String queryValue = Utils.getQueryValue(urlStringToURL, "list");
            if (queryValue == null || !YoutubeParsingHelper.isYoutubeMixId(queryValue)) {
                return super.fromUrl(str);
            }
            String queryValue2 = Utils.getQueryValue(urlStringToURL, "v");
            if (queryValue2 == null) {
                queryValue2 = YoutubeParsingHelper.extractVideoIdFromMixId(queryValue);
            }
            return new ListLinkHandler(new LinkHandler(str, "https://www.youtube.com/watch?v=" + queryValue2 + "&list=" + queryValue, queryValue));
        } catch (MalformedURLException e) {
            throw new ParsingException(b.n("Error could not parse URL: ", e.getMessage()), e);
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) throws ParsingException {
        try {
            URL urlStringToURL = Utils.stringToURL(str);
            if (!Utils.isHTTP(urlStringToURL) || (!YoutubeParsingHelper.isYoutubeURL(urlStringToURL) && !YoutubeParsingHelper.isInvidiousURL(urlStringToURL))) {
                throw new ParsingException("the url given is not a YouTube-URL");
            }
            String path = urlStringToURL.getPath();
            if (!path.equals("/watch") && !path.equals("/playlist")) {
                throw new ParsingException("the url given is neither a video nor a playlist URL");
            }
            String queryValue = Utils.getQueryValue(urlStringToURL, "list");
            if (queryValue == null) {
                throw new ParsingException("the URL given does not include a playlist");
            }
            if (queryValue.matches("[a-zA-Z0-9_-]{10,}")) {
                return queryValue;
            }
            throw new ParsingException("the list-ID given in the URL does not match the list pattern");
        } catch (Exception e) {
            throw new ParsingException(b.n("Error could not parse URL: ", e.getMessage()), e);
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) {
        return b.n("https://www.youtube.com/playlist?list=", str);
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
