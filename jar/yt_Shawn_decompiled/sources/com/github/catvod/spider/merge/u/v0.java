package com.github.catvod.spider.merge.u;

import java.io.Serializable;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v0 {
    public static final v0 b = new v0("VOID", 0, Void.class, null);
    public static final v0 c = new v0("INT", 1, Integer.class, 0);
    public static final v0 d = new v0("LONG", 2, Long.class, 0L);
    public static final v0 e = new v0("FLOAT", 3, Float.class, Float.valueOf(0.0f));
    public static final v0 f = new v0("DOUBLE", 4, Double.class, Double.valueOf(0.0d));
    public static final v0 g = new v0("BOOLEAN", 5, Boolean.class, Boolean.FALSE);
    public static final v0 h = new v0("STRING", 6, String.class, VideoStream.RESOLUTION_UNKNOWN);
    public static final v0 i = new v0("BYTE_STRING", 7, l.class, l.b);
    public static final v0 j = new v0("ENUM", 8, Integer.class, null);
    public static final v0 k = new v0("MESSAGE", 9, Object.class, null);
    public final Object a;

    public v0(String str, int i2, Class cls, Serializable serializable) {
        this.a = serializable;
    }
}
