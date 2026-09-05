package org.schabi.newpipe.extractor.services.soundcloud.extractors;

import com.grack.nanojson.JsonObject;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundcloudLikesInfoItemExtractor extends SoundcloudStreamInfoItemExtractor {
    public SoundcloudLikesInfoItemExtractor(JsonObject jsonObject) {
        super(jsonObject.getObject("track"));
    }
}
