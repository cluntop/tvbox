package com.github.catvod.spider.merge.u;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class u0 extends IOException {
    public boolean a;

    public static u0 a() {
        return new u0("Protocol message contained an invalid tag (zero).");
    }

    public static u0 b() {
        return new u0("Protocol message had invalid UTF-8.");
    }

    public static t0 c() {
        return new t0("Protocol message tag had invalid wire type.");
    }

    public static u0 d() {
        return new u0("CodedInputStream encountered a malformed varint.");
    }

    public static u0 e() {
        return new u0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static u0 f() {
        return new u0("Failed to parse the message.");
    }

    public static u0 g() {
        return new u0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
