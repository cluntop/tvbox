package org.schabi.newpipe.extractor.stream;

import java.util.List;
import org.schabi.newpipe.extractor.Image;
import org.schabi.newpipe.extractor.InfoItemExtractor;
import org.schabi.newpipe.extractor.localization.DateWrapper;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface StreamInfoItemExtractor extends InfoItemExtractor {
    ContentAvailability getContentAvailability();

    long getDuration();

    String getShortDescription();

    StreamType getStreamType();

    String getTextualUploadDate();

    DateWrapper getUploadDate();

    List<Image> getUploaderAvatars();

    String getUploaderName();

    String getUploaderUrl();

    long getViewCount();

    boolean isAd();

    boolean isShortFormContent();

    boolean isUploaderVerified();
}
