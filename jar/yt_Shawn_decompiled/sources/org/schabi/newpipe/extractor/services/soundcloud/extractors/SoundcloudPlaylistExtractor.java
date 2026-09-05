package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.github.catvod.spider.jdollar.util.Objects;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudParsingHelper;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudPlaylistExtractor extends PlaylistExtractor {
    private static final int STREAMS_PER_REQUESTED_PAGE = 15;
    private JsonObject playlist;
    private String playlistId;

    public SoundcloudPlaylistExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInitialPage$0(StreamInfoItemsCollector streamInfoItemsCollector, List list, JsonObject jsonObject) {
        if (jsonObject.has("title")) {
            streamInfoItemsCollector.commit((StreamInfoItemExtractor) new SoundcloudStreamInfoItemExtractor(jsonObject));
        } else {
            list.add(String.valueOf(jsonObject.getLong("id")));
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public Description getDescription() {
        String string = this.playlist.getString("description");
        return Utils.isNullOrEmpty(string) ? Description.EMPTY_DESCRIPTION : new Description(string, 3);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getId() {
        return this.playlistId;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        ArrayList arrayList = new ArrayList();
        this.playlist.getArray("tracks").streamAsJsonObjects().forEachOrdered(new a(0, streamInfoItemsCollector, arrayList));
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, new Page(arrayList));
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.playlist.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) throws NumberFormatException, ParsingException {
        List<String> listSubList;
        List<String> ids;
        if (page == null || Utils.isNullOrEmpty(page.getIds())) {
            com.github.catvod.spider.merge.s0.a.r("Page doesn't contain IDs");
            return null;
        }
        if (page.getIds().size() <= STREAMS_PER_REQUESTED_PAGE) {
            ids = page.getIds();
            listSubList = null;
        } else {
            List<String> listSubList2 = page.getIds().subList(0, STREAMS_PER_REQUESTED_PAGE);
            listSubList = page.getIds().subList(STREAMS_PER_REQUESTED_PAGE, page.getIds().size());
            ids = listSubList2;
        }
        String strClientId = SoundcloudParsingHelper.clientId();
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = ids.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) ",");
            }
        }
        String strP = com.github.catvod.spider.merge.b.b.p("https://api-v2.soundcloud.com/tracks?client_id=", strClientId, "&ids=", sb.toString());
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        try {
            JsonArray jsonArrayFrom = JsonParser.array().from(NewPipe.getDownloader().get(strP, getExtractorLocalization()).responseBody());
            HashMap map = new HashMap();
            Iterator<Object> it2 = jsonArrayFrom.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (next instanceof JsonObject) {
                    JsonObject jsonObject = (JsonObject) next;
                    map.put(Long.valueOf(jsonObject.getLong("id")), jsonObject);
                }
            }
            Iterator<String> it3 = ids.iterator();
            while (it3.hasNext()) {
                long j = Long.parseLong(it3.next());
                try {
                    JsonObject jsonObject2 = (JsonObject) map.get(Long.valueOf(j));
                    Objects.requireNonNull(jsonObject2, "no track with id " + j + " in response");
                    streamInfoItemsCollector.commit((StreamInfoItemExtractor) new SoundcloudStreamInfoItemExtractor(jsonObject2));
                } catch (NullPointerException e) {
                    throw new ParsingException("Could not parse json response", e);
                }
            }
            return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, new Page(listSubList));
        } catch (JsonParserException e2) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e2);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public long getStreamCount() {
        return this.playlist.getLong("track_count");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getThumbnails() {
        String string = this.playlist.getString("artwork_url");
        if (!Utils.isNullOrEmpty(string)) {
            return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(string);
        }
        try {
            Iterator it = getInitialPage().getItems().iterator();
            while (it.hasNext()) {
                List<Image> thumbnails = ((StreamInfoItem) it.next()).getThumbnails();
                if (!Utils.isNullOrEmpty(thumbnails)) {
                    return thumbnails;
                }
            }
        } catch (Exception unused) {
        }
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getUploaderAvatars() {
        return SoundcloudParsingHelper.getAllImagesFromArtworkOrAvatarUrl(SoundcloudParsingHelper.getAvatarUrl(this.playlist));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderName() {
        return SoundcloudParsingHelper.getUploaderName(this.playlist);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderUrl() {
        return SoundcloudParsingHelper.getUploaderUrl(this.playlist);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public boolean isUploaderVerified() {
        return this.playlist.getObject("user").getBoolean("verified");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ParsingException {
        String id = getLinkHandler().getId();
        this.playlistId = id;
        try {
            this.playlist = JsonParser.object().from(downloader.get("https://api-v2.soundcloud.com/playlists/" + id + "?client_id=" + SoundcloudParsingHelper.clientId() + "&representation=compact", getExtractorLocalization()).responseBody());
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse json response", e);
        }
    }
}
