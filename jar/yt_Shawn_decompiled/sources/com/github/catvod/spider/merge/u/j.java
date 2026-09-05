package com.github.catvod.spider.merge.u;

import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class j extends l {
    public j() {
        this.a = 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new com.github.catvod.spider.merge.o1.b(this);
    }
}
