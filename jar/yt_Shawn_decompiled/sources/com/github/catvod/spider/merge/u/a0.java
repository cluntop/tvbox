package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class a0 {
    public static final z a = new z();
    public static final z b;

    static {
        Class cls = e.a;
        z zVar = null;
        try {
            zVar = (z) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = zVar;
    }
}
