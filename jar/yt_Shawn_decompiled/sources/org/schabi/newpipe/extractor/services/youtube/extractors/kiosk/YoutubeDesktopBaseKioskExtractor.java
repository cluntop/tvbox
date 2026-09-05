package org.schabi.newpipe.extractor.services.youtube.extractors.kiosk;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.StandardCharsets;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.youtube.InnertubeClientRequestInfo;
import org.schabi.newpipe.extractor.services.youtube.YoutubeChannelHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.services.youtube.extractors.YoutubeStreamInfoItemLockupExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
abstract class YoutubeDesktopBaseKioskExtractor extends KioskExtractor<StreamInfoItem> {
    protected final String browseId;
    protected final String params;
    protected YoutubeChannelHelper.ChannelResponseData responseData;

    public YoutubeDesktopBaseKioskExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str, String str2, String str3) {
        super(streamingService, listLinkHandler, str);
        this.browseId = str2;
        this.params = str3;
    }

    private ListExtractor.InfoItemsPage<StreamInfoItem> collectStreamItems(JsonArray jsonArray, String str) {
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        Page nextPageFrom = null;
        if (!jsonArray.isEmpty()) {
            jsonArray.streamAsJsonObjects().forEachOrdered(new b(streamInfoItemsCollector, getTimeAgoParser(), 0));
            JsonObject object = jsonArray.getObject(jsonArray.size() - 1);
            if (object.has("continuationItemRenderer")) {
                nextPageFrom = getNextPageFrom(object.getObject("continuationItemRenderer"), str);
            }
        }
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, nextPageFrom);
    }

    private Page getNextPageFrom(JsonObject jsonObject, String str) {
        if (Utils.isNullOrEmpty(jsonObject)) {
            return null;
        }
        String string = jsonObject.getObject("continuationEndpoint").getObject("continuationCommand").getString("token");
        InnertubeClientRequestInfo innertubeClientRequestInfoOfWebClient = InnertubeClientRequestInfo.ofWebClient();
        innertubeClientRequestInfoOfWebClient.clientInfo.clientVersion = YoutubeParsingHelper.getClientVersion();
        innertubeClientRequestInfoOfWebClient.clientInfo.visitorData = str;
        return new Page("https://www.youtube.com/youtubei/v1/browse?prettyPrint=false", str, null, null, JsonWriter.string(YoutubeParsingHelper.prepareJsonBuilder(getExtractorLocalization(), getExtractorContentCountry(), innertubeClientRequestInfoOfWebClient, null).value("continuation", string).done()).getBytes(StandardCharsets.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$collectStreamItems$2(StreamInfoItemsCollector streamInfoItemsCollector, TimeAgoParser timeAgoParser, JsonObject jsonObject) {
        if (jsonObject.has("richItemRenderer")) {
            JsonObject object = jsonObject.getObject("richItemRenderer").getObject("content");
            if (object.has("videoRenderer")) {
                streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeStreamInfoItemExtractor(object.getObject("videoRenderer"), timeAgoParser));
                return;
            }
            return;
        }
        if (jsonObject.has("gridVideoRenderer")) {
            streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeStreamInfoItemExtractor(jsonObject.getObject("gridVideoRenderer"), timeAgoParser));
        } else if (jsonObject.has("lockupViewModel")) {
            JsonObject object2 = jsonObject.getObject("lockupViewModel");
            if ("LOCKUP_CONTENT_TYPE_VIDEO".equals(object2.getString("contentType"))) {
                streamInfoItemsCollector.commit((StreamInfoItemExtractor) new YoutubeStreamInfoItemLockupExtractor(object2, timeAgoParser));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPage$0(JsonObject jsonObject) {
        return jsonObject.has("appendContinuationItemsAction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getPage$1(JsonObject jsonObject) {
        return jsonObject.getObject("appendContinuationItemsAction");
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        JsonObject object = this.responseData.jsonResponse.getObject("contents").getObject("twoColumnBrowseResultsRenderer").getArray("tabs").getObject(0).getObject("tabRenderer").getObject("content");
        return collectStreamItems(object.has("sectionListRenderer") ? object.getObject("sectionListRenderer").getArray("contents").getObject(0).getObject("itemSectionRenderer").getArray("contents").getObject(0).getObject("shelfRenderer").getObject("content").getObject("gridRenderer").getArray("items") : object.has("richGridRenderer") ? object.getObject("richGridRenderer").getArray("contents") : new JsonArray(), this.responseData.jsonResponse.getObject("responseContext").getString("visitorData"));
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return YoutubeChannelHelper.getChannelName(YoutubeChannelHelper.getChannelHeader(this.responseData.jsonResponse), null, this.responseData.jsonResponse);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        if (page == null || page.getBody() == null) {
            com.github.catvod.spider.merge.s0.a.r("Page is null or doesn't contain a body");
            return null;
        }
        int i = 0;
        return collectStreamItems(((JsonObject) YoutubeParsingHelper.getJsonPostResponse("browse", page.getBody(), getExtractorLocalization()).getArray("onResponseReceivedActions").streamAsJsonObjects().filter(new c(i)).map(new d(i)).findFirst().orElse(new JsonObject())).getArray("continuationItems"), page.getId());
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        this.responseData = YoutubeChannelHelper.getChannelResponse(this.browseId, this.params, getExtractorLocalization(), getExtractorContentCountry());
    }
}
