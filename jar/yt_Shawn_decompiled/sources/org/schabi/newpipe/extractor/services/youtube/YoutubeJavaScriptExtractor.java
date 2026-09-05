package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.u.c2;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
final class YoutubeJavaScriptExtractor {
    private static final String BASE_JS_PLAYER_URL_FORMAT = "https://www.youtube.com/s/player/%s/player_ias.vflset/en_GB/base.js";
    private static final String HTTPS = "https:";
    private static final Pattern IFRAME_RES_JS_BASE_PLAYER_HASH_PATTERN = Pattern.compile("player\\\\/([a-z0-9]{8})\\\\/");
    private static final Pattern EMBEDDED_WATCH_PAGE_JS_BASE_PLAYER_URL_PATTERN = Pattern.compile("\"jsUrl\":\"(/s/player/[A-Za-z0-9]+/player_ias\\.vflset/[A-Za-z_-]+/base\\.js)\"");

    private YoutubeJavaScriptExtractor() {
    }

    private static String cleanJavaScriptUrl(String str) {
        return str.startsWith("//") ? HTTPS.concat(str) : str.startsWith("/") ? "https://www.youtube.com".concat(str) : str;
    }

    private static String downloadJavaScriptCode(String str) throws ParsingException {
        try {
            return NewPipe.getDownloader().get(str, Localization.DEFAULT).responseBody();
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get JavaScript base player's code", e);
            return null;
        }
    }

    public static String extractJavaScriptPlayerCode(String str) throws ParsingException {
        try {
            String strCleanJavaScriptUrl = cleanJavaScriptUrl(extractJavaScriptUrlWithIframeResource());
            new URL(strCleanJavaScriptUrl);
            return downloadJavaScriptCode(strCleanJavaScriptUrl);
        } catch (Exception unused) {
            String strCleanJavaScriptUrl2 = cleanJavaScriptUrl(extractJavaScriptUrlWithEmbedWatchPage(str));
            try {
                new URL(strCleanJavaScriptUrl2);
                return downloadJavaScriptCode(strCleanJavaScriptUrl2);
            } catch (MalformedURLException e) {
                com.github.catvod.spider.merge.s0.a.m("The extracted and built JavaScript URL is invalid", e);
                return null;
            }
        }
    }

    public static String extractJavaScriptUrlWithEmbedWatchPage(String str) throws ParsingException {
        try {
            String strResponseBody = NewPipe.getDownloader().get("https://www.youtube.com/embed/" + str, Localization.DEFAULT).responseBody();
            com.github.catvod.spider.merge.q1.e eVarT = c2.T(strResponseBody).T("script");
            Iterator<E> it = eVarT.iterator();
            while (it.hasNext()) {
                ((n) it.next()).c("name", "player/base");
            }
            Iterator<E> it2 = eVarT.iterator();
            while (it2.hasNext()) {
                String strB = ((n) it2.next()).b("src");
                if (strB.contains("base.js")) {
                    return strB;
                }
            }
            try {
                return Parser.matchGroup1(EMBEDDED_WATCH_PAGE_JS_BASE_PLAYER_URL_PATTERN, strResponseBody);
            } catch (Parser.RegexException e) {
                com.github.catvod.spider.merge.s0.a.m("Embedded watch page didn't provide JavaScript base player's URL", e);
                return null;
            }
        } catch (Exception e2) {
            com.github.catvod.spider.merge.s0.a.m("Could not fetch embedded watch page", e2);
            return null;
        }
    }

    public static String extractJavaScriptUrlWithIframeResource() throws ParsingException {
        try {
            try {
                return "https://www.youtube.com/s/player/" + Parser.matchGroup1(IFRAME_RES_JS_BASE_PLAYER_HASH_PATTERN, NewPipe.getDownloader().get("https://www.youtube.com/iframe_api", Localization.DEFAULT).responseBody()) + "/player_ias.vflset/en_GB/base.js";
            } catch (Parser.RegexException e) {
                com.github.catvod.spider.merge.s0.a.m("IFrame resource didn't provide JavaScript base player's hash", e);
                return null;
            }
        } catch (Exception e2) {
            com.github.catvod.spider.merge.s0.a.m("Could not fetch IFrame resource", e2);
            return null;
        }
    }
}
