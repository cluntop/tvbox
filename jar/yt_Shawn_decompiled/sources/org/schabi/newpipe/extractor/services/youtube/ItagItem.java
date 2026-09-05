package org.schabi.newpipe.extractor.services.youtube;

import java.io.Serializable;
import java.util.Locale;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.AudioTrackType;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ItagItem implements Serializable {
    public static final long APPROX_DURATION_MS_UNKNOWN = -1;
    public static final int AUDIO_CHANNELS_NOT_APPLICABLE_OR_UNKNOWN = -1;
    public static final int AVERAGE_BITRATE_UNKNOWN = -1;
    public static final long CONTENT_LENGTH_UNKNOWN = -1;
    public static final int FPS_NOT_APPLICABLE_OR_UNKNOWN = -1;
    private static final ItagItem[] ITAG_LIST;
    public static final long LAST_MODIFIED_UNKOWN = -1;
    public static final int SAMPLE_RATE_UNKNOWN = -1;
    public static final int TARGET_DURATION_SEC_UNKNOWN = -1;
    private long approxDurationMs;
    private int audioChannels;
    private Locale audioLocale;
    private String audioTrackId;
    private String audioTrackName;
    private AudioTrackType audioTrackType;

    @Deprecated
    public int avgBitrate;
    private int bitrate;
    private String codec;
    private long contentLength;

    @Deprecated
    public int fps;
    private int height;
    public final int id;
    private int indexEnd;
    private int indexStart;
    private int initEnd;
    private int initStart;
    private boolean isDrc;
    public final ItagType itagType;
    private long lastModified;
    private final MediaFormat mediaFormat;
    private String quality;

    @Deprecated
    public String resolutionString;
    private int sampleRate;
    private int targetDurationSec;
    private int width;
    private String xtags;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public enum ItagType {
        AUDIO,
        VIDEO,
        VIDEO_ONLY
    }

    static {
        ItagType itagType = ItagType.VIDEO;
        MediaFormat mediaFormat = MediaFormat.v3GPP;
        ItagItem itagItem = new ItagItem(17, itagType, mediaFormat, "144p");
        ItagItem itagItem2 = new ItagItem(36, itagType, mediaFormat, "240p");
        MediaFormat mediaFormat2 = MediaFormat.MPEG_4;
        ItagItem itagItem3 = new ItagItem(18, itagType, mediaFormat2, "360p");
        ItagItem itagItem4 = new ItagItem(34, itagType, mediaFormat2, "360p");
        ItagItem itagItem5 = new ItagItem(35, itagType, mediaFormat2, "480p");
        ItagItem itagItem6 = new ItagItem(59, itagType, mediaFormat2, "480p");
        ItagItem itagItem7 = new ItagItem(78, itagType, mediaFormat2, "480p");
        ItagItem itagItem8 = new ItagItem(22, itagType, mediaFormat2, "720p");
        ItagItem itagItem9 = new ItagItem(37, itagType, mediaFormat2, "1080p");
        ItagItem itagItem10 = new ItagItem(38, itagType, mediaFormat2, "1080p");
        MediaFormat mediaFormat3 = MediaFormat.WEBM;
        ItagItem itagItem11 = new ItagItem(43, itagType, mediaFormat3, "360p");
        ItagItem itagItem12 = new ItagItem(44, itagType, mediaFormat3, "480p");
        ItagItem itagItem13 = new ItagItem(45, itagType, mediaFormat3, "720p");
        ItagItem itagItem14 = new ItagItem(46, itagType, mediaFormat3, "1080p");
        ItagType itagType2 = ItagType.AUDIO;
        MediaFormat mediaFormat4 = MediaFormat.WEBMA;
        ItagItem itagItem15 = new ItagItem(171, itagType2, mediaFormat4, 128);
        ItagItem itagItem16 = new ItagItem(172, itagType2, mediaFormat4, 256);
        MediaFormat mediaFormat5 = MediaFormat.M4A;
        ItagItem itagItem17 = new ItagItem(599, itagType2, mediaFormat5, 32);
        ItagItem itagItem18 = new ItagItem(139, itagType2, mediaFormat5, 48);
        ItagItem itagItem19 = new ItagItem(140, itagType2, mediaFormat5, 128);
        ItagItem itagItem20 = new ItagItem(141, itagType2, mediaFormat5, 256);
        MediaFormat mediaFormat6 = MediaFormat.WEBMA_OPUS;
        ItagItem itagItem21 = new ItagItem(600, itagType2, mediaFormat6, 35);
        ItagItem itagItem22 = new ItagItem(249, itagType2, mediaFormat6, 50);
        ItagItem itagItem23 = new ItagItem(250, itagType2, mediaFormat6, 70);
        ItagItem itagItem24 = new ItagItem(251, itagType2, mediaFormat6, 160);
        ItagType itagType3 = ItagType.VIDEO_ONLY;
        ITAG_LIST = new ItagItem[]{itagItem, itagItem2, itagItem3, itagItem4, itagItem5, itagItem6, itagItem7, itagItem8, itagItem9, itagItem10, itagItem11, itagItem12, itagItem13, itagItem14, itagItem15, itagItem16, itagItem17, itagItem18, itagItem19, itagItem20, itagItem21, itagItem22, itagItem23, itagItem24, new ItagItem(160, itagType3, mediaFormat2, "144p"), new ItagItem(394, itagType3, mediaFormat2, "144p"), new ItagItem(133, itagType3, mediaFormat2, "240p"), new ItagItem(395, itagType3, mediaFormat2, "240p"), new ItagItem(134, itagType3, mediaFormat2, "360p"), new ItagItem(396, itagType3, mediaFormat2, "360p"), new ItagItem(135, itagType3, mediaFormat2, "480p"), new ItagItem(212, itagType3, mediaFormat2, "480p"), new ItagItem(397, itagType3, mediaFormat2, "480p"), new ItagItem(136, itagType3, mediaFormat2, "720p"), new ItagItem(398, itagType3, mediaFormat2, "720p"), new ItagItem(298, itagType3, mediaFormat2, "720p60", 60), new ItagItem(137, itagType3, mediaFormat2, "1080p"), new ItagItem(399, itagType3, mediaFormat2, "1080p"), new ItagItem(299, itagType3, mediaFormat2, "1080p60", 60), new ItagItem(400, itagType3, mediaFormat2, "1440p"), new ItagItem(266, itagType3, mediaFormat2, "2160p"), new ItagItem(401, itagType3, mediaFormat2, "2160p"), new ItagItem(278, itagType3, mediaFormat3, "144p"), new ItagItem(242, itagType3, mediaFormat3, "240p"), new ItagItem(243, itagType3, mediaFormat3, "360p"), new ItagItem(244, itagType3, mediaFormat3, "480p"), new ItagItem(245, itagType3, mediaFormat3, "480p"), new ItagItem(246, itagType3, mediaFormat3, "480p"), new ItagItem(247, itagType3, mediaFormat3, "720p"), new ItagItem(248, itagType3, mediaFormat3, "1080p"), new ItagItem(271, itagType3, mediaFormat3, "1440p"), new ItagItem(272, itagType3, mediaFormat3, "2160p"), new ItagItem(302, itagType3, mediaFormat3, "720p60", 60), new ItagItem(303, itagType3, mediaFormat3, "1080p60", 60), new ItagItem(308, itagType3, mediaFormat3, "1440p60", 60), new ItagItem(313, itagType3, mediaFormat3, "2160p"), new ItagItem(315, itagType3, mediaFormat3, "2160p60", 60)};
    }

    public ItagItem(ItagItem itagItem) {
        this.avgBitrate = -1;
        this.sampleRate = -1;
        this.audioChannels = -1;
        this.fps = -1;
        this.targetDurationSec = -1;
        this.approxDurationMs = -1L;
        this.contentLength = -1L;
        this.mediaFormat = itagItem.mediaFormat;
        this.id = itagItem.id;
        this.itagType = itagItem.itagType;
        this.avgBitrate = itagItem.avgBitrate;
        this.sampleRate = itagItem.sampleRate;
        this.audioChannels = itagItem.audioChannels;
        this.resolutionString = itagItem.resolutionString;
        this.fps = itagItem.fps;
        this.bitrate = itagItem.bitrate;
        this.width = itagItem.width;
        this.height = itagItem.height;
        this.initStart = itagItem.initStart;
        this.initEnd = itagItem.initEnd;
        this.indexStart = itagItem.indexStart;
        this.indexEnd = itagItem.indexEnd;
        this.quality = itagItem.quality;
        this.codec = itagItem.codec;
        this.targetDurationSec = itagItem.targetDurationSec;
        this.approxDurationMs = itagItem.approxDurationMs;
        this.contentLength = itagItem.contentLength;
        this.audioTrackId = itagItem.audioTrackId;
        this.audioTrackName = itagItem.audioTrackName;
        this.audioTrackType = itagItem.audioTrackType;
        this.audioLocale = itagItem.audioLocale;
    }

    public static ItagItem getItag(int i) throws ParsingException {
        for (ItagItem itagItem : ITAG_LIST) {
            if (i == itagItem.id) {
                return new ItagItem(itagItem);
            }
        }
        throw new ParsingException(com.github.catvod.spider.merge.b.b.k(i, "itag ", " is not supported"));
    }

    public static boolean isSupported(int i) {
        for (ItagItem itagItem : ITAG_LIST) {
            if (i == itagItem.id) {
                return true;
            }
        }
        return false;
    }

    public long getApproxDurationMs() {
        return this.approxDurationMs;
    }

    public int getAudioChannels() {
        return this.audioChannels;
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
        return this.avgBitrate;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getCodec() {
        return this.codec;
    }

    public long getContentLength() {
        return this.contentLength;
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

    public long getLastModified() {
        return this.lastModified;
    }

    public MediaFormat getMediaFormat() {
        return this.mediaFormat;
    }

    public String getQuality() {
        return this.quality;
    }

    public String getResolutionString() {
        return this.resolutionString;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getTargetDurationSec() {
        return this.targetDurationSec;
    }

    public int getWidth() {
        return this.width;
    }

    public String getXtags() {
        return this.xtags;
    }

    public Boolean isDrc() {
        return Boolean.valueOf(this.isDrc);
    }

    public void setApproxDurationMs(long j) {
        if (j <= 0) {
            j = -1;
        }
        this.approxDurationMs = j;
    }

    public void setAudioChannels(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.audioChannels = i;
    }

    public void setAudioLocale(Locale locale) {
        this.audioLocale = locale;
    }

    public void setAudioTrackId(String str) {
        this.audioTrackId = str;
    }

    public void setAudioTrackName(String str) {
        this.audioTrackName = str;
    }

    public void setAudioTrackType(AudioTrackType audioTrackType) {
        this.audioTrackType = audioTrackType;
    }

    public void setBitrate(int i) {
        this.bitrate = i;
    }

    public void setCodec(String str) {
        this.codec = str;
    }

    public void setContentLength(long j) {
        if (j <= 0) {
            j = -1;
        }
        this.contentLength = j;
    }

    public void setFps(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.fps = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setIndexEnd(int i) {
        this.indexEnd = i;
    }

    public void setIndexStart(int i) {
        this.indexStart = i;
    }

    public void setInitEnd(int i) {
        this.initEnd = i;
    }

    public void setInitStart(int i) {
        this.initStart = i;
    }

    public void setIsDrc(Boolean bool) {
        this.isDrc = bool.booleanValue();
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    public void setSampleRate(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.sampleRate = i;
    }

    public void setTargetDurationSec(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.targetDurationSec = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setXtags(String str) {
        this.xtags = str;
    }

    public ItagItem(int i, ItagType itagType, MediaFormat mediaFormat, String str, int i2) {
        this.avgBitrate = -1;
        this.sampleRate = -1;
        this.audioChannels = -1;
        this.targetDurationSec = -1;
        this.approxDurationMs = -1L;
        this.contentLength = -1L;
        this.id = i;
        this.itagType = itagType;
        this.mediaFormat = mediaFormat;
        this.resolutionString = str;
        this.fps = i2;
    }

    public ItagItem(int i, ItagType itagType, MediaFormat mediaFormat, int i2) {
        this.sampleRate = -1;
        this.audioChannels = -1;
        this.fps = -1;
        this.targetDurationSec = -1;
        this.approxDurationMs = -1L;
        this.contentLength = -1L;
        this.id = i;
        this.itagType = itagType;
        this.mediaFormat = mediaFormat;
        this.avgBitrate = i2;
    }

    public ItagItem(int i, ItagType itagType, MediaFormat mediaFormat, String str) {
        this.avgBitrate = -1;
        this.sampleRate = -1;
        this.audioChannels = -1;
        this.targetDurationSec = -1;
        this.approxDurationMs = -1L;
        this.contentLength = -1L;
        this.id = i;
        this.itagType = itagType;
        this.mediaFormat = mediaFormat;
        this.resolutionString = str;
        this.fps = 30;
    }
}
