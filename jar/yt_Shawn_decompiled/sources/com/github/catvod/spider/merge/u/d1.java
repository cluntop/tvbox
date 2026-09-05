package com.github.catvod.spider.merge.u;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class d1 {
    public static final c1 a;
    public static final c1 b;

    static {
        Class cls = e.a;
        c1 c1Var = null;
        try {
            c1Var = (c1) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = c1Var;
        b = new c1();
    }
}
