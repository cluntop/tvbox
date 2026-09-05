package com.github.catvod.spider.merge.z0;

import java.util.logging.Logger;
import kotlin.text.StringsKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class q {
    public static final Logger a = Logger.getLogger("okio.Okio");

    public static final boolean a(AssertionError assertionError) {
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? StringsKt.o(message, "getsockname failed") : false) {
                return true;
            }
        }
        return false;
    }
}
