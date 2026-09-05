package com.github.catvod.spider.merge.o;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class e {
    public static final Pattern a = Pattern.compile("(magnet|thunder|ed2k):.*");
    public static final List b = Arrays.asList("mp4", "mkv", "mov", "wav", "wma", "wmv", "flv", "avi", "iso", "mpg", "ts", "mp3", "aac", "flac", "m4a", "ape", "ogg", "rm", "rmvb", "asf", "dts", "dsf", "dff");
    public static final List c = Arrays.asList("srt", "ass", "ssa", "vtt");

    public static String a(String str) {
        return str.contains(".") ? str.substring(str.lastIndexOf(".") + 1).toLowerCase() : str.toLowerCase();
    }

    public static String b(double d) {
        if (d <= 0.0d) {
            return VideoStream.RESOLUTION_UNKNOWN;
        }
        int iLog10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, iLog10)) + Stream.ID_UNKNOWN + new String[]{"bytes", "KB", "MB", "GB", "TB"}[iLog10];
    }

    public static String c(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(".")) : str;
    }
}
