package com.github.catvod.spider.jdollar.util;

import java.util.RandomAccess;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l extends j implements RandomAccess {
    private static final long serialVersionUID = 1530674583602358482L;

    private Object writeReplace() {
        return new j(this.c);
    }

    @Override // com.github.catvod.spider.jdollar.util.j, java.util.List
    public final java.util.List subList(int i, int i2) {
        l lVar;
        synchronized (this.b) {
            lVar = new l(this.c.subList(i, i2), this.b);
        }
        return lVar;
    }
}
