package com.github.catvod.spider.jdollar.util.stream;

import java.security.AccessController;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class p8 {
    public static final boolean a = ((Boolean) AccessController.doPrivileged(new com.github.catvod.spider.jdollar.nio.file.spi.a(3))).booleanValue();

    public static void a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
