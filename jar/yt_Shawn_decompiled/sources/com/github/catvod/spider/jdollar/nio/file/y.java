package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.lang.Iterable;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.Spliterators;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class y implements Iterable, Iterable {
    public final Iterable a;

    public y(Iterable iterable) {
        this.a = iterable;
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final void forEach(Consumer consumer) {
        Iterable.EL.forEach(this.a, new w(consumer, 1));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new z(this.a.iterator());
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(Spliterators.spliteratorUnknownSize(iterator(), 0));
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.Spliterator spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
