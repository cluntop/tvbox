package org.schabi.newpipe.extractor.services.youtube.extractors.kiosk;

import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.function.Consumer$CC;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.services.youtube.InnertubeClientRequestInfo;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.ContentAvailability;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
abstract class YoutubeChartsBaseKioskExtractor extends KioskExtractor<StreamInfoItem> {
    protected static final String YT_CHARTS_ENDPOINT = "https://charts.youtube.com/youtubei/v1/browse?alt=json&prettyPrint=false";
    protected static final Set<String> YT_CHARTS_SUPPORTED_COUNTRY_CODES;
    protected JsonObject browseResponse;
    protected final String chartType;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    final class YoutubeChartsVideoInfoItemExtractor implements StreamInfoItemExtractor {
        private final JsonObject videoObject;

        public YoutubeChartsVideoInfoItemExtractor(JsonObject jsonObject) {
            this.videoObject = jsonObject;
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public final ContentAvailability getContentAvailability() {
            return ContentAvailability.UNKNOWN;
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public long getDuration() {
            return this.videoObject.getInt("videoDuration", -1);
        }

        @Override // org.schabi.newpipe.extractor.InfoItemExtractor
        public String getName() {
            return this.videoObject.getString("title");
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public final /* synthetic */ String getShortDescription() {
            return null;
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public StreamType getStreamType() {
            return StreamType.VIDEO_STREAM;
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public String getTextualUploadDate() {
            return null;
        }

        @Override // org.schabi.newpipe.extractor.InfoItemExtractor
        public List<Image> getThumbnails() {
            return YoutubeParsingHelper.getThumbnailsFromInfoItem(this.videoObject);
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public DateWrapper getUploadDate() {
            JsonObject object = this.videoObject.getObject("releaseDate");
            return new DateWrapper(LocalDate.of(object.getInt("year"), object.getInt("month"), object.getInt("day")).atStartOfDay(ZoneOffset.UTC).toInstant(), true);
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public final List getUploaderAvatars() {
            return Collections.EMPTY_LIST;
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public String getUploaderName() {
            return this.videoObject.getString("channelName");
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public String getUploaderUrl() throws ParsingException {
            String string = this.videoObject.getString("externalChannelId");
            if (Utils.isNullOrEmpty(string)) {
                org.schabi.newpipe.extractor.utils.c.a("Could not get channel ID");
                return null;
            }
            return YoutubeChannelLinkHandlerFactory.getInstance().getUrl("channel/" + string);
        }

        @Override // org.schabi.newpipe.extractor.InfoItemExtractor
        public String getUrl() {
            return YoutubeStreamLinkHandlerFactory.getInstance().getUrl(this.videoObject.getString("id"));
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public long getViewCount() {
            return -1L;
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public boolean isAd() {
            return false;
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public final /* synthetic */ boolean isShortFormContent() {
            return false;
        }

        @Override // org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor
        public boolean isUploaderVerified() {
            return false;
        }
    }

    static {
        String[] strArr = {"AE", "AR", "AT", "AU", "BE", "BO", "BR", "CA", "CH", "CL", "CO", "CR", "CZ", "DE", "DK", "DO", "EC", "EE", "EG", "ES", "FI", "FR", "GB", "GT", "HN", "HU", "ID", "IE", "IL", "IN", "IS", "IT", "JP", "KE", "KR", "LU", "MX", "NG", "NI", "NL", "NO", "NZ", "PA", "PE", "PL", "PT", "PY", "RO", "RS", "RU", "SA", "SE", "SV", "TR", "TZ", "UA", "UG", "US", "UY", "ZA", "ZW"};
        HashSet hashSet = new HashSet(61);
        for (int i = 0; i < 61; i++) {
            String str = strArr[i];
            Objects.requireNonNull(str);
            if (!hashSet.add(str)) {
                com.github.catvod.spider.merge.b0.a.j("duplicate element: ", str);
                return;
            }
        }
        YT_CHARTS_SUPPORTED_COUNTRY_CODES = DesugarCollections.unmodifiableSet(hashSet);
    }

    public YoutubeChartsBaseKioskExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str, String str2) {
        super(streamingService, listLinkHandler, str);
        this.chartType = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInitialPage$0(StreamInfoItemsCollector streamInfoItemsCollector, JsonObject jsonObject) {
        streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeChartsVideoInfoItemExtractor(jsonObject));
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        JsonArray array = this.browseResponse.getObject("contents").getObject("sectionListRenderer").getArray("contents").getObject(0).getObject("musicAnalyticsSectionRenderer").getObject("content").getArray("videos").getObject(0).getArray("videoViews");
        final StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        array.streamAsJsonObjects().forEachOrdered(new Consumer() { // from class: org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                YoutubeChartsBaseKioskExtractor.lambda$getInitialPage$0(streamInfoItemsCollector, (JsonObject) obj);
            }

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public abstract String getName();

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        return ListExtractor.InfoItemsPage.emptyPage();
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        Localization extractorLocalization = getExtractorLocalization();
        ContentCountry extractorContentCountry = getExtractorContentCountry();
        InnertubeClientRequestInfo innertubeClientRequestInfoOfWebMusicAnalyticsChartsClient = InnertubeClientRequestInfo.ofWebMusicAnalyticsChartsClient();
        byte[] bytes = JsonWriter.string(YoutubeParsingHelper.prepareJsonBuilder(getExtractorLocalization(), extractorContentCountry, innertubeClientRequestInfoOfWebMusicAnalyticsChartsClient, null).value("browseId", "FEmusic_analytics_charts_home").value("query", com.github.catvod.spider.merge.b.b.p("perspective=CHART_DETAILS&chart_params_country_code=", extractorContentCountry.getCountryCode(), "&chart_params_chart_type=", this.chartType)).done()).getBytes(StandardCharsets.UTF_8);
        HashMap map = new HashMap(YoutubeParsingHelper.getOriginReferrerHeaders("https://charts.youtube.com"));
        InnertubeClientRequestInfo.ClientInfo clientInfo = innertubeClientRequestInfoOfWebMusicAnalyticsChartsClient.clientInfo;
        map.putAll(YoutubeParsingHelper.getClientHeaders(clientInfo.clientId, clientInfo.clientVersion));
        this.browseResponse = JsonUtils.toJsonObject(YoutubeParsingHelper.getValidJsonResponseBody(getDownloader().postWithContentTypeJson(YT_CHARTS_ENDPOINT, map, bytes, extractorLocalization)));
    }
}
