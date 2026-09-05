package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.Objects;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PoTokenResult {
    public final String playerRequestPoToken;
    public final String streamingDataPoToken;
    public final String visitorData;

    public PoTokenResult(String str, String str2, String str3) {
        Objects.requireNonNull(str);
        this.visitorData = str;
        Objects.requireNonNull(str2);
        this.playerRequestPoToken = str2;
        this.streamingDataPoToken = str3;
    }
}
