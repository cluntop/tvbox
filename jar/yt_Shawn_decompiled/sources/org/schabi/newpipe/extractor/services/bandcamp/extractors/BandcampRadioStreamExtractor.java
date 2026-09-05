package org.schabi.newpipe.extractor.services.bandcamp.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.merge.n1.g;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ContentNotSupportedException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.playlist.PlaylistInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.StreamSegment;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class BandcampRadioStreamExtractor extends BandcampStreamExtractor {
    private static final String MP3_128 = "mp3-128";
    private static final String OPUS_LO = "opus-lo";
    private JsonObject showInfo;

    public BandcampRadioStreamExtractor(StreamingService streamingService, LinkHandler linkHandler) {
        super(streamingService, linkHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getUploaderName$0() {
        return new ParsingException("Could not get uploader name");
    }

    public static JsonObject query(int i) throws ParsingException {
        try {
            return JsonParser.object().from(NewPipe.getDownloader().get("https://bandcamp.com/api/bcweekly/1/get?id=" + i).responseBody());
        } catch (JsonParserException | IOException | ReCaptchaException e) {
            com.github.catvod.spider.merge.s0.a.m("could not get show data", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<AudioStream> getAudioStreams() {
        ArrayList arrayList = new ArrayList();
        JsonObject object = this.showInfo.getObject("audio_stream");
        if (object.has(MP3_128)) {
            arrayList.add(new AudioStream.Builder().setId(MP3_128).setContent(object.getString(MP3_128), true).setMediaFormat(MediaFormat.MP3).setAverageBitrate(128).build());
        }
        if (object.has(OPUS_LO)) {
            arrayList.add(new AudioStream.Builder().setId(OPUS_LO).setContent(object.getString(OPUS_LO), true).setMediaFormat(MediaFormat.OPUS).setAverageBitrate(100).build());
        }
        return arrayList;
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getCategory() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public Description getDescription() {
        return new Description(this.showInfo.getString("desc"), 3);
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getLength() {
        return this.showInfo.getLong("audio_duration");
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getLicence() {
        return VideoStream.RESOLUTION_UNKNOWN;
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.showInfo.getString("subtitle");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<StreamSegment> getStreamSegments() {
        JsonArray array = this.showInfo.getArray("tracks");
        ArrayList arrayList = new ArrayList(array.size());
        Iterator<Object> it = array.iterator();
        while (it.hasNext()) {
            JsonObject jsonObject = (JsonObject) it.next();
            StreamSegment streamSegment = new StreamSegment(jsonObject.getString("title"), jsonObject.getInt("timecode"));
            streamSegment.setPreviewUrl(BandcampExtractorHelper.getImageUrl(jsonObject.getLong("track_art_id"), true));
            streamSegment.setChannelName(jsonObject.getString("artist"));
            arrayList.add(streamSegment);
        }
        return arrayList;
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<String> getTags() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getTextualUploadDate() {
        return this.showInfo.getString("published_date");
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getThumbnails() {
        return BandcampExtractorHelper.getImagesFromImageId(this.showInfo.getLong("show_image_id"), false);
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getUploaderAvatars() {
        return Collections.singletonList(new Image("https://bandcamp.com/img/buttons/bandcamp-button-circle-whitecolor-512.png", 512, 512, Image.ResolutionLevel.MEDIUM));
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderName() {
        return (String) Collection$EL.stream(c2.T(this.showInfo.getString("image_caption")).O("a")).map(new g(5)).findFirst().orElseThrow(new com.github.catvod.spider.merge.n1.b(9));
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderUrl() throws ContentNotSupportedException {
        throw new ContentNotSupportedException("Fan pages are not supported");
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.Extractor
    public String getUrl() {
        return getLinkHandler().getUrl();
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) {
        this.showInfo = query(Integer.parseInt(getId()));
    }

    @Override // org.schabi.newpipe.extractor.services.bandcamp.extractors.BandcampStreamExtractor, org.schabi.newpipe.extractor.stream.StreamExtractor
    public PlaylistInfoItemsCollector getRelatedItems() {
        return null;
    }
}
