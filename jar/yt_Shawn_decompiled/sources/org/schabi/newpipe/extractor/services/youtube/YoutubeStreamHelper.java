package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.grack.nanojson.JsonBuilder;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.services.youtube.InnertubeClientRequestInfo;
import org.schabi.newpipe.extractor.utils.JsonUtils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeStreamHelper {
    private static final String BASE_YT_DESKTOP_WATCH_URL = "https://www.youtube.com/watch?v=";
    private static final String PLAYER = "player";
    private static final String PO_TOKEN = "poToken";
    private static final String SERVICE_INTEGRITY_DIMENSIONS = "serviceIntegrityDimensions";

    private YoutubeStreamHelper() {
    }

    private static void addPlaybackContext(JsonBuilder<JsonObject> jsonBuilder, String str, int i) {
        jsonBuilder.object("playbackContext").object("contentPlaybackContext").value("signatureTimestamp", i).value("referer", str).end().end();
    }

    private static void addPoToken(JsonBuilder<JsonObject> jsonBuilder, String str) {
        jsonBuilder.object(SERVICE_INTEGRITY_DIMENSIONS).value(PO_TOKEN, str).end();
    }

    private static void addVideoIdCpnAndOkChecks(JsonBuilder<JsonObject> jsonBuilder, String str, String str2) {
        jsonBuilder.value(YoutubeParsingHelper.VIDEO_ID, str);
        if (str2 != null) {
            jsonBuilder.value(YoutubeParsingHelper.CPN, str2);
        }
        jsonBuilder.value(YoutubeParsingHelper.CONTENT_CHECK_OK, true).value(YoutubeParsingHelper.RACY_CHECK_OK, true);
    }

    public static JsonObject getAndroidPlayerResponse(ContentCountry contentCountry, Localization localization, String str, String str2, PoTokenResult poTokenResult) {
        InnertubeClientRequestInfo innertubeClientRequestInfoOfAndroidClient = InnertubeClientRequestInfo.ofAndroidClient();
        innertubeClientRequestInfoOfAndroidClient.clientInfo.visitorData = poTokenResult.visitorData;
        Map<String, List<String>> mobileClientHeaders = getMobileClientHeaders(YoutubeParsingHelper.getAndroidUserAgent(localization));
        JsonBuilder<JsonObject> jsonBuilderPrepareJsonBuilder = YoutubeParsingHelper.prepareJsonBuilder(localization, contentCountry, innertubeClientRequestInfoOfAndroidClient, null);
        addVideoIdCpnAndOkChecks(jsonBuilderPrepareJsonBuilder, str, str2);
        addPoToken(jsonBuilderPrepareJsonBuilder, poTokenResult.playerRequestPoToken);
        byte[] bytes = JsonWriter.string(jsonBuilderPrepareJsonBuilder.done()).getBytes(StandardCharsets.UTF_8);
        return JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson(com.github.catvod.spider.merge.b.b.p("https://youtubei.googleapis.com/youtubei/v1/player?prettyPrint=false&t=", YoutubeParsingHelper.generateTParameter(), "&id=", str), mobileClientHeaders, bytes, localization)));
    }

    public static JsonObject getAndroidReelPlayerResponse(ContentCountry contentCountry, Localization localization, String str, String str2) {
        InnertubeClientRequestInfo innertubeClientRequestInfoOfAndroidClient = InnertubeClientRequestInfo.ofAndroidClient();
        Map<String, List<String>> mobileClientHeaders = getMobileClientHeaders(YoutubeParsingHelper.getAndroidUserAgent(localization));
        innertubeClientRequestInfoOfAndroidClient.clientInfo.visitorData = YoutubeParsingHelper.getVisitorDataFromInnertube(innertubeClientRequestInfoOfAndroidClient, localization, contentCountry, mobileClientHeaders, YoutubeParsingHelper.YOUTUBEI_V1_GAPIS_URL, null, false);
        JsonBuilder<JsonObject> jsonBuilderPrepareJsonBuilder = YoutubeParsingHelper.prepareJsonBuilder(localization, contentCountry, innertubeClientRequestInfoOfAndroidClient, null);
        jsonBuilderPrepareJsonBuilder.object("playerRequest");
        addVideoIdCpnAndOkChecks(jsonBuilderPrepareJsonBuilder, str, str2);
        jsonBuilderPrepareJsonBuilder.end().value("disablePlayerResponse", false);
        return JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson("https://youtubei.googleapis.com/youtubei/v1/reel/reel_item_watch?prettyPrint=false&t=" + YoutubeParsingHelper.generateTParameter() + "&id=" + str + "&$fields=playerResponse", mobileClientHeaders, JsonWriter.string(jsonBuilderPrepareJsonBuilder.done()).getBytes(StandardCharsets.UTF_8), localization))).getObject("playerResponse");
    }

    public static JsonObject getIosPlayerResponse(ContentCountry contentCountry, Localization localization, String str, String str2, PoTokenResult poTokenResult) {
        ContentCountry contentCountry2;
        Localization localization2;
        String visitorDataFromInnertube;
        InnertubeClientRequestInfo innertubeClientRequestInfoOfIosClient = InnertubeClientRequestInfo.ofIosClient();
        Map<String, List<String>> mobileClientHeaders = getMobileClientHeaders(YoutubeParsingHelper.getIosUserAgent(localization));
        InnertubeClientRequestInfo.ClientInfo clientInfo = innertubeClientRequestInfoOfIosClient.clientInfo;
        if (poTokenResult == null) {
            contentCountry2 = contentCountry;
            localization2 = localization;
            visitorDataFromInnertube = YoutubeParsingHelper.getVisitorDataFromInnertube(innertubeClientRequestInfoOfIosClient, localization2, contentCountry2, mobileClientHeaders, YoutubeParsingHelper.YOUTUBEI_V1_URL, null, false);
        } else {
            contentCountry2 = contentCountry;
            localization2 = localization;
            visitorDataFromInnertube = poTokenResult.visitorData;
        }
        clientInfo.visitorData = visitorDataFromInnertube;
        JsonBuilder<JsonObject> jsonBuilderPrepareJsonBuilder = YoutubeParsingHelper.prepareJsonBuilder(localization2, contentCountry2, innertubeClientRequestInfoOfIosClient, null);
        addVideoIdCpnAndOkChecks(jsonBuilderPrepareJsonBuilder, str, str2);
        if (poTokenResult != null) {
            addPoToken(jsonBuilderPrepareJsonBuilder, poTokenResult.playerRequestPoToken);
        }
        byte[] bytes = JsonWriter.string(jsonBuilderPrepareJsonBuilder.done()).getBytes(StandardCharsets.UTF_8);
        return JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson(com.github.catvod.spider.merge.b.b.p("https://youtubei.googleapis.com/youtubei/v1/player?prettyPrint=false&t=", YoutubeParsingHelper.generateTParameter(), "&id=", str), mobileClientHeaders, bytes, localization2)));
    }

    private static Map<String, List<String>> getMobileClientHeaders(String str) {
        Object[] objArr = {str};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        List listG = com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList);
        ArrayList arrayList2 = new ArrayList(1);
        Object obj2 = new Object[]{"2"}[0];
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("User-Agent", listG), new AbstractMap.SimpleEntry("X-Goog-Api-Format-Version", com.github.catvod.spider.merge.t0.a.g(obj2, arrayList2, obj2, arrayList2))};
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

    public static JsonObject getVisionOsPlayerResponse(ContentCountry contentCountry, Localization localization, String str, String str2) {
        InnertubeClientRequestInfo innertubeClientRequestInfoOfVisionOsClient = InnertubeClientRequestInfo.ofVisionOsClient();
        Map<String, List<String>> mobileClientHeaders = getMobileClientHeaders(YoutubeParsingHelper.getVisionOsUserAgent(localization));
        innertubeClientRequestInfoOfVisionOsClient.clientInfo.visitorData = YoutubeParsingHelper.getVisitorDataFromInnertube(innertubeClientRequestInfoOfVisionOsClient, localization, contentCountry, mobileClientHeaders, YoutubeParsingHelper.YOUTUBEI_V1_URL, null, false);
        JsonBuilder<JsonObject> jsonBuilderPrepareJsonBuilder = YoutubeParsingHelper.prepareJsonBuilder(localization, contentCountry, innertubeClientRequestInfoOfVisionOsClient, null);
        addVideoIdCpnAndOkChecks(jsonBuilderPrepareJsonBuilder, str, str2);
        byte[] bytes = JsonWriter.string(jsonBuilderPrepareJsonBuilder.done()).getBytes(StandardCharsets.UTF_8);
        return JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson(com.github.catvod.spider.merge.b.b.p("https://youtubei.googleapis.com/youtubei/v1/player?prettyPrint=false&t=", YoutubeParsingHelper.generateTParameter(), "&id=", str), mobileClientHeaders, bytes, localization)));
    }

    public static JsonObject getWebEmbeddedPlayerResponse(Localization localization, ContentCountry contentCountry, String str, String str2, PoTokenResult poTokenResult, int i) throws ParsingException {
        Localization localization2;
        ContentCountry contentCountry2;
        String visitorDataFromInnertube;
        InnertubeClientRequestInfo innertubeClientRequestInfoOfWebEmbeddedPlayerClient = InnertubeClientRequestInfo.ofWebEmbeddedPlayerClient();
        HashMap map = new HashMap(YoutubeParsingHelper.getClientHeaders("56", "1.20260122.01.00"));
        map.putAll(YoutubeParsingHelper.getOriginReferrerHeaders("https://www.youtube.com"));
        String str3 = BASE_YT_DESKTOP_WATCH_URL + str;
        InnertubeClientRequestInfo.ClientInfo clientInfo = innertubeClientRequestInfoOfWebEmbeddedPlayerClient.clientInfo;
        if (poTokenResult == null) {
            localization2 = localization;
            contentCountry2 = contentCountry;
            visitorDataFromInnertube = YoutubeParsingHelper.getVisitorDataFromInnertube(innertubeClientRequestInfoOfWebEmbeddedPlayerClient, localization2, contentCountry2, map, YoutubeParsingHelper.YOUTUBEI_V1_URL, str3, false);
        } else {
            localization2 = localization;
            contentCountry2 = contentCountry;
            visitorDataFromInnertube = poTokenResult.visitorData;
        }
        clientInfo.visitorData = visitorDataFromInnertube;
        JsonBuilder<JsonObject> jsonBuilderPrepareJsonBuilder = YoutubeParsingHelper.prepareJsonBuilder(localization2, contentCountry2, innertubeClientRequestInfoOfWebEmbeddedPlayerClient, str3);
        addVideoIdCpnAndOkChecks(jsonBuilderPrepareJsonBuilder, str, str2);
        addPlaybackContext(jsonBuilderPrepareJsonBuilder, str3, i);
        if (poTokenResult != null) {
            addPoToken(jsonBuilderPrepareJsonBuilder, poTokenResult.playerRequestPoToken);
        }
        return JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson("https://www.youtube.com/youtubei/v1/player?prettyPrint=false", map, JsonWriter.string(jsonBuilderPrepareJsonBuilder.done()).getBytes(StandardCharsets.UTF_8), localization2)));
    }

    public static JsonObject getWebMetadataPlayerResponse(Localization localization, ContentCountry contentCountry, String str) {
        InnertubeClientRequestInfo innertubeClientRequestInfoOfWebClient = InnertubeClientRequestInfo.ofWebClient();
        innertubeClientRequestInfoOfWebClient.clientInfo.clientVersion = YoutubeParsingHelper.getClientVersion();
        Map<String, List<String>> youTubeHeaders = YoutubeParsingHelper.getYouTubeHeaders();
        innertubeClientRequestInfoOfWebClient.clientInfo.visitorData = YoutubeParsingHelper.getVisitorDataFromInnertube(innertubeClientRequestInfoOfWebClient, localization, contentCountry, youTubeHeaders, YoutubeParsingHelper.YOUTUBEI_V1_URL, null, false);
        JsonBuilder<JsonObject> jsonBuilderPrepareJsonBuilder = YoutubeParsingHelper.prepareJsonBuilder(localization, contentCountry, innertubeClientRequestInfoOfWebClient, null);
        addVideoIdCpnAndOkChecks(jsonBuilderPrepareJsonBuilder, str, null);
        return JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(NewPipe.getDownloader().postWithContentTypeJson("https://www.youtube.com/youtubei/v1/player?prettyPrint=false&$fields=microformat,videoDetails.thumbnail.thumbnails,videoDetails.videoId", youTubeHeaders, JsonWriter.string(jsonBuilderPrepareJsonBuilder.done()).getBytes(StandardCharsets.UTF_8), localization)));
    }
}
