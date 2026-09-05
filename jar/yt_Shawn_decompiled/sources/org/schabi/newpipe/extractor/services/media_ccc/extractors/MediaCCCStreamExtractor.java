package org.schabi.newpipe.extractor.services.media_ccc.extractors;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.linkhandler.LinkHandler;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCConferenceLinkHandlerFactory;
import org.schabi.newpipe.extractor.services.media_ccc.linkHandler.MediaCCCStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.stream.Description;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.StreamType;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.JsonUtils;
import org.schabi.newpipe.extractor.utils.LocaleCompat;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class MediaCCCStreamExtractor extends StreamExtractor {
    private JsonObject conferenceData;
    private JsonObject data;

    public MediaCCCStreamExtractor(StreamingService streamingService, LinkHandler linkHandler) {
        super(streamingService, linkHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$getAudioStreams$0(String str) {
        return new ParsingException(com.github.catvod.spider.merge.b.b.n("Cannot convert this language to a locale: ", str));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<AudioStream> getAudioStreams() {
        JsonArray array = this.data.getArray("recordings");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            JsonObject object = array.getObject(i);
            String string = object.getString("mime_type");
            if (string.startsWith("audio")) {
                AudioStream.Builder averageBitrate = new AudioStream.Builder().setId(object.getString("filename", Stream.ID_UNKNOWN)).setContent(object.getString("recording_url"), true).setMediaFormat(string.endsWith("opus") ? MediaFormat.OPUS : string.endsWith("mpeg") ? MediaFormat.MP3 : string.endsWith("ogg") ? MediaFormat.OGG : null).setAverageBitrate(-1);
                String string2 = object.getString("language");
                if (string2 != null && !string2.contains("-")) {
                    averageBitrate.setAudioLocale(LocaleCompat.forLanguageTag(string2).orElseThrow(new com.github.catvod.spider.merge.n1.d(string2, 4)));
                }
                arrayList.add(averageBitrate.build());
            }
        }
        return arrayList;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public Description getDescription() {
        return new Description(this.data.getString("description"), 3);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public Locale getLanguageInfo() {
        return Localization.getLocaleFromThreeLetterCode(this.data.getString("original_language"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getLength() {
        return this.data.getInt("length");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getName() {
        return this.data.getString("title");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public String getOriginalUrl() {
        return this.data.getString("frontend_link");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public StreamType getStreamType() {
        return StreamType.VIDEO_STREAM;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<String> getTags() {
        return JsonUtils.getStringListFromJsonArray(this.data.getArray("tags"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getTextualUploadDate() {
        return this.data.getString("release_date");
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getThumbnails() {
        return MediaCCCParsingHelper.getThumbnailsFromStreamItem(this.data);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public DateWrapper getUploadDate() {
        return DateWrapper.fromOffsetDateTime(getTextualUploadDate());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<Image> getUploaderAvatars() {
        return MediaCCCParsingHelper.getImageListFromLogoImageUrl(this.conferenceData.getString("logo_url"));
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderName() {
        return this.data.getString("conference_url").replaceFirst("https://(api\\.)?media\\.ccc\\.de/public/conferences/", VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public String getUploaderUrl() {
        return com.github.catvod.spider.merge.b.b.n(MediaCCCConferenceLinkHandlerFactory.CONFERENCE_PATH, getUploaderName());
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoOnlyStreams() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public List<VideoStream> getVideoStreams() {
        JsonArray array = this.data.getArray("recordings");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            JsonObject object = array.getObject(i);
            String string = object.getString("mime_type");
            if (string.startsWith("video")) {
                arrayList.add(new VideoStream.Builder().setId(object.getString("filename", Stream.ID_UNKNOWN)).setContent(object.getString("recording_url"), true).setIsVideoOnly(false).setMediaFormat(string.endsWith("webm") ? MediaFormat.WEBM : string.endsWith("mp4") ? MediaFormat.MPEG_4 : null).setResolution(object.getInt("height") + "p").build());
            }
        }
        return arrayList;
    }

    @Override // org.schabi.newpipe.extractor.stream.StreamExtractor
    public long getViewCount() {
        return this.data.getInt("view_count");
    }

    @Override // org.schabi.newpipe.extractor.Extractor
    public void onFetchPage(Downloader downloader) throws ExtractionException {
        String strN = com.github.catvod.spider.merge.b.b.n(MediaCCCStreamLinkHandlerFactory.VIDEO_API_ENDPOINT, getId());
        try {
            this.data = JsonParser.object().from(downloader.get(strN).responseBody());
            this.conferenceData = JsonParser.object().from(downloader.get(this.data.getString("conference_url")).responseBody());
        } catch (JsonParserException e) {
            throw new ExtractionException("Could not parse json returned by URL: ".concat(strN), e);
        }
    }
}
