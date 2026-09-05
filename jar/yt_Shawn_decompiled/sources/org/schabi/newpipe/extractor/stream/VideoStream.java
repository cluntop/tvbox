package org.schabi.newpipe.extractor.stream;

import com.github.catvod.spider.merge.s0.a;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class VideoStream extends Stream {
    public static final String RESOLUTION_UNKNOWN = "";
    private int bitrate;
    private String codec;
    private int fps;
    private int height;
    private int indexEnd;
    private int indexStart;
    private int initEnd;
    private int initStart;

    @Deprecated
    public final boolean isVideoOnly;
    private int itag;
    private ItagItem itagItem;
    private String quality;

    @Deprecated
    public final String resolution;
    private int width;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class Builder {
        private String content;
        private DeliveryMethod deliveryMethod = DeliveryMethod.PROGRESSIVE_HTTP;
        private String id;
        private boolean isUrl;
        private Boolean isVideoOnly;
        private ItagItem itagItem;
        private String manifestUrl;
        private MediaFormat mediaFormat;
        private String resolution;

        public VideoStream build() {
            String str = this.id;
            if (str == null) {
                a.h("The identifier of the video stream has been not set or is null. If you are not able to get an identifier, use the static constant ID_UNKNOWN of the Stream class.");
                return null;
            }
            String str2 = this.content;
            if (str2 == null) {
                a.h("The content of the video stream has been not set or is null. Please specify a non-null one with setContent.");
                return null;
            }
            DeliveryMethod deliveryMethod = this.deliveryMethod;
            if (deliveryMethod == null) {
                a.h("The delivery method of the video stream has been set as null, which is not allowed. Pass a valid one instead with setDeliveryMethod.");
                return null;
            }
            Boolean bool = this.isVideoOnly;
            if (bool == null) {
                a.h("The video stream has been not set as a video-only stream or as a video stream with embedded audio. Please specify this information with setIsVideoOnly.");
                return null;
            }
            String str3 = this.resolution;
            if (str3 != null) {
                return new VideoStream(str, str2, this.isUrl, this.mediaFormat, deliveryMethod, str3, bool.booleanValue(), this.manifestUrl, this.itagItem, 0);
            }
            a.h("The resolution of the video stream has been not set. Please specify it with setResolution (use an empty string if you are not able to get it).");
            return null;
        }

        public Builder setContent(String str, boolean z) {
            this.content = str;
            this.isUrl = z;
            return this;
        }

        public Builder setDeliveryMethod(DeliveryMethod deliveryMethod) {
            this.deliveryMethod = deliveryMethod;
            return this;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setIsVideoOnly(boolean z) {
            this.isVideoOnly = Boolean.valueOf(z);
            return this;
        }

        public Builder setItagItem(ItagItem itagItem) {
            this.itagItem = itagItem;
            return this;
        }

        public Builder setManifestUrl(String str) {
            this.manifestUrl = str;
            return this;
        }

        public Builder setMediaFormat(MediaFormat mediaFormat) {
            this.mediaFormat = mediaFormat;
            return this;
        }

        public Builder setResolution(String str) {
            this.resolution = str;
            return this;
        }
    }

    private VideoStream(String str, String str2, boolean z, MediaFormat mediaFormat, DeliveryMethod deliveryMethod, String str3, boolean z2, String str4, ItagItem itagItem) {
        super(str, str2, z, mediaFormat, deliveryMethod, str4);
        this.itag = -1;
        if (itagItem != null) {
            this.itagItem = itagItem;
            this.itag = itagItem.id;
            this.bitrate = itagItem.getBitrate();
            this.initStart = itagItem.getInitStart();
            this.initEnd = itagItem.getInitEnd();
            this.indexStart = itagItem.getIndexStart();
            this.indexEnd = itagItem.getIndexEnd();
            this.codec = itagItem.getCodec();
            this.height = itagItem.getHeight();
            this.width = itagItem.getWidth();
            this.quality = itagItem.getQuality();
            this.fps = itagItem.getFps();
        }
        this.resolution = str3;
        this.isVideoOnly = z2;
    }

    @Override // org.schabi.newpipe.extractor.stream.Stream
    public boolean equalStats(Stream stream) {
        if (!super.equalStats(stream) || !(stream instanceof VideoStream)) {
            return false;
        }
        VideoStream videoStream = (VideoStream) stream;
        return this.resolution.equals(videoStream.resolution) && this.isVideoOnly == videoStream.isVideoOnly;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getCodec() {
        return this.codec;
    }

    public int getFps() {
        return this.fps;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIndexEnd() {
        return this.indexEnd;
    }

    public int getIndexStart() {
        return this.indexStart;
    }

    public int getInitEnd() {
        return this.initEnd;
    }

    public int getInitStart() {
        return this.initStart;
    }

    public int getItag() {
        return this.itag;
    }

    @Override // org.schabi.newpipe.extractor.stream.Stream
    public ItagItem getItagItem() {
        return this.itagItem;
    }

    public String getQuality() {
        return this.quality;
    }

    public String getResolution() {
        return this.resolution;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isVideoOnly() {
        return this.isVideoOnly;
    }

    public /* synthetic */ VideoStream(String str, String str2, boolean z, MediaFormat mediaFormat, DeliveryMethod deliveryMethod, String str3, boolean z2, String str4, ItagItem itagItem, int i) {
        this(str, str2, z, mediaFormat, deliveryMethod, str3, z2, str4, itagItem);
    }
}
