package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.t0.a;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.ArrayList;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeChannelLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeChannelExtractor extends ChannelExtractor {
    private final String baseUrl;
    private JsonObject json;

    public PeertubeChannelExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
        this.baseUrl = getBaseUrl();
    }

    private void setInitialData(String str) throws ExtractionException {
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(str);
            this.json = jsonObjectFrom;
            if (jsonObjectFrom == null) {
                throw new ExtractionException("Unable to extract PeerTube channel data");
            }
        } catch (JsonParserException e) {
            throw new ExtractionException("Unable to extract PeerTube channel data", e);
        }
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getAvatars() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(this.baseUrl, this.json);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getBanners() {
        return PeertubeParsingHelper.getBannersFromAccountOrVideoChannelObject(this.baseUrl, this.json);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getDescription() {
        return this.json.getString("description");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getFeedUrl() {
        return getBaseUrl() + "/feeds/videos.xml?videoChannelId=" + this.json.get("id");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return JsonUtils.getString(this.json, "displayName");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getParentChannelAvatars() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(this.baseUrl, this.json.getObject("ownerAccount"));
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getParentChannelName() {
        return JsonUtils.getString(this.json, "ownerAccount.name");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getParentChannelUrl() {
        return JsonUtils.getString(this.json, "ownerAccount.url");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public long getSubscriberCount() {
        return this.json.getLong("followersCount");
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<ListLinkHandler> getTabs() {
        PeertubeChannelTabLinkHandlerFactory peertubeChannelTabLinkHandlerFactory = PeertubeChannelTabLinkHandlerFactory.getInstance();
        String id = getId();
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{"videos"}[0];
        ListLinkHandler listLinkHandlerFromQuery = peertubeChannelTabLinkHandlerFactory.fromQuery(id, a.g(obj, arrayList, obj, arrayList), VideoStream.RESOLUTION_UNKNOWN, getBaseUrl());
        PeertubeChannelTabLinkHandlerFactory peertubeChannelTabLinkHandlerFactory2 = PeertubeChannelTabLinkHandlerFactory.getInstance();
        String id2 = getId();
        ArrayList arrayList2 = new ArrayList(1);
        Object obj2 = new Object[]{"playlists"}[0];
        Object[] objArr = {listLinkHandlerFromQuery, peertubeChannelTabLinkHandlerFactory2.fromQuery(id2, a.g(obj2, arrayList2, obj2, arrayList2), VideoStream.RESOLUTION_UNKNOWN, getBaseUrl())};
        ArrayList arrayList3 = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            Object obj3 = objArr[i];
            Objects.requireNonNull(obj3);
            arrayList3.add(obj3);
        }
        return DesugarCollections.unmodifiableList(arrayList3);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public boolean isVerified() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        Response response = downloader.get(this.baseUrl + PeertubeChannelLinkHandlerFactory.API_ENDPOINT + getId());
        if (response == null) {
            throw new ExtractionException("Unable to extract PeerTube channel data");
        }
        setInitialData(response.responseBody());
    }
}
