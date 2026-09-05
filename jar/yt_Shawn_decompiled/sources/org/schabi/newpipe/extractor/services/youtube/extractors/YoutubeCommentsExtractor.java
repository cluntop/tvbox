package org.schabi.newpipe.extractor.services.youtube.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.comments.CommentsExtractor;
import org.schabi.newpipe.extractor.comments.CommentsInfoItem;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemExtractor;
import org.schabi.newpipe.extractor.comments.CommentsInfoItemsCollector;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.localization.TimeAgoParser;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeCommentsExtractor extends CommentsExtractor {
    private static final String COMMENT_RENDERER_KEY = "commentRenderer";
    private static final String COMMENT_VIEW_MODEL_KEY = "commentViewModel";
    private JsonObject ajaxJson;
    private boolean commentsDisabled;

    public YoutubeCommentsExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    private void collectCommentItem(JsonArray jsonArray, JsonObject jsonObject, CommentsInfoItemsCollector commentsInfoItemsCollector, String str, TimeAgoParser timeAgoParser) {
        if (!jsonObject.has("commentThreadRenderer")) {
            if (jsonObject.has(COMMENT_VIEW_MODEL_KEY)) {
                JsonObject object = jsonObject.getObject(COMMENT_VIEW_MODEL_KEY);
                commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new YoutubeCommentsEUVMInfoItemExtractor(object, null, getMutationPayloadFromEntityKey(jsonArray, object.getString("commentKey", VideoStream.RESOLUTION_UNKNOWN)).getObject("commentEntityPayload"), getMutationPayloadFromEntityKey(jsonArray, object.getString("toolbarStateKey", VideoStream.RESOLUTION_UNKNOWN)).getObject("engagementToolbarStateEntityPayload"), str, timeAgoParser));
                return;
            } else {
                if (jsonObject.has(COMMENT_RENDERER_KEY)) {
                    commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new YoutubeCommentsInfoItemExtractor(jsonObject.getObject(COMMENT_RENDERER_KEY), null, str, timeAgoParser));
                    return;
                }
                return;
            }
        }
        JsonObject object2 = jsonObject.getObject("commentThreadRenderer");
        if (object2.has(COMMENT_VIEW_MODEL_KEY)) {
            JsonObject object3 = object2.getObject(COMMENT_VIEW_MODEL_KEY).getObject(COMMENT_VIEW_MODEL_KEY);
            commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new YoutubeCommentsEUVMInfoItemExtractor(object3, object2.getObject("replies").getObject("commentRepliesRenderer"), getMutationPayloadFromEntityKey(jsonArray, object3.getString("commentKey", VideoStream.RESOLUTION_UNKNOWN)).getObject("commentEntityPayload"), getMutationPayloadFromEntityKey(jsonArray, object3.getString("toolbarStateKey", VideoStream.RESOLUTION_UNKNOWN)).getObject("engagementToolbarStateEntityPayload"), str, timeAgoParser));
        } else if (object2.has("comment")) {
            commentsInfoItemsCollector.commit((CommentsInfoItemExtractor) new YoutubeCommentsInfoItemExtractor(object2.getObject("comment").getObject(COMMENT_RENDERER_KEY), object2.getObject("replies").getObject("commentRepliesRenderer"), str, timeAgoParser));
        }
    }

    private void collectCommentsFrom(CommentsInfoItemsCollector commentsInfoItemsCollector, JsonObject jsonObject) {
        String str;
        JsonArray array = jsonObject.getArray("onResponseReceivedEndpoints");
        if (array.isEmpty()) {
            return;
        }
        JsonObject object = array.getObject(array.size() - 1);
        if (object.has("reloadContinuationItemsCommand")) {
            str = "reloadContinuationItemsCommand.continuationItems";
        } else if (!object.has("appendContinuationItemsAction")) {
            return;
        } else {
            str = "appendContinuationItemsAction.continuationItems";
        }
        try {
            JsonArray jsonArray = new JsonArray(JsonUtils.getArray(object, str));
            int size = jsonArray.size() - 1;
            if (!jsonArray.isEmpty() && jsonArray.getObject(size).has("continuationItemRenderer")) {
                jsonArray.remove(size);
            }
            JsonArray array2 = jsonObject.getObject("frameworkUpdates").getObject("entityBatchUpdate").getArray("mutations");
            String url = getUrl();
            TimeAgoParser timeAgoParser = getTimeAgoParser();
            Iterator<Object> it = jsonArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof JsonObject) {
                    collectCommentItem(array2, (JsonObject) next, commentsInfoItemsCollector, url, timeAgoParser);
                }
            }
        } catch (Exception unused) {
        }
    }

    private ListExtractor.InfoItemsPage<CommentsInfoItem> extractComments(JsonObject jsonObject) {
        CommentsInfoItemsCollector commentsInfoItemsCollector = new CommentsInfoItemsCollector(getServiceId());
        collectCommentsFrom(commentsInfoItemsCollector, jsonObject);
        return new ListExtractor.InfoItemsPage<>(commentsInfoItemsCollector, getNextPage(jsonObject));
    }

    private String findInitialCommentsToken(JsonObject jsonObject) {
        JsonArray jsonContents = getJsonContents(jsonObject);
        if (jsonContents == null) {
            return null;
        }
        String str = (String) jsonContents.streamAsJsonObjects().filter(new n(7)).findFirst().map(new h(10)).orElse(null);
        this.commentsDisabled = str == null;
        return str;
    }

    private ListExtractor.InfoItemsPage<CommentsInfoItem> getInfoItemsPageForDisabledComments() {
        List list = Collections.EMPTY_LIST;
        return new ListExtractor.InfoItemsPage<>(list, null, list);
    }

    private JsonArray getJsonContents(JsonObject jsonObject) {
        try {
            return JsonUtils.getArray(jsonObject, "contents.twoColumnWatchNextResults.results.results.contents");
        } catch (ParsingException unused) {
            return null;
        }
    }

    private JsonObject getMutationPayloadFromEntityKey(JsonArray jsonArray, String str) {
        return jsonArray.streamAsJsonObjects().filter(new d(str, 1)).findFirst().orElseThrow(new i(3)).getObject("payload");
    }

    private Page getNextPage(JsonObject jsonObject) {
        JsonArray array = jsonObject.getArray("onResponseReceivedEndpoints");
        if (array.isEmpty()) {
            return null;
        }
        try {
            JsonObject object = array.getObject(array.size() - 1);
            JsonArray array2 = object.getObject("reloadContinuationItemsCommand", object.getObject("appendContinuationItemsAction")).getArray("continuationItems");
            if (array2.isEmpty()) {
                return null;
            }
            JsonObject object2 = array2.getObject(array2.size() - 1).getObject("continuationItemRenderer");
            return getNextPage(JsonUtils.getString(object2, object2.has("button") ? "button.buttonRenderer.command.continuationCommand.token" : "continuationEndpoint.continuationCommand.token"));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findInitialCommentsToken$0(JsonObject jsonObject) {
        try {
            return "comments-section".equals(JsonUtils.getString(jsonObject, "itemSectionRenderer.targetId"));
        } catch (ParsingException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$findInitialCommentsToken$1(JsonObject jsonObject) {
        try {
            return JsonUtils.getString(jsonObject.getObject("itemSectionRenderer").getArray("contents").getObject(0), "continuationItemRenderer.continuationEndpoint.continuationCommand.token");
        } catch (ParsingException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMutationPayloadFromEntityKey$2(String str, JsonObject jsonObject) {
        return str.equals(jsonObject.getString("entityKey"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getMutationPayloadFromEntityKey$3() {
        return new ParsingException("Could not get comment entity payload mutation");
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsExtractor
    public int getCommentsCount() throws ExtractionException {
        assertPageFetched();
        if (this.commentsDisabled) {
            return -1;
        }
        try {
            return Integer.parseInt(Utils.removeNonDigitCharacters(YoutubeParsingHelper.getTextFromObject(this.ajaxJson.getArray("onResponseReceivedEndpoints").getObject(0).getObject("reloadContinuationItemsCommand").getArray("continuationItems").getObject(0).getObject("commentsHeaderRenderer").getObject("countText"))));
        } catch (Exception e) {
            throw new ExtractionException("Unable to get comments count", e);
        }
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<CommentsInfoItem> getInitialPage() {
        return this.commentsDisabled ? getInfoItemsPageForDisabledComments() : extractComments(this.ajaxJson);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<CommentsInfoItem> getPage(Page page) {
        if (this.commentsDisabled) {
            return getInfoItemsPageForDisabledComments();
        }
        if (page == null || Utils.isNullOrEmpty(page.getId())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't have the continuation.");
            return null;
        }
        Localization extractorLocalization = getExtractorLocalization();
        return extractComments(YoutubeParsingHelper.getJsonPostResponse("next", JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, getExtractorContentCountry()).value("continuation", page.getId()).done()).getBytes(StandardCharsets.UTF_8), extractorLocalization));
    }

    @Override // org.schabi.newpipe.extractor.comments.CommentsExtractor
    public boolean isCommentsDisabled() {
        return this.commentsDisabled;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        Localization extractorLocalization = getExtractorLocalization();
        String strString = JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, getExtractorContentCountry()).value(YoutubeParsingHelper.VIDEO_ID, getId()).done());
        Charset charset = StandardCharsets.UTF_8;
        String strFindInitialCommentsToken = findInitialCommentsToken(YoutubeParsingHelper.getJsonPostResponse("next", strString.getBytes(charset), extractorLocalization));
        if (strFindInitialCommentsToken == null) {
            return;
        }
        this.ajaxJson = YoutubeParsingHelper.getJsonPostResponse("next", JsonWriter.string(YoutubeParsingHelper.prepareDesktopJsonBuilder(extractorLocalization, getExtractorContentCountry()).value("continuation", strFindInitialCommentsToken).done()).getBytes(charset), extractorLocalization);
    }

    private Page getNextPage(String str) {
        return new Page(getUrl(), str);
    }
}
