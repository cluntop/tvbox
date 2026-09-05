package org.schabi.newpipe.extractor.exceptions;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class ReCaptchaException extends ExtractionException {
    private final String url;

    public ReCaptchaException(String str, String str2) {
        super(str);
        this.url = str2;
    }

    public String getUrl() {
        return this.url;
    }
}
