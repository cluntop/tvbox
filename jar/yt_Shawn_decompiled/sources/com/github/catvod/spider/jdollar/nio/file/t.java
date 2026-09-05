package com.github.catvod.spider.jdollar.nio.file;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class t implements Iterator {
    public int a = 0;
    public final /* synthetic */ com.github.catvod.spider.jdollar.desugar.sun.nio.fs.n b;

    public t(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.n nVar) {
        this.b = nVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.c.size();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.a >= this.b.c.size()) {
            throw new NoSuchElementException();
        }
        com.github.catvod.spider.jdollar.desugar.sun.nio.fs.n name = this.b.getName(this.a);
        this.a++;
        return name;
    }
}
