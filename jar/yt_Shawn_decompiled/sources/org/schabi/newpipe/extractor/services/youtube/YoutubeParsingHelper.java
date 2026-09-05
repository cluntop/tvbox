package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.Base64;
import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Optional;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.merge.o1.p;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonBuilder;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import com.grack.nanojson.JsonStringWriter;
import com.grack.nanojson.JsonWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.AccountTerminatedException;
import org.schabi.newpipe.extractor.exceptions.ContentNotAvailableException;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.playlist.PlaylistInfo;
import org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags;
import org.schabi.newpipe.extractor.stream.AudioTrackType;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.RandomStringFromAlphabetGenerator;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeParsingHelper {
    public static final String CONTENT_CHECK_OK = "contentCheckOk";
    private static final String CONTENT_PLAYBACK_NONCE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    public static final String CPN = "cpn";
    public static final String DISABLE_PRETTY_PRINT_PARAMETER = "prettyPrint=false";
    private static final String FEED_BASE_CHANNEL_ID = "https://www.youtube.com/feeds/videos.xml?channel_id=";
    private static final String FEED_BASE_USER = "https://www.youtube.com/feeds/videos.xml?user=";
    private static final Set<String> GOOGLE_URLS;
    private static final Set<String> INVIDIOUS_URLS;
    public static final String RACY_CHECK_OK = "racyCheckOk";
    public static final String VIDEO_ID = "videoId";
    public static final String YOUTUBEI_V1_GAPIS_URL = "https://youtubei.googleapis.com/youtubei/v1/";
    public static final String YOUTUBEI_V1_URL = "https://www.youtube.com/youtubei/v1/";
    private static final String YOUTUBE_MUSIC_URL = "https://music.youtube.com";
    private static final Set<String> YOUTUBE_URLS;
    private static String clientVersion;
    private static boolean clientVersionExtracted;
    private static boolean consentAccepted;
    private static String youtubeMusicClientVersion;
    private static Optional<Boolean> hardcodedClientVersionValid = Optional.empty();
    private static final String[] INNERTUBE_CONTEXT_CLIENT_VERSION_REGEXES = {"INNERTUBE_CONTEXT_CLIENT_VERSION\":\"([0-9\\.]+?)\"", "innertube_context_client_version\":\"([0-9\\.]+?)\"", "client.version=([0-9\\.]+)"};
    private static final String[] INITIAL_DATA_REGEXES = {"window\\[\"ytInitialData\"\\]\\s*=\\s*(\\{.*?\\});", "var\\s*ytInitialData\\s*=\\s*(\\{.*?\\});"};
    private static Random numberGenerator = new Random();
    private static final Pattern C_WEB_PATTERN = Pattern.compile("&c=WEB");
    private static final Pattern C_WEB_EMBEDDED_PLAYER_PATTERN = Pattern.compile("&c=WEB_EMBEDDED_PLAYER");
    private static final Pattern C_ANDROID_PATTERN = Pattern.compile("&c=ANDROID");
    private static final Pattern C_IOS_PATTERN = Pattern.compile("&c=IOS");
    private static final Pattern C_VISIONOS_PATTERN = Pattern.compile("&c=VISIONOS");

    static {
        Object[] objArr = {"google.", "m.google.", "www.google."};
        HashSet hashSet = new HashSet(3);
        for (int i = 0; i < 3; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            if (!hashSet.add(obj)) {
                com.github.catvod.spider.merge.b0.a.j("duplicate element: ", obj);
                return;
            }
        }
        GOOGLE_URLS = DesugarCollections.unmodifiableSet(hashSet);
        String[] strArr = {"invidio.us", "dev.invidio.us", "www.invidio.us", "redirect.invidious.io", "invidious.snopyta.org", "yewtu.be", "tube.connect.cafe", "tubus.eduvid.org", "invidious.kavin.rocks", "invidious.site", "invidious-us.kavin.rocks", "piped.kavin.rocks", "vid.mint.lgbt", "invidiou.site", "invidious.fdn.fr", "invidious.048596.xyz", "invidious.zee.li", "vid.puffyan.us", "ytprivate.com", "invidious.namazso.eu", "invidious.silkky.cloud", "ytb.trom.tf", "invidious.exonip.de", "inv.riverside.rocks", "invidious.blamefran.net", "y.com.cm", "invidious.moomoo.me", "yt.cyberhost.uk"};
        HashSet hashSet2 = new HashSet(28);
        for (int i2 = 0; i2 < 28; i2++) {
            String str = strArr[i2];
            Objects.requireNonNull(str);
            if (!hashSet2.add(str)) {
                com.github.catvod.spider.merge.b0.a.j("duplicate element: ", str);
                return;
            }
        }
        INVIDIOUS_URLS = DesugarCollections.unmodifiableSet(hashSet2);
        Object[] objArr2 = {"youtube.com", "www.youtube.com", "m.youtube.com", "music.youtube.com"};
        HashSet hashSet3 = new HashSet(4);
        for (int i3 = 0; i3 < 4; i3++) {
            Object obj2 = objArr2[i3];
            Objects.requireNonNull(obj2);
            if (!hashSet3.add(obj2)) {
                com.github.catvod.spider.merge.b0.a.j("duplicate element: ", obj2);
                return;
            }
        }
        YOUTUBE_URLS = DesugarCollections.unmodifiableSet(hashSet3);
        consentAccepted = false;
    }

    private YoutubeParsingHelper() {
    }

    private static int convertDurationToInt(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Integer.parseInt(Utils.removeNonDigitCharacters(str));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public static void defaultAlertsCheck(JsonObject jsonObject) {
        JsonArray array = jsonObject.getArray("alerts");
        if (Utils.isNullOrEmpty(array)) {
            return;
        }
        JsonObject object = array.getObject(0).getObject("alertRenderer");
        String textFromObject = getTextFromObject(object.getObject("text"));
        if (object.getString("type", VideoStream.RESOLUTION_UNKNOWN).equalsIgnoreCase("ERROR")) {
            if (textFromObject == null || !(textFromObject.contains("This account has been terminated") || textFromObject.contains("This channel was removed"))) {
                throw new ContentNotAvailableException(com.github.catvod.spider.merge.b.b.A("Got error: \"", textFromObject, "\""));
            }
            if (!textFromObject.matches(".*violat(ed|ion|ing).*") && !textFromObject.contains("infringement")) {
                throw new AccountTerminatedException(textFromObject);
            }
            throw new AccountTerminatedException(textFromObject, AccountTerminatedException.Reason.VIOLATION);
        }
    }

    public static AudioTrackType extractAudioTrackType(String str) {
        if (str == null) {
            return null;
        }
        try {
            String str2 = (String) Collection$EL.stream(Xtags.XTags.parseFrom(Base64.getUrlDecoder().decode(str)).getXtagsList()).filter(new b(8)).findFirst().map(new a(10)).orElse(null);
            if (str2 == null) {
                return null;
            }
            switch (str2) {
            }
            return null;
        }
    }

    public static String extractCachedUrlIfNeeded(String str) {
        if (str == null) {
            return null;
        }
        return str.contains("webcache.googleusercontent.com") ? str.split("cache:")[1] : str;
    }

    private static void extractClientVersionFromHtmlSearchResultsPage() throws ParsingException {
        if (clientVersionExtracted) {
            return;
        }
        String strResponseBody = NewPipe.getDownloader().get("https://www.youtube.com/results?search_query=&ucbcb=1", getCookieHeader()).responseBody();
        Stream<JsonObject> streamStreamAsJsonObjects = getInitialData(strResponseBody).getObject("responseContext").getArray("serviceTrackingParams").streamAsJsonObjects();
        String clientVersionFromServiceTrackingParam = getClientVersionFromServiceTrackingParam(streamStreamAsJsonObjects, "CSI", "cver");
        clientVersion = clientVersionFromServiceTrackingParam;
        if (clientVersionFromServiceTrackingParam == null) {
            try {
                clientVersion = Utils.getStringResultFromRegexArray(strResponseBody, INNERTUBE_CONTEXT_CLIENT_VERSION_REGEXES, 1);
            } catch (Parser.RegexException unused) {
            }
        }
        if (Utils.isNullOrEmpty(clientVersion)) {
            clientVersion = getClientVersionFromServiceTrackingParam(streamStreamAsJsonObjects, "ECATCHER", "client.version");
        }
        if (clientVersion != null) {
            clientVersionExtracted = true;
        } else {
            org.schabi.newpipe.extractor.utils.c.a("Could not extract YouTube WEB InnerTube client version from HTML search results page");
        }
    }

    private static void extractClientVersionFromSwJs() throws ParsingException {
        if (clientVersionExtracted) {
            return;
        }
        try {
            clientVersion = Utils.getStringResultFromRegexArray(NewPipe.getDownloader().get("https://www.youtube.com/sw.js", getOriginReferrerHeaders("https://www.youtube.com")).responseBody(), INNERTUBE_CONTEXT_CLIENT_VERSION_REGEXES, 1);
            clientVersionExtracted = true;
        } catch (Parser.RegexException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not extract YouTube WEB InnerTube client version from sw.js", e);
        }
    }

    public static String extractCookieValue(String str, Response response) {
        List<String> list = response.responseHeaders().get("set-cookie");
        String strSubstring = VideoStream.RESOLUTION_UNKNOWN;
        if (list == null) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        for (String str2 : list) {
            int iIndexOf = str2.indexOf(str);
            if (iIndexOf != -1) {
                strSubstring = str2.substring(str.length() + iIndexOf + 1, str2.indexOf(";", iIndexOf));
            }
        }
        return strSubstring;
    }

    public static PlaylistInfo.PlaylistType extractPlaylistTypeFromPlaylistId(String str) throws ParsingException {
        if (!Utils.isNullOrEmpty(str)) {
            return isYoutubeMusicMixId(str) ? PlaylistInfo.PlaylistType.MIX_MUSIC : isYoutubeGenreMixId(str) ? PlaylistInfo.PlaylistType.MIX_GENRE : isYoutubeMixId(str) ? PlaylistInfo.PlaylistType.MIX_STREAM : PlaylistInfo.PlaylistType.NORMAL;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not extract playlist type from empty playlist id");
        return null;
    }

    public static PlaylistInfo.PlaylistType extractPlaylistTypeFromPlaylistUrl(String str) throws ParsingException {
        try {
            return extractPlaylistTypeFromPlaylistId(Utils.getQueryValue(Utils.stringToURL(str), "list"));
        } catch (MalformedURLException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not extract playlist type from malformed url", e);
            return null;
        }
    }

    public static String extractVideoIdFromMixId(String str) throws ParsingException {
        if (Utils.isNullOrEmpty(str)) {
            org.schabi.newpipe.extractor.utils.c.a("Video id could not be determined from empty playlist id");
            return null;
        }
        if (isYoutubeMyMixId(str)) {
            return str.substring(4);
        }
        if (isYoutubeMusicMixId(str)) {
            return str.substring(6);
        }
        if (isYoutubeGenreMixId(str)) {
            throw new ParsingException(com.github.catvod.spider.merge.b.b.n("Video id could not be determined from genre mix id: ", str));
        }
        if (!isYoutubeMixId(str)) {
            throw new ParsingException(com.github.catvod.spider.merge.b.b.n("Video id could not be determined from playlist id: ", str));
        }
        if (str.length() == 13) {
            return str.substring(2);
        }
        throw new ParsingException("Video id could not be determined from mix id: ".concat(str));
    }

    public static String fixThumbnailUrl(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        return str.startsWith(Utils.HTTP) ? Utils.replaceHttpWithHttps(str) : !str.startsWith(Utils.HTTPS) ? Utils.HTTPS.concat(str) : str;
    }

    public static String generateConsentCookie() {
        return "SOCS=".concat(isConsentAccepted() ? "CAISAiAD" : "CAE=");
    }

    public static String generateContentPlaybackNonce() {
        return RandomStringFromAlphabetGenerator.generate(CONTENT_PLAYBACK_NONCE_ALPHABET, 16, numberGenerator);
    }

    public static String generateTParameter() {
        return RandomStringFromAlphabetGenerator.generate(CONTENT_PLAYBACK_NONCE_ALPHABET, 12, numberGenerator);
    }

    public static String getAndroidUserAgent(Localization localization) {
        if (localization == null) {
            localization = Localization.DEFAULT;
        }
        return com.github.catvod.spider.merge.b.b.A("com.google.android.youtube/21.03.36 (Linux; U; Android 15; ", localization.getCountryCode(), ") gzip");
    }

    public static Map<String, List<String>> getClientHeaders(String str, String str2) {
        Object[] objArr = {str};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        List listG = com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList);
        Object[] objArr2 = {str2};
        ArrayList arrayList2 = new ArrayList(1);
        Object obj2 = objArr2[0];
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("X-YouTube-Client-Name", listG), new AbstractMap.SimpleEntry("X-YouTube-Client-Version", com.github.catvod.spider.merge.t0.a.g(obj2, arrayList2, obj2, arrayList2))};
        HashMap map = new HashMap(2);
        for (int i = 0; i < 2; i++) {
            Map.Entry entry = entryArr[i];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                com.github.catvod.spider.merge.b0.a.j("duplicate key: ", key);
                return null;
            }
        }
        return DesugarCollections.unmodifiableMap(map);
    }

    public static Map<String, List<String>> getClientInfoHeaders() {
        HashMap map = new HashMap(getOriginReferrerHeaders("https://www.youtube.com"));
        map.putAll(getClientHeaders("1", getClientVersion()));
        return map;
    }

    public static String getClientVersion() throws ExtractionException {
        if (!Utils.isNullOrEmpty(clientVersion)) {
            return clientVersion;
        }
        try {
            extractClientVersionFromSwJs();
        } catch (Exception unused) {
            extractClientVersionFromHtmlSearchResultsPage();
        }
        if (clientVersionExtracted) {
            return clientVersion;
        }
        if (!isHardcodedClientVersionValid()) {
            throw new ExtractionException("Could not get YouTube WEB client version");
        }
        clientVersion = "2.20260120.01.00";
        return "2.20260120.01.00";
    }

    private static String getClientVersionFromServiceTrackingParam(Stream<JsonObject> stream, String str, String str2) {
        return (String) stream.filter(new org.schabi.newpipe.extractor.a(str, 7)).flatMap(new a(12)).filter(new org.schabi.newpipe.extractor.a(str2, 8)).map(new a(13)).filter(new b(7)).findFirst().orElse(null);
    }

    public static Map<String, List<String>> getCookieHeader() {
        Object[] objArr = {generateConsentCookie()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("Cookie", com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList))};
        HashMap map = new HashMap(1);
        Map.Entry entry = entryArr[0];
        Object key = entry.getKey();
        Objects.requireNonNull(key);
        Object value = entry.getValue();
        Objects.requireNonNull(value);
        if (map.put(key, value) == null) {
            return DesugarCollections.unmodifiableMap(map);
        }
        com.github.catvod.spider.merge.b0.a.j("duplicate key: ", key);
        return null;
    }

    public static String getFeedUrlFrom(String str) {
        return str.startsWith("user/") ? com.github.catvod.spider.merge.b.b.n(FEED_BASE_USER, str.replace("user/", VideoStream.RESOLUTION_UNKNOWN)) : str.startsWith("channel/") ? com.github.catvod.spider.merge.b.b.n(FEED_BASE_CHANNEL_ID, str.replace("channel/", VideoStream.RESOLUTION_UNKNOWN)) : FEED_BASE_CHANNEL_ID.concat(str);
    }

    public static JsonObject getFirstCollaborator(JsonObject jsonObject) {
        try {
            return JsonUtils.getArray(jsonObject, "showDialogCommand.panelLoadingStrategy.inlineContent.dialogViewModel.customContent.listViewModel.listItems").getObject(0).getObject("listItemViewModel");
        } catch (ParsingException unused) {
            return null;
        }
    }

    public static List<Image> getImagesFromThumbnailsArray(JsonArray jsonArray) {
        return (List) jsonArray.streamAsJsonObjects().filter(new b(6)).map(new a(11)).collect(Collectors.toUnmodifiableList());
    }

    private static JsonObject getInitialData(String str) throws ParsingException {
        try {
            return JsonParser.object().from(Utils.getStringResultFromRegexArray(str, INITIAL_DATA_REGEXES, 1));
        } catch (JsonParserException | Parser.RegexException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get ytInitialData", e);
            return null;
        }
    }

    public static String getIosUserAgent(Localization localization) {
        if (localization == null) {
            localization = Localization.DEFAULT;
        }
        return com.github.catvod.spider.merge.b.b.A("com.google.ios.youtube/21.03.2(iPhone16,2; U; CPU iOS 18_7_2 like Mac OS X; ", localization.getCountryCode(), ")");
    }

    public static JsonObject getJsonPostResponse(String str, List<String> list, byte[] bArr, Localization localization) {
        String strA;
        Map<String, List<String>> youTubeHeaders = getYouTubeHeaders();
        if (list.isEmpty()) {
            strA = "?prettyPrint=false";
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) "&");
                }
            }
            strA = com.github.catvod.spider.merge.b.b.A("?", sb.toString(), "&prettyPrint=false");
        }
        return JsonUtils.toJsonObject(getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson(com.github.catvod.spider.merge.b.b.A(YOUTUBEI_V1_URL, str, strA), youTubeHeaders, bArr, localization)));
    }

    public static Map<String, List<String>> getOriginReferrerHeaders(String str) {
        Object[] objArr = {str};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        List listG = com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList);
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("Origin", listG), new AbstractMap.SimpleEntry("Referer", listG)};
        HashMap map = new HashMap(2);
        for (int i = 0; i < 2; i++) {
            Map.Entry entry = entryArr[i];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                com.github.catvod.spider.merge.b0.a.j("duplicate key: ", key);
                return null;
            }
        }
        return DesugarCollections.unmodifiableMap(map);
    }

    public static String getTextAtKey(JsonObject jsonObject, String str) {
        return jsonObject.isString(str) ? jsonObject.getString(str) : getTextFromObject(jsonObject.getObject(str));
    }

    public static String getTextFromObject(JsonObject jsonObject, boolean z) {
        if (Utils.isNullOrEmpty(jsonObject)) {
            return null;
        }
        if (jsonObject.has("simpleText")) {
            return jsonObject.getString("simpleText");
        }
        JsonArray array = jsonObject.getArray("runs");
        if (array.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = array.iterator();
        while (it.hasNext()) {
            JsonObject jsonObject2 = (JsonObject) it.next();
            String string = jsonObject2.getString("text");
            if (z) {
                if (jsonObject2.has("navigationEndpoint")) {
                    String urlFromNavigationEndpoint = getUrlFromNavigationEndpoint(jsonObject2.getObject("navigationEndpoint"));
                    if (!Utils.isNullOrEmpty(urlFromNavigationEndpoint)) {
                        string = "<a href=\"" + p.d(urlFromNavigationEndpoint) + "\">" + p.d(string) + "</a>";
                    }
                }
                boolean z2 = false;
                boolean z3 = jsonObject2.has("bold") && jsonObject2.getBoolean("bold");
                boolean z4 = jsonObject2.has("italics") && jsonObject2.getBoolean("italics");
                if (jsonObject2.has("strikethrough") && jsonObject2.getBoolean("strikethrough")) {
                    z2 = true;
                }
                if (z3) {
                    sb.append("<b>");
                }
                if (z4) {
                    sb.append("<i>");
                }
                if (z2) {
                    sb.append("<s>");
                }
                sb.append(string);
                if (z2) {
                    sb.append("</s>");
                }
                if (z4) {
                    sb.append("</i>");
                }
                if (z3) {
                    sb.append("</b>");
                }
            } else {
                sb.append(string);
            }
        }
        String string2 = sb.toString();
        return z ? string2.replaceAll("\\n", "<br>").replaceAll(" {2}", " &nbsp;") : string2;
    }

    public static String getTextFromObjectOrThrow(JsonObject jsonObject, String str) throws ParsingException {
        String textFromObject = getTextFromObject(jsonObject);
        if (textFromObject != null) {
            return textFromObject;
        }
        throw new ParsingException(com.github.catvod.spider.merge.b.b.n("Could not extract text: ", str));
    }

    public static List<Image> getThumbnailsFromInfoItem(JsonObject jsonObject) throws ParsingException {
        try {
            return getImagesFromThumbnailsArray(jsonObject.getObject("thumbnail").getArray("thumbnails"));
        } catch (Exception e) {
            com.github.catvod.spider.merge.s0.a.m("Could not get thumbnails from InfoItem", e);
            return null;
        }
    }

    public static String getUrlFromNavigationEndpoint(JsonObject jsonObject) {
        if (jsonObject.has("urlEndpoint")) {
            String string = jsonObject.getObject("urlEndpoint").getString("url");
            if (string.startsWith("https://www.youtube.com/redirect?")) {
                string = string.substring(23);
            }
            if (string.startsWith("/redirect?")) {
                for (String str : string.substring(10).split("&")) {
                    if (str.split("=")[0].equals("q")) {
                        return Utils.decodeUrlUtf8(str.split("=")[1]);
                    }
                }
            } else {
                if (string.startsWith("http")) {
                    return string;
                }
                if (string.startsWith("/channel") || string.startsWith("/user") || string.startsWith("/watch")) {
                    return "https://www.youtube.com".concat(string);
                }
            }
        }
        if (jsonObject.has("browseEndpoint")) {
            JsonObject object = jsonObject.getObject("browseEndpoint");
            String string2 = object.getString("canonicalBaseUrl");
            String string3 = object.getString("browseId");
            if (string3 != null) {
                if (string3.startsWith("UC")) {
                    return "https://www.youtube.com/channel/".concat(string3);
                }
                if (string3.startsWith("VL")) {
                    return "https://www.youtube.com/playlist?list=".concat(string3.substring(2));
                }
            }
            if (!Utils.isNullOrEmpty(string2)) {
                return com.github.catvod.spider.merge.b.b.n("https://www.youtube.com", string2);
            }
        }
        if (jsonObject.has("watchEndpoint")) {
            StringBuilder sb = new StringBuilder("https://www.youtube.com/watch?v=");
            sb.append(jsonObject.getObject("watchEndpoint").getString(VIDEO_ID));
            if (jsonObject.getObject("watchEndpoint").has("playlistId")) {
                sb.append("&list=");
                sb.append(jsonObject.getObject("watchEndpoint").getString("playlistId"));
            }
            if (jsonObject.getObject("watchEndpoint").has("startTimeSeconds")) {
                sb.append("&t=");
                sb.append(jsonObject.getObject("watchEndpoint").getInt("startTimeSeconds"));
            }
            return sb.toString();
        }
        if (jsonObject.has("watchPlaylistEndpoint")) {
            return com.github.catvod.spider.merge.b.b.n("https://www.youtube.com/playlist?list=", jsonObject.getObject("watchPlaylistEndpoint").getString("playlistId"));
        }
        if (jsonObject.has("showDialogCommand")) {
            try {
                return getUrlFromNavigationEndpoint(JsonUtils.getObject(JsonUtils.getArray(jsonObject, "showDialogCommand.panelLoadingStrategy.inlineContent.dialogViewModel.customContent.listViewModel.listItems").getObject(0), "listItemViewModel.rendererContext.commandContext.onTap.innertubeCommand"));
            } catch (ParsingException unused) {
            }
        }
        if (!jsonObject.has("commandMetadata")) {
            return null;
        }
        JsonObject object2 = jsonObject.getObject("commandMetadata").getObject("webCommandMetadata");
        if (object2.has("url")) {
            return com.github.catvod.spider.merge.b.b.n("https://www.youtube.com", object2.getString("url"));
        }
        return null;
    }

    public static String getUrlFromObject(JsonObject jsonObject) {
        if (Utils.isNullOrEmpty(jsonObject)) {
            return null;
        }
        JsonArray array = jsonObject.getArray("runs");
        if (array.isEmpty()) {
            return null;
        }
        Iterator<Object> it = array.iterator();
        while (it.hasNext()) {
            String urlFromNavigationEndpoint = getUrlFromNavigationEndpoint(((JsonObject) it.next()).getObject("navigationEndpoint"));
            if (!Utils.isNullOrEmpty(urlFromNavigationEndpoint)) {
                return urlFromNavigationEndpoint;
            }
        }
        return null;
    }

    public static String getValidJsonResponseBody(Response response) {
        if (response.responseCode() == 404) {
            throw new ContentNotAvailableException("Not found (\"" + response.responseCode() + org.schabi.newpipe.extractor.stream.Stream.ID_UNKNOWN + response.responseMessage() + "\")");
        }
        String strResponseBody = response.responseBody();
        if (strResponseBody.length() < 50) {
            org.schabi.newpipe.extractor.utils.c.a("JSON response is too short");
            return null;
        }
        URL url = new URL(response.latestUrl());
        if (url.getHost().equalsIgnoreCase("www.youtube.com")) {
            String path = url.getPath();
            if (path.equalsIgnoreCase("/oops") || path.equalsIgnoreCase("/error")) {
                throw new ContentNotAvailableException("Content unavailable");
            }
        }
        String header = response.getHeader("Content-Type");
        if (header == null || !header.toLowerCase().contains("text/html")) {
            return strResponseBody;
        }
        throw new ParsingException(com.github.catvod.spider.merge.b.b.A("Got HTML document, expected JSON response (latest url was: \"", response.latestUrl(), "\")"));
    }

    public static String getVisionOsUserAgent(Localization localization) {
        if (localization == null) {
            localization = Localization.DEFAULT;
        }
        return com.github.catvod.spider.merge.b.b.A("com.google.visionos.youtube/1.02(RealityDevice14,1; U; CPU visionOS 25_6_0 like Mac OS X; ", localization.getCountryCode(), ")");
    }

    public static String getVisitorDataFromInnertube(InnertubeClientRequestInfo innertubeClientRequestInfo, Localization localization, ContentCountry contentCountry, Map<String, List<String>> map, String str, String str2, boolean z) throws ParsingException {
        String string = JsonUtils.toJsonObject(getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson(com.github.catvod.spider.merge.b.b.o(str, z ? "guide" : "visitor_id", "?prettyPrint=false"), map, JsonWriter.string(prepareJsonBuilder(localization, contentCountry, innertubeClientRequestInfo, str2).done()).getBytes(StandardCharsets.UTF_8)))).getObject("responseContext").getString("visitorData");
        if (!Utils.isNullOrEmpty(string)) {
            return string;
        }
        org.schabi.newpipe.extractor.utils.c.a("Could not get visitorData");
        return null;
    }

    public static Map<String, List<String>> getYouTubeHeaders() {
        Map<String, List<String>> clientInfoHeaders = getClientInfoHeaders();
        Object[] objArr = {generateConsentCookie()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        clientInfoHeaders.put("Cookie", com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList));
        return clientInfoHeaders;
    }

    public static String getYoutubeMusicClientVersion() {
        if (!Utils.isNullOrEmpty(youtubeMusicClientVersion)) {
            return youtubeMusicClientVersion;
        }
        if (isHardcodedYoutubeMusicClientVersionValid()) {
            youtubeMusicClientVersion = "1.20260121.03.00";
            return "1.20260121.03.00";
        }
        try {
            youtubeMusicClientVersion = Utils.getStringResultFromRegexArray(NewPipe.getDownloader().get("https://music.youtube.com/sw.js", getOriginReferrerHeaders(YOUTUBE_MUSIC_URL)).responseBody(), INNERTUBE_CONTEXT_CLIENT_VERSION_REGEXES, 1);
        } catch (Exception unused) {
            youtubeMusicClientVersion = Utils.getStringResultFromRegexArray(NewPipe.getDownloader().get("https://music.youtube.com/?ucbcb=1", getCookieHeader()).responseBody(), INNERTUBE_CONTEXT_CLIENT_VERSION_REGEXES, 1);
        }
        return youtubeMusicClientVersion;
    }

    public static Map<String, List<String>> getYoutubeMusicHeaders() {
        HashMap map = new HashMap(getOriginReferrerHeaders(YOUTUBE_MUSIC_URL));
        map.putAll(getClientHeaders("67", youtubeMusicClientVersion));
        return map;
    }

    public static boolean hasArtistOrVerifiedIconBadgeAttachment(JsonArray jsonArray) {
        return jsonArray.streamAsJsonObjects().anyMatch(new b(5));
    }

    public static boolean isAndroidStreamingUrl(String str) {
        return Parser.isMatch(C_ANDROID_PATTERN, str);
    }

    public static boolean isConsentAccepted() {
        return consentAccepted;
    }

    public static boolean isGoogleURL(String str) {
        try {
            return Collection$EL.stream(GOOGLE_URLS).anyMatch(new com.github.catvod.spider.merge.e0.a(3, new URL(extractCachedUrlIfNeeded(str))));
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static boolean isHardcodedClientVersionValid() {
        if (hardcodedClientVersionValid.isPresent()) {
            return hardcodedClientVersionValid.get().booleanValue();
        }
        boolean z = false;
        byte[] bytes = ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) JsonWriter.string().object()).object("context")).object("client")).value("hl", "en-GB")).value("gl", "GB")).value("clientName", "WEB")).value("clientVersion", "2.20260120.01.00")).value("platform", "DESKTOP")).value("utcOffsetMinutes", 0)).end()).object("request")).array("internalExperimentFlags")).end()).value("useSsl", true)).end()).object("user")).value("lockedSafetyMode", false)).end()).end()).value("fetchLiveState", true)).end()).done().getBytes(StandardCharsets.UTF_8);
        Response responsePostWithContentTypeJson = NewPipe.getDownloader().postWithContentTypeJson("https://www.youtube.com/youtubei/v1/guide?prettyPrint=false", getClientHeaders("1", "2.20260120.01.00"), bytes);
        String strResponseBody = responsePostWithContentTypeJson.responseBody();
        int iResponseCode = responsePostWithContentTypeJson.responseCode();
        if (strResponseBody.length() > 5000 && iResponseCode == 200) {
            z = true;
        }
        Optional<Boolean> optionalOf = Optional.of(Boolean.valueOf(z));
        hardcodedClientVersionValid = optionalOf;
        return optionalOf.get().booleanValue();
    }

    public static boolean isHardcodedYoutubeMusicClientVersionValid() {
        byte[] bytes = ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) JsonWriter.string().object()).object("context")).object("client")).value("clientName", "WEB_REMIX")).value("clientVersion", "1.20260121.03.00")).value("hl", "en-GB")).value("gl", "GB")).value("platform", "DESKTOP")).value("utcOffsetMinutes", 0)).end()).object("request")).array("internalExperimentFlags")).end()).value("useSsl", true)).end()).object("user")).value("lockedSafetyMode", false)).end()).end()).value("input", VideoStream.RESOLUTION_UNKNOWN)).end()).done().getBytes(StandardCharsets.UTF_8);
        HashMap map = new HashMap(getOriginReferrerHeaders(YOUTUBE_MUSIC_URL));
        map.putAll(getClientHeaders("67", "2.20260120.01.00"));
        Response responsePostWithContentTypeJson = NewPipe.getDownloader().postWithContentTypeJson("https://music.youtube.com/youtubei/v1/music/get_search_suggestions?prettyPrint=false", map, bytes);
        return responsePostWithContentTypeJson.responseBody().length() > 500 && responsePostWithContentTypeJson.responseCode() == 200;
    }

    public static boolean isHooktubeURL(URL url) {
        return url.getHost().equalsIgnoreCase("hooktube.com");
    }

    public static boolean isInvidiousURL(URL url) {
        return INVIDIOUS_URLS.contains(url.getHost().toLowerCase(Locale.ROOT));
    }

    public static boolean isIosStreamingUrl(String str) {
        return Parser.isMatch(C_IOS_PATTERN, str);
    }

    public static boolean isVerified(JsonArray jsonArray) {
        if (Utils.isNullOrEmpty(jsonArray)) {
            return false;
        }
        Iterator<Object> it = jsonArray.iterator();
        while (it.hasNext()) {
            String string = ((JsonObject) it.next()).getObject("metadataBadgeRenderer").getString("style");
            if (string != null && (string.equals("BADGE_STYLE_TYPE_VERIFIED") || string.equals("BADGE_STYLE_TYPE_VERIFIED_ARTIST"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVisionOsStreamingUrl(String str) {
        return Parser.isMatch(C_VISIONOS_PATTERN, str);
    }

    public static boolean isWebEmbeddedPlayerStreamingUrl(String str) {
        return Parser.isMatch(C_WEB_EMBEDDED_PLAYER_PATTERN, str);
    }

    public static boolean isWebStreamingUrl(String str) {
        return Parser.isMatch(C_WEB_PATTERN, str);
    }

    public static boolean isY2ubeURL(URL url) {
        return url.getHost().equalsIgnoreCase("y2u.be");
    }

    public static boolean isYoutubeGenreMixId(String str) {
        return str.startsWith("RDGMEM");
    }

    public static boolean isYoutubeMixId(String str) {
        return str.startsWith("RD");
    }

    public static boolean isYoutubeMusicMixId(String str) {
        return str.startsWith("RDAMVM") || str.startsWith("RDCLAK");
    }

    public static boolean isYoutubeMyMixId(String str) {
        return str.startsWith("RDMM");
    }

    public static boolean isYoutubeServiceURL(URL url) {
        String host = url.getHost();
        return host.equalsIgnoreCase("www.youtube-nocookie.com") || host.equalsIgnoreCase("youtu.be");
    }

    public static boolean isYoutubeURL(URL url) {
        return YOUTUBE_URLS.contains(url.getHost().toLowerCase(Locale.ROOT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$extractAudioTrackType$10(Xtags.KeyValuePair keyValuePair) {
        return "acont".equals(keyValuePair.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getClientVersionFromServiceTrackingParam$1(String str, JsonObject jsonObject) {
        return jsonObject.getString("service", VideoStream.RESOLUTION_UNKNOWN).equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getClientVersionFromServiceTrackingParam$2(JsonObject jsonObject) {
        return jsonObject.getArray("params").streamAsJsonObjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getClientVersionFromServiceTrackingParam$3(String str, JsonObject jsonObject) {
        return jsonObject.getString("key", VideoStream.RESOLUTION_UNKNOWN).equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getClientVersionFromServiceTrackingParam$4(JsonObject jsonObject) {
        return jsonObject.getString("value");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getClientVersionFromServiceTrackingParam$5(String str) {
        return !Utils.isNullOrEmpty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getImagesFromThumbnailsArray$6(JsonObject jsonObject) {
        return !Utils.isNullOrEmpty(jsonObject.getString("url"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Image lambda$getImagesFromThumbnailsArray$7(JsonObject jsonObject) {
        int i = jsonObject.getInt("height", -1);
        return new Image(fixThumbnailUrl(jsonObject.getString("url")), i, jsonObject.getInt("width", -1), Image.ResolutionLevel.fromHeight(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$hasArtistOrVerifiedIconBadgeAttachment$8(JsonObject jsonObject) {
        String string = jsonObject.getObject("clientResource").getString("imageName");
        return "CHECK_CIRCLE_FILLED".equals(string) || "AUDIO_BADGE".equals(string) || "MUSIC_FILLED".equals(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$hasArtistOrVerifiedIconBadgeAttachment$9(JsonObject jsonObject) {
        return com.github.catvod.spider.merge.t0.a.c(jsonObject, "element", "type", "imageType", "image").getArray("sources").streamAsJsonObjects().anyMatch(new b(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isGoogleURL$0(URL url, String str) {
        return url.getHost().startsWith(str);
    }

    public static int parseDurationString(String str) throws ParsingException {
        if (!str.matches(".*\\d.*") && !str.equalsIgnoreCase("SHORTS")) {
            throw new ParsingException("Error duration string contains no digits: ".concat(str));
        }
        String[] strArrSplit = str.contains(":") ? str.split(":") : str.split("\\.");
        int[] iArr = {24, 60, 60, 1};
        int length = 4 - strArrSplit.length;
        if (length < 0) {
            throw new ParsingException("Error duration string with unknown format: ".concat(str));
        }
        int iConvertDurationToInt = 0;
        for (int i = 0; i < strArrSplit.length; i++) {
            iConvertDurationToInt = (iConvertDurationToInt + convertDurationToInt(strArrSplit[i])) * iArr[i + length];
        }
        return iConvertDurationToInt;
    }

    public static JsonBuilder<JsonObject> prepareDesktopJsonBuilder(Localization localization, ContentCountry contentCountry) {
        return JsonObject.builder().object("context").object("client").value("hl", localization.getLocalizationCode()).value("gl", contentCountry.getCountryCode()).value("clientName", "WEB").value("clientVersion", getClientVersion()).value("originalUrl", "https://www.youtube.com").value("platform", "DESKTOP").value("utcOffsetMinutes", 0).end().object("request").array("internalExperimentFlags").end().value("useSsl", true).end().object("user").value("lockedSafetyMode", false).end().end();
    }

    public static JsonBuilder<JsonObject> prepareJsonBuilder(Localization localization, ContentCountry contentCountry, InnertubeClientRequestInfo innertubeClientRequestInfo, String str) {
        JsonBuilder<JsonObject> jsonBuilderValue = JsonObject.builder().object("context").object("client").value("clientName", innertubeClientRequestInfo.clientInfo.clientName).value("clientVersion", innertubeClientRequestInfo.clientInfo.clientVersion);
        String str2 = innertubeClientRequestInfo.clientInfo.clientScreen;
        if (str2 != null) {
            jsonBuilderValue.value("clientScreen", str2);
        }
        String str3 = innertubeClientRequestInfo.deviceInfo.platform;
        if (str3 != null) {
            jsonBuilderValue.value("platform", str3);
        }
        String str4 = innertubeClientRequestInfo.clientInfo.visitorData;
        if (str4 != null) {
            jsonBuilderValue.value("visitorData", str4);
        }
        String str5 = innertubeClientRequestInfo.deviceInfo.deviceMake;
        if (str5 != null) {
            jsonBuilderValue.value("deviceMake", str5);
        }
        String str6 = innertubeClientRequestInfo.deviceInfo.deviceModel;
        if (str6 != null) {
            jsonBuilderValue.value("deviceModel", str6);
        }
        String str7 = innertubeClientRequestInfo.deviceInfo.osName;
        if (str7 != null) {
            jsonBuilderValue.value("osName", str7);
        }
        String str8 = innertubeClientRequestInfo.deviceInfo.osVersion;
        if (str8 != null) {
            jsonBuilderValue.value("osVersion", str8);
        }
        int i = innertubeClientRequestInfo.deviceInfo.androidSdkVersion;
        if (i > 0) {
            jsonBuilderValue.value("androidSdkVersion", i);
        }
        jsonBuilderValue.value("hl", localization.getLocalizationCode()).value("gl", contentCountry.getCountryCode()).value("utcOffsetMinutes", 0).end();
        if (str != null) {
            jsonBuilderValue.object("thirdParty").value("embedUrl", str).end();
        }
        jsonBuilderValue.object("request").array("internalExperimentFlags").end().value("useSsl", true).end().object("user").value("lockedSafetyMode", false).end().end();
        return jsonBuilderValue;
    }

    public static void resetClientVersion() {
        clientVersion = null;
        clientVersionExtracted = false;
    }

    public static void setConsentAccepted(boolean z) {
        consentAccepted = z;
    }

    public static void setNumberGenerator(Random random) {
        numberGenerator = random;
    }

    public static JsonObject getJsonPostResponse(String str, byte[] bArr, Localization localization) {
        return JsonUtils.toJsonObject(getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson(com.github.catvod.spider.merge.b.b.A(YOUTUBEI_V1_URL, str, "?prettyPrint=false"), getYouTubeHeaders(), bArr, localization)));
    }

    public static String getTextFromObject(JsonObject jsonObject) {
        return getTextFromObject(jsonObject, false);
    }
}
