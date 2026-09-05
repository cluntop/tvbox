package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.n1.g;
import com.github.catvod.spider.merge.q1.w;
import com.github.catvod.spider.merge.s0.a;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.channel.tabs.ChannelTabs;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.peertube.linkHandler.PeertubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.stream.DeliveryMethod;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.Frameset;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemExtractor;
import org.schabi.newpipe.extractor.stream.StreamInfoItemsCollector;
import org.schabi.newpipe.extractor.stream.StreamSegment;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.SubtitlesStream;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.Utils;
import org.schabi.newpipe.extractor.utils.c;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeStreamExtractor extends StreamExtractor {
    private static final String ACCOUNT_HOST = "account.host";
    private static final String ACCOUNT_NAME = "account.name";
    private static final String FILES = "files";
    private static final String FILE_DOWNLOAD_URL = "fileDownloadUrl";
    private static final String FILE_URL = "fileUrl";
    private static final String PLAYLIST_URL = "playlistUrl";
    private static final String RESOLUTION_ID = "resolution.id";
    private static final String STREAMING_PLAYLISTS = "streamingPlaylists";
    private final List<AudioStream> audioStreams;
    private final String baseUrl;
    private JsonObject json;
    private final List<SubtitlesStream> subtitles;
    private ParsingException subtitlesException;
    private final List<VideoStream> videoStreams;

    public PeertubeStreamExtractor(StreamingService streamingService, LinkHandler linkHandler) {
        super(streamingService, linkHandler);
        this.subtitles = new ArrayList();
        this.audioStreams = new ArrayList();
        this.videoStreams = new ArrayList();
        this.subtitlesException = null;
        this.baseUrl = getBaseUrl();
    }

    private void addNewAudioStream(JsonObject jsonObject, boolean z, String str, String str2, String str3, String str4) {
        String strSubstring = str3.substring(str3.lastIndexOf(".") + 1);
        MediaFormat fromSuffix = MediaFormat.getFromSuffix(strSubstring);
        String strO = b.o(str, "-", strSubstring);
        this.audioStreams.add(new AudioStream.Builder().setId(strO + "-" + str2 + "-" + DeliveryMethod.PROGRESSIVE_HTTP).setContent(str3, true).setMediaFormat(fromSuffix).setAverageBitrate(-1).build());
        if (!Utils.isNullOrEmpty(str4)) {
            String hlsPlaylistUrlFromFragmentedFileUrl = z ? getHlsPlaylistUrlFromFragmentedFileUrl(jsonObject, str2, strSubstring, str3) : getHlsPlaylistUrlFromMasterPlaylist(jsonObject, str4);
            AudioStream.Builder builder = new AudioStream.Builder();
            DeliveryMethod deliveryMethod = DeliveryMethod.HLS;
            AudioStream audioStreamBuild = builder.setId(strO + "-" + deliveryMethod).setContent(hlsPlaylistUrlFromFragmentedFileUrl, true).setDeliveryMethod(deliveryMethod).setMediaFormat(fromSuffix).setAverageBitrate(-1).setManifestUrl(str4).build();
            if (!Stream.containSimilarStream(audioStreamBuild, this.audioStreams)) {
                this.audioStreams.add(audioStreamBuild);
            }
        }
        String string = JsonUtils.getString(jsonObject, "torrentUrl");
        if (Utils.isNullOrEmpty(string)) {
            return;
        }
        List<AudioStream> list = this.audioStreams;
        AudioStream.Builder builder2 = new AudioStream.Builder();
        DeliveryMethod deliveryMethod2 = DeliveryMethod.TORRENT;
        list.add(builder2.setId(strO + "-" + str2 + "-" + deliveryMethod2).setContent(string, true).setDeliveryMethod(deliveryMethod2).setMediaFormat(fromSuffix).setAverageBitrate(-1).build());
    }

    private void addNewVideoStream(JsonObject jsonObject, boolean z, String str, String str2, String str3, String str4) {
        String strSubstring = str3.substring(str3.lastIndexOf(".") + 1);
        MediaFormat fromSuffix = MediaFormat.getFromSuffix(strSubstring);
        String strO = b.o(str, "-", strSubstring);
        boolean z2 = jsonObject.has("hasAudio") && !jsonObject.getBoolean("hasAudio");
        this.videoStreams.add(new VideoStream.Builder().setId(strO + "-" + str2 + "-" + DeliveryMethod.PROGRESSIVE_HTTP).setContent(str3, true).setIsVideoOnly(z2).setResolution(str).setMediaFormat(fromSuffix).build());
        if (!Utils.isNullOrEmpty(str4)) {
            String hlsPlaylistUrlFromFragmentedFileUrl = z ? getHlsPlaylistUrlFromFragmentedFileUrl(jsonObject, str2, strSubstring, str3) : getHlsPlaylistUrlFromMasterPlaylist(jsonObject, str4);
            VideoStream.Builder builder = new VideoStream.Builder();
            DeliveryMethod deliveryMethod = DeliveryMethod.HLS;
            VideoStream videoStreamBuild = builder.setId(strO + "-" + deliveryMethod).setContent(hlsPlaylistUrlFromFragmentedFileUrl, true).setIsVideoOnly(z2).setDeliveryMethod(deliveryMethod).setResolution(str).setMediaFormat(fromSuffix).setManifestUrl(str4).build();
            if (!Stream.containSimilarStream(videoStreamBuild, this.videoStreams)) {
                this.videoStreams.add(videoStreamBuild);
            }
        }
        String string = JsonUtils.getString(jsonObject, "torrentUrl");
        if (Utils.isNullOrEmpty(string)) {
            return;
        }
        List<VideoStream> list = this.videoStreams;
        VideoStream.Builder builder2 = new VideoStream.Builder();
        DeliveryMethod deliveryMethod2 = DeliveryMethod.TORRENT;
        list.add(builder2.setId(strO + "-" + str2 + "-" + deliveryMethod2).setContent(string, true).setIsVideoOnly(z2).setDeliveryMethod(deliveryMethod2).setResolution(str).setMediaFormat(fromSuffix).build());
    }

    private void collectStreamsFrom(StreamInfoItemsCollector streamInfoItemsCollector, JsonObject jsonObject) throws ParsingException {
        try {
            Iterator<Object> it = ((JsonArray) JsonUtils.getValue(jsonObject, "data")).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof JsonObject) {
                    PeertubeStreamInfoItemExtractor peertubeStreamInfoItemExtractor = new PeertubeStreamInfoItemExtractor((JsonObject) next, this.baseUrl);
                    if (!peertubeStreamInfoItemExtractor.getUrl().equals(getUrl())) {
                        streamInfoItemsCollector.commit((StreamInfoItemExtractor) peertubeStreamInfoItemExtractor);
                    }
                }
            }
        } catch (Exception e) {
            a.m("Could not extract related videos", e);
        }
    }

    private void extractLiveVideoStreams() throws ParsingException {
        try {
            com.github.catvod.spider.jdollar.util.stream.Stream<R> map = this.json.getArray(STREAMING_PLAYLISTS).streamAsJsonObjects().map(new g(27));
            List<VideoStream> list = this.videoStreams;
            Objects.requireNonNull(list);
            map.forEachOrdered(new w(3, list));
        } catch (Exception e) {
            a.m("Could not get video streams", e);
        }
    }

    private JsonObject fetchSubApiContent(String str) throws ParsingException {
        Response response = getDownloader().get(this.baseUrl + PeertubeStreamLinkHandlerFactory.VIDEO_API_ENDPOINT + getId() + "/" + str);
        if (response == null) {
            c.a("Could not get segments from API.");
            return null;
        }
        if (response.responseCode() == 400) {
            return null;
        }
        if (response.responseCode() != 200) {
            throw new ParsingException(b.j(response.responseCode(), "Could not get segments from API. Response code: "));
        }
        try {
            return JsonParser.object().from(response.responseBody());
        } catch (JsonParserException e) {
            a.m("Could not parse json data for segments", e);
            return null;
        }
    }

    private String getHlsPlaylistUrlFromFragmentedFileUrl(JsonObject jsonObject, String str, String str2, String str3) {
        if (FILE_DOWNLOAD_URL.equals(str)) {
            str3 = JsonUtils.getString(jsonObject, FILE_URL);
        }
        return str3.replace("-fragmented." + str2, ".m3u8");
    }

    private String getHlsPlaylistUrlFromMasterPlaylist(JsonObject jsonObject, String str) {
        return str.replace("master", JsonUtils.getNumber(jsonObject, RESOLUTION_ID).toString());
    }

    private String getRelatedItemsUrl(List<String> list) {
        String strZ = b.z(this.baseUrl, PeertubeSearchQueryHandlerFactory.SEARCH_ENDPOINT_VIDEOS);
        StringBuilder sb = new StringBuilder("start=0&count=8&sort=-createdAt");
        for (String str : list) {
            sb.append("&tagsOneOf=");
            sb.append(Utils.encodeUrlUtf8(str));
        }
        return strZ + "?" + ((Object) sb);
    }

    private void getStreams() throws ParsingException {
        getStreamsFromArray(this.json.getArray(FILES), VideoStream.RESOLUTION_UNKNOWN);
        try {
            for (JsonObject jsonObject : this.json.getArray(STREAMING_PLAYLISTS).streamAsJsonObjects()) {
                getStreamsFromArray(jsonObject.getArray(FILES), jsonObject.getString(PLAYLIST_URL));
            }
        } catch (Exception e) {
            a.m("Could not get streams", e);
        }
    }

    private void getStreamsFromApi(StreamInfoItemsCollector streamInfoItemsCollector, String str) throws ParsingException {
        JsonObject jsonObjectFrom;
        Response response = getDownloader().get(str);
        if (response == null || Utils.isBlank(response.responseBody())) {
            jsonObjectFrom = null;
        } else {
            try {
                jsonObjectFrom = JsonParser.object().from(response.responseBody());
            } catch (JsonParserException e) {
                a.m("Could not parse json data for related videos", e);
                return;
            }
        }
        if (jsonObjectFrom != null) {
            collectStreamsFrom(streamInfoItemsCollector, jsonObjectFrom);
        }
    }

    private void getStreamsFromArray(JsonArray jsonArray, String str) throws ParsingException {
        String str2;
        try {
            boolean z = !Utils.isNullOrEmpty(str) && str.endsWith("-master.m3u8");
            for (JsonObject jsonObject : jsonArray.streamAsJsonObjects()) {
                String string = JsonUtils.getString(jsonObject, jsonObject.has(FILE_URL) ? FILE_URL : FILE_DOWNLOAD_URL);
                if (Utils.isNullOrEmpty(string)) {
                    return;
                }
                String string2 = JsonUtils.getString(jsonObject, "resolution.label");
                String str3 = jsonObject.has(FILE_URL) ? FILE_URL : FILE_DOWNLOAD_URL;
                if (string2.toLowerCase().contains("audio")) {
                    str2 = str;
                    addNewAudioStream(jsonObject, z, string2, str3, string, str2);
                } else {
                    str2 = str;
                    addNewVideoStream(jsonObject, z, string2, str3, string, str2);
                }
                str = str2;
            }
        } catch (Exception e) {
            a.m("Could not get streams from array", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ VideoStream lambda$extractLiveVideoStreams$1(JsonObject jsonObject) {
        return new VideoStream.Builder().setId(String.valueOf(jsonObject.getInt("id", -1))).setContent(jsonObject.getString(PLAYLIST_URL, VideoStream.RESOLUTION_UNKNOWN), true).setIsVideoOnly(false).setResolution(VideoStream.RESOLUTION_UNKNOWN).setMediaFormat(MediaFormat.MPEG_4).setDeliveryMethod(DeliveryMethod.HLS).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSubtitles$0(MediaFormat mediaFormat, SubtitlesStream subtitlesStream) {
        return subtitlesStream.getFormat() == mediaFormat;
    }

    private void loadSubtitles() {
        if (this.subtitles.isEmpty()) {
            try {
                Iterator<Object> it = JsonUtils.getArray(JsonParser.object().from(getDownloader().get(this.baseUrl + PeertubeStreamLinkHandlerFactory.VIDEO_API_ENDPOINT + getId() + "/captions").responseBody()), "data").iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof JsonObject) {
                        JsonObject jsonObject = (JsonObject) next;
                        String str = this.baseUrl + JsonUtils.getString(jsonObject, "captionPath");
                        String string = JsonUtils.getString(jsonObject, "language.id");
                        MediaFormat fromSuffix = MediaFormat.getFromSuffix(str.substring(str.lastIndexOf(".") + 1));
                        if (fromSuffix != null && !Utils.isNullOrEmpty(string)) {
                            this.subtitles.add(new SubtitlesStream.Builder().setContent(str, true).setMediaFormat(fromSuffix).setLanguageCode(string).setAutoGenerated(false).build());
                        }
                    }
                }
            } catch (Exception e) {
                this.subtitlesException = new ParsingException("Could not get subtitles", e);
            }
        }
    }

    private void setInitialData(String str) throws ExtractionException {
        try {
            JsonObject jsonObjectFrom = JsonParser.object().from(str);
            this.json = jsonObjectFrom;
            if (jsonObjectFrom == null) {
                throw new ExtractionException("Could not extract PeerTube stream data");
            }
            PeertubeParsingHelper.validate(jsonObjectFrom);
        } catch (JsonParserException e) {
            throw new ExtractionException("Could not extract PeerTube stream data", e);
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public int getAgeLimit() {
        return JsonUtils.getBoolean(this.json, "nsfw").booleanValue() ? 18 : 0;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<AudioStream> getAudioStreams() throws ParsingException {
        assertPageFetched();
        if (this.audioStreams.isEmpty() && this.videoStreams.isEmpty() && getStreamType() == StreamType.VIDEO_STREAM) {
            getStreams();
        }
        return this.audioStreams;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getCategory() {
        return JsonUtils.getString(this.json, "category.label");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public Description getDescription() {
        try {
            String string = JsonUtils.getString(this.json, "description");
            if (string.length() == 250 && string.substring(247).equals("...")) {
                Downloader downloader = NewPipe.getDownloader();
                try {
                    string = JsonUtils.getString(JsonParser.object().from(downloader.get(this.baseUrl + PeertubeStreamLinkHandlerFactory.VIDEO_API_ENDPOINT + getId() + "/description").responseBody()), "description");
                } catch (JsonParserException | IOException | ReCaptchaException unused) {
                }
            }
            return new Description(string, 2);
        } catch (ParsingException unused2) {
            return Description.EMPTY_DESCRIPTION;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getDislikeCount() {
        return this.json.getLong("dislikes");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Frameset> getFrames() throws ExtractionException {
        ArrayList arrayList = new ArrayList();
        try {
            JsonObject jsonObjectFetchSubApiContent = fetchSubApiContent("storyboards");
            if (jsonObjectFetchSubApiContent != null && jsonObjectFetchSubApiContent.has("storyboards")) {
                Iterator<Object> it = jsonObjectFetchSubApiContent.getArray("storyboards").iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof JsonObject) {
                        JsonObject jsonObject = (JsonObject) next;
                        String string = jsonObject.getString("storyboardPath");
                        int i = jsonObject.getInt("spriteWidth");
                        int i2 = jsonObject.getInt("spriteHeight");
                        int i3 = jsonObject.getInt("totalWidth") / i;
                        int i4 = jsonObject.getInt("totalHeight") / i2;
                        int i5 = jsonObject.getInt("spriteDuration") * 1000;
                        Object[] objArr = {b.z(this.baseUrl, string)};
                        ArrayList arrayList2 = new ArrayList(1);
                        Object obj = objArr[0];
                        arrayList.add(new Frameset(com.github.catvod.spider.merge.t0.a.g(obj, arrayList2, obj, arrayList2), i, i2, i3 * i4, i5, i3, i4));
                    }
                }
            }
            return arrayList;
        } catch (IOException | ReCaptchaException e) {
            throw new ExtractionException("Could not get frames", e);
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getHlsUrl() {
        assertPageFetched();
        return (getStreamType() != StreamType.VIDEO_STREAM || Utils.isNullOrEmpty(this.json.getObject(FILES))) ? this.json.getArray(STREAMING_PLAYLISTS).getObject(0).getString(PLAYLIST_URL, VideoStream.RESOLUTION_UNKNOWN) : this.json.getObject(FILES).getString(PLAYLIST_URL, VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getHost() {
        return JsonUtils.getString(this.json, ACCOUNT_HOST);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public Locale getLanguageInfo() {
        try {
            return new Locale(JsonUtils.getString(this.json, "language.id"));
        } catch (ParsingException unused) {
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getLength() {
        return this.json.getLong("duration");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getLicence() {
        return JsonUtils.getString(this.json, "licence.label");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getLikeCount() {
        return this.json.getLong(ChannelTabs.LIKES);
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return JsonUtils.getString(this.json, "name");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public StreamExtractor.Privacy getPrivacy() {
        int i = this.json.getObject("privacy").getInt("id");
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? StreamExtractor.Privacy.OTHER : StreamExtractor.Privacy.INTERNAL : StreamExtractor.Privacy.PRIVATE : StreamExtractor.Privacy.UNLISTED : StreamExtractor.Privacy.PUBLIC;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public StreamInfoItemsCollector getRelatedItems() throws ParsingException {
        String relatedItemsUrl;
        List<String> tags = getTags();
        if (tags.isEmpty()) {
            relatedItemsUrl = this.baseUrl + "/api/v1/accounts/" + JsonUtils.getString(this.json, ACCOUNT_NAME) + "@" + JsonUtils.getString(this.json, ACCOUNT_HOST) + "/videos?start=0&count=8";
        } else {
            relatedItemsUrl = getRelatedItemsUrl(tags);
        }
        if (Utils.isBlank(relatedItemsUrl)) {
            return null;
        }
        StreamInfoItemsCollector streamInfoItemsCollector = new StreamInfoItemsCollector(getServiceId());
        getStreamsFromApi(streamInfoItemsCollector, relatedItemsUrl);
        return streamInfoItemsCollector;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<StreamSegment> getStreamSegments() throws ParsingException {
        ArrayList arrayList = new ArrayList();
        try {
            JsonObject jsonObjectFetchSubApiContent = fetchSubApiContent("chapters");
            if (jsonObjectFetchSubApiContent != null && jsonObjectFetchSubApiContent.has("chapters")) {
                JsonArray array = jsonObjectFetchSubApiContent.getArray("chapters");
                for (int i = 0; i < array.size(); i++) {
                    JsonObject object = array.getObject(i);
                    arrayList.add(new StreamSegment(object.getString("title"), object.getInt("timecode")));
                }
            }
            return arrayList;
        } catch (IOException | ReCaptchaException e) {
            a.m("Could not get stream segments", e);
            return null;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public StreamType getStreamType() {
        return this.json.getBoolean("isLive") ? StreamType.LIVE_STREAM : StreamType.VIDEO_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getSubChannelAvatars() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(this.baseUrl, this.json.getObject("channel"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getSubChannelName() {
        return JsonUtils.getString(this.json, "channel.displayName");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getSubChannelUrl() {
        return JsonUtils.getString(this.json, "channel.url");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<SubtitlesStream> getSubtitles(MediaFormat mediaFormat) throws ParsingException {
        ParsingException parsingException = this.subtitlesException;
        if (parsingException == null) {
            return (List) Collection$EL.stream(this.subtitles).filter(new com.github.catvod.spider.merge.e0.a(2, mediaFormat)).collect(Collectors.toList());
        }
        throw parsingException;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<SubtitlesStream> getSubtitlesDefault() throws ParsingException {
        ParsingException parsingException = this.subtitlesException;
        if (parsingException == null) {
            return this.subtitles;
        }
        throw parsingException;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getSupportInfo() {
        try {
            return JsonUtils.getString(this.json, "support");
        } catch (ParsingException unused) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<String> getTags() {
        return JsonUtils.getStringListFromJsonArray(this.json.getArray("tags"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getTextualUploadDate() {
        return JsonUtils.getString(this.json, "publishedAt");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getThumbnails() {
        return PeertubeParsingHelper.getThumbnailsFromPlaylistOrVideoItem(this.baseUrl, this.json);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getTimeStamp() {
        long timestampSeconds = getTimestampSeconds("((#|&|\\?)start=\\d{0,3}h?\\d{0,3}m?\\d{1,3}s?)");
        if (timestampSeconds == -2) {
            return 0L;
        }
        return timestampSeconds;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public DateWrapper getUploadDate() {
        return DateWrapper.fromInstant(getTextualUploadDate());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getUploaderAvatars() {
        return PeertubeParsingHelper.getAvatarsFromOwnerAccountOrVideoChannelObject(this.baseUrl, this.json.getObject("account"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderName() {
        return JsonUtils.getString(this.json, "account.displayName");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderUrl() {
        return getService().getChannelLHFactory().fromId(b.p("accounts/", JsonUtils.getString(this.json, ACCOUNT_NAME), "@", JsonUtils.getString(this.json, ACCOUNT_HOST)), this.baseUrl).getUrl();
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoOnlyStreams() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoStreams() throws ParsingException {
        assertPageFetched();
        if (this.videoStreams.isEmpty()) {
            if (getStreamType() == StreamType.VIDEO_STREAM) {
                getStreams();
            } else {
                extractLiveVideoStreams();
            }
        }
        return this.videoStreams;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getViewCount() {
        return this.json.getLong("views");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        Response response = downloader.get(this.baseUrl + PeertubeStreamLinkHandlerFactory.VIDEO_API_ENDPOINT + getId());
        if (response == null) {
            throw new ExtractionException("Could not extract PeerTube channel data");
        }
        setInitialData(response.responseBody());
        loadSubtitles();
    }
}
