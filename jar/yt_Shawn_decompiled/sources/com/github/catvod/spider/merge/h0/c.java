package com.github.catvod.spider.merge.h0;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c {
    public static final Pattern e = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);
    public static final Pattern f = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
    public static final Pattern g = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public c(String str) {
        this.a = str;
        String str2 = VideoStream.RESOLUTION_UNKNOWN;
        if (str != null) {
            Matcher matcher = e.matcher(str);
            this.b = matcher.find() ? matcher.group(1) : str2;
            Matcher matcher2 = f.matcher(str);
            this.c = matcher2.find() ? matcher2.group(2) : null;
        } else {
            this.b = VideoStream.RESOLUTION_UNKNOWN;
            this.c = "UTF-8";
        }
        if (!"multipart/form-data".equalsIgnoreCase(this.b)) {
            this.d = null;
        } else {
            Matcher matcher3 = g.matcher(str);
            this.d = matcher3.find() ? matcher3.group(2) : null;
        }
    }

    public final String a() {
        String str = this.c;
        return str == null ? "US-ASCII" : str;
    }
}
