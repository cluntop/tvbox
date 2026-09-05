package org.schabi.newpipe.extractor.utils;

import com.github.catvod.spider.jdollar.net.URLDecoder;
import com.github.catvod.spider.jdollar.net.URLEncoder;
import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarArrays;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Utils {
    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";
    private static final Pattern M_PATTERN = Pattern.compile("(https?)?://m\\.");
    private static final Pattern WWW_PATTERN = Pattern.compile("(https?)?://www\\.");

    private Utils() {
    }

    public static void checkUrl(Pattern pattern, String str) throws ParsingException {
        if (isNullOrEmpty(str)) {
            com.github.catvod.spider.merge.s0.a.r("Url can't be null or empty");
        } else {
            if (Parser.isMatch(pattern, str.toLowerCase())) {
                return;
            }
            c.a("Url doesn't match the pattern");
        }
    }

    public static String decodeUrlUtf8(String str) {
        return URLDecoder.decode(str, StandardCharsets.UTF_8);
    }

    public static String encodeUrlUtf8(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }

    public static String followGoogleRedirectIfNeeded(String str) {
        try {
            URL urlStringToURL = stringToURL(str);
            return (urlStringToURL.getHost().contains("google") && urlStringToURL.getPath().equals("/url")) ? decodeUrlUtf8(Parser.matchGroup1("&url=([^&]+)(?:&|$)", str)) : str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static String getBaseUrl(String str) throws ParsingException {
        try {
            URL urlStringToURL = stringToURL(str);
            return urlStringToURL.getProtocol() + "://" + urlStringToURL.getAuthority();
        } catch (MalformedURLException e) {
            String message = e.getMessage();
            if (message.startsWith("unknown protocol: ")) {
                return message.substring(18);
            }
            throw new ParsingException(com.github.catvod.spider.merge.b.b.n("Malformed url: ", str), e);
        }
    }

    public static String getQueryValue(URL url, String str) {
        String query = url.getQuery();
        if (query == null) {
            return null;
        }
        for (String str2 : query.split("&")) {
            String[] strArrSplit = str2.split("=", 2);
            if (decodeUrlUtf8(strArrSplit[0]).equals(str)) {
                return decodeUrlUtf8(strArrSplit[1]);
            }
        }
        return null;
    }

    public static String getStringResultFromRegexArray(String str, String[] strArr, int i) {
        return getStringResultFromRegexArray(str, (Pattern[]) DesugarArrays.stream(strArr).filter(new org.schabi.newpipe.extractor.services.bandcamp.extractors.a(5)).map(new b(3)).toArray(new d()), i);
    }

    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return true;
    }

    public static boolean isHTTP(URL url) {
        String protocol = url.getProtocol();
        if (protocol.equals("http") || protocol.equals("https")) {
            return url.getPort() == -1 || (url.getPort() == url.getDefaultPort());
        }
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String join(String str, String str2, Map<? extends CharSequence, ? extends CharSequence> map) {
        return (String) Collection$EL.stream(map.entrySet()).map(new org.schabi.newpipe.extractor.services.bandcamp.extractors.b(str2, 5)).collect(Collectors.joining(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pattern[] lambda$getStringResultFromRegexArray$2(int i) {
        return new Pattern[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$join$0(String str, Map.Entry entry) {
        return entry.getKey() + str + entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$nonEmptyAndNullJoin$1(String str) {
        return (isNullOrEmpty(str) || str.equals("null")) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long mixedNumberWordToLong(java.lang.String r5) throws java.lang.NumberFormatException {
        /*
            r0 = 2
            java.lang.String r1 = "[\\d]+([\\.,][\\d]+)?([KMBkmb])+"
            java.lang.String r1 = org.schabi.newpipe.extractor.utils.Parser.matchGroup(r1, r5, r0)     // Catch: org.schabi.newpipe.extractor.exceptions.ParsingException -> L8
            goto La
        L8:
            java.lang.String r1 = ""
        La:
            java.lang.String r2 = "([\\d]+([\\.,][\\d]+)?)"
            java.lang.String r5 = org.schabi.newpipe.extractor.utils.Parser.matchGroup1(r2, r5)
            java.lang.String r2 = ","
            java.lang.String r3 = "."
            java.lang.String r5 = r5.replace(r2, r3)
            double r2 = java.lang.Double.parseDouble(r5)
            java.lang.String r5 = r1.toUpperCase()
            r5.getClass()
            int r1 = r5.hashCode()
            r4 = -1
            switch(r1) {
                case 66: goto L41;
                case 75: goto L36;
                case 77: goto L2d;
                default: goto L2b;
            }
        L2b:
            r0 = -1
            goto L4b
        L2d:
            java.lang.String r1 = "M"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L4b
            goto L2b
        L36:
            java.lang.String r0 = "K"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L3f
            goto L2b
        L3f:
            r0 = 1
            goto L4b
        L41:
            java.lang.String r0 = "B"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L4a
            goto L2b
        L4a:
            r0 = 0
        L4b:
            switch(r0) {
                case 0: goto L5f;
                case 1: goto L59;
                case 2: goto L50;
                default: goto L4e;
            }
        L4e:
            long r0 = (long) r2
            return r0
        L50:
            r0 = 4696837146684686336(0x412e848000000000, double:1000000.0)
        L55:
            double r2 = r2 * r0
            long r0 = (long) r2
            return r0
        L59:
            r0 = 4652007308841189376(0x408f400000000000, double:1000.0)
            goto L55
        L5f:
            r0 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            goto L55
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.utils.Utils.mixedNumberWordToLong(java.lang.String):long");
    }

    public static String nonEmptyAndNullJoin(CharSequence charSequence, String... strArr) {
        return (String) DesugarArrays.stream(strArr).filter(new org.schabi.newpipe.extractor.services.bandcamp.extractors.a(6)).collect(Collectors.joining(charSequence));
    }

    public static String removeMAndWWWFromUrl(String str) {
        return M_PATTERN.matcher(str).find() ? str.replace("m.", VideoStream.RESOLUTION_UNKNOWN) : WWW_PATTERN.matcher(str).find() ? str.replace("www.", VideoStream.RESOLUTION_UNKNOWN) : str;
    }

    public static String removeNonDigitCharacters(String str) {
        return str.replaceAll("\\D+", VideoStream.RESOLUTION_UNKNOWN);
    }

    public static String removeUTF8BOM(String str) {
        if (str.startsWith("\ufeff")) {
            str = str.substring(1);
        }
        return str.endsWith("\ufeff") ? str.substring(0, str.length() - 1) : str;
    }

    public static String replaceHttpWithHttps(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith(HTTP) ? HTTPS.concat(str.substring(7)) : str;
    }

    public static URL stringToURL(String str) throws MalformedURLException {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            if (e.getMessage().equals("no protocol: " + str)) {
                return new URL(com.github.catvod.spider.merge.b.b.n(HTTPS, str));
            }
            throw e;
        }
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <K, V> boolean isNullOrEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    public static void checkUrl(String str, String str2) throws ParsingException {
        checkUrl(Pattern.compile(str), str2);
    }

    public static String getStringResultFromRegexArray(String str, Pattern[] patternArr) {
        return getStringResultFromRegexArray(str, patternArr, 0);
    }

    public static String getStringResultFromRegexArray(String str, String[] strArr) {
        return getStringResultFromRegexArray(str, strArr, 0);
    }

    public static String getStringResultFromRegexArray(String str, Pattern[] patternArr, int i) throws Parser.RegexException {
        String strMatchGroup;
        for (Pattern pattern : patternArr) {
            try {
                strMatchGroup = Parser.matchGroup(pattern, str, i);
            } catch (Parser.RegexException unused) {
            }
            if (strMatchGroup != null) {
                return strMatchGroup;
            }
        }
        throw new Parser.RegexException(com.github.catvod.spider.merge.b.b.j(i, "No regex matched the input on group "));
    }
}
