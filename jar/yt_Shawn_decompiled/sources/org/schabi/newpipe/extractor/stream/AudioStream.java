package org.schabi.newpipe.extractor.stream;

import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.s0.a;
import java.util.Locale;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.services.youtube.ItagItem;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class AudioStream extends Stream {
    public static final int UNKNOWN_BITRATE = -1;
    private final Locale audioLocale;
    private final String audioTrackId;
    private final String audioTrackName;
    private final AudioTrackType audioTrackType;
    private final int averageBitrate;
    private int bitrate;
    private String codec;
    private int indexEnd;
    private int indexStart;
    private int initEnd;
    private int initStart;
    private int itag;
    private ItagItem itagItem;
    private String quality;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class Builder {
        private Locale audioLocale;
        private String audioTrackId;
        private String audioTrackName;
        private AudioTrackType audioTrackType;
        private String content;
        private String id;
        private boolean isUrl;
        private ItagItem itagItem;
        private String manifestUrl;
        private MediaFormat mediaFormat;
        private DeliveryMethod deliveryMethod = DeliveryMethod.PROGRESSIVE_HTTP;
        private int averageBitrate = -1;

        public AudioStream build() {
            validateBuild();
            return new AudioStream(this);
        }

        public Builder setAudioLocale(Locale locale) {
            this.audioLocale = locale;
            return this;
        }

        public Builder setAudioTrackId(String str) {
            this.audioTrackId = str;
            return this;
        }

        public Builder setAudioTrackName(String str) {
            this.audioTrackName = str;
            return this;
        }

        public Builder setAudioTrackType(AudioTrackType audioTrackType) {
            this.audioTrackType = audioTrackType;
            return this;
        }

        public Builder setAverageBitrate(int i) {
            this.averageBitrate = i;
            return this;
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

        public void validateBuild() {
            if (this.id == null) {
                a.h("The identifier of the audio stream has been not set or is null. If you are not able to get an identifier, use the static constant ID_UNKNOWN of the Stream class.");
            } else if (this.content == null) {
                a.h("The content of the audio stream has been not set or is null. Please specify a non-null one with setContent.");
            } else {
                if (this.deliveryMethod != null) {
                    return;
                }
                a.h("The delivery method of the audio stream has been set as null, which is not allowed. Pass a valid one instead with setDeliveryMethod.");
            }
        }
    }

    public AudioStream(Builder builder) {
        super(builder.id, builder.content, builder.isUrl, builder.mediaFormat, builder.deliveryMethod, builder.manifestUrl);
        this.itag = -1;
        if (builder.itagItem != null) {
            this.itagItem = builder.itagItem;
            this.itag = builder.itagItem.id;
            this.quality = builder.itagItem.getQuality();
            this.bitrate = builder.itagItem.getBitrate();
            this.initStart = builder.itagItem.getInitStart();
            this.initEnd = builder.itagItem.getInitEnd();
            this.indexStart = builder.itagItem.getIndexStart();
            this.indexEnd = builder.itagItem.getIndexEnd();
            this.codec = builder.itagItem.getCodec();
        }
        this.averageBitrate = builder.averageBitrate;
        this.audioTrackId = builder.audioTrackId;
        this.audioTrackName = builder.audioTrackName;
        this.audioLocale = builder.audioLocale;
        this.audioTrackType = builder.audioTrackType;
    }

    @Override // org.schabi.newpipe.extractor.stream.Stream
    public boolean equalStats(Stream stream) {
        if (!super.equalStats(stream) || !(stream instanceof AudioStream)) {
            return false;
        }
        AudioStream audioStream = (AudioStream) stream;
        return this.averageBitrate == audioStream.averageBitrate && Objects.equals(this.audioTrackId, audioStream.audioTrackId) && this.audioTrackType == audioStream.audioTrackType && Objects.equals(this.audioLocale, audioStream.audioLocale);
    }

    public Locale getAudioLocale() {
        return this.audioLocale;
    }

    public String getAudioTrackId() {
        return this.audioTrackId;
    }

    public String getAudioTrackName() {
        return this.audioTrackName;
    }

    public AudioTrackType getAudioTrackType() {
        return this.audioTrackType;
    }

    public int getAverageBitrate() {
        return this.averageBitrate;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getCodec() {
        return this.codec;
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
}
