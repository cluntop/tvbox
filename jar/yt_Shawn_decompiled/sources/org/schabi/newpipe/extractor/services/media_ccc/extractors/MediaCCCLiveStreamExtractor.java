package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.o1.k;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.stream.DeliveryMethod;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCLiveStreamExtractor extends StreamExtractor {
    private static final String STREAMS = "streams";
    private static final String URL = "url";
    private static final String URLS = "urls";
    private JsonObject conference;
    private String group;
    private JsonObject room;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class MediaCCCLiveStreamMapperDTO {
        final JsonObject streamJsonObj;
        final String urlKey;
        final JsonObject urlValue;

        public MediaCCCLiveStreamMapperDTO(JsonObject jsonObject, String str, JsonObject jsonObject2) {
            this.streamJsonObj = jsonObject;
            this.urlKey = str;
            this.urlValue = jsonObject2;
        }
    }

    public MediaCCCLiveStreamExtractor(StreamingService streamingService, LinkHandler linkHandler) {
        super(streamingService, linkHandler);
        this.conference = null;
        this.group = VideoStream.RESOLUTION_UNKNOWN;
        this.room = null;
    }

    private String getManifestOfDeliveryMethodWanted(String str) {
        return (String) this.room.getArray(STREAMS).streamAsJsonObjects().map(new d(2)).filter(new org.schabi.newpipe.extractor.a(str, 4)).map(new org.schabi.newpipe.extractor.services.bandcamp.extractors.b(str, 1)).findFirst().orElse(VideoStream.RESOLUTION_UNKNOWN);
    }

    private <T extends Stream> List<T> getStreams(String str, Function<MediaCCCLiveStreamMapperDTO, T> function) {
        return (List) Collection$EL.stream(this.room.getArray(STREAMS)).filter(new c(2)).map(new d(3)).filter(new org.schabi.newpipe.extractor.a(str, 5)).flatMap(new d(4)).filter(new c(0)).map(function).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioStream lambda$getAudioStreams$3(MediaCCCLiveStreamMapperDTO mediaCCCLiveStreamMapperDTO) {
        AudioStream.Builder averageBitrate = new AudioStream.Builder().setId(mediaCCCLiveStreamMapperDTO.urlValue.getString("tech", Stream.ID_UNKNOWN)).setContent(mediaCCCLiveStreamMapperDTO.urlValue.getString(URL), true).setAverageBitrate(-1);
        return "hls".equals(mediaCCCLiveStreamMapperDTO.urlKey) ? averageBitrate.setDeliveryMethod(DeliveryMethod.HLS).build() : averageBitrate.setMediaFormat(MediaFormat.getFromSuffix(mediaCCCLiveStreamMapperDTO.urlKey)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JsonObject lambda$getManifestOfDeliveryMethodWanted$0(JsonObject jsonObject) {
        return jsonObject.getObject(URLS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getManifestOfDeliveryMethodWanted$1(String str, JsonObject jsonObject) {
        return jsonObject.has(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getManifestOfDeliveryMethodWanted$2(String str, JsonObject jsonObject) {
        return jsonObject.getObject(str).getString(URL, VideoStream.RESOLUTION_UNKNOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getStreams$5(String str, JsonObject jsonObject) {
        return str.equals(jsonObject.getString("type"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getStreams$6(Map.Entry entry) {
        return entry.getValue() instanceof JsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MediaCCCLiveStreamMapperDTO lambda$getStreams$7(JsonObject jsonObject, Map.Entry entry) {
        return new MediaCCCLiveStreamMapperDTO(jsonObject, (String) entry.getKey(), (JsonObject) entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.github.catvod.spider.jdollar.util.stream.Stream lambda$getStreams$8(JsonObject jsonObject) {
        return Collection$EL.stream(jsonObject.getObject(URLS).entrySet()).filter(new c(1)).map(new k(jsonObject, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getStreams$9(MediaCCCLiveStreamMapperDTO mediaCCCLiveStreamMapperDTO) {
        return !"dash".equals(mediaCCCLiveStreamMapperDTO.urlKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ VideoStream lambda$getVideoStreams$4(MediaCCCLiveStreamMapperDTO mediaCCCLiveStreamMapperDTO) {
        JsonArray array = mediaCCCLiveStreamMapperDTO.streamJsonObj.getArray("videoSize");
        VideoStream.Builder resolution = new VideoStream.Builder().setId(mediaCCCLiveStreamMapperDTO.urlValue.getString("tech", Stream.ID_UNKNOWN)).setContent(mediaCCCLiveStreamMapperDTO.urlValue.getString(URL), true).setIsVideoOnly(false).setResolution(array.getInt(0) + "x" + array.getInt(1));
        return "hls".equals(mediaCCCLiveStreamMapperDTO.urlKey) ? resolution.setDeliveryMethod(DeliveryMethod.HLS).build() : resolution.setMediaFormat(MediaFormat.getFromSuffix(mediaCCCLiveStreamMapperDTO.urlKey)).build();
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<AudioStream> getAudioStreams() {
        return getStreams("audio", new d(0));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getCategory() {
        return this.group;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getDashMpdUrl() {
        return getManifestOfDeliveryMethodWanted("dash");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public Description getDescription() {
        return new Description(com.github.catvod.spider.merge.b.b.o(this.conference.getString("description"), " - ", this.group), 3);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getHlsUrl() {
        return getManifestOfDeliveryMethodWanted("hls");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.room.getString("display");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public StreamType getStreamType() {
        return StreamType.LIVE_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getThumbnails() {
        return MediaCCCParsingHelper.getThumbnailsFromLiveStreamItem(this.room);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderName() {
        return this.conference.getString("conference");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderUrl() {
        return com.github.catvod.spider.merge.b.b.n("https://streaming.media.ccc.de/", this.conference.getString("slug"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoOnlyStreams() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoStreams() {
        return getStreams("video", new d(1));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getViewCount() {
        return -1L;
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        JsonArray liveStreams = MediaCCCParsingHelper.getLiveStreams(downloader, getExtractorLocalization());
        for (int i = 0; i < liveStreams.size(); i++) {
            JsonObject object = liveStreams.getObject(i);
            JsonArray array = object.getArray("groups");
            for (int i2 = 0; i2 < array.size(); i2++) {
                String string = array.getObject(i2).getString("group");
                JsonArray array2 = array.getObject(i2).getArray("rooms");
                for (int i3 = 0; i3 < array2.size(); i3++) {
                    JsonObject object2 = array2.getObject(i3);
                    if (getId().equals(object.getString("mandator") + "/" + object2.getString("slug"))) {
                        this.conference = object;
                        this.group = string;
                        this.room = object2;
                        return;
                    }
                }
            }
        }
        throw new ExtractionException(com.github.catvod.spider.merge.b.b.A("Could not find room matching id: '", getId(), "'"));
    }
}
