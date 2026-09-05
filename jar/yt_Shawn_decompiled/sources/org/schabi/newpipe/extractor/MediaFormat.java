package org.schabi.newpipe.extractor;

import com.github.catvod.spider.jdollar.util.DesugarArrays;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.n1.g;
import java.util.List;
import java.util.function.Function;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum MediaFormat {
    MPEG_4(0, "MPEG-4", "mp4", "video/mp4"),
    v3GPP(16, "3GPP", "3gp", "video/3gpp"),
    WEBM(32, "WebM", "webm", "video/webm"),
    M4A(256, "m4a", "m4a", "audio/mp4"),
    WEBMA(512, "WebM", "webm", "audio/webm"),
    MP3(768, "MP3", "mp3", "audio/mpeg"),
    MP2(784, "MP2", "mp2", "audio/mpeg"),
    OPUS(1024, "opus", "opus", "audio/opus"),
    OGG(1280, "ogg", "ogg", "audio/ogg"),
    WEBMA_OPUS(512, "WebM Opus", "webm", "audio/webm"),
    AIFF(1536, "AIFF", "aiff", "audio/aiff"),
    AIF(1536, "AIFF", "aif", "audio/aiff"),
    WAV(1792, "WAV", "wav", "audio/wav"),
    FLAC(2048, "FLAC", "flac", "audio/flac"),
    ALAC(2304, "ALAC", "alac", "audio/alac"),
    VTT(4096, "WebVTT", "vtt", "text/vtt"),
    TTML(8192, "Timed Text Markup Language", "ttml", "application/ttml+xml"),
    TRANSCRIPT1(12288, "TranScript v1", "srv1", "text/xml"),
    TRANSCRIPT2(16384, "TranScript v2", "srv2", "text/xml"),
    TRANSCRIPT3(20480, "TranScript v3", "srv3", "text/xml"),
    SRT(24576, "SubRip file format", "srt", "text/srt");

    public final int id;
    public final String mimeType;
    public final String name;
    public final String suffix;

    MediaFormat(int i, String str, String str2, String str3) {
        this.id = i;
        this.name = str;
        this.suffix = str2;
        this.mimeType = str3;
    }

    public static List<MediaFormat> getAllFromMimeType(String str) {
        return (List) DesugarArrays.stream(values()).filter(new a(str, 1)).collect(Collectors.toList());
    }

    private static <T> T getById(int i, Function<MediaFormat, T> function, T t) {
        return (T) DesugarArrays.stream(values()).filter(new b(i, 0)).map(function).findFirst().orElse(t);
    }

    public static MediaFormat getFormatById(int i) {
        return (MediaFormat) getById(i, new g(9), null);
    }

    public static MediaFormat getFromMimeType(String str) {
        return (MediaFormat) DesugarArrays.stream(values()).filter(new a(str, 0)).findFirst().orElse(null);
    }

    public static MediaFormat getFromSuffix(String str) {
        return (MediaFormat) DesugarArrays.stream(values()).filter(new a(str, 2)).findFirst().orElse(null);
    }

    public static String getMimeById(int i) {
        return (String) getById(i, new g(10), null);
    }

    public static String getNameById(int i) {
        return (String) getById(i, new g(11), VideoStream.RESOLUTION_UNKNOWN);
    }

    public static String getSuffixById(int i) {
        return (String) getById(i, new g(8), VideoStream.RESOLUTION_UNKNOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAllFromMimeType$2(String str, MediaFormat mediaFormat) {
        return mediaFormat.mimeType.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getById$0(int i, MediaFormat mediaFormat) {
        return mediaFormat.id == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MediaFormat lambda$getFormatById$3(MediaFormat mediaFormat) {
        return mediaFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getFromMimeType$1(String str, MediaFormat mediaFormat) {
        return mediaFormat.mimeType.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getFromSuffix$4(String str, MediaFormat mediaFormat) {
        return mediaFormat.suffix.equals(str);
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
