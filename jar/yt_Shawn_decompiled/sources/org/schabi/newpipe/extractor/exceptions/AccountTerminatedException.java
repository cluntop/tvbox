package org.schabi.newpipe.extractor.exceptions;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class AccountTerminatedException extends ContentNotAvailableException {
    private Reason reason;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public enum Reason {
        UNKNOWN,
        VIOLATION
    }

    public AccountTerminatedException(String str) {
        super(str);
        this.reason = Reason.UNKNOWN;
    }

    public Reason getReason() {
        return this.reason;
    }

    public AccountTerminatedException(String str, Reason reason) {
        super(str);
        Reason reason2 = Reason.UNKNOWN;
        this.reason = reason;
    }

    public AccountTerminatedException(String str, Throwable th) {
        super(str, th);
        this.reason = Reason.UNKNOWN;
    }
}
