package com.github.catvod.spider.jdollar.util;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class n implements Iterator, z {
    public final /* synthetic */ int a = 0;
    public final Iterator b;

    public n(o oVar) {
        this.b = oVar.a.iterator();
    }

    @Override // java.util.Iterator, com.github.catvod.spider.jdollar.util.z
    public final void forEachRemaining(Consumer consumer) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                com.github.catvod.spider.jdollar.time.chrono.m.A(this.b, consumer);
                break;
            default:
                com.github.catvod.spider.jdollar.time.chrono.m.A(this.b, new com.github.catvod.spider.jdollar.nio.file.w(consumer, 2));
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
        }
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                return this.b.next();
            default:
                return new r((Map.Entry) this.b.next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public n(t tVar) {
        this.b = tVar.a.iterator();
    }
}
