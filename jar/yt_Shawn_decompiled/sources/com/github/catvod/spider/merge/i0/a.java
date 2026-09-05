package com.github.catvod.spider.merge.i0;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class a extends Error {
    public final Exception a;

    public a(String str, Exception exc) {
        super(str);
        this.a = exc;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        Exception exc;
        String message = super.getMessage();
        if (message != null || (exc = this.a) == null) {
            return message;
        }
        String message2 = exc.getMessage();
        return message2 == null ? exc.getClass().toString() : message2;
    }
}
