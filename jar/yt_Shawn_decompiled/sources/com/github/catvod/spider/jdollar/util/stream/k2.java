package com.github.catvod.spider.jdollar.util.stream;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.Spliterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k2 implements g2 {
    public final Collection a;

    public k2(Collection collection) {
        this.a = collection;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final g2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final long count() {
        return this.a.size();
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final void forEach(Consumer consumer) {
        Collection$EL.a(this.a, consumer);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ g2 l(long j, long j2, IntFunction intFunction) {
        return v3.w(this, j, j2, intFunction);
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final void m(Object[] objArr, int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Object[] q(IntFunction intFunction) {
        Collection collection = this.a;
        return collection.toArray((Object[]) intFunction.apply(collection.size()));
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final /* synthetic */ int s() {
        return 0;
    }

    @Override // com.github.catvod.spider.jdollar.util.stream.g2
    public final Spliterator spliterator() {
        return Collection$EL.stream(this.a).spliterator();
    }

    public final String toString() {
        return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.a.size()), this.a);
    }
}
