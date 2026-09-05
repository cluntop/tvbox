package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.s0.a;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubePlaylistExtractor extends PlaylistExtractor {
    private JsonObject playlistInfo;

    public PeertubePlaylistExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public Description getDescription() {
        String string = this.playlistInfo.getString("description");
        return Utils.isNullOrEmpty(string) ? Description.EMPTY_DESCRIPTION : new Description(string, 3);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        return getPage(new Page(b.z(getUrl(), "/videos?start=0&count=12")));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.playlistInfo.getString("displayName");
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) throws ExtractionException {
        JsonObject jsonObjectFrom = null;
        if (page == null || Utils.isNullOrEmpty(page.getUrl())) {
            a.r("Page doesn't contain an URL");
            return null;
        }
        Response response = getDownloader().get(page.getUrl());
        if (response != null && !Utils.isBlank(response.responseBody())) {
            try {
                jsonObjectFrom = JsonParser.object().from(response.responseBody());
            } catch (Exception e) {
                a.m("Could not parse json data for playlist info", e);
                return null;
            }
        }
        if (jsonObjectFrom == null) {
            throw new ExtractionException("Unable to get PeerTube playlist info");
        }
        PeertubeParsingHelper.validate(jsonObjectFrom);
        long j = jsonObjectFrom.getLong("total");
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        PeertubeParsingHelper.collectItemsFrom(streamInfoItemsCollector, jsonObjectFrom, getBaseUrl());
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, PeertubeParsingHelper.getNextPage(page.getUrl(), j));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public long getStreamCount() {
        return this.playlistInfo.getLong("videosLength");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getSubChannelAvatars() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(getBaseUrl(), this.playlistInfo.getObject("videoChannel"));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getSubChannelName() {
        return this.playlistInfo.getObject("videoChannel").getString("displayName");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getSubChannelUrl() {
        return this.playlistInfo.getObject("videoChannel").getString("url");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getThumbnails() {
        return PeertubeParsingHelper.getThumbnailsFromPlaylistOrVideoItem(getBaseUrl(), this.playlistInfo);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getUploaderAvatars() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(getBaseUrl(), this.playlistInfo.getObject("ownerAccount"));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderName() {
        return this.playlistInfo.getObject("ownerAccount").getString("displayName");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderUrl() {
        return this.playlistInfo.getObject("ownerAccount").getString("url");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public boolean isUploaderVerified() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(downloader.get(getUrl()).responseBody());
            this.playlistInfo = jsonObjectFrom;
            PeertubeParsingHelper.validate(jsonObjectFrom);
        } catch (JsonParserException e) {
            throw new ExtractionException("Could not parse json", e);
        }
    }
}
