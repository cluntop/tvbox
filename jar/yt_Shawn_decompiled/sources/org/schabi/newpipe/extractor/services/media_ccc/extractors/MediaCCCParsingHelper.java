package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class MediaCCCParsingHelper {
    private static final Pattern LIVE_STREAM_ID_PATTERN = Pattern.compile("\\w+/\\w+");
    private static JsonArray liveStreams = null;

    private MediaCCCParsingHelper() {
    }

    public static List<Image> getImageListFromLogoImageUrl(String str) {
        if (Utils.isNullOrEmpty(str)) {
            return Collections.EMPTY_LIST;
        }
        Object[] objArr = {new Image(str, -1, -1, Image.ResolutionLevel.UNKNOWN)};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        return com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList);
    }

    public static JsonArray getLiveStreams(Downloader downloader, Localization localization) {
        if (liveStreams == null) {
            try {
                liveStreams = JsonParser.array().from(downloader.get("https://streaming.media.ccc.de/streams/v2.json", localization).responseBody());
            } catch (JsonParserException e) {
                throw new ExtractionException("Could not parse JSON.", e);
            } catch (IOException | ReCaptchaException e2) {
                throw new ExtractionException("Could not get live stream JSON.", e2);
            }
        }
        return liveStreams;
    }

    public static List<Image> getThumbnailsFromLiveStreamItem(JsonObject jsonObject) {
        return getThumbnailsFromObject(jsonObject, "thumb", "poster");
    }

    private static List<Image> getThumbnailsFromObject(JsonObject jsonObject, String str, String str2) {
        ArrayList arrayList = new ArrayList(2);
        String string = jsonObject.getString(str);
        if (!Utils.isNullOrEmpty(string)) {
            arrayList.add(new Image(string, -1, -1, Image.ResolutionLevel.MEDIUM));
        }
        String string2 = jsonObject.getString(str2);
        if (!Utils.isNullOrEmpty(string2)) {
            arrayList.add(new Image(string2, -1, -1, Image.ResolutionLevel.HIGH));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public static List<Image> getThumbnailsFromStreamItem(JsonObject jsonObject) {
        return getThumbnailsFromObject(jsonObject, "thumb_url", "poster_url");
    }

    public static boolean isLiveStreamId(String str) {
        return LIVE_STREAM_ID_PATTERN.matcher(str).find();
    }
}
