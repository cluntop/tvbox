package org.schabi.newpipe.extractor.exceptions;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class SoundCloudGoPlusContentException extends ContentNotAvailableException {
    public SoundCloudGoPlusContentException() {
        super("This track is a SoundCloud Go+ track");
    }

    public SoundCloudGoPlusContentException(Throwable th) {
        super("This track is a SoundCloud Go+ track", th);
    }
}
