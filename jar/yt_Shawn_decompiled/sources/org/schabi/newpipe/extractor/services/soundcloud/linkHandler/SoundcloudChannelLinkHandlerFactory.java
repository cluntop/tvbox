package org.schabi.newpipe.extractor.services.soundcloud.linkHandler;

import java.util.List;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class SoundcloudChannelLinkHandlerFactory extends ListLinkHandlerFactory {
    private static final SoundcloudChannelLinkHandlerFactory INSTANCE = new SoundcloudChannelLinkHandlerFactory();
    private static final String URL_PATTERN = "^https?://(www\\.|m\\.)?soundcloud.com/[0-9a-z_-]+(/((tracks|albums|sets|reposts|followers|following)/?)?)?([#?].*)?$";

    private SoundcloudChannelLinkHandlerFactory() {
    }

    public static SoundcloudChannelLinkHandlerFactory getInstance() {
        return INSTANCE;
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public String getId(String str) throws ParsingException {
        Utils.checkUrl(URL_PATTERN, str);
        try {
            return SoundcloudParsingHelper.resolveIdWithWidgetApi(str);
        } catch (Exception e) {
            throw new ParsingException(e.getMessage(), e);
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.ListLinkHandlerFactory
    public String getUrl(String str, List<String> list, String str2) throws ParsingException {
        try {
            return SoundcloudParsingHelper.resolveUrlWithEmbedPlayer("https://api.soundcloud.com/users/" + str);
        } catch (Exception e) {
            throw new ParsingException(e.getMessage(), e);
        }
    }

    @Override // org.schabi.newpipe.extractor.linkhandler.LinkHandlerFactory
    public boolean onAcceptUrl(String str) {
        return Parser.isMatch(URL_PATTERN, str.toLowerCase());
    }
}
