package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.ZonedDateTime;
import com.github.catvod.spider.jdollar.time.format.DateTimeFormatter;
import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.merge.n1.g;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import com.grack.nanojson.JsonStringWriter;
import com.grack.nanojson.JsonWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.ImageSuffix;
import org.schabi.newpipe.extractor.utils.Utils;
import org.schabi.newpipe.extractor.utils.c;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class BandcampExtractorHelper {
    public static final String BASE_API_URL = "https://bandcamp.com/api";
    public static final String BASE_URL = "https://bandcamp.com";
    private static final String IMAGES_DOMAIN_AND_PATH = "https://f4.bcbits.com/img/";
    private static final String IMAGE_URL_APPENDIX_AND_EXTENSION_REGEX = "_\\d+\\.\\w+";
    private static final List<ImageSuffix> IMAGE_URL_SUFFIXES_AND_RESOLUTIONS;

    static {
        Image.ResolutionLevel resolutionLevel = Image.ResolutionLevel.HIGH;
        ImageSuffix imageSuffix = new ImageSuffix("10.jpg", -1, 1200, resolutionLevel);
        Image.ResolutionLevel resolutionLevel2 = Image.ResolutionLevel.LOW;
        ImageSuffix imageSuffix2 = new ImageSuffix("101.jpg", 90, -1, resolutionLevel2);
        Image.ResolutionLevel resolutionLevel3 = Image.ResolutionLevel.MEDIUM;
        ImageSuffix imageSuffix3 = new ImageSuffix("170.jpg", 422, -1, resolutionLevel3);
        ImageSuffix imageSuffix4 = new ImageSuffix("171.jpg", 646, -1, resolutionLevel3);
        ImageSuffix imageSuffix5 = new ImageSuffix("20.jpg", -1, 1024, resolutionLevel);
        ImageSuffix imageSuffix6 = new ImageSuffix("200.jpg", 420, -1, resolutionLevel3);
        ImageSuffix imageSuffix7 = new ImageSuffix("201.jpg", 280, -1, resolutionLevel3);
        ImageSuffix imageSuffix8 = new ImageSuffix("202.jpg", 140, -1, resolutionLevel2);
        ImageSuffix imageSuffix9 = new ImageSuffix("204.jpg", 360, -1, resolutionLevel3);
        ImageSuffix imageSuffix10 = new ImageSuffix("205.jpg", 240, -1, resolutionLevel3);
        ImageSuffix imageSuffix11 = new ImageSuffix("206.jpg", 180, -1, resolutionLevel3);
        ImageSuffix imageSuffix12 = new ImageSuffix("207.jpg", 120, -1, resolutionLevel2);
        ImageSuffix imageSuffix13 = new ImageSuffix("43.jpg", 100, -1, resolutionLevel2);
        ImageSuffix imageSuffix14 = new ImageSuffix("44.jpg", 200, -1, resolutionLevel3);
        ImageSuffix[] imageSuffixArr = {imageSuffix, imageSuffix2, imageSuffix3, imageSuffix4, imageSuffix5, imageSuffix6, imageSuffix7, imageSuffix8, imageSuffix9, imageSuffix10, imageSuffix11, imageSuffix12, imageSuffix13, imageSuffix14};
        ArrayList arrayList = new ArrayList(14);
        for (int i = 0; i < 14; i++) {
            ImageSuffix imageSuffix15 = imageSuffixArr[i];
            Objects.requireNonNull(imageSuffix15);
            arrayList.add(imageSuffix15);
        }
        IMAGE_URL_SUFFIXES_AND_RESOLUTIONS = DesugarCollections.unmodifiableList(arrayList);
    }

    private BandcampExtractorHelper() {
    }

    public static JsonObject getArtistDetails(String str) throws ParsingException {
        try {
            return JsonParser.object().from(NewPipe.getDownloader().postWithContentTypeJson("https://bandcamp.com/api/mobile/22/band_details", Collections.EMPTY_MAP, ((JsonStringWriter) ((JsonStringWriter) ((JsonStringWriter) JsonWriter.string().object()).value("band_id", str)).end()).done().getBytes(StandardCharsets.UTF_8)).responseBody());
        } catch (JsonParserException | IOException | ReCaptchaException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not download band details", e);
            return null;
        }
    }

    public static String getImageUrl(long j, boolean z) {
        return IMAGES_DOMAIN_AND_PATH + (z ? 'a' : VideoStream.RESOLUTION_UNKNOWN) + j + "_10.jpg";
    }

    private static List<Image> getImagesFromImageBaseUrl(String str) {
        return (List) Collection$EL.stream(IMAGE_URL_SUFFIXES_AND_RESOLUTIONS).map(new b(str, 0)).collect(Collectors.toUnmodifiableList());
    }

    public static List<Image> getImagesFromImageId(long j, boolean z) {
        if (j == 0) {
            return Collections.EMPTY_LIST;
        }
        return getImagesFromImageBaseUrl(IMAGES_DOMAIN_AND_PATH + (z ? 'a' : VideoStream.RESOLUTION_UNKNOWN) + j + "_");
    }

    public static List<Image> getImagesFromImageUrl(String str) {
        return Utils.isNullOrEmpty(str) ? Collections.EMPTY_LIST : getImagesFromImageBaseUrl(str.replaceFirst(IMAGE_URL_APPENDIX_AND_EXTENSION_REGEX, "_"));
    }

    public static List<Image> getImagesFromSearchResult(n nVar) {
        return getImagesFromImageUrl((String) Collection$EL.stream(nVar.N("art")).flatMap(new g(18)).map(new g(19)).filter(new a(2)).findFirst().orElse(VideoStream.RESOLUTION_UNKNOWN));
    }

    public static String getStreamUrlFromIds(long j, long j2, String str) throws ParsingException {
        try {
            return Utils.replaceHttpWithHttps(JsonParser.object().from(NewPipe.getDownloader().get("https://bandcamp.com/api/mobile/22/tralbum_details?band_id=" + j + "&tralbum_id=" + j2 + "&tralbum_type=" + str.charAt(0)).responseBody()).getString("bandcamp_url"));
        } catch (JsonParserException | IOException | ReCaptchaException e) {
            com.github.catvod.spider.merge.s0.a.m("Ids could not be translated to URL", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isArtistDomain(String str) throws ParsingException {
        if (str.toLowerCase().matches("https?://.+\\.bandcamp\\.com(/.*)?")) {
            return true;
        }
        if (str.toLowerCase().matches("https?://bandcamp\\.com(/.*)?")) {
            return false;
        }
        try {
            return ((n) ((n) c2.T(NewPipe.getDownloader().get(Utils.replaceHttpWithHttps(str)).responseBody()).N("cart-wrapper").get(0)).O("a").get(0)).b("href").equals("https://bandcamp.com/cart");
        } catch (IOException | ReCaptchaException unused) {
            c.a("Could not determine whether URL is custom domain (not available? network error?)");
            return false;
        } catch (IndexOutOfBoundsException | NullPointerException unused2) {
            return false;
        }
    }

    public static boolean isRadioUrl(String str) {
        return str.toLowerCase().matches("https?://bandcamp\\.com/\\?show=\\d+");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Image lambda$getImagesFromImageBaseUrl$3(String str, ImageSuffix imageSuffix) {
        return new Image(com.github.catvod.spider.merge.b.b.z(str, imageSuffix.getSuffix()), imageSuffix.getHeight(), imageSuffix.getWidth(), imageSuffix.getResolutionLevel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getImagesFromSearchResult$0(n nVar) {
        return Collection$EL.stream(nVar.O("img"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getImagesFromSearchResult$1(n nVar) {
        return nVar.b("src");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getImagesFromSearchResult$2(String str) {
        return !Utils.isNullOrEmpty(str);
    }

    public static DateWrapper parseDate(String str) throws ParsingException {
        try {
            return new DateWrapper(ZonedDateTime.parse(str, DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH)).toInstant());
        } catch (DateTimeException e) {
            throw new ParsingException(com.github.catvod.spider.merge.b.b.A("Could not parse date '", str, "'"), e);
        }
    }
}
