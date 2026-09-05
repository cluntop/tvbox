package com.github.catvod.spider.jdollar.util.concurrent;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.Spliterator;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.StreamSupport;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class s extends b implements com.github.catvod.spider.jdollar.util.c {
    private static final long serialVersionUID = 2249069246763182397L;

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.util.concurrent.b, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.containsValue(obj);
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
                consumer.accept(lVarA.c);
            }
        }
    }

    @Override // com.github.catvod.spider.jdollar.util.concurrent.b, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.a;
        l[] lVarArr = concurrentHashMap.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, concurrentHashMap, 1);
    }

    @Override // java.util.Collection
    public final /* synthetic */ Stream parallelStream() {
        return Stream.Wrapper.convert(StreamSupport.stream(Collection$EL.c(this), true));
    }

    @Override // com.github.catvod.spider.jdollar.util.concurrent.b, java.util.Collection
    public final boolean remove(Object obj) {
        a aVar;
        if (obj == null) {
            return false;
        }
        Object it = iterator();
        do {
            aVar = (a) it;
            if (!aVar.hasNext()) {
                return false;
            }
        } while (!obj.equals(((h) it).next()));
        aVar.remove();
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.util.concurrent.b, java.util.Collection
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        Object it = iterator();
        boolean z = false;
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                return z;
            }
            if (collection.contains(((h) it).next())) {
                aVar.remove();
                z = true;
            }
        }
    }

    @Override // java.util.Collection, com.github.catvod.spider.jdollar.util.c
    public final boolean removeIf(Predicate predicate) {
        ConcurrentHashMap concurrentHashMap = this.a;
        predicate.getClass();
        l[] lVarArr = concurrentHashMap.a;
        boolean z = false;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                Object obj = lVarA.b;
                Object obj2 = lVarA.c;
                if (predicate.test(obj2) && concurrentHashMap.g(obj, null, obj2) != null) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.lang.Iterable, com.github.catvod.spider.jdollar.lang.Iterable
    public final Spliterator spliterator() {
        ConcurrentHashMap concurrentHashMap = this.a;
        long j = concurrentHashMap.j();
        l[] lVarArr = concurrentHashMap.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new j(lVarArr, length, 0, length, j < 0 ? 0L : j, 1);
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

    @Override // java.util.Collection, java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }
}
