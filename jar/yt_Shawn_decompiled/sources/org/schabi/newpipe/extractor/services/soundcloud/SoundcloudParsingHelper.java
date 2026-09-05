package org.schabi.newpipe.extractor.services.soundcloud;

import com.github.catvod.spider.jdollar.time.OffsetDateTime;
import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.time.format.DateTimeParseException;
import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.q1.e;
import com.github.catvod.spider.merge.t0.a;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.channel.ChannelInfoItemsCollector;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.b;
import org.schabi.newpipe.extractor.services.soundcloud.extractors.SoundcloudChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.services.soundcloud.extractors.SoundcloudLikesInfoItemExtractor;
import org.schabi.newpipe.extractor.services.soundcloud.extractors.SoundcloudPlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.services.soundcloud.extractors.SoundcloudStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ImageSuffix;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;
import org.schabi.newpipe.extractor.utils.c;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class SoundcloudParsingHelper {
    private static final List<ImageSuffix> ALBUMS_AND_ARTWORKS_IMAGE_SUFFIXES;
    private static final Pattern ON_URL_PATTERN;
    public static final String SOUNDCLOUD_API_V2_URL = "https://api-v2.soundcloud.com/";
    private static final List<ImageSuffix> VISUALS_IMAGE_SUFFIXES;
    private static String clientId;

    static {
        Image.ResolutionLevel resolutionLevel = Image.ResolutionLevel.LOW;
        ImageSuffix imageSuffix = new ImageSuffix("mini", 16, 16, resolutionLevel);
        ImageSuffix imageSuffix2 = new ImageSuffix("t20x20", 20, 20, resolutionLevel);
        ImageSuffix imageSuffix3 = new ImageSuffix("small", 32, 32, resolutionLevel);
        ImageSuffix imageSuffix4 = new ImageSuffix("badge", 47, 47, resolutionLevel);
        ImageSuffix imageSuffix5 = new ImageSuffix("t50x50", 50, 50, resolutionLevel);
        ImageSuffix imageSuffix6 = new ImageSuffix("t60x60", 60, 60, resolutionLevel);
        ImageSuffix imageSuffix7 = new ImageSuffix("t67x67", 67, 67, resolutionLevel);
        ImageSuffix imageSuffix8 = new ImageSuffix("t80x80", 80, 80, resolutionLevel);
        ImageSuffix imageSuffix9 = new ImageSuffix("large", 100, 100, resolutionLevel);
        ImageSuffix imageSuffix10 = new ImageSuffix("t120x120", 120, 120, resolutionLevel);
        Image.ResolutionLevel resolutionLevel2 = Image.ResolutionLevel.MEDIUM;
        ImageSuffix[] imageSuffixArr = {imageSuffix, imageSuffix2, imageSuffix3, imageSuffix4, imageSuffix5, imageSuffix6, imageSuffix7, imageSuffix8, imageSuffix9, imageSuffix10, new ImageSuffix("t200x200", 200, 200, resolutionLevel2), new ImageSuffix("t240x240", 240, 240, resolutionLevel2), new ImageSuffix("t250x250", 250, 250, resolutionLevel2), new ImageSuffix("t300x300", 300, 300, resolutionLevel2), new ImageSuffix("t500x500", 500, 500, resolutionLevel2)};
        ArrayList arrayList = new ArrayList(15);
        for (int i = 0; i < 15; i++) {
            ImageSuffix imageSuffix11 = imageSuffixArr[i];
            Objects.requireNonNull(imageSuffix11);
            arrayList.add(imageSuffix11);
        }
        ALBUMS_AND_ARTWORKS_IMAGE_SUFFIXES = DesugarCollections.unmodifiableList(arrayList);
        Image.ResolutionLevel resolutionLevel3 = Image.ResolutionLevel.MEDIUM;
        Object[] objArr = {new ImageSuffix("t1240x260", 1240, 260, resolutionLevel3), new ImageSuffix("t2480x520", 2480, 520, resolutionLevel3)};
        ArrayList arrayList2 = new ArrayList(2);
        for (int i2 = 0; i2 < 2; i2++) {
            Object obj = objArr[i2];
            Objects.requireNonNull(obj);
            arrayList2.add(obj);
        }
        VISUALS_IMAGE_SUFFIXES = DesugarCollections.unmodifiableList(arrayList2);
        ON_URL_PATTERN = Pattern.compile("^https?://on.soundcloud.com/[0-9a-zA-Z]+$");
    }

    private SoundcloudParsingHelper() {
    }

    public static synchronized String clientId() {
        if (!Utils.isNullOrEmpty(clientId)) {
            return clientId;
        }
        Downloader downloader = NewPipe.getDownloader();
        e eVarT = c2.T(downloader.get("https://soundcloud.com").responseBody()).T("script[src*=\"sndcdn.com/assets/\"][src$=\".js\"]");
        Collections.reverse(eVarT);
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{"bytes=0-50000"}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        Map<String, List<String>> mapH = a.h(DesugarCollections.unmodifiableList(arrayList));
        Iterator<E> it = eVarT.iterator();
        while (it.hasNext()) {
            String strB = ((n) it.next()).b("src");
            if (!Utils.isNullOrEmpty(strB)) {
                try {
                    String strMatchGroup1 = Parser.matchGroup1(",client_id:\"(.*?)\"", downloader.get(strB, mapH).responseBody());
                    clientId = strMatchGroup1;
                    return strMatchGroup1;
                } catch (Parser.RegexException unused) {
                    continue;
                }
            }
        }
        throw new ExtractionException("Couldn't extract client id");
    }

    public static List<Image> getAllImagesFromArtworkOrAvatarUrl(String str) {
        return Utils.isNullOrEmpty(str) ? Collections.EMPTY_LIST : getAllImagesFromImageUrlReturned(str.replace("-large.", "-%s."), ALBUMS_AND_ARTWORKS_IMAGE_SUFFIXES);
    }

    private static List<Image> getAllImagesFromImageUrlReturned(String str, List<ImageSuffix> list) {
        return (List) Collection$EL.stream(list).map(new b(str, 3)).collect(Collectors.toUnmodifiableList());
    }

    public static List<Image> getAllImagesFromTrackObject(JsonObject jsonObject) throws ParsingException {
        String string = jsonObject.getString("artwork_url");
        if (string != null) {
            return getAllImagesFromArtworkOrAvatarUrl(string);
        }
        String string2 = jsonObject.getObject("user").getString("avatar_url");
        if (string2 != null) {
            return getAllImagesFromArtworkOrAvatarUrl(string2);
        }
        c.a("Could not get track or track user's thumbnails");
        return null;
    }

    public static List<Image> getAllImagesFromVisualUrl(String str) {
        return Utils.isNullOrEmpty(str) ? Collections.EMPTY_LIST : getAllImagesFromImageUrlReturned(str.replace("-original.", "-%s."), VISUALS_IMAGE_SUFFIXES);
    }

    public static String getAvatarUrl(JsonObject jsonObject) {
        return Utils.replaceHttpWithHttps(jsonObject.getObject("user").getString("avatar_url", VideoStream.RESOLUTION_UNKNOWN));
    }

    public static String getInfoItemsFromApi(MultiInfoItemsCollector multiInfoItemsCollector, String str) throws IOException, ParsingException {
        Response response = NewPipe.getDownloader().get(str, ServiceList.SoundCloud.getLocalization());
        if (response.responseCode() >= 400) {
            com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.b.b.j(response.responseCode(), "Could not get streams from API, HTTP "));
            return null;
        }
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(response.responseBody());
            jsonObjectFrom.getArray("collection").streamAsJsonObjects().forEach(new org.schabi.newpipe.extractor.services.media_ccc.extractors.a(multiInfoItemsCollector, 1));
            try {
                String string = jsonObjectFrom.getString("next_href");
                if (string.contains("client_id=")) {
                    return string;
                }
                return string + "&client_id=" + clientId();
            } catch (Exception unused) {
                return VideoStream.RESOLUTION_UNKNOWN;
            }
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
            return null;
        }
    }

    private static String getNextPageUrl(JsonObject jsonObject) {
        try {
            String string = jsonObject.getString("next_href");
            if (string.contains("client_id=")) {
                return string;
            }
            return string + "&client_id=" + clientId();
        } catch (Exception unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    public static String getStreamsFromApi(StreamInfoItemsCollector streamInfoItemsCollector, String str, boolean z) throws IOException, ParsingException {
        Response response = NewPipe.getDownloader().get(str, ServiceList.SoundCloud.getLocalization());
        if (response.responseCode() >= 400) {
            com.github.catvod.spider.merge.s0.a.w(com.github.catvod.spider.merge.b.b.j(response.responseCode(), "Could not get streams from API, HTTP "));
            return null;
        }
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(response.responseBody());
            Iterator<Object> it = jsonObjectFrom.getArray("collection").iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof JsonObject) {
                    JsonObject object = (JsonObject) next;
                    if (z) {
                        object = object.getObject("track");
                    }
                    streamInfoItemsCollector.commit((StreamInfoItemExtractor) new SoundcloudStreamInfoItemExtractor(object));
                }
            }
            return getNextPageUrl(jsonObjectFrom);
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
            return null;
        }
    }

    public static String getStreamsFromApiMinItems(int i, StreamInfoItemsCollector streamInfoItemsCollector, String str) {
        String streamsFromApi = getStreamsFromApi(streamInfoItemsCollector, str);
        while (!streamsFromApi.isEmpty() && streamInfoItemsCollector.getItems().size() < i) {
            streamsFromApi = getStreamsFromApi(streamInfoItemsCollector, streamsFromApi);
        }
        return streamsFromApi;
    }

    public static String getUploaderName(JsonObject jsonObject) {
        return jsonObject.getObject("user").getString("username", VideoStream.RESOLUTION_UNKNOWN);
    }

    public static String getUploaderUrl(JsonObject jsonObject) {
        return Utils.replaceHttpWithHttps(jsonObject.getObject("user").getString("permalink_url", VideoStream.RESOLUTION_UNKNOWN));
    }

    public static String getUsersFromApi(ChannelInfoItemsCollector channelInfoItemsCollector, String str) throws ParsingException {
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(NewPipe.getDownloader().get(str, ServiceList.SoundCloud.getLocalization()).responseBody());
            Iterator<Object> it = jsonObjectFrom.getArray("collection").iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof JsonObject) {
                    channelInfoItemsCollector.commit((ChannelInfoItemsCollector) new SoundcloudChannelInfoItemExtractor((JsonObject) next));
                }
            }
            return getNextPageUrl(jsonObjectFrom);
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
            return null;
        }
    }

    public static String getUsersFromApiMinItems(int i, ChannelInfoItemsCollector channelInfoItemsCollector, String str) throws ParsingException {
        String usersFromApi = getUsersFromApi(channelInfoItemsCollector, str);
        while (!usersFromApi.isEmpty() && channelInfoItemsCollector.getItems().size() < i) {
            usersFromApi = getUsersFromApi(channelInfoItemsCollector, usersFromApi);
        }
        return usersFromApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Image lambda$getAllImagesFromImageUrlReturned$1(String str, ImageSuffix imageSuffix) {
        return new Image(String.format(str, imageSuffix.getSuffix()), imageSuffix.getHeight(), imageSuffix.getWidth(), imageSuffix.getResolutionLevel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInfoItemsFromApi$0(MultiInfoItemsCollector multiInfoItemsCollector, JsonObject jsonObject) {
        String string = jsonObject.getString("kind", VideoStream.RESOLUTION_UNKNOWN);
        string.getClass();
        switch (string) {
            case "like":
                JsonObject object = jsonObject.getObject("playlist", null);
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) (object == null ? new SoundcloudLikesInfoItemExtractor(jsonObject) : new SoundcloudPlaylistInfoItemExtractor(object)));
                break;
            case "user":
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) new SoundcloudChannelInfoItemExtractor(jsonObject));
                break;
            case "track":
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) new SoundcloudStreamInfoItemExtractor(jsonObject));
                break;
            case "playlist":
                multiInfoItemsCollector.commit((MultiInfoItemsCollector) new SoundcloudPlaylistInfoItemExtractor(jsonObject));
                break;
        }
    }

    public static DateWrapper parseDate(String str) throws ParsingException {
        try {
            return DateWrapper.fromInstant(str);
        } catch (DateTimeParseException e) {
            try {
                return new DateWrapper(OffsetDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss +0000")));
            } catch (DateTimeParseException e2) {
                e2.addSuppressed(e);
                throw new ParsingException(com.github.catvod.spider.merge.b.b.A("Could not parse date: \"", str, "\""), e2);
            }
        }
    }

    public static JsonObject resolveFor(Downloader downloader, String str) throws ParsingException {
        try {
            return JsonParser.object().from(downloader.get(com.github.catvod.spider.merge.b.b.p("https://api-v2.soundcloud.com/resolve?url=", Utils.encodeUrlUtf8(str), "&client_id=", clientId()), ServiceList.SoundCloud.getLocalization()).responseBody());
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
            return null;
        }
    }

    public static String resolveIdWithWidgetApi(String str) throws ParsingException {
        if (ON_URL_PATTERN.matcher(str).find()) {
            try {
                str = NewPipe.getDownloader().head(str).latestUrl().split("\\?")[0];
            } catch (ExtractionException e) {
                com.github.catvod.spider.merge.s0.a.m("Could not follow on.soundcloud.com redirect", e);
                return null;
            }
        }
        if (str.charAt(str.length() - 1) == '/') {
            str = str.substring(0, str.length() - 1);
        }
        try {
            try {
                return String.valueOf(JsonUtils.getValue(JsonParser.object().from(NewPipe.getDownloader().get("https://api-widget.soundcloud.com/resolve?url=" + Utils.encodeUrlUtf8(Utils.stringToURL(Utils.removeMAndWWWFromUrl(str.toLowerCase())).toString()) + "&format=json&client_id=" + clientId(), ServiceList.SoundCloud.getLocalization()).responseBody()), "id"));
            } catch (JsonParserException e2) {
                com.github.catvod.spider.merge.s0.a.m("Could not parse JSON response", e2);
                return null;
            } catch (ExtractionException e3) {
                com.github.catvod.spider.merge.s0.a.m("Could not resolve id with embedded player. ClientId not extracted", e3);
                return null;
            }
        } catch (MalformedURLException unused) {
            com.github.catvod.spider.merge.s0.a.r("The given URL is not valid");
            return null;
        }
    }

    public static String resolveUrlWithEmbedPlayer(String str) {
        return ((n) c2.T(NewPipe.getDownloader().get(com.github.catvod.spider.merge.b.b.n("https://w.soundcloud.com/player/?url=", Utils.encodeUrlUtf8(str)), ServiceList.SoundCloud.getLocalization()).responseBody()).T("link[rel=\"canonical\"]").c()).b("abs:href");
    }

    public static String getStreamsFromApi(StreamInfoItemsCollector streamInfoItemsCollector, String str) {
        return getStreamsFromApi(streamInfoItemsCollector, str, false);
    }
}
