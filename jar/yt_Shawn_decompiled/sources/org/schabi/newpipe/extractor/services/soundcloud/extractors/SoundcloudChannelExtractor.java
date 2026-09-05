package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudChannelTabLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudChannelExtractor extends ChannelExtractor {
    private static final String USERS_ENDPOINT = "https://api-v2.soundcloud.com/users/";
    private JsonObject user;
    private String userId;

    public SoundcloudChannelExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getAvatars() {
        return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(this.user.getString("avatar_url"));
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<Image> getBanners() {
        return SoundcloudParsingHelper.getAllImagesFromVisualUrl(this.user.getObject("visuals").getArray("visuals").getObject(0).getString("visual_url"));
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getDescription() {
        return this.user.getString("description", VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public String getFeedUrl() {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getId() {
        return this.userId;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.user.getString("username");
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
        return this.user.getLong("followers_count", 0L);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public List<ListLinkHandler> getTabs() {
        String url = getUrl();
        String strZ = com.github.catvod.spider.merge.b.b.z(url, SoundcloudChannelTabLinkHandlerFactory.getUrlSuffix("tracks"));
        String strZ2 = com.github.catvod.spider.merge.b.b.z(url, SoundcloudChannelTabLinkHandlerFactory.getUrlSuffix("playlists"));
        String strZ3 = com.github.catvod.spider.merge.b.b.z(url, SoundcloudChannelTabLinkHandlerFactory.getUrlSuffix(ChannelTabs.ALBUMS));
        String strZ4 = com.github.catvod.spider.merge.b.b.z(url, SoundcloudChannelTabLinkHandlerFactory.getUrlSuffix(ChannelTabs.LIKES));
        String id = getId();
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{"tracks"}[0];
        ListLinkHandler listLinkHandler = new ListLinkHandler(strZ, strZ, id, com.github.catvod.spider.merge.t0.a.g(obj, arrayList, obj, arrayList), VideoStream.RESOLUTION_UNKNOWN);
        ArrayList arrayList2 = new ArrayList(1);
        Object obj2 = new Object[]{"playlists"}[0];
        ListLinkHandler listLinkHandler2 = new ListLinkHandler(strZ2, strZ2, id, com.github.catvod.spider.merge.t0.a.g(obj2, arrayList2, obj2, arrayList2), VideoStream.RESOLUTION_UNKNOWN);
        Object[] objArr = {ChannelTabs.ALBUMS};
        ArrayList arrayList3 = new ArrayList(1);
        Object obj3 = objArr[0];
        ListLinkHandler listLinkHandler3 = new ListLinkHandler(strZ3, strZ3, id, com.github.catvod.spider.merge.t0.a.g(obj3, arrayList3, obj3, arrayList3), VideoStream.RESOLUTION_UNKNOWN);
        Object[] objArr2 = {ChannelTabs.LIKES};
        ArrayList arrayList4 = new ArrayList(1);
        Object obj4 = objArr2[0];
        Object[] objArr3 = {listLinkHandler, listLinkHandler2, listLinkHandler3, new ListLinkHandler(strZ4, strZ4, id, com.github.catvod.spider.merge.t0.a.g(obj4, arrayList4, obj4, arrayList4), VideoStream.RESOLUTION_UNKNOWN)};
        ArrayList arrayList5 = new ArrayList(4);
        for (int i = 0; i < 4; i++) {
            Object obj5 = objArr3[i];
            Objects.requireNonNull(obj5);
            arrayList5.add(obj5);
        }
        return DesugarCollections.unmodifiableList(arrayList5);
    }

    @Override // org.schabi.newpipe.extractor.channel.ChannelExtractor
    public boolean isVerified() {
        return this.user.getBoolean("verified");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ParsingException {
        String id = getLinkHandler().getId();
        this.userId = id;
        try {
            this.user = JsonParser.object().from(downloader.get(com.github.catvod.spider.merge.b.b.p(USERS_ENDPOINT, id, "?client_id=", SoundcloudParsingHelper.clientId()), getExtractorLocalization()).responseBody());
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
        }
    }
}
