package org.schabi.newpipe.extractor.services.peertube;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.s0.a;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.InfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.exceptions.ContentNotAvailableException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.b;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeChannelInfoItemExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubePlaylistInfoItemExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeSepiaStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.services.peertube.extractors.PeertubeStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Parser;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PeertubeParsingHelper {
    public static final String COUNT_KEY = "count";
    public static final int ITEMS_PER_PAGE = 12;
    public static final String START_KEY = "start";
    public static final String START_PATTERN = "start=(\\d*)";

    private PeertubeParsingHelper() {
    }

    public static void collectItemsFrom(InfoItemsCollector infoItemsCollector, JsonObject jsonObject, String str, boolean z) throws ParsingException {
        try {
            Iterator<Object> it = ((JsonArray) JsonUtils.getValue(jsonObject, "data")).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof JsonObject) {
                    JsonObject object = (JsonObject) next;
                    if (object.has("video")) {
                        object = object.getObject("video");
                    }
                    infoItemsCollector.commit((InfoItemsCollector) (z ? new PeertubeSepiaStreamInfoItemExtractor(object, str) : object.has("videosLength") ? new PeertubePlaylistInfoItemExtractor(object, str) : object.has("followersCount") ? new PeertubeChannelInfoItemExtractor(object, str) : new PeertubeStreamInfoItemExtractor(object, str)));
                }
            }
        } catch (Exception e) {
            a.m("Unable to extract list info", e);
        }
    }

    public static List<Image> getAvatarsFromOwnerAccountOrVideoChannelObject(String str, JsonObject jsonObject) {
        return getImagesFromAvatarsOrBanners(str, jsonObject, "avatars", "avatar");
    }

    public static List<Image> getBannersFromAccountOrVideoChannelObject(String str, JsonObject jsonObject) {
        return getImagesFromAvatarsOrBanners(str, jsonObject, "banners", "banner");
    }

    private static List<Image> getImagesFromAvatarOrBannerArray(String str, JsonArray jsonArray) {
        return (List) jsonArray.streamAsJsonObjects().filter(new org.schabi.newpipe.extractor.services.bandcamp.extractors.a(3)).map(new b(str, 2)).collect(Collectors.toUnmodifiableList());
    }

    private static List<Image> getImagesFromAvatarsOrBanners(String str, JsonObject jsonObject, String str2, String str3) {
        JsonArray array = jsonObject.getArray(str2);
        if (!Utils.isNullOrEmpty(array)) {
            return getImagesFromAvatarOrBannerArray(str, array);
        }
        JsonObject object = jsonObject.getObject(str3);
        String string = object.getString("path");
        if (Utils.isNullOrEmpty(string)) {
            return Collections.EMPTY_LIST;
        }
        Object[] objArr = {new Image(com.github.catvod.spider.merge.b.b.z(str, string), -1, object.getInt("width", -1), Image.ResolutionLevel.UNKNOWN)};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        return com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList);
    }

    public static Page getNextPage(String str, long j) {
        try {
            String strMatchGroup1 = Parser.matchGroup1(START_PATTERN, str);
            if (Utils.isBlank(strMatchGroup1)) {
                return null;
            }
            long j2 = Long.parseLong(strMatchGroup1) + 12;
            if (j2 >= j) {
                return null;
            }
            return new Page(str.replace(com.github.catvod.spider.merge.b.b.n("start=", strMatchGroup1), "start=" + j2));
        } catch (NumberFormatException | Parser.RegexException unused) {
            return null;
        }
    }

    public static List<Image> getThumbnailsFromPlaylistOrVideoItem(String str, JsonObject jsonObject) {
        ArrayList arrayList = new ArrayList(2);
        String string = jsonObject.getString("thumbnailPath");
        if (!Utils.isNullOrEmpty(string)) {
            arrayList.add(new Image(com.github.catvod.spider.merge.b.b.z(str, string), -1, -1, Image.ResolutionLevel.LOW));
        }
        String string2 = jsonObject.getString("previewPath");
        if (!Utils.isNullOrEmpty(string2)) {
            arrayList.add(new Image(com.github.catvod.spider.merge.b.b.z(str, string2), -1, -1, Image.ResolutionLevel.MEDIUM));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getImagesFromAvatarOrBannerArray$0(JsonObject jsonObject) {
        return !Utils.isNullOrEmpty(jsonObject.getString("path"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Image lambda$getImagesFromAvatarOrBannerArray$1(String str, JsonObject jsonObject) {
        return new Image(com.github.catvod.spider.merge.b.b.z(str, jsonObject.getString("path")), -1, jsonObject.getInt("width", -1), Image.ResolutionLevel.UNKNOWN);
    }

    public static void validate(JsonObject jsonObject) {
        String string = jsonObject.getString("error");
        if (!Utils.isBlank(string)) {
            throw new ContentNotAvailableException(string);
        }
    }

    public static void collectItemsFrom(InfoItemsCollector infoItemsCollector, JsonObject jsonObject, String str) throws ParsingException {
        collectItemsFrom(infoItemsCollector, jsonObject, str, false);
    }
}
