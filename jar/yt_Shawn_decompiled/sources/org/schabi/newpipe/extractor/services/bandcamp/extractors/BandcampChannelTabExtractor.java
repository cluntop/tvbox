package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.Iterator;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.MultiInfoItemsCollector;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabExtractor;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.streaminfoitem.BandcampDiscographStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampChannelTabExtractor extends ChannelTabExtractor {
    private JsonArray discography;
    private final String filter;

    public BandcampChannelTabExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
        String str = listLinkHandler.getContentFilters().get(0);
        str.getClass();
        if (str.equals(ChannelTabs.ALBUMS)) {
            this.filter = "album";
        } else if (str.equals("tracks")) {
            this.filter = "track";
        } else {
            com.github.catvod.spider.merge.s0.a.r("Unsupported channel tab: ".concat(str));
            throw null;
        }
    }

    public static BandcampChannelTabExtractor fromDiscography(StreamingService streamingService, ListLinkHandler listLinkHandler, JsonArray jsonArray) {
        BandcampChannelTabExtractor bandcampChannelTabExtractor = new BandcampChannelTabExtractor(streamingService, listLinkHandler);
        bandcampChannelTabExtractor.discography = jsonArray;
        return bandcampChannelTabExtractor;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getInitialPage() {
        MultiInfoItemsCollector multiInfoItemsCollector = new MultiInfoItemsCollector(getServiceId());
        Iterator<Object> it = this.discography.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JsonObject) {
                JsonObject jsonObject = (JsonObject) next;
                String string = jsonObject.getString("item_type", VideoStream.RESOLUTION_UNKNOWN);
                if (string.equals(this.filter)) {
                    if (string.equals("album")) {
                        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new BandcampAlbumInfoItemExtractor(jsonObject, getUrl()));
                    } else if (string.equals("track")) {
                        multiInfoItemsCollector.commit((MultiInfoItemsCollector) new BandcampDiscographStreamInfoItemExtractor(jsonObject, getUrl()));
                    }
                }
            }
        }
        return new ListExtractor.InfoItemsPage<>(multiInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<InfoItem> getPage(Page page) {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        if (this.discography == null) {
            this.discography = BandcampExtractorHelper.getArtistDetails(getId()).getArray("discography");
        }
    }
}
