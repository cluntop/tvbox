package com.github.catvod.spider.jdollar.nio.file;

import java.util.Iterator;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class z implements Iterator {
    public final Iterator a;

    public z(Iterator it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.o(this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
