package org.schabi.newpipe.extractor.services.peertube.extractors;

import com.grack.nanojson.JsonObject;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class PeertubeSepiaStreamInfoItemExtractor extends PeertubeStreamInfoItemExtractor {
    public PeertubeSepiaStreamInfoItemExtractor(JsonObject jsonObject, String str) {
        super(jsonObject, str);
        setBaseUrl(this.item.getString("embedUrl").replace(this.item.getString("embedPath"), VideoStream.RESOLUTION_UNKNOWN));
    }
}
