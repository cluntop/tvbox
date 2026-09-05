package org.schabi.newpipe.extractor.timeago;

import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PatternsManager {
    public static PatternsHolder getPatterns(String str, String str2) {
        return PatternMap.getPattern(str + ((str2 == null || str2.isEmpty()) ? VideoStream.RESOLUTION_UNKNOWN : "_".concat(str2)));
    }
}
