package com.github.catvod.spider.jdollar.util;

import java.util.RandomAccess;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class v extends q implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    private Object writeReplace() {
        return new q(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.util.q, java.util.List
    public final java.util.List subList(int i, int i2) {
        return new v(this.b.subList(i, i2));
    }
}
