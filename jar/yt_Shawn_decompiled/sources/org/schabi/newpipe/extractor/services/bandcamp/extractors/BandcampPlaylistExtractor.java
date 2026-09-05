package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.n1.g;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.q1.e;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParserException;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.ListExtractor;
import org.schabi.newpipe.extractor.Page;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.PaidContentException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;
import org.schabi.newpipe.extractor.playlist.PlaylistExtractor;
import org.schabi.newpipe.extractor.services.bandcamp.extractors.streaminfoitem.BandcampPlaylistStreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;
import org.schabi.newpipe.extractor.utils.c;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampPlaylistExtractor extends PlaylistExtractor {
    private static final int MAXIMUM_INDIVIDUAL_COVER_ARTS = 10;
    private JsonObject albumJson;
    private h document;
    private String name;
    private JsonArray trackInfo;

    public BandcampPlaylistExtractor(StreamingService streamingService, ListLinkHandler listLinkHandler) {
        super(streamingService, listLinkHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getUploaderAvatars$0(n nVar) {
        return nVar.b("src");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public Description getDescription() throws ParsingException {
        h hVar = this.document;
        hVar.getClass();
        c2.P("trackInfo");
        int i = 8;
        boolean z = false;
        n nVar = (n) c2.X(new com.github.catvod.spider.merge.q1.h("trackInfo", i, z), hVar).findFirst().orElse(null);
        if (nVar == null) {
            c.a("Could not find trackInfo in document");
            return null;
        }
        e eVarN = nVar.N("tralbum-about");
        e eVarN2 = nVar.N("tralbum-credits");
        h hVar2 = this.document;
        hVar2.getClass();
        c2.P("license");
        n nVar2 = (n) c2.X(new com.github.catvod.spider.merge.q1.h("license", i, z), hVar2).findFirst().orElse(null);
        if (eVarN.isEmpty() && eVarN2.isEmpty() && nVar2 == null) {
            return Description.EMPTY_DESCRIPTION;
        }
        StringBuilder sb = new StringBuilder();
        if (!eVarN.isEmpty()) {
            n nVar3 = (n) eVarN.c();
            Objects.requireNonNull(nVar3);
            sb.append(nVar3.P());
        }
        if (!eVarN2.isEmpty()) {
            n nVar4 = (n) eVarN2.c();
            Objects.requireNonNull(nVar4);
            sb.append(nVar4.P());
        }
        if (nVar2 != null) {
            sb.append(nVar2.P());
        }
        return new Description(sb.toString(), 1);
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getInitialPage() {
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        for (int i = 0; i < this.trackInfo.size(); i++) {
            JsonObject object = this.trackInfo.getObject(i);
            if (this.trackInfo.size() < 10) {
                streamInfoItemsCollector.commit((StreamInfoItemExtractor) new BandcampPlaylistStreamInfoItemExtractor(object, getUploaderUrl(), getService()));
            } else {
                streamInfoItemsCollector.commit((StreamInfoItemExtractor) new BandcampPlaylistStreamInfoItemExtractor(object, getUploaderUrl(), getThumbnails()));
            }
        }
        return new ListExtractor.InfoItemsPage<>(streamInfoItemsCollector, null);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.name;
    }

    @Override // org.schabi.newpipe.extractor.ListExtractor
    public ListExtractor.InfoItemsPage<StreamInfoItem> getPage(Page page) {
        return null;
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public long getStreamCount() {
        return this.trackInfo.size();
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getThumbnails() {
        return this.albumJson.isNull("art_id") ? Collections.EMPTY_LIST : BandcampExtractorHelper.getImagesFromImageId(this.albumJson.getLong("art_id"), true);
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public List<Image> getUploaderAvatars() {
        return BandcampExtractorHelper.getImagesFromImageUrl((String) Collection$EL.stream(this.document.N("band-photo")).map(new g(20)).findFirst().orElse(VideoStream.RESOLUTION_UNKNOWN));
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderName() {
        return this.albumJson.getString("artist");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public String getUploaderUrl() {
        return com.github.catvod.spider.merge.b.b.A(Utils.HTTPS, getUrl().split("/")[2], "/");
    }

    @Override // org.schabi.newpipe.extractor.playlist.PlaylistExtractor
    public boolean isUploaderVerified() {
        return false;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ParsingException {
        String strResponseBody = downloader.get(getLinkHandler().getUrl()).responseBody();
        this.document = c2.T(strResponseBody);
        JsonObject albumInfoJson = BandcampStreamExtractor.getAlbumInfoJson(strResponseBody);
        this.albumJson = albumInfoJson;
        this.trackInfo = albumInfoJson.getArray("trackinfo");
        try {
            this.name = JsonUtils.getJsonData(strResponseBody, "data-embed").getString("album_title");
            if (this.trackInfo.isEmpty()) {
                throw new PaidContentException("Album needs to be purchased");
            }
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Faulty JSON; page likely does not contain album data", e);
        } catch (ArrayIndexOutOfBoundsException e2) {
            com.github.catvod.spider.merge.s0.a.m("JSON does not exist", e2);
        }
    }
}
