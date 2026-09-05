package com.github.catvod.spider.merge.u;

import java.io.Serializable;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k2 {
    public static final k2 b = new k2("INT", 0, 0);
    public static final k2 c = new k2("LONG", 1, 0L);
    public static final k2 d = new k2("FLOAT", 2, Float.valueOf(0.0f));
    public static final k2 e = new k2("DOUBLE", 3, Double.valueOf(0.0d));
    public static final k2 f = new k2("BOOLEAN", 4, Boolean.FALSE);
    public static final k2 g = new k2("STRING", 5, VideoStream.RESOLUTION_UNKNOWN);
    public static final k2 h = new k2("BYTE_STRING", 6, l.b);
    public static final k2 i = new k2("ENUM", 7, null);
    public static final k2 j = new k2("MESSAGE", 8, null);
    public final Object a;

    public k2(String str, int i2, Serializable serializable) {
        this.a = serializable;
    }
}
