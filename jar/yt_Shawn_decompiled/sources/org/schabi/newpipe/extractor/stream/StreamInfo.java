package org.schabi.newpipe.extractor.stream;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.Info;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.MetaInfo;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.exceptions.ContentNotAvailableException;
import org.schabi.newpipe.extractor.exceptions.ContentNotSupportedException;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.localization.DateWrapper;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.utils.ExtractorHelper;
import org.schabi.newpipe.extractor.utils.ExtractorLogger;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class StreamInfo extends Info {
    private static final String TAG = "StreamInfo";
    private int ageLimit;
    private List<AudioStream> audioStreams;
    private String category;
    private ContentAvailability contentAvailability;
    private String dashMpdUrl;
    private Description description;
    private long dislikeCount;
    private long duration;
    private String hlsUrl;
    private String host;
    private Locale language;
    private String licence;
    private long likeCount;
    private List<MetaInfo> metaInfo;
    private List<Frameset> previewFrames;
    private StreamExtractor.Privacy privacy;
    private List<InfoItem> relatedItems;
    private boolean shortFormContent;
    private long startPosition;
    private List<StreamSegment> streamSegments;
    private StreamType streamType;
    private List<Image> subChannelAvatars;
    private String subChannelName;
    private String subChannelUrl;
    private List<SubtitlesStream> subtitles;
    private String supportInfo;
    private List<String> tags;
    private String textualUploadDate;
    private List<Image> thumbnails;
    private DateWrapper uploadDate;
    private List<Image> uploaderAvatars;
    private String uploaderName;
    private long uploaderSubscriberCount;
    private String uploaderUrl;
    private boolean uploaderVerified;
    private List<VideoStream> videoOnlyStreams;
    private List<VideoStream> videoStreams;
    private long viewCount;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public class StreamExtractException extends ExtractionException {
        public StreamExtractException(String str) {
            super(str);
        }
    }

    public StreamInfo(int i, String str, String str2, StreamType streamType, String str3, String str4, int i2) {
        super(i, str3, str, str2, str4);
        List list = Collections.EMPTY_LIST;
        this.thumbnails = list;
        this.duration = -1L;
        this.viewCount = -1L;
        this.likeCount = -1L;
        this.dislikeCount = -1L;
        this.uploaderName = VideoStream.RESOLUTION_UNKNOWN;
        this.uploaderUrl = VideoStream.RESOLUTION_UNKNOWN;
        this.uploaderAvatars = list;
        this.uploaderVerified = false;
        this.uploaderSubscriberCount = -1L;
        this.subChannelName = VideoStream.RESOLUTION_UNKNOWN;
        this.subChannelUrl = VideoStream.RESOLUTION_UNKNOWN;
        this.subChannelAvatars = list;
        this.videoStreams = list;
        this.audioStreams = list;
        this.videoOnlyStreams = list;
        this.dashMpdUrl = VideoStream.RESOLUTION_UNKNOWN;
        this.hlsUrl = VideoStream.RESOLUTION_UNKNOWN;
        this.relatedItems = list;
        this.startPosition = 0L;
        this.subtitles = list;
        this.host = VideoStream.RESOLUTION_UNKNOWN;
        this.category = VideoStream.RESOLUTION_UNKNOWN;
        this.licence = VideoStream.RESOLUTION_UNKNOWN;
        this.supportInfo = VideoStream.RESOLUTION_UNKNOWN;
        this.language = null;
        this.tags = list;
        this.streamSegments = list;
        this.metaInfo = list;
        this.shortFormContent = false;
        this.contentAvailability = ContentAvailability.AVAILABLE;
        this.previewFrames = list;
        this.streamType = streamType;
        this.ageLimit = i2;
        ExtractorLogger.d(TAG, "Created {}", this);
    }

    private static StreamInfo extractImportantData(StreamExtractor streamExtractor) throws ExtractionException {
        String url = streamExtractor.getUrl();
        StreamType streamType = streamExtractor.getStreamType();
        String id = streamExtractor.getId();
        String name = streamExtractor.getName();
        int ageLimit = streamExtractor.getAgeLimit();
        if (streamType == StreamType.NONE || Utils.isNullOrEmpty(url) || Utils.isNullOrEmpty(id) || name == null || ageLimit == -1) {
            throw new ExtractionException("Some important stream information was not given.");
        }
        return new StreamInfo(streamExtractor.getServiceId(), url, streamExtractor.getOriginalUrl(), streamType, id, name, ageLimit);
    }

    private static void extractOptionalData(StreamInfo streamInfo, StreamExtractor streamExtractor) {
        try {
            streamInfo.setThumbnails(streamExtractor.getThumbnails());
        } catch (Exception e) {
            streamInfo.addError(e);
        }
        try {
            streamInfo.setDuration(streamExtractor.getLength());
        } catch (Exception e2) {
            streamInfo.addError(e2);
        }
        try {
            streamInfo.setUploaderName(streamExtractor.getUploaderName());
        } catch (Exception e3) {
            streamInfo.addError(e3);
        }
        try {
            streamInfo.setUploaderUrl(streamExtractor.getUploaderUrl());
        } catch (Exception e4) {
            streamInfo.addError(e4);
        }
        try {
            streamInfo.setUploaderAvatars(streamExtractor.getUploaderAvatars());
        } catch (Exception e5) {
            streamInfo.addError(e5);
        }
        try {
            streamInfo.setUploaderVerified(streamExtractor.isUploaderVerified());
        } catch (Exception e6) {
            streamInfo.addError(e6);
        }
        try {
            streamInfo.setUploaderSubscriberCount(streamExtractor.getUploaderSubscriberCount());
        } catch (Exception e7) {
            streamInfo.addError(e7);
        }
        try {
            streamInfo.setSubChannelName(streamExtractor.getSubChannelName());
        } catch (Exception e8) {
            streamInfo.addError(e8);
        }
        try {
            streamInfo.setSubChannelUrl(streamExtractor.getSubChannelUrl());
        } catch (Exception e9) {
            streamInfo.addError(e9);
        }
        try {
            streamInfo.setSubChannelAvatars(streamExtractor.getSubChannelAvatars());
        } catch (Exception e10) {
            streamInfo.addError(e10);
        }
        try {
            streamInfo.setDescription(streamExtractor.getDescription());
        } catch (Exception e11) {
            streamInfo.addError(e11);
        }
        try {
            streamInfo.setViewCount(streamExtractor.getViewCount());
        } catch (Exception e12) {
            streamInfo.addError(e12);
        }
        try {
            streamInfo.setTextualUploadDate(streamExtractor.getTextualUploadDate());
        } catch (Exception e13) {
            streamInfo.addError(e13);
        }
        try {
            streamInfo.setUploadDate(streamExtractor.getUploadDate());
        } catch (Exception e14) {
            streamInfo.addError(e14);
        }
        try {
            streamInfo.setStartPosition(streamExtractor.getTimeStamp());
        } catch (Exception e15) {
            streamInfo.addError(e15);
        }
        try {
            streamInfo.setLikeCount(streamExtractor.getLikeCount());
        } catch (Exception e16) {
            streamInfo.addError(e16);
        }
        try {
            streamInfo.setDislikeCount(streamExtractor.getDislikeCount());
        } catch (Exception e17) {
            streamInfo.addError(e17);
        }
        try {
            streamInfo.setSubtitles(streamExtractor.getSubtitlesDefault());
        } catch (Exception e18) {
            streamInfo.addError(e18);
        }
        try {
            streamInfo.setHost(streamExtractor.getHost());
        } catch (Exception e19) {
            streamInfo.addError(e19);
        }
        try {
            streamInfo.setPrivacy(streamExtractor.getPrivacy());
        } catch (Exception e20) {
            streamInfo.addError(e20);
        }
        try {
            streamInfo.setCategory(streamExtractor.getCategory());
        } catch (Exception e21) {
            streamInfo.addError(e21);
        }
        try {
            streamInfo.setLicence(streamExtractor.getLicence());
        } catch (Exception e22) {
            streamInfo.addError(e22);
        }
        try {
            streamInfo.setLanguageInfo(streamExtractor.getLanguageInfo());
        } catch (Exception e23) {
            streamInfo.addError(e23);
        }
        try {
            streamInfo.setTags(streamExtractor.getTags());
        } catch (Exception e24) {
            streamInfo.addError(e24);
        }
        try {
            streamInfo.setSupportInfo(streamExtractor.getSupportInfo());
        } catch (Exception e25) {
            streamInfo.addError(e25);
        }
        try {
            streamInfo.setStreamSegments(streamExtractor.getStreamSegments());
        } catch (Exception e26) {
            streamInfo.addError(e26);
        }
        try {
            streamInfo.setMetaInfo(streamExtractor.getMetaInfo());
        } catch (Exception e27) {
            streamInfo.addError(e27);
        }
        try {
            streamInfo.setPreviewFrames(streamExtractor.getFrames());
        } catch (Exception e28) {
            streamInfo.addError(e28);
        }
        try {
            streamInfo.setShortFormContent(streamExtractor.isShortFormContent());
        } catch (Exception e29) {
            streamInfo.addError(e29);
        }
        try {
            streamInfo.setContentAvailability(streamExtractor.getContentAvailability());
        } catch (Exception e30) {
            streamInfo.addError(e30);
        }
        streamInfo.setRelatedItems(ExtractorHelper.getRelatedItemsOrLogError(streamInfo, streamExtractor));
    }

    private static void extractStreams(StreamInfo streamInfo, StreamExtractor streamExtractor) throws ContentNotSupportedException, StreamExtractException {
        try {
            streamInfo.setDashMpdUrl(streamExtractor.getDashMpdUrl());
        } catch (Exception e) {
            streamInfo.addError(new ExtractionException("Couldn't get DASH manifest", e));
        }
        try {
            streamInfo.setHlsUrl(streamExtractor.getHlsUrl());
        } catch (Exception e2) {
            streamInfo.addError(new ExtractionException("Couldn't get HLS manifest", e2));
        }
        try {
            streamInfo.setAudioStreams(streamExtractor.getAudioStreams());
        } catch (ContentNotSupportedException e3) {
            throw e3;
        } catch (Exception e4) {
            streamInfo.addError(new ExtractionException("Couldn't get audio streams", e4));
        }
        try {
            streamInfo.setVideoStreams(streamExtractor.getVideoStreams());
        } catch (Exception e5) {
            streamInfo.addError(new ExtractionException("Couldn't get video streams", e5));
        }
        try {
            streamInfo.setVideoOnlyStreams(streamExtractor.getVideoOnlyStreams());
        } catch (Exception e6) {
            streamInfo.addError(new ExtractionException("Couldn't get video only streams", e6));
        }
        if (streamInfo.videoStreams.isEmpty() && streamInfo.audioStreams.isEmpty() && Utils.isNullOrEmpty(streamInfo.dashMpdUrl) && Utils.isNullOrEmpty(streamInfo.hlsUrl)) {
            throw new StreamExtractException("Could not get any stream. See error variable to get further details.");
        }
    }

    public static StreamInfo getInfo(StreamExtractor streamExtractor) throws ExtractionException {
        ExtractorLogger.d(TAG, "getInfo({extractor})", streamExtractor);
        streamExtractor.fetchPage();
        try {
            StreamInfo streamInfoExtractImportantData = extractImportantData(streamExtractor);
            extractStreams(streamInfoExtractImportantData, streamExtractor);
            extractOptionalData(streamInfoExtractImportantData, streamExtractor);
            return streamInfoExtractImportantData;
        } catch (ExtractionException e) {
            String errorMessage = streamExtractor.getErrorMessage();
            if (Utils.isNullOrEmpty(errorMessage)) {
                throw e;
            }
            throw new ContentNotAvailableException(errorMessage, e);
        }
    }

    public int getAgeLimit() {
        return this.ageLimit;
    }

    public List<AudioStream> getAudioStreams() {
        return this.audioStreams;
    }

    public String getCategory() {
        return this.category;
    }

    public ContentAvailability getContentAvailability() {
        return this.contentAvailability;
    }

    public String getDashMpdUrl() {
        return this.dashMpdUrl;
    }

    public Description getDescription() {
        return this.description;
    }

    public long getDislikeCount() {
        return this.dislikeCount;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getHlsUrl() {
        return this.hlsUrl;
    }

    public String getHost() {
        return this.host;
    }

    public Locale getLanguageInfo() {
        return this.language;
    }

    public String getLicence() {
        return this.licence;
    }

    public long getLikeCount() {
        return this.likeCount;
    }

    public List<MetaInfo> getMetaInfo() {
        return this.metaInfo;
    }

    public List<Frameset> getPreviewFrames() {
        return this.previewFrames;
    }

    public StreamExtractor.Privacy getPrivacy() {
        return this.privacy;
    }

    public List<InfoItem> getRelatedItems() {
        return this.relatedItems;
    }

    @Deprecated
    public List<InfoItem> getRelatedStreams() {
        return getRelatedItems();
    }

    public long getStartPosition() {
        return this.startPosition;
    }

    public List<StreamSegment> getStreamSegments() {
        return this.streamSegments;
    }

    public StreamType getStreamType() {
        return this.streamType;
    }

    public List<Image> getSubChannelAvatars() {
        return this.subChannelAvatars;
    }

    public String getSubChannelName() {
        return this.subChannelName;
    }

    public String getSubChannelUrl() {
        return this.subChannelUrl;
    }

    public List<SubtitlesStream> getSubtitles() {
        return this.subtitles;
    }

    public String getSupportInfo() {
        return this.supportInfo;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTextualUploadDate() {
        return this.textualUploadDate;
    }

    public List<Image> getThumbnails() {
        return this.thumbnails;
    }

    public DateWrapper getUploadDate() {
        return this.uploadDate;
    }

    public List<Image> getUploaderAvatars() {
        return this.uploaderAvatars;
    }

    public String getUploaderName() {
        return this.uploaderName;
    }

    public long getUploaderSubscriberCount() {
        return this.uploaderSubscriberCount;
    }

    public String getUploaderUrl() {
        return this.uploaderUrl;
    }

    public List<VideoStream> getVideoOnlyStreams() {
        return this.videoOnlyStreams;
    }

    public List<VideoStream> getVideoStreams() {
        return this.videoStreams;
    }

    public long getViewCount() {
        return this.viewCount;
    }

    public boolean isShortFormContent() {
        return this.shortFormContent;
    }

    public boolean isUploaderVerified() {
        return this.uploaderVerified;
    }

    public void setAgeLimit(int i) {
        this.ageLimit = i;
    }

    public void setAudioStreams(List<AudioStream> list) {
        this.audioStreams = list;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setContentAvailability(ContentAvailability contentAvailability) {
        this.contentAvailability = contentAvailability;
    }

    public void setDashMpdUrl(String str) {
        this.dashMpdUrl = str;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setDislikeCount(long j) {
        this.dislikeCount = j;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setHlsUrl(String str) {
        this.hlsUrl = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setLanguageInfo(Locale locale) {
        this.language = locale;
    }

    public void setLicence(String str) {
        this.licence = str;
    }

    public void setLikeCount(long j) {
        this.likeCount = j;
    }

    public void setMetaInfo(List<MetaInfo> list) {
        this.metaInfo = list;
    }

    public void setPreviewFrames(List<Frameset> list) {
        this.previewFrames = list;
    }

    public void setPrivacy(StreamExtractor.Privacy privacy) {
        this.privacy = privacy;
    }

    public void setRelatedItems(List<InfoItem> list) {
        this.relatedItems = list;
    }

    @Deprecated
    public void setRelatedStreams(List<InfoItem> list) {
        setRelatedItems(list);
    }

    public void setShortFormContent(boolean z) {
        this.shortFormContent = z;
    }

    public void setStartPosition(long j) {
        this.startPosition = j;
    }

    public void setStreamSegments(List<StreamSegment> list) {
        this.streamSegments = list;
    }

    public void setStreamType(StreamType streamType) {
        this.streamType = streamType;
    }

    public void setSubChannelAvatars(List<Image> list) {
        this.subChannelAvatars = list;
    }

    public void setSubChannelName(String str) {
        this.subChannelName = str;
    }

    public void setSubChannelUrl(String str) {
        this.subChannelUrl = str;
    }

    public void setSubtitles(List<SubtitlesStream> list) {
        this.subtitles = list;
    }

    public void setSupportInfo(String str) {
        this.supportInfo = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setTextualUploadDate(String str) {
        this.textualUploadDate = str;
    }

    public void setThumbnails(List<Image> list) {
        this.thumbnails = list;
    }

    public void setUploadDate(DateWrapper dateWrapper) {
        this.uploadDate = dateWrapper;
    }

    public void setUploaderAvatars(List<Image> list) {
        this.uploaderAvatars = list;
    }

    public void setUploaderName(String str) {
        this.uploaderName = str;
    }

    public void setUploaderSubscriberCount(long j) {
        this.uploaderSubscriberCount = j;
    }

    public void setUploaderUrl(String str) {
        this.uploaderUrl = str;
    }

    public void setUploaderVerified(boolean z) {
        this.uploaderVerified = z;
    }

    public void setVideoOnlyStreams(List<VideoStream> list) {
        this.videoOnlyStreams = list;
    }

    public void setVideoStreams(List<VideoStream> list) {
        this.videoStreams = list;
    }

    public void setViewCount(long j) {
        this.viewCount = j;
    }

    @Override // org.schabi.newpipe.extractor.Info
    public String toString() {
        return TAG + "[serviceId=" + getServiceId() + ", url='" + getUrl() + "', originalUrl='" + getOriginalUrl() + "', id='" + getId() + "', name='" + getName() + "', streamType=" + this.streamType + ", ageLimit=" + this.ageLimit + "]";
    }

    public static StreamInfo getInfo(StreamingService streamingService, String str) {
        ExtractorLogger.d(TAG, "getInfo({service},{url})", streamingService, str);
        return getInfo(streamingService.getStreamExtractor(str));
    }

    public static StreamInfo getInfo(String str) {
        ExtractorLogger.d(TAG, "getInfo({url})", str);
        return getInfo(NewPipe.getServiceByUrl(str), str);
    }
}
