package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Optional;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h0 extends i0 {
    public static final d0 c;
    public static final d0 d;

    static {
        c7 c7Var = c7.REFERENCE;
        c = new d0(true, c7Var, Optional.empty(), new j(23), new j(24));
        d = new d0(false, c7Var, Optional.empty(), new j(23), new j(24));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.a) {
            return Optional.of(this.b);
        }
        return null;
    }
}
