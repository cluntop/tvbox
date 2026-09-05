package com.github.catvod.spider.merge.m1;

import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c extends f {
    public static final Pattern d = Pattern.compile(VideoStream.RESOLUTION_UNKNOWN);
    public final com.google.re2j.Pattern c;

    public c(com.google.re2j.Pattern pattern) {
        super(d);
        this.c = pattern;
    }

    public static c c(String str) {
        try {
            return new c(com.google.re2j.Pattern.compile(str));
        } catch (OutOfMemoryError | StackOverflowError e) {
            throw new g("Pattern complexity error: " + e.getMessage());
        } catch (RuntimeException e2) {
            throw new g("Pattern syntax error: " + e2.getMessage());
        }
    }

    @Override // com.github.catvod.spider.merge.m1.f
    public final e b(String str) {
        return new b(this.c.matcher(str));
    }

    @Override // com.github.catvod.spider.merge.m1.f
    public final String toString() {
        return this.c.toString();
    }
}
