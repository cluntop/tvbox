package org.schabi.newpipe.extractor.exceptions;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class YoutubeMusicPremiumContentException extends ContentNotAvailableException {
    public YoutubeMusicPremiumContentException() {
        super("This video is a YouTube Music Premium video");
    }

    public YoutubeMusicPremiumContentException(Throwable th) {
        super("This video is a YouTube Music Premium video", th);
    }
}
