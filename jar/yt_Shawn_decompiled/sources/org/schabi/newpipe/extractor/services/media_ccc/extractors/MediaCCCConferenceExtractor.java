package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.linkhandler.ReadyChannelTabListLinkHandler;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCConferenceLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCConferenceExtractor extends ChannelExtractor {
    private JsonObject conferenceData;

    public MediaCCCConferenceExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    public static JsonObject fetchConferenceData(Downloader downloader, String str) throws ExtractionException {
        String strN = com.github.catvod.spider.merge.b.b.n(MediaCCCConferenceLinkHandlerFactory.CONFERENCE_API_ENDPOINT, str);
        try {
            return JsonParser.object().from(downloader.get(strN).responseBody());
        } catch (JsonParserException unused) {
            throw new ExtractionException("Could not parse json returned by URL: ".concat(strN));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ChannelTabExtractor lambda$getTabs$91397d47$1(JsonObject jsonObject, StreamingService streamingService, ListLinkHandler listLinkHandler) {
        return new MediaCCCChannelTabExtractor(streamingService, listLinkHandler, jsonObject);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getAvatars() {
        return MediaCCCParsingHelper.getImageListFromLogoImageUrl(this.conferenceData.getString("logo_url"));
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getBanners() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getDescription() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getFeedUrl() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.conferenceData.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getParentChannelAvatars() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getParentChannelName() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getParentChannelUrl() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public long getSubscriberCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<ListLinkHandler> getTabs() {
        Object[] objArr = {new ReadyChannelTabListLinkHandler(getUrl(), getId(), "videos", new b(this.conferenceData))};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        return com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public boolean isVerified() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        this.conferenceData = fetchConferenceData(downloader, getId());
    }
}
