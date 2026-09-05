package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.kiosk.KioskExtractor;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItem;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemsCollector;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampFeaturedExtractor extends KioskExtractor<PlaylistInfoItem> {
    public static final String FEATURED_API_URL = "https://bandcamp.com/api/mobile/24/bootstrap_data";
    public static final String KIOSK_FEATURED = "Featured";
    public static final String MORE_FEATURED_API_URL = "https://bandcamp.com/api/mobile/24/feed_older_logged_out";
    private JsonObject json;

    public BandcampFeaturedExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler, String str) {
        super(streamingService, listLinkHandler, str);
    }

    private ListExtractor.InfoItemsPage<PlaylistInfoItem> extractItems(JsonArray jsonArray) {
        PlaylistInfoItemsCollector playlistInfoItemsCollector = new PlaylistInfoItemsCollector(getServiceId());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject object = jsonArray.getObject(i);
            if (!object.isNull("album_title")) {
                playlistInfoItemsCollector.commit((PlaylistInfoItemsCollector) new BandcampPlaylistInfoItemFeaturedExtractor(object));
            }
        }
        return new ListExtractor.InfoItemsPage<>(playlistInfoItemsCollector, getNextPageFrom(jsonArray.getObject(jsonArray.size() - 1)));
    }

    private Page getNextPageFrom(JsonObject jsonObject) {
        long j = jsonObject.getLong("story_date");
        long j2 = jsonObject.getLong("ntid");
        return new Page("https://bandcamp.com/api/mobile/24/feed_older_logged_out?story_groups=featured:" + j + ":" + jsonObject.getString("story_type") + ":" + j2);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<PlaylistInfoItem> getInitialPage() {
        return extractItems(this.json.getObject("feed_content").getObject("stories").getArray("featured"));
    }

    @Override // org.schabi.newpipe.extractor.kiosk.KioskExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return KIOSK_FEATURED;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<PlaylistInfoItem> getPage(Page page) throws ParsingException {
        try {
            return extractItems(JsonParser.object().from(getDownloader().get(page.getUrl()).responseBody()).getObject("stories").getArray("featured"));
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse Bandcamp featured API response", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ParsingException {
        try {
            this.json = JsonParser.object().from(getDownloader().postWithContentTypeJson(FEATURED_API_URL, Collections.EMPTY_MAP, "{\"platform\":\"\",\"version\":0}".getBytes(StandardCharsets.UTF_8)).responseBody());
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse Bandcamp featured API response", e);
        }
    }
}
