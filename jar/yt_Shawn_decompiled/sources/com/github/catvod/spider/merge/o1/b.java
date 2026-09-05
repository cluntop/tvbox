package com.github.catvod.spider.merge.o1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class b implements Iterator {
    public final /* synthetic */ int a;
    public int b;
    public int c;
    public final /* synthetic */ Iterable d;

    public b(com.github.catvod.spider.merge.u.j jVar) {
        this.a = 1;
        this.d = jVar;
        this.b = 0;
        this.c = jVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                c cVar = (c) this.d;
                if (cVar.a != this.b) {
                    throw new ConcurrentModificationException("Use Iterator#remove() instead to remove attributes while iterating.");
                }
                while (true) {
                    int i = this.c;
                    if (i < cVar.a && c.l(cVar.b[i])) {
                        this.c++;
                    }
                }
                return this.c < cVar.a;
            default:
                return this.b < this.c;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        Iterable iterable = this.d;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                c cVar = (c) iterable;
                int i2 = cVar.a;
                if (i2 != this.b) {
                    throw new ConcurrentModificationException("Use Iterator#remove() instead to remove attributes while iterating.");
                }
                int i3 = this.c;
                if (i3 >= i2) {
                    com.github.catvod.spider.merge.s0.a.a();
                    return null;
                }
                a aVar = new a(cVar.b[i3], (String) cVar.c[this.c], cVar);
                this.c++;
                return aVar;
            default:
                int i4 = this.b;
                if (i4 < this.c) {
                    this.b = i4 + 1;
                    return Byte.valueOf(((com.github.catvod.spider.merge.u.j) iterable).h(i4));
                }
                com.github.catvod.spider.merge.s0.a.a();
                return null;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                c cVar = (c) this.d;
                int i = this.c - 1;
                this.c = i;
                cVar.n(i);
                this.b--;
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public b(c cVar) {
        this.a = 0;
        this.d = cVar;
        this.b = cVar.a;
        this.c = 0;
    }
}
