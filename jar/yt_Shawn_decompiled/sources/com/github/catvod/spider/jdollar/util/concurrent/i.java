package com.github.catvod.spider.jdollar.util.concurrent;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.StreamSupport;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i extends b implements Set, com.github.catvod.spider.jdollar.util.c {
    private static final long serialVersionUID = 7249069246763182397L;

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.util.concurrent.b, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set != this) {
            return containsAll(set) && set.containsAll(this);
        }
        return true;
    }

    @Override // java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final void forEach(Consumer consumer) {
        consumer.getClass();
        l[] lVarArr = this.a.a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            } else {
                consumer.accept(lVarA.b);
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        Object it = iterator();
        int iHashCode = 0;
        while (((a) it).hasNext()) {
            iHashCode += ((h) it).next().hashCode();
        }
        return iHashCode;
    }

    @Override // com.github.catvod.spider.jdollar.util.concurrent.b, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.a;
        l[] lVarArr = concurrentHashMap.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, concurrentHashMap, 0);
    }

    @Override // java.util.Collection
    public final /* synthetic */ Stream parallelStream() {
        return Stream.Wrapper.convert(StreamSupport.stream(Collection$EL.c(this), true));
    }

    @Override // com.github.catvod.spider.jdollar.util.concurrent.b, java.util.Collection
    public final boolean remove(Object obj) {
        return this.a.g(obj, null, null) != null;
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final boolean removeIf(Predicate predicate) {
        Objects.requireNonNull(predicate);
        Object it = iterator();
        boolean z = false;
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                return z;
            }
            if (predicate.test(((h) it).next())) {
                aVar.remove();
                z = true;
            }
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set, com.github.catvod.spider.jdollar.lang.Iterable
    public final Spliterator spliterator() {
        ConcurrentHashMap concurrentHashMap = this.a;
        long j = concurrentHashMap.j();
        l[] lVarArr = concurrentHashMap.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new j(lVarArr, length, 0, length, j < 0 ? 0L : j, 0);
    }

    @Override // java.util.Collection
    public final /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(StreamSupport.stream(Collection$EL.c(this), false));
    }

    @Override // java.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.stream.Stream parallelStream() {
        return StreamSupport.stream(Collection$EL.c(this), true);
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final /* synthetic */ com.github.catvod.spider.jdollar.util.stream.Stream stream() {
        return StreamSupport.stream(Collection$EL.c(this), false);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }
}
