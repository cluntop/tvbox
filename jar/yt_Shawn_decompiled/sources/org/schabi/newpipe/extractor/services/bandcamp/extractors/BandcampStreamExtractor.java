package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.merge.n1.g;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.q1.i;
import com.github.catvod.spider.merge.q1.w;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParserException;
import java.util.Collections;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.PaidContentException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampStreamExtractor extends StreamExtractor {
    private JsonObject albumJson;
    private JsonObject current;
    private h document;

    public BandcampStreamExtractor(StreamingService streamingService, LinkHandler linkHandler) {
        super(streamingService, linkHandler);
    }

    public static JsonObject getAlbumInfoJson(String str) throws ParsingException {
        try {
            return JsonUtils.getJsonData(str, "data-tralbum");
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Faulty JSON; page likely does not contain album data", e);
            return null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            com.github.catvod.spider.merge.s0.a.m("JSON does not exist", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$getCategory$1(n nVar) {
        return Collection$EL.stream(nVar.N("tag"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getUploaderAvatars$0(n nVar) {
        return nVar.b("src");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<AudioStream> getAudioStreams() {
        return Collections.singletonList(new AudioStream.Builder().setId("mp3-128").setContent(this.albumJson.getArray("trackinfo").getObject(0).getObject("file").getString("mp3-128"), true).setMediaFormat(MediaFormat.MP3).setAverageBitrate(128).build());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getCategory() {
        return (String) Collection$EL.stream(this.document.N("tralbum-tags")).flatMap(new g(24)).map(new g(5)).findFirst().orElse(VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public Description getDescription() {
        return new Description(Utils.nonEmptyAndNullJoin("\n\n", this.current.getString("about"), this.current.getString("lyrics"), this.current.getString("credits")), 3);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getLength() {
        return (long) this.albumJson.getArray("trackinfo").getObject(0).getDouble("duration");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getLicence() {
        switch (this.current.getInt("license_type")) {
            case 1:
                return "All rights reserved ©";
            case 2:
                return "CC BY-NC-ND 3.0";
            case 3:
                return "CC BY-NC-SA 3.0";
            case 4:
                return "CC BY-NC 3.0";
            case 5:
                return "CC BY-ND 3.0";
            case 6:
                return "CC BY 3.0";
            case 7:
            default:
                return "Unknown";
            case 8:
                return "CC BY-SA 3.0";
        }
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.current.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public PlaylistInfoItemsCollector getRelatedItems() {
        PlaylistInfoItemsCollector playlistInfoItemsCollector = new PlaylistInfoItemsCollector(getServiceId());
        Collection$EL.stream(this.document.N("recommended-album")).map(new g(25)).forEach(new w(1, playlistInfoItemsCollector));
        return playlistInfoItemsCollector;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public StreamType getStreamType() {
        return StreamType.AUDIO_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<String> getTags() {
        h hVar = this.document;
        hVar.getClass();
        return (List) Collection$EL.stream(c2.k(new i("itemprop", "keywords", 0), hVar)).map(new g(5)).collect(Collectors.toList());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getTextualUploadDate() {
        return this.current.getString("publish_date");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getThumbnails() {
        return this.albumJson.isNull("art_id") ? Collections.EMPTY_LIST : BandcampExtractorHelper.getImagesFromImageId(this.albumJson.getLong("art_id"), true);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public DateWrapper getUploadDate() {
        return BandcampExtractorHelper.parseDate(getTextualUploadDate());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getUploaderAvatars() {
        return BandcampExtractorHelper.getImagesFromImageUrl((String) Collection$EL.stream(this.document.N("band-photo")).map(new g(23)).findFirst().orElse(VideoStream.RESOLUTION_UNKNOWN));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderName() {
        return this.albumJson.getString("artist");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderUrl() {
        return com.github.catvod.spider.merge.b.b.A(Utils.HTTPS, getUrl().split("/")[2], "/");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getUrl() {
        return Utils.replaceHttpWithHttps(this.albumJson.getString("url"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoOnlyStreams() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoStreams() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        String strResponseBody = downloader.get(getLinkHandler().getUrl()).responseBody();
        this.document = c2.T(strResponseBody);
        JsonObject albumInfoJson = getAlbumInfoJson(strResponseBody);
        this.albumJson = albumInfoJson;
        this.current = albumInfoJson.getObject("current");
        if (this.albumJson.getArray("trackinfo").size() > 1) {
            throw new ExtractionException("Page is actually an album, not a track");
        }
        if (this.albumJson.getArray("trackinfo").getObject(0).isNull("file")) {
            throw new PaidContentException("This track is not available without being purchased");
        }
    }
}
