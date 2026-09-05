package org.schabi.newpipe.extractor.utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface Logger {
    void debug(String str, String str2);

    void debug(String str, String str2, Throwable th);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th);

    void warn(String str, String str2);

    void warn(String str, String str2, Throwable th);
}
